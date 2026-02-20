---
layout: oop
title: "13.5 와일드카드 타입 파라미터"
nav_order: 5
parent: "Chapter 13. 제네릭"
grand_parent: "객체지향 프로그래밍"
---

# 13.5 와일드카드 타입 파라미터

제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 타입 파라미터로 `?`(와일드카드)를 사용할 수 있다. `?`는 범위에 있는 모든 타입으로 대체할 수 있다는 표시이다. 예를 들어 다음과 같은 상속 관계가 있다고 가정해 보자.

```
Person
  ^
  | (extends)
Worker     Student
             ^
             | (extends)
         HighStudent
         MiddleStudent
```

타입 파라미터의 대체 타입으로 `Student`와 자식 클래스인 `HighStudent`와 `MiddleStudent`만 가능하도록 매개변수를 다음과 같이 선언할 수 있다.

```java
리턴타입 메소드명(제네릭타입<? extends Student> 변수) { ... }
```

반대로 `Worker`와 부모 클래스인 `Person`만 가능하도록 매개변수를 다음과 같이 선언할 수 있다.

```java
리턴타입 메소드명(제네릭타입<? super Worker> 변수) { ... }
```

어떤 타입이든 가능하도록 매개변수를 선언할 수도 있다.

```java
리턴타입 메소드명(제네릭타입<?> 변수) { ... }
```

다음 예제에서 `Course` 클래스의 메소드 `registerCourse1()`은 모든 사람이 들을 수 있는 과정을 등록하고, `registerCourse2()`는 학생만 들을 수 있는 과정을 등록한다. 그리고 `registerCourse3()`은 직장인과 일반인만 들을 수 있는 과정을 등록한다.

```java
package ch13.sec05;

public class Person {
}

class Worker extends Person {
}

class Student extends Person {
}

class HighStudent extends Student {
}

class MiddleStudent extends Student {
}
```

```java
package ch13.sec05;

public class Applicant<T> {
	public T kind;

	public Applicant(T kind) {
		this.kind = kind;
	}
}
```

```java
package ch13.sec05;

public class Course {
	// 모든 사람이면 등록 가능
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course1을 등록함");
	}

	// 학생만 등록 가능
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course2를 등록함");
	}

	// 직장인 및 일반인만 등록 가능
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course3을 등록함");
	}
}
```

```java
package ch13.sec05;

public class GenericExample {
	public static void main(String[] args) {
		// 모든 사람이 신청 가능
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();

		// 학생만 신청 가능
		// Course.registerCourse2(new Applicant<Person>(new Person())); (x)
		// Course.registerCourse2(new Applicant<Worker>(new Worker())); (x)
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();

		// 직장인 및 일반인만 신청 가능
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		// Course.registerCourse3(new Applicant<Student>(new Student())); (x)
		// Course.registerCourse3(new Applicant<HighStudent>(new HighStudent())); (x)
		// Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent())); (x)
	}
}
```

**실행 결과**
```
Person이(가) Course1을 등록함
Worker이(가) Course1을 등록함
Student이(가) Course1을 등록함
HighStudent이(가) Course1을 등록함
MiddleStudent이(가) Course1을 등록함

Student이(가) Course2를 등록함
HighStudent이(가) Course2를 등록함
MiddleStudent이(가) Course2를 등록함

Person이(가) Course3을 등록함
Worker이(가) Course3을 등록함
```
