import java.awt.*;

public class ComponentExam {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        f.setLayout(new FlowLayout()); // 컴포넌트를 순서대로 배치

        Label idLabel = new Label("ID :");
        TextField idText = new TextField(20);
        
        Label pwLabel = new Label("PW :");
        TextField pwText = new TextField(20);
        pwText.setEchoChar('*'); // 비밀번호 가리기

        Button loginBtn = new Button("Login");

        f.add(idLabel);
        f.add(idText);
        f.add(pwLabel);
        f.add(pwText);
        f.add(loginBtn);

        f.setVisible(true);
    }
}
