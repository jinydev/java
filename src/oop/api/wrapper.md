---
layout: oop
title: "12.6 포장 클래스"
nav_order: 6
parent: "Chapter 12. java.base 모듈"
grand_parent: "객체지향 프로그래밍"
---

# 12.6 포장 클래스

자바는 기본 타입(byte, char, short, int, long, float, double, boolean)의 값을 갖는 객체를 생성할 수 있다. 이런 객체를 포장(Wrapper) 객체라고 한다. 값을 포장하고 있다고 해서 붙여진 이름이다.

포장 객체를 생성하기 위한 클래스는 java.lang 패키지에 포함되어 있는데, char 타입과 int 타입이 각각 Character와 Integer인 것만 제외하고는 기본 타입의 첫 문자를 대문자로 바꾼 이름을 가지고 있다.

| 기본 타입 | 포장 클래스 | 기본 타입 | 포장 클래스 |
| :-------- | :---------- | :-------- | :---------- |
| byte      | Byte        | int       | Integer     |
| char      | Character   | long      | Long        |
| short     | Short       | float     | Float       |
| double    | Double      | boolean   | Boolean     |

포장 객체는 포장하고 있는 기본 타입의 값을 변경할 수 없고, 단지 객체로 생성하는 데 목적이 있다. 이런 객체가 필요한 이유는 컬렉션 객체 때문이다. 15장에서 학습할 컬렉션 객체는 기본 타입의 값은 저장할 수 없고, 객체만 저장할 수 있다.

## 박싱과 언박싱

기본 타입의 값을 포장 객체로 만드는 과정을 박싱(Boxing)이라고 하고, 반대로 포장 객체에서 기본 타입의 값을 얻어내는 과정을 언박싱(Unboxing)이라고 한다.

박싱은 포장 클래스 변수에 기본 타입 값이 대입될 때 발생한다. 반대로 언박싱은 기본 타입 변수에 포장 객체가 대입될 때 발생한다.

```java
Integer obj = 100; // 박싱
int value = obj;   // 언박싱
```

언박싱은 다음과 같이 연산 과정에서도 발생한다. obj는 50과 연산되기 전에 언박싱된다.

```java
int value = obj + 50; // 언박싱 후 연산
```

```java
package ch12.sec06;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		// Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue()); // intValue() 메소드는 Integer 객체 내부의 int 값을 리턴한다.

		// Unboxing
		int value = obj;
		System.out.println("value: " + value);

		// 연산 시 Unboxing
		int result = obj + 100;
		System.out.println("result: " + result);
	}
}
```

**실행 결과**
```
value: 100
value: 100
result: 200
```

## 문자열을 기본 타입 값으로 변환

포장 클래스는 문자열을 기본 타입 값으로 변환할 때도 사용된다. 대부분의 포장 클래스에는 `parse+기본타입`명으로 되어 있는 정적(static) 메소드가 있다. 이 메소드는 문자열을 해당 기본 타입 값으로 변환한다(2.10절 참조).

## 포장 값 비교

포장 객체는 내부 값을 비교하기 위해 ==와 != 연산자를 사용할 수 없다. 이 연산은 내부의 값을 비교하는 것이 아니라 포장 객체의 번지를 비교하기 때문이다.

예외도 있다. 포장 객체의 효율적 사용을 위해 다음 범위의 값을 갖는 포장 객체는 공유된다. 이 범위의 값을 갖는 포장 객체는 ==와 != 연산자로 비교할 수 있지만, 내부 값을 비교하는 것이 아니라 객체 번지를 비교한다는 것을 알아야 한다.

| 타입             | 값의 범위       |
| :--------------- | :-------------- |
| boolean          | true, false     |
| char             | \u0000 ~ \u007f |
| byte, short, int | -128 ~ 127      |

포장 객체에 정확히 어떤 값이 저장될지 모르는 상황이라면 ==과 !=은 사용하지 않는 것이 좋다. 대신 equals() 메소드로 내부 값을 비교할 수 있다. 포장 클래스의 equals() 메소드는 내부의 값을 비교하도록 재정의되어 있다.

```java
package ch12.sec06;

public class ValueCompareExample {
	public static void main(String[] args) {
		// -128~127 초과값일 경우
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println("==: " + (obj1 == obj2));
		System.out.println("equals(): " + obj1.equals(obj2));
		System.out.println();

		// -128~127 범위값일 경우
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("==: " + (obj3 == obj4));
		System.out.println("equals: " + obj3.equals(obj4));
	}
}
```

**실행 결과**
```
==: false
equals(): true

==: true
equals: true
```
