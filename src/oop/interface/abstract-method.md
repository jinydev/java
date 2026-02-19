---
layout: oop
title: "11.4 추상 메소드"
nav_order: 4
parent: "Chapter 11. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 11.4 추상 메소드 (강제 이행 조항)

인터페이스의 가장 중요한 목적은 **"어떤 객체든 반드시 이 기능을 가지고 있어야 한다"**고 강제하는 것입니다.
이를 위해 **추상 메소드(Abstract Method)**를 사용합니다.

### 💡 핵심 비유: 빈 서식과 실제 작성
> **"동사무소의 신청서 양식(인터페이스)은 비어 있다. 하지만 신청하려는 사람(구현 클래스)은 그 빈칸을 빠짐없이 채워 넣어야만 접수가 된다."**

![Abstract Method Concept](./img/interface_abstract_concept.svg)

---


<br>

## 1. 추상 메소드란?

실행 코드(본문, Body)가 없는 껍데기뿐인 메소드입니다.
**"기능의 이름", "필요한 정보(매개변수)", "결과값(리턴타입)"**만 정해두고, 실제로 어떻게 동작할지는 정의하지 않습니다.

*   **선언 부**: 있음 (`public void turnOn();`)
*   **실행 부**: 없음 (`{ ... }` 가 없고 `;`로 끝남)

```java
public interface RemoteControl {
    // [public abstract]가 생략된 상태
    void turnOn();          // 전원 켜기
    void turnOff();         // 전원 끄기
    void setVolume(int vol);// 볼륨 조절
}
```


<br>

## 2. 왜 비워둘까요?

만약 인터페이스가 `turnOn()`의 내용을 미리 정해버리면 어떻게 될까요?
TV는 화면을 켜야 하고, 오디오는 소리를 내야 하는데, 미리 정해진 내용으로는 100가지, 1000가지가 넘는 기기들의 동작을 모두 만족시킬 수 없기 때문입니다.

그래서 **"켜는 기능이 있어야 한다는 사실"**만 남기고, **"어떻게 켜는지"**는 각 기기(클래스)에게 전적으로 맡기는 것입니다.


<br>

## 3. 구현 클래스의 의무 (Override)

`implements RemoteControl`을 선언한 클래스는 반드시 인터페이스의 빈칸(추상 메소드)을 채워야 합니다. 이를 **메소드 재정의(Overriding)**라고 합니다.

### 컴파일러의 감시
만약 메소드를 하나라도 구현하지 않으면, 자바 컴파일러는 즉시 에러를 발생시킵니다.

![Generic Error](./img/interface_abstract_error.svg)

> *"The type Television must implement the inherited abstract method RemoteControl.turnOn()"*
> (Television 클래스는 상속받은 추상 메소드 turnOn()을 반드시 구현해야 합니다!)

```java
public class Television implements RemoteControl {
    
    // 강제로 구현해야 함 (안 하면 에러!)
    @Override
    public void turnOn() {
        System.out.println("TV 화면을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 화면을 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV 볼륨을 " + volume + "로 설정합니다.");
    }
}
```


<br>

## 4. 예제로 보는 동작 비교

같은 `turnOn()` 메소드를 호출하더라도, 실제 연결된 객체가 무엇이냐에 따라 완전히 다른 코드가 실행됩니다.

```java
RemoteControl rc;

// 1. TV 연결
rc = new Television();
rc.turnOn(); // 결과: "TV 화면을 켭니다."

// 2. 오디오 연결
rc = new Audio();
rc.turnOn(); // 결과: "오디오 스피커를 켭니다."
```

이것이 바로 **다형성(Polymorphism)**의 시작입니다.
사용자는 `turnOn()` 하나만 알고 있으면, 세상의 모든 가전제품을 켤 수 있게 되는 것입니다.
