public class Summation {
    public static void main(String[] args) {
        int sum = 0; // 누적해서 더할 지갑을 준비합니다.

        // 1부터 10까지 10번 반복합니다.
        for (int i = 1; i <= 10; i++) {
            sum = sum + i; // 또는 sum += i; (현재 지갑 돈에 새로운 i 값을 더해서 다시 지갑에 넣음)
            // System.out.println(i + "를 더했습니다. 현재 합계: " + sum); // 궁금하면 주석을 풀어보세요!
        }

        System.out.println("1부터 10까지의 총합은: " + sum);
    }
}
