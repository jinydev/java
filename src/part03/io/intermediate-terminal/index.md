---
layout: part03
title: "17.3 중간 처리와 최종 처리"
nav_order: 3
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.3 중간 처리와 최종 처리

스트림은 하나 이상 연결될 수 있다. 컬렉션의 오리지널 스트림 뒤에 필터링 중간 스트림이 연결될 수 있고, 그 뒤에 매핑 중간 스트림이 연결될 수 있다. 이와 같이 스트림이 연결되어 있는 것을 **스트림 파이프라인(stream pipelines)**이라고 한다.

오리지널 스트림과 집계 처리 사이의 중간 스트림들은 최종 처리를 위해 요소를 걸러내거나(필터링), 요소를 변환시키거나(매핑), 정렬하는 작업을 수행한다. 최종 처리는 중간 처리에서 정제된 요소들을 반복하거나, 집계(카운팅, 총합, 평균) 작업을 수행한다.

```java
// Student 스트림
Stream<Student> studentStream = list.stream();

// score 스트림
IntStream scoreStream = studentStream.mapToInt( student -> student.getScore() );

// 평균 계산
double avg = scoreStream.average().getAsDouble();
```

메소드 체이닝 패턴을 이용하면 앞의 코드를 다음과 같이 더 간결하게 작성할 수 있다.

```java
double avg = list.stream()
	.mapToInt(student -> student.getScore())
	.average()
	.getAsDouble();
```

스트림 파이프라인으로 구성할 때 주의할 점은 파이프라인의 맨 끝에는 반드시 최종 처리 부분이 있어야 한다는 것이다. 최종 처리가 없다면 오리지널 및 중간 처리 스트림은 동작하지 않는다.

```java
package ch17.sec03;

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
package ch17.sec03;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
			new Student("홍길동", 10),
			new Student("신용권", 20),
			new Student("유미선", 30)
		);

		// 방법1
		/*
		Stream<Student> studentStream = list.stream();
		// 중간 처리(학생 객체를 점수로 매핑)
		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
		// 최종 처리(평균 점수)
		double avg = scoreStream.average().getAsDouble();
		*/

		// 방법2
		double avg = list.stream()
			.mapToInt(student -> student.getScore())
			.average()
			.getAsDouble();

		System.out.println("평균 점수: " + avg);
	}
}
```

**실행 결과**
```
평균 점수: 20.0
```
