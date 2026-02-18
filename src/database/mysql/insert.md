---
layout: database
title: "20.6 데이터 저장"
nav_order: 6
parent: "MySQL"
grand_parent: "데이터베이스"
---

# 20.6 데이터 저장

이번 절에서는 JDBC를 이용해서 INSERT 문을 실행하는 방법을 알아보자. users 테이블에 새로

운 사용자 정보를 저장하는 INSERT 문은 다음과 같다.

```sql
INSERT INTO users (userid, username, userpassword, userage, useremail)
VALUES ('winter', '한겨울', '12345', 25, 'winter@mycompany.com')
```

값을 ?(물음표)로 대체한 매개변수화된 INSERT 문으로 변경하면 다음과 같다.

```sql
INSERT INTO users (userid, username, userpassword, userage, useremail)
VALUES (?, ?, ?, ?, ?)
```

그리고 INSERT 문을 String 타입 변수 sql에 문자열로 대입한다.

String sql  =  new StringBuilder()
  .append("INSERT INTO users (userid, username, userpassword, userage, useremail) ")
  .append("VALUES (?, ?, ?, ?, ?)")
  .toString();

또는

String sql  =  "" +
  "INSERT INTO users (userid, username, userpassword, userage, useremail) " +
  "VALUES (?, ?, ?, ?, ?)";





매개변수화된 SQL 문을 실행하려면 PreparedStatement가 필요하다. 다음과 같이 Connection

의 prepareStatement ( ) 메소드로부터 PreparedStatement를 얻는다.

PreparedStatement pstmt  =  conn.prepareStatement(sql);

그리고 ?에 들어갈 값을 지정해주는데, ?는 순서에 따라 1번부터 번호가 부여된다. 값의 타입에 따

라 Setter 메소드를 선택한 후 첫 번째에는 ? 순번, 두 번째에는 값을 지정해 준다. 

pstmt.setString(1, "winter");
pstmt.setString(2, "한겨울");
pstmt.setString(3, "12345");
pstmt.setInt(4, 25);
pstmt.setString(5, "winter@mycompany.com");

값을 지정한 후 executeUpdate ( ) 메소드를 호출하면 SQL 문이 실행되면서 users 테이블에 1개

의 행이 저장된다. executeUpdate ( ) 메소드가 리턴하는 값은 저장된 행 수인데, 정상적으로 실행

되었을 경우 1을 리턴한다.

int rows  =  pstmt.executeUpdate(); 

PreparedStatement를  더  이상  사용하지  않을  경우에는  close ( )   메소드를  호출해서 

PreparedStatement가 사용했던 메모리를 해제시킨다.

pstmt.close(); 

다음 예제는 users 테이블에 사용자 정보를 저장하는 전체 코드를 보여 준다.





**>>> UserInsertExample.java**

```java



package ch20.mysql.sec06

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
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
      String sql  =  "" +
        "INSERT INTO users (userid, username, userpassword, userage, useremail) " +
        "VALUES (?, ?, ?, ?, ?)";

      //PreparedStatement 얻기 및 값 지정
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      pstmt.setString(1, "winter");
      pstmt.setString(2, "한겨울");
      pstmt.setString(3, "12345");
      pstmt.setInt(4, 25);
      pstmt.setString(5, "winter@mycompany.com");

      //SQL 문 실행
      int rows  =  pstmt.executeUpdate();
      System.out.println("저장된 행 수: " + rows);



     
     
 
     
     



      //PreparedStatement 닫기
      pstmt.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
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

저장된 행 수: 1

이번에는 boards 테이블에 게시물 정보를 저장해 보자. 새로운 게시물 정보를 저장하는 INSERT 

문은 다음과 같다. bno는 자동 증가 컬럼이므로 생략되고, now ( )는 현재 시간이다.

INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata)
VALUES ('눈 오는 날', '함박눈이 내려요', 'winter', now(), 'snow.jpg', binaryData)

now ( )를 제외하고 나머지는 ?로 대체한 매개변수화된 INSERT 문으로 만들고, String 타입 변수 

sql에 저장한다. 

String sql  =  "" +
  "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
  "VALUES (?, ?, ?, now(), ?, ?)";



     


매개변수화된 INSERT 문을 실행하기 위해 다음과 같이 prepareStatement ( ) 메소드로부터 

PreparedStatement를 얻는데, 이전과는 다르게 두 번째 매개값이 있다.

PreparedStatement pstmt  =  conn.prepareStatement(sql, 

Statement.RETURN_GENERATED_KEYS);

두 번째 매개값은 INSERT 문이 실행된 후 가져올 키 값으로, 자동 증가된 bno 값을 가져온다. SQL

문이 실행되기 전까지는 bno 값을 모르기 때문에 SQL 문이 실행된 후에 bno 컬럼에 실제로 저장

된 값을 얻어보는 것이다.

이제 ?에 해당하는 값을 지정한다. bfiledata 컬럼은 바이너리 타입(blob )이므로 ?에 값을 지정

하려면 setBinaryStream ( ), setBlob ( ), setBytes ( ) 메소드 중 하나를 이용해야 한다. 다음은 

setBlob을 이용해서 바이트 입력 스트림을 제공한 것이다.

pstmt.setString(1, "눈 오는 날");
pstmt.setString(2, "함박눈이 내려요.");
pstmt.setString(3, "winter");
pstmt.setString(4, "snow.jpg");
pstmt.setBlob(5, new FileInputStream("src/ch20/mysql/sec06/snow.jpg"));

INSERT 문을 실행하고 저장된 bno 값을 얻는 방법은 다음과 같다. 게시물 정보가 저장되었을 경

우(rows가 1일 경우) getGeneratedKeys ( ) 메소드로 ResultSet을 얻고, getInt ( ) 메소드로 

bno를 얻는다. ResultSet에 대해서는 20.9절에서 자세히 설명한다.

int rows  =  pstmt.executeUpdate(); 
if(rows  = =  1) {
  ResultSet rs  =  pstmt.getGeneratedKeys(); 

//SQL 문 실행

// new String[] { "bno" }에 기술된 컬럼 

  if(rs.next()) { 
    int bno  =  rs.getInt(1);  //new String[] { "bno" }의 첫 번째 항목 bno 컬럼 값을 읽음

값을 가져옴
//값이 있다면

  }

  rs.close(); 

//ResultSet이 사용했던 메모리 해제

}



         
 
 
 


다음은 boards 테이블에 게시물 정보를 저장하는 전체 코드이다.

```
**>>> BoardInsertExample.java**

```java



package ch20.mysql.sec06;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardInsertExample {
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
      String sql  =  "" +
        "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
        "VALUES (?, ?, ?, now(), ?, ?)";

    //PreparedStatement 얻기 및 값 지정
      PreparedStatement pstmt  =  conn.prepareStatement(
          sql, Statement.RETURN_GENERATED_KEYS);
      pstmt.setString(1, "눈 오는 날");
      pstmt.setString(2, "함박눈이 내려요.");
      pstmt.setString(3, "winter");



     
     
 
   



      pstmt.setString(4, "snow.jpg");
      pstmt.setBlob(5, new FileInputStream("src/ch20/mysql/sec06/snow.jpg"));

      //SQL 문 실행
      int rows  =  pstmt.executeUpdate();
      System.out.println("저장된 행 수: " + rows);

      //bno 값 얻기
      if(rows  = =  1) {
        ResultSet rs  =  pstmt.getGeneratedKeys();
        if(rs.next()) {
          int bno  =  rs.getInt(1);
          System.out.println("저장된 bno: " + bno);

        }
        rs.close();

      }

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

저장된 행 수: 1
저장된 bno: 1  (실행한 횟수에 따라 bno 값은 다를 수 있음)

```