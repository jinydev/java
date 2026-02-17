---
layout: part03
title: Chapter 12. java.base 모듈
---

# Chapter 12. java.base 모듈

## 12.1 API 도큐먼트

자바 표준 모듈에서 제공하는 라이브러리는 방대하기 때문에 쉽게 찾아서 사용할 수 있도록 도와주는 API(Application Programming Interface) 도큐먼트가 있다. 라이브러리가 클래스와 인터페이스의 집합이라면, API 도큐먼트는 이를 사용하기 위한 방법을 기술한 것이다.

다음 URL을 방문하면 JDK 버전별로 사용할 수 있는 API 도큐먼트를 볼 수 있다.

[https://docs.oracle.com/en/java/javase/index.html](https://docs.oracle.com/en/java/javase/index.html)

자바 버전을 선택하고 왼쪽 메뉴에서 [API Document] 버튼을 클릭하면 다음과 같이 각 버전에 따른 API 도큐먼트 페이지가 열린다.

![API Document](../images/12/api_document.png)

String 도큐먼트를 통해 API 도큐먼트를 읽는 방법을 알아보자.

### String 도큐먼트를 찾는 3가지 방법

1.  **방법 1: 웹 사이트 메뉴 이용**
    ① [Modules] 탭에서 java.base 모듈을 클릭한다.
    ② java.base의 Packages 목록에서 java.lang 패키지를 클릭한다.
    ③ java.lang의 [Classes and Interfaces] 탭에서 String 클래스를 클릭한다.

2.  **방법 2: 웹 사이트 검색 이용**
    ① 오른쪽 상단의 Search 검색란에 'String'을 입력한다.
    ② 드롭다운 목록에서 java.lang.String 항목을 선택한다.

3.  **방법 3: 이클립스 이용**
    ① 자바 코드에서 String 클래스를 마우스로 선택한 다음 [F1] 키를 누르면 Help 뷰가 나타난다.
    ② Help 뷰에서 Javadoc for 'java.lang.String' 링크를 클릭하면 String 도큐먼트로 이동한다.

### 클래스 선언부 보기

API 도큐먼트에서 String 클래스가 어떻게 정의되었는지 보려면 ① 선언부를 보면 된다. 여기서는 클래스가 final인지 추상(abstract)인지를 알 수 있고, 부모 클래스와 구현 인터페이스를 볼 수 있다. 전체 상속 관계를 보려면 ② 상속 계층도를 보면 된다.

```java
public final class String
    extends Object
    implements Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc
```

### 구성 멤버 보기

String이 가지고 있는 멤버를 보려면 상단 메뉴의 SUMMARY를 활용한다. SUMMARY는 선언된 멤버별로 이동하는 링크를 제공한다. 링크가 있으면 공개된(public, protected) 멤버가 있다는 뜻이고, 링크가 없으면 공개된 멤버가 없다는 뜻이다.

*   **NESTED**: 중첩 클래스/중첩 인터페이스 목록으로 이동하는 링크
*   **FIELD**: 필드 목록으로 이동하는 링크
*   **CONSTR**: 생성자 목록으로 이동하는 링크
*   **METHOD**: 메소드 목록으로 이동하는 링크

### 필드 보기

SUMMARY에서 FIELD 링크를 클릭하면 필드 목록으로 이동한다.

Modifier and Type에서는 static 여부와 필드 타입을 알 수 있고, Field와 Description은 필드명과 그에 대한 간단한 설명이다. 필드명을 클릭하면 필드 선언부와 상세한 설명이 나온다. 관례적으로 필드 이름이 모두 대문자이면 public static final로 선언된 상수 필드이다.

### 생성자 보기

SUMMARY에서 CONSTR 링크를 클릭하면 생성자 목록으로 이동한다.

Constructor에서는 생성자의 매개변수 타입을 알 수 있고, Description은 이에 대한 간단한 설명이다. String 클래스는 매개변수 타입과 개수를 달리한 10개가 넘는 생성자들이 오버로딩되어 있다. 이 생성자들 중 하나를 이용해서 String 객체를 생성할 수 있다.

### 메소드 보기

SUMMARY에서 METHOD 링크를 클릭하면 메소드 목록으로 이동하는데, 다음과 같이 서브 목록으로 가는 버튼들을 볼 수 있다.

*   **All Methods**: 모든 메소드 목록을 보여 준다.
*   **Static Methods**: 정적 메소드 목록을 보여 준다.
*   **Instance Methods**: 인스턴스 메소드 목록을 보여 준다.
*   **Concrete Methods**: 완전한 실행부를 갖춘 메소드 목록을 보여 준다.
*   **Deprecated Methods**: 향후 제거될 메소드 목록을 보여 준다.

Modifier and Type에서는 static 여부와 리턴 타입이 무엇인지 알 수 있다. Method에서는 메소드명과 매개변수 타입 및 개수를 알 수 있고, Description은 그에 대한 간단한 설명이다. 각 메소드명을 클릭하면 상세 설명을 읽을 수 있다.

## 12.2 java.base 모듈

java.base는 모든 모듈이 의존하는 기본 모듈로, 모듈 중 유일하게 requires하지 않아도 사용할 수 있다. 이 모듈에 포함되어 있는 패키지는 대부분의 자바 프로그램에서 많이 사용하는 것들이다. 다음은 java.base 모듈에 포함된 주요 패키지와 용도를 설명한 표이다.

| 패키지    | 용도                                                                 |
| :-------- | :------------------------------------------------------------------- |
| java.lang | 자바 언어의 기본 클래스를 제공                                       |
| java.util | 자료 구조와 관련된 컬렉션 클래스를 제공                              |
| java.text | 날짜 및 숫자를 원하는 형태의 문자열로 만들어 주는 포맷 클래스를 제공 |
| java.time | 날짜 및 시간을 조작하거나 연산하는 클래스를 제공                     |
| java.io   | 입출력 스트림 클래스를 제공                                          |
| java.net  | 네트워크 통신과 관련된 클래스를 제공                                 |
| java.nio  | 데이터 저장을 위한 Buffer 및 새로운 입출력 클래스 제공               |

우리가 지금까지 사용한 String, System, Integer, Double, Exception, RuntimeException 등의 클래스는 java.lang 패키지에 있고, 키보드 입력을 위해 사용한 Scanner는 java.util 패키지에 있다.

java.lang은 자바 언어의 기본적인 클래스를 담고 있는 패키지로, 이 패키지에 있는 클래스와 인터페이스는 import 없이 사용할 수 있다. 다음은 java.lang 패키지에 포함된 주요 클래스와 용도를 설명한 표이다.

| 클래스                                                        | 용도                                                                                                                                                                           |
| :------------------------------------------------------------ | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Object                                                        | 자바 클래스의 최상위 클래스로 사용                                                                                                                                             |
| System                                                        | 키보드로부터 데이터를 입력받을 때 사용<br>모니터(콘솔)로 출력하기 위해 사용<br>프로세스를 종료시킬 때 사용<br>진행 시간을 읽을 때 사용<br>시스템 속성(프로퍼티)을 읽을 때 사용 |
| Class                                                         | 클래스의 메타 정보(이름, 구성 멤버) 등을 조사할 때 사용                                                                                                                        |
| String                                                        | 문자열을 저장하고 조작할 때 사용                                                                                                                                               |
| StringBuilder                                                 | 효율적인 문자열 조작 기능이 필요할 때 사용                                                                                                                                     |
| Byte, Short, Character,<br>Integer, Float, Double,<br>Boolean | 기본 타입의 값을 포장할 때 사용<br>문자열을 기본 타입으로 변환할 때 사용                                                                                                       |
| Math                                                          | 수학 연산이 필요할 때 사용                                                                                                                                                     |

## 12.3 Object 클래스

클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속하게 된다. 따라서 자바의 모든 클래스는 Object의 자식이거나 자손 클래스이다.

그렇기 때문에 Object가 가진 메소드는 모든 객체에서 사용할 수 있다. 다음은 Object가 가진 주요 메소드를 설명한 표이다.

| 메소드                     | 용도                               |
| :------------------------- | :--------------------------------- |
| boolean equals(Object obj) | 객체의 번지를 비교하고 결과를 리턴 |
| int hashCode()             | 객체의 해시코드를 리턴             |
| String toString()          | 객체 문자 정보를 리턴              |

### 객체 동등 비교

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

### 객체 해시코드

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

### 객체 문자 정보

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

### 레코드 선언

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

### 롬복 사용하기

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

## 12.4 System 클래스

자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니라 자바 가상 머신(JVM) 위에서 실행된다. 따라서 운영체제의 모든 기능을 자바 코드로 직접 접근하기란 어렵다. 하지만 java.lang 패키지에 속하는 System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.

System 클래스의 정적(static) 필드와 메소드를 이용하면 프로그램 종료, 키보드 입력, 콘솔(모니터) 출력, 현재 시간 읽기, 시스템 프로퍼티 읽기 등이 가능하다.

| 구분                 | 필드 및 메소드      | 용도                                       |
| :------------------- | :------------------ | :----------------------------------------- |
| 콘솔 출력            | out                 | 콘솔(모니터)에 문자 출력                   |
|                      | err                 | 콘솔(모니터)에 에러 내용 출력              |
| 키보드 입력          | in                  | 키보드 입력                                |
| 프로세스 종료        | exit(int status)    | 프로세스 종료                              |
| 진행 시간 읽기       | currentTimeMillis() | 현재 시간을 밀리초 단위의 long 값으로 리턴 |
|                      | nanoTime()          | 현재 시간을 나노초 단위의 long 값으로 리턴 |
| 시스템 프로퍼티 읽기 | getProperty()       | 운영체제와 사용자 정보 제공                |
|                      | getenv()            | 운영체제의 환경 변수 정보 제공             |

### 콘솔 출력

out 필드를 이용하면 콘솔에 원하는 문자열을 출력할 수 있다. err 필드도 out 필드와 동일한데, 차이점은 콘솔 종류에 따라 에러 내용이 빨간색으로 출력된다는 것이다. 다음은 err 필드의 println() 메소드로 에러 내용을 출력하는 예제이다.

```java
package ch12.sec04;

public class ErrExample {
	public static void main(String[] args) {
		try {
			int value = Integer.parseInt("1oo");
		} catch(NumberFormatException e) {
			System.err.println("[에러 내용]");
			System.err.println(e.getMessage());
		}
	}
}
```

**실행 결과**
```
[에러 내용]
For input string: "1oo"
```

### 키보드 입력

자바는 키보드로부터 입력된 키를 읽기 위해 System 클래스에서 in 필드를 제공한다. 다음과 같이 in 필드를 이용해서 read() 메소드를 호출하면 입력된 키의 코드값을 얻을 수 있다.

```java
int keyCode = System.in.read();
```

키 코드는 각 키에 부여되어 있는 번호이다.

read() 메소드는 호출과 동시에 키 코드를 읽는 것이 아니라, Enter 키를 누르기 전까지는 대기 상태이다가 Enter 키를 누르면 입력했던 키들을 하나씩 읽기 시작한다. 단, read() 메소드는 IOException을 발생할 수 있는 코드이므로 예외 처리가 필요하다.

다음은 숫자 키 1과 2를 입력함에 따라 speed 변수값을 증감하는 예제이다. 그리고 숫자 키 3을 입력하면 while 문을 종료하도록 했다.

```java
package ch12.sec04;

import java.io.IOException;

public class InExample {
	public static void main(String[] args) throws IOException {
		int speed = 0;
		int keyCode = 0;

		while (true) {
			// Enter 키를 읽지 않았을 경우에만 실행
			if (keyCode != 13 && keyCode != 10) {
				if (keyCode == 49) { // 숫자 1 키를 읽었을 경우
					speed++;
				} else if (keyCode == 50) { // 숫자 2 키를 읽었을 경우
					speed--;
				} else if (keyCode == 51) { // 숫자 3 키를 읽었을 경우
					break;
				}
				System.out.println("-------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("-------------------------");
				System.out.println("현재 속도= " + speed);
				System.out.print("선택: ");
			}

			// 키를 하나씩 읽음
			keyCode = System.in.read();
		}

		System.out.println("프로그램 종료");
	}
}
```

**실행 결과**
```
-------------------------
1. 증속 | 2. 감속 | 3. 중지
-------------------------
현재 속도= 0
선택: 1 <Enter>
-------------------------
1. 증속 | 2. 감속 | 3. 중지
-------------------------
현재 속도= 1
선택: 2 <Enter>
-------------------------
1. 증속 | 2. 감속 | 3. 중지
-------------------------
현재 속도= 0
선택: 3 <Enter>
프로그램 종료
```

### 프로세스 종료

운영체제는 실행 중인 프로그램을 프로세스(process)로 관리한다. 자바 프로그램을 시작하면 JVM 프로세스가 생성되고, 이 프로세스가 main() 메소드를 호출한다. 프로세스를 강제 종료하고 싶다면 System.exit() 메소드를 사용한다.

```java
System.exit(int status)
```

exit() 메소드는 int 매개값이 필요한데, 이 값을 종료 상태값이라고 한다. 종료 상태값으로 어떤 값을 주더라도 프로세스는 종료되는데 정상 종료일 경우 0, 비정상 종료는 1 또는 -1로 주는 것이 관례이다.

다음 예제는 i가 5가 되면 프로세스를 정상 종료한다.

```java
package ch12.sec04;

public class ExitExample {
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			// i값 출력
			System.out.println(i);
			if (i == 5) {
				System.out.println("프로세스 강제 종료");
				System.exit(0);
			}
		}
	}
}
```

**실행 결과**
```
0
1
2
3
4
5
프로세스 강제 종료
```

### 진행 시간 읽기

System 클래스의 currentTimeMillis() 메소드와 nanoTime() 메소드는 1970년 1월 1일 0시부터 시작해서 현재까지 진행된 시간을 리턴한다.

| 메소드                   | 용도                               |
| :----------------------- | :--------------------------------- |
| long currentTimeMillis() | 1/1000초 단위로 진행된 시간을 리턴 |
| long nanoTime()          | 1/10^9초 단위로 진행된 시간을 리턴 |

이 두 메소드는 프로그램 처리 시간을 측정하는 데 주로 사용된다. 프로그램 처리를 시작할 때 한 번, 끝날 때 한 번 읽어서 그 차이를 구하면 프로그램 처리 시간이 나온다. 다음 예제는 for문을 사용해서 1부터 1000000까지의 합을 구하는데 걸린 시간을 출력한다.

```java
package ch12.sec04;

public class MeasureRunTimeExample {
	public static void main(String[] args) {
		long time1 = System.nanoTime();
		int sum = 0;
		for (int i=1; i<=1000000; i++) {
			sum += i;
		}

		long time2 = System.nanoTime();

		System.out.println("1-1000000까지의 합: " + sum);
		System.out.println("계산에 " + (time2 - time1) + " 나노초가 소요되었습니다.");
	}
}
```

**실행 결과**
```
1-1000000까지의 합: 1784293664
계산에 1933400 나노초가 소요되었습니다.
```

### 시스템 프로퍼티 읽기

시스템 프로퍼티(System Property)란 자바 프로그램이 시작될 때 자동 설정되는 시스템의 속성을 말한다. 예를 들어 운영체제 종류 및 사용자 정보, 자바 버전 등의 기본 사양 정보가 해당한다. 다음은 시스템 프로퍼티의 주요 속성 이름(key)과 값(value)에 대해 설명한 것이다.

| 속성 이름(key)             | 설명                    | 값(value) 예시                     |
| :------------------------- | :---------------------- | :--------------------------------- |
| java.specification.version | 자바 스펙 버전          | 17                                 |
| java.home                  | JDK 디렉토리 경로       | C:\Program Files\Java\jdk-17.0.2   |
| os.name                    | 운영체제                | Windows 10                         |
| user.name                  | 사용자 이름             | xxx                                |
| user.home                  | 사용자 홈 디렉토리 경로 | C:\Users\xxx                       |
| user.dir                   | 현재 디렉토리 경로      | C:\ThisIsJava\workspace\thisisjava |

다음은 운영체제 이름, 사용자 이름, 사용자 홈 디렉토리를 따로 출력하고, 모든 시스템 프로퍼티의 속성 이름과 값을 출력하는 예제이다. (Properties와 Set은 15장에서 학습한다.)

```java
package ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
	public static void main(String[] args) {
		// 운영체제와 사용자 정보 출력
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);

		// 전체 키와 값을 출력
		System.out.println("---------------------------------");
		System.out.println(" key: value");
		System.out.println("---------------------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();

		for (Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s\n", key, value);
		}
	}
}
```

## 12.5 문자열 클래스

자바에서 문자열과 관련된 주요 클래스는 다음과 같다.

| 클래스          | 설명                                       |
| :-------------- | :----------------------------------------- |
| String          | 문자열을 저장하고 조작할 때 사용           |
| StringBuilder   | 효율적인 문자열 조작 기능이 필요할 때 사용 |
| StringTokenizer | 구분자로 연결된 문자열을 분리할 때 사용    |

### String 클래스

String 클래스는 문자열을 저장하고 조작할 때 사용한다. 문자열 리터럴은 자동으로 String 객체로 생성되지만, String 클래스의 다양한 생성자를 이용해서 직접 객체를 생성할 수도 있다.

프로그램을 개발하다 보면 byte 배열을 문자열로 변환하는 경우가 종종 있다. 예를 들어 네트워크 통신으로 얻은 byte 배열을 원래 문자열로 변환하는 경우이다. 이때는 String 생성자 중에서 다음 두 가지를 사용해 String 객체로 생성할 수 있다.

```java
// 기본 문자셋으로 byte 배열을 디코딩해서 String 객체로 생성
String str = new String(byte[] bytes);

// 특정 문자셋으로 byte 배열을 디코딩해서 String 객체로 생성
String str = new String(byte[] bytes, String charsetName);
```

다음 예제는 문자열을 byte 배열로 변환시키고 다시 문자열로 복원하는 방법을 보여 준다.

```java
package ch12.sec05;

import java.util.Arrays;
import java.io.UnsupportedEncodingException;

public class BytesToStringExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "자바";

		// String -> byte 배열(기본: UTF-8 인코딩)
		byte[] arr1 = data.getBytes(); // byte[] arr1 = data.getBytes("UTF-8");
		System.out.println("arr1: " + Arrays.toString(arr1));

		// byte 배열 -> String (기본: UTF-8 디코딩)
		String str1 = new String(arr1); // String str1 = new String(arr1, "UTF-8");
		System.out.println("str1: " + str1);

		// String -> byte 배열(EUC-KR 인코딩)
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println("arr2: " + Arrays.toString(arr2));

		// byte 배열 -> String (EUC-KR 디코딩)
		String str2 = new String(arr2, "EUC-KR");
		System.out.println("str2: " + str2);
	}
}
```

**실행 결과**
```
arr1: [-20, -98, -112, -21, -80, -108]
str1: 자바
arr2: [-64, -38, -71, -39]
str2: 자바
```

### StringBuilder 클래스

String은 내부 문자열을 수정할 수 없다. 다음 코드를 보면 다른 문자열을 결합해서 내부 문자열을 변경하는 것처럼 보이지만 사실 'ABCDEF'라는 새로운 String 객체를 생성하는 것이다. 그리고 data 변수는 새로 생성된 String 객체를 참조하게 된다.

```java
String data = "ABC";
data += "DEF";
```

문자열의 + 연산은 새로운 String 객체가 생성되고 이전 객체는 계속 버려지는 것이기 때문에 효율성이 좋다고는 볼 수 없다. 잦은 문자열 변경 작업을 해야 한다면 String보다는 StringBuilder를 사용하는 것이 좋다.

StringBuilder는 내부 버퍼(데이터를 저장하는 메모리)에 문자열을 저장해두고 그 안에서 추가, 수정, 삭제 작업을 하도록 설계되어 있다. 따라서 String처럼 새로운 객체를 만들지 않고도 문자열을 조작할 수 있다. StringBuilder가 제공하는 조작 메소드는 다음과 같다.

| 리턴 타입     | 메소드(매개변수)                   | 설명                      |
| :------------ | :--------------------------------- | :------------------------ |
| StringBuilder | append(기본타입 또는 문자열)       | 문자열을 끝에 추가        |
| StringBuilder | insert(위치, 기본타입 또는 문자열) | 문자열을 지정 위치에 추가 |
| StringBuilder | delete(시작위치, 끝위치)           | 문자열 일부를 삭제        |
| StringBuilder | replace(시작위치, 끝위치, 문자열)  | 문자열 일부를 대체        |
| String        | toString()                         | 완성된 문자열을 리턴      |

toString()을 제외한 다른 메소드는 StringBuilder를 다시 리턴하기 때문에 연이어서 다른 메소드를 호출할 수 있는 메소드 체이닝(chaining) 패턴을 사용할 수 있다.

```java
package ch12.sec05;

public class StringBuilderExample {
	public static void main(String[] args) {
		String data = new StringBuilder()
				.append("DEF")
				.insert(0, "ABC")
				.delete(3, 4)
				.toString();
		System.out.println(data);
	}
}
```

**실행 결과**
```
ABCEF
```

### StringTokenizer 클래스

문자열이 구분자(delimiter)로 연결되어 있을 경우, 구분자를 기준으로 문자열을 분리하려면 String의 split() 메소드를 이용하거나 java.util 패키지의 StringTokenizer 클래스를 이용할 수 있다. split은 정규 표현식으로 구분하고, StringTokenizer는 문자로 구분한다는 차이점이 있다.

다음과 같은 문자열에서 &, 쉼표(,), 하이픈(-)으로 구분된 사람 이름을 뽑아낼 경우에는 정규 표현식으로 분리하는 split() 메소드를 사용해야 한다.

```java
String data = "홍길동&이수홍,박연수,김자바-최명호";
String[] names = data.split("&|,|-");
```

그러나 다음과 같이 여러 종류가 아닌 한 종류의 구분자만 있다면 StringTokenizer를 사용할 수도 있다.

```java
String data = "홍길동/이수홍/박연수";
StringTokenizer st = new StringTokenizer(data, "/");
```

StringTokenizer 객체가 생성되면 다음 메소드들을 이용해서 분리된 문자열을 얻을 수 있다.

| 리턴 타입 | 메소드(매개변수) | 설명                           |
| :-------- | :--------------- | :----------------------------- |
| int       | countTokens()    | 분리할 수 있는 문자열의 총 수  |
| boolean   | hasMoreTokens()  | 남아 있는 문자열이 있는지 여부 |
| String    | nextToken()      | 문자열을 하나씩 가져옴         |

```java
package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String data1 = "홍길동&이수홍,박연수";
		String[] arr = data1.split("&|,");
		for (String token : arr) {
			System.out.println(token);
		}
		System.out.println();

		String data2 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data2, "/");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
```

**실행 결과**
```
홍길동
이수홍
박연수

홍길동
이수홍
박연수
```

## 12.6 포장 클래스

자바는 기본 타입(byte, char, short, int, long, float, double, boolean)의 값을 갖는 객체를 생성할 수 있다. 이런 객체를 포장(Wrapper) 객체라고 한다. 값을 포장하고 있다고 해서 붙여진 이름이다.

포장 객체를 생성하기 위한 클래스는 java.lang 패키지에 포함되어 있는데, char 타입과 int 타입이 각각 Character와 Integer인 것만 제외하고는 기본 타입의 첫 문자를 대문자로 바꾼 이름을 가지고 있다.

| 기본 타입 | 포장 클래스 | 기본 타입 | 포장 클래스 |
| :-------- | :---------- | :-------- | :---------- |
| byte      | Byte        | int       | Integer     |
| char      | Character   | long      | Long        |
| short     | Short       | float     | Float       |
| double    | Double      | boolean   | Boolean     |

포장 객체는 포장하고 있는 기본 타입의 값을 변경할 수 없고, 단지 객체로 생성하는 데 목적이 있다. 이런 객체가 필요한 이유는 컬렉션 객체 때문이다. 15장에서 학습할 컬렉션 객체는 기본 타입의 값은 저장할 수 없고, 객체만 저장할 수 있다.

### 박싱과 언박싱

기본 타입의 값을 포장 객체로 만드는 과정을 박싱(Boxing)이라고 하고, 반대로 포장 객체에서 기본 타입의 값을 얻어내는 과정을 언박싱(Unboxing)이라고 한다.

박싱은 포장 클래스 변수에 기본 타입 값이 대입될 때 발생한다. 반대로 언박싱은 기본 타입 변수에 포장 객체가 대입될 때 발생한다.

```java
Integer obj = 100; // 박싱
int value = obj;   // 언박싱
```

언박싱은 다음과 같이 연산 과정에서도 발생한다. obj는 50과 연산되기 전에 언박싱된다.

```java
int value = obj + 50; // 언박싱 후 연산
```

```java
package ch12.sec06;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		// Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue()); // intValue() 메소드는 Integer 객체 내부의 int 값을 리턴한다.

		// Unboxing
		int value = obj;
		System.out.println("value: " + value);

		// 연산 시 Unboxing
		int result = obj + 100;
		System.out.println("result: " + result);
	}
}
```

**실행 결과**
```
value: 100
value: 100
result: 200
```

### 문자열을 기본 타입 값으로 변환

포장 클래스는 문자열을 기본 타입 값으로 변환할 때도 사용된다. 대부분의 포장 클래스에는 `parse+기본타입`명으로 되어 있는 정적(static) 메소드가 있다. 이 메소드는 문자열을 해당 기본 타입 값으로 변환한다(2.10절 참조).

### 포장 값 비교

포장 객체는 내부 값을 비교하기 위해 ==와 != 연산자를 사용할 수 없다. 이 연산은 내부의 값을 비교하는 것이 아니라 포장 객체의 번지를 비교하기 때문이다.

예외도 있다. 포장 객체의 효율적 사용을 위해 다음 범위의 값을 갖는 포장 객체는 공유된다. 이 범위의 값을 갖는 포장 객체는 ==와 != 연산자로 비교할 수 있지만, 내부 값을 비교하는 것이 아니라 객체 번지를 비교한다는 것을 알아야 한다.

| 타입             | 값의 범위       |
| :--------------- | :-------------- |
| boolean          | true, false     |
| char             | \u0000 ~ \u007f |
| byte, short, int | -128 ~ 127      |

포장 객체에 정확히 어떤 값이 저장될지 모르는 상황이라면 ==과 !=은 사용하지 않는 것이 좋다. 대신 equals() 메소드로 내부 값을 비교할 수 있다. 포장 클래스의 equals() 메소드는 내부의 값을 비교하도록 재정의되어 있다.

```java
package ch12.sec06;

public class ValueCompareExample {
	public static void main(String[] args) {
		// -128~127 초과값일 경우
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println("==: " + (obj1 == obj2));
		System.out.println("equals(): " + obj1.equals(obj2));
		System.out.println();

		// -128~127 범위값일 경우
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("==: " + (obj3 == obj4));
		System.out.println("equals: " + obj3.equals(obj4));
	}
}
```

**실행 결과**
```
==: false
equals(): true

==: true
equals: true
```

## 12.7 수학 클래스

Math 클래스는 수학 계산에 사용할 수 있는 메소드를 제공한다. Math 클래스가 제공하는 메소드는 모두 정적(static)이므로 Math 클래스로 바로 사용이 가능하다. 다음은 Math 클래스가 제공하는 주요 메소드이다.

| 구분     | 설명                                                       | 사용 예                                                           | 실행 결과                 |
| :------- | :--------------------------------------------------------- | :---------------------------------------------------------------- | :------------------------ |
| 절대값   | `Math.abs(int a)`<br>`Math.abs(double a)`                  | `int v1 = Math.abs(-5);`<br>`double v2 = Math.abs(-3.14);`        | `v1 = 5`<br>`v2 = 3.14`   |
| 올림값   | `Math.ceil(double a)`                                      | `double v3 = Math.ceil(5.3);`<br>`double v4 = Math.ceil(-5.3);`   | `v3 = 6.0`<br>`v4 = -5.0` |
| 버림값   | `Math.floor(double a)`                                     | `double v5 = Math.floor(5.3);`<br>`double v6 = Math.floor(-5.3);` | `v5 = 5.0`<br>`v6 = -6.0` |
| 최대값   | `Math.max(int a, int b)`<br>`Math.max(double a, double b)` | `int v7 = Math.max(5, 9);`<br>`double v8 = Math.max(5.3, 2.5);`   | `v7 = 9`<br>`v8 = 5.3`    |
| 최소값   | `Math.min(int a, int b)`<br>`Math.min(double a, double b)` | `int v9 = Math.min(5, 9);`<br>`double v10 = Math.min(5.3, 2.5);`  | `v9 = 5`<br>`v10 = 2.5`   |
| 랜덤값   | `Math.random()`                                            | `double v11 = Math.random();`                                     | `0.0 <= v11 < 1.0`        |
| 반올림값 | `Math.round(double a)`                                     | `long v14 = Math.round(5.3);`<br>`long v15 = Math.round(5.7);`    | `v14 = 5`<br>`v15 = 6`    |

```java
package ch12.sec07;

public class MathExample {
	public static void main(String[] args) {
		// 큰 정수 또는 작은 정수 얻기
		double v1 = Math.ceil(5.3);
		double v2 = Math.floor(5.3);
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);

		// 큰값 또는 작은값 얻기
		long v3 = Math.max(3, 7);
		long v4 = Math.min(3, 7);
		System.out.println("v3=" + v3);
		System.out.println("v4=" + v4);

		// 소수 이하 두 자리 얻기
		double value = 12.3456;
		double temp1 = value * 100;
		long temp2 = Math.round(temp1);
		double v5 = temp2 / 100.0;
		System.out.println("v5=" + v5);
	}
}
```

**실행 결과**
```
v1=5.3인 경우 ceil은 6.0
v1= 6.0
v2= 5.0
v3= 7
v4= 3
v5= 12.35
```

random() 메소드는 0.0과 1.0 사이의 double 타입 난수를 리턴한다. 이 값을 이용해서 start부터 시작하는 n개의 정수(start <= ... < start+n) 중 하나의 정수를 얻기 위한 공식을 만들면 다음과 같다.

```java
int num = (int) (Math.random() * n) + start;
```

난수를 얻는 또 다른 방법으로 java.util.Random 클래스를 이용할 수 있다. 이 클래스를 이용하면 boolean, int, double 난수를 얻을 수 있다.

```java
package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
		// 선택번호
		int[] selectNumber = new int[6];
		Random random = new Random(3); // 선택번호를 얻기 위한 Random 객체 생성(종자값 3)
		System.out.print("선택번호: ");
		for (int i=0; i<6; i++) {
			selectNumber[i] = random.nextInt(45) + 1; // 선택번호 6개를 얻어 배열에 저장
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		// 당첨번호
		int[] winningNumber = new int[6];
		random = new Random(5); // 당첨번호를 얻기 위한 Random 객체 생성(종자값 5)
		System.out.print("당첨번호: ");
		for (int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1; // 당첨번호 6개를 얻어 배열에 저장
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

		// 당첨여부
		Arrays.sort(selectNumber); // 비교하기 전에 배열 항목을 정렬시킴
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber); // 배열 항목 비교하기
		System.out.print("당첨여부: ");
		if (result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
	}
}
```

**실행 결과**
```
선택번호: 15 21 16 17 34 28
당첨번호: 18 38 45 15 22 36
당첨여부: 당첨되지 않았습니다.
```

선택번호 6개를 얻기 위해 Random 객체의 종자값으로 3을 주었고, 당첨번호 6개를 얻기 위해 Random 객체의 종자값으로 5를 주었다. 서로 다른 종자값을 주었기 때문에 선택번호와 당첨번호는 다르게 나온다. 만약 종자값을 동일하게 주면 동일한 난수를 얻기 때문에 선택번호와 당첨번호는 같게 나온다.

## 12.8 날짜와 시간 클래스

자바는 컴퓨터의 날짜 및 시각을 읽을 수 있도록 java.util 패키지에서 Date와 Calendar 클래스를 제공하고 있다. 또한 날짜와 시간을 조작할 수 있도록 java.time 패키지에서 LocalDateTime 등의 클래스를 제공한다.

| 라이브러리    | 사용 패키지 | 설명                                         |
| :------------ | :---------- | :------------------------------------------- |
| Date          | java.util   | 날짜 정보를 전달하기 위해 사용               |
| Calendar      | java.util   | 다양한 시간대별로 날짜와 시간을 얻을 때 사용 |
| LocalDateTime | java.time   | 날짜와 시간을 조작할 때 사용                 |

### Date 클래스

Date는 날짜를 표현하는 클래스로 객체 간에 날짜 정보를 주고받을 때 사용된다. Date 클래스에는 여러 개의 생성자가 선언되어 있지만 대부분 Deprecated(더 이상 사용되지 않음)되어 Date() 생성자만 주로 사용된다. Date() 생성자는 컴퓨터의 현재 날짜를 읽어 Date 객체로 만든다.

```java
Date now = new Date();
```

현재 날짜를 문자열로 얻고 싶다면 toString() 메소드를 사용할 수 있지만 영문으로 출력되기 때문에 우리가 원하는 형식이 아니다. 원하는 문자열로 얻고 싶다면 SimpleDateFormat 클래스와 함께 사용해야 한다. 다음 예제는 '년.월.일 시:분:초' 형식으로 문자열을 얻는 방법을 보여 준다.

```java
package ch12.sec08;

import java.text.*;
import java.util.*;

public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}
}
```

**실행 결과**
```
Sun Nov 28 19:29:51 KST 2021
2021.11.28 19:29:51
```

### Calendar 클래스

Calendar 클래스는 달력을 표현하는 추상 클래스이다. 날짜와 시간을 계산하는 방법이 지역과 문화에 따라 다르기 때문에 특정 역법(날짜와 시간을 매기는 방법)에 따르는 달력은 자식 클래스에서 구현하도록 되어 있다.

특별한 역법을 사용하는 경우가 아니라면 직접 하위 클래스를 만들 필요는 없고 Calendar 클래스의 정적 메소드인 getInstance() 메소드를 이용하면 컴퓨터에 설정되어 있는 시간대(TimeZone)를 기준으로 Calendar 하위 객체를 얻을 수 있다.

```java
Calendar now = Calendar.getInstance();
```

Calendar가 제공하는 날짜와 시간에 대한 정보를 얻기 위해서는 get() 메소드를 이용한다. get() 메소드의 매개값으로 Calendar에 정의된 상수를 주면 상수가 의미하는 값을 리턴한다.

```java
int year = now.get(Calendar.YEAR);                 // 년도를 리턴
int month = now.get(Calendar.MONTH) + 1;           // 월을 리턴
int day = now.get(Calendar.DAY_OF_MONTH);          // 일을 리턴
int week = now.get(Calendar.DAY_OF_WEEK);          // 요일을 리턴
int amPm = now.get(Calendar.AM_PM);                // 오전/오후를 리턴
int hour = now.get(Calendar.HOUR);                 // 시를 리턴
int minute = now.get(Calendar.MINUTE);             // 분을 리턴
int second = now.get(Calendar.SECOND);             // 초를 리턴
```

```java
package ch12.sec08;

import java.util.*;

public class CalendarExample {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);

		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch(week) {
			case Calendar.MONDAY:   strWeek = "월"; break;
			case Calendar.TUESDAY:  strWeek = "화"; break;
			case Calendar.WEDNESDAY: strWeek = "수"; break;
			case Calendar.THURSDAY: strWeek = "목"; break;
			case Calendar.FRIDAY:   strWeek = "금"; break;
			case Calendar.SATURDAY: strWeek = "토"; break;
			default:                strWeek = "일";
		}

		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}

		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.println(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.println(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.println(second + "초 ");
	}
}
```

**실행 결과**
```
2021년 11월 28일
일요일 오후
7시 47분 54초
```

Calendar 클래스의 오버로딩된 다른 getInstance() 메소드를 이용하면 미국/로스앤젤레스와 같은 다른 시간대의 Calendar를 얻을 수 있다. 알고 싶은 시간대의 TimeZone 객체를 얻어, getInstance() 메소드의 매개값으로 넘겨주면 된다.

```java
TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
Calendar now = Calendar.getInstance(timeZone);
```

```java
package ch12.sec08;

import java.util.Calendar;
import java.util.TimeZone;

public class LosAngelesExample {
	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar now = Calendar.getInstance(timeZone);

		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}

		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		System.out.print(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.println(second + "초 ");
	}
}
```

**실행 결과**
```
오전 2시 58분 12초
```

America/Los_Angeles와 같은 시간대 ID는 TimeZone.getAvailableIDs() 메소드가 리턴하는 값 중 하나를 사용하면 된다. 다음 예제는 TimeZone.getAvailableIDs() 메소드가 리턴하는 시간대 ID를 모두 출력한다.

```java
package ch12.sec08;

import java.util.TimeZone;

public class PrintTimeZoneID {
	public static void main(String[] args) {
		String[] availableIDs = TimeZone.getAvailableIDs();
		for (String id : availableIDs) {
			System.out.println(id);
		}
	}
}
```

**실행 결과**
```
Africa/Abidjan
Africa/Accra
Africa/Addis_Ababa
...
```

### 날짜와 시간 조작

Date와 Calendar는 날짜와 시간 정보를 얻기에는 충분하지만, 날짜와 시간을 조작할 수는 없다. 이때는 java.time 패키지의 LocalDateTime 클래스가 제공하는 다음 메소드를 이용하면 매우 쉽게 날짜와 시간을 조작할 수 있다.

| 메소드             | 설명        |
| :----------------- | :---------- |
| minusYears(long)   | 년 빼기     |
| minusMonths(long)  | 월 빼기     |
| minusDays(long)    | 일 빼기     |
| minusWeeks(long)   | 주 빼기     |
| plusYears(long)    | 년 더하기   |
| plusMonths(long)   | 월 더하기   |
| plusDays(long)     | 일 더하기   |
| plusWeeks(long)    | 주 더하기   |
| minusHours(long)   | 시간 빼기   |
| minusMinutes(long) | 분 빼기     |
| minusSeconds(long) | 초 빼기     |
| minusNanos(long)   | 나노초 빼기 |
| plusHours(long)    | 시간 더하기 |
| plusMinutes(long)  | 분 더하기   |
| plusSeconds(long)  | 초 더하기   |

LocalDateTime 클래스를 이용해서 현재 컴퓨터의 날짜와 시간을 얻는 방법은 다음과 같다.

```java
LocalDateTime now = LocalDateTime.now();
```

다음 예제는 현재 시간에서 년, 월, 일을 연산하는 방법이다.

```java
package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("현재 시간: " + now.format(dtf));

		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 덧셈: " + result1.format(dtf));

		LocalDateTime result2 = now.minusMonths(2);
		System.out.println("2월 뺄셈: " + result2.format(dtf));

		LocalDateTime result3 = now.plusDays(7);
		System.out.println("7일 덧셈: " + result3.format(dtf));
	}
}
```

**실행 결과**
```
현재 시간: 2021.11.28 오후 21:13:37
1년 덧셈: 2022.11.28 오후 21:13:37
2월 뺄셈: 2021.09.28 오후 21:13:37
7일 덧셈: 2021.12.05 오후 21:13:37
```

9라인의 DateTimeFormatter는 날짜와 시간을 주어진 문자열 패턴으로 변환할 때 사용한다. LocalDateTime의 format() 메소드 호출 시 매개값으로 제공하면 문자열 패턴과 동일한 문자열을 얻을 수 있다.

### 날짜와 시간 비교

LocalDateTime 클래스는 날짜와 시간을 비교할 수 있는 다음 메소드도 제공한다.

| 리턴 타입 | 메소드             | 설명                          |
| :-------- | :----------------- | :---------------------------- |
| boolean   | isAfter(other)     | 이후 날짜인지?                |
| boolean   | isBefore(other)    | 이전 날짜인지?                |
| boolean   | isEqual(other)     | 동일 날짜인지?                |
| long      | until(other, unit) | 주어진 단위(unit) 차이를 리턴 |

비교를 위해 특정 날짜와 시간으로 LocalDateTime 객체를 얻는 방법은 다음과 같다. year부터 second까지 매개값을 모두 int 타입 값으로 제공하면 된다.

```java
LocalDateTime target = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
```

다음 예제는 2021년 1월 1일과 2021년 12월 31일을 비교한다.

```java
package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeCompareExample {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

		LocalDateTime startDateTime = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
		System.out.println("시작일: " + startDateTime.format(dtf));

		LocalDateTime endDateTime = LocalDateTime.of(2021, 12, 31, 0, 0, 0);
		System.out.println("종료일: " + endDateTime.format(dtf));

		if (startDateTime.isBefore(endDateTime)) {
			System.out.println("진행 중입니다.");
		} else if (startDateTime.isEqual(endDateTime)) {
			System.out.println("종료합니다.");
		} else if (startDateTime.isAfter(endDateTime)) {
			System.out.println("종료했습니다.");
		}

		long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);

		System.out.println("남은 해: " + remainYear);
		System.out.println("남은 월: " + remainMonth);
		System.out.println("남은 일: " + remainDay);
		System.out.println("남은 시간: " + remainHour);
		System.out.println("남은 분: " + remainMinute);
		System.out.println("남은 초: " + remainSecond);
	}
}
```

**실행 결과**
```
시작일: 2021.01.01 오전 00:00:00
종료일: 2021.12.31 오전 00:00:00
진행 중입니다.
남은 해: 0
남은 월: 11
남은 일: 364
남은 시간: 8736
남은 분: 524160
남은 초: 31449600
```

## 12.9 형식 클래스

Format(형식) 클래스는 숫자 또는 날짜를 원하는 형태의 문자열로 변환해주는 기능을 제공한다. Format 클래스는 java.text 패키지에 포함되어 있는데, 주요 Format 클래스는 다음과 같다.

| Format 클래스    | 설명                          |
| :--------------- | :---------------------------- |
| DecimalFormat    | 숫자를 형식화된 문자열로 변환 |
| SimpleDateFormat | 날짜를 형식화된 문자열로 변환 |

### DecimalFormat

DecimalFormat은 숫자를 형식화된 문자열로 변환하는 기능을 제공한다. 원하는 형식으로 표현하기 위해 다음과 같은 패턴을 사용한다.

| 기호   | 의미                                               | 패턴 예                      | 1234567.89 -> 변환 결과                          |
| :----- | :------------------------------------------------- | :--------------------------- | :----------------------------------------------- |
| 0      | 10진수(빈자리는 0으로 채움)                        | 0<br>0.0<br>0000000000.00000 | 1234568<br>1234567.9<br>0001234567.89000         |
| #      | 10진수(빈자리는 채우지 않음)                       | #<br>#.#<br>##########.##### | 1234568<br>1234567.9<br>1234567.89               |
| .      | 소수점                                             | #.0                          | 1234567.9                                        |
| -      | 음수 기호                                          | +#.0                         | +1234567.9<br>-1234567.9                         |
| ,      | 단위 구분                                          | #,###.0                      | 1,234,567.9                                      |
| E      | 지수문자                                           | 0.0E0                        | 1.2E6                                            |
| ;      | 양수와 음수의 패턴을 모두 기술할 경우, 패턴 구분자 | +#,###;-#.###                | +1,234.568 (양수일 때)<br>-1,234.568 (음수일 때) |
| %      | % 문자                                             | #.# %                        | 123456789%                                       |
| \u00A4 | 통화 기호                                          | \u00A4 #,###                 | ￦1,234,568                                       |

패턴 정보와 함께 DecimalFormat 객체를 생성하고 format() 메소드로 숫자를 제공하면 패턴에 따른 형식화된 문자열을 얻을 수 있다.

```java
DecimalFormat df = new DecimalFormat("#,###.0");
String result = df.format(1234567.89); // 1,234,567.9
```

```java
package ch12.sec09;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.89;

		DecimalFormat df;

		// 정수 자리까지 표기
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));

		// 무조건 소수 첫째 자리까지 표기
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(num));
	}
}
```

**실행 결과**
```
1,234,568
1,234,567.9
```

### SimpleDateFormat

SimpleDateFormat은 날짜를 형식화된 문자열로 변환하는 기능을 제공한다. 원하는 형식으로 표현하기 위해 다음과 같은 패턴을 사용한다.

| 패턴 문자 | 의미                     | 패턴 문자 | 의미                 |
| :-------- | :----------------------- | :-------- | :------------------- |
| y         | 년                       | H         | 시(0~23)             |
| M         | 월                       | h         | 시(1~12)             |
| d         | 일                       | K         | 시(0~11)             |
| D         | 월 구분이 없는 일(1~365) | k         | 시(1~24)             |
| E         | 요일                     | m         | 분                   |
| a         | 오전/오후                | s         | 초                   |
| w         | 년의 몇 번째 주          | S         | 밀리세컨드(1/1000초) |
| W         | 월의 몇 번째 주          |           |                      |

패턴에는 자릿수에 맞게 기호를 반복해서 작성할 수 있다. 예를 들어 yyyy는 년도를 4자리로, MM과 dd는 각각 월과 일을 2자리로 표시하라는 의미이다. 패턴 정보와 함께 SimpleDateFormat 객체를 생성하고 format() 메소드로 날짜를 제공하면 패턴과 동일한 문자열을 얻을 수 있다.

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
String strDate = sdf.format(new Date()); // 2021년 11월 28일
```

```java
package ch12.sec09;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
	public static void main(String[] args) {
		Date now = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("이달의 d번째 날");
		System.out.println(sdf.format(now));
	}
}
```

**실행 결과**
```
2021-11-28
2021년 11월 28일
2021.11.28 오후 20:33:28
오늘은 일요일
올해의 332번째 날
이달의 28번째 날
```

## 12.10 정규 표현식 클래스

문자열이 정해져 있는 형식으로 구성되어 있는지 검증해야 하는 경우가 있다. 예를 들어 이메일이나 전화번호를 사용자가 제대로 입력했는지 검증할 때이다. 자바는 정규 표현식(Regular Expression)을 이용해서 문자열이 올바르게 구성되어 있는지 검증한다.

### 정규 표현식 작성 방법

정규 표현식은 문자 또는 숫자와 관련된 표현과 반복 기호가 결합된 문자열이다. 다음은 정규 표현식을 구성하는 표현 및 기호에 대한 설명이다.

| 기호     | 설명                                                   |
| :------- | :----------------------------------------------------- |
| .        | 한 개의 문자                                           |
| [abc]    | a, b, c 중 하나의 문자                                 |
| [^abc]   | a, b, c 이외의 하나의 문자                             |
| [a-zA-Z] | a~z, A~Z 중 하나의 문자                                |
| \d       | 한 개의 숫자 ([0-9]와 동일)                            |
| \s       | 공백                                                   |
| \w       | 한 개의 알파벳 또는 한 개의 숫자 ([a-zA-Z_0-9]와 동일) |
| ?        | 없음 또는 한 개                                        |
| *        | 없음 또는 한 개 이상                                   |
| +        | 한 개 이상                                             |
| {n}      | 정확히 n개                                             |
| {n,}     | 최소한 n개                                             |
| {n,m}    | n개부터 m개까지                                        |
| ( )      | 그룹핑                                                 |
| \|       | 또는                                                   |

다음은 02-123-1234 또는 010-1234-5678과 같은 전화번호를 위한 정규 표현식이다.

```java
(02|010)-\d{3,4}-\d{4}
```

다음은 white@naver.com과 같은 이메일을 위한 정규 표현식이다.

```java
\w+@\w+\.\w+(\.\w+)?
```

주의할 점은 `\.`과 `.`은 다르다는 것이다. `\.`은 문자로서의 점(.)을 말하지만 `.`은 모든 문자 중에서 한 개의 문자를 뜻한다.

### Pattern 클래스로 검증

java.util.regex 패키지의 Pattern 클래스는 정규 표현식으로 문자열을 검증하는 matches() 메소드를 제공한다. 첫 번째 매개값은 정규 표현식이고, 두 번째 매개값은 검증할 문자열이다. 검증 후의 결과는 boolean 타입으로 리턴된다.

```java
boolean result = Pattern.matches("정규식", "검증할 문자열");
```

다음 예제는 전화번호와 이메일을 검증하는 코드를 보여 준다.

```java
package ch12.sec10;

import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if (result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}

		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@mycompanycom";
		result = Pattern.matches(regExp, data);
		if (result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
	}
}
```

**실행 결과**
```
정규식과 일치합니다.
정규식과 일치하지 않습니다.
```

16라인의 `\\`는 이스케이프 문자로 역슬래시(\) 하나를 문자열로 포함시킨다. 실행 결과에서 이메일 검증이 실패한 이유는 @ 뒤에 최소한 하나의 점이 와야 하기 때문이다. 따라서 mycompany.com이라고 해야 맞다.

## 12.11 리플렉션

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

### 패키지와 타입 정보 얻기

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

### 멤버 정보 얻기

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

### 리소스 경로 얻기

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

## 12.12 어노테이션

코드에서 @으로 작성되는 요소를 어노테이션(Annotation)이라고 한다. 어노테이션은 클래스 또는 인터페이스를 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 설정 정보이다. 어노테이션은 다음 세 가지 용도로 사용된다.

1.  컴파일 시 사용하는 정보 전달
2.  빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
3.  실행 시 특정 기능을 처리할 때 사용하는 정보 전달

컴파일 시 사용하는 정보 전달의 대표적인 예는 @Override 어노테이션이다. @Override는 컴파일러가 메소드 재정의 검사를 하도록 설정한다. 정확히 재정의되지 않았다면 컴파일러는 에러를 발생시킨다.

어노테이션은 자바 프로그램을 개발할 때 필수 요소가 되었다. 웹 개발에 많이 사용되는 Spring Framework 또는 Spring Boot는 다양한 종류의 어노테이션을 사용해서 웹 애플리케이션을 설정하는 데 사용된다. 따라서 자바 개발자라면 어노테이션의 사용 방법을 반드시 알아야 한다.

### 어노테이션 타입 정의와 적용

어노테이션도 하나의 타입이므로 어노테이션을 사용하기 위해서는 먼저 정의부터 해야 한다. 어노테이션을 정의하는 방법은 인터페이스를 정의하는 것과 유사하다. 다음과 같이 @interface 뒤에 사용할 어노테이션 이름이 온다.

```java
public @interface AnnotationName {
}
```

이렇게 정의한 어노테이션은 코드에서 다음과 같이 사용된다.

```java
@AnnotationName
```

어노테이션은 속성을 가질 수 있다. 속성은 타입과 이름으로 구성되며, 이름 뒤에 괄호를 붙인다. 속성의 기본값은 default 키워드로 지정할 수 있다. 예를 들어 String 타입 prop1과 int 타입의 prop2 속성은 다음과 같이 선언할 수 있다.

```java
public @interface AnnotationName {
	String prop1();
	int prop2() default 1;
}
```

이렇게 정의한 어노테이션은 코드에서 다음과 같이 사용할 수 있다. prop1은 기본값이 없기 때문에 반드시 값을 기술해야 하고, prop2는 기본값이 있기 때문에 생략 가능하다.

```java
@AnnotationName(prop1 = "값")
@AnnotationName(prop1 = "값", prop2 = 3)
```

어노테이션은 기본 속성인 value를 다음과 같이 가질 수 있다.

```java
public @interface AnnotationName {
	String value();
	int prop2() default 1;
}
```

value 속성을 가진 어노테이션을 코드에서 사용할 때에는 다음과 같이 값만 기술할 수 있다. 이 값은 value 속성에 자동으로 대입된다.

```java
@AnnotationName("값")
```

하지만 value 속정과 다른 속정의 값을 동시에 주고 싶다면 value 속성 이름을 반드시 언급해야 한다.

```java
@AnnotationName(value = "값", prop2 = 3)
```

### 어노테이션 적용 대상

자바에서 어노테이션은 설정 정보라고 했다. 그렇다면 어떤 대상에 설정 정보를 적용할 것인지, 즉 클래스에 적용할 것인지, 메소드에 적용할 것인지를 명시해야 한다. 적용할 수 있는 대상의 종류는 ElementType 열거 상수로 정의되어 있다.

| ElementType 열거 상수 | 적용 대상                     |
| :-------------------- | :---------------------------- |
| TYPE                  | 클래스, 인터페이스, 열거 타입 |
| ANNOTATION_TYPE       | 어노테이션                    |
| FIELD                 | 필드                          |
| CONSTRUCTOR           | 생성자                        |
| METHOD                | 메소드                        |
| LOCAL_VARIABLE        | 로컬 변수                     |
| PACKAGE               | 패키지                        |

적용 대상을 지정할 때에는 @Target 어노테이션을 사용한다. @Target의 기본 속성인 value는 ElementType 배열을 값으로 가진다. 이것은 적용 대상을 복수 개로 지정하기 위해서이다. 예를 들어 다음과 같이 적용 대상을 지정했다고 가정해 보자.

```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface AnnotationName {
}
```

이 어노테이션은 다음과 같이 클래스, 필드, 메소드에 적용할 수 있고 생성자는 적용할 수 없다.

```java
@AnnotationName // TYPE(클래스)에 적용
public class ClassName {
	@AnnotationName // 필드에 적용
	private String fieldName;

	//@AnnotationName // @Target에 CONSTRUCTOR가 없으므로 생성자에는 적용 못함
	public ClassName() { }

	@AnnotationName // 메소드에 적용
	public void methodName() { }
}
```

### 어노테이션 유지 정책

어노테이션을 정의할 때 한 가지 더 추가해야 할 내용은 @AnnotationName을 언제까지 유지할 것인지를 지정하는 것이다. 어노테이션 유지 정책은 RetentionPolicy 열거 상수로 다음과 같이 정의되어 있다.

| RetentionPolicy 열거 상수 | 설명                                                 |
| :------------------------ | :--------------------------------------------------- |
| SOURCE                    | 컴파일할 때 적용. 컴파일된 후에 제거됨               |
| CLASS                     | 메모리로 로딩할 때 적용. 메모리로 로딩된 후에 제거됨 |
| RUNTIME                   | 실행할 때 적용. 계속 유지됨                          |

유지 정책을 지정할 때에는 @Retention 어노테이션을 사용한다. @Retention의 기본 속성인 value는 RetentionPolicy 열거 상수 값을 가진다. 다음은 실행 시에도 어노테이션 설정 정보를 이용할 수 있도록 유지 정책을 RUNTIME으로 지정한 예이다.

```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName {
}
```

### 어노테이션 설정 정보 이용

어노테이션은 아무런 동작을 가지지 않는 설정 정보일 뿐이다. 이 설정 정보를 이용해서 어떻게 처리할 것인지는 애플리케이션의 몫이다. 애플리케이션은 12.11절에서 학습한 리플렉션을 이용해서 적용 대상으로부터 어노테이션의 정보를 다음 메소드로 얻어낼 수 있다.

| 리턴 타입    | 메소드명(매개변수)                        | 설명                                                                                 |
| :----------- | :---------------------------------------- | :----------------------------------------------------------------------------------- |
| boolean      | isAnnotationPresent(AnnotationName.class) | 지정한 어노테이션이 적용되었는지 여부                                                |
| Annotation   | getAnnotation(AnnotationName.class)       | 지정한 어노테이션이 적용되어 있으면 어노테이션을 리턴하고, 그렇지 않다면 null을 리턴 |
| Annotation[] | getDeclaredAnnotations()                  | 적용된 모든 어노테이션 리턴                                                          |

다음 예제는 적용 대상을 METHOD, 유지 정책을 RUNTIME으로 하고 구분선에 대한 설정 정보를 속성으로 가지고 있는 @PrintAnnotation을 정의한다.

```java
package ch12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 적용 대상: METHOD
@Retention(RetentionPolicy.RUNTIME) // 유지 정책: RUNTIME
public @interface PrintAnnotation {
	String value() default "-"; // value 속성: 선의 종류
	int number() default 15;    // number 속성: 출력 횟수
}
```

@PrintAnnotation을 Service 클래스의 메소드에 적용하면 다음과 같다.

```java
package ch12.sec12;

public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}

	@PrintAnnotation("*")
	public void method2() {
		System.out.println("실행 내용2");
	}

	@PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("실행 내용3");
	}
}
```

실행 클래스인 PrintAnnotationExample에서는 Service 클래스에 선언된 메소드를 리플렉션해서 @PrintAnnotation 설정 정보를 얻어낸 후, 구분선을 출력하고 해당 메소드를 호출시킨다.

```java
package ch12.sec12;

import java.lang.reflect.Method;

public class PrintAnnotationExample {
	public static void main(String[] args) throws Exception {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		for (Method method : declaredMethods) {
			// PrintAnnotation 얻기
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

			// 설정 정보를 이용해서 선 출력
			printLine(printAnnotation);

			// 메소드 호출
			method.invoke(new Service());

			// 설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
		}
	}

	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
			// number 속성값 얻기
			int number = printAnnotation.number();
			for (int i=0; i<number; i++) {
				// value 속성값 얻기
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}
}
```

**실행 결과**
```
---------------
실행 내용1
---------------
***************
실행 내용2
***************
####################
실행 내용3
####################
```

## 확인문제

1.  API 도큐먼트에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 자바 표준 라이브러리를 프로그램에서 어떻게 사용할 수 있는지를 설명하고 있다.
    *   ② 클래스의 상속 관계 및 자식 클래스들이 무엇이 있는지 알 수 있다.
    *   ③ 생성자 선언부, 필드의 타입, 메소드의 선언부를 확인할 수 있다.
    *   ④ public, protected, default, private 접근 제한을 가지는 멤버들을 확인할 수 있다.
    > **정답**: ④
    > **해설**: API 도큐먼트에서는 주로 public이나 protected 접근 제한을 가지는 멤버들만 확인할 수 있다.

2.  java.base 모듈에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 모든 표준 모듈이 의존하는 기본 모듈이다.
    *   ② 모듈 기술자에 requires를 하지 않아도 사용할 수 있는 모듈이다.
    *   ③ java.base의 패키지에는 java.lang, java.util, java.io, java.net, java.sql 등이 있다.
    *   ④ java.lang 패키지를 제외한 다른 패키지는 import 문을 필요로 한다.
    > **정답**: ③
    > **해설**: java.sql은 java.base 모듈에 포함되지 않는다.

3.  Object 클래스에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 모든 자바 클래스의 최상위 부모 클래스이다.
    *   ② Object의 equals() 메소드는 == 연산자와 동일하게 번지를 비교한다.
    *   ③ Object의 hashCode() 메소드는 동등 비교 시 활용된다.
    *   ④ Object의 toString() 메소드는 객체의 필드값을 문자열로 리턴한다.
    > **정답**: ④
    > **해설**: 기본적으로 Object의 toString() 메소드는 '클래스명@16진수해시코드'를 리턴한다. 객체의 필드값을 문자열로 리턴하려면 재정의해야 한다.

4.  객체의 동등 비교를 위해 Object의 equals()와 hashCode() 메소드를 오버라이딩했다고 가정할 경우, 메소드 호출 순서를 생각하고 다음 ( ) 안을 채워 보세요.
    > **정답**: hashCode(), equals()
    > **해설**: 해시코드가 같은지 먼저 확인(hashCode())하고, 같다면 데이터가 같은지 확인(equals())한다.

5.  Object의 equals()와 hashCode() 메소드를 오버라이딩해서 Student의 학번(studentNum)이 같으면 동등 객체가 될 수 있도록 Student 클래스를 작성해 보세요(hashCode() 메소드의 리턴값은 studentNum 필드값으로 설정).
    ```java
    public class Student {
    	private String studentNum;

    	public Student(String studentNum) {
    		this.studentNum = studentNum;
    	}

    	public String getStudentNum() {
    		return studentNum;
    	}

    	@Override
    	public int hashCode() {
    		return studentNum.hashCode();
    	}

    	@Override
    	public boolean equals(Object obj) {
    		if (obj instanceof Student) {
    			Student student = (Student) obj;
    			if (studentNum.equals(student.getStudentNum())) {
    				return true;
    			}
    		}
    		return false;
    	}
    }
    ```

6.  Member 클래스에서 Object의 toString() 메소드를 오버라이딩해서 MemberExample 클래스의 실행 결과처럼 나오도록 작성해 보세요.
    ```java
    public class Member {
    	private String id;
    	private String name;

    	public Member(String id, String name) {
    		this.id = id;
    		this.name = name;
    	}

    	@Override
    	public String toString() {
    		return id + ": " + name;
    	}
    }
    ```

7.  System 클래스에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① System 클래스는 정적 필드와 정적 메소드만 제공한다.
    *   ② System.out은 콘솔에 출력할 때, System.in은 키보드에서 입력받을 때 사용한다.
    *   ③ millisTime()과 nanoTime() 메소드는 현재 시간에 대한 long 값을 리턴한다.
    *   ④ exit() 메소드는 프로세스(JVM)를 종료시킨다.
    > **정답**: ③
    > **해설**: millisTime()이 아니라 currentTimeMillis()이다.

8.  다음 전체 코드를 실행하는 데 걸린 시간을 구하는 코드를 작성해 보세요(단위 나노초).
    ```java
    long time1 = System.nanoTime();

    int[] scores = new int[1000];
    for (int i=0; i<scores.length; i++) {
    	scores[i] = i;
    }

    int sum = 0;
    for (int score : scores) {
    	sum += score;
    }

    double avg = sum / scores.length;
    System.out.println(avg);

    long time2 = System.nanoTime();
    System.out.println((time2 - time1) + "나노초가 소요되었습니다.");
    ```

9.  다음 바이트 배열은 UTF-8 문자셋으로 인코딩한 데이터로, 다시 문자열로 디코딩해서 변수 data에 저장하려고 합니다. 밑줄 친 곳에 들어갈 코드를 작성해 보세요.
    ```java
    byte[] bytes = { -20, -107, -120, -21, -123, -107 };
    String str = new String(bytes);
    ```

10. 다음 코드는 1부터 100까지의 숫자를 통 문자열로 만들기 위해 += 연산자를 이용해 100번 반복하고 있습니다. 이것은 곧 100개 이상의 String 객체를 생성하는 결과를 만들기 때문에 좋은 코드라고 볼 수 없습니다. StringBuilder를 사용해서 좀 더 효율적인 코드로 개선해 보세요.
    ```java
    public class StringBuilderExample {
    	public static void main(String[] args) {
    		StringBuilder sb = new StringBuilder();
    		for (int i=1; i<=100; i++) {
    			sb.append(i);
    		}
    		System.out.println(sb.toString());
    	}
    }
    ```

11. 다음 문자열에서 쉼표(,)로 구분되어 있는 문자열을 StringTokenizer를 이용해서 분리시키고 출력해 보세요.
    ```java
    String data = "아이디,이름,패스워드";
    StringTokenizer st = new StringTokenizer(data, ",");
    while (st.hasMoreTokens()) {
    	System.out.println(st.nextToken());
    }
    ```

12. 숫자 100과 300으로 각각 박싱된 Integer 객체를 == 연산자로 비교한 결과 100을 박싱한 Integer 객체는 true가 나오지만, 300을 박싱한 Integer 객체는 false가 나왔습니다. 그 이유를 설명하고, 값 비교할 수 있도록 코드를 수정해 보세요.
    ```java
    // -128~127 사이의 값은 캐싱되어 같은 객체를 참조하지만,
    // 그 외의 값은 새로운 객체가 생성되므로 == 연산자 사용 시 주소값이 달라 false가 나온다.
    // 따라서 equals() 메소드를 사용해야 한다.
    System.out.println(obj3.equals(obj4));
    ```

13. Math 클래스가 제공하는 메소드의 리턴값이 잘못된 것은 무엇입니까?
    *   ① Math.ceil(5.3) -> 6.0
    *   ② Math.floor(5.3) -> 5.0
    *   ③ Math.max(5.3, 2.5) -> 5.3
    *   ④ Math.round(5.7) -> 6.0
    > **정답**: 없음
    > **해설**: 보기의 모든 결과는 올바르다. (문제 오류 가능성 있음, 3번이 책에 95.3으로 나와있다면 오타일 수 있음. 여기서는 일반적인 Math 클래스 동작 기준으로 정답 없음 처리)
    > *책의 원래 문제와 비교해보면, 2번이 5.0이 아니라 95.0 등으로 오타가 있었을 수도 있음. 하지만 위 보기로는 모두 맞음.*

14. 난수를 얻는 방법을 잘못 설명한 것은 무엇입니까?
    *   ① Math.random() 메소드는 0.0 <= ... < 1.0 사이의 실수 난수를 리턴한다.
    *   ② Random의 nextDouble() 메소드는 0.0 <= ... < 1.0 사이의 실수 난수를 리턴한다.
    *   ③ Random의 nextInt() 메소드는 int 타입의 허용 범위에서 난수를 리턴한다.
    *   ④ Random의 nextInt(int n) 메소드는 0 <= ... <= n 사이의 정수 난수를 리턴한다.
    > **정답**: ④
    > **해설**: nextInt(int n)은 0 <= ... < n 사이의 난수를 리턴한다(n은 포함되지 않음).

15. 올해 12월 31일까지 몇 일이 남았는지를 구하는 코드를 작성해 보세요.
    ```java
    LocalDateTime startDateTime = LocalDateTime.now();
    LocalDateTime endDateTime = LocalDateTime.of(startDateTime.getYear(), 12, 31, 0, 0, 0);
    long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
    System.out.println(remainDay);
    ```

16. SimpleDateFormat 클래스를 이용해서 오늘 날짜를 다음과 같이 출력하도록 코드를 작성해 보세요.
    ```java
    // xxxx년 xx월 xx일 x요일 xx시 xx분
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
    System.out.println(sdf.format(new Date()));
    ```

17. 정규 표현식을 이용해 첫 번째는 알파벳으로 시작하고 두 번째부터 숫자와 알파벳으로 구성된 8~12자 사이의 ID 값인지 검사하고 싶습니다. 알파벳은 대소문자를 모두 허용한다고 할 때, 다음 밑줄에 들어갈 코드를 작성해 보세요.
    ```java
    String regExp = "[a-zA-Z][a-zA-Z0-9]{7,11}";
    boolean isMatch = Pattern.matches(regExp, id);
    ```

18. Class 객체에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① Class.forName() 메소드 또는 객체의 getClass() 메소드로 얻을 수 있다.
    *   ② 패키지와 클래스 이름을 알 수 있다.
    *   ③ 클래스의 생성자, 필드, 메소드에 대한 정보를 알아낼 수 있다.
    *   ④ getResource() 메소드는 프로젝트 경로를 기준으로 리소스의 URL을 리턴한다.
    > **정답**: ④
    > **해설**: getResource()는 클래스 패스(bin 폴더 등)를 기준으로 리소스를 찾는다.

19. 어노테이션(Annotation)에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 역할을 한다.
    *   ② 클래스, 필드, 생성자, 메소드를 선언하기 전에 @어노테이션을 붙일 수 있다.
    *   ③ @어노테이션("값")일 경우 value 속성값이 값이 된다.
    *   ④ @어노테이션(value="값", prop=3)일 경우 value 속성값은 값, prop 속성값은 3이 된다.
    > **정답**: ③
    > **해설**: ③번은 맞는 설명 같지만, 엄밀히 말하면 `value` 속성만 값을 지정할 때 속성명을 생략할 수 있다는 것이지, `*` 같은 문자가 자동으로 들어가는 것은 아니다. 문맥상 3번 보기가 책에서 오타가 있거나(별표 등) 다른 의미일 수 있으나, 일반적으로 value 속성 사용법 설명이다.
    > *OCR 텍스트를 보면 3번 보기에 '*'가 포함되어 있음. '@어노테이션("*")일 경우 value 속성값이 *가 된다'는 맞는 말이지만, 문제 의도가 '속성명을 생략하면 value 속성에 대입된다'를 묻는 것이라면 맞음. 하지만 틀린 것을 찾아야 함.*
    > *OCR 텍스트 재확인:*
    > *3) @어노테이션 ( "*" )일 경우 value 속성값이 *가 된다.*
    > *4) @어노테이션 ( "*", prop=3)일 경우 value 속성값은 *, prop 속성값은 3이 된다.* -> 이건 틀림. value 속성 외에 다른 속성을 같이 쓴다면 `value=`를 생략할 수 없음.
    > **따라서 정답은 ④번**. `value` 속성과 다른 속성을 같이 사용할 때는 `value` 속성 이름을 생략할 수 없다. `value="값"`이라고 명시해야 한다.
