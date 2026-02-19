---
layout: oop
title: "6.9 인스턴스 멤버"
nav_order: 9
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.9 인스턴스 멤버 (객체 고유의 속성)

<br>

## 6.9.1 인스턴스(Instance) 멤버란?

**"내 건 내 거고, 네 건 네 거야!"**

인스턴스 멤버는 **객체(Instance)를 생성해야만 사용할 수 있는 멤버(필드, 메소드)**를 말합니다. 쉽게 말해 **객체마다 각자 가지고 있는 고유한 데이터와 기능**입니다.

> **비유: 주민등록증**
> 사람마다 이름과 주민등록번호가 모두 다릅니다. '홍길동'의 신분증은 '유관순'의 신분증과 완전히 다른 별개의 물건인 것처럼, 객체들도 각자 독립적인 저장 공간을 가집니다.

![Instance vs Static Concept](./img/instance_vs_static_concept.svg)

하지만 비유를 넘어 기술적으로 이해해야 합니다.
**인스턴스 멤버**는 객체가 `new` 연산자로 힙(Heap) 메모리에 생성될 때, 비로소 그 객체 안에 공간이 할당됩니다. 따라서 객체를 생성하지 않으면 아예 존재하지 않는 멤버들입니다.

<br>
<br>

## 6.9.2 인스턴스 멤버 선언 및 사용

인스턴스 멤버는 객체에 소속되어 있기 때문에, 사용하려면 반드시 **객체를 먼저 생성(`new`)**해야 합니다.

### 💻 코드 예시

```java
public class Car {
    // 인스턴스 필드 (차마다의 고유 데이터)
    int gas;
    
    // 인스턴스 메소드 (차의 동작)
    void setSpeed(int speed) { ... }
}
```

```java
// 1. 객체 생성
Car myCar = new Car(); 
Car yourCar = new Car();

// 2. 인스턴스 멤버 사용 (객체 참조 변수를 통해 접근)
myCar.gas = 10;
yourCar.gas = 20; 
```

### 🔍 코드를 다시 한번 원리와 동작을 살펴봅니다

*   **메모리 할당**: `new Car()`가 실행되는 순간, 컴퓨터 메모리(Heap)에 `Car` 객체를 위한 방이 만들어지고, 그 안에 `gas`라는 변수 공간이 생깁니다.
*   **독립성**: `myCar`가 가리키는 객체와 `yourCar`가 가리키는 객체는 서로 다른 주소를 가진 **별개의 존재**입니다.
*   **데이터 보존**: `myCar.gas`에 10을 넣어도 `yourCar.gas`에는 아무런 영향을 주지 않습니다. 이것이 바로 인스턴스 필드가 **객체마다 독립적**이라는 의미입니다.

<br>
<br>

## 6.9.3 `this` 키워드 (현재 객체 참조)

**"이거(this) = 지금 실행 중인 나 자신"**

객체 내부 코드에서 인스턴스 멤버에 접근할 때, **현재 실행 중인 객체 자신을 가리키는 키워드**가 바로 `this`입니다.

![This Keyword](./img/this_keyword.svg)

### 💻 코드 예시

```java
public class Car {
    String model; // (1) 인스턴스 필드
    
    public Car(String model) { // (2) 매개변수 (외부에서 받은 값)
        this.model = model;
    }
}
```

### 🔍 코드를 다시 한번 원리와 동작을 살펴봅니다

*   **변수의 이름 충돌**: 위 코드에서 필드 이름도 `model`이고, 생성자의 매개변수 이름도 `model`입니다. 이 경우 메소드 내부에서는 매개변수 `model`이 우선순위를 가집니다. (필드가 가려짐)
*   **this의 역할**: 이때 `this.model`이라고 쓰면, "지역변수 `model`이 아니라, **이 객체가 가지고 있는 필드 `model`**"을 명확하게 지칭하게 됩니다.
*   **주소값**: 기술적으로 `this`는 **현재 객체의 참조(주소)값**을 가지고 있습니다. 그래서 `this.model = model;`은 "**내 주소지에 있는 `model` 변수**에, 전달받은 `model` 값을 저장하라"는 명령이 됩니다.

<br>
<br>

## 6.9.4 전체 실행 예제

### 💻 코드 예시

**Car.java**
```java
package ch06.sec09;

public class Car {
	// 인스턴스 필드
	String model;
	int speed;
	
	// 생성자
	Car(String model) {
		// 매개변수로 받은 model 값을 내 필드(this.model)에 저장
		this.model = model; 
	}
	
	// 인스턴스 메소드
	void run() {
		for(int i=10; i<=30; i+=10) {
			// 내 필드 speed 수정
			this.speed = i; 
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
		// 객체 생성 (각각 다른 메모리 주소에 할당됨)
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		// 인스턴스 메소드 호출
		myCar.run();
		yourCar.run();
	}
}
```

### 🔍 코드를 다시 한번 원리와 동작을 살펴봅니다

*   **this의 변화**: `myCar.run()`을 호출했을 때의 `this`는 `myCar` 객체를 가리키고, `yourCar.run()`을 호출했을 때의 `this`는 `yourCar` 객체를 가리킵니다. 즉, **누가 호출했느냐에 따라 `this`가 가리키는 대상이 달라집니다.**
*   **상태 유지**: `run()` 메소드가 실행되는 동안 `this.speed` 값이 계속 변경되지만, 이는 오직 해당 메서드를 호출한 객체의 `speed` 필드에만 적용됩니다.
