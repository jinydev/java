---
layout: basic
title: "4.11 키보드 입력"
nav_order: 11
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 4.11 키보드 입력

## 1. 사용자 입력 받기 (`Scanner`) ⌨️

프로그램이 사용자와 대화하려면 키보드 입력을 받아야 합니다.
자바에서는 **`Scanner`**라는 도구를 사용합니다.

## 2. 사용법

### 1단계: 도구 준비
```java
import java.util.Scanner; // 스캐너를 쓰겠다고 선언

Scanner scanner = new Scanner(System.in); // 스캐너 켜기
```

### 2단계: 입력 받기
```java
System.out.print("이름을 입력하세요: ");
String name = scanner.nextLine(); // 엔터 칠 때까지 기다렸다가 읽음

System.out.println("반갑습니다, " + name + "님!");
```

### 3단계: 숫자로 바꾸기
`scanner.nextLine()`은 무조건 **문자열(String)**로 읽습니다.
숫자 계산이 필요하면 변환해야 합니다.

```java
String input = scanner.nextLine(); // "100" 입력
int num = Integer.parseInt(input); // 숫자 100으로 변환
```
