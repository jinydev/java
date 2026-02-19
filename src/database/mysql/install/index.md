---
layout: database
title: "20.2 DBMS 설치"
nav_order: 2
parent: "Chapter 24. MySQL"
grand_parent: "데이터베이스"
---

# 20.2 DBMS 설치

DBMS 마다 조금씩 다른 SQL을 사용하기 때문에 부록에서는 교육 과정에서 많이 사용되는 MySQL

을 기준으로 설명한다. 

MySQL 설치

윈도우 운영체제에서 MySQL을 설치해 보자.

  MySQL 설치 파일은 다음 URL에 접속해서 다운로드할 수 있다.

https ://dev.mysql.com/downloads/installer

  MySQL 버전(8.0.x )

은 다운로드하는 시점에 따라 

달라질 수 있다.


[Download] 버튼을 눌러 mysql-installer-web-community-8.0.25.0.msi 파일을 다

운로드한다. 다운로드하기 전에 로그인 창이 뜨는데, 로그인할 필요 없이 하단에 ‘No thanks, just 

start my download’ 링크를 클릭하면 된다.



 


  다운로드한 파일을 실행하면 다음과 같이 MySQL Installer 설치 화면이 나타난다. Choosing 

a Setup Type 단계에서 Installer가 제공하는 SW를 선택적으로 설치하기 위해 ‘Custom’을 선택

한 후 [Next] 버튼을 클릭한다.


Select Prodects 단계에서 Available Products 목록의 ‘MySQL Server 8.0.25’, ‘MySQL 

Workbench 8.0.25’, ‘Connector/J 8.0.25’를 선택하고 화살표를 눌러 오른쪽의 Products To 

Be Installed 목록으로 추가시키고 [Next] 버튼을 클릭한다.



 


Products

MySQL Server 8.0.25 - X64

설명

DBMS

MySQL Workbench 8.0.25 - X64

DB 관리 및 개발을 위한 Client Tool

Connector/J 8.0.25 - X86

JDBC Driver

  선택한 Product를 다운로드하기 위해 [Execute] 버튼을 클릭한다. 다운로드가 완료되면 [Next] 

버튼을 클릭한다.


Installation 단계에서 설치를 위해 [Execute] 버튼을 클릭한다. 설치가 완료되면 [Next] 버

튼을 클릭한다.



 


  D B M S   설정을  위해  P r o d u c t i o n 

Configuration 단계에서 [Next] 버튼을 클릭

한다.


Type  and  Networking  단계에서는 

MySQL 서버 구성 타입 및 네트워크 접속 환경

을 설정한다. 개발용 PC에 설치하므로 Config 

Type으로 ‘Development Computer’를 선

택하고, Connectivity에서는 ‘TCP/IP’의 체

크박스에 체크하고 Port는 ‘3306’으로 설정

한다. 나머지는 모두 기본 설정 그대로 두고 

[Next] 버튼을 클릭한다.


Authentication Method 단계에서는 기

본으로 체크된 내용을 그대로 두고 [Next] 버튼

을 클릭한다.



 
 


10 Accounts and Roles 단계에서는 관리자 계정인 Root의 비밀번호로 ‘mysql’을 입력한다. 

그리고 사용자 계정을 추가하기 위해 [Add User] 버튼을 클릭하고, User Name에는 ‘java’를, 

Password는 ‘mysql’을 입력해준다. [OK] 버튼을 클릭하고 [Next] 버튼을 클릭한다.

  Windows Service 단계에서는 윈도우 부

팅 시 자동 실행될 수 있도록 기본 내용을 그대

로 두고 [Next] 버튼을 클릭한다.


Apply Configuration 단계에서는 설치 시 설정해야 할 목록을 보여 준다. [Execute] 버튼을 

클릭하고 설정이 끝나면 [Finish] 버튼을 클릭한다.



 



Product Configuration에서 [Next] 버튼을 클릭하고 Install Complete에서 [Finish] 버튼

을 클릭하면 설치 과정을 모두 마치게 된다.

수동으로 3306 포트 개방하기

MySQL은 설치 과정에서 원격으로 접속할 수 있도록 3306 포트를 자동으로 개방 설정하기 때문에 지금부터 

하는 작업은 불필요할 수도 있다. 하지만 자동으로 원격 접속이 안 된다면 다음과 같이 수동으로 3306 포트를 

개방해야 한다.

01 윈도우 시작 버튼을 클릭한 후 [설정] - [업데이트 및 보안] - [Windows 보안]으로 들어가 [Windows 

보안 열기] 버튼을 클릭한다. Windows 보안 대화상자에서 [방화벽 및 네트워크 보안] - [고급 설정]을 클릭하

면 [고급 보안이 포함된 Windows Defender 방화벽] 대화상자가 나온다. 여기에서 [인바운드 규칙] - [새 규

칙]을 선택한다.



 


02 새 인바운드 규칙 마법사가 다음과 같이 실행되면 ‘포트’를 선택하고 [다음] 버튼을 클릭한다.

03 ‘TCP’를 선택하고, 특정 로컬 포트 입력란에 ‘3306’을 입력한 후 [다음] 버튼을 클릭한다.

04 ‘연결 허용’ 선택을 그대로 두고 [다음] 버튼을 클릭한다.

05 규칙이 적용되는 시기는 모두 체크된 상태로 두고 [다음] 버튼을 클릭한다.





06 규칙 이름 입력란에 ‘MySQL’이라고 입력하고, [마침] 버튼을 클릭해 닫는다.
