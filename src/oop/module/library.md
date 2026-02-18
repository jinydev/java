---
layout: oop
title: "10.1 라이브러리"
nav_order: 1
parent: "Chapter 10. 라이브러리와 모듈"
grand_parent: "객체지향 자바 프로그래밍"
---

# 10.1 라이브러리

라이브러리(Library)는 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것을 말한다. 일반적으로 JAR(Java ARchive) 압축 파일(*.jar) 형태로 존재한다. JAR 파일에는 클래스와 인터페이스의 바이트코드 파일(*.class)들이 압축되어 있다.

특정 클래스와 인터페이스가 여러 응용프로그램을 개발할 때 공통으로 자주 사용된다면 JAR 파일로 압축해서 라이브러리로 관리하는 것이 좋다. 참고로 이클립스는 Java Project를 생성해서 클래스와 인터페이스를 개발하고 최종 산출물로 JAR 파일을 만드는 기능이 있다.

프로그램 개발 시 라이브러리를 이용하려면 라이브러리 JAR 파일을 ClassPath에 추가해야 한다. ClassPath란 말 그대로 클래스를 찾기 위한 경로이다. ClassPath에 라이브러리를 추가하는 방법은 다음과 같다.

*   **콘솔(명령 프롬프트 또는 터미널)에서 프로그램을 실행할 경우**
    *   `java` 명령어를 실행할 때 `-classpath`로 제공
    *   `CLASSPATH` 환경 변수에 경로를 추가
*   **이클립스 프로젝트에서 실행할 경우**
    *   프로젝트의 Build Path에 추가

라이브러리를 생성하고 프로그램에서 이용하는 방법을 실습을 통해 알아보자.

## my_lib 라이브러리 프로젝트 생성

1.  이클립스 메뉴에서 [File] - [New] - [Java Project]를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 [Finish] 버튼을 클릭한다.
    *   Project name: `my_lib`
    *   Module: [체크안함] Create module-info.java file (중요)

2.  Package Explorer 뷰에서 src 폴더를 선택하고 마우스 오른쪽 버튼을 클릭하여 [New] - [Package]로 `pack1`과 `pack2` 패키지를 생성한다. 그리고 그 밑에 각각 `A`와 `B` 클래스를 다음과 같이 작성한다.

    **A.java**
    ```java
    package pack1;

    public class A {
        // 메소드 선언
        public void method() {
            System.out.println("A-method 실행");
        }
    }
    ```

    **B.java**
    ```java
    package pack2;

    public class B {
        // 메소드 선언
        public void method() {
            System.out.println("B-method 실행");
        }
    }
    ```

3.  Package Explorer 뷰에서 `my_lib` 프로젝트를 선택하고 마우스 오른쪽 버튼으로 클릭하여 [New] - [Folder]를 선택해 이름이 `dist`인 폴더를 생성한다.

4.  `my_lib` 프로젝트를 선택하고 마우스 오른쪽 버튼으로 클릭해 [Export]를 선택한다. Export 대화상자의 Select an export wizard에서 Java 항목을 확장하면 보이는 JAR file을 선택한 후 [Next] 버튼을 클릭한다.

5.  Select the resources to export에서 `my_lib`를 확장한 후 그 안에 있는 `src` 폴더만 체크하고 나머지는 모두 체크 해제한다.

6.  Select the export destination에서 [Browse] 버튼을 클릭하고, `my_lib` 프로젝트의 `dist` 폴더로 이동한다. 파일 이름은 `my_lib.jar`로 입력하고 [저장]과 [Finish] 버튼을 클릭한다.

7.  Package Explorer 뷰에서 `my_lib` 프로젝트를 선택하고 마우스 오른쪽 버튼으로 클릭해 [Refresh]를 선택한다. 그리고 `dist` 폴더에 `my_lib.jar` 파일이 생성되었는지 확인한다.

## my_application_1 프로젝트 생성

1.  이클립스 메뉴에서 [File] - [New] - [Java Project]를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 [Finish] 버튼을 클릭한다.
    *   Project name: `my_application_1`
    *   Module: [체크안함] Create module-info.java file (중요)

2.  `my_application_1` 프로젝트를 이클립스에서 컴파일할 때와 실행할 때 라이브러리 파일인 `my_lib.jar`을 사용하기 위해 Build Path에 추가해 보자. Package Explorer 뷰에서 `my_application_1` 프로젝트를 선택하고 마우스 오른쪽 버튼으로 클릭해 [Build Path] - [Configure Build Path]를 선택한다.

3.  [Libraries] 탭에 들어가 Classpath 항목을 선택하고 [Add External JARs] 버튼을 클릭한다. `my_lib` 프로젝트의 `dist` 폴더에 있는 `my_lib.jar` 파일을 선택하고 [열기]와 [Apply and Close] 버튼을 클릭한다. 다시 Package Explorer 뷰에서 `my_application_1` 프로젝트를 선택하고 [Build Path] - [Configure Build Path]를 선택하면 라이브러리 파일이 등록된 것을 볼 수 있다.

    > **라이브러리 프로젝트를 직접 Build Path에 추가하기**
    >
    > 라이브러리와 응용프로그램을 동시에 개발하는 경우 `my_lib` 프로젝트를 `my_application_1` 프로젝트에서 바로 Build Path에 추가할 수 있다. 이렇게 하면 `my_lib` 프로젝트를 수정하는 즉시 `my_application_1`에서 수정된 내용을 사용할 수 있게 된다.
    > 1. `my_application_1` 프로젝트를 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Build Path] - [Configure Build Path] 메뉴를 선택한다.
    > 2. [Projects] 탭에 들어가 Classpath 항목을 선택하고 [Add] 버튼을 클릭한다.
    > 3. `my_lib` 프로젝트를 선택한 후 [OK]와 [Apply and Close] 버튼을 차례대로 클릭해 추가한다.

4.  `my_application_1` 프로젝트의 `src` 폴더 안에 `app` 패키지를 하나 생성하고 그 안에 `Main` 클래스를 생성한다.

5.  `Main` 클래스에는 다음과 같이 작성하고, 이클립스에서 실행한다.

    **Main.java**
    ```java
    package app;

    import pack1.A;
    import pack2.B;

    public class Main {
        public static void main(String[] args) {
            // 라이브러리에서 가져온 A 클래스 사용
            A a = new A();
            a.method();

            // 라이브러리에서 가져온 B 클래스 사용
            B b = new B();
            b.method();
        }
    }
    ```

    **실행 결과**
    ```
    A-method 실행
    B-method 실행
    ```

## 콘솔에서 -classpath 옵션 사용

이번에는 윈도우 명령 프롬프트 또는 맥OS 터미널에서 `-classpath` 옵션을 주고 실행하는 방법을 알아보자.

**윈도우**

명령 프롬프트에서 다음과 같이 현재 경로를 bin 디렉토리로 이동하고 `Main` 클래스를 실행한다.

```
C:\...> cd C:\ThisIsJava\workspace\my_application_1\bin
C:\...\bin> java app.Main
```

`java.lang.NoClassDefFoundError: pack1/A`라는 에러가 출력될 것이다. 이것은 `my_lib.jar` 라이브러리를 인식하지 못했기 때문이다. 이번에는 다음과 같이 `-classpath` 옵션을 주고 `my_lib.jar` 파일 경로를 추가해서 실행해 보자.

```
C:\...\bin> java -classpath C:\ThisIsJava\workspace\my_lib\dist\my_lib.jar;. app.Main
```

`-classpath` 대신 `-cp`를 사용해도 된다. 경로 뒤에 세미콜론(;)과 함께 마침표(.)를 추가했는데, 이것은 현재 경로에서 `app.Main`을 찾기 위해서이다. 윈도우에서 classpath 구분자는 세미콜론(;)이므로 주의해야 한다.

**맥OS**

터미널에서는 다음과 같이 실행한다. 맥OS에서 classpath 구분자는 콜론이므로 콜론(:)과 함께 마침표(.)를 경로 뒤에 추가해야 한다.

```
$ cd ~/ThisIsJava/workspace/my_application_1/bin
$ java -classpath ~/ThisIsJava/workspace/my_lib/dist/my_lib.jar:. app.Main
```

## 환경 변수 CLASSPATH 사용

`-classpath` 옵션은 `java` 명령어를 실행할 때마다 별도로 추가해야 하는 불편함이 있다. 여러 프로그램에서 공통으로 사용하는 라이브러리는 환경 변수 `CLASSPATH`에 경로를 추가하면 이러한 불편함을 없앨 수 있다.

**윈도우**

[환경 변수] 대화상자에서 시스템 변수의 [새로 만들기] 버튼을 클릭한다. 변수 이름에는 `CLASSPATH`를, 변수값에는 `.;C:\ThisIsJava\workspace\my_lib\dist\my_lib.jar`을 입력한다. 그리고 [확인] 버튼을 클릭한다.

맨 앞에 `.;`을 추가한 이유는 현재 디렉토리에서 먼저 찾은 후 없으면 뒤의 경로에서 찾도록 하기 위해서이다. 명령 프롬프트를 새로 열고 다음과 같이 실행해 보자.

```
C:\...> cd C:\ThisIsJava\workspace\my_application_1\bin
C:\...\bin> java app.Main
```

**맥OS**

사용자 홈 디렉토리에서 `ls -all` 명령어를 실행해서 `.bash_profile`을 찾아보고, 없으면 다음과 같이 생성한다.

```
$ touch .bash_profile
```

`.bash_profile` 파일을 텍스트 에디터로 열고 다음과 같이 작성하고 저장한다. 맨 앞에 `.:`을 작성할 때 주의할 점은 윈도우와 달리 경로 구분자가 콜론(:)이라는 것이다.

```
export CLASSPATH=.:~/ThisIsJava/workspace/my_lib/dist/my_lib.jar
```

터미널을 열고 `~/.bash_profile` 내용을 적용하기 위해 다음 명령어를 실행시킨다.

```
$ source ~/.bash_profile
```

그리고 다음과 같이 실행해 보자.

```
$ cd ~/ThisIsJava/workspace/my_application_1/bin
$ java app.Main
```
