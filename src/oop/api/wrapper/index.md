---
layout: oop
title: "15.6 포장 클래스 (Wrapper)"
nav_order: 6
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
description: "15.6 포장 클래스 (Wrapper) 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "15.6 포장 클래스 (Wrapper), 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 15.6 포장 클래스 (Wrapper)


<br>

## 1. 선물 상자 (Boxing) 🎁

자바에는 `int`, `double` 같은 **기본 타입(Primitive Type)**이 있고, `String`, `Person` 같은 **객체(Object)**가 있습니다.
가끔 **기본 타입을 객체로 취급해야 할 때**가 있습니다. (예: `ArrayList` 같은 컬렉션에는 객체만 담을 수 있음)

이때 기본 타입 데이터를 객체라는 **상자(Box)**에 담는 것을 **포장(Wrapper)**이라고 합니다.

| 기본 타입 | 포장 클래스 (상자) |
| :-------- | :----------------- |
| `byte`    | `Byte`             |
| `int`     | `Integer`          |
| `double`  | `Double`           |
| `boolean` | `Boolean`          |


<br>

## 2. 자동 포장기 (Auto Boxing/Unboxing)

오래전 자바(JDK 1.4 이전)에서는 일일이 포장하고 끌러야 했지만, 지금은 **자동**입니다.

```java
// 박싱 (Boxing): 100이라는 숫자를 상자에 담는다.
Integer obj = 100; 

// 언박싱 (Unboxing): 상자에서 물건을 꺼낸다.
int value = obj;

// 연산: 상자 째로 더해도 알아서 꺼내서 계산한다.
int result = obj + 200; // 100 + 200 = 300
```


<br>

## 3. 포장 값 비교 (주의!)

포장 객체는 **객체**이므로 `==` 연산자는 **주소값(상자 자체)**을 비교합니다.
내용물(값)을 비교하려면 `equals()`를 쓰거나 언박싱해서 비교해야 합니다.

```java
Integer a = 300;
Integer b = 300;

System.out.println(a == b);      // false (서로 다른 상자임)
System.out.println(a.equals(b)); // true  (내용물은 같음)
```

> **핵심**: 기본 타입을 객체처럼 써야 할 때(컬렉션 등) **Wrapper 클래스**가 대신 해줍니다.

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Wrapper`**: 래퍼, 포장지. (숫자 `10` 같은 밋밋한 기본 데이터(원시 타입)를 모시듯 예쁜 상자(객체)에 감싸 담아서, 컬렉션 같은 까다로운 곳에도 들어갈 수 있도록 포장해 주는 클래스)
*   **`Boxing`**: 박싱, 상자에 담기. (반대로 상자에서 다시 데이터만 쏙 빼내는 건 `Unboxing` 언박싱이라고 하며, 요즘 자바는 이를 귀찮아하는 개발자를 위해 알아서 척척 해주는 오토박싱(`Auto Boxing`) 기능을 뽐냄)
