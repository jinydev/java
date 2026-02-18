---
layout: oop
title: "6.9 인스턴스 멤버"
nav_order: 9
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.9 인스턴스 멤버

필드와 메소드는 선언 방법에 따라 인스턴스 멤버와 정적 멤버로 분류할 수 있다. 인스턴스 멤버로 선언되면 객체 생성 후 사용할 수 있고, 정적 멤버로 선언되면 객체 생성 없이도 사용할 수 있다.

| 구분                    | 설명                                                       |
| ----------------------- | ---------------------------------------------------------- |
| 인스턴스(Instance) 멤버 | 객체에 소속된 멤버 (객체를 생성해야만 사용할 수 있는 멤버) |
| 정적(Static) 멤버       | 클래스에 고정된 멤버 (객체 없이도 사용할 수 있는 멤버)     |

## 인스턴스 멤버 선언 및 사용

인스턴스(instance) 멤버란 객체에 소속된 멤버를 말한다. 따라서 객체가 있어야만 사용할 수 있는 멤버다. 우리가 지금까지 선언한 필드와 메소드는 인스턴스 멤버였다. 다음과 같이 Car 클래스에 gas 필드와 setSpeed() 메소드를 선언하면 인스턴스 멤버가 된다.

```java
public class Car {
    // 인스턴스 필드 선언
    int gas;
    // 인스턴스 메소드 선언
    void setSpeed(int speed) { ... }
}
```

gas 필드와 setSpeed() 메소드는 인스턴스 멤버이기 때문에 외부 클래스에서 사용하기 위해서는 Car 객체를 먼저 생성하고 참조 변수로 접근해서 사용해야 한다.

```java
Car myCar = new Car();
myCar.gas = 10;
myCar.setSpeed(60);

Car yourCar = new Car();
yourCar.gas = 20;
yourCar.setSpeed(80);
```

인스턴스 멤버는 객체에 소속된 멤버라고 했다. gas 필드는 객체에 소속된 멤버가 분명하지만, setSpeed() 메소드는 객체에 포함되지 않는다. 여기서 우리는 '객체에 소속된'을 '객체에 포함된'이라고 해석하면 안 된다.

메소드는 코드의 덩어리이므로 객체마다 저장한다면 중복 저장으로 인해 메모리 효율이 떨어진다. 따라서 메소드 코드는 메소드 영역에 두되 공유해서 사용하고, 이때 객체 없이는 사용하지 못하도록 제한을 걸어둔 것이다.

## this 키워드

객체 내부에서는 인스턴스 멤버에 접근하기 위해 this를 사용할 수 있다. 우리가 자신을 '나'라고 하듯이, 객체는 자신을 'this'라고 한다. 생성자와 메소드의 매개변수명이 인스턴스 멤버인 필드명과 동일한 경우, 인스턴스 필드임을 강조하고자 할 때 this를 주로 사용한다.

**Car.java**
```java
package ch06.sec09;

public class Car {
	// 필드 선언
	String model;
	int speed;
	
	// 생성자 선언
	Car(String model) {
		this.model = model; // 매개변수를 필드에 대입(this 생략 불가)
	}
	
	// 메소드 선언
	void setSpeed(int speed) {
		this.speed = speed; // 매개변수를 필드에 대입(this 생략 불가)
	}
	
	void run() {
		for(int i=10; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속:" + this.speed + "km/h)");
		}
	}
}
```

**CarExample.java**
```java
package ch06.sec09;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		yourCar.run();
	}
}
```

**실행 결과**
```
포르쉐가 달립니다.(시속:10km/h)
포르쉐가 달립니다.(시속:20km/h)
포르쉐가 달립니다.(시속:30km/h)
포르쉐가 달립니다.(시속:40km/h)
포르쉐가 달립니다.(시속:50km/h)
벤츠가 달립니다.(시속:10km/h)
벤츠가 달립니다.(시속:20km/h)
벤츠가 달립니다.(시속:30km/h)
벤츠가 달립니다.(시속:40km/h)
벤츠가 달립니다.(시속:50km/h)
```
