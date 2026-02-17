---
layout: part03
title: "14.7 스레드 안전 종료"
nav_order: 7
parent: "Chapter 14. 멀티 스레드"
grand_parent: "라이브러리 활용"
---

# 14.7 스레드 안전 종료

스레드는 자신의 run() 메소드가 모두 실행되면 자동적으로 종료되지만, 경우에 따라서는 실행 중인 스레드를 즉시 종료할 필요가 있다.

스레드를 안전하게 종료하는 방법은 사용하던 리소스들을 정리하고 run() 메소드를 빨리 종료하는 것이다. 주로 조건 이용 방법과 interrupt() 메소드 이용 방법을 사용한다.

## 조건 이용

스레드가 while 문으로 반복 실행할 경우, 조건을 이용해서 run() 메소드의 종료를 유도할 수 있다.

```java
package ch14.sec07.exam01;

public class PrintThread extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("실행 중");
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}
```

```java
package ch14.sec07.exam01;

public class SafeStopExample {
	public static void main(String[] args) {
		PrintThread printThread = new PrintThread();
		printThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		printThread.setStop(true);
	}
}
```

## interrupt() 메소드 이용

interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때 InterruptedException 예외를 발생시키는 역할을 한다. 이것을 이용하면 예외 처리를 통해 run() 메소드를 정상 종료시킬 수 있다.

```java
package ch14.sec07.exam02;

public class PrintThread extends Thread {
	public void run() {
		try {
			while (true) {
				System.out.println("실행 중");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}
```

```java
package ch14.sec07.exam02;

public class InterruptExample {
	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
	}
}
```

일시 정지를 만들지 않고도 interrupt() 메소드 호출 여부를 알 수 있는 방법이 있다. Thread의 interrupted()와 isInterrupted() 메소드는 interrupt() 메소드 호출 여부를 리턴한다.

```java
package ch14.sec07.exam03;

public class PrintThread extends Thread {
	public void run() {
		while (true) {
			System.out.println("실행 중");
			if (Thread.interrupted()) {
				break;
			}
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}
```

```java
package ch14.sec07.exam03;

public class InterruptExample {
	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
	}
}
```
