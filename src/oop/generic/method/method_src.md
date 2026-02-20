---
layout: oop
title: "13.3 제네릭 메소드"
nav_order: 3
parent: "Chapter 13. 제네릭"
grand_parent: "객체지향 프로그래밍"
---

# 13.3 제네릭 메소드

제네릭 메소드는 타입 파라미터를 가지고 있는 메소드를 말한다. 타입 파라미터가 메소드 선언부에 정의된다는 점에서 제네릭 타입과 차이가 있다. 제네릭 메소드는 리턴 타입 앞에 `<T>` 기호를 추가하고 타입 파라미터를 정의한 뒤, 리턴 타입과 매개변수 타입에서 사용한다.

```java
public <A, B, ...> 리턴타입 메소드명(매개변수, ...) { ... }
```

다음 `boxing()` 메소드는 타입 파라미터로 `<T>`를 정의하고 매개변수 타입과 리턴 타입에서 `T`를 사용한다. 정확한 리턴 타입은 `T`를 내용물로 갖는 `Box` 객체이다.

```java
public <T> Box<T> boxing(T t) { ... }
```

타입 파라미터 `T`는 매개값이 어떤 타입이냐에 따라 컴파일 과정에서 구체적인 타입으로 대체된다.

```java
Box<Integer> box1 = boxing(100);
Box<String> box2 = boxing("안녕하세요");
```

①은 100의 클래스 타입이 `Integer`이므로 타입 파라미터 `T`는 `Integer`로 대체되어 `Box<Integer>`가 리턴된다. ②는 "안녕하세요"의 클래스 타입이 `String`이므로 타입 파라미터 `T`는 `String`으로 대체되어 `Box<String>`이 리턴된다.

실습을 해보자. 먼저 제네릭 타입인 `Box` 클래스를 다음과 같이 선언한다.

```java
package ch13.sec03.exam01;

public class Box<T> {
	// 필드
	private T t;

	// Getter 메소드
	public T get() {
		return t;
	}

	// Setter 메소드
	public void set(T t) {
		this.t = t;
	}
}
```

다음 `GenericExample` 클래스는 제네릭 메소드인 `boxing`을 선언하고 호출하는 방법을 보여 준다.

```java
package ch13.sec03.exam01;

public class GenericExample {
	// 제네릭 메소드
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}

	public static void main(String[] args) {
		// 제네릭 메소드 호출
		Box<Integer> box1 = boxing(100);
		int intValue = box1.get();
		System.out.println(intValue);

		// 제네릭 메소드 호출
		Box<String> box2 = boxing("홍길동");
		String strValue = box2.get();
		System.out.println(strValue);
	}
}
```

**실행 결과**
```
100
홍길동
```
