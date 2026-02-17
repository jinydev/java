---
layout: part04
title: "Chapter 18. JDBC"
nav_order: 18
has_children: true
parent: "데이터 입출력"
---

# Chapter 18. 데이터 입출력

## 학습목표

데이터의 입력과 출력을 담당하는 입출력 스트림의 종류와 사용법을 학습합니다.


## 목차

### [18.1 입출력 스트림](./01)

데이터는 키보드를 통해 입력될 수도 있고, 파일 또는 프로그램으로부터 입력될 수도 있다. 반대로 데이터는 모니터로 출력될 수도 있고, 파일에 저장되거나 다른 프로그램으로 전송될 수 있다. 이것을 총칭해서 데이터 입출력이라고 한다. 자바는 입력 스트림과 출력 스트림을 통...

### [18.2 바이트 출력 스트림](./02)

OutputStream은 바이트 출력 스트림의 최상위 클래스로 추상 클래스이다. 모든 바이트 출력 스트림 클래스는 이 OutputStream 클래스를 상속받아서 만들어진다. OutputStream 클래스에는 모든 바이트 출력 스트림이 기본적으로 가져야 할 메소드가 정의...

### [18.3 바이트 입력 스트림](./03)

InputStream은 바이트 입력 스트림의 최상위 클래스로, 추상 클래스이다. 모든 바이트 입력 스트림은 InputStream 클래스를 상속받아서 만들어진다. InputStream 클래스에는 바이트 입력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다. read...

### [18.4 문자 입출력 스트림](./04)

바이트 입출력 스트림인 InputStream과 OutputStream에 대응하는 문자 입출력 스트림으로 Reader와 Writer가 있다. 입출력되는 단위가 문자인 것을 제외하고는 바이트 입출력 스트림과 사용 방법은 동일하다. Writer는 문자 출력 스트림의 최상위...

### [18.5 보조 스트림](./05)

보조 스트림이란 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림을 말한다. 보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에 입출력 소스로부터 직접 생성된 입출력 스트림에 연결해서 사용해야 한다. 보조스트림 변수 = new 보조스트림입출력스트림...

### [18.6 문자 변환 스트림](./06)

바이트 스트림 InputStream, OutputStream에서 입출력할 데이터가 문자라면 문자 스트림 Reader, Writer으로 변환해서 사용하는 것이 좋다. InputStream is = new FileInputStream"C:/Temp/test.txt"; Re...

### [18.7 성능 향상 스트림](./07)

프로그램이 입출력 소스와 직접 작업하지 않고 중간에 메모리 버퍼buffer와 작업함으로써 실행 성능을 향상시킬 수 있다.    바이트 스트림: BufferedInputStream, BufferedOutputStream    문자 스트림: BufferedReader, B...

### [18.8 기본 타입 스트림](./08)

바이트 스트림에 DataInputStream과 DataOutputStream 보조 스트림을 연결하면 기본 타입인 boolean, char, short, int, long, float, double 값을 입출력할 수 있다. package ch18.sec08; import...

### [18.9 프린트 스트림](./09)

PrintStream과 PrintWriter는 print, println, printf 메소드를 가지고 있는 보조 스트림이다.    PrintStream: 바이트 출력 스트림과 연결    PrintWriter: 문자 출력 스트림과 연결 package ch18.sec09...

### [18.10 객체 스트림](./10)

자바는 메모리에 생성된 객체를 파일 또는 네트워크로 출력할 수 있다. 객체를 출력하려면 필드값을 일렬로 늘어선 바이트로 변경해야 하는데, 이것을 직렬화serialization라고 한다. 반대로 직렬화된 바이트를 객체의 필드값으로 복원하는 것을 역직렬화deserializ...

### [18.11 File과 Files 클래스](./11)

java.io 패키지와 java.nio.file 패키지는 파일과 디렉토리 정보를 가지고 있는 File과 Files 클래스를 제공한다. File 클래스로부터 File 객체를 생성하는 방법은 다음과 같다. File file = new File"C:/Temp/file.txt...

## 확인문제
- [확인문제](./quiz)
