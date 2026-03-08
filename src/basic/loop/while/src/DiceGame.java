public class DiceGame {
    public static void main(String[] args) {
        int dice = 0; // 아직 안 던짐

        System.out.println("주사위 놀이를 시작합니다. 6이 나오면 끝납니다!");

        // dice가 6이 아닌 "동안(while)" 계속 반복합니다.
        // 횟수를 예측할 수 없기 때문에 while 문이 아주 적합합니다.
        while (dice != 6) {
            // 자바에서 1~6의 랜덤 주사위 굴리기
            dice = (int) (Math.random() * 6) + 1;
            System.out.println("주사위를 굴렸습니다. 나온 눈: " + dice);
        }

        // 루프를 탈출했다는 것은, 조건식(dice != 6)이 드디어 거짓이 되었다 = 즉 dice가 6이라는 뜻!
        System.out.println("🎉 축하합니다! 드디어 6이 나왔습니다!");
    }
}
