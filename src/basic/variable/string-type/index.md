---
layout: basic
title: "4.6 문자열 타입"
nav_order: 6
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
description: "4.6 문자열 타입 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "4.6 문자열 타입, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 4.6 문자열 타입 (String)

프로그래밍에서 가장 많이 사용하는 데이터 중 하나인 **문자열(String)**에 대해 알아봅니다.

---

## 1. 문자열이란? (Text) 🧵

### 1) 개념
문자열은 **문자(char)들의 나열**입니다.
작은따옴표가 아닌 **큰따옴표(`" "`)**로 감싸야 합니다.

### 2) 비유: "구슬 목걸이"
*   `char`가 구슬 하나라면, `String`은 구슬을 실에 꿰어 만든 **목걸이**입니다.
*   구슬(`char`)이 하나도 없어도 실만 있으면 목걸이(`String`)가 될 수 있습니다. (빈 문자열 가능)

### 3) 구조 시각화

```mermaid
graph LR
    String["String 'HELLO'"] --> H((H))
    String --> E((E))
    String --> L1((L))
    String --> L2((L))
    String --> O((O))
    
    style String fill:#f9f,stroke:#333
    style H fill:#fff,stroke:#333
    style E fill:#fff,stroke:#333
    style L1 fill:#fff,stroke:#333
    style L2 fill:#fff,stroke:#333
    style O fill:#fff,stroke:#333
```

---

## 2. String은 특별하다 (참조 타입) 🌟

### 1) 기본 타입이 아님
`int`, `double`, `boolean` 등은 소문자로 시작하는 **기본 타입(Primitive Type)**이지만, `String`은 대문자로 시작하는 **클래스(Class)**이자 **참조 타입(Reference Type)**입니다.

### 2) 메모리 저장 방식
*   기본 타입: 상자 안에 **값(데이터)**이 직접 들어있습니다.
*   참조 타입(String): 상자 안에 진짜 데이터가 있는 **주소(번지수)**가 들어있습니다. (보물지도 같은 개념)

```mermaid
graph LR
    Var[변수 name] -->|가리킴| Heap[객체 '홍길동']
    style Var fill:#bef,stroke:#333
    style Heap fill:#fdb,stroke:#333
```

---

## 3. 이스케이프 문자 (Escape Character) 🏃‍♂️

문자열 안에 쌍따옴표(`"`)를 넣거나 줄 바꿈을 하고 싶을 때, 역슬래시(`\`)를 사용하여 특별한 신호를 보냅니다.

| 기호 | 설명               | 예시             | 출력 결과                        |
| :--- | :----------------- | :--------------- | :------------------------------- |
| `\"` | 큰따옴표 출력      | `"\"안녕\""`     | `"안녕"`                         |
| `\'` | 작은따옴표 출력    | `'\'A\''`        | `'A'`                            |
| `\n` | 줄 바꿈 (New Line) | `"안녕\n하세요"` | 안녕<br>하세요                   |
| `\t` | 탭 (Tab)           | `"이름\t나이"`   | 이름&nbsp;&nbsp;&nbsp;&nbsp;나이 |
| `\\` | 역슬래시 출력      | `"C:\\Poler"`    | `C:\Folder`                      |

---

# 4.6 문자열 타입 (String)

프로그래밍에서 가장 많이 사용하는 데이터 중 하나인 **문자열(String)**에 대해 알아봅니다.

---

## 1. 문자열이란? (Text) 🧵

### 1) 개념
문자열은 **문자(char)들의 나열**입니다.
작은따옴표가 아닌 **큰따옴표(`" "`)**로 감싸야 합니다.

### 2) 비유: "구슬 목걸이"
*   `char`가 구슬 하나라면, `String`은 구슬을 실에 꿰어 만든 **목걸이**입니다.
*   구슬(`char`)이 하나도 없어도 실만 있으면 목걸이(`String`)가 될 수 있습니다. (빈 문자열 가능)

### 3) 구조 시각화

```mermaid
graph LR
    String["String 'HELLO'"] --> H((H))
    String --> E((E))
    String --> L1((L))
    String --> L2((L))
    String --> O((O))
    
    style String fill:#f9f,stroke:#333
    style H fill:#fff,stroke:#333
    style E fill:#fff,stroke:#333
    style L1 fill:#fff,stroke:#333
    style L2 fill:#fff,stroke:#333
    style O fill:#fff,stroke:#333
```

---

## 2. String은 특별하다 (참조 타입) 🌟

### 1) 기본 타입이 아님
`int`, `double`, `boolean` 등은 소문자로 시작하는 **기본 타입(Primitive Type)**이지만, `String`은 대문자로 시작하는 **클래스(Class)**이자 **참조 타입(Reference Type)**입니다.

### 2) 메모리 저장 방식
*   기본 타입: 상자 안에 **값(데이터)**이 직접 들어있습니다.
*   참조 타입(String): 상자 안에 진짜 데이터가 있는 **주소(번지수)**가 들어있습니다. (보물지도 같은 개념)

```mermaid
graph LR
    Var[변수 name] -->|가리킴| Heap[객체 '홍길동']
    style Var fill:#bef,stroke:#333
    style Heap fill:#fdb,stroke:#333
```

---

## 3. 이스케이프 문자 (Escape Character) 🏃‍♂️

문자열 안에 쌍따옴표(`"`)를 넣거나 줄 바꿈을 하고 싶을 때, 역슬래시(`\`)를 사용하여 특별한 신호를 보냅니다.

| 기호 | 설명               | 예시             | 출력 결과                        |
| :--- | :----------------- | :--------------- | :------------------------------- |
| `\"` | 큰따옴표 출력      | `"\"안녕\""`     | `"안녕"`                         |
| `\'` | 작은따옴표 출력    | `'\'A\''`        | `'A'`                            |
| `\n` | 줄 바꿈 (New Line) | `"안녕\n하세요"` | 안녕<br>하세요                   |
| `\t` | 탭 (Tab)           | `"이름\t나이"`   | 이름&nbsp;&nbsp;&nbsp;&nbsp;나이 |
| `\\` | 역슬래시 출력      | `"C:\\Poler"`    | `C:\Folder`                      |

### 코드 예시
```java
public class EscapeExample {
    public static void main(String[] args) {
        System.out.println("우리는 \"개발자\" 입니다."); 
        System.out.println("봄\t여름\t가을\t겨울");
        System.out.println("안녕\n반가워");
    }
}
```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`String`**: 스트링, 문자열 / 실(줄). (단어, 줄바꿈, 문장 등 여러 개의 글자들이 보이지 않는 실로 예쁘게 꿰어 있는 반짝이는 진주 목걸이 같은 데이터 타입)
*   **`Text`**: 텍스트, 글 / 문자. (화면에 근사하게 출력되거나 파일에 영구히 기록되는 사람이 읽고 이해할 수 있는 모든 종류의 연속된 글자들)
*   **`Reference Type`**: 레퍼런스 타입, 참조 타입. (데이터 자체를 무겁게 바로 짊어지고 있는 것이 아니라, 진짜 데이터가 살고 있는 주소(번지수)가 적힌 가벼운 보물지도를 들고 있는 타입. `String`도 고급지게 여기에 속함)
*   **`Escape Character`**: 이스케이프 캐릭터, 탈출 / 제어 문자. (`\`(역슬래시) 기호와 특별하게 만나서 마법의 기능을 부리며 화면 출력을 마음대로 예쁘게 컨트롤하도록 돕는 특공대 문자들)
