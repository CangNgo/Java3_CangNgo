package asm.View;

import asm.Controller.QLDiemController;
import asm.Model.Student_Point;
import asm.Model.Student;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QL_Diem extends javax.swing.JFrame {

    QLDiemController sinhvienController;
    QLDiemController diemController;
    DefaultTableModel tbmodel;

    public QL_Diem() {
        initComponents();
        setLocationRelativeTo(null);
        initColTable();
        initRowTable();

    }

    public void initColTable() {
        tbmodel = new DefaultTableModel();
        tbmodel.setColumnIdentifiers(
                new String[]{"Mã sinh viên", "Tên sinh vien", "Tiếng anh", "Tin học", "GDTC", "Điểm TB"});
        tblStudent.setModel(tbmodel);
    }

    public void initRowTable() {
        List<Student_Point> list = new ArrayList<>();
        QLDiemController stpoint = new QLDiemController();
        stpoint.Showtop3(list);
        tbmodel.setRowCount(0);
        for (Student_Point st : list) {
            double diemTB = st.getTiengAnh() + st.getTinHoc() + st.getGDTC();
            diemTB = (Math.round(diemTB * 100.0 / 3.0)) / 100.0;
            tbmodel.addRow(new Object[]{st.getMaSV(), st.getTenSV(), st.getTiengAnh(), st.getTinHoc(), st.getGDTC(),
                diemTB});
        }
        tblStudent.setModel(tbmodel);
    }

    public void setInforStudent(int index) {
        double tongdiem = (double) tblStudent.getValueAt(index, 2)
                + (double) tblStudent.getValueAt(index, 3)
                + (double) tblStudent.getValueAt(index, 4);
        txtMasv.setText(String.valueOf(tblStudent.getValueAt(index, 0)));
        lblNameSV.setText(String.valueOf(tblStudent.getValueAt(index, 1)));
        txtTienganh.setText(String.valueOf(tblStudent.getValueAt(index, 2)));
        txtTinhoc.setText(String.valueOf(tblStudent.getValueAt(index, 3)));
        txtGDTC.setText(String.valueOf(tblStudent.getValueAt(index, 4)));
        lblTongdiem.setText(String.valueOf(tongdiem));
    }

    public void Reset() {
        txtMasv.setText("");
        txtTienganh.setText("");
        txtTinhoc.setText("");
        txtGDTC.setText("");
        lblTongdiem.setText("0.0");
        txtMasv.requestFocus();

    }

    public boolean CheckSearch(String search) {
        if (search.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên");
            return false;
        }
        return true;
    }

    public boolean CheckDiem() {

        if (!CheckTinhoc()) {
            JOptionPane.showMessageDialog(null, "Nhập điểm từ 0 đén 10");
            return false;
        }
        if (!CheckTienganh()) {
            JOptionPane.showMessageDialog(null, "Nhập điểm từ 0 đén 10");
            return false;
        }
        if (!CheckGDTC()) {
            JOptionPane.showMessageDialog(null, "Nhập điểm từ 0 đén 10");
            return false;
        }
        return CheckMasv() && CheckTinhoc() && CheckTinhoc() && CheckGDTC();
    }

    public boolean CheckMasv() {
        return (!txtMasv.getText().equals(""));
    }

    public boolean CheckTienganh() {
        double pointTiengAnh = Double.parseDouble(txtTienganh.getText());
        return pointTiengAnh >= 0 && pointTiengAnh <= 10;
    }

    public boolean CheckTinhoc() {

        double pointTinHoc = Double.parseDouble(txtTinhoc.getText());
        return pointTinHoc >= 0 && pointTinHoc <= 10;
    }

    public boolean CheckGDTC() {
        double pointGDTC = Double.parseDouble(txtGDTC.getText());
        return pointGDTC >= 0 && pointGDTC <= 10;
    }

    public boolean CheckNull() {
        String masv = txtMasv.getText();
        String tienganh = txtTienganh.getText();
        String tinhoc = txtTinhoc.getText();
        String gdtc = txtGDTC.getText();
        if (masv.equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống mã sinh vien");
            return false;
        }
        if (tienganh.equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống điểm tiếng anh");
            return false;
        }
        if (tinhoc.equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống điểm tin hoc");
            return false;
        }
        if (gdtc.equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để điểm GDTC");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblNameSV = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMasv = new javax.swing.JTextField();
        txtTienganh = new javax.swing.JTextField();
        txtGDTC = new javax.swing.JTextField();
        txtTinhoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblTongdiem = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btbNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        btnFirst = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Quản Lý Điểm Sinh Viên");
        jPanel1.add(jLabel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel2.setText("Mã sinh viên");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel3.setText("Họ tên SV : ");

        lblNameSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblNameSVKeyReleased(evt);
            }
        });

        jLabel5.setText("Mã SV");

        jLabel6.setText("Tiến anh");

        jLabel7.setText("Tin");

        jLabel8.setText("Giáo dục");

        txtMasv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMasvKeyPressed(evt);
            }
        });

        jLabel9.setText("Điểm TB:");

        lblTongdiem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTongdiem.setForeground(new java.awt.Color(51, 0, 255));
        lblTongdiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongdiem.setText("0.0");
        lblTongdiem.setAlignmentX(2.0F);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(lblNameSV, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMasv)
                    .addComponent(txtTienganh)
                    .addComponent(txtTinhoc)
                    .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTongdiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6))
                            .addComponent(txtTienganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(lblTongdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel6.setLayout(new java.awt.GridLayout(4, 1));

        btbNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new.png"))); // NOI18N
        btbNew.setText("New");
        btbNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbNewActionPerformed(evt);
            }
        });
        jPanel6.add(btbNew);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel6.add(btnSave);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel6.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(btnDelete);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "3 sinh viên cao điểm nhất"));

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudent);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnFirst.setText("Frist");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnUp.setText("Up");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.setText("Down");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnFirst)
                        .addGap(5, 5, 5)
                        .addComponent(btnUp)
                        .addGap(5, 5, 5)
                        .addComponent(btnDown)
                        .addGap(5, 5, 5)
                        .addComponent(btnLast)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst)
                    .addComponent(btnUp)
                    .addComponent(btnDown)
                    .addComponent(btnLast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
    }//GEN-LAST:event_btnSearchMouseClicked

    private void txtMasvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMasvKeyPressed
//         TODO add your handling code here:
        String masv = txtMasv.getText();
        String tensv = diemController.SelectNamesv(masv);
        lblNameSV.setText(tensv);
    }//GEN-LAST:event_txtMasvKeyPressed

    private void lblNameSVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblNameSVKeyReleased
        // TODO add your handling code here:
//        String masv = txtMasv.getText();
//        String tensv = diemController.SelectNamesv(masv);
//        txtSearch.setText(tensv);
    }//GEN-LAST:event_lblNameSVKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSearchActionPerformed

    }// GEN-LAST:event_txtSearchActionPerformed

    private void btbNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btbNewActionPerformed
        Reset();
    }// GEN-LAST:event_btbNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchActionPerformed

        String masv = txtSearch.getText();
        if (CheckSearch(masv)) {
            QLDiemController selectSV = new QLDiemController();
            Student_Point stpoint = new Student_Point();
            stpoint = selectSV.SelectPoint(txtSearch.getText());
            if (stpoint != null) {
                lblNameSV.setText(stpoint.getTenSV());
                txtMasv.setText(stpoint.getMaSV());
                txtTienganh.setText(String.valueOf(stpoint.getTiengAnh()));
                txtTinhoc.setText(String.valueOf(stpoint.getTinHoc()));
                txtGDTC.setText(String.valueOf(stpoint.getGDTC()));
                lblTongdiem.setText(String.valueOf(stpoint.getTiengAnh() + stpoint.getTinHoc() + stpoint.getGDTC()));
            } else {
                JOptionPane.showMessageDialog(this, "Sinh viên không tồn tại");
            }
            txtSearch.requestFocus();
        }
    }// GEN-LAST:event_btnSearchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
        //early return
        if (!CheckNull()) {
            return;
        }
        if (!CheckDiem()) {
            return;
        }
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu điểm sinh viên ", "Lưu điểm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String masv = txtMasv.getText();
            String tienganh = txtTienganh.getText();
            String tinhoc = txtTinhoc.getText();
            String gdtc = txtGDTC.getText();
            QLDiemController insertStudent = new QLDiemController();
            Student_Point st = new Student_Point(masv, Double.parseDouble(tienganh), Double.parseDouble(tinhoc),
                    Double.parseDouble(gdtc));
            insertStudent.InsertBangDiem(st);
            // cập nhật lại top 3
            initRowTable();
            Reset();
        }
    }// GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        if (!CheckNull()) {
            return;
        }
        if (CheckDiem()) {
            String masv = txtMasv.getText();
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật điểm sinh viên" + masv, "Xóa sinh viên", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                double tiengAnh, tinHoc, GDTC;
                tiengAnh = Double.parseDouble(txtTienganh.getText());
                tinHoc = Double.parseDouble(txtTinhoc.getText());
                GDTC = Double.parseDouble(txtGDTC.getText());
                Student_Point st = new Student_Point(masv, tiengAnh, tinHoc, GDTC);
                // tao doi tuong
                QLDiemController qldcon = new QLDiemController();
                qldcon.UpdateStudent(st);
                // cập nhật lại top 3
                initRowTable();
                Reset();
            }
        }
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        if (!CheckNull()) {
            return;
        }
        if (CheckDiem()) {
            //lấy dữ liệu
            String masv = txtMasv.getText();
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sinh viên " + masv, "xóa sinh viên", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                //tạo đối tượng và truyền vào function
                diemController = new QLDiemController();
                diemController.DeleteStudent(masv);
                // cập nhật lại top 3
                initRowTable();
                Reset();
            }
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblStudentMouseClicked
        // lick vào table
        int index = tblStudent.getSelectedRow();
        Student st = new Student();
        setInforStudent(index);
    }// GEN-LAST:event_tblStudentMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFirstActionPerformed

        tblStudent.setRowSelectionInterval(0, 0);
        int index = tblStudent.getSelectedRow();
        setInforStudent(index);
    }// GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLastActionPerformed

        tblStudent.setRowSelectionInterval(2, 2);
        int index = tblStudent.getSelectedRow();
        setInforStudent(index);
    }// GEN-LAST:event_btnLastActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpActionPerformed

        int index = tblStudent.getSelectedRow();
        if (index == -1) {
            index = 0;
        }
        if (index == 0) {
            index = 2;
        } else {
            index = index - 1;
        }
        tblStudent.setRowSelectionInterval(index, index);
        setInforStudent(index);
    }// GEN-LAST:event_btnUpActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDownActionPerformed

        int index = tblStudent.getSelectedRow();
        if (index == 2) {
            index = 0;
        } else {
            index = index + 1;
        }
        tblStudent.setRowSelectionInterval(index, index);
        setInforStudent(index);
    }// GEN-LAST:event_btnDownActionPerformed

    public static void main(String args[]) throws MalformedURLException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QL_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_Diem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblNameSV;
    private javax.swing.JLabel lblTongdiem;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienganh;
    private javax.swing.JTextField txtTinhoc;
    // End of variables declaration//GEN-END:variables
}
