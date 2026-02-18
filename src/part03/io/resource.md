---
layout: part03
title: "17.4 리소스로부터 스트림 얻기"
nav_order: 4
parent: "Chapter 17. 데이터 입출력"
grand_parent: "라이브러리 활용"
---

# 17.4 리소스로부터 스트림 얻기

`java.util.stream` 패키지에는 스트림 인터페이스들이 있다. `BaseStream` 인터페이스를 부모로 한 자식 인터페이스들은 `Stream`, `IntStream`, `LongStream`, `DoubleStream`이다.

`BaseStream`에는 모든 스트림에서 사용할 수 있는 공통 메소드들이 정의되어 있다. `Stream`은 객체 요소를 처리하는 스트림이고, `IntStream`, `LongStream`, `DoubleStream`은 각각 기본 타입인 `int`, `long`, `double` 요소를 처리하는 스트림이다.

## 컬렉션으로부터 스트림 얻기

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

## 배열로부터 스트림 얻기

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

## 숫자 범위로부터 스트림 얻기

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

## 파일로부터 스트림 얻기

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
