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

```mermaid
flowchart LR
    subgraph Stack [스택 (Stack)]
        Ref1[String s1 = '100번지']
        Ref2[String s2 = null]
    end
    
    subgraph Heap [힙 (Heap)]
        Obj1['100번지: 객체 데이터']
    end
    
    Ref1 -->|정상 참조| Obj1
    Ref2 -.->|가리키는 곳 없음| Null[허공 💨]
    
    style Stack fill:#eef,stroke:#333
    style Heap fill:#efe,stroke:#333
    style Ref1 fill:#ff9,stroke:#333
    style Ref2 fill:#f99,stroke:#333
    style Obj1 fill:#bfb,stroke:#333
    style Null fill:#eee,stroke:#333,stroke-dasharray: 5 5
```

## 2. `NullPointerException` (가장 무서운 에러 😱)

`null`인 상태에서 무언가를 하려고 하면(도트를 찍으면 `.`) 발생하는 에러입니다.
**"주소가 없는데 어딜 찾아가라는 거야!"** 라고 컴퓨터가 화내는 것과 같습니다.

```java
String str = null;
System.out.println(str.length()); // 에러 발생! (NullPointerException)
```

> **해결책**: 항상 변수가 `null`인지 아닌지 확인하고 사용해야 합니다.
