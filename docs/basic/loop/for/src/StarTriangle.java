public class StarTriangle {
    public static void main(String[] args) {
        // 바깥쪽 루프: 총 5줄(행)을 만듭니다.
        for (int i = 1; i <= 5; i++) {

            // 안쪽 루프: 현재 줄 번호(i)만큼 별을 찍습니다.
            // 1번째 줄은 1개, 2번째 줄은 2개...
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); // ln이 빠진 print를 써서 옆으로 이어 붙입니다.
            }

            System.out.println(); // 다 찍었으면 다음 줄로!
        }
    }
}
