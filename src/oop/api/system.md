---
layout: oop
title: "15.4 System 클래스"
nav_order: 4
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
---

# 15.4 System 클래스


<br>

## 1. 운영체제(OS)의 대리인 🕵️‍♂️

자바 프로그램은 운영체제(Windows, Mac 등) 위에서 바로 실행되는 것이 아니라, **JVM(자바 가상 머신)**이라는 보호막 안에서 실행됩니다.
그래서 운영체제의 기능을 직접 건드리기 어렵습니다. 이때 **`System` 클래스**가 운영체제와 소통할 수 있는 창구(대리인) 역할을 해줍니다.


<br>

## 2. 주요 기능 (Dashboard)

`System` 클래스는 모두 **정적(static) 필드와 메소드**로 구성되어 있어서, 객체를 생성하지 않고 바로 쓸 수 있습니다.

### 1) 입출력 (Input/Output)
*   **`System.out`**: 모니터로 데이터를 보냄 (출력).
*   **`System.in`**: 키보드에서 데이터를 받음 (입력).
*   **`System.err`**: 에러 메시지를 보냄 (빨간 글씨 출력).

### 2) 프로그램 제어
*   **`System.exit(0)`**: 프로그램 강제 종료. (0은 정상 종료를 의미)
*   **`System.currentTimeMillis()`**: 현재 시간을 밀리초(1/1000초) 단위로 리턴. (성능 측정용 스톱워치)


<br>

## 3. 예제: 성능 측정 (스톱워치)

`currentTimeMillis()`를 이용해 프로그램 실행 시간을 재는 예제입니다.

```java
package ch15.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        // 1. 시작 시간 기록
        long time1 = System.currentTimeMillis();

        int sum = 0;
        for (int i=1; i<=1000000; i++) {
            sum += i;
        }

        // 2. 종료 시간 기록
        long time2 = System.currentTimeMillis();

        System.out.println("1-1000000까지의 합: " + sum);
        System.out.println("계산에 " + (time2 - time1) + " 밀리초가 소요되었습니다.");
    }
}
```


<br>

## 4. 예제: 시스템 정보 확인

내 컴퓨터의 정보를 확인해 봅시다.

```java
package ch15.sec04;

public class GetPropertyExample {
    public static void main(String[] args) {
        // 운영체제 이름
        String osName = System.getProperty("os.name");
        // 사용자 이름
        String userName = System.getProperty("user.name");
        // 사용자 홈 디렉토리
        String userHome = System.getProperty("user.home");

        System.out.println("운영체제: " + osName);
        System.out.println("사용자: " + userName);
        System.out.println("홈 디렉토리: " + userHome);
    }
}
```

> **핵심**: `System` 클래스는 **운영체제와 대화하는 도구**입니다. 주로 **출력(`out`)**과 **시간 측정**에 많이 쓰입니다.
