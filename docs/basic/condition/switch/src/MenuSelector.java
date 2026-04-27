public class MenuSelector {
    public static void main(String[] args) {
        int menuNumber = 2;

        switch (menuNumber) {
            case 1:
                System.out.println("예금 조회를 선택하셨습니다. 💳");
                break;
            case 2:
                System.out.println("현금 출금을 선택하셨습니다. 💵");
                break;
            case 3:
                System.out.println("계좌 이체를 선택하셨습니다. 💸");
                break;
            default:
                System.out.println("잘못된 번호를 입력하셨습니다. ❌");
        }
    }
}
