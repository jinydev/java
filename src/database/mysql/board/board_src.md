---
layout: database
title: "20.11 게시판 구현"
nav_order: 11
parent: "MySQL"
grand_parent: "데이터베이스"
---

# 20.11 게시판 구현

지금까지 학습한 JDBC를 활용해서 명령 프롬프트(윈도우) 또는 터미널(맥OS )에서 실행되는 게

시판을 구현해 보자. 게시판은 기본적인 CRUD (Create, Read, Update, Delete ) 기능이 포함되

어 있어 가장 좋은 실습 주제 중 하나이다.

메인 메뉴

BoardExample 클래스를 실행하면 다음과 같은 게시물 목록과 함께 메뉴가 나오도록 작성해 보자.






**실행 결과**

```

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title     

-----------------------------------------------------------------------

1     winter      2022-01-27     게시판에 오신 것을 환영합니다.                        
2     winter      2022-01-27     올 겨울은 많이 춥습니다.                           

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택:

먼저 list ( ), mainMenu ( ), main ( )  메소드를  다음과  같이  작성한다. main ( )  메소드는 

BoardExample 객체를 생성하고 list ( ) 메소드를 호출한다. list ( ) 메소드는 게시물 목록을 출력

하고 mainMenu ( ) 메소드를 호출한다.

```
**>>> BoardExample1.java**

```java


package ch20.mysql.sec11;

public class BoardExample1 {
  //Field

  //Constructor

  //Method  
  public void list() {
    System.out.println();
    System.out.println("[게시물 목록]");
    System.out.println("-------------------------------------------------------");
    System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
    System.out.println("-------------------------------------------------------");
    System.out.printf("%-6s%-12s%-16s%-40s \n", 
        "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
    System.out.printf("%-6s%-12s%-16s%-40s \n", 
        "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
    mainMenu();

  }



 
 



  public void mainMenu() {
    System.out.println();
    System.out.println("-------------------------------------------------------");
    System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
    System.out.print("메뉴 선택: ");
    System.out.println();

  } 

  public static void main(String[] args) {
    BoardExample1 boardExample  =  new BoardExample1();
    boardExample.list();

  }

}

메인 메뉴 선택 기능

메인 메뉴 1부터 4 중 하나를 선택하면 다음과 같이 해당 메소드가 실행되도록 작성해 보자.

```

**실행 결과**

```

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

1     winter      2022.01.27      게시판에 오신 것을 환영합니다.                        
2     winter      2022.01.27      올 겨울은 많이 춥습니다.                           

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 1

*** create() 메소드 실행됨

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

1     winter      2022.01.27      게시판에 오신 것을 환영합니다.                        



 
 


2     winter      2022.01.27      올 겨울은 많이 춥습니다.                           

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 2

*** read() 메소드 실행됨

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

1     winter      2022.01.27      게시판에 오신 것을 환영합니다.                        
2     winter      2022.01.27      올 겨울은 많이 춥습니다.                           

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 3

*** clear() 메소드 실행됨

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

1     winter      2022.01.27      게시판에 오신 것을 환영합니다.                        
2     winter      2022.01.27      올 겨울은 많이 춥습니다.                           

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 4

키보드 입력을 받기 위해 Scanner 필드를 추가하고(7라인), mainMenu ( ) 메소드에서 키보드 입

력을 받기 위해 nextLine ( ) 메소드를 호출한다(30라인). 그리고 메뉴 선택 번호에 따라 해당 메소

드를 호출한다(33~38라인). 





```
**>>> BoardExample2.java**

```java


package ch20.mysql.sec11;

import java.util.Scanner;

public class BoardExample2 {
  //Field
  private Scanner scanner  =  new Scanner(System.in);

  //Constructor

  //Method 
  public void list() {
    System.out.println();
    System.out.println("[게시물 목록]");
    System.out.println("-------------------------------------------------------");
    System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
    System.out.println("-------------------------------------------------------");
    System.out.printf("%-6s%-12s%-16s%-40s \n", 
        "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
    System.out.printf("%-6s%-12s%-16s%-40s \n", 
        "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
    mainMenu();

  }

  public void mainMenu() {
    System.out.println();
    System.out.println("-------------------------------------------------------");
    System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
    System.out.print("메뉴 선택: ");
    String menuNo  =  scanner.nextLine();
    System.out.println();

    switch(menuNo) {
      case "1" -> create();
      case "2" -> read();
      case "3" -> clear();
      case "4" -> exit();

    }



 
 
 
   



  } 

  public void create() {
    System.out.println("*** create() 메소드 실행됨");
    list();

  }

  public void read() {
    System.out.println("*** read() 메소드 실행됨");
    list();

  }

  public void clear() {
    System.out.println("*** clear() 메소드 실행됨");
    list();

  }

  public void exit() {
    System.exit(0);

  }

  public static void main(String[] args) {
    BoardExample2 boardExample  =  new BoardExample2();
    boardExample.list();

  }

}

Board 클래스 작성

boards 테이블의 한 개의 행(게시물)을 저장할 Board 클래스를 작성한다. 컬럼 개수와 타입에 맞

게 필드를 선언하고, 롬복 @Data 어노테이션을 이용해서 Getter, Setter, toString ( ) 메소드를 자

동 생성시킨다. 



 
 
 
 
 


```
**>>> Board.java**

```java


package ch20.mysql.sec11;

import java.util.Date;
import lombok.Data;

@Data
public class Board {
  private int bno;
  private String btitle;
  private String bcontent;
  private String bwriter;
  private Date bdate;

}

boards 테이블에는 bfilename과 bfiledata 컬럼이 있지만, 이번 게시판 구현에서는 첨부 파일은 

제외할 것이므로 필드로 선언하지 않는다.

게시물 목록 기능

boards 테이블에서 모든 게시물 정보들을 가져온 다음 게시물 목록으로 출력시켜 보자. 

```

**실행 결과**

```

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

3     winter      2022-01-27      봄의 정원                                    
2     winter      2022-01-27      크리스마스                                    
1     winter      2022-01-27      눈 오는 날                                    

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택:





DB 연결이 필요하므로 Connection 필드를 추가하고(15라인), 생성자에서 DB 연결을 한다

(18~33라인). 그리고 boards 테이블에서 게시물 정보들을 가져와서 게시물 목록으로 출력하도록 

list ( ) 메소드를 수정한다(36~74라인).

```
**>>> BoardExample3.java**

```java


package ch20.mysql.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ch20.mysql.sec11.Board;

public class BoardExample3 {
  //Field
  private Scanner scanner  =  new Scanner(System.in);
  private Connection conn;

  //Constructor
  public BoardExample3() {
    try {
      //JDBC Driver 등록
      Class.forName("com.mysql.cj.jdbc.Driver");

      //연결하기
      conn  =  DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/thisisjava", 
        "java", 
        "mysql"

      );
    } catch(Exception e) {
      e.printStackTrace();
      exit();

    }

  }



 
     



  //Method 
  public void list() {
    //타이틀 및 컬럼명 출력
    System.out.println();
    System.out.println("[게시물 목록]");
    System.out.println("-------------------------------------------------------");
    System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
    System.out.println("-------------------------------------------------------");

    //boads 테이블에서 게시물 정보를 가져와서 출력하기
    try {
      String sql  =  "" +
        "SELECT bno, btitle, bcontent, bwriter, bdate " +
        "FROM boards " + 
        "ORDER BY bno DESC";
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      ResultSet rs  =  pstmt.executeQuery();
      while(rs.next()) { 
        Board board  =  new Board();
        board.setBno(rs.getInt("bno"));
        board.setBtitle(rs.getString("btitle"));
        board.setBcontent(rs.getString("bcontent"));
        board.setBwriter(rs.getString("bwriter"));
        board.setBdate(rs.getDate("bdate"));
        System.out.printf("%-6s%-12s%-16s%-40s \n", 
            board.getBno(), 
            board.getBwriter(),
            board.getBdate(),
            board.getBtitle());

      }
      rs.close();
      pstmt.close();
    } catch(SQLException e) {
      e.printStackTrace();
      exit();

    }

    //메인 메뉴 출력
    mainMenu();



 
   
 
   



… 

  }

//이하 동일

…

게시물 생성 기능

메인 메뉴에서 ‘1.Create’를 선택하면 새로운 게시물의 제목, 내용, 작성자를 키보드로 입력받고, 보

조 메뉴에서 ‘1.Ok’를 선택하면 boards 테이블에 새로운 게시물이 저장되도록 해보자. 

```

**실행 결과**

```

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 1

[새 게시물 입력]
제목: 여름에 가장 시원할 때
내용: 에어컨이 나오는 강의실에서 자바 공부할 때입니다^^.
작성자: summer

-----------------------------------------------------------------------

보조 메뉴: 1.Ok | 2.Cancel
메뉴 선택: 1

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title       

-----------------------------------------------------------------------

4     summer      2022-01-27      여름에 가장 시원할 때 
3     winter      2022-01-27      봄의 정원           
2     winter      2022-01-27      크리스마스          
1     winter      2022-01-27      눈 오는 날          

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택:



 


메인 메뉴에서 ‘1.Create’를 선택했을 때 호출되는 create ( ) 메소드를 다음과 같이 수정한다. 

```
**>>> BoardExample4.java**

```java


… 


//이상 동일

…

  public void create() {
    //입력 받기
    Board board  =  new Board();
    System.out.println("[새 게시물 입력]");
    System.out.print("제목: ");  
    board.setBtitle(scanner.nextLine());
    System.out.print("내용: ");  
    board.setBcontent(scanner.nextLine());
    System.out.print("작성자: ");  
    board.setBwriter(scanner.nextLine());

    //보조 메뉴 출력
    System.out.println("-------------------------------------------------------");
    System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
    System.out.print("메뉴 선택: ");
    String menuNo  =  scanner.nextLine();
    if(menuNo.equals("1")) {
      //boards 테이블에 게시물 정보 저장
      try {
        String sql  =  "" +
          "INSERT INTO boards (btitle, bcontent, bwriter, bdate) " +
          "VALUES (?, ?, ?, now())";
        PreparedStatement pstmt  =  conn.prepareStatement(sql);
        pstmt.setString(1, board.getBtitle());
        pstmt.setString(2, board.getBcontent());
        pstmt.setString(3, board.getBwriter());
        pstmt.executeUpdate();
        pstmt.close();
      } catch (Exception e) {
        e.printStackTrace();
        exit();

      }

    }



   



    //게시물 목록 출력
    list();

  }

//이하 동일

… 

…

게시물 읽기 기능

메인 메뉴에서 ‘2.Read’를 선택했을 때 게시물의 번호를 키보드로 입력받고, boards 테이블에 있는 

해당 게시물을 가져와서 출력해 보자.

```

**실행 결과**

```

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

4     summer      2022-01-27      여름에 가장 시원할 때                             
3     winter      2022-01-27      봄의 정원                                    
2     winter      2022-01-27      크리스마스                                    
1     winter      2022-01-27      눈 오는 날                                    

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 2

[게시물 읽기]
bno: 4

#############

번호: 4
제목: 여름에 가장 시원할 때
내용: 에이컨이 나오는 강의실에서 자바 공부할 때입니다^^.
작성자: summer
날짜: 2022-01-27

#############



   


메인 메뉴에서 ‘2.Read’를 선택했을 때 호출되는 read ( ) 메소드를 다음과 같이 수정한다. 

```
**>>> BoardExample5.java**

```java


… 


//이상 동일

…

  public void read() {

    //입력받기
    System.out.println("[게시물 읽기]");
    System.out.print("bno: ");  
    int bno  =  Integer.parseInt(scanner.nextLine());

    //boards 테이블에서 해당 게시물을 가져와 출력
    try {
      String sql  =  "" +
        "SELECT bno, btitle, bcontent, bwriter, bdate " +
        "FROM boards " +
        "WHERE bno = ?";
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      pstmt.setInt(1, bno);
      ResultSet rs  =  pstmt.executeQuery();
      if(rs.next()) {
        Board board  =  new Board();
        board.setBno(rs.getInt("bno"));
        board.setBtitle(rs.getString("btitle"));
        board.setBcontent(rs.getString("bcontent"));
        board.setBwriter(rs.getString("bwriter"));
        board.setBdate(rs.getDate("bdate"));
        System.out.println("#############");
        System.out.println("번호: " + board.getBno());
        System.out.println("제목: " + board.getBtitle());
        System.out.println("내용: " + board.getBcontent());
        System.out.println("작성자: " + board.getBwriter());
        System.out.println("날짜: " + board.getBdate());
        System.out.println("#############");

      }
      rs.close();
      pstmt.close();
    } catch (Exception e) {



   



      e.printStackTrace();
      exit();

    }

    //게시물 목록 출력
    list();

  }

//이하 동일

… 

…

게시물 수정 기능

게시물 읽기에서 보조 메뉴를 추가하고, 보조 메뉴에서 ‘1.Update’를 선택했을 때 제목, 내용, 작성

자의 수정 내용을 입력할 수 있도록 해보자. 그리고 보조 메뉴에서 ‘1.Ok’를 선택했을 때 boards 테

이블의 해당 게시물을 수정하도록 해보자.

```

**실행 결과**

```

[게시물 읽기]
bno: 3

#############

번호: 3
제목: 봄의 정원
내용: 정원의 꽃이 예쁘네요.
작성자: winter
날짜: 2022-01-27

-----------------------------------------------------------------------

보조 메뉴: 1.Update | 2.Delete | 3.List
메뉴 선택: 1

[수정 내용 입력]
제목: 봄이 왔어요.
내용: 들에는 꽃들이 만발했네요.
작성자: spring

-----------------------------------------------------------------------

보조 메뉴: 1.Ok | 2.Cancel
메뉴 선택: 1



   


[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

4     summer      2022-01-27      여름에 가장 시원할 때                             
3     spring      2022-01-27      봄이 왔어요.                                   
2     winter      2022-01-27      크리스마스                                    
1     winter      2022-01-27      눈 오는 날                                    

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택:

read ( ) 메소드에서 보조 메뉴 ‘1.Update | 2.Delete | 3.List’를 추가하고, 보조 메뉴에서 

‘1.Update’를 선택하면 update ( ) 메소드가, ‘2.Delete’를 선택하면 delete ( ) 메소드가 호출되도

록 한다. update ( ) 메소드는 매개값으로 받은 Board 객체를 수정해서 boards 테이블의 게시물 

정보를 수정하도록 한다.

```
**>>> BoardExample6.java**

```java


… 


//이상 동일

…

public void read() {

… 

  …


  System.out.println("#############");
  System.out.println("번호: " + board.getBno());
  System.out.println("제목: " + board.getBtitle());
  System.out.println("내용: " + board.getBcontent());
  System.out.println("작성자: " + board.getBwriter());
  System.out.println("날짜: " + board.getBdate());
  //보조 메뉴 출력
  System.out.println("----------------------");
  System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
  System.out.print("메뉴 선택: ");
  String menuNo  =  scanner.nextLine();
  System.out.println();

  if(menuNo.equals("1")) {



  



… 


    update(board);
  } else if(menuNo.equals("2")) {
    delete(board);

  }

  …

}   

  public void update(Board board) {
    //수정 내용 입력받기
    System.out.println("[수정 내용 입력]");
    System.out.print("제목: ");  
    board.setBtitle(scanner.nextLine());
    System.out.print("내용: ");  
    board.setBcontent(scanner.nextLine());
    System.out.print("작성자: ");  
    board.setBwriter(scanner.nextLine());

    //보조 메뉴 출력
    System.out.println("------------------------------------------------------");
    System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
    System.out.print("메뉴 선택: ");
    String menuNo  =  scanner.nextLine();
    if(menuNo.equals("1")) {
      //boards 테이블에서 게시물 정보 수정
      try {
        String sql  =  "" +
          "UPDATE boards SET btitle = ?, bcontent = ?, bwriter = ? " +
          "WHERE bno = ?";
        PreparedStatement pstmt  =  conn.prepareStatement(sql);
        pstmt.setString(1, board.getBtitle());
        pstmt.setString(2, board.getBcontent());
        pstmt.setString(3, board.getBwriter());
        pstmt.setInt(4, board.getBno());
        pstmt.executeUpdate();
        pstmt.close();
      } catch (Exception e) {
        e.printStackTrace();
        exit();

      }

    }



   



… 

    //게시물 목록 출력
    list();

  }

//이하 동일

…

게시물 삭제 기능

게시물 읽기의 보조 메뉴에서 ‘2.Delete’를 선택했을 때 boards 테이블에서 해당 게시물을 삭제하

도록 해보자.

```

**실행 결과**

```

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

4     summer      2022-01-27      여름에 가장 시원할 때       
3     spring      2022-01-27      봄이 왔어요.                                   
2     winter      2022-01-27      크리스마스                                    
1     winter      2022-01-27      눈 오는 날                                    

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 2

[게시물 읽기]
bno: 4

#############

번호: 4
제목: 여름에 가장 시원할 때
내용: 에이컨이 나오는 강의실에서 자바 공부할 때입니다^^.
작성자: summer
날짜: 2022-01-27

-----------------------------------------------------------------------

보조 메뉴: 1.Update | 2.Delete | 3.List
메뉴 선택: 2



   
 


[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

3     spring      2022-01-27      봄이 왔어요.                                   
2     winter      2022-01-27      크리스마스                                    
1     winter      2022-01-27      눈 오는 날                                    

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택:

게시물 수정 기능을 구현할 때 보조 메뉴에서 ‘2.Delete’를 선택했을 때 delete ( ) 메소드가 호출되

도록 하였다. delete ( ) 메소드를 다음과 같이 수정해 매개값으로 받은 Board 객체에서 bno를 얻

어 boards 테이블에서 해당 게시물을 삭제하도록 한다.

```
**>>> BoardExample7.java**

```java


… 


//이상 동일 

…

  public void delete(Board board) {
    //boards 테이블에 게시물 정보 삭제
    try {
      String sql  =  "DELETE FROM boards WHERE bno = ?";
      PreparedStatement pstmt  =  conn.prepareStatement(sql);
      pstmt.setInt(1, board.getBno());
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
      exit();

    }

    //게시물 목록 출력	
    list();

  }

//이하 동일

… 

…



   
	


게시물 전체 삭제 기능

메인 메뉴에서 ‘3.Clear’를 선택하고 보조 메뉴에서 ‘1.Ok’를 선택했을 때 boards 테이블의 전체 

게시물 정보를 삭제하도록 해보자. 

```

**실행 결과**

```

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

3     spring      2022-01-27      봄이 왔어요.                                   
2     winter      2022-01-27      크리스마스                                    
1     winter      2022-01-27      눈 오는 날                                    

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 3

[게시물 전체 삭제]

-----------------------------------------------------------------------

보조 메뉴: 1.Ok | 2.Cancel
메뉴 선택: 1

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   
----------------------------------------------------------------------- 

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택:

메인 메뉴에서 ‘3.Clear’를 선택했을 때 호출되는 clear ( ) 메소드를 다음과 같이 수정한다.

```
**>>> BoardExample8.java**

```java


… 


//이상 동일

…

  public void clear() {






    System.out.println("[게시물 전체 삭제]");
    System.out.println("-------------------------------------------------------");
    System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
    System.out.print("메뉴 선택: ");
    String menuNo  =  scanner.nextLine();
    if(menuNo.equals("1")) {
      //boards 테이블에 게시물 정보 전체 삭제
      try {
        String sql  =  "TRUNCATE TABLE boards";
        PreparedStatement pstmt  =  conn.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();
      } catch (Exception e) {
        e.printStackTrace();
        exit();

      }

    }

    //게시물 목록 출력
    list();

  }

//이하 동일

… 

…

종료 기능

메인 메뉴에서 ‘4.Exit’를 선택하면 Connection을 닫고 프로그램을 종료시켜 보자. 

```

**실행 결과**

```

[게시물 목록]

-----------------------------------------------------------------------

no    writer      date            title                                   

-----------------------------------------------------------------------

-----------------------------------------------------------------------

메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit
메뉴 선택: 4

** 게시판 종료 **



     


메인 메뉴에서 ‘4.Exit’를 선택했을 때 호출되는 exit ( ) 메소드를 다음과 같이 수정한다.

```
**>>> BoardExample9.java**

```java


… 


//이상 동일

…

  public void exit() {
    if(conn !=  null) {
      try {
        conn.close();
      } catch (SQLException e) {

      }

    }
    System.out.println("** 게시판 종료 **");
    System.exit(0);

  }

//이하 동일

… 

…

  전체 코드는 예제소스 파일을 참조한다.

게시판 구현은 여기에서 마무리를 짓고, 사용자 가입 기능 및 로그인 기능은 배운 내용을 토대로 상

상력을 발휘해서 구현해보길 바란다.

```