---
layout: oop
title: "7.11 봉인된 클래스"
nav_order: 11
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.11 봉인된 클래스

기본적으로 `final` 클래스를 제외한 모든 클래스는 부모 클래스가 될 수 있다. 그러나 Java 15부터는 무분별한 자식 클래스 생성을 방지하기 위해 봉인된(`sealed`) 클래스가 도입되었다.

다음과 같이 `Person`의 자식 클래스는 `Employee`와 `Manager`만 가능하고, 그 이외는 자식 클래스가 될 수 없도록 `Person`을 봉인된 클래스로 선언할 수 있다.

```java
public sealed class Person permits Employee, Manager { ... }
```

`sealed` 키워드를 사용하면 `permits` 키워드 뒤에 상속 가능한 자식 클래스를 지정해야 한다. 봉인된 `Person` 클래스를 상속하는 `Employee`와 `Manager`는 `final` 또는 `non-sealed` 키워드로 다음과 같이 선언하거나, `sealed` 키워드를 사용해서 또 다른 봉인 클래스로 선언해야 한다.

```java
public final class Employee extends Person { ... }
public non-sealed class Manager extends Person { ... }
```

`final`은 더 이상 상속할 수 없다는 뜻이고, `non-sealed`는 봉인을 해제한다는 뜻이다. 따라서 `Employee`는 더 이상 자식 클래스를 만들 수 없지만 `Manager`는 다음과 같이 자식 클래스를 만들 수 있다.

```java
public class Director extends Manager { ... }
```

설명한 내용을 실습으로 확인해 보자.

**Person.java**
```java
package ch07.sec11;

public sealed class Person permits Employee, Manager {
	// 필드
	public String name;
	
	// 메소드
	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
}
```

**Employee.java**
```java
package ch07.sec11;

public final class Employee extends Person {
	@Override
	public void work() {
		System.out.println("제품을 생산합니다.");
	}
}
```

**Manager.java**
```java
package ch07.sec11;

public non-sealed class Manager extends Person {
	@Override
	public void work() {
		System.out.println("생산 관리를 합니다.");
	}
}
```

**Director.java**
```java
package ch07.sec11;

public class Director extends Manager {
	@Override
	public void work() {
		System.out.println("제품을 기획합니다.");
	}
}
```

**SealedExample.java**
```java
package ch07.sec11;

public class SealedExample {
	public static void main(String[] args) {
		Person p = new Person();
		Employee e = new Employee();
		Manager m = new Manager();
		Director d = new Director();
		
		p.work();
		e.work();
		m.work();
		d.work();
	}
}
```

**실행 결과**
```
하는 일이 결정되지 않았습니다.
제품을 생산합니다.
생산 관리를 합니다.
제품을 기획합니다.
```
