/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;


import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author acer
 */
public class connec {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=STUDENT;trustServerCertificate=true;encrypt=true;" ; 
            String user ="LAB5";
            String pass ="123123";
            Connection con = DriverManager.getConnection(connectionUrl,user,pass);
            System.out.println("thanh cong");
        } catch (Exception e) {
            
            System.out.println("loi");
        }
    }
}
