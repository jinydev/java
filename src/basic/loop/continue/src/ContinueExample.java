public class ContinueExample {
    public static void main(String[] args) {

        System.out.println("컨베이어 벨트 가동! 홀수만 포장합니다.");

        // 1부터 10까지 10번 반복하는 쳇바퀴
        for (int i = 1; i <= 10; i++) {

            // 검사소: 혹시 이 숫자가 2로 나누어 떨어지는 짝수인가?
            if (i % 2 == 0) {
                // 불량품(짝수) 발견! 밑에 포장 코드 무시하고 바로 다음 숫자(i++)로 가라!
                continue;
            }

            // 짝수라면 여기까지 코드가 도달조차 하지 못합니다.
            // 고로 이건 100% 홀수일 때만 실행됩니다!
            System.out.println("📦 포장 완료: " + i);
        }

        System.out.println("공장 가동 종료.");
    }
}
