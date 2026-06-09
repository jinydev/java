package sec14.exam02_repaint;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RepaintExample extends JFrame {
    public RepaintExample() {
        setTitle("재 드로잉");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
        setSize(500, 400);
    }

    class MyCanvas extends Canvas implements MouseMotionListener {
        private int x, y;

        public MyCanvas() {
            addMouseMotionListener(this);
        }

        @Override
        public void update(Graphics g) {
            paint(g); // 화면 지우기 생략
        }

        @Override
        public void paint(Graphics g) {
            g.drawString("*", x, y);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint(); // 다시 그리기 요청
        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RepaintExample().setVisible(true));
    }
}
