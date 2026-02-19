---
layout: backend
title: "3.2 Spring Boot 환경 설정"
nav_order: 7
parent: "3주차. Spring Boot 시작하기"
grand_parent: "백엔드 웹서버 개발"
---

# 3.2 Spring Boot 환경 설정

`src/main/resources/application.properties` (또는 `.yml`) 파일에서 서버 포트, DB 연결 정보 등을 설정합니다.

## 1. 서버 포트 변경
기본 포트는 8080입니다. 변경하려면 다음과 같이 작성합니다.

```properties
server.port=8081
```

## 2. 데이터베이스 연결 설정 (MySQL)
Spring Boot는 설정 파일에 정보만 입력하면 자동으로 `DataSource`를 생성해줍니다.

```properties
# MySQL Driver Class
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# DB URL
spring.datasource.url=jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&characterEncoding=UTF-8

# User & Password
spring.datasource.username=root
spring.datasource.password=your_password

# JPA 설정 (Hibernate)
spring.jpa.hibernate.ddl-auto=update  # 실행 시 테이블 자동 생성/수정 (create, update, validate, none)
spring.jpa.show-sql=true              # 실행되는 SQL 쿼리 로그 출력
spring.jpa.properties.hibernate.format_sql=true # SQL 예쁘게 출력
```

> **주의**: `ddl-auto=create`는 시작할 때마다 기존 데이터를 다 지우고 새로 만듭니다. 개발 초기에는 편하지만, **운영 환경에서는 절대 사용하면 안 됩니다 (`none` 또는 `validate` 사용).**
