public class SeasonChecker {
    public static void main(String[] args) {
        int month = 4;

        // 의도적인 폴스루(Fall-through) 기법을 활용한 계절 판독 스위치 문
        switch (month) {
            case 3:
            case 4:  // 4번으로 점프 후, 밑으로 흘러내려가 실행됨!
            case 5:
                System.out.println("따뜻한 봄입니다. 🌱");
                break; // 여기서 탈출!
            
            case 6: case 7: case 8:
                System.out.println("더운 여름입니다. ☀️");
                break;
                
            case 9: case 10: case 11:
                System.out.println("시원한 가을입니다. 🍁");
                break;
                
            case 12: case 1: case 2:
                System.out.println("추운 겨울입니다. ⛄");
                break;
                
            default:
                System.out.println("존재하지 않는 달입니다.");
        }
    }
}
