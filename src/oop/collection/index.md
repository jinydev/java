---
layout: oop
title: "Chapter 17. 컬렉션 자료구조"
nav_order: 17
has_children: true
parent: "객체지향 자바 프로그래밍"
description: "Chapter 17. 컬렉션 자료구조 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "Chapter 17. 컬렉션 자료구조, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# Chapter 17. 컬렉션 자료구조 (Collection Framework)

> **"효율적인 데이터 정리를 위한 자바의 정리 정돈 도구들"**


<br>

## 학습목표

1.  **List (순서 O, 중복 O)**: 줄을 서서 기다리는 데이터 관리법을 배웁니다.
2.  **Set (순서 X, 중복 X)**: 유일한 데이터만 모으는 법을 배웁니다.
3.  **Map (키-값)**: 짝을 지어 데이터를 관리하는 법을 배웁니다.
4.  **Tree (정렬)**: 자동으로 순서를 매기며 저장하는 법을 배웁니다.
5.  **LIFO & FIFO**: 스택과 큐의 구조를 이해합니다.

![List Concept Todo](./img/list_concept_todo.svg)

---


<br>

## 목차

### [17.1 List 컬렉션](./list)
순서가 있고 중복을 허용하는 **"할 일 목록(To-Do List)"** 같은 자료구조입니다. (`ArrayList`, `LinkedList`, `Vector`)

### [17.2 Set 컬렉션](./set)
순서가 없고 중복을 허용하지 않는 **"보석함(Jewelry Box)"** 같은 자료구조입니다. (`HashSet`, `LinkedHashSet`)

### [17.3 Map 컬렉션](./map)
키(Key)와 값(Value)의 쌍으로 저장되는 **"목욕탕 라커(Locker)"** 같은 자료구조입니다. (`HashMap`, `Hashtable`, `Properties`)

### [17.4 검색 기능을 강화시킨 컬렉션](./tree)
저장할 때부터 자동으로 정렬되는 **"도서관 책장"** 같은 자료구조입니다. (`TreeSet`, `TreeMap`)

### [17.5 LIFO와 FIFO 컬렉션](./stack-queue)
나중에 넣은 게 먼저 나오는 **"프링글스 통(Stack)"**과 먼저 줄 선 사람이 먼저 타는 **"버스 줄(Queue)"** 자료구조입니다.

### [17.6 동기화된 컬렉션](./synchronized)
여러 스레드가 동시에 접근해도 안전한 **"1인용 화장실"** 같은 컬렉션을 만드는 방법입니다.
---

# Chapter 17. 컬렉션 자료구조 (Collection Framework)

> **"효율적인 데이터 정리를 위한 자바의 정리 정돈 도구들"**


<br>

## 학습목표

1.  **List (순서 O, 중복 O)**: 줄을 서서 기다리는 데이터 관리법을 배웁니다.
2.  **Set (순서 X, 중복 X)**: 유일한 데이터만 모으는 법을 배웁니다.
3.  **Map (키-값)**: 짝을 지어 데이터를 관리하는 법을 배웁니다.
4.  **Tree (정렬)**: 자동으로 순서를 매기며 저장하는 법을 배웁니다.
5.  **LIFO & FIFO**: 스택과 큐의 구조를 이해합니다.

![List Concept Todo](./img/list_concept_todo.svg)

---


<br>

## 목차

### [17.1 List 컬렉션](./list)
순서가 있고 중복을 허용하는 **"할 일 목록(To-Do List)"** 같은 자료구조입니다. (`ArrayList`, `LinkedList`, `Vector`)

### [17.2 Set 컬렉션](./set)
순서가 없고 중복을 허용하지 않는 **"보석함(Jewelry Box)"** 같은 자료구조입니다. (`HashSet`, `LinkedHashSet`)

### [17.3 Map 컬렉션](./map)
키(Key)와 값(Value)의 쌍으로 저장되는 **"목욕탕 라커(Locker)"** 같은 자료구조입니다. (`HashMap`, `Hashtable`, `Properties`)

### [17.4 검색 기능을 강화시킨 컬렉션](./tree)
저장할 때부터 자동으로 정렬되는 **"도서관 책장"** 같은 자료구조입니다. (`TreeSet`, `TreeMap`)

### [17.5 LIFO와 FIFO 컬렉션](./stack-queue)
나중에 넣은 게 먼저 나오는 **"프링글스 통(Stack)"**과 먼저 줄 선 사람이 먼저 타는 **"버스 줄(Queue)"** 자료구조입니다.

### [17.6 동기화된 컬렉션](./synchronized)
여러 스레드가 동시에 접근해도 안전한 **"1인용 화장실"** 같은 컬렉션을 만드는 방법입니다.

---


<br>

## 확인문제
- [확인문제](./quiz)

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Collection`**: 컬렉션, 수집, 모음. (수많은 데이터를 배열보다 훨씬 똑똑하고 알아서 크기도 늘려가며 다루기 쉽게 모아놓은 자바의 데이터 보관함 세트)
*   **`Framework`**: 프레임워크, 뼈대, 구조. (컬렉션을 사용할 때 개발자가 맨땅에 헤딩하지 않도록, 미리 잘 만들어둔 클래스와 인터페이스의 거대한 표준 설계도)
