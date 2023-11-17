package com.example.Tictactoe.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private DBConnection(){}

    public static Connection getInstance(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root","root");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return connection;
    }
}
