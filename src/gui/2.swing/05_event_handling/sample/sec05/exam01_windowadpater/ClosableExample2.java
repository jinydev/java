package sec05.exam01_windowadpater;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClosableExample2 extends JFrame {
    private JButton btnClose;

    public ClosableExample2() {
        this.setTitle("CloseExample");
        this.setSize(300, 100);
        this.setLayout(new FlowLayout());
        this.getContentPane().add(getBtnClose());
        
        // 익명 객체로 WindowListener 구현
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private JButton getBtnClose() {
        if(btnClose == null) {
            btnClose = new JButton("닫기");
            
            // 익명 객체로 ActionListener 구현
            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return btnClose;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClosableExample2 jFrame = new ClosableExample2();
            jFrame.setVisible(true);
        });
    }
}
