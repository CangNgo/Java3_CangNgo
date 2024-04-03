/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab5;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class bai2 extends javax.swing.JFrame {

    List<Student> list = new ArrayList<>();

    public bai2() {
        initComponents();
        setLocationRelativeTo(null);
        LoadDatatoSQK();
    }

    public void LoadDatatoSQK() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=SOF203_Demo;trustServerCertificate=true;encrypt=true;";
            String username = "sa";
            String password = "123123";
            Connection con = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "select *from student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                int gioitinh = rs.getInt(5);
                String diachi = rs.getString(6);
                list.add(new Student(id, name, email, phone, gioitinh, diachi));
            }
            con.close();
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
    }

    public void Add() {
        txtID.setText("");
        txtName.setText("");
        txtNode.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        btnGroupGender.clearSelection();
    }

    public void Delete() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=SOF203_Demo;trustServerCertificate=true;encrypt=true;";
        String password = "123123";
        String username = "sa";
        try (Connection con = DriverManager.getConnection(connectionUrl, username, password)) {
            String id = txtID.getText();
            String delete = "delete SOF203_L5_B2_SinhVien where masv like ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            stmt.setString(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa sinh viên thất bại");
        }

    }

    public void Update() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=SOF203_Demo;trustServerCertificate=true;encrypt=true;";
        String password = "123123";
        String username = "sa";
        try (Connection con = DriverManager.getConnection(connectionUrl, username, password)) {
            String id = txtID.getText();
            String hoten = txtName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            int gioitinh = rdoFemal.isSelected() ? 0 : 1;
            String diachi = txtNode.getText();
            String insert = "update SOF203_Demo set hoten = ?, email = ?, sodt = ?, gioitinh =? , diachi = ? where masv = ?";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setString(1, hoten);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setInt(4, gioitinh);
            stmt.setString(5, diachi);
            stmt.setString(6, id);
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thất bại");
        }
    }

    public void Save() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=SOF203_Demo;trustServerCertificate=true;encrypt=true;";
        String password = "123123";
        String username = "sa";
        try (Connection con = DriverManager.getConnection(connectionUrl, username, password)) {
            String id = txtID.getText();
            String hoten = txtName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            int gioitinh = rdoFemal.isSelected() ? 0 : 1;
            String diachi = txtNode.getText();
            String insert = "insert into SOF203_L5_B2_SinhVien (masv, hoten, email, sodt, gioitinh,diachi) values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setString(1, id);
            stmt.setString(2, hoten);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setInt(5, gioitinh);
            stmt.setString(6, diachi);
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa sinh viên thất bại");
        }
    }

    public void Find() {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=STUDENT;trustServerCertificate=true;encrypt=true;";
        String password = "123123";
        String username = "sa";

        try (Connection con = DriverManager.getConnection(connectionUrl, username, password)) {
            String id = txtID.getText();
            String sql = "{call PS_FIND(?)}";
            try (CallableStatement stmt = con.prepareCall(sql)) {
                stmt.setString(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        txtID.setText(rs.getString(1));
                        txtName.setText(rs.getString(2));
                        txtEmail.setText(rs.getString(3));
                        txtPhone.setText(rs.getString(4));
                        int gender = rs.getInt(5);
                        if (gender == 0) {
                            rdoMale.setSelected(true);
                        } else {
                            rdoFemal.setSelected(true);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Student not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemal = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNode = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("Ma SV");

        jLabel2.setText("Ten SV");

        jLabel3.setText("Email");

        jLabel4.setText("So ĐT");

        jLabel5.setText("Giói tính ");

        btnGroupGender.add(rdoMale);
        rdoMale.setText("Nam");

        btnGroupGender.add(rdoFemal);
        rdoFemal.setText("Nữ");

        jLabel6.setText("Địa chỉ");

        txtNode.setColumns(20);
        txtNode.setRows(5);
        jScrollPane1.setViewportView(txtNode);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        48,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 27, Short.MAX_VALUE)))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtID,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                122,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                122,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel3Layout.createSequentialGroup()
                                                                        .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addComponent(jLabel4,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jLabel3,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jLabel5,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        48, Short.MAX_VALUE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtEmail,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        122,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtPhone,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        122,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel3Layout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(rdoMale,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                59,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(rdoFemal,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                59,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(26, 26, 26))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(rdoMale)
                                        .addComponent(rdoFemal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(88, Short.MAX_VALUE)));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(17, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFind)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));

        jPanel1.add(jPanel2);

        jButton1.setText("<");

        jButton2.setText("|<");

        jButton3.setText(">");

        jButton4.setText(">|");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addContainerGap(80, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed

        Add();
    }// GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed

        Delete();
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed

        Update();
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed

        Save();
    }// GEN-LAST:event_btnSaveActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFindActionPerformed

        Find();
    }// GEN-LAST:event_btnFindActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.ButtonGroup btnGroupGender;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoFemal;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNode;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
