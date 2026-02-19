---
layout: part04
title: "23.2 DBMS 설치"
nav_order: 2
parent: "Chapter 23. 데이터베이스 입출력 (Oracle)"
grand_parent: "데이터 입출력"
---

# 23.2 DBMS 설치

DBMS마다 조금씩 다른 SQL을 사용하기 때문에 이 책에서는 개발자 교육과정 중 기업체에서 가장 많이 요구하는 Oracle을 기준으로 설명한다.

## Oracle 설치

*(본문 내용은 Oracle 19c 설치 과정을 상세히 설명하고 있음. 상세 스크린샷 및 단계별 설명은 생략하고 핵심 내용만 기술함)*

1.  오라클 공식 웹사이트에서 Windows x64용 Oracle Database 19c 설치 파일(`WINDOWS.X64_193000_db_home.zip`)을 다운로드한다.
2.  `C:\Oracle` 디렉토리에 압축을 해제한다. (반드시 이 경로여야 함)
3.  `setup.exe`를 실행하여 설치를 진행한다.
4.  설치 과정에서 '단일 인스턴스 데이터베이스 생성', '데스크톱 클래스' 등을 선택한다.
5.  Oracle Base는 `C:\Oracle`로 설정하고, 비밀번호는 `oracle`로 설정한다. '컨테이너 데이터베이스로 생성' 체크는 해제한다.
6.  설치가 완료되면 `sqlplus`를 이용해 관리자 계정 생명 주기 제한을 푼다.
    ```sql
    sqlplus / as sysdba
    alter profile default limit password_life_time unlimited;
    ```
7.  학습에 사용할 DB 계정 `java`를 생성하고 권한을 부여한다.
    ```sql
    create user java identified by oracle;
    grant connect to java;
    grant resource to java;
    grant unlimited tablespace to java;
    ```

## 원격 연결

Oracle을 설치하면 기본적으로 로컬(설치된 컴퓨터) 환경에서만 Oracle에 연결할 수 있다. 원격(외부 컴퓨터)에서 Oracle에 연결해서 사용하려면 'Net Configuration Assistant'를 실행하여 리스너(LISTENER)를 재구성해야 한다.

## 방화벽 해제

윈도우 방화벽 설정에서 1521 포트에 대한 인바운드 규칙을 추가하여 포트를 개방해야 한다.
