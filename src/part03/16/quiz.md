---
layout: part03
title: "확인문제"
nav_order: 99
parent: "Chapter 16. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 확인문제

1.  람다식에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 람다식은 함수형 인터페이스의 익명 구현 객체를 생성한다.
    *   ② 매개변수가 없을 경우 ( ) -> { ... } 형태로 작성한다.
    *   ③ `(x, y) -> { return x+y; }`는 `(x, y) -> x+y`로 바꿀 수 있다.
    *   ④ `@FunctionalInterface`가 기술된 인터페이스만 람다식으로 표현이 가능하다.
    > **정답**: ④
    > **해설**: @FunctionalInterface 어노테이션이 없어도 추상 메소드가 하나라면 람다식으로 표현 가능하다.

2.  메소드 참조와 생성자 참조에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 메소드 참조는 함수적 인터페이스의 익명 구현 객체를 생성한다.
    *   ② 인스턴스 메소드는 "참조변수::메소드"로 기술한다.
    *   ③ 정적 메소드는 "클래스::메소드"로 기술한다.
    *   ④ 생성자 참조인 "클래스::new"는 매개변수가 없는 디폴트 생성자만 호출한다.
    > **정답**: ④
    > **해설**: 매개변수가 있는 생성자도 호출 가능하다.

3.  다음 중 잘못 작성된 람다식은 무엇입니까?
    *   ① `a -> a + 3`
    *   ② `a, b -> a * b`
    *   ③ `x -> System.out.println(x/5)`
    *   ④ `(x, y) -> Math.max(x, y)`
    > **정답**: ②
    > **해설**: 파라미터가 2개 이상일 때는 괄호가 필수이다. `(a, b) -> a * b` 여야 한다.

4.  다음 코드의 실행 결과를 보고 빈 곳에 들어갈 람다식을 작성해 보세요.
    ```java
    Thread thread = new Thread(
    	() -> {
    		for (int i=0; i<3; i++)
    			System.out.println("작업 스레드가 실행됩니다.");
    	}
    );
    ```

5.  다음 코드의 실행 결과를 보고 밑줄 친 곳에 들어갈 람다식을 작성해 보세요.
    ```java
    // ... main 내부 ...
    Button btnOk = new Button();
    btnOk.setClickListener( () -> System.out.println("Ok 버튼을 클릭했습니다.") );
    btnOk.click();

    Button btnCancel = new Button();
    btnCancel.setClickListener( () -> System.out.println("Cancel 버튼을 클릭했습니다.") );
    btnCancel.click();
    ```

6.  다음 코드를 보고, Function 함수형 인터페이스를 작성해 보세요.
    ```java
    @FunctionalInterface
    public interface Function {
    	double apply(double x, double y);
    }
    ```

7.  다음은 배열 항목 중에 최대값 또는 최소값을 찾는 코드입니다. maxOrMin() 메소드를 호출할 때 빈 곳에 람다식을 작성해 보세요.
    ```java
    // ... main 내부 ...
    // 최대값 얻기
    int max = maxOrMin(
    	(a, b) -> (a>=b) ? a : b
    );
    System.out.println("최대값: " + max);

    // 최소값 얻기
    int min = maxOrMin(
    	(a, b) -> (a<=b) ? a : b
    );
    System.out.println("최소값: " + min);
    ```

8.  다음은 학생의 영어 평균 점수와 수학 평균 점수를 계산하는 코드입니다. 빈 곳에 avg() 메소드를 작성해 보세요.
    ```java
    // ... Example 클래스 내부 ...
    public static double avg(Function<Student> function) {
    	int sum = 0;
    	for (Student student : students) {
    		sum += function.apply(student);
    	}
    	double avg = (double) sum / students.length;
    	return avg;
    }
    ```

9.  8번 문제에서 Example 클래스의 main() 메소드를 실행할 때, avg() 메소드의 매개값으로 람다식을 사용하지 않고 메소드 참조로 변경해 보세요.
    ```java
    double englishAvg = avg( Student :: getEnglishScore );
    double mathAvg = avg( Student :: getMathScore );
    ```
