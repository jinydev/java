---
layout: part03
title: "확인문제"
nav_order: 99
parent: "Chapter 20. 멀티 스레드"
grand_parent: "라이브러리 활용"
---

# 확인문제

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
