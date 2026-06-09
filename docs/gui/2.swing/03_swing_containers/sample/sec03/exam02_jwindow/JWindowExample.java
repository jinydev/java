package sec03.exam02_jwindow;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class JWindowExample extends JWindow {
    public JWindowExample() {
        // JWindow 크기 설정
        this.setSize(600, 350);
        
        // 화면 중앙에 띄우기
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int leftTopX = centerPoint.x - this.getWidth() / 2;
        int leftTopY = centerPoint.y - this.getHeight() / 2;
        this.setLocation(leftTopX, leftTopY);
        
        // 이미지 라벨 추가
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(getClass().getResource("game.png")));
        getContentPane().add(label, BorderLayout.CENTER);
        
        // 클릭 시 종료
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // 윈도우 닫기
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JWindowExample jWindow = new JWindowExample();
            jWindow.setVisible(true);
        });
    }
}
