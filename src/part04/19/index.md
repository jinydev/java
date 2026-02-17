---
layout: part04
title: Chapter 19. 네트워크 입출력
---

# Chapter 19. 네트워크 입출력

## 19.1 네트워크 기초

네트워크(Network)는 여러 컴퓨터들을 통신 회선으로 연결한 것을 말한다. LAN(Local Area Network)은 가정, 회사, 건물, 특정 영역에 존재하는 컴퓨터를 연결한 것이고, WAN(Wide Area Network)은 LAN을 연결한 것이다. WAN이 우리가 흔히 말하는 인터넷(Internet)이다.

### 서버와 클라이언트

네트워크에서 유무선으로 컴퓨터가 연결되어 있다면 실제로 데이터를 주고받는 행위는 프로그램들이 한다. 서비스를 제공하는 프로그램을 일반적으로 **서버(Server)**라고 부르고, 서비스를 요청하는 프로그램을 **클라이언트(Client)**라고 부른다.

인터넷에서 두 프로그램이 통신하기 위해서는 먼저 클라이언트가 서비스를 요청하고, 서버는 처리 결과를 응답으로 제공해 준다.

## 19.2 IP 주소 얻기

컴퓨터에도 고유한 주소가 있다. 바로 **IP(Internet Protocol) 주소**이다. IP 주소는 네트워크 어댑터(LAN 카드)마다 할당된다.

네트워크 어댑터에 어떤 IP 주소가 부여되어 있는지 확인하려면 윈도우에서는 `ipconfig` 명령어를, 맥OS에서는 `ifconfig` 명령어를 실행하면 된다.

연결할 상대방 컴퓨터의 IP 주소를 모르면 프로그램들은 서로 통신할 수 없다. 우리가 전화번호를 모르면 114로 문의하듯이 프로그램은 **DNS(Domain Name System)**를 이용해서 컴퓨터의 IP 주소를 검색한다. DNS는 도메인 이름으로 IP를 등록하는 저장소이다.

웹 브라우저는 웹 서버와 통신하는 클라이언트로, 사용자가 입력한 도메인 이름으로 DNS에서 IP 주소를 검색해 찾은 다음 웹 서버와 연결해서 웹 페이지를 받는다.

### Port 번호

한 대의 컴퓨터에는 다양한 서버 프로그램들이 실행될 수 있다. 예를 들어 웹(Web) 서버, 데이터베이스 관리 시스템(DBMS), FTP 서버 등이 하나의 IP 주소를 갖는 컴퓨터에서 동시에 실행될 수 있다. 이 경우 클라이언트는 어떤 서버와 통신해야 할지 결정해야 한다. IP는 컴퓨터의 네트워크 어댑터까지만 갈 수 있는 정보이기 때문에, 컴퓨터 내부에서 실행하는 서버를 선택하기 위해서는 추가적인 **Port 번호**가 필요하다.

Port는 운영체제가 관리하는 서버 프로그램의 연결 번호이다. 서버는 시작할 때 특정 Port 번호에 바인딩(Binding)한다.

클라이언트도 서버에서 보낸 정보를 받기 위해서는 Port 번호가 필요한데, 서버와 같이 고정적인 Port 번호에 바인딩하는 것이 아니라 운영체제가 자동으로 부여하는 번호를 사용한다.

프로그램에서 사용할 수 있는 전체 Port 번호의 범위는 0 ~ 65535이다.

| 구분명                              | 범위          | 설명                                                                     |
| :---------------------------------- | :------------ | :----------------------------------------------------------------------- |
| **Well Known Port Numbers**         | 0 ~ 1023      | 국제인터넷주소관리기구(ICANN)가 특정 애플리케이션용으로 미리 예약한 Port |
| **Registered Port Numbers**         | 1024 ~ 49151  | 회사에서 등록해서 사용할 수 있는 Port                                    |
| **Dynamic Or Private Port Numbers** | 49152 ~ 65535 | 운영체제가 부여하는 동적 Port 또는 개인적인 목적으로 사용할 수 있는 Port |

자바는 IP 주소를 `java.net` 패키지의 `InetAddress`로 표현한다.

*   로컬 컴퓨터의 IP 주소 얻기:
    ```java
    InetAddress ia = InetAddress.getLocalHost();
    ```

*   도메인 이름으로 IP 주소 얻기:
    ```java
    InetAddress ia = InetAddress.getByName(String domainName);
    InetAddress[] iaArr = InetAddress.getAllByName(String domainName);
    ```

*   IP 주소 문자열 얻기:
    ```java
    String ip = ia.getHostAddress();
    ```

```java
package ch19.sec02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress());

			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
```

## 19.3 TCP 네트워킹

IP 주소로 프로그램들이 통신할 때는 약속된 데이터 전송 규약이 있다. 이것을 **전송용 프로토콜(Transfer Protocol)**이라고 부른다. 인터넷에서 전송용 프로토콜은 **TCP(Transmission Control Protocol)**와 **UDP(User Datagram Protocol)**가 있다.

TCP는 **연결형 프로토콜**로, 상대방이 연결된 상태에서 데이터를 주고받는다. 클라이언트가 연결 요청을 하고 서버가 연결을 수락하면 통신 회선이 고정되고, 데이터는 고정 회선을 통해 전달된다. 그렇기 때문에 TCP는 보낸 데이터가 순서대로 전달되며 손실이 발생하지 않는다.

자바는 TCP 네트워킹을 위해 `java.net` 패키지에서 `ServerSocket`과 `Socket` 클래스를 제공하고 있다.

### TCP 서버

TCP 서버 프로그램을 개발하려면 우선 `ServerSocket` 객체를 생성해야 한다. 다음은 50001번 Port에 바인딩하는 `ServerSocket`를 생성하는 코드이다.

```java
ServerSocket serverSocket = new ServerSocket(50001);
```

`ServerSocket`이 생성되었다면 연결 요청을 수락을 위해 `accept()` 메소드를 실행해야 한다. `accept()`는 클라이언트가 연결 요청하기 전까지 블로킹된다. 클라이언트의 연결 요청이 들어오면 블로킹이 해제되고 통신용 `Socket`을 리턴한다.

```java
Socket socket = serverSocket.accept();
```

연결된 클라이언트의 IP 주소와 Port 번호를 얻고 싶다면 다음과 같이 할 수 있다.

```java
InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
String clientIp = isa.getHostName(); // 또는 isa.getHostString()
String portNo = isa.getPort();
```

서버를 종료하려면 `ServerSocket`의 `close()` 메소드를 호출해서 Port 번호를 언바인딩시켜야 한다.

```java
serverSocket.close();
```

```java
package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("--------------------------------------------------------------------");

		// TCP 서버 시작
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

		// TCP 서버 종료
		stopServer();
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");

					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						// 연결 수락
						Socket socket = serverSocket.accept();

						// 연결된 클라이언트 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 수락함");

						// 연결 끊기
						socket.close();
						System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start();
	}

	public static void stopServer() {
		try {
			// ServerSocket을 닫고 Port 언바인딩
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {}
	}
}
```

### TCP 클라이언트

클라이언트가 서버에 연결 요청을 하려면 `Socket` 객체를 생성할 때 생성자 매개값으로 서버 IP 주소와 Port 번호를 제공하면 된다. 로컬 컴퓨터에서 실행하는 서버로 연결 요청을 할 경우에는 IP 주소 대신 `localhost`를 사용할 수 있다.

```java
Socket socket = new Socket("IP", 50001);
```

```java
package ch19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {
	public static void main(String[] args) {
		try {
			// Socket 생성과 동시에 localhost의 50001 Port로 연결 요청
			Socket socket = new Socket("localhost", 50001);

			System.out.println("[클라이언트] 연결 성공");

			// Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			// IP 표기 방법이 잘못되었을 경우
		} catch (IOException e) {
			// 해당 포트의 서버에 연결할 수 없는 경우
		}
	}
}
```

### 입출력 스트림으로 데이터 주고받기

클라이언트가 연결 요청(`connect()`)을 하고 서버가 연결 수락(`accept()`)했다면, 양쪽의 `Socket` 객체로부터 각각 입력 스트림(`InputStream`)과 출력 스트림(`OutputStream`)을 얻을 수 있다.

```java
InputStream is = socket.getInputStream();
OutputStream os = socket.getOutputStream();
```

다음은 TCP 클라이언트가 보낸 메시지를 다시 돌려보내는 에코(Echo) TCP 서버를 구현한 예제이다.

```java
package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("--------------------------------------------------------------------");

		// TCP 서버 시작
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

		// TCP 서버 종료
		stopServer();
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");

					// 연결 수락 및 데이터 통신
					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						// 연결 수락
						Socket socket = serverSocket.accept();

						// 연결된 클라이언트 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함");

						/*
						// 데이터 받기
						InputStream is = socket.getInputStream();
						byte[] bytes = new byte[1024];
						int readByteCount = is.read(bytes);
						String message = new String(bytes, 0, readByteCount, "UTF-8");

						// 데이터 보내기
						OutputStream os = socket.getOutputStream();
						bytes = message.getBytes("UTF-8");
						os.write(bytes);
						os.flush();
						System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
						*/

						// 데이터 받기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();

						// 데이터 보내기
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);

						// 연결 끊기
						socket.close();
						System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start();
	}

	public static void stopServer() {
		try {
			// ServerSocket을 닫고 Port 언바인딩
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {}
	}
}
```

```java
package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) {
		try {
			// Socket 생성과 동시에 localhost의 50001 포트로 연결 요청
			Socket socket = new Socket("localhost", 50001);

			System.out.println("[클라이언트] 연결 성공");

			/*
			// 데이터 보내기
			String sendMessage = "나는 자바가 좋아~~";
			OutputStream os = socket.getOutputStream();
			byte[] bytes = sendMessage.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[클라이언트] 데이터 보냄: " + sendMessage);

			// 데이터 받기
			InputStream is = socket.getInputStream();
			bytes = new byte[1024];
			int readByteCount = is.read(bytes);
			String receiveMessage = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[클라이언트] 데이터 받음: " + receiveMessage);
			*/

			// 데이터 보내기
			String sendMessage = "나는 자바가 좋아~~";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄: " + sendMessage);

			// 데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음: " + receiveMessage);

			// 연결 끊기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (Exception e) {
		}
	}
}
```

## 19.4 UDP 네트워킹

**UDP(User Datagram Protocol)**는 발신자가 일방적으로 수신자에게 데이터를 보내는 방식으로, TCP처럼 연결 요청 및 수락 과정이 없기 때문에 TCP보다 데이터 전송 속도가 상대적으로 빠르다. 하지만 데이터 신뢰성은 낮다.

자바는 UDP 네트워킹을 위해 `java.net` 패키지에서 `DatagramSocket`과 `DatagramPacket` 클래스를 제공하고 있다. `DatagramSocket`은 발신점과 수신점에 해당하고, `DatagramPacket`은 주고받는 데이터에 해당한다.

### UDP 서버

UDP 서버를 위한 `DatagramSocket` 객체를 생성할 때에는 다음과 같이 바인딩할 Port 번호를 생성자 매개값으로 제공해야 한다.

```java
DatagramSocket datagramSocket = new DatagramSocket(50001);
```

데이터 수신은 `receive()` 메소드를 사용한다.

```java
DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
datagramSocket.receive(receivePacket);
```

### UDP 클라이언트

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

## 19.5 서버의 동시 요청 처리

일반적으로 서버는 다수의 클라이언트와 통신을 한다. `accept()`와 `receive()`를 제외한 요청 처리 코드를 별도의 스레드에서 작업하는 것이 좋다. 스레드를 처리할 때 주의할 점은 클라이언트의 폭증으로 인한 서버의 과도한 스레드 생성을 방지해야 한다는 것이다. 그래서 **스레드풀(ExecutorService)**을 사용하는 것이 바람직하다.

### TCP EchoServer 동시 요청 처리

```java
package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	private static ServerSocket serverSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10); // 10개의 스레드로 요청을 처리하는 스레드풀 생성

	public static void main(String[] args) {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("--------------------------------------------------------------------");

		// TCP 서버 시작
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

		// TCP 서버 종료
		stopServer();
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨\n");

					// 연결 수락 및 데이터 통신
					while (true) {
						// 연결 수락
						Socket socket = serverSocket.accept();

						executorService.execute(() -> {
							try {
								// 연결된 클라이언트 정보 얻기
								InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함");

								// 데이터 받기
								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String message = dis.readUTF();

								// 데이터 보내기
								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(message);
								dos.flush();
								System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);

								// 연결 끊기
								socket.close();
								System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음\n");
							} catch (IOException e) {
							}
						});
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start();
	}

	public static void stopServer() {
		try {
			// ServerSocket을 닫고 Port 언바인딩
			serverSocket.close();
			executorService.shutdownNow(); // 스레드풀 종료
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {}
	}
}
```

### UDP NewsServer 동시 요청 처리

```java
package ch19.sec05.exam02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer {
	private static DatagramSocket datagramSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10); // 10개의 스레드로 요청을 처리하는 스레드풀 생성

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

						executorService.execute(() -> {
							try {
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
							} catch (Exception e) {
							}
						});
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
		executorService.shutdownNow(); // 스레드풀 종료
		System.out.println("[서버] 종료됨");
	}
}
```

## 19.6 JSON 데이터 형식

네트워크로 전달하는 데이터가 복잡할수록 구조화된 형식이 필요하다. **JSON(JavaScript Object Notation)**은 네트워크 통신에서 가장 많이 사용되는 데이터 형식이다.

JSON을 자바에서 처리하기 위해 `org.json` 라이브러리를 사용한다.

*   `JSONObject`: JSON 객체 표기를 생성하거나 파싱할 때 사용
*   `JSONArray`: JSON 배열 표기를 생성하거나 파싱할 때 사용

```java
package ch19.sec06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {
	public static void main(String[] args) throws IOException {
		// JSON 객체 생성
		JSONObject root = new JSONObject();

		// 속성 추가
		root.put("id", "winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);

		// 객체 속성 추가
		JSONObject tel = new JSONObject();
		tel.put("home", "02-123-1234");
		tel.put("mobile", "010-123-1234");
		root.put("tel", tel);

		// 배열 속성 추가
		JSONArray skill = new JSONArray();
		skill.put("java");
		skill.put("c");
		skill.put("c++");
		root.put("skill", skill);

		// JSON 얻기
		String json = root.toString();

		// 콘솔에 출력
		System.out.println(json);

		// 파일로 저장
		Writer writer = new FileWriter("C:/Temp/member.json", Charset.forName("UTF-8"));
		writer.write(json);
		writer.flush();
		writer.close();
	}
}
```

```java
package ch19.sec06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJsonExample {
	public static void main(String[] args) throws IOException {
		// 파일로부터 JSON 읽기
		BufferedReader br = new BufferedReader(
			new FileReader("C:/Temp/member.json", Charset.forName("UTF-8"))
		);
		String json = br.readLine();
		br.close();

		// JSON 파싱
		JSONObject root = new JSONObject(json);

		// 속성 정보 읽기
		System.out.println("id: " + root.getString("id"));
		System.out.println("name: " + root.getString("name"));
		System.out.println("age: " + root.getInt("age"));
		System.out.println("student: " + root.getBoolean("student"));

		// 객체 속성 정보 읽기
		JSONObject tel = root.getJSONObject("tel");
		System.out.println("home: " + tel.getString("home"));
		System.out.println("mobile: " + tel.getString("mobile"));

		// 배열 속성 정보 읽기
		JSONArray skill = root.getJSONArray("skill");
		System.out.print("skill: ");
		for (int i=0; i<skill.length(); i++) {
			System.out.print(skill.get(i) + ", ");
		}
	}
}
```

## 19.7 TCP 채팅 프로그램

TCP 네트워킹을 이용해서 채팅 서버와 클라이언트를 구현할 수 있다.

### 채팅 서버

```java
package ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
	// 필드
	ServerSocket serverSocket;
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

	// 메소드: 서버 시작
	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작됨");

		Thread thread = new Thread(() -> {
			try {
				while (true) {
					Socket socket = serverSocket.accept();
					SocketClient sc = new SocketClient(this, socket);
				}
			} catch (IOException e) {
			}
		});
		thread.start();
	}

	// 메소드: 클라이언트 연결 시 SocketClient 생성 및 추가
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}

	// 메소드: 클라이언트 연결 종료 시 SocketClient 제거
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("나감: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}

	// 메소드: 모든 클라이언트에게 메시지 보냄
	public void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();

		Collection<SocketClient> socketClients = chatRoom.values();
		for (SocketClient sc : socketClients) {
			if (sc == sender) continue;
			sc.send(json);
		}
	}

	// 메소드: 서버 종료
	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			chatRoom.values().stream().forEach(sc -> sc.close());
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {}
	}

	// 메소드: 메인
	public static void main(String[] args) {
		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();

			System.out.println("--------------------------------------------------------------------");
			System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
			System.out.println("--------------------------------------------------------------------");

			Scanner scanner = new Scanner(System.in);
			while (true) {
				String key = scanner.nextLine();
				if (key.equals("q")) break;
			}
			scanner.close();
			chatServer.stop();
		} catch (IOException e) {
			System.out.println("[서버] " + e.getMessage());
		}
	}
}
```

```java
package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	// 필드
	ChatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String clientIp;
	String chatName;

	// 생성자
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			receive();
		} catch (IOException e) {
		}
	}

	// 메소드: JSON 받기
	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while (true) {
					String receiveJson = dis.readUTF();

					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");

					switch (command) {
						case "incoming":
							this.chatName = jsonObject.getString("data");
							chatServer.sendToAll(this, "들어오셨습니다.");
							chatServer.addSocketClient(this);
							break;
						case "message":
							String message = jsonObject.getString("data");
							chatServer.sendToAll(this, message);
							break;
					}
				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}

	// 메소드: JSON 보내기
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
		}
	}

	// 메소드: 연결 종료
	public void close() {
		try {
			socket.close();
		} catch (Exception e) {}
	}
}
```

### 채팅 클라이언트

```java
package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	// 필드
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;

	// 메소드: 서버 연결
	public void connect() throws IOException {
		socket = new Socket("localhost", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결됨");
	}

	// 메소드: JSON 받기
	public void receive() {
		Thread thread = new Thread(() -> {
			try {
				while (true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + "> " + message);
				}
			} catch (Exception e1) {
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);
			}
		});
		thread.start();
	}

	// 메소드: JSON 보내기
	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}

	// 메소드: 서버 연결 종료
	public void unconnect() throws IOException {
		socket.close();
	}

	// 메소드: 메인
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect();

			Scanner scanner = new Scanner(System.in);
			System.out.println("대화명 입력: ");
			chatClient.chatName = scanner.nextLine();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);

			chatClient.receive();

			System.out.println("--------------------------------------------------------------------");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("채팅를 종료하려면 q를 입력하고 Enter");
			System.out.println("--------------------------------------------------------------------");

			while (true) {
				String message = scanner.nextLine();
				if (message.toLowerCase().equals("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			scanner.close();
			chatClient.unconnect();
		} catch (IOException e) {
			System.out.println("[클라이언트] 서버 연결 안됨");
		}
	}
}
```

## 확인문제

1.  서버와 클라이언트에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 서비스를 제공하는 쪽이 서버이고, 서비스를 요청하는 쪽이 클라이언트이다.
    *   ② 클라이언트가 서버에 연결하기 위해서는 IP 주소만 있으면 된다.
    *   ③ 포트(Port)는 여러 서버 중에 특정 서버와 연결하기 위해 필요한 정보다.
    *   ④ 서버와 클라이언트는 양쪽 모두 포트가 배정되어야 한다.
    > **정답**: ②
    > **해설**: IP 주소 외에도 포트 번호가 필요하다.

2.  TCP와 UDP에 대한 설명으로 틀린 것을 모두 선택하세요.
    *   ① TCP는 데이터 입출력에 앞서 연결 요청과 수락 과정이 필요하다.
    *   ② TCP는 여러 회선으로 데이터를 전달하므로, 데이터의 전달 순서가 달라질 수 있다.
    *   ③ UDP는 연결 수락 과정이 없기 때문에 TCP보다 상대적으로 빠르다.
    *   ④ UDP는 고정된 회선으로 데이터를 전달하기 때문에 전달 신뢰도가 높다.
    > **정답**: ②, ④
    > **해설**: TCP는 고정 회선을 사용하므로 순서가 보장된다. UDP는 고정 회선이 아니므로 데이터 순서가 달라질 수 있고 신뢰도가 낮다.

3.  다음은 TCP 클라이언트가 서버로 연결 요청을 하고 서버는 연결을 수락하는 코드이다. 빈칸에 들어갈 코드를 작성하세요. (단, 클라이언트와 서버는 같은 컴퓨터에서 실행하고 있습니다.)
    ```java
    // [클라이언트]
    Socket socket = new Socket("localhost", 5001);

    // [서버]
    ServerSocket serverSocket = new ServerSocket(5001);
    Socket socket = serverSocket.accept();
    ```

4.  TCP를 사용하는 클라이언트를 서버에 연결해 Socket으로 데이터 입출력을 하려고 합니다. 빈칸에 Socket을 통해 얻는 입출력 스트림의 타입을 적어 보세요.
    ```java
    InputStream is = socket.getInputStream();
    OutputStream os = socket.getOutputStream();
    ```

5.  UDP를 사용하는 클라이언트를 서버에서 사용되는 클래스 이름 및 데이터와 수신 · 발신할 때 사용되는 클래스 이름을 ① ~ ⑤ 빈칸에 작성해 보세요.
    *   ① `DatagramPacket`
    *   ② `DatagramSocket`
    *   ③ `DatagramPacket`
    *   ④ `DatagramPacket`
    *   ⑤ `DatagramSocket`

6.  서버 측 DatagramSocket에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 서버에서는 고정된 Port 번호를 제공하고 생성해야 한다.
    *   ② receive() 메소드는 데이터를 수신할 때까지 블로킹된다.
    *   ③ 클라이언트의 IP 주소와 Port 번호는 수신된 DatagramPacket에서 얻을 수 있다.
    *   ④ 클라이언트로 DatagramPacket을 발신할 때 write() 메소드를 사용한다.
    > **정답**: ④
    > **해설**: `send()` 메소드를 사용한다.

7.  상품관리 프로그램을 TCP를 이용해서 개발하려고 합니다. 다음 내용에 맞게 서버와 클라이언트를 직접 개발해 보세요.

    *(문제 내용 생략)*

    **요약**: Create, Update, Delete 기능을 가진 상품 관리 서버/클라이언트 구현. JSON 통신 사용.

    **Product.java**
    ```java
    package ch19.check;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.io.Serializable;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Product implements Serializable {
        private static final long serialVersionUID = 1L;
        private int no;
        private String name;
        private int price;
        private int stock;
    }
    ```

    **ProductServer.java** (서버 구현)
    ```java
    package ch19.check;

    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.Collections;
    import java.util.List;
    import java.util.Vector;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;

    import org.json.JSONArray;
    import org.json.JSONObject;

    public class ProductServer {
        private ServerSocket serverSocket;
        private ExecutorService threadPool;
        private List<Product> products;
        private int sequence;

        public void start() throws IOException {
            serverSocket = new ServerSocket(50001);
            threadPool = Executors.newFixedThreadPool(100);
            products = new Vector<>();

            System.out.println("[서버] 시작됨");

            while(true) {
                Socket socket = serverSocket.accept();
                SocketClient sc = new SocketClient(this, socket);
            }
        }

        public void stop() {
            try {
                serverSocket.close();
                threadPool.shutdownNow();
                System.out.println("[서버] 종료됨");
            } catch (IOException e1) {}
        }

        public static void main(String[] args) {
            try {
                ProductServer productServer = new ProductServer();
                productServer.start();
            } catch (IOException e) {
                System.out.println("[서버] " + e.getMessage());
            }
        }

        // 중첩 클래스
        public class SocketClient {
            private ProductServer productServer;
            private Socket socket;
            private DataInputStream dis;
            private DataOutputStream dos;

            public SocketClient(ProductServer productServer, Socket socket) {
                try {
                    this.productServer = productServer;
                    this.socket = socket;
                    this.dis = new DataInputStream(socket.getInputStream());
                    this.dos = new DataOutputStream(socket.getOutputStream());
                    receive();
                } catch (IOException e) {
                    close();
                }
            }

            public void receive() {
                productServer.threadPool.execute(() -> {
                    try {
                        while(true) {
                            String requestJson = dis.readUTF();
                            JSONObject request = new JSONObject(requestJson);
                            int menu = request.getInt("menu");

                            switch(menu) {
                                case 0:
                                    list();
                                    break;
                                case 1:
                                    create(request);
                                    break;
                                case 2:
                                    update(request);
                                    break;
                                case 3:
                                    delete(request);
                                    break;
                            }
                        }
                    } catch(Exception e) {
                        close();
                    }
                });
            }

            public void list() throws IOException {
                JSONArray data = new JSONArray();
                for(Product p : productServer.products) {
                    JSONObject product = new JSONObject();
                    product.put("no", p.getNo());
                    product.put("name", p.getName());
                    product.put("price", p.getPrice());
                    product.put("stock", p.getStock());
                    data.put(product);
                }

                JSONObject response = new JSONObject();
                response.put("status", "success");
                response.put("data", data);
                dos.writeUTF(response.toString());
                dos.flush();
            }

            public void create(JSONObject request) throws IOException {
                JSONObject data = request.getJSONObject("data");
                Product product = new Product();
                product.setNo(++productServer.sequence);
                product.setName(data.getString("name"));
                product.setPrice(data.getInt("price"));
                product.setStock(data.getInt("stock"));
                productServer.products.add(product);

                list();
            }

            public void update(JSONObject request) throws IOException {
                JSONObject data = request.getJSONObject("data");
                int no = data.getInt("no");
                for(int i=0; i<productServer.products.size(); i++) {
                    Product product = productServer.products.get(i);
                    if(product.getNo() == no) {
                        product.setName(data.getString("name"));
                        product.setPrice(data.getInt("price"));
                        product.setStock(data.getInt("stock"));
                    }
                }
                list();
            }

            public void delete(JSONObject request) throws IOException {
            	JSONObject data = request.getJSONObject("data");
                int no = data.getInt("no");
                for(int i=0; i<productServer.products.size(); i++) {
                    Product product = productServer.products.get(i);
                    if(product.getNo() == no) {
                        productServer.products.remove(i);
                    }
                }
                list();
            }

            public void close() {
                try {
                	socket.close();
                } catch(Exception e) {}
            }
        }
    }
    ```

    **ProductClient.java** (클라이언트 구현)
    ```java
    package ch19.check;

    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.Socket;
    import java.util.Scanner;

    import org.json.JSONArray;
    import org.json.JSONObject;

    public class ProductClient {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;
        private Scanner scanner;

        public void start() throws IOException {
            socket = new Socket("localhost", 50001);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            
            list();
        }

        public void stop() {
            try {
                socket.close();
                scanner.close();
            } catch(Exception e) {}
            System.out.println("[클라이언트] 종료");
        }

        public void list() throws IOException {
            System.out.println("\n[상품 목록]");
            System.out.println("--------------------------------------------------");
            System.out.println("no\tname\t\tprice\tstock");
            System.out.println("--------------------------------------------------");
            
            // 서버에 목록 요청
            JSONObject request = new JSONObject();
            request.put("menu", 0);
            request.put("data", new JSONObject());
            dos.writeUTF(request.toString());
            dos.flush();
            
            // 응답 받기
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	JSONArray data = response.getJSONArray("data");
            	for(int i=0; i<data.length(); i++) {
            		JSONObject product = data.getJSONObject(i);
            		System.out.println(
            			product.getInt("no") + "\t" + 
            			product.getString("name") + "\t" + 
            			product.getInt("price") + "\t" + 
            			product.getInt("stock")
            		);
            	}
            }
            
            menu();
        }

        public void menu() throws IOException {
            System.out.println("--------------------------------------------------");
            System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
            System.out.print("선택: ");
            String menuNo = scanner.nextLine();
            switch(menuNo) {
                case "1": create(); break;
                case "2": update(); break;
                case "3": delete(); break;
                case "4": stop(); return;
            }
        }

        public void create() throws IOException {
            System.out.println("[상품 생성]");
            Product product = new Product();
            System.out.print("상품 이름: ");
            product.setName(scanner.nextLine());
            System.out.print("상품 가격: ");
            product.setPrice(Integer.parseInt(scanner.nextLine()));
            System.out.print("상품 재고: ");
            product.setStock(Integer.parseInt(scanner.nextLine()));

            JSONObject data = new JSONObject();
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("stock", product.getStock());

            JSONObject request = new JSONObject();
            request.put("menu", 1);
            request.put("data", data);

            dos.writeUTF(request.toString());
            dos.flush();
            
            // 응답 대기 및 목록 갱신
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	list();   
            }
        }
        
        public void update() throws IOException {
            System.out.println("[상품 수정]");
            Product product = new Product();
            System.out.print("상품 번호: ");
            product.setNo(Integer.parseInt(scanner.nextLine()));
            System.out.print("이름 변경: ");
            product.setName(scanner.nextLine());
            System.out.print("가격 변경: ");
            product.setPrice(Integer.parseInt(scanner.nextLine()));
            System.out.print("재고 변경: ");
            product.setStock(Integer.parseInt(scanner.nextLine()));

            JSONObject data = new JSONObject();
            data.put("no", product.getNo());
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("stock", product.getStock());

            JSONObject request = new JSONObject();
            request.put("menu", 2);
            request.put("data", data);

            dos.writeUTF(request.toString());
            dos.flush();

            // 응답 대기 및 목록 갱신
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	list();   
            }
        }

        public void delete() throws IOException {
            System.out.println("[상품 삭제]");
            System.out.print("상품 번호: ");
            int no = Integer.parseInt(scanner.nextLine());

            JSONObject data = new JSONObject();
            data.put("no", no);

            JSONObject request = new JSONObject();
            request.put("menu", 3);
            request.put("data", data);

            dos.writeUTF(request.toString());
            dos.flush();

            // 응답 대기 및 목록 갱신
            String responseJson = dis.readUTF();
            JSONObject response = new JSONObject(responseJson);
            if(response.getString("status").equals("success")) {
            	list();   
            }
        }

        public static void main(String[] args) {
            try {
                ProductClient productClient = new ProductClient();
                productClient.start();
            } catch(Exception e) {
            	e.printStackTrace();
            	System.out.println("[클라이언트] 서버 연결 안됨");
            }
        }
    }
    ```
