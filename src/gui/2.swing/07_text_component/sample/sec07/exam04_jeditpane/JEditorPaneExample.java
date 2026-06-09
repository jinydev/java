package sec07.exam04_jeditpane;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;

public class JEditorPaneExample extends JFrame {
    private JEditorPane jEditorPane;

    public JEditorPaneExample() {
        this.setTitle("JEditorPaneExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.getContentPane().add(new JScrollPane(getJEditorPane()), BorderLayout.CENTER);
    }

    public JEditorPane getJEditorPane() {
        if(jEditorPane == null) {
            jEditorPane = new JEditorPane();
            jEditorPane.setEditable(false); // 읽기 전용 (HTML 뷰어)
            
            try {
                // 같은 패키지 내의 jeditorpane.html 파일 로딩
                jEditorPane.setPage(getClass().getResource("jeditorpane.html"));
            } catch(Exception e) {
                e.printStackTrace();
            }

            // 하이퍼링크 클릭 이벤트 처리
            jEditorPane.addHyperlinkListener(e -> {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        jEditorPane.setPage(e.getURL());
                    } catch(IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            });
        }
        return jEditorPane;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JEditorPaneExample jFrame = new JEditorPaneExample();
            jFrame.setVisible(true);
        });
    }
}
