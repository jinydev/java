package sec07.exam02_jtextfield_jpasswordfield;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextFieldJPasswordFieldExample extends JFrame {
    private JTextField txtId;
    private JPasswordField txtPassword;

    public JTextFieldJPasswordFieldExample() {
        this.setTitle("JTextField & JPasswordField");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 100);
        this.getContentPane().setLayout(new GridLayout(2, 2));
        
        this.getContentPane().add(new JLabel("아이디", JLabel.CENTER));
        this.getContentPane().add(getTxtId());
        this.getContentPane().add(new JLabel("패스워드", JLabel.CENTER));
        this.getContentPane().add(getTxtPassword());
    }

    // ID 입력 필드 (KeyListener 예제)
    public JTextField getTxtId() {
        if (txtId == null) {
            txtId = new JTextField();
            txtId.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z) {
                        System.out.println("알파벳 입력됨");
                    } else {
                        System.out.println("알파벳 아님");
                    }
                }
            });
        }
        return txtId;
    }

    // 비밀번호 입력 필드 (ActionListener 예제 - Enter키)
    public JPasswordField getTxtPassword() {
        if (txtPassword == null) {
            txtPassword = new JPasswordField();
            txtPassword.addActionListener(e -> {
                String password = new String(txtPassword.getPassword());
                JOptionPane.showMessageDialog(
                    JTextFieldJPasswordFieldExample.this, 
                    "입력한 패스워드: " + password
                );
            });
        }
        return txtPassword;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTextFieldJPasswordFieldExample jFrame = new JTextFieldJPasswordFieldExample();
            jFrame.setVisible(true);
        });
    }
}
