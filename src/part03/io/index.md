---
layout: part03
title: "Chapter 21. 스트림과 병렬 처리"
nav_order: 21
has_children: true
parent: "라이브러리 활용"
---

# Chapter 21. 스트림과 병렬 처리

## 학습목표

데이터의 집합을 함수형 스타일로 처리하는 스트림과 병렬 처리 기법을 배웁니다.

## 목차

### [17.1 스트림이란?](./intro/)

지금까지 컬렉션 및 배열에 저장된 요소를 반복 처리하기 위해서는 for 문을 이용하거나 Iterator반복자를 이용했다. 다음은 List 컬렉션에서 요소를 하나씩 처리하는 for 문이다. List list = ...; for int i=0; i<list.size; i+...

### [17.2 내부 반복자](./internal-iterator/)

for 문과 Iterator는 컬렉션의 요소를 컬렉션 바깥쪽으로 반복해서 가져와 처리하는데, 이것을 외부 반복자external iterator라고 한다. 반면 스트림은 요소 처리 방법을 컬렉션 내부로 주입시켜서 요소를 반복 처리하는데, 이것을 내부 반복자internal...

### [17.3 중간 처리와 최종 처리](./intermediate-terminal/)

스트림은 하나 이상 연결될 수 있다. 컬렉션의 오리지널 스트림 뒤에 필터링 중간 스트림이 연결될 수 있고, 그 뒤에 매핑 중간 스트림이 연결될 수 있다. 이와 같이 스트림이 연결되어 있는 것을 스트림 파이프라인stream pipelines이라고 한다. 오리지널 스트림과...

### [17.4 리소스로부터 스트림 얻기](./resource/)

java.util.stream 패키지에는 스트림 인터페이스들이 있다. BaseStream 인터페이스를 부모로 한 자식 인터페이스들은 Stream, IntStream, LongStream, DoubleStream이다. BaseStream에는 모든 스트림에서 사용할 수 있...

### [17.5 요소 걸러내기(필터링)](./filtering/)

필터링은 요소를 걸러내는 중간 처리 기능이다. 필터링 메소드에는 distinct와 filter가 있다.    distinct: 중복 제거    filterPredicate: 조건 필터링. 매개값으로 주어진 Predicate가 true를 리턴하는 요소만 필터링한다. pa...

### [17.6 요소 변환(매핑)](./mapping/)

매핑mapping은 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능이다. 매핑 메소드는 mapXxx, asDoubleStream, asLongStream, boxed, flatMapXxx 등이 있다. mapXxx 메소드는 요소를 다른 요소로 변환한 새로운 스트림을...

### [17.7 요소 정렬](./sorting/)

정렬은 요소를 오름차순 또는 내림차순으로 정렬하는 중간 처리 기능이다.    sorted: Comparable 요소를 정렬한 새로운 스트림 생성    sortedComparator: 요소를 Comparator에 따라 정렬한 새 스트림 생성 스트림의 요소가 객체일 경우...

### [17.8 요소를 하나씩 처리(루핑)](./looping/)

루핑looping은 스트림에서 요소를 하나씩 반복해서 가져와 처리하는 것을 말한다. 루핑 메소드에는 peek과 forEach가 있다.    peek: 중간 처리 메소드. 최종 처리가 뒤에 붙지 않으면 동작하지 않는다.    forEach: 최종 처리 메소드. packa...

### [17.9 요소 조건 만족 여부(매칭)](./matching/)

매칭은 요소들이 특정 조건에 만족하는지 여부를 조사하는 최종 처리 기능이다.    allMatch: 모든 요소가 만족하는지 여부    anyMatch: 최소한 하나의 요소가 만족하는지 여부    noneMatch: 모든 요소가 만족하지 않는지 여부 package ch1...

### [17.10 요소 기본 집계](./basic-aggregate/)

집계Aggregate는 최종 처리 기능으로 요소들을 처리해서 카운팅, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 것을 말한다.    count: 요소 개수    findFirst: 첫 번째 요소    max: 최대 요소    min: 최소 요소...

### [17.11 요소 커스텀 집계](./custom-aggregate/)

스트림은 기본 집계 메소드 외에 다양한 집계 결과물을 만들 수 있도록 reduce 메소드도 제공한다. reduce는 스트림에 요소가 없을 경우 예외가 발생하지만, identity 매개값이 주어지면 이 값을 디폴트 값으로 리턴한다. package ch17.sec11; p...

### [17.12 요소 수집](./collect/)

스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 collect를 제공한다. Stream의 collectCollector collector 메소드는 필터링 또는 매핑된 요소들을 새로운 컬렉션에 수집하고, 이 컬렉션을 리턴한다.    Coll...

### [17.13 요소 병렬 처리](./parallel/)

요소 병렬 처리Parallel Operation란 멀티 코어 CPU 환경에서 전체 요소를 분할해서 각각의 코어가 병렬적으로 처리하는 것을 말한다. 자바는 요소 병렬 처리를 위해 병렬 스트림을 제공한다.    동시성Concurrency: 멀티 작업을 위해 멀티 스레드가...

## 확인문제
- [확인문제](./quiz)
