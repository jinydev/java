---
layout: database
title: "20.3 Client Tool 설치"
nav_order: 3
parent: "MySQL"
grand_parent: "데이터베이스"
---

# 20.3 Client Tool 설치

MySQL Workbench는 DB 개발 및 관리에 사용되는 Client Tool이다. MySQL 설치 과정에서 

같이 설치되었기 때문에 추가로 설치할 필요가 없다. 설치가 완료되면 자동으로 실행되지만, 시작 메

뉴에서 [MySQL] - [MySQL Workbench x.x CE]를 선택해서 실행해도 된다.

MySQL 설치 과정에서 java 사용자 계정을 추가했기 때문에 사용자 계정을 생성하는 과정은 생략하

고 여기에서는 접속 방법만 알아보자. Workbench에서 MySQL Connections 바로 옆의 

 아이

콘을 클릭한다. Setup New Connection 화면에서 다음과 같이 입력한 후 [OK] 버튼을 클릭한다.





● Connection Name : ‘thisisjava’ 입력

● Username : ‘java’ 입력

● Password : [Store in Vault] 버튼 클릭 

● Store Password For Connection 대화상자의 Password : ‘mysql’ 입력 - [OK] 버튼 클릭

오른쪽 화면과 같이 연결 정보 박스가 생성되면 마우스로 클릭

한다.

다음은 성공적으로 접속된 화면이다.
