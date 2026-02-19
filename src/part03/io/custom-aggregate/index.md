---
layout: part03
title: "17.11 요소 커스텀 집계"
nav_order: 11
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.11 요소 커스텀 집계

스트림은 기본 집계 메소드 외에 다양한 집계 결과물을 만들 수 있도록 `reduce()` 메소드도 제공한다.

`reduce()`는 스트림에 요소가 없을 경우 예외가 발생하지만, identity 매개값이 주어지면 이 값을 디폴트 값으로 리턴한다.

```java
package ch17.sec11;

public class Student {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() { return name; }
	public int getScore() { return score; }
}
```

```java
package ch17.sec11;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
			new Student("홍길동", 92),
			new Student("신용권", 95),
			new Student("감자바", 88)
		);

		// 방법1
		int sum1 = studentList.stream()
			.mapToInt(Student::getScore)
			.sum();

		// 방법2
		int sum2 = studentList.stream()
			.map(Student::getScore)
			.reduce(0, (a, b) -> a+b);

		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
	}
}
```

**실행 결과**
```
sum1: 275
sum2: 275
```
