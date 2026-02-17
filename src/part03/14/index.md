---
layout: part03
title: Chapter 14. 멀티 스레드
---

# Chapter 14. 멀티 스레드

## 14.1 멀티 스레드 개념

운영체제는 실행 중인 프로그램을 **프로세스(process)**로 관리한다. 멀티 태스킹(multi tasking)은 두 가지 이상의 작업을 동시에 처리하는 것을 말하는데, 이때 운영체제는 멀티 프로세스를 생성해서 처리한다. 하지만 멀티 태스킹이 꼭 멀티 프로세스를 뜻하지는 않는다.

하나의 프로세스 내에서 멀티 태스킹을 할 수 있도록 만들어진 프로그램들도 있다. 예를 들어 메신저는 채팅 작업을 하면서 동시에 파일 전송 작업을 수행하기도 한다.

하나의 프로세스가 두 가지 이상의 작업을 처리할 수 있는 이유는 **멀티 스레드(multi thread)**가 있기 때문이다. **스레드(thread)**는 코드의 실행 흐름을 말하는데, 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미이다.

멀티 프로세스가 프로그램 단위의 멀티 태스킹이라면 멀티 스레드는 프로그램 내부에서의 멀티 태스킹이라고 볼 수 있다.

멀티 프로세스들은 서로 독립적이므로 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 미치지 않는다. 하지만 멀티 스레드는 프로세스 내부에서 생성되기 때문에 하나의 스레드가 예외를 발생시키면 프로세스가 종료되므로 다른 스레드에게 영향을 미친다.

예를 들어 워드와 엑셀을 동시에 사용하는 도중에 워드에 오류가 생겨 먹통이 되더라도 엑셀은 여전히 사용 가능하다. 그러나 멀티 스레드로 동작하는 메신저의 경우, 파일을 전송하는 스레드에서 예외가 발생하면 메신저 프로세스 자체가 종료되기 때문에 채팅 스레드도 같이 종료된다. 그렇기 때문에 멀티 스레드를 사용할 경우에는 예외 처리에 만전을 기해야 한다.

멀티 스레드는 데이터를 분할해서 병렬로 처리하는 곳에서 사용하기도 하고, 안드로이드 앱에서 네트워크 통신을 하기 위해 사용하기도 한다. 또한 다수의 클라이언트 요청을 처리하는 서버를 개발할 때에도 사용된다.

> 자바 21부터는 가상 스레드(virtual thread) 기능이 추가되었다. 이번 장에서 설명하는 스레드는 운영체제 스레드와 1:1로 매핑되는 플랫폼 스레드(platform thread)일 때 복수 개의 가상 스레드가 운영체제의 스레드 1개와 매핑되면서 실행된다.

## 14.2 메인 스레드

모든 자바 프로그램은 **메인 스레드(main thread)**가 main() 메소드를 실행하면서 시작된다. 메인 스레드는 main() 메소드의 첫 코드부터 순차적으로 실행하고, main() 메소드의 마지막 코드를 실행하거나 return 문을 만나면 실행을 종료한다.

```java
public static void main(String[] args) {
	String data = null;
	if (...) {
	}
	while (...) {
	}
	System.out.println(".......");
}
```

메인 스레드는 필요에 따라 추가 작업 스레드들을 만들어서 실행시킬 수 있다.

싱글 스레드에서는 메인 스레드가 종료되면 프로세스도 종료된다. 하지만 멀티 스레드에서는 실행 중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다. 메인 스레드가 작업 스레드보다 먼저 종료되더라도 작업 스레드가 계속 실행 중이라면 프로세스는 종료되지 않는다.

## 14.3 작업 스레드 생성과 실행

멀티 스레드로 실행하는 프로그램을 개발하려면 먼저 몇 개의 작업을 병렬로 실행할지 결정하고 각 작업별로 스레드를 생성해야 한다.

자바 프로그램은 메인 스레드가 반드시 존재하기 때문에 메인 작업 이외에 추가적인 작업 수만큼 스레드를 생성하면 된다. 자바는 작업 스레드도 객체로 관리하므로 클래스가 필요하다. Thread 클래스로 직접 객체를 생성해도 되지만, 하위 클래스를 만들어서 생성할 수도 있다.

### Thread 클래스로 직접 생성

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

### Thread 자식 클래스로 생성

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

## 14.4 스레드 이름

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

## 14.5 스레드 상태

스레드 객체를 생성(NEW)하고, start() 메소드를 호출하면 곧바로 스레드가 실행되는 것이 아니라 실행 대기 상태(RUNNABLE)가 된다. 실행 대기 상태란 실행을 기다리고 있는 상태를 말한다.

실행 대기하는 스레드는 CPU 스케줄링에 따라 CPU를 점유하고 run() 메소드를 실행한다. 이때를 실행(RUNNING) 상태라고 한다. 실행 스레드는 run() 메소드를 모두 실행하기 전에 스케줄링에 의해 다시 실행 대기 상태로 돌아갈 수 있다. 그리고 다른 스레드가 실행 상태가 된다.

이렇게 스레드는 실행 대기 상태와 실행 상태를 번갈아 가면서 자신의 run() 메소드를 조금씩 실행한다. 실행 상태에서 run() 메소드가 종료되면 더 이상 실행할 코드가 없기 때문에 스레드의 실행은 멈추게 된다. 이 상태를 종료 상태(TERMINATED)라고 한다.

실행 상태에서 일시 정지 상태로 가기도 하는데, 일시 정지 상태는 스레드가 실행할 수 없는 상태를 말한다. 스레드가 다시 실행 상태로 가기 위해서는 일시 정지 상태에서 실행 대기 상태로 가야만 한다.

### 주어진 시간 동안 일시 정지

실행 중인 스레드를 일정 시간 멈추게 하고 싶다면 Thread 클래스의 정적 메소드인 sleep()을 이용하면 된다. 매개값에는 얼마 동안 일시 정지 상태로 있을 것인지 밀리세컨드(1/1000) 단위로 시간을 주면 된다.

```java
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// interrupt() 메소드가 호출되면 실행
}
```

일시 정지 상태에서는 InterruptedException이 발생할 수 있기 때문에 sleep()은 예외 처리가 필요한 메소드이다.

```java
package ch14.sec05.exam01;

import java.awt.Toolkit;

public class SleepExample {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<10; i++) {
			toolkit.beep();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
		}
	}
}
```

### 다른 스레드의 종료를 기다림

스레드는 다른 스레드와 독립적으로 실행하지만 다른 스레드가 종료될 때까지 기다렸다가 실행을 해야 하는 경우도 있다. 예를 들어 계산 스레드의 작업이 종료된 후 그 결과값을 받아 처리하는 경우이다.

이를 위해 스레드는 **join()** 메소드를 제공한다. ThreadA가 ThreadB의 join() 메소드를 호출하면 ThreadA는 ThreadB가 종료할 때까지 일시 정지 상태가 된다. ThreadB의 run() 메소드가 종료되고 나서야 비로소 ThreadA는 일시 정지에서 풀려 다음 코드를 실행한다.

```java
threadB.start();
threadB.join(); // ThreadA 일시 정지
```

다음은 SumThread가 계산 작업을 모두 마칠 때까지 메인 스레드가 일시 정지 상태에 있다가 SumThread가 최종 계산된 결과값을 산출하고 종료하면 메인 스레드가 결과값을 받아 출력하는 예제이다.

```java
package ch14.sec05.exam02;

public class SumThread extends Thread {
	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for (int i=1; i<=100; i++) {
			sum += i;
		}
	}
}
```

```java
package ch14.sec05.exam02;

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join();
		} catch (InterruptedException e) {
		}
		System.out.println("1~100 합: " + sumThread.getSum());
	}
}
```

**실행 결과**
```
1~100 합: 5050
```

### 다른 스레드에게 실행 양보

스레드가 처리하는 작업은 반복적인 실행을 위해 for 문이나 while 문을 포함하는 경우가 많은데, 가끔 반복문이 무의미한 반복을 하는 경우가 있다.

이때는 다른 스레드에게 실행을 양보하고 자신은 실행 대기 상태로 가는 것이 프로그램 성능에 도움이 된다. 이런 기능을 위해 Thread는 **yield()** 메소드를 제공한다. yield()를 호출한 스레드는 실행 대기 상태로 돌아가고, 다른 스레드가 실행 상태가 된다.

```java
public void run() {
	while (true) {
		if (work) {
			System.out.println("ThreadA 작업 내용");
		} else {
			Thread.yield();
		}
	}
}
```

```java
package ch14.sec05.exam03;

public class WorkThread extends Thread {
	public boolean work = true;

	public WorkThread(String name) {
		setName(name);
	}

	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(getName() + ": 작업처리");
			} else {
				Thread.yield();
			}
		}
	}
}
```

```java
package ch14.sec05.exam03;

public class YieldExample {
	public static void main(String[] args) {
		WorkThread workThreadA = new WorkThread("workThreadA");
		WorkThread workThreadB = new WorkThread("workThreadB");
		workThreadA.start();
		workThreadB.start();

		try { Thread.sleep(5000); } catch (InterruptedException e) {}
		workThreadA.work = false;

		try { Thread.sleep(10000); } catch (InterruptedException e) {}
		workThreadA.work = true;
	}
}
```

**실행 결과**
```
workThreadA: 작업처리
workThreadB: 작업처리
(5초 후)
workThreadB: 작업처리
(10초 후)
workThreadA: 작업처리
workThreadB: 작업처리
```

## 14.6 스레드 동기화

멀티 스레드는 하나의 객체를 공유해서 작업할 수도 있다. 이 경우, 다른 스레드에 의해 객체 내부 데이터가 쉽게 변경될 수 있기 때문에 의도했던 것과는 다른 결과가 나올 수 있다.

스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날 때까지 객체에 잠금을 걸면 된다. 이를 위해 자바는 **동기화(synchronized) 메소드와 블록**을 제공한다.

객체 내부에 동기화 메소드와 동기화 블록이 여러 개가 있다면 스레드가 이들 중 하나를 실행할 때 다른 스레드는 해당 메소드는 물론이고 다른 동기화 메소드 및 블록도 실행할 수 없다. 하지만 일반 메소드는 실행이 가능하다.

### 동기화 메소드 및 블록 선언

동기화 메소드를 선언하는 방법은 다음과 같이 synchronized 키워드를 붙이면 된다. synchronized 키워드는 인스턴스와 정적 메소드 어디든 붙일 수 있다.

```java
public synchronized void method() {
	// 단 하나의 스레드만 실행하는 영역
}
```

스레드가 동기화 메소드를 실행하는 즉시 객체는 잠금이 일어나고, 메소드 실행이 끝나면 잠금이 풀린다. 메소드 전체가 아닌 일부 영역을 실행할 때만 객체 잠금을 걸고 싶다면 다음과 같이 동기화 블록을 만들면 된다.

```java
public void method() {
	// 여러 스레드가 실행할 수 있는 영역
	synchronized(공유객체) {
		// 단 하나의 스레드만 실행하는 영역
	}
	// 여러 스레드가 실행할 수 있는 영역
}
```

다음 예제는 공유 객체로 사용할 Calculator이다. setMemory1()을 동기화 메소드로, setMemory2()를 동기화 블록을 포함하는 메소드로 선언했다.

```java
package ch14.sec06.exam01;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}

	public void setMemory2(int memory) {
		synchronized(this) {
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		}
	}
}
```

```java
package ch14.sec06.exam01;

public class User1Thread extends Thread {
	private Calculator calculator;

	public User1Thread() {
		setName("User1Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory1(100);
	}
}
```

```java
package ch14.sec06.exam01;

public class User2Thread extends Thread {
	private Calculator calculator;

	public User2Thread() {
		setName("User2Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory2(50);
	}
}
```

```java
package ch14.sec06.exam01;

public class SynchronizedExample {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();

		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
	}
}
```

**실행 결과**
```
User1Thread: 100
User2Thread: 50
```

### wait()과 notify()를 이용한 스레드 제어

경우에 따라서는 두 개의 스레드를 교대로 번갈아 가며 실행할 때도 있다. 정확한 교대 작업이 필요할 경우, 자신의 작업이 끝나면 상대방 스레드를 일시 정지 상태에서 풀어주고 자신은 일시 정지 상태로 만들면 된다.

이 방법의 핵심은 공유 객체에 있다. 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 정해 놓는다. 한 스레드가 작업을 완료하면 notify() 메소드를 호출해서 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고, 자신은 두 번 작업을 하지 않도록 wait() 메소드를 호출하여 일시 정지 상태로 만든다.

```java
package ch14.sec06.exam02;

public class WorkObject {
	public synchronized void methodA() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodA 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}

	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodB 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
```

```java
package ch14.sec06.exam02;

public class ThreadA extends Thread {
	private WorkObject workObject;

	public ThreadA(WorkObject workObject) {
		setName("ThreadA");
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			workObject.methodA();
		}
	}
}
```

```java
package ch14.sec06.exam02;

public class ThreadB extends Thread {
	private WorkObject workObject;

	public ThreadB(WorkObject workObject) {
		setName("ThreadB");
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			workObject.methodB();
		}
	}
}
```

```java
package ch14.sec06.exam02;

public class WaitNotifyExample {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();

		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);

		threadA.start();
		threadB.start();
	}
}
```

**실행 결과**
```
ThreadA: methodA 작업 실행
ThreadB: methodB 작업 실행
ThreadA: methodA 작업 실행
ThreadB: methodB 작업 실행
...
```

## 14.7 스레드 안전 종료

스레드는 자신의 run() 메소드가 모두 실행되면 자동적으로 종료되지만, 경우에 따라서는 실행 중인 스레드를 즉시 종료할 필요가 있다.

스레드를 안전하게 종료하는 방법은 사용하던 리소스들을 정리하고 run() 메소드를 빨리 종료하는 것이다. 주로 조건 이용 방법과 interrupt() 메소드 이용 방법을 사용한다.

### 조건 이용

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

### interrupt() 메소드 이용

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

## 14.8 데몬 스레드

**데몬(daemon) 스레드**는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다. 주 스레드가 종료되면 데몬 스레드도 따라서 자동으로 종료된다.

스레드를 데몬으로 만들기 위해서는 주 스레드가 데몬이 될 스레드의 setDaemon(true)를 호출하면 된다.

```java
package ch14.sec08;

public class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장함.");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			save();
		}
	}
}
```

```java
package ch14.sec08;

public class DaemonExample {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		System.out.println("메인 스레드 종료");
	}
}
```

**실행 결과**
```
작업 내용을 저장함.
작업 내용을 저장함.
메인 스레드 종료
```

## 14.9 스레드풀

병렬 작업 처리가 많아지면 스레드의 개수가 폭증하여 CPU가 바빠지고 메모리 사용량이 늘어난다. 이에 따라 애플리케이션의 성능 또한 급격히 저하된다. 이렇게 병렬 작업 증가로 인한 스레드의 폭증을 막으려면 **스레드풀(ThreadPool)**을 사용하는 것이 좋다.

스레드풀은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐(Queue)에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식이다.

### 스레드풀 생성

자바는 스레드풀을 생성하고 사용할 수 있도록 java.util.concurrent 패키지에서 ExecutorService 인터페이스와 Executors 클래스를 제공하고 있다.

```java
// 초기 수 0, 코어 수 0, 최대 수 Integer.MAX_VALUE
ExecutorService executorService = Executors.newCachedThreadPool();

// 초기 수 0, 코어 수 0, 최대 수 5
ExecutorService executorService = Executors.newFixedThreadPool(5);
```

### 스레드풀 종료

스레드풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아 있다. 스레드풀의 모든 스레드를 종료하려면 ExecutorService의 shutdown() 또는 shutdownNow() 메소드를 실행해야 한다.

```java
package ch14.sec09.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	public static void main(String[] args) {
		// 스레드풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		// 작업 생성과 처리 요청
		// 스레드풀 종료
		executorService.shutdownNow();
	}
}
```

### 작업 생성과 처리 요청

하나의 작업은 Runnable 또는 Callable 구현 객체로 표현한다. Runnable과 Callable의 차이점은 작업 처리 완료 후 리턴값이 있느냐 없느냐이다.

작업 처리 요청이란 ExecutorService의 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위를 말한다.

*   `execute(Runnable command)`: Runnable을 작업 큐에 저장. 작업 처리 결과를 리턴하지 않음.
*   `submit(Callable<T> task)`: Callable을 작업 큐에 저장. 작업 처리 결과를 얻을 수 있도록 Future를 리턴.

```java
package ch14.sec09.exam02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {
	public static void main(String[] args) {
		// 1000개의 메일 생성
		String[][] mails = new String[1000][3];
		for (int i=0; i<mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member"+i+"@my.com";
			mails[i][2] = "신상품 입고";
		}

		// ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// 이메일을 보내는 작업 생성 및 처리 요청
		for (int i=0; i<1000; i++) {
			final int idx = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String content = mails[idx][2];
					System.out.println("[" + thread.getName() + "] " +
							from + " ==> " + to + ": " + content);
				}
			});
		}

		// ExecutorService 종료
		executorService.shutdown();
	}
}
```

```java
package ch14.sec09.exam03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSubmitExample {
	public static void main(String[] args) {
		// ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// 계산 작업 생성 및 처리 요청
		for (int i=1; i<=100; i++) {
			final int idx = i;
			Future<Integer> future = executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int i=1; i<=idx; i++) {
						sum += i;
					}
					Thread thread = Thread.currentThread();
					System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
					return sum;
				}
			});

			try {
				int result = future.get(); // Callable의 call() 메소드가 리턴한 값 얻기
				System.out.println("\t리턴값: " + result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// ExecutorService 종료
		executorService.shutdown();
	}
}
```

## 확인문제

1.  스레드에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 자바 애플리케이션은 메인(main) 스레드가 main() 메소드를 실행시킨다.
    *   ② 작업 스레드 클래스는 Thread 클래스를 상속해서 만들 수 있다.
    *   ③ Runnable 객체는 스레드가 실행해야 할 코드를 가지고 있는 객체라고 볼 수 있다.
    *   ④ 스레드 실행을 시작하려면 run() 메소드를 호출해야 한다.
    > **정답**: ④
    > **해설**: 스레드 실행을 시작하려면 start() 메소드를 호출해야 한다.

2.  동영상과 음악을 재생하기 위해 두 가지 스레드를 실행하려고 합니다. 밑줄 친 부분에 적당한 코드를 작성해 보세요.
    ```java
    public class ThreadExample {
    	public static void main(String[] args) {
    		Thread thread1 = new MovieThread();
    		thread1.start();

    		Thread thread2 = new Thread(new MusicRunnable());
    		thread2.start();
    	}
    }
    ```
    ```java
    public class MovieThread extends Thread {
    	@Override
    	public void run() {
    		for (int i=0; i<3; i++) {
    			System.out.println("동영상을 재생합니다.");
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    			}
    		}
    	}
    }
    ```
    ```java
    public class MusicRunnable implements Runnable {
    	@Override
    	public void run() {
    		for (int i=0; i<3; i++) {
    			System.out.println("음악을 재생합니다.");
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    			}
    		}
    	}
    }
    ```

3.  동기화 메소드와 동기화 블록에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 동기화 메소드와 동기화 블록은 싱글(단일) 스레드 환경에서는 필요 없다.
    *   ② 스레드가 동기화 메소드를 실행할 때 다른 스레드는 일반 메소드를 호출할 수 없다.
    *   ③ 스레드가 동기화 메소드를 실행할 때 다른 스레드는 동기화 메소드를 호출할 수 없다.
    *   ④ 스레드가 동기화 블록을 실행할 때 다른 스레드는 동기화 메소드를 호출할 수 없다.
    > **정답**: ②
    > **해설**: 스레드가 동기화 메소드를 실행할 때 다른 스레드는 일반 메소드를 호출할 수 있다. 동기화된 메소드나 블록만 접근이 차단된다.

4.  스레드 일시 정지 상태에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① sleep() 메소드는 주어진 시간동안 스레드가 일시 정지 상태가 된다.
    *   ② 스레드가 동기화 메소드를 실행할 때 다른 스레드가 동기화 메소드를 호출하게 되면 일시 정지 상태가 된다.
    *   ③ 동기화 메소드 내에서 wait() 메소드를 호출하면 현재 스레드가 일시 정지 상태가 된다.
    *   ④ yield() 메소드를 호출하면 현재 스레드가 일시 정지 상태가 된다.
    > **정답**: ④
    > **해설**: yield() 메소드를 호출하면 실행 대기 상태가 된다.

5.  interrupt() 메소드를 호출한 효과에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 일시 정지 상태에서 InterruptedException을 발생시킨다.
    *   ② 스레드를 즉시 종료한다.
    *   ③ 스레드가 일시 정지 상태가 될 때까지 InterruptedException이 발생하지 않는다.
    *   ④ InterruptedException이 발생하지 않았다면 isInterrupted() 메소드는 true를 리턴한다.
    > **정답**: ②
    > **해설**: interrupt() 메소드는 즉시 종료시키는 것이 아니라, 예외를 발생시키거나 인터럽트 상태를 설정하여 종료를 유도하는 것이다.

6.  메인 스레드에서 3초 후 MovieThread의 interrupt() 메소드를 호출해서 MovieThread를 안전하게 종료하고 싶습니다. 비어있는 부분에 적당한 코드를 작성해 보세요.
    ```java
    public class MovieThread extends Thread {
    	@Override
    	public void run() {
    		while(true) {
    			System.out.println("동영상을 재생합니다.");
    			if (this.isInterrupted()) {
    				break;
    			}
    		}
    	}
    }
    ```
    > **해설**: 또는
    ```java
    			try { Thread.sleep(1); } catch (InterruptedException e) { break; }
    ```
    > 도 가능하지만, 문제에서 "비어있는 부분에 적당한 코드"라고 했고 반복문 안이므로 `if (Thread.interrupted()) break;` 혹은 `if (this.isInterrupted()) break;` 가 적절하다.
    > *OCR 결과에 따르면:*
    ```java
    /*
    Thread thread = new MovieThread();
    thread.start();
    try { Thread.sleep(3000); } catch (InterruptedException e) {}
    thread.interrupt();
    */
    public class MovieThread extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println("동영상을 재생합니다.");
                if (isInterrupted()) {
                    break;
                }
            }
        }
    }
    ```

7.  wait()와 notify() 메소드에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 스레드가 wait()를 호출하면 일시 정지 상태가 된다.
    *   ② notify()를 호출하면 wait()로 일시 정지 상태에 있던 스레드가 실행 대기 상태가 된다.
    *   ③ wait()와 notify()는 동기화 메소드 또는 블록에서 호출할 필요가 없다.
    *   ④ wait()와 notify()는 두 스레드가 균등하게 번갈아 가면서 실행할 때 사용할 수 있다.
    > **정답**: ③
    > **해설**: wait()와 notify()는 반드시 동기화 메소드 또는 동기화 블록 내에서 호출해야 한다.

8.  3초 뒤에 메인 스레드가 종료하면 MovieThread도 같이 종료되게 만들고 싶습니다. 밑줄 친 부분에 적당한 코드를 넣어 보세요.
    ```java
    public class ThreadExample {
    	public static void main(String[] args) {
    		Thread thread = new MovieThread();
    		thread.setDaemon(true);
    		thread.start();
    		try { Thread.sleep(3000); } catch (InterruptedException e) {}
    	}
    }
    ```

9.  while 문으로 반복적인 작업을 하는 스레드를 종료시키는 방법에 대한 설명 중 최선의 방법이 아닌 것은 무엇입니까?
    *   ① 조건식에 boolean 타입의 stop 플래그를 이용해서 while 문을 빠져나가게 한다.
    *   ② 스레드가 반복적으로 일시 정지 상태가 된다면 InterruptedException을 발생시켜 예외 처리 코드에서 break 문으로 while 문을 빠져나가게 한다.
    *   ③ 스레드가 일시 정지 상태로 가지 않는다면 isInterrupted()나 interrupted() 메소드의 리턴값을 조사해서 true일 경우 break 문으로 while 문을 빠져나가게 한다.
    *   ④ stop() 메소드를 호출한다.
    > **정답**: ④
    > **해설**: stop() 메소드는 deprecated 되었으므로 사용하지 않는 것이 좋다.

10. 스레드풀에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 갑작스러운 작업의 증가로 스레드의 폭증을 막기 위해 사용된다.
    *   ② ExecutorService 객체가 스레드풀이며 newFixedThreadPool() 메소드로 얻을 수 있다.
    *   ③ 작업은 Runnable 또는 Callable 인터페이스를 구현해서 정의한다.
    *   ④ execute() 메소드로 작업 처리 요청을 하면 작업이 완료될 때까지 대기(블로킹)된다.
    > **정답**: ④
    > **해설**: execute() 메소드는 작업을 큐에 넣고 즉시 리턴한다(비동기). 블로킹되지 않는다.
