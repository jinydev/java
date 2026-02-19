---
layout: part04
title: "18.10 객체 스트림"
nav_order: 10
parent: "Chapter 22. 데이터 입출력"
grand_parent: "Chapter 22. 데이터 입출력"
---

# 18.10 객체 스트림

자바는 메모리에 생성된 객체를 파일 또는 네트워크로 출력할 수 있다. 객체를 출력하려면 필드값을 일렬로 늘어선 바이트로 변경해야 하는데, 이것을 **직렬화(serialization)**라고 한다. 반대로 직렬화된 바이트를 객체의 필드값으로 복원하는 것을 **역직렬화(deserialization)**라고 한다.

*   `ObjectOutputStream`: 객체를 직렬화
*   `ObjectInputStream`: 객체로 복원(역직렬화)

```java
objectOutputStream.writeObject(객체);
객체타입 변수 = (객체타입) objectInputStream.readObject();
```

```java
package ch18.sec10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws Exception {
		// FileOutputStream에 ObjectOutputStream 보조 스트림 연결
		FileOutputStream fos = new FileOutputStream("C:/Temp/object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// 객체 생성
		Member m1 = new Member("fall", "단풍이");
		Product p1 = new Product("노트북", 1500000);
		int[] arr1 = { 1, 2, 3 };

		// 객체를 역직렬화해서 파일에 저장
		oos.writeObject(m1);
		oos.writeObject(p1);
		oos.writeObject(arr1);

		oos.flush(); oos.close(); fos.close();

		// FileInputStream에 ObjectInputStream 보조 스트림 연결
		FileInputStream fis = new FileInputStream("C:/Temp/object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 파일을 읽고 역직렬화해서 객체로 복원
		Member m2 = (Member) ois.readObject();
		Product p2 = (Product) ois.readObject();
		int[] arr2 = (int[]) ois.readObject();

		ois.close(); fis.close();

		// 복원된 객체 내용 확인
		System.out.println(m2);
		System.out.println(p2);
		System.out.println(Arrays.toString(arr2));
	}
}
```

## Serializable 인터페이스

자바는 `Serializable` 인터페이스를 구현한 클래스만 직렬화할 수 있도록 제한한다.

```java
public class Member implements Serializable {
	// ...
}
```

객체가 직렬화될 때 인스턴스 필드값은 직렬화 대상이지만 정적 필드값과 `transient`로 선언된 필드값은 직렬화에서 제외된다.

직렬화할 때 사용된 클래스와 역직렬화할 때 사용된 클래스는 기본적으로 동일한 클래스여야 한다. 클래스 내용이 다르더라도 두 클래스가 동일한 `serialVersionUID` 상수값을 가지고 있으면 역직렬화가 가능하다.

```java
public class Member implements Serializable {
	static final long serialVersionUID = -622284561026719240L;
	// ...
}
```
