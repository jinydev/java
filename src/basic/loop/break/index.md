---
layout: basic
title: "7.4 break 문"
nav_order: 4
parent: "Chapter 07. 반복문"
grand_parent: "Part 01. 자바 언어의 기초"
description: "7.4 break 문 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "7.4 break 문, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 7.4 break 문

## 1. 탈출 버튼 🛑

반복문(`for`, `while`)을 실행하다가 **즉시 멈추고 밖으로 나가고 싶을 때** 사용합니다.
마치 비상 탈출 버튼과 같습니다.

![그림](./img/break_statement.png)

```mermaid
flowchart TD
    Start([반복 시작]) --> Run[실행중...]
    Run --> Check{탈출 조건 만족?}
    
    Check -- "아니오 (계속 반복)" --> Run
    Check -- "예 (break! 🚨)" --> Exit([반복문 완전 빠져나감])
    
    style Start fill:#f9f,stroke:#333
    style Run fill:#bfb,stroke:#333
    style Check fill:#ff9,stroke:#333
    style Exit fill:#f99,stroke:#333,stroke-width:2px
```

```java
while(true) { // 무한 반복
    int num = (int)(Math.random() * 6) + 1;
    System.out.println(num);
    
    if(num == 6) {
        break; // 6이 나오면 즉시 종료!
    }
}
System.out.println("프로그램 종료");
```

가장 가까운 반복문 하나만 빠져나옵니다.
