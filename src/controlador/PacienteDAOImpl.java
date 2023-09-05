/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.DataBase;
import interfaces.PacienteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;

/**
 *
 * @author Yair
 */
public class PacienteDAOImpl extends DataBase implements PacienteDAO {

    @Override
    public void agregar(Paciente paciente) throws Exception {

        String sql = "INSERT INTO paciente (nombre, apellidos, genero) values (?, ?, ?)";

        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, paciente.getNombre());
            st.setString(2, paciente.getApellido());
            st.setString(3, paciente.getGenero());

            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public List<Paciente> listar() throws Exception {

        String sql = "SELECT * FROM paciente ORDER BY ID DESC;";
        List<Paciente> lista = null;
        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setPacientId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellidos"));
                paciente.setGenero(rs.getString("genero"));
                lista.add(paciente);
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
