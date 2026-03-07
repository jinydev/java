---
layout: oop
title: "15.8 날짜와 시간 클래스"
nav_order: 8
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
description: "15.8 날짜와 시간 클래스 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "15.8 날짜와 시간 클래스, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 15.8 날짜와 시간 클래스


<br>

## 1. 자바의 시간 여행 🕰️

자바에서 날짜와 시간을 다루는 방법은 역사적으로 진화해 왔습니다.

| 세대      | 클래스          | 패키지      | 특징                                   | 별명            |
| :-------- | :-------------- | :---------- | :------------------------------------- | :-------------- |
| **1세대** | `Date`          | `java.util` | 대부분 기능이 삭제됨(Deprecated).      | **구식 시계**   |
| **2세대** | `Calendar`      | `java.util` | 사용하기 복잡함(Month가 0부터 시작).   | **불편한 달력** |
| **3세대** | `LocalDateTime` | `java.time` | **강력 추천!** 직관적이고 기능이 많음. | **스마트 워치** |


<br>

## 2. 구식 방식 (`Date`, `Calendar`)

### 1) Date
현재 날짜를 단순히 담는 용도로만 주로 씁니다.

```java
Date now = new Date();
System.out.println(now); // 출력 형식이 안 예쁨 (Sun Feb 20 ...)
```

### 2) Calendar
날짜 계산은 가능하지만, 사용법이 어렵습니다. (주의: 월(Month)이 0부터 시작해서 1월이 0입니다!)

```java
Calendar now = Calendar.getInstance();
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH) + 1; // 꼭 +1 해줘야 함!
```


<br>

## 3. 스마트 방식 (`LocalDateTime`) 🌟

Java 8부터 도입된 `java.time` 패키지는 매우 직관적입니다.

### 1) 현재 시간 얻기
```java
LocalDateTime now = LocalDateTime.now();
System.out.println(now); // 2024-02-20T10:30:00.123
```

### 2) 날짜 조작 (시간 여행)
메소드 이름만 봐도 기능을 알 수 있습니다.

```java
LocalDateTime target = now
    .plusYears(1)    // 1년 뒤
    .minusMonths(2)  // 2달 전
    .plusDays(7);    // 7일 뒤

System.out.println(target);
```

### 3) 날짜 비교
```java
if (now.isBefore(target)) {
    System.out.println("현재가 미래보다 이전입니다."); // 출력됨
}
```

> **핵심**: 새로 코드를 짠다면 무조건 **`LocalDateTime`**을 쓰세요.
