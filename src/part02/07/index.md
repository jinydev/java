---
layout: part02
title: Chapter 07. 상속
---

# Chapter 07. 상속

## 7.1 상속 개념

상속(Inheritance)은 부모가 자식에게 물려주는 행위를 말한다. 객체지향 프로그램에서도 부모 클래스의 필드와 메소드를 자식 클래스에게 물려줄 수 있다.

상속은 이미 잘 개발된 클래스를 재사용해서 새로운 클래스를 만들기 때문에 중복되는 코드를 줄여 개발 시간을 단축시킨다. 예를 들어 다음 그림처럼 자식 클래스(B)에서 처음부터 필드와 메소드 4개를 작성하는 것보다는 field1과 method1을 부모 클래스(A)에서 상속받고 field2와 method2만 추가 작성하는 것이 보다 효율적이다.

**부모 클래스 (A.java)**
```java
public class A {
    int field1;
    void method1() { ... }
}
```

**자식 클래스 (B.java)**
```java
public class B extends A {
    String field2;
    void method2() { ... }
}
```

실제로 B 클래스를 객체 생성해서 다음과 같이 사용할 때는 마치 B가 field1과 method1을 가지고 있는 것처럼 보인다.

```java
B b = new B();
b.field1 = 10;
b.method1();   // A로부터 물려받은 필드와 메소드
b.field2 = "홍길동";
b.method2();   // B가 추가한 필드와 메소드
```

상속의 또 다른 이점은 클래스의 수정을 최소화할 수 있다는 것이다. 부모 클래스를 수정하면 모든 자식 클래스에 수정 효과를 가져온다. 예를 들어 B, C가 A를 상속할 경우 A의 필드와 메소드를 수정하면 B, C를 수정하지 않아도 수정된 A의 필드와 메소드를 이용할 수 있다.

## 7.2 클래스 상속

현실에서의 상속은 부모가 자식을 선택해서 물려주지만, 프로그램에서는 자식이 부모를 선택한다. 자식 클래스를 선언할 때 어떤 부모로부터 상속받을 것인지를 결정하고, 부모 클래스를 다음과 같이 extends 뒤에 기술한다.

```java
public class 자식클래스 extends 부모클래스 {
}
```

다른 언어와는 달리 자바는 다중 상속을 허용하지 않는다. 즉, 여러 개의 부모 클래스를 상속할 수 없다. 따라서 extends 뒤에는 단 하나의 부모 클래스만이 와야 한다.

```java
public class 자식클래스 extends 부모클래스1, 부모클래스2 { // x
}
```

다음 예제는 Phone 클래스를 상속해서 SmartPhone 클래스를 작성한 것이다.

**Phone.java**
```java
package ch07.sec02;

public class Phone {
	// 필드 선언
	public String model;
	public String color;
	
	// 메소드 선언
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
```

**SmartPhone.java**
```java
package ch07.sec02;

public class SmartPhone extends Phone {
	// 필드 선언
	public boolean wifi;
	
	// 생성자 선언
	public SmartPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	// 메소드 선언
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}
```

**SmartPhoneExample.java**
```java
package ch07.sec02;

public class SmartPhoneExample {
	public static void main(String[] args) {
		// SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// Phone으로부터 상속받은 필드 읽기
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
		
		// SmartPhone의 필드 읽기
		System.out.println("와이파이 상태: " + myPhone.wifi);
		
		// Phone으로부터 상속받은 메소드 호출
		myPhone.bell();
		myPhone.sendVoice("여보세요.");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		myPhone.sendVoice("아~ 네. 반갑습니다.");
		myPhone.hangUp();
		
		// SmartPhone의 메소드 호출
		myPhone.setWifi(true);
		myPhone.internet();
	}
}
```

**실행 결과**
```
모델: 갤럭시
색상: 은색
와이파이 상태: false
벨이 울립니다.
자기: 여보세요.
상대방: 안녕하세요! 저는 홍길동인데요.
자기: 아~ 네. 반갑습니다.
전화를 끊습니다.
와이파이 상태를 변경했습니다.
인터넷에 연결합니다.
```

## 7.3 부모 생성자 호출

현실에서 부모 없는 자식이 있을 수 없듯이 자바에서도 자식 객체를 생성하면 부모 객체가 먼저 생성된 다음에 자식 객체가 생성된다. 다음 코드는 SmartPhone 객체만 생성되는 것처럼 보이지만, 사실은 부모인 Phone 객체가 먼저 생성되고 그 다음에 자식인 SmartPhone 객체가 생성된 것이다.

```java
자식클래스 변수 = new 자식클래스();
```

모든 객체는 생성자를 호출해야만 생성된다. 부모 객체도 예외는 아니다. 그렇다면 부모 객체의 생성자는 어디서 호출된 것일까? 이것에 대한 비밀은 자식 생성자에 숨어 있다. 부모 생성자는 자식 생성자의 맨 첫 줄에 숨겨져 있는 super()에 의해 호출된다.

```java
// 자식 생성자 선언
public 자식클래스(...) {
    super();
}
```

super()는 컴파일 과정에서 자동 추가되는데, 이것은 부모의 기본 생성자를 호출한다. 만약 부모 클래스에 기본 생성자가 없다면 자식 생성자 선언에서 컴파일 에러가 발생한다.

부모 클래스에 기본 생성자가 없고 매개변수를 갖는 생성자만 있다면 개발자는 다음과 같이 super(매개값, ...) 코드를 직접 넣어야 한다. 이 코드는 매개값의 타입과 개수가 일치하는 부모 생성자를 호출한다.

```java
// 자식 생성자 선언
public 자식클래스(...) {
    super(매개값, ...);
}
```

다음 예제는 부모 클래스가 기본 생성자를 가지고 있는 경우이다.

**Phone.java**
```java
package ch07.sec03.exam01;

public class Phone {
	// 필드 선언
	public String model;
	public String color;
	
	// 기본 생성자 선언
	public Phone() {
		System.out.println("Phone() 생성자 실행");
	}
}
```

**SmartPhone.java**
```java
package ch07.sec03.exam01;

public class SmartPhone extends Phone {
	// 자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(); // 생략 가능(컴파일 시 자동 추가됨)
		this.model = model;
		this.color = color;
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
```

**SmartPhoneExample.java**
```java
package ch07.sec03.exam01;

public class SmartPhoneExample {
	public static void main(String[] args) {
		// SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// Phone으로부터 상속받은 필드 읽기
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
	}
}
```

**실행 결과**
```
Phone() 생성자 실행
SmartPhone(String model, String color) 생성자 실행됨
모델: 갤럭시
색상: 은색
```

다음 예제는 부모 클래스가 매개변수를 갖는 생성자가 있는 경우이다.

**Phone.java**
```java
package ch07.sec03.exam02;

public class Phone {
	// 필드 선언
	public String model;
	public String color;
	
	// 매개변수를 갖는 생성자 선언
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("Phone(String model, String color) 생성자 실행");
	}
}
```

**SmartPhone.java**
```java
package ch07.sec03.exam02;

public class SmartPhone extends Phone {
	// 자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(model, color); // 반드시 작성해야 함
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
```

**SmartPhoneExample.java**
```java
package ch07.sec03.exam02;

public class SmartPhoneExample {
	public static void main(String[] args) {
		// SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// Phone으로부터 상속받은 필드 읽기
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
	}
}
```

**실행 결과**
```
Phone(String model, String color) 생성자 실행
SmartPhone(String model, String color) 생성자 실행됨
모델: 갤럭시
색상: 은색
```

## 7.4 메소드 재정의

부모 클래스의 모든 메소드가 자식 클래스에게 맞게 설계되어 있다면 가장 이상적인 상속이지만, 어떤 메소드는 자식 클래스가 사용하기에 적합하지 않을 수 있다. 이러한 메소드는 자식 클래스에서 재정의해서 사용해야 한다. 이것을 메소드 오버라이딩(Overriding)이라고 한다.

### 메소드 오버라이딩

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
- 접근 제한을 더 강하게 오버라이딩할 수 없다(public -> private으로 변경 불가).
- 새로운 예외를 throws할 수 없다(예외는 10장에서 학습한다).

다음 예제를 보면 Calculator는 원의 넓이를 구하는 areaCircle() 메소드를 가지고 있다. 하지만 원주율 파이가 정확하지 않기 때문에 자식 클래스인 Computer에서 오버라이딩해서 좀 더 정확한 원주율 파이 상수(Math.PI)를 사용해 원의 넓이를 구하도록 했다.

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

자바는 개발자의 실수를 줄여주기 위해 정확히 오버라이딩이 되었는지 체크해주는 @Override 어노테이션을 제공한다. @Override를 붙이면 컴파일 단계에서 정확히 오버라이딩이 되었는지 체크하고, 문제가 있다면 컴파일 에러를 출력한다.

### 부모 메소드 호출

메소드를 재정의하면, 부모 메소드는 숨겨지고 자식 메소드만 사용되기 때문에 비록 부모 메소드의 일부만 변경된다 하더라도 중복된 내용을 자식 메소드도 가지고 있어야 한다. 예를 들어 부모 메소드가 100줄의 코드를 가지고 있을 경우, 자식 메소드에서 1줄만 추가하고 싶더라도 100줄의 코드를 자식 메소드에서 다시 작성해야 한다.

이 문제는 자식 메소드와 부모 메소드의 공동 작업 처리 기법을 이용하면 매우 쉽게 해결된다. 자식 메소드 내에서 부모 메소드를 호출하는 것인데, 다음과 같이 super 키워드와 도트(.) 연산자를 사용하면 숨겨진 부모 메소드를 호출할 수 있다.

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

super.method()의 위치는 작업 처리 2 전후에 어디든지 올 수 있다. 우선 처리가 되어야 할 내용을 먼저 작성하면 된다. 이 방법은 부모 메소드를 재사용함으로써 자식 메소드의 중복 작업 내용을 없애는 효과를 가져온다.

다음 예제를 보면 Airplane의 fly() 메소드를 자식 클래스인 SupersonicAirplane에서 오버라이딩했다. 따라서 일반 비행 모드일 때는 Airplane의 fly()를 사용하고, 초음속 비행 모드일 때는 오버라이딩된 SupersonicAirplane의 fly()를 사용한다.

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

## 7.5 final 클래스와 final 메소드

우리가 6장 11절에서 살펴보았듯이, 필드 선언 시에 final을 붙이면 초기값 설정 후 값을 변경할 수 없다. 그렇다면 클래스와 메소드에 final을 붙이면 어떤 효과가 일어날까? final 클래스와 final 메소드는 상속과 관련이 있다.

### final 클래스

클래스를 선언할 때 final 키워드를 class 앞에 붙이면 최종적인 클래스이므로 더 이상 상속할 수 없는 클래스가 된다. 즉 final 클래스는 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없다.

```java
public final class 클래스 { ... }
```

대표적인 예가 String 클래스이다. String 클래스는 다음과 같이 선언되어 있다.

```java
public final class String { ... }
```

그래서 다음과 같이 자식 클래스를 만들 수 없다.

```java
public class NewString extends String { ... } // x
```

다음 예제는 Member 클래스를 선언할 때 final을 지정함으로써 Member를 상속해 VeryImportantPerson을 선언할 수 없음을 보여 준다.

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

### final 메소드

메소드를 선언할 때 final 키워드를 붙이면 이 메소드는 최종적인 메소드이므로 오버라이딩할 수 없는 메소드가 된다. 즉 부모 클래스를 상속해서 자식 클래스를 선언할 때, 부모 클래스에 선언된 final 메소드는 자식 클래스에서 재정의할 수 없다.

```java
public final 리턴타입 메소드(매개변수, ...) { ... }
```

다음 예제는 Car 클래스의 stop() 메소드를 final로 선언했기 때문에 자식 클래스인 SportsCar에서 stop() 메소드를 오버라이딩할 수 없음을 보여 준다.

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

## 7.6 protected 접근 제한자

우리는 6.13절에서 public, private 접근 제한자를 사용해 객체 외부에서 필드, 생성자, 메소드의 접근 여부를 결정했다. 이번 절에서는 또 하나의 접근 제한자인 protected에 대해 알아본다. protected는 상속과 관련이 있고, public과 default의 중간쯤에 해당하는 접근 제한을 한다.

| 접근 제한자 | 적용 대상            | 접근할 수 있는 범위                      |
| ----------- | -------------------- | ---------------------------------------- |
| protected   | 필드, 생성자, 메소드 | 같은 패키지이거나, 자식 객체만 사용 가능 |

protected는 같은 패키지에서는 default처럼 접근이 가능하나, 다른 패키지에서는 자식 클래스만 접근을 허용한다. protected는 필드와 생성자 그리고 메소드 선언에 사용될 수 있다.

다음 A 클래스를 보면 protected로 선언된 필드, 생성자, 메소드가 있다.

**A.java**
```java
package ch07.sec06.package1;

public class A {
	// 필드 선언
	protected String field;
	
	// 생성자 선언
	protected A() {
	}
	
	// 메소드 선언
	protected void method() {
	}
}
```

다음 B 클래스는 A 클래스와 동일한 패키지에 있기 때문에 A의 protected 필드, 생성자, 메소드에 접근이 가능하다.

**B.java**
```java
package ch07.sec06.package1;

public class B {
	// 메소드 선언
	public void method() {
		A a = new A(); // (o)
		a.field = "value"; // (o)
		a.method(); // (o)
	}
}
```

다음 C 클래스는 A 클래스와 다른 패키지에 있기 때문에 A의 protected 필드, 생성자, 메소드에 접근할 수 없다.

**C.java**
```java
package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class C {
	// 메소드 선언
	public void method() {
		// A a = new A(); // (x)
		// a.field = "value"; // (x)
		// a.method(); // (x)
	}
}
```

다음 D 클래스는 A 클래스와 다른 패키지에 있지만 A의 자식 클래스이므로 A의 protected 필드, 생성자, 메소드에 접근이 가능하다. 단 new 연산자를 사용해서 생성자를 직접 호출할 수는 없고, 자식 생성자에서 super()로 A 생성자를 호출할 수 있다.

**D.java**
```java
package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class D extends A {
	// 생성자 선언
	public D() {
		// A() 생성자 호출
		super(); // (o)
	}
	
	// 메소드 선언
	public void method1() {
		// A 필드값 변경
		this.field = "value"; // (o)
		// A 메소드 호출
		this.method(); // (o)
	}
	
	// 메소드 선언
	public void method2() {
		// A a = new A(); // (x)
		// a.field = "value"; // (x)
		// a.method(); // (x)
	}
}
```

## 7.7 타입 변환

타입 변환이란 타입을 다른 타입으로 변환하는 것을 말한다. 기본 타입의 변환에 대해서는 이미 2.7-8절에서 학습한 바 있다. 클래스도 마찬가지로 타입 변환이 있는데, 클래스의 타입 변환은 상속 관계에 있는 클래스 사이에서 발생한다.

### 자동 타입 변환

자동 타입 변환(Promotion)은 의미 그대로 자동적으로 타입 변환이 일어나는 것을 말한다. 자동 타입 변환은 다음과 같은 조건에서 일어난다.

```java
부모타입 변수 = 자식타입객체;
```

자식은 부모의 특징과 기능을 상속받기 때문에 부모와 동일하게 취급될 수 있다. 예를 들어 고양이가 동물의 특징과 기능을 상속받았다면 '고양이는 동물이다'가 성립한다.

```java
class Animal {
}

class Cat extends Animal {
}
```

그래서 Cat 객체를 생성하고 이것을 Animal 변수에 대입하면 자동 타입 변환이 일어난다.

```java
Cat cat = new Cat();
Animal animal = cat;
// Animal animal = new Cat();
```

위 코드로 생성되는 메모리 상태를 그림으로 묘사하면 다음과 같다. cat과 animal 변수는 타입만 다를 뿐, 동일한 Cat 객체를 참조한다.

따라서 두 참조 변수의 == 연산 결과는 true가 나온다.

```java
cat == animal // true
```

바로 위의 부모가 아니더라도 상속 계층에서 상위 타입이라면 자동 타입 변환이 일어날 수 있다.

```java
class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends C {}

public class PromotionExample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E(); 
        
        A a1 = b;
        A a2 = c;
        A a3 = d;
        A a4 = e;
        
        B b1 = d;
        C c1 = e;
        
        // B b3 = e; // (x) 상속 관계 아님
        // C c2 = d; // (x) 상속 관계 아님
    }
}
```

부모 타입으로 자동 타입 변환된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.

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
        Parent parent = child;
        
        parent.method1();
        parent.method2();
        // parent.method3(); // (호출 불가능)
    }
}
```

그러나 자식 클래스에서 오버라이딩된 메소드가 있다면 부모 메소드 대신 오버라이딩된 메소드가 호출된다. 이것은 다형성(Polymorphism)과 관련 있기 때문에 잘 알아두어야 한다.

**Parent.java**
```java
package ch07.sec07.exam02;

public class Parent {
	// 메소드 선언
	public void method1() {
		System.out.println("Parent-method1()");
	}
	
	// 메소드 선언
	public void method2() {
		System.out.println("Parent-method2()");
	}
}
```

**Child.java**
```java
package ch07.sec07.exam02;

public class Child extends Parent {
	// 메소드 오버라이딩
	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}
	
	// 메소드 선언
	public void method3() {
		System.out.println("Child-method3()");
	}
}
```

**ChildExample.java**
```java
package ch07.sec07.exam02;

public class ChildExample {
	public static void main(String[] args) {
		// 자식 객체 생성
		Child child = new Child();
		
		// 자동 타입 변환
		Parent parent = child;
		
		// 메소드 호출
		parent.method1();
		parent.method2();
		// parent.method3(); // (호출 불가능)
	}
}
```

**실행 결과**
```
Parent-method1()
Child-method2()
```

### 강제 타입 변환

자식 타입은 부모 타입으로 자동 변환되지만, 반대로 부모 타입은 자식 타입으로 자동 변환되지 않는다. 대신 다음과 같이 캐스팅 연산자로 강제 타입 변환(Casting)을 할 수 있다.

```java
자식타입 변수 = (자식타입) 부모타입객체;
```

그렇다고 해서 부모 타입 객체를 자식 타입으로 무조건 강제 변환할 수 있는 것은 아니다. 자식 객체가 부모 타입으로 자동 변환된 후 다시 자식 타입으로 변환할 때 강제 타입 변환을 사용할 수 있다.

```java
Parent parent = new Child(); // 자동 타입 변환
Child child = (Child) parent; // 강제 타입 변환
```

자식 객체가 부모 타입으로 자동 변환하면 부모 타입에 선언된 필드와 메소드만 사용 가능하다는 제약 사항이 따른다. 만약 자식 타입에 선언된 필드와 메소드를 꼭 사용해야 한다면 강제 타입 변환을 해서 다시 자식 타입으로 변환해야 한다.

**Parent.java**
```java
package ch07.sec07.exam03;

public class Parent {
	// 필드 선언
	public String field1;
	
	// 메소드 선언
	public void method1() {
		System.out.println("Parent-method1()");
	}
	
	// 메소드 선언
	public void method2() {
		System.out.println("Parent-method2()");
	}
}
```

**Child.java**
```java
package ch07.sec07.exam03;

public class Child extends Parent {
	// 필드 선언
	public String field2;
	
	// 메소드 선언
	public void method3() {
		System.out.println("Child-method3()");
	}
}
```

**ChildExample.java**
```java
package ch07.sec07.exam03;

public class ChildExample {
	public static void main(String[] args) {
		// 객체 생성 및 자동 타입 변환
		Parent parent = new Child();
		
		// Parent 타입으로 필드와 메소드 사용
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		/*
		parent.field2 = "data2"; // (불가능)
		parent.method3(); // (불가능)
		*/
		
		// 강제 타입 변환
		Child child = (Child) parent;
		
		// Child 타입으로 필드와 메소드 사용
		child.field2 = "data2"; // (가능)
		child.method3(); // (가능)
	}
}
```

**실행 결과**
```
Parent-method1()
Parent-method2()
Child-method3()
```

## 7.8 다형성

다형성(Polymorphism)이란 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질을 말한다. 자동차의 부품을 교환하면 성능이 다르게 나오듯이 객체는 부품과 같아서, 프로그램을 구성하는 객체를 바꾸면 프로그램의 실행 성능이 다르게 나올 수 있다.

객체 사용 방법이 동일하다는 것은 동일한 메소드를 가지고 있다는 뜻이다. 한국 타이어와 금호 타이어는 모두 타이어를 상속하고 있다면, 한국 타이어와 금호 타이어는 타이어(부모)의 메소드를 동일하게 가지고 있다고 말할 수 있다.

만약 한국 타이어와 금호 타이어가 타이어(부모)의 메소드를 오버라이딩하고 있다면, 타이어 메소드 호출 시 오버라이딩된 메소드가 호출된다. 오버라이딩된 내용은 두 타이어가 다르기 때문에 실행 결과가 다르게 나온다. 이것이 바로 다형성이다.

다형성을 구현하기 위해서는 자동 타입 변환과 메소드 재정의가 필요하다.

### 필드 다형성

필드 다형성은 필드 타입은 동일하지만(사용 방법은 동일하지만), 대입되는 객체가 달라져서 실행 결과가 다양하게 나올 수 있는 것을 말한다. 다음 Car 클래스를 보면서 이해해 보자.

```java
public class Car {
    // 필드 선언
    public Tire tire;
    
    // 메소드 선언
    public void run() {
        tire.roll();
    }
}
```

Car 클래스에는 Tire 필드가 선언되어 있다. 먼저 Car 객체를 생성한 후 타이어를 장착하기 위해 다음과 같이 HankookTire 또는 KumhoTire 객체를 Tire 필드에 대입할 수 있다. 왜냐하면 자동 타입 변환이 되기 때문이다.

```java
// Car 객체 생성
Car myCar = new Car();
// HankookTire 장착
myCar.tire = new HankookTire();
// KumhoTire 장착
myCar.tire = new KumhoTire();
```

Car 클래스의 run() 메소드는 tire 필드에 대입된 객체의 roll() 메소드를 호출한다. 만약 HankookTire와 KumhoTire가 roll() 메소드를 재정의하고 있다면, 재정의된 roll() 메소드가 호출된다.

```java
myCar.run();
```

따라서 어떤 타이어를 장착했는지에 따라 roll() 메소드의 실행 결과는 달라지게 된다. 이것이 바로 필드의 다형성이다. 예제를 통해 확인해 보자.

**Tire.java**
```java
package ch07.sec08.exam01;

public class Tire {
	// 메소드 선언
	public void roll() {
		System.out.println("회전합니다.");
	}
}
```

**HankookTire.java**
```java
package ch07.sec08.exam01;

public class HankookTire extends Tire {
	// 메소드 재정의(오버라이딩)
	@Override
	public void roll() {
		System.out.println("한국 타이어가 회전합니다.");
	}
}
```

**KumhoTire.java**
```java
package ch07.sec08.exam01;

public class KumhoTire extends Tire {
	// 메소드 재정의(오버라이딩)
	@Override
	public void roll() {
		System.out.println("금호 타이어가 회전합니다.");
	}
}
```

**Car.java**
```java
package ch07.sec08.exam01;

public class Car {
	// 필드 선언
	public Tire tire;
	
	// 메소드 선언
	public void run() {
		// tire 필드에 대입된 객체의 roll() 메소드 호출
		tire.roll();
	}
}
```

**CarExample.java**
```java
package ch07.sec08.exam01;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();
		
		// Tire 객체 장착
		myCar.tire = new Tire();
		myCar.run();
		
		// HankookTire 객체 장착
		myCar.tire = new HankookTire();
		myCar.run();
		
		// KumhoTire 객체 장착
		myCar.tire = new KumhoTire();
		myCar.run();
	}
}
```

**실행 결과**
```
회전합니다.
한국 타이어가 회전합니다.
금호 타이어가 회전합니다.
```

### 매개변수 다형성

다형성은 필드보다는 메소드를 호출할 때 많이 발생한다. 메소드가 클래스 타입의 매개변수를 가지고 있을 경우, 호출할 때 동일한 타입의 객체를 제공하는 것이 정석이지만 자식 객체를 제공할 수도 있다. 여기서 다형성이 발생한다.

다음과 같이 Driver라는 클래스가 있고, Vehicle 매개변수를 갖는 drive() 메소드가 정의되어 있다고 가정해 보자. drive() 메소드는 매개값으로 전달받은 vehicle의 run() 메소드를 호출한다.

```java
public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.run();
    }
}
```

일반적으로 drive() 메소드를 호출한다면 다음과 같이 Vehicle 객체를 제공할 것이다.

```java
Driver driver = new Driver();
Vehicle vehicle = new Vehicle();
driver.drive(vehicle);
```

그러나 매개값으로 Vehicle 객체만 제공할 수 있는 것은 아니다. 자동 타입 변환으로 인해 Vehicle의 자식 객체도 제공할 수 있다.

```java
Driver driver = new Driver();
Bus bus = new Bus();
driver.drive(bus); // Vehicle vehicle = bus; 자동 타입 변환 발생
```

drive() 메소드는 매개변수 vehicle이 참조하는 객체의 run() 메소드를 호출하는데, 자식 객체가 run() 메소드를 재정의하고 있다면 재정의된 run() 메소드가 호출된다. 그러므로 어떤 자식 객체가 제공되느냐에 따라서 drive()의 실행 결과는 달라진다. 이것이 매개변수의 다형성이다.

**Vehicle.java**
```java
package ch07.sec08.exam02;

public class Vehicle {
	// 메소드 선언
	public void run() {
		System.out.println("차량이 달립니다.");
	}
}
```

**Bus.java**
```java
package ch07.sec08.exam02;

public class Bus extends Vehicle {
	// 메소드 재정의(오버라이딩)
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
}
```

**Taxi.java**
```java
package ch07.sec08.exam02;

public class Taxi extends Vehicle {
	// 메소드 재정의(오버라이딩)
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
}
```

**Driver.java**
```java
package ch07.sec08.exam02;

public class Driver {
	// 메소드 선언(클래스 타입의 매개변수를 가지고 있음)
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}
```

**DriverExample.java**
```java
package ch07.sec08.exam02;

public class DriverExample {
	public static void main(String[] args) {
		// Driver 객체 생성
		Driver driver = new Driver();
		
		// 매개값으로 Bus 객체를 제공하고 drive() 메소드 호출
		Bus bus = new Bus();
		driver.drive(bus);
		
		// 매개값으로 Taxi 객체를 제공하고 drive() 메소드 호출
		Taxi taxi = new Taxi();
		driver.drive(taxi);
	}
}
```

**실행 결과**
```
버스가 달립니다.
택시가 달립니다.
```

## 7.9 객체 타입 확인

매개변수의 다형성에서 실제로 어떤 객체가 매개값으로 제공되었는지 확인하는 방법이 있다. 꼭 매개변수가 아니더라도 변수가 참조하는 객체의 타입을 확인하고자 할 때, instanceof 연산자를 사용할 수 있다.

instanceof 연산자의 좌항에는 객체가 오고 우항에는 타입이 오는데, 좌항의 객체가 우항의 타입이면 true를 산출하고 그렇지 않으면 false를 산출한다.

```java
boolean result = 객체 instanceof 타입;
```

예를 들어 다음 코드는 Child 타입으로 강제 타입 변환하기 전에 매개값이 Child 타입인지 여부를 instanceof 연산자로 확인한다. Child 타입이 아니라면 강제 타입 변환을 할 수 없기 때문이다. 강제 타입 변환을 하는 이유는 Child 객체의 모든 멤버(필드, 메소드)에 접근하기 위해서이다.

```java
public void method(Parent parent) {
    if (parent instanceof Child) {
        Child child = (Child) parent;
        // child 변수 사용
    }
}
```

Java 12부터는 instanceof 연산의 결과가 true일 경우, 우측 타입 변수를 사용할 수 있기 때문에 강제 타입 변환이 필요 없다.

```java
if (parent instanceof Child child) {
    // child 변수 사용
}
```

다음은 personInfo() 메소드의 매개값으로 Student를 제공했을 경우에만 studentNo를 출력하고 study() 메소드를 호출한다.

**InstanceofExample.java**
```java
package ch07.sec09;

public class InstanceofExample {
	// main() 메소드에서 바로 호출하기 위해 정적 메소드 선언
	public static void personInfo(Person person) {
		System.out.println("name: " + person.name);
		person.walk();
		
		// person이 참조하는 객체가 Student 타입인지 확인
		/*
		if (person instanceof Student) {
			// Student 객체일 경우 강제 타입 변환
			Student student = (Student) person;
			// Student 객체만 가지고 있는 필드 및 메소드 사용
			System.out.println("studentNo: " + student.studentNo);
			student.study();
		}
		*/
		
		// person이 참조하는 객체가 Student 타입일 경우
		// student 변수에 대입(타입 변환 발생)
		if (person instanceof Student student) {
			System.out.println("studentNo: " + student.studentNo);
			student.study();
		}
	}
	
	public static void main(String[] args) {
		// Person 객체를 매개값으로 제공하고 personInfo() 메소드 호출
		Person p1 = new Person("홍길동");
		personInfo(p1);
		
		System.out.println();
		
		// Student 객체를 매개값으로 제공하고 personInfo() 메소드 호출
		Person p2 = new Student("김길동", 10);
		personInfo(p2);
	}
}
```

**Person.java**
```java
package ch07.sec09;

public class Person {
	// 필드 선언
	public String name;
	
	// 생성자 선언
	public Person(String name) {
		this.name = name;
	}
	
	// 메소드 선언
	public void walk() {
		System.out.println("걷습니다.");
	}
}
```

**Student.java**
```java
package ch07.sec09;

public class Student extends Person {
	// 필드 선언
	public int studentNo;
	
	// 생성자 선언
	public Student(String name, int studentNo) {
		super(name);
		this.studentNo = studentNo;
	}
	
	// 메소드 선언
	public void study() {
		System.out.println("공부를 합니다.");
	}
}
```

**실행 결과**
```
name: 홍길동
걷습니다.

name: 김길동
걷습니다.
studentNo: 10
공부를 합니다.
```

## 7.10 추상 클래스

사전적 의미로 추상(abstract)은 실체 간에 공통되는 특성을 추출한 것을 말한다. 예를 들어 새, 곤충, 물고기 등의 공통점은 동물이다. 여기서 동물은 실체들의 공통되는 특성을 가지고 있는 추상적인 것이라고 볼 수 있다.

### 추상 클래스란?

객체를 생성할 수 있는 클래스를 실체 클래스라고 한다면, 이 클래스들의 공통적인 필드나 메소드를 추출해서 선언한 클래스를 추상 클래스라고 한다. 추상 클래스는 실체 클래스의 부모 역할을 한다. 따라서 실체 클래스는 추상 클래스를 상속해서 공통적인 필드나 메소드를 물려받을 수 있다.

예를 들어 Bird, Insect, Fish와 같은 실체 클래스에서 공통되는 필드와 메소드를 따로 선언한 Animal 클래스를 만들 수 있고, 이것을 상속해서 실체 클래스를 만들 수 있다.

추상 클래스는 실체 클래스의 공통되는 필드와 메소드를 추출해서 만들었기 때문에 new 연산자를 사용해서 객체를 직접 생성할 수 없다.

```java
Animal animal = new Animal(); // (x)
```

추상 클래스는 새로운 실체 클래스를 만들기 위한 부모 클래스로만 사용된다. 즉, 추상 클래스는 extends 뒤에만 올 수 있다.

```java
class Fish extends Animal {
}
```

### 추상 클래스 선언

클래스 선언에 abstract 키워드를 붙이면 추상 클래스 선언이 된다. 추상 클래스는 new 연산자를 이용해서 객체를 직접 만들지 못하고 상속을 통해 자식 클래스만 만들 수 있다.

```java
public abstract class 클래스명 {
    // 필드
    // 생성자
    // 메소드
}
```

추상 클래스도 필드, 메소드를 선언할 수 있다. 그리고 자식 객체가 생성될 때 super()로 추상 클래스의 생성자가 호출되기 때문에 생성자도 반드시 있어야 한다. 다음은 모든 전화기의 공통 필드와 메소드만 뽑아내어 추상 클래스 Phone으로 선언한 것이다.

**Phone.java**
```java
package ch07.sec10.exam01;

public abstract class Phone {
	// 필드 선언
	String owner;
	
	// 생성자 선언
	Phone(String owner) {
		this.owner = owner;
	}
	
	// 메소드 선언
	void turnOn() {
		System.out.println("폰 전원을 니다.");
	}
	
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
```

그렇다면 새로운 전화기 클래스는 추상 클래스인 Phone으로부터 공통 필드와 메소드를 물려받고 특화된 필드와 메소드를 작성할 수 있다. 다음은 Phone을 상속해서 SmartPhone을 설계한 것이다.

**SmartPhone.java**
```java
package ch07.sec10.exam01;

public class SmartPhone extends Phone {
	// 생성자 선언
	SmartPhone(String owner) {
		// Phone 생성자 호출
		super(owner);
	}
	
	// 메소드 선언
	void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
}
```

Phone 객체는 new 연산자로 직접 생성할 수는 없지만 자식 객체인 SmartPhone은 new 연산자로 객체 생성이 가능하고, Phone으로부터 물려받은 turnOn()과 turnOff() 메소드를 호출할 수 있다.

**PhoneExample.java**
```java
package ch07.sec10.exam01;

public class PhoneExample {
	public static void main(String[] args) {
		// Phone phone = new Phone(); // (x)
		
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn(); // Phone의 메소드
		smartPhone.internetSearch();
		smartPhone.turnOff(); // Phone의 메소드
	}
}
```

**실행 결과**
```
폰 전원을 니다.
인터넷 검색을 합니다.
폰 전원을 끕니다.
```

### 추상 메소드와 재정의

자식 클래스들이 가지고 있는 공통 메소드를 뽑아내어 추상 클래스로 작성할 때, 메소드 선언부(리턴 타입, 메소드명, 매개변수)만 동일하고 실행 내용은 자식 클래스마다 달라야 하는 경우가 많다.

예를 들어 동물은 소리를 내기 때문에 Animal 추상 클래스에서 sound()라는 메소드를 선언할 수 있지만, 실행 내용인 소리는 동물마다 다르기 때문에 추상 클래스에서 통일하여 작성할 수 없다.

이런 경우를 위해서 추상 클래스는 다음과 같은 추상 메소드를 선언할 수 있다. 일반 메소드 선언과의 차이점은 abstract 키워드가 붙고, 메소드 실행 내용인 중괄호 {}가 없다.

```java
abstract 리턴타입 메소드명(매개변수, ...);
```

추상 메소드는 자식 클래스의 공통 메소드라는 것만 정의할 뿐, 실행 내용을 가지지 않는다. 다음은 Animal 추상 클래스에서 sound() 추상 메소드를 선언한 것이다.

```java
public abstract class Animal {
    abstract void sound();
}
```

추상 메소드는 자식 클래스에서 반드시 재정의(오버라이딩)해서 실행 내용을 채워야 한다. 따라서 Animal 클래스를 상속하는 자식 클래스는 고유한 소리를 내도록 sound() 메소드를 반드시 재정의해야 한다. 예를 들어 Dog는 '멍멍', Cat은 '야옹' 소리를 내도록 말이다.

**Animal.java**
```java
package ch07.sec10.exam02;

public abstract class Animal {
	// 메소드 선언
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	// 추상 메소드 선언
	public abstract void sound();
}
```

**Dog.java**
```java
package ch07.sec10.exam02;

public class Dog extends Animal {
	// 추상 메소드 재정의
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
```

**Cat.java**
```java
package ch07.sec10.exam02;

public class Cat extends Animal {
	// 추상 메소드 재정의
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
```

**AbstractMethodExample.java**
```java
package ch07.sec10.exam02;

public class AbstractMethodExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat.sound();
		
		// 매개변수의 다형성
		animalSound(new Dog());
		animalSound(new Cat());
	}
	
	public static void animalSound(Animal animal) {
		animal.sound(); // 재정의된 메소드 호출
	}
}
```

**실행 결과**
```
멍멍
야옹
멍멍
야옹
```

## 7.11 봉인된 클래스

기본적으로 final 클래스를 제외한 모든 클래스는 부모 클래스가 될 수 있다. 그러나 Java 15부터는 무분별한 자식 클래스 생성을 방지하기 위해 봉인된(sealed) 클래스가 도입되었다.

다음과 같이 Person의 자식 클래스는 Employee와 Manager만 가능하고, 그 이외는 자식 클래스가 될 수 없도록 Person을 봉인된 클래스로 선언할 수 있다.

```java
public sealed class Person permits Employee, Manager { ... }
```

sealed 키워드를 사용하면 permits 키워드 뒤에 상속 가능한 자식 클래스를 지정해야 한다. 봉인된 Person 클래스를 상속하는 Employee와 Manager는 final 또는 non-sealed 키워드로 다음과 같이 선언하거나, sealed 키워드를 사용해서 또 다른 봉인 클래스로 선언해야 한다.

```java
public final class Employee extends Person { ... }
public non-sealed class Manager extends Person { ... }
```

final은 더 이상 상속할 수 없다는 뜻이고, non-sealed는 봉인을 해제한다는 뜻이다. 따라서 Employee는 더 이상 자식 클래스를 만들 수 없지만 Manager는 다음과 같이 자식 클래스를 만들 수 있다.

```java
public class Director extends Manager { ... }
```

설명한 내용을 실습으로 확인해 보자.

**Person.java**
```java
package ch07.sec11;

public sealed class Person permits Employee, Manager {
	// 필드
	public String name;
	
	// 메소드
	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
}
```

**Employee.java**
```java
package ch07.sec11;

public final class Employee extends Person {
	@Override
	public void work() {
		System.out.println("제품을 생산합니다.");
	}
}
```

**Manager.java**
```java
package ch07.sec11;

public non-sealed class Manager extends Person {
	@Override
	public void work() {
		System.out.println("생산 관리를 합니다.");
	}
}
```

**Director.java**
```java
package ch07.sec11;

public class Director extends Manager {
	@Override
	public void work() {
		System.out.println("제품을 기획합니다.");
	}
}
```

**SealedExample.java**
```java
package ch07.sec11;

public class SealedExample {
	public static void main(String[] args) {
		Person p = new Person();
		Employee e = new Employee();
		Manager m = new Manager();
		Director d = new Director();
		
		p.work();
		e.work();
		m.work();
		d.work();
	}
}
```

**실행 결과**
```
하는 일이 결정되지 않았습니다.
제품을 생산합니다.
생산 관리를 합니다.
제품을 기획합니다.
```

## 확인문제

1. 자바의 상속에 대한 설명 중 틀린 것은 무엇입니까?
   - ① 자바는 다중 상속을 허용한다.
   - ② 부모의 메소드를 자식 클래스에서 재정의(오버라이딩)할 수 있다.
   - ③ 부모의 private 접근 제한을 갖는 필드와 메소드는 상속의 대상이 아니다.
   - ④ final 클래스는 상속할 수 없고, final 메소드는 오버라이딩할 수 없다.

2. 클래스 타입 변환에 대한 설명 중 틀린 것은 무엇입니까?
   - ① 자식 객체는 부모 타입으로 자동 타입 변환된다.
   - ② 부모 객체는 어떤 자식 타입으로도 강제 타입 변환된다.
   - ③ 자동 타입 변환을 이용해서 필드와 매개변수의 다형성을 구현한다.
   - ④ 강제 타입 변환 전에 instanceof 연산자로 변환 가능한지 검사하는 것이 좋다.

3. final 키워드에 대한 설명으로 틀린 것은 무엇입니까?
   - ① final 클래스는 부모 클래스로 사용할 수 있다.
   - ② final 필드는 초기화된 후에는 변경할 수 없다.
   - ③ final 메소드는 재정의(오버라이딩)할 수 없다.
   - ④ static final 필드는 상수를 말한다.

4. 오버라이딩(Overriding)에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 부모 메소드의 시그너처(리턴 타입, 메소드명, 매개변수)와 동일해야 한다.
   - ② 부모 메소드보다 좁은 접근 제한자를 붙일 수 없다. (예: public(부모) -> private(자식)).
   - ③ @Override 어노테이션을 사용하면 재정의가 확실한지 컴파일러가 검증한다.
   - ④ protected 접근 제한을 갖는 메소드는 다른 패키지의 자식 클래스에서 재정의할 수 없다.

5. 추상 클래스에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 직접 객체를 생성할 수 없고, 상속만 할 수 있다.
   - ② 추상 메소드를 반드시 가져야 한다.
   - ③ 추상 메소드는 자식 클래스에서 재정의(오버라이딩)할 수 있다.
   - ④ 추상 메소드를 재정의하지 않으면 자식 클래스도 추상 클래스가 되어야 한다.

6. Parent 클래스를 상속해서 Child 클래스를 다음과 같이 작성했는데, Child 생성자에서 컴파일 에러가 발생했습니다. 그 이유와 해결 방법을 설명해 보세요.

```java
public class Parent {
    public String name;
    
    public Parent(String name) {
        this.name = name;
    }
}

public class Child extends Parent {
    public int studentNo;
    
    public Child(String name, int studentNo) {
        this.name = name;
        this.studentNo = studentNo;
    }
}
```

**정답:**
부모 클래스에 기본 생성자가 없으므로, 자식 생성자에서 반드시 super(name)을 호출해야 한다.

```java
public Child(String name, int studentNo) {
    super(name);
    this.name = name;
    this.studentNo = studentNo;
}
```

7. Parent 클래스를 상속받아 Child 클래스를 다음과 같이 작성했습니다. ChildExample 클래스를 실행했을 때 호출되는 각 클래스의 생성자의 순서를 생각하면서 출력 결과를 작성해 보세요.

```java
public class Parent {
    public String nation;
    
    public Parent() {
        this("대한민국");
        System.out.println("Parent() call");
    }
    
    public Parent(String nation) {
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}

public class Child extends Parent {
    public String name;
    
    public Child() {
        this("홍길동");
        System.out.println("Child() call");
    }
    
    public Child(String name) {
        this.name = name;
        System.out.println("Child(String name) call");
    }
}

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
    }
}
```

**실행 결과**
```
Parent(String nation) call
Parent() call
Child(String name) call
Child() call
```

8. Tire 클래스를 상속받아 SnowTire 클래스를 다음과 같이 작성했습니다. SnowTireExample 클래스를 실행했을 때 출력 결과를 작성해 보세요.

```java
public class Tire {
    public void run() {
        System.out.println("일반 타이어가 굴러갑니다.");
    }
}

public class SnowTire extends Tire {
    @Override
    public void run() {
        System.out.println("스노우 타이어가 굴러갑니다.");
    }
}

public class SnowTireExample {
    public static void main(String[] args) {
        SnowTire snowTire = new SnowTire();
        Tire tire = snowTire;
        
        snowTire.run();
        tire.run();
    }
}
```

**실행 결과**
```
스노우 타이어가 굴러갑니다.
스노우 타이어가 굴러갑니다.
```

9. A, B, C, D, E, F 클래스가 다음과 같이 상속 관계에 있을 때 다음 빈칸에 들어올 수 없는 코드를 선택하세요.

```java
// 변수 대입
B b = (  );

// 메소드 선언
void method(B b) { ... }

// 메소드 호출
method(  )
```

- ① new B()
- ② (B) new A()
- ③ new D()
- ④ new E()

**정답:** ② (B) new A() (부모 객체를 자식 타입으로 강제 변환 불가 unless it was originally a child)

10. 다음과 같이 작성한 Computer 클래스에서 컴파일 에러가 발생했습니다. 그 이유를 설명해 보세요.

```java
public abstract class Machine {
    public void powerOn() { }
    public void powerOff() { }
    public abstract void work();
}

public class Computer extends Machine {
}
```

**정답:**
Computer 클래스는 추상 클래스 Machine을 상속받았지만, 추상 메소드인 work()를 재정의하지 않았기 때문이다. 해결하려면 work() 메소드를 오버라이딩하거나 Computer 클래스를 abstract로 선언해야 한다.

11. MainActivity의 onCreate()를 실행할 때 Activity의 onCreate()도 실행시키고 싶습니다. 밑줄에 들어갈 코드를 작성해 보세요.

```java
public class Activity {
    public void onCreate() {
        System.out.println("기본적인 실행 내용");
    }
}

public class MainActivity extends Activity {
    @Override
    public void onCreate() {
        __________________
        System.out.println("추가적인 실행 내용");
    }
}
```

**정답:** `super.onCreate();`

12. 다음과 같은 Example 클래스에서 action() 메소드를 호출할 때 매개값이 C 객체일 경우에만 method2()가 호출되도록 밑줄에 들어갈 코드를 작성해 보세요.

```java
public class A {
    public void method1() {
        System.out.println("A-method1()");
    }
}

public class B extends A {
    public void method1() {
        System.out.println("B-method1()");
    }
}

public class C extends A {
    public void method1() {
        System.out.println("C-method1()");
    }
    public void method2() {
        System.out.println("C-method2()");
    }
}

public class Example {
    public static void action(A a) {
        a.method1();
        if (__________________) {
            c.method2();
        }
    }
    
    public static void main(String[] args) {
        action(new A());
        action(new B());
        action(new C());
    }
}
```

**정답:** `a instanceof C c`

```java
        if (a instanceof C c) {
            c.method2();
        }
```

```
