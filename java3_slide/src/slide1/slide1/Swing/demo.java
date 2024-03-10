package slide1.Swing;

import java.awt.Frame;

import javax.swing.JFrame;

public class demo extends Frame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("demo Jframe");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}