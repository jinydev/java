---
layout: oop
title: "8.9 인터페이스 상속"
nav_order: 9
parent: "Chapter 08. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 8.9 인터페이스 상속

인터페이스도 다른 인터페이스를 상속할 수 있으며, 클래스와는 달리 다중 상속을 허용한다. 다음과 같이 `extends` 키워드 뒤에 상속할 인터페이스들을 나열하면 된다.

```java
public interface 자식인터페이스 extends 부모인터페이스1, 부모인터페이스2 { ... }
```

자식 인터페이스의 구현 클래스는 자식 인터페이스의 메소드뿐만 아니라 부모 인터페이스의 모든 추상 메소드를 재정의해야 한다. 그리고 구현 객체는 다음과 같이 자식 및 부모 인터페이스 변수에 대입될 수 있다.

```java
자식인터페이스 변수 = new 구현클래스(...);
부모인터페이스1 변수 = new 구현클래스(...);
부모인터페이스2 변수 = new 구현클래스(...);
```

구현 객체가 자식 인터페이스 변수에 대입되면 자식 및 부모 인터페이스의 추상 메소드를 모두 호출할 수 있으나, 부모 인터페이스 변수에 대입되면 부모 인터페이스에 선언된 추상 메소드만 호출 가능하다. 다음 예제를 통해 확인해 보자.

**InterfaceA.java**
```java
package ch08.sec09;

public interface InterfaceA {
	// 추상 메소드
	void methodA();
}
```

**InterfaceB.java**
```java
package ch08.sec09;

public interface InterfaceB {
	// 추상 메소드
	void methodB();
}
```

**InterfaceC.java**
```java
package ch08.sec09;

public interface InterfaceC extends InterfaceA, InterfaceB {
	// 추상 메소드
	void methodC();
}
```

**InterfaceCImpl.java**
```java
package ch08.sec09;

public class InterfaceCImpl implements InterfaceC {
	public void methodA() {
		System.out.println("InterfaceCImpl-methodA() 실행");
	}
	
	public void methodB() {
		System.out.println("InterfaceCImpl-methodB() 실행");
	}
	
	public void methodC() {
		System.out.println("InterfaceCImpl-methodC() 실행");
	}
}
```

**ExtendsExample.java**
```java
package ch08.sec09;

public class ExtendsExample {
	public static void main(String[] args) {
		InterfaceCImpl impl = new InterfaceCImpl();
		
		InterfaceA ia = impl;
		ia.methodA();
		// ia.methodB(); // (x)
		System.out.println();
		
		InterfaceB ib = impl;
		// ib.methodA(); // (x)
		ib.methodB();
		System.out.println();
		
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
```

**실행 결과**
```
InterfaceCImpl-methodA() 실행

InterfaceCImpl-methodB() 실행

InterfaceCImpl-methodA() 실행
InterfaceCImpl-methodB() 실행
InterfaceCImpl-methodC() 실행
```
