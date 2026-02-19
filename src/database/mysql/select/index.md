---
layout: database
title: "20.9 데이터 읽기"
nav_order: 9
parent: "Chapter 24. MySQL"
grand_parent: "데이터베이스"
---

# 20.9 데이터 읽기

PreparedStatement를  생성할  때  SQL  문이  INSERT,  UPDATE,  DELETE일  경우에

는  executeUpdate ( )  메소드를  호출하지만,  데이터를  가져오는  SELECT  문일  경우에는 

executeQuery ( ) 메소드를 호출해야 한다. executeQuery ( ) 메소드는 가져온 데이터를 

ResultSet에 저장하고 리턴한다. 

ResultSet rs  =  pstmt.executeQuery();

ResultSet 구조

ResultSet은 SELECT 문에 기술된 컬럼으로 구성된 행row의 집합이다. 예를 들어 다음 SELECT 문

은 userid, username, userage 컬럼으로 구성된 ResultSet을 리턴한다.

```sql
SELECT userid, username, userage FROM users
```

위의 SELECT 문이 가져온 데이터 행이 4개라면 ResultSet의 내부 구조는 다음과 같다.





```sql
SELECT 문에 기술된 컬럼 순번
```

ResultSet

userid, 1

username, 2

userage, 3

beforeFirst 행

데이터 없음

first 행

spring

summer

fall

last 행

winter

김봄이

하여름

이단풍

한겨울

afterLast 행

데이터 없음





최초 커서 위치

true  =  next()

true  =  next()

true  =  next()

true  =  next()

false  =  next()

ResultSet의 특징은 커서cursor가 있는 행의 데이터만 읽을 수 있다는 것이다. 여기서 커서는 행을 

가리키는 포인터를 말한다. ResultSet은 실제 가져온 데이터 행의 앞과 뒤에 beforeFirst 행과 

afterLast 행이 붙는데, 최초 커서는 beforeFirst를 가리킨다. 따라서 첫 번째 데이터 행인 first 행

을 읽으려면 커서를 이동시켜야 한다. 이때 next ( ) 메소드를 사용한다.

boolean result  =  rs.next();

next ( ) 메소드는 커서를 다음 행으로 이동시키는데, 이동한 행에 데이터가 있으면 true를, 없으

면 false를 리턴한다. 앞의 그림을 보면 last 행까지는 true를 리턴하고 afterLast 행으로 이동하면 

false를 리턴하는 것을 볼 수 있다. 

만약 SELECT 문으로 가져온 데이터 행이 없다면 beforeFirst 행과 afterLast 행이 붙어 있기 때문

에 첫 번째 next ( ) 결과는 false가 된다. 다음은 SELECT 문으로 가져온 행의 수에 따라서 커서를 

이동시키는 코드이다. 

1개의 데이터 행만 가져올 경우

n개의 데이터 행을 가져올 경우

ResultSet rs  =  pstmt.executeQuery();
if(rs.next()) {
  //첫 번째 데이터 행 처리
} else {
  //afterLast 행으로 이동했을 경우

}

ResultSet rs  =  pstmt.executeQuery();
while(rs.next()) {
  //last 행까지 이동하면서 데이터 행 처리
} 
  //afterLast 행으로 이동했을 경우





1개의 데이터 행만 가져올 경우에는 if 조건식에서 next ( ) 메소드를 1번 호출한다. true일 경우(첫 

번째 데이터 행이 있을 경우)와 false일 경우(afterLast 행으로 이동했을 경우)에 따라서 적절한 처

리를 해야 한다. 주로 SELECT 문이 기본키primary key를 조건으로 데이터를 가져오는 경우에 해당한다.

n개의 데이터 행을 가져올 경우에는 while 문을 이용해서 next ( ) 메소드를 반복 호출해 true가 리

턴될 동안(last 행까지 이동할 때까지) 데이터 행을 처리하고, false가 리턴되면(afterLast 행으로 

이동할 때) 반복을 종료시킨다. 

```sql
SELECT 문에 따라 ResultSet에는 많은 데이터 행이 저장될 수 있기 때문에 ResultSet을 더 이상 
```

사용하지 않는다면 close ( ) 메소드를 호출해서 ResultSet이 사용한 메모리를 해제하는 것이 좋다.

rs.close();

데이터 행 읽기

커서가 있는 데이터 행에서 각 컬럼의 값은 Getter 메소드로 읽을 수 있다. 컬럼의 데이터 타입에 

따라서 getXxx ( ) 메소드가 사용되며, 매개값으로 컬럼의 이름 또는 컬럼 순번을 줄 수 있다. 

ResultSet에서 컬럼 순번은 1부터 시작하기 때문에 userid = 1, username = 2, userage = 3이 

된다.

컬럼 이름으로 읽기

컬럼 순번으로 읽기

String userId  =  
  rs.getString("userid");
String userName  =  
  rs.getString("username");
int userAge  =  rs.getInt("userage");

String userId  =  rs.getString(1);
String userName  =  rs.getString(2);
int userAge  =  rs.getInt(3);

만약 SELECT 문에 연산식이나 함수 호출이 포함되어 있다면 컬럼 이름 대신에 컬럼 순번으로 읽어

야 한다. 예를 들어 다음과 같은 SELECT 문에서 userage - 1 연산식이 사용되면 컬럼 순번으로만 

읽을 수 있다. userage - 1은 컬럼명이 아니기 때문이다.





```sql
SELECT userid, userage - 1 
FROM users
```

String userId  =  
  rs.getString("userid");
int userAge  =  rs.getInt(2);

  (userage - 1 ) as userage와 같이 별명(alias )이 있다면 별명이 컬럼 이름이 된다.

사용자 정보 읽기

users 테이블에서 userid가 winter인 사용자의 정보를 가져와 출력해 보자. 먼저 users 테이블의 

한 개의 행(사용자)을 저장할 User 클래스를 작성한다. 컬럼 개수와 타입에 맞게 필드를 선언하고, 

롬복 @Data 어노테이션을 이용해서 Getter, Setter, toString ( ) 메소드를 자동 생성시킨다. 

**>>> User.java**

```java


package ch20.mysql.sec09.exam01;

import lombok.Data;

@Data  //Constructor, Getter, Setter, hashCode(), equals(), toString() 자동 생성
public class User {
  private String userId; 
  private String userName; 
  private String userPassword; 
  private int userAge; 
  private String userEmail;

}

userid가 winter인 사용자 정보를 가져오는 SELECT 문은 다음과 같다.

SELECT userid, username, userpassword, userage, useremail 
FROM users
WHERE userid = 'winter';

조건절의 값을 ?로 대체한 매개변수화된 SQL 문을 String 타입 변수 sql에 대입한다.





String sql  =  "" +
  "SELECT userid, username, userpassword, userage, useremail " +
  "FROM users " +
  "WHERE userid = ?";

매개변수화된  S E L E C T   문을  실행하기  위해  p r e p a r e S t a t e m e n t ( )   메소드로부터 

PreparedStatement를 얻고, ?에 값을 지정한다.

PreparedStatement pstmt  =  conn.prepareStatement(sql);
pstmt.setString(1, "winter");

executeQuery ( ) 메소드로 SELECT 문을 실행해서 ResultSet을 얻는다. userid는 기본키primary 

key이므로 조건에 맞는 행은 1개이거나, 0개이므로 if 문을 이용해서 next ( ) 메소드가 true를 리턴

할 경우 데이터 행을 User 객체에 저장하고 출력한다.

//1개의 데이터 행을 가져왔을 경우

ResultSet rs  =  pstmt.executeQuery();
if(rs.next()) { 
  User user  =  new User();
  user.setUserId(rs.getString("userid"));
  user.setUserName(rs.getString("username"));
  user.setUserPassword(rs.getString("userpassword"));
  user.setUserAge(rs.getInt(4)); 
  user.setUserEmail(rs.getString(5)); 
  System.out.println(user);
} else {  
  System.out.println("사용자 아이디가 존재하지 않음");

//컬럼 순번을 이용해서 컬럼 지정
//컬럼 순번을 이용해서 컬럼 지정

//데이터 행을 가져오지 않았을 경우

}

System.out.println (user )는 롬복이 생성한 User의 toString ( ) 메소드를 호출해서 받은 리턴값

을 출력한다. 다음은 users 테이블에서 userid가 winter인 사용자 정보를 가져오는 전체 코드를 

보여 준다.



 
 
 


```
**>>> UserSelectExample.java**

```java


package ch20.mysql.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExample {
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
        "SELECT userid, username, userpassword, userage, useremail " +
        "FROM users " +
        "WHERE userid = ?";

      //PreparedStatement 얻기 및 값 지정
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      pstmt.setString(1, "winter");

      //SQL 문 실행 후, ResultSet을 통해 데이터 읽기
      ResultSet rs  =  pstmt.executeQuery();
      if(rs.next()) {   //1개의 데이터 행을 가져왔을 경우
        User user  =  new User();
        user.setUserId(rs.getString("userid"));
        user.setUserName(rs.getString("username"));



     
     
     
     



        user.setUserPassword(rs.getString("userpassword"));
        user.setUserAge(rs.getInt(4)); 
        user.setUserEmail(rs.getString(5)); 
        System.out.println(user);
      } else {   //데이터 행을 가져오지 않았을 경우
        System.out.println("사용자 아이디가 존재하지 않음");

//컬럼 순번을 이용
//컬럼 순번을 이용

      }
      rs.close();

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

User(userId = winter, userName = 한겨울, userPassword = 12345, userAge = 25, 
userEmail = winter@mycompany.com)

게시물 정보 읽기

이번에는 boards 테이블에서 bwriter가 winter인 게시물의 정보를 가져와보자. 먼저 20.6의 

BoardInsertExample 예제를 이용해서 다음과 같이 boards 테이블에 bwriter를 winter로 하는 

게시물을 2개 이상 저장해둔다.



     


  bno의 값은 다를 수 있다.

먼저 boards 테이블의 1개 행(게시물)을 저장할 Board 클래스를 작성한다. 컬럼 개수와 타입에 

맞게 필드를 선언하고, 롬복 @Data 어노테이션을 이용해서 Getter, Setter, toString ( ) 메소드를 

자동 생성한다. 

```
**>>> Board.java**

```java


package ch20.mysql.sec09.exam02;

import java.sql.Blob;
import java.util.Date;
import lombok.Data;

@Data  //Constructor, Getter, Setter, hashCode(), equals(), toString() 자동 생성
public class Board {
  private int bno;
  private String btitle;
  private String bcontent;
  private String bwriter;
  private Date bdate;
  private String bfilename;
  private Blob bfiledata;

}

bwriter가 winter인 게시물 정보를 가져오는 SELECT 문은 다음과 같다.

SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata
FROM boards
WHERE bwriter = 'winter';

조건절의 값을 ?로 대체한 매개변수화된 SELECT 문을 String 타입 변수 sql에 대입한다.





String sql  =  "" +
  "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
  "FROM boards " +
  "WHERE bwriter = ?";

매개변수화된 SELECT 문을 실행하기 위해 다음과 같이 prepareStatement ( ) 메소드로부터 

PreparedStatement를 얻고, ?에 값을 지정한다.

PreparedStatement pstmt  =  conn.prepareStatement(sql);
pstmt.setString(1, "winter");

executeQuery ( ) 메소드로 SELECT 문을 실행해서 ResultSet을 얻는다. 조건에 맞는 행은 n개이

므로 while 문을 이용해서 next ( ) 메소드가 false를 리턴할 때까지 반복해서 데이터 행을 Board 

객체에 저장하고 출력한다.

ResultSet rs  =  pstmt.executeQuery();
while(rs.next()) { 
  //데이터 행을 읽고 Board 객체에 저장
  Board board  =  new Board();
  board.setBno(rs.getInt("bno"));
  board.setBtitle(rs.getString("btitle"));
  board.setBcontent(rs.getString("bcontent"));
  board.setBwriter(rs.getString("bwriter"));
  board.setBdate(rs.getDate("bdate"));
  board.setBfilename(rs.getString("bfilename"));
  board.setBfiledata(rs.getBlob("bfiledata"));

	 //콘솔에 출력
  System.out.println(board);

}

System.out.println (board )는 롬복이 생성한 Board의 toString ( ) 메소드를 호출해서 받은 리

턴값을 출력한다. Board의 bfiledata는 Blob 객체이므로 콘솔에 출력하면 com.mysql.cj.jdbc.

Blob@65b104b9와 같이 의미 없는 타입 정보만 출력된다. 



 
 


Blob 객체에 저장된 바이너리 데이터를 얻기 위해서는 다음과 같이 입력 스트림 또는 배열을 얻어

내야 한다. 

Blob blob  =  board.getBfiledata();
InputStream is  =  
  blob.getBinaryStream(); 

Blob blob  =  board.getBfiledata();
byte[] bytes  =  blob.getBytes(0, 
  blob.length());

다음은 Blob 객체에서 InputStream을 얻고, 읽은 바이트를 파일로 저장하는 방법을 보여 준다.

InputStream is  =  blob.getBinaryStream();
OutputStream os  =  new FileOutputStream("C:/Temp/" + board.getBfilename());
is.transferTo(os);
os.flush();
os.close();
is.close();

다음은 boards 테이블에서 bwriter가 winter인 게시물 정보를 가져오는 전체 코드이다.

```
**>>> BoardSelectExample.java**

```java


package ch20.mysql.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample {
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
        "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
        "FROM boards " +
        "WHERE bwriter = ?";

      //PreparedStatement 얻기 및 값 지정
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      pstmt.setString(1, "winter");

      //SQL 문 실행 후, ResultSet을 통해 데이터 읽기
      ResultSet rs  =  pstmt.executeQuery();
      while(rs.next()) { 
        //데이터 행을 읽고 Board 객체 생성
        Board board  =  new Board();
        board.setBno(rs.getInt("bno"));
        board.setBtitle(rs.getString("btitle"));
        board.setBcontent(rs.getString("bcontent"));
        board.setBwriter(rs.getString("bwriter"));
        board.setBdate(rs.getDate("bdate"));
        board.setBfilename(rs.getString("bfilename"));
        board.setBfiledata(rs.getBlob("bfiledata"));

        //콘솔에 출력
        System.out.println(board);

        //파일로 저장
        Blob blob  =  board.getBfiledata();
        if(blob !=  null) {
          InputStream is  =  blob.getBinaryStream();



     
     
     
     
 
       
       


          OutputStream os  =  new FileOutputStream("C:/Temp/" + 
              board.getBfilename());
          is.transferTo(os);
          os.flush();
          os.close();
          is.close();

        }

      }
      rs.close();

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

Board(bno = 14, btitle = 봄의 정원, bcontent = 정원의 꽃이 예쁘네요., bwriter = winter, 
bdate = 2022-01-25, bfilename = spring.jpg, bfiledata =  com.mysql.cj.jdbc.Blob@5f354bcf)

Board(bno = 12, btitle = 눈 오는 날, bcontent = 함박눈이 내려요., bwriter = winter, 
bdate = 2022-01-25, bfilename = snow.jpg, bfiledata =  com.mysql.cj.jdbc.Blob@146dfe6)

Board(bno = 13, btitle = 크리스마스, bcontent = 메리 크리스마스~, bwriter = winter, 
bdate = 2022-01-25, bfilename = chrismas.jpg, bfiledata =  com.mysql.cj.jdbc.
Blob@4716be8b)

bfiledata 컬럼의 그림 데이터는 다음과 같이 bfilename 컬럼 값을 파일명으로 해서 C:\Temp 디

렉토리에 저장된다.

```