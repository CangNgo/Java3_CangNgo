/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class bai1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=STUDENT;trustServerCertificate=true;encrypt=true;";
            String user = "LAB5";
            String pass = "123123";
            Connection con = DriverManager.getConnection(connectionUrl, user, pass);
            System.out.println("thanh cong");
            
            String sql = "Select *from student";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                System.out.print("MASV: " + rs.getString(1));
                System.out.print(", Hoten: " + rs.getString(2));
                System.out.print(", Email: " + rs.getString(3));
                System.out.print(", SoDT: " + rs.getString(4));
                System.out.print(", GioiTinh: " + rs.getString(5));
                System.out.println();
            }
            
        } catch (Exception e) {

            System.out.println(e.getStackTrace());
        }
    }
}
