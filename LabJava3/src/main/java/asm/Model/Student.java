/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class Student {

    private String MaSV, hoTen, email, soDT, diaChi, hinhSV, gioiTinh;

    public String getHinhSV() {
        return hinhSV;
    }

    public void setHinhSV(String hinhSV) {
        this.hinhSV = hinhSV;
    }

    public Student(String MaSV, String hoTen, String email, String soDT, String gioiTinh, String diaChi, String hinhSV) {
        this.MaSV = MaSV;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhSV = hinhSV;
    }

    public Student() {
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Student SelecSV(String MaSV) {
        String sql = "select masinhvien, hoten, email, sodt, gioitinh,diachi, hinh from sinhvien where masinhvien = ?";
        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement pstmt = con.prepareCall(sql);
            pstmt.setString(1, sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Student st = new Student();
                st.setMaSV(rs.getString(1));
                st.setHoTen(rs.getString(2));
                st.setEmail(rs.getString(3));
                st.setSoDT(rs.getString(4));
                st.setGioiTinh(rs.getString(5));
                st.setDiaChi(rs.getString(6));
                st.setHinhSV(rs.getString(7));
                return st;
            }
            {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên");
            }
        } catch (Exception e) {
        }

        return null;
    }

    public String selectMaSV(String id) {
        String sql = "select masinhvien from sinhvien where masinhvien = ?";
        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return null;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void InsertSinhvien(Student st) {
        String masv = st.getMaSV();
        String tensv = st.getHoTen();
        String email = st.getSoDT();
        String gioiTinh = st.getGioiTinh(); // chưa xác định
        String diachi = st.getMaSV();
        String hinh = st.getMaSV();
    }
}
