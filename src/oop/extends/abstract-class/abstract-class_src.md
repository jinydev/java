---
layout: oop
title: "7.10 추상 클래스"
nav_order: 10
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 7.10 추상 클래스

사전적 의미로 추상(`abstract`)은 실체 간에 공통되는 특성을 추출한 것을 말한다. 예를 들어 새, 곤충, 물고기 등의 공통점은 동물이다. 여기서 동물은 실체들의 공통되는 특성을 가지고 있는 추상적인 것이라고 볼 수 있다.

## 추상 클래스란?

객체를 생성할 수 있는 클래스를 실체 클래스라고 한다면, 이 클래스들의 공통적인 필드나 메소드를 추출해서 선언한 클래스를 추상 클래스라고 한다. 추상 클래스는 실체 클래스의 부모 역할을 한다. 따라서 실체 클래스는 추상 클래스를 상속해서 공통적인 필드나 메소드를 물려받을 수 있다.

예를 들어 `Bird`, `Insect`, `Fish`와 같은 실체 클래스에서 공통되는 필드와 메소드를 따로 선언한 `Animal` 클래스를 만들 수 있고, 이것을 상속해서 실체 클래스를 만들 수 있다.

추상 클래스는 실체 클래스의 공통되는 필드와 메소드를 추출해서 만들었기 때문에 `new` 연산자를 사용해서 객체를 직접 생성할 수 없다.

```java
Animal animal = new Animal(); // (x)
```

추상 클래스는 새로운 실체 클래스를 만들기 위한 부모 클래스로만 사용된다. 즉, 추상 클래스는 `extends` 뒤에만 올 수 있다.

```java
class Fish extends Animal {
}
```

## 추상 클래스 선언

클래스 선언에 `abstract` 키워드를 붙이면 추상 클래스 선언이 된다. 추상 클래스는 `new` 연산자를 이용해서 객체를 직접 만들지 못하고 상속을 통해 자식 클래스만 만들 수 있다.

```java
public abstract class 클래스명 {
    // 필드
    // 생성자
    // 메소드
}
```

추상 클래스도 필드, 메소드를 선언할 수 있다. 그리고 자식 객체가 생성될 때 `super()`로 추상 클래스의 생성자가 호출되기 때문에 생성자도 반드시 있어야 한다. 다음은 모든 전화기의 공통 필드와 메소드만 뽑아내어 추상 클래스 `Phone`으로 선언한 것이다.

**Phone.java**
```java
package ch07.sec10.exam01;

public abstract class Phone {
	// 필드 선언
	String owner;
	
	// 생성자 선언
	Phone(String owner) {
		this.owner = owner;
	}
	
	// 메소드 선언
	void turnOn() {
		System.out.println("폰 전원을 니다.");
	}
	
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
```

그렇다면 새로운 전화기 클래스는 추상 클래스인 `Phone`으로부터 공통 필드와 메소드를 물려받고 특화된 필드와 메소드를 작성할 수 있다. 다음은 `Phone`을 상속해서 `SmartPhone`을 설계한 것이다.

**SmartPhone.java**
```java
package ch07.sec10.exam01;

public class SmartPhone extends Phone {
	// 생성자 선언
	SmartPhone(String owner) {
		// Phone 생성자 호출
		super(owner);
	}
	
	// 메소드 선언
	void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
}
```

`Phone` 객체는 `new` 연산자로 직접 생성할 수는 없지만 자식 객체인 `SmartPhone`은 `new` 연산자로 객체 생성이 가능하고, `Phone`으로부터 물려받은 `turnOn()`과 `turnOff()` 메소드를 호출할 수 있다.

**PhoneExample.java**
```java
package ch07.sec10.exam01;

public class PhoneExample {
	public static void main(String[] args) {
		// Phone phone = new Phone(); // (x)
		
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn(); // Phone의 메소드
		smartPhone.internetSearch();
		smartPhone.turnOff(); // Phone의 메소드
	}
}
```

**실행 결과**
```
폰 전원을 니다.
인터넷 검색을 합니다.
폰 전원을 끕니다.
```

## 추상 메소드와 재정의

자식 클래스들이 가지고 있는 공통 메소드를 뽑아내어 추상 클래스로 작성할 때, 메소드 선언부(리턴 타입, 메소드명, 매개변수)만 동일하고 실행 내용은 자식 클래스마다 달라야 하는 경우가 많다.

예를 들어 동물은 소리를 내기 때문에 `Animal` 추상 클래스에서 `sound()`라는 메소드를 선언할 수 있지만, 실행 내용인 소리는 동물마다 다르기 때문에 추상 클래스에서 통일하여 작성할 수 없다.

이런 경우를 위해서 추상 클래스는 다음과 같은 추상 메소드를 선언할 수 있다. 일반 메소드 선언과의 차이점은 `abstract` 키워드가 붙고, 메소드 실행 내용인 중괄호 `{}`가 없다.

```java
abstract 리턴타입 메소드명(매개변수, ...);
```

추상 메소드는 자식 클래스의 공통 메소드라는 것만 정의할 뿐, 실행 내용을 가지지 않는다. 다음은 `Animal` 추상 클래스에서 `sound()` 추상 메소드를 선언한 것이다.

```java
public abstract class Animal {
    abstract void sound();
}
```

추상 메소드는 자식 클래스에서 반드시 재정의(오버라이딩)해서 실행 내용을 채워야 한다. 따라서 `Animal` 클래스를 상속하는 자식 클래스는 고유한 소리를 내도록 `sound()` 메소드를 반드시 재정의해야 한다. 예를 들어 `Dog`는 '멍멍', `Cat`은 '야옹' 소리를 내도록 말이다.

**Animal.java**
```java
package ch07.sec10.exam02;

public abstract class Animal {
	// 메소드 선언
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	// 추상 메소드 선언
	public abstract void sound();
}
```

**Dog.java**
```java
package ch07.sec10.exam02;

public class Dog extends Animal {
	// 추상 메소드 재정의
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
```

**Cat.java**
```java
package ch07.sec10.exam02;

public class Cat extends Animal {
	// 추상 메소드 재정의
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
```

**AbstractMethodExample.java**
```java
package ch07.sec10.exam02;

public class AbstractMethodExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat.sound();
		
		// 매개변수의 다형성
		animalSound(new Dog());
		animalSound(new Cat());
	}
	
	public static void animalSound(Animal animal) {
		animal.sound(); // 재정의된 메소드 호출
	}
}
```

**실행 결과**
```
멍멍
야옹
멍멍
야옹
```
