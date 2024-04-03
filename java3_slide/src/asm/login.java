package asm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javafx.geometry.Insets;
import javafx.scene.layout.Border;

import javax.swing.border.EmptyBorder;

public class login {
    public login() {
        CreateJF();
    }

    public void CreateJF() {
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 320);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        // panel login
        JPanel pnLogin = new JPanel();
        TitledBorder ttborderLogin = new TitledBorder("Login");
        pnLogin.setBorder(ttborderLogin);

        pnLogin.setPreferredSize(new Dimension(450, 230));
        pnLogin.setLayout(new BoxLayout(pnLogin, BoxLayout.Y_AXIS));
        // khoi tao bien
        JTextField txtUsername;
        JPasswordField txtPass;
        JLabel lblUsername, lblPass;
        lblUsername = new JLabel("Username");
        lblPass = new JLabel("Password");
        txtUsername = new JTextField();
        txtUsername.setPreferredSize(new Dimension(200, 30));
        txtPass = new JPasswordField();
        txtPass.setPreferredSize(new Dimension(200, 30));
        JPanel pnUer, pnPas;
        // Panel User
        pnUer = new JPanel(new FlowLayout());
        pnUer.setSize(new Dimension(300, 40));
        pnUer.setBorder(new EmptyBorder(20, 0, 0, 0));
        pnUer.add(lblUsername);
        pnUer.add(txtUsername);
        pnLogin.add(pnUer);
        // Panel Pass
        pnPas = new JPanel(new FlowLayout());
        pnUer.setSize(new Dimension(300, 40));
        pnPas.add(lblPass);
        pnPas.add(txtPass);
        pnLogin.add(pnPas);
        // end Panel User

        JPanel pnbtn = new JPanel(new FlowLayout());
        JButton btnLogin, btnCancel;
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
        // di chuyển sang phải
        pnbtn.add(Box.createHorizontalStrut(80));
        pnbtn.add(btnLogin);
        pnbtn.add(btnCancel);

        pnLogin.add(pnbtn);
        // end panel Login
        // hien thi
        frame.add(pnLogin, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
}
