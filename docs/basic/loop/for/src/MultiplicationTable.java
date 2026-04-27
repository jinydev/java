public class MultiplicationTable {
    public static void main(String[] args) {

        // 바깥쪽 쳇바퀴 (시침 역할: 2단 ~ 9단)
        for (int m = 2; m <= 9; m++) {
            System.out.println("\n*** " + m + "단 ***"); // 단이 바뀔 때마다 제목 출력

            // 안쪽 쳇바퀴 (분침 역할: x1 ~ x9) - 바깥쪽 m이 '한 번' 도는 동안 안쪽 n은 '9번'을 돕니다!
            for (int n = 1; n <= 9; n++) {
                // 구구단 계산 및 출력
                System.out.println(m + " x " + n + " = " + (m * n));
            }
        }
    }
}
