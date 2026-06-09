package sec08.exam02_jcombobox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JComboBoxExample extends JFrame {
    private JPanel pNorth;
    private JComboBox<String> comboString;
    private JComboBox<ImageIcon> comboImage;
    private JLabel jLabel;

    public JComboBoxExample() {
        this.setTitle("JComboBoxExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.getContentPane().setBackground(Color.WHITE);
        
        this.getContentPane().add(getPNorth(), BorderLayout.NORTH);
        this.getContentPane().add(getJLabel(), BorderLayout.CENTER);
    }

    public JPanel getPNorth() {
        if (pNorth == null) {
            pNorth = new JPanel();
            pNorth.setBackground(Color.WHITE);
            pNorth.add(getComboString());
            pNorth.add(getComboImage());
        }
        return pNorth;
    }

    // 텍스트 콤보박스
    public JComboBox<String> getComboString() {
        if (comboString == null) {
            String[] items = { 
                "Cantaloupe", "Grapefruit", "Grapes", "Kiwi", "Peach", 
                "pineapple", "strawberry", "tomato", "watermelon" 
            };
            comboString = new JComboBox<>(items);
            comboString.setBackground(Color.WHITE);
            comboString.addActionListener(e -> {
                int index = comboString.getSelectedIndex();
                String imgName = "fruit" + (index + 1) + ".jpg";
                getJLabel().setIcon(new ImageIcon(getClass().getResource(imgName)));
            });
        }
        return comboString;
    }

    // 이미지 콤보박스
    public JComboBox<ImageIcon> getComboImage() {
        if (comboImage == null) {
            Vector<ImageIcon> vImage = new Vector<>();
            for (int i = 1; i < 10; i++) {
                vImage.add(new ImageIcon(getClass().getResource("fruit" + i + ".jpg")));
            }
            comboImage = new JComboBox<>(vImage);
            comboImage.setBackground(Color.WHITE);
            comboImage.addActionListener(e -> {
                ImageIcon image = (ImageIcon) comboImage.getSelectedItem();
                getJLabel().setIcon(image);
            });
        }
        return comboImage;
    }

    public JLabel getJLabel() {
        if (jLabel == null) {
            jLabel = new JLabel();
            jLabel.setHorizontalAlignment(JLabel.CENTER);
        }
        return jLabel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JComboBoxExample jFrame = new JComboBoxExample();
            jFrame.setVisible(true);
        });
    }
}
