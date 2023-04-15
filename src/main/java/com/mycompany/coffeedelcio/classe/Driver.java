package com.mycompany.coffeedelcio.classe;


import java.sql.*;

public class Driver {
    public static Statement createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficina", "root", "22041985");
        return connection.createStatement();
    }

}
