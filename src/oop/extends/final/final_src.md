---
layout: oop
title: "7.5 final 클래스와 final 메소드"
nav_order: 5
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.5 final 클래스와 final 메소드

우리가 6장 11절에서 살펴보았듯이, 필드 선언 시에 `final`을 붙이면 초기값 설정 후 값을 변경할 수 없다. 그렇다면 클래스와 메소드에 `final`을 붙이면 어떤 효과가 일어날까? `final` 클래스와 `final` 메소드는 상속과 관련이 있다.

## final 클래스

클래스를 선언할 때 `final` 키워드를 `class` 앞에 붙이면 최종적인 클래스이므로 더 이상 상속할 수 없는 클래스가 된다. 즉 `final` 클래스는 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없다.

```java
public final class 클래스 { ... }
```

대표적인 예가 `String` 클래스이다. `String` 클래스는 다음과 같이 선언되어 있다.

```java
public final class String { ... }
```

그래서 다음과 같이 자식 클래스를 만들 수 없다.

```java
public class NewString extends String { ... } // x
```

다음 예제는 `Member` 클래스를 선언할 때 `final`을 지정함으로써 `Member`를 상속해 `VeryImportantPerson`을 선언할 수 없음을 보여 준다.

**Member.java**
```java
package ch07.sec05.exam01;

public final class Member {
}
```

**VeryImportantPerson.java**
```java
package ch07.sec05.exam01;

public class VeryImportantPerson extends Member { // 컴파일 에러
}
```

## final 메소드

메소드를 선언할 때 `final` 키워드를 붙이면 이 메소드는 최종적인 메소드이므로 오버라이딩할 수 없는 메소드가 된다. 즉 부모 클래스를 상속해서 자식 클래스를 선언할 때, 부모 클래스에 선언된 `final` 메소드는 자식 클래스에서 재정의할 수 없다.

```java
public final 리턴타입 메소드(매개변수, ...) { ... }
```

다음 예제는 `Car` 클래스의 `stop()` 메소드를 `final`로 선언했기 때문에 자식 클래스인 `SportsCar`에서 `stop()` 메소드를 오버라이딩할 수 없음을 보여 준다.

**Car.java**
```java
package ch07.sec05.exam02;

public class Car {
	// 필드 선언
	public int speed;
	
	// 메소드 선언
	public void speedUp() {
		speed += 1;
	}
	
	// final 메소드
	public final void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
```

**SportsCar.java**
```java
package ch07.sec05.exam02;

public class SportsCar extends Car {
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	// 오버라이딩을 할 수 없음
	/*
	@Override
	public void stop() {
		System.out.println("스포츠카를 멈춤");
		speed = 0;
	}
	*/
}
```
