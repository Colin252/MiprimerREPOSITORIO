package org.studyeasy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {
	private static final String URL = "jdbc:mysql://localhost:3306/chatdb";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "123456";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }

    public static void probarConexion() {
        try {
            Connection conexion = obtenerConexion();
            if (conexion != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Error al conectar con la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
}