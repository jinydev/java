package basic.reference.src;

public class NullErrorDemo {
    public static void main(String[] args) {

        // 1. String 타입 리모컨을 만들긴 했지만, 아직 아무 글자 TV와 연결하지 않았습니다!
        String str = null;

        System.out.println("프로그램을 시작합니다.");

        // 2. 💣 펑! (연결된 객체가 없는데 리모컨의 length() 버튼을 눌렀습니다!)
        int length = str.length();

        // 3. 위에서 에러가 터지면서 프로그램이 강제 종료되므로, 이 줄은 영원히 출력되지 않습니다.
        System.out.println("글자 수는 " + length + "개 입니다.");
    }
}
