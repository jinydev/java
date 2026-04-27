public class StarRightTriangle {
    public static void main(String[] args) {
        // 총 5줄
        for (int i = 1; i <= 5; i++) {

            // 1. 공백 찍기 루프: 점점 줄어들어야 합니다. (4, 3, 2, 1, 0)
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            // 2. 별 찍기 루프: 점점 늘어나야 합니다. (1, 2, 3, 4, 5)
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            // 3. 줄바꿈
            System.out.println();
        }
    }
}
