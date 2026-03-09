---
layout: basic
title: "2.9 연산식에서 자동 타입 변환"
nav_order: 9
parent: "Chapter 02. 변수와 타입"
grand_parent: "객체지향 자바 프로그래밍"
description: "2.9 연산식에서 자동 타입 변환 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "2.9 연산식에서 자동 타입 변환, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 2.9 연산식에서 자동 타입 변환

`byte`, `short`, `char` 타입의 변수가 피연산자로 사용되면, 컴파일 단계에서 연산 결과는 `int` 타입이 된다.

```java
byte x = 10;
byte y = 20;
//byte result = x + y; //컴파일 에러
int result = x + y;
```

따라서 `byte` 변수 `x`, `y`가 피연산자로 사용되면 `x`, `y` 변수의 값은 `int` 타입으로 변환되어 연산되고, 결과 역시 `int` 타입이 된다. 그렇기 때문에 결과값을 `byte` 변수에 저장할 수 없고 `int` 변수에 저장해야 한다.

정수 연산식에서 모든 변수가 `int` 타입으로 변환되는 것은 아니다. 두 피연산자 중 허용 범위가 큰 타입으로 변환되어 연산이 수행된다.

```java
int x = 10;
long y = 20L;
long result = x + y; //int x가 long 타입으로 변환되어 연산 수행
```

실수 연산식에서도 마찬가지이다. 피연산자 중 하나가 `double` 타입이면 다른 피연산자도 `double` 타입으로 변환되어 연산되고, 결과 역시 `double` 타입이 된다.

```java
int x = 10;
double y = 5.5;
double result = x + y; //10.0 + 5.5 = 15.5
```

만약 `int` 타입으로 결과를 얻고 싶다면 `double` 타입을 `int` 타입으로 강제 변환하면 된다.

```java
int result = x + (int) y; //10 + 5 = 15
```

자바에서는 `1 / 2`의 결과가 0.5가 아닌 0이 된다. 정수 연산의 결과는 항상 정수이기 때문이다. 만약 `0.5` 결과를 얻고 싶다면 피연산자 중 하나를 `double` 타입으로 변환해야 한다.

```java
int x = 1;
int y = 2;
double result = (double) x / y; //0.5
```

다음 예제는 다양한 데이터 타입의 연산식에서 자동 등급 변환이 일어나는 것을 보여 준다.

**[예제: OperationPromotionExample.java]**
```java
package ch02.sec09;

public class OperationPromotionExample {
    public static void main(String[] args) {
        byte result1 = 10 + 20; //컴파일 단계에서 연산
        System.out.println("result1: " + result1);
        
        byte v1 = 10;
        byte v2 = 20;
        int result2 = v1 + v2; //int 타입으로 변환 후 연산
        System.out.println("result2: " + result2);
        
        byte v3 = 10;
        int v4 = 100;
        long v5 = 1000L;
        long result3 = v3 + v4 + v5; //long 타입으로 변환 후 연산
        System.out.println("result3: " + result3);
        
        char v6 = 'A';
        char v7 = 1;
        int result4 = v6 + v7; //int 타입으로 변환 후 연산
        System.out.println("result4: " + result4);
        System.out.println("result4: " + (char)result4);
        
        int v8 = 10;
        int result5 = v8 / 4; //정수 연산의 결과는 정수
        System.out.println("result5: " + result5);
        
        int v9 = 10;
        double result6 = v9 / 4.0; //double 타입으로 변환 후 연산
        System.out.println("result6: " + result6);
        
        int v10 = 1;
        int v11 = 2;
        double result7 = (double) v10 / v11; //double 타입으로 변환 후 연산
        System.out.println("result7: " + result7);
    }
}
```

**실행 결과**
```
result1: 30
result2: 30
result3: 1110
result4: 66
result4: B
result5: 2
result6: 2.5
result7: 0.5
```

자바에서 `+` 연산자는 두 가지 기능을 가지고 있다. 피연산자가 모두 숫자일 경우에는 덧셈 연산을 수행하고, 피연산자 중 하나가 문자열일 경우에는 나머지 피연산자도 문자열로 자동 변환되어 문자열 결합 연산을 수행한다.

```java
int value = 3 + 7; //int value = 10;
String str = "3" + 7; //String str = "3" + "7" -> String str = "37";
String str = 3 + "7"; //String str = "3" + "7" -> String str = "37";
```

연산식에서 `+` 연산자가 연이어 나오면 앞에서부터 순차적으로 `+` 연산을 수행한다. 먼저 수행된 연산이 덧셈 연산이라면 덧셈 결과를 가지고 그다음 `+` 연산을 수행한다. 만약 먼저 수행된 연산이 결합 연산이라면 이후 `+` 연산은 모두 결합 연산이 된다.

```java
int value = 1 + 2 + 3; //int value = 3 + 3 -> int value = 6;
String str = 1 + 2 + "3"; //String str = 3 + "3" -> String str = "33";
String str = 1 + "2" + 3; //String str = "12" + 3 -> String str = "123";
String str = "1" + 2 + 3; //String str = "12" + 3 -> String str = "123";
```

앞에서 순차적으로 `+` 연산을 수행하지 않고 특정 부분을 우선 연산하고 싶다면 해당 부분을 괄호`()`로 감싸면 된다. 괄호는 항상 최우선으로 연산을 수행한다.

```java
String str = "1" + (2 + 3); //String str = "1" + 5 -> String str = "15";
```

**[예제: StringConcatExample.java]**
```java
package ch02.sec09;

public class StringConcatExample {
    public static void main(String[] args) {
        //숫자 연산
        int result1 = 10 + 2 + 8;
        System.out.println("result1: " + result1);
        
        //결합 연산
        String result2 = 10 + 2 + "8";
        System.out.println("result2: " + result2);
        
        String result3 = 10 + "2" + 8;
        System.out.println("result3: " + result3);
        
        String result4 = "10" + 2 + 8;
        System.out.println("result4: " + result4);
        
        String result5 = "10" + (2 + 8);
        System.out.println("result5: " + result5);
    }
}
```
---

# 2.9 연산식에서 자동 타입 변환

`byte`, `short`, `char` 타입의 변수가 피연산자로 사용되면, 컴파일 단계에서 연산 결과는 `int` 타입이 된다.

```java
byte x = 10;
byte y = 20;
//byte result = x + y; //컴파일 에러
int result = x + y;
```

따라서 `byte` 변수 `x`, `y`가 피연산자로 사용되면 `x`, `y` 변수의 값은 `int` 타입으로 변환되어 연산되고, 결과 역시 `int` 타입이 된다. 그렇기 때문에 결과값을 `byte` 변수에 저장할 수 없고 `int` 변수에 저장해야 한다.

정수 연산식에서 모든 변수가 `int` 타입으로 변환되는 것은 아니다. 두 피연산자 중 허용 범위가 큰 타입으로 변환되어 연산이 수행된다.

```java
int x = 10;
long y = 20L;
long result = x + y; //int x가 long 타입으로 변환되어 연산 수행
```

실수 연산식에서도 마찬가지이다. 피연산자 중 하나가 `double` 타입이면 다른 피연산자도 `double` 타입으로 변환되어 연산되고, 결과 역시 `double` 타입이 된다.

```java
int x = 10;
double y = 5.5;
double result = x + y; //10.0 + 5.5 = 15.5
```

만약 `int` 타입으로 결과를 얻고 싶다면 `double` 타입을 `int` 타입으로 강제 변환하면 된다.

```java
int result = x + (int) y; //10 + 5 = 15
```

자바에서는 `1 / 2`의 결과가 0.5가 아닌 0이 된다. 정수 연산의 결과는 항상 정수이기 때문이다. 만약 `0.5` 결과를 얻고 싶다면 피연산자 중 하나를 `double` 타입으로 변환해야 한다.

```java
int x = 1;
int y = 2;
double result = (double) x / y; //0.5
```

다음 예제는 다양한 데이터 타입의 연산식에서 자동 등급 변환이 일어나는 것을 보여 준다.

**[예제: OperationPromotionExample.java]**
```java
package ch02.sec09;

public class OperationPromotionExample {
    public static void main(String[] args) {
        byte result1 = 10 + 20; //컴파일 단계에서 연산
        System.out.println("result1: " + result1);
        
        byte v1 = 10;
        byte v2 = 20;
        int result2 = v1 + v2; //int 타입으로 변환 후 연산
        System.out.println("result2: " + result2);
        
        byte v3 = 10;
        int v4 = 100;
        long v5 = 1000L;
        long result3 = v3 + v4 + v5; //long 타입으로 변환 후 연산
        System.out.println("result3: " + result3);
        
        char v6 = 'A';
        char v7 = 1;
        int result4 = v6 + v7; //int 타입으로 변환 후 연산
        System.out.println("result4: " + result4);
        System.out.println("result4: " + (char)result4);
        
        int v8 = 10;
        int result5 = v8 / 4; //정수 연산의 결과는 정수
        System.out.println("result5: " + result5);
        
        int v9 = 10;
        double result6 = v9 / 4.0; //double 타입으로 변환 후 연산
        System.out.println("result6: " + result6);
        
        int v10 = 1;
        int v11 = 2;
        double result7 = (double) v10 / v11; //double 타입으로 변환 후 연산
        System.out.println("result7: " + result7);
    }
}
```

**실행 결과**
```
result1: 30
result2: 30
result3: 1110
result4: 66
result4: B
result5: 2
result6: 2.5
result7: 0.5
```

자바에서 `+` 연산자는 두 가지 기능을 가지고 있다. 피연산자가 모두 숫자일 경우에는 덧셈 연산을 수행하고, 피연산자 중 하나가 문자열일 경우에는 나머지 피연산자도 문자열로 자동 변환되어 문자열 결합 연산을 수행한다.

```java
int value = 3 + 7; //int value = 10;
String str = "3" + 7; //String str = "3" + "7" -> String str = "37";
String str = 3 + "7"; //String str = "3" + "7" -> String str = "37";
```

연산식에서 `+` 연산자가 연이어 나오면 앞에서부터 순차적으로 `+` 연산을 수행한다. 먼저 수행된 연산이 덧셈 연산이라면 덧셈 결과를 가지고 그다음 `+` 연산을 수행한다. 만약 먼저 수행된 연산이 결합 연산이라면 이후 `+` 연산은 모두 결합 연산이 된다.

```java
int value = 1 + 2 + 3; //int value = 3 + 3 -> int value = 6;
String str = 1 + 2 + "3"; //String str = 3 + "3" -> String str = "33";
String str = 1 + "2" + 3; //String str = "12" + 3 -> String str = "123";
String str = "1" + 2 + 3; //String str = "12" + 3 -> String str = "123";
```

앞에서 순차적으로 `+` 연산을 수행하지 않고 특정 부분을 우선 연산하고 싶다면 해당 부분을 괄호`()`로 감싸면 된다. 괄호는 항상 최우선으로 연산을 수행한다.

```java
String str = "1" + (2 + 3); //String str = "1" + 5 -> String str = "15";
```

**[예제: StringConcatExample.java]**
```java
package ch02.sec09;

public class StringConcatExample {
    public static void main(String[] args) {
        //숫자 연산
        int result1 = 10 + 2 + 8;
        System.out.println("result1: " + result1);
        
        //결합 연산
        String result2 = 10 + 2 + "8";
        System.out.println("result2: " + result2);
        
        String result3 = 10 + "2" + 8;
        System.out.println("result3: " + result3);
        
        String result4 = "10" + 2 + 8;
        System.out.println("result4: " + result4);
        
        String result5 = "10" + (2 + 8);
        System.out.println("result5: " + result5);
    }
}
```

**실행 결과**
```
result1: 20
result2: 128
result3: 1028
result4: 1028
result5: 1010
```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Operation`**: 오퍼레이션, 연산 / 계산. (`+`, `-`, `*`, `/` 등을 사용하여 숫자나 문자열들을 요리조리 계산하고 가공하는 행위)
*   **`Promotion`**: 프로모션, 승격 / 자동 타입 변환. (`int`와 `double`을 계산할 때 작은 `int`가 자동으로 큰 `double` 대우를 받아 부드럽게 계산되도록 올라가는 것)
*   **`Concatenation`**: 컨캐터네이션, 문자열 결합. (`"안녕" + "하세요"` 처럼 더하기(`+`) 연산자가 숫자 계산을 멈추고 글자들을 기차처럼 쭉 이어서 붙여주는 마법의 접착제 기능)
