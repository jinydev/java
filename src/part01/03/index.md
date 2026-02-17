---
layout: part01
title: "Chapter 03. 연산자"
permalink: /part01/03/
---

# Chapter 03

## 연산자

**목차**

* 3.1 부호/증감 연산자
* 3.2 산술 연산자
* 3.3 오버플로우와 언더플로우
* 3.4 정확한 계산은 정수 연산으로
* 3.5 나눗셈 연산 후 NaN과 Infinity 처리
* 3.6 비교 연산자
* 3.7 논리 연산자
* 3.8 비트 논리 연산자
* 3.9 비트 이동 연산자
* 3.10 대입 연산자
* 3.11 삼항(조건) 연산자
* 3.12 연산의 방향과 우선순위

### 3.1 부호/증감 연산자

부호 연산자는 변수의 부호를 유지하거나 변경한다.

| 연산식       | 설명                 |
| :----------- | :------------------- |
| `+` 피연산자 | 피연산자의 부호 유지 |
| `-` 피연산자 | 피연산자의 부호 변경 |

`+` 연산자는 잘 사용되지 않고, `-` 연산자는 변수값의 부호를 변경할 때 사용된다. 주의할 점은 부호 변경 후의 타입이다. 다음 코드는 컴파일 에러가 발생한다.

```java
byte b = 100;
byte result = -b; //컴파일 에러
```

정수 타입(byte, short, int) 연산의 결과는 `int` 타입이다. 부호를 변경하는 것도 연산이므로 다음과 같이 `int` 타입 변수에 대입해야 한다.

```java
byte b = 100;
int result = -b;
```

**[예제: SignOperatorExample.java]**
```java
package ch03.sec01;

public class SignOperatorExample {
    public static void main(String[] args) {
        int x = -100;
        x = -x;
        System.out.println("x: " + x);
        
        byte b = 100;
        int y = -b;
        System.out.println("y: " + y);
    }
}
```

**실행 결과**
```
x: 100
y: -100
```

증감 연산자(`++`, `--`)는 변수의 값을 1 증가시키거나 1 감소시키는 연산자이다.

| 연산식        | 설명                                                 |
| :------------ | :--------------------------------------------------- |
| `++` 피연산자 | 다른 연산을 수행하기 전에 피연산자의 값을 1 증가시킴 |
| `--` 피연산자 | 다른 연산을 수행하기 전에 피연산자의 값을 1 감소시킴 |
| 피연산자 `++` | 다른 연산을 수행한 후에 피연산자의 값을 1 증가시킴   |
| 피연산자 `--` | 다른 연산을 수행한 후에 피연산자의 값을 1 감소시킴   |

변수 단독으로 증감 연산자가 사용될 경우에는 변수의 앞뒤 어디에 붙어도 결과는 동일하다.
`++i;`는 `i = i + 1;`로 동일
`i++;`는 `i = i + 1;`로 동일
`--i;`는 `i = i - 1;`로 동일
`i--;`는 `i = i - 1;`로 동일

하지만 여러 개의 연산자가 포함되어 있는 연산식에서는 증감 연산자의 위치에 따라 결과가 달라진다. 증감 연산자가 변수 앞에 있으면 우선 변수를 1 증가 또는 1 감소시킨 후에 다른 연산을 수행한다. 증감 연산자가 변수 뒤에 있으면 모든 연산을 끝낸 후에 변수를 1 증가 또는 1 감소시킨다.

```java
int x = 1;
int y = 1;
int result1 = ++x + 10; //x를 1 증가 -> int result1 = 2 + 10;
int result2 = y++ + 10; //int result2 = 1 + 10; -> y를 1 증가
```

위 코드에서 `result1`과 `result2`에는 각각 12와 11이 저장된다. 그리고 최종 `x`와 `y`의 값은 2가 된다.

**[예제: IncreaseDecreaseOperatorExample.java]**
```java
package ch03.sec01;

public class IncreaseDecreaseOperatorExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z;
        
        x++;
        ++x;
        System.out.println("x=" + x);
        
        System.out.println("-----------------------");
        y--;
        --y;
        System.out.println("y=" + y);
        
        System.out.println("-----------------------");
        z = x++;
        System.out.println("z=" + z);
        System.out.println("x=" + x);
        
        System.out.println("-----------------------");
        z = ++x;
        System.out.println("z=" + z);
        System.out.println("x=" + x);
        
        System.out.println("-----------------------");
        z = ++x + y++;
        System.out.println("z=" + z);
        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }
}
```

**실행 결과**
```
x=12
-----------------------
y=8
-----------------------
z=12
x=13
-----------------------
z=14
x=14
-----------------------
z=23
x=15
y=9
```

### 3.2 산술 연산자

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

### 3.3 오버플로우와 언더플로우

오버플로우(overflow)란 타입이 허용하는 최대값을 벗어나는 것을 말한다. 반대로 언더플로우(underflow)는 타입이 허용하는 최소값을 벗어나는 것을 말한다. 정수 타입 연산에서 오버플로우 또는 언더플로우가 발생되면 실행 에러가 발생할 것 같지만, 그렇지는 않고 해당 정수 타입의 최소값 또는 최대값으로 되돌아간다.

예를 들어 `byte` 타입일 경우 최대값 127에서 1을 더하면 128이 되어 오버플로우가 발생하고, 연산 결과는 최소값인 -128이 된다. 그리고 다시 1을 더하면 -127이 된다.

```java
byte value = 127;
value++; //value 값에 1을 더함
System.out.println(value); //-128
```

마찬가지로 -128에서 1을 빼면 -129가 되어 언더플로우가 발생하는데, 연산 결과는 최대값인 127이 된다. 그리고 다시 1을 빼면 126이 된다.

```java
byte value = -128;
value--; //value 값에 1을 뺌
System.out.println(value); //127
```

`short`, `int`, `long` 타입은 값의 범위만 다를 뿐, 오버플로우 및 언더플로우가 발생했을 때 마찬가지로 최소값 또는 최대값으로 되돌아간다.

**[예제: OverflowUnderflowExample.java]**
```java
package ch03.sec03;

public class OverflowUnderflowExample {
    public static void main(String[] args) {
        byte var1 = 125;
        for(int i=0; i<5; i++) { //{ }를 5번 반복 실행
            var1++; //++ 연산은 var1의 값을 1 증가시킨다.
            System.out.println("var1: " + var1);
        }
        
        System.out.println("-----------------------");
        
        byte var2 = -125;
        for(int i=0; i<5; i++) { //{ }를 5번 반복 실행
            var2--; //-- 연산은 var2의 값을 1 감소시킨다.
            System.out.println("var2: " + var2);
        }
    }
}
```

**실행 결과**
```
var1: 126
var1: 127
var1: -128
var1: -127
var1: -126
-----------------------
var2: -126
var2: -127
var2: -128
var2: 127
var2: 126
```

연산 과정 중에 발생하는 오버플로우와 언더플로우는 우리가 기대하는 값이 아니므로 항상 해당 타입의 범위 내에서 연산이 수행되도록 코딩에 신경써야 한다. 만약 연산 과정에서 `int` 타입에서 오버플로우 또는 언더플로우가 발생될 가능성이 있다면 `long` 타입으로 연산을 하도록 해야 한다.

```java
int x = 1000000;
int y = 1000000;
int z = x * y; //z: -727379968;
```

위 코드는 1000000 * 1000000은 10^6 * 10^6 = 10^12이 되어 `int` 타입 허용 범위를 초과한 오버플로우가 발생한다. 올바른 값을 얻기 위해서는 다음과 같이 변수 x와 y 중 최소 하나라도 `long` 타입이 되어야하고, 변수 z가 `long` 타입이어야 한다.

```java
long x = 1000000;
long y = 1000000;
long z = x * y; //long z = 1000000000000;
```

### 3.4 정확한 계산은 정수 연산으로

산술 연산을 정확하게 계산하고 싶다면 실수 타입을 사용하지 않는 것이 좋다. 다음 예제는 사과 1개를 0.1 단위의 10조각으로 보고, 그 중 7조각(0.7)을 뺀 3조각(0.3)을 result 변수에 저장한다.

**[예제: AccuracyExample1.java]**
```java
package ch03.sec04;

public class AccuracyExample1 {
    public static void main(String[] args) {
        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;
        
        double result = apple - number*pieceUnit;
        
        System.out.println("사과 1개에서 남은 양: " + result);
    }
}
```

**실행 결과**
```
사과 1개에서 남은 양: 0.29999999999999993
```

출력된 결과를 보면 `result` 변수의 값은 정확히 0.3이 되지 않는다. 이것은 부동 소수점 방식을 사용하는 실수 타입에서 흔히 일어난다. 그렇기 때문에 정확한 계산이 필요하다면 정수 연산으로 변경해서 다음과 같이 계산하는 것이 좋다.

**[예제: AccuracyExample2.java]**
```java
package ch03.sec04;

public class AccuracyExample2 {
    public static void main(String[] args) {
        int apple = 1;
        int totalPieces = apple * 10;
        int number = 7;
        
        int result = totalPieces - number;
        
        System.out.println("10조각에서 남은 조각: " + result);
        System.out.println("사과 1개에서 남은 양: " + result/10.0);
    }
}
```

**실행 결과**
```
10조각에서 남은 조각: 3
사과 1개에서 남은 양: 0.3
```

### 3.5 나눗셈 연산 후 NaN과 Infinity 처리

나눗셈(`/`) 또는 나머지(`%`) 연산에서 좌측 피연산자가 정수이고 우측 피연산자가 0일 경우 예외 (ArithmeticException)가 발생한다. 무한대의 값을 정수로 표현할 수 없기 때문이다.

```java
5 / 0 -> 예외 발생
5 % 0 -> 예외 발생
```

하지만 좌측 피연산자가 실수이거나 우측 피연산자가 0.0 또는 0.0f이면 예외가 발생하지 않고 연산의 결과는 Infinity(무한대) 또는 NaN(Not a Number)이 된다.

```java
5 / 0.0 -> Infinity
5 % 0.0 -> NaN
```

Infinity 또는 NaN 상태에서 계속해서 연산을 수행하면 안 된다. 어떤 연산을 하더라도 결과는 계속해서 Infinity와 NaN이 되므로 데이터가 엉망이 될 수 있다.

```java
Infinity + 2 -> Infinity
NaN + 2 -> NaN
```

그렇기 때문에 `/`와 `%` 연산의 결과가 Infinity 또는 NaN인지 먼저 확인하고 다음 연산을 수행하는 것이 좋다. 이를 확인하기 위해서는 `Double.isInfinite()`와 `Double.isNaN()`를 사용한다. 이렇게 하면 변수값이 Infinity 또는 NaN일 경우 `true`를, 그렇지 않다면 `false`를 산출한다.

```java
boolean result = Double.isInfinite(변수);
boolean result = Double.isNaN(변수);
```

다음 예제에서 7라인과 8라인을 번갈아 주석 처리하며 실행해 보자.

**[예제: InfinityAndNaNCheckExample.java]**
```java
package ch03.sec05;

public class InfinityAndNaNCheckExample {
    public static void main(String[] args) {
        int x = 5;
        double y = 0.0;
        double z = x / y;
        //double z = x % y;
        
        //잘못된 코드
        System.out.println(z + 2);
        
        //알맞은 코드
        if(Double.isInfinite(z) || Double.isNaN(z)) {
            System.out.println("값 산출 불가");
        } else {
            System.out.println(z + 2);
        }
    }
}
```

**실행 결과**
```
Infinity 또는 NaN
값 산출 불가
```

### 3.6 비교 연산자

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

### 3.7 논리 연산자

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

### 3.8 비트 논리 연산자

비트 논리 연산자는 bit 단위로 논리 연산을 수행한다. 0과 1이 피연산자가 되므로 2진수 0과 1로 저장되는 정수 타입(byte, short, int, long)만 피연산자가 될 수 있고, 부동 소수점 방식으로 저장되는 실수 타입(float, double)은 피연산자가 될 수 없다.

다음은 비트 논리 연산자의 종류를 보여 준다. 피연산자가 1, 0이라는 것과 산출 결과가 1, 0이라는 점에 주목하자. 1은 `true`, 0은 `false`라고 생각한다면 3.7절의 논리 연산자와 차이가 없다.

| 구분                | 연산식 | 설명                                                       |
| :------------------ | :----- | :--------------------------------------------------------- |
| AND (논리곱)        | `&`    | 두 비트 모두 1일 경우에만 연산 결과가 1                    |
| OR (논리합)         | `      | `                                                          | 두 비트 중 하나만 1이면 연산 결과는 1 |
| XOR (배타적 논리합) | `^`    | 두 비트 중 하나는 1이고 다른 하나가 0일 경우 연산 결과는 1 |
| NOT (논리 부정)     | `~`    | 보수                                                       |

45와 25를 비트 논리 연산해 보자. 먼저 45를 2진수로 표현하면 다음과 같다.
`00101101` (45)

25를 2진수로 표현하면 다음과 같다.
`00011001` (25)

45와 25의 2진수로 비트 논리곱(`&`)과 논리합(`|`) 연산을 수행하면 다음과 같다.
`45 & 25` = `00001001` (9)
`45 | 25` = `00111101` (61)

45와 25의 비트 배타적 논리합(`^`)과 45의 비트 논리 부정(`~`) 연산을 수행하면 다음과 같다.
`45 ^ 25` = `00110100` (52)
`~45` = `11010010` (-46) (최상위 비트가 1이면 음수)

비트 논리 연산자는 `byte`, `short`, `char` 타입 피연산자를 `int` 타입으로 자동 변환한 후 연산을 수행한다. 따라서 연산 결과도 `int` 타입이 되므로 `int` 변수에 대입해야 한다.

```java
byte num1 = 45;
byte num2 = 25;
//byte result = num1 & num2; //컴파일 에러
int result = num1 & num2;
```

비트 논리 연산이 왜 필요한지 예를 하나 들어 보자. 소형 임베디드 장치의 C 프로그램에서 외부 서버의 자바 프로그램으로 데이터를 전달한다고 가정하자. C 언어에는 `uint8_t` 타입이 있는데, 이 타입은 1byte 크기를 가지면서 0~255 값의 범위를 가진다.

C 프로그램이 `uint8_t` 타입 136을 2진수로 보내면, 자바는 2진수를 -120으로 읽게 된다. 그 이유는 자바는 최상위 비트가 1이면 음수로 인식하기 때문이다.

`-120`을 C 프로그램이 보낸 `136`으로 복원하고 싶다면 `-120`과 `255`를 비트 논리곱(`&`) 연산을 수행하면 된다.

```java
byte receiveData = -120;
int unsignedInt = receiveData & 255; //136
```

**[예제: BitLogicExample.java]**
```java
package ch03.sec08;

public class BitLogicExample {
    public static void main(String[] args) {
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));
        System.out.println("-------------------------");
        
        byte receiveData = -120;
        
        //방법1: 비트 논리곱 연산으로 Unsigned 정수 얻기
        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);
        
        //방법2: 자바 API를 이용해서 Unsigned 정수 얻기
        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);
        
        int test = 136;
        byte btest = (byte) test;
        System.out.println(btest);
    }
}
```

**실행 결과**
```
45 & 25 = 9
45 | 25 = 61
45 ^ 25 = 52
~45 = -46
-------------------------
136
136
-120
```

### 3.9 비트 이동 연산자

비트 이동 연산자는 비트를 좌측 또는 우측으로 밀어서 이동시키는 연산을 수행한다.

| 구분      | 연산식    | 설명                                                                                   |
| :-------- | :-------- | :------------------------------------------------------------------------------------- |
| 좌측 이동 | `a << b`  | 정수 a의 각 비트를 b만큼 왼쪽으로 이동(빈자리는 0으로 채움)                            |
| 우측 이동 | `a >> b`  | 정수 a의 각 비트를 b만큼 오른쪽으로 이동(빈자리는 최상위 부호 비트와 같은 값으로 채움) |
|           | `a >>> b` | 정수 a의 각 비트를 b만큼 오른쪽으로 이동(빈자리는 0으로 채움)                          |

`a << b` 연산은 `a * 2^b`와 같은 결과를 산출하고, `a >> b` 연산은 `a / 2^b`와 같은 결과를 산출한다.

**[예제: BitShiftExample1.java]**
```java
package ch03.sec09;

public class BitShiftExample1 {
    public static void main(String[] args) {
        int num1 = 1;
        int result1 = num1 << 3;
        int result2 = num1 * (int) Math.pow(2, 3);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        
        int num2 = -8;
        int result3 = num2 >> 3;
        int result4 = num2 / (int) Math.pow(2, 3);
        System.out.println("result3: " + result3);
        System.out.println("result4: " + result4);
    }
}
```

**실행 결과**
```
result1: 8
result2: 8
result3: -1
result4: -1
```

이번에는 우측 이동 연산자(`>>>`)를 사용하여 정수 -8을 3비트만큼 오른쪽으로 이동시켜 보자.

```java
int result = -8 >>> 3;
//00011111 11111111 11111111 11111111 (536870911)
```

32비트 전체를 오른쪽으로 3비트 이동할 때 맨 오른쪽 3비트는 밀려서 버려지고, 맨 왼쪽에 새로 생기는 3비트는 무조건 0으로 채워진다. 이렇게 변환된 2진수를 10진수로 변환하면 536870911 값을 얻는다.

다음은 `int` 타입 값 772를 구성하는 4개의 `byte`를 각각 별도로 읽고, 부호 없는 정수(0~255)로 출력하는 예제이다.

**[예제: BitShiftExample2.java]**
```java
package ch03.sec09;

public class BitShiftExample2 {
    public static void main(String[] args) {
        int value = 772; // [00000000] [00000000] [00000011] [00000100]
        
        //우측으로 3byte(24bit) 이동하고 끝 1바이트만 읽음: [00000000]
        byte byte1 = (byte) (value >>> 24);
        int int1 = byte1 & 255;
        System.out.println("첫 번째 바이트 부호 없는 값: " + int1);
        
        //우측으로 2byte(16bit) 이동하고 끝 1바이트만 읽음: [00000000]
        byte byte2 = (byte) (value >>> 16);
        int int2 = Byte.toUnsignedInt(byte2);
        System.out.println("두 번째 바이트 부호 없는 값: " + int2);
        
        //우측으로 1byte(8bit) 이동하고 끝 1바이트만 읽음: [00000011]
        byte byte3 = (byte) (value >>> 8);
        int int3 = byte3 & 255;
        System.out.println("세 번째 바이트 부호 없는 값: " + int3);
        
        //끝 1바이트만 읽음: [00000100]
        byte byte4 = (byte) value;
        int int4 = Byte.toUnsignedInt(byte4);
        System.out.println("네 번째 바이트 부호 없는 값: " + int4);
    }
}
```

**실행 결과**
```
첫 번째 바이트 부호 없는 값: 0
두 번째 바이트 부호 없는 값: 0
세 번째 바이트 부호 없는 값: 3
네 번째 바이트 부호 없는 값: 4
```

### 3.10 대입 연산자

대입 연산자는 우측 피연산자의 값을 좌측 피연산자인 변수에 대입한다. 우측 피연산자에는 리터럴 및 변수, 그리고 다른 연산식이 올 수 있다. 대입 연산자의 종류에는 단순히 값을 대입하는 단순 대입 연산자가 있고, 정해진 연산을 수행한 후 결과를 대입하는 복합 대입 연산자가 있다.

| 구분      | 연산식               | 설명                                                                |
| :-------- | :------------------- | :------------------------------------------------------------------ |
| 단순 대입 | `변수 = 피연산자`    | 우측의 피연산자의 값을 변수에 저장                                  |
| 복합 대입 | `변수 += 피연산자`   | 우측의 피연산자의 값을 변수의 값과 더한 후에 다시 변수에 저장       |
|           | `변수 -= 피연산자`   | 우측의 피연산자의 값을 변수의 값에서 뺀 후에 다시 변수에 저장       |
|           | `변수 *= 피연산자`   | 우측의 피연산자의 값을 변수의 값과 곱한 후에 다시 변수에 저장       |
|           | `변수 /= 피연산자`   | 우측의 피연산자의 값으로 변수의 값을 나눈 후에 다시 변수에 저장     |
|           | `변수 %= 피연산자`   | 우측의 피연산자의 값으로 변수의 값을 나눈 후에 나머지를 변수에 저장 |
|           | `변수 &= 피연산자`   | 우측의 피연산자의 값과 변수의 값을 `&` 연산 후 결과를 변수에 저장   |
|           | `변수                | = 피연산자`                                                         | 우측의 피연산자의 값과 변수의 값을 ` | ` 연산 후 결과를 변수에 저장 |
|           | `변수 ^= 피연산자`   | 우측의 피연산자의 값과 변수의 값을 `^` 연산 후 결과를 변수에 저장   |
|           | `변수 <<= 피연산자`  | 우측의 피연산자의 값과 변수의 값을 `<<` 연산 후 결과를 변수에 저장  |
|           | `변수 >>= 피연산자`  | 우측의 피연산자의 값과 변수의 값을 `>>` 연산 후 결과를 변수에 저장  |
|           | `변수 >>>= 피연산자` | 우측의 피연산자의 값과 변수의 값을 `>>>` 연산 후 결과를 변수에 저장 |

**[예제: AssignmentOperatorExample.java]**
```java
package ch03.sec10;

public class AssignmentOperatorExample {
    public static void main(String[] args) {
        int result = 0;
        result += 10;
        System.out.println("result=" + result);
        result -= 5;
        System.out.println("result=" + result);
        result *= 3;
        System.out.println("result=" + result);
        result /= 5;
        System.out.println("result=" + result);
        result %= 3;
        System.out.println("result=" + result);
    }
}
```

**실행 결과**
```
result= 10
result= 5
result= 15
result= 3
result= 0
```

### 3.11 삼항(조건) 연산자

삼항 연산자(피연산자 ? 피연산자 : 피연산자)는 총 3개의 피연산자를 가진다. `?` 앞의 피연산자에는 `boolean` 변수 또는 조건식이 오므로 조건 연산자라고도 한다. 이 값이 `true`이면 콜론(`:`) 앞의 피연산자가 선택되고, `false`이면 콜론 뒤의 피연산자가 선택된다.

```java
조건식(피연산자1) ? 값 또는 연산식(피연산자2) : 값 또는 연산식(피연산자3)
//true -> 피연산자2 선택
//false -> 피연산자3 선택
```

**[예제: ConditionalOperationExample.java]**
```java
package ch03.sec11;

public class ConditionalOperationExample {
    public static void main(String[] args) {
        int score = 85;
        char grade = (score > 90) ? 'A' : ( (score > 80) ? 'B' : 'C' );
        System.out.println(score + "점은 " + grade + "등급입니다.");
    }
}
```

**실행 결과**
```
85점은 B등급입니다.
```

### 3.12 연산의 방향과 우선순위

산술 연산식에서 덧셈(`+`), 뺄셈(`-`) 연산자보다는 곱셈(`*`), 나눗셈(`/`) 연산자가 우선 처리된다는 것을 우리는 이미 알고 있다. 그러면 다른 연산자들의 경우는 어떨까? 예를 들어 다음과 같은 연산식에서 `&&` 연산자가 먼저 처리될까? 아니면 `>`, `<` 연산자가 먼저 처리될까?

```java
x > 0 && y < 0
```

연산자는 우선순위가 정해져 있다. `&&`보다는 `>`, `<`가 우선순위가 높기 때문에 `x > 0`과 `y < 0`이 먼저 처리되므로 `&&`는 `x > 0`과 `y < 0`의 산출값을 가지고 연산하게 된다.

그러면 우선순위가 같은 연산자들끼리는 어떤 순서로 처리될까? 이 경우는 연산의 방향에 따라 달라진다. 대부분의 연산자는 왼쪽에서부터 오른쪽으로(`->`) 연산을 수행한다. 예를 들어 다음 연산식을 보자.

```java
100 * 2 / 3 % 5
```

`*`, `/`, `%`는 같은 우선순위를 갖고 있다. 이 연산자들은 연산 방향이 왼쪽에서 오른쪽으로 수행된다. 따라서 `100 * 2`가 제일 먼저 연산되어 200이 산출되고, 그 다음 `200 / 3`이 연산되어 66이 산출된다. 그 다음으로 `66 % 5`가 연산되어 결과값 1이 나온다.

하지만 대입 연산자(`=`, `+=`, `-=`, ...)는 오른쪽에서 왼쪽(`<-`)으로 연산을 수행한다.

```java
a = b = c = 5;
```

위 연산식은 `c = 5`, `b = c`, `a = b` 순서로 실행된다. 따라서 실행되고 난 후에는 `a`, `b`, `c`의 값이 모두 5가 된다. 이와 같이 연산자는 우선순위 및 연산 방향이 정해져 있기 때문에 복잡한 연산식에서는 주의가 필요하다.

위 표를 숙지했다 하더라도 여러 가지 연산자들이 섞여 있다면 어느 연산자가 먼저 처리될지 매우 혼란스러울 것이다. 그래서 먼저 처리해야 할 연산을 괄호`()`로 묶는 것을 추천한다. 괄호`()`는 최우선순위를 가지기 때문이다.

```java
int var1 = 1;
int var2 = 3;
int var3 = 2;
int result = var1 + var2 * var3; // 1 + (3 * 2) = 7
int result = (var1 + var2) * var3; // (1 + 3) * 2 = 8
```

### 확인문제

1. 다음 코드를 실행했을 때 출력 결과를 작성해 보세요.
   ```java
   int x = 10;
   int y = 20;
   int z = (++x) + (y--);
   System.out.println(z);
   ```

2. 다음 코드를 실행했을 때 출력 결과를 작성해 보세요.
   ```java
   int score = 85;
   String result = (!(score>90)) ? "가" : "나";
   System.out.println(result);
   ```

3. 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고, 마지막에 몇 개가 남는지를 구하는 코드입니다. ( )에 들어갈 알맞은 코드를 차례대로 작성해 보세요.
   ```java
   int pencils = 534;
   int students = 30;
   
   //학생 한 명이 가지는 연필 수
   int pencilsPerStudent = (   );
   System.out.println(pencilsPerStudent);
   
   //남은 연필 수
   int pencilsLeft = (   );
   System.out.println(pencilsLeft);
   ```

4. 다음은 십의 자리 이하를 버리는 코드입니다. 변수 value의 값이 356이라면 300이 나올 수 있도록 ( )에 알맞은 코드를 작성하세요(산술 연산자만 사용).
   ```java
   int value = 356;
   System.out.println(   );
   ```

5. 다음 코드는 사다리꼴의 넓이를 구하는 코드입니다. 정확히 소수 자릿수가 나올 수 있도록 ( )에 들어갈 수 있는 코드를 모두 선택하세요.
   ```java
   int lengthTop = 5;
   int lengthBottom = 10;
   int height = 7;
   double area = (   );
   System.out.println(area);
   ```
   1. `(lengthTop + lengthBottom) * height / 2.0`
   2. `(lengthTop + lengthBottom) * height * 1.0 / 2`
   3. `(double)(lengthTop + lengthBottom) * height / 2`
   4. `(double)((lengthTop + lengthBottom) * height / 2)`

6. 다음 코드는 비교 연산자와 논리 연산자의 복합 연산식입니다. 연산식의 출력 결과를 작성해 보세요.
   ```java
   int x = 10;
   int y = 5;
   System.out.println( (x>7) && (y<=5) );
   System.out.println( (x%3 == 2) || (y%2 != 1) );
   ```

7. 다음은 % 연산을 수행한 결과값에 10을 더하는 코드입니다. NaN 값을 검사해서 올바른 결과가 출력될 수 있도록 ( )에 들어갈 코드를 작성해 보세요.
   ```java
   double x = 5.0;
   double y = 0.0;
   double z = x % y;
   
   if(   ) {
       System.out.println("0.0으로 나눌 수 없습니다.");
   } else {
       double result = z + 10;
       System.out.println("결과: " + result);
   }
   ```
