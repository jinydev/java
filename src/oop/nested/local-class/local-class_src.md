---
layout: oop
title: "9.4 로컬 클래스"
nav_order: 4
parent: "Chapter 09. 중첩 선언과 익명 객체"
grand_parent: "객체지향 자바 프로그래밍"
---

# 9.4 로컬 클래스

생성자 또는 메소드 내부에서 다음과 같이 선언된 클래스를 로컬(Local) 클래스라고 한다.

```java
[public] class A {
    // 생성자
    public A() {
        class B {}
    }
    
    // 메소드
    public void method() {
        class B {}
    }
}
```

로컬 클래스는 생성자와 메소드가 실행될 동안에만 객체를 생성할 수 있다.

**A.java**
```java
package ch09.sec04.exam01;

public class A {
	// 생성자
	A() {
		// 로컬 클래스 선언
		class B {}
		
		// 로컬 객체 생성
		B b = new B();
	}
	
	// 메소드
	void method() {
		// 로컬 클래스 선언
		class B {}
		
		// 로컬 객체 생성
		B b = new B();
	}
}
```

로컬 클래스 B 내부에는 일반 클래스와 같이 필드, 생성자, 메소드 선언이 올 수 있다. 정적 필드와 정적 메소드는 Java 17부터 선언이 가능하다.

**A.java**
```java
package ch09.sec04.exam02;

public class A {
	// 메소드
	void useB() {
		// 로컬 클래스
		class B {
			// 인스턴스 필드
			int field1 = 1;
			
			// 정적 필드(Java 17부터 허용)
			static int field2 = 2;
			
			// 생성자
			B() {
				System.out.println("B-생성자 실행");
			}
			
			// 인스턴스 메소드
			void method1() {
				System.out.println("B-method1 실행");
			}
			
			// 정적 메소드(Java 17부터 허용)
			static void method2() {
				System.out.println("B-method2 실행");
			}
		}
		
		// 로컬 객체 생성
		B b = new B();
		
		// 로컬 객체의 인스턴스 필드와 메소드 사용
		System.out.println(b.field1);
		b.method1();
		
		// 로컬 클래스의 정적 필드와 메소드 사용(Java 17부터 허용)
		System.out.println(B.field2);
		B.method2();
	}
}
```

**AExample.java**
```java
package ch09.sec04.exam02;

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
B-생성자 실행
1
B-method1 실행
2
B-method2 실행
```

로컬 변수(생성자 또는 메소드의 매개변수 또는 내부에서 선언된 변수)를 로컬 클래스에서 사용할 경우 로컬 변수는 `final` 특성을 갖게 되므로 값을 읽을 수만 있고 수정할 수 없게 된다. 이것은 로컬 클래스 내부에서 값을 변경하지 못하도록 제한하기 때문이다.

Java 8 이후부터는 명시적으로 `final` 키워드를 붙이지 않아도 되지만, 로컬 변수에 `final` 키워드를 추가해서 final 변수임을 명확히 할 수도 있다. 참고로 Java 7 이전에는 `final` 키워드를 반드시 붙여야 했다.

**A.java**
```java
package ch09.sec04.exam03;

public class A {
	// 메소드
	public void method1(int arg) { // final int arg
		// 로컬 변수
		int var = 1; // final int var = 1;
		
		// 로컬 클래스
		class B {
			// 메소드
			void method2() {
				// 로컬 변수 읽기
				System.out.println("arg: " + arg); // (o)
				System.out.println("var: " + var); // (o)
				
				// 로컬 변수 수정
				// arg = 2; // (x)
				// var = 2; // (x)
			}
		}
		
		// 로컬 객체 생성
		B b = new B();
		// 로컬 객체 메소드 호출
		b.method2();
		
		// 로컬 변수 수정
		// arg = 3; // (x)
		// var = 3; // (x)
	}
}
```
