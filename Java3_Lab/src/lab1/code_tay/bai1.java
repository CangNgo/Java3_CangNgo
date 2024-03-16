package lab1.code_tay;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class bai1 {

    JFrame mainFrame; // khai báo frame
    JPanel ControlPanel; // panel chứa các nút và Label
    JLabel headerLabel, statusLabel;

    public void createFrame() {

        mainFrame = new JFrame("Tieu de Frame");
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        // set layout dang lưới 3 hàng 1 cột
        mainFrame.setLayout(new GridLayout(3, 1));
        // tao ra Jpanel và set layout
        ControlPanel = new JPanel(new FlowLayout());
        ControlPanel.setBorder(new LineBorder(Color.red, 1));

        // tao checkbox
        JCheckBox chkApple = new JCheckBox("Apple"); // nhớ JcheckBox của thư viên Swing moi có hổ tro
        JCheckBox chkMango = new JCheckBox("Mango");
        JCheckBox chkPeer = new JCheckBox("Peer");

        // tao phím tắt
        chkApple.setMnemonic(KeyEvent.VK_A);
        chkMango.setMnemonic(KeyEvent.VK_M);
        chkPeer.setMnemonic(KeyEvent.VK_P);

        // add check box vào Jpanel
        ControlPanel.add(chkApple);
        ControlPanel.add(chkMango);
        ControlPanel.add(chkPeer);

        // viết sự kiện: chkApple.addItemListener(new ItemListener()
        // + (e.getStateChange() == 1 ? "checked" : "unchecked"));/
        chkApple.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Apple dc check " + (e.getStateChange() == 1 ? "Checked" : "Uncheck"));
            }
        });
        // add event Mango
        chkMango.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Mango dc check " + (e.getStateChange() == 1 ? "Checked" : "Uncheck"));
            }
        });
        // add event Peer
        chkPeer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Peer dc check " + (e.getStateChange() == 1 ? "Checked" : "Uncheck"));
            }
        });

        headerLabel = new JLabel("Header", JLabel.CENTER);
        statusLabel = new JLabel("Status", JLabel.CENTER);

        // Jpanel vao Frame
        mainFrame.add(headerLabel);
        mainFrame.add(ControlPanel);
        mainFrame.add(statusLabel);

        mainFrame.setVisible(true);//
    }

    public static void main(String[] args) {
        bai1 b1 = new bai1();
        b1.createFrame();

    }
}