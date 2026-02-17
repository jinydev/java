---
layout: part01
title: "확인문제"
nav_order: 99
parent: "Chapter 02. 변수와 타입"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제

1. 변수에 대해 잘못 설명한 것은 무엇입니까?
   1. 변수는 하나의 값만 저장할 수 있다.
   2. 변수는 선언 시에 사용한 타입의 값만 저장할 수 있다.
   3. 변수는 변수가 선언된 중괄호 `{}` 안에서만 사용 가능하다.
   4. 변수는 초기값이 저장되지 않은 상태에서 읽을 수 있다.

2. 변수 이름으로 사용할 수 없는 것을 모두 선택하세요.
   1. modelName
   2. class
   3. 6hour
   4. $value
   5. _age
   6. int

3. 다음 표의 빈 칸에 자바의 기본 타입 8개를 적어 보세요.
   | 타입      | 1byte | 2byte    | 4byte | 8byte |
   | :-------- | :---- | :------- | :---- | :---- |
   | 정수 타입 | ( )   | ( ), ( ) | ( )   | ( )   |
   | 실수 타입 |       |          | ( )   | ( )   |
   | 논리 타입 | ( )   |          |       |       |

4. 다음 코드에서 타입, 변수 이름, 리터럴에 해당하는 것을 적어 보세요.
   ```java
   int age;
   age = 10;
   double price = 3.14;
   ```
   타입: ( ), ( )
   변수 이름: ( ), ( )
   리터럴: ( ), ( )

5. 다음 자동 타입 변환에서 컴파일 에러가 발생하는 것을 선택하세요.
   ```java
   byte byteValue = 10;
   char charValue = 'A';
   ```
   1. `int intValue = byteValue;`
   2. `int intValue = charValue;`
   3. `short shortValue = charValue;`
   4. `double doubleValue = byteValue;`

6. 다음 강제 타입 변환에서 컴파일 에러가 발생하는 것을 선택하세요.
   ```java
   int intValue = 10;
   char charValue = 'A';
   double doubleValue = 5.7;
   String strValue = "A";
   ```
   1. `double var = (double) intValue;`
   2. `byte var = (byte) intValue;`
   3. `int var = (int) doubleValue;`
   4. `char var = (char) strValue;`

7. 변수를 잘못 초기화한 것은 무엇입니까?
   1. `int var1 = 10;`
   2. `long var2 = 10000000000L;`
   3. `char var3 = '';` //작은따옴표 두 개가 붙어 있음
   4. `float var4 = 10;`
   5. `String var5 = "abc\ndef";`
   6. `String var6 = """...""";`

8. 콘솔에 값을 입출력하는 방법에 대해 잘못 설명한 것을 선택하세요.
   1. `System.out.print(변수)`는 변수값을 출력시키고 행을 바꾸지 않는다.
   2. `System.out.println(변수)`는 변수값을 출력시키고 행을 바꾼다.
   3. `System.out.printf("형식", 변수)`는 주어진 형식대로 변수값을 바꾼다.
   4. `Scanner`의 `nextLine()` 메소드는 콘솔에 입력된 내용을 문자열로 읽는다.

9. 연산식의 타입 변환 중에서 컴파일 에러가 발생하는 것을 선택하세요.
   ```java
   byte byteValue = 10;
   float floatValue = 2.5F;
   double doubleValue = 2.5;
   ```
   1. `byte result = byteValue + byteValue;`
   2. `int result = 5 + byteValue;`
   3. `float result = 5 + floatValue;`
   4. `double result = 5 + doubleValue;`

10. 문자열을 기본 타입으로 변환하는 코드로 틀린 것을 고르세요.
    ```java
    String str = "5";
    ```
    1. `byte var1 = Byte.parseByte(str);`
    2. `int var2 = Int.parseInt(str);`
    3. `float var3 = Float.parseFloat(str);`
    4. `double var4 = Double.parseDouble(str);`

11. 다음 코드에서 컴파일 에러가 발생하는 라인을 모두 적어 보세요.
    ```java
    int v1 = 1;
    System.out.println("v1: " + v1);
    if(true) {
        int v2 = 2;
        if(true) {
            int v3 = 2;
            System.out.println("v1: " + v1);
            System.out.println("v2: " + v2);
            System.out.println("v3: " + v3);
        }
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.println("v3: " + v3);
    }
    System.out.println("v1: " + v1);
    System.out.println("v2: " + v2);
    ```
