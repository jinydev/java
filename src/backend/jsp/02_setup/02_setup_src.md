---
layout: backend
title: "1.2 개발 환경 구축"
nav_order: 2
parent: "1주차. 웹 서버와 환경 설정"
grand_parent: "백엔드 웹서버 개발"
---

# 1.2 개발 환경 구축 (JDK, Tomcat)

## 1. JDK 설치 확인
백엔드 개발을 위해서는 JDK(Java Development Kit)가 필수입니다. 터미널(CMD)을 열어 설치 여부를 확인합니다.

```bash
java -version
```
> 설치가 안 되어 있다면 [JDK 설치](/basic/setup/jdk-installation) 강좌를 참고하여 설치해주세요. (JDK 17 이상 권장)

---

## 2. Apache Tomcat 설치
자로 만든 웹 애플리케이션을 실행하려면 WAS가 필요합니다. 무료이면서 가장 널리 쓰이는 **Tomcat**을 설치합니다.

1. **다운로드**: [Tomcat 공식 홈페이지](https://tomcat.apache.org/) 접속 -> Download -> Tomcat 10 선택
2. **압축 해제**: `Core` 항목의 `zip` (Windows) 또는 `tar.gz` (Mac/Linux) 다운로드 후 원하는 경로에 압축 해제
   - 예: `C:\Tyomcat\apache-tomcat-10.1.xx` 또는 `/usr/local/apache-tomcat-10.1.xx`

---

## 3. IDE 설정 (IntelliJ IDEA 기준)
이클립스 사용자도 비슷한 흐름으로 'Server' 탭에서 톰캣을 등록하면 됩니다. 여기서는 IntelliJ Ultimate(유료) 또는 Community(무료, 스마트 톰캣 플러그인 필요) 기준으로 설명합니다.

### IntelliJ Ultimate (추천)
1. **프로젝트 생성**: New Project -> Jakarta EE (또는 Java Enterprise)
2. **설정**:
   - Template: Web Application
   - Application Server: [New] -> Tomcat Server -> Tomcat Home에 압축 푼 경로 지정
   - Language: Java
   - Build system: Maven or Gradle (여기서는 **Maven** 권장)
   - JDK: 설치된 JDK 선택
3. **생성**: `Create` 클릭

### IntelliJ Community (무료 버전)
1. 플러그인 설치: Settings -> Plugins -> **Smart Tomcat** 검색 및 설치
2. 프로젝트 생성: New Project -> Maven -> Archetype: `maven-archetype-webapp` 선택
3. 실행 구성: Run/Debug Configurations -> (+) -> Smart Tomcat
   - Tomcat server: Configure... -> 톰캣 경로 추가
   - Deployment Directory: `src/main/webapp` 선택
   - Context Path: `/`

---

## 4. 서버 실행 테스트
1. `src/main/webapp/index.jsp` 파일을 엽니다.
2. `<body>` 태그 안에 `<h2>Hello Backend!</h2>`를 적습니다.
3. IDE 상단 실행(Run) 버튼 클릭
4. 브라우저가 열리며 `http://localhost:8080/` 에서 "Hello Backend!"가 보이면 성공!
