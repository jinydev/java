---
layout: part04
title: "18.11 File과 Files 클래스"
nav_order: 11
parent: "Chapter 22. 데이터 입출력"
grand_parent: "Chapter 22. 데이터 입출력"
---

# 18.11 File과 Files 클래스

`java.io` 패키지와 `java.nio.file` 패키지는 파일과 디렉토리 정보를 가지고 있는 `File`과 `Files` 클래스를 제공한다.

## File 클래스

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

## Files 클래스

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
