/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.DataBase;
import interfaces.CitaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cita;

/**
 *
 * @author Yair
 */
public class CitaDAOImplm extends DataBase implements CitaDAO {

    @Override
    public void agregar(Cita cita) throws Exception {

        String sql = "INSERT INTO cita (fecha, hora, estado, pacienteId) values (?, ?, ?, ?)";

        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setDate(1, cita.getFecha());
            st.setString(2, cita.getHora());
            st.setString(3, cita.getEstado());
            st.setInt(4, cita.getPacienteId());

            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void actualizar(Cita cita) throws Exception {

        String sql = "UPDATE cita SET fecha = ?, hora = ?, estado = ? WHERE id = ?";

        try {
            this.conectar();

            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setDate(1, cita.getFecha());
            st.setString(2, cita.getHora());
            st.setString(3, cita.getEstado());
            st.setInt(4, cita.getCitaId());

            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public Cita traerCita(String idCita) throws Exception {

        String sql = "SELECT * FROM cita WHERE id = ?";
        Cita cita = new Cita();
        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, idCita);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                cita.setCitaId(rs.getInt("id"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setHora(rs.getString("hora"));
                cita.setEstado(rs.getString("estado"));
                cita.setPacienteId(rs.getInt("pacienteId"));
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexion();
        }

        return cita;

    }

    @Override
    public List<Cita> listar() throws Exception {

        String sql = "SELECT * FROM cita";
        List<Cita> lista = null;
        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCitaId(rs.getInt("id"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setHora(rs.getString("hora"));
                cita.setEstado(rs.getString("estado"));
                cita.setPacienteId(rs.getInt("pacienteId"));
                lista.add(cita);
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexion();
        }

        return lista;

    }

}
