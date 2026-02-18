---
layout: oop
title: "13.4 제한된 타입 파라미터"
nav_order: 4
parent: "Chapter 13. 제네릭"
grand_parent: "객체지향 프로그래밍"
---

# 13.4 제한된 타입 파라미터

경우에 따라서는 타입 파라미터를 대체하는 구체적인 타입을 제한할 필요가 있다. 예를 들어 숫자를 연산하는 제네릭 메소드는 대체 타입으로 Number 또는 자식 클래스(Byte, Short, Integer, Long, Double)로 제한할 필요가 있다.

이처럼 모든 타입으로 대체할 수 없고, 특정 타입과 자식 또는 구현 관계에 있는 타입만 대체할 수 있는 타입 파라미터를 **제한된 타입 파라미터(bounded type parameter)**라고 한다. 정의는 다음과 같이 한다.

```java
public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) { ... }
```

상위 타입은 클래스뿐만 아니라 인터페이스도 가능하다. 인터페이스라고 해서 implements를 사용하지는 않는다. 다음은 Number 타입과 자식 클래스(Byte, Short, Integer, Long, Double)에만 대체 가능한 타입 파라미터를 정의한 것이다.

```java
public <T extends Number> boolean compare(T t1, T t2) {
	double v1 = t1.doubleValue(); // Number의 doubleValue() 메소드 사용
	double v2 = t2.doubleValue(); // Number의 doubleValue() 메소드 사용
	return (v1 == v2);
}
```

타입 파라미터가 Number 타입으로 제한되면서 Object의 메소드뿐만 아니라 Number가 가지고 있는 메소드도 사용할 수 있다. 위 코드에서 doubleValue() 메소드는 Number 타입에 정의되어 있는 메소드로, double 타입 값을 리턴한다.

```java
package ch13.sec04;

public class GenericExample {
	// 제한된 타입 파라미터를 갖는 제네릭 메소드
	public static <T extends Number> boolean compare(T t1, T t2) {
		// T의 타입을 출력
		System.out.println("compare(" + t1.getClass().getSimpleName() + ", " +
				t2.getClass().getSimpleName() + ")");

		// Number의 메소드 사용
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();

		return (v1 == v2);
	}

	public static void main(String[] args) {
		// 제네릭 메소드 호출
		boolean result1 = compare(10, 20); // T를 Integer 타입으로 대체
		System.out.println(result1);
		System.out.println();

		// 제네릭 메소드 호출
		boolean result2 = compare(4.5, 4.5); // T를 Double 타입으로 대체
		System.out.println(result2);
	}
}
```

**실행 결과**
```
compare(Integer, Integer)
false

compare(Double, Double)
true
```
