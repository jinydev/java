package sec07.exam03_jtextarea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextAreaExample extends JFrame {
    private JTextArea txtDisplay;
    private JPanel pSouth;
    private JTextField txtInput;
    private JButton btnSend;

    public JTextAreaExample() {
        this.setTitle("JTextAreaExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        
        // 중앙에 스크롤 가능한 JTextArea 배치
        this.getContentPane().add(new JScrollPane(getTxtDisplay()), BorderLayout.CENTER);
        this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
    }

    public JTextArea getTxtDisplay() {
        if (txtDisplay == null) {
            txtDisplay = new JTextArea();
            txtDisplay.setEditable(false); // 읽기 전용
        }
        return txtDisplay;
    }

    public JPanel getPSouth() {
        if (pSouth == null) {
            pSouth = new JPanel(new BorderLayout());
            pSouth.add(getTxtInput(), BorderLayout.CENTER);
            pSouth.add(getBtnSend(), BorderLayout.EAST);
        }
        return pSouth;
    }

    public JTextField getTxtInput() {
        if (txtInput == null) {
            txtInput = new JTextField();
            // Enter키 입력 시 전송 버튼 클릭 효과
            txtInput.addActionListener(e -> getBtnSend().doClick());
        }
        return txtInput;
    }

    public JButton getBtnSend() {
        if (btnSend == null) {
            btnSend = new JButton("전송");
            btnSend.addActionListener(e -> {
                String message = getTxtInput().getText();
                getTxtDisplay().append(message + "\n");
                
                // 스크롤을 맨 아래로 이동
                getTxtDisplay().setCaretPosition(getTxtDisplay().getText().length());
                
                getTxtInput().setText("");
                getTxtInput().requestFocus();
            });
        }
        return btnSend;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTextAreaExample jFrame = new JTextAreaExample();
            jFrame.setVisible(true);
        });
    }
}
