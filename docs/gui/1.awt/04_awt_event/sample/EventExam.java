import java.awt.*;
import java.awt.event.*;

public class EventExam implements ActionListener {
    Frame f;
    Button b;

    public EventExam() {
        f = new Frame("Event Test");
        f.setLayout(new FlowLayout());

        b = new Button("Click Me");
        b.addActionListener(this); // 버튼에 리스너(자기 자신) 등록

        f.add(b);
        f.setSize(300, 200);

        // 사용자가 창을 닫을 수 있도록 닫기 이벤트 추가
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked!");
    }

    public static void main(String[] args) {
        new EventExam();
    }
}
