---
layout: oop
title: "18.5 메소드 참조"
nav_order: 5
parent: "Chapter 18. 람다식"
grand_parent: "객체지향 자바 프로그래밍"
---

# 18.5 메소드 참조 (Method Reference)


<br>

## 1. "재사용"의 끝판왕 ♻️

람다식도 짧지만, **이미 있는 메소드**를 사용할 때는 더 짧게 줄일 수 있습니다.
매개변수를 받아서 토스(toss)만 하는 경우라면, **"그냥 쟤꺼 쓰세요"**라고 가리키는 것이 **메소드 참조**입니다.

*   람다식: `(left, right) -> Math.max(left, right);`
*   메소드 참조: `Math :: max;`


<br>

## 2. 사용 방법 (`::`)

콜론 두 개(`::`)를 사용합니다.

### 1) 정적(static) 메소드 참조
```java
// 클래스명 :: 메소드명
Math :: max
Computer :: staticMethod
```

### 2) 인스턴스 메소드 참조
```java
// 참조변수 :: 메소드명
System.out :: println
com :: instanceMethod
```

### 3) 매개변수의 메소드 참조
첫 번째 매개변수(`a`)가 메소드의 주인이 되고, 두 번째 매개변수(`b`)가 인자가 되는 경우입니다.
*   람다식: `(a, b) -> a.compareToIgnoreCase(b)`
*   참조: `String :: compareToIgnoreCase` (타입 :: 메소드명)


<br>

## 3. 예제: 계산기와 문자열 비교

```java
package ch18.sec05;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 1. 정적 메소드 참조
        // 람다식: (x, y) -> Computer.staticMethod(x, y)
        person.action(Computer :: staticMethod);

        // 2. 인스턴스 메소드 참조
        Computer com = new Computer();
        // 람다식: (x, y) -> com.instanceMethod(x, y)
        person.action(com :: instanceMethod);
        
        // 3. 매개변수의 메소드 참조
        // 람다식: (a, b) -> a.compareToIgnoreCase(b)
        person.ordering(String :: compareToIgnoreCase);
    }
}
```

**실행 결과**
```
결과: 14.0  (정적 메소드: 10 + 4)
결과: 40.0  (인스턴스 메소드: 10 * 4)
홍길동은 김길동보다 뒤에 옵니다. (String 비교)
```

> **핵심**: "내가 직접 코드를 짜는 게 아니라, **이미 있는 메소드를 연결만 시켜줄 때**" 사용합니다.
