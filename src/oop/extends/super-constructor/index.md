---
layout: oop
title: "7.3 부모 생성자 호출 (super)"
nav_order: 3
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
description: "7.3 부모 생성자 호출 (super) 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "7.3 부모 생성자 호출 (super), 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 7.3 부모 생성자 호출 (super)

자바에서 자식 객체를 생성하면, **기묘하게도 부모 객체가 먼저 생성됩니다.**
내가 `new Child()`를 했는데, 왜 `Parent`가 먼저 만들어질까요?

### 💡 핵심 비유: 2층 집 짓기
> **"1층(부모)을 짓지 않고 2층(자식)을 짓는 건 불가능하다."**
> 자식 객체는 부모 객체라는 **기반(Foundation)** 위에 만들어집니다.

![Super Constructor Flow](./img/super_constructor_flow.svg)

---

## 1. super() - 부모를 부르는 주문

모든 생성자의 첫 줄에는 `super()`라는 코드가 숨어 있습니다.
이것은 **"부모님 먼저 생성되세요!"**라고 호출하는 명령어입니다.

```java
public class Child extends Parent {
    public Child() {
        // 개발자가 안 적으면 컴파일러가 몰래 적어줌!
        super(); 
        System.out.println("자식 생성 완료");
    }
}
```

**[실행 순서]**
1.  `new Child()` 호출
2.  `Child` 생성자 진입 -> **`super()` 만남**
3.  `Parent` 생성자로 이동 -> 부모 생성 완료
4.  다시 `Child`로 돌아옴 -> 자식 생성 완료

<br>
<br>

---

## 2. 부모에게 매개변수가 필요하다면?

만약 부모 클래스에 **기본 생성자(매개변수 없는 거)**가 없고, **매개변수가 있는 생성자**만 있다면?
컴파일러는 `super()`를 자동으로 못 넣어줍니다. (어떤 값을 넣어야 할지 모르니까요!)

이때는 **개발자가 직접 `super(값)`을 넣어줘야 합니다.**

### 예제: 사람(이름 필수) -> 학생

**Person.java (부모)**
```java
public class Person {
    String name;
    
    // 이름 없이는 사람을 만들 수 없다!
    public Person(String name) {
        this.name = name;
    }
}
```

**Student.java (자식)**
```java
public class Student extends Person {
    public Student(String name) {
        // super(); // ❌ 에러! (부모는 이름 없이 생성 불가)
        
        super(name); // ✅ OK! (받은 이름을 부모에게 전달)
    }
}
```

<br>
<br>

## 3. 예제 코드: 원리와 동작

**Main.java**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 학생 객체 생성 시작 ===");
        Student s = new Student("홍길동");
        System.out.println("=== 학생 객체 생성 끝 ===");
---

# 7.3 부모 생성자 호출 (super)

자바에서 자식 객체를 생성하면, **기묘하게도 부모 객체가 먼저 생성됩니다.**
내가 `new Child()`를 했는데, 왜 `Parent`가 먼저 만들어질까요?

### 💡 핵심 비유: 2층 집 짓기
> **"1층(부모)을 짓지 않고 2층(자식)을 짓는 건 불가능하다."**
> 자식 객체는 부모 객체라는 **기반(Foundation)** 위에 만들어집니다.

![Super Constructor Flow](./img/super_constructor_flow.svg)

---

## 1. super() - 부모를 부르는 주문

모든 생성자의 첫 줄에는 `super()`라는 코드가 숨어 있습니다.
이것은 **"부모님 먼저 생성되세요!"**라고 호출하는 명령어입니다.

```java
public class Child extends Parent {
    public Child() {
        // 개발자가 안 적으면 컴파일러가 몰래 적어줌!
        super(); 
        System.out.println("자식 생성 완료");
    }
}
```

**[실행 순서]**
1.  `new Child()` 호출
2.  `Child` 생성자 진입 -> **`super()` 만남**
3.  `Parent` 생성자로 이동 -> 부모 생성 완료
4.  다시 `Child`로 돌아옴 -> 자식 생성 완료

<br>
<br>

---

## 2. 부모에게 매개변수가 필요하다면?

만약 부모 클래스에 **기본 생성자(매개변수 없는 거)**가 없고, **매개변수가 있는 생성자**만 있다면?
컴파일러는 `super()`를 자동으로 못 넣어줍니다. (어떤 값을 넣어야 할지 모르니까요!)

이때는 **개발자가 직접 `super(값)`을 넣어줘야 합니다.**

### 예제: 사람(이름 필수) -> 학생

**Person.java (부모)**
```java
public class Person {
    String name;
    
    // 이름 없이는 사람을 만들 수 없다!
    public Person(String name) {
        this.name = name;
    }
}
```

**Student.java (자식)**
```java
public class Student extends Person {
    public Student(String name) {
        // super(); // ❌ 에러! (부모는 이름 없이 생성 불가)
        
        super(name); // ✅ OK! (받은 이름을 부모에게 전달)
    }
}
```

<br>
<br>

## 3. 예제 코드: 원리와 동작

**Main.java**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 학생 객체 생성 시작 ===");
        Student s = new Student("홍길동");
        System.out.println("=== 학생 객체 생성 끝 ===");
    }
}
```

**실행 결과**
```text
=== 학생 객체 생성 시작 ===
Person(홍길동) 생성자 실행 (1층 공사 완료)
Student 생성자 실행 (2층 공사 완료)
=== 학생 객체 생성 끝 ===
```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Super()`**: 슈퍼, 부모 생성자 호출. ("내(자식)가 먼저 만들어지기 전에, 1층 공사인 부모님부터 먼저 확실하게 만들어주세요!"라고 부모의 생성자를 명시적으로 호출하는 마법의 주문)
