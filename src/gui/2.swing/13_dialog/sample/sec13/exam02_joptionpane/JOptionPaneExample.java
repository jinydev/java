package sec13.exam02_joptionpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JOptionPaneExample extends JFrame {
    private JButton btnMessage, btnConfirm, btnInput, btnOption;

    public JOptionPaneExample() {
        this.setTitle("JOptionPaneExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(4, 1));
        
        this.getContentPane().add(getBtnMessage());
        this.getContentPane().add(getBtnConfirm());
        this.getContentPane().add(getBtnInput());
        this.getContentPane().add(getBtnOption());
        
        this.setSize(400, 300);
    }

    public JButton getBtnMessage() {
        if (btnMessage == null) {
            btnMessage = new JButton("MessageDialog");
            btnMessage.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    JOptionPaneExample.this,
                    "알림 메시지입니다.",
                    "알림",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });
        }
        return btnMessage;
    }

    public JButton getBtnConfirm() {
        if (btnConfirm == null) {
            btnConfirm = new JButton("ConfirmDialog");
            btnConfirm.addActionListener(e -> {
                int option = JOptionPane.showConfirmDialog(
                    JOptionPaneExample.this,
                    "진행하시겠습니까?",
                    "확인",
                    JOptionPane.OK_CANCEL_OPTION
                );
                
                if (option == JOptionPane.OK_OPTION) {
                    System.out.println("확인 선택");
                } else {
                    System.out.println("취소 선택");
                }
            });
        }
        return btnConfirm;
    }

    public JButton getBtnInput() {
        if (btnInput == null) {
            btnInput = new JButton("InputDialog");
            btnInput.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(
                    JOptionPaneExample.this,
                    "이름을 입력하세요:",
                    "입력",
                    JOptionPane.QUESTION_MESSAGE
                );
                System.out.println("입력값: " + input);
            });
        }
        return btnInput;
    }

    public JButton getBtnOption() {
        if (btnOption == null) {
            btnOption = new JButton("OptionDialog");
            btnOption.addActionListener(e -> {
                String[] options = {"시작", "중지"};
                int choice = JOptionPane.showOptionDialog(
                    JOptionPaneExample.this,
                    "작업을 선택하세요",
                    "옵션",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
                );
                
                if (choice == 0) System.out.println("시작 선택");
                else if (choice == 1) System.out.println("중지 선택");
            });
        }
        return btnOption;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JOptionPaneExample().setVisible(true);
        });
    }
}
