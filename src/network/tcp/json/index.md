---
layout: network
title: "19.6 JSON 데이터 형식"
nav_order: 6
parent: "Chapter 19. 네트워크 입출력"
grand_parent: "데이터 입출력"
---

# 19.6 JSON 데이터 형식

네트워크로 전달하는 데이터가 복잡할수록 구조화된 형식이 필요하다. **JSON(JavaScript Object Notation)**은 네트워크 통신에서 가장 많이 사용되는 데이터 형식이다.

JSON을 자바에서 처리하기 위해 `org.json` 라이브러리를 사용한다.

*   `JSONObject`: JSON 객체 표기를 생성하거나 파싱할 때 사용
*   `JSONArray`: JSON 배열 표기를 생성하거나 파싱할 때 사용

```java
package ch19.sec06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {
	public static void main(String[] args) throws IOException {
		// JSON 객체 생성
		JSONObject root = new JSONObject();

		// 속성 추가
		root.put("id", "winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);

		// 객체 속성 추가
		JSONObject tel = new JSONObject();
		tel.put("home", "02-123-1234");
		tel.put("mobile", "010-123-1234");
		root.put("tel", tel);

		// 배열 속성 추가
		JSONArray skill = new JSONArray();
		skill.put("java");
		skill.put("c");
		skill.put("c++");
		root.put("skill", skill);

		// JSON 얻기
		String json = root.toString();

		// 콘솔에 출력
		System.out.println(json);

		// 파일로 저장
		Writer writer = new FileWriter("C:/Temp/member.json", Charset.forName("UTF-8"));
		writer.write(json);
		writer.flush();
		writer.close();
	}
}
```

```java
package ch19.sec06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJsonExample {
	public static void main(String[] args) throws IOException {
		// 파일로부터 JSON 읽기
		BufferedReader br = new BufferedReader(
			new FileReader("C:/Temp/member.json", Charset.forName("UTF-8"))
		);
		String json = br.readLine();
		br.close();

		// JSON 파싱
		JSONObject root = new JSONObject(json);

		// 속성 정보 읽기
		System.out.println("id: " + root.getString("id"));
		System.out.println("name: " + root.getString("name"));
		System.out.println("age: " + root.getInt("age"));
		System.out.println("student: " + root.getBoolean("student"));

		// 객체 속성 정보 읽기
		JSONObject tel = root.getJSONObject("tel");
		System.out.println("home: " + tel.getString("home"));
		System.out.println("mobile: " + tel.getString("mobile"));

		// 배열 속성 정보 읽기
		JSONArray skill = root.getJSONArray("skill");
		System.out.print("skill: ");
		for (int i=0; i<skill.length(); i++) {
			System.out.print(skill.get(i) + ", ");
		}
	}
}
```
