---
layout: basic
title: "2.13 키보드 입력 데이터를 변수에 저장"
nav_order: 13
parent: "Chapter 02. 변수와 타입"
grand_parent: "객체지향 자바 프로그래밍"
---

# 2.13 키보드 입력 데이터를 변수에 저장

키보드로부터 입력된 데이터를 읽는 방법은 여러 가지가 있지만 이것은 17장에서 자세히 다루기로 하고, 여기서는 기업체 코딩 테스트 문제에서 주로 사용하는 방법을 소개하려고 한다. 앞으로 우리 책의 예제나 확인문제에서 키보드로부터 데이터를 입력받을 때 사용하면 된다.

키보드로부터 입력된 데이터를 읽고 변수에 저장하는 가장 쉬운 방법은 `Scanner`를 사용하는 것이다. 다음과 같이 `Scanner` 타입 변수를 선언하고, 대입 연산자 `=`를 사용해서 `new` 연산자로 생성한 `Scanner` 객체를 변수에 대입한다. `new` 연산자는 6장에서 자세히 설명한다.

```java
Scanner scanner = new Scanner(System.in);
```

그리고 다음과 같이 `scanner.nextLine()`을 실행하면 키보드로 입력된 내용을 문자열로 읽고 좌측 `String` 변수에 저장할 수 있다.

```java
String inputData = scanner.nextLine();
```
Enter 키를 누르면 입력된 문자열을 읽음

`scanner.nextLine()`은 Enter 키가 입력되기 전까지 블로킹(대기) 상태가 되며, Enter 키가 입력되면 지금까지 입력된 모든 내용을 문자열로 읽는다.

**[예제: ScannerExample.java]**
```java
package ch02.sec13;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("x 값 입력: ");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);
        
        System.out.print("y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);
        
        int result = x + y;
        System.out.println("x + y: " + result);
        System.out.println();
        
        while(true) {
            System.out.print("입력 문자열: ");
            String data = scanner.nextLine();
            if(data.equals("q")) {
                break;
            }
            System.out.println("출력 문자열: " + data);
            System.out.println();
        }
        
        System.out.println("종료");
    }
}
```

**실행 결과**
```
x 값 입력: 3
y 값 입력: 5
x + y: 8

입력 문자열: Hello
출력 문자열: Hello

입력 문자열: 안녕하세요
출력 문자열: 안녕하세요

입력 문자열: q
종료
```

21라인의 `while(true)` 문은 중괄호 안을 무한히 반복 실행하는 코드로, 4장에서 자세히 설명한다. 24~26라인은 입력된 문자열이 `q`라면 반복을 중단하는 코드이다.
자바는 기본 타입(byte, short, int, long, float, double, boolean) 값이 동일한지 비교할 때는 `==`를 사용하고, `String` 타입 값이 동일한지 비교할 때에는 `equals()`를 사용한다. `String` 타입과 비교에 대해서는 5장에서 자세히 설명한다.

```java
boolean result = data.equals("문자열");
//같으면 true, 다르면 false
```
