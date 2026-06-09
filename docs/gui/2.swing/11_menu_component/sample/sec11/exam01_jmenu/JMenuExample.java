package sec11.exam01_jmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class JMenuExample extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu menuFile, menuNew, menuHelp;
    private JMenuItem menuItemNewFile, menuItemNewFolder;
    private JMenuItem menuItemOpen, menuItemSave, menuItemExit;
    
    public JMenuExample() {
        this.setTitle("JMenuExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.setJMenuBar(getJMenuBar());
    }

    // JMenuBar 생성
    public JMenuBar getJMenuBar() {
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
            jMenuBar.add(getMenuFile());
            jMenuBar.add(getMenuHelp());
        }
        return jMenuBar;
    }

    // [파일] 메뉴
    public JMenu getMenuFile() {
        if (menuFile == null) {
            menuFile = new JMenu("파일");
            menuFile.add(getMenuNew()); // 서브 메뉴
            menuFile.add(getMenuItemOpen());
            menuFile.add(getMenuItemSave());
            menuFile.add(new JSeparator()); // 구분선
            menuFile.add(getMenuItemExit());
        }
        return menuFile;
    }

    // [도움말] 메뉴
    public JMenu getMenuHelp() {
        if (menuHelp == null) {
            menuHelp = new JMenu("도움말");
        }
        return menuHelp;
    }

    // [파일] -> [새로 만들기] 서브 메뉴
    public JMenu getMenuNew() {
        if (menuNew == null) {
            menuNew = new JMenu("새로 만들기");
            menuNew.add(getMenuItemNewFile());
            menuNew.add(getMenuItemNewFolder());
        }
        return menuNew;
    }

    public JMenuItem getMenuItemNewFile() {
        if (menuItemNewFile == null) {
            menuItemNewFile = new JMenuItem("새 파일");
        }
        return menuItemNewFile;
    }

    public JMenuItem getMenuItemNewFolder() {
        if (menuItemNewFolder == null) {
            menuItemNewFolder = new JMenuItem("새 폴더");
        }
        return menuItemNewFolder;
    }

    public JMenuItem getMenuItemOpen() {
        if (menuItemOpen == null) {
            // 아이콘 포함 (이미지 파일 필요)
            menuItemOpen = new JMenuItem("파일 열기", new ImageIcon(getClass().getResource("open.gif")));
        }
        return menuItemOpen;
    }

    public JMenuItem getMenuItemSave() {
        if (menuItemSave == null) {
            // 체크박스 메뉴 아이템
            menuItemSave = new JCheckBoxMenuItem("파일 저장 (Check)");
            menuItemSave.addActionListener(actionListener);
        }
        return menuItemSave;
    }

    public JMenuItem getMenuItemExit() {
        if (menuItemExit == null) {
            menuItemExit = new JMenuItem("종료");
            menuItemExit.addActionListener(actionListener);
        }
        return menuItemExit;
    }

    // 이벤트 리스너
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menuItemSave) {
                if (menuItemSave.isSelected()) {
                    JOptionPane.showMessageDialog(JMenuExample.this, "저장 기능 활성화");
                } else {
                    JOptionPane.showMessageDialog(JMenuExample.this, "저장 기능 비활성화");
                }
            } else if (e.getSource() == menuItemExit) {
                System.exit(0);
            }
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JMenuExample jFrame = new JMenuExample();
            jFrame.setVisible(true);
        });
    }
}
