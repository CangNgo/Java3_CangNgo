
package lab4.code_tay;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class bai1 extends JFrame {
    public bai1() {
        CreaetJF();
    }

    public void CreaetJF() {
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // tao cac bien can thiet cho frame

        // tao menubar
        JMenuBar menubar = new JMenuBar();
        // tao menu
        JMenu menuFile = new JMenu("FIle");
        JMenu menuColor = new JMenu("Color");
        JMenu menuSystem = new JMenu("System");
        // tao menu item
        JMenuItem menuNew = new JMenuItem("New");
        JMenuItem menuOpen = new JMenuItem("Open");
        JMenuItem menuSave = new JMenuItem("Save");
        // tao radio button item
        JRadioButtonMenuItem rdoRedMenu = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem rdoGreenMenu = new JRadioButtonMenuItem("Green");
        JRadioButtonMenuItem rdoBlueMenu = new JRadioButtonMenuItem("Blue");
        JCheckBoxMenuItem chkTextColorMenu = new JCheckBoxMenuItem("Text color");
        ButtonGroup btgColor = new ButtonGroup();
        btgColor.add(rdoRedMenu);
        btgColor.add(rdoGreenMenu);
        btgColor.add(rdoBlueMenu);

        // add menu vao menubar
        menubar.add(menuFile);
        menubar.add(menuColor);
        menubar.add(menuSystem);
        // add menu item vao menu
        menuFile.add(menuNew);
        menuFile.add(menuOpen);
        menuFile.add(menuSave);
        // add radio button item vao menu
        menuColor.add(rdoRedMenu);
        menuColor.add(rdoGreenMenu);
        menuColor.add(rdoBlueMenu);
        menuColor.addSeparator();
        menuColor.add(chkTextColorMenu);
        // tao jtextField
        JTextField txtColor = new JTextField(30);
        txtColor.setPreferredSize(new Dimension(300, 40));
        Font f = new Font("Arial", ABORT, 34);
        txtColor.setFont(f);
        txtColor.setBorder(new EmptyBorder(0, 30, 0, 20));
        txtColor.setText("Test Color");
        txtColor.setCaretPosition(txtColor.getText().length());
        // tao text area
        JPanel pnCenter = new JPanel();
        pnCenter.setBorder(new EmptyBorder(30, 10, 30, 10));
        JTextArea txtNote = new JTextArea(30, 10);
        txtNote.setBorder(new EmptyBorder(30, 10, 30, 10));
        pnCenter.add(txtNote);

        // Su ly su kien
        rdoRedMenu.addActionListener((ActionEvent e) -> {
            txtColor.setForeground(Color.RED);
        });
        rdoBlueMenu.addActionListener((ActionEvent e) -> {
            txtColor.setForeground(Color.BLUE);
        });
        rdoGreenMenu.addActionListener((ActionEvent e) -> {
            txtColor.setForeground(Color.GREEN);
        });

        // add menu
        // add vao frame
        setLayout(new BorderLayout());
        add(menubar, BorderLayout.NORTH);
        add(txtNote, BorderLayout.CENTER);
        add(txtColor, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        bai1 b1 = new bai1();
        b1.setVisible(true);

    }

}