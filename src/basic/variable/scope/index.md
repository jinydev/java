---
layout: basic
title: "4.9 변수 사용 범위"
nav_order: 9
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 4.9 변수 사용 범위

## 1. 변수의 생명 주기 (Scope) 🌱

변수는 **자신이 선언된 블록 `{ ... }` 안에서만** 살 수 있습니다.
블록을 벗어나면 그 변수는 사라집니다.

*   **메소드 블록** 안에서 만들면 -> 메소드 안에서만 씀 (지역 변수)
*   **if문 블록** 안에서 만들면 -> if문 안에서만 씀

```java
public static void main(String[] args) {
    int v1 = 10;
    
    if (v1 > 5) {
        int v2 = 20; // v2는 이 if문 안에서만 존재
        System.out.println(v1 + v2); // 가능 (v1은 바깥에 있으니까)
    }
    
    // System.out.println(v2); // (X) 에러 발생! v2는 이미 사라짐
}
```

> **규칙**: **안쪽**에서는 **바깥쪽** 변수를 쓸 수 있지만, **바깥쪽**에서는 **안쪽** 변수를 쓸 수 없습니다.
