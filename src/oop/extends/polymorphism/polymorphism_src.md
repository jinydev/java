---
layout: oop
title: "7.8 다형성"
nav_order: 8
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.8 다형성

다형성(`Polymorphism`)이란 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질을 말한다. 자동차의 부품을 교환하면 성능이 다르게 나오듯이 객체는 부품과 같아서, 프로그램을 구성하는 객체를 바꾸면 프로그램의 실행 성능이 다르게 나올 수 있다.

객체 사용 방법이 동일하다는 것은 동일한 메소드를 가지고 있다는 뜻이다. 한국 타이어와 금호 타이어는 모두 타이어를 상속하고 있다면, 한국 타이어와 금호 타이어는 타이어(부모)의 메소드를 동일하게 가지고 있다고 말할 수 있다.

만약 한국 타이어와 금호 타이어가 타이어(부모)의 메소드를 오버라이딩하고 있다면, 타이어 메소드 호출 시 오버라이딩된 메소드가 호출된다. 오버라이딩된 내용은 두 타이어가 다르기 때문에 실행 결과가 다르게 나온다. 이것이 바로 다형성이다.

다형성을 구현하기 위해서는 자동 타입 변환과 메소드 재정의가 필요하다.

## 필드 다형성

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

`Car` 클래스에는 `Tire` 필드가 선언되어 있다. 먼저 `Car` 객체를 생성한 후 타이어를 장착하기 위해 다음과 같이 `HankookTire` 또는 `KumhoTire` 객체를 `Tire` 필드에 대입할 수 있다. 왜냐하면 자동 타입 변환이 되기 때문이다.

```java
// Car 객체 생성
Car myCar = new Car();
// HankookTire 장착
myCar.tire = new HankookTire();
// KumhoTire 장착
myCar.tire = new KumhoTire();
```

`Car` 클래스의 `run()` 메소드는 `tire` 필드에 대입된 객체의 `roll()` 메소드를 호출한다. 만약 `HankookTire`와 `KumhoTire`가 `roll()` 메소드를 재정의하고 있다면, 재정의된 `roll()` 메소드가 호출된다.

```java
myCar.run();
```

따라서 어떤 타이어를 장착했는지에 따라 `roll()` 메소드의 실행 결과는 달라지게 된다. 이것이 바로 필드의 다형성이다. 예제를 통해 확인해 보자.

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

## 매개변수 다형성

다형성은 필드보다는 메소드를 호출할 때 많이 발생한다. 메소드가 클래스 타입의 매개변수를 가지고 있을 경우, 호출할 때 동일한 타입의 객체를 제공하는 것이 정석이지만 자식 객체를 제공할 수도 있다. 여기서 다형성이 발생한다.

다음과 같이 `Driver`라는 클래스가 있고, `Vehicle` 매개변수를 갖는 `drive()` 메소드가 정의되어 있다고 가정해 보자. `drive()` 메소드는 매개값으로 전달받은 `vehicle`의 `run()` 메소드를 호출한다.

```java
public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.run();
    }
}
```

일반적으로 `drive()` 메소드를 호출한다면 다음과 같이 `Vehicle` 객체를 제공할 것이다.

```java
Driver driver = new Driver();
Vehicle vehicle = new Vehicle();
driver.drive(vehicle);
```

그러나 매개값으로 `Vehicle` 객체만 제공할 수 있는 것은 아니다. 자동 타입 변환으로 인해 `Vehicle`의 자식 객체도 제공할 수 있다.

```java
Driver driver = new Driver();
Bus bus = new Bus();
driver.drive(bus); // Vehicle vehicle = bus; 자동 타입 변환 발생
```

`drive()` 메소드는 매개변수 `vehicle`이 참조하는 객체의 `run()` 메소드를 호출하는데, 자식 객체가 `run()` 메소드를 재정의하고 있다면 재정의된 `run()` 메소드가 호출된다. 그러므로 어떤 자식 객체가 제공되느냐에 따라서 `drive()`의 실행 결과는 달라진다. 이것이 매개변수의 다형성이다.

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
