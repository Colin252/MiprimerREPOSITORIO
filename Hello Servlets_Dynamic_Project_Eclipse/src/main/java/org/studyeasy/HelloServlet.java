package org.studyeasy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
        System.out.println("El servlet ha sido llamado.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter();

        out.println("<html><head><meta charset='UTF-8'><title>Prueba de Conexión</title></head><body>");
        out.println("<h1>Prueba de conexión a MySQL desde el Servlet</h1>");

        Connection conexion = null;

        try {
            conexion = ConexionMysql.obtenerConexion();
            if (conexion != null) {
                out.println("<p style='color:green;'>¡Conexión exitosa a la base de datos!</p>");
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                out.println("<p style='color:red;'>Error al conectar con la base de datos.</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try {
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Botón de navegación a Página2JSP.jsp
        out.println("<br><button onclick=\"window.location.href='http://localhost:8080/Hello_Servlets/Pagina2jsp.jsp'\">Ir a Página 2</button>");

        // Botón de redirección externa
        out.println("<br><button onclick=\"window.location.href='https://www.postman.com/'\">Ir a Postman</button>");

        
        out.println("<br><button onclick=\"location.reload();\">Actualizar Página</button>");
        
        out.println("</body></html>");
    }
}