---
layout: basic
title: "5.7 삼항 연산자"
nav_order: 7
parent: "Chapter 05. 연산자"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 5.7 삼항 연산자

## 1. 간단한 갈림길 🛤️

`if-else` 문을 한 줄로 줄여 쓸 수 있는 편리한 도구입니다.
조건이 3개(조건, 참일 때, 거짓일 때)라서 삼항 연산자라고 부릅니다.

**공식:**
> **(조건) ? 참일_때_값 : 거짓일_때_값**

## 2. 예시

점수가 90점 이상이면 "A", 아니면 "B"를 주는 코드입니다.

```java
int score = 85;

// 삼항 연산자 사용
char grade = (score >= 90) ? 'A' : 'B';

System.out.println(grade); // B
```

`if` 문으로 쓰면 5줄이 넘어가는데, 삼항 연산자는 한 줄로 끝납니다!
