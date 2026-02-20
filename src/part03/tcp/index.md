---
layout: part03
title: "Chapter 19. 네트워크 입출력"
nav_order: 19
has_children: true
parent: "라이브러리 활용"
---

# Chapter 19. 네트워크 입출력

## 학습목표

TCP/UDP 네트워크 프로그래밍을 통해 데이터를 주고받는 통신 프로그램을 작성해 봅니다.

## 목차

### [19.1 네트워크 기초](./01/)

네트워크Network는 여러 컴퓨터들을 통신 회선으로 연결한 것을 말한다. LANLocal Area Network은 가정, 회사, 건물, 특정 영역에 존재하는 컴퓨터를 연결한 것이고, WANWide Area Network은 LAN을 연결한 것이다. WAN이 우리가 흔히...

### [19.2 IP 주소 얻기](./02/)

컴퓨터에도 고유한 주소가 있다. 바로 IPInternet Protocol 주소이다. IP 주소는 네트워크 어댑터LAN 카드마다 할당된다. 네트워크 어댑터에 어떤 IP 주소가 부여되어 있는지 확인하려면 윈도우에서는 ipconfig 명령어를, 맥OS에서는 ifconfig...

### [19.3 TCP 네트워킹](./03/)

IP 주소로 프로그램들이 통신할 때는 약속된 데이터 전송 규약이 있다. 이것을 전송용 프로토콜Transfer Protocol이라고 부른다. 인터넷에서 전송용 프로토콜은 TCPTransmission Control Protocol와 UDPUser Datagram Proto...

### [19.4 UDP 네트워킹](./04/)

UDPUser Datagram Protocol는 발신자가 일방적으로 수신자에게 데이터를 보내는 방식으로, TCP처럼 연결 요청 및 수락 과정이 없기 때문에 TCP보다 데이터 전송 속도가 상대적으로 빠르다. 하지만 데이터 신뢰성은 낮다. 자바는 UDP 네트워킹을 위해 j...

### [19.5 서버의 동시 요청 처리](./05/)

일반적으로 서버는 다수의 클라이언트와 통신을 한다. accept와 receive를 제외한 요청 처리 코드를 별도의 스레드에서 작업하는 것이 좋다. 스레드를 처리할 때 주의할 점은 클라이언트의 폭증으로 인한 서버의 과도한 스레드 생성을 방지해야 한다는 것이다. 그래서 스...

### [19.6 JSON 데이터 형식](./06/)

네트워크로 전달하는 데이터가 복잡할수록 구조화된 형식이 필요하다. JSONJavaScript Object Notation은 네트워크 통신에서 가장 많이 사용되는 데이터 형식이다. JSON을 자바에서 처리하기 위해 org.json 라이브러리를 사용한다.    JSONOb...

### [19.7 TCP 채팅 프로그램](./07/)

TCP 네트워킹을 이용해서 채팅 서버와 클라이언트를 구현할 수 있다. package ch19.sec07; import java.io.IOException; import java.net.ServerSocket; import java.net.Socket; import ja...

## 확인문제
- [확인문제](./quiz)
