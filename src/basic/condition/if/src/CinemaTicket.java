public class CinemaTicket {
    public static void main(String[] args) {
        int age = 25;

        // 나이에 따른 극장 요금 계산 다중 분기 조건문
        if (age < 13) {
            System.out.println("어린이 요금: 7,000원");
        } else if (age < 19) {  // 이미 위에서 13세 미만은 걸러졌으므로 '13세 이상' 조건은 생략 가능
            System.out.println("청소년 요금: 10,000원");
        } else {
            System.out.println("성인 요금: 15,000원");
        }
    }
}
