---
layout: oop
title: "12.11 리플렉션"
nav_order: 11
parent: "Chapter 12. java.base 모듈"
grand_parent: "객체지향 프로그래밍"
---

# 12.11 리플렉션

자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리한다. 여기서 메타 정보란 패키지 정보, 타입 정보, 멤버(생성자, 필드, 메소드) 정보 등을 말한다. 이러한 메타 정보를 프로그램에서 읽고 수정하는 행위를 리플렉션(Reflection)이라고 한다.

프로그램에서 Class 객체를 얻으려면 다음 3가지 방법 중 하나를 이용하면 된다.

1. `Class clazz = 클래스이름.class;`
2. `Class clazz = Class.forName("패키지...클래스이름");`
3. `Class clazz = 객체참조변수.getClass();`

①과 ②는 클래스 이름만 가지고 Class 객체를 얻는 방법이고, ③은 객체로부터 Class 객체를 얻는 방법이다. 셋 중 어떤 방법을 사용하더라도 동일한 Class 객체를 얻을 수 있다. 예를 들어 String 클래스의 Class 객체는 다음과 같이 얻을 수 있다.

```java
Class clazz = String.class;
Class clazz = Class.forName("java.lang.String");
String str = "감자바";
Class clazz = str.getClass();
```

## 패키지와 타입 정보 얻기

패키지와 타입(클래스, 인터페이스) 이름 정보는 다음 메소드를 통해 얻을 수 있다.

| 메소드                 | 설명                           |
| :--------------------- | :----------------------------- |
| Package getPackage()   | 패키지 정보 읽기               |
| String getSimpleName() | 패키지를 제외한 타입 이름      |
| String getName()       | 패키지를 포함한 전체 타입 이름 |

다음 예제는 Car 클래스의 Class 객체를 얻고, 패키지와 클래스의 이름을 얻어 출력한다.

```java
package ch12.sec11.exam01;

public class Car {
}
```

```java
package ch12.sec11.exam01;

public class GetClassExample {
	public static void main(String[] args) throws Exception {
		// how1
		Class clazz = Car.class;

		// how2
		// Class clazz = Class.forName("ch12.sec11.exam01.Car");

		// how3
		// Car car = new Car();
		// Class clazz = car.getClass();

		System.out.println("패키지: " + clazz.getPackage().getName());
		System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
		System.out.println("클래스 전체 이름: " + clazz.getName());
	}
}
```

**실행 결과**
```
패키지: ch12.sec11.exam01
클래스 간단 이름: Car
클래스 전체 이름: ch12.sec11.exam01.Car
```

## 멤버 정보 얻기

타입(클래스, 인터페이스)가 가지고 있는 멤버 정보는 다음 메소드를 통해 얻을 수 있다.

| 메소드                                  | 용도             |
| :-------------------------------------- | :--------------- |
| Constructor[] getDeclaredConstructors() | 생성자 정보 읽기 |
| Field[] getDeclaredFields()             | 필드 정보 읽기   |
| Method[] getDeclaredMethods()           | 메소드 정보 읽기 |

메소드 이름에서 알 수 있듯이 각각 Constructor 배열, Field 배열, Method 배열을 리턴한다. Constructor, Field, Method 클래스는 모두 java.lang.reflect 패키지에 있는데 각각 생성자, 필드, 메소드에 대한 선언부 정보를 제공한다.

```java
package ch12.sec11.exam02;

public class Car {
	// 필드
	private String model;
	private String owner;

	// 생성자
	public Car() {
	}
	public Car(String model) {
		this.model = model;
	}

	// 메소드
	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
	public String getOwner() { return owner; }
	public void setOwner(String owner) { this.owner = owner; }
}
```

```java
package ch12.sec11.exam02;

import java.lang.reflect.*;

public class ReflectionExample {
	public static void main(String[] args) throws Exception {
		Class clazz = Car.class;

		System.out.println("[생성자 정보]");
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class[] parameters = constructor.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();

		System.out.println("[필드 정보]");
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getType().getName() + " " + field.getName());
		}
		System.out.println();

		System.out.println("[메소드 정보]");
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
	}

	private static void printParameters(Class[] parameters) {
		for (int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if (i < (parameters.length - 1)) {
				System.out.print(",");
			}
		}
	}
}
```

**실행 결과**
```
[생성자 정보]
ch12.sec11.exam02.Car()
ch12.sec11.exam02.Car(java.lang.String)

[필드 정보]
java.lang.String model
java.lang.String owner

[메소드 정보]
getOwner()
setOwner(java.lang.String)
getModel()
setModel(java.lang.String)
```

## 리소스 경로 얻기

Class 객체는 클래스 파일(*.class)의 경로 정보를 가지고 있기 때문에 이 경로를 기준으로 상대 경로에 있는 다른 리소스 파일(이미지, XML, Property 파일)의 정보를 얻을 수 있다. 이때 사용하는 메소드는 다음과 같다.

| 메소드                                       | 설명                           |
| :------------------------------------------- | :----------------------------- |
| URL getResource(String name)                 | 리소스 파일의 URL 리턴         |
| InputStream getResourceAsStream(String name) | 리소스 파일의 InputStream 리턴 |

getResource()는 경로 정보가 담긴 URL 객체를 리턴하고, getResourceAsStream()은 파일의 내용을 읽을 수 있도록 InputStream 객체를 리턴한다(InputStream은 18장에서 학습한다).

다음과 같이 Car.class 파일과 이미지 파일들이 저장되어 있다고 가정해 보자.

```
C:\app\bin
  - Car.class
  - photo1.jpg
  - images
    - photo2.jpg
```

프로그램에서 이미지 파일(photo1.jpg, photo2.jpg)의 절대 경로가 필요할 경우, Car.class가 있는 곳에서 상대 경로로 다음과 같이 얻을 수 있다.

```java
String photo1Path = clazz.getResource("photo1.jpg").getPath();
// C:\...\bin\photo1.jpg

String photo2Path = clazz.getResource("images/photo2.jpg").getPath();
// C:\...\bin\images\photo2.jpg
```

여기서 getPath()는 URL 객체의 메소드로 절대 경로를 리턴한다.

```java
package ch12.sec11.exam03;

public class Car {
}
```

```java
package ch12.sec11.exam03;

public class GetResourceExample {
	public static void main(String[] args) {
		Class clazz = Car.class;

		String photo1Path = clazz.getResource("photo1.jpg").getPath();
		String photo2Path = clazz.getResource("images/photo2.jpg").getPath();

		System.out.println(photo1Path);
		System.out.println(photo2Path);
	}
}
```
