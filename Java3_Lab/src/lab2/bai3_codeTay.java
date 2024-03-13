package lab2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        JPanel pn = new JPanel();
        pn.setLayout(new GridLayout(2, 2));
        pn.add(btnMDialog);
        pn.add(btnIDiglog);
        pn.add(btnCDiglog);
        pn.add(btnODiglog);
        f.add(pn);

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
