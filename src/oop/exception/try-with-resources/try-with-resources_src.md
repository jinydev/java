---
layout: oop
title: "11.4 리소스 자동 닫기"
nav_order: 4
parent: "Chapter 11. 예외 처리"
grand_parent: "객체지향 자바 프로그래밍"
---

# 11.4 리소스 자동 닫기

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
