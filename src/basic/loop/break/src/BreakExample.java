public class BreakExample {
    public static void main(String[] args) {

        System.out.println("주사위를 무한히 던집니다. 6이 나오면 탈출합니다!");

        while (true) { // 무한 쳇바퀴 가동!
            int num = (int) (Math.random() * 6) + 1;
            System.out.println("나온 숫자: " + num);

            // 탈출 조건 감시역
            if (num == 6) {
                System.out.println("🚨 6이 나와서 루프를 탈출합니다! (Break 발동)");
                break; // 이 순간, 즉시 가장 가까운 '}' 밖으로 순간이동!
            }

            // 만약 6이 안 나왔다면 아래 코드가 실행되면서 다시 위로 올라감
            System.out.println("다음 주사위를 준비합니다...\n");
        } // <- 이 중괄호 벽을 부수고 나감!

        // 탈출 성공 후 도착하는 곳
        System.out.println("프로그램을 안전하게 종료합니다.");
    }
}
