---
layout: basic
title: "4.5 논리 타입"
nav_order: 5
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 4.5 논리 타입

## 1. 참과 거짓 (`boolean`) ✅

`boolean`(불리언)은 딱 두 가지 값만 가질 수 있습니다.
*   **`true`**: 참 (ON)
*   **`false`**: 거짓 (OFF)

전등 스위치처럼 켜거나 끄는 상태를 저장할 때 씁니다.

```java
boolean stop = true;
boolean isCar = false;
```

## 2. 어디에 쓰나요?

주로 **조건문(`if`)**이나 **반복문(`while`)**에서 흐름을 제어할 때 사용합니다.

```java
boolean isRainy = true;

if (isRainy) {
    System.out.println("우산을 챙기세요!");
}
```
