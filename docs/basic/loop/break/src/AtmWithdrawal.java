public class AtmWithdrawal {
    public static void main(String[] args) {
        int balance = 10000; // 초기 잔액 만원
        int withdrawAmount = 3000; // 1회 출금액 삼천원

        System.out.println("통장 잔액: " + balance + "원");

        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "회차 출금 시도 중...");

            // 위험 감지! 돈이 모자라면 즉시 루프 파괴!
            if (balance < withdrawAmount) {
                System.out.println("🚨 삐빅! 잔액이 부족하여 더 이상 출금할 수 없습니다!");
                break; // 남은 횟수 상관없이 무조건 쳇바퀴 밖으로 튕겨나감!
            }

            balance -= withdrawAmount;
            System.out.println("출금 성공! 남은 잔액: " + balance + "원\n");
        }

        System.out.println("출금 처리가 모두 종료되었습니다.");
    }
}
