---
layout: oop
title: "7.4 메소드 재정의"
nav_order: 4
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.4 메소드 재정의

부모 클래스의 모든 메소드가 자식 클래스에게 맞게 설계되어 있다면 가장 이상적인 상속이지만, 어떤 메소드는 자식 클래스가 사용하기에 적합하지 않을 수 있다. 이러한 메소드는 자식 클래스에서 재정의해서 사용해야 한다. 이것을 메소드 오버라이딩(`Overriding`)이라고 한다.

## 메소드 오버라이딩

메소드 오버라이딩은 상속된 메소드를 자식 클래스에서 재정의하는 것을 말한다. 메소드가 오버라이딩되었다면 해당 부모 메소드는 숨겨지고, 자식 메소드가 우선적으로 사용된다.

```java
class Parent {
    void method1() { ... }
    void method2() { ... }
}

class Child extends Parent {
    void method2() { ... } // 오버라이딩
    void method3() { ... }
}

class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        child.method1(); // 부모 메소드 호출
        child.method2(); // 오버라이딩된 자식 메소드 호출
        child.method3(); // 자식 메소드 호출
    }
}
```

메소드를 오버라이딩할 때는 다음과 같은 규칙에 주의해서 작성해야 한다.
- 부모 메소드의 선언부(리턴 타입, 메소드 이름, 매개변수)와 동일해야 한다.
- 접근 제한을 더 강하게 오버라이딩할 수 없다(`public` -> `private`으로 변경 불가).
- 새로운 예외를 `throws`할 수 없다(예외는 10장에서 학습한다).

다음 예제를 보면 `Calculator`는 원의 넓이를 구하는 `areaCircle()` 메소드를 가지고 있다. 하지만 원주율 파이가 정확하지 않기 때문에 자식 클래스인 `Computer`에서 오버라이딩해서 좀 더 정확한 원주율 파이 상수(`Math.PI`)를 사용해 원의 넓이를 구하도록 했다.

**Calculator.java**
```java
package ch07.sec04.exam01;

public class Calculator {
	// 메소드 선언
	public double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return 3.14159 * r * r;
	}
}
```

**Computer.java**
```java
package ch07.sec04.exam01;

public class Computer extends Calculator {
	// 메소드 오버라이딩
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}
```

**ComputerExample.java**
```java
package ch07.sec04.exam01;

public class ComputerExample {
	public static void main(String[] args) {
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("원 면적: " + calculator.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("원 면적: " + computer.areaCircle(r));
	}
}
```

**실행 결과**
```
Calculator 객체의 areaCircle() 실행
원 면적: 314.159

Computer 객체의 areaCircle() 실행
원 면적: 314.1592653589793
```

자바는 개발자의 실수를 줄여주기 위해 정확히 오버라이딩이 되었는지 체크해주는 `@Override` 어노테이션을 제공한다. `@Override`를 붙이면 컴파일 단계에서 정확히 오버라이딩이 되었는지 체크하고, 문제가 있다면 컴파일 에러를 출력한다.

## 부모 메소드 호출

메소드를 재정의하면, 부모 메소드는 숨겨지고 자식 메소드만 사용되기 때문에 비록 부모 메소드의 일부만 변경된다 하더라도 중복된 내용을 자식 메소드도 가지고 있어야 한다. 예를 들어 부모 메소드가 100줄의 코드를 가지고 있을 경우, 자식 메소드에서 1줄만 추가하고 싶더라도 100줄의 코드를 자식 메소드에서 다시 작성해야 한다.

이 문제는 자식 메소드와 부모 메소드의 공동 작업 처리 기법을 이용하면 매우 쉽게 해결된다. 자식 메소드 내에서 부모 메소드를 호출하는 것인데, 다음과 같이 `super` 키워드와 도트(`.`) 연산자를 사용하면 숨겨진 부모 메소드를 호출할 수 있다.

```java
class Parent {
    public void method() {
        // 작업 처리 1
    }
}

class Child extends Parent {
    @Override
    public void method() {
        super.method(); // 부모 메소드 호출
        // 작업 처리 2
    }
}
```

`super.method()`의 위치는 작업 처리 2 전후에 어디든지 올 수 있다. 우선 처리가 되어야 할 내용을 먼저 작성하면 된다. 이 방법은 부모 메소드를 재사용함으로써 자식 메소드의 중복 작업 내용을 없애는 효과를 가져온다.

다음 예제를 보면 `Airplane`의 `fly()` 메소드를 자식 클래스인 `SupersonicAirplane`에서 오버라이딩했다. 따라서 일반 비행 모드일 때는 `Airplane`의 `fly()`를 사용하고, 초음속 비행 모드일 때는 오버라이딩된 `SupersonicAirplane`의 `fly()`를 사용한다.

**Airplane.java**
```java
package ch07.sec04.exam02;

public class Airplane {
	// 메소드 선언
	public void land() {
		System.out.println("착륙합니다.");
	}
	
	public void fly() {
		System.out.println("일반 비행합니다.");
	}
	
	public void takeOff() {
		System.out.println("이륙합니다.");
	}
}
```

**SupersonicAirplane.java**
```java
package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane {
	// 상수 선언
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	// 상태 필드 선언
	public int flyMode = NORMAL;
	
	// 메소드 재정의
	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		} else {
			// Airplane 객체의 fly() 메소드 호출
			super.fly();
		}
	}
}
```

**SupersonicAirplaneExample.java**
```java
package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
	}
}
```

**실행 결과**
```
이륙합니다.
일반 비행합니다.
초음속 비행합니다.
일반 비행합니다.
착륙합니다.
```
