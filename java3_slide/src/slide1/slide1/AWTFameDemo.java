package slide1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * AWTFameDemo
 */
public class AWTFameDemo extends Frame implements ActionListener {
    Button btnred, btnblue;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public AWTFameDemo(String title) {
        super(title);
        btnred = new Button("red");
        btnblue = new Button("blue");

        setLayout(new FlowLayout());
        add(btnred);
        add(btnblue);
        setLocationRelativeTo(null);
        btnred.addActionListener(this);
        btnblue.addActionListener(this);
    }

    public static void main(String[] args) {
        AWTFameDemo demo = new AWTFameDemo("Cang");
        demo.setSize(600, 500);
        demo.setVisible(true);
        demo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }
}