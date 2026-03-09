---
layout: basic
title: "4.10 문자열 타입 변환"
nav_order: 10
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
description: "4.10 문자열 타입 변환 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "4.10 문자열 타입 변환, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 4.10 문자열 타입 변환

프로그래밍을 하다 보면 숫자처럼 생긴 문자열(`"100"`)을 진짜 숫자(`100`)로 바꿔야 할 때가 많습니다.
반대로 숫자를 문자열로 바꿔야 할 때도 있죠.
이 **변환(Conversion)** 방법에 대해 알아봅니다. 🔄

---

## 1. 문자열 ➡️ 기본 타입 (Parsing)

### 1) 개념
문자열(String)을 `int`, `double`, `boolean` 등의 기본 타입으로 바꾸는 것을 **파싱(Parsing)**이라고 합니다.
자바에서는 각 타입의 **포장 클래스(Wrapper Class)**가 가진 `parse...()` 메소드를 사용합니다.

### 2) 비유: "포장지 뜯기"
*   `"100"`은 숫자 100이 문자열 포장지에 싸여있는 상태입니다.
*   **파싱(Parsing)**은 이 포장지를 뜯어서 알맹이인 숫자 `100`을 꺼내는 작업입니다.

### 3) 변환 방법 표

| 변환 방향        | 비유                               | 메소드 (코드)                   |
| :--------------- | :--------------------------------- | :------------------------------ |
| String ➡ byte    | 소주잔에 따르기                    | `Byte.parseByte("10")`          |
| String ➡ short   | 머그컵에 따르기                    | `Short.parseShort("200")`       |
| **String ➡ int** | **물동이에 따르기** (가장 많이 씀) | **`Integer.parseInt("1000")`**  |
| String ➡ long    | 물탱크에 따르기                    | `Long.parseLong("100000")`      |
| String ➡ float   | 작은 자로 재기                     | `Float.parseFloat("3.14")`      |
| String ➡ double  | 정밀한 자로 재기                   | `Double.parseDouble("3.14159")` |
| String ➡ boolean | 스위치 확인하기                    | `Boolean.parseBoolean("true")`  |

### 4) 변환 과정 시각화

```mermaid
graph LR
    Str["String '123'"] --> Parser[Integer.parseInt()]
    Parser --> Int[int 123]
    
    style Str fill:#f9f,stroke:#333
    style Parser fill:#ff9,stroke:#333
    style Int fill:#bfb,stroke:#333
```

---

## 2. 기본 타입 ➡️ 문자열 (String.valueOf)

### 1) 개념
반대로 숫자나 불리언 값을 문자열로 바꿀 때는 `String.valueOf()` 메소드를 사용합니다.
가장 간단하고 강력한 방법입니다.

### 2) 코드 예시
```java
int a = 100;
String s1 = String.valueOf(a); // 100 -> "100"

double b = 3.14;
String s2 = String.valueOf(b); // 3.14 -> "3.14"

boolean c = true;
String s3 = String.valueOf(c); // true -> "true"
```

> **꿀팁**: 빈 문자열(`""`)을 더해도 문자열로 변합니다.
> `String s = 100 + "";` 👉 `"100"`

---

## 3. 주의: 변환할 수 없는 문자열 ⚠️

숫자가 아닌 문자열을 억지로 숫자로 바꾸려 하면 **에러(예외)**가 발생합니다.

```java
String str = "1a2b3c"; // 숫자가 아님!
int value = Integer.parseInt(str); // (X) NumberFormatException 발생 💥
```
*   **비유**: "사과"라는 글자를 숫자로 바꿀 수 없는 것과 같습니다. 반드시 **숫자 형태**의 문자열만 변환해야 합니다.

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Conversion`**: 컨버전, 변환 / 개조. (숫자처럼 예쁘게 생긴 문자열이나 진짜 숫자를 개발자의 입맛과 상황에 맞게 서로 자유롭게 옷을 갈아입혀 주는 신비한 마법)
*   **`Parsing`**: 파싱, 구문 분석 / 해체. (예쁜 포장지로 꽁꽁 둘러싸여 있는 `"100"`이라는 문자열을 뜯어내고, 그 안에 숨은 진짜 알맹이 숫자 `100`을 쏙 뽑아내는 작업)
*   **`Wrapper Class`**: 래퍼 클래스, 포장 클래스. (`int`, `double` 같은 소박한 기본 데이터 타입들을 화려한 객체 형태로 한 번 더 감싸서, 파싱 같은 다양한 추가 기능을 막강하게 제공해 주는 만능 상자)
