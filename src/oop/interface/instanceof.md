---
layout: oop
title: "8.12 객체 타입 확인"
nav_order: 12
parent: "Chapter 08. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 8.12 객체 타입 확인

우리는 상속에서 객체 타입을 확인하기 위해 `instanceof` 연산자를 사용했는데, 인터페이스에서도 사용할 수 있다. 예를 들어 `Vehicle` 인터페이스 변수에 대입된 객체가 `Bus`인지 확인하는 코드는 다음과 같다.

```java
if (vehicle instanceof Bus) {
    // vehicle에 대입된 객체가 Bus일 경우 실행
}
```

메소드의 매개변수가 인터페이스 타입일 경우, 메소드 호출 시 매개값은 해당 인터페이스를 구현하는 모든 객체가 될 수 있다. 만약 매개값이 특정 구현 객체일 경우에만 강제 타입 변환을 하고 싶다면 `instanceof` 연산자를 사용해서 매개값의 타입을 검사해야 한다.

```java
public void method(Vehicle vehicle) {
    if (vehicle instanceof Bus) {
        Bus bus = (Bus) vehicle;
        // bus 변수 사용
    }
}
```

Java 12부터는 `instanceof` 연산의 결과가 true일 경우, 우측 타입 변수를 사용할 수 있기 때문에 강제 타입 변환이 필요 없다.

```java
if (vehicle instanceof Bus bus) {
    // bus 변수 사용
}
```

다음은 `ride()` 메소드의 매개값으로 `Bus`를 제공했을 경우에만 `checkFare()` 메소드를 호출하는 예제이다.

**InstanceofExample.java**
```java
package ch08.sec12;

public class InstanceofExample {
	public static void main(String[] args) {
		// 구현 객체 생성
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
		// ride() 메소드 호출 시 구현 객체를 매개값으로 전달
		ride(taxi);
		System.out.println();
		ride(bus);
	}
	
	// 인터페이스 매개변수를 갖는 메소드
	public static void ride(Vehicle vehicle) {
		// 방법 1
		/*
		if (vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		*/
		
		// 방법 2
		if (vehicle instanceof Bus bus) {
			bus.checkFare();
		}
		
		vehicle.run();
	}
}
```

**Vehicle.java**
```java
package ch08.sec12;

public interface Vehicle {
	void run();
}
```

**Bus.java**
```java
package ch08.sec12;

public class Bus implements Vehicle {
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare() {
		System.out.println("승차요금을 체크합니다.");
	}
}
```

**Taxi.java**
```java
package ch08.sec12;

public class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
}
```

**실행 결과**
```
택시가 달립니다.

승차요금을 체크합니다.
버스가 달립니다.
```
