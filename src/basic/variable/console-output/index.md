---
layout: basic
title: "4.10 콘솔 출력"
nav_order: 10
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 4.10 콘솔 출력

## 1. 출력하기 (`System.out.println`) 📺

화면에 글자를 보여주는 방법은 크게 3가지가 있습니다.

*   **`println()`** (Print Line): 내용을 출력하고 **줄을 바꿉니다.** (가장 많이 씀)
*   **`print()`**: 내용을 출력하고 줄을 바꾸지 않습니다. (이어 쓰기)
*   **`printf()`**: 형식을 지정해서 출력합니다.

```java
System.out.println("Hello");
System.out.println("World");
// 결과:
// Hello
// World

System.out.print("Hello");
System.out.print("World");
// 결과: HelloWorld
```

## 2. 형식대로 출력하기 (`printf`)

"가격: 1000원" 처럼 문자와 변수를 섞어 쓸 때 유용합니다.

*   `%d`: 정수 (Integer)
*   `%f`: 실수 (Float)
*   `%s`: 문자열 (String)

```java
int price = 1000;
System.out.printf("가격: %d원\n", price); // \n은 줄바꿈
```
