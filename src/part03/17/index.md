---
layout: part03
title: Chapter 17. 스트림 요소 처리
---

# Chapter 17. 스트림 요소 처리

## 17.1 스트림이란?

지금까지 컬렉션 및 배열에 저장된 요소를 반복 처리하기 위해서는 for 문을 이용하거나 Iterator(반복자)를 이용했다. 다음은 List 컬렉션에서 요소를 하나씩 처리하는 for 문이다.

```java
List<String> list = ...;
for (int i=0; i<list.size(); i++) {
	String item = list.get(i);
	// item 처리
}
```

그리고 Set에서 요소를 하나씩 처리하기 위해 Iterator를 다음과 같이 사용했다.

```java
Set<String> set = ...;
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
	String item = iterator.next();
	// 요소 처리
}
```

Java 8부터는 또 다른 방법으로 컬렉션 및 배열의 요소를 반복 처리하기 위해 **스트림(Stream)**을 사용할 수 있다. 스트림은 요소들이 하나씩 흘러가면서 처리된다는 의미를 가지고 있다. List 컬렉션에서 요소를 반복 처리하기 위해 스트림을 사용하면 다음과 같다.

```java
Stream<String> stream = list.stream();
stream.forEach( item -> /* item 처리 */ );
```

List 컬렉션의 `stream()` 메소드로 Stream 객체를 얻고, `forEach()` 메소드로 요소를 어떻게 처리할지를 람다식으로 제공한다.

```java
package ch17.sec01.exam01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// Set 컬렉션 생성
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("신용권");
		set.add("감자바");

		// Stream을 이용한 요소 반복 처리
		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));
	}
}
```

**실행 결과**
```
홍길동
신용권
감자바
```

Stream은 Iterator와 비슷한 반복자이지만, 다음과 같은 차이점을 가지고 있다.
1.  내부 반복자이므로 처리 속도가 빠르고 병렬 처리에 효율적이다.
2.  람다식으로 다양한 요소 처리를 정의할 수 있다.
3.  중간 처리와 최종 처리를 수행하도록 파이프라인을 형성할 수 있다.

## 17.2 내부 반복자

for 문과 Iterator는 컬렉션의 요소를 컬렉션 바깥쪽으로 반복해서 가져와 처리하는데, 이것을 **외부 반복자(external iterator)**라고 한다. 반면 스트림은 요소 처리 방법을 컬렉션 내부로 주입시켜서 요소를 반복 처리하는데, 이것을 **내부 반복자(internal iterator)**라고 한다.

외부 반복자일 경우는 컬렉션의 요소를 외부로 가져오는 코드와 처리하는 코드를 모두 개발자 코드가 가지고 있어야 한다. 반면 내부 반복자일 경우는 개발자 코드에서 제공한 데이터 처리 코드(람다식)를 가지고 컬렉션 내부에서 요소를 반복 처리한다.

내부 반복자는 멀티 코어 CPU를 최대한 활용하기 위해 요소들을 분배시켜 병렬 작업을 할 수 있다. 하나씩 처리하는 순차적 외부 반복자보다는 효율적으로 요소를 반복시킬 수 있는 장점이 있다.

다음 예제는 List 컬렉션의 내부 반복자를 이용해서 병렬 처리하는 방법을 보여준다. `parallelStream()` 메소드로 병렬 처리 스트림을 얻고, `forEach()` 메소드를 호출할 때 요소 처리 방법인 람다식을 제공한다. 람다식은 처리되는 요소가 무엇이고, 어떤 스레드가 처리하는지를 출력한다.

```java
package ch17.sec02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("신용권");
		list.add("감자바");
		list.add("람다식");
		list.add("박병렬");

		// 병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(name -> {
			System.out.println(name + ": " + Thread.currentThread().getName());
		});
	}
}
```

**실행 결과**
```
감자바: main
람다식: ForkJoinPool.commonPool-worker-2
홍길동: ForkJoinPool.commonPool-worker-2
박병렬: main
신용권: ForkJoinPool.commonPool-worker-1
```

## 17.3 중간 처리와 최종 처리

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

## 17.4 리소스로부터 스트림 얻기

`java.util.stream` 패키지에는 스트림 인터페이스들이 있다. `BaseStream` 인터페이스를 부모로 한 자식 인터페이스들은 `Stream`, `IntStream`, `LongStream`, `DoubleStream`이다.

`BaseStream`에는 모든 스트림에서 사용할 수 있는 공통 메소드들이 정의되어 있다. `Stream`은 객체 요소를 처리하는 스트림이고, `IntStream`, `LongStream`, `DoubleStream`은 각각 기본 타입인 `int`, `long`, `double` 요소를 처리하는 스트림이다.

### 컬렉션으로부터 스트림 얻기

`java.util.Collection` 인터페이스는 `stream()`과 `parallelStream()` 메소드를 가지고 있기 때문에 자식 인터페이스인 List와 Set 인터페이스를 구현한 모든 컬렉션에서 객체 스트림을 얻을 수 있다.

```java
package ch17.sec04.exam01;

public class Product {
	private int pno;
	private String name;
	private String company;
	private int price;

	public Product(int pno, String name, String company, int price) {
		this.pno = pno;
		this.name = name;
		this.company = company;
		this.price = price;
	}

	public int getPno() { return pno; }
	public String getName() { return name; }
	public String getCompany() { return company; }
	public int getPrice() { return price; }

	@Override
	public String toString() {
		return new StringBuilder()
			.append("{")
			.append("pno:" + pno + ", ")
			.append("name:" + name + ", ")
			.append("company:" + company + ", ")
			.append("price:" + price)
			.append("}")
			.toString();
	}
}
```

```java
package ch17.sec04.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<Product> list = new ArrayList<>();
		for (int i=1; i<=5; i++) {
			Product product = new Product(i, "상품"+i, "멋진 회사", (int)(10000*Math.random()));
			list.add(product);
		}

		// 객체 스트림 얻기
		Stream<Product> stream = list.stream();
		stream.forEach(p -> System.out.println(p));
	}
}
```

**실행 결과**
```
{pno:1, name:상품1, company:멋진 회사, price:2029}
{pno:2, name:상품2, company:멋진 회사, price:2534}
{pno:3, name:상품3, company:멋진 회사, price:8886}
{pno:4, name:상품4, company:멋진 회사, price:9298}
{pno:5, name:상품5, company:멋진 회사, price:1333}
```

### 배열로부터 스트림 얻기

`java.util.Arrays` 클래스를 이용하면 다양한 종류의 배열로부터 스트림을 얻을 수 있다.

```java
package ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		String[] strArray = { "홍길동", "신용권", "김미나" };
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(item -> System.out.print(item + ","));
		System.out.println();

		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(item -> System.out.print(item + ","));
		System.out.println();
	}
}
```

**실행 결과**
```
홍길동,신용권,김미나,
1,2,3,4,5,
```

### 숫자 범위로부터 스트림 얻기

`IntStream` 또는 `LongStream`의 정적 메소드인 `range()`와 `rangeClosed()` 메소드를 이용하면 특정 범위의 정수 스트림을 얻을 수 있다. 첫 번째 매개값은 시작 수이고 두 번째 매개값은 끝 수인데, 끝 수를 포함하지 않으면 `range()`, 포함하면 `rangeClosed()`를 사용한다.

```java
package ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
	public static int sum;

	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
	}
}
```

**실행 결과**
```
총합: 5050
```

### 파일로부터 스트림 얻기

`java.nio.file.Files`의 `lines()` 메소드를 이용하면 텍스트 파일의 행 단위 스트림을 얻을 수 있다.

`data.txt` 파일 내용:
```
{"pno":1, "name":"상품1", "company":"멋진 회사", "price":1558}
{"pno":2, "name":"상품2", "company":"멋진 회사", "price":4671}
{"pno":3, "name":"상품3", "company":"멋진 회사", "price":470}
{"pno":4, "name":"상품4", "company":"멋진 회사", "price":9584}
{"pno":5, "name":"상품5", "company":"멋진 회사", "price":6868}
```

```java
package ch17.sec04.exam04;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get(StreamExample.class.getResource("data.txt").toURI());
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(line -> System.out.println(line));
		stream.close();
	}
}
```

**실행 결과**
```
{"pno":1, "name":"상품1", "company":"멋진 회사", "price":1558}
{"pno":2, "name":"상품2", "company":"멋진 회사", "price":4671}
{"pno":3, "name":"상품3", "company":"멋진 회사", "price":470}
{"pno":4, "name":"상품4", "company":"멋진 회사", "price":9584}
{"pno":5, "name":"상품5", "company":"멋진 회사", "price":6868}
```

## 17.5 요소 걸러내기(필터링)

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

## 17.6 요소 변환(매핑)

매핑(mapping)은 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능이다. 매핑 메소드는 `mapXxx()`, `asDoubleStream()`, `asLongStream()`, `boxed()`, `flatMapXxx()` 등이 있다.

### 요소를 다른 요소로 변환

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

### 요소를 복수 개의 요소로 변환

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

## 17.7 요소 정렬

정렬은 요소를 오름차순 또는 내림차순으로 정렬하는 중간 처리 기능이다.
*   `sorted()`: Comparable 요소를 정렬한 새로운 스트림 생성
*   `sorted(Comparator<T>)`: 요소를 Comparator에 따라 정렬한 새 스트림 생성

### Comparable 구현 객체의 정렬

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

### Comparator를 이용한 정렬

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

## 17.8 요소를 하나씩 처리(루핑)

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

## 17.9 요소 조건 만족 여부(매칭)

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

## 17.10 요소 기본 집계

집계(Aggregate)는 최종 처리 기능으로 요소들을 처리해서 카운팅, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 것을 말한다.

### 스트림이 제공하는 기본 집계

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

### Optional 클래스

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

## 17.11 요소 커스텀 집계

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

## 17.12 요소 수집

스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 `collect()`를 제공한다.

### 필터링한 요소 수집

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

### 요소 그룹핑

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

### 커스텀 집계 값

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

## 17.13 요소 병렬 처리

요소 병렬 처리(Parallel Operation)란 멀티 코어 CPU 환경에서 전체 요소를 분할해서 각각의 코어가 병렬적으로 처리하는 것을 말한다. 자바는 요소 병렬 처리를 위해 병렬 스트림을 제공한다.

### 동시성과 병렬성

*   **동시성(Concurrency)**: 멀티 작업을 위해 멀티 스레드가 하나의 코어에서 번갈아 가며 실행하는 것.
*   **병렬성(Parallelism)**: 멀티 작업을 위해 멀티 코어를 각각 이용해서 병렬로 실행하는 것.

### 포크조인 프레임워크

자바 병렬 스트림은 요소들을 병렬 처리하기 위해 포크조인 프레임워크(ForkJoin Framework)를 사용한다. 포크 단계에서 전체 요소들을 서브 요소셋으로 분할하고, 각각의 서브 요소셋을 멀티 코어에서 병렬로 처리한다. 조인 단계에서는 서브 결과를 결합해서 최종 결과를 만들어낸다.

### 병렬 스트림 사용

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

### 병렬 처리 성능

병렬 처리에 영향을 미치는 3가지 요인:
1.  **요소의 수와 요소당 처리 시간**: 요소 수가 적고 처리 시간이 짧으면 일반 스트림이 빠를 수 있다.
2.  **스트림 소스의 종류**: ArrayList, 배열은 빠르지만 HashSet, TreeSet, LinkedList는 상대적으로 느리다.
3.  **코어의 수**: 코어 수가 많을수록 병렬 스트림 성능이 좋아진다.

## 확인문제

1.  스트림에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 스트림은 내부 반복자를 사용하기 때문에 코드가 간결해진다.
    *   ② 스트림은 요소를 분리해서 병렬 처리시킬 수 있다.
    *   ③ 스트림은 람다식을 사용해서 요소 처리 내용을 기술한다.
    *   ④ 스트림은 요소를 모두 처리하고 나서 처음부터 요소를 다시 반복시킬 수 있다.
    > **정답**: ④
    > **해설**: 스트림은 일회용이므로 한 번 사용하면 재사용할 수 없다.

2.  스트림을 얻을 수 있는 소스가 아닌 것은 무엇입니까?
    *   ① 컬렉션(List)
    *   ② int, long, double 범위
    *   ③ 디렉토리
    *   ④ 배열
    *   ⑤ Iterator
    > **정답**: ⑤
    > **해설**: Iterator로부터 바로 스트림을 얻는 메소드는 없다.

3.  스트림 파이프라인에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 스트림을 연결해서 중간 처리와 최종 처리를 할 수 있다.
    *   ② 중간 처리 단계에서는 필터링, 매핑, 정렬, 그룹핑을 한다.
    *   ③ 최종 처리 단계에서는 합계, 평균, 카운팅, 최대값, 최소값 등을 얻을 수 있다.
    *   ④ 최종 처리가 없더라도 중간 처리를 할 수 있다.
    > **정답**: ④
    > **해설**: 최종 처리가 호출되어야 비로소 중간 처리가 동작한다(Lazy Evaluation).

4.  스트림 병렬 처리에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 전체 요소를 분할해서 처리한다.
    *   ② 내부적으로 포크조인 프레임워크를 이용한다.
    *   ③ 병렬 처리는 순차적 처리보다 항상 빠른 처리를 한다.
    *   ④ 내부적으로 스레드풀을 이용해서 스레드를 관리한다.
    > **정답**: ③
    > **해설**: 요소 수가 적거나 처리 비용이 낮으면 오히려 느릴 수 있다.

5.  List에 저장되어 있는 String 요소에서 대소문자와 상관없이 "java"라는 단어가 포함된 문자열만 필터링해서 출력하려고 합니다. 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    List<String> list = Arrays.asList(
    	"This is a java book",
    	"Lambda Expressions",
    	"Java8 supports lambda expressions"
    );
    list.stream()
    	.filter(a -> a.toLowerCase().contains("java"))
    	.forEach(a -> System.out.println(a));
    ```

6.  List에 저장되어 있는 Member의 평균 나이를 출력하려고 합니다. 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    double avg = list.stream()
    	.mapToInt(Member::getAge)
    	.average()
    	.getAsDouble(); // 또는 orElse(0.0)
    ```

7.  List에 저장되어 있는 Member 중에서 직업이 "개발자"인 사람만 별도의 List에 수집하려고 합니다. 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    List<Member> developers = list.stream()
    	.filter(m -> m.getJob().equals("개발자"))
    	.collect(Collectors.toList());
    // 또는 .toList(); (Java 16+)
    ```

8.  List에 저장되어 있는 Member를 직업별로 그룹핑해서 Map<String, List<Member>> 객체로 생성하려고 합니다. 키는 Member의 직업이고, 값은 해당 직업을 갖는 Member들을 저장하고 있는 List입니다. 실행 결과를 보고 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    Map<String, List<Member>> groupingMap = list.stream()
    	.collect(Collectors.groupingBy(Member::getJob));
    ```
