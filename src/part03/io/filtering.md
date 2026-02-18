---
layout: part03
title: "17.5 요소 걸러내기(필터링)"
nav_order: 5
parent: "Chapter 17. 데이터 입출력"
grand_parent: "라이브러리 활용"
---

# 17.5 요소 걸러내기(필터링)

필터링은 요소를 걸러내는 중간 처리 기능이다. 필터링 메소드에는 `distinct()`와 `filter()`가 있다.

*   `distinct()`: 중복 제거
*   `filter(Predicate<T>)`: 조건 필터링. 매개값으로 주어진 Predicate가 true를 리턴하는 요소만 필터링한다.

```java
package ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("신용권");
		list.add("감자바");
		list.add("신용권");
		list.add("신민철");

		// 중복 요소 제거
		list.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		System.out.println();

		// 신으로 시작하는 요소만 필터링
		list.stream()
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
		System.out.println();

		// 중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
		list.stream()
			.distinct()
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
	}
}
```

**실행 결과**
```
홍길동
신용권
감자바
신민철

신용권
신용권
신민철

신용권
신민철
```
