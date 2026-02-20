---
layout: oop
title: "8.5 디폴트 메소드"
nav_order: 5
parent: "Chapter 08. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 8.5 디폴트 메소드

인터페이스에는 완전한 실행 코드를 가진 디폴트 메소드를 선언할 수 있다. 추상 메소드는 실행부(중괄호)가 없지만, 디폴트 메소드는 실행부가 있다. 선언 방법은 클래스 메소드와 동일한데, 차이점은 `default` 키워드가 리턴 타입 앞에 붙는다.

```java
[public] default 리턴타입 메소드명(매개변수, ...) { ... }
```

디폴트 메소드의 실행부에는 상수 필드를 읽거나 추상 메소드를 호출하는 코드를 작성할 수 있다. `RemoteControl` 인터페이스에서 무음 처리 기능을 제공하는 `setMute()` 디폴트 메소드를 선언해 보자.

**RemoteControl.java**
```java
package ch08.sec05;

public interface RemoteControl {
	// 상수 필드
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 인스턴스 메소드
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리합니다.");
			// 추상 메소드 호출하면서 상수 필드 사용
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
}
```

디폴트 메소드는 구현 객체가 필요한 메소드이다. 따라서 `RemoteControl`의 `setMute()` 메소드를 호출하려면 구현 객체인 `Television` 객체를 다음과 같이 인터페이스 변수에 대입하고 나서 `setMute()`를 호출해야 한다.

**RemoteControlExample.java**
```java
package ch08.sec05;

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
	}
}
```

**실행 결과**
```
TV를 켭니다.
현재 TV 볼륨: 5
무음 처리합니다.
현재 TV 볼륨: 0
무음 해제합니다.

Audio를 켭니다.
현재 Audio 볼륨: 5
무음 처리합니다.
현재 Audio 볼륨: 0
무음 해제합니다.
```

구현 클래스는 디폴트 메소드를 재정의해서 자신에게 맞게 수정할 수도 있다. 재정의 시 주의할 점은 `public` 접근 제한자를 반드시 붙여야 하고, `default` 키워드를 생략해야 한다. `Audio` 구현 클래스에서 `setMute()` 메소드를 재정의해 원래 볼륨으로 복원해 보자.

**Audio.java**
```java
package ch08.sec05;

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
	
	// 필드
	private int memoryVolume;
	
	// 디폴트 메소드 재정의
	@Override
	public void setMute(boolean mute) {
		if (mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음 처리합니다.");
			setVolume(RemoteControl.MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
			setVolume(this.memoryVolume);
		}
	}
}
```

**RemoteControlExample.java** (실행 결과)
```
...
Audio를 켭니다.
현재 Audio 볼륨: 5
무음 처리합니다.
현재 Audio 볼륨: 0
무음 해제합니다.
현재 Audio 볼륨: 5
```
