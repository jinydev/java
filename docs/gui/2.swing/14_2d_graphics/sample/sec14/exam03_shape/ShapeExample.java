package sec14.exam03_shape;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ShapeExample extends JFrame {
    public ShapeExample() {
        setTitle("도형 그리기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
        setSize(400, 300);
    }

    class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.setFont(new Font("맑은 고딕", Font.BOLD, 14));
            g.drawString("다양한 도형 그리기", 20, 30);

            g.drawOval(50, 50, 50, 50); // 원
            g.setColor(Color.RED);
            g.drawLine(50, 120, 150, 200); // 선
            g.setColor(Color.BLUE);
            g.drawRoundRect(200, 50, 120, 80, 30, 30); // 둥근 사각형
            g.setColor(Color.GREEN);
            g.fillRect(200, 150, 120, 60); // 채워진 사각형
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeExample().setVisible(true));
    }
}
