---
layout: oop
title: "7.8 다형성"
nav_order: 8
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.8 다형성 (Polymorphism)

다형성(Poly + Morph)은 "다양한 형태를 가질 수 있는 능력"을 말합니다.
이것은 객체지향 프로그래밍의 **꽃**이라고 불릴 만큼 중요하고 강력한 기능입니다.

### 💡 핵심 비유: 자동차 타이어 교체
> **"자동차 바퀴 규격(Tire)만 맞으면, 한국 타이어든 금호 타이어든 어떤 회사의 타이어도 갈아 끼울 수 있다!"**

![Polymorphism Tires](./img/polymorphism_tires.svg)

---

## 1. 자동 타입 변환 (필드 다형성)

우리가 변수를 선언할 때 보통은 같은 타입을 대입합니다.
하지만 상속 관계에서는 **부모 타입 변수에 자식 객체를 대입**할 수 있습니다. (자동 타입 변환)

```java
// 타이어 변수에 한국타이어 대입 가능! (한국타이어는 타이어니까)
Tire myTire = new HankookTire();
```

이게 왜 좋을까요? **나중에 부품을 교체하기가 엄청나게 쉬워지기 때문**입니다.

### 예제: 자동차 타이어 교체
```java
class Car {
    // 필드를 부모 타입(Tire)으로 선언
    Tire tire;

    void run() {
        tire.roll(); // 자식이 누구든 알아서 잘 굴러감 (오버라이딩)
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();

        // 1. 한국 타이어 장착
        myCar.tire = new HankookTire();
        myCar.run();

        // 2. 금호 타이어로 교체 (코드 수정 없이 객체만 대입!)
        myCar.tire = new KumhoTire();
        myCar.run(); 
    }
}
```

---

## 2. 매개변수 다형성

메소드를 호출할 때도 다형성이 빛을 발합니다.
**"나는 `Vehicle(탈것)`이면 뭐든지 운전할 수 있어!"**

```java
public class Driver {
    // 매개변수로 Vehicle을 받음 (버스, 택시, 트럭 다 들어올 수 있음)
    public void drive(Vehicle vehicle) {
        vehicle.run();
    }
}
```

```java
Driver driver = new Driver();
driver.drive(new Bus());  // "버스가 달립니다."
driver.drive(new Taxi()); // "택시가 달립니다."
```

---

## 3. 심화: 왜 '설계의 핵심'일까? (Deep Dive)

다형성이 없다면 어떻게 될까요?
새로운 탈것이 나올 때마다 `Driver` 클래스를 계속 수정해야 할 것입니다.

```java
// 다형성이 없다면... (나쁜 예)
public void driveBus(Bus bus) { ... }
public void driveTaxi(Taxi taxi) { ... }
public void driveTruck(Truck truck) { ... } // 끝이 엾음
```

![Polymorphism Architecture](./img/polymorphism_architecture.svg)

다형성을 사용하면:
1.  **Driver는 Vehicle만 알면 됩니다.** (Bus, Taxi가 어떻게 생겼는지 몰라도 됨)
2.  새로운 `ElectricCar`가 나와도 `Driver` 코드를 **한 줄도 고칠 필요가 없습니다.** (Plug & Play)
3.  이것을 **"결합도를 낮춘다(Loose Coupling)"**라고 하며, 좋은 소프트웨어 설계의 기본입니다.
