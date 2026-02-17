---
layout: part03
title: "17.13 요소 병렬 처리"
nav_order: 13
parent: "Chapter 17. 데이터 입출력"
grand_parent: "라이브러리 활용"
---

# 17.13 요소 병렬 처리

요소 병렬 처리(Parallel Operation)란 멀티 코어 CPU 환경에서 전체 요소를 분할해서 각각의 코어가 병렬적으로 처리하는 것을 말한다. 자바는 요소 병렬 처리를 위해 병렬 스트림을 제공한다.

## 동시성과 병렬성

*   **동시성(Concurrency)**: 멀티 작업을 위해 멀티 스레드가 하나의 코어에서 번갈아 가며 실행하는 것.
*   **병렬성(Parallelism)**: 멀티 작업을 위해 멀티 코어를 각각 이용해서 병렬로 실행하는 것.

## 포크조인 프레임워크

자바 병렬 스트림은 요소들을 병렬 처리하기 위해 포크조인 프레임워크(ForkJoin Framework)를 사용한다. 포크 단계에서 전체 요소들을 서브 요소셋으로 분할하고, 각각의 서브 요소셋을 멀티 코어에서 병렬로 처리한다. 조인 단계에서는 서브 결과를 결합해서 최종 결과를 만들어낸다.

## 병렬 스트림 사용

`parallelStream()` 메소드는 컬렉션(List, Set)으로부터 병렬 스트림을 바로 리턴한다. `parallel()` 메소드는 기존 스트림을 병렬 처리 스트림으로 변환한다.

```java
package ch17.sec13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelExample {
	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> scores = new ArrayList<>();
		for (int i=0; i<100000000; i++) {
			scores.add(random.nextInt(101));
		}

		double avg = 0.0;
		long startTime = 0;
		long endTime = 0;
		long time = 0;

		// 일반 스트림으로 처리
		Stream<Integer> stream = scores.stream();
		startTime = System.nanoTime();
		avg = stream
			.mapToInt(i -> i.intValue())
			.average()
			.getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");

		// 병렬 스트림으로 처리
		Stream<Integer> parallelStream = scores.parallelStream();
		startTime = System.nanoTime();
		avg = parallelStream
			.mapToInt(i -> i.intValue())
			.average()
			.getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg: " + avg + ", 병렬 스트림 처리 시간: " + time + "ns");
	}
}
```

**실행 결과**
```
avg: 50.00272852, 일반 스트림 처리 시간: 110984200ns
avg: 50.00272852, 병렬 스트림 처리 시간: 45621500ns
```
*(실행 결과는 환경에 따라 다를 수 있음)*

## 병렬 처리 성능

병렬 처리에 영향을 미치는 3가지 요인:
1.  **요소의 수와 요소당 처리 시간**: 요소 수가 적고 처리 시간이 짧으면 일반 스트림이 빠를 수 있다.
2.  **스트림 소스의 종류**: ArrayList, 배열은 빠르지만 HashSet, TreeSet, LinkedList는 상대적으로 느리다.
3.  **코어의 수**: 코어 수가 많을수록 병렬 스트림 성능이 좋아진다.
