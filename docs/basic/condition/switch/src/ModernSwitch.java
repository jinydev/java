public class ModernSwitch {
    public static void main(String[] args) {
        String day = "수요일";

        // Java 12+ 화살표 함수형 Switch 문
        // 쉼표(,)를 사용해 여러 조건을 한 줄로 묶고, break 없이 깔끔하게 분기합니다.
        switch (day) {
            case "월요일", "수요일", "금요일" -> System.out.println("헬스장 가는 날 💪");
            case "화요일", "목요일" -> System.out.println("수영장 가는 날 🏊‍♂️");
            case "토요일", "일요일" -> System.out.println("집에서 쉬는 날 🛌");
            default -> System.out.println("잘못된 요일입니다.");
        }
    }
}
