public class VendingPrice {
    public static void main(String[] args) {
        String drink = "콜라";

        // 우와! switch 문 전체가 마치 하나의 '값'처럼 취급되어 price 변수에 쏙 들어갑니다.
        // System.out.println을 쓰지 않고 화살표 우측에 '값'만 적어냅니다.
        int price = switch (drink) {
            case "콜라", "사이다" -> 1500;
            case "환타" -> 1200;
            default -> 0;
        }; // 주의! 변수에 대입하는 것이므로 switch 끝 중괄호 뒤에 세미콜론(;)이 필수입니다!

        System.out.println("선택하신 " + drink + "의 가격은 " + price + "원 입니다.");
    }
}
