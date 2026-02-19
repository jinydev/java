---
layout: database
title: "20.10 트랜잭션 처리"
nav_order: 10
parent: "Chapter 24. MySQL"
grand_parent: "데이터베이스"
---

# 20.10 트랜잭션 처리

트랜잭션transaction은 기능 처리의 최소 단위를 말한다. 하나의 기능은 여러 가지 소작업들로 구성될 수 

있다. 최소 단위란 것은 이 소작업들을 분리할 수 없으며, 전체를 하나로 본다는 개념이다. 트랜잭션

은 소작업들이 모두 성공하거나 모두 실패해야 한다.

예를 들어 계좌 이체는 출금 작업과 입금 작업으로 구성된 트랜잭션이다. 출금과 입금 작업 중 하나

만 성공할 수 없으며, 모두 성공하거나 모두 실패되어야 한다. 

계좌 이체(트랜잭션)

출금 작업

입금 작업

계좌 이체는 DB 입장에서 보면 두 개의 계좌 금액을 수정하는 작업이다. 출금 계좌에서 금액을 감

소시키고, 입금 계좌에서 금액을 증가시킨다. 따라서 다음과 같이 두 개의 UPDATE 문이 필요하

다. 두 UPDATE 문은 모두 성공하거나 모두 실패해야 하며, 하나만 성공할 수 없다.

계좌 이체(트랜잭션)

//출금 작업
```sql
UPDATE accounts SET balance = balance-이체금액 WHERE ano = 출금계좌번호
```

//입금 작업
```sql
UPDATE accounts SET balance = balance+이체금액 WHERE ano = 입금계좌번호
```





DB는 트랜잭션을 처리하기 위해 커밋commit과 롤백rollback을 제공한다. 커밋은 내부 작업을 모두 성

공 처리하고, 롤백은 실행 전으로 돌아간다는 의미에서 모두 실패 처리한다. 

JDBC에서는 INSERT, UPDATE, DELETE 문을 실행할 때마다 자동 커밋이 일어난다. 이 기능은 

계좌 이체와 같이 두 가지 UPDATE 문을 실행할 때 문제가 된다. 출금 작업이 성공되면 바로 커밋

이 되기 때문에 입금 작업의 성공 여부와 상관없이 출금 작업만 별도 처리된다. 

따라서 JDBC에서 트랜잭션을 코드로 제어하려면 자동 커밋 기능을 꺼야 한다. 자동 커밋 설정 여부

는 Connection의 setAutoCommit ( ) 메소드로 할 수 있다. 다음 코드는 자동 커밋 기능을 끈다. 

conn.setAutoCommit(false);

자동 커밋 기능이 꺼지면, 다음과 같은 코드로 커밋과 롤백을 제어할 수 있다.

conn.commit(); 
conn.rollback(); 

//커밋하기

//롤백하기

트랜잭션을 위한 일반적인 코드 작성 패턴은 다음과 같다.

Connection conn  =  null;
try {
  //트랜잭션 시작 ----------------------------------------------------
	 	 //자동 커밋 기능 끄기
    conn.setAutoCommit(false);
    //소작업 처리

    …

	 	 //소작업 처리

    …

    //커밋 -> 모두 성공 처리
    conn.commit();
  //트랜잭션 종료 ----------------------------------------------------
} catch (Exception e) {
  try { 
    //롤백 -> 모두 실패 처리
    conn.rollback(); 
  } catch (SQLException e1) {}





} finally {
  if(conn !=  null) {
    try { 
      //원래대로 자동 커밋 기능 켜기
      conn.setAutoCommit(true);
      //연결 끊기
      conn.close(); 
    } catch (SQLException e) {}

  }

}

다음 예제는 accounts 테이블에서 111-111-1111 계좌에서 222-222-2222 계좌로 10000원

을 이체하기 위해 트랜잭션 처리를 한다. 

**>>> TransactionExample.java**

```java


package ch20.mysql.sec10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
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

      //트랜잭션 시작 ----------------------------------------------------



     
     



        //자동 커밋 기능 끄기
        conn.setAutoCommit(false);

        //출금 작업
        String sql1  = "UPDATE accounts SET balance =balance-? WHERE ano = ?";
        PreparedStatement pstmt1  =  conn.prepareStatement(sql1);
        pstmt1.setInt(1, 10000);
        pstmt1.setString(2, "111-111-1111");
        int rows1  =  pstmt1.executeUpdate();
        if(rows1  = =  0) throw new Exception("출금되지 않았음");
        pstmt1.close();

        //입금 작업
        String sql2  = "UPDATE accounts SET balance =balance+? WHERE ano = ?";
        PreparedStatement pstmt2  =  conn.prepareStatement(sql2);
      pstmt2.setInt(1, 10000);
        pstmt2.setString(2, "222-222-2222");
        int rows2  =  pstmt2.executeUpdate();
        if(rows2  = =  0) throw new Exception("입금되지 않았음");
        pstmt2.close();

        //수동 커밋 -> 모두 성공 처리
        conn.commit();
        System.out.println("계좌 이체 성공"); 
      //트랜잭션 종료 ----------------------------------------------------
    } catch (Exception e) {
      try { 
        //수동 롤백 -> 모두 실패 처리
        conn.rollback(); 
      } catch (SQLException e1) {}
      System.out.println("계좌 이체 실패");
      e.printStackTrace();
    } finally {
      if(conn !=  null) {
        try { 
          //원래대로 자동 커밋 기능 켜기
          conn.setAutoCommit(true);
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

계좌 이체 성공

39라인에서 입금 계좌를 ‘333-333-3333’처럼 다르게 주면 rows2가 0이 되므로 41라인에서 예

외가 발생하고, 예외 처리 코드 51라인에서 롤백된다. 롤백이 되면 출금도 실패 처리되므로 출금 계

좌와 입금 계좌의 금액은 변동되지 않는다. 

```
**>>> TransactionExample.java**

```java

 … 

…
        pstmt2.setString(2, "333-333-3333");

… 

…

```

**실행 결과**

```

계좌 이체 실패
java.lang.Exception: 입금되지 않았음

at ch20.mysql.sec10.TransactionExample.main(TransactionExample.java:41)

트랜잭션을 처리한 이후에는 원래대로 자동 커밋 기능을 켜둬야 한다. 앞의 예제는 더 이상 

Connection을 사용하지 않기 때문에 상관은 없지만, Connection을 다른 기능 처리를 위해 계속 

사용해야 한다면 setAutoCommit (true ) 코드로 자동 커밋 기능을 켜둬야 한다. 특히 커넥션 풀

Connection Pool을 사용할 때 주의해야 할 부분이다.



 


커넥션 풀

다수의 클라이언트의 요청을 처리하는 서버 프로그램은 대부분 커넥션 풀(Connection Pool )을 사용한

다. 커넥션 풀은 일정량의 Connection을 미리 생성시켜놓고, 서버에서 클라이언트의 요청을 처리할 때 

Connection을 제공해주고 다시 반환받는 역할을 수행한다. 

요청 처리

3. Connection
사용

1. Connection
요청

2. Connection
제공

4. Connection
반환

Connection
Pool

connection

connection

connection

connection

DB

커넥션 풀을 사용하면 생성된 Connection을 재사용할 수 있기 때문에 DB 연결 시간을 줄일 수 있고, 전체 

Connection 수를 관리할 수도 있다. 따라서 이것은 불특정 다수의 클라이언트 요청을 처리하는 서버 프로그

램에서는 필수 기능 중 하나이다.

```