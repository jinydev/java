---
layout: oop
title: "7.2 클래스 상속"
nav_order: 2
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.2 클래스 상속

현실에서의 상속은 부모가 자식을 선택해서 물려주지만, 프로그램에서는 자식이 부모를 선택한다. 자식 클래스를 선언할 때 어떤 부모로부터 상속받을 것인지를 결정하고, 부모 클래스를 다음과 같이 extends 뒤에 기술한다.

```java
public class 자식클래스 extends 부모클래스 {
}
```

다른 언어와는 달리 자바는 다중 상속을 허용하지 않는다. 즉, 여러 개의 부모 클래스를 상속할 수 없다. 따라서 extends 뒤에는 단 하나의 부모 클래스만이 와야 한다.

```java
public class 자식클래스 extends 부모클래스1, 부모클래스2 { // x
}
```

다음 예제는 Phone 클래스를 상속해서 SmartPhone 클래스를 작성한 것이다.

**Phone.java**
```java
package ch07.sec02;

public class Phone {
	// 필드 선언
	public String model;
	public String color;
	
	// 메소드 선언
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
```

**SmartPhone.java**
```java
package ch07.sec02;

public class SmartPhone extends Phone {
	// 필드 선언
	public boolean wifi;
	
	// 생성자 선언
	public SmartPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	// 메소드 선언
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}
```

**SmartPhoneExample.java**
```java
package ch07.sec02;

public class SmartPhoneExample {
	public static void main(String[] args) {
		// SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// Phone으로부터 상속받은 필드 읽기
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
		
		// SmartPhone의 필드 읽기
		System.out.println("와이파이 상태: " + myPhone.wifi);
		
		// Phone으로부터 상속받은 메소드 호출
		myPhone.bell();
		myPhone.sendVoice("여보세요.");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		myPhone.sendVoice("아~ 네. 반갑습니다.");
		myPhone.hangUp();
		
		// SmartPhone의 메소드 호출
		myPhone.setWifi(true);
		myPhone.internet();
	}
}
```

**실행 결과**
```
모델: 갤럭시
색상: 은색
와이파이 상태: false
벨이 울립니다.
자기: 여보세요.
상대방: 안녕하세요! 저는 홍길동인데요.
자기: 아~ 네. 반갑습니다.
전화를 끊습니다.
와이파이 상태를 변경했습니다.
인터넷에 연결합니다.
```
