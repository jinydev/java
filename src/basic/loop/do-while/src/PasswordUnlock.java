import java.util.Scanner;

public class PasswordUnlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPwd;
        String correctPwd = "1234";

        System.out.println("🔒 스마트폰이 잠겨 있습니다.");

        // 일단 묻고 봅니다. (do)
        do {
            System.out.print("비밀번호 4자리를 입력하세요: ");
            inputPwd = scanner.nextLine();

            if (!inputPwd.equals(correctPwd)) {
                System.out.println("❌ 삐빅! 비밀번호가 틀렸습니다. 다시 시도하세요.\n");
            }
        } while (!inputPwd.equals(correctPwd));
        // 👆 입력한 비밀번호가 "1234"가 "아닌 동안" 계속 쳇바퀴를 돕니다.

        // 정답을 맞혀서 while 조건이 False가 되면 이곳으로 탈출!
        System.out.println("🔓 철칵! 잠금이 해제되었습니다 환영합니다!");
        scanner.close(); // 자원 반납
    }
}
