---
layout: part03
title: "17.1 스트림이란?"
nav_order: 1
parent: "Chapter 21. 스트림과 병렬 처리"
grand_parent: "라이브러리 활용"
---

# 17.1 스트림이란?

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

Java 8부터는 또 다른 방법으로 컬렉션 및 배열의 요소를 반복 처리하기 위해 **스트림(Stream)**을 사용할 수 있다. 스트림은 요소들이 하나씩 흘러가면서 처리된다는 의미를 가지고 있다.

### 스트림(Stream) 시각화: "물결 따라 흘러가는 데이터"

```mermaid
flowchart LR
    subgraph Collection [List / Set 컬렉션 (고여있는 물)]
        A[데이터1]
        B[데이터2]
        C[데이터3]
    end
    
    subgraph StreamFlow [스트림 처리 (흐르는 물 🌊)]
        direction LR
        S1((데이터1)) -.-> S2((데이터2)) -.-> S3((데이터3))
    end
    
    Collection -->|stream() 호출| StreamFlow
    
    style Collection fill:#f9f9f9,stroke:#333
    style StreamFlow fill:#dae8fc,stroke:#6c8ebf
    style S1 fill:#cce5ff,stroke:#0066cc
    style S2 fill:#cce5ff,stroke:#0066cc
    style S3 fill:#cce5ff,stroke:#0066cc
```

List 컬렉션에서 요소를 반복 처리하기 위해 스트림을 사용하면 다음과 같다.

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
