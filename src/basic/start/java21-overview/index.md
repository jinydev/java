---
layout: basic
title: "1.5 자바 21 개요"
nav_order: 5
parent: "Chapter 03. 자바 시작하기"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 1.5 자바 21의 새로운 기능 🚀

자바는 계속해서 진화하고 있습니다. 특히 **Java 21**은 장기 지원(LTS, Long Term Support) 버전으로, 매우 중요하고 강력한 기능들이 대거 추가되었습니다.

---

## 1. 가상 스레드 (Virtual Threads) ⚡️

### 1) 개념
기존의 자바 스레드(뉴스레드)는 운영체제(OS)의 스레드와 1:1로 매핑되는 무거운 자원이었습니다.
**가상 스레드**는 운영체제 스레드 하나 위에서 수천, 수만 개가 동시에 동작할 수 있는 **초경량 스레드**입니다.

### 2) 비유: "고속도로와 드론"
*   **플랫폼 스레드 (기존)**: **대형 화물 트럭**. 한 번 움직일 때마다 비용이 많이 들고, 도로(OS 자원)를 많이 차지합니다.
*   **가상 스레드 (New)**: **경량 드론**. 트럭 짐칸에 수백 개의 드론이 실려 있다가, 필요할 때 날아가서 각자 임무를 수행하고 돌아옵니다.

![그림](./img/virtual_threads.png)

### 3) 구조 시각화

```mermaid
graph TD
    OS[운영체제 스레드 (트럭)]
    VT1[가상 스레드 1 (드론)]
    VT2[가상 스레드 2 (드론)]
    VT3[가상 스레드 3 (드론)]
    
    OS --> VT1
    OS --> VT2
    OS --> VT3
    
    style OS fill:#f9f,stroke:#333
    style VT1 fill:#bfb,stroke:#333
    style VT2 fill:#bfb,stroke:#333
    style VT3 fill:#bfb,stroke:#333
```

---

## 2. 순차 컬렉션 (Sequenced Collections) 📚

### 1) 개념
리스트(List), 셋(Set), 맵(Map) 등 순서가 있는 데이터 구조에서 **첫 번째 요소**나 **마지막 요소**에 쉽게 접근할 수 있는 표준 방법을 제공합니다.
이전에는 컬렉션마다 접근 방법이 제각각이었지만, 이제는 통일되었습니다.

### 2) 비유: "앞문과 뒷문이 있는 버스"
*   이전에는 어떤 버스는 앞문만 있고, 어떤 버스는 창문으로 타야 했습니다.
*   이제는 모든 순서가 있는 버스(컬렉션)에 표준 **앞문(`getFirst`)**과 **뒷문(`getLast`)**이 생겼습니다.

![그림](./img/sequenced_collections.png)

**예제 코드**
```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");

// Java 21 이전: 리스트만 get(0), 셋은 iterator... 복잡함
// Java 21 이후:
System.out.println(list.getFirst()); // "Apple"
System.out.println(list.getLast());  // "Banana"
```

---

## 3. 레코드 패턴 (Record Patterns) 📦

### 1) 개념
객체의 내부 데이터를 분해(Deconstruction)해서 변수에 바로 할당하는 기능입니다.
`instanceof`로 타입을 확인하면서 동시에 필드 값을 추출할 수 있습니다.

### 2) 비유: "택배 상자 투시"
*   예전에는 택배 상자를 받고(객체 확인), 칼로 뜯어서(타입 변환), 물건을 꺼내야(필드 접근) 했습니다.
*   이제는 **투시 안경**을 쓰고 상자를 보자마자 내용물이 내 손에 쥐어지는 것과 같습니다.

![그림](./img/record_patterns.png)

**예제 코드**
```java
record Point(int x, int y) {}

Object obj = new Point(10, 20);

// Java 21
if (obj instanceof Point(int x, int y)) {
    System.out.println("X=" + x + ", Y=" + y); // x, y 변수 바로 사용 가능!
}
```

---

## 4. Switch 문 개선 (Pattern Matching) 🔀

### 1) 개념
Switch 문에서 `null`을 처리할 수 있고, 숫자/문자뿐만 아니라 **객체의 타입**에 따라 분기할 수 있습니다.

**예제 코드**
```java
Object obj = "Hello";

String result = switch (obj) {
    case Integer i -> "정수입니다: " + i;
    case String s  -> "문자열입니다: " + s;
    case null      -> "null입니다";
    default        -> "알 수 없음";
};
```

---

## 5. UTF-8 기본 문자셋 채택 🌐
*   운영체제(윈도우, 맥, 리눅스)마다 달랐던 기본 문자셋이 **UTF-8**로 통일되었습니다.
*   이제 한글이 깨지는 문제(MS949 vs UTF-8)가 획기적으로 줄어듭니다.
