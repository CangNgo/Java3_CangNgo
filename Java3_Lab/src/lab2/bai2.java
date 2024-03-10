package lab2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class bai2 {
    public bai2() {
        CreateFrame();
    }

    public void CreateFrame() {
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        // khai bao
        JLabel lblBrand, lblDisplay;
        JButton[] btn = new JButton[10];
        JPanel panel1, panel2, panel3, panel4, panel5, panel6;
        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton("" + (i + 1));
        }

        // set layout cho frame
        f.setLayout(new GridLayout(6, 1));

        // add item vao panel
        panel1 = new JPanel(new BorderLayout());
        lblBrand = new JLabel("Casio");
        // lblBrand.setVerticalAlignment(4);
        panel1.add(lblBrand, BorderLayout.SOUTH);
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        // add item vao panel
        f.add(panel1);
        f.add(panel2);
        f.add(panel3);
        f.add(panel4);
        f.add(panel5);
        f.add(panel6);
        // hien thi
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new bai2();
    }
}
