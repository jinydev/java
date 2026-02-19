---
layout: database
title: "20.8 데이터 삭제"
nav_order: 8
parent: "Chapter 24. MySQL"
grand_parent: "데이터베이스"
---

# 20.8 데이터 삭제

이번 절에서는 JDBC를 이용해서 DELETE 문을 실행하는 방법을 알아보자. boards 테이블에서 

bwriter가 winter인 모든 게시물을 삭제하는 DELETE 문은 다음과 같다.

```sql
DELETE FROM boards WHERE bwriter = 'winter'
```

조건절의 값을 ?로 대체한 매개변수화된 DELETE 문으로 변경한다.

```sql
DELETE FROM boards WHERE bwriter = ?
```

매개변수화된 DELETE 문을 String 타입 변수 sql에 대입한다.

String sql  =  "DELETE FROM boards WHERE bwriter = ?";

매개변수화된  D E L E T E   문을  실행하기  위해  p r e p a r e S t a t e m e n t ( )   메소드로부터 

PreparedStatement를 얻고 ?에 값을 지정한 후, executeUpdate로 SQL 문을 실행한다. 리턴

값은 삭제된 행 수이다.

String sql  =  "DELETE FROM boards WHERE bwriter = ?";
PreparedStatement pstmt  =  conn.prepareStatement(sql);
pstmt.setString(1, "winter");
int rows  =  pstmt.executeUpdate();





다음은 boards 테이블에 저장된 게시물 정보를 삭제하는 전체 코드이다.

**>>> BoardDeleteExample.java**

```java


package ch20.mysql.sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteExample {
  public static void main(String[] args) {
    Connection conn  =  null;
    try {
      //JDBC Driver 등록
      Class.forName("com.mysql.cj.jdbc.Driver");

      //연결하기
      conn  =  DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/thisisjava", 
        "java", 
        "mysql"

      );

      //매개변수화된 SQL 문 작성
      String sql  =  "DELETE FROM boards WHERE bwriter = ?";

      //PreparedStatement 얻기 및 값 지정
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      pstmt.setString(1, "winter");

      //SQL 문 실행
      int rows  =  pstmt.executeUpdate();
      System.out.println("삭제된 행 수: " + rows);

      //PreparedStatement 닫기
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {



     
     
     
     
     


      if(conn !=  null) {
        try { 
          //연결 끊기
          conn.close(); 
        } catch (SQLException e) {}

      }

    }

  }

}


```

**실행 결과**

```

삭제된 행 수: 10  (winter가 작성한 게시물 개수에 따라 삭제된 행 수는 다를 수 있음)

```