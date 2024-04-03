/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class Connec {

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=STUDENT;trustServerCertificate=true;encrypt=true;";
        String username = "sa";
        String password = "123123";
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;

    }

    public static Connection openConnectionLab6bai2() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=LAB6BAI2;trustServerCertificate=true;encrypt=true;";
        String username = "sa";
        String password = "123123";
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;

    }

}
