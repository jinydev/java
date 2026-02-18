---
layout: basic
title: "2.4 실수 타입"
nav_order: 4
parent: "Chapter 02. 변수와 타입"
grand_parent: "객체지향 자바 프로그래밍"
---

# 2.4 실수 타입

실수 타입에는 `float`과 `double`이 있으며, 다음과 같이 메모리 할당 크기와 저장되는 값의 범위를 가지고 있다.

| 타입   | 메모리 크기  | 유효 소수 이하 자리 | 저장되는 값의 허용 범위(양수 기준) |
| :----- | :----------- | :------------------ | :--------------------------------- |
| float  | 4byte(32bit) | 7자리               | 1.4 x 10^-45 ~ 3.4 x 10^38         |
| double | 8byte(64bit) | 15자리              | 4.9 x 10^-324 ~ 1.8 x 10^308       |

`double` 타입이 `float` 타입보다 큰 실수를 저장할 수 있고 정밀도 또한 높은 것을 볼 수 있다.
자바는 IEEE 754 표준에 근거해서 `float` 타입과 `double` 타입의 값을 부동 소수점(floating-point) 방식으로 메모리에 저장한다.

최상위 1bit는 양수 및 음수를 결정짓는 부호 bit로 0이면 양수, 1이면 음수가 된다. 지수는 `float` 타입은 8bit, `double` 타입은 11bit로 표현하고 나머지 bit는 모두 가수를 표현하는 데 사용된다.

`double`은 `float`보다 지수와 가수 부분의 bit 수가 크기 때문에 더 크고 정밀한 실수를 저장할 수 있다. 코드에서 실수 리터럴은 다음과 같이 작성할 수 있다.

* **10진수 리터럴**
  ```java
  double x = 0.25;
  double y = -3.14;
  ```
* **e 또는 E가 포함된 10의 거듭제곱 리터럴**
  ```java
  double x = 5e2; //5.0 x 10^2 = 500.0
  double y = 0.12E-2; //0.12 x 10^-2 = 0.0012
  ```

컴파일러는 실수 리터럴을 기본적으로 `double` 타입으로 해석하기 때문에 `double` 타입 변수에 대입해야 한다. `float` 타입에 대입하고 싶다면 리터럴 뒤에 소문자 `f`나 대문자 `F`를 붙여 컴파일러가 `float` 타입임을 알 수 있도록 해야 한다.

```java
double var = 3.14;
double var = 314e-2;
float var = 3.14f;
float var = 3E6F;
```

다음 예제는 `float`과 `double` 타입의 소수 이하 유효 자릿수를 확인한다. `double` 타입은 `float` 타입보다 약 2배의 유효 자릿수를 가지기 때문에 보다 정확한 데이터 저장이 가능하다. `double`이라는 이름도 `float`보다 약 2배의 정밀도를 갖는다는 의미에서 붙여진 것이다. 확인 후에는 10의 거듭제곱 리터럴을 대입해서 출력해 보자.

**[예제: FloatDoubleExample.java]**
```java
package ch02.sec04;

public class FloatDoubleExample {
    public static void main(String[] args) {
        //정밀도 확인
        float var1 = 0.1234567890123456789f;
        double var2 = 0.1234567890123456789;
        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        
        //10의 거듭제곱 리터럴
        double var3 = 3e6;
        float var4 = 3e6F;
        double var5 = 2e-3;
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);
        System.out.println("var5: " + var5);
    }
}
```

**실행 결과**
```
var1: 0.12345679
var2: 0.12345678901234568
var3: 3000000.0
var4: 3000000.0
var5: 0.002
```
