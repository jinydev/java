---
layout: part04
title: "18.6 문자 변환 스트림"
nav_order: 6
parent: "Chapter 22. 데이터 입출력"
grand_parent: "Chapter 22. 데이터 입출력"
---

# 18.6 문자 변환 스트림

바이트 스트림 (`InputStream`, `OutputStream`)에서 입출력할 데이터가 문자라면 문자 스트림 (`Reader`, `Writer`)으로 변환해서 사용하는 것이 좋다.

## InputStream을 Reader로 변환

```java
InputStream is = new FileInputStream("C:/Temp/test.txt");
Reader reader = new InputStreamReader(is);
```

## OutputStream을 Writer로 변환

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
