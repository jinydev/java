---
layout: oop
title: "7.3 부모 생성자 호출"
nav_order: 3
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.3 부모 생성자 호출

현실에서 부모 없는 자식이 있을 수 없듯이 자바에서도 자식 객체를 생성하면 부모 객체가 먼저 생성된 다음에 자식 객체가 생성된다. 다음 코드는 SmartPhone 객체만 생성되는 것처럼 보이지만, 사실은 부모인 Phone 객체가 먼저 생성되고 그 다음에 자식인 SmartPhone 객체가 생성된 것이다.

```java
자식클래스 변수 = new 자식클래스();
```

모든 객체는 생성자를 호출해야만 생성된다. 부모 객체도 예외는 아니다. 그렇다면 부모 객체의 생성자는 어디서 호출된 것일까? 이것에 대한 비밀은 자식 생성자에 숨어 있다. 부모 생성자는 자식 생성자의 맨 첫 줄에 숨겨져 있는 super()에 의해 호출된다.

```java
// 자식 생성자 선언
public 자식클래스(...) {
    super();
}
```

super()는 컴파일 과정에서 자동 추가되는데, 이것은 부모의 기본 생성자를 호출한다. 만약 부모 클래스에 기본 생성자가 없다면 자식 생성자 선언에서 컴파일 에러가 발생한다.

부모 클래스에 기본 생성자가 없고 매개변수를 갖는 생성자만 있다면 개발자는 다음과 같이 super(매개값, ...) 코드를 직접 넣어야 한다. 이 코드는 매개값의 타입과 개수가 일치하는 부모 생성자를 호출한다.

```java
// 자식 생성자 선언
public 자식클래스(...) {
    super(매개값, ...);
}
```

다음 예제는 부모 클래스가 기본 생성자를 가지고 있는 경우이다.

**Phone.java**
```java
package ch07.sec03.exam01;

public class Phone {
	// 필드 선언
	public String model;
	public String color;
	
	// 기본 생성자 선언
	public Phone() {
		System.out.println("Phone() 생성자 실행");
	}
}
```

**SmartPhone.java**
```java
package ch07.sec03.exam01;

public class SmartPhone extends Phone {
	// 자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(); // 생략 가능(컴파일 시 자동 추가됨)
		this.model = model;
		this.color = color;
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
```

**SmartPhoneExample.java**
```java
package ch07.sec03.exam01;

public class SmartPhoneExample {
	public static void main(String[] args) {
		// SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// Phone으로부터 상속받은 필드 읽기
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
	}
}
```

**실행 결과**
```
Phone() 생성자 실행
SmartPhone(String model, String color) 생성자 실행됨
모델: 갤럭시
색상: 은색
```

다음 예제는 부모 클래스가 매개변수를 갖는 생성자가 있는 경우이다.

**Phone.java**
```java
package ch07.sec03.exam02;

public class Phone {
	// 필드 선언
	public String model;
	public String color;
	
	// 매개변수를 갖는 생성자 선언
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("Phone(String model, String color) 생성자 실행");
	}
}
```

**SmartPhone.java**
```java
package ch07.sec03.exam02;

public class SmartPhone extends Phone {
	// 자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(model, color); // 반드시 작성해야 함
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
```

**SmartPhoneExample.java**
```java
package ch07.sec03.exam02;

public class SmartPhoneExample {
	public static void main(String[] args) {
		// SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// Phone으로부터 상속받은 필드 읽기
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
	}
}
```

**실행 결과**
```
Phone(String model, String color) 생성자 실행
SmartPhone(String model, String color) 생성자 실행됨
모델: 갤럭시
색상: 은색
```
