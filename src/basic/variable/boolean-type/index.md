---
layout: basic
title: "4.5 논리 타입"
nav_order: 5
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
description: "4.5 논리 타입 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "4.5 논리 타입, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 4.5 논리 타입 (boolean)

컴퓨터 세상에서의 대답은 오직 **"YES"** 아니면 **"NO"**입니다.
이 둘 중 하나를 저장하는 타입이 바로 **boolean(불리언)**입니다.

---

## 1. 참과 거짓 (True or False) 🚥

### 1) 개념
`boolean` 타입은 오직 두 가지 값만 가질 수 있습니다.
*   **`true`**: 참 (맞다, 켜짐, 성공)
*   **`false`**: 거짓 (아니다, 꺼짐, 실패)

### 2) 비유: "전등 스위치"
*   방의 전등 스위치는 **ON(켜짐)** 또는 **OFF(꺼짐)** 두 가지 상태밖에 없습니다. "반만 켜짐" 같은 건 없습니다.
*   boolean 변수도 마찬가지로 딱 두 가지 상태만 저장합니다.

### 3) 상태 시각화

```mermaid
graph LR
    ON((ON<br>true)) <--> OFF((OFF<br>false))
    style ON fill:#bfb,stroke:#333
    style OFF fill:#eee,stroke:#333
```

---

## 2. 사용 예시

### 1) 변수 선언 및 초기화
주로 상태를 나타내는 변수 이름 앞에 `is`, `has`, `can` 등을 붙여서 질문형으로 짓습니다.

```java
boolean isStop = true;   // 멈췄나요? 네(true)
boolean hasApple = false; // 사과가 있나요? 아니요(false)
boolean canRun = true;    // 달릴 수 있나요? 네(true)
```

### 2) 흐름 제어 (Flow Control)
boolean 타입은 주로 **조건문(`if`)**이나 **반복문(`while`)**에서 프로그램의 흐름을 결정할 때 사용됩니다.

```java
boolean isRaining = true;

if (isRaining) {
    System.out.println("우산을 챙기세요! ☔️");
} else {
    System.out.println("양산을 챙기세요! ☀️");
}
```

---

# 4.5 논리 타입 (boolean)

컴퓨터 세상에서의 대답은 오직 **"YES"** 아니면 **"NO"**입니다.
이 둘 중 하나를 저장하는 타입이 바로 **boolean(불리언)**입니다.

---

## 1. 참과 거짓 (True or False) 🚥

### 1) 개념
`boolean` 타입은 오직 두 가지 값만 가질 수 있습니다.
*   **`true`**: 참 (맞다, 켜짐, 성공)
*   **`false`**: 거짓 (아니다, 꺼짐, 실패)

### 2) 비유: "전등 스위치"
*   방의 전등 스위치는 **ON(켜짐)** 또는 **OFF(꺼짐)** 두 가지 상태밖에 없습니다. "반만 켜짐" 같은 건 없습니다.
*   boolean 변수도 마찬가지로 딱 두 가지 상태만 저장합니다.

### 3) 상태 시각화

```mermaid
graph LR
    ON((ON<br>true)) <--> OFF((OFF<br>false))
    style ON fill:#bfb,stroke:#333
    style OFF fill:#eee,stroke:#333
```

---

## 2. 사용 예시

### 1) 변수 선언 및 초기화
주로 상태를 나타내는 변수 이름 앞에 `is`, `has`, `can` 등을 붙여서 질문형으로 짓습니다.

```java
boolean isStop = true;   // 멈췄나요? 네(true)
boolean hasApple = false; // 사과가 있나요? 아니요(false)
boolean canRun = true;    // 달릴 수 있나요? 네(true)
```

### 2) 흐름 제어 (Flow Control)
boolean 타입은 주로 **조건문(`if`)**이나 **반복문(`while`)**에서 프로그램의 흐름을 결정할 때 사용됩니다.

```java
boolean isRaining = true;

if (isRaining) {
    System.out.println("우산을 챙기세요! ☔️");
} else {
    System.out.println("양산을 챙기세요! ☀️");
}
```

```mermaid
flowchart TD
    Check{isRaining?} -->|true| Umbrella[우산 챙기기]
    Check{isRaining?} -->|false| Sunshade[양산 챙기기]
    
    style Check fill:#ff9,stroke:#333
    style Umbrella fill:#bef,stroke:#333
    style Sunshade fill:#fdb,stroke:#333
```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Boolean`**: 불리언. (참(`true`)과 거짓(`false`) 딱 두 가지 상태만을 나타내는 논리적인 데이터 타입)
*   **`True / False`**: 트루 / 폴스, 참 / 거짓. (조건이 맞는지 틀린지를 나타내는 불리언 값의 영원한 짝꿍)
*   **`Flow Control`**: 플로우 컨트롤, 흐름 제어. (불리언 논리 값에 따라 프로그램이 어느 길로 갈지 방향을 스위치처럼 결정하는 것)
