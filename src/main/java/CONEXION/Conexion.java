/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alfiery Furlong
 */
public class Conexion {

    public static Connection conectar() throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/bd_timana";
        String USUARIO = "postgres";
        String PASSWORD = "postgres";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
