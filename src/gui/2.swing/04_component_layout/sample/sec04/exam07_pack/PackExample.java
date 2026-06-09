package sec04.exam07_pack;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PackExample extends JFrame {
    private JButton btnOk;
    private JButton btnCancel;

    public PackExample() {
        this.setTitle("PackExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new FlowLayout());
        this.getContentPane().add(getBtnOk());
        this.getContentPane().add(getBtnCancel());
        
        // 내부 컴포넌트 크기에 맞게 윈도우 크기 자동 조절
        this.pack();
    }

    private JButton getBtnOk() {
        if(btnOk == null) {
            btnOk = new JButton("확인");
        }
        return btnOk;
    }

    private JButton getBtnCancel() {
        if(btnCancel == null) {
            btnCancel = new JButton("취소");
        }
        return btnCancel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PackExample jFrame = new PackExample();
            jFrame.setVisible(true);
        });
    }
}
