---
layout: oop
title: "6.4 객체 생성과 클래스 변수"
nav_order: 4
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.4 객체 생성과 클래스 변수

## `new` 연산자 (공장에 주문 넣기)

설계도(클래스)가 준비되었으니, 이제 실제로 물건(객체)을 만들어 달라고 공장에 주문을 넣어야 합니다.
이때 사용하는 명령어가 바로 **`new`** 입니다.

> **new**: "새로운 거 하나 만들어 주세요!"

```java
new 클래스();
```

![New Operator Magic](./img/new_operator_magic.png)

`new` 다음에 오는 `클래스()`는 생성자라고 부르는데, "이 설계도로 초기 설정까지 해서 만들어라"라는 뜻입니다.

## 객체의 주소 (Address)

`new` 연산자가 객체를 뚝딱 만들면, 컴퓨터 메모리 어딘가에 이 객체가 저장됩니다.
그리고 `new` 연산자는 **"객체가 메모리 몇 번지에 저장되었는지" (주소)**를 알려줍니다. (반환합니다)

우리는 이 주소를 변수에 담아두고, 필요할 때마다 변수를 통해 객체를 찾아가서 사용합니다.

```java
// 클래스 변수 = new 클래스();
Car myCar = new Car();
```

*   `new Car()`: 자동차 한 대를 힙 메모리에 만듭니다.
*   `Car myCar`: 자동차의 **위치(주소)**를 저장할 수 있는 변수(리모컨)를 만듭니다.
*   `=`: 만들어진 자동차의 주소를 `myCar` 변수에 저장합니다.

이제 `myCar` 변수를 통해(참조하여) 언제든지 그 자동차를 조종할 수 있습니다.

![Object Reference Return](./img/object_reference_return.png)

## 연습하기

`Student` (학생) 클래스를 만들고, 학생 두 명(`s1`, `s2`)을 입학시켜 봅시다.

**Student.java** (설계도)
```java
package ch06.sec04;

public class Student {
}
```

**StudentExample.java** (실행 클래스)
```java
package ch06.sec04;

public class StudentExample {
	public static void main(String[] args) {
		// 첫 번째 학생 생성 (s1 변수가 가리킴)
		Student s1 = new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		
		// 두 번째 학생 생성 (s2 변수가 가리킴)
		Student s2 = new Student();
		System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
	}
}
```

`s1`과 `s2`는 서로 다른 학생 객체를 가리키고 있습니다. 설계도는 같지만, 만들어진 실체는 별개입니다.

![Student Reference Memory](./img/student_reference_memory.png)

## 클래스의 두 가지 용도

클래스는 크게 두 가지 용도로 쓰입니다.

1.  **라이브러리(Library) 클래스**: 부품 역할. 혼자서는 실행되지 않고 다른 클래스에서 가져다 씁니다. (대부분의 클래스) - 예: `Student`, `Car`
2.  **실행(Execution) 클래스**: `main()` 메소드를 가지고 있어서 프로그램을 시작시키는 역할. - 예: `StudentExample`, `CarExample`

프로그램은 보통 **하나의 실행 클래스**가 **여러 개의 라이브러리 클래스(부품)**들을 조립하고 사용하여 돌아갑니다.

![Library vs Execution Class](./img/library_vs_execution.png)
