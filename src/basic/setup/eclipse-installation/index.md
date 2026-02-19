---
layout: basic
title: "3. 이클립스 설치"
nav_order: 3
parent: "개발 환경 구축"
grand_parent: "객체지향 자바 프로그래밍"
---

# 1.6 이클립스 설치

자바 프로그램을 개발할 때에는 편리한 기능을 갖춘 통합개발환경(Integrated Development Environment, IDE)을 사용하는 것이 좋다. 현재 기업체에서 가장 많이 사용하는 통합개발환경은 이클립스(Eclipse)이다. 따라서 이 책을 학습할 때에도 이클립스를 사용하는 것이 좋다. 다음 순서에 따라 이클립스를 설치해 보자.

01 이클립스 사이트에 접속한다.
https://www.eclipse.org

02 페이지 오른쪽 상단에 있는 [Download] 버튼을 클릭한다.

03 다운로드 화면이 나타나면 [Install your favorite desktop IDE packages]의 [Download Packages] 링크를 클릭한다.
[Download x86_64] 버튼을 클릭해 설치 파일을 다운로드할 수도 있지만, 우리 책에서는 원하는 디렉토리에 저장하기 위해 압축 파일 형태로 다운로드할 것이다.

> **이클립스의 버전**
> 자바 21을 지원하는 이클립스 최소 버전은 Eclipse IDE 2023-12이므로 이보다 낮은 버전을 다운로드하면 안 된다. 가능하면 가장 최신에 릴리즈된 이클립스를 사용하는 것이 좋다.

04 [Eclipse Packages] 탭에서 [Eclipse IDE for Java Developers]의 오른쪽 링크를 클릭해 자신의 운영체제에 맞는 설치 파일을 다운로드한다.

| 운영체제                 | 설치 파일명                                     |
| :----------------------- | :---------------------------------------------- |
| Windows x64(인텔칩)      | eclipse-java-2023-12-R-win32-x86_64.zip         |
| macOS x64(인텔칩)        | eclipse-java-2023-12-R-macosx-cocoa-x86_64.dmg  |
| macOS aarch64(애플(M)칩) | eclipse-java-2023-12-R-macosx-cocoa-aarch64.dmg |

> **이클립스의 설치 파일**
> 이클립스는 개발 내용에 따라 여러 가지 설치 파일을 제공한다. 독자 여러분들이 이 책을 학습한 후에 웹 애플리케이션 개발을 계속 학습한다면 [Eclipse IDE for Enterprise Java and Web Developers] 다운로드하는 것이 좋다.

05 다운로드한 파일을 운영체제에 맞게 다음과 같이 설치한다.

**윈도우**
ZIP 파일을 압축 해제하면 나오는 `eclipse` 폴더를 다음 경로로 옮긴다(`ThisIsJava` 폴더는 여러분이 직접 생성해야 한다).
`C:\ThisIsJava\eclipse`

`C:\ThisIsJava\eclipse` 경로에 있는 `eclipse.exe`를 마우스 오른쪽 버튼으로 클릭한 후 [바로 가기 만들기]를 선택해 바로 가기 아이콘을 생성한다. 그리고 생성된 바로 가기 아이콘을 작업 표시줄 또는 바탕 화면으로 이동시켜 언제든지 이클립스를 실행할 수 있도록 한다.

> NOTE: 마우스 오른쪽 버튼을 클릭하면 나타나는 팝업 메뉴에서 [바로 가기 만들기]가 보이지 않는다면 [추가 옵션 표시]를 선택하면 [바로 가기 만들기] 메뉴를 확인할 수 있다.

**맥OS**
DMG 파일을 더블 클릭하면 나타나는 다음 화면에서 Eclipse 아이콘을 Applications 폴더로 끌어 놓으면 자동으로 설치된다.

06 이클립스 바로 가기 아이콘을 더블 클릭하면 다음과 같이 [Eclipse IDE Launcher] 대화상자가 나타난다. 프로젝트가 저장될 워크스페이스(Workspace) 디렉토리를 운영체제에 맞게 다음과 같이 설정한다.

**윈도우**
[Workspace]를 `C:\ThisIsJava\workspace`로 지정하고 [Launch] 버튼을 클릭하면 이클립스가 실행된다.

**맥OS**
[Workspace]를 `/Users/사용자홈/ThisIsJava/workspace`로 지정하고 [Launch] 버튼을 클릭하면 이클립스가 실행된다.

> NOTE: [Eclipse IDE Launcher] 대화상자 하단에 있는 [Use this as the default and do not ask again]에 체크하면 이클립스를 재시작할 때 [Eclipse IDE Launcher] 대화상자가 나타나지 않고 바로 이클립스가 실행된다.

07 다음은 이클립스를 실행한 화면이다. 앞으로 [Welcome] 탭이 나오지 않도록 하단의 [Always show Welcome at start up]을 체크 해제하고, [Welcome] 탭의 [x] 버튼을 클릭해 닫는다.

08 설치 후 화면은 다음과 같다.
