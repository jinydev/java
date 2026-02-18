---
layout: oop
title: "8.13 봉인된 인터페이스"
nav_order: 13
parent: "Chapter 08. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 8.13 봉인된 인터페이스

Java 15부터는 무분별한 자식 인터페이스 생성을 방지하기 위해 봉인된(sealed) 인터페이스를 사용할 수 있다. `InterfaceA`의 자식 인터페이스는 `InterfaceB`만 가능하고, 그 이외는 자식 인터페이스가 될 수 없도록 다음과 같이 `InterfaceA`를 봉인된 인터페이스로 선언할 수 있다.

```java
public sealed interface InterfaceA permits InterfaceB { ... }
```

`sealed` 키워드를 사용하면 `permits` 키워드 뒤에 상속 가능한 자식 인터페이스를 지정해야 한다. 봉인된 `InterfaceA`를 상속하는 `InterfaceB`는 `non-sealed` 키워드로 다음과 같이 선언하거나, `sealed` 키워드를 사용해서 또 다른 봉인 인터페이스로 선언해야 한다.

```java
public non-sealed interface InterfaceB extends InterfaceA { ... }
```

`non-sealed`는 봉인을 해제한다는 뜻이다. 따라서 `InterfaceB`는 다른 자식 인터페이스를 만들 수 있다.

```java
public interface InterfaceC extends InterfaceB { ... }
```

설명한 내용을 실습으로 확인해 보자.

**InterfaceA.java**
```java
package ch08.sec13;

public sealed interface InterfaceA permits InterfaceB {
	void methodA();
}
```

**InterfaceB.java**
```java
package ch08.sec13;

public non-sealed interface InterfaceB extends InterfaceA {
	void methodB();
}
```

**InterfaceC.java**
```java
package ch08.sec13;

public interface InterfaceC extends InterfaceB {
	void methodC();
}
```

**ImplClass.java**
```java
package ch08.sec13;

public class ImplClass implements InterfaceC {
	public void methodA() {
		System.out.println("methodA() 실행");
	}
	
	public void methodB() {
		System.out.println("methodB() 실행");
	}
	
	@Override
	public void methodC() {
		System.out.println("methodC() 실행");
	}
}
```

**SealedExample.java**
```java
package ch08.sec13;

public class SealedExample {
	public static void main(String[] args) {
		ImplClass impl = new ImplClass();
		
		InterfaceA ia = impl;
		ia.methodA();
		System.out.println();
		
		InterfaceB ib = impl;
		ib.methodA();
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
methodA() 실행

methodA() 실행
methodB() 실행

methodA() 실행
methodB() 실행
methodC() 실행
```
