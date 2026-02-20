---
layout: oop
title: "12.3 Object 클래스"
nav_order: 3
parent: "Chapter 12. java.base 모듈"
grand_parent: "객체지향 프로그래밍"
---

# 12.3 Object 클래스

클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속하게 된다. 따라서 자바의 모든 클래스는 Object의 자식이거나 자손 클래스이다.

그렇기 때문에 Object가 가진 메소드는 모든 객체에서 사용할 수 있다. 다음은 Object가 가진 주요 메소드를 설명한 표이다.

| 메소드                     | 용도                               |
| :------------------------- | :--------------------------------- |
| boolean equals(Object obj) | 객체의 번지를 비교하고 결과를 리턴 |
| int hashCode()             | 객체의 해시코드를 리턴             |
| String toString()          | 객체 문자 정보를 리턴              |

## 객체 동등 비교

Object의 equals() 메소드는 객체의 번지를 비교하고 boolean 값을 리턴한다.

```java
public boolean equals(Object obj)
```

equals() 메소드의 매개변수 타입이 Object이므로 자동 타입 변환에 의해 모든 객체가 매개값으로 대입될 수 있다. equals() 메소드는 비교 연산자인 ==과 동일한 결과를 리턴한다. 두 객체가 동일한 객체라면 true를 리턴하고, 그렇지 않으면 false를 리턴한다.

```java
Object obj1 = new Object();
Object obj2 = obj1;

boolean result = obj1.equals(obj2);  // 결과가 동일
boolean result = (obj1 == obj2);
```

일반적으로 Object의 equals() 메소드는 재정의해서 동등 비교용으로 사용된다. 동등 비교란 객체가 비록 달라도 내부의 데이터가 같은지를 비교하는 것을 말한다. 예를 들어 String은 equals() 메소드를 재정의해서 내부 문자열이 같은지를 비교한다.

다음 예제는 Member 객체의 동등 비교를 위해서 equals() 메소드를 재정의한다. Member 타입이면서 id 필드값이 같을 경우는 true를 리턴하고, 그 이외의 경우는 모두 false를 리턴한다.

```java
package ch12.sec03.exam01;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member target) { // obj가 Member 타입인지 검사하고 타입 변환 후 target 변수에 대입
			if (id.equals(target.id)) {     // id 문자열이 같은지 비교
				return true;
			}
		}
		return false;
	}
}
```

```java
package ch12.sec03.exam01;

public class EqualsExample {
	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");

		if (obj1.equals(obj2)) { // 매개값이 Member 타입이고 id도 동일하므로 true
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}

		if (obj1.equals(obj3)) { // 매개값이 Member 타입이지만 id가 다르므로 false
			System.out.println("obj1과 obj3은 동등합니다.");
		} else {
			System.out.println("obj1과 obj3은 동등하지 않습니다.");
		}
	}
}
```

**실행 결과**
```
obj1과 obj2는 동등합니다.
obj1과 obj3은 동등하지 않습니다.
```

## 객체 해시코드

객체 해시코드란 객체를 식별하는 정수를 말한다. Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해서 해시코드를 생성하기 때문에 객체마다 다른 정수값을 리턴한다. hashCode() 메소드의 용도는 equals() 메소드와 비슷한데, 두 객체가 동등한지를 비교할 때 주로 사용한다.

```java
public int hashCode()
```

equals() 메소드와 마찬가지로 hashCode() 메소드 역시 객체의 데이터를 기준으로 재정의해서 새로운 정수값을 리턴하도록 하는 것이 일반적이다. 객체가 다르다 할지라도 내부 데이터가 동일하다면 같은 정수값을 리턴하기 위해서이다.

자바는 두 객체가 동등함을 비교할 때 hashCode()와 equals() 메소드를 같이 사용하는 경우가 많다. 우선 hashCode()가 리턴하는 정수값이 같은지를 확인하고, 그 다음 equals() 메소드가 true를 리턴하는지를 확인해서 동등 객체임을 판단한다(HashSet, HashMap의 동등 객체를 판단하는 방법은 15.3-4절에서 자세히 설명한다).

다음 예제는 Student 객체를 동등 비교하기 위해 hashCode()와 equals() 메소드를 재정의했다. 학생 번호와 이름으로 해시코드를 생성하고, 학생 번호와 이름이 동일할 경우에만 equals()가 true를 리턴하도록 했다.

```java
package ch12.sec03.exam02;

public class Student {
	private int no;
	private String name;

	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() { return no; }
	public String getName() { return name; }

	@Override
	public int hashCode() {
		int hashCode = no + name.hashCode(); // Object의 hashCode() 메소드를 재정의해서 학생 번호와 이름 해시코드를 합한 새로운 해시코드를 리턴하도록 함(번호와 이름이 같으면 동일한 해시코드가 생성됨)
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student target) {
			if (no == target.getNo() && name.equals(target.getName())) { // Object의 equals() 메소드를 재정의해서 Student 객체인지를 확인하고 학생 번호와 이름이 같으면 true를 리턴하도록 함
				return true;
			}
		}
		return false;
	}
}
```

```java
package ch12.sec03.exam02;

public class HashCodeExample {
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");

		if (s1.hashCode() == s2.hashCode()) { // 해시코드가 동일한지 검사
			if (s1.equals(s2)) { // 데이터가 동일한지 검사
				System.out.println("동등 객체입니다.");
			} else {
				System.out.println("데이터가 다르므로 동등 객체가 아닙니다.");
			}
		} else {
			System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
		}
	}
}
```

**실행 결과**
```
동등 객체입니다.
```

15장에서 배울 컬렉션에 속하는 HashSet은 동등 객체를 중복 저장하지 않는 특징이 있다. HashSet은 hashCode()와 equals() 메소드를 이용해서 동등 객체인지 판단한다. 다음 예제에서 Student 객체를 HashSet에 저장하고, 저장된 개수를 확인해 보자.

```java
package ch12.sec03.exam02;

import java.util.HashSet; // HashSet java.util 패키지에 있으므로 import해야 함

public class HashSetExample {
	public static void main(String[] args) {
		HashSet hashSet = new HashSet(); // HashSet 컬렉션 생성

		Student s1 = new Student(1, "홍길동");
		hashSet.add(s1); // HashSet에 Student 객체 저장
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s2 = new Student(1, "홍길동");
		hashSet.add(s2); // HashSet에 Student 객체 저장
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s3 = new Student(2, "홍길동");
		hashSet.add(s3); // HashSet에 Student 객체 저장
		System.out.println("저장된 객체 수: " + hashSet.size());
	}
}
```

**실행 결과**
```
저장된 객체 수: 1
저장된 객체 수: 1 // 동등 객체는 중복 저장되지 않음
저장된 객체 수: 2
```

s1 객체와 s2 객체는 학생 번호와 이름이 같기 때문에 동등 객체이다. 따라서 s2가 저장될 때 이미 s1이 저장되어 있으므로 중복 저장되지 않는다. Student 클래스에서 hashCode() 재정의 코드를 주석으로 처리하고 HashSetExample.java를 다시 실행해 보자.

```java
/*
@Override
public int hashCode() {
    int hashCode = no + name.hashCode();
    return hashCode;
}
*/
```

hashCode()를 재정의하지 않으면 객체 번지로 해시코드를 생성하므로 객체가 다를 경우 해시코드도 달라진다. 따라서 s1, s2는 동등 객체가 아니므로 따로 저장된다. 실행 결과는 다음과 같다.

**실행 결과**
```
저장된 객체 수: 1
저장된 객체 수: 2
저장된 객체 수: 3
```

## 객체 문자 정보

Object의 toString() 메소드는 객체의 문자 정보를 리턴한다. 객체의 문자 정보란 객체를 문자열로 표현한 값을 말한다. 기본적으로 Object의 toString() 메소드는 '클래스명@16진수해시코드'로 구성된 문자열을 리턴한다.

```java
Object obj = new Object();
System.out.println(obj.toString()); // java.lang.Object@de6ced
```

객체의 문자 정보가 중요한 경우에는 Object의 toString() 메소드를 재정의해서 간결하고 유익한 정보를 리턴하도록 해야 한다. 예를 들어 Date 클래스는 현재 날짜와 시간을, String 클래스는 저장된 문자열을 리턴하도록 toString() 메소드를 재정의하고 있다.

다음 예제는 SmartPhone 객체의 문자 정보로 제조회사 및 운영체제를 리턴하도록 toString() 메소드를 재정의한다.

```java
package ch12.sec03.exam03;

public class SmartPhone {
	private String company;
	private String os;

	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}

	@Override // Object의 toString() 메소드를 재정의해서 제조회사와 운영체제가 결합된 문자열을 리턴하도록 함
	public String toString() {
		return company + ", " + os;
	}
}
```

```java
package ch12.sec03.exam03;

public class ToStringExample {
	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("삼성전자", "안드로이드");

		String strObj = myPhone.toString(); // toString() 메소드 호출
		System.out.println(strObj);

		System.out.println(myPhone); // toString() 메소드 호출
	}
}
```

**실행 결과**
```
삼성전자, 안드로이드
삼성전자, 안드로이드
```

System.out.println() 메소드는 매개값이 기본 타입(byte, short, int, long, float, double, boolean)이거나 문자열일 경우 해당 값을 그대로 출력한다. 만약 매개값이 객체가 되면 객체의 toString() 메소드를 호출해서 리턴값을 출력한다.

## 레코드 선언

데이터 전달을 위한 DTO(Data Transfer Object)를 작성할 때 반복적으로 사용되는 코드를 줄이기 위해 Java 14부터 레코드(record)가 도입되었다. 예를 들어 사람의 정보를 전달하기 위한 Person DTO가 다음과 같다고 가정해 보자.

```java
public class Person {
	private final String name;
	private final int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String name() { return this.name; }
	public int age() { return this.age; }

	@Override
	public int hashCode() { ... }

	@Override
	public boolean equals(Object obj) { ... }

	@Override
	public String toString() { ... }
}
```

Person의 데이터(필드)는 읽기만 가능하도록 필드를 private final로 선언하였으며, 필드 이름과 동일한 Getter 메소드(name(), age())를 가지고 있다. 그리고 동등 비교를 위해 hashCode(), equals() 메소드를 재정의하고 있고, 의미 있는 문자열 출력을 위해 toString() 메소드를 재정의하고 있다.

다음 코드는 위와 동일한 코드를 생성하는 레코드 선언이다. class 키워드 대신에 record로 대체하고 클래스 이름 뒤에 괄호를 작성해서 저장할 데이터의 종류를 변수로 선언하였다.

```java
public record Person(String name, int age) {
}
```

이렇게 선언된 레코드 소스를 컴파일하면 변수의 타입과 이름을 이용해서 private final 필드가 자동 생성되고, 생성자 및 Getter 메소드가 자동으로 추가된다. 그리고 hashCode(), equals(), toString() 메소드를 재정의한 코드도 자동으로 추가된다.

다음은 레코드로 선언된 Member를 이용하는 방법을 보여 준다.

```java
package ch12.sec03.exam04;

public record Member(String id, String name, int age) {
}
```

```java
package ch12.sec03.exam04;

public class RecordExample {
	public static void main(String[] args) {
		Member m = new Member("winter", "눈송이", 25);
		System.out.println(m.id());   // Getter 메소드 호출
		System.out.println(m.name()); // Getter 메소드 호출
		System.out.println(m.age());  // Getter 메소드 호출
		System.out.println(m.toString());
		System.out.println();

		Member m1 = new Member("winter", "눈송이", 25);
		Member m2 = new Member("winter", "눈송이", 25);
		System.out.println("m1.hashCode(): " + m1.hashCode());
		System.out.println("m2.hashCode(): " + m2.hashCode());
		System.out.println("m1.equals(m2): " + m1.equals(m2)); // 동등 비교
	}
}
```

**실행 결과**
```
winter
눈송이
25
Member[id=winter, name=눈송이, age=25]

m1.hashCode(): 306065155
m2.hashCode(): 306065155
m1.equals(m2): true
```

> **NOTE**: Java 21에서는 레코드 패턴 기능이 추가되었다. 자세한 내용은 [부록 1] '최신 자바의 강화된 언어 및 라이브러리'에서 설명한다.

## 롬복 사용하기

롬복(Lombok)은 JDK에 포함된 표준 라이브러리는 아니지만 개발자들이 즐겨 쓰는 자동 코드 생성 라이브러리이다. 롬복은 레코드와 마찬가지로 DTO 클래스를 작성할 때 Getter, Setter, hashCode(), equals(), toString() 메소드를 자동 생성하기 때문에 작성할 코드의 양을 줄여 준다.

레코드와의 차이점은 필드가 final이 아니며, 값을 읽는 Getter는 getXxx(또는 isXxx)로, 값을 변경하는 Setter는 setXxx로 생성된다는 것이다.

> **NOTE**: getXxx와 setXxx는 자바빈즈(JavaBeans)의 정식 Getter와 Setter 이름이다.

이클립스에서 롬복을 사용하려면 설치 과정이 필요하다. 다음 URL로 가서 최신 버전의 롬복 설치 파일(lombok.jar)을 다운로드한다.

[https://projectlombok.org/download](https://projectlombok.org/download)

명령 프롬프트(윈도우) 또는 터미널(맥OS)에서 다운로드받은 lombok.jar 파일이 있는 곳으로 이동해서 다음 명령어를 실행한다.

```bash
java -jar lombok.jar
```

롬복이 실행되면 자동으로 운영체제에 설치된 이클립스를 검색해서 찾을 것이다. 하지만 우리 책 1장을 따라서 윈도우에 이클립스를 설치했다면(C:\ThisIsJava\eclipse) 이클립스를 찾지 못할 수 있다. 이 경우에는 [Specify location] 버튼을 클릭해서 수동으로 이클립스를 지정하면 된다. 설치될 이클립스를 확인했다면 [Install/Update] 버튼을 클릭해서 롬복을 설치한다.

설치가 끝나면 [Quit Installer] 버튼을 클릭해서 닫는다. 그리고 이클립스가 롬복 기능을 인식하도록 이클립스를 재시작한다.

이클립스가 재시작되었다면, Package Explorer 뷰에서 thisisjava 프로젝트를 선택한 다음 마우스 오른쪽 버튼으로 클릭해 [New] - [Folder] 메뉴를 선택하고 lib 폴더를 생성한다. 그리고 다운로드한 lombok.jar 파일을 lib 폴더로 복사한다.

마지막으로 thisisjava 프로젝트에서 lombok 라이브러리를 사용할 수 있도록 lombok.jar 파일을 선택한 다음 마우스 오른쪽 버튼으로 클릭해 [Build Path] - [Add to Build Path]를 선택해 준다.

이제 롬복 라이브러리를 사용해 보자. 먼저 다음과 같이 Member 클래스를 선언한다. 3개의 필드를 선언하고 class 선언 위에 @Data를 붙인다. 이 @Data는 어노테이션이라고 하는데, 어노테이션은 12.12절에서 자세히 설명한다.

```java
package ch12.sec03.exam05;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String name;
	private int age;
}
```

@Data가 붙게 되면 컴파일 과정에서 기본 생성자와 함께 Getter, Setter, hashCode(), equals(), toString() 메소드가 자동 생성된다.

@Data 외에도 다음과 같은 어노테이션을 사용할 수 있다.

| 어노테이션               | 설명                                                                                                                     |
| :----------------------- | :----------------------------------------------------------------------------------------------------------------------- |
| @NoArgsConstructor       | 기본(매개변수가 없는) 생성자 포함                                                                                        |
| @AllArgsConstructor      | 모든 필드를 초기화하는 생성자 포함                                                                                       |
| @RequiredArgsConstructor | 기본적으로 매개변수가 없는 생성자 포함. 만약 final 또는 @NonNull이 붙은 필드가 있다면 이 필드만 초기화시키는 생성자 포함 |
| @Getter                  | Getter 메소드 포함                                                                                                       |
| @Setter                  | Setter 메소드 포함                                                                                                       |
| @EqualsAndHashCode       | equals()와 hashCode() 메소드 포함                                                                                        |
| @ToString                | toString() 메소드 포함                                                                                                   |

> **NOTE**: @Data는 @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString 어노테이션들이 합쳐진 것과 동일한 효과를 낸다.

다음은 매개변수가 없는 기본 생성자뿐만 아니라 모든 필드를 초기화하는 생성자까지 포함시키는 예제이다.

```java
package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String name;
	private int age;
}
```
