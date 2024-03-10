package slide2;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class demo1 extends JFrame {
    public demo1() {
        createJFrame();
    }

    public void createJFrame() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // khai bao element
        JButton btnVN, btnUSA, btnITa;
        Panel panel = new Panel(new GridLayout(1, 1));
        // tao icon
        ImageIcon iconVN = new ImageIcon(getClass().getResource("/slide2/img/VietNam_icon.png"));
        ImageIcon iconUSA = new ImageIcon(getClass().getResource("/slide2/img/usa.jpg"));
        ImageIcon iconIta = new ImageIcon(getClass().getResource("/slide2/img/Italya_icon.png"));
        // tao button
        btnVN = new JButton("VN", iconVN);
        eventAcc(btnVN, "VN");
        btnUSA = new JButton("USA", iconUSA);
        eventAcc(btnUSA, "USA");
        btnITa = new JButton("ITA", iconIta);
        eventAcc(btnITa, "Italya");
        // add panel
        panel.add(btnVN);
        panel.add(btnUSA);
        panel.add(btnITa);
        // add panel vao frame
        add(panel);
        // hien thi frame
        setVisible(true);
    }

    public void eventAcc(JButton btn, String Country) {
        btn.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Ban da chon " + Country);
        });
    }

    public static void main(String[] args) {
        new demo1();
    }
}