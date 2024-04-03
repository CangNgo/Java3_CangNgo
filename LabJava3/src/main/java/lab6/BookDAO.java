/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class BookDAO {

    //search
    public Book Search(String id) {
        String sql = "select *from SOF203_L6_B1_BOOK where BookID = ?";
        try (Connection con = Connectionn.openConnectionLab6bai1()) {
            PreparedStatement ptmt = con.prepareStatement(sql);
            ptmt.setString(1, id);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setID(rs.getString(1));
                book.setName(rs.getString(2));
                book.setPrice(rs.getDouble(3));
                return book;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void DeleteBook(String id) {
        String sql = "delete SOF203_L6_B1_BOOK where BookID= ?";
        String selectsql = "select BookID,Title  from SOF203_L6_B1_BOOK where BookID = ?";
        try (Connection con = Connectionn.openConnectionLab6bai1()) {
            //kiem tra xem bookid co trong database hay khong
            PreparedStatement ptmtCheck = con.prepareStatement(selectsql);
            ptmtCheck.setString(1, id);
            ResultSet rs = ptmtCheck.executeQuery();
            if (rs.next()) {
                int argee = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa Sach " + rs.getString("Title"), "ban muon xoa sach",JOptionPane.YES_NO_OPTION);
                if (argee == JOptionPane.YES_OPTION) {
                    //xoa du lieu
                    PreparedStatement ptmt = con.prepareStatement(sql);
                    ptmt.setString(1, id);
                    ptmt.execute();
                }

            }else{
                JOptionPane.showMessageDialog(null, "Khong tim thay sach ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  e.getStackTrace());
        }
    }
}
