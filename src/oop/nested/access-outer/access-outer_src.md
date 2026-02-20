---
layout: oop
title: "9.5 바깥 멤버 접근"
nav_order: 5
parent: "Chapter 09. 중첩 선언과 익명 객체"
grand_parent: "객체지향 자바 프로그래밍"
---

# 9.5 바깥 멤버 접근

중첩 클래스는 바깥 클래스와 긴밀한 관계를 맺으면서 바깥 클래스의 멤버(필드, 메소드)에 접근할 수 있다. 하지만 중첩 클래스가 어떻게 선언되었느냐에 따라 접근 제한이 있을 수 있다.

## 바깥 클래스의 멤버 접근 제한

정적 멤버 클래스 내부에서는 바깥 클래스의 필드와 메소드를 사용할 때 제한이 따른다.

| 구분                     | 바깥 클래스의 사용 가능한 멤버        |
| :----------------------- | :------------------------------------ |
| **인스턴스 멤버 클래스** | 바깥 클래스의 모든 필드와 메소드      |
| **정적 멤버 클래스**     | 바깥 클래스의 정적 필드와 정적 메소드 |

정적 멤버 클래스는 바깥 객체가 없어도 사용 가능해야 하므로 바깥 클래스의 인스턴스 필드와 인스턴스 메소드는 사용하지 못한다.

**A.java**
```java
package ch09.sec05.exam01;

public class A {
	// A의 인스턴스 필드와 메소드
	int field1;
	void method1() { }
	
	// A의 정적 필드와 메소드
	static int field2;
	static void method2() { }
	
	// 인스턴스 멤버 클래스
	class B {
		void method() {
			// A의 인스턴스 필드와 메소드 사용
			field1 = 10; // (o)
			method1(); // (o)
			
			// A의 정적 필드와 메소드 사용
			field2 = 10; // (o)
			method2(); // (o)
		}
	}
	
	// 정적 멤버 클래스
	static class C {
		void method() {
			// A의 인스턴스 필드와 메소드 사용
			// field1 = 10; // (x)
			// method1(); // (x)
			
			// A의 정적 필드와 메소드 사용
			field2 = 10; // (o)
			method2(); // (o)
		}
	}
}
```

## 바깥 클래스의 객체 접근

중첩 클래스 내부에서 `this`는 해당 중첩 클래스의 객체를 말한다. 만약 중첩 클래스 내부에서 바깥 클래스의 객체를 얻으려면 바깥 클래스 이름에 `this`를 붙여 주면 된다.

```
바깥클래스이름.this -> 바깥객체
```

다음 예제는 중첩 클래스와 바깥 클래스가 동일한 이름의 인스턴스 필드와 메소드를 가지고 있을 경우, 바깥 객체 소속의 필드와 메소드를 사용하는 방법을 보여 준다.

**A.java**
```java
package ch09.sec05.exam02;

public class A {
	// A 인스턴스 필드
	String field = "A-field";
	
	// A 인스턴스 메소드
	void method() {
		System.out.println("A-method");
	}
	
	// 인스턴스 멤버 클래스
	class B {
		// B 인스턴스 필드
		String field = "B-field";
		
		// B 인스턴스 메소드
		void method() {
			System.out.println("B-method");
		}
		
		// B 인스턴스 메소드
		void print() {
			// B 객체의 필드와 메소드 사용
			System.out.println(this.field);
			this.method();
			
			// A 객체의 필드와 메소드 사용
			System.out.println(A.this.field);
			A.this.method();
		}
	}
	
	// A의 인스턴스 메소드
	void useB() {
		B b = new B();
		b.print();
	}
}
```

**AExample.java**
```java
package ch09.sec05.exam02;

public class AExample {
	public static void main(String[] args) {
		// A 객체 생성
		A a = new A();
		
		// A 메소드 호출
		a.useB();
	}
}
```

**실행 결과**
```
B-field
B-method
A-field
A-method
```
