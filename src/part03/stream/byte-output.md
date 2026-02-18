---
layout: part04
title: "18.2 바이트 출력 스트림"
nav_order: 2
parent: "Chapter 18. JDBC"
grand_parent: "데이터 입출력"
---

# 18.2 바이트 출력 스트림

`OutputStream`은 바이트 출력 스트림의 최상위 클래스로 추상 클래스이다. 모든 바이트 출력 스트림 클래스는 이 `OutputStream` 클래스를 상속받아서 만들어진다.

`OutputStream` 클래스에는 모든 바이트 출력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.

| 리턴 타입 | 메소드                              | 설명                                                    |
| :-------- | :---------------------------------- | :------------------------------------------------------ |
| `void`    | `write(int b)`                      | 1 byte를 출력                                           |
| `void`    | `write(byte[] b)`                   | 매개값으로 주어진 배열 b의 모든 바이트를 출력           |
| `void`    | `write(byte[] b, int off, int len)` | 매개값으로 주어진 배열 b[off]부터 len개의 바이트를 출력 |
| `void`    | `flush()`                           | 출력 버퍼에 잔류하는 모든 바이트를 출력                 |
| `void`    | `close()`                           | 출력 스트림을 닫고 사용 메모리 해제                     |

## 1 바이트 출력

`write(int b)` 메소드는 매개값 `int(4byte)`에서 끝 `1byte`만 출력한다. 매개변수가 int 타입이므로 4byte 모두를 보내는 것은 아니다.

```java
package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test1.db");

			byte a = 10;
			byte b = 20;
			byte c = 30;

			os.write(a);
			os.write(b);
			os.write(c);

			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

## 바이트 배열 출력

일반적으로 1 바이트를 출력하는 경우는 드물고, 보통 바이트 배열을 통째로 출력하는 경우가 많다. `write(byte[] b)` 메소드는 매개값으로 주어진 배열의 모든 바이트를 출력한다.

```java
package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test2.db");

			byte[] array = { 10, 20, 30 };

			os.write(array);

			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

만약 배열의 일부분을 출력하고 싶다면 `write(byte[] b, int off, int len)` 메소드를 사용하면 된다. 이 메소드는 `b[off]`부터 `len`개의 바이트를 출력한다.

```java
package ch18.sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test3.db");

			byte[] array = { 10, 20, 30, 40, 50 };

			os.write(array, 1, 3); // 1번 인덱스부터 3개 출력 -> 20, 30, 40

			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```
