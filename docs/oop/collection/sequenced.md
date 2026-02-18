layout: oop
title: "15.9 순차 컬렉션"
nav_order: 9
parent: "15. 컬렉션 자료구조"
grand_parent: "Part 03. 라이브러리 활용"
---

# 21.7 순차 컬렉션

자바 21은 순서가 있는 컬렉션을 묶고, 공통 API를 제공할 목적으로 **순차 컬렉션(SequencedCollection)**, **순차 셋(SequencedSet)**, **순차 맵(SequencedMap)** 인터페이스를 추가하고 기존 인터페이스의 상속 관계를 수정했다.

## 순차 컬렉션 (SequencedCollection)

`SequencedCollection`은 순서가 있는 List와 Set 컬렉션의 최상위 인터페이스이다. 다음과 같은 메소드가 선언되어 있다.

*   `void addFirst(E e)`: 첫 번째 요소로 추가
*   `void addLast(E e)`: 마지막 요소로 추가
*   `E getFirst()`: 첫 번째 요소를 가져오기
*   `E getLast()`: 마지막 요소를 가져오기
*   `E removeFirst()`: 첫 번째 요소를 제거하기
*   `E removeLast()`: 마지막 요소를 제거하기
*   `SequencedCollection<E> reversed()`: 요소의 순서를 뒤바꾸기

## 순차 Set (SequencedSet)

순서가 있으면서 요소의 중복 저장을 허용하지 않는 순차 Set 컬렉션은 `SequencedCollection`의 자식인 `SequencedSet` 인터페이스를 별도로 상속받는다. `reversed()` 메소드만 리턴 타입을 `SequencedSet<E>`로 변경해서 재정의했다.

주의할 점은 `SortedSet`을 구현한 `TreeSet` 클래스는 요소들을 비교한 후 위치가 결정되기 때문에 `addFirst()`, `addLast()` 메소드를 사용해서 직접 해당 위치에 요소를 저장할 수 없다. (예외 발생)

## 순차 Map (SequencedMap)

`SequencedMap`은 순서가 있는 Map 컬렉션의 최상위 인터페이스이다.

*   `Map.Entry<K, V> firstEntry()`: 첫 번째 엔트리 가져오기
*   `Map.Entry<K, V> lastEntry()`: 마지막 엔트리 가져오기
*   `Map.Entry<K, V> pollFirstEntry()`: 첫 번째 엔트리를 가져오고 제거
*   `Map.Entry<K, V> pollLastEntry()`: 마지막 엔트리를 가져오고 제거
*   `V putFirst(K k, V v)`: 첫 번째 요소로 추가하기
*   `V putLast(K k, V v)`: 마지막 요소로 추가하기
*   `SequencedMap<K, V> reversed()`: 엔트리의 순서를 뒤바꾸기
*   `SequencedSet<Map.Entry<K, V>> sequencedEntrySet()`: 엔트리를 요소로 하는 SequencedSet 얻기
*   `SequencedSet<K> sequencedKeySet()`: 키를 요소로 하는 SequencedSet 얻기
*   `SequencedCollection<V> sequencedValues()`: 값을 요소로 하는 SequencedCollection 얻기

`SortedMap`을 구현한 `TreeMap`은 `putFirst()`, `putLast()` 메소드를 사용할 수 없다.

## 수정할 수 없는 순차 컬렉션

자바 21에서는 요소를 변경할 수 없도록 수정할 수 없는 순차 컬렉션을 만들기 위해 `Collections` 클래스에 다음 정적 메소드가 추가되었다.

*   `Collections.unmodifiableSequencedCollection(sequencedCollection)`
*   `Collections.unmodifiableSequencedSet(sequencedSet)`
*   `Collections.unmodifiableSequencedMap(sequencedMap)`
