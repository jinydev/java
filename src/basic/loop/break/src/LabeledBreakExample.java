public class LabeledBreakExample {
    public static void main(String[] args) {

        System.out.println("경찰 몽타주 수색을 시작합니다.");

        // 🏷️ 바깥쪽 루프 전체에 "SearchLabel" 이라는 이름(레이블)표를 답니다!
        SearchLabel: for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {
                System.out.println("수색 중... (구역 " + i + "-" + j + ")");

                // 만약 구역 2-2에서 범인을 찾았다면?
                if (i == 2 && j == 2) {
                    System.out.println("🚨 범인(2-2) 발견!! 모든 부대는 즉시 수색을 중단하고 철수하라!");

                    // 안쪽 for문만 멈추는 게 아니라, SearchLabel 이 붙은 전체 큰 for문을 부수고 나갑니다!
                    break SearchLabel;
                }
            }
        }
        // 👆 break SearchLabel; 을 맞으면 코드가 이쪽으로 팅겨져 나옵니다.

        System.out.println("수색 종료. 경찰서로 복귀합니다.");
    }
}
