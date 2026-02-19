---
layout: database
title: "20.7 데이터 수정"
nav_order: 7
parent: "Chapter 24. MySQL"
grand_parent: "데이터베이스"
---

# 20.7 데이터 수정

이번 절에서는 JDBC를 이용해서 UPDATE 문을 실행하는 방법을 알아보자. boards 테이블에 저

장된 게시물 중에서 bno가 3인 게시물의 btitle, bcontent, bfilename, bfiledata를 변경하는 

SQL 문은 다음과 같다.

```sql
UPDATE boards SET
  btitle = '눈사람',
  bcontent = '눈으로 만든 사람;,
  bfilename = 'snowman.jpg',
  bfiledata = binaryData 
WHERE bno = 3
```

값을 ?로 대체한 매개변수화된 UPDATE 문으로 변경한다.

```sql
UPDATE boards SET
  btitle = ?,
  bcontent = ?,
  bfilename = ?,
  bfiledata = ?
WHERE bno = ?
```

String 타입 변수 sql에 매개변수화된 UPDATE 문을 저장한다.

String sql  =  new StringBuilder()
    .append("UPDATE boards SET ")
    .append("btitle = ?, ")
    .append("bcontent = ?, ")
    .append("bfilename = ?, ")
    .append("bfiledata = ? ")
    .append("WHERE bno = ?")
    .toString();

매개변수화된 UPDATE 문을 실행하기 위해 다음과 같이 prepareStatement ( ) 메소드로부터 

PreparedStatement를 얻고, ?에 해당하는 값을 지정한다.





PreparedStatement pstmt  =  conn.prepareStatement(sql);
pstmt.setString(1, "눈사람");
pstmt.setString(2, "눈으로 만든 사람");
pstmt.setString(3, "snowman.jpg");
pstmt.setBlob(4, new FileInputStream("src/ch20/mysql/sec07/snowman.jpg"));
pstmt.setInt(5, 3);

값을 모두 지정하였다면 UPDATE 문을 실행하기 위해 executeUpdate ( ) 메소드를 호출한다. 성

공적으로 실행되면 수정된 행의 수가 리턴된다. 만약 0이 리턴되면 조건에 맞는 행이 없어 수정된 

내용이 없음을 의미한다.

int rows  =  pstmt.executeUpdate();

다음은 boards 테이블에 저장된 게시물 정보를 수정하는 전체 코드이다. 39라인의 게시물 번호 3은 

여러분의 boards 테이블에 저장된 번호로 알맞게 수정해야 한다.

**>>> BoardUpdateExample.java**

```java


package ch20.mysql.sec07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
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
      String sql  =  new StringBuilder()
          .append("UPDATE boards SET ")
          .append("btitle = ?, ")
          .append("bcontent = ?, ")
          .append("bfilename = ?, ")
          .append("bfiledata = ? ")
          .append("WHERE bno = ?")
          .toString();

      //PreparedStatement 얻기 및 값 지정
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      pstmt.setString(1, "눈사람");
      pstmt.setString(2, "눈으로 만든 사람");
      pstmt.setString(3, "snowman.jpg");
      pstmt.setBlob(4, new FileInputStream("src/ch20/mysql/sec07/snowman. jpg"));
      pstmt.setInt(5, 3);  //boards 테이블에 있는 게시물 번호(bno) 지정

      //SQL 문 실행
      int rows  =  pstmt.executeUpdate();
      System.out.println("수정된 행 수: " + rows);

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

수정된 행 수: 1

```