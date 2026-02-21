---
layout: basic
title: "1.4 바이트코드와 JVM"
nav_order: 4
parent: "Chapter 01. 자바 언어 소개"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 1.4 바이트코드와 JVM

자바가 운영체제에 독립적으로 실행될 수 있는 비결, 바로 **바이트코드**와 **JVM**의 비밀을 파헤쳐 봅니다. 🕵️‍♀️

---

## 1. 바이트코드 (Bytecode) 📜

### 1) 개념
자바 소스 파일(`.java`)을 컴파일하면 생성되는 `.class` 파일의 내용입니다.
컴퓨터(CPU)가 바로 이해할 수 있는 기계어가 아니라, **JVM만 이해할 수 있는 중간 언어**입니다.

![그림](./img/bytecode_concept.png)

### 2) 비유: "에스페란토 (공용어)"
*   한국인(Win), 미국인(Mac), 프랑스인(Linux)이 모여 있을 때, 각자의 언어로 말하면 소통이 안 됩니다.
*   이때 **"에스페란토(바이트코드)"**라는 공용어로 적어서 주면, 각자의 **통역사(JVM)**가 모국어로 통역해 줍니다.

![그림](./img/esperanto_analogy.png)

---

## 2. JVM (Java Virtual Machine) 🤖

### 1) 개념
**자바 가상 머신**의 약자로, 바이트코드를 읽어서 해당 운영체제가 이해할 수 있는 기계어로 번역하고 실행하는 **가상의 컴퓨터**입니다.

![그림](./img/jvm_concept.png)

### 2) 비유: "전용 통역사"
*   **개발자**: "나는 윈도우용, 맥용 따로 만들기 귀찮아. 그냥 자바어로 한 번만 말할게!"
*   **JVM**: "걱정 마세요. 제가 윈도우한테는 윈도우 말로, 맥한테는 맥 말로 통역해 드릴게요."

![그림](./img/jvm_exclusive.png)

---

## 3. JVM 내부 구조 (심화) 🧠

JVM이 어떻게 동작하는지 **요리 과정**에 비유하여 알아봅니다.

```mermaid
graph TD
    classDef box fill:#fff,stroke:#333,stroke-width:2px;
    classDef grp fill:#eee,stroke:#333,stroke-dasharray: 5 5;

    Source[Hello.class<br>(식재료)] --> CL[Class Loader<br>(재료 손질)]
    CL --> Runtime[Runtime Data Area<br>(주방)]
    
    subgraph JVM [JVM (레스토랑)]
        direction TB
        CL
        Runtime
        EE[Execution Engine<br>(요리사)]
        GC[Garbage Collector<br>(청소부)]
    end
    
    Runtime <--> EE
    Runtime -.-> GC
    
    style JVM fill:#eef,stroke:#333
    style Runtime fill:#fed,stroke:#333
    style CL fill:#def,stroke:#333
    style EE fill:#bfb,stroke:#333
    style GC fill:#fbb,stroke:#333
```

### 1) Class Loader (재료 손질)
*   `.class` 파일을 읽어들여서 JVM이 사용할 수 있게 메모리(주방)에 배치합니다.
*   **비유**: 창고에서 식재료를 꺼내 다듬어서 주방 선반에 올려놓는 과정입니다.
   
![그림](./img/class_loader.png)


### 2) Runtime Data Area (주방)
*   프로그램 실행에 필요한 데이터가 저장되는 메모리 공간입니다.
*   **비유**: 요리사가 요리할 때 쓰는 도마, 냄비, 접시가 놓인 **조리대**입니다.

![그림](./img/runtime_data_area.png)

### 3) Execution Engine (요리사)
*   메모리에 로드된 바이트코드를 한 줄씩 읽어서 실제 기계어로 변환하고 실행합니다.
*   **비유**: 조리대에 있는 재료로 실제로 **요리**를 하는 셰프입니다.

![그림](./img/execution_engine.png)

### 4) Garbage Collector (청소부)
*   더 이상 쓰지 않는 메모리(객체)를 자동으로 정리합니다.
*   **비유**: 요리가 끝나고 남은 껍질이나 빈 그릇을 치워주는 **청소 담당**입니다.

![그림](./img/garbage_cleaner.png)