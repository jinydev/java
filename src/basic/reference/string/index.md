---
layout: basic
title: "8.5 문자열(String) 타입"
nav_order: 5
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.5 문자열(String) 타입

## 1. 문자열도 객체입니다

우리가 편하게 쓰는 `String`은 사실 **참조 타입(객체)**입니다.
그래서 변수에는 실제 문자열이 아니라 **주소**가 저장됩니다.

## 2. 문자열 리터럴의 비밀

```java
String name1 = "홍길동";
String name2 = "홍길동";
```
자바는 메모리를 아끼기 위해, 똑같은 문자열 리터럴("홍길동")이 있으면 **새로 만들지 않고 기존 주소를 재사용**합니다.
그래서 `name1 == name2`가 `true`가 나옵니다.

```mermaid
flowchart LR
    subgraph Stack [스택 (Stack)]
        n1[name1]
        n2[name2]
    end
    
    subgraph Heap [힙 (Heap)]
        subgraph Pool [String Constant Pool]
            str["홍길동"]
        end
    end
    
    n1 -->|같은 주소 가리킴| str
    n2 -->|같은 주소 가리킴| str
    
    style Stack fill:#eef,stroke:#333
    style Heap fill:#efe,stroke:#333
    style Pool fill:#d5e8d4,stroke:#333,stroke-dasharray: 5 5
    style str fill:#bfb,stroke:#333
```

하지만 `new String("홍길동")`으로 만들면 강제로 새로운 집을 짓기 때문에 주소가 달라집니다.

> **결론**: 문자열 비교는 묻지도 따지지도 말고 그냥 **`equals()`**를 쓰세요. 그게 마음 편합니다.
