import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🤖 자판기 전원이 켜졌습니다.");

        while (true) {
            System.out.print("커피를 뽑으시겠습니까? (네/종료): ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("🛑 자판기 영업을 종료합니다.");
                break; // 쳇바퀴 탈출!
            }

            if (command.equals("네")) {
                System.out.println("☕ 따뜻한 커피가 나왔습니다!\n");
            } else {
                System.out.println("잘못된 입력입니다.\n");
            }
        }

        System.out.println("기계가 완전히 꺼졌습니다.");
        scanner.close();
    }
}
