---
layout: part03
title: "17.6 요소 변환(매핑)"
nav_order: 6
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.6 요소 변환(매핑)

매핑(mapping)은 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능이다. 매핑 메소드는 `mapXxx()`, `asDoubleStream()`, `asLongStream()`, `boxed()`, `flatMapXxx()` 등이 있다.

## 요소를 다른 요소로 변환

`mapXxx()` 메소드는 요소를 다른 요소로 변환한 새로운 스트림을 리턴한다.

```java
package ch17.sec06.exam01;

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
package ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 85));
		studentList.add(new Student("홍길동", 92));
		studentList.add(new Student("홍길동", 87));

		// Student를 score 스트림으로 변환
		studentList.stream()
			.mapToInt(s -> s.getScore())
			.forEach(score -> System.out.println(score));
	}
}
```

**실행 결과**
```
85
92
87
```

기본 타입 간의 변환이거나 기본 타입 요소를 래퍼(Wrapper) 객체 요소로 변환하려면 다음과 같은 간편화 메소드를 사용할 수도 있다.
*   `asLongStream()`: int -> long
*   `asDoubleStream()`: int -> double, long -> double
*   `boxed()`: int -> Integer, long -> Long, double -> Double

```java
package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };

		IntStream intStream = Arrays.stream(intArray);
		intStream
			.asDoubleStream()
			.forEach(d -> System.out.println(d));

		System.out.println();

		intStream = Arrays.stream(intArray);
		intStream
			.boxed()
			.forEach(obj -> System.out.println(obj.intValue()));
	}
}
```

**실행 결과**
```
1.0
2.0
3.0
4.0
5.0

1
2
3
4
5
```

## 요소를 복수 개의 요소로 변환

`flatMapXxx()` 메소드는 하나의 요소를 복수 개의 요소들로 변환한 새로운 스트림을 리턴한다.

```java
package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
	public static void main(String[] args) {
		// 문장 스트림을 단어 스트림으로 변환
		List<String> list1 = new ArrayList<>();
		list1.add("this is java");
		list1.add("i am a best developer");
		list1.stream()
			.flatMap(data -> Arrays.stream(data.split(" ")))
			.forEach(word -> System.out.println(word));
		System.out.println();

		// 문자열 숫자 목록 스트림을 숫자 스트림으로 변환
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		list2.stream()
			.flatMapToInt(data -> {
				String[] strArr = data.split(",");
				int[] intArr = new int[strArr.length];
				for (int i=0; i<strArr.length; i++) {
					intArr[i] = Integer.parseInt(strArr[i].trim());
				}
				return Arrays.stream(intArr);
			})
			.forEach(number -> System.out.println(number));
	}
}
```

**실행 결과**
```
this
is
java
i
am
a
best
developer

10
20
30
40
50
```
