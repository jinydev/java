---
layout: oop
title: "14.3 예외 종류에 따른 처리"
nav_order: 3
parent: "Chapter 14. 예외 처리"
grand_parent: "객체지향 자바 프로그래밍"
---

# 14.3 예외 종류에 따른 처리 (Multi-catch)


<br>

## 1. 종합 병원 진료 시스템 🏥

병원에는 내과, 외과, 치과 등 전문 분야가 있습니다. 환자(예외)의 증상에 따라 의사가 달라져야 합니다.
자바의 `try-catch`도 마찬가지입니다. 하나의 `try` 블록에서 여러 종류의 예외가 발생할 수 있다면, `catch` 블록을 여러 개 만들어 각각 다르게 처리할 수 있습니다.

![Multi Catch Triage](./img/multi_catch_triage.svg)

<br>


<br>

## 2. 기본 다중 catch

```java
try {
    // 1. 배열 인덱스 초과 가능성
    // 2. 숫자 포맷 오류 가능성
} catch(ArrayIndexOutOfBoundsException e) {
    System.out.println("인덱스 오류! 배열 범위를 확인하세요.");
} catch(NumberFormatException e) {
    System.out.println("숫자 포맷 오류! 숫자만 입력하세요.");
}
```

*   **동작 원리**: 예외가 터지면 위에서부터 순서대로 `catch` 블록을 검사합니다. 맞는 타입이 있으면 실행하고 나머지는 건너뜁니다.
*   **주의**: `catch` 블록 중 **단 하나만** 실행됩니다.

<br>


<br>

## 3. 상속 관계 주의 (순서가 중요!)

모든 예외의 부모인 `Exception` 클래스는 **"모든 병을 고치는 만능 의사(일반의)"**와 같습니다.
만약 `catch(Exception e)`를 맨 위에 작성하면 어떻게 될까요?

```java
// ❌ 잘못된 순서
try { ... } 
catch(Exception e) { ... } // 여기서 다 걸러짐 (모든 예외의 부모니까)
catch(NullPointerException e) { ... } // 여기까지 올 기회가 없음 (Unreachable Code)
```

따라서 **구체적인 자식 예외(전문의)**를 먼저 쓰고, **부모 예외(일반의)**는 맨 마지막에 써야 합니다.

```java
// ✅ 올바른 순서
catch(NullPointerException e) { ... }
catch(NumberFormatException e) { ... }
catch(Exception e) { ... } // 마지막 보루 (나머지 모든 예외 처리)
```

<br>


<br>

## 4. 멀티 catch (파이프 `|`)

Java 7부터는 똑같은 처리를 하는 예외들을 하나로 묶을 수 있습니다.

```java
try { ... } 
catch(NullPointerException | NumberFormatException e) {
    // 두 예외 중 하나가 발생하면 여기서 처리
    System.out.println("데이터에 문제가 있습니다.");
}
```

> **핵심 요약**: 예외 처리는 **"구체적인 것부터, 추상적인 것 순서로"** 작성해야 합니다. `Exception`은 최후의 안전장치(`else`)라고 생각하세요.
