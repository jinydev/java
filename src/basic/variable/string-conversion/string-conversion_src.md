---
layout: basic
title: "2.10 문자열을 기본 타입으로 변환"
nav_order: 10
parent: "Chapter 02. 변수와 타입"
grand_parent: "객체지향 자바 프로그래밍"
---

# 2.10 문자열을 기본 타입으로 변환

프로그램에서 문자열을 숫자 타입으로 변환하는 경우가 매우 많다. 예를 들어 "12"와 "3.5"를 정수 및 실수 타입으로 변환해서 숫자 연산을 하는 경우이다. 자바에서 문자열을 기본 타입으로 변환하는 방법은 다음과 같다.

| 변환 타입         | 사용 예                                      |
| :---------------- | :------------------------------------------- |
| String -> byte    | `byte value = Byte.parseByte(str);`          |
| String -> short   | `short value = Short.parseShort(str);`       |
| String -> int     | `int value = Integer.parseInt(str);`         |
| String -> long    | `long value = Long.parseLong(str);`          |
| String -> float   | `float value = Float.parseFloat(str);`       |
| String -> double  | `double value = Double.parseDouble(str);`    |
| String -> boolean | `boolean value = Boolean.parseBoolean(str);` |

반대로 기본 타입의 값을 문자열로 변경하는 경우도 있는데, 이 경우는 간단히 `String.valueOf()` 메소드를 이용하면 된다.

```java
String str = String.valueOf(기본타입값);
```

**[예제: PrimitiveAndStringConversionExample.java]**
```java
package ch02.sec10;

public class PrimitiveAndStringConversionExample {
    public static void main(String[] args) {
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");
        
        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        System.out.println("value3: " + value3);
        
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
    }
}
```

**실행 결과**
```
value1: 10
value2: 3.14
value3: true
str1: 10
str2: 3.14
str3: true
```
