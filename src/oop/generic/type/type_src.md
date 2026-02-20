---
layout: oop
title: "13.2 제네릭 타입"
nav_order: 2
parent: "Chapter 13. 제네릭"
grand_parent: "객체지향 프로그래밍"
---

# 13.2 제네릭 타입

제네릭 타입은 결정되지 않은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다. 제네릭 타입은 선언부에 '< >' 부호가 붙고 그 사이에 타입 파라미터들이 위치한다.

```java
public class 클래스명<A, B, ...> { ... }
public interface 인터페이스명<A, B, ...> { ... }
```

타입 파라미터는 변수명과 동일한 규칙에 따라 작성할 수 있지만 일반적으로 대문자 알파벳 한 글자로 표현한다. 외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정해야 한다. 만약 지정하지 않으면 `Object` 타입이 암묵적으로 사용된다.

다음 예제에서 `Product` 클래스를 제네릭 타입으로 선언해 보자. `kind`와 `model` 필드를 타입 파라미터로 선언하고, Getter의 매개변수와 Setter의 리턴 타입 역시 타입 파라미터로 선언한다. 이렇게 타입 파라미터를 사용하는 이유는 `Product`에 다양한 종류와 모델 제품을 저장하기 위해서이다.

```java
package ch13.sec02.exam01;

// 제네릭 타입
public class Product<K, M> {
	// 필드
	private K kind;
	private M model;

	// 메소드
	public K getKind() { return this.kind; }
	public M getModel() { return this.model; }
	public void setKind(K kind) { this.kind = kind; }
	public void setModel(M model) { this.model = model; }
}
```

`Tv`와 `Car` 클래스를 다음과 같이 작성해 보자.

```java
package ch13.sec02.exam01;

public class Tv {
}
```

```java
package ch13.sec02.exam01;

public class Car {
}
```

다음 `GenericExample` 클래스는 `Product` 제네릭 타입을 이용해서 `Tv`와 `Car`를 저장하고 얻는 방법을 보여 준다.

```java
package ch13.sec02.exam01;

public class GenericExample {
	public static void main(String[] args) {
		// K는 Tv로 대체, M은 String으로 대체
		Product<Tv, String> product1 = new Product<>();

		// Setter 매개값은 반드시 `Tv`와 `String`을 제공
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");

		// Getter 리턴값은 `Tv`와 `String`이 됨
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();

		// K는 Car로 대체, M은 String으로 대체
		Product<Car, String> product2 = new Product<>();

		// Setter 매개값은 반드시 `Car`와 `String`을 제공
		product2.setKind(new Car());
		product2.setModel("SUV자동차");

		// Getter 리턴값은 `Car`와 `String`이 됨
		Car car = product2.getKind();
		String carModel = product2.getModel();
	}
}
```

이번에는 `Rentable` 인터페이스를 제네릭 타입으로 선언해 보자. 다양한 대상을 렌트하기 위해 `rent()` 메소드의 리턴 타입을 타입 파라미터로 선언한다.

```java
package ch13.sec02.exam02;

public interface Rentable<P> {
	P rent();
}
```

렌트 대상인 `Home`과 `Car` 클래스를 다음과 같이 작성해 보자.

```java
package ch13.sec02.exam02;

public class Home {
	public void turnOnLight() {
		System.out.println("전등을 켭니다.");
	}
}
```

```java
package ch13.sec02.exam02;

public class Car {
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
}
```

다음 `HomeAgency`와 `CarAgency`는 집과 자동차를 렌트해주는 대리점 클래스로, `Rentable`의 타입 파라미터를 `Home`과 `Car`로 대체해서 구현하는 방법을 보여 준다.

```java
package ch13.sec02.exam02;

public class HomeAgency implements Rentable<Home> {
	@Override
	public Home rent() {
		return new Home();
	}
}
```

```java
package ch13.sec02.exam02;

public class CarAgency implements Rentable<Car> {
	@Override
	public Car rent() {
		return new Car();
	}
}
```

다음 `GenericExample` 클래스는 `HomeAgency`와 `CarAgency`에서 대여한 `Home`과 `Car`를 이용하는 방법을 보여 준다.

```java
package ch13.sec02.exam02;

public class GenericExample {
	public static void main(String[] args) {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();

		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
	}
}
```

**실행 결과**
```
전등을 켭니다.
자동차가 달립니다.
```

타입 파라미터는 기본적으로 `Object` 타입으로 간주되므로 `Object`가 가지고 있는 메소드를 호출할 수 있다. 다음 예제는 `Box`의 내용물을 비교하기 위해 타입 파라미터로 `Object`의 `equals()` 메소드를 호출한다.

```java
package ch13.sec02.exam03;

public class Box<T> {
	public T content;

	// Box의 내용물이 같은지 비교
	public boolean compare(Box<T> other) {
		boolean result = content.equals(other.content);
		return result;
	}
}
```

```java
package ch13.sec02.exam03;

public class GenericExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		box1.content = "100";

		Box<String> box2 = new Box<>();
		box2.content = "100";

		boolean result1 = box1.compare(box2);
		System.out.println("result1: " + result1);

		Box<String> box3 = new Box<>();
		box3.content = "안녕하세요";

		boolean result2 = box1.compare(box3);
		System.out.println("result2: " + result2);
	}
}
```

**실행 결과**
```
result1: true
result2: false
```
