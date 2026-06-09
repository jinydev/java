package sec08.exam01_jlist;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JListExample extends JFrame {
    private JPanel pWest;
    private JList<String> listString;
    private JList<ImageIcon> listImage;
    private JLabel jLabel;

    public JListExample() {
        this.setTitle("JListExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        
        this.getContentPane().add(getPWest(), BorderLayout.WEST);
        this.getContentPane().add(getJLabel(), BorderLayout.CENTER);
    }

    public JPanel getPWest() {
        if (pWest == null) {
            pWest = new JPanel(new GridLayout(2, 1));
            pWest.add(new JScrollPane(getListString()));
            pWest.add(new JScrollPane(getListImage()));
        }
        return pWest;
    }

    // 텍스트 리스트
    public JList<String> getListString() {
        if (listString == null) {
            String[] items = { 
                "Cantaloupe", "Grapefruit", "Grapes", "Kiwi", "Peach", 
                "pineapple", "strawberry", "tomato", "watermelon" 
            };
            listString = new JList<>(items);
            
            listString.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int index = listString.getSelectedIndex();
                    // fruit1.jpg ~ fruit9.jpg 로 가정
                    String imgName = "fruit" + (index + 1) + ".jpg";
                    ImageIcon image = new ImageIcon(getClass().getResource(imgName));
                    getJLabel().setIcon(image);
                }
            });
        }
        return listString;
    }

    // 이미지 리스트
    public JList<ImageIcon> getListImage() {
        if (listImage == null) {
            Vector<ImageIcon> items = new Vector<>();
            for (int i = 1; i < 10; i++) {
                items.add(new ImageIcon(getClass().getResource("fruit" + i + ".jpg")));
            }
            listImage = new JList<>(items);
            
            listImage.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    ImageIcon image = listImage.getSelectedValue();
                    getJLabel().setIcon(image);
                }
            });
        }
        return listImage;
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
            JListExample jFrame = new JListExample();
            jFrame.setVisible(true);
        });
    }
}
