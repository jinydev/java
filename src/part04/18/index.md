---
layout: part04
title: Chapter 18. 데이터 입출력
---

# Chapter 18. 데이터 입출력

## 18.1 입출력 스트림

데이터는 키보드를 통해 입력될 수도 있고, 파일 또는 프로그램으로부터 입력될 수도 있다. 반대로 데이터는 모니터로 출력될 수도 있고, 파일에 저장되거나 다른 프로그램으로 전송될 수 있다. 이것을 총칭해서 데이터 입출력이라고 한다.

자바는 입력 스트림과 출력 스트림을 통해 데이터를 입출력한다. 스트림(Stream)은 단방향으로 데이터가 흐르는 것을 말하는데, 데이터는 출발지에서 나와 도착지로 흘러들어간다.

*   **입력 스트림**: 프로그램이 데이터를 입력받을 때 사용
*   **출력 스트림**: 프로그램이 데이터를 출력할 때 사용

어떤 데이터를 입출력하느냐에 따라 스트림은 다음 두 종류로 구분할 수 있다.
*   **바이트 스트림**: 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 입출력할 때 사용
*   **문자 스트림**: 문자만 입출력할 때 사용

자바는 데이터 입출력과 관련된 라이브러리를 `java.io` 패키지에서 제공하고 있다. `java.io` 패키지는 바이트 스트림과 문자 스트림을 다음과 같이 이름으로 구분해서 제공한다.

| 구분                | 바이트 스트림                              | 문자 스트림                     |
| :------------------ | :----------------------------------------- | :------------------------------ |
| **최상위 클래스**   | `InputStream`, `OutputStream`              | `Reader`, `Writer`              |
| **하위 클래스(예)** | `FileInputStream`, `FileOutputStream`, ... | `FileReader`, `FileWriter`, ... |

## 18.2 바이트 출력 스트림

`OutputStream`은 바이트 출력 스트림의 최상위 클래스로 추상 클래스이다. 모든 바이트 출력 스트림 클래스는 이 `OutputStream` 클래스를 상속받아서 만들어진다.

`OutputStream` 클래스에는 모든 바이트 출력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.

| 리턴 타입 | 메소드                              | 설명                                                    |
| :-------- | :---------------------------------- | :------------------------------------------------------ |
| `void`    | `write(int b)`                      | 1 byte를 출력                                           |
| `void`    | `write(byte[] b)`                   | 매개값으로 주어진 배열 b의 모든 바이트를 출력           |
| `void`    | `write(byte[] b, int off, int len)` | 매개값으로 주어진 배열 b[off]부터 len개의 바이트를 출력 |
| `void`    | `flush()`                           | 출력 버퍼에 잔류하는 모든 바이트를 출력                 |
| `void`    | `close()`                           | 출력 스트림을 닫고 사용 메모리 해제                     |

### 1 바이트 출력

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

### 바이트 배열 출력

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

## 18.3 바이트 입력 스트림

`InputStream`은 바이트 입력 스트림의 최상위 클래스로, 추상 클래스이다. 모든 바이트 입력 스트림은 `InputStream` 클래스를 상속받아서 만들어진다.

`InputStream` 클래스에는 바이트 입력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.

| 리턴 타입 | 메소드           | 설명                                                                 |
| :-------- | :--------------- | :------------------------------------------------------------------- |
| `int`     | `read()`         | 1 byte를 읽은 후 읽은 바이트를 리턴                                  |
| `int`     | `read(byte[] b)` | 읽은 바이트를 매개값으로 주어진 배열에 저장 후 읽은 바이트 수를 리턴 |
| `void`    | `close()`        | 입력 스트림을 닫고 사용 메모리 해제                                  |

### 1 바이트 읽기

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

### 바이트 배열로 읽기

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

## 18.4 문자 입출력 스트림

바이트 입출력 스트림인 `InputStream`과 `OutputStream`에 대응하는 문자 입출력 스트림으로 `Reader`와 `Writer`가 있다. 입출력되는 단위가 문자인 것을 제외하고는 바이트 입출력 스트림과 사용 방법은 동일하다.

### 문자 출력

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

### 문자 읽기

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

## 18.5 보조 스트림

보조 스트림이란 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림을 말한다. 보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에 입출력 소스로부터 직접 생성된 입출력 스트림에 연결해서 사용해야 한다.

```java
보조스트림 변수 = new 보조스트림(입출력스트림);
```

자주 사용되는 보조 스트림은 다음과 같다.

| 보조 스트림                                                                         | 기능                                 |
| :---------------------------------------------------------------------------------- | :----------------------------------- |
| `InputStreamReader`                                                                 | 바이트 스트림을 문자 스트림으로 변환 |
| `BufferedInputStream`, `BufferedOutputStream`<br>`BufferedReader`, `BufferedWriter` | 입출력 성능 향상                     |
| `DataInputStream`, `DataOutputStream`                                               | 기본 타입 데이터 입출력              |
| `PrintStream`, `PrintWriter`                                                        | 줄바꿈 처리 및 형식화된 문자열 출력  |
| `ObjectInputStream`, `ObjectOutputStream`                                           | 객체 입출력                          |

## 18.6 문자 변환 스트림

바이트 스트림 (`InputStream`, `OutputStream`)에서 입출력할 데이터가 문자라면 문자 스트림 (`Reader`, `Writer`)으로 변환해서 사용하는 것이 좋다.

### InputStream을 Reader로 변환

```java
InputStream is = new FileInputStream("C:/Temp/test.txt");
Reader reader = new InputStreamReader(is);
```

### OutputStream을 Writer로 변환

```java
OutputStream os = new FileOutputStream("C:/Temp/test.txt");
Writer writer = new OutputStreamWriter(os);
```

다음 예제는 UTF-8 문자셋으로 파일에 문자를 저장하고, 저장된 문자를 다시 읽는다.

```java
package ch18.sec06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {
	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림을 사용합니다.");
		String data = read();
		System.out.println(data);
	}

	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		writer.write(str);
		writer.flush();
		writer.close();
	}

	public static String read() throws Exception {
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		Reader reader = new InputStreamReader(is, "UTF-8");
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		String str = new String(data, 0, num);
		return str;
	}
}
```

## 18.7 성능 향상 스트림

프로그램이 입출력 소스와 직접 작업하지 않고 중간에 메모리 버퍼(buffer)와 작업함으로써 실행 성능을 향상시킬 수 있다.

*   바이트 스트림: `BufferedInputStream`, `BufferedOutputStream`
*   문자 스트림: `BufferedReader`, `BufferedWriter`

다음 예제는 성능 향상 보조 스트림을 사용했을 때와 사용하지 않았을 때의 파일 복사 성능 차이를 보여준다.

```java
package ch18.sec07.exam01;

import java.io.*;

public class BufferExample {
	public static void main(String[] args) throws Exception {
		// 입출력 스트림 생성
		String originalFilePath1 = BufferExample.class.getResource("originalFile1.jpg").getPath();
		String targetFilePath1 = "C:/Temp/targetFile1.jpg";
		FileInputStream fis = new FileInputStream(originalFilePath1);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);

		// 입출력 스트림 + 버퍼 스트림 생성
		String originalFilePath2 = BufferExample.class.getResource("originalFile2.jpg").getPath();
		String targetFilePath2 = "C:/Temp/targetFile2.jpg";
		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);

		// 버퍼를 사용하지 않고 복사
		long nonBufferTime = copy(fis, fos);
		System.out.println("버퍼 미사용:\t" + nonBufferTime + " ns");

		// 버퍼를 사용하고 복사
		long bufferTime = copy(bis, bos);
		System.out.println("버퍼 사용:\t" + bufferTime + " ns");

		fis.close();
		fos.close();
		bis.close();
		bos.close();
	}

	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		while (true) {
			int data = is.read();
			if (data == -1) break;
			os.write(data);
		}
		os.flush();
		long end = System.nanoTime();
		return (end - start);
	}
}
```

문자 입력 스트림 Reader에 BufferedReader를 연결하면 행 단위로 문자열을 읽는 `readLine()` 메소드를 사용할 수 있다.

```java
package ch18.sec07.exam02;

import java.io.*;

public class ReadLineExample {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
			new FileReader("src/ch18/sec07/exam02/ReadLineExample.java")
		);

		int lineNo = 1;
		while (true) {
			String str = br.readLine();
			if (str == null) break;
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}

		br.close();
	}
}
```

## 18.8 기본 타입 스트림

바이트 스트림에 `DataInputStream`과 `DataOutputStream` 보조 스트림을 연결하면 기본 타입인 boolean, char, short, int, long, float, double 값을 입출력할 수 있다.

```java
package ch18.sec08;

import java.io.*;

public class DataInputOutputStreamExample {
	public static void main(String[] args) throws Exception {
		// DataOutputStream 생성
		FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.db");
		DataOutputStream dos = new DataOutputStream(fos);

		// 기본 타입 출력
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.writeInt(1);

		dos.writeUTF("감자바");
		dos.writeDouble(90.3);
		dos.writeInt(2);

		dos.flush(); dos.close(); fos.close();

		// DataInputStream 생성
		FileInputStream fis = new FileInputStream("C:/Temp/primitive.db");
		DataInputStream dis = new DataInputStream(fis);

		// 기본 타입 입력
		for (int i=0; i<2; i++) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " : " + score + " : " + order);
		}

		dis.close(); fis.close();
	}
}
```

## 18.9 프린트 스트림

`PrintStream`과 `PrintWriter`는 `print()`, `println()`, `printf()` 메소드를 가지고 있는 보조 스트림이다.

*   `PrintStream`: 바이트 출력 스트림과 연결
*   `PrintWriter`: 문자 출력 스트림과 연결

```java
package ch18.sec09;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/printstream.txt");
		PrintStream ps = new PrintStream(fos);

		ps.print("마치 ");
		ps.println("프린터가 출력하는 것처럼 ");
		ps.println("데이터를 출력합니다.");
		ps.printf("| %6d | %-10s | %10s | \n", 1, "홍길동", "도적");
		ps.printf("| %6d | %-10s | %10s | \n", 2, "감자바", "학생");

		ps.flush();
		ps.close();
	}
}
```

## 18.10 객체 스트림

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

### Serializable 인터페이스

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

## 18.11 File과 Files 클래스

`java.io` 패키지와 `java.nio.file` 패키지는 파일과 디렉토리 정보를 가지고 있는 `File`과 `Files` 클래스를 제공한다.

### File 클래스

`File` 클래스로부터 `File` 객체를 생성하는 방법은 다음과 같다.

```java
File file = new File("C:/Temp/file.txt");
```

`File` 객체를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다. `exists()` 메소드로 존재 여부를 확인할 수 있다.

```java
package ch18.sec11;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	public static void main(String[] args) throws Exception {
		// File 객체 생성
		File dir = new File("C:/Temp/images");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File("C:/Temp/file3.txt");

		// 존재하지 않으면 디렉토리 또는 파일 생성
		if (dir.exists() == false) { dir.mkdirs(); }
		if (file1.exists() == false) { file1.createNewFile(); }
		if (file2.exists() == false) { file2.createNewFile(); }
		if (file3.exists() == false) { file3.createNewFile(); }

		// Temp 폴더의 내용을 출력
		File temp = new File("C:/Temp");
		File[] contents = temp.listFiles();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for (File file : contents) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.printf("%-10s%-20s", "<DIR>", file.getName());
			} else {
				System.out.printf("%-10s%-20s", file.length(), file.getName());
			}
			System.out.println();
		}
	}
}
```

### Files 클래스

`Files` 클래스는 정적 메소드로 구성되어 있으며, `Path` 객체를 매개값으로 받는다.

```java
package ch18.sec11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
	public static void main(String[] args) {
		try {
			String data = "" +
				"id: winter\n" +
				"email: winter@mycompany.com\n" +
				"tel: 010-123-1234";

			// Path 객체 생성
			Path path = Paths.get("C:/Temp/user.txt");

			// 파일 생성 및 데이터 저장
			Files.writeString(Paths.get("C:/Temp/user.txt"), data, Charset.forName("UTF-8"));

			// 파일 정보 얻기
			System.out.println("파일 유형: " + Files.probeContentType(path));
			System.out.println("파일 크기: " + Files.size(path) + " bytes");

			// 파일 읽기
			String content = Files.readString(path, Charset.forName("UTF-8"));
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

## 확인문제

1.  입출력 스트림에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 하나의 스트림으로 입력과 출력이 동시에 가능하다.
    *   ② 프로그램을 기준으로 데이터가 들어오면 입력 스트림이다.
    *   ③ 프로그램을 기준으로 데이터가 나가면 출력 스트림이다.
    *   ④ 콘솔에 출력하거나 파일에 저장하려면 출력 스트림을 사용해야 한다.
    > **정답**: ①
    > **해설**: 스트림은 단방향이다.

2.  InputStream과 Reader에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 이미지 데이터는 InputStream 또는 Reader로 모두 읽을 수 있다.
    *   ② Reader의 read() 메소드는 1문자를 읽는다.
    *   ③ InputStream의 read() 메소드는 1바이트를 읽는다.
    *   ④ InputStreamReader를 이용하면 InputStream을 Reader로 변환시킬 수 있다.
    > **정답**: ①
    > **해설**: 이미지 데이터는 바이너리 데이터이므로 바이트 스트림(InputStream)을 사용해야 한다. Reader는 문자 스트림이다.

3.  InputStream의 read(byte[] b) 메소드에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 메소드의 리턴값은 읽은 바이트 수이다.
    *   ② 매개값 b에는 읽은 데이터가 저장된다.
    *   ③ 읽을 수 있는 바이트 수는 제한이 없다.
    *   ④ 매개값 b에는 이전에 읽은 바이트가 남아 있을 수 있다.
    > **정답**: ③
    > **해설**: 읽을 수 있는 바이트 수는 배열 b의 길이로 제한된다.

4.  출력 스트림에서 데이터를 출력 후 flush() 메소드를 호출하는 이유는 무엇입니까?
    *   ① 출력 스트림의 버퍼에 있는 데이터를 모두 출력시키고 버퍼를 비운다.
    *   ② 출력 스트림을 메모리에서 제거한다.
    *   ③ 출력 스트림의 버퍼에 있는 데이터를 모두 삭제한다.
    *   ④ 출력 스트림을 닫는 역할을 한다.
    > **정답**: ①
    > **해설**: flush()는 버퍼에 남아있는 데이터를 강제로 출력한다.

5.  보조 스트림에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① InputStreamReader는 InputStream을 Reader로 변환시키는 보조 스트림이다.
    *   ② BufferedInputStream은 데이터 읽기 성능을 향상시키는 보조 스트림이다.
    *   ③ DataInputStream은 객체를 입출력하는 보조 스트림이다.
    *   ④ PrintStream은 print(), println() 메소드를 제공하는 보조 스트림이다.
    > **정답**: ③
    > **해설**: DataInputStream은 기본 타입 데이터를 입출력하는 보조 스트림이다. 객체 입출력은 ObjectInputStream/ObjectOutputStream이다.

6.  ObjectInputStream, ObjectOutputStream에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 객체를 직렬화해서 출력하고 역직렬화해서 복원시킨다.
    *   ② Serializable 인터페이스를 구현한 객체만 입출력할 수 있다.
    *   ③ 클래스의 serialVersionUID는 입출력할 때 달라도 상관없다.
    *   ④ transient 필드는 출력에서 제외된다.
    > **정답**: ③
    > **해설**: serialVersionUID가 같아야 역직렬화가 가능하다.

7.  소스 파일을 읽고 실행 결과와 같이 행의 라인 번호를 추가시켜 출력하도록 밑줄과 빈 곳에 코드를 작성해 보세요.
    ```java
    // ...
    String filePath = "C:/ThisIsJavaSecondEdition/workspace/thisisjava/src/ch02/sec01/VariableUseExample.java";
    FileReader fr = new FileReader(filePath);
    BufferedReader br = new BufferedReader(fr);
    int rowNumber = 0;
    String rowData;
    while (true) {
        rowData = br.readLine();
        if (rowData == null) break;
        System.out.println(++rowNumber + ": " + rowData);
    }
    br.close(); fr.close();
    // ...
    ```

8.  PrintStream에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① out 필드는 콘솔로 출력하는 PrintStream 타입이다.
    *   ② print(), println(), printf() 메소드를 제공한다.
    *   ③ println() 메소드는 매개값의 타입에 따라 오버로딩되어 있다.
    *   ④ PrintStream은 문자 기반 출력 스트림에 연결된다.
    > **정답**: ④
    > **해설**: PrintStream은 바이트 기반 출력 스트림에 연결된다. (PrintWriter가 문자 기반)

9.  File과 Files 클래스에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① File 객체는 파일이 실제로 존재하지 않아도 생성할 수 있다.
    *   ② File 객체는 파일 정보만 제공하고, 디렉토리 정보는 제공하지 않는다.
    *   ③ Files 클래스는 정적 메소드로 구성되어 있기 때문에 객체를 만들 필요가 없다.
    *   ④ File 객체는 파일의 크기를 제공하는 length() 메소드를 제공한다.
    > **정답**: ②
    > **해설**: File 객체는 파일뿐만 아니라 디렉토리 정보도 제공한다.

10. 실행하면 다음과 같이 원본 파일 경로와 복사 파일 경로를 입력받고 원본 파일을 복사하는 프로그램을 만들어 보세요. (바이트 기반 스트림과 성능 향상 보조 스트림을 반드시 사용)
    ```java
    package ch18.check;

    import java.io.*;
    import java.util.Scanner;

    public class FileCopy {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("원본 파일 경로: ");
            String originalFilePath = scanner.nextLine();

            System.out.print("복사 파일 경로: ");
            String targetFilePath = scanner.nextLine();

            File originalFile = new File(originalFilePath);
            if (!originalFile.exists()) {
                System.out.println("원본 파일이 존재하지 않습니다.");
                System.exit(0);
            }

            File targetFile = new File(targetFilePath);
            File parentFile = targetFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }

            try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(originalFilePath));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFilePath));
            ) {
                byte[] data = new byte[1024];
                int num;
                while ((num = bis.read(data)) != -1) {
                    bos.write(data, 0, num);
                }
                System.out.println("복사가 성공되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    ```
