---
layout: oop
title: "15.6 포장 클래스 (Wrapper)"
nav_order: 6
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
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
