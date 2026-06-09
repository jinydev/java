import java.awt.*;
import java.awt.event.*;

public class AnonymousEventExam {
    public static void main(String[] args) {
        Frame f = new Frame("Anonymous Event");
        f.setSize(300, 200);
        f.setLayout(new FlowLayout());

        Button b = new Button("Close Window");

        // 1. 버튼 클릭 처리 (ActionListener)
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close button clicked");
                System.exit(0);
            }
        });

        // 2. 윈도우 'X' 버튼 처리 (WindowListener -> WindowAdapter)
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(b);
        f.setVisible(true);
    }
}
