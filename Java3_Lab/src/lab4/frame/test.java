package lab4.frame;

import javax.swing.JFrame;

public class test extends JFrame {
    public test() {
        creteFrame();
    }

    public void creteFrame() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new test();

    }
}
