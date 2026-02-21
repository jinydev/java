---
layout: basic
title: "8.6 배열(Array) 타입"
nav_order: 6
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.6 배열(Array) 타입

## 1. 기차 만들기 🚂

변수는 하나에 값 하나만 담을 수 있습니다.
값이 30개라면 변수 30개를 만들어야 할까요? (너무 힘듭니다!)

**배열(Array)**은 같은 타입의 변수를 여러 개 묶어서 **기차처럼 길게 연결한 것**입니다.

![그림](./img/array_train.png)

## 2. 선언과 생성

```java
// 1. 선언 (기차표 끊기)
int[] scores;

// 2. 생성 (좌석 30개짜리 기차 만들기)
scores = new int[30];

// 3. 값 넣기 (승객 태우기)
scores[0] = 90; // 첫 번째 칸 (0번부터 시작!)
scores[1] = 80;
```

```mermaid
flowchart LR
    subgraph Stack [스택 영역]
        Ref[scores]
    end
    
    subgraph Heap [힙 영역]
        direction LR
        Arr0[0번 칸\n90] -.- Arr1[1번 칸\n80] -.- Arr2[... 29번 칸]
    end
    
    Ref -->|배열의 시작 주소를 가리킴| Arr0
    
    style Stack fill:#eef,stroke:#333
    style Heap fill:#efe,stroke:#333
    style Ref fill:#ff9,stroke:#333
    style Arr0 fill:#bfb,stroke:#333,stroke-width:2px
    style Arr1 fill:#bfb,stroke:#333,stroke-width:2px
    style Arr2 fill:#eee,stroke:#333
```

## 3. 한 방에 만들기

```java
int[] scores = { 90, 80, 70, 60 };
```

> **주의**: 배열의 순서(인덱스)는 **0부터 시작**합니다. (0, 1, 2, ...)
