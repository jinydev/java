package sec03.exam03_jframe;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExample extends JFrame {
    public JFrameExample() {
        this.setSize(600, 500);
        
        // 아이콘 및 제목 설정
        this.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        this.setTitle("메인창");
        
        // 종료 동작 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 화면 중앙 배치
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        this.setLocation(centerPoint.x - this.getWidth()/2, centerPoint.y - this.getHeight()/2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrameExample jFrame = new JFrameExample();
            jFrame.setVisible(true);
        });
    }
}
