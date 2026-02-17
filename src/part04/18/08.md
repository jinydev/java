---
layout: part04
title: "18.8 기본 타입 스트림"
nav_order: 8
parent: "Chapter 18. JDBC"
grand_parent: "데이터 입출력"
---

# 18.8 기본 타입 스트림

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
