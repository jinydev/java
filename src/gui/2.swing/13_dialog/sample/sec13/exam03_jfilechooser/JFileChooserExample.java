package sec13.exam03_jfilechooser;

import java.awt.GridLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserExample extends JFrame {
    private JButton btnOpen, btnSave;

    public JFileChooserExample() {
        setTitle("JFileChooserExample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        
        add(getBtnOpen());
        add(getBtnSave());
        setSize(300, 200);
    }

    public JButton getBtnOpen() {
        if (btnOpen == null) {
            btnOpen = new JButton("Open File");
            btnOpen.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("텍스트 파일 (*.txt)", "txt"));
                
                int option = fileChooser.showOpenDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    System.out.println("여는 파일: " + file.getAbsolutePath());
                }
            });
        }
        return btnOpen;
    }

    public JButton getBtnSave() {
        if (btnSave == null) {
            btnSave = new JButton("Save File");
            btnSave.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    System.out.println("저장할 파일: " + file.getAbsolutePath());
                }
            });
        }
        return btnSave;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JFileChooserExample().setVisible(true));
    }
}
