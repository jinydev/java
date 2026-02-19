---
layout: part03
title: "14.9 스레드풀"
nav_order: 9
parent: "Chapter 20. 멀티 스레드"
grand_parent: "라이브러리 활용"
---

# 14.9 스레드풀

병렬 작업 처리가 많아지면 스레드의 개수가 폭증하여 CPU가 바빠지고 메모리 사용량이 늘어난다. 이에 따라 애플리케이션의 성능 또한 급격히 저하된다. 이렇게 병렬 작업 증가로 인한 스레드의 폭증을 막으려면 **스레드풀(ThreadPool)**을 사용하는 것이 좋다.

스레드풀은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐(Queue)에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식이다.

## 스레드풀 생성

자바는 스레드풀을 생성하고 사용할 수 있도록 java.util.concurrent 패키지에서 ExecutorService 인터페이스와 Executors 클래스를 제공하고 있다.

```java
// 초기 수 0, 코어 수 0, 최대 수 Integer.MAX_VALUE
ExecutorService executorService = Executors.newCachedThreadPool();

// 초기 수 0, 코어 수 0, 최대 수 5
ExecutorService executorService = Executors.newFixedThreadPool(5);
```

## 스레드풀 종료

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

## 작업 생성과 처리 요청

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
