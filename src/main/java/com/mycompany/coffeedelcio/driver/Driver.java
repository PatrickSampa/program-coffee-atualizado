package com.mycompany.coffeedelcio.driver;


import java.sql.*;

public class Driver {
    public static Statement createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/starbucks", "root", "3223");
        return connection.createStatement();
    }

}
