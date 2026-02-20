---
layout: oop
title: "6.13 접근 제한자"
nav_order: 13
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.13 접근 제한자

main() 메소드를 가지는 클래스에서 외부 클래스를 사용해서 객체를 생성하고 필드와 메소드를 사용하는 코드를 많이 보아왔다.

```java
Car myCar = new Car();
myCar.speed = 60;
myCar.run();
```

객체 생성을 막기 위해 생성자를 호출하지 못하게 하거나 객체의 특정 데이터를 보호하기 위해 해당 필드에 접근하지 못하게 막아야 할 때가 있다. 그리고 특정 메소드를 호출할 수 없도록 막아야 할 때도 있다.

자바는 이러한 경우를 대비해서 접근 제한자(Access Modifier)를 제공한다. 접근 제한자는 말 그대로 접근을 제한하기 위해 사용된다. 여기서 접근이란 클래스 및 인터페이스를 이용하는 것을 말한다.

접근 제한자는 public, protected, private와 default(아무것도 붙이지 않음)가 있다.

| 접근 제한자 | 적용 대상                    | 접근할 수 있는 범위              |
| ----------- | ---------------------------- | -------------------------------- |
| public      | 클래스, 필드, 생성자, 메소드 | 없음 (모든 패키지에서 접근 가능) |
| protected   | 필드, 생성자, 메소드         | 같은 패키지 + 자식 클래스        |
| default     | 클래스, 필드, 생성자, 메소드 | 같은 패키지                      |
| private     | 필드, 생성자, 메소드         | 클래스 내부                      |

## 클래스의 접근 제한

클래스를 어디에서나 사용할 수 있는 것은 아니다. 클래스를 다른 패키지에서도 사용할 수 있도록 할 것인지, 아니면 같은 패키지에서만 사용할 수 있도록 할 것인지에 따라 접근 제한자를 갖는다.

```java
[public] class 클래스 { ... }
```

클래스 선언 시 public 접근 제한자를 생략했다면 클래스는 default 접근 제한을 가졌다라고 말한다. 클래스가 default 접근 제한을 가지면 같은 패키지에서는 아무런 제한 없이 사용할 수 있지만 다른 패키지에서는 사용할 수 없도록 제한된다.

반대로 클래스가 public 접근 제한을 가지면 같은 패키지뿐만 아니라 다른 패키지에서도 아무런 제한 없이 사용할 수 있다.

라이브러리 클래스를 개발할 때에는 일반적으로 public 접근 제한을 갖도록 해서 어느 패키지에서나 사용할 수 있도록 한다. 그러나 인터넷으로 배포되는 라이브러리 클래스들 중에는 public이 아닌 것도 있다. 이것은 외부로 노출시키지 않고 라이브러리 내부에서만 사용하기 위해서이다.

## 생성자의 접근 제한

객체를 생성하기 위해서는 new 연산자로 생성자를 호출해야 한다. 하지만 생성자를 어디에서나 호출할 수 있는 것은 아니다. 생성자가 어떤 접근 제한을 갖느냐에 따라 호출 가능 여부가 결정된다.

```java
public class ClassName {
    [public | protected | private] ClassName(...) { ... }
}
```

- **public 접근 제한**: 모든 패키지에서 아무런 제한 없이 생성자를 호출할 수 있다.
- **protected 접근 제한**: 같은 패키지에 속하는 클래스에서 생성자를 호출할 수 있다. 다른 패키지에 속한 클래스가 해당 클래스의 자식 클래스라면 생성자를 호출할 수 있다.
- **default 접근 제한**: 같은 패키지에 속하는 클래스에서만 생성자를 호출할 수 있다.
- **private 접근 제한**: 동일한 클래스 내부에서만 생성자를 호출할 수 있고 외부에서는 호출할 수 없다.

**A.java**
```java
package ch06.sec13.exam02.package1;

public class A {
	// 필드 선언
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	// public 접근 제한 생성자 선언
	public A(boolean b) {
	}
	
	// default 접근 제한 생성자 선언
	A(int b) {
	}
	
	// private 접근 제한 생성자 선언
	private A(String s) {
	}
}
```

**B.java**
```java
package ch06.sec13.exam02.package1;

public class B {
	// 필드 선언
	A a1 = new A(true); // (o)
	A a2 = new A(1);    // (o)
	// A a3 = new A("문자열"); // (x) private 생성자 접근 불가
}
```

**C.java**
```java
package ch06.sec13.exam02.package2;

import ch06.sec13.exam02.package1.*;

public class C {
	// 필드 선언
	A a1 = new A(true); // (o)
	// A a2 = new A(1);    // (x) default 생성자 접근 불가
	// A a3 = new A("문자열"); // (x) private 생성자 접근 불가
}
```

## 필드와 메소드의 접근 제한

필드와 메소드를 어디서나 사용할 수 있는 것은 아니다. 어떤 접근 제한을 갖느냐에 따라 호출 여부가 결정된다.

```java
[public | protected | private] [static] 타입 필드;
[public | protected | private] [static] 리턴타입 메소드(...) { ... }
```

- **public 접근 제한**: 모든 패키지에서 아무런 제한 없이 필드와 메소드를 사용할 수 있다.
- **protected 접근 제한**: 같은 패키지에 속하는 클래스에서 필드와 메소드를 사용할 수 있다. 다른 패키지에 속한 클래스가 해당 클래스의 자식 클래스라면 필드와 메소드를 사용할 수 있다.
- **default 접근 제한**: 같은 패키지에 속하는 클래스에서만 필드와 메소드를 사용할 수 있다.
- **private 접근 제한**: 동일한 클래스 내부에서만 필드와 메소드를 사용할 수 있다.

**A.java**
```java
package ch06.sec13.exam03.package1;

public class A {
	// public 접근 제한을 갖는 필드 선언
	public int field1;
	// default 접근 제한을 갖는 필드 선언
	int field2;
	// private 접근 제한을 갖는 필드 선언
	private int field3;
	
	// public 접근 제한을 갖는 생성자 선언
	public A() {
		field1 = 1;	// (o)
		field2 = 1;	// (o)
		field3 = 1;	// (o)
		
		method1();	// (o)
		method2();	// (o)
		method3();	// (o)
	}
	
	// public 접근 제한을 갖는 메소드 선언
	public void method1() {
	}
	
	// default 접근 제한을 갖는 메소드 선언
	void method2() {
	}
	
	// private 접근 제한을 갖는 메소드 선언
	private void method3() {
	}
}
```

**B.java**
```java
package ch06.sec13.exam03.package1;

public class B {
	public void method() {
		// 객체 생성
		A a = new A();
		
		// 필드값 변경
		a.field1 = 1; // (o)
		a.field2 = 1; // (o)
		// a.field3 = 1; // (x) private 필드 접근 불가
		
		// 메소드 호출
		a.method1(); // (o)
		a.method2(); // (o)
		// a.method3(); // (x) private 메소드 접근 불가
	}
}
```

**C.java**
```java
package ch06.sec13.exam03.package2;

import ch06.sec13.exam03.package1.*;

public class C {
	public void method() {
		// 객체 생성
		A a = new A();
		
		// 필드값 변경
		a.field1 = 1; // (o)
		// a.field2 = 1; // (x) default 필드 접근 불가
		// a.field3 = 1; // (x) private 필드 접근 불가
		
		// 메소드 호출
		a.method1(); // (o)
		// a.method2(); // (x) default 메소드 접근 불가
		// a.method3(); // (x) private 메소드 접근 불가
	}
}
```
