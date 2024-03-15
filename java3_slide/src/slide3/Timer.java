package slide3;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer {
    public Timer() {
        CreateJF();
    }

    public void CreateJF() {
        JFrame frame = new JFrame("Timer");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel();
        // tao panel
        pn1.setLayout(new FlowLayout());
        JLabel lblText = new JLabel("Timer");
        pn1.add(lblText);
        pn2.setLayout(new FlowLayout());
        JButton btnStart, btnStop;
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        pn2.add(btnStart);
        pn2.add(btnStop);
        frame.add(pn1);
        frame.add(pn2);

        // event
        btnStart.addActionListener((ActionEvent e) -> {

        });
        btnStop.addActionListener((ActionEvent e) -> {
            System.out.println("Stop");
        });
        // hien thi
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Timer();
    }

}
