---
layout: part03
title: "14.4 스레드 이름"
nav_order: 4
parent: "Chapter 20. 멀티 스레드"
grand_parent: "라이브러리 활용"
---

# 14.4 스레드 이름

스레드는 자신의 이름을 가지고 있다. 메인 스레드는 'main'이라는 이름을 가지고 있고, 작업 스레드는 자동적으로 'Thread-n'이라는 이름을 가진다. 작업 스레드의 이름을 Thread-n 대신 다른 이름으로 설정하고 싶다면 Thread 클래스의 setName() 메소드를 사용하면 된다.

```java
thread.setName("스레드 이름");
```

스레드 이름은 디버깅할 때 어떤 스레드가 작업을 하는지 조사할 목적으로 주로 사용된다. 현재 코드를 어떤 스레드가 실행하고 있는지 확인하려면 정적 메소드인 currentThread()로 스레드 객체의 참조를 얻은 다음 getName() 메소드로 이름을 출력해보면 된다.

```java
Thread thread = Thread.currentThread();
System.out.println(thread.getName());
```

다음은 현재 실행 중인 스레드의 참조를 얻어 이름을 콘솔에 출력하고, 작업 스레드의 이름을 setName() 메소드로 수정하는 방법을 보여 준다.

```java
package ch14.sec04;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName() + " 실행");

		for (int i=0; i<3; i++) {
			Thread threadA = new Thread() {
				@Override
				public void run() {
					System.out.println(getName() + " 실행");
				}
			};
			threadA.start();
		}

		Thread chatThread = new Thread() {
			@Override
			public void run() {
				System.out.println(getName() + " 실행");
			}
		};
		chatThread.setName("chat-thread");
		chatThread.start();
	}
}
```

**실행 결과**
```
main 실행
Thread-0 실행
Thread-1 실행
Thread-2 실행
chat-thread 실행
```
