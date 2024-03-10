/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the  emplate in the editor.
 */
package slide1.Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Jpanel_Layout extends JFrame {// kế thừa mình tạo frame.

    public Jpanel_Layout() {
        initComponets();

    }

    public void initComponets() {// b1
        setTitle("VD ve Jpanel");// set tieu de this cua frame này
        this.setSize(700, 500);// độ rộng frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // nhấn x tắt
        // b2 tao đối tương con thuộc Container(Jpanel là Container đặc biệt gắn các
        // thành phần vào thông getContentPane()
        Container con = getContentPane();
        con.setLayout(new BorderLayout());// BorderLayout() set layout theo Eat,west,south,norht

        // Tao các Jpanel
        Panel pnl1 = new Panel();
        pnl1.setBackground(Color.red);
        JButton btn1 = new JButton("Phải");
        pnl1.add(btn1);
        con.add(pnl1, BorderLayout.EAST);

        Panel pnl2 = new Panel();
        pnl2.setBackground(Color.blue);
        JButton btn2 = new JButton("Trai");
        pnl2.add(btn2);
        con.add(pnl2, BorderLayout.WEST);

        Panel pnl3 = new Panel();
        pnl3.setBackground(Color.YELLOW);
        JButton btn3 = new JButton("Duoi");
        pnl3.add(btn3);
        con.add(pnl3, BorderLayout.SOUTH);

        Panel pnl4 = new Panel();
        pnl4.setBackground(Color.GRAY);
        JButton btn4 = new JButton("tren");
        pnl4.add(btn4);
        con.add(pnl4, BorderLayout.NORTH);

        Panel pnl5 = new Panel();
        pnl5.setBackground(Color.ORANGE);
        JButton btn5 = new JButton("Giữa");
        pnl5.add(btn5);
        con.add(pnl5, BorderLayout.CENTER);
        // cho frame hiên len
        this.setVisible(true);
        this.setLocationRelativeTo(null); // hien chính giữa

    }

    public static void main(String[] args) {
        new Jpanel_Layout();
    }
}