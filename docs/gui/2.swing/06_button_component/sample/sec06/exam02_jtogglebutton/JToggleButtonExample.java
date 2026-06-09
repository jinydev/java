package sec06.exam02_jtogglebutton;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class JToggleButtonExample extends JFrame {
    private JPanel pFirst, pSecond;
    private JToggleButton tbOnOff, tbStart, tbStop;

    public JToggleButtonExample() {
        this.setTitle("JToggleButtonExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(getPFirst());
        this.getContentPane().add(getPSecond());
        this.pack();
    }

    public JPanel getPFirst() {
        if(pFirst == null) {
            pFirst = new JPanel();
            pFirst.add(getTbOnOff());
        }
        return pFirst;
    }

    public JPanel getPSecond() {
        if(pSecond == null) {
            pSecond = new JPanel();
            pSecond.setBorder(new TitledBorder("원하는 기능은?"));
            pSecond.add(getTbStart());
            pSecond.add(getTbStop());

            // 배타적 선택을 위한 ButtonGroup 생성
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getTbStart());
            buttonGroup.add(getTbStop());
        }
        return pSecond;
    }

    // On/Off 토글 버튼
    public JToggleButton getTbOnOff() {
        if(tbOnOff == null) {
            tbOnOff = new JToggleButton("On");
            tbOnOff.addItemListener(e -> {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    tbOnOff.setText("Off");
                } else {
                    tbOnOff.setText("On");
                }
            });
        }
        return tbOnOff;
    }

    // Start 토글 버튼
    public JToggleButton getTbStart() {
        if(tbStart == null) {
            tbStart = new JToggleButton("Start", new ImageIcon(getClass().getResource("start.gif")));
            tbStart.addActionListener(e -> JOptionPane.showMessageDialog(this, "Start"));
        }
        return tbStart;
    }

    // Stop 토글 버튼
    public JToggleButton getTbStop() {
        if(tbStop == null) {
            tbStop = new JToggleButton("Stop", new ImageIcon(getClass().getResource("stop.gif")));
            tbStop.addActionListener(e -> JOptionPane.showMessageDialog(this, "Stop"));
        }
        return tbStop;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JToggleButtonExample jFrame = new JToggleButtonExample();
            jFrame.setVisible(true);
        });
    }
}
