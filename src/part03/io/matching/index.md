---
layout: part03
title: "17.9 요소 조건 만족 여부(매칭)"
nav_order: 9
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.9 요소 조건 만족 여부(매칭)

매칭은 요소들이 특정 조건에 만족하는지 여부를 조사하는 최종 처리 기능이다.

*   `allMatch()`: 모든 요소가 만족하는지 여부
*   `anyMatch()`: 최소한 하나의 요소가 만족하는지 여부
*   `noneMatch()`: 모든 요소가 만족하지 않는지 여부

```java
package ch17.sec09;

import java.util.Arrays;

public class MatchingExample {
	public static void main(String[] args) {
		int[] intArr = { 2, 4, 6 };

		boolean result = Arrays.stream(intArr)
			.allMatch(a -> a%2==0);
		System.out.println("모두 2의 배수인가? " + result);

		result = Arrays.stream(intArr)
			.anyMatch(a -> a%3==0);
		System.out.println("하나라도 3의 배수가 있는가? " + result);

		result = Arrays.stream(intArr)
			.noneMatch(a -> a%3==0);
		System.out.println("3의 배수가 없는가? " + result);
	}
}
```

**실행 결과**
```
모두 2의 배수인가? true
하나라도 3의 배수가 있는가? true
3의 배수가 없는가? false
```
