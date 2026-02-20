---
layout: basic
title: "2. 환경 변수 설정"
nav_order: 2
parent: "개발 환경 구축"
grand_parent: "객체지향 자바 프로그래밍"
---

# 1.3 운영체제별 환경 변수 설정

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
