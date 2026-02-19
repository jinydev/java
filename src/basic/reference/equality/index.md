---
layout: basic
title: "8.3 참조 변수의 비교"
nav_order: 3
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.3 참조 변수의 비교

## 1. `==`의 배신 💔

기본 타입(`int`, `double`)은 `==`로 비교하면 값이 같은지 확인합니다.
하지만 참조 타입(String, 배열 등)은 `==`로 비교하면 **"주소"가 같은지** 확인합니다.

```java
String s1 = new String("안녕");
String s2 = new String("안녕");

System.out.println(s1 == s2); // false! (주소가 다름)
```
내용은 같아도, 힙 영역에 따로따로 지어진 집이기 때문에 주소가 다릅니다.

## 2. `equals()`를 써야 하는 이유

내용물(실제 값)이 같은지 비교하려면 **`equals()`** 메소드를 써야 합니다.

```java
System.out.println(s1.equals(s2)); // true (내용이 같음)
```

> **비유**:
> *   `==`: "너네 둘이 **주민등록번호(주소)**가 같아?" (동일 인물인가?)
> *   `equals()`: "너네 둘이 **생김새(내용)**가 같아?" (일란성 쌍둥이인가?)
