import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;

public class AwtExample {
    public static void main(String[] args) {
        // 1. 프레임(윈도우) 생성
        Frame f = new Frame("Hello AWT");

        // 2. 레이아웃 설정 (컴포넌트 배치 방식)
        f.setLayout(new FlowLayout());

        // 3. 버튼 생성 및 추가
        Button b = new Button("Click Me");
        f.add(b);

        // 4. 프레임 크기 설정 및 보이기
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
