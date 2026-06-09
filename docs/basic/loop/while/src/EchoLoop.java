import java.util.Scanner;

public class EchoLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🤖 앵무새 봇이 켜졌습니다. (끝내려면 '종료' 입력)");

        // 의도적인 무한 루프 시작!
        while (true) {
            System.out.print("당신: ");
            String input = scanner.nextLine(); // 키보드 입력 대기

            // 탈출 조건 검사!
            if (input.equals("종료")) {
                System.out.println("🤖 앵무새 봇이 잠듭니다...");
                break; // 쳇바퀴를 강제로 부수고 루프 바깥으로 탈출합니다!
            }

            // 탈출하지 않았다면 메아리 치기
            System.out.println("앵무새: " + input);
        }

        // break를 만나면 코드가 이쪽으로 건너뜁니다.
        System.out.println("프로그램이 완전히 종료되었습니다.");
        scanner.close(); // 자원 반납
    }
}
