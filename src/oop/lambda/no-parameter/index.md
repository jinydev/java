---
layout: oop
title: "18.2 매개변수가 없는 람다식"
nav_order: 2
parent: "Chapter 18. 람다식"
grand_parent: "객체지향 자바 프로그래밍"
description: "18.2 매개변수가 없는 람다식 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "18.2 매개변수가 없는 람다식, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 18.2 매개변수가 없는 람다식


<br>

## 1. 시작 버튼 누르기 🔘

매개변수가 없다는 것은 **"외부에서 데이터를 받지 않고, 그냥 실행만 하면 된다"**는 뜻입니다.
마치 엘리베이터의 **열림 버튼**이나 게임의 **Start 버튼**과 같습니다.

*   문법: `() -> { 실행문; }`


<br>

## 2. 기본 문법

함수형 인터페이스의 추상 메소드에 매개변수가 없을 경우, 람다식은 빈 괄호 `()`를 사용합니다.

```java
// 1. 실행문이 여러 개인 경우: 중괄호 {} 필수!
() -> {
    System.out.println("명령 1");
    System.out.println("명령 2");
}

// 2. 실행문이 하나인 경우: 중괄호 {} 생략 가능 (권장)
() -> System.out.println("명령 1");
```


<br>

## 3. 예제: 버튼 클릭 이벤트

버튼을 클릭했을 때 어떤 동작을 할지 람다식으로 정의해보겠습니다.

**함수형 인터페이스 정의**
```java
package ch18.sec02.exam02;

public class Button {
    // 정적 멤버 인터페이스 (함수형 인터페이스)
    @FunctionalInterface
    public static interface ClickListener {
        void onClick(); // 매개변수 없음
    }

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }
}
```

**실행 코드**
```java
package ch18.sec02.exam02;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button();

        // 1. 람다식 주입 (매개변수 없음)
        btnOk.setClickListener(() -> {
            System.out.println("Ok 버튼을 클릭했습니다.");
        });
        btnOk.click();

        Button btnCancel = new Button();

        // 2. 람다식 주입 (중괄호 생략)
        btnCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭했습니다."));
        btnCancel.click();
    }
}
```

**실행 결과**
```
Ok 버튼을 클릭했습니다.
Cancel 버튼을 클릭했습니다.
```

> **핵심**: 매개변수가 없으면 **빈 괄호 `()`**를 꼭 써주세요.
