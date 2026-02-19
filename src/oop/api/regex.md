---
layout: oop
title: "15.10 정규 표현식 (Regex)"
nav_order: 10
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
---

# 15.10 정규 표현식 (Regex)


<br>

## 1. 문자열 검문소 🚧

**정규 표현식(Regular Expression)**은 문자열이 **"특정 규칙에 맞는지 검사"**하는 도구입니다.
회원가입 할 때 "이메일 형식이 아닙니다" 또는 "전화번호를 다시 입력하세요"라고 알려주는 기능의 핵심입니다.


<br>

## 2. 주요 문법 (암호표)

| 기호    | 설명          | 예시                   |
| :------ | :------------ | :--------------------- |
| `^`     | 시작          | `^010` (010으로 시작)  |
| `$`     | 끝            | `com$` (com으로 끝남)  |
| `.`     | 아무 문자 1개 |                        |
| `\d`    | 숫자 (0~9)    | `\d{3}` (숫자 3개)     |
| `\w`    | 문자+숫자     |                        |
| `+`     | 1개 이상      |                        |
| `*`     | 0개 이상      |                        |
| `{n,m}` | n개~m개       | `\d{3,4}` (숫자 3~4개) |


<br>

## 3. 사용법 (`Pattern.matches`)

`Pattern` 클래스의 `matches()` 메소드를 사용하면 한 줄로 검사가 끝납니다.

### 1) 전화번호 검사
```java
// 규칙: 010 - (숫자 3~4개) - (숫자 4개)
String pattern = "010-\\d{3,4}-\\d{4}";
String data = "010-1234-5678";

boolean result = Pattern.matches(pattern, data);

if(result) {
    System.out.println("통과! 정상적인 번호입니다.");
} else {
    System.out.println("삐빅! 잘못된 번호입니다.");
}
```

### 2) 이메일 검사
```java
// 규칙: (문자들) @ (문자들) . (문자들)
String pattern = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
String email = "hong@naver.com";

boolean isEmail = Pattern.matches(pattern, email);
```

> **핵심**: 복잡한 문자열 규칙 검사는 `if`문 수십 줄 대신 **정규 표현식 한 줄**로 해결하세요.
