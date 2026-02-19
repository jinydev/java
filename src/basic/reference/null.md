---
layout: basic
title: "8.4 null과 NullPointerException"
nav_order: 4
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.4 null과 NullPointerException

## 1. `null` (텅 빔) 🈳

참조 변수는 주소를 저장합니다.
하지만 아직 가리킬 주소가 없다면? 이때 **`null`**(널)을 넣습니다.

*   "이 변수는 아직 아무것도 가리키고 있지 않아."
*   "명함 지갑이 비어있어."

## 2. `NullPointerException` (가장 무서운 에러 😱)

`null`인 상태에서 무언가를 하려고 하면(도트를 찍으면 `.`) 발생하는 에러입니다.
**"주소가 없는데 어딜 찾아가라는 거야!"** 라고 컴퓨터가 화내는 것과 같습니다.

```java
String str = null;
System.out.println(str.length()); // 에러 발생! (NullPointerException)
```

> **해결책**: 항상 변수가 `null`인지 아닌지 확인하고 사용해야 합니다.
