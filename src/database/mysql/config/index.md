---
layout: database
title: "20.4 DB 구성"
nav_order: 4
parent: "Chapter 24. MySQL"
grand_parent: "데이터베이스"
---

# 20.4 DB 구성

이제 Workbench에서 학습용 DB와 Table을 생성해 보자.

DB 생성

  MySQL에서는 DB를 스키마Schema라고 부르

므로, Navigator 뷰 하단의 [Schemas] 탭을 선

택해서 Schema 리스트로 전환한 다음 DB 생성

을 위해 툴바에서 

 아이콘을 클릭한다. 

  Name 입력란에 ‘thisisjava’라고 입력하고, Charset/Collation에서 드롭다운 버튼을 클릭해 

각각 ‘utf8’과 ‘utf8_general_ci’로 변경한 다음 [Apply] 버튼을 클릭한다. 


Review SQL Script 단계에서 [Apply] 버튼을, Apply SQL Script 단계에서 [Finish] 버튼을 

차례대로 클릭한다.



 


  성공적으로 DB가 생성되면 Navigator 뷰에 

thisisjava가 다음과 같이 생성된다. thisisjava를 

선택하고 마우스 오른쪽 버튼을 클릭하여 [Set as 

Default Schema]를 선택해 java 계정의 기본Default 

스키마로 설정한다.

Table 생성

  사용자 정보가 저장될 users 테이블을 생성하기 위해 예제소스 sql/mysql/users.sql 파일의 

텍스트 내용을 복사해 Workbench의 Query 편집기에 붙여 넣는다. 그리고 마우스로 모든 코드를 

선택한 다음 실행을 위해 번개 모양 아이콘(

)을 클릭한다.

  게시물 정보가 저장될 boards 테이블을 생성하기 위해 예제소스 sql/mysql/boards.sql 파

일의 텍스트 내용을 복사해 Workbench의 Query 편집기에 붙여 넣는다. 그리고 마우스로 모든 

코드를 선택한 다음 실행을 위해 번개 모양 아이콘(

)을 클릭한다.





  계좌 정보가 저장될 accounts 테이블을 생성하기 위해 예제소스 sql/mysql/accounts.sql 

파일의 텍스트 내용을 복사해 Workbench의 Query 편집기에 붙여 넣는다. 그리고 create 문에

서 insert 문까지 모든 코드를 마우스로 선택한 다음 실행을 위해 번개 모양 아이콘(

)을 클릭한다.


3개의 테이블이 모두 성공적으로 생성되었다면 SCHEMAS 

뷰에서 Tables를 확장했을 때 다음과 같이 테이블 이름들이 보

여야 한다. 만약 보이지 않는다면 우측 상단의 아이콘(

)을 클

릭해서 목록을 갱신시킨다.
