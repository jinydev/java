---
layout: part03
title: "17.7 요소 정렬"
nav_order: 7
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.7 요소 정렬

정렬은 요소를 오름차순 또는 내림차순으로 정렬하는 중간 처리 기능이다.
*   `sorted()`: Comparable 요소를 정렬한 새로운 스트림 생성
*   `sorted(Comparator<T>)`: 요소를 Comparator에 따라 정렬한 새 스트림 생성

## Comparable 구현 객체의 정렬

스트림의 요소가 객체일 경우 객체가 Comparable을 구현하고 있어야만 `sorted()` 메소드를 사용하여 정렬할 수 있다. 그렇지 않다면 `ClassCastException`이 발생한다.

```java
package ch17.sec07.exam01;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() { return name; }
	public int getScore() { return score; }

	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score); // score와 o.score가 같을 경우 0, 작을 경우 음수, 클 경우 양수 리턴
	}
}
```

```java
package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 30));
		studentList.add(new Student("신용권", 10));
		studentList.add(new Student("유미선", 20));

		// 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted()
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		System.out.println();

		// 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
```

**실행 결과**
```
신용권: 10
유미선: 20
홍길동: 30

홍길동: 30
유미선: 20
신용권: 10
```

## Comparator를 이용한 정렬

요소 객체가 Comparable을 구현하고 있지 않다면, 비교자를 제공하면 요소를 정렬시킬 수 있다.

```java
package ch17.sec07.exam02;

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
package ch17.sec07.exam02;

import java.util.ArrayList;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 30));
		studentList.add(new Student("신용권", 10));
		studentList.add(new Student("유미선", 20));

		// 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		System.out.println();

		// 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
```

**실행 결과**
```
신용권: 10
유미선: 20
홍길동: 30

홍길동: 30
유미선: 20
신용권: 10
```
