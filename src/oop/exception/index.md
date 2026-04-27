---
layout: oop
title: "Chapter 14. 예외 처리"
nav_order: 14
has_children: true
parent: "객체지향 자바 프로그래밍"
description: "Chapter 14. 예외 처리 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "Chapter 14. 예외 처리, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# Chapter 14. 예외 처리 (Exception Handling)

> **"사고(Bug)를 예방하고, 사고가 나도 수습하는 안전장치"**


<br>

## 학습목표

1.  예외(Exception)와 에러(Error)의 차이를 이해합니다.
2.  **일반 예외(Checked)**와 **실행 예외(Unchecked)**의 종류와 특징을 구별합니다.
3.  `try-catch-finally` 블록을 사용하여 예외를 안전하게 처리하는 방법을 익힙니다.
4.  `try-with-resources`를 통해 리소스를 자동으로 닫는 방법을 배웁니다.
5.  `throws` 키워드로 예외를 떠넘기는 방법과 사용자 정의 예외를 만드는 법을 배웁니다.

![Exception Hierarchy](./img/exception_hierarchy.svg)

---


<br>

## 목차

### [14.1 예외와 예외 클래스](./exception-class)
프로그램 실행 중 발생하는 오류의 종류와 자바의 예외 클래스 계층 구조를 배웁니다.

### [14.2 예외 처리 코드 (try-catch-finally)](./handling-code)
예외가 발생했을 때 프로그램이 종료되지 않도록 안전하게 처리하는 기본 문법을 배웁니다.

### [14.3 예외 종류에 따른 처리](./handling-by-type)
다양한 예외 상황(숫자 포맷 오류, 널 포인터 등)을 각각 다르게 처리하는 다중 `catch` 기법을 배웁니다.

### [14.4 리소스 자동 닫기 (try-with-resources)](./try-with-resources)
파일이나 네트워크 연결 같은 리소스를 사용 후 자동으로 닫아주는(`close`) 편리한 문법을 배웁니다.

### [14.5 예외 떠넘기기 (throws)](./throws)
메소드 내부에서 발생한 예외를 직접 처리하지 않고, 메소드를 호출한 곳으로 책임을 넘기는 방법을 배웁니다.

### [14.6 사용자 정의 예외](./custom-exception)
자바 표준 예외 외에 내 프로그램에 맞는 커스텀 예외를 만들고 발생시키는 방법을 배웁니다.
---

# Chapter 14. 예외 처리 (Exception Handling)

> **"사고(Bug)를 예방하고, 사고가 나도 수습하는 안전장치"**


<br>

## 학습목표

1.  예외(Exception)와 에러(Error)의 차이를 이해합니다.
2.  **일반 예외(Checked)**와 **실행 예외(Unchecked)**의 종류와 특징을 구별합니다.
3.  `try-catch-finally` 블록을 사용하여 예외를 안전하게 처리하는 방법을 익힙니다.
4.  `try-with-resources`를 통해 리소스를 자동으로 닫는 방법을 배웁니다.
5.  `throws` 키워드로 예외를 떠넘기는 방법과 사용자 정의 예외를 만드는 법을 배웁니다.

![Exception Hierarchy](./img/exception_hierarchy.svg)

---


<br>

## 목차

### [14.1 예외와 예외 클래스](./exception-class)
프로그램 실행 중 발생하는 오류의 종류와 자바의 예외 클래스 계층 구조를 배웁니다.

### [14.2 예외 처리 코드 (try-catch-finally)](./handling-code)
예외가 발생했을 때 프로그램이 종료되지 않도록 안전하게 처리하는 기본 문법을 배웁니다.

### [14.3 예외 종류에 따른 처리](./handling-by-type)
다양한 예외 상황(숫자 포맷 오류, 널 포인터 등)을 각각 다르게 처리하는 다중 `catch` 기법을 배웁니다.

### [14.4 리소스 자동 닫기 (try-with-resources)](./try-with-resources)
파일이나 네트워크 연결 같은 리소스를 사용 후 자동으로 닫아주는(`close`) 편리한 문법을 배웁니다.

### [14.5 예외 떠넘기기 (throws)](./throws)
메소드 내부에서 발생한 예외를 직접 처리하지 않고, 메소드를 호출한 곳으로 책임을 넘기는 방법을 배웁니다.

### [14.6 사용자 정의 예외](./custom-exception)
자바 표준 예외 외에 내 프로그램에 맞는 커스텀 예외를 만들고 발생시키는 방법을 배웁니다.

---


<br>

## 확인문제
- [확인문제](./quiz)

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Exception`**: 익셉션, 예외. (프로그램 실행 중 예기치 않게 발생하는, 그러나 미리 대비하면 충분히 수습 가능한 가벼운 접촉 사고 같은 오류)
*   **`Handling`**: 핸들링, 처리. (예외 상황이 터졌을 때 프로그램이 허무하게 뻗어버리지 않도록, 안전하게 운전대를 꽉 붙잡고 상황을 수습하는 조치)
