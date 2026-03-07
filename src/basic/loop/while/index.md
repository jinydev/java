---
layout: basic
title: "7.2 while 문"
nav_order: 2
parent: "Chapter 07. 반복문"
grand_parent: "Part 01. 자바 언어의 기초"
description: "7.2 while 문 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "7.2 while 문, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 7.2 while 문

## 1. 조건이 맞을 때까지 반복하기 🔄

**"노래가 끝날 때까지 춤을 춰!"** 처럼 **조건**이 중요할 때 사용합니다.
몇 번 반복할지는 모르지만, 특정 조건이 만족되는 동안은 계속 실행합니다.

![그림](./img/while_loop.png)

```mermaid
flowchart TD
    Start([시작]) --> Cond{조건식 (노래가 나오는가?)}
    
    Cond -- "참 (true)" --> Run[실행 블록 (춤을 춘다)]
    Run --> Cond
    
    Cond -- "거짓 (false)" --> End([종료])
    
    style Start fill:#f9f,stroke:#333,stroke-width:2px
    style End fill:#ccc,stroke:#333,stroke-width:2px
    style Cond fill:#ff9,stroke:#333,stroke-width:2px
    style Run fill:#bfb,stroke:#333,stroke-width:2px
```

```java
int i = 1;
while (i <= 10) {
    System.out.println(i);
    i++;
}
```

## 2. for문과 차이점

*   **`for`**: 횟수가 정해져 있을 때 좋습니다. (배열, 리스트 등)
*   **`while`**: 횟수보다는 조건이 중요할 때 좋습니다. (사용자가 종료 버튼을 누를 때까지, 파일의 끝까지 읽을 때 등)

> **주의**: 조건이 항상 `true`이면 **무한 루프(Infinite Loop)**에 빠져서 프로그램이 멈추지 않습니다. 반드시 조건을 `false`로 만들어주는 코드가 필요합니다.
