---
layout: oop
title: "16.5 메소드 참조"
nav_order: 5
parent: "Chapter 16. 스트림과 병렬 처리"
grand_parent: "객체지향 프로그래밍"
---

# 16.5 메소드 참조

메소드 참조(Method Reference)는 말 그대로 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내 람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 한다.

예를 들어 두 개의 값을 받아 큰 수를 리턴하는 `Math.max()` 정적 메소드를 호출하는 람다식은 다음과 같다.

```java
(left, right) -> Math.max(left, right);
```

이것을 메소드 참조를 이용하면 다음과 같이 깔끔하게 처리할 수 있다.

```java
Math :: max;
```

## 정적 메소드와 인스턴스 메소드 참조

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

## 매개변수의 메소드 참조

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
