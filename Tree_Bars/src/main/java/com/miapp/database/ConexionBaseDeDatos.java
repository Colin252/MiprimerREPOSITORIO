package com.miapp.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contraseña";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
