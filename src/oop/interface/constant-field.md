---
layout: oop
title: "8.3 상수 필드"
nav_order: 3
parent: "Chapter 08. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 8.3 상수 필드

인터페이스는 `public static final` 특성을 갖는 불변의 상수 필드를 멤버로 가질 수 있다.

```java
[public static final] 타입 상수명 = 값;
```

인터페이스에 선언된 필드는 모두 `public static final` 특성을 갖기 때문에 `public static final`을 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다. 상수명은 대문자로 작성하되, 서로 다른 단어로 구성되어 있을 경우에는 언더바(`_`)로 연결하는 것이 관례이다.

다음과 같이 `RemoteControl` 인터페이스에 `MAX_VOLUME`과 `MIN_VOLUME` 상수를 선언해 보자.

**RemoteControl.java**
```java
package ch08.sec03;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
}
```

상수는 구현 객체와 관련 없는 인터페이스 소속 멤버이므로 다음과 같이 인터페이스로 바로 접근해서 상수값을 읽을 수 있다.

**RemoteControlExample.java**
```java
package ch08.sec03;

public class RemoteControlExample {
	public static void main(String[] args) {
		System.out.println("리모콘 최대 볼륨: " + RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최저 볼륨: " + RemoteControl.MIN_VOLUME);
	}
}
```
