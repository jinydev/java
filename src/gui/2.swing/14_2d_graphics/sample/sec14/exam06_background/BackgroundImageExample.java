package sec14.exam06_background;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BackgroundImageExample extends JFrame {
    public BackgroundImageExample() {
        setTitle("JPanel 배경 이미지 넣기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new MyPanel(), BorderLayout.CENTER);
        setSize(400, 300);
    }

    class MyPanel extends JPanel {
        private Image bgImage;

        public MyPanel() {
            setLayout(null);
            // 리소스 로드
            bgImage = new ImageIcon(getClass().getResource("bg.jpg")).getImage();
            
            // 자식 컴포넌트 추가
            JButton button = new JButton("버튼");
            button.setBounds(150, 120, 100, 30);
            add(button);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // 기본 그리기 수행
            if (bgImage != null) {
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this); // 배경 그리기
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BackgroundImageExample().setVisible(true));
    }
}
