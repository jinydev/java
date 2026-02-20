---
layout: part03
title: "17.10 요소 기본 집계"
nav_order: 10
parent: "Chapter 17. 데이터 입출력"
grand_parent: "라이브러리 활용"
---

# 17.10 요소 기본 집계

집계(Aggregate)는 최종 처리 기능으로 요소들을 처리해서 카운팅, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 것을 말한다.

## 스트림이 제공하는 기본 집계

*   `count()`: 요소 개수
*   `findFirst()`: 첫 번째 요소
*   `max()`: 최대 요소
*   `min()`: 최소 요소
*   `average()`: 요소 평균
*   `sum()`: 요소 총합

```java
package ch17.sec10;

import java.util.Arrays;

public class AggregateExample {
	public static void main(String[] args) {
		// 정수 배열
		int[] arr = { 1, 2, 3, 4, 5 };

		// 카운팅
		long count = Arrays.stream(arr)
			.filter(n -> n%2==0)
			.count();
		System.out.println("2의 배수 개수: " + count);

		// 총합
		long sum = Arrays.stream(arr)
			.filter(n -> n%2==0)
			.sum();
		System.out.println("2의 배수의 합: " + sum);

		// 평균
		double avg = Arrays.stream(arr)
			.filter(n -> n%2==0)
			.average()
			.getAsDouble();
		System.out.println("2의 배수의 평균: " + avg);

		// 최대값
		int max = Arrays.stream(arr)
			.filter(n -> n%2==0)
			.max()
			.getAsInt();
		System.out.println("최대값: " + max);

		// 최소값
		int min = Arrays.stream(arr)
			.filter(n -> n%2==0)
			.min()
			.getAsInt();
		System.out.println("최소값: " + min);

		// 첫 번째 요소
		int first = Arrays.stream(arr)
			.filter(n -> n%3==0)
			.findFirst()
			.getAsInt();
		System.out.println("첫 번째 3의 배수: " + first);
	}
}
```

**실행 결과**
```
2의 배수 개수: 2
2의 배수의 합: 6
2의 배수의 평균: 3.0
최대값: 4
최소값: 2
첫 번째 3의 배수: 3
```

## Optional 클래스

Optional, OptionalDouble, OptionalInt, OptionalLong 클래스는 집계값이 존재하지 않을 경우 디폴트 값을 설정하거나 집계값을 처리하는 Consumer를 등록할 수 있다.

*   `isPresent()`: 집계값이 있는지 여부
*   `orElse()`: 집계값이 없을 경우 디폴트 값 설정
*   `ifPresent()`: 집계값이 있을 경우 Consumer에서 처리

```java
package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		/*
		// 예외 발생(java.util.NoSuchElementException)
		double avg = list.stream()
			.mapToInt(Integer::intValue)
			.average()
			.getAsDouble();
		*/

		// 방법1
		OptionalDouble optional = list.stream()
			.mapToInt(Integer::intValue)
			.average();
		if (optional.isPresent()) {
			System.out.println("방법1_평균: " + optional.getAsDouble());
		} else {
			System.out.println("방법1_평균: 0.0");
		}

		// 방법2
		double avg = list.stream()
			.mapToInt(Integer::intValue)
			.average()
			.orElse(0.0);
		System.out.println("방법2_평균: " + avg);

		// 방법3
		list.stream()
			.mapToInt(Integer::intValue)
			.average()
			.ifPresent(a -> System.out.println("방법3_평균: " + a));
	}
}
```

**실행 결과**
```
방법1_평균: 0.0
방법2_평균: 0.0
```
