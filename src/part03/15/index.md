---
layout: part03
title: Chapter 15. 컬렉션 자료구조
---

# Chapter 15. 컬렉션 자료구조

## 15.1 컬렉션 프레임워크

자바는 널리 알려져 있는 자료구조(Data Structure)를 바탕으로 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 관련된 인터페이스와 클래스들을 java.util 패키지에 포함시켜 놓았다. 이들을 총칭해서 **컬렉션 프레임워크(Collection Framework)**라고 부른다. 컬렉션 프레임워크는 몇 가지 인터페이스를 통해서 다양한 컬렉션 클래스를 이용할 수 있도록 설계되어 있다. 주요 인터페이스로는 List, Set, Map이 있는데, 이 인터페이스로 사용 가능한 컬렉션 객체의 종류는 다음과 같다.

| 인터페이스 분류            | 특징                                                      | 구현 클래스                             |
| :------------------------- | :-------------------------------------------------------- | :-------------------------------------- |
| **Collection** -> **List** | - 순서를 유지하고 저장<br>- 중복 저장 가능                | ArrayList, Vector, LinkedList           |
| **Collection** -> **Set**  | - 순서를 유지하지 않고 저장<br>- 중복 저장 안됨           | HashSet, TreeSet                        |
| **Map**                    | - 키와 값으로 구성된 엔트리 저장<br>- 키는 중복 저장 안됨 | HashMap, Hashtable, TreeMap, Properties |

List와 Set은 객체를 추가, 삭제, 검색하는 방법에 있어서 공통점이 있기 때문에 공통된 메소드만 따로 모아 Collection 인터페이스로 정의해 두고 이것을 상속하고 있다. Map은 키와 값을 하나의 쌍으로 묶어서 관리하는 구조로 되어 있어 List 및 Set과는 사용 방법이 다르다.

> **순차 컬렉션**: 자바 21에서는 순차 컬렉션(sequenced collection) 기능이 추가되었다. 자세한 내용은 21장에서 설명한다.

## 15.2 List 컬렉션

List 컬렉션은 객체를 인덱스로 관리하기 때문에 객체를 저장하면 인덱스가 부여되고 인덱스로 객체를 검색, 삭제할 수 있는 기능을 제공한다.

List 컬렉션에는 ArrayList, Vector, LinkedList 등이 있는데, List 컬렉션에서 공통적으로 사용 가능한 List 인터페이스 메소드는 다음과 같다.

| 기능      | 메소드                           | 설명                                      |
| :-------- | :------------------------------- | :---------------------------------------- |
| 객체 추가 | `boolean add(E e)`               | 주어진 객체를 맨 끝에 추가                |
|           | `void add(int index, E element)` | 주어진 인덱스에 객체를 추가               |
|           | `E set(int index, E element)`    | 주어진 인덱스의 객체를 새로운 객체로 바꿈 |
| 객체 검색 | `boolean contains(Object o)`     | 주어진 객체가 저장되어 있는지 여부        |
|           | `E get(int index)`               | 주어진 인덱스에 저장된 객체를 리턴        |
|           | `boolean isEmpty()`              | 컬렉션이 비어 있는지 조사                 |
|           | `int size()`                     | 저장되어 있는 전체 객체 수를 리턴         |
| 객체 삭제 | `void clear()`                   | 저장된 모든 객체를 삭제                   |
|           | `E remove(int index)`            | 주어진 인덱스에 저장된 객체를 삭제        |
|           | `boolean remove(Object o)`       | 주어진 객체를 삭제                        |

### ArrayList

ArrayList는 List 컬렉션에서 가장 많이 사용하는 컬렉션이다. ArrayList에 객체를 추가하면 내부 배열에 객체가 저장된다. 일반 배열과의 차이점은 ArrayList는 제한 없이 객체를 추가할 수 있다는 것이다.

List 컬렉션은 객체 자체를 저장하는 것이 아니라 객체의 번지를 저장한다. 또한 동일한 객체를 중복 저장할 수 있는데, 이 경우에는 동일한 번지가 저장된다. null 또한 저장이 가능하다.

ArrayList 컬렉션은 다음과 같이 생성할 수 있다.

```java
List<E> list = new ArrayList<E>(); // E에 지정된 타입의 객체만 저장
List<E> list = new ArrayList<>(); // E에 지정된 타입의 객체만 저장
List list = new ArrayList(); // 모든 타입의 객체를 저장
```

타입 파라미터 E에는 ArrayList에 저장하고 싶은 객체 타입을 지정하면 된다.

ArrayList 컬렉션에 객체를 추가하면 인덱스 0번부터 차례대로 저장된다. 특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다. 마찬가지로 특정 인덱스에 객체를 삽입하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 밀려난다.

따라서 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList를 사용하는 것은 바람직하지 않다. 대신 이런 경우라면 LinkedList를 사용하는 것이 좋다.

```java
package ch15.sec02.exam01;

public class Board {
	private String subject;
	private String content;
	private String writer;

	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}

	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
}
```

```java
package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		// ArrayList 컬렉션 생성
		List<Board> list = new ArrayList<>();

		// 객체 추가
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));

		// 저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();

		// 특정 인덱스의 객체 가져오기
		Board board = list.get(2);
		System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());
		System.out.println();

		// 모든 객체를 하나씩 가져오기
		for (int i=0; i<list.size(); i++) {
			Board b = list.get(i);
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
		System.out.println();

		// 객체 삭제
		list.remove(2);
		list.remove(2);

		// 향상된 for 문으로 모든 객체를 하나씩 가져오기
		for (Board b : list) {
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
	}
}
```

**실행 결과**
```
총 객체 수: 5

제목3	내용3	글쓴이3

제목1	내용1	글쓴이1
제목2	내용2	글쓴이2
제목3	내용3	글쓴이3
제목4	내용4	글쓴이4
제목5	내용5	글쓴이5

제목1	내용1	글쓴이1
제목2	내용2	글쓴이2
제목5	내용5	글쓴이5
```

### Vector

Vector는 ArrayList와 동일한 내부 구조를 가지고 있다. 차이점은 Vector는 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Vector() 메소드를 실행할 수 없다는 것이다. 그렇기 때문에 멀티 스레드 환경에서는 안전하게 객체를 추가 또는 삭제할 수 있다.

Vector 컬렉션은 다음과 같이 생성할 수 있다.

```java
List<E> list = new Vector<E>();
List<E> list = new Vector<>();
```

다음은 ThreadA와 ThreadB에서 동시에 Board 객체를 Vector에 각각 1000개씩 추가한 후, 전체 저장된 수를 출력하는 예제이다.

```java
package ch15.sec02.exam02;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		// Vector 컬렉션 생성
		List<Board> list = new Vector<>();

		// 작업 스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				// 객체 1000개 추가
				for (int i=1; i<=1000; i++) {
					list.add(new Board("제목"+i, "내용"+i, "글쓴이"+i));
				}
			}
		};

		// 작업 스레드 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				// 객체 1000개 추가
				for (int i=1001; i<=2000; i++) {
					list.add(new Board("제목"+i, "내용"+i, "글쓴이"+i));
				}
			}
		};

		// 작업 스레드 실행
		threadA.start();
		threadB.start();

		// 작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
		}

		// 저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();
	}
}
```

**실행 결과**
```
총 객체 수: 2000
```

만약 `List<Board> list = new ArrayList<>();`로 변경하고 실행하면 경합이 발생하여 2000개가 나오지 않거나 에러가 발생할 수 있다.

### LinkedList

LinkedList는 ArrayList와 사용 방법은 동일하지만 내부 구조는 완전히 다르다. ArrayList는 내부 배열에 객체를 저장하지만, LinkedList는 인접 객체를 체인처럼 연결해서 관리한다.

LinkedList는 특정 위치에서 객체를 삽입하거나 삭제하면 바로 앞뒤 링크만 변경하면 되므로 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList보다 좋은 성능을 발휘한다.

LinkedList 컬렉션은 다음과 같이 생성할 수 있다.

```java
List<E> list = new LinkedList<E>();
List<E> list = new LinkedList<>();
```

다음 예제는 ArrayList와 LinkedList에 10000개의 객체를 삽입하는데 걸린 시간을 측정한 것이다.

```java
package ch15.sec02.exam03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	public static void main(String[] args) {
		// ArrayList 컬렉션 객체 생성
		List<String> list1 = new ArrayList<String>();

		// LinkedList 컬렉션 객체 생성
		List<String> list2 = new LinkedList<String>();

		// 시작 시간과 끝 시간을 저장할 변수 선언
		long startTime;
		long endTime;

		// ArrayList 컬렉션에 저장하는 시간 측정
		startTime = System.nanoTime();
		for (int i=0; i<10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime-startTime));

		// LinkedList 컬렉션에 저장하는 시간 측정
		startTime = System.nanoTime();
		for (int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ", (endTime-startTime));
	}
}
```

**실행 결과**
```
ArrayList 걸린 시간: 4265400 ns
LinkedList 걸린 시간: 1045500 ns
```

## 15.3 Set 컬렉션

List 컬렉션은 저장 순서를 유지하지만, Set 컬렉션은 저장 순서가 유지되지 않는다. 또한 객체를 중복해서 저장할 수 없고, 하나의 null만 저장할 수 있다. Set 컬렉션은 수학의 집합에 비유될 수 있다.

Set 컬렉션에는 HashSet, LinkedHashSet, TreeSet 등이 있는데, Set 컬렉션에서 공통적으로 사용 가능한 Set 인터페이스의 메소드는 다음과 같다.

| 기능      | 메소드                       | 설명                                                                       |
| :-------- | :--------------------------- | :------------------------------------------------------------------------- |
| 객체 추가 | `boolean add(E e)`           | 주어진 객체를 성공적으로 저장하면 true를 리턴하고 중복 객체면 false를 리턴 |
| 객체 검색 | `boolean contains(Object o)` | 주어진 객체가 저장되어 있는지 여부                                         |
|           | `boolean isEmpty()`          | 컬렉션이 비어 있는지 조사                                                  |
|           | `Iterator<E> iterator()`     | 저장된 객체를 한 번씩 가져오는 반복자 리턴                                 |
|           | `int size()`                 | 저장되어 있는 전체 객체 수 리턴                                            |
| 객체 삭제 | `void clear()`               | 저장된 모든 객체를 삭제                                                    |
|           | `boolean remove(Object o)`   | 주어진 객체를 삭제                                                         |

### HashSet

Set 컬렉션 중에서 가장 많이 사용되는 것이 HashSet이다. 다음은 HashSet 컬렉션을 생성하는 방법이다.

```java
Set<E> set = new HashSet<E>();
Set<E> set = new HashSet<>();
```

HashSet은 동일한 객체는 중복 저장하지 않는다. 여기서 동일한 객체란 동등 객체를 말한다. HashSet은 다른 객체라도 hashCode() 메소드의 리턴값이 같고, equals() 메소드가 true를 리턴하면 동일한 객체라고 판단하고 중복 저장하지 않는다.

문자열을 HashSet에 저장할 경우, 같은 문자열을 갖는 String 객체는 동등한 객체로 간주한다.

```java
package ch15.sec03.exam01;

import java.util.*;

public class HashSetExample {
	public static void main(String[] args) {
		// HashSet 컬렉션 생성
		Set<String> set = new HashSet<String>();

		// 객체 저장
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java"); // 중복 객체이므로 저장하지 않음
		set.add("Spring");

		// 저장된 객체 수 출력
		int size = set.size();
		System.out.println("총 객체 수: " + size);
	}
}
```

**실행 결과**
```
총 객체 수: 4
```

다음 예제는 이름과 나이가 동일할 경우 Member 객체를 HashSet에 중복 저장하지 않는다.

```java
package ch15.sec03.exam02;

public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// hashCode 재정의
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	// equals 재정의
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member target) {
			return target.name.equals(name) && (target.age==age);
		} else {
			return false;
		}
	}
}
```

```java
package ch15.sec03.exam02;

import java.util.*;

public class HashSetExample {
	public static void main(String[] args) {
		// HashSet 컬렉션 생성
		Set<Member> set = new HashSet<Member>();

		// Member 객체 저장
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30)); // 인스턴스는 다르지만 동등 객체이므로 객체 1개만 저장

		// 저장된 객체 수 출력
		System.out.println("총 객체 수: " + set.size());
	}
}
```

**실행 결과**
```
총 객체 수: 1
```

Set 컬렉션은 인덱스로 객체를 검색해서 가져오는 메소드가 없다. 대신 객체를 한 개씩 반복해서 가져와야 하는데, 여기에는 두 가지 방법이 있다. 하나는 for 문을 이용하는 것이고, 다른 방법은 iterator() 메소드로 반복자(Iterator)를 얻어 객체를 하나씩 가져오는 것이다.

| 리턴 타입 | 메소드명    | 설명                                                          |
| :-------- | :---------- | :------------------------------------------------------------ |
| `boolean` | `hasNext()` | 가져올 객체가 있으면 true를 리턴하고 없으면 false를 리턴한다. |
| `E`       | `next()`    | 컬렉션에서 하나의 객체를 가져온다.                            |
| `void`    | `remove()`  | `next()`로 가져온 객체를 Set 컬렉션에서 제거한다.             |

```java
package ch15.sec03.exam03;

import java.util.*;

public class HashSetExample {
	public static void main(String[] args) {
		// HashSet 컬렉션 생성
		Set<String> set = new HashSet<String>();

		// 객체 추가
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Spring");

		// 객체를 하나씩 가져와서 처리
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			// 객체를 하나 가져오기
			String element = iterator.next();
			System.out.println(element);
			if (element.equals("JSP")) {
				// 가져온 객체를 컬렉션에서 제거
				iterator.remove();
			}
		}
		System.out.println();

		// 객체 제거
		set.remove("JDBC");

		// 객체를 하나씩 가져와서 처리
		for (String element : set) {
			System.out.println(element);
		}
	}
}
```

**실행 결과**
```
Java
JSP
JDBC
Spring

Java
Spring
```

## 15.4 Map 컬렉션

Map 컬렉션은 **키(key)**와 **값(value)**으로 구성된 **엔트리(Entry)** 객체를 저장한다. 여기서 키와 값은 모두 객체이다. 키는 중복 저장할 수 없지만 값은 중복 저장할 수 있다. 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대치된다.

Map 컬렉션에는 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap 등이 있다.

Map 컬렉션에서 공통적으로 사용 가능한 Map 인터페이스 메소드는 다음과 같다.

| 기능      | 메소드                                | 설명                                                            |
| :-------- | :------------------------------------ | :-------------------------------------------------------------- |
| 객체 추가 | `V put(K key, V value)`               | 주어진 키와 값을 추가. 저장이 되면 값을 리턴                    |
| 객체 검색 | `boolean containsKey(Object key)`     | 주어진 키가 있는지 여부                                         |
|           | `boolean containsValue(Object value)` | 주어진 값이 있는지 여부                                         |
|           | `Set<Map.Entry<K,V>> entrySet()`      | 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴 |
|           | `V get(Object key)`                   | 주어진 키의 값을 리턴                                           |
|           | `boolean isEmpty()`                   | 컬렉션이 비어있는지 여부                                        |
|           | `Set<K> keySet()`                     | 모든 키를 Set 객체에 담아서 리턴                                |
|           | `int size()`                          | 저장된 키의 총 수를 리턴                                        |
|           | `Collection<V> values()`              | 저장된 모든 값을 Collection에 담아서 리턴                       |
| 객체 삭제 | `void clear()`                        | 모든 Map.Entry(키와 값)를 삭제                                  |
|           | `V remove(Object key)`                | 주어진 키와 일치하는 Map.Entry 삭제, 삭제가 되면 값을 리턴      |

### HashMap

HashMap은 키로 사용할 객체가 hashCode() 메소드의 리턴값이 같고 equals() 메소드가 true를 리턴할 경우, 동일 키로 보고 중복 저장을 허용하지 않는다.

다음은 HashMap 컬렉션을 생성하는 방법이다.

```java
Map<K, V> map = new HashMap<K, V>();
Map<K, V> map = new HashMap<>();
```

다음 예제는 이름을 키로, 점수를 값으로 저장하는 HashMap 사용 방법을 보여 준다.

```java
package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		// Map 컬렉션 생성
		Map<String, Integer> map = new HashMap<>();

		// 객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); // 키가 같기 때문에 제일 마지막에 저장한 값만 저장
		System.out.println("총 Entry 수: " + map.size());
		System.out.println();

		// 키로 값 얻기
		String key = "홍길동";
		int value = map.get(key);
		System.out.println(key + ": " + value);
		System.out.println();

		// 키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			String k = keyIterator.next();
			Integer v = map.get(k);
			System.out.println(k + ": " + v);
		}
		System.out.println();

		// 엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k + ": " + v);
		}
		System.out.println();

		// 키로 엔트리 삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수: " + map.size());
		System.out.println();
	}
}
```

**실행 결과**
```
총 Entry 수: 3

홍길동: 95

홍길동: 95
신용권: 85
동장군: 80

홍길동: 95
신용권: 85
동장군: 80

총 Entry 수: 2
```

### Hashtable

Hashtable은 HashMap과 동일한 내부 구조를 가지고 있다. 차이점은 Hashtable은 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Hashtable의 메소드들을 실행할 수 없다는 것이다. 따라서 멀티 스레드 환경에서도 안전하게 객체를 추가, 삭제할 수 있다.

```java
package ch15.sec04.exam02;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {
	public static void main(String[] args) {
		// Hashtable 컬렉션 생성
		Map<String, Integer> map = new Hashtable<>();

		// 작업 스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				// 엔트리 1000개 추가
				for (int i=1; i<=1000; i++) {
					map.put(String.valueOf(i), i);
				}
			}
		};

		// 작업 스레드 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				// 엔트리 1000개 추가
				for (int i=1001; i<=2000; i++) {
					map.put(String.valueOf(i), i);
				}
			}
		};

		// 작업 스레드 실행
		threadA.start();
		threadB.start();

		// 작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
		}

		// 저장된 총 엔트리 수 얻기
		int size = map.size();
		System.out.println("총 엔트리 수: " + size);
		System.out.println();
	}
}
```

**실행 결과**
```
총 엔트리 수: 2000
```

### Properties

Properties는 Hashtable의 자식 클래스이기 때문에 Hashtable의 특징을 그대로 가지고 있다. Properties는 키와 값을 String 타입으로 제한한 컬렉션이다. Properties는 주로 확장자가 `.properties`인 프로퍼티 파일을 읽을 때 사용한다.

프로퍼티 파일은 키와 값이 `=` 기호로 연결되어 있는 텍스트 파일이다.

**database.properties**
```properties
driver=oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:orcl
username=scott
password=tiger
admin=\uD64D\uAE38\uB3D9
```
(admin의 값은 유니코드로 '홍길동'이다)

```java
package ch15.sec04.exam03;

import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) throws Exception {
		// Properties 컬렉션 생성
		Properties properties = new Properties();

		// PropertiesExample.class와 동일한 ClassPath에 있는 database.properties 파일 로드
		properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));

		// 주어진 키에 대한 값 읽기
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");

		// 값 출력
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("admin : " + admin);
	}
}
```

**실행 결과**
```
driver : oracle.jdbc.OracleDriver
url : jdbc:oracle:thin:@localhost:1521:orcl
username : scott
password : tiger
admin : 홍길동
```

## 15.5 검색 기능을 강화시킨 컬렉션

컬렉션 프레임워크는 검색 기능을 강화시킨 TreeSet과 TreeMap을 제공한다. 이름에서 알 수 있듯이 TreeSet은 Set 컬렉션이고, TreeMap은 Map 컬렉션이다.

### TreeSet

TreeSet은 이진 트리(binary tree)를 기반으로 한 Set 컬렉션이다. 이진 트리는 여러 개의 노드(node)가 트리 형태로 연결된 구조로, 루트 노드(root node)라고 불리는 하나의 노드에서 시작해 각 노드에 최대 2개의 노드를 연결할 수 있는 구조를 가지고 있다.

TreeSet에 객체를 저장하면 자동으로 정렬된다. 부모 노드의 객체와 비교해서 낮은 것은 왼쪽 자식 노드에, 높은 것은 오른쪽 자식 노드에 저장한다.

| 리턴 타입         | 메소드                 | 설명                                                                                       |
| :---------------- | :--------------------- | :----------------------------------------------------------------------------------------- |
| `E`               | `first()`              | 제일 낮은 객체를 리턴                                                                      |
| `E`               | `last()`               | 제일 높은 객체를 리턴                                                                      |
| `E`               | `lower(E e)`           | 주어진 객체보다 바로 아래 객체를 리턴                                                      |
| `E`               | `higher(E e)`          | 주어진 객체보다 바로 위 객체를 리턴                                                        |
| `E`               | `floor(E e)`           | 주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체의 바로 아래의 객체를 리턴 |
| `E`               | `ceiling(E e)`         | 주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체의 바로 위의 객체를 리턴   |
| `E`               | `pollFirst()`          | 제일 낮은 객체를 꺼내오고 컬렉션에서 제거함                                                |
| `E`               | `pollLast()`           | 제일 높은 객체를 꺼내오고 컬렉션에서 제거함                                                |
| `Iterator<E>`     | `descendingIterator()` | 내림차순으로 정렬된 Iterator를 리턴                                                        |
| `NavigableSet<E>` | `descendingSet()`      | 내림차순으로 정렬된 NavigableSet을 리턴                                                    |

```java
package ch15.sec05.exam01;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		// TreeSet 컬렉션 생성
		TreeSet<Integer> scores = new TreeSet<>();

		// Integer 객체 저장
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);

		// 정렬된 Integer 객체를 하나씩 가져오기
		for (Integer s : scores) {
			System.out.print(s + " ");
		}
		System.out.println("\n");

		// 특정 Integer 객체를 가져오기
		System.out.println("가장 낮은 점수: " + scores.first());
		System.out.println("가장 높은 점수: " + scores.last());
		System.out.println("95점 아래 점수: " + scores.lower(95));
		System.out.println("95점 위의 점수: " + scores.higher(95));
		System.out.println("95점이거나 바로 아래 점수: " + scores.floor(95));
		System.out.println("85점이거나 바로 위의 점수: " + scores.ceiling(85) + "\n");

		// 내림차순으로 정렬하기
		NavigableSet<Integer> descendingScores = scores.descendingSet();
		for (Integer s : descendingScores) {
			System.out.print(s + " ");
		}
		System.out.println("\n");

		// 범위 검색 (80 <= )
		NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
		for (Integer s : rangeSet) {
			System.out.print(s + " ");
		}
		System.out.println("\n");

		// 범위 검색 (80 <= score < 90)
		rangeSet = scores.subSet(80, true, 90, false);
		for (Integer s : rangeSet) {
			System.out.print(s + " ");
		}
	}
}
```

**실행 결과**
```
75 80 87 95 98

가장 낮은 점수: 75
가장 높은 점수: 98
95점 아래 점수: 87
95점 위의 점수: 98
95점이거나 바로 아래 점수: 95
85점이거나 바로 위의 점수: 87

98 95 87 80 75

80 87 95 98

80 87
```

### TreeMap

TreeMap은 이진 트리를 기반으로 한 Map 컬렉션이다. TreeSet과의 차이점은 키와 값이 저장된 Entry를 저장한다는 점이다. TreeMap에 엔트리를 저장하면 키를 기준으로 자동 정렬되는데, 부모 키 값과 비교해서 낮은 것은 왼쪽, 높은 것은 오른쪽 자식 노드에 Entry 객체를 저장한다.

```java
package ch15.sec05.exam02;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		// TreeMap 컬렉션 생성
		TreeMap<String, Integer> treeMap = new TreeMap<>();

		// 엔트리 저장
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 80);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 30);

		// 정렬된 엔트리를 하나씩 가져오기
		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		System.out.println();

		// 특정 키에 대한 값 가져오기
		Entry<String, Integer> entry = null;
		entry = treeMap.firstEntry();
		System.out.println("제일 앞 단어: " + entry.getKey() + "-" + entry.getValue());
		entry = treeMap.lastEntry();
		System.out.println("제일 뒤 단어: " + entry.getKey() + "-" + entry.getValue());
		entry = treeMap.lowerEntry("ever");
		System.out.println("ever 앞 단어: " + entry.getKey() + "-" + entry.getValue() + "\n");

		// 내림차순으로 정렬하기
		NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
		Set<Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
		for (Entry<String, Integer> e : descendingEntrySet) {
			System.out.println(e.getKey() + "-" + e.getValue());
		}
		System.out.println();

		// 범위 검색 ([c~h 사이의 단어 검색])
		System.out.println("[c~h 사이의 단어 검색]");
		NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "h", false);
		for (Entry<String, Integer> e : rangeMap.entrySet()) {
			System.out.println(e.getKey() + "-" + e.getValue());
		}
	}
}
```

### Comparable과 Comparator

TreeSet에 저장되는 객체와 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순으로 정렬되는데, 어떤 객체든 정렬될 수 있는 것은 아니고 객체가 `Comparable` 인터페이스를 구현하고 있어야 가능하다.

`Comparable` 인터페이스에는 `compareTo()` 메소드가 정의되어 있다. 따라서 사용자 정의 클래스에서 이 메소드를 재정의해서 비교 결과를 정수 값으로 리턴해야 한다.
- 주어진 객체와 같으면 0을 리턴
- 주어진 객체보다 적으면 음수를 리턴
- 주어진 객체보다 크면 양수를 리턴

```java
package ch15.sec05.exam03;

public class Person implements Comparable<Person> {
	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (age < o.age) return -1;
		else if (age == o.age) return 0;
		else return 1;
	}
}
```

```java
package ch15.sec05.exam03;

import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		// TreeSet 컬렉션 생성
		TreeSet<Person> treeSet = new TreeSet<Person>();

		// 객체 저장
		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("감자바", 25));
		treeSet.add(new Person("박지원", 31));

		// 객체를 하나씩 가져오기
		for (Person person : treeSet) {
			System.out.println(person.name + ":" + person.age);
		}
	}
}
```

**실행 결과**
```
감자바:25
박지원:31
홍길동:45
```

비교 기능이 없는 Comparable 비구현 객체를 저장하고 싶다면 TreeSet과 TreeMap을 생성할 때 비교자(Comparator)를 제공하면 된다.

```java
package ch15.sec05.exam04;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {
	@Override
	public int compare(Fruit o1, Fruit o2) {
		if (o1.price < o2.price) return -1;
		else if (o1.price == o2.price) return 0;
		else return 1;
	}
}
```

```java
package ch15.sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		// 비교자를 제공한 TreeSet 컬렉션 생성
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>( new FruitComparator() );

		// 객체 저장
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));

		// 객체를 하나씩 가져오기
		for (Fruit fruit : treeSet) {
			System.out.println(fruit.name + ":" + fruit.price);
		}
	}
}
```

**실행 결과**
```
포도:3000
딸기:6000
수박:10000
```

## 15.6 LIFO와 FIFO 컬렉션

후입선출(LIFO: Last In First Out)은 나중에 넣은 객체가 먼저 빠져나가고, 선입선출(FIFO: First In First Out)은 먼저 넣은 객체가 먼저 빠져나가는 구조를 말한다. 컬렉션 프레임워크는 LIFO 자료구조를 제공하는 **Stack** 클래스와 FIFO 자료구조를 제공하는 **Queue** 인터페이스를 제공하고 있다.

- 스택(Stack): LIFO (응용 예: JVM 스택 메모리)
- 큐(Queue): FIFO (응용 예: 스레드풀의 작업 큐)

### Stack

Stack 클래스는 LIFO 자료구조를 구현한 클래스이다.

- `push(E item)`: 주어진 객체를 스택에 넣는다.
- `pop()`: 스택의 맨 위 객체를 빼낸다.

```java
package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		// Stack 컬렉션 생성
		Stack<Coin> coinBox = new Stack<Coin>();

		// 동전 넣기
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));

		// 동전을 하나씩 꺼내기
		while (!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
		}
	}
}
```

### Queue

Queue 인터페이스는 FIFO 자료구조에서 사용되는 메소드를 정의하고 있다.

- `offer(E e)`: 주어진 객체를 큐에 넣는다.
- `poll()`: 큐에서 객체를 빼낸다.

Queue 인터페이스를 구현한 대표적인 클래스는 LinkedList이다.

```java
package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		// Queue 컬렉션 생성
		Queue<Message> messageQueue = new LinkedList<>();

		// 메시지 넣기
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendKakaotalk", "감자바"));

		// 메시지를 하나씩 꺼내어 처리
		while (!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch (message.command) {
				case "sendMail":
					System.out.println(message.to + "님에게 메일을 보냅니다.");
					break;
				case "sendSMS":
					System.out.println(message.to + "님에게 SMS를 보냅니다.");
					break;
				case "sendKakaotalk":
					System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
					break;
			}
		}
	}
}
```

## 15.7 동기화된 컬렉션

컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다. 그렇기 때문에 여러 스레드가 동시에 컬렉션에 접근한다면 의도하지 않게 요소가 변경될 수 있는 불안전한 상태가 된다.

Vector와 Hashtable은 동기화된(synchronized) 메소드로 구성되어 있기 때문에 안전하지만, ArrayList와 HashSet, HashMap은 안전하지 않다.

비동기화된 메소드를 동기화된 메소드로 래핑하는 Collections의 `synchronizedXXX()` 메소드를 사용하면 동기화된 컬렉션으로 변환할 수 있다.

- `synchronizedList(List<T> list)`
- `synchronizedMap(Map<K,V> m)`
- `synchronizedSet(Set<T> s)`

```java
List<T> list = Collections.synchronizedList(new ArrayList<T>());
Set<E> set = Collections.synchronizedSet(new HashSet<E>());
Map<K,V> map = Collections.synchronizedMap(new HashMap<K,V>());
```

```java
package ch15.sec07;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample {
	public static void main(String[] args) {
		// Map 컬렉션 생성
		Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

		// 작업 스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				// 객체 1000개 추가
				for (int i=1; i<=1000; i++) {
					map.put(i, "내용"+i);
				}
			}
		};

		// 작업 스레드 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				// 객체 1000개 추가
				for (int i=1001; i<=2000; i++) {
					map.put(i, "내용"+i);
				}
			}
		};

		// 작업 스레드 실행
		threadA.start();
		threadB.start();

		// 작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
		}

		// 저장된 총 객체 수 얻기
		int size = map.size();
		System.out.println("총 객체 수: " + size);
	}
}
```

## 15.8 수정할 수 없는 컬렉션

수정할 수 없는(unmodifiable) 컬렉션이란 요소를 추가, 삭제할 수 없는 컬렉션을 말한다. 컬렉션 생성 시 저장된 요소를 변경하고 싶지 않을 때 유용하다.

1. `of()` 메소드 이용:
```java
List<E> immutableList = List.of(E... elements);
Set<E> immutableSet = Set.of(E... elements);
Map<K,V> immutableMap = Map.of(K k1, V v1, ...);
```

2. `copyOf()` 메소드 이용:
```java
List<E> immutableList = List.copyOf(Collection<E> coll);
Set<E> immutableSet = Set.copyOf(Collection<E> coll);
Map<K,V> immutableMap = Map.copyOf(Map<K,V> map);
```

3. 배열로부터 `Arrays.asList()` (약간 다름: 추가/삭제 불가하지만 set은 가능할 수 있음, 하지만 여기서는 of/copyOf와 함께 소개됨) - *참고: 책 예제에서는 Arrays.asList(arr)을 사용하여 List 불변 컬렉션 생성을 설명하고 있는데, 엄밀히 말하면 Arrays.asList는 고정 크기 리스트를 반환하며 set()은 허용한다. 하지만 List.of()는 완전 불변이다.*

```java
package ch15.sec08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExample {
	public static void main(String[] args) {
		// List 불변 컬렉션 생성
		List<String> immutableList1 = List.of("A", "B", "C");
		// immutableList1.add("D"); (x)

		// Set 불변 컬렉션 생성
		Set<String> immutableSet1 = Set.of("A", "B", "C");
		// immutableSet1.remove("A"); (x)

		// Map 불변 컬렉션 생성
		Map<Integer, String> immutableMap1 = Map.of(
			1, "A",
			2, "B",
			3, "C"
		);
		// immutableMap1.put(4, "D"); (x)

		// List 컬렉션을 불변 컬렉션으로 복사
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		List<String> immutableList2 = List.copyOf(list);

		// Set 컬렉션을 불변 컬렉션으로 복사
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		Set<String> immutableSet2 = Set.copyOf(set);

		// Map 컬렉션을 불변 컬렉션으로 복사
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		Map<Integer, String> immutableMap2 = Map.copyOf(map);

		// 배열로부터 List 불변 컬렉션 생성
		String[] arr = { "A", "B", "C" };
		List<String> immutableList3 = Arrays.asList(arr);
	}
}
```

## 확인문제

1.  자바의 컬렉션 프레임워크에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① List 컬렉션은 인덱스로 객체를 관리하며 중복 저장을 허용한다.
    *   ② Set 컬렉션은 순서를 유지하지 않으며 중복 저장을 허용하지 않는다.
    *   ③ Map 컬렉션은 키와 값으로 구성된 Map.Entry를 저장한다.
    *   ④ Stack은 FIFO (선입선출) 자료구조를 구현한 클래스이다.
    > **정답**: ④
    > **해설**: Stack은 LIFO(후입선출) 자료구조이다.

2.  List 컬렉션에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 대표적인 구현 클래스로는 ArrayList, Vector, LinkedList가 있다.
    *   ② 멀티 스레드 환경에서는 ArrayList보다는 Vector가 스레드에 안전하다.
    *   ③ ArrayList에서 객체를 삭제하면 삭제된 위치는 비어 있게 된다.
    *   ④ 중간 위치에 객체를 빈번히 삽입하거나 제거할 경우 LinkedList를 사용하는 것이 좋다.
    > **정답**: ③
    > **해설**: ArrayList에서 객체를 삭제하면 뒤의 객체들이 한 칸씩 앞으로 당겨져 위치를 채운다.

3.  Set 컬렉션에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 대표적인 구현 클래스로는 HashSet, LinkedHashSet, TreeSet이 있다.
    *   ② Set 컬렉션에서 객체를 하나씩 꺼내오고 싶다면 Iterator를 이용한다.
    *   ③ HashSet은 hashCode()와 equals() 메소드를 이용해서 중복된 객체를 판별한다.
    *   ④ Set 컬렉션에는 null을 저장할 수 없다.
    > **정답**: ④
    > **해설**: Set 컬렉션에는 null을 저장할 수 있다 (단, 하나만).

4.  Map 컬렉션에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 대표적인 구현 클래스로는 HashMap, Hashtable, TreeMap, Properties가 있다.
    *   ② HashMap과 Hashtable은 hashCode()와 equals() 메소드를 이용해서 중복 키를 판별한다.
    *   ③ 멀티 스레드 환경에서는 Hashtable보다는 HashMap이 스레드에 안전하다.
    *   ④ Properties는 키와 값이 모두 String 타입이다.
    > **정답**: ③
    > **해설**: Hashtable이 동기화되어 있어 스레드에 안전하다. HashMap은 안전하지 않다.

5.  단일(싱글) 스레드 환경에서 Board 객체를 저장 순서에 맞게 읽고 싶습니다. 가장 적합한 컬렉션을 생성하도록 밑줄 친 부분에 코드를 작성해 보세요.
    ```java
    List<Board> list = new ArrayList<Board>();
    // 또는 new ArrayList<>();
    ```

6.  단일(싱글) 스레드 환경에서 학번(String)를 키로, 점수(Integer)를 값으로 저장하는 가장 적합한 컬렉션을 생성하도록 밑줄 친 부분에 코드를 작성해 보세요.
    ```java
    Map<String, Integer> map = new HashMap<String, Integer>();
    // 또는 new HashMap<>();
    ```

7.  BoardDao 객체의 getBoardList() 메소드를 호출하면 List\<Board\> 타입의 컬렉션을 리턴합니다. ListExample 클래스의 실행 결과를 보고, BoardDao 클래스와 getBoardList() 메소드를 작성해 보세요.
    ```java
    import java.util.ArrayList;
    import java.util.List;

    public class BoardDao {
    	public List<Board> getBoardList() {
    		List<Board> list = new ArrayList<>();
    		list.add(new Board("제목1", "내용1"));
    		list.add(new Board("제목2", "내용2"));
    		list.add(new Board("제목3", "내용3"));
    		return list;
    	}
    }
    ```

8.  HashSet에 Student 객체를 저장하려고 합니다. 학번이 같으면 동일한 Student라고 가정하고 중복 저장이 되지 않도록 하고 싶습니다. Student 객체의 해시코드는 학번이라고 가정하고 Student 클래스를 작성해 보세요.
    ```java
    public class Student {
    	public int studentNum;
    	public String name;

    	public Student(int studentNum, String name) {
    		this.studentNum = studentNum;
    		this.name = name;
    	}

    	@Override
    	public int hashCode() {
    		return studentNum;
    	}

    	@Override
    	public boolean equals(Object obj) {
    		if (obj instanceof Student target) {
    			return target.studentNum == studentNum;
    		} else {
    			return false;
    		}
    	}
    }
    ```

9.  HashMap에 아이디(String)와 점수(Integer)가 저장되어 있습니다. 실행 결과와 같이 평균 점수, 최고 점수, 최고 점수를 받은 아이디를 출력하도록 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    String name = null;
    int maxScore = 0;
    int totalScore = 0;

    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
    for (Map.Entry<String, Integer> entry : entrySet) {
    	if (entry.getValue() > maxScore) {
    		name = entry.getKey();
    		maxScore = entry.getValue();
    	}
    	totalScore += entry.getValue();
    }
    int avgScore = totalScore / map.size();

    System.out.println("평균 점수: " + avgScore);
    System.out.println("최고 점수: " + maxScore);
    System.out.println("최고 점수를 받은 아이디: " + name);
    ```

10. TreeSet에 Student 객체를 저장할 때, Student의 score 필드값을 기준으로 자동 정렬되도록 구현하고 싶습니다. TreeSet의 last() 메소드를 호출했을 때 가장 높은 score의 Student 객체가 리턴되도록 Student 클래스에서 밑줄 친 곳과 비어있는 곳에 코드를 작성해 보세요.
    ```java
    public class Student implements Comparable<Student> {
    	public String id;
    	public int score;

    	public Student(String id, int score) {
    		this.id = id;
    		this.score = score;
    	}

    	@Override
    	public int compareTo(Student o) {
    		if (score < o.score) return -1;
    		else if (score == o.score) return 0;
    		else return 1;
    	}
    }
    ```

11. LIFO와 FIFO 컬렉션에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① Stack은 LIFO이고 Queue는 FIFO 구조를 가지고 있다.
    *   ② Stack에 넣는 행위는 push이고, 빼는 행위는 pop이다.
    *   ③ Queue에 넣는 행위는 offer이고, 빼는 행위는 poll이다.
    *   ④ Stack과 Queue는 자바에서 클래스 타입이다.
    > **정답**: ④
    > **해설**: Stack은 클래스이지만, Queue는 인터페이스이다.

12. 동기화된 컬렉션에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 멀티 스레드 환경에서 안전하게 사용할 수 있는 컬렉션이다.
    *   ② 동기화된 컬렉션의 메소드는 synchronized 처리가 되어 있다.
    *   ③ Vector와 HashMap은 동기화된 컬렉션이다.
    *   ④ Collections의 synchronizedMap() 메소드는 동기화된 Map을 리턴한다.
    > **정답**: ③
    > **해설**: Vector는 동기화된 컬렉션이지만, HashMap은 동기화되어 있지 않다. Hashtable이 동기화된 컬렉션이다.

13. 수정할 수 없는 List 컬렉션에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 요소를 추가, 삭제할 수 없는 List 컬렉션을 말한다.
    *   ② List의 of() 메소드는 수정할 수 없는 컬렉션을 생성한다.
    *   ③ List의 copyOf() 메소드는 기존 컬렉션을 복사한 수정할 수 없는 컬렉션을 생성한다.
    *   ④ Arrays.asList() 메소드는 배열로부터 수정할 수 있는 List 컬렉션을 생성한다.
    > **정답**: ④
    > **해설**: Arrays.asList()로 생성된 리스트는 고정 크기라서 추가/삭제 불가능하지만 set()으로 변경은 가능하다. 하지만 문제의 문맥상 일반적으로 '수정할 수 없는' 기능에 포함되거나, 혹은 완전한 '수정할 수 있는' ArrayList와 구별된다. 하지만 여기서 명확히 틀린 것을 찾자면, Arrays.asList()는 `add`/`remove`를 지원하지 않아 "수정할 수 있는"이라고 단정하기 어렵고, `List.of`나 `copyOf`와 달리 `set`은 되므로 완전 불변도 아니다. 그러나 문제 의도는 1,2,3이 명확히 맞는 설명이고 4번이 "수정할 수 있는"이라고 했으므로 틀린 것으로 볼 수 있다. (Arrays.asList는 구조적 수정 불가). 혹은 Arrays.asList는 불변 리스트가 아니라 고정 크기 리스트이다.
