---
layout: basic
title: "7.1 for 문"
nav_order: 1
parent: "Chapter 07. 반복문"
grand_parent: "Part 01. 자바 언어의 기초"
description: "7.1 for 문 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "7.1 for 문, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 7.1 for 문

## 1. 정해진 횟수만큼 반복하기 🏃‍♂️

**"운동장 10바퀴 뛰어!"** 처럼 **반복 횟수**가 명확할 때 사용하는 반복문입니다.

![그림](./img/for_loop.png)

```java
// 1부터 10까지 출력하기
for(int i=1; i<=10; i++) {
    System.out.println(i);
}
```

## 2. 구성 요소와 실행 순서

`for (초기화식; 조건식; 증감식) { 실행문 }`

```mermaid
flowchart TD
    Start([반복문 시작]) --> Init[1. 초기화식 (i=1)]
    Init --> Cond{2. 조건식 (i<=10)}
    
    Cond -- "참(true)" --> Run[3. 실행문 (출력)]
    Run --> Inc[4. 증감식 (i++)]
    Inc --> Cond
    
    Cond -- "거짓(false)" --> End([반복문 종료])
    
    style Start fill:#f9f,stroke:#333,stroke-width:2px
    style End fill:#f9f,stroke:#333,stroke-width:2px
    style Cond fill:#ff9,stroke:#333,stroke-width:2px
    style Init fill:#bbf,stroke:#333
    style Run fill:#bfb,stroke:#333,stroke-width:2px
    style Inc fill:#fcf,stroke:#333
```

1.  **초기화식 (`int i=1`)**: 시작점입니다. (1번부터 시작!) - **최초 1회만** 실행됩니다.
2.  **조건식 (`i<=10`)**: "여기까지만 해." (10번 이하일 때만 계속해) - 참이면 실행, 거짓이면 탈출합니다.
3.  **실행문**: 조건이 참일 때 실행되는 실제 명령입니다.
4.  **증감식 (`i++`)**: "한 바퀴 돌았으면 카운트 올려." (1씩 증가) - 실행 후 조건식으로 다시 돌아갑니다.

## 3. 중첩 for 문 (구구단)

`for` 문 안에 또 `for` 문을 넣을 수 있습니다.

```java
for (int m=2; m<=9; m++) {
    System.out.println("*** " + m + "단 ***");
    for (int n=1; n<=9; n++) {
        System.out.println(m + " x " + n + " = " + (m*n));
    }
}
```
