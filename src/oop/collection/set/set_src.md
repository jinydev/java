---
layout: oop
title: "15.3 Set 컬렉션"
nav_order: 3
parent: "Chapter 15. 컬렉션 자료구조"
grand_parent: "객체지향 프로그래밍"
---

# 15.3 Set 컬렉션

`List` 컬렉션은 저장 순서를 유지하지만, `Set` 컬렉션은 저장 순서가 유지되지 않는다. 또한 객체를 중복해서 저장할 수 없고, 하나의 `null`만 저장할 수 있다. `Set` 컬렉션은 수학의 집합에 비유될 수 있다.

`Set` 컬렉션에는 `HashSet`, `LinkedHashSet`, `TreeSet` 등이 있는데, `Set` 컬렉션에서 공통적으로 사용 가능한 `Set` 인터페이스의 메소드는 다음과 같다.

| 기능      | 메소드                       | 설명                                                                       |
| :-------- | :--------------------------- | :------------------------------------------------------------------------- |
| 객체 추가 | `boolean add(E e)`           | 주어진 객체를 성공적으로 저장하면 true를 리턴하고 중복 객체면 false를 리턴 |
| 객체 검색 | `boolean contains(Object o)` | 주어진 객체가 저장되어 있는지 여부                                         |
|           | `boolean isEmpty()`          | 컬렉션이 비어 있는지 조사                                                  |
|           | `Iterator<E> iterator()`     | 저장된 객체를 한 번씩 가져오는 반복자 리턴                                 |
|           | `int size()`                 | 저장되어 있는 전체 객체 수 리턴                                            |
| 객체 삭제 | `void clear()`               | 저장된 모든 객체를 삭제                                                    |
|           | `boolean remove(Object o)`   | 주어진 객체를 삭제                                                         |

## HashSet

`Set` 컬렉션 중에서 가장 많이 사용되는 것이 `HashSet`이다. 다음은 `HashSet` 컬렉션을 생성하는 방법이다.

```java
Set<E> set = new HashSet<E>();
Set<E> set = new HashSet<>();
```

`HashSet`은 동일한 객체는 중복 저장하지 않는다. 여기서 동일한 객체란 동등 객체를 말한다. `HashSet`은 다른 객체라도 `hashCode()` 메소드의 리턴값이 같고, `equals()` 메소드가 `true`를 리턴하면 동일한 객체라고 판단하고 중복 저장하지 않는다.

문자열을 `HashSet`에 저장할 경우, 같은 문자열을 갖는 `String` 객체는 동등한 객체로 간주한다.

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

다음 예제는 이름과 나이가 동일할 경우 `Member` 객체를 `HashSet`에 중복 저장하지 않는다.

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

`Set` 컬렉션은 인덱스로 객체를 검색해서 가져오는 메소드가 없다. 대신 객체를 한 개씩 반복해서 가져와야 하는데, 여기에는 두 가지 방법이 있다. 하나는 `for` 문을 이용하는 것이고, 다른 방법은 `iterator()` 메소드로 반복자(`Iterator`)를 얻어 객체를 하나씩 가져오는 것이다.

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
