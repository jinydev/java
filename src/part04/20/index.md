---
layout: part04
title: Chapter 20. 데이터베이스 입출력
---

# Chapter 20. 데이터베이스 입출력

## 20.1 JDBC 개요

자바는 데이터베이스(DB)와 연결해서 데이터 입출력 작업을 할 수 있도록 **JDBC(Java Database Connectivity)** 라이브러리(`java.sql` 패키지)를 제공한다. JDBC는 데이터베이스 관리 시스템(DBMS)의 종류와 상관없이 동일하게 사용할 수 있는 클래스와 인터페이스로 구성되어 있다.

JDBC 인터페이스를 통해 실제로 DB와 작업하는 것은 JDBC Driver이다. JDBC Driver는 JDBC 인터페이스를 구현한 것으로, DBMS마다 별도로 다운로드 받아 사용해야 한다.

JDBC에 포함되어 있는 클래스와 인터페이스들의 연관 관계는 다음과 같다.

*   **DriverManager**: JDBC Driver를 관리하며 DB와 연결해서 `Connection` 구현 객체를 생성한다.
*   **Connection**: `Statement`, `PreparedStatement`, `CallableStatement` 구현 객체를 생성하며, 트랜잭션(Transaction) 처리 및 DB 연결을 끊을 때 사용한다.
*   **Statement**: SQL의 DDL(Data Definition Language)과 DML(Data Manipulation Language)을 실행할 때 사용한다. 주로 변경되지 않는 정적 SQL 문을 실행할 때 사용한다.
*   **PreparedStatement**: `Statement`와 동일하게 SQL의 DDL, DML 문을 실행할 때 사용한다. 차이점은 매개변수화된 SQL 문을 사용할 수 있기 때문에 편리성과 보안성이 좋다. 그래서 `Statement`보다는 `PreparedStatement`를 주로 사용한다.
*   **CallableStatement**: DB에 저장되어 있는 프로시저(Procedure)와 함수(Function)를 호출할 때 사용한다.
*   **ResultSet**: DB에서 가져온 데이터를 읽을 때 사용한다.

> **참고**: 학습용 DBMS로 Oracle을 사용한다면 이 책으로 계속해서 학습하고, MySQL을 사용한다면 부록으로 제공되는 '부록 1: 데이터베이스 입출력(MySQL용)' PDF로 대체해서 학습하길 바란다.
> *   Oracle 학습 환경일 경우: 책 본문으로 학습
> *   MySQL 학습 환경일 경우: 부록으로 제공되는 PDF로 학습

## 20.2 DBMS 설치

DBMS마다 조금씩 다른 SQL을 사용하기 때문에 이 책에서는 개발자 교육과정 중 기업체에서 가장 많이 요구하는 Oracle을 기준으로 설명한다.

### Oracle 설치

*(본문 내용은 Oracle 19c 설치 과정을 상세히 설명하고 있음. 상세 스크린샷 및 단계별 설명은 생략하고 핵심 내용만 기술함)*

1.  오라클 공식 웹사이트에서 Windows x64용 Oracle Database 19c 설치 파일(`WINDOWS.X64_193000_db_home.zip`)을 다운로드한다.
2.  `C:\Oracle` 디렉토리에 압축을 해제한다. (반드시 이 경로여야 함)
3.  `setup.exe`를 실행하여 설치를 진행한다.
4.  설치 과정에서 '단일 인스턴스 데이터베이스 생성', '데스크톱 클래스' 등을 선택한다.
5.  Oracle Base는 `C:\Oracle`로 설정하고, 비밀번호는 `oracle`로 설정한다. '컨테이너 데이터베이스로 생성' 체크는 해제한다.
6.  설치가 완료되면 `sqlplus`를 이용해 관리자 계정 생명 주기 제한을 푼다.
    ```sql
    sqlplus / as sysdba
    alter profile default limit password_life_time unlimited;
    ```
7.  학습에 사용할 DB 계정 `java`를 생성하고 권한을 부여한다.
    ```sql
    create user java identified by oracle;
    grant connect to java;
    grant resource to java;
    grant unlimited tablespace to java;
    ```

### 원격 연결

Oracle을 설치하면 기본적으로 로컬(설치된 컴퓨터) 환경에서만 Oracle에 연결할 수 있다. 원격(외부 컴퓨터)에서 Oracle에 연결해서 사용하려면 'Net Configuration Assistant'를 실행하여 리스너(LISTENER)를 재구성해야 한다.

### 방화벽 해제

윈도우 방화벽 설정에서 1521 포트에 대한 인바운드 규칙을 추가하여 포트를 개방해야 한다.

## 20.3 Client Tool 설치

SQL Developer는 Oracle DB 개발 및 관리를 간편하게 해주는 무료 Client Tool이다.

1.  오라클 공식 웹사이트에서 SQL Developer를 다운로드한다.
2.  `C:\Oracle\sqldeveloper` 경로에 압축을 해제한다.
3.  `sqldeveloper.exe`를 실행한다.
4.  새 데이터베이스 접속을 생성한다.
    *   **Name**: thisisjava
    *   **사용자 이름**: java
    *   **비밀번호**: oracle
    *   **호스트 이름**: localhost
    *   **포트**: 1521
    *   **SID**: orcl

## 20.4 DB 구성

학습에 필요한 테이블, 시퀀스, 프로시저, 함수를 생성하여 데이터베이스를 구성한다.

1.  `users` 테이블 생성: `sql/oracle/users.sql` 실행
2.  `boards` 테이블 생성: `sql/oracle/boards.sql` 실행
3.  `SEQ_BNO` 시퀀스 생성: `sql/oracle/sequence.sql` 실행
4.  `accounts` 테이블 생성 및 데이터 삽입: `sql/oracle/accounts.sql` 실행
5.  `user_create` 프로시저 생성: `sql/oracle/procedure.sql` 실행
6.  `user_login` 함수 생성: `sql/oracle/function.sql` 실행

## 20.5 DB 연결

클라이언트 프로그램에서 DB와 연결하려면 해당 DBMS의 JDBC Driver가 필요하다. 또한 연결에 필요한 다음 네 가지 정보가 있어야 한다.
1.  DBMS가 설치된 컴퓨터의 IP 주소
2.  DBMS가 허용하는 포트(Port) 번호
3.  사용자(DB 계정) 및 비밀번호
4.  사용하고자 하는 DB 이름

### JDBC Driver 설치

Oracle 19c와 호환되는 JDBC Driver(`ojdbc8.jar`)를 프로젝트의 `lib` 폴더에 복사하고 Build Path에 추가해야 한다.

### DB 연결

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

## 20.6 데이터 저장

데이터 저장은 `INSERT` 문을 사용한다. 매개변수화된 SQL 문을 작성하고 `PreparedStatement`를 이용하여 실행한다.

```java
String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) VALUES (?, ?, ?, ?, ?)";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "winter");
// ... 값 설정 ...
int rows = pstmt.executeUpdate();
```

게시물 저장 시 `SEQ_BNO.NEXTVAL`로 생성된 키 값을 알아내려면 `prepareStatement`의 두 번째 매개값으로 컬럼명을 배열로 전달하고, `executeUpdate()` 후 `getGeneratedKeys()`를 사용한다.

```java
package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
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

			// 매개변수화된 SQL 문 작성
			String sql = "" +
				"INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
				"VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";

			// PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1, "눈 오는 날");
			pstmt.setString(2, "함박눈이 내려요.");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "snow.jpg");
			pstmt.setBlob(5, BoardWithFileInsertExample.class.getResourceAsStream("snow.jpg"));

			// SQL 문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);

			// bno 값 얻기
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno: " + bno);
				}
				rs.close();
			}

			// PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 연결 끊기
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
```

## 20.7 데이터 수정

데이터 수정은 `UPDATE` 문을 사용한다. `PreparedStatement`를 이용하여 매개변수 값을 설정하고 `executeUpdate()` 메소드를 호출한다.

```java
String sql = "UPDATE boards SET btitle=?, bcontent=?, bfilename=?, bfiledata=? WHERE bno=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
// ... 값 설정 ...
int rows = pstmt.executeUpdate();
```

## 20.8 데이터 삭제

데이터 삭제는 `DELETE` 문을 사용한다.

```java
String sql = "DELETE FROM boards WHERE bwriter=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "winter");
int rows = pstmt.executeUpdate();
```

## 20.9 데이터 읽기

데이터 읽기는 `SELECT` 문을 사용한다. `PreparedStatement`의 `executeQuery()` 메소드를 호출하여 `ResultSet`을 얻는다.

`ResultSet`은 조회된 데이터의 행(row) 집합이다. `next()` 메소드로 커서를 이동시키며 데이터를 읽는다.

*   1개의 행을 가져올 때: `if (rs.next()) { ... }`
*   여러 행을 가져올 때: `while (rs.next()) { ... }`

데이터 읽기는 `get타입(컬럼명)` 또는 `get타입(컬럼순번)` 메소드를 사용한다. (예: `getString("userid")`, `getInt(1)`)

```java
package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample {
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

			// 매개변수화된 SQL 문 작성
			String sql = "" +
				"SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
				"FROM boards " +
				"WHERE bwriter=?";

			// PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");

			// SQL 문 실행 후 ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// 데이터 행을 읽고 Board 객체 생성
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));

				// 콘솔에 출력
				System.out.println(board);

				// 파일로 저장
				Blob blob = board.getBfiledata();
				if (blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("C:/Temp/" + board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
			}
			rs.close();

			// PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 연결 끊기
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
```

## 20.10 프로시저와 함수 호출

프로시저와 함수는 `CallableStatement`를 사용하여 호출한다. connection의 `prepareCall()` 메소드를 사용한다.

*   프로시저 호출: `{ call 프로시저명(?, ?, ...) }`
*   함수 호출: `{ ? = call 함수명(?, ?, ...) }`

리턴값(OUT 파라미터)은 `registerOutParameter()` 메소드로 타입을 지정하고, 실행 후 `get타입()` 메소드로 값을 얻는다.

## 20.11 트랜잭션 처리

트랜잭션(Transaction)은 기능 처리의 최소 단위로, 소작업들이 모두 성공하거나 모두 실패해야 한다. (All or Nothing)

JDBC에서는 기본적으로 자동 커밋(Auto Commit)이 켜져 있다. 트랜잭션을 수동으로 제어하려면 `conn.setAutoCommit(false)`를 호출하여 자동 커밋을 끈다.

*   `conn.commit()`: 모든 작업 성공 시 커밋
*   `conn.rollback()`: 예외 발생 시 롤백

```java
try {
    conn.setAutoCommit(false); // 자동 커밋 끄기
    
    // ... 소작업 1 ...
    // ... 소작업 2 ...
    
    conn.commit(); // 모두 성공 시 커밋
} catch (Exception e) {
    conn.rollback(); // 실패 시 롤백
} finally {
    conn.setAutoCommit(true); // 자동 커밋 다시 켜기
    conn.close();
}
```

## 20.12 게시판 구현

JDBC를 활용하여 콘솔 기반의 게시판을 구현한다. 기능은 Create, Read, Update, Delete (CRUD)와 목록 보기, 전체 삭제, 종료를 포함한다.

(상세 구현 코드는 생략하며, 각 기능별로 `BoardExample` 클래스를 단계적으로 발전시키는 형태임.)

## 확인문제

1.  JDBC에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① java.sql에서 제공하는 표준 라이브러리를 말한다.
    *   ② DBMS의 종류와 상관없이 사용할 수 있는 클래스와 인터페이스로 구성되어 있다.
    *   ③ JDBC 인터페이스들을 구현한 것이 JDBC Driver이다.
    *   ④ JDBC Driver는 DBMS의 종류와 상관없이 동일한 것을 사용할 수 있다.
    > **정답**: ④
    > **해설**: JDBC Driver는 DBMS 종류마다 다르며 별도로 설치해야 한다.

2.  JDBC가 DB와 연결할 때 필요한 정보가 아닌 것은 무엇입니까?
    *   ① DBMS가 설치된 컴퓨터의 IP 주소와 Port 번호가 필요하다.
    *   ② DBMS에 생성된 DB의 이름과 사용자 및 비밀번호가 필요하다.
    *   ③ DB에 생성된 테이블 이름을 알아야 한다.
    *   ④ DBMS별로 제공되는 JDBC Driver 클래스 이름을 알아야 한다.
    > **정답**: ③
    > **해설**: DB 연결 시에는 테이블 이름을 알 필요가 없다.

3.  JDBC로 SQL 실행 결과를 얻기 위한 코드 작성 순서는? ( ) -> ( ) -> ( ) -> ( )
    *   ① DriverManager부터 Connection을 얻는다.
    *   ② Class.forName() 메소드를 이용해서 JDBC Driver 클래스를 로딩한다.
    *   ③ ResultSet에서 SQL 실행 결과를 얻는다.
    *   ④ PreparedStatement를 얻고 SQL 문을 실행한다.
    > **정답**: ② -> ① -> ④ -> ③

4.  PreparedStatement에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 매개변수화된 SQL 문을 사용할 수 있다.
    *   ② INSERT, UPDATE, DELETE 문은 executeUpdate() 메소드로 실행한다.
    *   ③ SELECT 문은 executeQuery() 메소드로 실행한다.
    *   ④ 매개변수화된 SQL 문의 ? 순번은 0번부터 시작한다.
    > **정답**: ④
    > **해설**: ? 순번은 1번부터 시작한다.

5.  ResultSet에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① ResultSet은 executeQuery의 리턴값이다.
    *   ② next() 메소드로 afterLast로 이동할 때 true를 리턴한다.
    *   ③ ResultSet은 한 번에 하나의 행만 읽을 수 있다.
    *   ④ ResultSet은 다음 행으로 커서를 이동할 때 next() 메소드를 사용한다.
    > **정답**: ②
    > **해설**: afterLast로 이동하면 false를 리턴한다.

6.  프로시저와 함수를 실행하는 방법으로 틀린 것은 무엇입니까?
    *   ① CallableStatement를 이용한다.
    *   ② 프로시저 호출 문자열로 "{ call 프로시저명(?, ?, ...)}"을 사용한다.
    *   ③ 함수 호출 문자열로 "{ ? = call 함수명(?, ?, ...)}"을 사용한다.
    *   ④ 리턴값인 ?을 지정할 때에는 registerOutParameter() 메소드를 이용한다.
    > **정답**: 없음 (모두 맞는 설명임. 문제의 의도가 다를 수 있으나 보기 내용은 모두 맞음)
    > **해설**: 보기들이 모두 맞는 description이나, 확인문제 원본에서는 틀린 것을 고르라고 함. 혹시 ④번이 IN 파라미터 설정과 혼동을 유발하려 했는지 모르겠으나, OUT 파라미터(리턴값 포함)는 `registerOutParameter`를 사용하는 것이 맞음. 책의 정답 확인 필요. (책 정답: 20.10절 내용을 보면 CallableStatement 사용, 호출 문자열 형식, registerOutParameter 사용 모두 맞음.)

7.  트랜잭션에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 기능 처리의 최소 단위를 말한다.
    *   ② 커밋(commit)은 내부 작업을 모두 성공 처리한다.
    *   ③ 롤백(rollback)은 내부 작업 중에서 성공한 작업까지 되돌린다.
    *   ④ 트랜잭션을 코드로 제어하려면 setAutoCommit(false) 메소드를 먼저 호출해야 한다.
    > **정답**: 없음 (모두 맞는 설명임)

8.  20.12절에서 구현한 게시판에서 다음 내용과 같이 새 사용자를 가입하는 기능을 추가해 보세요.
    (문제 내용 생략: 회원 가입 기능 구현)

9.  8번 문제에서 만든 결과물에 다음과 같이 로그인 기능을 추가해 보세요.
    (문제 내용 생략: 로그인/로그아웃 기능 구현)

10. 9번 문제에서 만든 결과물에 다음과 같은 조건에 맞는 프로그램으로 수정해 보세요.
    (문제 내용 생략: 로그인 상태 연동 및 권한 제어)
