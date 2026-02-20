---
layout: oop
title: "15.7 동기화된 컬렉션"
nav_order: 7
parent: "Chapter 15. 컬렉션 자료구조"
grand_parent: "객체지향 프로그래밍"
---

# 15.7 동기화된 컬렉션

컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다. 그렇기 때문에 여러 스레드가 동시에 컬렉션에 접근한다면 의도하지 않게 요소가 변경될 수 있는 불안전한 상태가 된다.

`Vector`와 `Hashtable`은 동기화된(`synchronized`) 메소드로 구성되어 있기 때문에 안전하지만, `ArrayList`와 `HashSet`, `HashMap`은 안전하지 않다.

비동기화된 메소드를 동기화된 메소드로 래핑하는 `Collections`의 `synchronizedXXX()` 메소드를 사용하면 동기화된 컬렉션으로 변환할 수 있다.

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
