/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.DataBase;
import interfaces.HistorialClinicoDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.HistorialClinico;

/**
 *
 * @author Yair
 */
public class HistorialClinicoDAOImpl extends DataBase implements HistorialClinicoDAO {

    @Override
    public void agregar(HistorialClinico historialClinico) throws Exception {

        String sql = "INSERT INTO historialclinico (rutaArchivoHistorial, nombreArchivo, pacienteId) values (?, ?, ?)";

        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, historialClinico.getArchivoReferencia());
            st.setString(2, historialClinico.getArchivoNombre());
            st.setInt(3, historialClinico.getPacienteId());

            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void visualizarHistorialC(String idHistorial) throws Exception {

        String sql = "SELECT * FROM historialclinico WHERE pacienteId = ?";

        HistorialClinico historialClinico = new HistorialClinico();

        this.conectar();
        PreparedStatement st = this.conexion.prepareStatement(sql);
        st.setString(1, idHistorial);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            historialClinico.setHistorialId(rs.getInt("id"));
            historialClinico.setArchivoReferencia(rs.getString("rutaArchivoHistorial"));

            // Obtener la ruta del archivo
            String rutaArchivo = historialClinico.getArchivoReferencia();

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

    @Override
    public HistorialClinico traerHistorialC(String pacienteId) throws Exception {

        String sql = "SELECT * FROM historialclinico WHERE pacienteId = ?";

        HistorialClinico historialClinico = new HistorialClinico();
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, pacienteId);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                historialClinico.setHistorialId(rs.getInt("id"));
                historialClinico.setPacienteId(rs.getInt("pacienteId"));
                historialClinico.setArchivoNombre(rs.getString("nombreArchivo"));
                historialClinico.setArchivoReferencia(rs.getString("rutaArchivoHistorial"));

            }

            rs.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.cerrarConexion();
        }

        return historialClinico;

    }

}
