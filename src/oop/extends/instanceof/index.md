---
layout: oop
title: "7.9 객체 타입 확인 (instanceof)"
nav_order: 9
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
description: "7.9 객체 타입 확인 (instanceof) 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "7.9 객체 타입 확인 (instanceof), 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 7.9 객체 타입 확인 (instanceof)

강제 타입 변환(Downcasting)은 실패할 위험이 있다고 배웠습니다.
그래서 변환을 시도하기 전에 **"이 변환이 진짜 안전한가?"** 확인하는 과정이 필요합니다.
이때 사용하는 것이 바로 `instanceof` 연산자입니다.

### 💡 핵심 비유: 신분증 검사
> **"학생 할인(강제 변환)을 받으려면, 학생증(instanceof)을 보여주세요!"**
> 만약 학생이 아닌데(False) 학생 할인을 해달라고 하면 쫓겨납니다(Error).

![Instanceof Check](./img/instanceof_check.svg)

---

## 1. 기본 사용법

`instanceof`는 좌변의 객체가 우변의 타입인지 확인하여 **참(true) 또는 거짓(false)**을 돌려줍니다.

```java
boolean result = 객체 instanceof 타입;
```

### 예제
```java
Person p = new Student(); // 학생이 사람인 척 하고 있음

if (p instanceof Student) {
    System.out.println("학생 맞네요! 합격!");
    Student s = (Student) p; // 안전하게 변환
    s.study();
} else {
    System.out.println("학생 아니잖아요! 돌아가세요.");
}
```

<br>
<br>

---

## 2. Java 12+: 패턴 매칭 (스마트 검사)

Java 12부터는 `instanceof`와 동시에 변수 선언이 가능해졌습니다.
검사해서 `true`면 바로 그 이름으로 변수를 만들어줍니다. (귀찮은 변환 과정 생략!)

### 이전 방식 (~ Java 11)
```java
if (p instanceof Student) {
    Student s = (Student) p; // 1. 검사하고 2. 변환하고 (두 번 일함)
    s.study();
}
```

### 최신 방식 (Java 12+)
```java
if (p instanceof Student s) { // 1. 검사 통과하면 바로 's' 변수 생성!
    s.study();
}
```

<br>
<br>

## 3. 예제 코드: 원리와 동작

**Main.java**
```java
public class Main {
    public static void method(Person person) {
        System.out.println("검사를 시작합니다...");
        
        if (person instanceof Student student) {
            System.out.println("학생이군요! 공부하세요.");
            student.study();
        } else {
            System.out.println("학생이 아닙니다.");
        }
---

# 7.9 객체 타입 확인 (instanceof)

강제 타입 변환(Downcasting)은 실패할 위험이 있다고 배웠습니다.
그래서 변환을 시도하기 전에 **"이 변환이 진짜 안전한가?"** 확인하는 과정이 필요합니다.
이때 사용하는 것이 바로 `instanceof` 연산자입니다.

### 💡 핵심 비유: 신분증 검사
> **"학생 할인(강제 변환)을 받으려면, 학생증(instanceof)을 보여주세요!"**
> 만약 학생이 아닌데(False) 학생 할인을 해달라고 하면 쫓겨납니다(Error).

![Instanceof Check](./img/instanceof_check.svg)

---

## 1. 기본 사용법

`instanceof`는 좌변의 객체가 우변의 타입인지 확인하여 **참(true) 또는 거짓(false)**을 돌려줍니다.

```java
boolean result = 객체 instanceof 타입;
```

### 예제
```java
Person p = new Student(); // 학생이 사람인 척 하고 있음

if (p instanceof Student) {
    System.out.println("학생 맞네요! 합격!");
    Student s = (Student) p; // 안전하게 변환
    s.study();
} else {
    System.out.println("학생 아니잖아요! 돌아가세요.");
}
```

<br>
<br>

---

## 2. Java 12+: 패턴 매칭 (스마트 검사)

Java 12부터는 `instanceof`와 동시에 변수 선언이 가능해졌습니다.
검사해서 `true`면 바로 그 이름으로 변수를 만들어줍니다. (귀찮은 변환 과정 생략!)

### 이전 방식 (~ Java 11)
```java
if (p instanceof Student) {
    Student s = (Student) p; // 1. 검사하고 2. 변환하고 (두 번 일함)
    s.study();
}
```

### 최신 방식 (Java 12+)
```java
if (p instanceof Student s) { // 1. 검사 통과하면 바로 's' 변수 생성!
    s.study();
}
```

<br>
<br>

## 3. 예제 코드: 원리와 동작

**Main.java**
```java
public class Main {
    public static void method(Person person) {
        System.out.println("검사를 시작합니다...");
        
        if (person instanceof Student student) {
            System.out.println("학생이군요! 공부하세요.");
            student.study();
        } else {
            System.out.println("학생이 아닙니다.");
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("홍길동");
        Person p2 = new Student("김철수");

        method(p1); // "학생이 아닙니다."
        method(p2); // "학생이군요! 공부하세요."
    }
}
```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어갈까요?

*   **`Instance of`**: 인스턴스 오브. (앞에 있는 객체(Instance)가 뒤에 적힌 클래스로부터 만들어진 실체가 맞는지(of) 묻는 안전 확인 연산자)
*   **`Pattern Matching`**: 패턴 매칭. (Java 12부터 도입되어, `instanceof` 검사를 함과 동시에 곧바로 변수까지 깔끔하게 만들어주는 스마트한 마법 기능)
