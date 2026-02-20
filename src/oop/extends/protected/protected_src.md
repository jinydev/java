---
layout: oop
title: "7.6 protected 접근 제한자"
nav_order: 6
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.6 protected 접근 제한자

우리는 6.13절에서 public, private 접근 제한자를 사용해 객체 외부에서 필드, 생성자, 메소드의 접근 여부를 결정했다. 이번 절에서는 또 하나의 접근 제한자인 protected에 대해 알아본다. protected는 상속과 관련이 있고, public과 default의 중간쯤에 해당하는 접근 제한을 한다.

| 접근 제한자 | 적용 대상            | 접근할 수 있는 범위                      |
| ----------- | -------------------- | ---------------------------------------- |
| protected   | 필드, 생성자, 메소드 | 같은 패키지이거나, 자식 객체만 사용 가능 |

protected는 같은 패키지에서는 default처럼 접근이 가능하나, 다른 패키지에서는 자식 클래스만 접근을 허용한다. protected는 필드와 생성자 그리고 메소드 선언에 사용될 수 있다.

다음 A 클래스를 보면 protected로 선언된 필드, 생성자, 메소드가 있다.

**A.java**
```java
package ch07.sec06.package1;

public class A {
	// 필드 선언
	protected String field;
	
	// 생성자 선언
	protected A() {
	}
	
	// 메소드 선언
	protected void method() {
	}
}
```

다음 B 클래스는 A 클래스와 동일한 패키지에 있기 때문에 A의 protected 필드, 생성자, 메소드에 접근이 가능하다.

**B.java**
```java
package ch07.sec06.package1;

public class B {
	// 메소드 선언
	public void method() {
		A a = new A(); // (o)
		a.field = "value"; // (o)
		a.method(); // (o)
	}
}
```

다음 C 클래스는 A 클래스와 다른 패키지에 있기 때문에 A의 protected 필드, 생성자, 메소드에 접근할 수 없다.

**C.java**
```java
package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class C {
	// 메소드 선언
	public void method() {
		// A a = new A(); // (x)
		// a.field = "value"; // (x)
		// a.method(); // (x)
	}
}
```

다음 D 클래스는 A 클래스와 다른 패키지에 있지만 A의 자식 클래스이므로 A의 protected 필드, 생성자, 메소드에 접근이 가능하다. 단 new 연산자를 사용해서 생성자를 직접 호출할 수는 없고, 자식 생성자에서 super()로 A 생성자를 호출할 수 있다.

**D.java**
```java
package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class D extends A {
	// 생성자 선언
	public D() {
		// A() 생성자 호출
		super(); // (o)
	}
	
	// 메소드 선언
	public void method1() {
		// A 필드값 변경
		this.field = "value"; // (o)
		// A 메소드 호출
		this.method(); // (o)
	}
	
	// 메소드 선언
	public void method2() {
		// A a = new A(); // (x)
		// a.field = "value"; // (x)
		// a.method(); // (x)
	}
}
```
