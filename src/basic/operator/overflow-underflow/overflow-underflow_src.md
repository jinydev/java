---
layout: basic
title: "3.3 오버플로우와 언더플로우"
nav_order: 3
parent: "Chapter 03. 연산자"
grand_parent: "객체지향 자바 프로그래밍"
---

# 3.3 오버플로우와 언더플로우

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
