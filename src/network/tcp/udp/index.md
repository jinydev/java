---
layout: network
title: "19.4 UDP 네트워킹"
nav_order: 4
parent: "Chapter 19. 네트워크 입출력"
grand_parent: "데이터 입출력"
---

# 19.4 UDP 네트워킹

**UDP(User Datagram Protocol)**는 발신자가 일방적으로 수신자에게 데이터를 보내는 방식으로, TCP처럼 연결 요청 및 수락 과정이 없기 때문에 TCP보다 데이터 전송 속도가 상대적으로 빠르다. 하지만 데이터 신뢰성은 낮다.

자바는 UDP 네트워킹을 위해 `java.net` 패키지에서 `DatagramSocket`과 `DatagramPacket` 클래스를 제공하고 있다. `DatagramSocket`은 발신점과 수신점에 해당하고, `DatagramPacket`은 주고받는 데이터에 해당한다.

## UDP 서버

UDP 서버를 위한 `DatagramSocket` 객체를 생성할 때에는 다음과 같이 바인딩할 Port 번호를 생성자 매개값으로 제공해야 한다.

```java
DatagramSocket datagramSocket = new DatagramSocket(50001);
```

데이터 수신은 `receive()` 메소드를 사용한다.

```java
DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
datagramSocket.receive(receivePacket);
```

## UDP 클라이언트

UDP 클라이언트를 위한 `DatagramSocket` 객체는 기본 생성자로 생성한다. `Port` 번호는 자동으로 부여된다.

```java
DatagramSocket datagramSocket = new DatagramSocket();
```

데이터 전송은 `send()` 메소드를 사용한다.

```java
DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("localhost", 50001));
datagramSocket.send(sendPacket);
```

다음 예제는 UDP 클라이언트가 구독하고 싶은 뉴스를 전송하면 UDP 서버가 관련 뉴스 10개를 전송하는 예제이다.

```java
package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewsServer {
	private static DatagramSocket datagramSocket = null;

	public static void main(String[] args) throws Exception {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("--------------------------------------------------------------------");

		// UDP 서버 시작
		startServer();

		// 키보드 입력
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();

		// UDP 서버 종료
		stopServer();
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// DatagramSocket 생성 및 Port 바인딩
					datagramSocket = new DatagramSocket(50001);
					System.out.println("[서버] 시작됨");

					while (true) {
						// 클라이언트가 구독하고 싶은 뉴스 주제 얻기
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivePacket);
						String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

						// 클라이언트의 IP와 Port 얻기
						SocketAddress socketAddress = receivePacket.getSocketAddress();

						// 10개의 뉴스를 클라이언트로 전송
						for (int i=1; i<=10; i++) {
							String data = newsKind + ": 뉴스" + i;
							byte[] bytes = data.getBytes("UTF-8");
							DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
							datagramSocket.send(sendPacket);
						}
					}
				} catch (Exception e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start();
	}

	public static void stopServer() {
		// DatagramSocket을 닫고 Port 언바인딩
		datagramSocket.close();
		System.out.println("[서버] 종료됨");
	}
}
```

```java
package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {
	public static void main(String[] args) {
		try {
			// DatagramSocket 생성
			DatagramSocket datagramSocket = new DatagramSocket();

			// 구독하고 싶은 뉴스 주제 보내기
			String data = "정치";
			byte[] bytes = data.getBytes("UTF-8");
			DatagramPacket sendPacket = new DatagramPacket(
				bytes, bytes.length, new InetSocketAddress("localhost", 50001)
			);
			datagramSocket.send(sendPacket);

			while (true) {
				// 뉴스 받기
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivePacket);

				// 문자열로 변환
				String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
				System.out.println(news);

				// 10번째 뉴스를 받으면 while 문 종료
				if (news.contains("뉴스10")) {
					break;
				}
			}

			// DatagramSocket 닫기
			datagramSocket.close();
		} catch (Exception e) {
		}
	}
}
```
