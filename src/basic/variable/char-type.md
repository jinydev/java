---
layout: basic
title: "4.3 문자 타입"
nav_order: 3
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 4.3 문자 타입

## 1. 글자 하나 (`char`) 🔤
`char`(캐릭터)는 **글자 딱 하나**를 저장하는 타입입니다.
**작은따옴표(`'`)**로 감싸야 합니다.

```java
char grade = 'A';
char hangul = '가';
```

## 2. 유니코드 (Unicode)
컴퓨터는 사실 글자를 모릅니다. 모든 글자에 번호를 붙여서 관리하는데, 이를 **유니코드**라고 합니다.
`char` 타입은 이 유니코드 번호(정수)를 저장합니다.

```java
char c1 = 'A';  // 문자 저장
char c2 = 65;   // 'A'의 유니코드 번호 저장 (같은 결과)

System.out.println(c1); // A
System.out.println(c2); // A
```

> **주의**: 글자 하나는 `char`('A'), 여러 글자는 `String`("ABC")입니다.
> (빈 문자 `''`는 에러가 납니다. 공백 `' '`은 가능합니다.)
