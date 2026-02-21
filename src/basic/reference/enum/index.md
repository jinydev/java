---
layout: basic
title: "8.10 열거(Enum) 타입"
nav_order: 10
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.10 열거(Enum) 타입

## 1. 한정된 메뉴판 📋

데이터 중에는 **요일(월~일), 계절(봄~겨울)** 처럼 값이 몇 가지로 딱 정해져 있는 것들이 있습니다.
이런 데이터를 다룰 때, 아무 값이나 막 넣지 못하게 **"이 중에서만 골라!"**라고 정해두는 타입입니다.

![그림](./img/enum_menu.png)

## 2. 사용법

먼저 `Enum` 파일을 만듭니다. (Week.java)

```java
public enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
} // 대문자로 쓰는 게 관례입니다.
```

이제 변수에는 이 값들만 넣을 수 있습니다.

```java
Week today = Week.SUNDAY;
// Week today = "Monday"; // (X) 에러 발생! 문자열 못 넣음
// Week today = Week.SUMMER; // (X) 에러 발생! 없는 메뉴 못 고름
```

실수를 줄이고 코드를 읽기 편하게 만들어줍니다.
