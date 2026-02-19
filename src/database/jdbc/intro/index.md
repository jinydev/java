---
layout: part04
title: "23.1 JDBC 개요"
nav_order: 1
parent: "Chapter 23. 데이터베이스 입출력 (Oracle)"
grand_parent: "데이터 입출력"
---

# 23.1 JDBC 개요

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
