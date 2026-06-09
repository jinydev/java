---
layout: basic
title: "4.8 강제 타입 변환"
nav_order: 8
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
description: "4.8 강제 타입 변환 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "4.8 강제 타입 변환, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 4.8 강제 타입 변환

## 1. 큰 양동이 물을 작은 컵에 붓기 🪣 -> 🥛

반대로, **큰 타입**의 값을 **작은 타입**에 넣으려고 하면 어떻게 될까요?
물이 넘칠 수 있습니다(데이터 손실).
그래서 자바는 이걸 말립니다. (컴파일 에러)

하지만 개발자가 "괜찮아, 안 넘쳐! 내가 책임질게!"라고 강제로 넣을 수 있습니다.
이것을 **강제 타입 변환(Casting, 캐스팅)**이라고 합니다.

![그림](./img/type_casting.png)

```mermaid
flowchart LR
    BigBucket[큰 양동이\ndouble\n'3.14'] -->|강제 압축 (캐스팅)| SmallCup[작은 컵\nint\n'3']
    Overflow((💦 \n물 넘침!\n.14 손실)) -.-> SmallCup
    
    style BigBucket fill:#bdf,stroke:#333,shape:cylinder,stroke-width:2px
    style SmallCup fill:#def,stroke:#333,stroke-width:2px
    style Overflow fill:#f99,stroke:#f00,stroke-dasharray: 5 5
```

## 2. 캐스팅 방법

작은 컵 이름(타입)을 괄호 `()` 안에 적어주면 됩니다.

```java
double big = 3.14;
int small = (int) big; // 강제로 int로 바꿈

System.out.println(small); // 3 (소수점 .14는 버려짐)
```

## 3. 문자열을 숫자로 변환하기

---

# 4.8 강제 타입 변환

## 1. 큰 양동이 물을 작은 컵에 붓기 🪣 -> 🥛

반대로, **큰 타입**의 값을 **작은 타입**에 넣으려고 하면 어떻게 될까요?
물이 넘칠 수 있습니다(데이터 손실).
그래서 자바는 이걸 말립니다. (컴파일 에러)

하지만 개발자가 "괜찮아, 안 넘쳐! 내가 책임질게!"라고 강제로 넣을 수 있습니다.
이것을 **강제 타입 변환(Casting, 캐스팅)**이라고 합니다.

![그림](./img/type_casting.png)

```mermaid
flowchart LR
    BigBucket[큰 양동이\ndouble\n'3.14'] -->|강제 압축 (캐스팅)| SmallCup[작은 컵\nint\n'3']
    Overflow((💦 \n물 넘침!\n.14 손실)) -.-> SmallCup
    
    style BigBucket fill:#bdf,stroke:#333,shape:cylinder,stroke-width:2px
    style SmallCup fill:#def,stroke:#333,stroke-width:2px
    style Overflow fill:#f99,stroke:#f00,stroke-dasharray: 5 5
```

## 2. 캐스팅 방법

작은 컵 이름(타입)을 괄호 `()` 안에 적어주면 됩니다.

```java
double big = 3.14;
int small = (int) big; // 강제로 int로 바꿈

System.out.println(small); // 3 (소수점 .14는 버려짐)
```

## 3. 문자열을 숫자로 변환하기

문자열(`String`)을 숫자(`int`, `double`)로 바꿀 때는 캐스팅이 아니라 특별한 방법을 씁니다.

*   `String` -> `int`: **`Integer.parseInt("10")`**
*   `String` -> `double`: **`Double.parseDouble("3.14")`**
*   ` 숫자` -> `String`: **`String.valueOf(10)`**

```java
String s = "100";
int value = Integer.parseInt(s);
```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Casting`**: 캐스팅, 강제 타입 변환. (데이터의 손실 위험을 안고서라도 큰 그릇의 물을 작은 그릇에 억지로 구겨 넣는 작업)
*   **`Parse`**: 파스, 구문 분석/변환. (문자열 형태의 숫자를 진짜 컴퓨터가 계산 가능한 숫자로 분해해서 변환하는 작업, 예: `Integer.parseInt`)
*   **`Loss`**: 로스, 손실. (작은 타입으로 무리하게 캐스팅할 때 공간이 부족하여 원래 데이터의 일부가 싹둑 잘려 나가는 현상)
