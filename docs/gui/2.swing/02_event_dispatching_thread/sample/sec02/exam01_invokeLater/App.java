package sec02.exam01_invokeLater;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App extends JFrame {
    public App() {
        // 제목 설정
        setTitle("Swing App");
        // 윈도우 크기 설정
        setSize(300, 100);
        
        // 윈도우 종료 버튼을 클릭하면 프로세스 종료
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // 이벤트 큐에 Runnable 넣기
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 윈도우 생성 및 출력 (EDT에서 실행됨)
                App app = new App();
                app.setVisible(true);
                
                // 현재 스레드 이름 출력 -> AWT-EventQueue-0 (EDT) 확인
                System.out.println(Thread.currentThread().getName());
            }
        });
    }
}
