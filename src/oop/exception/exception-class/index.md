---
layout: oop
title: "14.1 예외와 클래스"
nav_order: 1
parent: "Chapter 14. 예외 처리"
grand_parent: "객체지향 자바 프로그래밍"
---

# 14.1 예외와 예외 클래스 (Exception & Error)


<br>

## 1. 천재지변 vs 교통사고 💥

컴퓨터 프로그램도 살다 보면 문제가 생깁니다. 자바에서는 이를 크게 두 가지로 나눕니다.

1.  **에러(Error) - 천재지변**: 컴퓨터의 메모리가 부족하거나(`OutOfMemoryError`), 시스템이 고장 나는 등 프로그램이 도저히 손쓸 수 없는 심각한 상황입니다. (복구 불가)
2.  **예외(Exception) - 교통사고**: 사용을 잘못하거나 코딩 실수로 발생하는 문제들입니다. 다행히 **예외 처리(Insurance)**를 잘 해두면 프로그램이 죽지 않고 계속 실행될 수 있습니다. (수습 가능)

![Exception Hierarchy](./img/exception_hierarchy.svg)

<br>


<br>

## 2. 일반 예외 vs 실행 예외

예외(`Exception`)는 다시 두 가지로 나뉩니다.

### 1) 일반 예외 (Checked Exception) - "공사 중 표지판" 🚧
*   **특징**: 컴파일러가 "야, 여기 사고 날 수도 있어!"라고 미리 경고합니다.
*   **강제성**: **무조건** 예외 처리를 해야 합니다. 안 하면 컴파일이 안 됩니다(빨간 줄).
*   **예시**: `ClassNotFoundException` (없는 클래스 로딩), `IOException` (파일 입출력)

### 2) 실행 예외 (RuntimeException) - "무단 횡단" 🏃
*   **특징**: 컴파일러는 모릅니다. 실행해봐야 압니다(Unchecked). 주로 프로그래머의 실수로 발생합니다.
*   **강제성**: 예외 처리가 강제되지 않습니다. (하지만 하는 게 좋습니다.)
*   **예시**: `NullPointerException` (빈 객체 건드림), `ArrayIndexOutOfBoundsException` (배열 범위 초과)

<br>


<br>

## 3. 자주 보는 실행 예외들

가장 많이 겪게 될 "3대장" 예외입니다.

1.  **NullPointerException (NPE)**: `null`인 변수의 메소드를 호출할 때. "없는 사람한테 말 걸기".
2.  **ArrayIndexOutOfBoundsException**: 배열 크기는 3인데 5번째 칸을 요구할 때. "없는 좌석표 들이밀기".
3.  **NumberFormatException**: 숫자가 아닌 문자열("100a")을 숫자로 바꾸려 할 때.

> **핵심 요약**: 에러는 포기해야 하지만, **예외는 우리가 살릴 수 있습니다.** 특히 컴파일러가 경고하는 **일반 예외(Checked)**는 반드시 처리 코드를 작성해야 합니다.
