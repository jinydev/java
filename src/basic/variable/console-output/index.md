---
layout: basic
title: "4.10 콘솔 출력"
nav_order: 10
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
description: "자바의 콘솔 출력 (print, println, printf)과 서식 지정자(%d, %f, %s 등)의 원리와 사용법을 시각적 예제로 완벽하게 알아봅니다."
keywords: "자바, Java, console, 출력, print, println, printf, 서식 지정자, format specifier, escape 문자, 이스케이프"
---

# 4.10 콘솔 출력

프로그램이 계산한 결과나 사용자에게 보여줄 메시지를 화면(콘솔)에 출력하는 방법을 알아봅니다. 📺

---

## 1. 출력 방법 3가지 🖨️

### 1) 개념
자바는 `System.out`이라는 기본 출력 도구를 제공합니다.
상황에 따라 3가지 메소드를 골라 쓸 수 있습니다.

### 2) 비유: "프린터 모드 설정"
*   **println (Print Line)**: 한 줄 쓰고 **종이를 위로 올리기(엔터)**
*   **print**: 한 줄 쓰고 **그 자리에 멈추기** (옆에 이어 쓰기)
*   **printf (Print Format)**: **서식(양식)**에 맞춰서 예쁘게 채워 넣기

### 3) 출력 차이 시각화

```mermaid
graph TD
    subgraph println [println("A"); println("B");]
        L1[A]
        L2[B]
        L1 --> L2
    end
    
    subgraph print [print("A"); print("B");]
        P1[AB]
    end
    
    style println fill:#eef,stroke:#333
    style print fill:#eef,stroke:#333
```

---

## 2. 자주 쓰는 메소드

### 1) System.out.println()
괄호 안의 내용을 출력하고 **줄을 바꿉니다**. 가장 많이 사용합니다.

```java
System.out.println("안녕하세요");
System.out.println("반갑습니다");
// 출력:
// 안녕하세요
// 반갑습니다
```

### 2) System.out.print()
괄호 안의 내용을 출력하고 **줄을 바꾸지 않습니다**.

```java
System.out.print("사과");
System.out.print("포도");
// 출력: 사과포도
```

---

## 3. 형식 지정 출력 (printf) 🎨

### 1) 개념
`printf("형식문자열", 값1, 값2, ...)` 형태로 사용합니다.
문자열 안에 **빈칸(서식 지정자)**을 만들어두고, 뒤에 오는 값을 순서대로 채워 넣는 방식입니다.

### 2) 자주 쓰는 서식 지정자 (Format Specifier)

| 기호     | 설명                  | 타입          | 예시                                            |
| :------- | :-------------------- | :------------ | :---------------------------------------------- |
| **`%d`** | 10진수 정수 (Decimal) | `int`, `long` | `printf("나이: %d", 25)` 👉 "나이: 25"           |
| **`%s`** | 문자열 (String)       | `String`      | `printf("이름: %s", "홍길동")` 👉 "이름: 홍길동" |
| **`%f`** | 실수 (Float)          | `double`      | `printf("키: %.1f", 175.5)` 👉 "키: 175.5"       |

> **꿀팁**: `%`와 글자 사이에 숫자를 넣으면 자릿수를 맞출 수 있습니다.
> *   `%.2f`: 소수점 둘째 자리까지 표시 (반올림)

### 3) 코드 예시
```java
String name = "김자바";
int age = 20;
double height = 180.56;

System.out.printf("이름: %s, 나이: %d세, 키: %.1fcm\n", name, age, height);
// 출력: 이름: 김자바, 나이: 20세, 키: 180.6cm
```
