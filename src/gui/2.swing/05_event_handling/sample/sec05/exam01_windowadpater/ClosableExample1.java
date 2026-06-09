package sec05.exam01_windowadpater;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClosableExample1 extends JFrame {
    private JButton btnClose;

    public ClosableExample1() {
        this.setTitle("CloseExample");
        this.setSize(300, 100);
        this.setLayout(new FlowLayout());
        
        this.getContentPane().add(getBtnClose());
        
        // WindowAdapter를 상속받은 클래스 사용
        this.addWindowListener(new MyWindowAdapter());
    }

    private JButton getBtnClose() {
        if(btnClose == null) {
            btnClose = new JButton("닫기");
            // ActionListener를 구현한 클래스 사용
            btnClose.addActionListener(new MyActionListener());
        }
        return btnClose;
    }

    // 내부 클래스로 리스너 정의
    class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClosableExample1 jFrame = new ClosableExample1();
            jFrame.setVisible(true);
        });
    }
}
