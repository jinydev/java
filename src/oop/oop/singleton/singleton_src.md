---
layout: oop
title: "6.15 싱글톤 패턴"
nav_order: 15
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.15 싱글톤 패턴

애플리케이션 전체에서 단 한 개의 객체만 생성해서 사용하고 싶다면 싱글톤(`Singleton`) 패턴을 적용할 수 있다. 싱글톤 패턴의 핵심은 생성자를 `private` 접근 제한해 외부에서 `new` 연산자로 생성자를 호출할 수 없도록 막는 것이다.

```java
private 클래스() {}
```

생성자를 호출할 수 없으니 외부에서 마음대로 객체를 생성하는 것이 불가능해진다. 대신 싱글톤 패턴이 제공하는 정적 메소드를 통해 간접적으로 객체를 얻을 수 있다.

다음은 싱글톤 패턴의 전체 코드를 보여 준다.

```java
public class 클래스 {
    // private 접근 권한을 갖는 정적 필드 선언과 초기화
    private static 클래스 singleton = new 클래스();
    
    // private 접근 권한을 갖는 생성자 선언
    private 클래스() {}
    
    // public 접근 권한을 갖는 정적 메소드 선언
    public static 클래스 getInstance() {
        return singleton;
    }
}
```

외부에서 객체를 얻는 유일한 방법은 `getInstance()` 메소드를 호출하는 것이다. `getInstance()` 메소드가 리턴하는 객체는 정적 필드가 참조하는 싱글톤 객체이다. 따라서 아래 코드에서 변수1과 변수2가 참조하는 객체는 동일한 객체가 된다.

```java
클래스 변수1 = 클래스.getInstance();
클래스 변수2 = 클래스.getInstance();
```

**Singleton.java**
```java
package ch06.sec15;

public class Singleton {
	// private 접근 권한을 갖는 정적 필드 선언과 초기화
	private static Singleton singleton = new Singleton();
	
	// private 접근 권한을 갖는 생성자 선언
	private Singleton() {
	}
	
	// public 접근 권한을 갖는 정적 메소드 선언
	public static Singleton getInstance() {
		return singleton;
	}
}
```

**SingletonExample.java**
```java
package ch06.sec15;

public class SingletonExample {
	public static void main(String[] args) {
		/*
		Singleton obj1 = new Singleton(); // 컴파일 에러
		Singleton obj2 = new Singleton(); // 컴파일 에러
		*/
		
		// 정적 메소드를 호출해서 싱글톤 객체 얻음
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		// 동일한 객체를 참조하는지 확인
		if (obj1 == obj2) {
			System.out.println("같은 Singleton 객체입니다.");
		} else {
			System.out.println("다른 Singleton 객체입니다.");
		}
	}
}
```

**실행 결과**
```
같은 Singleton 객체입니다.
```
