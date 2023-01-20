package com.mycompany.coffeedelcio.classe;


import java.sql.*;

public class Driver {
    public static Statement createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/starbucks", "root", "xyzh");
        return connection.createStatement();
    }

}
