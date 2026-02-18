---
layout: part03
title: "14.8 데몬 스레드"
nav_order: 8
parent: "Chapter 14. 멀티 스레드"
grand_parent: "라이브러리 활용"
---

# 14.8 데몬 스레드

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
