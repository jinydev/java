---
layout: oop
title: "17.6 동기화된 컬렉션"
nav_order: 6
parent: "Chapter 17. 컬렉션 자료구조"
grand_parent: "객체지향 자바 프로그래밍"
---

# 17.6 동기화된 컬렉션 (Synchronized)


<br>

## 1. 1인용 화장실 vs 공원 벤치 🚻

여러 스레드(사람)가 동시에 자료구조(시설)를 이용할 때 문제가 생길 수 있습니다.

1.  **비동기화 컬렉션 (`ArrayList`, `HashSet`, `HashMap`)**:
    *   **비유**: **"공원 벤치"**
    *   **특징**: 여러 사람이 동시에 앉을 수 있습니다. 빠르고 편합니다.
    *   **문제**: 두 사람이 동시에 같은 자리에 앉으려고 하면 부딪혀서 사고가 납니다. (데이터 깨짐, 에러 발생)

2.  **동기화 컬렉션 (`Vector`, `Hashtable`)**:
    *   **비유**: **"1인용 화장실"**
    *   **특징**: 한 번에 한 사람만 들어갈 수 있습니다. 문을 잠그고(`Lock`) 씁니다.
    *   **장점**: 안전합니다. 절대 겹치지 않습니다.
    *   **단점**: 줄을 서야 해서 느립니다.

<br>


<br>

## 2. 안전하게 바꾸기 (`Collections.synchronizedXXX`)

`ArrayList`는 빠르지만 위험하고, `Vector`는 안전하지만 느립니다.
평소에는 `ArrayList`를 쓰다가, 멀티 스레드 환경에서만 안전하게 바꾸고 싶다면?
**"공원 벤치에 번호표 기계 달기"**를 하면 됩니다.

```java
// 1. 불안한 ArrayList 생성
List<String> list = new ArrayList<>();

// 2. 안전한 List로 포장 (Wrapping)
List<String> safeList = Collections.synchronizedList(list);

// 이제 safeList는 Vector처럼 동작합니다. (동기화 됨)
```

마찬가지로 Set과 Map도 바꿀 수 있습니다.

```java
Set<String> safeSet = Collections.synchronizedSet(new HashSet<>());
Map<String, Integer> safeMap = Collections.synchronizedMap(new HashMap<>());
```

> **핵심 요약**: 혼자 쓸 때는 `ArrayList`, `HashMap`을 쓰세요. 여럿이 동시에 써야 한다면 `Collections.synchronized...`로 감싸서 쓰세요.
