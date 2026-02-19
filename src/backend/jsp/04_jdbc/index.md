---
layout: backend
title: "2.1 JDBC와 데이터베이스 연결"
nav_order: 4
parent: "2주차. JSP 게시판 만들기"
grand_parent: "백엔드 웹서버 개발"
---

# 2.1 JDBC와 데이터베이스 연결

## 1. JDBC (Java Database Connectivity)
자바 프로그램에서 데이터베이스(MySQL, Oracle 등)에 연결하여 데이터를 주고받을 수 있게 해주는 표준 인터페이스(API)입니다.

### JDBC 드라이버
각 DB 벤더(MySQL, Oracle 등)는 JDBC 인터페이스를 구현한 드라이버(Jar 파일)를 제공합니다. 우리는 MySQL을 사용하므로 `mysql-connector-j` 라이브러리가 필요합니다.

---

## 2. MySQL DB 연결 단계 (순서)
1. **드라이버 로드**: `Class.forName("com.mysql.cj.jdbc.Driver")`
2. **연결 생성**: `DriverManager.getConnection(url, user, password)`
3. **쿼리 준비**: `PreparedStatement` 객체 생성
4. **쿼리 실행**: `executeQuery()` (조회), `executeUpdate()` (삽입, 수정, 삭제)
5. **결과 처리**: `ResultSet` (조회 시)
6. **자원 해제**: `close()`

---

## 3. DB 연결 유틸리티 클래스 (DBUtil.java)
매번 연결 코드를 작성하는 것은 번거로우므로, 공통 클래스를 만들어 사용합니다.

```java
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 1. 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. 연결 생성 (URL, User, Password 본인 환경에 맞게 수정 필요)
            String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
            String user = "root";
            String password = "password";
            
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
```

---

## 4. 데이터 삽입 (INSERT) 예제

```java
Connection conn = DBUtil.getConnection();
String sql = "INSERT INTO members (id, name) VALUES (?, ?)";

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "user1");
pstmt.setString(2, "홍길동");

int result = pstmt.executeUpdate(); // 변경된 행의 개수 반환
System.out.println(result + "행이 삽입되었습니다.");

pstmt.close();
conn.close();
```

## 5. 데이터 조회 (SELECT) 예제

```java
Connection conn = DBUtil.getConnection();
String sql = "SELECT * FROM members";

PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
    String id = rs.getString("id");
    String name = rs.getString("name");
    System.out.println("ID: " + id + ", Name: " + name);
}

rs.close();
pstmt.close();
conn.close();
```
