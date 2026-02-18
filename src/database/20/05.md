---
layout: part04
title: "20.5 DB 연결"
nav_order: 5
parent: "Chapter 20. 데이터베이스 입출력"
grand_parent: "데이터 입출력"
---

# 20.5 DB 연결

클라이언트 프로그램에서 DB와 연결하려면 해당 DBMS의 JDBC Driver가 필요하다. 또한 연결에 필요한 다음 네 가지 정보가 있어야 한다.
1.  DBMS가 설치된 컴퓨터의 IP 주소
2.  DBMS가 허용하는 포트(Port) 번호
3.  사용자(DB 계정) 및 비밀번호
4.  사용하고자 하는 DB 이름

## JDBC Driver 설치

Oracle 19c와 호환되는 JDBC Driver(`ojdbc8.jar`)를 프로젝트의 `lib` 폴더에 복사하고 Build Path에 추가해야 한다.

## DB 연결

`Class.forName()` 메소드로 JDBC Driver를 메모리로 로딩하고, `DriverManager.getConnection()` 메소드로 DB와 연결한다.

```java
package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// 연결하기
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/orcl",
				"java",
				"oracle"
			);

			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 연결 끊기
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}
}
```
연결 문자열 형식: `jdbc:oracle:thin:@IP주소:포트/DB명` (예: `jdbc:oracle:thin:@localhost:1521/orcl`)
