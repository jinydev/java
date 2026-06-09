import java.awt.*;
import java.awt.event.*;

public class LayoutExam {
    public static void main(String[] args) {
        Frame f = new Frame("Calculator Layout");
        f.setSize(300, 400);
        f.setLayout(new BorderLayout()); // 전체적으로 BorderLayout 사용

        // 상단: 결과 표시창 (TextField)
        TextField result = new TextField("0");
        result.setEditable(false); // 사용자가 직접 키보드로 수정하지 못하게 설정
        f.add(result, BorderLayout.NORTH);

        // 중앙: 버튼 배치 (Panel + GridLayout)
        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 3)); // 4행 3열

        // 버튼 클릭 이벤트 리스너 정의
        ActionListener btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equals("*")) {
                    result.setText("0"); // '*' 버튼은 Clear 기능으로 작동
                } else if (cmd.equals("#")) {
                    // '#' 버튼은 간단한 입력 완료 표시 또는 이벤트 유지
                    // 여기서는 누르면 입력 내용을 로그에 출력하거나 유지하도록 처리합니다.
                } else {
                    String current = result.getText();
                    if (current.equals("0")) {
                        result.setText(cmd);
                    } else {
                        result.setText(current + cmd);
                    }
                }
            }
        };

        // 1부터 9까지의 버튼 생성 및 리스너 추가
        for (int i = 1; i <= 9; i++) {
            Button btn = new Button(String.valueOf(i));
            btn.addActionListener(btnListener);
            p.add(btn);
        }

        // *, 0, # 버튼 생성 및 리스너 추가
        Button starBtn = new Button("*");
        starBtn.addActionListener(btnListener);
        p.add(starBtn);

        Button zeroBtn = new Button("0");
        zeroBtn.addActionListener(btnListener);
        p.add(zeroBtn);

        Button hashBtn = new Button("#");
        hashBtn.addActionListener(btnListener);
        p.add(hashBtn);

        f.add(p, BorderLayout.CENTER);

        // 윈도우 닫기(X) 버튼을 눌렀을 때 프로그램이 종료되도록 이벤트 추가
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setVisible(true);
    }
}
