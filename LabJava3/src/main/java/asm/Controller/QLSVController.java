package asm.Controller;

import asm.Model.Connected;
import asm.Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class QLSVController {

    public List<Student> SelectAllSV() {
        List<Student> listAllSV = new ArrayList<>();
        String sqlSelectAllSV = "SELECT MASINHVIEN, HOTEN, EMAIL, SODT, GIOITINH, DIACHI, HINH FROM SINHVIEN";
        try (Connection con = Connected.openConnectionASM()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelectAllSV);
            while (rs.next()) {
                Student st = new Student();
                st.setMaSV(rs.getString("masinhvien"));
                st.setHoTen(rs.getString("hoten"));
                st.setEmail(rs.getString("email"));
                st.setSoDT(rs.getString("sodt"));
                st.setGioiTinh(rs.getString("gioitinh"));
                st.setDiaChi(rs.getString("diachi"));
                st.setHinhSV(rs.getString("hinh"));
                listAllSV.add(st);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listAllSV;
    }

    public void InsertSV(Student st) {
        String sqlInsert = "INSERT INTO SINHVIEN(MASINHVIEN,HOTEN,EMAIL,SODT,GIOITINH,DIACHI,HINH) VALUES(?,?,?,?,?,?,?)";
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm sinh viên " + st.getHoTen(), "Thêm sinh vien", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try (Connection con = Connected.openConnectionASM()) {
                PreparedStatement ptmt = con.prepareStatement(sqlInsert);
                ptmt.setString(1, st.getMaSV());
                ptmt.setString(2, st.getHoTen());
                ptmt.setString(3, st.getEmail());
                ptmt.setString(4, st.getSoDT());
                ptmt.setString(5, st.getGioiTinh());
                ptmt.setString(6, st.getDiaChi());
                ptmt.setString(7, st.getHinhSV());
                ptmt.execute();
                JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "thêm sinh viên thất bại");
            }
        }
    }

    //update 
    public void UpdateSV(Student st) {
        String sqlInsert = "Update sinhvien \n"
                + "set hoten = ?,\n"
                + "email = ?, \n"
                + "sodt = ?, \n"
                + "gioitinh =? , \n"
                + "diachi = ?, \n"
                + "hinh = ?  \n"
                + "where masinhvien = ?";
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật sinh viên " + st.getHoTen(), "Cập nhật sinh vien", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try (Connection con = Connected.openConnectionASM()) {
                PreparedStatement ptmt = con.prepareStatement(sqlInsert);
                String hinh = st.getHinhSV();

                ptmt.setString(1, st.getHoTen());
                ptmt.setString(2, st.getEmail());
                ptmt.setString(3, st.getSoDT());
                ptmt.setString(4, st.getGioiTinh());
                ptmt.setString(5, st.getDiaChi());
                ptmt.setString(6, st.getHinhSV());
                ptmt.setString(7, st.getMaSV());

                ptmt.execute();
                JOptionPane.showMessageDialog(null, "Cập nhật sinh viên thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    //delete
    public void DeleteSV(String masv) {
        String sqlInsert = "Delete sinhvien where masinhvien = ?";

        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement ptmt = con.prepareStatement(sqlInsert);

            ptmt.setString(1, masv);
            ptmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
