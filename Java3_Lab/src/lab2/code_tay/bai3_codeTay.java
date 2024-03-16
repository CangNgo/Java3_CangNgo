package lab2.code_tay;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class bai3_codeTay {
    public bai3_codeTay() {
        CreateFrame();
    }

    public void CreateFrame() {
        JFrame f = new JFrame();
        f.setTitle("Bài 3");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        f.setLayout(new GridLayout(2, 2));
        // tạo button
        JButton btnMDialog, btnIDiglog, btnCDiglog, btnODiglog;
        btnMDialog = new JButton("Message Dialog");
        btnIDiglog = new JButton("Input Diglog");
        btnCDiglog = new JButton("Confirm Diglog");
        btnODiglog = new JButton("Oprion Diglog");
        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel();
        JPanel pn3 = new JPanel();
        JPanel pn4 = new JPanel();
        pn1.setLayout(new FlowLayout());
        pn2.setLayout(new FlowLayout());
        pn3.setLayout(new FlowLayout());
        pn4.setLayout(new FlowLayout());
        pn1.add(btnMDialog);
        pn2.add(btnIDiglog);
        pn3.add(btnCDiglog);
        pn4.add(btnODiglog);
        f.add(pn1);
        f.add(pn2);
        f.add(pn3);
        f.add(pn4);

        btnMDialog.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Please input your name");
        });
        btnIDiglog.addActionListener((ActionEvent e) -> {
            String name = JOptionPane.showInputDialog(" your name is");
            if (name != null) {
                JOptionPane.showMessageDialog(null, "Your name is " + name);
            }
        });
        btnCDiglog.addActionListener((ActionEvent e) -> {
            int res = JOptionPane.showConfirmDialog(null, "Are you sure", null, JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (res == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Bạn đã chọn yes");
            } else {
                JOptionPane.showMessageDialog(null, "Bạn đã chọn No");
            }
        });
        btnODiglog.addActionListener((ActionEvent e) -> {
            String[] option = { "Java", "C#", "Python", "Ruby", "PHP" };
            int code = JOptionPane.showOptionDialog(null, "Ngôn ngữ của bạn là", "Mời chọn ngôn ngữ của bạn", 0, 0,
                    null, option, e);
            JOptionPane.showMessageDialog(null, "Ngôn ngữ bạn chọn là " + option[code]);
        });
        // hien thi
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new bai3_codeTay();
    }
}
