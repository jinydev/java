package sec04.exam06_nulllayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class NullLayoutExample extends JFrame {
    private JButton btnOk;

    public NullLayoutExample() {
        this.setTitle("NullLayoutExample");
        this.setSize(300, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // NullLayout 설정
        this.getContentPane().setLayout(null);
        this.getContentPane().add(getBtnOk());
    }

    public JButton getBtnOk() {
        if(btnOk == null) {
            btnOk = new JButton("확인");
            // 절대 위치 및 크기 설정
            btnOk.setBounds(100, 50, 70, 60);
        }
        return btnOk;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NullLayoutExample jFrame = new NullLayoutExample();
            jFrame.setVisible(true);
        });
    }
}
