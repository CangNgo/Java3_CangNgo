package lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public final class bai1 {
    public bai1() {
        CreateJFrame();
    }

    public void CreateJFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 1));
        // tao panel
        JPanel pnFlowLayout = new JPanel();
        JPanel pnBorderLayout = new JPanel();
        JPanel pnTextfield = new JPanel();
        JPanel pnGridLayout = new JPanel();
        // add component vao panelFlowLayout
        JButton btnRed, btnGreen, btnYellow;
        btnRed = new JButton("Red");
        btnGreen = new JButton("Green");
        btnYellow = new JButton("Yellow");
        pnFlowLayout.setBounds(0, 0, 400, 100);
        pnFlowLayout.setLayout(new FlowLayout(2, 30, 30));
        pnFlowLayout.setBackground(Color.yellow);
        // add btn vao pnflowlayout
        pnFlowLayout.add(btnRed);
        pnFlowLayout.add(btnGreen);
        pnFlowLayout.add(btnYellow);
        // add component vao Borderlayout
        pnBorderLayout.setLayout(new BorderLayout());
        pnBorderLayout.setBounds(0, 0, 400, 100);
        JButton btnNorth, btnWest, btnCenter, btnEast, btnSouth;
        btnNorth = new JButton("North");
        btnWest = new JButton("West");
        btnCenter = new JButton("Center");
        btnEast = new JButton("East");
        btnSouth = new JButton("South");
        pnBorderLayout.add(btnNorth, BorderLayout.NORTH);
        pnBorderLayout.add(btnWest, BorderLayout.WEST);
        pnBorderLayout.add(btnCenter, BorderLayout.CENTER);
        pnBorderLayout.add(btnEast, BorderLayout.EAST);
        pnBorderLayout.add(btnSouth, BorderLayout.SOUTH);
        // Jtext field
        JTextField txtLab3 = new JTextField();
        txtLab3.setPreferredSize(new Dimension(350, 30));
        txtLab3.setForeground(Color.green);
        pnTextfield.add(txtLab3);

        // add grid layout
        pnGridLayout.setBounds(0, 0, 400, 100);
        pnGridLayout.setLayout(new GridLayout(2, 5));
        JButton[] buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            pnGridLayout.add(buttons[i]);
        }
        // add panel vao frame
        frame.add(pnFlowLayout);
        frame.add(pnBorderLayout);
        frame.add(pnTextfield);
        frame.add(pnGridLayout);
        // hien thi frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new bai1();
    }
}

