---
layout: basic
title: "3.2 산술 연산자"
nav_order: 2
parent: "Chapter 03. 연산자"
grand_parent: "객체지향 자바 프로그래밍"
---

# 3.2 산술 연산자

산술 연산자는 더하기(`+`), 빼기(`-`), 곱하기(`*`), 나누기(`/`), 나머지(`%`)로 총 5개이다.

| 연산식                | 설명                            |
| :-------------------- | :------------------------------ |
| 피연산자 `+` 피연산자 | 덧셈 연산                       |
| 피연산자 `-` 피연산자 | 뺄셈 연산                       |
| 피연산자 `*` 피연산자 | 곱셈 연산                       |
| 피연산자 `/` 피연산자 | 나눗셈 연산                     |
| 피연산자 `%` 피연산자 | 나눗셈의 나머지를 산출하는 연산 |

곱셈의 경우 `*`를 사용하고 나눗셈의 경우 `/`를 사용한다는 것이 일반 수학과 다르다. `%` 연산자는 나눗셈을 수행한 후에 몫이 아닌 나머지를 산출하는 연산자이다.

```java
int result = num % 3;
//0, 1, 2 중 한 값 (num을 3으로 나눈 나머지)
```

산술 연산의 특징은 다음과 같다(2.9절 참고).
* 피연산자가 정수 타입(byte, short, char, int)이면 연산의 결과는 `int` 타입이다.
* 피연산자가 정수 타입이고 그 중 하나가 `long` 타입이면 연산의 결과는 `long` 타입이다.
* 피연산자 중 하나가 실수 타입이면 연산의 결과는 실수 타입이다.

**[예제: ArithmeticOperatorExample.java]**
```java
package ch03.sec02;

public class ArithmeticOperatorExample {
    public static void main(String[] args) {
        byte v1 = 10;
        byte v2 = 4;
        int v3 = 5;
        long v4 = 10L;
        
        int result1 = v1 + v2; //모든 피연산자는 int 타입으로 자동 변환 후 연산
        System.out.println("result1: " + result1);
        
        long result2 = v1 + v2 - v4; //모든 피연산자는 long 타입으로 자동 변환 후 연산
        System.out.println("result2: " + result2);
        
        double result3 = (double) v1 / v2; //double 타입으로 강제 변환 후 연산
        System.out.println("result3: " + result3);
        
        int result4 = v1 % v2;
        System.out.println("result4: " + result4);
    }
}
```

**실행 결과**
```
result1: 14
result2: 4
result3: 2.5
result4: 2
```
