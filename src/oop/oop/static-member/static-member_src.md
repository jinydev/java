---
layout: oop
title: "6.10 정적 멤버"
nav_order: 10
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.10 정적 멤버

자바는 클래스 로더(class loader)를 이용해서 클래스를 메소드 영역에 저장하고 사용한다. 정적(static) 멤버란 메소드 영역의 클래스에 고정적으로 위치하는 멤버를 말한다. 그렇기 때문에 정적 멤버는 객체를 생성할 필요 없이 클래스를 통해 바로 사용이 가능하다.

필드와 메소드는 모두 정적 멤버가 될 수 있다. 정적 필드와 정적 메소드로 선언하려면 다음과 같이 `static` 키워드를 추가하면 된다.

```java
public class 클래스 {
    static 타입 필드 [= 초기값];
    
    // 정적 메소드
    static 리턴타입 메소드( 매개변수, ... ) { ... }
}
```

객체마다 가지고 있을 필요성이 없는 공용적인 필드는 정적 필드로 선언하는 것이 좋다. 예를 들어 `Calculator` 클래스에서 원의 넓이나 둘레를 구할 때 필요한 파이(π)는 `Calculator` 객체마다 가지고 있을 필요가 없기 때문에 정적 필드로 선언하는 것이 좋다.

```java
public class Calculator {
    String color; // 계산기별로 색깔이 다를 수 있다.
    static double pi = 3.14159; // 계산기에서 사용하는 파이(π) 값은 동일하다.
}
```

인스턴스 필드를 이용하지 않는 메소드는 정적 메소드로 선언하는 것이 좋다. 예를 들어 `Calculator`의 `plus()` 메소드는 외부에서 주어진 매개값들을 가지고 처리하므로 정적 메소드로 선언하는 것이 좋다. 그러나 인스턴스 필드인 `color`를 변경하는 `setColor()` 메소드는 인스턴스 메소드로 선언해야 한다.

```java
public class Calculator {
    String color; // 인스턴스 필드
    void setColor(String color) { this.color = color; } // 인스턴스 메소드
    static int plus(int x, int y) { return x + y; } // 정적 메소드
    static int minus(int x, int y) { return x - y; } // 정적 메소드
}
```

## 정적 멤버 사용

클래스가 메모리로 로딩되면 정적 멤버를 바로 사용할 수 있는데, 클래스 이름과 함께 도트(.) 연산자로 접근하면 된다. 예를 들어 `Calculator` 클래스가 다음과 같이 작성되었다면,

```java
public class Calculator {
    static double pi = 3.14159;
    static int plus(int x, int y) { ... }
    static int minus(int x, int y) { ... }
}
```

정적 필드 `pi`와 정적 메소드 `plus()`, `minus()`는 다음과 같이 사용할 수 있다.

```java
double result1 = 10 * 10 * Calculator.pi;
int result2 = Calculator.plus(10, 5);
int result3 = Calculator.minus(10, 5);
```

정적 필드와 정적 메소드는 다음과 같이 객체 참조 변수로도 접근이 가능하다.

```java
Calculator myCalcu = new Calculator();
double result1 = 10 * 10 * myCalcu.pi;
int result2 = myCalcu.plus(10, 5);
int result3 = myCalcu.minus(10, 5);
```

하지만 정적 요소는 클래스 이름으로 접근하는 것이 정석이다. 이클립스에서는 정적 멤버를 객체 참조 변수로 접근했을 경우, 경고 표시(![warning])를 낸다.

**Calculator.java**
```java
package ch06.sec10.exam01;

public class Calculator {
	static double pi = 3.14159;
	
	static int plus(int x, int y) {
		return x + y;
	}
	
	static int minus(int x, int y) {
		return x - y;
	}
}
```

**CalculatorExample.java**
```java
package ch06.sec10.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}
}
```

**실행 결과**
```
result1 : 314.159
result2 : 15
result3 : 5
```

## 정적 블록

정적 필드는 다음과 같이 필드 선언과 동시에 초기값을 주는 것이 일반적이다.

```java
static double pi = 3.14159;
```

하지만 복잡한 초기화 작업이 필요하다면 정적 블록(`static block`)을 이용해야 한다. 다음은 정적 블록의 형태를 보여 준다.

```java
static {
    // ...
}
```

정적 블록은 클래스가 메모리로 로딩될 때 자동으로 실행된다. 정적 블록이 클래스 내부에 여러 개가 선언되어 있을 경우에는 선언된 순서대로 실행된다.

> **생성자에서 초기화를 하지 않는 정적 필드**
> 정적 필드는 객체 생성 없이도 사용할 수 있기 때문에 생성자에서 초기화 작업을 하지 않는다. 생성자는 객체 생성 후 실행되기 때문이다.

다음 예제를 보면 `Television`은 3개의 정적 필드를 가지고 있다. `company`와 `model`은 선언 시 초기값을 주었고, `info`는 정적 블록에서 `company`와 `model`을 서로 연결하여 초기값으로 주었다.

**Television.java**
```java
package ch06.sec10.exam02;

public class Television {
	static String company = "MyCompany";
	static String model = "LCD";
	static String info;
	
	static {
		info = company + "-" + model;
	}
}
```

**TelevisionExample.java**
```java
package ch06.sec10.exam02;

public class TelevisionExample {
	public static void main(String[] args) {
		System.out.println(Television.info);
	}
}
```

**실행 결과**
```
MyCompany-LCD
```

## 인스턴스 멤버 사용 불가

정적 메소드와 정적 블록은 객체가 없어도 실행된다는 특징 때문에 내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없다. 또한 객체 자신의 참조인 `this`도 사용할 수 없다.

```java
public class ClassName {
    // 인스턴스 필드와 메소드 선언
    int field1;
    void method1() { ... }
    
    // 정적 필드와 메소드 선언
    static int field2;
    static void method2() { ... }
    
    // 정적 블록 선언
    static {
        field1 = 10; // (x) 컴파일 에러
        method1(); // (x)
        field2 = 10; // (o)
        method2(); // (o)
    }
    
    // 정적 메소드 선언
    static void method3() {
        this.field1 = 10; // (x) 컴파일 에러
        this.method1(); // (x)
        field2 = 10; // (o)
        method2(); // (o)
    }
}
```

정적 메소드와 정적 블록에서 인스턴스 멤버를 사용하고 싶다면 다음과 같이 객체를 먼저 생성하고 참조 변수로 접근해야 한다.

```java
static void method3() {
    // 객체 생성
    ClassName obj = new ClassName();
    // 인스턴스 멤버 사용
    obj.field1 = 10;
    obj.method1();
}
```

`main()` 메소드도 동일한 규칙이 적용된다. `main()` 메소드도 정적 메소드이므로 객체 생성 없이 인스턴스 필드와 인스턴스 메소드를 `main()` 메소드에서 바로 사용할 수 없다. 따라서 다음과 같이 작성하면 컴파일 에러가 발생한다.

```java
public class Car {
    // 인스턴스 필드 선언
    int speed;
    
    // 인스턴스 메소드 선언
    void run() { ... }
    
    // 메인 메소드 선언
    public static void main(String[] args) {
        speed = 60; // (x) 컴파일 에러
        run(); // (x)
    }
}
```

`main()` 메소드를 올바르게 수정하면 다음과 같다.

```java
public static void main(String[] args) {
    // 객체 생성
    Car myCar = new Car();
    // 인스턴스 멤버 사용
    myCar.speed = 60;
    myCar.run();
}
```

**Car.java**
```java
package ch06.sec10.exam03;

public class Car {
	// 인스턴스 필드 선언
	int speed;
	
	// 인스턴스 메소드 선언
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}
	
	static void simulate() {
		// 객체 생성
		Car myCar = new Car();
		// 인스턴스 멤버 사용
		myCar.speed = 200;
		myCar.run();
	}
	
	public static void main(String[] args) {
		// 정적 메소드 호출
		simulate();
		
		// 객체 생성
		Car myCar = new Car();
		// 인스턴스 멤버 사용
		myCar.speed = 60;
		myCar.run();
	}
}
```

**실행 결과**
```
200으로 달립니다.
60으로 달립니다.
```
