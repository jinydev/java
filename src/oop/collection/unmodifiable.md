---
layout: oop
title: "17.7 수정할 수 없는 컬렉션"
nav_order: 7
parent: "Chapter 17. 컬렉션 자료구조"
grand_parent: "객체지향 자바 프로그래밍"
---

# 17.7 수정할 수 없는 컬렉션 (Immutable)


<br>

## 1. 박물관 전시품 🖼️

데이터를 저장한 후에 **"이제 아무도 건드리지 마!"**라고 확정 짓고 싶을 때가 있습니다.
이것을 **수정할 수 없는(Immutable) 컬렉션**이라고 합니다.
마치 유리관 속에 넣은 박물관 전시품처럼, **보기만(Read) 할 수 있고 만질(Write) 수는 없습니다.**

만약 억지로 데이터를 추가하거나 삭제하려고 하면?
`UnsupportedOperationException` (지원하지 않는 기능입니다!) 에러가 발생하며 쫓겨납니다. 👮‍♂️

<br>


<br>

## 2. 만드는 방법 (`of`, `copyOf`)

자바 9부터 아주 쉽게 만들 수 있는 방법이 추가되었습니다.

### 1) 처음부터 불변으로 만들기 (`.of()`)

```java
// "A", "B", "C"가 들어있는 리스트 생성 (수정 불가)
List<String> list = List.of("A", "B", "C");

// list.add("D"); // 에러 발생! ❌
// list.remove(0); // 에러 발생! ❌
```

Set과 Map도 똑같습니다.

```java
Set<String> set = Set.of("A", "B", "C");
Map<Integer, String> map = Map.of(1, "A", 2, "B");
```

### 2) 기존 컬렉션을 불변으로 복사하기 (`.copyOf()`)

이미 있는 `ArrayList`를 수정 못 하게 박제하고 싶다면?

```java
// 1. 일반 리스트 (수정 가능)
List<String> normalList = new ArrayList<>();
normalList.add("Java");

// 2. 불변 리스트로 복사 (수정 불가)
List<String> safeList = List.copyOf(normalList);

// safeList.add("Python"); // 에러 발생! ❌
```

> **핵심 요약**: 변하면 안 되는 기준 정보(예: 요일, 메뉴판, 설정값)는 `List.of()` 등을 사용해서 **불변 컬렉션**으로 만드는 것이 안전합니다.
