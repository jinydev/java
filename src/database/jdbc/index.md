---
layout: part04
title: "Chapter 23. 데이터베이스 입출력 (Oracle)"
nav_order: 23
has_children: true
parent: "데이터 입출력"
---

# Chapter 23. 데이터베이스 입출력 (Oracle)

## 학습목표

자바와 데이터베이스를 연결하여 데이터를 저장하고 관리하는 JDBC 프로그래밍을 배웁니다.

## 목차

### [23.1 JDBC 개요](./01/)

자바는 데이터베이스DB와 연결해서 데이터 입출력 작업을 할 수 있도록 JDBCJava Database Connectivity 라이브러리java.sql 패키지를 제공한다. JDBC는 데이터베이스 관리 시스템DBMS의 종류와 상관없이 동일하게 사용할 수 있는 클래스와 인터...

### [23.2 DBMS 설치](./02/)

DBMS마다 조금씩 다른 SQL을 사용하기 때문에 이 책에서는 개발자 교육과정 중 기업체에서 가장 많이 요구하는 Oracle을 기준으로 설명한다. 본문 내용은 Oracle 19c 설치 과정을 상세히 설명하고 있음. 상세 스크린샷 및 단계별 설명은 생략하고 핵심 내용만...

### [23.3 Client Tool 설치](./03/)

SQL Developer는 Oracle DB 개발 및 관리를 간편하게 해주는 무료 Client Tool이다. 1.  오라클 공식 웹사이트에서 SQL Developer를 다운로드한다. 2.  C:\Oracle\sqldeveloper 경로에 압축을 해제한다. 3.  sql...

### [23.4 DB 구성](./04/)

학습에 필요한 테이블, 시퀀스, 프로시저, 함수를 생성하여 데이터베이스를 구성한다. 1.  users 테이블 생성: sql/oracle/users.sql 실행 2.  boards 테이블 생성: sql/oracle/boards.sql 실행 3.  SEQ_BNO 시퀀스 생...

### [23.5 DB 연결](./05/)

클라이언트 프로그램에서 DB와 연결하려면 해당 DBMS의 JDBC Driver가 필요하다. 또한 연결에 필요한 다음 네 가지 정보가 있어야 한다. 1.  DBMS가 설치된 컴퓨터의 IP 주소 2.  DBMS가 허용하는 포트Port 번호 3.  사용자DB 계정 및 비밀번...

### [23.6 데이터 저장](./06/)

데이터 저장은 INSERT 문을 사용한다. 매개변수화된 SQL 문을 작성하고 PreparedStatement를 이용하여 실행한다. String sql = "INSERT INTO users userid, username, userpassword, userage, user...

### [23.7 데이터 수정](./07/)

데이터 수정은 UPDATE 문을 사용한다. PreparedStatement를 이용하여 매개변수 값을 설정하고 executeUpdate 메소드를 호출한다. String sql = "UPDATE boards SET btitle=?, bcontent=?, bfilename=...

### [23.8 데이터 삭제](./08/)

데이터 삭제는 DELETE 문을 사용한다. String sql = "DELETE FROM boards WHERE bwriter=?"; PreparedStatement pstmt = conn.prepareStatementsql; pstmt.setString1, "wint...

### [23.9 데이터 읽기](./09/)

데이터 읽기는 SELECT 문을 사용한다. PreparedStatement의 executeQuery 메소드를 호출하여 ResultSet을 얻는다. ResultSet은 조회된 데이터의 행row 집합이다. next 메소드로 커서를 이동시키며 데이터를 읽는다.    1개의...

### [23.10 프로시저와 함수 호출](./10/)

프로시저와 함수는 CallableStatement를 사용하여 호출한다. connection의 prepareCall 메소드를 사용한다.    프로시저 호출: { call 프로시저명?, ?, ... }    함수 호출: { ? = call 함수명?, ?, ... } 리턴값...

### [23.11 트랜잭션 처리](./11/)

트랜잭션Transaction은 기능 처리의 최소 단위로, 소작업들이 모두 성공하거나 모두 실패해야 한다. All or Nothing JDBC에서는 기본적으로 자동 커밋Auto Commit이 켜져 있다. 트랜잭션을 수동으로 제어하려면 conn.setAutoCommitfa...

### [23.12 게시판 구현](./12/)

JDBC를 활용하여 콘솔 기반의 게시판을 구현한다. 기능은 Create, Read, Update, Delete CRUD와 목록 보기, 전체 삭제, 종료를 포함한다. 상세 구현 코드는 생략하며, 각 기능별로 BoardExample 클래스를 단계적으로 발전시키는 형태임....

## 확인문제
- [확인문제](./quiz)
