---
layout: part01
title: "Chapter 02. 변수와 타입"
permalink: /part01/02/
---

# Chapter 02

## 변수와 타입

**목차**

* 2.1 변수 선언
* 2.2 정수 타입
* 2.3 문자 타입
* 2.4 실수 타입
* 2.5 논리 타입
* 2.6 문자열 타입
* 2.7 자동 타입 변환
* 2.8 강제 타입 변환
* 2.9 연산식에서 자동 타입 변환
* 2.10 문자열을 기본 타입으로 변환
* 2.11 변수 사용 범위
* 2.12 콘솔로 변수값 출력
* 2.13 키보드 입력 데이터를 변수에 저장

### 2.1 변수 선언

컴퓨터 메모리(RAM)는 수많은 번지들로 구성된 데이터 저장 공간이다. 프로그램은 데이터를 메모리에 저장하고 읽는 작업을 빈번히 수행한다. 이때 데이터를 어디에, 어떤 방식으로 저장할지 정해져 있지 않다면 메모리 관리가 무척 어려워진다. 프로그래밍 언어는 이 문제를 해결하기 위해 변수를 사용한다.

변수(variable)는 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름이다. 변수를 통해 프로그램은 메모리 번지에 값을 저장하고 읽을 수 있다.

**변수 = 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름**

자바의 변수는 다양한 타입의 값을 저장할 수 없다. 즉, 정수형 변수에는 정수값만 저장할 수 있고, 실수형 변수에는 실수값만 저장할 수 있다.

**하나의 값만 저장 가능**

변수를 사용하려면 변수 선언이 필요한데, 변수 선언은 어떤 타입의 데이터를 저장할 것인지 그리고 변수 이름이 무엇인지를 결정하는 것이다.

```java
//타입 이름
int age; //정수(int) 값을 저장할 수 있는 age 변수 선언
double value; //실수(double) 값을 저장할 수 있는 value 변수 선언
```

> **로컬(지역) 변수 타입 추론 가능**
> 자바 10부터 로컬(지역) 변수를 위한 타입 추론(type inference for local variables) 기능이 추가되어 변수 선언 시 구체적인 타입 대신 예약된 타입(reserved type)인 `var`를 사용할 수 있다. 자세한 내용은 우리 책 979쪽 21장 '자바 21에서 강화된 언어 및 라이브러리'에서 설명하므로 20장까지 모두 학습한 후에 학습하길 바란다.

변수 이름은 첫 번째 글자가 문자여야 하고, 중간부터는 문자, 숫자, $, _를 포함할 수 있다. 또한, 첫 문자를 소문자로 시작하되 캐멀 스타일로 작성하는 것이 관례이다.

> **캐멀(Camel) 스타일**
> 코드를 작성할 때 여러 단어를 혼합하여 명명하는 경우, 낙타의 등처럼 대소문자가 섞여 있도록 작성하는 스타일을 말한다. 자바 소스 파일명과 변수명을 작성할 때 관례적으로 사용한다.
> 1. 자바 소스 파일명(클래스명)은 대문자로 시작하는 것이 관례
>    Weel.java, MemberGrade.java, ProductKind.java
> 2. 변수명은 소문자로 시작하는 것이 관례
>    score, mathScore, sportsCar

변수가 선언되었다면 값을 저장할 수 있는데, 이때 대입 연산자인 `=`를 사용한다. 수학에서 등호(=)는 '같다'라는 의미이지만, 자바에서는 우측 값을 좌측 변수에 대입하는 연산자로 사용된다.

```java
int score; //변수 선언
score = 90; //값 대입
```

> **변수 이름의 길이와 한글**
> 변수 이름은 어떤 값을 저장하고 있는지 쉽게 알 수 있도록 의미 있는 이름을 지어 주는 것이 좋다. 변수 이름의 길이는 프로그램 실행과는 무관하기 때문에 충분히 길어도 상관없다. 그리고 변수 이름에 한글을 포함하지 않는 것이 관례이다.

변수 선언은 저장되는 값의 타입과 이름만 결정한 것이지, 아직 메모리에 할당된 것은 아니다. 변수에 최초로 값이 대입될 때 메모리에 할당되고, 해당 메모리에 값이 저장된다.

변수에 최초로 값을 대입하는 행위를 변수 초기화라고 하고, 이때의 값을 초기값이라고 한다. 초기값은 다음과 같이 변수를 선언함과 동시에 대입할 수도 있다.

```java
int score = 90;
```

초기화되지 않은 변수는 아직 메모리에 할당되지 않았기 때문에 변수를 통해 메모리 값을 읽을 수 없다. 따라서 다음은 잘못된 코딩이다.

```java
int value; //변수 value 선언
int result = value + 10; //변수 value 값을 읽고 10을 더해서 변수 result에 저장
```

위에서 변수 value가 선언되었지만, 초기화되지 않았기 때문에 `value + 10`에서 value 변수값은 읽어 올 수 없다. 따라서 위 코드는 다음과 같이 변경해야 한다.

```java
int value = 30; //변수 value가 30으로 초기화됨
int result = value + 10; //변수 value 값(30)을 읽고 10을 더해서 변수 result에 저장
```

다음 예제는 초기화되지 않은 변수를 연산식에 사용할 경우 컴파일 에러(The local variable value may not have been initialized)가 발생하는 것을 보여 준다.

**[예제: VariableInitializationExample.java]**
```java
package ch02.sec01;

public class VariableInitializationExample {
    public static void main(String[] args) {
        //변수 value 선언
        int value;
        
        //연산 결과를 변수 result의 초기값으로 대입
        int result = value + 10; //오류 발생
        
        //변수 result 값을 읽고 콘솔에 출력
        System.out.println(result);
    }
}
```

변수는 출력문이나 연산식에 사용되어 변수값을 활용한다. 다음 예제는 변수를 문자열과 결합 후 출력하거나 연산식에서 활용하는 모습을 보여 준다.

**[예제: VariableUseExample.java]**
```java
package ch02.sec01;

public class VariableUseExample {
    public static void main(String[] args) {
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간 " + minute + "분");
        
        int totalMinute = (hour*60) + minute;
        System.out.println("총 " + totalMinute + "분");
    }
}
```

**실행 결과**
```
3시간 5분
총 185분
```

변수는 또 다른 변수에 대입되어 메모리 간에 값을 복사할 수 있다. 다음 코드는 변수 x값을 변수 y값으로 복사한다.

```java
int x = 10; //변수 x에 10을 대입
int y = x; //변수 y에 변수 x 값을 대입
```

다음 예제는 두 변수의 값을 교환하는 방법을 보여 준다. 두 변수의 값을 교환하기 위해서 새로운 변수 temp를 선언한 것에 주목하길 바란다.

**[예제: VariableExchangeExample.java]**
```java
package ch02.sec01;

public class VariableExchangeExample {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.println("x:" + x + ", y:" + y);
        
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x + ", y:" + y);
    }
}
```

**실행 결과**
```
x:3, y:5
x:5, y:3
```

### 2.2 정수 타입

변수는 선언될 때의 타입에 따라 저장할 수 있는 값의 종류와 허용 범위가 달라진다. 자바는 정수, 실수, 논리값을 저장할 수 있는 기본(primitive) 타입 8개를 다음과 같이 제공한다.

| 값의 분류        | 기본 타입                    |
| :--------------- | :--------------------------- |
| 정수             | byte, char, short, int, long |
| 실수             | float, double                |
| 논리(true/false) | boolean                      |

정수 타입은 총 5개로, 다음과 같이 메모리 할당 크기와 저장되는 값의 범위를 가지고 있다.

| 타입  | 메모리 크기  | 저장되는 값의 허용 범위                                                   |
| :---- | :----------- | :------------------------------------------------------------------------ |
| byte  | 1byte(8bit)  | -2^7 ~ (2^7-1) (-128 ~ 127)                                               |
| short | 2byte(16bit) | -2^15 ~ (2^15-1) (-32,768 ~ 32,767)                                       |
| char  | 2byte(16bit) | 0 ~ (2^16-1) (0 ~ 65535, 유니코드)                                        |
| int   | 4byte(32bit) | -2^31 ~ (2^31-1) (-2,147,483,648 ~ 2,147,483,647)                         |
| long  | 8byte(64bit) | -2^63 ~ (2^63-1) (-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807) |

`byte`, `short`, `int`, `long`은 모두 부호 있는(signed) 정수 타입이므로 최상위 bit는 부호 bit로 사용되고, 나머지 bit는 값의 범위를 결정한다.

코드에서 프로그래머가 직접 입력한 값을 리터럴(literal)이라고 부르는데, 변수에 대입할 정수 리터럴은 진수에 따라 작성하는 방법이 다르다.

* **2진수**: `0b` 또는 `0B`로 시작하고 0과 1로 작성
  ```java
  int x = 0b1011; //10진수 값 = 11
  int y = 0B10100; //10진수 값 = 20
  ```
* **8진수**: `0`으로 시작하고 0~7 숫자로 작성
  ```java
  int x = 013; //10진수 값 = 11
  int y = 0206; //10진수 값 = 134
  ```
* **10진수**: 소수점이 없는 0~9 숫자로 작성
  ```java
  int x = 12;
  int y = 365;
  ```
* **16진수**: `0x` 또는 `0X`로 시작하고 0~9 숫자나 A, B, C, D, E, F 또는 a, b, c, d, e, f로 작성
  ```java
  int x = 0xB3; //10진수 값 = 179
  int y = 0x2A0F; //10진수 값 = 10767
  ```

다음 예제는 다양한 정수 리터럴을 `int` 타입 변수에 대입하고 10진수로 출력한다.

**[예제: IntegerLiteralExample.java]**
```java
package ch02.sec02;

public class IntegerLiteralExample {
    public static void main(String[] args) {
        int var1 = 0b1011; //2진수
        int var2 = 0206;   //8진수
        int var3 = 365;    //10진수
        int var4 = 0xB3;   //16진수
        
        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);
    }
}
```

**실행 결과**
```
var1: 11
var2: 134
var3: 365
var4: 179
```

다음 예제는 `byte` 타입 변수에 허용 범위를 초과한 값을 대입했을 경우 컴파일 오류가 발생하는 것을 보여 준다.

**[예제: ByteExample.java]**
```java
package ch02.sec02;

public class ByteExample {
    public static void main(String[] args) {
        byte var1 = -128;
        byte var2 = -30;
        byte var3 = 0;
        byte var4 = 30;
        byte var5 = 127;
        byte var6 = 128; //컴파일 에러(Type mismatch: cannot convert from int to byte)
        
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);
    }
}
```

`long` 타입은 수치가 큰 데이터를 다루는 프로그램에서 사용된다. 예를 들어 은행이나 과학 분야에서 사용되는 프로그램들이다. 기본적으로 컴파일러는 정수 리터럴을 `int` 타입 값으로 간주하기 때문에 `int` 타입의 허용 범위(-2,147,483,648 ~ 2,147,483,647)를 초과하는 리터럴은 뒤에 소문자 `l`이나 대문자 `L`을 붙여 `long` 타입 값임을 컴파일러에게 알려 줘야 한다.

**[예제: LongExample.java]**
```java
package ch02.sec02;

public class LongExample {
    public static void main(String[] args) {
        long var1 = 10;
        long var2 = 20L;
        //long var3 = 1000000000000; //컴파일러는 int로 간주하기 때문에 에러 발생
        long var4 = 1000000000000L;
        
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var4);
    }
}
```

### 2.3 문자 타입

하나의 문자를 작은따옴표(`'`)로 감싼 것을 문자 리터럴이라고 한다. 문자 리터럴은 유니코드로 변환되어 저장되는데, 유니코드는 세계 각국의 문자를 0~65535 숫자로 매핑한 국제 표준 규약이다. 자바는 이러한 유니코드를 저장할 수 있도록 `char` 타입을 제공한다.

```java
char var1 = 'A'; //'A' 문자와 매핑되는 숫자: 65로 대입
char var3 = '가'; //'가' 문자와 매핑되는 숫자: 44032로 대입
```

유니코드가 정수이므로 `char` 타입도 정수 타입에 속한다. 그렇기 때문에 `char` 변수에 작은따옴표로 감싼 문자가 아니라 유니코드 숫자를 직접 대입할 수도 있다.

```java
char c = 65; //10진수 65와 매핑되는 문자: 'A'
char c = 0x0041; //16진수 0x0041과 매핑되는 문자: 'A'
```

**[예제: CharExample.java]**
```java
package ch02.sec03;

public class CharExample {
    public static void main(String[] args) {
        char c1 = 'A'; //문자 저장
        char c2 = 65; //유니코드 직접 저장
        
        char c3 = '가'; //문자 저장
        char c4 = 44032; //유니코드 직접 저장
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}
```

**실행 결과**
```
A
A
가
가
```

`char` 타입의 변수에 어떤 문자도 대입하지 않고 단순히 초기화를 할 목적으로 다음과 같이 작은따옴표(`'`) 두 개를 연달아 붙인 빈(empty) 문자를 대입하면 컴파일 에러가 발생한다. 이 경우에는 공백(유니코드: 32) 하나를 포함해서 초기화해야 한다.

```java
char c = ''; //컴파일 에러
char c = ' '; //공백 하나를 포함해서 초기화
```

### 2.4 실수 타입

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

### 2.5 논리 타입

참과 거짓을 의미하는 논리 리터럴은 `true`와 `false`이다. 논리 리터럴은 `boolean` 타입 변수에 다음과 같이 대입할 수 있다.

```java
boolean stop = true;
boolean stop = false;
```

`boolean` 타입 변수는 주로 두 가지 상태값을 저장할 필요가 있을 경우에 사용되며, 상태값에 따라 조건문과 제어문의 실행 흐름을 변경하는 데 사용된다. 연산식 중에서 비교 및 논리 연산의 산출값은 `true` 또는 `false`이므로 `boolean` 타입 변수에 다음과 같이 대입할 수 있다.

```java
int x = 10;
boolean result = (x == 20); //변수 x의 값이 20인가?
boolean result = (x != 20); //변수 x의 값이 20이 아닌가?
boolean result = (x > 20); //변수 x의 값이 20보다 큰가?
boolean result = (0 < x && x < 20); //변수 x의 값이 0보다 크고, 20보다 적은가?
boolean result = (x < 0 || x > 200); //변수 x의 값이 0보다 적거나 200보다 큰가?
```

다음 예제는 `stop` 변수값에 따라 `if` 블록과 `else` 블록 중 하나를 실행하고, 연산식의 결과를 `boolean` 변수에 저장해서 출력한다.

**[예제: BooleanExample.java]**
```java
package ch02.sec05;

public class BooleanExample {
    public static void main(String[] args) {
        boolean stop = true;
        if(stop) {
            System.out.println("중지합니다.");
        } else {
            System.out.println("시작합니다.");
        }
        
        int x = 10;
        boolean result1 = (x == 20); //변수 x의 값이 20인가?
        boolean result2 = (x != 20); //변수 x의 값이 20이 아닌가?
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
    }
}
```

**실행 결과**
```
중지합니다.
result1: false
result2: true
```

### 2.6 문자열 타입

작은따옴표(`'`)로 감싼 한 개의 문자는 `char` 타입이지만, 큰따옴표(`"`)로 감싼 여러 개의 문자들은 유니코드로 변환되지 않는다. 따라서 다음은 잘못 작성된 코드다.

```java
char var1 = "A"; //컴파일 에러
char var2 = "홍길동"; //컴파일 에러
```

큰따옴표(`"`)로 감싼 문자들을 문자열이라고 부르는데, 문자열을 변수에 저장하고 싶다면 다음과 같이 `String` 타입을 사용해야 한다.

```java
String var1 = "A";
String var2 = "홍길동";
```

> **NOTE:** `String` 타입은 자바 기본 타입에 속하지 않는 참조 타입이다. 참조 타입에 대해서는 5장에서 상세히 설명한다.

문자열 내부에 역슬래쉬(`\`)가 붙은 문자를 사용할 수가 있는데, 이것을 이스케이프(escape) 문자라고 한다. 이스케이프 문자를 사용하면 특정 문자를 포함할 수 있고, 출력에 영향을 미치기도 한다.

**이스케이프 문자**
* `\"`: " 문자 포함
* `\'`: ' 문자 포함
* `\\`: \ 문자 포함
* `\u16진수`: 16진수 유니코드에 해당하는 문자 포함
* `\t`: 출력 시 탭만큼 띄움
* `\n`: 출력 시 줄바꿈(라인피드)
* `\r`: 출력 시 캐리지 리턴

다음 예제는 이스케이프 문자를 사용하는 방법을 보여 준다. 문자열에 큰따옴표를 넣기 위해 `\"`를 사용했고, 탭만큼 띄워 출력하기 위해 `\t`를, 다음 행으로 이동하기 위해 `\n`을 사용하였다. 역슬래쉬(`\`) 기호가 `₩`로 표시될 수도 있는데, 이것은 폰트 때문이니 상관 없다.

**[예제: StringExample.java]**
```java
package ch02.sec06;

public class StringExample {
    public static void main(String[] args) {
        String name = "홍길동";
        String job = "프로그래머";
        System.out.println(name);
        System.out.println(job);
        
        String str = "나는 \"자바\"를 배웁니다.";
        System.out.println(str);
        
        str = "번호\t이름\t직업";
        System.out.println(str);
        
        System.out.print("나는\n");
        System.out.print("자바를\n");
        System.out.print("배웁니다.");
    }
}
```

**실행 결과**
```
홍길동
프로그래머
나는 "자바"를 배웁니다.
번호	이름	직업
나는
자바를
배웁니다.
```

Java 13부터는 다음과 같은 텍스트 블록 문법을 제공한다.

```java
String str = """
...
""";
```

큰따옴표 3개로 감싸면 이스케이프하거나 라인피드를 할 필요가 없이 작성된 그대로 문자열로 저장된다. 다음 예제에서 `str1`과 `str2`는 동일한 문자열이 저장된다.

**[예제: TextBlockExample.java]**
```java
package ch02.sec06;

public class TextBlockExample {
    public static void main(String[] args) {
        String str1 = "" +
        "{\n" +
        "\t\"id\":\"winter\",\n" +
        "\t\"name\":\"눈송이\"\n" +
        "}";
        
        String str2 = """
        {
            "id":"winter",
            "name":"눈송이"
        }
        """;
        
        System.out.println(str1);
        System.out.println("------------------------------------");
        System.out.println(str2);
        System.out.println("------------------------------------");
        String str = """
        나는 자바를 \
        학습합니다.
        나는 자바 고수가 될 겁니다.
        """;
        System.out.println(str);
    }
}
```

**실행 결과**
```
{
	"id":"winter",
	"name":"눈송이"
}
------------------------------------
{
	"id":"winter",
	"name":"눈송이"
}
------------------------------------
나는 자바를 학습합니다.
나는 자바 고수가 될 겁니다.
```

텍스트 블록에서 줄바꿈은 `\n`에 해당한다. 만약 줄바꿈을 하지 않고 다음 줄에 이어서 작성하고 싶다면 23라인처럼 맨 끝에 `\`를 붙여 주면 된다. 이 기능은 Java 14부터 제공된다.

### 2.7 자동 타입 변환

자동 타입 변환(promotion)은 말 그대로 자동으로 타입 변환이 일어나는 것을 말한다. 자동 타입 변환은 값의 허용 범위가 작은 타입이 허용 범위가 큰 타입으로 대입될 때 발생한다.

**자동 타입 변환**
큰 허용 범위 타입 = 작은 허용 범위 타입

기본 타입을 허용 범위 순으로 나열하면 다음과 같다.
`byte` < `short`, `char` < `int` < `long` < `float` < `double`

`int` 타입이 `byte` 타입보다 허용 범위가 더 크기 때문에 다음 코드는 자동 타입 변환이 된다.

```java
byte byteValue = 10;
int intValue = byteValue; //자동 타입 변환됨
```

정수 타입이 실수 타입으로 대입될 경우에는 무조건 자동 타입 변환이 된다. 실수 타입은 정수 타입보다 허용 범위가 더 크기 때문이다.

```java
long longValue = 5000000000L;
float floatValue = longValue; //5.0E9f로 저장됨
double doubleValue = longValue; //5.0E9로 저장됨
```

`char` 타입의 경우 `int` 타입으로 자동 변환되면 유니코드 값이 `int` 타입에 대입된다.

```java
char charValue = 'A';
int intValue = charValue; //65가 저장됨
```

자동 타입 변환에서 예외가 있다. `char` 타입보다 허용 범위가 작은 `byte` 타입은 `char` 타입으로 자동 변환될 수 없다. 왜냐하면 `char` 타입의 허용 범위는 음수를 포함하지 않는데, `byte` 타입은 음수를 포함하기 때문이다.

```java
byte byteValue = 65;
char charValue = byteValue; //컴파일 에러
```

다음은 자동 타입 변환이 생기는 다양한 코드들이다.

**[예제: PromotionExample.java]**
```java
package ch02.sec07;

public class PromotionExample {
    public static void main(String[] args) {
        //자동 타입 변환
        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println("intValue: " + intValue);
        
        char charValue = '가';
        intValue = charValue;
        System.out.println("가의 유니코드: " + intValue);
        
        intValue = 50;
        long longValue = intValue;
        System.out.println("longValue: " + longValue);
        
        longValue = 100;
        float floatValue = longValue;
        System.out.println("floatValue: " + floatValue);
        
        floatValue = 100.5F;
        double doubleValue = floatValue;
        System.out.println("doubleValue: " + doubleValue);
    }
}
```

**실행 결과**
```
intValue: 10
가의 유니코드: 44032
longValue: 50
floatValue: 100.0
doubleValue: 100.5
```

### 2.8 강제 타입 변환

큰 허용 범위 타입은 작은 허용 범위 타입으로 자동 타입 변환될 수 없다. 마치 큰 그릇을 작은 그릇 안에 넣을 수 없는 것과 동일한 이치이다. 하지만 큰 그릇을 작은 그릇 단위로 쪼개어서 한 조각만 작은 그릇에 넣는 것은 가능하다. 이를 강제 타입 변환(Casting)이라고 한다. 강제 타입 변환은 캐스팅 연산자 `()`를 사용하는데, 괄호 안에 들어가는 타입은 쪼개는 단위이다.

**작은 허용 범위 타입 = (작은 허용 범위 타입) 큰 허용 범위 타입**

```java
int intValue = 10;
byte byteValue = (byte) intValue; //강제 타입 변환
```

`int` 타입은 4byte이고 `byte` 타입은 1byte이므로 `int` 타입 `10`은 `byte` 타입 `10`으로 변환될 때 손실 없이 변환이 가능하다. 하지만 `int` 값이 `byte`의 허용 범위인 -128 ~ 127을 초과하면 `byte` 타입으로 변환될 때 데이터 손실이 발생할 수 있다.

다음 예제는 강제 타입 변환을 사용하는 다양한 방법을 보여 준다.

**[예제: CastingExample.java]**
```java
package ch02.sec08;

public class CastingExample {
    public static void main(String[] args) {
        int var1 = 10;
        byte var2 = (byte) var1;
        System.out.println(var2); //강제 타입 변환 후에 10이 그대로 유지
        
        long var3 = 300;
        int var4 = (int) var3;
        System.out.println(var4); //강제 타입 변환 후에 300이 그대로 유지
        
        int var5 = 65;
        char var6 = (char) var5;
        System.out.println(var6); //'A'가 출력
        
        double var7 = 3.14;
        int var8 = (int) var7;
        System.out.println(var8); //3이 출력
    }
}
```

**실행 결과**
```
10
300
A
3
```

### 2.9 연산식에서 자동 타입 변환

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

### 2.10 문자열을 기본 타입으로 변환

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

### 2.11 변수 사용 범위

`main()` 메소드 블록에는 다른 중괄호 `{}` 블록들이 작성될 수 있다. 조건문에 해당하는 `if`, 반복문에 해당하는 `for`, `while` 등이 중괄호 `{}` 블록을 가질 수 있는데, 이러한 중괄호 `{}` 블록 내에서 선언된 변수는 해당 중괄호 `{}` 블록 내에서만 사용이 가능하고 밖에서는 사용할 수 없다.

```java
public static void main(String[] args) {
    int var1; //메소드 블록에서 선언
    
    if(...) {
        int var2; //if 블록에서 선언
        //var1과 var2 사용 가능
    }
    
    for(...) {
        int var3; //for 블록에서 선언
        //var1과 var3 사용 가능
        //var2는 사용 못함
    }
    
    //var1 사용 가능
    //var2와 var3는 사용 못함
}
```

메소드 블록 전체에서 사용하고 싶다면 메소드 블록 첫머리에 선언하는 것이 좋고, 특정 블록 내부에서만 사용된다면 해당 블록 내에서 선언하는 것이 좋다.

**[예제: VariableScopeExample.java]**
```java
package ch02.sec11;

public class VariableScopeExample {
    public static void main(String[] args) {
        int v1 = 15;
        if(v1>10) {
            int v2 = v1 - 10;
        }
        int v3 = v1 + v2 + 5; //v2 변수를 사용할 수 없기 때문에 컴파일 에러 발생
    }
}
```

### 2.12 콘솔로 변수값 출력

우리는 지금까지 표준 출력 장치인 모니터(명령 프롬프트, 터미널, 콘솔)에 값을 출력하기 위해 `System.out.println()`을 이용했다. 괄호() 안에 리터럴을 넣으면 리터럴이 그대로 출력되고, 변수를 넣으면 변수에 저장된 값이 출력되었다.

**`System.out.println(리터럴 또는 변수);`**
(시스템으로 출력하는데 괄호 안의 내용을 출력하고 행을 바꿔라)

출력 방법에 따라 `println()` 이외에도 다음과 같이 `print()`, `printf()`를 사용할 수 있다.

| 메소드                                 | 의미                                          |
| :------------------------------------- | :-------------------------------------------- |
| `println(내용);`                       | 괄호 안의 내용을 출력하고 행을 바꿔라.        |
| `print(내용);`                         | 괄호 안의 내용을 출력하고 행은 바꾸지 말아라. |
| `printf("형식문자열", 값1, 값2, ...);` | 형식 문자열에 맞추어 뒤의 값을 출력해라.      |

`printf()`의 형식 문자열은 다음과 같은 포맷으로 작성한다.

`% [argument_index$] [flags] [width] [.precision] conversion` (값의 순번, flags, 전체 자릿수, 소수 자릿수, 변환문자)

형식 문자열에서 `%`와 `conversion`(변환 문자)은 필수로 작성하고 그 외의 항목은 모두 생략할 수 있다. `%`는 형식 문자열의 시작을 뜻하고, `conversion`에는 제공되는 값의 타입에 따라 `d`(정수), `f`(실수), `s`(문자열)가 온다.

```java
System.out.printf("이름: %s", "김자바"); //이름: 김자바
System.out.printf("나이: %d", 25); //나이: 25
```

형식 문자열에 포함될 값이 두 개 이상일 경우에는 값의 순번(argument_index$)을 포함시켜야 한다. 예를 들어 `1$`는 첫 번째 값을, `2$`는 두 번째 값을 뜻한다.

```java
System.out.printf("이름: %1$s, 나이: %2$d", "김자바", 25); //이름: 김자바, 나이: 25
```

`flags`는 빈 공간을 채우는 방법인데, 생략되면 왼쪽이 공백으로 채워지고 `-`가 오면 오른쪽이 공백으로 채워진다. `0`은 공백 대신 0으로 채운다. `width`는 소수점을 포함한 전체 자릿수이며, `.precision`은 소수 이하 자릿수이다. 자주 사용되는 형식 문자열은 다음과 같다.

| 형식화된 문자열 | 설명                                             | 출력 예    |
| :-------------- | :----------------------------------------------- | :--------- |
| **정수**        |                                                  |            |
| `%d`            | 정수                                             | 123        |
| `%6d`           | 6자리 정수. 왼쪽 빈자리 공백                     | ___123     |
| `%-6d`          | 6자리 정수. 오른쪽 빈자리 공백                   | 123___     |
| `%06d`          | 6자리 정수. 왼쪽 빈자리 0 채움                   | 000123     |
| **실수**        |                                                  |            |
| `%10.2f`        | 정수 7자리 소수점+소수 2자리. 왼쪽 빈자리 공백   | ____123.45 |
| `%-10.2f`       | 정수 7자리 소수점+소수 2자리. 오른쪽 빈자리 공백 | 123.45____ |
| `%010.2f`       | 정수 7자리 소수점+소수 2자리. 왼쪽 빈자리 0 채움 | 0000123.45 |
| **문자열**      |                                                  |            |
| `%s`            | 문자열                                           | abc        |
| `%6s`           | 6자리 문자열. 왼쪽 빈자리 공백                   | ___abc     |
| `%-6s`          | 6자리 문자열. 오른쪽 빈자리 공백                 | abc___     |
| **특수 문자**   |                                                  |            |
| `\t`            | 탭(tab)                                          |            |
| `\n`            | 줄바꿈                                           |            |
| `%%`            | %                                                | %          |

**[예제: PrintfExample.java]**
```java
package ch02.sec12;

public class PrintfExample {
    public static void main(String[] args) {
        int value = 123;
        System.out.printf("상품의 가격:%d원\n", value);
        System.out.printf("상품의 가격:%6d원\n", value);
        System.out.printf("상품의 가격:%-6d원\n", value);
        System.out.printf("상품의 가격:%06d원\n", value);
        
        double area = 3.14159 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10, area);
        
        String name = "홍길동";
        String job = "도적";
        System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
    }
}
```

**실행 결과**
```
상품의 가격:123원
상품의 가격:   123원
상품의 가격:123   원
상품의 가격:000123원
반지름이 10인 원의 넓이:    314.16
     1 | 홍길동      |         도적
```

### 2.13 키보드 입력 데이터를 변수에 저장

키보드로부터 입력된 데이터를 읽는 방법은 여러 가지가 있지만 이것은 17장에서 자세히 다루기로 하고, 여기서는 기업체 코딩 테스트 문제에서 주로 사용하는 방법을 소개하려고 한다. 앞으로 우리 책의 예제나 확인문제에서 키보드로부터 데이터를 입력받을 때 사용하면 된다.

키보드로부터 입력된 데이터를 읽고 변수에 저장하는 가장 쉬운 방법은 `Scanner`를 사용하는 것이다. 다음과 같이 `Scanner` 타입 변수를 선언하고, 대입 연산자 `=`를 사용해서 `new` 연산자로 생성한 `Scanner` 객체를 변수에 대입한다. `new` 연산자는 6장에서 자세히 설명한다.

```java
Scanner scanner = new Scanner(System.in);
```

그리고 다음과 같이 `scanner.nextLine()`을 실행하면 키보드로 입력된 내용을 문자열로 읽고 좌측 `String` 변수에 저장할 수 있다.

```java
String inputData = scanner.nextLine();
```
Enter 키를 누르면 입력된 문자열을 읽음

`scanner.nextLine()`은 Enter 키가 입력되기 전까지 블로킹(대기) 상태가 되며, Enter 키가 입력되면 지금까지 입력된 모든 내용을 문자열로 읽는다.

**[예제: ScannerExample.java]**
```java
package ch02.sec13;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("x 값 입력: ");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);
        
        System.out.print("y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);
        
        int result = x + y;
        System.out.println("x + y: " + result);
        System.out.println();
        
        while(true) {
            System.out.print("입력 문자열: ");
            String data = scanner.nextLine();
            if(data.equals("q")) {
                break;
            }
            System.out.println("출력 문자열: " + data);
            System.out.println();
        }
        
        System.out.println("종료");
    }
}
```

**실행 결과**
```
x 값 입력: 3
y 값 입력: 5
x + y: 8

입력 문자열: Hello
출력 문자열: Hello

입력 문자열: 안녕하세요
출력 문자열: 안녕하세요

입력 문자열: q
종료
```

21라인의 `while(true)` 문은 중괄호 안을 무한히 반복 실행하는 코드로, 4장에서 자세히 설명한다. 24~26라인은 입력된 문자열이 `q`라면 반복을 중단하는 코드이다.
자바는 기본 타입(byte, short, int, long, float, double, boolean) 값이 동일한지 비교할 때는 `==`를 사용하고, `String` 타입 값이 동일한지 비교할 때에는 `equals()`를 사용한다. `String` 타입과 비교에 대해서는 5장에서 자세히 설명한다.

```java
boolean result = data.equals("문자열");
//같으면 true, 다르면 false
```

### 확인문제

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
