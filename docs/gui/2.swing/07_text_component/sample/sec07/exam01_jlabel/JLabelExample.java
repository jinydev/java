package sec07.exam01_jlabel;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

public class JLabelExample extends JFrame {
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4;

    public JLabelExample() {
        this.setTitle("JLabelExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 300);
        this.getContentPane().setLayout(new GridLayout(4, 1));

        this.getContentPane().add(getJLabel1());
        this.getContentPane().add(getJLabel2());
        this.getContentPane().add(getJLabel3());
        this.getContentPane().add(getJLabel4());
    }

    // 1. 텍스트만 + 좌측 정렬 + 테두리
    public JLabel getJLabel1() {
        if (jLabel1 == null) {
            jLabel1 = new JLabel("JLabel1");
            jLabel1.setHorizontalAlignment(JLabel.LEFT);
            jLabel1.setBorder(new EtchedBorder());
        }
        return jLabel1;
    }

    // 2. 텍스트 + 이미지 + 중앙 정렬
    public JLabel getJLabel2() {
        if (jLabel2 == null) {
            jLabel2 = new JLabel("JLabel2");
            jLabel2.setIcon(new ImageIcon(getClass().getResource("user.gif")));
            jLabel2.setHorizontalAlignment(JLabel.CENTER);
            jLabel2.setBorder(new EtchedBorder());
        }
        return jLabel2;
    }

    // 3. 이미지 왼쪽에 텍스트 배치
    public JLabel getJLabel3() {
        if (jLabel3 == null) {
            jLabel3 = new JLabel("JLabel3");
            jLabel3.setIcon(new ImageIcon(getClass().getResource("user.gif")));
            jLabel3.setHorizontalAlignment(JLabel.CENTER);
            jLabel3.setHorizontalTextPosition(JLabel.LEFT);
            jLabel3.setBorder(new EtchedBorder());
        }
        return jLabel3;
    }

    // 4. 아이콘과 텍스트 간격 조정
    public JLabel getJLabel4() {
        if (jLabel4 == null) {
            jLabel4 = new JLabel("JLabel4");
            jLabel4.setIcon(new ImageIcon(getClass().getResource("user.gif")));
            jLabel4.setHorizontalAlignment(JLabel.CENTER);
            jLabel4.setIconTextGap(20);
            jLabel4.setBorder(new EtchedBorder());
        }
        return jLabel4;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JLabelExample jFrame = new JLabelExample();
            jFrame.setVisible(true);
        });
    }
}
