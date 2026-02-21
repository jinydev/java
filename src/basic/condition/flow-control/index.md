---
layout: basic
title: "6.1 코드 실행 흐름 제어"
nav_order: 1
parent: "Chapter 06. 조건문"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 6.1 코드 실행 흐름 제어

## 1. 물 흐르듯 실행되는 코드 🌊

자바 프로그램은 기본적으로 `main()` 메소드의 첫 줄부터 마지막 줄까지 **위에서 아래로** 순서대로 실행됩니다.
마치 강물이 위에서 아래로 흐르는 것과 같습니다.

![그림](./img/code_flow.png)

```mermaid
flowchart TD
    Start([프로그램 시작]) --> Step1[첫 번째 줄 실행: 물 긷기]
    Step1 --> Step2[두 번째 줄 실행: 물 나르기]
    Step2 --> Step3[세 번째 줄 실행: 물 붓기]
    Step3 --> End([프로그램 종료])

    style Start fill:#f9f,stroke:#333,stroke-width:2px
    style End fill:#f9f,stroke:#333,stroke-width:2px
    style Step1 fill:#bbf,stroke:#333,stroke-width:2px
    style Step2 fill:#bbf,stroke:#333,stroke-width:2px
    style Step3 fill:#bbf,stroke:#333,stroke-width:2px
```

## 2. 댐을 만들어 흐름 바꾸기 (제어문) 🚧

하지만 항상 위에서 아래로만 흐르면 재미없는 프로그램밖에 못 만듭니다.
상황에 따라 물길을 바꾸거나(조건문), 물을 가둬서 빙빙 돌려야(반복문) 할 때도 있습니다.

![그림](./img/flow_control_dam.png)

```mermaid
flowchart TD
    Start([위에서 내려오는 강물]) --> IF_Dam{조건문 댐: 오른쪽? 왼쪽?}
    
    IF_Dam -- "오른쪽 길로 갈까 (참)" --> Path1[오른쪽으로 흐름]
    IF_Dam -- "왼쪽 길로 갈까 (거짓)" --> Path2[왼쪽으로 흐름]
    
    Path1 --> Merge((합류))
    Path2 --> Merge
    
    Merge --> LOOP_Dam{반복문 댐: 10바퀴 다 돌았나?}
    
    LOOP_Dam -- "아니오 (운동장 10바퀴 돌아!)" --> Merge
    LOOP_Dam -- "예 (탈출!)" --> End([바다로 흘러감])

    style Start fill:#f9f,stroke:#333,stroke-width:2px
    style End fill:#f9f,stroke:#333,stroke-width:2px
    style IF_Dam fill:#ff9,stroke:#333,stroke-width:2px
    style LOOP_Dam fill:#ff9,stroke:#333,stroke-width:2px
    style Path1 fill:#bbf,stroke:#333,stroke-width:2px
    style Path2 fill:#bbf,stroke:#333,stroke-width:2px
    style Merge fill:#ccc,stroke:#333,stroke-width:2px
```

이런 역할을 하는 것이 **제어문(Control Statement)**입니다.

*   **조건문 (`if`, `switch`)**: "오른쪽 길로 갈까, 왼쪽 길로 갈까?" (갈림길)
*   **반복문 (`for`, `while`)**: "운동장 10바퀴 돌아!" (뺑뺑이)
