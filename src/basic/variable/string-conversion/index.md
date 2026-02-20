---
layout: basic
title: "4.10 문자열 타입 변환"
nav_order: 10
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
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
