---
layout: part03
title: "14.3 작업 스레드 생성과 실행"
nav_order: 3
parent: "Chapter 14. 멀티 스레드"
grand_parent: "라이브러리 활용"
---

# 14.3 작업 스레드 생성과 실행

멀티 스레드로 실행하는 프로그램을 개발하려면 먼저 몇 개의 작업을 병렬로 실행할지 결정하고 각 작업별로 스레드를 생성해야 한다.

자바 프로그램은 메인 스레드가 반드시 존재하기 때문에 메인 작업 이외에 추가적인 작업 수만큼 스레드를 생성하면 된다. 자바는 작업 스레드도 객체로 관리하므로 클래스가 필요하다. Thread 클래스로 직접 객체를 생성해도 되지만, 하위 클래스를 만들어서 생성할 수도 있다.

## Thread 클래스로 직접 생성

java.lang 패키지에 있는 Thread 클래스로부터 작업 스레드 객체를 직접 생성하려면 다음과 같이 Runnable 구현 객체를 매개값으로 갖는 생성자를 호출하면 된다.

```java
Thread thread = new Thread(Runnable target);
```

Runnable은 스레드가 작업을 실행할 때 사용하는 인터페이스이다. Runnable에는 run() 메소드가 정의되어 있는데, 구현 클래스는 run()을 재정의해서 스레드가 실행할 코드를 가지고 있어야 한다.

```java
class Task implements Runnable {
	@Override
	public void run() {
		// 스레드가 실행할 코드
	}
}
```

Runnable 구현 클래스는 작업 내용을 정의한 것이므로, 스레드에게 전달해야 한다. Runnable 구현 객체를 생성한 후 Thread 생성자 매개값으로 Runnable 객체를 다음과 같이 전달하면 된다.

```java
Runnable task = new Task();
Thread thread = new Thread(task);
```

명시적인 Runnable 구현 클래스를 작성하지 않고 Thread 생성자를 호출할 때 Runnable 익명 구현 객체를 매개값으로 사용할 수 있다. 오히려 이 방법이 더 많이 사용된다.

```java
Thread thread = new Thread(new Runnable() {
	@Override
	public void run() {
		// 스레드가 실행할 코드
	}
});
```

작업 스레드 객체가 생성되었다고 해서 바로 작업 스레드가 실행되지는 않는다. 작업 스레드를 실행하려면 스레드 객체의 start() 메소드를 다음과 같이 호출해야 한다.

```java
thread.start();
```

start() 메소드가 호출되면, 작업 스레드는 매개값으로 받은 Runnable의 run() 메소드를 실행하면서 작업을 처리한다.

다음은 메인 스레드가 동시에 두 가지 작업을 처리할 수 없음을 보여주는 예제이다. 원래 목적은 0.5초 주기로 비프(beep)음을 발생시키면서 동시에 프린팅까지 하는 작업이었지만, 메인 스레드는 비프음을 모두 발생한 다음에야 프린팅을 시작한다.

```java
package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<5; i++) {
			toolkit.beep();
			try { Thread.sleep(500); } catch (Exception e) {}
		}

		for (int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch (Exception e) {}
		}
	}
}
```

**실행 결과**
```
(비프음 5번 발생 후)
띵
띵
띵
띵
띵
```

원래 목적대로 0.5초 주기로 비프음을 발생시키면서 동시에 프린팅을 하고 싶다면 두 작업 중 하나를 작업 스레드에서 처리하도록 해야 한다. 이제 프린팅은 메인 스레드가 담당하고 비프음을 들려주는 것은 작업 스레드가 담당하도록 수정해 보자.

```java
package ch14.sec03.exam02;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i=0; i<5; i++) {
					toolkit.beep();
					try { Thread.sleep(500); } catch (Exception e) {}
				}
			}
		});

		thread.start();

		for (int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch (Exception e) {}
		}
	}
}
```

**실행 결과**
```
(비프음과 동시에)
띵
띵
띵
띵
띵
```

## Thread 자식 클래스로 생성

작업 스레드 객체를 생성하는 또 다른 방법은 Thread의 자식 객체로 만드는 것이다. Thread 클래스를 상속한 다음 run() 메소드를 재정의해서 스레드가 실행할 코드를 작성하고 객체를 생성하면 된다.

```java
public class WorkerThread extends Thread {
	@Override
	public void run() {
		// 스레드가 실행할 코드
	}
}

// 스레드 객체 생성
Thread thread = new WorkerThread();
```

작업 스레드를 실행하는 방법은 동일하다. start() 메소드를 호출하면 작업 스레드는 재정의된 run()을 실행시킨다.

명시적인 자식 클래스를 정의하지 않고, 다음과 같이 Thread 익명 자식 객체를 사용할 수도 있다. 오히려 이 방법이 더 많이 사용된다.

```java
Thread thread = new Thread() {
	@Override
	public void run() {
		// 스레드가 실행할 코드
	}
};
thread.start();
```

다음은 Thread의 익명 자식 객체로 작업 스레드를 정의하고 비프음을 실행하도록 이전 예제를 수정한 것이다.

```java
package ch14.sec03.exam03;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i=0; i<5; i++) {
					toolkit.beep();
					try { Thread.sleep(500); } catch (Exception e) {}
				}
			}
		};

		thread.start();

		for (int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch (Exception e) {}
		}
	}
}
```
