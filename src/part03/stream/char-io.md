---
layout: part04
title: "18.4 문자 입출력 스트림"
nav_order: 4
parent: "Chapter 18. JDBC"
grand_parent: "데이터 입출력"
---

# 18.4 문자 입출력 스트림

바이트 입출력 스트림인 `InputStream`과 `OutputStream`에 대응하는 문자 입출력 스트림으로 `Reader`와 `Writer`가 있다. 입출력되는 단위가 문자인 것을 제외하고는 바이트 입출력 스트림과 사용 방법은 동일하다.

## 문자 출력

`Writer`는 문자 출력 스트림의 최상위 클래스로, 추상 클래스이다.

| 리턴 타입 | 메소드                                 | 설명                                                              |
| :-------- | :------------------------------------- | :---------------------------------------------------------------- |
| `void`    | `write(int c)`                         | 매개값으로 주어진 한 문자를 출력                                  |
| `void`    | `write(char[] cbuf)`                   | 매개값으로 주어진 배열의 모든 문자를 출력                         |
| `void`    | `write(char[] cbuf, int off, int len)` | 매개값으로 주어진 배열에서 cbuf[off]부터 len개까지의 문자를 출력  |
| `void`    | `write(String str)`                    | 매개값으로 주어진 문자열을 출력                                   |
| `void`    | `write(String str, int off, int len)`  | 매개값으로 주어진 문자열에서 off 순번부터 len개까지의 문자를 출력 |
| `void`    | `flush()`                              | 버퍼에 잔류하는 모든 문자를 출력                                  |
| `void`    | `close()`                              | 출력 스트림을 닫고 사용 메모리를 해제                             |

```java
package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("C:/Temp/test.txt");

			char a = 'A';
			writer.write(a);
			char b = 'B';
			writer.write(b);

			char[] arr = { 'C', 'D', 'E' };
			writer.write(arr);

			writer.write("FGH");

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

## 문자 읽기

`Reader`는 문자 입력 스트림의 최상위 클래스로, 추상 클래스이다.

| 리턴 타입 | 메소드              | 설명                                                                   |
| :-------- | :------------------ | :--------------------------------------------------------------------- |
| `int`     | `read()`            | 1개의 문자를 읽고 리턴                                                 |
| `int`     | `read(char[] cbuf)` | 읽은 문자를 매개값으로 주어진 문자 배열에 저장하고 읽은 문자 수를 리턴 |
| `void`    | `close()`           | 입력 스트림을 닫고 사용 메모리 해제                                    |

```java
package ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
	public static void main(String[] args) {
		try {
			Reader reader = null;

			// 1 문자씩 읽기
			reader = new FileReader("C:/Temp/test.txt");
			while (true) {
				int data = reader.read();
				if (data == -1) break;
				System.out.print((char)data);
			}
			reader.close();
			System.out.println();

			// 문자 배열로 읽기
			reader = new FileReader("C:/Temp/test.txt");
			char[] data = new char[100];
			while (true) {
				int num = reader.read(data);
				if (num == -1) break;
				for (int i=0; i<num; i++) {
					System.out.print(data[i]);
				}
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```
