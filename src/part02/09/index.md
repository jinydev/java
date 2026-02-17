---
layout: part02
title: Chapter 09. 중첩 선언과 익명 객체

---

# Chapter 09. 중첩 선언과 익명 객체

## 9.1 중첩 클래스

객체지향 프로그램에서는 클래스 간에 서로 긴밀한 관계를 맺고 상호작용한다. 클래스가 여러 클래스와 관계를 맺는 경우에는 독립적으로 선언하는 것이 좋으나, 특정 클래스와만 관계를 맺을 경우에는 중첩 클래스로 선언하는 것이 유지보수에 도움이 되는 경우가 많다.

중첩 클래스(Nested Class)란 클래스 내부에 선언한 클래스를 말하는데, 중첩 클래스를 사용하면 클래스의 멤버를 쉽게 사용할 수 있고 외부에는 중첩 관계 클래스를 감춤으로써 코드의 복잡성을 줄일 수 있다는 장점이 있다.

중첩 클래스는 선언하는 위치에 따라 두 가지로 분류된다. 클래스의 멤버로서 선언되는 중첩 클래스를 멤버 클래스라고 하고, 메소드 내부에서 선언되는 중첩 클래스를 로컬 클래스라고 한다.

| 선언 위치에 따른 분류 |                          | 선언 위치                                       | 객체 생성 조건                                   |
| :-------------------- | :----------------------- | :---------------------------------------------- | :----------------------------------------------- |
| **멤버 클래스**       | **인스턴스 멤버 클래스** | `class A { class B { ... } }`                   | A 객체를 생성해야만 B 객체를 생성할 수 있음      |
|                       | **정적 멤버 클래스**     | `class A { static class B { ... } }`            | A 객체를 생성하지 않아도 B 객체를 생성할 수 있음 |
| **로컬 클래스**       |                          | `class A { void method() { class B { ... } } }` | method가 실행할 때만 B 객체를 생성할 수 있음     |

중첩 클래스도 하나의 클래스이기 때문에 컴파일하면 바이트코드 파일(`.class`)이 별도로 생성된다. 멤버 클래스일 경우 바이트코드 파일의 이름은 다음과 같이 결정된다.

```
A$B.class
(바깥클래스$멤버클래스.class)
```

로컬 클래스일 경우에는 다음과 같이 `$1`이 포함된 바이트코드 파일이 생성된다.

```
A$1B.class
(바깥클래스$1로컬클래스.class)
```

## 9.2 인스턴스 멤버 클래스

인스턴스 멤버 클래스는 다음과 같이 A 클래스의 멤버로 선언된 B 클래스를 말한다.

```java
[public] class A {
    [public | private] class B {
    }
}
```

접근 제한자에 따른 인스턴스 멤버 클래스의 접근 범위는 다음과 같다.

| 구분                 | 접근 범위                                      |
| :------------------- | :--------------------------------------------- |
| `public class B {}`  | 다른 패키지에서 B 클래스를 사용할 수 있다.     |
| `class B {}`         | 같은 패키지에서만 B 클래스를 사용할 수 있다.   |
| `private class B {}` | A 클래스 내부에서만 B 클래스를 사용할 수 있다. |

인스턴스 멤버 클래스 B는 주로 A 클래스 내부에서 사용되므로 `private` 접근 제한을 갖는 것이 일반적이다. B 객체는 A 클래스 내부 어디에서나 생성할 수는 없고, 인스턴스 필드값, 생성자, 인스턴스 메소드에서 생성할 수 있다. A 객체가 있어야 B 객체도 생성할 수 있기 때문이다.

```java
public class A {
    // 인스턴스 멤버 클래스
    class B {}
    
    // 인스턴스 필드값으로 B 객체 대입
    B field = new B();
    
    // 생성자
    A() {
        B b = new B();
    }
    
    // 인스턴스 메소드
    void method() {
        B b = new B();
    }
}
```

B 객체를 A 클래스 외부에 생성하려면 `default` 또는 `public` 접근 제한을 가져야 하고, A 객체를 먼저 생성한 다음 B 객체를 생성해야 한다.

```java
A a = new A();
A.B b = a.new B();
```

**AExample.java**
```java
package ch09.sec02.exam01;

public class AExample {
	public static void main(String[] args) {
		// A 객체 생성
		A a = new A();
		
		// B 객체 생성
		A.B b = a.new B();
	}
}
```

인스턴스 멤버 클래스 B 내부에는 일반 클래스와 같이 필드, 생성자, 메소드 선언이 올 수 있다. 정적 필드와 정적 메소드는 Java 17부터 선언이 가능하다.

**A.java**
```java
package ch09.sec02.exam02;

public class A {
	// 인스턴스 멤버 클래스
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
	
	// 인스턴스 메소드
	void useB() {
		// B 객체 생성 및 인스턴스 필드 및 메소드 사용
		B b = new B();
		System.out.println(b.field1);
		b.method1();
		
		// B 클래스의 정적 필드 및 메소드 사용
		System.out.println(B.field2);
		B.method2();
	}
}
```

**AExample.java**
```java
package ch09.sec02.exam02;

public class AExample {
	public static void main(String[] args) {
		// A 객체 생성
		A a = new A();
		
		// A 인스턴스 메소드 호출
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

## 9.3 정적 멤버 클래스

정적 멤버 클래스는 다음과 같이 `static` 키워드와 함께 A 클래스의 멤버로 선언된 B 클래스를 말한다.

```java
[public] class A {
    [public | private] static class B {
    }
}
```

접근 제한자에 따른 정적 멤버 클래스의 접근 범위는 다음과 같다.

| 구분                        | 접근 범위                                      |
| :-------------------------- | :--------------------------------------------- |
| `public static class B {}`  | 다른 패키지에서 B 클래스를 사용할 수 있다.     |
| `static class B {}`         | 같은 패키지에서만 B 클래스를 사용할 수 있다.   |
| `private static class B {}` | A 클래스 내부에서만 B 클래스를 사용할 수 있다. |

정적 멤버 클래스 B는 A 클래스 내부에서 사용되기도 하지만, A 클래스 외부에서 A와 함께 사용되는 경우가 많기 때문에 주로 `default` 또는 `public` 접근 제한을 가진다. B 객체는 A 클래스 내부 어디든 객체를 생성할 수 있다.

**A.java**
```java
package ch09.sec03.exam01;

public class A {
	// 정적 멤버 클래스
	static class B {}
	
	// 인스턴스 필드값으로 B 객체 대입
	B field1 = new B();
	
	// 정적 필드값으로 B 객체 대입
	static B field2 = new B();
	
	// 생성자
	A() {
		B b = new B();
	}
	
	// 인스턴스 메소드
	void method1() {
		B b = new B();
	}
	
	// 정적 메소드
	static void method2() {
		B b = new B();
	}
}
```

A 클래스 외부에서 B 객체를 생성하려면 A 객체 생성 없이 A 클래스로 접근해서 B 객체를 생성할 수 있다.

```java
A.B b = new A.B();
```

**AExample.java**
```java
package ch09.sec03.exam01;

public class AExample {
	public static void main(String[] args) {
		// B 객체 생성
		A.B b = new A.B();
	}
}
```

정적 멤버 클래스 B 내부에는 일반 클래스와 같이 필드, 생성자, 메소드 선언이 올 수 있다.

**A.java**
```java
package ch09.sec03.exam02;

public class A {
	// 정적 멤버 클래스
	static class B {
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
}
```

**AExample.java**
```java
package ch09.sec03.exam02;

public class AExample {
	public static void main(String[] args) {
		// B 객체 생성 및 인스턴스 필드 및 메소드 사용
		A.B b = new A.B();
		System.out.println(b.field1);
		b.method1();
		
		// B 클래스의 정적 필드 및 메소드 사용
		System.out.println(A.B.field2);
		A.B.method2();
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

## 9.4 로컬 클래스

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

## 9.5 바깥 멤버 접근

중첩 클래스는 바깥 클래스와 긴밀한 관계를 맺으면서 바깥 클래스의 멤버(필드, 메소드)에 접근할 수 있다. 하지만 중첩 클래스가 어떻게 선언되었느냐에 따라 접근 제한이 있을 수 있다.

### 바깥 클래스의 멤버 접근 제한

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

### 바깥 클래스의 객체 접근

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

## 9.6 중첩 인터페이스

중첩 인터페이스는 클래스의 멤버로 선언된 인터페이스를 말한다. 인터페이스를 클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 객체를 만들기 위해서이다. 중첩 인터페이스는 다음과 같이 선언된다.

```java
class A {
    [public | private] [static] interface B {
        // 상수 필드
        // 추상 메소드
        // 디폴트 메소드
        // 정적 메소드
    }
}
```

외부의 접근을 막지 않으려면 `public`을 붙이고, A 클래스 내부에서만 사용하려면 `private`을 붙인다. 접근 제한자를 붙이지 않으면 같은 패키지 안에서만 접근이 가능하다. 그리고 중첩 인터페이스는 암시적으로 `static`이므로 `static`을 생략해도 항상 A 객체 없이 B 인터페이스를 사용할 수 있다.

중첩 인터페이스는 안드로이드와 같은 UI 프로그램에서 이벤트를 처리할 목적으로 많이 활용된다. 예를 들어 버튼을 클릭했을 때 이벤트를 처리할 객체는 중첩 인터페이스를 구현해서 만든다. 다음 예제를 따라 작성하면서 이해해 보자.

**Button.java**
```java
package ch09.sec06.exam01;

public class Button {
	// 정적 중첩 인터페이스
	public static interface ClickListener {
		// 추상 메소드
		void onClick();
	}
}
```

외부에서 접근이 가능하도록 `public`이면서 Button 객체 없이 사용할 수 있는 `static` 중첩 인터페이스로 `ClickListener`를 선언했다. 그리고 추상 메소드인 `onClick()`을 선언했다. `onClick()` 메소드는 버튼이 클릭되었을 때 호출될 메소드이다.

Button 클래스에 `ClickListener` 타입의 필드와 Setter를 추가해서 외부에서 Setter를 통해 `ClickListener` 구현 객체를 필드에 저장할 수 있도록 하자.

**Button.java**
```java
package ch09.sec06.exam02;

public class Button {
	// 정적 멤버 인터페이스
	public static interface ClickListener {
		// 추상 메소드
		void onClick();
	}
	
	// 필드
	private ClickListener clickListener;
	
	// 메소드
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
}
```

Button이 클릭되었을 때 실행할 메소드로 `click()`을 다음과 같이 추가한다. 실행 내용은 `ClickListener` 인터페이스 필드를 이용해서 `onClick()` 추상 메소드를 호출한다.

**Button.java**
```java
package ch09.sec06.exam03;

public class Button {
	// 정적 멤버 인터페이스
	public static interface ClickListener {
		// 추상 메소드
		void onClick();
	}
	
	// 필드
	private ClickListener clickListener;
	
	// 메소드
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		this.clickListener.onClick();
	}
}
```

`clickListener` 필드는 Setter를 통해 제공된 `ClickListener` 구현 객체의 참조를 갖고 있다. 따라서 `onClick()` 메소드를 호출하면 `ClickListener` 구현 객체의 `onClick()` 메소드가 실행된다. 이제 버튼을 이용하는 실행 클래스를 작성해 보자.

**ButtonExample.java**
```java
package ch09.sec06.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		// Ok 버튼 객체 생성
		Button btnOk = new Button();
		
		// Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class OkListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		}
		
		// Ok 버튼 객체에 ClickListener 구현 객체 주입
		btnOk.setClickListener(new OkListener());
		
		// Ok 버튼 클릭하기
		btnOk.click();
		
		// Cancel 버튼 객체 생성
		Button btnCancel = new Button();
		
		// Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class CancelListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		}
		
		// Cancel 버튼 객체에 ClickListener 구현 객체 주입
		btnCancel.setClickListener(new CancelListener());
		
		// Cancel 버튼 클릭하기
		btnCancel.click();
	}
}
```

**실행 결과**
```
Ok 버튼을 클릭했습니다.
Cancel 버튼을 클릭했습니다.
```

## 9.7 익명 객체

익명(Anonymous) 객체는 이름이 없는 객체를 말한다. 명시적으로 클래스를 선언하지 않기 때문에 쉽게 객체를 생성할 수 있다는 장점이 있다. 익명 객체는 필드값, 로컬 변수값, 매개변수값으로 주로 사용된다.

익명 객체는 클래스를 상속하거나 인터페이스를 구현해야만 생성할 수 있다. 클래스를 상속해서 만들 경우 익명 자식 객체라고 하고, 인터페이스를 구현해서 만들 경우 익명 구현 객체라고 한다.

### 익명 자식 객체

익명 자식 객체는 부모 클래스를 상속받아 다음과 같이 생성된다. 이렇게 생성된 객체는 부모 타입의 필드, 로컬 변수, 매개변수의 값으로 대입할 수 있다.

```java
new 부모생성자(매개값, ...) {
    // 필드
    // 메소드
}
```

중괄호 블록 안의 필드와 메소드는 익명 자식 객체가 가져야 할 멤버로, 중괄호 블록 안에서만 사용할 수 있다. 익명 자식 객체는 부모 타입에 대입되므로 부모 타입에 선언된 멤버만 접근할 수 있기 때문이다. 중괄호 블록 안에는 주로 부모 메소드를 재정의하는 코드가 온다.

다음 예제는 `Tire` 클래스의 익명 자식 객체를 생성해서 필드, 로컬 변수, 매개변수의 값으로 사용하는 방법을 보여 준다. `Tire` 클래스는 `roll()` 메소드를 가지고 있지만, 익명 자식 객체는 `roll()`을 재정의해 실행 내용을 변경한다(다형성).

**Tire.java**
```java
package ch09.sec07.exam01;

public class Tire {
	public void roll() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}
```

**Car.java**
```java
package ch09.sec07.exam01;

public class Car {
	// 필드에 Tire 객체 대입
	private Tire tire1 = new Tire();
	
	// 필드에 익명 자식 객체 대입
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("익명 자식 Tire 객체 1이 굴러갑니다.");
		}
	};
	
	// 메소드(필드 이용)
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	// 메소드(로컬 변수 이용)
	public void run2() {
		// 로컬 변수에 익명 자식 객체 대입
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 Tire 객체 2가 굴러갑니다.");
			}
		};
		tire.roll();
	}
	
	// 메소드(매개변수 이용)
	public void run3(Tire tire) {
		tire.roll();
	}
}
```

**CarExample.java**
```java
package ch09.sec07.exam01;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car car = new Car();
		
		// 익명 자식 객체가 대입된 필드 사용
		car.run1();
		
		// 익명 자식 객체가 대입된 로컬 변수 사용
		car.run2();
		
		// 익명 자식 객체가 대입된 매개변수 사용
		car.run3(new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 Tire 객체 3이 굴러갑니다.");
			}
		});
	}
}
```

**실행 결과**
```
일반 타이어가 굴러갑니다.
익명 자식 Tire 객체 1이 굴러갑니다.
익명 자식 Tire 객체 2가 굴러갑니다.
익명 자식 Tire 객체 3이 굴러갑니다.
```

익명 자식 객체가 부모 타입에 대입되면 부모 메소드 `roll()`을 호출할 경우, 재정의된 익명 자식 객체의 `roll()` 메소드가 실행되는 것을 볼 수 있다(다형성).

### 익명 구현 객체

익명 구현 객체는 인터페이스를 구현해서 다음과 같이 생성된다. 이렇게 생성된 객체는 인터페이스 타입의 필드, 로컬 변수, 매개변수의 값으로 대입할 수 있다. 익명 구현 객체는 안드로이드와 같은 UI 프로그램에서 이벤트를 처리하는 객체로 많이 사용된다.

```java
new 인터페이스() {
    // 필드
    // 메소드
}
```

중괄호 블록 안의 필드와 메소드는 익명 구현 객체가 가져야 할 멤버로, 중괄호 블록 안에서만 사용할 수 있다. 그 이유는 익명 구현 객체는 인터페이스 타입에 대입되므로 인터페이스 타입에 선언된 멤버만 접근할 수 있기 때문이다. 중괄호 블록 안에는 주로 인터페이스의 추상 메소드를 재정의하는 코드가 온다.

다음 예제는 `RemoteControl` 인터페이스의 익명 구현 객체를 생성해서 필드, 로컬 변수, 매개변수 값으로 사용하는 방법을 보여 준다. 익명 구현 객체는 `turnOn()` 메소드를 재정의해서 실행 내용을 가지고 있다(다형성).

**RemoteControl.java**
```java
package ch09.sec07.exam02;

public interface RemoteControl {
	// 추상 메소드
	void turnOn();
	void turnOff();
}
```

**Home.java**
```java
package ch09.sec07.exam02;

public class Home {
	// 필드에 익명 구현 객체 대입
	private RemoteControl rc = new RemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다.");
		}
		
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다.");
		}
	};
	
	// 메소드(필드 이용)
	public void use1() {
		rc.turnOn();
		rc.turnOff();
	}
	
	// 메소드(로컬 변수 이용)
	public void use2() {
		// 로컬 변수에 익명 구현 객체 대입
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("에어컨을 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("에어컨을 끕니다.");
			}
		};
		rc.turnOn();
		rc.turnOff();
	}
	
	// 메소드(매개변수 이용)
	public void use3(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
```

**HomeExample.java**
```java
package ch09.sec07.exam02;

public class HomeExample {
	public static void main(String[] args) {
		// Home 객체 생성
		Home home = new Home();
		
		// 익명 구현 객체가 대입된 필드 사용
		home.use1();
		
		// 익명 구현 객체가 대입된 로컬 변수 사용
		home.use2();
		
		// 익명 구현 객체가 대입된 매개변수 사용
		home.use3(new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("난방을 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("난방을 끕니다.");
			}
		});
	}
}
```

**실행 결과**
```
TV를 켭니다.
TV를 끕니다.
에어컨을 켭니다.
에어컨을 끕니다.
난방을 켭니다.
난방을 끕니다.
```

다음 예제는 9.6 중첩 인터페이스의 예제를 수정한 것으로, 버튼 이벤트 처리 객체를 익명 구현 객체로 대체한 것이다. Setter를 호출할 때 매개값으로 `ClickListener` 익명 구현 객체를 대입했다. 명시적인 구현 클래스를 생성하지 않기 때문에 코드가 간결해진 것을 볼 수 있다.

**ButtonExample.java**
```java
package ch09.sec07.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		// Ok 버튼 객체 생성
		Button btnOk = new Button();
		
		// Ok 버튼 객체에 ClickListener 구현 객체 주입
		btnOk.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		});
		
		// Ok 버튼 클릭하기
		btnOk.click();
		
		// Cancel 버튼 객체 생성
		Button btnCancel = new Button();
		
		// Cancel 버튼 객체에 ClickListener 구현 객체 주입
		btnCancel.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		});
		
		// Cancel 버튼 클릭하기
		btnCancel.click();
	}
}
```

## 확인문제

1. 중첩 멤버 클래스에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 인스턴스 멤버 클래스는 바깥 클래스의 객체가 있어야 사용될 수 있다.
   - ② 정적 멤버 클래스는 바깥 클래스의 객체가 없어도 사용될 수 있다.
   - ③ 인스턴스 멤버 클래스 내부에는 바깥 클래스의 모든 필드와 메소드를 사용할 수 있다.
   - ④ 정적 멤버 클래스 내부에는 바깥 클래스의 인스턴스 필드를 사용할 수 있다.

   **정답:** ④ (정적 멤버 클래스에서는 바깥 클래스의 정적 필드와 정적 메소드만 사용할 수 있다.)

2. 로컬 클래스에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 로컬 클래스는 메소드 내부에 선언된 클래스를 말한다.
   - ② 로컬 클래스는 바깥 클래스의 필드와 메소드를 사용할 수 있다.
   - ③ 로컬 클래스는 `static` 키워드를 이용해서 정적 클래스로 만들 수 있다.
   - ④ `final` 특성을 가진 매개변수나 로컬 변수만 로컬 클래스 내부에서 사용할 수 있다.

   **정답:** ③ (로컬 클래스는 `static`을 붙일 수 없다.)

3. 익명 객체에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 익명 객체는 클래스를 상속하거나 인터페이스를 구현해야만 생성될 수 있다.
   - ② 익명 객체는 필드, 매개변수, 로컬 변수의 초기값으로 주로 사용된다.
   - ③ 익명 객체에는 생성자를 선언할 수 있다.
   - ④ 익명 객체는 주로 재정의된 메소드를 멤버로 가진다.

   **정답:** ③ (익명 객체는 클래스 이름이 없으므로 생성자를 선언할 수 없다.)

4. 다음과 같이 `Car` 클래스 내부에 `Tire`와 `Engine` 클래스가 멤버로 선언되어 있습니다. `CarExample` 클래스에서 `Tire`와 `Engine` 객체를 생성하는 코드를 작성해 보세요.

```java
public class Car {
    class Tire {}
    static class Engine {}
}

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        
        Car.Tire tire = myCar.new Tire();
        Car.Engine engine = new Car.Engine();
    }
}
```

5. `Action` 인터페이스는 다음과 같이 `work()` 추상 메소드를 가지고 있습니다. `ActionExample` 클래스의 `main()` 메소드에서 `Action`의 익명 구현 객체를 만들어 실행 결과와 동일하게 나오도록 박스 안에 들어갈 코드를 작성해 보세요.

```java
public interface Action {
    public void work();
}

public class ActionExample {
    public static void main(String[] args) {
        Action action = new Action() {
            @Override
            public void work() {
                System.out.println("복사를 합니다.");
            }
        };
        action.work();
    }
}
```

**실행 결과**
```
복사를 합니다.
```

6. `AnonymousExample` 클래스의 실행 결과를 보고, `Vehicle` 인터페이스의 익명 구현 객체를 필드와 로컬 변수의 초기값 그리고 메소드의 매개값으로 대입해 보세요.

```java
public interface Vehicle {
	public void run();
}

public class Anonymous {
	Vehicle field = new Vehicle() {
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};
	
	void method1() {
		Vehicle localVar = new Vehicle() {
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}
}

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		anony.method2(new Vehicle() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}
}
```

**실행 결과**
```
자전거가 달립니다.
승용차가 달립니다.
트럭이 달립니다.
```

7. 다음 `Chatting` 클래스는 컴파일 에러가 발생합니다. 원인을 설명해 보세요.

```java
public class Chatting {
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
	
	void startChat(String chatId) {
		String nickName = null;
		nickName = chatId;
		
		Chat chat = new Chat() {
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "] " + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}
}
```

**정답:**
`startChat()` 메소드의 로컬 변수 `nickName`은 `chatId`로 초기화된 후 `Chat` 익명 자식 객체의 `start()` 메소드 내부에서 사용되고 있다. 로컬 클래스나 익명 객체 내부에서 사용되는 로컬 변수는 `final` 특성을 가져야 하므로 값을 수정할 수 없다. 하지만 13라인(`nickName = chatId;`)에서 값을 변경하고 있기 때문에 컴파일 에러가 발생한다. `nickName`을 `final`로 선언하거나, 초기화 이후 수정하지 말아야 한다. 또는 `chatId` 매개변수 자체를 직접 사용해도 된다(Java 8부터 `final` 생략 가능).

수정 예시:
```java
void startChat(String chatId) {
    // nickName을 사용하지 않고 chatId를 바로 사용하거나
    // nickName = chatId; 구문을 제거하고 선언 시 초기화
    String nickName = chatId; 
    
    Chat chat = new Chat() {
        @Override
        public void start() {
            while (true) {
                String inputData = "안녕하세요";
                String message = "[" + nickName + "] " + inputData;
                sendMessage(message);
            }
        }
    };
    chat.start();
}
```

