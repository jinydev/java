---
layout: part01
title: "Chapter 01. 자바 시작하기"
permalink: /part01/01/
---

# Part 01

## 자바 언어의 기초

# Chapter 01

## 자바 시작하기

**목차**

* 1.1 프로그래밍 언어와 자바
* 1.2 운영체제별 JDK 설치
* 1.3 운영체제별 환경 변수 설정
* 1.4 바이트코드 파일과 자바 가상 머신
* 1.5 소스 작성부터 실행까지
* 1.6 이클립스 설치
* 1.7 이클립스 프로젝트 생성
* 1.8 이클립스 소스 작성부터 실행까지
* 1.9 코드 용어 이해
* 1.10 코드 주석 달기
* 1.11 실행문과 세미콜론

### 1.1 프로그래밍 언어와 자바

컴퓨터가 이해할 수 있는 기계어(machine language)는 우리가 일상생활에서 사용하는 언어와는 너무나도 다르게 0과 1로 이루어진 이진 코드를 사용한다. 따라서 사람이 이해하기에는 매우 어렵다. 반대로 사람이 사용하는 언어는 컴퓨터 입장에서 보면 이해할 수 없는 문자의 집합이다. 그렇기 때문에 사람과 컴퓨터가 대화하기 위해서는 사람의 언어와 기계어의 다리 역할을 하는 프로그래밍 언어가 필요하다.

프로그래밍 언어는 고급 언어와 저급 언어로 구분된다. 고급 언어란 컴퓨터와 대화할 수 있도록 만든 언어 중에서 사람이 쉽게 이해할 수 있는 언어를 말한다. 고급 언어로 작성된 소스 파일은 컴퓨터가 바로 이해할 수 없기 때문에 컴파일(compile)이라는 과정을 통해 컴퓨터가 이해할 수 있는 0과 1로 이루어진 기계어로 변환한 후 사용해야 한다. 반대로 저급 언어란 기계어에 가까운 언어를 말하며, 대표적으로 어셈블리어가 이에 속한다.

* **프로그램 언어로 작성 및 실행**

**소스파일**
```java
class Calculator {
    public static void main(String[] args) {
        int result = 10 + 20;
        System.out.println(result);
    }
}
```

↓ (컴파일)

**기계어 파일**
```
0010011100010
00100100 10000
1101110000111
```

개발자가 고급 언어로 작성한 파일을 소스(source) 파일이라고 부른다. 고급 언어에는 많은 종류가 있는데, 대표적으로 자바(Java), C, C++, C#, 파이썬(Python) 등이 있다.

자바는 1995년도에 썬 마이크로시스템즈(Sun Microsystems)에서 처음 발표한 후, 가장 성공한 프로그래밍 언어로서 전 세계적으로 다양한 분야에서 사용되고 있다. 안드로이드 폰에서 실행하는 애플리케이션뿐만 아니라, 웹 사이트를 개발하는 핵심 언어로 사용되고 있다. 그리고 모든 운영체제에서 실행 가능한 데스크톱 애플리케이션도 개발할 수 있다.

자바는 오라클(https://www.oracle.com)에서 라이선스(license)를 가지고 있다. 오라클은 자바 개발 도구(Java Development Kit, JDK)를 배포하여 자바로 프로그램을 쉽게 개발할 수 있도록 기술적 지원을 하고 있다. 자바는 다른 프로그래밍 언어와 비교해 다음과 같은 특징이 있다.

* **모든 운영체제에서 실행 가능**: 자바로 작성된 프로그램은 모든 운영체제에서 실행 가능하다. 따라서 윈도우에서 개발된 프로그램을 수정 없이 바로 맥OS 또는 리눅스에서도 실행할 수 있다는 장점이 있다.
* **객체지향 프로그래밍**: 먼저 객체(부품)를 만들고 이 객체들을 서로 연결해서 더 큰 프로그램을 완성시키는 기법을 객체지향 프로그래밍(Object Oriented Programming, OOP)이라고 한다. 자바는 OOP를 위한 최적의 언어이다.
* **메모리 자동 정리**: 자바는 메모리(RAM)를 자동 관리하므로 개발자가 메모리 관리의 수고스러움을 덜고 핵심 기능인 코드 작성에 집중할 수 있다.
* **풍부한 무료 라이브러리**: 무료로 다운로드해서 사용할 수 있는 오픈소스 라이브러리(Open Source Library)가 풍부하기 때문에 프로그램 개발 기간을 단축시켜 준다.

### 1.2 운영체제별 JDK 설치

자바 프로그램을 개발하고 실행하기 위해서는 먼저 Java SE(Standard Edition)의 구현체인 JDK(Java Development Kit)를 설치해야 한다. JDK에는 Open JDK와 Oracle JDK가 있다.

| 구분                | Open JDK          | Oracle JDK                        |
| :------------------ | :---------------- | :-------------------------------- |
| 라이선스            | GNU GPL version 2 | Oracle Technology Network License |
| 사용료              | 무료              | 개발 및 학습: 무료, 상업용: 유료  |
| 개발 소스 공개 의무 | 있음              | 없음                              |

Oracle JDK는 Open JDK보다 응답성과 JVM 성능이 상대적으로 뛰어나다. 하지만 Open JDK의 성능도 지속적으로 향상되고 있으며, 더욱 안정화되었기 때문에 JDK 비용을 고려한다면 Open JDK를 사용하는 것이 유리하다. 다음은 JDK를 다운로드할 수 있는 사이트이다.

| 종류       | 다운로드 사이트                                    |
| :--------- | :------------------------------------------------- |
| Open JDK   | https://jdk.java.net<br>https://adoptium.net       |
| Oracle JDK | https://www.oracle.com/java/technologies/downloads |

Open JDK를 사용하고 싶다면 'https://jdk.java.net' 사이트보다는 이클립스 재단(Eclipse Foundation)에서 관리하는 'https://adoptium.net' 사이트에서 다운로드하는 것이 좋다. 어답티움 사이트에는 다양한 운영체제용 JDK와 LTS(Long Term Support) 버전을 제공하기 때문이다.

LTS는 장기간 기술 지원을 받을 수 있다는 뜻이므로 다른 버전보다 안정적으로 사용할 수 있다. LTS를 제공하는 버전은 JDK 8, JDK 11, JDK 17, JDK 21이다. Oracle JDK도 LTS 버전을 제공하기 때문에 우리 책에서는 Oracle JDK를 사용할 것이다. 웹 브라우저에서 다음 사이트를 방문해 보자.

https://www.oracle.com/java/technologies/downloads

우리 책은 자바 21 버전을 사용하므로 JDK 21 버전을 다운로드하기 위해 [Java Downloads] 화면에서 아래로 스크롤한 후 [JDK 21] 탭을 클릭한다.

**윈도우에서 설치**

윈도우 사용자라면 [Windows] 탭을 클릭하고, [x64 Installer]의 다운로드 링크를 선택해 설치 파일 'jdk-21_windows-x64_bin.exe'를 다운로드한다.

파일 탐색기에서 다운로드한 JDK 설치 파일을 더블 클릭해서 실행하고, [사용자 계정 컨트롤] 대화상자에서 디바이스 변경을 허용하도록 [예] 버튼을 클릭한다. 이것은 JDK를 `C:\Program Files\Java`에 설치할 때 필요하다.

그리고 각 화면에서 [Next] 버튼을 클릭해서 기본 설치를 진행한다.
설치를 완료하면 JDK가 `C:\Program Files\Java\jdk-21` 경로에 저장된다.

**맥OS에서 설치**

맥OS 사용자라면 [macOS] 탭을 클릭하고, JDK를 설치할 PC가 애플(M)칩을 사용하면 [ARM64 DMG Installer]의 링크를, 인텔칩을 사용하면 [x64 DMG Installer]의 링크를 클릭해 설치 파일 'jdk-21_macos-aarch64[x64]_bin.dmg'를 다운로드한다.

다운로드한 JDK 설치 파일을 더블 클릭하면 나오는 'JDK 21.0.x.pkg' 파일을 더블 클릭한다. 그리고 나타나는 대화상자에서 다음과 같이 [계속] 및 [설치] 버튼을 클릭해서 설치를 진행한다.

### 1.3 운영체제별 환경 변수 설정

운영체제는 프로그램들이 실행하면서 사용할 수 있는 값들을 환경 변수 이름으로 관리한다. JDK를 설치하고 나면 프로그램들이 JDK를 이용할 수 있도록 `JAVA_HOME` 환경 변수를 생성하고, `Path` 환경 변수를 수정하는 것이 좋다.

**윈도우 환경 변수 설정**

먼저 윈도우 운영체제에서 환경 변수를 설정하는 방법을 알아보자.

01 윈도우에서 환경 변수를 새로 만들거나 편집하려면 [환경 변수] 대화상자를 열어야 한다. 윈도우 작업 표시줄에서 검색 아이콘을 클릭하고 '환경 변수'라고 입력하면 나오는 [시스템 환경 변수 편집] 메뉴를 클릭하면 된다. 그리고 [시스템 속성] 대화상자에서 [환경 변수] 버튼을 클릭한다.

02 [환경 변수] 대화상자에서 [시스템 변수]의 [새로 만들기] 버튼을 클릭한다.

03 [새 시스템 변수] 대화상자가 나타나면 [변수 이름]에는 'JAVA_HOME'을 입력하고, [변수 값]에는 [디렉터리 찾아보기] 버튼을 클릭해서 JDK가 설치된 경로인 `C:\Program Files\Java\jdk-21`을 선택해 입력해 준다. 그리고 [확인] 버튼을 클릭한다.

04 JDK 설치 폴더인 `C:\Program Files\Java\jdk-21` 경로에 들어가면 `bin` 디렉토리가 있다. `bin` 디렉토리 안에는 다양한 명령어들이 있는데, 대표적으로 자바 소스 파일을 컴파일해 주는 'javac.exe'와 자바 프로그램을 실행해 주는 'java.exe' 명령어가 있다.

05 `javac`와 `java` 명령어는 명령 프롬프트 또는 파워쉘에서 컴파일하고 실행할 때 사용된다. `bin` 디렉토리 안에 있지만 어떤 위치에서도 사용할 수 있도록 'Path' 환경 변수에 경로를 추가해 보자. [환경 변수] 대화상자의 [시스템 변수]에서 'Path' 환경 변수를 선택하고 [편집] 버튼을 클릭한다.

06 [환경 변수 편집] 대화상자가 나타나면 [새로 만들기] 버튼을 클릭하고, 추가된 항목에 직접 `%JAVA_HOME%\bin`을 입력한다. `%JAVA_HOME%`은 `JAVA_HOME` 환경 변수의 값을 의미한다. 따라서 `%JAVA_HOME%\bin`은 `C:\Program Files\Java\jdk-21\bin`이 된다.
입력이 끝나면 [위로 이동] 버튼을 클릭해서 `%JAVA_HOME%\bin`을 첫 번째 항목으로 올려 준다. 이렇게 하는 이유는 'Path' 환경 변수에 등록된 순서대로 명령어를 찾기 때문이다. 만약 `%JAVA_HOME%\bin`보다 위쪽에 위치한 경로에 `java` 명령어가 있다면 다른 버전의 `java` 명령어가 사용될 수 있으므로 주의해야 한다. 이제 [확인] 버튼을 클릭해서 빠져 나온다.

07 환경 변수가 올바르게 설정되었는지 확인하기 위해 명령 프롬프트 또는 파워쉘을 실행하고, 다음과 같이 `javac` 명령어를 실행해 보자.

```bash
C:\...>javac -version
javac 21
```

08 그리고 `java` 명령어를 다음과 같이 실행한다.

```bash
C:\...>java -version
java version "21" 2023-09-19 LTS
Java(TM) SE Runtime Environment (build 21+35-LTS-2513)
Java HotSpot(TM) 64-Bit Server VM (build 21+35-LTS-2513, mixed mode, sharing)
```

만약 '외부 명령, 실행할 수 있는 프로그램 또는 배치 파일이 아닙니다.'라는 메시지가 출력되면 환경 변수 설정이 잘못된 것이다. 이 경우에는 환경 변수 `JAVA_HOME`과 `Path`를 다시 확인하고 수정해야 한다. 수정한 후에는 현재 명령 프롬프트 또는 파워쉘을 닫고 재시작해야 한다.

**맥OS 환경 변수 설정**

1.2절에서 맥OS에 JDK를 설치했다면 위치는 `/Library/Java/JavaVirtualMachines/JDK-21.jdk`가 된다. `JavaVirtualMachines` 디렉토리에 `JDK-21.jdk`만 있다면 환경 변수 설정이 필요 없다. 만약 다른 JDK가 존재한다면 `JDK-21.jdk`를 사용하도록 환경 변수를 설정해야 한다.

01 <사용자 홈> 디렉토리에서 `ls -all` 명령어를 실행해 `.bash_profile`을 찾아보고, 없으면 다음과 같이 생성한다.

```bash
$ touch .bash_profile
```

> NOTE: 이 책에서 <사용자 홈>이란 윈도우에서는 `C:\사용자(Users)\계정` 폴더, 맥OS에서는 `/사용자(Users)/계정` 폴더를 말한다.

02 `.bash_profile` 파일을 텍스트 편집기로 열어 다음과 같이 두 줄을 추가하고 저장한다.

```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/JDK-21.jdk/Contents/Home
export PATH=${PATH}:$JAVA_HOME/bin
```

03 터미널을 열고 `~/.bash_profile` 내용을 적용하기 위해 다음 명령어를 실행한다.

```bash
$ source ~/.bash_profile
```

04 환경 변수가 올바르게 설정되었는지 확인하기 위해 터미널에서 다음과 같이 `javac` 명령어를 실행한다.

```bash
$ javac -version
javac 21
```

05 그리고 다음과 같이 `java` 명령어를 실행해 보자.

```bash
$ java -version
java version "21" 2023-09-19 LTS
Java(TM) SE Runtime Environment (build 21+35-LTS-2513)
Java HotSpot(TM) 64-Bit Server VM (build 21+35-LTS-2513, mixed mode, sharing)
```

`javac`와 `java` 버전이 위와 비슷한 내용으로 출력된다면 환경 변수가 제대로 설정된 것이다. 그렇지 않다면 환경 변수 설정을 수정해야 한다.

### 1.4 바이트코드 파일과 자바 가상 머신

JDK를 설치했다면 이제 자바 언어로 작성한 소스 파일을 만들고 컴파일할 수 있다. 자바 소스 파일의 확장명은 `.java`이다. 텍스트 파일이므로 어떤 텍스트 에디터에서도 작성이 가능하다.

**Hello.java**
```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java");
    }
}
```

소스 파일(.java)을 작성한 후에는 컴파일을 해야 한다. `javac` (java compiler) 명령어는 소스 파일을 컴파일하는데, 컴파일 결과는 확장명이 `.class`인 바이트코드(ByteCode) 파일로 생성된다.

**자바 소스 파일 (Hello.java) -> javac 명령어 실행 (컴파일) -> 바이트코드 파일 (Hello.class)**

윈도우, 맥OS, 리눅스 등 어떤 운영체제라 하더라도 동일한 소스 파일을 `javac`로 컴파일하면 모두 동일한 바이트코드 파일이 생성된다.

**자바 가상 머신**

바이트코드 파일(`*.class`)을 특정 운영체제가 이해하는 기계어로 번역하고 실행시키는 명령어는 `java`이다. `java` 명령어는 JDK와 함께 설치된 자바 가상 머신(Java Virtual Machine, JVM)을 구동시켜 바이트코드 파일을 완전한 기계어로 번역하고 실행시킨다.

**바이트코드 파일 (Hello.class) -> java 명령어 실행 (자바 가상 머신) -> 기계어**

바이트코드 파일은 운영체제와 상관없이 모두 동일한 내용으로 생성되지만, 자바 가상 머신은 운영체제에서 이해하는 기계어로 번역해야 하므로 운영체제별로 다르게 설치된다. 그래서 운영체제별로 설치하는 JDK가 다른 것이다.

### 1.5 소스 작성부터 실행까지

1.4절에서 설명한 내용을 확인하기 위해 소스 작성부터 실행까지 실습해 보자(윈도우 기준).

01 윈도우 탐색기에서 `C:\temp` 디렉토리를 다음 구조로 생성하고, `Hello.java` 소스 파일을 생성한다.

```
C:\temp
 ├─ src
 │   └─ ch01
 │       └─ sec06   <-- 패키지 디렉토리 (소스 파일이 저장되는 디렉토리)
 │           └─ Hello.java  <-- 소스 파일
 └─ bin   <-- 바이트코드 파일이 저장되는 디렉토리
```

> 자바는 소스 파일 및 컴파일된 바이트코드 파일을 쉽게 관리하기 위해 패키지(package)를 사용한다. 패키지는 마치 파일 시스템의 디렉토리와 비슷하다. 이 책에서는 장별 그리고 절별로 패키지를 생성해서 파일들을 관리할 것이다.

02 `Hello.java`를 텍스트 에디터에서 열고, 다음과 같이 코드를 작성한다.

> VSCode(Visual Studio Code)와 같은 개발 도구 텍스트 에디터를 설치(https://code.visualstudio.com)해서 작성하는 것이 편리하다.

**[예제: Hello.java]**
```java
package ch01.sec06; // 바이트코드 파일이 위치할 패키지 선언

public class Hello { // Hello 클래스 선언
    public static void main(String[] args) { // main() 메소드 선언
        System.out.println("Hello, Java"); // 콘솔에 출력하는 코드
    }
}
```

03 소스 파일을 `javac` 명령어로 컴파일해 보자. 명령 프롬프트에서 `cd` 명령어로 `C:\temp` 디렉토리로 이동하고, 다음과 같이 `javac` 명령어를 실행한다.

> `javac -d [바이트코드파일저장위치] [소스경로/*.java]`
> `*.java`는 확장명이 java인 모든 파일을 말한다.

```bash
C:\...> cd C:\temp
C:\temp> javac -d bin src/ch01/sec06/Hello.java
```
`C:\temp\bin`에 패키지 디렉토리와 바이트코드 파일(`ch01/sec06/Hello.class`)이 생성

04 `java` 명령어로 바이트코드 파일을 기계어로 번역하고 실행시켜 보자. 여전히 명령 프롬프트의 현재 위치는 `C:\temp` 디렉토리이다. 주의할 점은 패키지 구분자는 `.`를 사용해야 하고, 클래스명은 `.class`를 제외한 `Hello`만 입력해야 한다는 점이다.

> `java -cp [바이트코드파일위치] [패키지...클래스명]`

```bash
C:\temp> java -cp bin ch01.sec06.Hello
Hello, Java
```
콘솔에 "Hello, Java"가 출력

윈도우와 맥OS를 함께 사용할 수 있는 환경을 갖고 있다면 한쪽에서 temp 디렉토리를 다른 쪽으로 복사한 다음 `java` 명령어를 실행해도 된다. `javac`로 컴파일하면 운영체제에 독립적인 바이트코드 파일(`*.class`)이 생성되기 때문이다.

### 1.6 이클립스 설치

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

### 1.7 이클립스 프로젝트 생성

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

### 1.8 이클립스 소스 작성부터 실행까지

1.5절에서 작성했던 Hello.java 소스 파일을 이클립스에서 작성하고, 실행시켜 보자.

01 Package Explorer 뷰에서 `src` 디렉토리를 선택하고, 마우스 오른쪽 버튼으로 클릭하여 [New] - [Package]를 선택한다. Name 입력란에 'ch01.sec08'을 입력하고 [Finish] 버튼을 클릭한다.

> 패키지는 소스 파일과 바이트코드 파일을 관리하기 위한 디렉토리라고 생각하자. 앞으로 모든 예제는 장별, 절별로 패키지를 만들어서 관리할 것이다. 많은 예제 소스 파일을 쉽게 찾기 위해서이다.

02 `ch01.sec08` 패키지에서 마우스 오른쪽 버튼으로 클릭하여 [New] - [Class]를 선택한다.

03 [New Java Class] 대화상자가 나타나면 Name 입력란에 'Hello'를 입력한다. 그리고 `main()` 메소드를 자동으로 추가하기 위해 [public static void main(String[] args)]를 체크하고 [Finish] 버튼을 클릭한다.

> Name 입력란에 클래스 이름을 입력할 때 주의할 점은 첫 문자가 대문자여야 한다는 것이다. 소문자로 입력하면 경고 메시지가 나타난다. 자바 소스 파일명(Hello.java)과 작성하는 클래스명(Hello)은 대소문자가 일치해야 한다.

04 소스 코드 편집 뷰가 열리고 Hello 클래스와 `main()` 메소드가 자동으로 생성되면, `main()` 메소드 중괄호 `{}` 내부에 다음과 같이 작성한다.

```java
package ch01.sec08;

public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello, Java");
    }

}
```

> **글자 크기를 변경하려면**
> [Window] - [Editor] - [Zoom In] 또는 [Zoom Out] 메뉴를 이용하거나, 단축키 `Ctrl` + `+/-`를 이용한다.

05 소스 코드가 완성되었다면 툴바에서 [Run] 아이콘을 클릭하거나 단축키 `Ctrl` + `F11`을 눌러 컴파일하고 실행한다.

06 [Console] 뷰에 "Hello, Java"가 출력된 것을 볼 수 있다.

이클립스는 소스 파일을 저장하면 내부적으로 `javac` 명령어를 실행해 컴파일을 수행한다. 그리고 [Run] 아이콘을 클릭하면 내부적으로 `java` 명령어를 실행해 컴파일된 바이트코드를 실행한다.

### 1.9 코드 용어 이해

지금까지 작성한 Hello.java 소스 파일을 보면서 사용된 코드 용어들을 살펴보자.

```java
package ch01.sec09; // ① 패키지 선언

public class Hello { // ② 클래스 선언
    
    public static void main(String args[]) { // ③ 메소드 선언
        System.out.println("Hello, Java"); // ④ 실행문
    } // ⑤ 닫는 중괄호: 메소드 끝
    
} // ⑥ 닫는 중괄호: 클래스 끝 (소스 파일 끝)
```

① **패키지 선언**: `package` 키워드는 해당 클래스가 어떤 패키지에 속해 있는지를 선언한다.
② **클래스 선언**: `public class Hello`는 Hello라는 이름의 공개된 클래스를 선언한다는 뜻이다. `public class`는 공개 클래스라고 부르며, 클래스 이름은 소스 파일명과 동일해야 한다.
③ **메소드 선언**: `public static void main(String[] args)`는 `main()` 메소드를 선언한다는 뜻이다. `main()` 메소드는 바이트코드 파일을 실행할 때 자바 가상 머신이 제일 먼저 찾는 메소드이기 때문에 실행 진입점(entry point)라고 부른다. 따라서 프로그램을 실행하려면 반드시 `main()` 메소드가 있어야 한다.
④ **실행문**: `System.out.println("Hello, Java");`는 콘솔에 "Hello, Java"를 출력하라는 명령이다. `main()` 메소드 블록 `{}` 내부에는 다양한 실행문이 작성될 수 있다.

### 1.10 코드 주석 달기

프로그램 소스 코드에 프로그래머의 의견이나 설명을 적어 놓는 것을 주석(Comment)이라고 한다. 주석은 컴파일 과정에서 무시되고 실행문만 바이트코드로 번역된다. 따라서 주석을 많이 작성한다고 해서 바이트코드 파일의 크기가 커지는 것은 아니다.

**주석의 종류**

* **라인 주석 (`// ...` )**: `//`부터 라인 끝까지 주석으로 처리한다.
* **범위 주석 (`/* ... */`)**: `/*`와 `*/` 사이의 내용을 주석으로 처리한다.
* **도큐먼트 주석 (`/** ... */`)**: `/**`와 `*/` 사이의 내용을 주석으로 처리하며, 주로 `javadoc` 명령어로 API 도큐먼트를 생성할 때 사용한다.

문자열 내부(`" "`)에 주석 기호가 있을 경우에는 주석으로 처리되지 않으므로 주의해야 한다.

```java
System.out.println("Hello, /*주석...*/ Java");
```
위 코드는 "Hello, /*주석...*/ Java"가 그대로 출력된다.

**[예제: Hello.java]**
```java
package ch01.sec10;

/**
 * @author 홍길동
 */
/*
장제목: 1장 자바 시작하기
작성일: 202x.xx.xx
*/
public class Hello {
    //프로그램 실행 진입점
    public static void main(String[] args) {
        //콘솔에 출력하는 실행문
        System.out.println("Hello, Java");
    }
}
```

### 1.11 실행문과 세미콜론

`main()` 메소드 블록 내부에는 다양한 실행문이 작성된다. 실행문은 변수 선언(저장 장소 생성), 값 저장, 메소드 호출에 해당하는 코드를 말한다. 실행문 끝에는 반드시 세미콜론(`;`)을 붙여서 실행문이 끝났음을 표시해야 한다.

```java
int x = 1; // 변수 x를 선언하고 1을 저장
int y = 2; // 변수 y를 선언하고 2를 저장
int result = x + y; // 변수 result를 선언하고 변수 x와 y를 더한 값을 저장
System.out.println(result); // 콘솔에 변수의 값을 출력하는 println() 메소드 호출
```

실행문 끝에는 반드시 세미콜론(`;`)을 붙여야 한다. 그렇지 않으면 컴파일 에러가 발생한다. 실행문을 여러 줄에 걸쳐서 작성하고 맨 마지막에 세미콜론을 붙여도 된다.

```java
int result =
x + y;
```

또한 여러 가지 실행문을 세미콜론으로 구분해서 한 줄로 작성할 수도 있다.

```java
int x = 1; int y = 2;
```

실행문에 세미콜론을 붙이는 실습을 해보자. Package Explorer 뷰에서 `ch01.sec11` 패키지를 생성하고 그 안에 `Calculator.java` 소스 파일을 만든다. 그리고 다음과 같이 작성하고 실행한다.

**[예제: Calculator.java]**
```java
package ch01.sec11;

public class Calculator {
    public static void main(String[] args) {
        int x = 1; //변수 x를 선언하고 1을 저장
        int y = 2; //변수 y를 선언하고 2를 저장
        int result = x + y; //변수 result를 선언하고 x와 y를 더한 값을 저장
        System.out.println(result); //콘솔에 출력하는 메소드 호출
    }
}
```

**실행 결과**

```
3
```

### 확인문제

1. 자바 언어의 특징을 잘못 설명한 것은 무엇입니까?
   1. 안드로이드 애플리케이션뿐만 아니라 웹 사이트를 개발할 때 사용하는 언어이다.
   2. 한 번 작성으로 다양한 운영체제에서 실행할 수 있다.
   3. 객체지향 프로그래밍 언어이다.
   4. 개발자가 코드로 메모리를 관리해야 한다.

2. Open JDK와 Oracle JDK를 잘못 설명한 것은 무엇입니까?
   1. 둘 다 학습용 및 개발용으로는 무료 사용이 가능하다.
   2. Oracle JDK는 개발 소스 공개 의무가 없지만, Open JDK는 있다.
   3. 둘 다 Java SE의 구현체이다.
   4. JDK 17 LTS 버전의 후속 LTS 버전은 JDK 21이다.

3. 환경 변수에 대해 잘못 설명한 것은 무엇입니까?
   1. 프로그램에서 사용할 수 있도록 운영체제가 관리한다.
   2. `JAVA_HOME`은 JDK가 설치된 디렉토리 경로를 가지고 있다.
   3. `PATH`는 명령 프롬프트 또는 터미널에서 명령어 파일을 찾을 때 이용된다.
   4. 환경 변수를 수정하면 기존 명령 프롬프트 또는 터미널에서 바로 적용된다.

4. 자바 가상 머신(JVM)에 대해 잘못 설명한 것은 무엇입니까?
   1. JVM은 `java.exe` 명령어에 의해 구동된다.
   2. JVM은 바이트코드를 기계어로 변환하고 실행시킨다.
   3. JVM은 운영체제에 독립적이다(운영체제별로 동일한 JVM이 사용된다).
   4. 바이트코드는 어떤 JVM에서도 실행 가능한 독립적 코드이다.

5. 자바 프로그램 개발 과정을 순서대로 적어 보세요. ( ) -> ( ) -> ( ) -> ( )
   1. `javac.exe`로 바이트코드 파일(`*.class`)을 생성한다.
   2. `java.exe`로 JVM을 구동시킨다.
   3. 자바 소스 파일(`*.java`)을 작성한다.
   4. JVM은 `main()` 메소드를 찾아 메소드 블록을 실행시킨다.

6. 자바 소스 파일을 작성할 때 잘못된 것은 무엇입니까?
   1. 자바 소스 파일명과 클래스명은 대소문자가 동일해야 한다.
   2. 클래스 블록과 메소드 블록은 반드시 중괄호 `{}`로 감싸야 한다.
   3. 실행문 뒤에는 반드시 세미콜론(`;`)을 붙여야 한다.
   4. 주석은 문자열 안에도 작성할 수 있다.

7. 이클립스의 특징을 올바르게 설명한 것을 모두 선택하세요.
   1. 오픈 소스 통합개발환경(IDE)이다.
   2. 소스 파일을 저장하면 자동 컴파일되어 바이트코드 파일이 생성된다.
   3. 워크스페이스(Workspace)는 프로젝트들이 생성되는 기본 디렉토리를 말한다.
   4. Java 21을 지원하는 최소 버전은 Eclipse IDE 2023-12이다.

8. 다음과 같이 출력되도록 `Example.java`를 패키지 `ch01.verify`에서 작성해 보세요.

```
개발자가 되기 위한 필수 개발 언어 Java
```
