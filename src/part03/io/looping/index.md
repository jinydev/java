---
layout: part03
title: "17.8 요소를 하나씩 처리(루핑)"
nav_order: 8
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.8 요소를 하나씩 처리(루핑)

루핑(looping)은 스트림에서 요소를 하나씩 반복해서 가져와 처리하는 것을 말한다. 루핑 메소드에는 `peek()`과 `forEach()`가 있다.

*   `peek()`: 중간 처리 메소드. 최종 처리가 뒤에 붙지 않으면 동작하지 않는다.
*   `forEach()`: 최종 처리 메소드.

```java
package ch17.sec08;

import java.util.Arrays;

public class LoopingExample {
	public static void main(String[] args) {
		int[] intArr = { 1, 2, 3, 4, 5 };

		// 잘못 작성한 경우
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.peek(n -> System.out.println(n)); // 최종 처리가 없으므로 동작하지 않음

		// 중간 처리 메소드 peek()을 이용해서 반복 처리
		int total = Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.peek(n -> System.out.println(n)) // 동작함
			.sum(); // 최종 처리
		System.out.println("총합: " + total + "\n");

		// 최종 처리 메소드 forEach()를 이용해서 반복 처리
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.forEach(n -> System.out.println(n)); // 최종 처리이므로 동작함
	}
}
```

**실행 결과**
```
2
4
총합: 6

2
4
```
