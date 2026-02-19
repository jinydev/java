---
layout: backend
title: "2.2 게시판 CRUD 구현"
nav_order: 5
parent: "2주차. JSP 게시판 만들기"
grand_parent: "백엔드 웹서버 개발"
---

# 2.2 게시판 CRUD 구현

JSP와 JDBC를 이용하여 간단한 게시판을 만듭니다.

## 1. 데이터베이스 테이블 생성
```sql
CREATE TABLE board (
    no INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    writer VARCHAR(50),
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 2. VO (Value Object) 클래스 생성
게시글 데이터를 담을 클래스입니다.

```java
public class Board {
    private int no;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    
    // Getter, Setter 생략 (직접 생성하세요)
}
```

---

## 3. 게시글 목록(List) - list.jsp
DB에서 전체 게시글을 조회하여 표(Table) 형태로 출력합니다.

```jsp
<%@ page import="java.sql.*, java.util.*, com.example.dto.Board, com.example.util.DBUtil" %>
<%
    Connection conn = DBUtil.getConnection();
    String sql = "SELECT * FROM board ORDER BY no DESC";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
%>
<table border="1">
    <tr>
        <th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
    </tr>
    <%
        while(rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("no") %></td>
        <td><a href="view.jsp?no=<%= rs.getInt("no") %>"><%= rs.getString("title") %></a></td>
        <td><%= rs.getString("writer") %></td>
        <td><%= rs.getTimestamp("regdate") %></td>
    </tr>
    <%
        }
        rs.close(); pstmt.close(); conn.close();
    %>
</table>
<a href="write.jsp">글쓰기</a>
```

---

## 4. 게시글 작성(Write) - write.jsp & write_action.jsp

### 입력 폼 (write.jsp)
```html
<form action="write_action.jsp" method="post">
    제목: <input type="text" name="title"><br>
    작성자: <input type="text" name="writer"><br>
    내용: <textarea name="content"></textarea><br>
    <button type="submit">등록</button>
</form>
```

### 처리 로직 (write_action.jsp)
```jsp
<%
    request.setCharacterEncoding("UTF-8");
    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");

    Connection conn = DBUtil.getConnection();
    String sql = "INSERT INTO board (title, writer, content) VALUES (?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, title);
    pstmt.setString(2, writer);
    pstmt.setString(3, content);
    
    pstmt.executeUpdate();
    pstmt.close(); conn.close();
    
    response.sendRedirect("list.jsp");
%>
```

---

## 5. 상세 보기(View), 수정(Update), 삭제(Delete)
- **상세 보기**: `list.jsp`에서 제목 클릭 시 `no` 파라미터를 넘겨받아 `SELECT * FROM board WHERE no = ?` 쿼리 실행
- **수정**: 상세 보기에서 '수정' 버튼 클릭 -> 수정 폼(`update.jsp`) -> `UPDATE` 쿼리 실행(`update_action.jsp`)
- **삭제**: 상세 보기에서 '삭제' 버튼 클릭 -> `DELETE` 쿼리 실행(`delete_action.jsp`)
