---
layout: part04
title: "18.7 성능 향상 스트림"
nav_order: 7
parent: "Chapter 18. JDBC"
grand_parent: "데이터 입출력"
---

# 18.7 성능 향상 스트림

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
