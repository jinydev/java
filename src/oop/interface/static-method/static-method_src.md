---
layout: oop
title: "8.6 정적 메소드"
nav_order: 6
parent: "Chapter 08. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 8.6 정적 메소드

인터페이스에는 정적 메소드도 선언이 가능하다. 추상 메소드와 디폴트 메소드는 구현 객체가 필요하지만, 정적 메소드는 구현 객체가 없어도 인터페이스만으로 호출할 수 있다. 선언 방법은 클래스 정적 메소드와 완전 동일하다. 단, `public`을 생략하더라도 자동으로 컴파일 과정에서 붙는 것이 차이점이다.

```java
[public | private] static 리턴타입 메소드명(매개변수, ...) { ... }
```

`RemoteControl` 인터페이스에서 배터리를 교환하는 기능을 가진 `changeBattery()` 정적 메소드를 선언해 보자.

**RemoteControl.java**
```java
package ch08.sec06;

public interface RemoteControl {
	// 상수 필드
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 메소드
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	// 정적 메소드
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
}
```

인터페이스에 선언된 정적 메소드는 구현 객체 없이 인터페이스명으로 접근해서 호출할 수 있다. 따라서 `RemoteControl`의 `changeBattery()` 메소드는 `RemoteControl.changeBattery()`로 호출할 수 있다.

**RemoteControlExample.java**
```java
package ch08.sec06;

public class RemoteControlExample {
	public static void main(String[] args) {
		// 인터페이스 변수 선언
		RemoteControl rc;
		
		// Television 객체를 생성하고 인터페이스 변수에 대입
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		
		// 디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		System.out.println();
		
		// Audio 객체를 생성하고 인터페이스 변수에 대입
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		
		// 디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		System.out.println();
		
		// 정적 메소드 호출
		RemoteControl.changeBattery();
	}
}
```

**실행 결과**
```
...
리모콘 건전지를 교환합니다.
```

정적 메소드의 실행부(중괄호)를 작성할 때 주의할 점은 상수 필드를 제외한 추상 메소드, 디폴트 메소드, `private` 메소드 등을 호출할 수 없다는 것이다. 이 메소드는 구현 객체가 필요한 인스턴스 메소드이기 때문이다.
