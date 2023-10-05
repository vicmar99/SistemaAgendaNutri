/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.DataBase;
import interfaces.VistaCitasDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelo.VistaCitas;

/**
 *
 * @author Yair
 */
public class VistaCitasDAOImpl extends DataBase implements VistaCitasDAO {

    @Override

    public List<VistaCitas> listar() throws Exception {

        String sql = "SELECT * FROM VistaCitas ORDER BY IdCita DESC;";

        List<VistaCitas> lista = null;

        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                VistaCitas vc = new VistaCitas();
                vc.setIdCitaVista(rs.getInt("IdCita"));
                vc.setIdPacienteVista(rs.getInt("IdPaciente"));
                vc.setNombrePacienteVista(rs.getString("NombrePaciente"));
                vc.setApellidosPacienteVista(rs.getString("ApellidosPaciente"));
                vc.setFechaCitaVista(rs.getDate("Fecha"));
                vc.setHoraCitaVista(rs.getString("Hora"));
                vc.setEstadoCitaVista(rs.getString("Estado"));

                lista.add(vc);
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

    @Override
    public List<VistaCitas> filtrarHoy() throws Exception {

        // Obtener la fecha actual
        Calendar calendario = Calendar.getInstance();
        Date fechaActual = new Date(calendario.getTime().getTime());

        // Consulta para obtener citas del día de hoy
        String sql = "SELECT * FROM VistaCitas WHERE Fecha = ? ORDER BY Hora;";

        List<VistaCitas> lista = null;

        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setDate(1, fechaActual);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                VistaCitas vc = new VistaCitas();
                vc.setIdCitaVista(rs.getInt("IdCita"));
                vc.setIdPacienteVista(rs.getInt("IdPaciente"));
                vc.setNombrePacienteVista(rs.getString("NombrePaciente"));
                vc.setApellidosPacienteVista(rs.getString("ApellidosPaciente"));
                vc.setFechaCitaVista(rs.getDate("Fecha"));
                vc.setHoraCitaVista(rs.getString("Hora"));
                vc.setEstadoCitaVista(rs.getString("Estado"));

                lista.add(vc);
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

    @Override
    public List<VistaCitas> filtrarManiana() throws Exception {

        // Obtener la fecha de mañana
        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DAY_OF_MONTH, 1); // Sumar un día para obtener la fecha de mañana
        Date fechaManiana = new Date(calendario.getTime().getTime());

        // Consulta para obtener citas para mañana
        String sql = "SELECT * FROM VistaCitas WHERE Fecha = ? ORDER BY Hora;";

        List<VistaCitas> lista = null;

        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setDate(1, fechaManiana);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                VistaCitas vc = new VistaCitas();
                vc.setIdCitaVista(rs.getInt("IdCita"));
                vc.setIdPacienteVista(rs.getInt("IdPaciente"));
                vc.setNombrePacienteVista(rs.getString("NombrePaciente"));
                vc.setApellidosPacienteVista(rs.getString("ApellidosPaciente"));
                vc.setFechaCitaVista(rs.getDate("Fecha"));
                vc.setHoraCitaVista(rs.getString("Hora"));
                vc.setEstadoCitaVista(rs.getString("Estado"));

                lista.add(vc);
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

    @Override
    public List<VistaCitas> filtrarSiguientes() throws Exception {
        // Obtener la fecha de mañana
        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DAY_OF_MONTH, 1); // Sumar un día para obtener la fecha de mañana
        Date fechaManiana = new Date(calendario.getTime().getTime());

        // Consulta para obtener citas para después de mañana
        String sql = "SELECT * FROM VistaCitas WHERE Fecha > ? ORDER BY Hora;";

        List<VistaCitas> lista = null;

        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setDate(1, fechaManiana);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                VistaCitas vc = new VistaCitas();
                vc.setIdCitaVista(rs.getInt("IdCita"));
                vc.setIdPacienteVista(rs.getInt("IdPaciente"));
                vc.setNombrePacienteVista(rs.getString("NombrePaciente"));
                vc.setApellidosPacienteVista(rs.getString("ApellidosPaciente"));
                vc.setFechaCitaVista(rs.getDate("Fecha"));
                vc.setHoraCitaVista(rs.getString("Hora"));
                vc.setEstadoCitaVista(rs.getString("Estado"));

                lista.add(vc);
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
