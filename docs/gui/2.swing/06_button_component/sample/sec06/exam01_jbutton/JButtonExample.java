package sec06.exam01_jbutton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JButtonExample extends JFrame {
    private JButton btn1, btn2, btn3;

    public JButtonExample() {
        this.setTitle("JButtonExample");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(getBtn1());
        this.getContentPane().add(getBtn2());
        this.getContentPane().add(getBtn3());
    }

    // 텍스트 버튼
    public JButton getBtn1() {
        if(btn1 == null) {
            btn1 = new JButton("새문서");
            btn1.addActionListener(e -> {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(JButtonExample.this);
            });
        }
        return btn1;
    }

    // 이미지 버튼
    public JButton getBtn2() {
        if(btn2 == null) {
            btn2 = new JButton();
            btn2.setIcon(new ImageIcon(getClass().getResource("new.gif")));
            btn2.addActionListener(e -> {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(JButtonExample.this);
            });
        }
        return btn2;
    }

    // 텍스트 + 이미지 버튼
    public JButton getBtn3() {
        if(btn3 == null) {
            btn3 = new JButton("새문서", new ImageIcon(getClass().getResource("new.gif")));
            btn3.addActionListener(e -> {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(JButtonExample.this);
            });
        }
        return btn3;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JButtonExample jFrame = new JButtonExample();
            jFrame.setVisible(true);
        });
    }
}
