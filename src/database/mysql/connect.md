---
layout: database
title: "20.5 DB 연결"
nav_order: 5
parent: "MySQL"
grand_parent: "데이터베이스"
---

# 20.5 DB 연결

클라이언트 프로그램에서 DB와 연결하려면 해당 DBMS의 JDBC Driver가 필요하다. 또한 연결

에 필요한 다음 네 가지 정보가 있어야 한다.

A클라이언트 프로그램

서버

자바
코드

JDBC
Interface

JDBC
Driver

B클라이언트 프로그램

IP

자바
코드

JDBC
Interface

JDBC
Driver

MySQL

② 포트
3306

사용자
패스워드

Oracle

② 포트
1521

사용자
패스워드

④ DB 이름

Table1

Table2

④ DB 이름

Table1

Table2

① DBMS가 설치된 컴퓨터의 IP 주소

② DBMS가 허용하는 포트(Port ) 번호

③ 사용자(DB 계정) 및 비밀번호

④ 사용하고자 하는 DB 이름

IP 주소는 컴퓨터를 찾아가기 위해, Port 번호는 DBMS로 연결하기 위해 필요하다. DBMS는 여러 

개의 DB를 관리하므로 실제로 사용할 DB 이름이 필요하며, 어떤 사용자인지 인증받기 위한 계정 

및 비밀번호가 필요하다.

JDBC Driver 설치

20.2절에서 로컬 PC에 MySQL을 설치했다면 다음 경로에서 JDBC Driver 파일을 찾을 수 있다.

C :\Program Files (x86 )\MySQL\Connector J 8.0\mysql -connector -java -8.0.25.jar





만약 MySQL을 설치하지 않고 원격 MySQL을 사용한다면 JDBC Driver만 별도로 다음 URL에서 

다운로드할 수 있다.

https ://mvnrepository.com/artifact/mysql/mysql -connector -java

위 사이트에서는 MySQL 버전별로 JDBC Driver를 제공하는데, MySQL 8.0과 호환되는 가장 마

지막 버전인 8.0.x를 받아 보자. 다음 그림과 같이 버전 링크를 클릭한다.

  MySQL 버전(8.0.x )은 다운로드하는 시점에 따라 달라질 수 있다.

JDBC Driver 라이브러리 파일(jar ) 파일을 받기 위해 Files에 있는 jar 링크를 클릭한다.





로컬 PC에서 찾았거나 URL에서 내려받은 mysql-connector-

java-8.0.x.jar 파일을 thisisjava 프로젝트의 lib 폴더에 복사

한다. lib 폴더가 없으면 thisisjava 프로젝트를 마우스 오른쪽 

버튼으로 클릭한 후 [New] - [Folder]를 선택해서 생성한다.

그리고 JAR 파일 안에 있는 클래스를 사용하기 위해 JAR 파일을 선택 후 마우스 오른쪽 버튼을 클

릭해서 다음과 같이 Build Path에 추가한다.

환경 변수 CLASSPATH에 JAR 파일 경로 추가하기

명령 프롬프트에서 클라이언트 프로그램을 실행하려면 환경 변수 CLASSPATH에 JDBC Driver JAR 파일 

경로를 추가해야 한다. 다음 순서대로 CLASSPATH에 경로를 추가해 보자.

1. C:\Program Files\Java\jdk-21 안에 외부 라이브러리가 저장될 extlib 디렉토리를 생성한다.

2.  C:\Program Files\Java\jdk-21\extlib 디렉토리 안에 mysql-connector-java-8.0.25.jar 파일을 저장

한다.

3.  환경 변수 CLASSPATH에 다음과 같이 JAR 파일 경로를 추가해 준다.  

(주의: 첫 줄에는 마침표(.)가 반드시 있어야 함)





DB 연결

클라이언트 프로그램을 DB와 연결하기 위해 가장 먼저 해야 할 작업은 JDBC Driver를 메모리로 

로딩하는 것이다. Class.forName ( ) 메소드는 문자열로 주어진 JDBC Driver 클래스를 Build 

Path에서 찾고, 메모리로 로딩한다.

Class.forName("com.mysql.cj.jdbc.Driver");

이 과정에서 JDBC Driver 클래스의 static 블록이 실행되면서 DriverManager에 JDBC 

Driver 객체를 등록하게 된다. 만약 Build Path에서 JDBC Driver 클래스를 찾지 못하면 

ClassNotFoundException이 발생하므로 예외 처리를 해야 한다.

DriverManager에 JDBC Driver가 등록되면 getConnection ( ) 메소드로 DB와 연결을 할 수 

있다.

Connection conn  =  DriverManager.getConnection("연결 문자열", "사용자", "비밀번호");

첫 번째 매개값은 연결 문자열인데, DBMS마다 다른 형식을 가지고 있다. 다음은 MySQL의 연결 

문자열을 보여 준다.

jdbc :mysql ://localhost :3306/thisisjava

IP 주소

포트

DB명

localhost는 로컬에 설치된 MySQL에 연결하겠다는 의미이다. 원격 MySQL에 연결하려면 IP 주

소로 기술해야 한다. 3306은 Port 번호, thisisjava는 DB명이다. 

연결이 성공하면 getConnection ( ) 메소드는 Connection 객체를 리턴한다. 만약 연결이 실패하

면 SQLException이 발생하므로 예외 처리를 해야 한다. 





다음은 20.4에서 설치한 thisisjava DB에 연결하는 방법을 보여 준다.

**>>> ConnectionExample.java**

```java


package ch20.mysql.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
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

      System.out.println("연결 성공");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if(conn !=  null) {
        try { 
          //연결 끊기
          conn.close(); 
          System.out.println("연결 끊기");
        } catch (SQLException e) {}

      }

    }

  }

}



     
     


```

**실행 결과**

```

연결 성공

연결 끊기

연결 성공했던 DB를 끊을 때에는 Connection 객체의 close ( ) 메소드를 호출한다. 이 메소드는 

SQLException이 발생할 수 있으므로 예외 처리가 필요하다.

```