public class FloatCounter {
    public static void main(String[] args) {
        System.out.println("0.1씩 증가시키며 1.0 이하일 때까지 반복합니다.");

        // 주의: 절대 실무에서 이렇게 루프 카운터를 float로 잡지 마세요!
        for (float x = 0.1f; x <= 1.0f; x += 0.1f) {
            System.out.println("현재 x의 값: " + x);
        }
    }
}
