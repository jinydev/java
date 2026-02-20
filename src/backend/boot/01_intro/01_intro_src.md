---
layout: backend
title: "3.1 Spring Boot 개요 및 프로젝트 생성"
nav_order: 6
parent: "3주차. Spring Boot 시작하기"
grand_parent: "백엔드 웹서버 개발"
---

# 3.1 Spring Boot 개요 및 프로젝트 생성

## 1. Spring Framework vs Spring Boot
- **Spring Framework**: 자바 엔터프라이즈 애플리케이션 개발을 위한 강력한 기능을 제공하지만, 설정(XML, Java Config)이 복잡하고 어렵습니다.
- **Spring Boot**: Spring을 더 **빠르고 쉽게** 사용할 수 있도록 만든 도구입니다. 복잡한 설정을 자동화(Auto Configuration)해주고, 내장 웹 서버(Tomcat)를 제공하여 `main()` 메소드 실행만으로 서버를 띄울 수 있습니다.

## 2. Spring Initializr로 프로젝트 생성
[Spring Initializr](https://start.spring.io/) 사이트를 이용하면 프로젝트 구조를 쉽게 잡을 수 있습니다.

1. **Project**: Maven
2. **Language**: Java
3. **Spring Boot**: 3.x.x (최신 안정 버전, Snapshot 제외)
4. **Project Metadata**:
   - Jar: 선택 (War 아님)
   - Java: 17 이상
5. **Dependencies** (추가할 라이브러리):
   - **Spring Web**: 웹 개발 기능 (Tomcat, MVC 등)
   - **Lombok**: Getter, Setter 등 자동 생성
   - **Spring Data JPA**: DB 접근 기술
   - **MySQL Driver**: MySQL 연결 드라이버 (또는 H2)
   - **Thymeleaf**: 뷰 템플릿 엔진 (JSP 대신 사용 권장)

6. **Generate** 버튼 클릭 -> 압축 파일 다운로드 -> 압축 해제 -> IDE에서 Open

---

## 3. 프로젝트 구조
```text
project-root
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.demo
│   │   │       └── DemoApplication.java  # 메인 실행 파일
│   │   └── resources
│   │       ├── static        # 정적 파일 (css, js, images)
│   │       ├── templates     # HTML 템플릿 파일 (Thymeleaf)
│   │       └── application.properties # 설정 파일
└── pom.xml                   # Maven 의존성 관리
```

## 4. Hello World 실행
`DemoApplication.java` 실행 후 브라우저에서 `localhost:8080` 접속 확인.
