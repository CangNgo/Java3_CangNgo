package slide4;

import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ngotr
 */
public class bai11 {
    public static void main(String[] args) {
        try {
            String user = "sа";
            String pass = "";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-SGILQUI:1433;databaseName=QLSV;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select * from Students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getString("MaSV") + ", ");
                System.out.print(rs.getString("HoTen") + ", ");
                System.out.print(rs.getString("Email") + ", ");
                System.out.print(rs.getString("SoDT") + ", ");
                System.out.println(rs.getString("Gioitinh"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
