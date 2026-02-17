---
layout: part03
title: Chapter 13. 제네릭
---

# Chapter 13. 제네릭

## 13.1 제네릭이란?

다음과 같이 Box 클래스를 선언하려고 한다. Box에 넣을 내용물로 content 필드를 선언하려고 할 때, 타입을 무엇으로 해야 할까?

```java
public class Box {
	public ? content;
}
```

Box는 다양한 내용물을 저장해야 하므로 특정 클래스 타입으로 선언할 수 없다. 그래서 다음과 같이 Object 타입으로 선언한다.

```java
public class Box {
	public Object content;
}
```

Object 타입은 모든 클래스의 최상위 부모 클래스이다. 그렇기 때문에 모든 객체는 부모 타입인 Object로 자동 타입 변환이 되므로 content 필드에는 어떤 객체든 대입이 가능하다.

```java
Box box = new Box();
box.content = 모든 객체;
```

문제는 Box 안의 내용물을 얻을 때이다. content는 Object 타입이므로 어떤 객체가 대입되어 있는지 확실하지 않다. 이때 대입된 내용물의 타입을 안다면 강제 타입 변환을 거쳐 얻을 수 있다. 예를 들어 내용물이 String 타입이라면 `(String)`으로 강제 타입 변환해서 내용물을 얻는 식이다.

```java
String content = (String) box.content;
```

그러나 어떤 내용물이 저장되어 있는지 모른다면 instanceof 연산자로 타입을 조사할 수는 있지만 모든 종류의 클래스를 대상으로 조사할 수는 없다. 따라서 Object 타입으로 content 필드를 선언하는 것은 좋은 방법이 아니다.

Box를 생성하기 전에 우리는 어떤 내용물을 넣을지 이미 알고 있다. 따라서 Box를 생성할 때 저장할 내용물의 타입을 미리 알려 주면 Box는 content에 무엇이 대입되고, 읽을 때 어떤 타입으로 제공할지를 알게 된다. 이것이 제네릭이다.

> **제네릭(Generic)**이란 결정되지 않은 타입을 파라미터로 처리하고 실제 사용할 때 파라미터를 구체적인 타입으로 대체시키는 기능

다음은 Box 클래스에서 결정되지 않은 content의 타입을 T라는 **타입 파라미터**로 정의한 것이다.

```java
public class Box<T> {
	public T content;
}
```

`<T>`는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용할 수 있음을 알려주는 역할을 한다. 여기에서 Box 클래스는 T를 content 필드의 타입으로 사용하였다. 즉, Box 클래스는 T가 무엇인지 모르지만, Box 객체가 생성될 시점에 다른 타입으로 대체된다는 것을 알고 있다.

만약 Box의 내용물로 String을 저장하고 싶다면 다음과 같이 Box를 생성할 때 타입 파라미터 T 대신 String으로 대체하면 된다.

```java
Box<String> box = new Box<String>();
box.content = "안녕하세요.";
String content = box.content; // 강제 타입 변환이 필요 없이 "안녕하세요"를 바로 얻을 수 있음
```

Box의 내용물로 100을 저장하고 싶다면 다음과 같이 Box를 생성할 때 타입 파라미터 T 대신 Integer로 대체하면 된다. Integer는 int 값을 표현하는 클래스 타입이다.

```java
Box<Integer> box = new Box<Integer>();
box.content = 100;
int content = box.content; // 강제 타입 변환이 필요없이 100을 바로 얻을 수 있음
```

사실 `<T>`에서 타입 파라미터로 쓰이는 T는 단지 이름일 뿐이기 때문에 T 대신 A부터 Z까지 어떤 알파벳을 사용해도 좋다. 주의할 점은 타입 파라미터를 대체하는 타입은 클래스 및 인터페이스라는 것이다. 바로 위 코드에서 `Box<int>`라고 하지 않은 이유는 기본 타입은 타입 파라미터의 대체 타입이 될 수 없기 때문이다.

그리고 변수를 선언할 때와 동일한 타입으로 호출하고 싶다면 생성자 호출 시 생성자에는 타입을 명시하지 않고 `<>`만 붙일 수 있다.

```java
Box<String> box = new Box<String>();   -> Box<String> box = new Box<>();
Box<Integer> box = new Box<Integer>(); -> Box<Integer> box = new Box<>();
```

실습을 통해 이해해 보자. 다음과 같이 Box 클래스를 작성한다.

```java
package ch13.sec01;

public class Box<T> {
	public T content;
}
```

GenericExample 클래스를 다음과 같이 작성하고 실행해 보자.

```java
package ch13.sec01;

public class GenericExample {
	public static void main(String[] args) {
		// Box<String> box1 = new Box<String>();
		Box<String> box1 = new Box<>();
		box1.content = "안녕하세요.";
		String str = box1.content;
		System.out.println(str);

		// Box<Integer> box2 = new Box<Integer>();
		Box<Integer> box2 = new Box<>();
		box2.content = 100;
		int value = box2.content;
		System.out.println(value);
	}
}
```

**실행 결과**
```
안녕하세요.
100
```

## 13.2 제네릭 타입

제네릭 타입은 결정되지 않은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다. 제네릭 타입은 선언부에 '< >' 부호가 붙고 그 사이에 타입 파라미터들이 위치한다.

```java
public class 클래스명<A, B, ...> { ... }
public interface 인터페이스명<A, B, ...> { ... }
```

타입 파라미터는 변수명과 동일한 규칙에 따라 작성할 수 있지만 일반적으로 대문자 알파벳 한 글자로 표현한다. 외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정해야 한다. 만약 지정하지 않으면 Object 타입이 암묵적으로 사용된다.

다음 예제에서 Product 클래스를 제네릭 타입으로 선언해 보자. kind와 model 필드를 타입 파라미터로 선언하고, Getter의 매개변수와 Setter의 리턴 타입 역시 타입 파라미터로 선언한다. 이렇게 타입 파라미터를 사용하는 이유는 Product에 다양한 종류와 모델 제품을 저장하기 위해서이다.

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

Tv와 Car 클래스를 다음과 같이 작성해 보자.

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

다음 GenericExample 클래스는 Product 제네릭 타입을 이용해서 Tv와 Car를 저장하고 얻는 방법을 보여 준다.

```java
package ch13.sec02.exam01;

public class GenericExample {
	public static void main(String[] args) {
		// K는 Tv로 대체, M은 String으로 대체
		Product<Tv, String> product1 = new Product<>();

		// Setter 매개값은 반드시 Tv와 String을 제공
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");

		// Getter 리턴값은 Tv와 String이 됨
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();

		// K는 Car로 대체, M은 String으로 대체
		Product<Car, String> product2 = new Product<>();

		// Setter 매개값은 반드시 Car와 String을 제공
		product2.setKind(new Car());
		product2.setModel("SUV자동차");

		// Getter 리턴값은 Car와 String이 됨
		Car car = product2.getKind();
		String carModel = product2.getModel();
	}
}
```

이번에는 Rentable 인터페이스를 제네릭 타입으로 선언해 보자. 다양한 대상을 렌트하기 위해 rent() 메소드의 리턴 타입을 타입 파라미터로 선언한다.

```java
package ch13.sec02.exam02;

public interface Rentable<P> {
	P rent();
}
```

렌트 대상인 Home과 Car 클래스를 다음과 같이 작성해 보자.

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

다음 HomeAgency와 CarAgency는 집과 자동차를 렌트해주는 대리점 클래스로, Rentable의 타입 파라미터를 Home과 Car로 대체해서 구현하는 방법을 보여 준다.

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

다음 GenericExample 클래스는 HomeAgency와 CarAgency에서 대여한 Home과 Car를 이용하는 방법을 보여 준다.

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

타입 파라미터는 기본적으로 Object 타입으로 간주되므로 Object가 가지고 있는 메소드를 호출할 수 있다. 다음 예제는 Box의 내용물을 비교하기 위해 타입 파라미터로 Object의 equals() 메소드를 호출한다.

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

## 13.3 제네릭 메소드

제네릭 메소드는 타입 파라미터를 가지고 있는 메소드를 말한다. 타입 파라미터가 메소드 선언부에 정의된다는 점에서 제네릭 타입과 차이가 있다. 제네릭 메소드는 리턴 타입 앞에 `< >` 기호를 추가하고 타입 파라미터를 정의한 뒤, 리턴 타입과 매개변수 타입에서 사용한다.

```java
public <A, B, ...> 리턴타입 메소드명(매개변수, ...) { ... }
```

다음 boxing() 메소드는 타입 파라미터로 `<T>`를 정의하고 매개변수 타입과 리턴 타입에서 T를 사용한다. 정확한 리턴 타입은 T를 내용물로 갖는 Box 객체이다.

```java
public <T> Box<T> boxing(T t) { ... }
```

타입 파라미터 T는 매개값이 어떤 타입이냐에 따라 컴파일 과정에서 구체적인 타입으로 대체된다.

```java
Box<Integer> box1 = boxing(100);
Box<String> box2 = boxing("안녕하세요");
```

①은 100의 클래스 타입이 Integer이므로 타입 파라미터 T는 Integer로 대체되어 `Box<Integer>`가 리턴된다. ②는 "안녕하세요"의 클래스 타입이 String이므로 타입 파라미터 T는 String으로 대체되어 `Box<String>`이 리턴된다.

실습을 해보자. 먼저 제네릭 타입인 Box 클래스를 다음과 같이 선언한다.

```java
package ch13.sec03.exam01;

public class Box<T> {
	// 필드
	private T t;

	// Getter 메소드
	public T get() {
		return t;
	}

	// Setter 메소드
	public void set(T t) {
		this.t = t;
	}
}
```

다음 GenericExample 클래스는 제네릭 메소드인 boxing을 선언하고 호출하는 방법을 보여 준다.

```java
package ch13.sec03.exam01;

public class GenericExample {
	// 제네릭 메소드
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}

	public static void main(String[] args) {
		// 제네릭 메소드 호출
		Box<Integer> box1 = boxing(100);
		int intValue = box1.get();
		System.out.println(intValue);

		// 제네릭 메소드 호출
		Box<String> box2 = boxing("홍길동");
		String strValue = box2.get();
		System.out.println(strValue);
	}
}
```

**실행 결과**
```
100
홍길동
```

## 13.4 제한된 타입 파라미터

경우에 따라서는 타입 파라미터를 대체하는 구체적인 타입을 제한할 필요가 있다. 예를 들어 숫자를 연산하는 제네릭 메소드는 대체 타입으로 Number 또는 자식 클래스(Byte, Short, Integer, Long, Double)로 제한할 필요가 있다.

이처럼 모든 타입으로 대체할 수 없고, 특정 타입과 자식 또는 구현 관계에 있는 타입만 대체할 수 있는 타입 파라미터를 **제한된 타입 파라미터(bounded type parameter)**라고 한다. 정의는 다음과 같이 한다.

```java
public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) { ... }
```

상위 타입은 클래스뿐만 아니라 인터페이스도 가능하다. 인터페이스라고 해서 implements를 사용하지는 않는다. 다음은 Number 타입과 자식 클래스(Byte, Short, Integer, Long, Double)에만 대체 가능한 타입 파라미터를 정의한 것이다.

```java
public <T extends Number> boolean compare(T t1, T t2) {
	double v1 = t1.doubleValue(); // Number의 doubleValue() 메소드 사용
	double v2 = t2.doubleValue(); // Number의 doubleValue() 메소드 사용
	return (v1 == v2);
}
```

타입 파라미터가 Number 타입으로 제한되면서 Object의 메소드뿐만 아니라 Number가 가지고 있는 메소드도 사용할 수 있다. 위 코드에서 doubleValue() 메소드는 Number 타입에 정의되어 있는 메소드로, double 타입 값을 리턴한다.

```java
package ch13.sec04;

public class GenericExample {
	// 제한된 타입 파라미터를 갖는 제네릭 메소드
	public static <T extends Number> boolean compare(T t1, T t2) {
		// T의 타입을 출력
		System.out.println("compare(" + t1.getClass().getSimpleName() + ", " +
				t2.getClass().getSimpleName() + ")");

		// Number의 메소드 사용
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();

		return (v1 == v2);
	}

	public static void main(String[] args) {
		// 제네릭 메소드 호출
		boolean result1 = compare(10, 20); // T를 Integer 타입으로 대체
		System.out.println(result1);
		System.out.println();

		// 제네릭 메소드 호출
		boolean result2 = compare(4.5, 4.5); // T를 Double 타입으로 대체
		System.out.println(result2);
	}
}
```

**실행 결과**
```
compare(Integer, Integer)
false

compare(Double, Double)
true
```

## 13.5 와일드카드 타입 파라미터

제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 타입 파라미터로 `?`(와일드카드)를 사용할 수 있다. `?`는 범위에 있는 모든 타입으로 대체할 수 있다는 표시이다. 예를 들어 다음과 같은 상속 관계가 있다고 가정해 보자.

```
Person
  ^
  | (extends)
Worker     Student
             ^
             | (extends)
         HighStudent
         MiddleStudent
```

타입 파라미터의 대체 타입으로 Student와 자식 클래스인 HighStudent와 MiddleStudent만 가능하도록 매개변수를 다음과 같이 선언할 수 있다.

```java
리턴타입 메소드명(제네릭타입<? extends Student> 변수) { ... }
```

반대로 Worker와 부모 클래스인 Person만 가능하도록 매개변수를 다음과 같이 선언할 수 있다.

```java
리턴타입 메소드명(제네릭타입<? super Worker> 변수) { ... }
```

어떤 타입이든 가능하도록 매개변수를 선언할 수도 있다.

```java
리턴타입 메소드명(제네릭타입<?> 변수) { ... }
```

다음 예제에서 Course 클래스의 메소드 registerCourse1()은 모든 사람이 들을 수 있는 과정을 등록하고, registerCourse2()는 학생만 들을 수 있는 과정을 등록한다. 그리고 registerCourse3()은 직장인과 일반인만 들을 수 있는 과정을 등록한다.

```java
package ch13.sec05;

public class Person {
}

class Worker extends Person {
}

class Student extends Person {
}

class HighStudent extends Student {
}

class MiddleStudent extends Student {
}
```

```java
package ch13.sec05;

public class Applicant<T> {
	public T kind;

	public Applicant(T kind) {
		this.kind = kind;
	}
}
```

```java
package ch13.sec05;

public class Course {
	// 모든 사람이면 등록 가능
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course1을 등록함");
	}

	// 학생만 등록 가능
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course2를 등록함");
	}

	// 직장인 및 일반인만 등록 가능
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course3을 등록함");
	}
}
```

```java
package ch13.sec05;

public class GenericExample {
	public static void main(String[] args) {
		// 모든 사람이 신청 가능
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();

		// 학생만 신청 가능
		// Course.registerCourse2(new Applicant<Person>(new Person())); (x)
		// Course.registerCourse2(new Applicant<Worker>(new Worker())); (x)
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();

		// 직장인 및 일반인만 신청 가능
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		// Course.registerCourse3(new Applicant<Student>(new Student())); (x)
		// Course.registerCourse3(new Applicant<HighStudent>(new HighStudent())); (x)
		// Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent())); (x)
	}
}
```

**실행 결과**
```
Person이(가) Course1을 등록함
Worker이(가) Course1을 등록함
Student이(가) Course1을 등록함
HighStudent이(가) Course1을 등록함
MiddleStudent이(가) Course1을 등록함

Student이(가) Course2를 등록함
HighStudent이(가) Course2를 등록함
MiddleStudent이(가) Course2를 등록함

Person이(가) Course3을 등록함
Worker이(가) Course3을 등록함
```

## 확인문제

1.  제네릭에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 컴파일 시 강한 타입 체크를 할 수 있다.
    *   ② 타입 변환(casting)을 제거한다.
    *   ③ 제네릭 타입은 타입 파라미터를 가지는 제네릭 클래스와 인터페이스를 말한다.
    *   ④ 제네릭 메소드는 리턴 타입으로 타입 파라미터를 가질 수 없다.
    > **정답**: ④
    > **해설**: 제네릭 메소드는 리턴 타입 앞에 타입 파라미터를 선언하고, 리턴 타입으로도 사용할 수 있다.

2.  ContainerExample 클래스의 main() 메소드는 Container 제네릭 타입을 사용하고 있습니다. main() 메소드에서 사용하는 방법을 참고해서 Container 제네릭 타입을 선언해 보세요.
    ```java
    public class ContainerExample {
    	public static void main(String[] args) {
    		Container<String> container1 = new Container<String>();
    		container1.set("홍길동");
    		String str = container1.get();

    		Container<Integer> container2 = new Container<Integer>();
    		container2.set(6);
    		int value = container2.get();
    	}
    }
    ```
    > **정답**:
    ```java
    public class Container<T> {
    	private T t;
    	public T get() { return t; }
    	public void set(T t) { this.t = t; }
    }
    ```

3.  ContainerExample 클래스의 main() 메소드는 Container 제네릭 타입을 사용하고 있습니다. main() 메소드에서 사용하는 방법을 참고해서 Container 제네릭 타입을 선언해 보세요.
    ```java
    public class ContainerExample {
    	public static void main(String[] args) {
    		Container<String, String> container1 = new Container<String, String>();
    		container1.set("홍길동", "도적");
    		String name1 = container1.getKey();
    		String job = container1.getValue();

    		Container<String, Integer> container2 = new Container<String, Integer>();
    		container2.set("홍길동", 35);
    		String name2 = container2.getKey();
    		int age = container2.getValue();
    	}
    }
    ```
    > **정답**:
    ```java
    public class Container<K, V> {
    	private K key;
    	private V value;

    	public void set(K key, V value) {
    		this.key = key;
    		this.value = value;
    	}

    	public K getKey() {
    		return key;
    	}

    	public V getValue() {
    		return value;
    	}
    }
    ```

4.  다음 Util 클래스의 정적 getValue() 메소드는 첫 번째 매개값으로 Pair 타입과 하위 타입만 받고, 두 번째 매개값으로 키값을 받습니다. 리턴값은 키값이 일치할 경우 Pair에 저장된 값을 리턴하고, 일치하지 않으면 null을 리턴하도록 Util 클래스와 getValue() 제네릭 메소드를 작성해 보세요.
    ```java
    public class UtilExample {
    	public static void main(String[] args) {
    		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
    		Integer age = Util.getValue(pair, "홍길동");
    		System.out.println(age);

    		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
    		Integer childAge = Util.getValue(childPair, "홍삼순");
    		System.out.println(childAge);

    		/*
    		OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
    		// OtherPair는 Pair를 상속하지 않으므로 컴파일 에러가 발생
    		int otherAge = Util.getValue(otherPair, "홍삼원");
    		System.out.println(otherAge);
    		*/
    	}
    }
    ```
    ```java
    public class Pair<K, V> {
    	private K key;
    	private V value;

    	public Pair(K key, V value) {
    		this.key = key;
    		this.value = value;
    	}

    	public K getKey() { return key; }
    	public V getValue() { return value; }
    }
    ```
    ```java
    public class ChildPair<K, V> extends Pair<K, V> {
    	public ChildPair(K k, V v) {
    		super(k, v);
    	}
    }
    ```
    ```java
    public class OtherPair<K, V> {
    	private K key;
    	private V value;

    	public OtherPair(K key, V value) {
    		this.key = key;
    		this.value = value;
    	}

    	public K getKey() { return key; }
    	public V getValue() { return value; }
    }
    ```
    > **정답**:
    ```java
    public class Util {
        public static <P extends Pair<K, V>, K, V> V getValue(P pair, K key) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            } else {
                return null;
            }
        }
        /*
        또는
        public static <K, V> V getValue(Pair<K, V> pair, K key) {
             if(pair.getKey().equals(key)) {
                 return pair.getValue();
             } else {
                 return null;
             }
        }
        문제에서 "Pair 타입과 하위 타입만 받고" 라고 했으므로
        public static <P extends Pair<K, V>, K, V> V getValue(P pair, K key)
        형지 더 적절할 수 있다. 하지만 Pair<K,V>로 받아도 하위 타입은 다 받을 수 있다.
        */
    }
    ```
