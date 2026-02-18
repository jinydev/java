---
layout: oop
title: "11.6 사용자 정의 예외"
nav_order: 6
parent: "Chapter 11. 예외 처리"
grand_parent: "객체지향 자바 프로그래밍"
---

# 11.6 사용자 정의 예외

은행의 뱅킹 프로그램에서 잔고보다 더 많은 출금 요청이 들어온 경우에는 잔고 부족 예외를 발생시킬 필요가 있다. 그러나 잔고 부족 예외는 표준 라이브러리에는 존재하지 않기 때문에 직접 예외 클래스를 정의해서 사용해야 한다. 이것을 사용자 정의 예외라고 한다.

## 사용자 정의 예외

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

## 예외 발생시키기

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
