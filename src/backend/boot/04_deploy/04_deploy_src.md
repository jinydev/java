---
layout: backend
title: "3.4 빌드 및 배포"
nav_order: 9
parent: "3주차. Spring Boot 시작하기"
grand_parent: "백엔드 웹서버 개발"
---

# 3.4 빌드 및 배포

개발이 완료된 애플리케이션을 서버에 배포하는 방법입니다.

## 1. Jar 파일로 빌드 (내장 톰캣 사용)
Spring Boot의 가장 큰 장점은 웹 서버(Tomcat)를 내장하고 있어, 별도의 톰캣 설치 없이 `java -jar` 명령어로 바로 실행 가능한 Jar 파일을 만들 수 있다는 점입니다.

### Maven 빌드
터미널에서 프로젝트 루트 경로로 이동 후:
```bash
./mvnw clean package
```
빌드가 성공하면 `target` 폴더 안에 `demo-0.0.1-SNAPSHOT.jar` 같은 파일이 생성됩니다.

### 실행
```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```
이제 서버의 8080 포트로 접속할 수 있습니다.

---

## 2. 외부 Tomcat에 배포 (War 파일)
만약 이미 운영 중인 Tomcat 서버에 배포해야 한다면 `War` 파일로 빌드해야 합니다.

1. `DemoApplication.java` 수정: `SpringBootServletInitializer` 상속 및 `configure` 오버라이딩
2. `pom.xml` 수정: `<packaging>war</packaging>` 추가
3. 빌드: `./mvnw clean package`
4. 생성된 `.war` 파일을 톰캣의 `webapps` 폴더에 복사하고 톰캣 실행

> **권장**: 최근에는 클라우드 환경(AWS, Docker)과 마이크로서비스 아키텍처(MSA)가 대세가 되면서 **Jar 배포** 방식이 훨씬 더 많이 사용됩니다.
