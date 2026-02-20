---
layout: basic
title: "3.7 논리 연산자"
nav_order: 7
parent: "Chapter 03. 연산자"
grand_parent: "객체지향 자바 프로그래밍"
---

# 3.7 논리 연산자

논리 연산자는 논리곱(`&&`), 논리합(`||`), 배타적 논리합(`^`) 그리고 논리 부정(`!`) 연산을 수행한다. 논리 연산은 흐름 제어문인 조건문(`if`), 반복문(`for`, `while`) 등에서 주로 이용된다.

| 구분                | 연산식        | 설명                                                                           |
| :------------------ | :------------ | :----------------------------------------------------------------------------- |
| AND (논리곱)        | `&&` 또는 `&` | 피연산자 모두가 `true`일 경우에만 연산 결과가 `true`                           |
| OR (논리합)         | `             |                                                                                | ` 또는 ` | ` | 피연산자 중 하나만 `true`이면 연산 결과는 `true` |
| XOR (배타적 논리합) | `^`           | 피연산자가 하나는 `true`이고 다른 하나가 `false`일 경우에만 연산 결과가 `true` |
| NOT (논리 부정)     | `!`           | 피연산자의 논리값을 바꿈                                                       |

`&&`와 `&`는 산출 결과는 같지만 연산 과정이 조금 다르다. `&&`는 앞의 피연산자가 `false`라면 뒤의 피연산자를 평가하지 않고 바로 `false`를 산출한다. 그러나 `&`는 두 피연산자 모두를 평가해서 산출 결과를 낸다. 따라서 `&`보다는 `&&`가 더 효율적으로 동작한다.
`||`와 `|`도 마찬가지이다. `||`는 앞의 피연산자가 `true`라면 뒤의 피연산자를 평가하지 않고 바로 `true`를 산출하지만, `|`는 두 피연산자 모두를 평가해서 산출 결과를 낸다.

다음 예제는 `if`문의 조건식에 논리 연산자를 사용하였다. 조건식이 `true`라면 `if` 블록을 실행한다. 5~7라인과 23~24라인의 주석을 옮겨 가며 실행해 보길 바란다.

**[예제: LogicalOperatorExample.java]**
```java
package ch03.sec07;

public class LogicalOperatorExample {
    public static void main(String[] args) {
        int charCode = 'A';
        //int charCode = 'a';
        //int charCode = '5';
        
        if( (65<=charCode) & (charCode<=90) ) {
            System.out.println("대문자이군요.");
        }
        
        if( (97<=charCode) && (charCode<=122) ) {
            System.out.println("소문자이군요.");
        }
        
        if( (48<=charCode) && (charCode<=57) ) {
            System.out.println("0~9 숫자이군요.");
        }
        
        //-----------------------------------------
        
        int value = 6;
        //int value = 7;
        
        if( (value%2==0) | (value%3==0) ) {
            System.out.println("2 또는 3의 배수이군요.");
        }
        
        boolean result = (value%2==0) || (value%3==0);
        if( !result ) {
            System.out.println("2 또는 3의 배수가 아니군요.");
        }
    }
}
```

**실행 결과**
```
대문자이군요.
2 또는 3의 배수이군요.
```
