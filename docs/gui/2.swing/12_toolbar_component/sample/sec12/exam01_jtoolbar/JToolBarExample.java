package sec12.exam01_jtoolbar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.SoftBevelBorder;

public class JToolBarExample extends JFrame {
    private JMenuBar jMenuBar;
    private JToolBar jToolBar;
    private JButton btnNew, btnSave, btnCopy, btnPaste;

    public JToolBarExample() {
        this.setTitle("JToolBarExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        
        this.setJMenuBar(getJMenuBar());
        this.getContentPane().add(getJToolBar(), BorderLayout.NORTH);
    }

    // 메뉴바 생성
    public JMenuBar getJMenuBar() {
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
            jMenuBar.add(new JMenu("파일"));
            jMenuBar.add(new JMenu("도움말"));
        }
        return jMenuBar;
    }

    // 툴바 생성
    public JToolBar getJToolBar() {
        if (jToolBar == null) {
            jToolBar = new JToolBar();
            // 툴바 이동 가능 여부 (false: 고정)
            // jToolBar.setFloatable(false); 
            
            jToolBar.add(getBtnNew());
            jToolBar.add(getBtnSave());
            jToolBar.addSeparator(); // 구분선
            jToolBar.add(getBtnCopy());
            jToolBar.add(getBtnPaste());
        }
        return jToolBar;
    }

    public JButton getBtnNew() {
        if (btnNew == null) {
            btnNew = new JButton();
            // 이미지 아이콘이 있다면 사용 (없으면 텍스트 대체 가능)
            btnNew.setIcon(new ImageIcon(getClass().getResource("new.gif"))); 
            btnNew.setText("New"); // 아이콘 없을 시 텍스트 표시
            btnNew.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
            btnNew.setToolTipText("새로 만들기");
            btnNew.addActionListener(actionListener);
        }
        return btnNew;
    }

    public JButton getBtnSave() {
        if (btnSave == null) {
            btnSave = new JButton();
            btnSave.setIcon(new ImageIcon(getClass().getResource("save.gif")));
            btnSave.setText("Save");
            btnSave.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
            btnSave.setToolTipText("저장");
            btnSave.addActionListener(actionListener);
        }
        return btnSave;
    }

    public JButton getBtnCopy() {
        if (btnCopy == null) {
            btnCopy = new JButton();
            btnCopy.setIcon(new ImageIcon(getClass().getResource("copy.gif")));
            btnCopy.setText("Copy");
            btnCopy.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
            btnCopy.setToolTipText("복사");
            btnCopy.addActionListener(actionListener);
        }
        return btnCopy;
    }

    public JButton getBtnPaste() {
        if (btnPaste == null) {
            btnPaste = new JButton();
            btnPaste.setIcon(new ImageIcon(getClass().getResource("paste.gif")));
            btnPaste.setText("Paste");
            btnPaste.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
            btnPaste.setToolTipText("붙여넣기");
            btnPaste.addActionListener(actionListener);
        }
        return btnPaste;
    }

    // 공통 액션 리스너
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = "";
            if (e.getSource() == btnNew) command = "[새로만들기]";
            else if (e.getSource() == btnSave) command = "[저장]";
            else if (e.getSource() == btnCopy) command = "[복사]";
            else if (e.getSource() == btnPaste) command = "[붙여넣기]";
            
            JOptionPane.showMessageDialog(JToolBarExample.this, command + " 클릭");
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JToolBarExample jFrame = new JToolBarExample();
            jFrame.setVisible(true);
        });
    }
}
