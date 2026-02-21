---
layout: basic
title: "8.2 메모리 사용 영역"
nav_order: 2
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.2 메모리 사용 영역

자바(JVM)는 메모리 공간을 구역별로 나누어 사용합니다.
(마치 도서관이 열람실, 서고, 안내데스크로 나뉘어 있는 것처럼요.)

![그림](./img/memory_areas.png)

## 1. 메소드 영역 (Method Area) 📜
*   **비유**: **공용 게시판** (또는 칠판)
*   클래스(`Hello.class`)의 설계도, 상수, static 변수들이 저장됩니다.
*   모든 코드가 공유해서 봅니다.

## 2. 힙 영역 (Heap Area) 📚
*   **비유**: **서고 (책장)**
*   우리가 `new`라고 만들면 생성되는 **객체(Object)**와 **배열(Array)**이 여기에 저장됩니다.
*   참조 변수(주소)를 통해서만 접근할 수 있습니다.
*   쓰지 않는 객체는 청소부(Garbage Collector)가 갖다 버립니다.

## 3. 스택 영역 (Stack Area) 🖥️
*   **비유**: **개인 책상**
*   메소드가 실행될 때마다 잠깐 생겼다 사라지는 공간입니다.
*   우리가 만드는 변수(기본 타입 변수, 참조 변수)들이 여기에 잠시 머뭅니다.
*   메소드가 끝나면 책상은 싹 치워집니다(자동 제거).

---

### 메모리 영역 시각화 (도서관 비유)

```mermaid
graph TD
    subgraph JVM [JVM 메모리 (도서관)]
        direction LR
        Method[메소드 영역 📜\n(공용 게시판)\n클래스 정보, static 변수]
        Heap[힙 영역 📚\n(서고)\nnew 객체, 배열\nGarbage Collector가 관리]
        Stack[스택 영역 🖥️\n(개인 책상)\n지역 변수, 매개 변수]
    end
    
    style JVM fill:#f9f9f9,stroke:#333,stroke-width:2px
    style Method fill:#ffe6cc,stroke:#333
    style Heap fill:#d5e8d4,stroke:#333
    style Stack fill:#dae8fc,stroke:#333
```
