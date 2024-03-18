package lab3.codeTay;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class bai2_code_tay {
    public bai2_code_tay() {
        CreateJFrame();
    }

    public void CreateJFrame() {
        // tao frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        // tao bien cho frame
        // pannel 1
        JPanel pn1 = new JPanel();
        pn1.setBounds(0, 0, 1000, 100);
        System.out.println(frame.getWidth());

        pn1.setLayout(new GridLayout(1, 1));
        JPanel innerPN1 = new JPanel();
        // chen panel rong
        innerPN1.setLayout(new GridBagLayout());
        // khai bao bien cho panel1
        JLabel lblFristName, lblLastName, lblCodeName, lblCode;
        JTextField txtFristName, txtLastName, txtCodeName;
        JPasswordField txtCode;
        // set component vao vi tri
        GridBagConstraints gcb = new GridBagConstraints();
        gcb.gridx = 0;
        gcb.gridy = 0;
        gcb.anchor = GridBagConstraints.CENTER;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);

        // add label vao panel
        lblFristName = new JLabel("First Name");
        innerPN1.add(lblFristName, gcb);
        gcb.gridx += 3;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);

        lblLastName = new JLabel("Last Name");
        innerPN1.add(lblLastName, gcb);
        gcb.gridy += 2;
        gcb.gridx = 0;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);

        lblCodeName = new JLabel("Code Name");
        innerPN1.add(lblCodeName, gcb);
        gcb.gridx += 3;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);
        lblCode = new JLabel("Code");
        innerPN1.add(lblCode, gcb);
        // add textfield vao panel
        txtFristName = new JTextField(20);
        txtFristName.setPreferredSize(new Dimension(50, 20));

        txtLastName = new JTextField(20);
        txtLastName.setPreferredSize(new Dimension(50, 20));

        txtCodeName = new JTextField(20);
        txtCodeName.setPreferredSize(new Dimension(50, 20));

        txtCode = new JPasswordField(20);
        txtCode.setPreferredSize(new Dimension(50, 20));

        gcb.gridx = 1;
        gcb.gridy = 0;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);

        innerPN1.add(txtFristName, gcb);
        gcb.gridx += 3;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);

        innerPN1.add(txtLastName, gcb);
        gcb.gridx = 1;
        gcb.gridy += 2;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);

        innerPN1.add(txtCodeName, gcb);
        gcb.gridx += 3;
        gcb.insets = new java.awt.Insets(5, 5, 5, 5);

        innerPN1.add(txtCode, gcb);
        pn1.add(innerPN1, gcb);

        // panel 2
        JPanel pn2 = new JPanel();
        pn2.setBounds(0, 0, 1000, 100);
        FlowLayout flayout = new FlowLayout();
        flayout.setHgap(100);
        pn2.setLayout(flayout);
        JRadioButton rdoMale, rdoFeMale, rdoUnSex;
        rdoMale = new JRadioButton("Nam");
        rdoFeMale = new JRadioButton("Nữ");
        rdoUnSex = new JRadioButton("Không xác định");
        ButtonGroup btg = new ButtonGroup();
        btg.add(rdoUnSex);
        btg.add(rdoFeMale);
        btg.add(rdoUnSex);
        pn2.add(rdoMale);
        pn2.add(rdoFeMale);
        pn2.add(rdoUnSex);

        // panel 3
        JPanel pn3 = new JPanel();
        pn3.setLayout(new GridBagLayout());
        JLabel lblHomeTown, lblLike, lblNode;
        JComboBox cbxHomeTown;
        JCheckBox chkEatPlay, chkDacing, chkSleep;
        JTextArea txtNote;
        // khoi tao gia tri
        lblHomeTown = new JLabel("Hometown:");
        lblLike = new JLabel("Likes:");
        lblNode = new JLabel("Note:");

        cbxHomeTown = new JComboBox<>(provinces);

        // Thêm các option khác vào comboBox tương tự như trên

        chkEatPlay = new JCheckBox("Eat & Play");
        chkDacing = new JCheckBox("Dancing");
        chkSleep = new JCheckBox("Sleep");

        txtNote = new JTextArea(5, 20);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        pn3.add(lblHomeTown, gbc3);
        gbc3.gridx = 4;
        pn3.add(cbxHomeTown, gbc3);
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        pn3.add(lblLike, gbc3);
        gbc3.gridx += 4;
        pn3.add(chkEatPlay, gbc3);
        gbc3.gridx += 4;
        pn3.add(chkDacing, gbc3);
        gbc3.gridx += 4;
        pn3.add(chkSleep, gbc3);
        gbc3.gridx = 0;
        gbc3.gridy = 4;
        pn3.add(lblNode, gbc3);
        gbc3.gridx += 4;
        pn3.add(txtNote, gbc3);
        // add
        JPanel pn4 = new JPanel();
        pn4.setLayout(new FlowLayout());
        JButton btnOk, btnReset, btnExit;
        btnOk = new JButton("OK");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        pn4.add(btnOk);
        pn4.add(btnReset);
        pn4.add(btnExit);

        // event
        btnOk.addActionListener((ActionEvent e) -> {
            String ho = txtFristName.getText();
            String ten = txtLastName.getText();
            String codeName = txtCodeName.getText();
            String code = new String(txtCode.getPassword());
            String queQuan = (String) cbxHomeTown.getSelectedItem();
            String gioiTinh = "";
            String soThich = "";
            if (chkEatPlay.isSelected()) {
                soThich += "\n    Ăn chơi ";
            }
            if (chkDacing.isSelected()) {
                soThich += "\n    Nhảy múa ";
            }
            if (chkSleep.isSelected()) {
                soThich += "\n    Ngủ nghỉ ";
            }
            if (rdoMale.isSelected()) {
                gioiTinh = "Nam";
            } else if (rdoFeMale.isSelected()) {
                gioiTinh = "Nữ";
            } else if (rdoUnSex.isSelected()) {
                gioiTinh = "Không xác định";
            }
            String note = txtNote.getText();
            if (ho.equals("") || ten.equals("") || codeName.equals("") || code.equals("") || gioiTinh.equals("")
                    || queQuan.equals("")) {
                JOptionPane.showMessageDialog(null, "không được để trống các ô");
                return;
            }
            JOptionPane.showMessageDialog(null, "Họ tên: " + ho + "\nTên: " + ten + "\nQuê quán: " + queQuan + "\n"
                    + "Giới tính: " + gioiTinh + "\nBí danh: " + codeName + "\nMã: " + code +
                    "\nSở thích: " + soThich + "\nGhi chú: " + note);
        });

        btnExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        btnReset.addActionListener((ActionEvent e) -> {
            txtFristName.setText("");
            txtLastName.setText("");
            txtCodeName.setText("");
            txtCode.setText("");
            cbxHomeTown.setSelectedIndex(0);
            chkEatPlay.setSelected(false);
            chkDacing.setSelected(false);
            chkSleep.setSelected(false);
            btg.clearSelection();
            txtNote.setText("");
        });

        // hien thi frame
        frame.add(pn1);
        frame.add(pn2);
        frame.add(pn3);
        frame.add(pn4);
        frame.setVisible(true);
    }

    private String[] provinces = {
            "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu",
            "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận",
            "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên",
            "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh",
            "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa",
            "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai",
            "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ",
            "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh",
            "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên",
            "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP. Hồ Chí Minh", "Trà Vinh",
            "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"
    };

    public static void main(String[] args) {

        new bai2_code_tay();

    }
}