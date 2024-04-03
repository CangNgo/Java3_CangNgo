/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class Connectionn {
      public static java.sql.Connection openConnectionLab6bai1() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=SOF203_Demo;trustServerCertificate=true;encrypt=true;";
        String username = "sa";
        String password = "123123";
        java.sql.Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;
    }
}
