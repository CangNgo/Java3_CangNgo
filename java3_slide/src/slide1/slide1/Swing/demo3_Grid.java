package slide1.Swing;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Hay tạo 10 button trong 1 panel theo dạng gridLayout

public class demo3_Grid {
    public static void main(String[] args) {
        // b1 Tao Frame
        JFrame f = new JFrame("JPanel - Fpoly");
        f.setLocation(200, 200);
        f.setSize(400, 200);
        // b2 Tao panel theo dang chỉ định lưới
        // JPanel p = new JPanel();// tao đối tượng măc diinh
        /*
         * GridLayout : la bố trí vào lưới với các CỘt và các Hàng --> thêm jpannel từ
         * trái ->sang
         * Trên ->Xuống dưới
         */
        JPanel p = new JPanel(new GridLayout(3, 3)); // thiết lap hiện lên 3 hàng 3 cot
        JButton buttons[] = new JButton[9]; // mãng nút
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            p.add(buttons[i]);
        }
        f.add(p);// add panel vao Frame
        f.setVisible(true); // cho frame hiên lên
    }

}