---
layout: basic
title: "4.6 문자열 타입"
nav_order: 6
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 4.6 문자열 타입

## 1. 문자열 (`String`) 🧵

여러 개의 문자(문장)를 저장하려면 **`String`** 타입을 사용합니다.
**큰따옴표(`"`)**로 감싸야 합니다.

```java
String name = "홍길동";
String job = "프로그래머";
```

## 2. 주의: String은 기본 타입이 아니다?

사실 `String`은 `int`나 `double` 같은 기본 타입(Primitive Type)이 아닙니다.
**클래스(참조 타입)**입니다. (그래서 첫 글자가 대문자 `S`입니다!)

하지만 너무 많이 쓰기 때문에 자바에서는 기본 타입처럼 편하게 쓸 수 있게 해줍니다.

## 3. 이스케이프 문자 (Escape Character)

문자열 안에 특수한 문자를 넣고 싶을 때 역슬래시(`\`)를 사용합니다.

*   `\"`: 큰따옴표 자체를 출력
*   `\n`: 줄 바꿈 (Enter)
*   `\t`: 탭 (Tab)

```java
System.out.println("우리는 \"개발자\" 입니다."); 
// 출력: 우리는 "개발자" 입니다.

System.out.println("안녕\n하세요");
// 출력:
// 안녕
// 하세요
```
