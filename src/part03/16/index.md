---
layout: part03
title: Chapter 16. 람다식
---

# Chapter 16. 람다식

## 16.1 람다식이란?

함수형 프로그래밍(functional programming)이란 함수를 정의하고 이 함수를 데이터 처리부로 보내 데이터를 처리하는 기법을 말한다. 데이터 처리부는 데이터만 가지고 있을 뿐, 처리 방법이 정해져 있지 않아 외부에서 제공된 함수에 의존한다.

데이터 처리부는 제공된 함수의 입력값으로 데이터를 넣고 함수에 정의된 처리 내용을 실행한다. 동일한 데이터라도 함수A를 제공해서 처리하는 결과와 함수B를 제공해서 처리하는 결과는 다를 수 있다. 이것이 함수형 프로그래밍의 특징으로, 데이터 처리의 다형성이라고도 볼 수 있다.

자바는 함수형 프로그래밍을 위해 Java 8부터 **람다식(Lambda Expressions)**을 지원한다. 람다식은 데이터 처리부에 제공되는 함수 역할을 하는 매개변수를 가진 중괄호 블록이다. 데이터 처리부는 람다식을 받아 매개변수에 데이터를 대입하고 중괄호를 실행시켜 처리한다.

```
람다식: (매개변수, ...) -> { 처리 내용 }
```

자바는 람다식을 익명 구현 객체로 변환한다. 익명 구현 객체란 이름이 없는 인터페이스 구현 객체를 말한다.

예를 들어 다음과 같이 Calculable 인터페이스가 있다고 가정해 보자.

```java
public interface Calculable {
	// 추상 메소드
	void calculate(int x, int y);
}
```

Calculable 인터페이스의 익명 구현 객체는 다음과 같이 생성할 수 있다.

```java
new Calculable() {
	@Override
	public void calculate(int x, int y) { 처리내용 }
};
```

이것을 람다식으로 표현하면 다음과 같다. 추상 메소드인 calculate()는 두 개의 매개변수를 가지므로 (x, y)로 표현되었고, 화살표 -> 뒤에 calculate()의 실행 블록이 온다.

```java
(x, y) -> { 처리내용 };
```

람다식은 인터페이스의 익명 구현 객체이므로 인터페이스 타입의 매개변수에 대입될 수 있다.

```java
public void action(Calculable calculable) {
	int x = 10;
	int y = 4;
	calculable.calculate(x, y); // 데이터를 제공하고 추상 메소드를 호출
}
```

action() 메소드를 호출할 때 매개값으로 다음과 같이 람다식을 제공할 수 있다.

```java
action((x, y) -> {
	int result = x + y;
	System.out.println(result);
});
```

인터페이스의 익명 구현 객체를 람다식으로 표현하려면 인터페이스가 단 하나의 추상 메소드만 가져야 한다. 인터페이스가 단 하나의 추상 메소드를 가질 때, 이를 **함수형 인터페이스(functional interface)**라고 한다.

인터페이스가 함수형 인터페이스임을 보장하기 위해서는 `@FunctionalInterface` 어노테이션을 붙이면 된다.

```java
package ch16.sec01;

@FunctionalInterface
public interface Calculable {
	// 추상 메소드
	void calculate(int x, int y);
}
```

```java
package ch16.sec01;

public class LambdaExample {
	public static void main(String[] args) {
		action((x, y) -> {
			int result = x + y;
			System.out.println("result: " + result);
		});

		action((x, y) -> {
			int result = x - y;
			System.out.println("result: " + result);
		});
	}

	public static void action(Calculable calculable) {
		int x = 10;
		int y = 4;
		// 데이터 처리
		calculable.calculate(x, y);
	}
}
```

**실행 결과**
```
result: 14
result: 6
```

## 16.2 매개변수가 없는 람다식

함수형 인터페이스의 추상 메소드에 매개변수가 없을 경우 람다식은 다음과 같이 작성할 수 있다. 실행문이 두 개 이상일 경우에는 중괄호를 생략할 수 없고, 하나일 경우에만 생략할 수 있다.

```
() -> {
	실행문;
	실행문;
}

() -> 실행문
```

```java
package ch16.sec02.exam01;

@FunctionalInterface
public interface Workable {
	void work();
}
```

```java
package ch16.sec02.exam01;

public class Person {
	public void action(Workable workable) {
		workable.work();
	}
}
```

```java
package ch16.sec02.exam01;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		// 실행문이 두 개 이상인 경우 중괄호 필요
		person.action(() -> {
			System.out.println("출근을 합니다.");
			System.out.println("프로그래밍을 합니다.");
		});

		// 실행문이 한 개일 경우 중괄호 생략 가능
		person.action(() -> System.out.println("퇴근합니다."));
	}
}
```

**실행 결과**
```
출근을 합니다.
프로그래밍을 합니다.
퇴근합니다.
```

다음은 버튼의 클릭 이벤트를 람다식으로 처리하는 예제이다.

```java
package ch16.sec02.exam02;

public class Button {
	// 정적 멤버 인터페이스
	@FunctionalInterface
	public static interface ClickListener {
		// 추상 메소드
		void onClick();
	}

	// 필드
	private ClickListener clickListener;

	// 메소드
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}
```

```java
package ch16.sec02.exam02;

public class ButtonExample {
	public static void main(String[] args) {
		// Ok 버튼 객체 생성
		Button btnOk = new Button();

		// Ok 버튼 객체에 람다식(ClickListener 익명 구현 객체) 주입
		btnOk.setClickListener(() -> {
			System.out.println("Ok 버튼을 클릭했습니다.");
		});

		// Ok 버튼 클릭하기
		btnOk.click();

		// Cancel 버튼 객체 생성
		Button btnCancel = new Button();

		// Cancel 버튼 객체에 람다식(ClickListener 익명 구현 객체) 주입
		btnCancel.setClickListener(() -> {
			System.out.println("Cancel 버튼을 클릭했습니다.");
		});

		// Cancel 버튼 클릭하기
		btnCancel.click();
	}
}
```

**실행 결과**
```
Ok 버튼을 클릭했습니다.
Cancel 버튼을 클릭했습니다.
```

## 16.3 매개변수가 있는 람다식

함수형 인터페이스의 추상 메소드에 매개변수가 있을 경우 람다식은 다음과 같이 작성할 수 있다. 매개변수를 선언할 때 타입은 생략할 수 있고, 구체적인 타입 대신에 `var`를 사용할 수도 있다. 하지만 타입을 생략하고 작성하는 것이 일반적이다.

```
(타입 매개변수, ...) -> { ... }
(var 매개변수, ...) -> { ... }
(매개변수, ...) -> { ... }
```

매개변수가 하나일 경우에는 괄호를 생략할 수도 있다. 이때는 타입 또는 `var`를 붙일 수 없다.

```
매개변수 -> { ... }
매개변수 -> 실행문
```

```java
package ch16.sec03;

@FunctionalInterface
public interface Workable {
	void work(String name, String job);
}
```

```java
package ch16.sec03;

@FunctionalInterface
public interface Speakable {
	void speak(String content);
}
```

```java
package ch16.sec03;

public class Person {
	public void action1(Workable workable) {
		workable.work("홍길동", "프로그래밍");
	}

	public void action2(Speakable speakable) {
		speakable.speak("안녕하세요");
	}
}
```

```java
package ch16.sec03;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		// 매개변수가 두 개일 경우
		person.action1((name, job) -> {
			System.out.print(name + "이 ");
			System.out.println(job + "을 합니다.");
		});
		person.action1((name, job) -> System.out.println(name + "이 " + job + "을 하지 않습니다."));

		// 매개변수가 한 개일 경우
		person.action2(word -> {
			System.out.print("\"" + word + "\"");
			System.out.println("라고 말합니다.");
		});
		person.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
	}
}
```

**실행 결과**
```
홍길동이 프로그래밍을 합니다.
홍길동이 프로그래밍을 하지 않습니다.
"안녕하세요"라고 말합니다.
"안녕하세요"라고 외칩니다.
```

## 16.4 리턴값이 있는 람다식

함수형 인터페이스의 추상 메소드에 리턴값이 있을 경우 람다식은 다음과 같이 작성할 수 있다. return 문 하나만 있을 경우에는 중괄호와 함께 return 키워드를 생략할 수 있다. 리턴값은 연산식 또는 리턴값 있는 메소드 호출로 대체할 수 있다.

```
(매개변수, ...) -> {
	실행문;
	return 값;
}

(매개변수, ...) -> 값
```

```java
package ch16.sec04;

@FunctionalInterface
public interface Calcuable {
	double calc(double x, double y);
}
```

```java
package ch16.sec04;

public class Person {
	public void action(Calcuable calcuable) {
		double result = calcuable.calc(10, 4);
		System.out.println("결과: " + result);
	}
}
```

```java
package ch16.sec04;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		// 실행문이 두 개 이상일 경우
		person.action((x, y) -> {
			double result = x + y;
			return result;
		});

		// 리턴문이 하나만 있을 경우(연산식)
		// person.action((x, y) -> {
		// return (x + y);
		// });
		person.action((x, y) -> (x + y));

		// 리턴문이 하나만 있을 경우(메소드 호출)
		// person.action((x, y) -> {
		// return sum(x, y);
		// });
		person.action((x, y) -> sum(x, y));
	}

	public static double sum(double x, double y) {
		return (x + y);
	}
}
```

**실행 결과**
```
결과: 14.0
결과: 14.0
결과: 14.0
```

## 16.5 메소드 참조

메소드 참조(Method Reference)는 말 그대로 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내 람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 한다.

예를 들어 두 개의 값을 받아 큰 수를 리턴하는 `Math.max()` 정적 메소드를 호출하는 람다식은 다음과 같다.

```java
(left, right) -> Math.max(left, right);
```

이것을 메소드 참조를 이용하면 다음과 같이 깔끔하게 처리할 수 있다.

```java
Math :: max;
```

### 정적 메소드와 인스턴스 메소드 참조

정적(static) 메소드를 참조할 경우에는 클래스 이름 뒤에 `::` 기호를 붙이고 정적 메소드 이름을 기술한다.

```
클래스 :: 메소드
```

인스턴스 메소드일 경우에는 먼저 객체를 생성한 다음 참조 변수 뒤에 `::` 기호를 붙이고 인스턴스 메소드 이름을 기술한다.

```
참조변수 :: 메소드
```

```java
package ch16.sec05.exam01;

@FunctionalInterface
public interface Calcuable {
	double calc(double x, double y);
}
```

```java
package ch16.sec05.exam01;

public class Person {
	public void action(Calcuable calcuable) {
		double result = calcuable.calc(10, 4);
		System.out.println("결과: " + result);
	}
}
```

```java
package ch16.sec05.exam01;

public class Computer {
	public static double staticMethod(double x, double y) {
		return x + y;
	}

	public double instanceMethod(double x, double y) {
		return x * y;
	}
}
```

```java
package ch16.sec05.exam01;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();

		// 정적 메소드일 경우
		// 람다식
		// person.action((x, y) -> Computer.staticMethod(x, y));
		// 메소드 참조
		person.action(Computer :: staticMethod);

		// 인스턴스 메소드일 경우
		Computer com = new Computer();
		// 람다식
		// person.action((x, y) -> com.instanceMethod(x, y));
		// 메소드 참조
		person.action(com :: instanceMethod);
	}
}
```

**실행 결과**
```
결과: 14.0
결과: 40.0
```

### 매개변수의 메소드 참조

다음과 같이 람다식에서 제공되는 a 매개변수의 메소드를 호출해서 b 매개변수를 매개값으로 사용하는 경우도 있다.

```java
(a, b) -> { a.instanceMethod(b); }
```

이것을 메소드 참조로 표현하면 다음과 같다. a의 클래스 이름 뒤에 `::` 기호를 붙이고 메소드 이름을 기술한다. 정적 메소드 참조와 작성 방법은 동일하지만, a의 인스턴스 메소드가 사용된다는 점에서 다르다.

```
클래스 :: instanceMethod
```

```java
package ch16.sec05.exam02;

@FunctionalInterface
public interface Comparable {
	int compare(String a, String b);
}
```

```java
package ch16.sec05.exam02;

public class Person {
	public void ordering(Comparable comparable) {
		String a = "홍길동";
		String b = "김길동";

		int result = comparable.compare(a, b);

		if (result < 0) {
			System.out.println(a + "은 " + b + "보다 앞에 옵니다.");
		} else if (result == 0) {
			System.out.println(a + "은 " + b + "과 같습니다.");
		} else {
			System.out.println(a + "은 " + b + "보다 뒤에 옵니다.");
		}
	}
}
```

```java
package ch16.sec05.exam02;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		person.ordering(String :: compareToIgnoreCase);
	}
}
```

**실행 결과**
```
홍길동은 김길동보다 뒤에 옵니다.
```

## 16.6 생성자 참조

생성자를 참조한다는 것은 객체를 생성하는 것을 의미한다. 람다식이 단순히 객체를 생성하고 리턴하도록 구성된다면 람다식을 생성자 참조로 대치할 수 있다.

```java
(a, b) -> { return new 클래스(a, b); }
```

이것을 생성자 참조로 표현하면 다음과 같다.

```java
클래스 :: new
```

생성자가 오버로딩되어 여러 개가 있을 경우, 컴파일러는 함수형 인터페이스의 추상 메소드와 동일한 매개변수 타입과 개수를 가지고 있는 생성자를 찾아 실행한다.

```java
package ch16.sec05.exam03;

@FunctionalInterface
public interface Creatable1 {
	public Member create(String id);
}
```

```java
package ch16.sec05.exam03;

@FunctionalInterface
public interface Creatable2 {
	public Member create(String id, String name);
}
```

```java
package ch16.sec05.exam03;

public class Member {
	private String id;
	private String name;

	public Member(String id) {
		this.id = id;
		System.out.println("Member(String id)");
	}

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("Member(String id, String name)");
	}

	@Override
	public String toString() {
		String info = "{ id: " + id + ", name: " + name + " }";
		return info;
	}
}
```

```java
package ch16.sec05.exam03;

public class Person {
	public Member getMember1(Creatable1 creatable) {
		String id = "winter";
		Member member = creatable.create(id);
		return member;
	}

	public Member getMember2(Creatable2 creatable) {
		String id = "winter";
		String name = "한겨울";
		Member member = creatable.create(id, name);
		return member;
	}
}
```

```java
package ch16.sec05.exam03;

public class ConstructorReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();

		Member m1 = person.getMember1(Member :: new);
		System.out.println(m1);
		System.out.println();

		Member m2 = person.getMember2(Member :: new);
		System.out.println(m2);
	}
}
```

**실행 결과**
```
Member(String id)
{ id: winter, name: null }

Member(String id, String name)
{ id: winter, name: 한겨울 }
```

## 확인문제

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
