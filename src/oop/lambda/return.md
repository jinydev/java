---
layout: oop
title: "18.4 리턴값이 있는 람다식"
nav_order: 4
parent: "Chapter 18. 람다식"
grand_parent: "객체지향 자바 프로그래밍"
---

# 18.4 리턴값이 있는 람다식


<br>

## 1. 계산기 (Input -> Output) 🧮

값을 받아서 처리한 뒤, **결과를 돌려주는(Return)** 람다식입니다.
마치 **계산기**나 **믹서기**(과일 넣으면 주스 나옴)와 같습니다.

*   문법: `(x, y) -> { return x + y; }`


<br>

## 2. 문법 규칙 (return 생략)

실행문이 **`return` 문 딱 하나**인 경우에는, **`return` 키워드와 중괄호 `{}`를 동시에 생략**할 수 있습니다. (이게 핵심입니다!)

```java
// 1. 정석 (중괄호 + return 사용)
(x, y) -> {
    return x + y;
}

// 2. 약식 (중괄호와 return 동시 생략 - 가장 많이 씀)
(x, y) -> x + y
```


<br>

## 3. 예제: 계산기 구현

**함수형 인터페이스 정의**
```java
package ch18.sec04;

@FunctionalInterface
public interface Calcuable {
    double calc(double x, double y); // 리턴값이 있는 메소드
}
```

**실행 코드**
```java
package ch18.sec04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 1. 정석 방식
        person.action((x, y) -> {
            double result = x + y;
            return result;
        });

        // 2. 약식 (표현식) - 덧셈
        // return (x + y); 와 동일
        person.action((x, y) -> (x + y));

        // 3. 약식 - 메소드 호출
        // return sum(x, y); 와 동일
        person.action((x, y) -> sum(x, y));
    }

    public static double sum(double x, double y) {
        return (x + y);
    }
}
```

**실행 결과**
```
결과: 14.0
결과: 14.0
결과: 14.0
```

> **핵심**: `(x, y) -> x + y`라고 쓰면 컴파일러가 알아서 `"아, x + y 값을 리턴하라는 거구나"`라고 해석합니다.
