/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.DataBase;
import interfaces.SeguimientoCitaDAO;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.SeguimientoCita;

/**
 *
 * @author Yair
 */
public class SeguimientoCitaDAOImpl extends DataBase implements SeguimientoCitaDAO {

    @Override
    public void agregar(SeguimientoCita seguimientoCita) throws Exception {

        String sql = "INSERT INTO seguimientocita (id, citaId, observaciones, nombreArchivo, rutaArchivoSeguimiento) "
                + "values (?, ?, ?, ?, ?)";

        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, seguimientoCita.getSeguimientoCitaId());
            st.setInt(2, seguimientoCita.getCitaId());
            st.setString(3, seguimientoCita.getObservaciones());
            st.setString(4, seguimientoCita.getNombreArchivo());
            st.setString(5, seguimientoCita.getRutaArchivo());

            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public List<SeguimientoCita> listar(String idUsuario) throws Exception {
        String sql = "SELECT sc.*\n"
                + "FROM paciente p\n"
                + "JOIN cita c ON p.id = c.pacienteId\n"
                + "JOIN seguimientocita sc ON c.id = sc.citaId\n"
                + "WHERE p.id = ?\n"
                + "ORDER BY sc.id DESC;";

        List<SeguimientoCita> lista = null;
        try {
            this.conectar();
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, idUsuario);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SeguimientoCita seguimientoCita = new SeguimientoCita();
                seguimientoCita.setSeguimientoCitaId(rs.getInt("id"));
                seguimientoCita.setCitaId(rs.getInt("citaId"));
                seguimientoCita.setObservaciones(rs.getString("observaciones"));
                seguimientoCita.setNombreArchivo(rs.getString("nombreArchivo"));
                seguimientoCita.setRutaArchivo(rs.getString("rutaArchivoSeguimiento"));
                lista.add(seguimientoCita);
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
    public void VisualizarSeguimeientoCita(String idSeguimiento) throws Exception {

        String sql = "SELECT * FROM seguimientocita WHERE id = ?";

        SeguimientoCita seguimientoCita = new SeguimientoCita();

        this.conectar();
        PreparedStatement st = this.conexion.prepareStatement(sql);
        st.setString(1, idSeguimiento);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            seguimientoCita.setSeguimientoCitaId(rs.getInt("id"));
            seguimientoCita.setCitaId(rs.getInt("citaId"));
            seguimientoCita.setObservaciones(rs.getString("observaciones"));
            seguimientoCita.setRutaArchivo(rs.getString("rutaArchivoSeguimiento"));

            // Obtener la ruta del archivo
            String rutaArchivo = seguimientoCita.getRutaArchivo();

            // Verificar si el archivo existe
            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                try {
                    // Abrir el archivo en el visor predeterminado del sistema
                    Desktop.getDesktop().open(archivo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("El archivo no existe en la ruta especificada.");
            }
        }
    }

}
