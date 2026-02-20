---
layout: database
title: "20.1 JDBC 개요"
nav_order: 1
parent: "MySQL"
grand_parent: "데이터베이스"
---

# 20.1 JDBC 개요

자바는 데이터베이스(DB )와 연결해서 데이터 입출력 작업을 할 수 있도록 JDBCJava Database Connectivity 

라이브러리(java.sql 패키지)를 제공한다. JDBC는 데이터베이스 관리시스템(DBMS )의 종류와 

상관없이 동일하게 사용할 수 있는 클래스와 인터페이스로 구성되어 있다.

애플리케이션

JDBC (java.sql 패키지) 인터페이스

JDBC
Driver

JDBC
Driver

JDBC
Driver

JDBC
Driver

JDBC 인터페이스를 통해 실제로 DB와 작업하는 것은 JDBC Driver이다. JDBC Driver는 

JDBC 인터페이스를 구현한 것으로, DBMS마다 별도로 다운로드받아 사용해야 한다. 

JDBC에 포함되어 있는 클래스와 인터페이스들의 연관 관계는 다음과 같다. 

JDBC (java.sql 패키지)

DriverManager

Connection

Statement

PreparedStatement

CallableStatement

ResultSet





DriverManager

DriverManager 클래스는 JDBC Driver를 관리하며 DB와 연결해서 Connection 구현 객체를 

생성한다.  

Connection

Connection 인터페이스는 Statement, PreparedStatement, CallableStatement 구현 객체를 

생성하며, 트랜잭션Transaction 처리 및 DB 연결을 끊을 때 사용한다.

Statement

Statement 인터페이스는 SQL의 DDLData Definition Language과 DMLData Manipulation Language을 실행할 때 

사용한다. 주로 변경되지 않는 정적 SQL 문을 실행할 때 사용한다. 

PreparedStatement

PreparedStatement는 Statement와 동일하게 SQL의 DDL, DML 문을 실행할 때 사용한다. 차

이점은 매개변수화된 SQL 문을 사용할 수 있기 때문에 편리성과 보안성이 좋다. 그래서 Statement

보다는 PreparedStatement를 주로 사용한다.

CallableStatement

CallableStatement는 DB에 저장되어 있는 프로시저procuder와 함수function를 호출할 때 사용한다. 

ResultSet

ResultSet은 DB에서 가져온 데이터를 읽을 때 사용한다. 

DBMS별 학습 내용 선택

다음 절부터는 DBMS를 설치하고 JDBC를 사용해서 데이터베이스 연동 프로그램을 어떻게 작성하는지를 학

습한다. 여기에서 문제는 DBMS별로 설치 방법과 SQL 문이 다르기 때문에 연동 프로그램 소스가 달라진다

는 것이다. 

학습용 DBMS로 Oracle을 사용한다면 이 책으로 계속해서 학습하고, MySQL을 사용한다면 부록으로 제공

되는 데이터베이스 입출력(MySQL용) PDF로 대체해서 학습하길 바란다.

● Oracle 학습 환경일 경우: 책 본문으로 학습

● MySQL 학습 환경일 경우: 부록으로 제공되는 PDF로 학습
