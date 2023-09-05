/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yair
 */
public class DataBase {

    protected Connection conexion = null;
    private final String URL = "jdbc:mysql://localhost:3306/gestionclinica";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    //Método para conectarse a la bd
    public void conectar() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
