---
layout: oop
title: "16.3 매개변수가 있는 람다식"
nav_order: 3
parent: "Chapter 16. 스트림과 병렬 처리"
grand_parent: "객체지향 프로그래밍"
---

# 16.3 매개변수가 있는 람다식

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
