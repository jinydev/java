---
layout: basic
title: "4. 이클립스 프로젝트 생성"
nav_order: 4
parent: "개발 환경 구축"
grand_parent: "객체지향 자바 프로그래밍"
---

# 1.7 이클립스 프로젝트 생성

통합개발환경(IDE) 도구는 대부분 프로젝트를 먼저 생성하고 소스 파일을 작성한다. 이클립스도 마찬가지로 프로젝트를 먼저 생성하고 소스 파일을 작성해야 한다.

01 이클립스의 [File] - [New] - [Java Project] 메뉴를 선택하거나, Package Explorer 뷰에서 [Create a Java project]를 선택한다.

02 [New Java Project] 대화상자가 나타나면 [Project name]에 새 프로젝트명 'thisisjava'를 입력한다. [JRE]에서 [Use an execution environment JRE]를 'JavaSE-21'로 선택하고, [Module]에서 [Create module-info.java file]에 체크 해제한 후 [Finish] 버튼을 클릭한다.

> NOTE: Module에 대해서는 10장에서 설명한다.

> **JRE의 세 가지 선택 옵션의 차이점은 다음과 같다.**
> * **Use an execution environment JRE**
> 이클립스는 선택된 Java SE 버전 기준으로 소스 파일을 컴파일하고 실행한다. 빌드 번호와 상관없이 Java SE 버전에 중점을 둡니다. [Configure JREs] 링크를 클릭하면 선택한 Java SE 버전에 해당하는 JDK가 등록되어 있어야 한다. 환경 변수를 제대로 설정했다면 기본적으로 jdk-21이 등록되어 있을 것이다. 빌드 번호란 21.0.x를 말하며, 여기서 Java SE 버전은 21이 된다.
> * **Use a project specific JRE**
> 이클립스는 선택된 JDK 기준으로 소스 파일을 컴파일하고 실행한다. 빌드 번호별로 JDK를 선택할 때 유용하다. [Configure JREs] 링크를 클릭하면 빌드 번호에 해당하는 JDK가 등록되어 있어야 한다.
> * **Use default JRE 'jdk-21' and workspace compiler preferences**
> 이클립스의 기본 자바 버전을 사용해서 소스 파일을 컴파일하고 실행한다. [Configure JREs] 링크를 클릭했을 때 기본(default)으로 되어 있는 자바 버전을 말한다.

> **Java, JDK, JRE, Java SE 용어 정리**
> 일반적으로 Java 버전을 언급할 때에는 Java 21처럼 표현한다. 그런데 다음과 같이 다른 용어로 표현하기도 한다.
> * **Java 개발 도구에 중점:** JDK 21
> * **Java 실행 환경에 중점:** JRE 21
> * **Java 스펙 내용에 중점:** Java SE-21
> Java SE(Java Standard Edition)은 자바 개발에서부터 실행까지의 모든 환경을 정의한 스펙을 말한다. Java SE 스펙을 준수해서 만든 것이 Open JDK, Oracle JDK라고 생각하면 된다.

03 프로젝트가 성공적으로 생성되면 Package Explorer 뷰에 `thisisjava` 프로젝트가 생성된다. 프로젝트를 확장해 보면 다음과 같이 구성되어 있다.

> **이클립스에서 예제 소스 보기**
> 책에서 제공하는 예제 소스는 독자들이 학습할 때 참고할 수 있도록 프로젝트 단위로 구성되어 있다. 자료실에서 다운로드한 예제 소스 압축 파일을 `C:\ThisIsJava`에 풀었다면 `workspace-original` 디렉토리가 있을 것이다. 이 디렉토리에는 우리 책에서 생성하는 전체 프로젝트가 저장되어 있다.
> 이클립스는 워크스페이스 디렉토리가 다르면 멀티 실행이 가능하다. 독자들이 실습하는 워크스페이스는 `C:\ThisIsJava\workspace`이기 때문에 다음과 같이 이클립스를 하나 더 실행해 `C:\ThisIsJava\workspace-original`로 워크스페이스를 지정하면 된다.
> 01 이클립스를 하나 더 실행하기 위해 이클립스 바로 가기 아이콘을 클릭한다.
> 02 [Launcher] 대화상자에서 [Browse...] 버튼을 클릭해 워크스페이스 디렉토리를 `C:\ThisIsJava\workspace-original`로 선택한다. 그리고 [Launch] 버튼을 클릭하면 된다.
> 이클립스가 성공적으로 실행되면 [Package Explorer] 뷰에서 모든 프로젝트를 확인할 수 있을 것이다.
