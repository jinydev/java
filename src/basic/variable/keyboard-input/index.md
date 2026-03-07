---
layout: basic
title: "4.11 키보드 입력"
nav_order: 11
parent: "Chapter 04. 변수와 타입"
grand_parent: "Part 01. 자바 언어의 기초"
사용자에게 태어난 연도를 입력받아 나이를 계산하는 프로그램입니다.

```java
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        // 1. 스캐너 생성
        Scanner scanner = new Scanner(System.in);

        // 2. 안내 메시지 출력
        System.out.print("태어난 연도를 입력하세요: ");

        // 3. 문자열로 입력 받기
        String str = scanner.nextLine(); 

        // 4. 숫자로 변환 (Parsing)
        int birthYear = Integer.parseInt(str);
        int age = 2024 - birthYear;

        // 5. 결과 출력
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}
```

---

## 4. 자주 하는 실수: nextInt() 사용 시 주의 ⚠️

숫자를 입력받을 때 `scanner.nextInt()`를 사용하면 편해 보이지만, **줄바꿈 문자(Enter)**가 찌꺼기처럼 남아서 다음 입력을 방해할 수 있습니다.

> **추천 방법**: 무조건 **`nextLine()`**으로 문자열을 모두 읽어들인 후, 필요하면 **`Integer.parseInt()`** 또는 **`Double.parseDouble()`** 로 변환하는 것이 정신 건강에 좋습니다. 👍

---

## 5. 심화: 상황별 맞춤 입력 기법 🚀

### 1) 무한 반복해서 계속 입력받기 (조건을 주고루프 돌기)
프로그램이 한 번만 묻고 끝나는 것이 아니라, 사용자가 `exit`나 `q` 같은 특별한 종료 명령어를 입력할 때까지 "계속해서" 글을 받아내야 할 때가 아주 많습니다. 이때는 무한 반복문(`while(true)`)과 `nextLine()`을 찰떡 조합으로 활용합니다.

```java
Scanner scanner = new Scanner(System.in);
System.out.println("채팅 프로그램 시작! (종료하려면 'q' 입력)");

while (true) {
    System.out.print("말을 걸어보세요: ");
    String input = scanner.nextLine(); // 사용자가 글을 치고 엔터를 칠 때까지 코드가 잠시 대기함

    if (input.equals("q")) { // 만약 입력받은 글자가 "q"라면?
        System.out.println("채팅을 종료합니다. 안녕!");
        break; // 무한 반복의 감옥을 부수고 탈출!
    }
    
    // q가 아니라면 계속 메아리를 쳐줍니다.
    System.out.println("상대방: 그래 너도 " + input + "(이)구나!");
}
```

### 2) 한 글자씩 (원초적인 형태로) 실시간 입력받기
`Scanner`라는 통역사를 거치지 않고, 키보드의 키가 눌렸을 때 발생하는 물리적인 '기계 번호(키코드)'를 가장 원초적인 날것의 형태로 한 글자(1바이트)씩 읽어 들여야 할 때는 가장 원시적인 형태인 **`System.in.read()`**를 사용합니다.

<br>

![Scanner와 System.in.read() 차이 웹툰](./img/char_vs_string_input_webtoon.png)
<br>
*▲ 큰 덩어리(완성된 문장)를 다 모아서 한 번에 와르르 쏟아내는 Scanner(nextLine)의 거대한 덤프트럭과 달리, System.in.read()는 핀셋처럼 아주 작은 한 단위를 한 번에 하나씩만 쏙쏙 섬세하게 집어 옵니다.*

<br>

![System.in.read() 입력 원리 애니메이션](./img/realtime_input_anim.svg)

<br>

```java
// 주의: 메인 메소드 선언부에 발생할 수 있는 오류를 넘겨주는 'throws Exception'을 반드시 적어야 합니다.
// public static void main(String[] args) throws Exception {

System.out.print("영어 알파벳 A를 하나 누르고 엔터를 쳐보세요: ");

// 단 한 글자만 원시 숫자로 읽어옵니다.
int keyCode = System.in.read(); 

System.out.println("읽어온 고유 숫자 코드: " + keyCode);    // 결과: 65
System.out.println("우리가 아는 문자로 복원: " + (char)keyCode); // 결과: A
```

> **⚠️ 주의! (자바의 진정한 "실시간" 입력 한계)**
> 게임 컨트롤처럼 키보드를 누르자마자 0.1초의 지연도 없이 즉각즉각 반응할 것이라 기대하기 쉽지만, 이 코드를 실행해 보면 글자를 누르고 멍 때리고 있다가 **결국 '엔터(Enter)'를 쳐 주어야만** 결과가 나옵니다.
> 이는 자바 언어의 잘못(?)이라기 보다는 윈도우/맥 같은 **운영체제(OS)들이 키보드 데이터를 임시 보관함(버퍼)에 쌓아두고 대기했다가 무조건 엔터가 쳐질 때 비로소 프로그램 진영으로 한꺼번에 밀어 넣는 방식(라인 버퍼링)**을 기본으로 쓰고 있기 때문입니다. 순수하게 OS 버퍼를 무시하는 오락실 게임 같은 완전 100% 무결점 실시간 입력을 구현하려면 초보 챕터를 벗어나는 (JNI 같은) 특수한 외부 라이브러리 도움이 필요하답니다! 🎮

---

## 6. 다 썼으면 문 닫기: scanner.close() 🚪

`Scanner`는 외부 세계(키보드 등)와 연결된 통로(Stream)를 열어두고 계속 입력을 기다리는 객체입니다. 
따라서 메모리와 운영체제 입장에서 통로를 무한정 열어두는 것은 자원 낭비(Resource Leak)가 될 수 있습니다.

<br>

![Scanner 자원 해제 웹툰 일러스트](./img/scanner_close_webtoon.png)
<br>
*▲ 다 사용한 마이크 선을 뽑고(System.in 연결 해제), 스캐너 로봇을 퇴근(close)시켜 주어야 다른 프로그램들이 쾌적하게 컴퓨터를 사용할 수 있습니다!*

<br>

**종료 방법:**
프로그램이 끝나기 전, 혹은 스캐너를 더 이상 안 쓸 때 코딩의 마지막 단계로 **`.close()`**를 호출해 줍니다. 
```java
scanner.close(); // 자원 반납
```

---

## 7. 최종 실전 예제: 프로필 생성기 종합판 👤

위에서 배운 여러 가지 타입의 안전한 입력 방식과, 스캐너 종류(`close()`)를 모두 적용한 종합 실전 코드입니다. 

**[예제: ProfileGenerator.java]**
```java
import java.util.Scanner;

public class ProfileGenerator {
    public static void main(String[] args) {
        // 1. 스캐너 켜기
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 👤 회원 가입 프로필 작성 ===");

        // 문자열 입력
        System.out.print("1. 이름을 입력하세요: ");
        String name = scanner.nextLine();

        // ⚠️ 숫자 입력 (안전한 방식인 nextLine() + parseInt() 조합 사용!)
        System.out.print("2. 나이를 입력하세요: ");
        int age = Integer.parseInt(scanner.nextLine()); 

        System.out.print("3. 키를 입력하세요 (예: 175.5): ");
        double height = Double.parseDouble(scanner.nextLine()); 

        // 4. 그냥 next()를 썼을 때 단어만 가져오는 예
        System.out.print("4. 사시는 도시를 입력하세요 (첫 단어만 저장됨): ");
        String city = scanner.next(); 
        // 만약 "서울 특별시" 라고 치면 "서울" 만 city에 들어감

        // 결과 출력 (이전 시간에 배운 printf 활용)
        System.out.println("\n--- 가입 완료! ---");
        System.out.printf("[%s]님(나이: %d, 키: %.1f) 환영합니다! (%s 거주)\n", name, age, height, city);

        // 5. 다 썼으니 깔끔하게 자원 반납 (퇴근!)
        scanner.close(); 
    }
}
```
