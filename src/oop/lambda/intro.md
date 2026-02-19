---
layout: oop
title: "18.1 람다식이란?"
nav_order: 1
parent: "Chapter 18. 람다식"
grand_parent: "객체지향 자바 프로그래밍"
---

# 18.1 람다식이란?


<br>

## 1. 익명 구현 객체의 다이어트 🏃

자바 8부터 도입된 **람다식(Lambda Expressions)**은 코드를 아주 간결하게 만들어주는 문법입니다.
특히 **인터페이스의 익명 구현 객체**를 만들 때 효과적입니다.

마치 **"리모컨 조립 세트"**와 같습니다.
*   **익명 구현 객체**: 플라스틱 케이스, 배터리 커버, 버튼 고무 등을 다 조립해야 함. (코드가 길다)
*   **람다식**: **"핵심 칩(로직)"**만 꽂으면 바로 동작함. (코드가 짧다)

![Lambda Concept](./img/lambda_concept.svg)

<br>


<br>

## 2. 코드 비교

예를 들어 `Calculable` 인터페이스가 있다고 가정해 봅시다.

```java
public interface Calculable {
    void calculate(int x, int y);
}
```

이 인터페이스를 구현해서 사용하는 방법을 비교해 보겠습니다.

### 1) 기존 방식 (익명 구현 객체)
```java
// 코드가 길고 복잡해 보입니다.
new Calculable() {
    @Override
    public void calculate(int x, int y) {
        System.out.println(x + y);
    }
};
```

### 2) 람다식 방식
```java
// 핵심 로직만 남았습니다.
(x, y) -> { System.out.println(x + y); }
```

람다식은 **`(매개변수) -> { 실행코드 }`** 형태로 작성합니다.
자바 컴파일러는 이 코드를 보고 "아, `Calculable` 인터페이스를 구현한 익명 객체구나!"라고 똑같이 해석해서 `.class` 파일을 만듭니다.

<br>


<br>

## 3. 함수형 인터페이스 (@FunctionalInterface)

람다식은 **추상 메소드가 딱 하나인 인터페이스**에만 사용할 수 있습니다.
이런 인터페이스를 **함수형 인터페이스(Functional Interface)**라고 부릅니다.

두 개 이상의 추상 메소드가 있으면 람다식이 어떤 메소드를 구현하는지 알 수 없기 때문입니다.
`@FunctionalInterface` 어노테이션을 붙이면, 컴파일러가 "추상 메소드가 하나인지" 검사해 줍니다.

```java
@FunctionalInterface
public interface Calculable {
    void calculate(int x, int y);
    // void anotherMethod(); // 이게 있으면 에러 발생!
}
```

<br>


<br>

## 4. 예제 코드

```java
package ch18.sec01;

public class LambdaExample {
    public static void main(String[] args) {
        // 1. 덧셈 처리 람다식
        action((x, y) -> {
            int result = x + y;
            System.out.println("result: " + result);
        });

        // 2. 뺄셈 처리 람다식
        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }

    public static void action(Calculable calculable) {
        // 데이터
        int x = 10;
        int y = 4;
        // 데이터 처리 (람다식으로 전달된 로직 실행)
        calculable.calculate(x, y);
    }
}
```

**실행 결과**
```
result: 14
result: 6
```
