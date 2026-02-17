---
layout: part03
title: "확인문제"
nav_order: 99
parent: "Chapter 12. java.base 모듈"
grand_parent: "라이브러리 활용"
---

# 확인문제

1.  API 도큐먼트에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 자바 표준 라이브러리를 프로그램에서 어떻게 사용할 수 있는지를 설명하고 있다.
    *   ② 클래스의 상속 관계 및 자식 클래스들이 무엇이 있는지 알 수 있다.
    *   ③ 생성자 선언부, 필드의 타입, 메소드의 선언부를 확인할 수 있다.
    *   ④ public, protected, default, private 접근 제한을 가지는 멤버들을 확인할 수 있다.
    > **정답**: ④
    > **해설**: API 도큐먼트에서는 주로 public이나 protected 접근 제한을 가지는 멤버들만 확인할 수 있다.

2.  java.base 모듈에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 모든 표준 모듈이 의존하는 기본 모듈이다.
    *   ② 모듈 기술자에 requires를 하지 않아도 사용할 수 있는 모듈이다.
    *   ③ java.base의 패키지에는 java.lang, java.util, java.io, java.net, java.sql 등이 있다.
    *   ④ java.lang 패키지를 제외한 다른 패키지는 import 문을 필요로 한다.
    > **정답**: ③
    > **해설**: java.sql은 java.base 모듈에 포함되지 않는다.

3.  Object 클래스에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 모든 자바 클래스의 최상위 부모 클래스이다.
    *   ② Object의 equals() 메소드는 == 연산자와 동일하게 번지를 비교한다.
    *   ③ Object의 hashCode() 메소드는 동등 비교 시 활용된다.
    *   ④ Object의 toString() 메소드는 객체의 필드값을 문자열로 리턴한다.
    > **정답**: ④
    > **해설**: 기본적으로 Object의 toString() 메소드는 '클래스명@16진수해시코드'를 리턴한다. 객체의 필드값을 문자열로 리턴하려면 재정의해야 한다.

4.  객체의 동등 비교를 위해 Object의 equals()와 hashCode() 메소드를 오버라이딩했다고 가정할 경우, 메소드 호출 순서를 생각하고 다음 ( ) 안을 채워 보세요.
    > **정답**: hashCode(), equals()
    > **해설**: 해시코드가 같은지 먼저 확인(hashCode())하고, 같다면 데이터가 같은지 확인(equals())한다.

5.  Object의 equals()와 hashCode() 메소드를 오버라이딩해서 Student의 학번(studentNum)이 같으면 동등 객체가 될 수 있도록 Student 클래스를 작성해 보세요(hashCode() 메소드의 리턴값은 studentNum 필드값으로 설정).
    ```java
    public class Student {
    	private String studentNum;

    	public Student(String studentNum) {
    		this.studentNum = studentNum;
    	}

    	public String getStudentNum() {
    		return studentNum;
    	}

    	@Override
    	public int hashCode() {
    		return studentNum.hashCode();
    	}

    	@Override
    	public boolean equals(Object obj) {
    		if (obj instanceof Student) {
    			Student student = (Student) obj;
    			if (studentNum.equals(student.getStudentNum())) {
    				return true;
    			}
    		}
    		return false;
    	}
    }
    ```

6.  Member 클래스에서 Object의 toString() 메소드를 오버라이딩해서 MemberExample 클래스의 실행 결과처럼 나오도록 작성해 보세요.
    ```java
    public class Member {
    	private String id;
    	private String name;

    	public Member(String id, String name) {
    		this.id = id;
    		this.name = name;
    	}

    	@Override
    	public String toString() {
    		return id + ": " + name;
    	}
    }
    ```

7.  System 클래스에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① System 클래스는 정적 필드와 정적 메소드만 제공한다.
    *   ② System.out은 콘솔에 출력할 때, System.in은 키보드에서 입력받을 때 사용한다.
    *   ③ millisTime()과 nanoTime() 메소드는 현재 시간에 대한 long 값을 리턴한다.
    *   ④ exit() 메소드는 프로세스(JVM)를 종료시킨다.
    > **정답**: ③
    > **해설**: millisTime()이 아니라 currentTimeMillis()이다.

8.  다음 전체 코드를 실행하는 데 걸린 시간을 구하는 코드를 작성해 보세요(단위 나노초).
    ```java
    long time1 = System.nanoTime();

    int[] scores = new int[1000];
    for (int i=0; i<scores.length; i++) {
    	scores[i] = i;
    }

    int sum = 0;
    for (int score : scores) {
    	sum += score;
    }

    double avg = sum / scores.length;
    System.out.println(avg);

    long time2 = System.nanoTime();
    System.out.println((time2 - time1) + "나노초가 소요되었습니다.");
    ```

9.  다음 바이트 배열은 UTF-8 문자셋으로 인코딩한 데이터로, 다시 문자열로 디코딩해서 변수 data에 저장하려고 합니다. 밑줄 친 곳에 들어갈 코드를 작성해 보세요.
    ```java
    byte[] bytes = { -20, -107, -120, -21, -123, -107 };
    String str = new String(bytes);
    ```

10. 다음 코드는 1부터 100까지의 숫자를 통 문자열로 만들기 위해 += 연산자를 이용해 100번 반복하고 있습니다. 이것은 곧 100개 이상의 String 객체를 생성하는 결과를 만들기 때문에 좋은 코드라고 볼 수 없습니다. StringBuilder를 사용해서 좀 더 효율적인 코드로 개선해 보세요.
    ```java
    public class StringBuilderExample {
    	public static void main(String[] args) {
    		StringBuilder sb = new StringBuilder();
    		for (int i=1; i<=100; i++) {
    			sb.append(i);
    		}
    		System.out.println(sb.toString());
    	}
    }
    ```

11. 다음 문자열에서 쉼표(,)로 구분되어 있는 문자열을 StringTokenizer를 이용해서 분리시키고 출력해 보세요.
    ```java
    String data = "아이디,이름,패스워드";
    StringTokenizer st = new StringTokenizer(data, ",");
    while (st.hasMoreTokens()) {
    	System.out.println(st.nextToken());
    }
    ```

12. 숫자 100과 300으로 각각 박싱된 Integer 객체를 == 연산자로 비교한 결과 100을 박싱한 Integer 객체는 true가 나오지만, 300을 박싱한 Integer 객체는 false가 나왔습니다. 그 이유를 설명하고, 값 비교할 수 있도록 코드를 수정해 보세요.
    ```java
    // -128~127 사이의 값은 캐싱되어 같은 객체를 참조하지만,
    // 그 외의 값은 새로운 객체가 생성되므로 == 연산자 사용 시 주소값이 달라 false가 나온다.
    // 따라서 equals() 메소드를 사용해야 한다.
    System.out.println(obj3.equals(obj4));
    ```

13. Math 클래스가 제공하는 메소드의 리턴값이 잘못된 것은 무엇입니까?
    *   ① Math.ceil(5.3) -> 6.0
    *   ② Math.floor(5.3) -> 5.0
    *   ③ Math.max(5.3, 2.5) -> 5.3
    *   ④ Math.round(5.7) -> 6.0
    > **정답**: 없음
    > **해설**: 보기의 모든 결과는 올바르다. (문제 오류 가능성 있음, 3번이 책에 95.3으로 나와있다면 오타일 수 있음. 여기서는 일반적인 Math 클래스 동작 기준으로 정답 없음 처리)
    > *책의 원래 문제와 비교해보면, 2번이 5.0이 아니라 95.0 등으로 오타가 있었을 수도 있음. 하지만 위 보기로는 모두 맞음.*

14. 난수를 얻는 방법을 잘못 설명한 것은 무엇입니까?
    *   ① Math.random() 메소드는 0.0 <= ... < 1.0 사이의 실수 난수를 리턴한다.
    *   ② Random의 nextDouble() 메소드는 0.0 <= ... < 1.0 사이의 실수 난수를 리턴한다.
    *   ③ Random의 nextInt() 메소드는 int 타입의 허용 범위에서 난수를 리턴한다.
    *   ④ Random의 nextInt(int n) 메소드는 0 <= ... <= n 사이의 정수 난수를 리턴한다.
    > **정답**: ④
    > **해설**: nextInt(int n)은 0 <= ... < n 사이의 난수를 리턴한다(n은 포함되지 않음).

15. 올해 12월 31일까지 몇 일이 남았는지를 구하는 코드를 작성해 보세요.
    ```java
    LocalDateTime startDateTime = LocalDateTime.now();
    LocalDateTime endDateTime = LocalDateTime.of(startDateTime.getYear(), 12, 31, 0, 0, 0);
    long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
    System.out.println(remainDay);
    ```

16. SimpleDateFormat 클래스를 이용해서 오늘 날짜를 다음과 같이 출력하도록 코드를 작성해 보세요.
    ```java
    // xxxx년 xx월 xx일 x요일 xx시 xx분
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
    System.out.println(sdf.format(new Date()));
    ```

17. 정규 표현식을 이용해 첫 번째는 알파벳으로 시작하고 두 번째부터 숫자와 알파벳으로 구성된 8~12자 사이의 ID 값인지 검사하고 싶습니다. 알파벳은 대소문자를 모두 허용한다고 할 때, 다음 밑줄에 들어갈 코드를 작성해 보세요.
    ```java
    String regExp = "[a-zA-Z][a-zA-Z0-9]{7,11}";
    boolean isMatch = Pattern.matches(regExp, id);
    ```

18. Class 객체에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① Class.forName() 메소드 또는 객체의 getClass() 메소드로 얻을 수 있다.
    *   ② 패키지와 클래스 이름을 알 수 있다.
    *   ③ 클래스의 생성자, 필드, 메소드에 대한 정보를 알아낼 수 있다.
    *   ④ getResource() 메소드는 프로젝트 경로를 기준으로 리소스의 URL을 리턴한다.
    > **정답**: ④
    > **해설**: getResource()는 클래스 패스(bin 폴더 등)를 기준으로 리소스를 찾는다.

19. 어노테이션(Annotation)에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 역할을 한다.
    *   ② 클래스, 필드, 생성자, 메소드를 선언하기 전에 @어노테이션을 붙일 수 있다.
    *   ③ @어노테이션("값")일 경우 value 속성값이 값이 된다.
    *   ④ @어노테이션(value="값", prop=3)일 경우 value 속성값은 값, prop 속성값은 3이 된다.
    > **정답**: ③
    > **해설**: ③번은 맞는 설명 같지만, 엄밀히 말하면 `value` 속성만 값을 지정할 때 속성명을 생략할 수 있다는 것이지, `*` 같은 문자가 자동으로 들어가는 것은 아니다. 문맥상 3번 보기가 책에서 오타가 있거나(별표 등) 다른 의미일 수 있으나, 일반적으로 value 속성 사용법 설명이다.
    > *OCR 텍스트를 보면 3번 보기에 '*'가 포함되어 있음. '@어노테이션("*")일 경우 value 속성값이 *가 된다'는 맞는 말이지만, 문제 의도가 '속성명을 생략하면 value 속성에 대입된다'를 묻는 것이라면 맞음. 하지만 틀린 것을 찾아야 함.*
    > *OCR 텍스트 재확인:*
    > *3) @어노테이션 ( "*" )일 경우 value 속성값이 *가 된다.*
    > *4) @어노테이션 ( "*", prop=3)일 경우 value 속성값은 *, prop 속성값은 3이 된다.* -> 이건 틀림. value 속성 외에 다른 속성을 같이 쓴다면 `value=`를 생략할 수 없음.
    > **따라서 정답은 ④번**. `value` 속성과 다른 속성을 같이 사용할 때는 `value` 속성 이름을 생략할 수 없다. `value="값"`이라고 명시해야 한다.
