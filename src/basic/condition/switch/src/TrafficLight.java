public class TrafficLight {
    public static void main(String[] args) {
        String color = "초록";

        switch (color) {
            case "빨강":
                System.out.println("정지하세요. 🛑");
                break;
            case "노랑":
                System.out.println("주의하세요. ⚠️");
                break;
            case "초록":
                System.out.println("출발하세요. 🟢");
                break;
            default:
                System.out.println("잘못된 신호입니다. ❓");
        }
    }
}
