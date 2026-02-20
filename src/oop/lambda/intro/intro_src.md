---
layout: oop
title: "16.1 람다식이란?"
nav_order: 1
parent: "Chapter 16. 스트림과 병렬 처리"
grand_parent: "객체지향 프로그래밍"
---

# 16.1 람다식이란?

함수형 프로그래밍(functional programming)이란 함수를 정의하고 이 함수를 데이터 처리부로 보내 데이터를 처리하는 기법을 말한다. 데이터 처리부는 데이터만 가지고 있을 뿐, 처리 방법이 정해져 있지 않아 외부에서 제공된 함수에 의존한다.

데이터 처리부는 제공된 함수의 입력값으로 데이터를 넣고 함수에 정의된 처리 내용을 실행한다. 동일한 데이터라도 함수A를 제공해서 처리하는 결과와 함수B를 제공해서 처리하는 결과는 다를 수 있다. 이것이 함수형 프로그래밍의 특징으로, 데이터 처리의 다형성이라고도 볼 수 있다.

자바는 함수형 프로그래밍을 위해 Java 8부터 **람다식(Lambda Expressions)**을 지원한다. 람다식은 데이터 처리부에 제공되는 함수 역할을 하는 매개변수를 가진 중괄호 블록이다. 데이터 처리부는 람다식을 받아 매개변수에 데이터를 대입하고 중괄호를 실행시켜 처리한다.

```
람다식: (매개변수, ...) -> { 처리 내용 }
```

자바는 람다식을 익명 구현 객체로 변환한다. 익명 구현 객체란 이름이 없는 인터페이스 구현 객체를 말한다.

예를 들어 다음과 같이 `Calculable` 인터페이스가 있다고 가정해 보자.

```java
public interface Calculable {
	// 추상 메소드
	void calculate(int x, int y);
}
```

`Calculable` 인터페이스의 익명 구현 객체는 다음과 같이 생성할 수 있다.

```java
new Calculable() {
	@Override
	public void calculate(int x, int y) { 처리내용 }
};
```

이것을 람다식으로 표현하면 다음과 같다. 추상 메소드인 `calculate()`는 두 개의 매개변수를 가지므로 `(x, y)`로 표현되었고, 화살표 `->` 뒤에 `calculate()`의 실행 블록이 온다.

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

`action()` 메소드를 호출할 때 매개값으로 다음과 같이 람다식을 제공할 수 있다.

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
