/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author acer
 */
public class bai2 extends JFrame {

    public bai2() {
        createFrame();
    }

    public static void AddEvent() {

    }

    private boolean CheckNull(JTextField txtFrist, JTextField txtSecond) {
        if (txtFrist.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập first number");
            return false;
        }
        if (txtSecond.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập second number");
            return false;
        }
        return true;
    }

    private boolean CheckNumber(JTextField txtFrist, JTextField txtSecond) {
        try {
            Double.parseDouble(txtFrist.getText());
        } catch (NumberFormatException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(this, "Xin mời nhập first number là số");
            txtFrist.setText("");
            return false;
        }
        try {
            Double.parseDouble(txtSecond.getText());
        } catch (NumberFormatException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(this, "Xin mời nhập second number là số");
            txtSecond.setText("");
            return false;
        }
        return true;
    }

    public void createFrame() {
        setSize(500, 500);
        setTitle("bai 2");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // khai bao
        JLabel lblFirst, lblSecond, lblResult;
        JTextField txtFirst, textSecond, txtResult;
        JButton btnAdd, btnMinus, btnMulti, btnDiv;

        Panel pn1 = new Panel();
        Panel pn2 = new Panel();
        Panel pn3 = new Panel();
        // tạọ label cho panel
        pn1.setLayout(new GridLayout(4, 1));
        lblFirst = new JLabel("Frist number");
        lblSecond = new JLabel("Second number");
        lblResult = new JLabel("Result");
        pn1.add(lblFirst);
        pn1.add(lblSecond);
        pn1.add(lblResult);
        // tạo textfiled cho panel 2
        pn2.setLayout(new GridLayout(4, 1));
        txtFirst = new JTextField(20);
        textSecond = new JTextField(20);
        txtResult = new JTextField(20);
        // tao button panel 3
        pn3.setLayout(new GridLayout(1, 4));
        btnAdd = new JButton("+");
        btnMinus = new JButton("-");
        btnMulti = new JButton("*");
        btnDiv = new JButton("/");
        // add panel 2
        pn2.add(txtFirst);
        pn2.add(textSecond);
        pn2.add(txtResult);
        pn2.add(pn3);
        // add panel 3
        pn3.add(btnAdd);
        pn3.add(btnMinus);
        pn3.add(btnMulti);
        pn3.add(btnDiv);
        // add vao frame
        add(pn1);
        add(pn2);
        // event
        // add
        btnAdd.addActionListener((ActionEvent e) -> {
            if (!CheckNull(txtFirst, textSecond)) {
                return;
            }
            if (!CheckNumber(txtFirst, textSecond)) {
                return;
            }
            Double first = Double.parseDouble(txtFirst.getText());
            Double second = Double.parseDouble(textSecond.getText());
            txtResult.setText(String.valueOf(first + second));
        });
        // minus
        btnMinus.addActionListener((ActionEvent e) -> {
            if (!CheckNull(txtFirst, textSecond)) {
                return;
            }
            if (!CheckNumber(txtFirst, textSecond)) {
                return;
            }
            Double first = Double.parseDouble(txtFirst.getText());
            Double second = Double.parseDouble(textSecond.getText());
            txtResult.setText(String.valueOf(first - second));
        });
        // multi
        btnMulti.addActionListener((ActionEvent e) -> {
            if (!CheckNull(txtFirst, textSecond)) {
                return;
            }
            if (!CheckNumber(txtFirst, textSecond)) {
                return;
            }
            Double first = Double.parseDouble(txtFirst.getText());
            Double second = Double.parseDouble(textSecond.getText());
            txtResult.setText(String.valueOf(first * second));
        });

        // div
        btnDiv.addActionListener((ActionEvent e) -> {
            if (!CheckNull(txtFirst, textSecond)) {
                return;
            }
            if (!CheckNumber(txtFirst, textSecond)) {
                return;
            }
            Double first = Double.parseDouble(txtFirst.getText());
            Double second = Double.parseDouble(textSecond.getText());
            txtResult.setText(String.valueOf((first * 10 / second) * 0.1));
        });
        // đặt layout
        setLayout(new GridLayout(1, 2));
        setVisible(true);

    }

    public static void main(String[] args) {
        new bai2();
    }
}
