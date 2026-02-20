---
layout: oop
title: "8.4 추상 메소드"
nav_order: 4
parent: "Chapter 08. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 8.4 추상 메소드

인터페이스는 구현 클래스가 재정의해야 하는 `public` 추상 메소드(abstract method)를 멤버로 가질 수 있다. 추상 메소드는 리턴 타입, 메소드명, 매개변수만 기술되고 중괄호 `{}`를 붙이지 않는 메소드를 말한다. `public abstract`를 생략하더라도 컴파일 과정에서 자동으로 붙게 된다.

```java
[public abstract] 리턴타입 메소드명(매개변수, ...);
```

추상 메소드는 객체 A가 인터페이스를 통해 어떻게 메소드를 호출할 수 있는지 방법을 알려주는 역할을 한다. 인터페이스 구현 객체 B는 추상 메소드의 실행부를 갖는 재정의된 메소드가 있어야 한다.

`RemoteControl` 인터페이스에서 `turnOn()`, `turnOff()`, `setVolume()` 추상 메소드를 각각 선언해 보자.

**RemoteControl.java**
```java
package ch08.sec04;

public interface RemoteControl {
	// 상수 필드
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}
```

`RemoteControl` 인터페이스를 통해서 다음과 같이 구현 객체인 `Television`과 `Audio`를 사용한다고 가정해 보자.

구현 클래스인 `Television`과 `Audio`는 인터페이스에 선언된 모든 추상 메소드를 재정의해서 실행 코드를 가져야 한다. 다음과 같이 `Television`과 `Audio` 구현 클래스를 선언해 보자.

**Television.java**
```java
package ch08.sec04;

public class Television implements RemoteControl {
	// 필드
	private int volume;
	
	// turnOn() 추상 메소드 오버라이딩
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	
	// turnOff() 추상 메소드 오버라이딩
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	
	// setVolume() 추상 메소드 오버라이딩
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨: " + this.volume);
	}
}
```

**Audio.java**
```java
package ch08.sec04;

public class Audio implements RemoteControl {
	// 필드
	private int volume;
	
	// turnOn() 추상 메소드 오버라이딩
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	
	// turnOff() 추상 메소드 오버라이딩
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	
	// setVolume() 추상 메소드 오버라이딩
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}
}
```

구현 클래스에서 추상 메소드를 재정의할 때 주의할 점은 인터페이스의 추상 메소드는 기본적으로 `public` 접근 제한을 갖기 때문에 `public`보다 더 낮은 접근 제한으로 재정의할 수 없다. 그래서 재정의되는 메소드에는 모두 `public`이 추가되어 있다.

인터페이스로 구현 객체를 사용하려면 다음과 같이 인터페이스 변수를 선언하고 구현 객체를 대입해야 한다. 인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입되면 구현 객체의 번지를 저장한다.

```java
RemoteControl rc;
rc = new Television();
rc = new Audio();
```

구현 객체가 대입되면 인터페이스 변수로 추상 메소드를 호출할 수 있게 된다. 이때 어떤 구현 객체가 대입되었는지에 따라 실행 내용이 달라진다. `Television`이 대입되었다면 `Television`의 재정의된 메소드가, `Audio`가 대입되었다면 `Audio`의 재정의된 메소드가 실행된다.

**RemoteControlExample.java**
```java
package ch08.sec04;

public class RemoteControlExample {
	public static void main(String[] args) {
		// 인터페이스 변수 선언
		RemoteControl rc;
		
		// Television 객체를 생성하고 인터페이스 변수에 대입
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		// Audio 객체를 생성하고 인터페이스 변수에 대입
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
	}
}
```

**실행 결과**
```
TV를 켭니다.
현재 TV 볼륨: 5
TV를 끕니다.
Audio를 켭니다.
현재 Audio 볼륨: 5
Audio를 끕니다.
```
