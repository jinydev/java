---
layout: part02
title: Chapter 11. 예외 처리
---

# Chapter 11. 예외 처리

## 11.1 예외와 예외 클래스

컴퓨터 하드웨어의 고장으로 인해 응용프로그램 실행 오류가 발생하는 것을 자바에서는 에러(Error)라고 한다. 프로그램을 아무리 견고하게 만들어도 개발자는 이런 에러에 대처할 방법이 전혀 없다.

자바에서는 에러 이외에 예외(Exception)라고 부르는 오류가 있다. 예외란 잘못된 사용 또는 코딩으로 인한 오류를 말한다. 예외가 발생되면 프로그램은 곧바로 종료된다는 점에서는 에러와 동일하지만, 예외 처리를 통해 계속 실행 상태를 유지할 수 있다.

예외에는 다음 두 가지가 있다.

*   **일반 예외(Exception)**: 컴파일러가 예외 처리 코드 여부를 검사하는 예외를 말한다.
*   **실행 예외(Runtime Exception)**: 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외를 말한다.

자바는 예외가 발생하면 예외 클래스로부터 객체를 생성한다. 이 객체는 예외 처리 시 사용된다. 자바의 모든 에러와 예외 클래스는 `Throwable`을 상속받아 만들어지고, 추가적으로 예외 클래스는 `java.lang.Exception` 클래스를 상속받는다.

실행 예외는 `RuntimeException`과 그 자식 클래스에 해당한다. 그 밖의 예외 클래스는 모두 일반 예외이다. 자바는 자주 사용되는 예외 클래스를 표준 라이브러리로 제공한다.

## 11.2 예외 처리 코드

예외가 발생했을 때 프로그램의 갑작스러운 종료를 막고 정상 실행을 유지할 수 있도록 처리하는 코드를 예외 처리 코드라고 한다. 예외 처리 코드는 `try-catch-finally` 블록으로 구성된다. `try-catch-finally` 블록은 생성자 내부와 메소드 내부에서 작성된다.

**정상 실행되었을 경우**
```java
try {
    // 예외 발생 가능 코드
} catch (예외클래스 e) {
    // 예외 처리
} finally {
    // 항상 실행
}
```

**예외가 발생되었을 경우**
```java
try {
    // 예외 발생
} catch (예외클래스 e) {
    // 예외 처리
} finally {
    // 항상 실행
}
```

`try` 블록에서 작성한 코드가 예외 없이 정상 실행되면 `catch` 블록은 실행되지 않고 `finally` 블록이 실행된다. 그러나 `try` 블록에서 예외가 발생하면 `catch` 블록이 실행되고 연이어 `finally` 블록이 실행된다.

예외 발생 여부와 상관없이 `finally` 블록은 항상 실행된다. 심지어 `try` 블록과 `catch` 블록에서 return 문(메소드 종료)을 사용하더라도 `finally` 블록은 항상 실행된다. `finally` 블록은 옵션으로 생략 가능하다.

다음 예제에서 `printLength()` 메소드는 문자열의 수를 리턴한다. 12라인에서 문자열 대신 `null`을 입력하면 5라인에서 `NullPointerException`이 발생한다. `NullPointerException`은 참조 변수가 null인 상태에서 필드나 메소드에 접근할 경우 발생한다. `NullPointerException`은 실행 예외이므로 컴파일할 때 예외 처리 코드가 없어도 되지만, 실행 중에 발생하면 프로그램은 즉시 종료된다.

**ExceptionHandlingExample1.java**
```java
package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = data.length();
        System.out.println("문자 수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null); // 매개값으로 null을 대입 -> NullPointerException 발생
        System.out.println("[프로그램 종료]");
    }
}
```

**실행 결과**
```
[프로그램 시작]

문자 수: 10
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
	at ch11.sec02.exam01.ExceptionHandlingExample1.printLength(ExceptionHandlingExample1.java:5)
	at ch11.sec02.exam01.ExceptionHandlingExample1.main(ExceptionHandlingExample1.java:12)
```

위 예제에서 예외 처리 코드를 추가해 보자. `try` 블록에서 `NullPointerException`이 발생하면 `catch` 블록을 실행해서 예외를 처리하도록 하고, 예외 발생 여부와 상관없이 `finally` 블록을 실행하여 마무리 작업을 해보자.

**ExceptionHandlingExample2.java**
```java
package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
            // System.out.println(e.toString());
            // e.printStackTrace();
        } finally {
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
```

**실행 결과**
```
[프로그램 시작]

문자 수: 10
[마무리 실행]

Cannot invoke "String.length()" because "data" is null
[마무리 실행]

[프로그램 종료]
```

### 예외 정보를 얻는 3가지 방법

9~11라인은 발생된 예외의 정보를 출력하는 3가지 방법을 보여 준다. 예외가 발생하면 예외 객체가 catch 선언부의 예외 클래스 변수에 대입된다.

1.  `e.getMessage()`: 예외가 발생한 이유만 리턴한다.
2.  `e.toString()`: 예외의 종류와 사유를 리턴한다.
3.  `e.printStackTrace()`: 예외가 어디서 발생했는지 추적한 내용까지도 출력해 준다.

다음 예제에서 `Class.forName("패키지...클래스")`는 ClassPath 위치에서 주어진 클래스를 찾는 코드이다. 찾지 못했을 경우, `ClassNotFoundException`이라는 일반 예외가 발생한다. 따라서 소스가 컴파일되려면 예외 처리 코드를 반드시 작성해야 한다.

**ExceptionHandlingExample.java**
```java
package ch11.sec02.exam02;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            Class.forName("java.lang.String");
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Class.forName("java.lang.String2");
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

**실행 결과**
```
java.lang.String 클래스가 존재합니다.

java.lang.ClassNotFoundException: java.lang.String2
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520)
	at java.base/java.lang.Class.forName0(Native Method)
	at java.base/java.lang.Class.forName(Class.java:375)
    at ch11.sec02.exam02.ExceptionHandlingExample.main(ExceptionHandlingExample.java:16)
```

## 11.3 예외 종류에 따른 처리

`try` 블록에는 다양한 종류의 예외가 발생할 수 있다. 이 경우, 다중 catch를 사용하면 발생하는 예외에 따라 예외 처리 코드를 다르게 작성할 수 있다. `catch` 블록의 예외 클래스는 `try` 블록에서 발생된 예외의 종류를 말하는데, 해당 타입의 예외가 발생하면 `catch` 블록이 선택되어 실행된다.

```java
try {
    // ArrayIndexOutOfBoundsException 발생
    // NumberFormatException 발생
} catch (ArrayIndexOutOfBoundsException e) {
    // 예외 처리 1
} catch (NumberFormatException e) {
    // 예외 처리 2
}
```

`catch` 블록이 여러 개라 할지라도 `catch` 블록은 단 하나만 실행된다. 그 이유는 `try` 블록에서 동시다발적으로 예외가 발생하지 않으며, 하나의 예외가 발생하면 즉시 실행을 멈추고 해당 `catch` 블록으로 이동하기 때문이다.

다음 예제는 배열의 인덱스가 초과되었을 경우 발생하는 `ArrayIndexOutOfBoundsException`과 숫자 타입이 아닐 때 발생하는 `NumberFormatException`을 각각 다르게 예외 처리한다.

**ExceptionHandlingExample.java**
```java
package ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i=0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch(NumberFormatException e) {
                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
            }
        }
    }
}
```

**실행 결과**
```
array[0]: 100
숫자로 변환할 수 없음: For input string: "1oo"
배열 인덱스가 초과됨: Index 2 out of bounds for length 2
```

처리해야 할 예외 클래스들이 상속 관계에 있을 때는 하위 클래스 `catch` 블록을 먼저 작성하고 상위 클래스 `catch` 블록을 나중에 작성해야 한다. 예외가 발생하면 `catch` 블록은 위에서부터 차례대로 검사 대상이 되는데, 하위 예외도 상위 클래스 타입이므로 상위 클래스 `catch` 블록이 먼저 검사 대상이 되면 안 된다.

**ExceptionHandlingExample.java**
```java
package ch11.sec03.exam02;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i=0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch(Exception e) {
                System.out.println("실행에 문제가 있습니다.");
            }
        }
    }
}
```

**실행 결과**
```
array[0]: 100
실행에 문제가 있습니다.
배열 인덱스가 초과됨: Index 2 out of bounds for length 2
```

두 개 이상의 예외를 하나의 `catch` 블록으로 동일하게 예외 처리하고 싶을 때가 있다. 이 경우에는 `catch` 블록에 예외 클래스를 기호 `|`로 연결하면 된다.

**ExceptionHandlingExample.java**
```java
package ch11.sec03.exam03;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo", null, "200"};

        for(int i=0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch(NullPointerException | NumberFormatException e) {
                System.out.println("데이터에 문제가 있음: " + e.getMessage());
            }
        }
    }
}
```

**실행 결과**
```
array[0]: 100
데이터에 문제가 있음: For input string: "1oo"
데이터에 문제가 있음: Cannot parse null string
array[3]: 200
배열 인덱스가 초과됨: Index 4 out of bounds for length 4
```

## 11.4 리소스 자동 닫기

리소스(resource)란 데이터를 제공하는 객체를 말한다. 리소스는 사용하기 위해 열어야(open) 하며, 사용이 끝난 다음에는 닫아야(close) 한다. 예를 들어 파일 내용을 읽기 위해서는 파일을 열어야 하며, 다 읽고 난 후에는 파일을 닫아야 다른 프로그램에서 사용할 수 있다.

리소스를 사용하다가 예외가 발생될 경우에도 안전하게 닫는 것이 중요하다. 그렇지 않으면 리소스가 불안정한 상태로 남아있게 된다.

다음 코드는 `file.txt` 파일의 내용을 읽기 위해 `FileInputStream` 리소스를 사용하는데, 예외 발생 여부와 상관없이 `finally` 블록에서 안전하게 close 한다.

```java
FileInputStream fis = null;
try {
    fis = new FileInputStream("file.txt");
} catch (IOException e) {
    ...
} finally {
    fis.close();
}
```

좀 더 쉬운 방법이 있다. `try-with-resources` 블록을 사용하면 예외 발생 여부와 상관없이 리소스를 자동으로 닫아준다. `try` 괄호에 리소스를 여는 코드를 작성하면 `try` 블록이 정상적으로 실행을 완료했거나 도중에 예외가 발생하면 자동으로 리소스의 `close()` 메소드가 호출된다.

```java
try (FileInputStream fis = new FileInputStream("file.txt")) {
    ...
} catch(IOException e) {
    ...
}
```

`try-with-resources` 블록을 사용하기 위해서는 조건이 하나 있다. 리소스는 `java.lang.AutoCloseable` 인터페이스를 구현해서 `AutoCloseable` 인터페이스의 `close()` 메소드를 재정의해야 한다.

```java
public class FileInputStream implements AutoCloseable {
    ...
    @Override
    public void close() throws Exception { ... }
}
```

복수 개의 리소스를 사용해야 한다면 다음과 같이 `try()` 괄호 안에 세미콜론(;)으로 구분해서 리소스를 여는 코드를 작성하면 된다.

```java
try (
    FileInputStream fis1 = new FileInputStream("file1.txt");
    FileInputStream fis2 = new FileInputStream("file2.txt")
) {
    ...
} catch(IOException e) {
    ...
}
```

Java 8 이전 버전은 `try` 괄호 안에서 리소스 변수를 반드시 선언해야 했지만, Java 9 이후부터는 외부 리소스 변수를 사용할 수 있다.

```java
FileInputStream fis1 = new FileInputStream("file1.txt");
FileInputStream fis2 = new FileInputStream("file2.txt");

try (fis1; fis2) {
    ...
} catch(IOException e) {
    ...
}
```

다음 예제는 `AutoCloseable` 인터페이스를 구현한 `MyResource` 리소스를 `try-with-resources` 블록에서 사용한다. `try` 블록에서 예외 발생 여부와 상관없이 안전하게 `close()` 메소드가 실행되는 것을 볼 수 있다.

**MyResource.java**
```java
package ch11.sec04;

public class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }

    public String read1() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "100";
    }

    public String read2() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "abc";
    }

    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + name + ") 닫기]");
    }
}
```

**TryWithResourceExample.java**
```java
package ch11.sec04;

public class TryWithResourceExample {
    public static void main(String[] args) {
        try (MyResource res = new MyResource("A")) {
            String data = res.read1();
            int value = Integer.parseInt(data);
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        try (MyResource res = new MyResource("A")) {
            String data = res.read2();
            // NumberFormatException 발생
            int value = Integer.parseInt(data);
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        MyResource res1 = new MyResource("A");
        MyResource res2 = new MyResource("B");
        try (res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read1();
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
}
```

**실행 결과**
```
[MyResource(A) 열기]
[MyResource(A) 읽기]
[MyResource(A) 닫기]

[MyResource(A) 열기]
[MyResource(A) 읽기]
[MyResource(A) 닫기]
예외 처리: For input string: "abc"

[MyResource(A) 열기]
[MyResource(B) 열기]
[MyResource(A) 읽기]

## 11.5 예외 떠넘기기

메소드 내부에서 예외가 발생할 때 `try-catch` 블록으로 예외를 처리하는 것이 기본이지만, 메소드를 호출한 곳으로 예외를 떠넘길 수도 있다. 이때 사용하는 키워드가 `throws`이다. `throws`는 메소드 선언부 끝에 작성하는데, 떠넘길 예외 클래스를 쉼표로 구분해서 나열해 주면 된다.

```java
리턴타입 메소드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
}
```

`throws` 키워드가 붙어 있는 메소드에서 해당 예외를 처리하지 않고 떠넘겼기 때문에 이 메소드를 호출하는 곳에서 예외를 받아 처리해야 한다. 예를 들어 다음 코드는 `ClassNotFoundException`을 `throws`하는 `method2()`의 예외를 `method1()`에서 호출할 때 처리하고 있다.

```java
public void method1() {
    try {
        method2(); // method2() 호출
    } catch(ClassNotFoundException e) {
        System.out.println("예외 처리: " + e.getMessage());
    }
}

public void method2() throws ClassNotFoundException {
    Class.forName("java.lang.String2");
}
```

**ThrowsExample1.java**
```java
package ch11.sec05;

public class ThrowsExample1 {
    public static void main(String[] args) {
        try {
            findClass();
        } catch(ClassNotFoundException e) {
            System.out.println("예외 처리: " + e.toString());
        }
    }

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
```

**실행 결과**
```
예외 처리: java.lang.ClassNotFoundException: java.lang.String2
```

나열해야 할 예외 클래스가 많을 경우에는 `throws Exception` 또는 `throws Throwable` 만으로 모든 예외를 간단히 떠넘길 수도 있다.

```java
리턴타입 메소드명(매개변수, ...) throws Exception {
}
```

`main()` 메소드에서도 `throws` 키워드를 사용해서 예외를 떠넘길 수 있는데, 결국 JVM이 최종적으로 예외 처리를 하게 된다. JVM은 예외의 내용을 콘솔에 출력하는 것으로 예외 처리를 한다.

```java
public static void main(String[] args) throws Exception {
}
```

**ThrowsExample2.java**
```java
package ch11.sec05;

public class ThrowsExample2 {
    public static void main(String[] args) throws Exception {
        findClass();
    }

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
```

**실행 결과**
```
Exception in thread "main" java.lang.ClassNotFoundException: java.lang.String2
	at java.base/java.lang.Class.forName(Class.java:375)
	at ch11.sec05.ThrowsExample2.findClass(ThrowsExample2.java:9)
	at ch11.sec05.ThrowsExample2.main(ThrowsExample2.java:5)
```

## 11.6 사용자 정의 예외

은행의 뱅킹 프로그램에서 잔고보다 더 많은 출금 요청이 들어온 경우에는 잔고 부족 예외를 발생시킬 필요가 있다. 그러나 잔고 부족 예외는 표준 라이브러리에는 존재하지 않기 때문에 직접 예외 클래스를 정의해서 사용해야 한다. 이것을 사용자 정의 예외라고 한다.

### 사용자 정의 예외

사용자 정의 예외는 컴파일러가 체크하는 일반 예외로 선언할 수도 있고, 컴파일러가 체크하지 않는 실행 예외로 선언할 수도 있다. 통상적으로 일반 예외는 `Exception`의 자식 클래스로 선언하고, 실행 예외는 `RuntimeException`의 자식 클래스로 선언한다.

```java
public class XXXException extends [ Exception | RuntimeException ] {
    public XXXException() {
    }

    public XXXException(String message) {
        super(message);
    }
}
```

사용자 정의 예외 클래스에는 기본 생성자와 예외 메시지를 입력받는 생성자를 선언해 준다. 예외 메시지는 부모 생성자 매개값으로 넘겨주는데, 그 이유는 예외 객체의 공통 메소드인 `getMessage()`의 리턴값으로 사용하기 위해서이다.

다음은 잔고 부족 예외를 사용자 정의 예외 클래스로 선언한 것이다.

**InsufficientException.java**
```java
package ch11.sec06;

public class InsufficientException extends Exception {
    public InsufficientException() {
    }

    public InsufficientException(String message) {
        super(message);
    }
}
```

### 예외 발생시키기

자바에서 제공하는 표준 예외뿐만 아니라 사용자 정의 예외를 직접 코드에서 발생시키려면 `throw` 키워드와 함께 예외 객체를 제공하면 된다. 예외의 원인에 해당하는 메시지를 제공하고 싶다면 생성자 매개값으로 전달한다.

```java
throw new Exception();
throw new RuntimeException();
throw new InsufficientException();

throw new Exception("예외메시지");
throw new RuntimeException("예외메시지");
throw new InsufficientException("예외메시지");
```

throw된 예외는 직접 `try-catch` 블록으로 예외를 처리할 수도 있지만(아래 왼쪽), 대부분은 메소드를 호출한 곳에서 예외를 처리하도록 `throws` 키워드로 예외를 떠넘긴다(아래 오른쪽).

```java
void method() {
    try {
        throw new Exception("예외메시지");
    } catch(Exception e) {
        String message = e.getMessage();
    }
}
```

```java
void method() throws Exception {
    throw new Exception("예외메시지");
}
```

다음 예제는 은행 계좌(`Account`) 클래스의 출금(`withdraw`) 메소드에서 잔고(`balance`) 필드와 출금액(매개값)을 비교해 잔고가 부족하면 `InsufficientException`을 발생시키고 `throws`한다. 그리고 `AccountExample`은 `withdraw()` 메소드를 호출할 때 예외 처리를 한다.

**Account.java**
```java
package ch11.sec06;

public class Account {
    private long balance;

    public Account() { }

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) throws InsufficientException {
        if(balance < money) {
            throw new InsufficientException("잔고 부족: " + (money-balance) + " 모자람");
        }
        balance -= money;
    }
}
```

**AccountExample.java**
```java
package ch11.sec06;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();

        // 예금하기
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        // 출금하기
        try {
            account.withdraw(30000);
        } catch(InsufficientException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
```

**실행 결과**
```
예금액: 10000
잔고 부족: 20000 모자람
```

## 확인문제

1. 예외에 대한 설명 중 틀린 것은 무엇입니까?
   - ① 예외는 사용자의 잘못된 조작, 개발자의 잘못된 코딩으로 인한 프로그램 오류를 말한다.
   - ② RuntimeException의 하위 예외는 컴파일러가 예외 처리 코드를 체크하지 않는다.
   - ③ 예외는 try-catch 블록을 사용해서 처리된다.
   - ④ 자바 표준 예외만 프로그램에서 처리할 수 있다.

   **정답:** ④ (사용자 정의 예외도 처리할 수 있다.)

2. try-catch-finally 블록에 대한 설명 중 틀린 것은 무엇입니까?
   - ① try 블록에는 예외가 발생할 수 있는 코드를 작성한다.
   - ② catch 블록은 try 블록에서 발생한 예외를 처리하는 블록이다.
   - ③ try 블록에서 return 문을 사용하면 finally 블록은 실행되지 않는다.
   - ④ catch 블록은 예외의 종류별로 여러 개를 작성할 수 있다.

   **정답:** ③ (try 블록에서 return 문을 사용해도 finally 블록은 항상 실행된다.)

3. throws에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 생성자나 메소드의 선언 끝 부분에 사용되어 내부에서 발생된 예외를 떠넘긴다.
   - ② throws 뒤에는 떠넘겨야 할 예외를 쉼표(,)로 구분해서 기술한다.
   - ③ 모든 예외를 떠넘기기 위해 간단하게 throws Exception으로 작성할 수 있다.
   - ④ 새로운 예외를 발생시키기 위해 사용된다.

   **정답:** ④ (새로운 예외를 발생시키는 건 `throw`이다.)

4. throw에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 예외를 최초로 발생시키는 코드이다.
   - ② 예외를 호출한 곳으로 떠넘기기 위해 메소드 선언부에 작성된다.
   - ③ throw로 발생된 예외는 일반적으로 생성자나 메소드 선언부에 throws로 떠넘겨진다.
   - ④ throw 키워드 뒤에는 예외 객체 생성 코드가 온다.

   **정답:** ② (예외를 떠넘기는 건 `throws`이다.)

5. 메소드가 다음과 같이 선언되어 있습니다. 잘못된 예외 처리를 선택하세요.
   ```java
   public void method1() throws NumberFormatException, ClassNotFoundException { ... }
   ```
   - ① `try { method1(); } catch (Exception e) { }`
   - ② `void method2() throws Exception { method1(); }`
   - ③ `try { method1(); } catch (Exception e) { } catch (ClassNotFoundException e) { }`
   - ④ `try { method1(); } catch (ClassNotFoundException e) { } catch (NumberFormatException e) { }`

   **정답:** ③ (하위 예외 클래스인 `ClassNotFoundException`이 상위 예외 클래스인 `Exception`보다 뒤에 올 수 없다. 컴파일 에러가 발생한다.)

6. 다음 코드가 실행되었을 때 출력 결과를 작성해 보세요.
   ```java
   String[] strArray = { "10", "2a" };
   int value = 0;
   for(int i=0; i<=2; i++) {
       try {
           value = Integer.parseInt(strArray[i]);
       } catch(ArrayIndexOutOfBoundsException e) {
           System.out.println("인덱스를 초과했음");
       } catch(NumberFormatException e) {
           System.out.println("숫자로 변환할 수 없음");
       } finally {
           System.out.println(value);
       }
   }
   ```

   **정답:**
   ```
   10
   숫자로 변환할 수 없음
   10
   인덱스를 초과했음
   10
   ```

7. `login()` 메소드에서 존재하지 않는 ID를 입력하면 `NotExistIDException`을 발생시키고, 잘못된 패스워드를 입력하면 `WrongPasswordException`을 발생시키려고 합니다. 다음 `LoginExample`의 실행 결과를 보고 빈칸을 채워 보세요.

   **NotExistIDException.java**
   ```java
   public class NotExistIDException extends Exception {
       public NotExistIDException() {}
       public NotExistIDException(String message) {
           super(message);
       }
   }
   ```

   **WrongPasswordException.java**
   ```java
   public class WrongPasswordException extends Exception {
       public WrongPasswordException() {}
       public WrongPasswordException(String message) {
           super(message);
       }
   }
   ```

   **LoginExample.java**
   ```java
   public class LoginExample {
       public static void main(String[] args) {
           try {
               login("white", "12345");
           } catch(Exception e) {
               System.out.println(e.getMessage());
           }

           try {
               login("blue", "54321");
           } catch(Exception e) {
               System.out.println(e.getMessage());
           }
       }

       public static void login(String id, String password) throws Exception {
           // id가 blue가 아니라면 NotExistIDException을 발생시킴
           if(!id.equals("blue")) {
               throw new NotExistIDException("아이디가 존재하지 않습니다.");
           }

           // password가 12345가 아니라면 WrongPasswordException을 발생시킴
           if(!password.equals("12345")) {
               throw new WrongPasswordException("패스워드가 틀립니다.");
           }
       }
   }
   ```

   **실행 결과**
   ```
   아이디가 존재하지 않습니다.
   패스워드가 틀립니다.
   ```

8. `FileWriter`는 파일을 열고 데이터를 저장하는 클래스입니다. 예외 발생 여부와 상관없이 마지막에는 `close()` 메소드를 실행해서 파일을 닫아 주려고 합니다. 왼쪽 코드는 `try-catch-finally`를 이용해서 작성한 코드로, 리소스 자동 닫기를 이용하도록 수정하고 싶습니다. 수정한 코드를 오른쪽에 작성해 보세요.

   **FileWriter.java**
   ```java
   import java.io.IOException;

   public class FileWriter implements AutoCloseable {
       public FileWriter(String filePath) throws IOException {
           System.out.println(filePath + " 파일을 엽니다.");
       }

       public void write(String data) throws IOException {
           System.out.println(data + "를 파일에 저장합니다.");
       }

       @Override
       public void close() throws IOException {
           System.out.println("파일을 닫습니다.");
       }
   }
   ```

   **FileWriterExample.java**
   ```java
   import java.io.IOException;

   public class FileWriterExample {
       public static void main(String[] args) {
           try (FileWriter fw = new FileWriter("file.txt")) {
               fw.write("Java");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   ```
