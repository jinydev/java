---
layout: part04
title: "18.3 바이트 입력 스트림"
nav_order: 3
parent: "Chapter 18. JDBC"
grand_parent: "데이터 입출력"
---

# 18.3 바이트 입력 스트림

`InputStream`은 바이트 입력 스트림의 최상위 클래스로, 추상 클래스이다. 모든 바이트 입력 스트림은 `InputStream` 클래스를 상속받아서 만들어진다.

`InputStream` 클래스에는 바이트 입력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.

| 리턴 타입 | 메소드           | 설명                                                                 |
| :-------- | :--------------- | :------------------------------------------------------------------- |
| `int`     | `read()`         | 1 byte를 읽은 후 읽은 바이트를 리턴                                  |
| `int`     | `read(byte[] b)` | 읽은 바이트를 매개값으로 주어진 배열에 저장 후 읽은 바이트 수를 리턴 |
| `void`    | `close()`        | 입력 스트림을 닫고 사용 메모리 해제                                  |

## 1 바이트 읽기

`read()` 메소드는 입력 스트림으로부터 1 byte를 읽고 `int(4byte)` 타입으로 리턴한다. 리턴된 4byte 중 끝 1byte에만 데이터가 들어 있다. 더 이상 입력 스트림으로부터 바이트를 읽을 수 없다면 `read()` 메소드는 -1을 리턴한다.

```java
package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test1.db");

			while (true) {
				int data = is.read();
				if (data == -1) break;
				System.out.println(data);
			}

			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

## 바이트 배열로 읽기

`read(byte[] b)` 메소드는 입력 스트림으로부터 주어진 배열의 길이만큼 바이트를 읽고 배열에 저장한 다음 읽은 바이트 수를 리턴한다. 많은 양의 바이트를 읽을 때는 `read(byte[] b)` 메소드를 사용하는 것이 좋다.

```java
package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test2.db");

			byte[] data = new byte[100];

			while (true) {
				int num = is.read(data);
				if (num == -1) break;

				for (int i=0; i<num; i++) {
					System.out.println(data[i]);
				}
			}

			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

다음은 파일 복사 예제이다. 파일 복사의 원리는 FileInputStream에서 읽은 바이트를 바로 FileOutputStream으로 출력하는 것이다.

```java
package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	public static void main(String[] args) throws Exception {
		String originalFileName = "C:/Temp/test.jpg";
		String targetFileName = "C:/Temp/test2.jpg";

		InputStream is = new FileInputStream(originalFileName);
		OutputStream os = new FileOutputStream(targetFileName);

		byte[] data = new byte[1024];
		while (true) {
			int num = is.read(data);
			if (num == -1) break;
			os.write(data, 0, num);
		}

		os.flush();
		os.close();
		is.close();

		System.out.println("복사가 잘 되었습니다.");
	}
}
```

Java 9부터는 `transferTo()` 메소드를 사용하여 더 쉽게 복사할 수 있다.
```java
is.transferTo(os);
```
