/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.Controller;

import asm.Model.Connected;
import asm.Model.Student_Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class QLDiemController {

    public List<String> SelectMasv(String masv) {
        List<String> listMasv = new ArrayList<>();
        String sqlSelectMasv = "SELECT MASINHVIEN FROM BANGDIEM";
        try (Connection con = Connected.openConnectionASM()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelectMasv);
            while (rs.next()) {
                listMasv.add(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listMasv;
    }

    //xuất sinh vien theo mã
    public Student_Point SelectPoint(String masv) {
        String sqlSelect = "SELECT HOTEN, BANGDIEM.MASINHVIEN, TIENGANH,TINHOC, GDTC "
                + "FROM BANGDIEM INNER JOIN SINHVIEN ON BANGDIEM.MASINHVIEN = SINHVIEN.MASINHVIEN \n"
                + "WHERE SINHVIEN.MASINHVIEN = ?";
        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement ptmt = con.prepareStatement(sqlSelect);
            ptmt.setString(1, masv);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                Student_Point studentpoint = new Student_Point();
                studentpoint.setTenSV(rs.getString(1));
                studentpoint.setMaSV(rs.getString(2));
                studentpoint.setTiengAnh(Double.parseDouble(rs.getString(3)));
                studentpoint.setTinHoc(Double.parseDouble(rs.getString(4)));
                studentpoint.setGDTC(Double.parseDouble(rs.getString(5)));

                return studentpoint;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "QLDIEM CONTROLLER" + e.getMessage());
        }
        return null;
    }

    //Hiển thị sinh viên top 3
    public List Showtop3(List list) {
        String sqlView = "SELECT *FROM V_TOP3SINHVIEN";
        try (Connection con = Connected.openConnectionASM()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlView);
            while (rs.next()) {
                Student_Point studentpoint = new Student_Point();
                studentpoint.setMaSV(rs.getString(1));
                studentpoint.setTenSV(rs.getString(2));
                studentpoint.setTiengAnh(Double.parseDouble(rs.getString(3)));
                studentpoint.setTinHoc(Double.parseDouble(rs.getString(4)));
                studentpoint.setGDTC(Double.parseDouble(rs.getString(5)));
                //add sinh vien vao list
                list.add(studentpoint);
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    //insert 
    public void InsertBangDiem(Student_Point st) {
        //kiểm tra sinh viên đã tồn tại điểm trong db chưa 
        String masv = st.getMaSV();
        //tạo biến kiểm tra
        boolean checkmasv = false;
        List<String> listmasv = SelectMasv(masv);
        for (String list : listmasv) {
            if (list.equals(masv)) {
                //đã tìm thấy mã sinh viên trong DB
                checkmasv = true;
                break;
            }
        }

        if (checkmasv) {
            int choice = JOptionPane.showConfirmDialog(null, "Điểm sinh viên " + masv + "  đã có, \nBạn có muốn cập nhật điểm cho sinh viên ", "Điểm đã tồn tại", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                UpdateStudent(st);
                return;
            } else {
                return;
            }
        }
        //insert 
        String sqlInsert = "INSERT INTO BANGDIEM (MASINHVIEN, TIENGANH, TINHOC, GDTC)"
                + "VALUES(?,?,?,?)";
        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement ptmt = con.prepareStatement(sqlInsert);
            ptmt.setString(1, st.getMaSV());
            ptmt.setString(2, String.valueOf(st.getTiengAnh()));
            ptmt.setString(3, String.valueOf(st.getTinHoc()));
            ptmt.setString(4, String.valueOf(st.getGDTC()));
            ptmt.execute();
            JOptionPane.showMessageDialog(null, "Thêm điểm sinh viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Student code does not exist");
        }
    }

    //update
    public void UpdateStudent(Student_Point st) {
        String sqlUpdate = "Update BANGDIEM \n"
                + "set TIENGANH = ?,\n"
                + "tinhoc = ?, \n"
                + "GDTC = ?\n"
                + "where masinhvien = ?";
        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement ptmt = con.prepareStatement(sqlUpdate);
            ptmt.setString(1, String.valueOf(st.getTiengAnh()));
            ptmt.setString(2, String.valueOf(st.getTinHoc()));
            ptmt.setString(3, String.valueOf(st.getGDTC()));
            ptmt.setString(4, st.getMaSV());
            ptmt.execute();
            JOptionPane.showMessageDialog(null, "Cập nhật sinh viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //DELETE SINH VIEN 
    //chưa ktr masv có tồn tại hay không 
    public void DeleteStudent(String masv) {
        String sqlDelete = "DELETE BANGDIEM WHERE MASINHVIEN = ?";
        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement ptmt = con.prepareStatement(sqlDelete);
            ptmt.setString(1, masv);
            ptmt.execute();
            JOptionPane.showMessageDialog(null, "Xóa sinh viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //select name sinh vien
    public String SelectNamesv(String masv) {
        String sqlSelectMasv = "SELECT hoten FROM sinhvien where masinhvien = ?";
        try (Connection con = Connected.openConnectionASM()) {
            PreparedStatement ptmt = con.prepareStatement(sqlSelectMasv);
            ptmt.setString(1, masv);
            ResultSet rs = ptmt.executeQuery();
            if (!rs.next()) {
                String result = rs.getString(1);
                return result;
            } else {
                return "Không tìm thấy sinh viên";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return "Không tìm thấy sinh viên";
    }
}
