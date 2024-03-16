package lab1.code_tay;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class bai3 {
    public bai3() {
        createJFrame();
    }

    public void createJFrame() {
        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        // khai bao
        JLabel lblUser, lblPass, lblConfirm;
        JTextField txtUser;
        JPasswordField txtPass;
        JPasswordField txtConfirm;
        JButton btnSignUp, btnCancel;

        // tao panel
        Panel panel1 = new Panel();
        Panel panel2 = new Panel(new FlowLayout());
        Panel panel3 = new Panel();
        // add item cho panel 1
        panel1.setLayout(new GridLayout(5, 1));
        lblUser = new JLabel("Username");
        lblPass = new JLabel("Password");
        lblConfirm = new JLabel("Confirm");

        // addd item cho panel 2
        panel2.setLayout(new GridLayout(4, 1));
        txtUser = new JTextField(10);
        txtUser.setPreferredSize(new Dimension(txtUser.getPreferredSize().width, 30));
        txtPass = new JPasswordField(10);
        txtPass.setPreferredSize(new Dimension(txtPass.getPreferredSize().width, 10));
        txtConfirm = new JPasswordField(10);
        txtConfirm.setPreferredSize(new Dimension(txtConfirm.getPreferredSize().width, 10));
        panel1.add(lblUser);
        panel1.add(lblPass);
        panel1.add(lblConfirm);
        panel2.add(txtUser);
        panel2.add(txtPass);
        panel2.add(txtConfirm);
        // add item cho panel 3
        btnSignUp = new JButton("Sign Up");
        btnCancel = new JButton("Cancel");
        panel3.add(btnSignUp);
        panel3.add(btnCancel);
        panel2.add(panel3);
        // event
        btnSignUp.addActionListener((ActionEvent e) -> {
            String user = txtUser.getText();
            String pass = String.valueOf(txtPass.getPassword());
            String confrim = String.valueOf(txtConfirm.getPassword());
            SignUp(user, pass, confrim, f);
        });
        btnCancel.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        // hien thi frame
        f.setLayout(new GridLayout(1, 2));
        f.add(panel1);
        f.add(panel2);
        f.setVisible(true);
    }

    private boolean CheckNull(String user, String password, String confirm, Frame f) {
        if (user.equals("") || password.equals("") || confirm.equals("")) {
            JOptionPane.showMessageDialog(f, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        return true;
    }

    private boolean CheckConfirm(String password, String confirm) {
        return password.equals(confirm);
    }

    private void SignUp(String user, String password, String confirm, Frame f) {
        if (!CheckNull(user, password, confirm, f)) {
            return;
        }
        if (!CheckConfirm(password, confirm)) {
            JOptionPane.showMessageDialog(f, "Mật khẩu không giống nhau");
            return;
        }
        JOptionPane.showMessageDialog(f, "Đăng nhập thành công");
    }

    public static void main(String[] args) {
        new bai3();
    }
}
