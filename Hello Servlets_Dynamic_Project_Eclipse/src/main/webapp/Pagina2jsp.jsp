<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>


<head>
    <meta charset="UTF-8">
    <title>Página 2 con Diseño</title>
    <style>
        body {
            background-image: url('https://source.unsplash.com/random/1600x900');
            background-size: cover;
            background-position: center;
            color: white;
            text-align: center;
            font-family: Arial, sans-serif;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin: 10px;
        }

        button:hover {
            background-color: #0056b3;
        }

        nav {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 15px;
            position: fixed;
            width: 100%;
            top: 0;
            left: 0;
        }

        nav a {
            color: white;
            text-decoration: none;
            font-size: 18px;
            margin: 10px;
            padding: 10px;
        }
    </style>
</head>






    <title>Página 2</title>
</head>

<%@ page import="java.sql.*" %>
<%
String url = "jdbc:mysql://localhost:3306/chatdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    String user = "root";
    String password = "TU_CONTRASEÑA_AQUÍ";

    try {
        // Cargar el driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establecer la conexión
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mensajes");

        // Mostrar los mensajes almacenados en la base de datos
        while (rs.next()) {
            out.println("<p><strong>" + rs.getString("usuario") + ":</strong> " + rs.getString("mensaje") + "</p>");
        }

        // Cerrar la conexión después de usarla
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        out.println("<p>Error de conexión: " + e.getMessage() + "</p>");
    }
%>

<link rel="stylesheet" href="styles.css">

<body>

<nav>
    <a href="http://localhost:8080/Hello_Servlets/HelloServlet">Página 1</a>
    <a href="http://localhost:8080/Hello_Servlets/PaginaDosServlet">Página 2</a>
    <a href="https://firstfactory.com/">First Factory</a>
</nav>









    <h1>¡Bienvenido a la Página 2 con JSP!</h1>
    <p>Esta es una nueva página web con lógica JSP.</p>

    <%-- Puedes usar Java aquí dentro --%>
    <%
        String mensaje = "Este texto viene desde Java embebido en la JSP.";
    %>
    <p><strong><%= mensaje %></strong></p>

    <a href="index.html">Volver al inicio</a>
    <a href="/Hello_Servlets/index.html">Volver al inicio</a>
    
    
    
    <body>
    
    
    
    
    
    <h1>¡Bienvenido a la Página 2 con JSP!</h1>
    <p>Esta es una nueva página web con lógica JSP.</p>


    <h1>¡Bienvenido a la Página 2 con JSP!</h1>
    <p>Esta es una nueva página web con lógica JSP.</p>

    <!-- Botón para regresar a Página 1 -->
    <button onclick="window.location.href='http://localhost:8080/Hello_Servlets/HelloServlet'">Regresar a Página 1</button>

    <!-- Botón para actualizar la página -->
    <button onclick="location.reload();">Actualizar Página</button>





    <%-- Puedes usar Java aquí dentro --%>
    <%
   //     String mensaje = "Este texto viene desde Java embebido en la JSP.";
    %>
    <p><strong><%= mensaje %></strong></p>

    <!-- Botón para regresar a la Página 1 -->
    <button onclick="window.location.href='http://localhost:8080/Hello_Servlets/HelloServlet'">
        Regresar a Página 1
    </button>

    <!-- Botón para ir a First Factory -->
    <button onclick="window.location.href='https://firstfactory.com/'">
        Ir a First Factory
    </button>

    <!-- Botón de navegación con enlace -->
    <a href="index.html">Volver al inicio</a>
    <a href="/Hello_Servlets/index.html">Volver al inicio</a>
    
<button onclick="location.reload();">Actualizar Página</button>
</body>
    
<body>
    <h1>¡Bienvenido a la Página 2 con JSP!</h1>
    <p>Esta es una nueva página web con lógica JSP.</p>

    <!-- Botón para regresar a Página 1 -->
    <button onclick="window.location.href='http://localhost:8080/Hello_Servlets/HelloServlet'">Regresar a Página 1</button>

    <!-- Botón para actualizar la página -->
    <button onclick="location.reload();">Actualizar Página</button>
</body>
    
    
</body>
</html>
