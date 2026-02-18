---
layout: backend
title: "1.3 Servlet과 JSP 기초"
nav_order: 3
parent: "1주차. 웹 서버와 환경 설정"
grand_parent: "백엔드 웹서버 개발"
---

# 1.3 Servlet과 JSP 기초

## 1. 프로젝트 디렉토리 구조 (Maven 기준)
```text
project-root
├── src
│   ├── main
│   │   ├── java          # 자바 소스 코드 (Servlet, Model 등)
│   │   ├── resources     # 설정 파일
│   │   └── webapp        # 웹 리소스 루트
│   │       ├── WEB-INF   # 외부에서 직접 접근 불가 (web.xml 등)
│   │       ├── index.jsp # 메인 페이지
│   │       └── css/      # 정적 리소스
└── pom.xml               # Maven 설정 파일
```

---

## 2. JSP (Java Server Pages) 기본 문법
HTML 코드 안에 자바 코드를 삽입하여 동적인 페이지를 만듭니다.

### 1) 스크립트릿 (Scriptlet): `<% ... %>`
자바 로직 코드를 작성하는 영역입니다.
```jsp
<%
    String name = "홍길동";
    int age = 20;
%>
```

### 2) 표현식 (Expression): `<%= ... %>`
변수나 메소드의 반환값을 화면(HTML)에 출력합니다.
```jsp
<p>이름: <%= name %></p>
<p>나이: <%= age %></p>
```

### 3) 지시자 (Directive): `<%@ ... %>`
페이지 속성 등을 정의합니다. 가장 상단에 위치합니다.
```jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
```

---

## 3. Servlet 기초
자바 클래스로 웹 요청을 처리합니다. `@WebServlet` 어노테이션으로 URL을 매핑합니다.

### HelloServlet.java
```java
package com.example.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello") // URL 매핑: localhost:8080/hello 로 접속 시 실행
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 응답 데이터 타입 및 인코딩 설정
        resp.setContentType("text/html; charset=UTF-8");
        
        // HTML 출력
        resp.getWriter().println("<h1>Hello from Servlet!</h1>");
        resp.getWriter().println("<p>서블릿에서 보낸 응답입니다.</p>");
    }
}
```

## 4. 실습: 구구단 출력하기
JSP를 이용하여 2단부터 9단까지 출력하는 페이지를 만들어보세요.

```jsp
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>구구단</title></head>
<body>
    <h2>구구단 출력</h2>
    <%
        for(int i=2; i<=9; i++) {
    %>
        <h3><%= i %>단</h3>
        <%
            for(int j=1; j<=9; j++) {
        %>
            <%= i %> x <%= j %> = <%= i*j %> <br>
        <%
            }
        %>
        <hr>
    <%
        }
    %>
</body>
</html>
```
