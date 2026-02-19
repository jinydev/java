---
layout: part03
title: "17.12 요소 수집"
nav_order: 12
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.12 요소 수집

스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 `collect()`를 제공한다.

## 필터링한 요소 수집

`Stream`의 `collect(Collector<T,A,R> collector)` 메소드는 필터링 또는 매핑된 요소들을 새로운 컬렉션에 수집하고, 이 컬렉션을 리턴한다.

*   `Collectors.toList()`: List에 저장
*   `Collectors.toSet()`: Set에 저장
*   `Collectors.toMap()`: Map에 저장

Java 16부터는 `toList()` 메소드를 사용하여 List 컬렉션을 바로 얻을 수 있다.

```java
package ch17.sec12.exam01;

public class Student {
	private String name;
	private String sex;
	private int score;

	public Student(String name, String sex, int score) {
		this.name = name;
		this.sex = sex;
		this.score = score;
	}

	public String getName() { return name; }
	public String getSex() { return sex; }
	public int getScore() { return score; }
}
```

```java
package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		// 남학생만 묶어 List 생성
		/*
		List<Student> maleList = totalList.stream()
			.filter(s->s.getSex().equals("남"))
			.collect(Collectors.toList());
		*/

		List<Student> maleList = totalList.stream()
			.filter(s->s.getSex().equals("남"))
			.toList();

		maleList.stream()
			.forEach(s -> System.out.println(s.getName()));

		System.out.println();

		// 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
		Map<String, Integer> map = totalList.stream()
			.collect(
				Collectors.toMap(
					s -> s.getName(), // Student 객체에서 키가 될 부분 리턴
					s -> s.getScore() // Student 객체에서 값이 될 부분 리턴
				)
			);

		System.out.println(map);
	}
}
```

**실행 결과**
```
홍길동
감자바

{오해영=93, 홍길동=92, 감자바=95, 김수영=87}
```

## 요소 그룹핑

`collect()` 메소드는 단순히 요소를 수집하는 기능 이외에 컬렉션의 요소들을 그룹핑해서 Map 객체를 생성하는 기능도 제공한다. `Collectors.groupingBy()` 메소드를 사용한다.

```java
package ch17.sec12.exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		Map<String, List<Student>> map = totalList.stream()
			.collect(
				Collectors.groupingBy(s -> s.getSex())
			);

		List<Student> maleList = map.get("남");
		maleList.stream().forEach(s -> System.out.println(s.getName()));
		System.out.println();

		List<Student> femaleList = map.get("여");
		femaleList.stream().forEach(s -> System.out.println(s.getName()));
	}
}
```

**실행 결과**
```
홍길동
감자바

김수영
오해영
```

## 커스텀 집계 값

```java
package ch17.sec12.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		Map<String, Double> map = totalList.stream()
			.collect(
				Collectors.groupingBy(
					s -> s.getSex(),
					Collectors.averagingDouble(s -> s.getScore())
				)
			);

		System.out.println(map);
	}
}
```

**실행 결과**
```
{남=93.5, 여=90.0}
```
