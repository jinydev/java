---
layout: oop
title: "11.3 예외 종류에 따른 처리"
nav_order: 3
parent: "Chapter 11. 예외 처리"
grand_parent: "객체지향 자바 프로그래밍"
---

# 11.3 예외 종류에 따른 처리

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
