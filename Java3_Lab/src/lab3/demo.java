package lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class demo {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Tạo JButton cho mỗi vị trí của BorderLayout
        JButton btnNorth = new JButton("North");
        JButton btnSouth = new JButton("South");
        JButton btnEast = new JButton("East");
        JButton btnWest = new JButton("West");
        JButton btnCenter = new JButton("Center");

        // Tạo BorderLayout
        BorderLayout borderLayout = new BorderLayout();

        // Đặt BorderLayout cho JFrame
        frame.setLayout(borderLayout);

        // Thêm các JButton vào các vị trí của BorderLayout
        frame.add(btnNorth, BorderLayout.NORTH);
        frame.add(btnSouth, BorderLayout.SOUTH);
        frame.add(btnEast, BorderLayout.EAST);
        frame.add(btnWest, BorderLayout.WEST);
        frame.add(btnCenter, BorderLayout.CENTER);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
