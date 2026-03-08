public class GradeComment {
    public static void main(String[] args) {
        char score = 'A';

        switch (score) {
            case 'A' -> {
                // 실행할 코드가 2줄 이상일 때는 이렇게 중괄호 {} 로 묶어줍니다!
                System.out.println("최고의 성적입니다! 🏆");
                System.out.println("장학금 대상자로 선정되셨습니다.");
            }
            case 'B' -> System.out.println("참 잘했어요. 👏");
            default -> System.out.println("조금 더 노력해 봐요. 🏃‍♂️");
        }
    }
}
