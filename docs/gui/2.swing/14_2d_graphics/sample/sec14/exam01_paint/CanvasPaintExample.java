package sec14.exam01_paint;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CanvasPaintExample extends JFrame {
    public CanvasPaintExample() {
        setTitle("paint() 메서드 호출 시점");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
        setSize(300, 200);
    }

    // 사용자 정의 Canvas
    class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawString("윈도우 크기를 변경해보세요", 50, 80);
            System.out.println("paint() 메서드 실행");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CanvasPaintExample().setVisible(true);
        });
    }
}
