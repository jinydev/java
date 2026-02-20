---
layout: basic
title: "3.6 비교 연산자"
nav_order: 6
parent: "Chapter 03. 연산자"
grand_parent: "객체지향 자바 프로그래밍"
---

# 3.6 비교 연산자

비교 연산자는 동등(`==`, `!=`) 또는 크기(`<`, `<=`, `>`, `>=`)를 평가해서 booelean 타입인 `true`/`false`를 산출한다. 비교 연산자는 흐름 제어문인 조건문(`if`), 반복문(`for`, `while`)에서 실행 흐름을 제어할 때 주로 사용된다.

| 구분      | 연산식                   | 설명                           |
| :-------- | :----------------------- | :----------------------------- |
| 동등 비교 | 피연산자1 `==` 피연산자2 | 두 피연산자의 값이 같은지 검사 |
|           | 피연산자1 `!=` 피연산자2 | 두 피연산자의 값이 다른지 검사 |
| 크기 비교 | 피연산자1 `>` 피연산자2  | 피연산자1이 큰지 검사          |
|           | 피연산자1 `>=` 피연산자2 | 피연산자1이 크거나 같은지 검사 |
|           | 피연산자1 `<` 피연산자2  | 피연산자1이 작은지 검사        |
|           | 피연산자1 `<=` 피연산자2 | 피연산자1이 작거나 같은지 검사 |

피연산자의 타입이 다를 경우에는 비교 연산을 수행하기 전에 타입을 일치시킨다. 예를 들어 `'A' == 65`는 `'A'`가 `int` 타입으로 변환되어 65가 된 다음 `65 == 65`로 비교한다. 마찬가지로 `3 == 3.0`은 3을 `double` 타입인 3.0으로 변환한 다음 `3.0 == 3.0`으로 비교한다.

```java
'A' == 65 -> true
3 == 3.0 -> true
```

한 가지 예외가 있다. `0.1f == 0.1`에서 `0.1f`가 `double` 타입으로 변환되면 `0.1 == 0.1`이 되어 `true`가 산출되어야 하지만, 이 결과값은 `false`가 산출된다.

```java
0.1f == 0.1 -> false
```

그 이유는 부동 소수점 방식을 사용하는 실수 타입은 0.1을 정확히 표현할 수 없을 뿐만 아니라 `float` 타입과 `double` 타입의 정밀도 차이 때문이다. 해결책은 다음과 같이 피연산자를 `float` 타입으로 강제 타입 변환 후에 비교 연산을 하면 된다.

```java
0.1f == (float) 0.1 -> true
```

문자열을 비교할 때에는 동등(`==`, `!=`) 연산자 대신 `equals()`와 `!equals()`를 사용한다. 그 이유는 5장에서 자세히 설명한다.

```java
boolean result = str1.equals(str2); //문자열이 같은지 검사 (대소문자 구분)
boolean result = !str1.equals(str2); //문자열이 다른지 검사
```

**[예제: CompareOperatorExample.java]**
```java
package ch03.sec06;

public class CompareOperatorExample {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);
        
        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = (char1 < char2); //65 < 66
        System.out.println("result4: " + result4);
        
        int num3 = 1;
        double num4 = 1.0;
        boolean result5 = (num3 == num4);
        System.out.println("result5: " + result5);
        
        float num5 = 0.1f;
        double num6 = 0.1;
        boolean result6 = (num5 == num6);
        boolean result7 = (num5 == (float) num6);
        System.out.println("result6: " + result6);
        System.out.println("result7: " + result7);
        
        String str1 = "자바";
        String str2 = "Java";
        boolean result8 = (str1.equals(str2));
        boolean result9 = (!str1.equals(str2));
        System.out.println("result8: " + result8);
        System.out.println("result9: " + result9);
    }
}
```

**실행 결과**
```
result1: true
result2: false
result3: true
result4: true
result5: true
result6: false
result7: true
result8: false
result9: true
```
