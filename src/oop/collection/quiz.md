---
layout: oop
title: "확인문제"
nav_order: 99
parent: "Chapter 17. 컬렉션 자료구조"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제


<br>

## 1. 컬렉션 프레임워크 특징
자바의 컬렉션 프레임워크에 대한 설명으로 **틀린 것**은 무엇입니까?
- ① List 컬렉션은 인덱스로 객체를 관리하며 중복 저장을 허용한다.
- ② Set 컬렉션은 순서를 유지하지 않으며 중복 저장을 허용하지 않는다.
- ③ Map 컬렉션은 키와 값으로 구성된 Map.Entry를 저장한다.
- ④ Stack은 FIFO (선입선출) 자료구조를 구현한 클래스이다.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ④
<br>
Stack은 **LIFO(후입선출)** 자료구조입니다. 나중에 넣은 게 먼저 나옵니다.
FIFO는 Queue입니다.
</div>
</details>

<br>


<br>

## 2. List 컬렉션 특징
List 컬렉션에 대한 설명 중 **틀린 것**은 무엇입니까?
- ① 대표적인 구현 클래스로는 ArrayList, Vector, LinkedList가 있다.
- ② 멀티 스레드 환경에서는 ArrayList보다는 Vector가 스레드에 안전하다.
- ③ ArrayList에서 객체를 삭제하면 삭제된 위치는 비어 있게 된다.
- ④ 중간 위치에 객체를 빈번히 삽입하거나 제거할 경우 LinkedList를 사용하는 것이 좋다.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ③
<br>
ArrayList에서 객체를 삭제하면 뒤에 있는 객체들이 자동으로 **한 칸씩 앞으로 당겨져서** 빈 공간을 채웁니다.
</div>
</details>

<br>


<br>

## 3. Map 활용
단일(싱글) 스레드 환경에서 **"학번(String)"**을 키로, **"점수(Integer)"**를 값으로 저장하는 가장 적합한 컬렉션을 생성하는 코드를 작성해 보세요.

```java
Map<String, Integer> map = ______________________________;
```

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** `new HashMap<>()` 또는 `new HashMap<String, Integer>()`
<br>
싱글 스레드 환경이므로 `HashMap`이 가장 적합합니다. (멀티 스레드라면 `Hashtable`이나 `ConcurrentHashMap`)
</div>
</details>

<br>


<br>

## 4. HashSet 중복 제거
`HashSet`에 `Student` 객체를 저장하려고 합니다.
학번(`studentNum`)이 같으면 동일한 학생으로 간주하고 중복 저장을 막고 싶습니다.
`Student` 클래스에서 재정의해야 할 두 가지 메소드는 무엇입니까?

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** `hashCode()`와 `equals()`
<br>
`HashSet`은 객체를 저장하기 전에 1차로 `hashCode()`를 비교하고, 2차로 `equals()`를 비교하여 둘 다 같으면 중복으로 판단합니다.
</div>
</details>

<br>


<br>

## 5. Map 데이터 처리
`HashMap`에 아이디(String)와 점수(Integer)가 저장되어 있습니다.
최고 점수를 받은 아이디와 점수를 출력하는 코드를 완성해 보세요.

```java
Map<String, Integer> map = new HashMap<>();
map.put("blue", 96);
map.put("hong", 86);
map.put("white", 92);

String name = null;
int maxScore = 0;
int totalScore = 0;

// 이곳에 코드를 작성하세요. (keySet()이나 entrySet() 활용)

System.out.println("최고 점수: " + maxScore);
System.out.println("최고 점수 아이디: " + name);
```

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답 예시:**
```java
// entrySet() 활용
for(Map.Entry<String, Integer> entry : map.entrySet()) {
    if(entry.getValue() > maxScore) {
        name = entry.getKey();
        maxScore = entry.getValue();
    }
    totalScore += entry.getValue();
}
```
</div>
</details>
