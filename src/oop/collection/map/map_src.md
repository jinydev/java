---
layout: oop
title: "15.4 Map 컬렉션"
nav_order: 4
parent: "Chapter 15. 컬렉션 자료구조"
grand_parent: "객체지향 프로그래밍"
---

# 15.4 Map 컬렉션

`Map` 컬렉션은 **키(key)**와 **값(value)**으로 구성된 **엔트리(Entry)** 객체를 저장한다. 여기서 키와 값은 모두 객체이다. 키는 중복 저장할 수 없지만 값은 중복 저장할 수 있다. 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대치된다.

`Map` 컬렉션에는 `HashMap`, `Hashtable`, `LinkedHashMap`, `Properties`, `TreeMap` 등이 있다.

`Map` 컬렉션에서 공통적으로 사용 가능한 `Map` 인터페이스 메소드는 다음과 같다.

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

## HashMap

`HashMap`은 키로 사용할 객체가 `hashCode()` 메소드의 리턴값이 같고 `equals()` 메소드가 `true`를 리턴할 경우, 동일 키로 보고 중복 저장을 허용하지 않는다.

다음은 `HashMap` 컬렉션을 생성하는 방법이다.

```java
Map<K, V> map = new HashMap<K, V>();
Map<K, V> map = new HashMap<>();
```

다음 예제는 이름을 키로, 점수를 값으로 저장하는 `HashMap` 사용 방법을 보여 준다.

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

## Hashtable

`Hashtable`은 `HashMap`과 동일한 내부 구조를 가지고 있다. 차이점은 `Hashtable`은 동기화된(`synchronized`) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 `Hashtable`의 메소드들을 실행할 수 없다는 것이다. 따라서 멀티 스레드 환경에서도 안전하게 객체를 추가, 삭제할 수 있다.

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

## Properties

`Properties`는 `Hashtable`의 자식 클래스이기 때문에 `Hashtable`의 특징을 그대로 가지고 있다. `Properties`는 키와 값을 `String` 타입으로 제한한 컬렉션이다. `Properties`는 주로 확장자가 `.properties`인 프로퍼티 파일을 읽을 때 사용한다.

`프로퍼티 파일`은 키와 값이 `=` 기호로 연결되어 있는 텍스트 파일이다.

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
