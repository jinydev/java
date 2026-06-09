package sec06.exam03_jradiobutton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class JRadioButtonExample extends JFrame {
    private JPanel radioPanel;
    private JRadioButton rbBird, rbCat;
    private JLabel lblPicture;

    public JRadioButtonExample() {
        setTitle("JRadioButtonExample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(getRadioPanel(), BorderLayout.WEST);
        this.getContentPane().add(getLblPicture(), BorderLayout.CENTER);
        pack();
    }

    public JPanel getRadioPanel() {
        if (radioPanel == null) {
            radioPanel = new JPanel(new GridLayout(2, 1));
            radioPanel.add(getRbBird());
            radioPanel.add(getRbCat());

            // ButtonGroup으로 묶어서 하나만 선택되게 설정
            ButtonGroup group = new ButtonGroup();
            group.add(getRbBird());
            group.add(getRbCat());
        }
        return radioPanel;
    }

    public JRadioButton getRbBird() {
        if (rbBird == null) {
            rbBird = new JRadioButton("Bird");
            rbBird.setSelected(true); // 기본 선택
            rbBird.addActionListener(e -> 
                getLblPicture().setIcon(new ImageIcon(getClass().getResource("Bird.gif")))
            );
        }
        return rbBird;
    }

    public JRadioButton getRbCat() {
        if (rbCat == null) {
            rbCat = new JRadioButton("Cat");
            rbCat.addActionListener(e -> 
                getLblPicture().setIcon(new ImageIcon(getClass().getResource("Cat.gif")))
            );
        }
        return rbCat;
    }

    public JLabel getLblPicture() {
        if (lblPicture == null) {
            lblPicture = new JLabel();
            lblPicture.setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
        }
        return lblPicture;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JRadioButtonExample jFrame = new JRadioButtonExample();
            jFrame.setVisible(true);
        });
    }
}
