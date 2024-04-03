/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asm.View;

import asm.Controller.QLDiemController;
import asm.Controller.QLSVController;
import asm.Model.Student;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QL_SV extends javax.swing.JFrame {

    private final QLDiemController qldiemcontroller = new QLDiemController();
    private final QLSVController qlsvController = new QLSVController();
    String strImg = "Không có hình";
    DefaultTableModel tbmodel;

    public QL_SV() {
        this.strImg = null;
        initComponents();
        setLocationRelativeTo(null);
        initColTable();
        initRowTable();
    }

    public void initColTable() {
        tbmodel = new DefaultTableModel();
        tbmodel.setColumnIdentifiers(new String[]{"Mã SV", "Họ tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ", "Hình"});
        tblSV.setModel(tbmodel);
    }

    //thêm 1 dòng vào bảng mà không cần load lại dữ liệu từ DB
    public void AddRowtoTable(Student st) {
        tbmodel.addRow(new Object[]{st.getMaSV(), st.getHoTen(), st.getEmail(), st.getSoDT(), st.getGioiTinh(), st.getDiaChi(), st.getHinhSV()});
        tblSV.setModel(tbmodel);
    }

    public boolean CheckNull_QLForm() {
        if (txtMaSV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống");
            return false;
        }
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Họ tên không được để trống");
            return false;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
            return false;
        }
        if (txtSoDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
            return false;
        }
        String gioiTinh = rdoMale.isSelected() ? "Nam" : "Nữ";
        if (gioiTinh.equals("")) {
            JOptionPane.showMessageDialog(this, "Giỏi tính không được để trống");
            return false;
        }
        if (txtAddress.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            return false;
        }
        return true;
    }

    public Student InformationSV() {
        if (!CheckNull_QLForm()) {
            return null;
        }
        Student st = new Student();
        st.setMaSV(txtMaSV.getText());
        st.setHoTen(txtName.getText());
        st.setEmail(txtEmail.getText());
        st.setSoDT(txtSoDT.getText());
        String gioiTinh = rdoMale.isSelected() ? "Nam" : "Nữ";
        st.setGioiTinh(gioiTinh);
        st.setDiaChi(txtAddress.getText());
        if (strImg == null) {
            strImg = "không có";
        }
        st.setHinhSV(strImg);
        return st;
    }

    //xóa 1 dòng sinh viên
    public void DeleteRowtoTable(String masv) {
        //xác định vị trí cột làm đk xóa
        int col = 0;
        int rowCount = tblSV.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            String valueRow = (String) tblSV.getValueAt(row, col);
            if (valueRow.equals(masv)) {
                tbmodel.removeRow(row);
                tblSV.setModel(tbmodel);
                return;
            }
        }
    }

    public void initRowTable() {
        List<Student> listAllSV = new ArrayList<>();
        listAllSV = qlsvController.SelectAllSV();
        tbmodel.setRowCount(0);
        for (Student st : listAllSV) {
            tbmodel.addRow(new Object[]{st.getMaSV(), st.getHoTen(), st.getEmail(), st.getSoDT(), st.getGioiTinh(), st.getDiaChi(), st.getHinhSV()});
        }
        tblSV.setModel(tbmodel);
    }

    //reset form 
    public void ResetFormSV() {
        txtMaSV.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtSoDT.setText("");
        txtAddress.setText("");
        buttonGroup1.clearSelection();
        txtMaSV.requestFocus();
    }

    @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSV_New = new javax.swing.JButton();
        btnSV_Save = new javax.swing.JButton();
        btnSV_Delete = new javax.swing.JButton();
        btnSV_Update = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản Lý Sinh Viên ");
        jPanel1.add(jLabel1);

        jPanel2.setLayout(new java.awt.GridLayout());

        jLabel2.setText("Mã SV: ");

        jLabel3.setText("Tên SV: ");

        jLabel4.setText("Email: ");

        jLabel5.setText("Số ĐT: ");

        jLabel6.setText("Giới tính");

        jLabel7.setText("Địa chỉ");

        buttonGroup1.add(rdoMale);
        rdoMale.setText("Nam");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Nữ");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdoMale)
                        .addGap(18, 18, 18)
                        .addComponent(rdoFemale)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel2.add(jPanel3);

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Hình ảnh");
        lblImage.setToolTipText("");
        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addGap(72, 72, 72))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );

        lblImage.getAccessibleContext().setAccessibleParent(lblImage);

        jPanel6.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(2, 2, 20, 10));

        btnSV_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnSV_New.setText("New");
        btnSV_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSV_NewActionPerformed(evt);
            }
        });
        jPanel5.add(btnSV_New);

        btnSV_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btnSV_Save.setText("Save");
        btnSV_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSV_SaveActionPerformed(evt);
            }
        });
        jPanel5.add(btnSV_Save);

        btnSV_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnSV_Delete.setText("Delete");
        btnSV_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSV_DeleteActionPerformed(evt);
            }
        });
        jPanel5.add(btnSV_Delete);

        btnSV_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnSV_Update.setText("Update");
        btnSV_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSV_UpdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnSV_Update);

        jPanel6.add(jPanel5);
        jPanel5.getAccessibleContext().setAccessibleParent(lblImage);

        jPanel2.add(jPanel6);

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSV);
        tblSV.getAccessibleContext().setAccessibleParent(lblImage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSV_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSV_SaveActionPerformed
        if (!CheckNull_QLForm()) {
            return;
        }
        qlsvController.InsertSV(InformationSV());
        initRowTable();
        ResetFormSV();
    }//GEN-LAST:event_btnSV_SaveActionPerformed

    private void btnSV_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSV_NewActionPerformed
        // TODO add your handling code here:
        ResetFormSV();
    }//GEN-LAST:event_btnSV_NewActionPerformed

    private void btnSV_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSV_DeleteActionPerformed
        // TODO add your handling code here:
        if (!CheckNull_QLForm()) {
            return;
        }
        String masv = txtMaSV.getText();
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sinh viên " + masv, "Xóa sinh vien", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            //xóa điểm trước
            qldiemcontroller.DeleteStudent(masv);
            //xóa sinh viên
            qlsvController.DeleteSV(masv);
        }
        initRowTable();
        ResetFormSV();
    }//GEN-LAST:event_btnSV_DeleteActionPerformed

    private void btnSV_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSV_UpdateActionPerformed
        // TODO add your handling code here:
        if (!CheckNull_QLForm()) {
            return;
        }
        qlsvController.UpdateSV(InformationSV());
        initRowTable();
        ResetFormSV();
    }//GEN-LAST:event_btnSV_UpdateActionPerformed

    private void tblSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSVMouseClicked
        // TODO add your handling code here:
        int index = tblSV.getSelectedRow();
        txtMaSV.setText((String) tblSV.getValueAt(index, 0));
        txtName.setText((String) tblSV.getValueAt(index, 1));
        txtEmail.setText((String) tblSV.getValueAt(index, 2));
        txtSoDT.setText((String) tblSV.getValueAt(index, 3));
        String gioiTinh = (String) tblSV.getValueAt(index, 4);
        if (gioiTinh.equalsIgnoreCase("Nam")) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }
        txtAddress.setText((String) tblSV.getValueAt(index, 5));
        String img = (String) tblSV.getValueAt(index, 6);
        int width = lblImage.getWidth();
        int height = lblImage.getHeight();

        if (img.equalsIgnoreCase("Không có")) {
            lblImage.setText("Không có avatar");
            lblImage.setIcon(null);
        } else {
            lblImage.setText("");
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/icon/" + img));
        Image iicon = imgIcon.getImage();

        Image scaledImg = iicon.getScaledInstance(96, 118, Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(scaledImg));

        }
    }//GEN-LAST:event_tblSVMouseClicked

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImageMouseClicked
        try {

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            strImg = file.getName();
            Image img = ImageIO.read(file);
            lblImage.setText("");
            int width = lblImage.getWidth();
            int height = lblImage.getHeight();
            lblImage.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            System.out.println("lỗi " + ex.getMessage());
        }

    }// GEN-LAST:event_lblImageMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QL_SV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_SV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_SV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_SV.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_SV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSV_Delete;
    private javax.swing.JButton btnSV_New;
    private javax.swing.JButton btnSV_Save;
    private javax.swing.JButton btnSV_Update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSoDT;
    // End of variables declaration//GEN-END:variables
}
