package sec06.exam04_jcheckbox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JCheckBoxExample extends JFrame {
    private JPanel pWest;
    private JCheckBox cbGlasses;
    private JCheckBox cbHair;
    private JLabel lblPicture;

    public JCheckBoxExample() {
        this.setTitle("JCheckBoxExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(getPWest(), BorderLayout.WEST);
        this.getContentPane().add(getLblPicture(), BorderLayout.CENTER);
        this.pack();
    }

    public JPanel getPWest() {
        if (pWest == null) {
            pWest = new JPanel(new GridLayout(2, 1));
            pWest.add(getCbGlasses());
            pWest.add(getCbHair());
        }
        return pWest;
    }

    public JCheckBox getCbGlasses() {
        if (cbGlasses == null) {
            cbGlasses = new JCheckBox("Glasses");
            cbGlasses.addActionListener(actionListener);
        }
        return cbGlasses;
    }

    public JCheckBox getCbHair() {
        if (cbHair == null) {
            cbHair = new JCheckBox("Hair");
            cbHair.addActionListener(actionListener);
        }
        return cbHair;
    }

    public JLabel getLblPicture() {
        if (lblPicture == null) {
            lblPicture = new JLabel();
            lblPicture.setIcon(new ImageIcon(getClass().getResource("geek.gif")));
        }
        return lblPicture;
    }

    // 공통 리스너
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String imageName = "geek";
            
            if (cbGlasses.isSelected()) imageName += "-glasses";
            if (cbHair.isSelected()) imageName += "-hair";
            
            imageName += ".gif";
            
            lblPicture.setIcon(new ImageIcon(getClass().getResource(imageName)));
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JCheckBoxExample jFrame = new JCheckBoxExample();
            jFrame.setVisible(true);
        });
    }
}
