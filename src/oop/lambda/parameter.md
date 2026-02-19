---
layout: oop
title: "18.3 매개변수가 있는 람다식"
nav_order: 3
parent: "Chapter 18. 람다식"
grand_parent: "객체지향 자바 프로그래밍"
---

# 18.3 매개변수가 있는 람다식


<br>

## 1. 자판기 동전 투입구 🪙

매개변수가 있다는 것은 **"외부에서 재료를 받아서 처리한다"**는 뜻입니다.
마치 **자판기**에 동전을 넣으면 음료가 나오는 것과 같습니다.

*   문법: `(x) -> { ... }`


<br>

## 2. 문법 규칙

매개변수의 타입(int, String 등)은 런타임 시에 대입되는 값에 따라 자동으로 인식되므로 **생략하는 것이 일반적**입니다.

```java
// 정석 (타입 명시)
(String name) -> { System.out.println(name); }

// 약식 (타입 생략 - 추천)
(name) -> { System.out.println(name); }

// 초약식 (매개변수가 하나일 때만 괄호 생략 가능)
name -> System.out.println(name);
```


<br>

## 3. 예제: 매개변수 처리

**함수형 인터페이스 정의**
```java
package ch18.sec03;

@FunctionalInterface
public interface Workable {
    void work(String name, String job); // 매개변수 2개
}

@FunctionalInterface
public interface Speakable {
    void speak(String content); // 매개변수 1개
}
```

**실행 코드**
```java
package ch18.sec03;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 1. 매개변수가 두 개일 경우 (괄호 필수)
        person.action1((name, job) -> {
            System.out.print(name + "이 ");
            System.out.println(job + "을 합니다.");
        });
        
        // 한 줄로 줄이기
        person.action1((name, job) -> System.out.println(name + "이 " + job + "을 하지 않습니다."));

        // 2. 매개변수가 한 개일 경우 (괄호 생략 가능)
        person.action2(word -> {
            System.out.print("\"" + word + "\"");
            System.out.println("라고 말합니다.");
        });
        
        // 한 줄로 줄이기
        person.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
    }
}
```

**실행 결과**
```
홍길동이 프로그래밍을 합니다.
홍길동이 프로그래밍을 하지 않습니다.
"안녕하세요"라고 말합니다.
"안녕하세요"라고 외칩니다.
```

> **핵심**: 매개변수가 **하나**일 때만 괄호 `()`를 생략할 수 있습니다. 두 개 이상이면 반드시 `(a, b)`처럼 묶어야 합니다.
