---
layout: part02
title: "Chapter 06. 클래스"
nav_order: 6
parent: "객체지향 자바 프로그래밍"
---

# Chapter 06. 클래스

## 6.1 객체지향 프로그래밍

현실 세계에서 어떤 제품을 만들 때는 부품을 먼저 만들고, 이 부품들을 하나씩 조립해서 완성품을 만든다. 소프트웨어를 개발할 때에도 부품에 해당하는 객체들을 먼저 만들고, 이 객체들을 하나씩 조립해서 완성된 프로그램을 만드는 기법을 객체지향 프로그래밍(Object Oriented Programming, OOP)이라고 한다.

### 객체란?

객체(Object)란 물리적으로 존재하거나 개념적인 것 중에서 다른 것과 식별 가능한 것을 말한다. 예를 들어 물리적으로 존재하는 자동차, 자전거, 책, 사람은 물론, 개념적인 학과나 강의, 주문 등도 모두 객체가 될 수 있다.

객체는 속성과 동작으로 구성된다. 사람은 이름, 나이 등의 속성과 웃다, 걷다 등의 동작이 있고, 자동차는 색상, 모델명 등의 속성과 달린다, 멈춘다 등의 동작이 있다. 자바는 이러한 속성과 동작을 각각 필드(field)와 메소드(method)라고 부른다.

```java
현실 세계
사람
[속성] 이름, 나이
[동작] 웃다, 먹다

자동차
[속성] 색깔, 속도
[동작] 달린다, 멈춘다
```

### 객체 모델링

현실 세계의 객체를 소프트웨어 객체로 설계하는 것을 객체 모델링(Object Modeling)이라고 한다. 객체 모델링은 현실 세계 객체의 대표 속성과 동작을 추려내어 소프트웨어 객체의 필드와 메소드로 정의하는 과정이라고 볼 수 있다.

### 객체의 상호작용

현실 세계에서 일어나는 모든 현상은 객체와 객체 간의 상호작용으로 이루어져 있다. 예를 들어 사람은 전자계산기의 기능을 이용하고, 전자계산기는 계산 결과를 사람에게 리턴하는 상호작용을 한다.

객체지향 프로그램에서도 객체들은 다른 객체와 서로 상호작용하면서 동작한다. 객체들 사이의 상호작용 수단은 메소드이다. 객체가 다른 객체의 기능을 이용할 때 이 메소드를 호출한다.

메소드 호출은 다음과 같은 형태를 가지고 있다.

```java
메소드(매개값1, 매개값2, ...);
```

메소드 호출을 통해 객체들은 데이터를 서로 주고받는다. 메소드 이름과 함께 전달하고자 하는 데이터를 괄호() 안에 기술하는데, 이러한 데이터를 매개값이라고 한다. 매개값은 메소드가 실행할 때 필요한 값이다. 리턴값은 메소드의 실행의 결과이며, 호출한 곳으로 돌려주는 값이다.

```java
int result = add(10, 20);
// 리턴한 값을 int 변수에 저장
```

### 객체 간의 관계

객체는 단독으로 존재할 수 있지만 대부분 다른 객체와 관계를 맺고 있다. 관계의 종류에는 집합 관계, 사용 관계, 상속 관계가 있다.

#### 집합 관계
완성품과 부품의 관계를 말한다. 예를 들어 자동차는 엔진, 타이어, 핸들 등으로 구성되므로 자동차와 부품들은 집합 관계라고 볼 수 있다.

#### 사용 관계
다른 객체의 필드를 읽고 변경하거나 메소드를 호출하는 관계를 말한다. 예를 들어 사람이 자동차에게 달린다, 멈춘다 등의 메소드를 호출하면 사람과 자동차는 사용 관계라고 볼 수 있다.

#### 상속 관계
부모와 자식 관계를 말한다. 자동차가 기계의 특징(필드, 메소드)을 물려받는다면 기계(부모)와 자동차(자식)는 상속 관계에 있다고 볼 수 있다.

### 객체지향 프로그래밍의 특징

객체지향 프로그램의 특징은 캡슐화, 상속, 다형성이다. 이 특징들은 자바 언어를 학습하면서 자연스럽게 알게 되는데, 여기서는 개념만 간단히 살펴보기로 하자.

#### 캡슐화

캡슐화(Encapsulation)란 객체의 데이터(필드), 동작(메소드)을 하나로 묶고 실제 구현 내용을 외부에 감추는 것을 말한다. 외부 객체는 객체 내부의 구조를 알지 못하며 객체가 노출해서 제공하는 필드와 메소드만 이용할 수 있다.

필드와 메소드를 캡슐화하여 보호하는 이유는 외부의 잘못된 사용으로 인해 객체가 손상되지 않도록 하는 데 있다. 자바 언어는 캡슐화된 멤버를 노출시킬 것인지 숨길 것인지를 결정하기 위해 접근 제한자(Access Modifier)를 사용한다.

#### 상속

객체지향 프로그래밍에서는 부모 역할의 상위 객체와 자식 역할의 하위 객체가 있다. 부모 객체는 자기가 가지고 있는 필드와 메소드를 자식 객체에게 물려주어 자식 객체가 사용할 수 있도록 한다. 이것이 상속(Inheritance)이다. 상속을 하는 이유는 다음과 같다.

- **코드의 재사용성을 높여 준다.**
  잘 개발된 부모 객체의 필드와 메소드를 자식이 그대로 사용할 수 있어 자식 객체에서 중복 코딩을 하지 않아도 된다.
- **유지 보수 시간을 최소화시켜 준다.**
  부모 객체의 필드와 메소드를 수정하면 모든 자식 객체들은 수정된 필드와 메소드를 사용할 수 있다.

#### 다형성

다형성(Polymorphism)이란 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질을 말한다. 자동차의 부품을 교환하면 성능이 다르게 나오듯이 프로그램을 구성하는 객체(부품)를 바꾸면 프로그램의 실행 성능이 다르게 나올 수 있다.

다형성을 구현하기 위해서는 자동 타입 변환과 재정의 기술이 필요하다. 이 기술들은 상속과 인터페이스 구현을 통해 얻어진다. 자세한 설명은 7장 상속과 8장 인터페이스에서 설명하겠다.

## 6.2 객체와 클래스

객체를 생성할 때에는 설계도가 필요하다. 현실 세계에서 자동차를 생성하려면 자동차의 설계도가 필요하듯이, 객체지향 프로그래밍에서도 객체를 생성하려면 설계도에 해당하는 클래스(class)가 필요하다.

클래스로부터 생성된 객체를 해당 클래스의 인스턴스(instance)라고 부른다. 그리고 클래스로부터 객체를 만드는 과정을 인스턴스화라고 한다. 동일한 클래스로부터 여러 개의 인스턴스를 만들 수 있는데, 이것은 동일한 설계도로 여러 대의 자동차를 만드는 것과 동일하다.

우리는 지금까지 많은 클래스를 선언해보았다. 클래스는 객체를 생성하기 위한 설계도이지만 객체를 만들지는 않았고, main() 메소드만 작성해서 실행할 목적으로 클래스를 이용했다. 6.3절부터는 main() 메소드가 없는 클래스를 선언하고 객체를 생성하는 방법을 배워 보도록 하자.

## 6.3 클래스 선언

클래스 선언은 객체 생성을 위한 설계도를 작성하는 작업이다. 어떻게 객체를 생성(생성자)하고, 객체가 가져야 할 데이터(필드)가 무엇이고, 객체의 동작(메소드)은 무엇인지를 정의하는 내용이 포함된다. 클래스 선언은 소스 파일명과 동일하게 다음과 같이 작성한다.

```java
[클래스명.java]
// 클래스 선언
public class 클래스명 {
}
```

public class는 공개 클래스를 선언한다는 뜻이다. 클래스명은 첫 문자를 대문자로 하고 캐멀 스타일로 작성한다. 숫자를 포함해도 되지만 첫 문자는 숫자가 될 수 없고, 특수문자 중 $, _를 포함할 수 있다.

이클립스의 Package Explorer 뷰에서 클래스가 포함될 패키지를 선택하고 마우스 오른쪽 버튼으로 클릭한 후 [New] - [Class]를 선택해서 클래스를 생성하면 패키지 선언과 클래스 선언이 자동 포함된다.

예를 들어 SportsCar 클래스를 생성하면 다음과 같은 소스 파일이 생성된다.

**SportsCar.java**
```java
package ch06.sec03;

public class SportsCar {
}
```

패키지 선언은 6.12절에서 따로 살펴보기로 하고, 여기서는 클래스 선언에 우선 집중하자. 하나의 소스 파일은 다음과 같이 복수 개의 클래스 선언을 포함할 수 있다.

**SportsCar.java**
```java
package ch06.sec03;

public class SportsCar {
}

class Tire {
}
```

복수 개의 클래스 선언이 포함된 소스 파일을 컴파일하면 바이트코드 파일(.class)은 클래스 선언 수만큼 생긴다. 위 소스 파일을 저장(컴파일)하고 bin/ch06/sec03 디렉토리를 열어 보면 SportsCar.class와 Tire.class가 생성된 것을 볼 수 있다.

하나의 소스 파일에 복수 개의 클래스를 선언할 때 주의할 점은 소스 파일명과 동일한 클래스만 공개 클래스(public class)로 선언할 수 있다는 것이다.

> **여기서 잠깐: 공개 클래스란?**
> 공개 클래스(public class)는 어느 위치에 있든지 패키지와 상관없이 사용할 수 있는 클래스를 말한다. public은 접근 제한자 중 하나로, 접근 제한자에 대해서는 6.13절에서 설명한다.

Tire 클래스도 공개 클래스(public class)로 선언하고 싶다면 Tire.java 소스 파일을 별도로 생성해야 한다. 그렇기 때문에 특별한 이유가 없다면 소스 파일 하나당 클래스 하나를 선언하는 것이 좋다.

## 6.4 객체 생성과 클래스 변수

클래스로부터 객체를 생성하려면 객체 생성 연산자인 new가 필요하다.

```java
new 클래스();
```

new 연산자 뒤에는 생성자 호출 코드가 오는데, 클래스() 형태를 가진다. new 연산자는 객체를 생성시킨 후 객체의 주소를 리턴하기 때문에 클래스 변수에 다음과 같이 대입할 수 있다.

```java
클래스 변수 = new 클래스();
```

Student 클래스를 선언하고 StudentExample 클래스의 main() 메소드에서 Student 객체를 생성해 보자.

**Student.java**
```java
package ch06.sec04;

public class Student {
}
```

**StudentExample.java**
```java
package ch06.sec04;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		
		Student s2 = new Student();
		System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
	}
}
```

**실행 결과**
```
s1 변수가 Student 객체를 참조합니다.
s2 변수가 또 다른 Student 객체를 참조합니다.
```

> **클래스의 두 가지 용도**
> 클래스는 다음 두 가지 용도가 있다.
> * 라이브러리(library) 클래스: 실행할 수 없으며 다른 클래스에서 이용하는 클래스
> * 실행 클래스: main() 메소드를 가지고 있는 실행 가능한 클래스
>
> 앞의 예제에서 Student는 라이브러리 클래스이고 StudentExample은 실행 클래스라고 볼 수 있다. 일반적으로 자바 프로그램은 하나의 실행 클래스와 여러 개의 라이브러리 클래스들로 구성된다. 실행 클래스는 실행하면서 라이브러리 클래스를 내부에서 이용한다.

## 6.5 클래스의 구성 멤버

클래스 선언에는 객체 초기화 역할을 담당하는 생성자와 객체에 포함될 필드와 메소드를 선언하는 코드가 포함된다. 그래서 생성자, 필드, 메소드를 클래스 구성 멤버라고 한다. 다음은 각 클래스 구성 멤버의 선언 형태이다.

* **필드**: 객체의 데이터가 저장되는 곳
* **생성자**: 객체 생성 시 초기화 역할 담당
* **메소드**: 객체의 동작으로 호출 시 실행하는 블록

```java
public class ClassName {
	// 필드 선언
	int fieldName;

	// 생성자 선언
	ClassName() { ... }

	// 메소드 선언
	int methodName() { ... }
}
```

**필드**
필드(Field)는 객체의 데이터를 저장하는 역할을 한다. 선언 형태는 변수 선언과 비슷하지만 쓰임새는 다르다.

**생성자**
생성자(Constructor)는 new 연산자로 객체를 생성할 때 객체의 초기화 역할을 담당한다. 선언 형태는 메소드와 비슷하지만, 리턴 타입이 없고 이름은 클래스 이름과 동일하다.

**메소드**
메소드(Method)는 객체가 수행할 동작이다. 다른 프로그램 언어에서는 함수라고 하기도 하는데, 객체 내부의 함수는 메소드라고 부른다. 메소드는 객체와 객체 간의 상호작용을 위해 호출된다.

## 6.6 필드 선언과 사용

필드(Field)는 객체의 데이터를 저장하는 역할을 한다. 객체의 데이터에는 고유 데이터, 현재 상태 데이터, 부품 데이터가 있다.

자동차 객체를 예로 들면 제작회사, 모델, 색깔, 최고 속도는 고유 데이터에 해당하고, 현재 속도, 엔진 회전 수는 상태 데이터에 해당한다. 그리고 차체, 엔진, 타이어는 부품에 해당한다.

```java
public class Car {
	// 고유 데이터를 저장하는 필드 선언
	String company;
	String model;
	String color;
	int maxSpeed;

	// 상태 데이터를 저장하는 필드 선언
	int speed;
	int rpm;

	// 부품 데이터를 저장하는 필드 선언
	Body body;
	Engine engine;
	Tire tire;
}
```

필드를 선언하는 방법은 변수를 선언하는 방법과 동일하다. 단, 반드시 클래스 블록에서 선언되어야만 필드 선언이 된다.

```java
타입 필드명 [ = 초기값 ];
```

> **필드와 (로컬)변수의 차이점**
> (로컬)변수는 생성자와 메소드 블록에서 선언되며 생성자와 메소드 호출 시에만 생성되고 사용된다. 필드는 클래스 블록에서 선언되며, 객체 내부에서 존재하고 객체 내·외부에서 사용 가능하다.
>
> | 구분 | 필드 | (로컬)변수 |
> |---|---|---|
> | 선언 위치 | 클래스 선언 블록 | 생성자, 메소드 선언 블록 |
> | 존재 위치 | 객체 내부에 존재 | 생성자, 메소드 호출 시에만 존재 |
> | 사용 위치 | 객체 내·외부 어디든 사용 | 생성자, 메소드 블록 내부에서만 사용 |

타입은 필드에 저장할 데이터의 종류를 결정한다. 기본 타입(byte, short, int, long, float, double, boolean)과 참조 타입(배열, 클래스, 인터페이스)이 모두 가능하다. 필드명은 첫 문자를 소문자로 하되, 캐멀 스타일로 작성하는 것이 관례이다. 다음은 Car 클래스의 필드를 선언한 예를 보여 준다.

```java
public class Car {
	String model = "그랜저";    // 고유 데이터 필드
	int speed = 300;            // 상태 데이터 필드
	boolean start = true;       // 상태 데이터 필드
	Tire tire = new Tire();     // 부품 객체 필드
}
```

초기값을 제공하지 않을 경우 필드는 객체 생성 시 자동으로 기본값으로 초기화된다. 다음 표는 필드 타입별 기본값을 보여 준다.

| 분류      | 데이터 타입                           | 초기값                       |
| --------- | ------------------------------------- | ---------------------------- |
| 기본 타입 | byte, char, short, int, long          | 0 (char는 '\u0000', 빈 공백) |
| 실수 타입 | float, double                         | 0.0, 0.0F                    |
| 논리 타입 | boolean                               | false                        |
| 참조 타입 | 배열, 클래스(String 포함), 인터페이스 | null                         |

정수 타입 필드는 0, 실수 타입 필드는 0.0, 그리고 boolean 필드는 false로 초기화되는 것을 볼 수 있다. 참조 타입은 객체를 참조하고 있지 않은 상태인 null로 초기화된다.

**Car.java**
```java
package ch06.sec06.exam01;

public class Car {
	// 필드 선언
	String model;
	boolean start;
	int speed;
}
```

**CarExample.java**
```java
package ch06.sec06.exam01;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();
		
		// Car 객체의 필드값 읽기
		System.out.println("모델명: " + myCar.model);
		System.out.println("시동여부: " + myCar.start);
		System.out.println("현재속도: " + myCar.speed);
	}
}
```

**실행 결과**
```
모델명: null
시동여부: false
현재속도: 0
```

### 필드 사용

필드를 사용한다는 것은 필드값을 읽고 변경하는 것을 말한다. 클래스에서 필드를 선언했다고 해서 바로 사용할 수 있는 것은 아니다. 필드는 객체의 데이터이므로 객체가 존재하지 않으면 필드도 존재하지 않는다.

클래스로부터 객체가 생성된 후에 필드를 사용할 수 있다. 필드는 객체 내부의 생성자와 메소드 내부에서 사용할 수 있고, 객체 외부에서도 접근해서 사용할 수 있다.

객체 내부에서는 단순히 필드명으로 읽고 변경할 수 있지만 외부 객체에서는 참조 변수와 도트(.) 연산자를 이용해서 필드를 읽고 변경해야 한다. 도트(.)는 객체 접근 연산자로, 객체가 가지고 있는 필드나 메소드에 접근하고자 할 때 참조 변수 뒤에 붙인다.

**Car.java**
```java
package ch06.sec06.exam02;

public class Car {
	// 필드 선언
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
}
```

**CarExample.java**
```java
package ch06.sec06.exam02;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();
		
		// Car 객체의 필드값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
		// Car 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
	}
}
```

**실행 결과**
```
제작회사: 현대자동차
모델명: 그랜저
색깔: 검정
최고속도: 350
현재속도: 0
수정된 속도: 60
```

## 6.7 생성자 선언과 호출

new 연산자는 객체를 생성한 후 연이어 생성자(Constructor)를 호출해서 객체를 초기화하는 역할을 한다. 객체 초기화란 필드 초기화를 하거나 메소드를 호출해서 객체를 사용할 준비를 하는 것을 말한다.

```java
클래스 변수 = new 클래스();
                ↑
            생성자 호출
```

생성자가 성공적으로 실행이 끝나면 new 연산자는 객체의 주소를 리턴한다. 리턴된 주소는 클래스 변수에 대입되어 객체의 필드나 메소드에 접근할 때 이용된다.

### 기본 생성자

모든 클래스는 생성자가 존재하며, 하나 이상을 가질 수 있다. 클래스에 생성자 선언이 없으면 컴파일러는 다음과 같은 기본 생성자(Default Constructor)를 바이트코드 파일에 자동으로 추가시킨다.

```java
[public] 클래스() { }
```

클래스가 public class로 선언되면 기본 생성자도 public이 붙지만, 클래스가 public 없이 class로만 선언되면 기본 생성자에도 public이 붙지 않는다.

그렇기 때문에 다음과 같이 new 연산자 뒤에 기본 생성자를 호출할 수 있다.

```java
Car myCar = new Car(); // 기본 생성자 호출
```

그러나 개발자가 명시적으로 선언한 생성자가 있다면 컴파일러는 기본 생성자를 추가하지 않는다. 개발자가 생성자를 선언하는 이유는 객체를 다양하게 초기화하기 위해서이다.

### 생성자 선언

객체를 다양하게 초기화하기 위해 개발자는 생성자를 다음과 같이 직접 선언할 수 있다.

```java
클래스(매개변수, ...) {
    // 객체의 초기화 코드
}
```

생성자는 메소드와 비슷한 모양을 가지고 있으나, 리턴 타입이 없고 클래스 이름과 동일하다. 매개변수는 new 연산자로 생성자를 호출할 때 매개값을 생성자 블록 내부로 전달하는 역할을 한다.

예를 들어 다음과 같이 Car 생성자를 호출할 때 3개의 매개값을 블록 내부로 전달한다고 가정해 보자.

```java
Car myCar = new Car("그랜저", "검정", 300);
```

3개의 매개값을 순서대로 매개변수로 대입받기 위해서는 다음과 같이 생성자가 선언되어야 한다.

```java
public class Car {
    // 생성자 선언
    Car(String model, String color, int maxSpeed) { ... }
}
```

매개변수의 타입은 매개값의 종류에 맞게 작성하면 된다.

**Car.java**
```java
package ch06.sec07.exam01;

public class Car {
    // 생성자 선언
    Car(String model, String color, int maxSpeed) {
    }
}
```

**CarExample.java**
```java
package ch06.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("그랜저", "검정", 250);
        // Car myCar = new Car(); // 기본 생성자 호출 못함
    }
}
```

### 필드 초기화

객체마다 동일한 값을 갖고 있다면 필드 선언 시 초기값을 대입하는 것이 좋고, 객체마다 다른 값을 가져야 한다면 생성자에서 필드를 초기화하는 것이 좋다.

예를 들어 Korean 클래스를 선언한다고 가정해 보자. 한국인이므로 nation(국가)은 대한민국으로 동일한 값을 가지지만, name(이름)과 ssn(주민등록번호)은 한국인마다 다르므로 생성자에서 초기화하는 것이 좋다.

```java
public class Korean {
    // 필드 선언
    String nation = "대한민국";
    String name;
    String ssn;
    
    // 생성자 선언
    public Korean(String n, String s) {
        name = n;
        ssn = s;
    }
}
```

생성자의 매개값은 new 연산자로 생성자를 호출할 때 주어진다. k1과 k2가 참조하는 객체는 주어진 매개값으로, name과 ssn 필드가 각각 초기화된다.

```java
Korean k1 = new Korean("박자바", "011225-1234567");
Korean k2 = new Korean("김자바", "930525-0654321");
```

**Korean.java**
```java
package ch06.sec07.exam02;

public class Korean {
    // 필드 선언
    String nation = "대한민국";
    String name;
    String ssn;
    
    // 생성자 선언
    public Korean(String n, String s) {
        name = n;
        ssn = s;
    }
}
```

**KoreanExample.java**
```java
package ch06.sec07.exam02;

public class KoreanExample {
    public static void main(String[] args) {
        // Korean 객체 생성
        Korean k1 = new Korean("박자바", "011225-1234567");
        // Korean 객체 데이터 읽기
        System.out.println("k1.nation : " + k1.nation);
        System.out.println("k1.name : " + k1.name);
        System.out.println("k1.ssn : " + k1.ssn);
        System.out.println();
        
        // 또 다른 Korean 객체 생성
        Korean k2 = new Korean("김자바", "930525-0654321");
        // 또 다른 Korean 객체 데이터 읽기
        System.out.println("k2.nation : " + k2.nation);
        System.out.println("k2.name : " + k2.name);
        System.out.println("k2.ssn : " + k2.ssn);
    }
}
```

**실행 결과**
```
k1.nation : 대한민국
k1.name : 박자바
k1.ssn : 011225-1234567

k2.nation : 대한민국
k2.name : 김자바
k2.ssn : 930525-0654321
```

위 예제의 Korean 생성자를 보면 매개변수 이름으로 각각 n과 s를 사용했다. 매개변수의 이름이 너무 짧으면 코드 가독성이 좋지 않기 때문에 가능하면 초기화시킬 필드명과 동일한 이름을 사용하는 것이 좋다.

```java
public Korean(String name, String ssn) {
    this.name = name;
    this.ssn = ssn;
}
```

위와 같은 경우에는 매개변수명이 필드명과 동일하기 때문에 필드임을 구분하기 위해 this 키워드를 필드명 앞에 붙여 주었다. this는 현재 객체를 말하며, this.name은 현재 객체의 데이터(필드)로서의 name을 뜻한다.

**Korean.java**
```java
package ch06.sec07.exam03;

public class Korean {
    // 필드 선언
    String nation = "대한민국";
    String name;
    String ssn;
    
    // 생성자 선언
    public Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}
```

> **이클립스에서 필드와 매개변수의 색깔**
> 이클립스는 필드의 색깔을 파란색, 매개변수의 색깔을 갈색으로 보여주기 때문에 코드를 보면 필드와 매개변수를 쉽게 구별할 수 있다.

### 생성자 오버로딩

매개값으로 객체의 필드를 다양하게 초기화하려면 생성자 오버로딩(Overloading)이 필요하다. 생성자 오버로딩이란 매개변수를 달리하는 생성자를 여러 개 선언하는 것을 말한다. 다음은 Car 클래스에서 생성자를 오버로딩한 예이다.

```java
public class Car {
    Car() { ... }
    Car(String model) { ... }
    Car(String model, String color) { ... }
    Car(String model, String color, int maxSpeed) { ... }
}
```

매개변수의 타입과 개수 그리고 선언된 순서가 똑같을 경우 매개변수 이름만 바꾸는 것은 생성자 오버로딩이 아니다. 바로 다음과 같은 경우이다.

```java
Car(String model, String color) { ... }
Car(String color, String model) { ... } // 오버로딩이 아님. 컴파일 에러 발생
```

생성자가 오버로딩되어 있을 경우, new 연산자로 생성자를 호출할 때 제공되는 매개값의 타입과 수에 따라 실행될 생성자가 결정된다.

**Car.java**
```java
package ch06.sec07.exam04;

public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;
    
    // 생성자 선언
    Car() {} // 1 생성자
    
    Car(String model) { // 2 생성자
        this.model = model;
    }
    
    Car(String model, String color) { // 3 생성자
        this.model = model;
        this.color = color;
    }
    
    Car(String model, String color, int maxSpeed) { // 4 생성자
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
```

**CarExample.java**
```java
package ch06.sec07.exam04;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car(); // 1 생성자 호출
        System.out.println("car1.company : " + car1.company);
        System.out.println();
        
        Car car2 = new Car("자가용"); // 2 생성자 호출
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println();
        
        Car car3 = new Car("자가용", "빨강"); // 3 생성자 호출
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println();
        
        Car car4 = new Car("택시", "검정", 200); // 4 생성자 호출
        System.out.println("car4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed);
    }
}
```

**실행 결과**
```
car1.company : 현대자동차

car2.company : 현대자동차
car2.model : 자가용

car3.company : 현대자동차
car3.model : 자가용
car3.color : 빨강

car4.company : 현대자동차
car4.model : 택시
car4.color : 검정
car4.maxSpeed : 200
```

### 다른 생성자 호출

생성자 오버로딩이 많아질 경우 생성자 간의 중복된 코드가 발생할 수 있다. 매개변수의 수만 달리하고 필드 초기화 내용이 비슷한 생성자에서 이러한 중복 코드를 많이 볼 수 있다.

```java
Car(String model) {
    this.model = model;
    this.color = "은색";
    this.maxSpeed = 250;
}

Car(String model, String color) {
    this.model = model;
    this.color = color;
    this.maxSpeed = 250;
}

Car(String model, String color, int maxSpeed) {
    this.model = model;
    this.color = color;
    this.maxSpeed = maxSpeed;
}
```

이 경우에는 공통 코드를 한 생성자에만 집중적으로 작성하고, 나머지 생성자는 this(...)를 사용하여 공통 코드를 가지고 있는 생성자를 호출하는 방법으로 개선할 수 있다.

```java
Car(String model) {
    this(model, "은색", 250);
}

Car(String model, String color) {
    this(model, color, 250);
}

Car(String model, String color, int maxSpeed) {
    this.model = model;
    this.color = color;
    this.maxSpeed = maxSpeed;
}
```

this(매개값, ...)는 생성자의 첫 줄에 작성되며 다른 생성자를 호출하는 역할을 한다. 호출하고 싶은 생성자의 매개변수에 맞게 매개값을 제공하면 된다. this() 다음에는 추가적인 실행문을 작성할 수 있는데, 호출되는 생성자의 실행이 끝나면 원래 생성자로 돌아와서 다음 실행문을 실행한다.

**Car.java**
```java
package ch06.sec07.exam05;

public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;
    
    Car(String model) {
        this(model, "은색", 250);
    }
    
    Car(String model, String color) {
        this(model, color, 250);
    }
    
    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
```

**CarExample.java**
```java
package ch06.sec07.exam05;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car("자가용"); // 1 생성자 호출
        System.out.println("car1.company : " + car1.company);
        System.out.println("car1.model : " + car1.model);
        System.out.println();
        
        Car car2 = new Car("자가용", "빨강"); // 2 생성자 호출
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println("car2.color : " + car2.color);
        System.out.println();
        
        Car car3 = new Car("택시", "검정", 200); // 3 생성자 호출
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println("car3.maxSpeed : " + car3.maxSpeed);
    }
}
```

**실행 결과**
```
car1.company : 현대자동차
car1.model : 자가용

car2.company : 현대자동차
car2.model : 자가용
car2.color : 빨강

car3.company : 현대자동차
car3.model : 택시
car3.color : 검정
car3.maxSpeed : 200
```

## 6.8 메소드 선언과 호출

메소드 선언은 객체의 동작을 실행 블록으로 정의하는 것을 말하고, 메소드 호출은 실행 블록을 실제로 실행하는 것을 말한다. 메소드는 객체 내부에서도 호출되지만 다른 객체에서도 호출될 수 있기 때문에 객체 간의 상호작용 방법을 정의하는 것이라고 볼 수 있다. 상호작용의 개념은 6.1절을 참고하길 바란다.

### 메소드 선언

다음은 메소드를 선언하는 방법을 보여 준다.

```java
리턴타입 메소드명 (매개변수, ...) {
    // 실행할 코드를 작성하는 곳
}
```

#### 리턴 타입

리턴 타입은 메소드가 실행한 후 호출한 곳으로 전달하는 결과값의 타입을 말한다. 리턴값이 없는 메소드는 void로 작성해야 한다.

```java
void powerOn() { ... } // 리턴값이 없는 메소드 선언
double divide(int x, int y) { ... } // double 타입 값을 리턴하는 메소드 선언
```

리턴 타입이 있는 메소드는 실행 블록 안에서 return 문으로 리턴값을 반드시 지정해야 한다.

#### 메소드명

메소드명은 첫 문자를 소문자로 시작하고, 캐멀 스타일로 작성한다. 다음은 잘 작성된 메소드명을 보여 준다.

```java
void run() { ... }
void setSpeed(int speed) { ... }
String getName() { ... }
```

#### 매개변수

매개변수는 메소드를 호출할 때 전달한 매개값을 받기 위해 사용된다. 다음 예에서 divide() 메소드는 연산할 두 수를 전달받아야 하므로 매개변수가 2개 필요하다. 전달할 매개값이 없다면 매개변수는 생략할 수 있다.

```java
double divide(int x, int y) { ... }
```

#### 실행 블록

메소드 호출 시 실행되는 부분이다.

다음 예제는 Calculator 클래스에서 powerOn(), plus(), divide(), powerOff() 메소드를 선언하는 방법을 보여 준다.

**Calculator.java**
```java
package ch06.sec08.exam01;

public class Calculator {
	// 리턴값이 없는 메소드 선언
	void powerOn() {
		System.out.println("전원을 니다.");
	}

	// 리턴값이 없는 메소드 선언
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	// 호출 시 두 정수 값을 전달받고,
	// 호출한 곳으로 결과값 int를 리턴하는 메소드 선언
	int plus(int x, int y) {
		int result = x + y;
		return result; // 리턴값 지정
	}

	// 호출 시 두 정수 값을 전달받고,
	// 호출한 곳으로 결과값 double을 리턴하는 메소드 선언
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result; // 리턴값 지정
	}
}
```

### 메소드 호출

메소드를 호출한다는 것은 메소드 블록을 실행하는 것을 말한다. 클래스에서 메소드를 선언했다고 해서 바로 호출할 수 있는 것은 아니다. 메소드는 객체의 동작이므로 객체가 존재하지 않으면 메소드를 호출할 수 없다.

클래스로부터 객체가 생성된 후에 메소드는 생성자와 다른 메소드 내부에서 호출될 수 있고, 객체 외부에서도 호출될 수 있다.

객체 내부에서는 단순히 메소드명으로 호출하면 되지만, 외부 객체에서는 참조 변수와 도트(.) 연산자를 이용해서 호출한다. 또한 메소드가 매개변수를 가지고 있을 때는 호출할 때 매개변수의 타입과 수에 맞게 매개값을 제공해야 한다.

메소드가 리턴값이 있을 경우에는 대입 연산자를 사용해서 다음과 같이 리턴값을 변수에 저장할 수 있다. 이때 변수 타입은 메소드의 리턴 타입과 동일하거나 자동 타입 변환될 수 있어야 한다.

```java
타입 변수 = 메소드();
```

**객체 내부**
```java
Calculator() {
    powerOff();
}

void method() {
    powerOn();
    int r1 = plus(3, 5);
    double r2 = divide(15, 3);
}
```

**외부 객체**
```java
void method() {
    Calculator calc = new Calculator();
    calc.powerOn();
    int r1 = calc.plus(10, 20);
    double r2 = calc.divide(10, 30);
}
```

다음 예제는 Calculator 클래스에서 선언된 powerOn(), plus(), divide(), powerOff() 메소드를 호출하는 방법을 보여 준다.

**CalculatorExample.java**
```java
package ch06.sec08.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		// Calculator 객체 생성
		Calculator myCalc = new Calculator();
		
		// 리턴값이 없는 powerOn() 메소드 호출
		myCalc.powerOn();
		
		// plus 메소드 호출 시 5와 6을 매개값으로 제공하고,
		// 덧셈 결과를 리턴받아 result1 변수에 대입
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1: " + result1);
		
		int x = 10;
		int y = 4;
		// divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고,
		// 나눗셈 결과를 리턴받아 result2 변수에 대입
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2);
		
		// 리턴값이 없는 powerOff() 메소드 호출
		myCalc.powerOff();
	}
}
```

**실행 결과**
```
전원을 니다.
result1: 11
result2: 2.5
전원을 끕니다.
```

### 가변길이 매개변수

메소드를 호출할 때에는 매개변수의 개수에 맞게 매개값을 제공해야 한다. 만약 메소드가 가변길이 매개변수를 가지고 있다면 매개변수의 개수와 상관없이 매개값을 줄 수 있다. 가변길이 매개변수는 다음과 같이 선언한다.

```java
int sum(int ... values) {
}
```

가변길이 매개변수는 메소드 호출 시 매개값을 쉼표로 구분해서 개수와 상관없이 제공할 수 있다.

```java
int result = sum(1, 2, 3);
int result = sum(1, 2, 3, 4, 5);
```

매개값들은 자동으로 배열 항목으로 변환되어 메소드에서 사용된다. 그렇기 때문에 메소드 호출 시 직접 배열을 매개값으로 제공해도 된다.

```java
int[] values = { 1, 2, 3 };
int result = sum(values);
int result = sum(new int[] { 1, 2, 3 });
```

**Computer.java**
```java
package ch06.sec08.exam02;

public class Computer {
	// 가변길이 매개변수를 갖는 메소드 선언
	int sum(int ... values) {
		// sum 변수 선언
		int sum = 0;
		
		// values는 배열 타입의 변수처럼 사용
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		
		// 합산 결과를 리턴
		return sum;
	}
}
```

**ComputerExample.java**
```java
package ch06.sec08.exam02;

public class ComputerExample {
	public static void main(String[] args) {
		// Computer 객체 생성
		Computer myCom = new Computer();
		
		// sum() 메소드 호출 시 매개값 1, 2, 3을 제공하고
		// 합산 결과를 리턴받아 result1 변수에 대입
		int result1 = myCom.sum(1, 2, 3);
		System.out.println("result1: " + result1);
		
		// sum() 메소드 호출 시 매개값 1, 2, 3, 4, 5를 제공하고
		// 합산 결과를 리턴받아 result2 변수에 대입
		int result2 = myCom.sum(1, 2, 3, 4, 5);
		System.out.println("result2: " + result2);
		
		// sum() 메소드 호출 시 배열을 제공하고
		// 합산 결과를 리턴받아 result3 변수에 대입
		int[] values = { 1, 2, 3, 4, 5 };
		int result3 = myCom.sum(values);
		System.out.println("result3: " + result3);
		
		// sum() 메소드 호출 시 배열을 제공하고
		// 합산 결과를 리턴받아 result4 변수에 대입
		int result4 = myCom.sum(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("result4: " + result4);
	}
}
```

**실행 결과**
```
result1: 6
result2: 15
result3: 15
result4: 15
```

### return 문

return 문은 메소드의 실행을 강제 종료하고 호출한 곳으로 돌아간다는 의미이다. 메소드 선언에 리턴 타입이 있을 경우에는 return 문 뒤에 리턴값을 추가로 지정해야 한다.

```java
return [리턴값];
```

return 문 이후에 실행문을 작성하면 'Unreachable code'라는 컴파일 에러가 발생한다. 왜냐하면 return 문 이후의 실행문은 결코 실행되지 않기 때문이다.

```java
int plus(int x, int y) {
    int result = x + y;
    return result;
    System.out.println(result); // Unreachable code
}
```

하지만 다음과 같은 경우에는 컴파일 에러가 발생하지 않는다.

```java
boolean isLeftGas() {
    if (gas == 0) {
        System.out.println("gas가 없습니다.");
        return false; // 1
    }
    System.out.println("gas가 있습니다."); // 2
    return true;
}
```

if 문의 조건식이 false가 되면 정상적으로 2가 실행되기 때문에 2는 'Unreachable code' 에러를 발생시키지 않는다. if 문의 조건식이 true가 되면 1이 실행되고 return false;가 실행되어 메소드는 즉시 종료되므로 당연히 2는 실행되지 않는다.

**Car.java**
```java
package ch06.sec08.exam03;

public class Car {
	// 필드 선언
	int gas;
	
	// 리턴값이 없는 메소드로 매개값을 받아서 gas 필드값을 변경
	void setGas(int gas) {
		this.gas = gas;
	}
	
	// 리턴값이 boolean인 메소드로 gas 필드값이 0이면 false를, 0이 아니면 true를 리턴
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false; // false를 리턴하고 메소드 종료
		}
		System.out.println("gas가 있습니다.");
		return true; // true를 리턴하고 메소드 종료
	}
	
	// 리턴값이 없는 메소드로 gas 필드값이 0이면 return 문으로 메소드를 종료
	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다.(gas잔량:" + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다.(gas잔량:" + gas + ")");
				return; // 메소드 종료
			}
		}
	}
}
```

**CarExample.java**
```java
package ch06.sec08.exam03;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();
		
		// 리턴값이 없는 setGas() 메소드 호출
		myCar.setGas(5);
		
		// isLeftGas() 메소드를 호출해서 받은 리턴값이 true일 경우 if 블록 실행
		if (myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			
			// 리턴값이 없는 run() 메소드 호출
			myCar.run();
		}
		
		System.out.println("gas를 주입하세요.");
	}
}
```

**실행 결과**
```
gas가 있습니다.
출발합니다.
달립니다.(gas잔량:5)
달립니다.(gas잔량:4)
달립니다.(gas잔량:3)
달립니다.(gas잔량:2)
달립니다.(gas잔량:1)
멈춥니다.(gas잔량:0)
gas를 주입하세요.
```

### 메소드 오버로딩

메소드 오버로딩(Overloading)은 메소드 이름은 같되 매개변수의 타입, 개수, 순서가 다른 메소드를 여러 개 선언하는 것을 말한다.

```java
class 클래스 {
    리턴타입 메소드이름 (타입 변수, ...) { ... }
    리턴타입 메소드이름 (타입 변수, ...) { ... } 
    // 리턴타입은 무관, 매개변수는 동일값, 개수, 순서가 달라야 함
}
```

메소드 오버로딩의 목적은 다양한 매개값을 처리하기 위해서이다. 다음 예에서 plus() 메소드는 두 개의 int 타입 매개값만 처리하고 double 타입 매개값은 처리할 수 없다.

```java
int plus(int x, int y) {
    int result = x + y;
    return result;
}
```

만약 double 타입 값도 처리하고 싶다면 다음과 같이 plus() 메소드를 오버로딩하면 된다.

```java
double plus(double x, double y) {
    double result = x + y;
    return result;
}
```

메소드 오버로딩의 대표적인 예는 콘솔에 출력하는 System.out.println() 메소드로, 호출할 때 주어진 매개값의 타입에 따라서 오버로딩된 println() 메소드 중 하나를 실행한다.

```java
void println() { ... }
void println(double x) { ... }
void println(int x) { ... }
void println(String x) { ... }
```

다음 예제는 areaRectangle() 메소드를 오버로딩해서 매개값이 한 개면 정사각형의 넓이를, 두 개면 직사각형의 넓이를 계산한다.

**Calculator.java**
```java
package ch06.sec08.exam04;

public class Calculator {
	// 정사각형의 넓이
	double areaRectangle(double width) {
		return width * width;
	}
	
	// 직사각형의 넓이
	double areaRectangle(double width, double height) {
		return width * height;
	}
}
```

**CalculatorExample.java**
```java
package ch06.sec08.exam04;

public class CalculatorExample {
	public static void main(String[] args) {
		// 객체 생성
		Calculator myCalcu = new Calculator();
		
		// 정사각형의 넓이 구하기
		double result1 = myCalcu.areaRectangle(10);
		
		// 직사각형의 넓이 구하기
		double result2 = myCalcu.areaRectangle(10, 20);
		
		System.out.println("정사각형 넓이=" + result1);
		System.out.println("직사각형 넓이=" + result2);
	}
}
```

**실행 결과**
```
정사각형 넓이=100.0
직사각형 넓이=200.0
```

## 6.9 인스턴스 멤버

필드와 메소드는 선언 방법에 따라 인스턴스 멤버와 정적 멤버로 분류할 수 있다. 인스턴스 멤버로 선언되면 객체 생성 후 사용할 수 있고, 정적 멤버로 선언되면 객체 생성 없이도 사용할 수 있다.

| 구분                    | 설명                                                       |
| ----------------------- | ---------------------------------------------------------- |
| 인스턴스(Instance) 멤버 | 객체에 소속된 멤버 (객체를 생성해야만 사용할 수 있는 멤버) |
| 정적(Static) 멤버       | 클래스에 고정된 멤버 (객체 없이도 사용할 수 있는 멤버)     |

### 인스턴스 멤버 선언 및 사용

인스턴스(instance) 멤버란 객체에 소속된 멤버를 말한다. 따라서 객체가 있어야만 사용할 수 있는 멤버다. 우리가 지금까지 선언한 필드와 메소드는 인스턴스 멤버였다. 다음과 같이 Car 클래스에 gas 필드와 setSpeed() 메소드를 선언하면 인스턴스 멤버가 된다.

```java
public class Car {
    // 인스턴스 필드 선언
    int gas;
    // 인스턴스 메소드 선언
    void setSpeed(int speed) { ... }
}
```

gas 필드와 setSpeed() 메소드는 인스턴스 멤버이기 때문에 외부 클래스에서 사용하기 위해서는 Car 객체를 먼저 생성하고 참조 변수로 접근해서 사용해야 한다.

```java
Car myCar = new Car();
myCar.gas = 10;
myCar.setSpeed(60);

Car yourCar = new Car();
yourCar.gas = 20;
yourCar.setSpeed(80);
```

인스턴스 멤버는 객체에 소속된 멤버라고 했다. gas 필드는 객체에 소속된 멤버가 분명하지만, setSpeed() 메소드는 객체에 포함되지 않는다. 여기서 우리는 '객체에 소속된'을 '객체에 포함된'이라고 해석하면 안 된다.

메소드는 코드의 덩어리이므로 객체마다 저장한다면 중복 저장으로 인해 메모리 효율이 떨어진다. 따라서 메소드 코드는 메소드 영역에 두되 공유해서 사용하고, 이때 객체 없이는 사용하지 못하도록 제한을 걸어둔 것이다.

### this 키워드

객체 내부에서는 인스턴스 멤버에 접근하기 위해 this를 사용할 수 있다. 우리가 자신을 '나'라고 하듯이, 객체는 자신을 'this'라고 한다. 생성자와 메소드의 매개변수명이 인스턴스 멤버인 필드명과 동일한 경우, 인스턴스 필드임을 강조하고자 할 때 this를 주로 사용한다.

**Car.java**
```java
package ch06.sec09;

public class Car {
	// 필드 선언
	String model;
	int speed;
	
	// 생성자 선언
	Car(String model) {
		this.model = model; // 매개변수를 필드에 대입(this 생략 불가)
	}
	
	// 메소드 선언
	void setSpeed(int speed) {
		this.speed = speed; // 매개변수를 필드에 대입(this 생략 불가)
	}
	
	void run() {
		for(int i=10; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속:" + this.speed + "km/h)");
		}
	}
}
```

**CarExample.java**
```java
package ch06.sec09;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		yourCar.run();
	}
}
```

**실행 결과**
```
포르쉐가 달립니다.(시속:10km/h)
포르쉐가 달립니다.(시속:20km/h)
포르쉐가 달립니다.(시속:30km/h)
포르쉐가 달립니다.(시속:40km/h)
포르쉐가 달립니다.(시속:50km/h)
벤츠가 달립니다.(시속:10km/h)
벤츠가 달립니다.(시속:20km/h)
벤츠가 달립니다.(시속:30km/h)
벤츠가 달립니다.(시속:40km/h)
벤츠가 달립니다.(시속:50km/h)
```

## 6.10 정적 멤버

자바는 클래스 로더(class loader)를 이용해서 클래스를 메소드 영역에 저장하고 사용한다. 정적(static) 멤버란 메소드 영역의 클래스에 고정적으로 위치하는 멤버를 말한다. 그렇기 때문에 정적 멤버는 객체를 생성할 필요 없이 클래스를 통해 바로 사용이 가능하다.

필드와 메소드는 모두 정적 멤버가 될 수 있다. 정적 필드와 정적 메소드로 선언하려면 다음과 같이 static 키워드를 추가하면 된다.

```java
public class 클래스 {
    static 타입 필드 [= 초기값];
    
    // 정적 메소드
    static 리턴타입 메소드( 매개변수, ... ) { ... }
}
```

객체마다 가지고 있을 필요성이 없는 공용적인 필드는 정적 필드로 선언하는 것이 좋다. 예를 들어 Calculator 클래스에서 원의 넓이나 둘레를 구할 때 필요한 파이(π)는 Calculator 객체마다 가지고 있을 필요가 없기 때문에 정적 필드로 선언하는 것이 좋다.

```java
public class Calculator {
    String color; // 계산기별로 색깔이 다를 수 있다.
    static double pi = 3.14159; // 계산기에서 사용하는 파이(π) 값은 동일하다.
}
```

인스턴스 필드를 이용하지 않는 메소드는 정적 메소드로 선언하는 것이 좋다. 예를 들어 Calculator의 plus() 메소드는 외부에서 주어진 매개값들을 가지고 처리하므로 정적 메소드로 선언하는 것이 좋다. 그러나 인스턴스 필드인 color를 변경하는 setColor() 메소드는 인스턴스 메소드로 선언해야 한다.

```java
public class Calculator {
    String color; // 인스턴스 필드
    void setColor(String color) { this.color = color; } // 인스턴스 메소드
    static int plus(int x, int y) { return x + y; } // 정적 메소드
    static int minus(int x, int y) { return x - y; } // 정적 메소드
}
```

### 정적 멤버 사용

클래스가 메모리로 로딩되면 정적 멤버를 바로 사용할 수 있는데, 클래스 이름과 함께 도트(.) 연산자로 접근하면 된다. 예를 들어 Calculator 클래스가 다음과 같이 작성되었다면,

```java
public class Calculator {
    static double pi = 3.14159;
    static int plus(int x, int y) { ... }
    static int minus(int x, int y) { ... }
}
```

정적 필드 pi와 정적 메소드 plus(), minus()는 다음과 같이 사용할 수 있다.

```java
double result1 = 10 * 10 * Calculator.pi;
int result2 = Calculator.plus(10, 5);
int result3 = Calculator.minus(10, 5);
```

정적 필드와 정적 메소드는 다음과 같이 객체 참조 변수로도 접근이 가능하다.

```java
Calculator myCalcu = new Calculator();
double result1 = 10 * 10 * myCalcu.pi;
int result2 = myCalcu.plus(10, 5);
int result3 = myCalcu.minus(10, 5);
```

하지만 정적 요소는 클래스 이름으로 접근하는 것이 정석이다. 이클립스에서는 정적 멤버를 객체 참조 변수로 접근했을 경우, 경고 표시(![warning])를 낸다.

**Calculator.java**
```java
package ch06.sec10.exam01;

public class Calculator {
	static double pi = 3.14159;
	
	static int plus(int x, int y) {
		return x + y;
	}
	
	static int minus(int x, int y) {
		return x - y;
	}
}
```

**CalculatorExample.java**
```java
package ch06.sec10.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}
}
```

**실행 결과**
```
result1 : 314.159
result2 : 15
result3 : 5
```

### 정적 블록

정적 필드는 다음과 같이 필드 선언과 동시에 초기값을 주는 것이 일반적이다.

```java
static double pi = 3.14159;
```

하지만 복잡한 초기화 작업이 필요하다면 정적 블록(static block)을 이용해야 한다. 다음은 정적 블록의 형태를 보여 준다.

```java
static {
    // ...
}
```

정적 블록은 클래스가 메모리로 로딩될 때 자동으로 실행된다. 정적 블록이 클래스 내부에 여러 개가 선언되어 있을 경우에는 선언된 순서대로 실행된다.

> **생성자에서 초기화를 하지 않는 정적 필드**
> 정적 필드는 객체 생성 없이도 사용할 수 있기 때문에 생성자에서 초기화 작업을 하지 않는다. 생성자는 객체 생성 후 실행되기 때문이다.

다음 예제를 보면 Television은 3개의 정적 필드를 가지고 있다. company와 model은 선언 시 초기값을 주었고, info는 정적 블록에서 company와 model을 서로 연결하여 초기값으로 주었다.

**Television.java**
```java
package ch06.sec10.exam02;

public class Television {
	static String company = "MyCompany";
	static String model = "LCD";
	static String info;
	
	static {
		info = company + "-" + model;
	}
}
```

**TelevisionExample.java**
```java
package ch06.sec10.exam02;

public class TelevisionExample {
	public static void main(String[] args) {
		System.out.println(Television.info);
	}
}
```

**실행 결과**
```
MyCompany-LCD
```

### 인스턴스 멤버 사용 불가

정적 메소드와 정적 블록은 객체가 없어도 실행된다는 특징 때문에 내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없다. 또한 객체 자신의 참조인 this도 사용할 수 없다.

```java
public class ClassName {
    // 인스턴스 필드와 메소드 선언
    int field1;
    void method1() { ... }
    
    // 정적 필드와 메소드 선언
    static int field2;
    static void method2() { ... }
    
    // 정적 블록 선언
    static {
        field1 = 10; // (x) 컴파일 에러
        method1(); // (x)
        field2 = 10; // (o)
        method2(); // (o)
    }
    
    // 정적 메소드 선언
    static void method3() {
        this.field1 = 10; // (x) 컴파일 에러
        this.method1(); // (x)
        field2 = 10; // (o)
        method2(); // (o)
    }
}
```

정적 메소드와 정적 블록에서 인스턴스 멤버를 사용하고 싶다면 다음과 같이 객체를 먼저 생성하고 참조 변수로 접근해야 한다.

```java
static void method3() {
    // 객체 생성
    ClassName obj = new ClassName();
    // 인스턴스 멤버 사용
    obj.field1 = 10;
    obj.method1();
}
```

main() 메소드도 동일한 규칙이 적용된다. main() 메소드도 정적 메소드이므로 객체 생성 없이 인스턴스 필드와 인스턴스 메소드를 main() 메소드에서 바로 사용할 수 없다. 따라서 다음과 같이 작성하면 컴파일 에러가 발생한다.

```java
public class Car {
    // 인스턴스 필드 선언
    int speed;
    
    // 인스턴스 메소드 선언
    void run() { ... }
    
    // 메인 메소드 선언
    public static void main(String[] args) {
        speed = 60; // (x) 컴파일 에러
        run(); // (x)
    }
}
```

main() 메소드를 올바르게 수정하면 다음과 같다.

```java
public static void main(String[] args) {
    // 객체 생성
    Car myCar = new Car();
    // 인스턴스 멤버 사용
    myCar.speed = 60;
    myCar.run();
}
```

**Car.java**
```java
package ch06.sec10.exam03;

public class Car {
	// 인스턴스 필드 선언
	int speed;
	
	// 인스턴스 메소드 선언
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}
	
	static void simulate() {
		// 객체 생성
		Car myCar = new Car();
		// 인스턴스 멤버 사용
		myCar.speed = 200;
		myCar.run();
	}
	
	public static void main(String[] args) {
		// 정적 메소드 호출
		simulate();
		
		// 객체 생성
		Car myCar = new Car();
		// 인스턴스 멤버 사용
		myCar.speed = 60;
		myCar.run();
	}
}
```

**실행 결과**
```
200으로 달립니다.
60으로 달립니다.
```

## 6.11 final 필드와 상수

인스턴스 필드와 정적 필드는 언제든지 값을 변경할 수 있다. 그러나 경우에 따라서는 값을 변경하는 것을 막고 읽기만 허용해야 할 때가 있다. 이때 final 필드와 상수를 선언해서 사용한다.

### final 필드 선언

final은 '최종적'이란 뜻을 가지고 있다. final 필드는 초기값이 저장되면 이것이 최종적인 값이 되어서 프로그램 실행 도중에 수정할 수 없게 된다. final 필드는 다음과 같이 선언한다.

```java
final 타입 필드 [= 초기값];
```

final 필드에 초기값을 줄 수 있는 방법은 다음 두 가지밖에 없다.
1. 필드 선언 시에 초기값 대입
2. 생성자에서 초기값 대입

고정된 값이라면 필드 선언 시에 주는 것이 가장 간단하다. 하지만 복잡한 초기화 코드가 필요하거나 객체 생성 시에 외부에서 전달된 값으로 초기화한다면 생성자에서 해야 한다. 이 두 방법을 사용하지 않고 final 필드를 그대로 남겨 두면 컴파일 에러가 발생한다.

다음 예제에서 Korean 클래스를 보면 국가(nation)와 주민등록번호(ssn) 필드를 final 필드로 선언했다. nation은 고정값이므로 선언 시에 초기값을 대입했고, ssn은 Korean 객체가 생성될 때 부여되므로 생성자 매개값으로 주민등록번호를 받아 초기값으로 대입했다.

**Korean.java**
```java
package ch06.sec11.exam01;

public class Korean {
	// 인스턴스 final 필드 선언
	final String nation = "대한민국";
	final String ssn;
	
	// 인스턴스 필드 선언
	String name;
	
	// 생성자 선언
	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
}
```

**KoreanExample.java**
```java
package ch06.sec11.exam01;

public class KoreanExample {
	public static void main(String[] args) {
		// 객체 생성 시 주민등록번호와 이름 전달
		Korean k1 = new Korean("123456-1234567", "감자바");
		
		// 필드값 읽기
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		// Final 필드는 값을 변경할 수 없음
		// k1.nation = "USA";
		// k1.ssn = "123-12-1234";
		
		// 비 final 필드는 값 변경 가능
		k1.name = "김자바";
	}
}
```

**실행 결과**
```
대한민국
123456-1234567
감자바
```

### 상수 선언

우리 주변에는 불변의 값이 있다. 불변의 값은 수학에서 사용하는 원주율 파이(π)나 지구의 무게 및 둘레 등이 해당된다. 이런 불변의 값을 저장하는 필드를 자바에서는 상수(constant)라고 부른다.

상수는 객체마다 저장할 필요가 없고, 여러 개의 값을 가져도 안 되기 때문에 static이면서 final인 특성을 가져야 한다. 따라서 상수는 다음과 같이 선언한다.

```java
static final 타입 상수 [= 초기값];
```

초기값은 선언 시에 주는 것이 일반적이지만, 복잡한 초기화가 필요할 경우에는 정적 블록에서 초기화할 수도 있다.

```java
static final 타입 상수;
static {
    상수 = 초기값;
}
```

상수 이름은 모두 대문자로 작성하는 것이 관례이다. 만약 서로 다른 단어가 혼합된 이름이라면 언더바(_)로 단어들을 연결한다.

```java
static final double PI = 3.14159;
static final double EARTH_SURFACE_AREA = 5.147185403641517E8;
```

또한 상수는 정적 필드이므로 클래스로 접근해서 읽을 수 있다.

```java
클래스명.상수
```

**Earth.java**
```java
package ch06.sec11.exam02;

public class Earth {
	// 상수 선언 및 초기화
	static final double EARTH_RADIUS = 6400;
	
	// 상수 선언
	static final double EARTH_SURFACE_AREA;
	
	// 정적 블록에서 상수 초기화
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
```

**EarthExample.java**
```java
package ch06.sec11.exam02;

public class EarthExample {
	public static void main(String[] args) {
		// 상수 읽기
		System.out.println("지구의 반지름: " + Earth.EARTH_RADIUS + " km");
		System.out.println("지구의 표면적: " + Earth.EARTH_SURFACE_AREA + " km^2");
	}
}
```

**실행 결과**
```
지구의 반지름: 6400.0 km
지구의 표면적: 5.147185403641517E8 km^2
```

## 6.12 패키지

우리는 지금까지 장별, 절별 예제 클래스를 패키지 안에 생성해서 관리했다. 자바의 패키지(package)는 단순히 디렉토리만을 의미하지는 않는다. 패키지는 클래스의 일부분이며, 클래스를 식별하는 용도로 사용된다.

패키지는 주로 개발 회사 도메인 이름의 역순으로 만든다. 예를 들어 mycompany.com 회사의 패키지는 com.mycompany로, yourcompany.com 회사의 패키지는 com.yourcompany로 만든다. 이렇게 하면 두 회사에서 개발한 Car 클래스가 있을 경우 다음과 같이 관리할 수 있다.

```
com
  mycompany
    Car.class
  yourcompany
    Car.class
```

패키지는 상위 패키지와 하위 패키지를 도트(.)로 구분한다. 도트는 물리적으로 하위 디렉토리임을 뜻한다. 예를 들어 com.mycompany 패키지의 com은 상위 디렉토리, mycompany는 하위 디렉토리이다.

패키지는 클래스를 식별하는 용도로 사용되기 때문에 클래스의 전체 이름에 포함된다. 예를 들어 Car 클래스가 com.mycompany 패키지에 속해 있다면 Car 클래스의 전체 이름은 com.mycompany.Car가 된다. 이것은 com.yourcompany.Car와 다른 클래스임을 뜻한다.

패키지에 속한 바이트코드 파일(*.class)은 따로 떼어 내어 다른 디렉토리로 이동할 수 없다. 예를 들어 Car 클래스가 com.mycompany 패키지에 소속되어 있다면 다른 디렉토리에 Car.class를 옮겨 저장할 경우 Car 클래스를 사용할 수 없게 된다.

```
com
  mycompany
    Car.class

com
  yourcompany
    Car.class
```

### 패키지 선언

패키지 디렉토리는 클래스를 컴파일하는 과정에서 자동으로 생성된다. 컴파일러는 클래스의 패키지 선언을 보고 디렉토리를 자동 생성시킨다. 패키지 선언은 package 키워드와 함께 패키지 이름을 기술한 것으로, 항상 소스 파일 최상단에 위치해야 한다.

```java
package 상위패키지.하위패키지;
public class 클래스명 { ... }
```

패키지 이름은 모두 소문자로 작성하는 것이 관례이다. 그리고 패키지 이름이 서로 중복되지 않도록 회사 도메인 이름의 역순으로 작성하고, 마지막에는 프로젝트 이름을 붙여 주는 것이 일반적이다.

```
com.samsung.projectname
com.lg.projectname
org.apache.projectname
```

이클립스에서는 패키지를 먼저 생성하고 클래스를 나중에 추가하는 방식을 사용한다. 지금까지 우리는 장별, 절별 패키지를 먼저 만들고, 클래스를 나중에 추가했다. 추가된 클래스를 보면 자동으로 패키지 선언이 포함되어 있는 것을 볼 수 있다.

소스 파일(*.java)이 저장되면 이클립스는 자동으로 컴파일해서 bin 디렉토리에 패키지 디렉토리와 함께 바이트코드 파일(*.class)을 생성한다.

만약 패키지 선언이 없다면 이클립스는 클래스를 (default package)에 포함시킨다. (default package)란 패키지가 없다는 뜻이다. 그러나 어떤 프로젝트든 패키지 없이 클래스를 만드는 경우는 드물다.

**Car.java**
```java
// (default package)
public class Car {
}
```

### import 문

같은 패키지에 있는 클래스는 아무런 조건 없이 사용할 수 있지만, 다른 패키지에 있는 클래스를 사용하려면 import 문을 이용해서 어떤 패키지의 클래스를 사용하는지 명시해야 한다.

다음은 com.mycompany 패키지의 Car 클래스에서 com.hankook 패키지의 Tire 클래스를 사용하기 위해 import 문을 사용한 것이다.

```java
package com.mycompany; // Car 클래스의 패키지
import com.hankook.Tire; // Tire 클래스의 전체 이름

public class Car {
    // 필드 선언 시 com.hankook.Tire 클래스를 사용
    Tire tire = new Tire();
}
```

import 문이 작성되는 위치는 패키지 선언과 클래스 선언 사이이다. import 키워드 뒤에는 사용하고자 하는 클래스의 전체 이름을 기술한다. 만약 동일한 패키지에 포함된 다수의 클래스를 사용해야 한다면 클래스 이름을 생략하고 *를 사용할 수 있다.

```java
import com.hankook.*;
```

import 문은 하위 패키지를 포함하지 않는다. 따라서 com.hankook 패키지에 있는 클래스도 사용해야 하고, com.hankook.project 패키지에 있는 클래스도 사용해야 한다면 다음과 같이 두 개의 import 문이 필요하다.

```java
import com.hankook.*;
import com.hankook.project.*;
```

만약 서로 다른 패키지에 동일한 클래스 이름이 존재한다고 가정해 보자.

```java
package com.hankook;
public class Tire { ... }

package com.kumho;
public class Tire { ... }
```

두 패키지를 모두 import하고 Tire 클래스를 사용할 경우, 컴파일러는 어떤 패키지의 클래스를 사용할지 결정할 수 없기 때문에 컴파일 에러를 발생시킨다.

```java
package com.hyundai;
import com.hankook.*;
import com.kumho.*;

public class Car {
    // 필드 선언
    Tire tire = new Tire(); // 컴파일 에러
}
```

이 경우에는 클래스의 전체 이름을 사용해서 정확히 어떤 패키지의 클래스를 사용하는지 알려야 한다. 클래스 전체 이름을 사용할 경우 import 문은 필요 없다.

```java
com.hankook.Tire tire = new com.hankook.Tire();
```

> **import 문 자동 추가 기능**
> 이클립스는 소스에서 사용한 클래스를 조사해서 필요하면 import 문을 자동으로 추가하는 기능을 제공한다.
> 1. 기본적으로 'import 전체클래스이름'으로 추가하려면 다음과 같이 선택한다.
>    상단 메뉴 [Source] - [Organize Imports] (단축키 [Ctrl]+[Shift]+[O])
> 2. 'import 패키지.*'로 추가하길 원한다면 다음과 같이 이클립스 설정을 변경한다.
>    상단 메뉴 [Window] - [Preferences] - [Java] - [Code Style] - [Organize Imports]
>    - Number of imports needed for .*의 99를 1로 변경

**SnowTire.java**
```java
package ch06.sec12.hankook;

public class SnowTire {
}
```

**Tire.java (hankook)**
```java
package ch06.sec12.hankook;

public class Tire {
}
```

**AllSeasonTire.java**
```java
package ch06.sec12.kumho;

public class AllSeasonTire {
}
```

**Tire.java (kumho)**
```java
package ch06.sec12.kumho;

public class Tire {
}
```

**Car.java**
```java
package ch06.sec12.hyundai;

// import 문으로 다른 패키지 클래스 사용을 명시
import ch06.sec12.hankook.SnowTire;
import ch06.sec12.kumho.AllSeasonTire;

public class Car {
	// 부품 필드 선언
	ch06.sec12.hankook.Tire tire1 = new ch06.sec12.hankook.Tire();
	ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
	SnowTire tire3 = new SnowTire();
	AllSeasonTire tire4 = new AllSeasonTire();
}
```

## 6.13 접근 제한자

main() 메소드를 가지는 클래스에서 외부 클래스를 사용해서 객체를 생성하고 필드와 메소드를 사용하는 코드를 많이 보아왔다.

```java
Car myCar = new Car();
myCar.speed = 60;
myCar.run();
```

객체 생성을 막기 위해 생성자를 호출하지 못하게 하거나 객체의 특정 데이터를 보호하기 위해 해당 필드에 접근하지 못하게 막아야 할 때가 있다. 그리고 특정 메소드를 호출할 수 없도록 막아야 할 때도 있다.

자바는 이러한 경우를 대비해서 접근 제한자(Access Modifier)를 제공한다. 접근 제한자는 말 그대로 접근을 제한하기 위해 사용된다. 여기서 접근이란 클래스 및 인터페이스를 이용하는 것을 말한다.

접근 제한자는 public, protected, private와 default(아무것도 붙이지 않음)가 있다.

| 접근 제한자 | 적용 대상                    | 접근할 수 있는 범위              |
| ----------- | ---------------------------- | -------------------------------- |
| public      | 클래스, 필드, 생성자, 메소드 | 없음 (모든 패키지에서 접근 가능) |
| protected   | 필드, 생성자, 메소드         | 같은 패키지 + 자식 클래스        |
| default     | 클래스, 필드, 생성자, 메소드 | 같은 패키지                      |
| private     | 필드, 생성자, 메소드         | 클래스 내부                      |

### 클래스의 접근 제한

클래스를 어디에서나 사용할 수 있는 것은 아니다. 클래스를 다른 패키지에서도 사용할 수 있도록 할 것인지, 아니면 같은 패키지에서만 사용할 수 있도록 할 것인지에 따라 접근 제한자를 갖는다.

```java
[public] class 클래스 { ... }
```

클래스 선언 시 public 접근 제한자를 생략했다면 클래스는 default 접근 제한을 가졌다라고 말한다. 클래스가 default 접근 제한을 가지면 같은 패키지에서는 아무런 제한 없이 사용할 수 있지만 다른 패키지에서는 사용할 수 없도록 제한된다.

반대로 클래스가 public 접근 제한을 가지면 같은 패키지뿐만 아니라 다른 패키지에서도 아무런 제한 없이 사용할 수 있다.

라이브러리 클래스를 개발할 때에는 일반적으로 public 접근 제한을 갖도록 해서 어느 패키지에서나 사용할 수 있도록 한다. 그러나 인터넷으로 배포되는 라이브러리 클래스들 중에는 public이 아닌 것도 있다. 이것은 외부로 노출시키지 않고 라이브러리 내부에서만 사용하기 위해서이다.

### 생성자의 접근 제한

객체를 생성하기 위해서는 new 연산자로 생성자를 호출해야 한다. 하지만 생성자를 어디에서나 호출할 수 있는 것은 아니다. 생성자가 어떤 접근 제한을 갖느냐에 따라 호출 가능 여부가 결정된다.

```java
public class ClassName {
    [public | protected | private] ClassName(...) { ... }
}
```

- **public 접근 제한**: 모든 패키지에서 아무런 제한 없이 생성자를 호출할 수 있다.
- **protected 접근 제한**: 같은 패키지에 속하는 클래스에서 생성자를 호출할 수 있다. 다른 패키지에 속한 클래스가 해당 클래스의 자식 클래스라면 생성자를 호출할 수 있다.
- **default 접근 제한**: 같은 패키지에 속하는 클래스에서만 생성자를 호출할 수 있다.
- **private 접근 제한**: 동일한 클래스 내부에서만 생성자를 호출할 수 있고 외부에서는 호출할 수 없다.

**A.java**
```java
package ch06.sec13.exam02.package1;

public class A {
	// 필드 선언
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	// public 접근 제한 생성자 선언
	public A(boolean b) {
	}
	
	// default 접근 제한 생성자 선언
	A(int b) {
	}
	
	// private 접근 제한 생성자 선언
	private A(String s) {
	}
}
```

**B.java**
```java
package ch06.sec13.exam02.package1;

public class B {
	// 필드 선언
	A a1 = new A(true); // (o)
	A a2 = new A(1);    // (o)
	// A a3 = new A("문자열"); // (x) private 생성자 접근 불가
}
```

**C.java**
```java
package ch06.sec13.exam02.package2;

import ch06.sec13.exam02.package1.*;

public class C {
	// 필드 선언
	A a1 = new A(true); // (o)
	// A a2 = new A(1);    // (x) default 생성자 접근 불가
	// A a3 = new A("문자열"); // (x) private 생성자 접근 불가
}
```

### 필드와 메소드의 접근 제한

필드와 메소드를 어디서나 사용할 수 있는 것은 아니다. 어떤 접근 제한을 갖느냐에 따라 호출 여부가 결정된다.

```java
[public | protected | private] [static] 타입 필드;
[public | protected | private] [static] 리턴타입 메소드(...) { ... }
```

- **public 접근 제한**: 모든 패키지에서 아무런 제한 없이 필드와 메소드를 사용할 수 있다.
- **protected 접근 제한**: 같은 패키지에 속하는 클래스에서 필드와 메소드를 사용할 수 있다. 다른 패키지에 속한 클래스가 해당 클래스의 자식 클래스라면 필드와 메소드를 사용할 수 있다.
- **default 접근 제한**: 같은 패키지에 속하는 클래스에서만 필드와 메소드를 사용할 수 있다.
- **private 접근 제한**: 동일한 클래스 내부에서만 필드와 메소드를 사용할 수 있다.

**A.java**
```java
package ch06.sec13.exam03.package1;

public class A {
	// public 접근 제한을 갖는 필드 선언
	public int field1;
	// default 접근 제한을 갖는 필드 선언
	int field2;
	// private 접근 제한을 갖는 필드 선언
	private int field3;
	
	// public 접근 제한을 갖는 생성자 선언
	public A() {
		field1 = 1;	// (o)
		field2 = 1;	// (o)
		field3 = 1;	// (o)
		
		method1();	// (o)
		method2();	// (o)
		method3();	// (o)
	}
	
	// public 접근 제한을 갖는 메소드 선언
	public void method1() {
	}
	
	// default 접근 제한을 갖는 메소드 선언
	void method2() {
	}
	
	// private 접근 제한을 갖는 메소드 선언
	private void method3() {
	}
}
```

**B.java**
```java
package ch06.sec13.exam03.package1;

public class B {
	public void method() {
		// 객체 생성
		A a = new A();
		
		// 필드값 변경
		a.field1 = 1; // (o)
		a.field2 = 1; // (o)
		// a.field3 = 1; // (x) private 필드 접근 불가
		
		// 메소드 호출
		a.method1(); // (o)
		a.method2(); // (o)
		// a.method3(); // (x) private 메소드 접근 불가
	}
}
```

**C.java**
```java
package ch06.sec13.exam03.package2;

import ch06.sec13.exam03.package1.*;

public class C {
	public void method() {
		// 객체 생성
		A a = new A();
		
		// 필드값 변경
		a.field1 = 1; // (o)
		// a.field2 = 1; // (x) default 필드 접근 불가
		// a.field3 = 1; // (x) private 필드 접근 불가
		
		// 메소드 호출
		a.method1(); // (o)
		// a.method2(); // (x) default 메소드 접근 불가
		// a.method3(); // (x) private 메소드 접근 불가
	}
}
```

## 6.14 Getter와 Setter

객체의 필드(데이터)를 외부에서 마음대로 읽고 변경할 경우 객체의 무결성(결점이 없는 성질)이 깨질 수 있다. 예를 들어 자동차의 속도는 음수가 될 수 없는데, 외부에서 음수 값을 설정하면 객체의 무결성이 깨진다.

```java
myCar.speed = -100;
```

이러한 문제점을 해결하기 위해 객체지향 프로그래밍에서는 객체의 필드를 외부에서 직접적으로 접근하는 것을 막고, 대신 메소드를 통해 필드에 접근하는 것을 선호한다. 그 이유는 메소드는 데이터를 검증해서 유효한 값만 필드에 저장할 수 있기 때문이다.

이 역할을 하는 메소드가 Setter이다. 예를 들어 자동차의 속도를 setSpeed() 메소드로 변경할 경우에 다음과 같이 검증 코드를 작성할 수 있다.

```java
void setSpeed(double speed) {
    if (speed < 0) {
        this.speed = 0;
        return;
    } else {
        this.speed = speed;
    }
}
```

외부에서 객체의 데이터를 읽을 때도 메소드를 사용하는 것이 좋다. 필드값이 객체 외부에서 사용하기에 부적절한 경우, 메소드로 적절한 값으로 변환해서 리턴할 수 있기 때문이다.

이 역할을 하는 메소드가 Getter이다. 예를 들어 자동차의 속도 단위가 마일(mile)인 경우, 외부에서 킬로미터(km) 단위로 읽고 싶다면 Getter 메소드에서 변환해서 리턴해 줄 수 있다.

```java
double getSpeed() {
    double km = speed * 1.6;
    return km;
}
```

클래스를 선언할 때 가능하다면 필드를 private로 선언해서 외부로부터 보호하고, 필드에 대한 Setter와 Getter 메소드를 작성해서 필드값을 안전하게 변경/사용하는 것이 좋다.

Setter와 Getter 메소드는 다음과 같은 명명 규칙을 권장한다.

| 리턴타입 | 메소드 이름                           | 작성 예                |
| -------- | ------------------------------------- | ---------------------- |
| boolean  | is`FieldName`()                       | isStop()               |
| 그 외    | get`FieldName`()                      | getSpeed()             |
| void     | set`FieldName`(`Type` `fieldName`)    | setSpeed(double speed) |
| boolean  | set`FieldName`(`boolean` `fieldName`) | setStop(boolean stop)  |

**Car.java**
```java
package ch06.sec14;

public class Car {
	// 필드 선언
	private int speed;
	private boolean stop;
	
	// speed 필드의 Getter/Setter 선언
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}
	
	// stop 필드의 Getter/Setter 선언
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		if (stop == true) this.speed = 0;
	}
}
```

**CarExample.java**
```java
package ch06.sec14;

public class CarExample {
	public static void main(String[] args) {
		// 객체 생성
		Car myCar = new Car();
		
		// 잘못된 속도 변경
		myCar.setSpeed(-50);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		// 올바른 속도 변경
		myCar.setSpeed(60);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		// 멈춤
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("현재 속도: " + myCar.getSpeed());
	}
}
```

**실행 결과**
```
현재 속도: 0
현재 속도: 60
현재 속도: 0
```

## 6.15 싱글톤 패턴

애플리케이션 전체에서 단 한 개의 객체만 생성해서 사용하고 싶다면 싱글톤(Singleton) 패턴을 적용할 수 있다. 싱글톤 패턴의 핵심은 생성자를 private 접근 제한해 외부에서 new 연산자로 생성자를 호출할 수 없도록 막는 것이다.

```java
private 클래스() {}
```

생성자를 호출할 수 없으니 외부에서 마음대로 객체를 생성하는 것이 불가능해진다. 대신 싱글톤 패턴이 제공하는 정적 메소드를 통해 간접적으로 객체를 얻을 수 있다.

다음은 싱글톤 패턴의 전체 코드를 보여 준다.

```java
public class 클래스 {
    // private 접근 권한을 갖는 정적 필드 선언과 초기화
    private static 클래스 singleton = new 클래스();
    
    // private 접근 권한을 갖는 생성자 선언
    private 클래스() {}
    
    // public 접근 권한을 갖는 정적 메소드 선언
    public static 클래스 getInstance() {
        return singleton;
    }
}
```

외부에서 객체를 얻는 유일한 방법은 getInstance() 메소드를 호출하는 것이다. getInstance() 메소드가 리턴하는 객체는 정적 필드가 참조하는 싱글톤 객체이다. 따라서 아래 코드에서 변수1과 변수2가 참조하는 객체는 동일한 객체가 된다.

```java
클래스 변수1 = 클래스.getInstance();
클래스 변수2 = 클래스.getInstance();
```

**Singleton.java**
```java
package ch06.sec15;

public class Singleton {
	// private 접근 권한을 갖는 정적 필드 선언과 초기화
	private static Singleton singleton = new Singleton();
	
	// private 접근 권한을 갖는 생성자 선언
	private Singleton() {
	}
	
	// public 접근 권한을 갖는 정적 메소드 선언
	public static Singleton getInstance() {
		return singleton;
	}
}
```

**SingletonExample.java**
```java
package ch06.sec15;

public class SingletonExample {
	public static void main(String[] args) {
		/*
		Singleton obj1 = new Singleton(); // 컴파일 에러
		Singleton obj2 = new Singleton(); // 컴파일 에러
		*/
		
		// 정적 메소드를 호출해서 싱글톤 객체 얻음
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		// 동일한 객체를 참조하는지 확인
		if (obj1 == obj2) {
			System.out.println("같은 Singleton 객체입니다.");
		} else {
			System.out.println("다른 Singleton 객체입니다.");
		}
	}
}
```

**실행 결과**
```
같은 Singleton 객체입니다.
```

## 확인문제

1. 객체와 클래스에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 클래스는 객체를 생성하기 위한 설계도(청사진)와 같은 것이다.
   - ② new 연산자로 클래스의 생성자를 호출함으로써 객체가 생성된다.
   - ③ 하나의 클래스로 하나의 객체만 생성할 수 있다.
   - ④ 객체는 클래스의 인스턴스이다.

2. 클래스의 구성 멤버가 아닌 것은 무엇입니까?
   - ① 필드(field)
   - ② 생성자(constructor)
   - ③ 메소드(method)
   - ④ 로컬 변수(local variable)

3. 필드, 생성자, 메소드에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 필드는 객체의 데이터를 저장한다.
   - ② 생성자는 객체의 초기화를 담당한다.
   - ③ 메소드는 객체의 동작 부분으로, 실행 코드를 가지고 있는 블록이다.
   - ④ 클래스는 반드시 필드와 메소드를 가져야 한다.

4. 필드에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 필드는 메소드에서 사용할 수 있다.
   - ② 인스턴스 필드 초기화는 생성자에서 할 수 있다.
   - ③ 필드는 반드시 생성자 선언 전에 선언되어야 한다.
   - ④ 필드는 초기값을 주지 않더라도 기본값으로 자동 초기화된다.

5. 생성자에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 객체를 생성하려면 생성자 호출이 반드시 필요한 것은 아니다.
   - ② 생성자는 다른 생성자를 호출하기 위해 this()를 사용할 수 있다.
   - ③ 생성자가 선언되지 않으면 컴파일러가 기본 생성자를 추가한다.
   - ④ 외부에서 객체를 생성할 수 없도록 생성자에 private 접근 제한자를 붙일 수 있다.

6. 메소드에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 리턴값이 없는 메소드는 리턴 타입을 void로 해야 한다.
   - ② 리턴 타입이 있는 메소드는 리턴값을 지정하기 위해 반드시 return 문이 있어야 한다.
   - ③ 매개값의 수를 모를 경우 "..."를 이용해서 매개변수를 선언할 수 있다.
   - ④ 메소드의 이름은 중복해서 선언할 수 없다.

7. 메소드 오버로딩에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 동일한 이름의 메소드를 여러 개 선언하는 것을 말한다.
   - ② 반드시 리턴 타입이 달라야 한다.
   - ③ 매개변수의 타입, 수, 순서를 다르게 선언해야 한다.
   - ④ 매개값의 타입 및 수에 따라 호출될 메소드가 선택된다.

8. 인스턴스 멤버와 정적 멤버에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 정적 멤버는 static으로 선언된 필드와 메소드를 말한다.
   - ② 인스턴스 필드는 생성자 및 정적 블록에서 초기화될 수 있다.
   - ③ 정적 필드와 정적 메소드는 객체 생성 없이 클래스를 통해 접근할 수 있다.
   - ④ 인스턴스 필드와 메소드는 객체를 생성하고 사용해야 한다.

9. final 필드와 상수(static final)에 대한 설명으로 틀린 것은 무엇입니까?
   - ① final 필드와 상수는 초기값이 저장되면 값을 변경할 수 없다.
   - ② final 필드와 상수는 생성자에서 초기화될 수 있다.
   - ③ 상수의 이름은 대문자로 작성하는 것이 관례이다.
   - ④ 상수는 객체 생성 없이 클래스를 통해 사용할 수 있다.

10. 패키지에 대한 설명으로 틀린 것은 무엇입니까?
    - ① 패키지는 클래스들을 그룹화시키는 기능을 한다.
    - ② 클래스가 패키지에 소속되려면 패키지 선언을 반드시 해야 한다.
    - ③ import 문은 다른 패키지의 클래스를 사용할 때 필요하다.
    - ④ com.mycompany 패키지에 소속된 클래스는 com.yourcompany에 옮겨 놓아도 동작한다.

11. 접근 제한에 대한 설명으로 틀린 것은 무엇입니까?
    - ① 접근 제한자는 클래스, 필드, 생성자, 메소드의 사용을 제한한다.
    - ② public 접근 제한은 아무런 제한 없이 해당 요소를 사용할 수 있게 한다.
    - ③ default 접근 제한은 해당 클래스 내부에서만 사용을 허가한다.
    - ④ 외부에서 접근하지 못하도록 하려면 private 접근 제한을 해야 한다.

12. 다음 클래스에서 해당 멤버가 필드, 생성자, 메소드 중 어떤 것인지 ( ) 안에 적어 보세요.

```java
public class Member {
    private String name;                    // ( 필드 )
    public Member(String name) { ... }      // ( 생성자 )
    public void setName(String name) { ... } // ( 메소드 )
}
```

13. 현실 세계의 회원을 Member 클래스로 모델링하려고 합니다. 회원의 데이터로는 이름, 아이디, 패스워드, 나이가 있습니다. 이 데이터들을 가지는 Member 클래스를 선언해 보세요.

```java
public class Member {
    String name;
    String id;
    String password;
    int age;
}
```

14. 13번 문제에서 작성한 Member 클래스에 생성자를 추가하려고 합니다. 다음과 같이 name 필드와 id 필드를 외부에서 받은 값으로 초기화하도록 생성자를 선언해 보세요.

```java
Member user1 = new Member("홍길동", "hong");
```

**정답:**
```java
public class Member {
    String name;
    String id;
    String password;
    int age;
    
    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
```

15. login() 메소드를 호출할 때에는 매개값으로 id와 password를 제공하고, logout() 메소드는 id만 매개값으로 제공하려고 합니다. 다음 조건과 예제 코드를 보고 MemberService 클래스에서 login(), logout() 메소드를 선언해 보세요.
    - login() 메소드는 매개값 id가 "hong", 매개값 password가 "12345"일 경우에만 true로 리턴하고 그 이외의 값일 경우에는 false를 리턴하도록 하세요.
    - logout() 메소드는 id + "님이 로그아웃 되었습니다"가 출력되도록 하세요.

```java
MemberService memberService = new MemberService();
boolean result = memberService.login("hong", "12345");
if(result) {
    System.out.println("로그인 되었습니다.");
    memberService.logout("hong");
} else {
    System.out.println("id 또는 password가 올바르지 않습니다.");
}
```

**정답:**
```java
public class MemberService {
    boolean login(String id, String password) {
        if(id.equals("hong") && password.equals("12345")) {
            return true;
        } else {
            return false;
        }
    }
    
    void logout(String id) {
        System.out.println(id + "님이 로그아웃 되었습니다.");
    }
}
```

16. println() 메소드는 매개값을 콘솔에 출력합니다. println() 메소드의 매개값으로는 int, boolean, double, String 타입 값을 줄 수 있습니다. 다음 조건과 예제 코드를 보고 Printer 클래스에서 println() 메소드를 오버로딩하여 선언해 보세요.

```java
Printer printer = new Printer();
printer.println(10);
printer.println(true);
printer.println(5.7);
printer.println("홍길동");
```

**정답:**
```java
public class Printer {
    void println(int value) {
        System.out.println(value);
    }
    void println(boolean value) {
        System.out.println(value);
    }
    void println(double value) {
        System.out.println(value);
    }
    void println(String value) {
        System.out.println(value);
    }
}
```

17. 16번 문제에서는 Printer 객체를 생성하고 println() 메소드를 호출했습니다. 이번에는 Printer 객체를 생성하지 않고도 다음과 같이 호출할 수 있도록 Printer 클래스를 수정해 보세요.

```java
Printer.println(10);
Printer.println(true);
Printer.println(5.7);
Printer.println("홍길동");
```

**정답:**
```java
public class Printer {
    static void println(int value) {
        System.out.println(value);
    }
    static void println(boolean value) {
        System.out.println(value);
    }
    static void println(double value) {
        System.out.println(value);
    }
    static void println(String value) {
        System.out.println(value);
    }
}
```

18. 다음 예제 코드가 실행되면 "같은 ShopService 객체입니다."라는 메시지가 출력되도록, 싱글톤 패턴을 사용해서 ShopService 클래스를 작성해 보세요.

```java
ShopService obj1 = ShopService.getInstance();
ShopService obj2 = ShopService.getInstance();

if(obj1 == obj2) {
    System.out.println("같은 ShopService 객체입니다.");
} else {
    System.out.println("다른 ShopService 객체입니다.");
}
```

**정답:**
```java
public class ShopService {
    private static ShopService singleton = new ShopService();
    
    private ShopService() {}
    
    public static ShopService getInstance() {
        return singleton;
    }
}
```

19. 은행 계좌 객체인 Account 객체는 잔고(balance) 필드를 가지고 있습니다. balance 필드는 음수값이 될 수 없고, 최대 백만 원까지만 저장할 수 있습니다. 외부에서 balance 필드를 마음대로 변경하지 못하고, 0 <= balance <= 1,000,000 범위의 값만 가질 수 있도록 Account 클래스를 작성해 보세요.
    - Setter와 Getter를 이용
    - 0과 1,000,000은 MIN_BALANCE와 MAX_BALANCE 상수를 선언해서 이용
    - Setter의 매개값이 음수이거나 백만 원을 초과하면 현재 balance 값을 유지

```java
Account account = new Account();

account.setBalance(10000);
System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000

account.setBalance(-100);
System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000

account.setBalance(2000000);
System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000

account.setBalance(300000);
System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 300000
```

**정답:**
```java
public class Account {
    public static final int MIN_BALANCE = 0;
    public static final int MAX_BALANCE = 1000000;
    private int balance;
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        if(balance < Account.MIN_BALANCE || balance > Account.MAX_BALANCE) {
            return;
        }
        this.balance = balance;
    }
}
```

20. 다음은 키보드로부터 계좌 정보를 입력받아 계좌를 관리하는 프로그램입니다. 계좌는 Account 객체로 생성되고 BankApplication에서 길이 100인 Account[] 배열로 관리됩니다. 실행 결과를 보고, Account와 BankApplication 클래스를 작성해 보세요. (키보드로 입력받을 때는 Scanner의 nextLine() 메소드를 사용)

```java
// 실행 결과
--------------------------------------------------
1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료
--------------------------------------------------
선택> 1
---------
계좌생성
---------
계좌번호: 111-111
계좌주: 홍길동
초기입금액: 10000
결과: 계좌가 생성되었습니다.

--------------------------------------------------
1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료
--------------------------------------------------
선택> 2
---------
계좌목록
---------
111-111    홍길동    10000
111-222    강자바    20000

--------------------------------------------------
1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료
--------------------------------------------------
선택> 3
---------
예금
---------
계좌번호: 111-111
예금액: 10000
결과: 예금이 성공되었습니다.

--------------------------------------------------
1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료
--------------------------------------------------
선택> 5
프로그램 종료
```

**정답:**

**Account.java**
```java
public class Account {
    private String ano;
    private String owner;
    private int balance;
    
    public Account(String ano, String owner, int balance) {
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
    }
    
    public String getAno() { return ano; }
    public void setAno(String ano) { this.ano = ano; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}
```

**BankApplication.java**
```java
import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean run = true;
        while(run) {
            System.out.println("--------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택> ");
            
            int selectNo = Integer.parseInt(scanner.nextLine());
            
            if(selectNo == 1) {
                createAccount();
            } else if(selectNo == 2) {
                accountList();
            } else if(selectNo == 3) {
                deposit();
            } else if(selectNo == 4) {
                withdraw();
            } else if(selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
    
    // 계좌생성하기
    private static void createAccount() {
        System.out.println("---------");
        System.out.println("계좌생성");
        System.out.println("---------");
        
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();
        
        System.out.print("계좌주: ");
        String owner = scanner.nextLine();
        
        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(scanner.nextLine());
        
        Account account = new Account(ano, owner, balance);
        for(int i=0; i<accountArray.length; i++) {
            if(accountArray[i] == null) {
                accountArray[i] = account;
                System.out.println("결과: 계좌가 생성되었습니다.");
                break;
            }
        }
    }
    
    // 계좌목록보기
    private static void accountList() {
        System.out.println("---------");
        System.out.println("계좌목록");
        System.out.println("---------");
        
        for(int i=0; i<accountArray.length; i++) {
            Account account = accountArray[i];
            if(account != null) {
                System.out.print(account.getAno());
                System.out.print("    ");
                System.out.print(account.getOwner());
                System.out.print("    ");
                System.out.print(account.getBalance());
                System.out.println();
            }
        }
    }
    
    // 예금하기
    private static void deposit() {
        System.out.println("---------");
        System.out.println("예금");
        System.out.println("---------");
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();
        System.out.print("예금액: ");
        int money = Integer.parseInt(scanner.nextLine());
        
        Account account = findAccount(ano);
        if(account == null) {
            System.out.println("결과: 계좌가 없습니다.");
            return;
        }
        account.setBalance(account.getBalance() + money);
        System.out.println("결과: 예금이 성공되었습니다.");
    }
    
    // 출금하기
    private static void withdraw() {
        System.out.println("---------");
        System.out.println("출금");
        System.out.println("---------");
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();
        System.out.print("출금액: ");
        int money = Integer.parseInt(scanner.nextLine());
        
        Account account = findAccount(ano);
        if(account == null) {
            System.out.println("결과: 계좌가 없습니다.");
            return;
        }
        account.setBalance(account.getBalance() - money);
        System.out.println("결과: 출금이 성공되었습니다.");
    }
    
    // Account 배열에서 ano와 동일한 Account 객체 찾기
    private static Account findAccount(String ano) {
        Account account = null;
        for(int i=0; i<accountArray.length; i++) {
            if(accountArray[i] != null) {
                String dbAno = accountArray[i].getAno();
                if(dbAno.equals(ano)) {
                    account = accountArray[i];
                    break;
                }
            }
        }
        return account;
    }
}
```

```

