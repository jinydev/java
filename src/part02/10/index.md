---
layout: part02
title: Chapter 10. 라이브러리와 모듈
---

# Chapter 10. 라이브러리와 모듈

## 10.1 라이브러리

라이브러리(Library)는 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것을 말한다. 일반적으로 JAR(Java ARchive) 압축 파일(*.jar) 형태로 존재한다. JAR 파일에는 클래스와 인터페이스의 바이트코드 파일(*.class)들이 압축되어 있다.

특정 클래스와 인터페이스가 여러 응용프로그램을 개발할 때 공통으로 자주 사용된다면 JAR 파일로 압축해서 라이브러리로 관리하는 것이 좋다. 참고로 이클립스는 Java Project를 생성해서 클래스와 인터페이스를 개발하고 최종 산출물로 JAR 파일을 만드는 기능이 있다.

프로그램 개발 시 라이브러리를 이용하려면 라이브러리 JAR 파일을 ClassPath에 추가해야 한다. ClassPath란 말 그대로 클래스를 찾기 위한 경로이다. ClassPath에 라이브러리를 추가하는 방법은 다음과 같다.

*   **콘솔(명령 프롬프트 또는 터미널)에서 프로그램을 실행할 경우**
    *   `java` 명령어를 실행할 때 `-classpath`로 제공
    *   `CLASSPATH` 환경 변수에 경로를 추가
*   **이클립스 프로젝트에서 실행할 경우**
    *   프로젝트의 Build Path에 추가

라이브러리를 생성하고 프로그램에서 이용하는 방법을 실습을 통해 알아보자.

### my_lib 라이브러리 프로젝트 생성

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

### my_application_1 프로젝트 생성

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

### 콘솔에서 -classpath 옵션 사용

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

### 환경 변수 CLASSPATH 사용

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

## 10.2 모듈

Java 9부터 지원하는 모듈(module)은 패키지 관리 기능까지 포함된 라이브러리이다. 일반 라이브러리는 내부에 포함된 모든 패키지에 외부 프로그램에서의 접근이 가능하지만, 모듈은 일부 패키지를 은닉하여 접근할 수 없게끔 할 수 있다.

또 다른 차이점은 모듈은 자신이 실행할 때 필요로 하는 의존 모듈을 모듈 기술자(`module-info.java`)에 기술할 수 있기 때문에 모듈 간의 의존 관계를 쉽게 파악할 수 있다는 것이다.

모듈도 라이브러리이므로 JAR 파일 형태로 배포할 수 있다. 응용프로그램을 개발할 때 원하는 기능의 모듈(JAR) 파일을 다운로드해서 이용하면 된다.

규모가 큰 응용프로그램은 기능별로 모듈화(modulization)해서 개발할 수도 있다. 모듈별로 개발하고 조립하는 방식을 사용하면 재사용성 및 유지보수에 유리하기 때문이다.

## 10.3 응용프로그램 모듈화

응용프로그램은 하나의 프로젝트로도 개발이 가능하지만, 이것을 기능별로 서브 프로젝트(모듈)로 쪼갠 다음 조합해서 개발할 수도 있다. 예를 들어 `my_application_2` 응용프로그램은 2개의 서브 프로젝트(모듈)인 `my_module_a`와 `my_module_b`로 쪼개서 개발하고, 이들을 조합해서 완성할 수 있다.

응용프로그램의 규모가 커질수록 협업과 유지보수 측면에서 서브 모듈로 쪼개서 개발하는 것이 유리하며, 이렇게 개발된 모듈들은 다른 응용프로그램에서도 재사용이 가능하다.

### my_module_a 모듈 생성

1.  이클립스 메뉴에서 [File] - [New] - [Java Project]를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 [Finish] 버튼을 클릭한다.
    *   Project name: `my_module_a`
    *   Module: [체크] Create module-info.java file (중요)
    *   Module name: `my_module_a`

2.  `my_module_a` 모듈의 `src` 폴더에 `pack1`과 `pack2` 패키지를 생성한다. 그리고 각 패키지에 `A` 클래스와 `B` 클래스를 다음과 같이 생성한다.

3.  `A`와 `B` 클래스에는 다음과 같이 각각 하나의 메소드를 선언한다.

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

4.  `my_module_a` 모듈이 포함하고 있는 두 개의 `pack1`과 `pack2`를 외부에서 사용할 수 있도록 모듈 기술자(`module-info.java`)를 다음과 같이 작성한다. `exports` 키워드는 모듈이 가지고 있는 패키지를 외부에서 사용할 수 있도록 노출시키는 역할을 한다.

    **module-info.java**
    ```java
    module my_module_a {
        exports pack1;
        exports pack2;
    }
    ```

### my_module_b 모듈 생성

1.  이클립스 메뉴에서 [File] - [New] - [Java Project]를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 [Finish] 버튼을 클릭한다.
    *   Project name: `my_module_b`
    *   Module: [체크] Create module-info.java file (중요)
    *   Module name: `my_module_b`

2.  `my_module_b` 모듈의 `src` 폴더에 `pack3`과 `pack4` 패키지를 생성한다. 그리고 각 패키지에 `C` 클래스와 `D` 클래스를 다음과 같이 생성한다.

3.  `C`와 `D` 클래스에는 다음과 같이 각각 하나의 메소드를 선언한다.

    **C.java**
    ```java
    package pack3;
    
    public class C {
        // 메소드 선언
        public void method() {
            System.out.println("C-method 실행");
        }
    }
    ```

    **D.java**
    ```java
    package pack4;
    
    public class D {
        // 메소드 선언
        public void method() {
            System.out.println("D-method 실행");
        }
    }
    ```

4.  `my_module_b` 모듈이 포함하고 있는 두 개의 `pack3`과 `pack4`를 외부에서 사용할 수 있도록 모듈 기술자(`module-info.java`)를 다음과 같이 작성한다.

    **module-info.java**
    ```java
    module my_module_b {
        exports pack3;
        exports pack4;
    }
    ```

### my_application_2 프로젝트 생성

이제 `my_module_a`와 `my_module_b`를 조합하는 `my_application_2` 프로젝트를 생성해 보자.

1.  이클립스 메뉴에서 [File] - [New] - [Java Project]를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 [Finish] 버튼을 클릭한다.
    *   Project name: `my_application_2`
    *   Module: [체크] Create module-info.java file (중요)
    *   Module name: `my_application_2`

    > **응용프로그램도 하나의 모듈**
    >
    > `my_application_2`는 모듈로 개발하는 것이 아니라 다른 모듈을 조합하는 응용프로그램을 위한 프로젝트이다. 그럼에도 불구하고 모듈 기술자(`module-info.java`)가 필요하다. 그 이유는 어떤 모듈을 가져와 사용할 것인지를 기술해야 하기 때문이다.
    >
    > 일반적으로 모듈 기술자(`module-info.java`)가 포함된 프로젝트를 모듈이라고 한다. 따라서 `my_application_2`도 하나의 모듈이다. 따라서 명칭 통일을 위해 `my_application_2` 프로젝트라는 용어 대신 `my_application_2` 모듈이라고 부르겠다.

2.  `my_application_2` 모듈은 `my_module_a`와 `my_module_b` 모듈에서 제공하는 패키지를 사용해야 하므로 두 모듈에 대한 의존 설정이 필요하다. `my_application_2`의 모듈 기술자(`module-info.java`)를 열고 다음과 같이 작성한다.

    **module-info.java**
    ```java
    module my_application_2 {
        requires my_module_a;
        requires my_module_b;
    }
    ```

    `requires` 키워드는 `my_application_2` 모듈을 컴파일하거나 실행할 때 필요한 의존 모듈을 지정한다. 실행하면 컴파일 에러가 발생하는데, 아직 `my_application_2` 모듈은 `my_module_a`와 `my_module_b` 모듈이 있는 경로를 모르기 때문이다.

3.  Package Explorer 뷰에서 `my_application_2`를 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Build Path] - [Configure Build Path] 버튼을 클릭 후 [Projects] 탭을 선택한다. 그리고 Required projects on the build path에서 Modulepath 항목을 선택하고 [Add] 버튼을 클릭한다.

4.  [Required Projects Selection] 대화상자가 나타나면 `my_module_a`와 `my_module_b` 모듈의 체크박스에 체크하고 [OK] 버튼을 클릭한다.

5.  [Projects] 탭에 두 모듈이 추가된 것을 확인하고 [Apply and Close] 버튼을 클릭한다.

6.  `my_application_2` 모듈의 `src` 폴더에서 `app` 패키지를 생성한다. 그리고 `Main` 클래스를 생성하고 다음과 같이 작성한 후 실행해 보자.

    **Main.java**
    ```java
    package app;
    
    import pack1.A;
    import pack2.B;
    import pack3.C;
    
    public class Main {
        public static void main(String[] args) {
            // my_module_a 패키지에 포함된 A 클래스 이용
            A a = new A();
            a.method();
            
            // my_module_a 패키지에 포함된 B 클래스 이용
            B b = new B();
            b.method();
            
            // my_module_b 패키지에 포함된 C 클래스 이용
            C c = new C();
            c.method();
        }
    }
    ```

    **실행 결과**
    ```
    A-method 실행
    B-method 실행
    C-method 실행
    ```

## 10.4 모듈 배포용 JAR 파일

모듈 개발을 완료했다면 다른 모듈에서 쉽게 사용할 수 있도록 바이트코드 파일(`.class`)로 구성된 배포용 JAR 파일을 생성해 보자. 이전 예제에서 만든 `my_module_a`와 `my_module_b` 모듈의 배포용 JAR 파일을 각각 생성한다.

### 모듈 배포용 JAR 파일 생성

`my_module_a`와 `my_module_b` 모듈에 각각 JAR 파일을 저장할 `dist` 폴더를 생성하자. 모듈 프로젝트에서 마우스 오른쪽 버튼을 클릭하여 [New] - [Folder]를 선택하고 Folder name에 `dist`를 입력한 후 [Finish] 버튼을 클릭한다.

`my_module_a` 모듈의 배포용 JAR 파일을 생성하는 방법은 다음과 같다.

1.  `my_module_a` 모듈을 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Export]를 선택한다.
2.  Java 항목을 확장하고 JAR file을 선택한 후, [Next] 버튼을 클릭한다.
3.  `my_module_a`를 확장하여 `src` 폴더에만 체크박스에 체크하고 나머지는 모두 체크 해제한다.
4.  Select the export destination에서 [Browse] 버튼을 클릭하고, `my_module_a` 모듈의 `dist` 폴더로 이동한다. 파일 이름은 `my_module_a.jar`로 입력하고 [저장], [Finish] 버튼을 클릭한다.
5.  Package Explorer 뷰에서 `my_module_a` 모듈을 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Refresh]를 선택한다. `dist` 폴더에 JAR 파일이 생성되었는지 확인한다.
6.  `my_module_b` 모듈의 배포용 JAR 파일도 위와 동일한 방법으로 생성한다.

### my_application_3 프로젝트 생성

이번엔 새로운 `my_application_3` 프로젝트를 생성해서 두 개의 모듈 JAR 파일을 가져와 사용해 보자.

1.  이클립스 메뉴에서 [File] - [New] - [Java Project]를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 [Finish] 버튼을 클릭한다.
    *   Project name: `my_application_3`
    *   Module: [체크] Create module-info.java file (중요)
    *   Module name: `my_application_3`

2.  Package Explorer 뷰에서 `my_application_3`을 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Build Path] - [Configure Build Path] 메뉴를 선택한다. [Libraries] 탭의 Modulepath 항목을 선택한 후, [Add External JARs] 버튼을 클릭한다.

3.  `my_module_a`와 `my_module_b` 모듈의 `dist` 폴더로 각각 이동해서 `my_module_a.jar` 파일과 `my_module_b.jar` 파일을 추가한다. 그리고 [Apply and Close] 버튼을 클릭한다.

4.  `my_application_3` 프로젝트는 `my_module_a` 모듈과 `my_module_b` 모듈을 사용해야 하므로 두 모듈 프로젝트에 대한 의존 설정이 필요하다. 모듈 기술자를 열고 다음과 같이 작성한다.

    **module-info.java**
    ```java
    module my_application_3 {
        requires my_module_a;
        requires my_module_b;
    }
    ```

5.  `my_application_3` 모듈의 `src` 폴더에서 `app` 패키지를 생성한다. 그리고 `Main` 클래스를 생성하고 다음과 같이 작성하고 실행한다.

    **Main.java**
    ```java
    package app;
    
    import pack1.A;
    import pack2.B;
    import pack3.C;
    
    public class Main {
        public static void main(String[] args) {
            // my_module_a 패키지에 포함된 A 클래스 이용
            A a = new A();
            a.method();
            
            // my_module_a 패키지에 포함된 B 클래스 이용
            B b = new B();
            b.method();
            
            // my_module_b 패키지에 포함된 C 클래스 이용
            C c = new C();
            c.method();
        }
    }
    ```

    **실행 결과**
    ```
    A-method 실행
    B-method 실행
    C-method 실행
    ```

## 10.5 패키지 은닉

모듈은 모듈 기술자(`module-info.java`)에서 `exports` 키워드를 사용해 내부 패키지 중 외부에서 사용할 패키지를 지정한다. `exports` 되지 않은 패키지는 자동적으로 은닉된다.

모듈이 일부 패키지를 은닉하는 이유는 다음과 같다.
*   **모듈 사용 방법 통일**: 모듈 외부에서 패키지2와 3을 사용하지 못하도록 막고, 패키지1로 사용 방법을 통일한다.
*   **쉬운 수정**: 모듈 성능 향상을 위해 패키지2와 3을 수정하더라도 모듈 사용 방법(패키지1)이 달라지지 않기 때문에 외부에 영향을 주지 않는다.

`my_module_a`의 `module-info.java`를 수정해서 `pack2`를 은닉시켜 보자. 그리고 `pack1`의 `A` 클래스에서 `pack2`의 `B` 클래스를 사용하도록 수정하자.

**module-info.java**
```java
module my_module_a {
    exports pack1;
    // exports pack2;
}
```

**A.java**
```java
package pack1;

import pack2.B;

public class A {
    // 메소드
    public void method() {
        System.out.println("A-method 실행");
        
        // B 클래스 사용
        B b = new B();
        b.method();
    }
}
```

`pack2`가 은닉되어 외부에서 사용할 수 없으므로 `my_application_2`의 `Main.java`도 다음과 같이 수정한다.

**Main.java**
```java
package app;

import pack1.A;
// import pack2.B;
import pack3.C;

public class Main {
    public static void main(String[] args) {
        // my_module_a 패키지에 포함된 A 클래스 이용
        A a = new A();
        a.method();
        
        // my_module_a 패키지에 포함된 B 클래스 이용
        // B b = new B();
        // b.method();
        

## 10.6 전이 의존

`my_application_2` 프로젝트와 `my_module_a`, `my_module_b` 모듈의 의존 관계는 다음과 같이 표현할 수 있다. `my_application_2`는 직접적으로 두 모듈을 requires 하고 있기 때문이다.

```
my_application_2 -> my_module_a
                 -> my_module_b
```

다음과 같이 의존 관계를 변경한다고 가정해 보자.

```
my_application_2 -> my_module_a -> my_module_b
```

`my_application_2`는 `my_module_a`에 의존하고, `my_module_a`는 `my_module_b`에 의존한다. 따라서 `my_application_2`와 `my_module_a`의 모듈 기술자는 다음과 같이 작성할 수 있을 것이다.

**my_application_2 module-info.java**
```java
module my_application_2 {
    requires my_module_a;
}
```

**my_module_a module-info.java**
```java
module my_module_a {
    exports pack1;
    requires my_module_b;
}
```

이렇게 작성하면 `my_application_2`의 Main 클래스는 `my_module_b` 모듈을 사용할 수 없기 때문에 컴파일 오류가 발생한다. `my_application_2`의 모듈 기술자에서 `requires my_module_b`가 빠졌기 때문이다.

Main 클래스에서 `my_module_b` 패키지 코드를 모두 제거하면 되겠지만, 제거할 수 없는 경우도 있다. 다음과 같이 `my_module_a` 소속의 A 클래스가 `my_module_b` 소속의 C 타입 객체를 리턴하는 경우이다.

```java
A a = new A();
C c = a.method();
```

`my_application_2`에서 이 코드를 사용해야 한다면 C 타입이 있기 때문에 `my_application_2`의 모듈 기술자에 `requires my_module_b`를 반드시 추가해야 한다. `my_application_2`는 단지 `my_module_a`만 사용하고 싶었는데도 말이다.

이 문제를 해결할 방법은 `my_module_a`가 가지고 있다. `my_module_a`의 모듈 기술자에 `transitive` 키워드와 함께 `my_module_b`를 의존 설정하면 된다. 그러면 `my_application_2`에서도 `my_module_b`를 사용할 수 있게 된다. 의존 설정이 전이되기 때문이다.

**my_module_a module-info.java**
```java
module my_module_a {
    exports pack1;
    requires transitive my_module_b;
}
```

다음 실습을 통해 전이 의존을 확인해 보자.

### my_module_a 모듈 수정

1.  Package Explorer 뷰에서 `my_module_a`를 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Build Path] - [Configure Build Path] 메뉴를 클릭한다. [Projects] 탭에서 Modulepath 항목을 선택한 후 [Add] 버튼을 클릭한다. `my_module_b` 모듈의 체크박스에 체크하고 [OK] 버튼을 클릭한다.

2.  Required projects on the build path에 `my_module_b` 모듈이 추가된 것을 확인하고 [Apply and Close] 버튼을 클릭한다.

3.  `my_module_a`의 모듈 기술자를 열고 다음과 같이 `my_module_b` 모듈을 전이적 의존으로 기술한다.

    **module-info.java**
    ```java
    module my_module_a {
        exports pack1;
        // exports pack2;
        requires transitive my_module_b;
    }
    ```

4.  `my_module_a`의 `A` 클래스에서 `getC()` 메소드를 선언한 다음, `my_module_b` 소속의 `C` 클래스로부터 객체를 생성하고 리턴하도록 다음과 같이 작성한다.

    **A.java**
    ```java
    package pack1;

    import pack2.B;
    import pack3.C;

    public class A {
        // 메소드
        public void method() {
            System.out.println("A-method 실행");
            // B 클래스 사용
            B b = new B();
            b.method();
        }
        
        // 메소드
        public C getC() {
            C c = new C();
            return c;
        }
    }
    ```

### my_application_2 프로젝트 수정

1.  Package Explorer 뷰에서 `my_application_2` 프로젝트의 모듈 기술자를 열고, `my_module_b` 모듈의 직접적 의존 관계를 주석 처리한다.

    **module-info.java**
    ```java
    module my_application_2 {
        requires my_module_a;
        // requires my_module_b;
    }
    ```

2.  `my_application_2`의 `Main` 클래스에 다음과 같이 21~22라인을 추가한다.

    **Main.java**
    ```java
    package app;

    import pack1.A;
    // import pack2.B;
    import pack3.C;

    public class Main {
        public static void main(String[] args) {
            // my_module_a 패키지에 포함된 A 클래스 이용
            A a = new A();
            a.method();
            
            // my_module_a 패키지에 포함된 B 클래스 이용
            // B b = new B();
            // b.method();
            
            // my_module_b 패키지에 포함된 C 클래스 이용
            C c = new C();
            c.method();
            
            C result = a.getC();
            result.method();
        }
    }
    ```

    **실행 결과**
    ```
    A-method 실행
    B-method 실행
    C-method 실행
    C-method 실행
    ```

`my_application_2` 모듈 기술자에서 `requires my_module_b`를 제거했음에도 불구하고 여전히 Main 클래스에서 `my_module_b` 소속의 `pack3.C` 클래스를 사용할 수 있다. 이는 `my_module_a` 모듈 기술자에서 `transitive`로 `my_module_b`를 의존 설정했기 때문이다.

## 10.7 집합 모듈

집합 모듈은 여러 모듈을 모아놓은 모듈을 말한다. 자주 사용되는 모듈들을 일일이 requires 하는 번거로움을 피하고 싶을 때 집합 모듈을 생성하면 편리하다. 집합 모듈은 자체적인 패키지를 가지지 않고, 모듈 기술자에 전이 의존 설정만 한다.

예를 들어 `my_module`은 `my_module_a`와 `my_module_b`을 제공하는 집합 모듈이라고 가정해 보자. `my_module`의 모듈 기술자는 다음과 같이 작성할 수 있다.

```java
module my_module {
    requires transitive my_module_a;
    requires transitive my_module_b;
}
```

이때 다른 프로젝트에서 `my_module`만 requires 하게 되면 `my_module_a`와 `my_module_b` 모듈 둘 다 사용할 수 있게 된다. 실습을 통해 확인해 보자.

### my_module 모듈 생성

1.  이클립스 메뉴에서 [File] - [New] - [Java Project]를 선택한다. Create a Java Project 대화상자가 나타나면 다음과 같이 입력하고 [Finish] 버튼을 클릭한다.
    *   Project name: `my_module`
    *   Module: [체크] Create module-info.java file (중요)
    *   Module name: `my_module`

2.  `my_module` 모듈은 `my_module_a`와 `my_module_b` 모듈을 제공할 목적으로 사용하므로 두 모듈에 대한 전이 의존 설정만 필요하다. 모듈 기술자(`module-info.java`)에 다음과 같이 작성한다.

    **module-info.java**
    ```java
    module my_module {
        requires transitive my_module_a;
        requires transitive my_module_b;
    }
    ```

3.  `my_module`이 두 모듈을 인식해야 하므로 Build Path에 추가하자. Package Explorer 뷰에서 `my_module`을 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Build Path] - [Configure Build Path] 메뉴를 클릭한다. [Projects] 탭에서 Modulepath 항목을 선택하고 [Add] 버튼을 클릭해 연 후 `my_module_a`와 `my_module_b` 모듈을 체크하고 [OK] 버튼을 클릭한다.

4.  Required projects on the build path에 두 모듈이 추가된 것을 확인하고 [Apply and Close] 버튼을 클릭해 닫는다.

### my_application_2 프로젝트 수정

1.  이제 `my_application_2`의 Build Path를 수정하자. Package Explorer 뷰에서 `my_application_2`를 선택한 다음 마우스 오른쪽 버튼으로 클릭하여 [Build Path] - [Configure Build Path] 메뉴를 클릭한다. [Projects] 탭에서 Modulepath 항목을 선택한 후 [Add] 버튼을 클릭한다. `my_module`의 체크박스에 체크하고 [OK] 버튼을 클릭한다.

2.  Required projects on the build path에 `my_module`이 추가된 것을 확인하고 [Apply and Close] 버튼을 클릭한다.

    > **my_module_a와 my_module_b가 Modulepath에 있어야 하는 이유**
    >
    > `my_application_2`는 결국 `my_module_a`와 `my_module_b`를 사용해야 하므로 이 두 모듈이 전부 ClassPath 위치에 있어야 한다.

3.  `my_application_2` 프로젝트의 모듈 기술자를 다음과 같이 수정한다. `my_module_a`와 `my_module_b`의 직접적 의존을 주석 처리하는 대신에 집합 모듈인 `my_module`을 의존한다.

    **module-info.java**
    ```java
    module my_application_2 {
        // requires my_module_a;
        // requires my_module_b;
        requires my_module;
    }
    ```

    Main 클래스는 수정할 내용이 없으니 실행만 해보자.

    **Main.java**
    ```java
    package app;

    import pack1.A;
    // import pack2.B;
    import pack3.C;

    public class Main {
        public static void main(String[] args) {
            // my_module_a 패키지에 포함된 A 클래스 이용
            A a = new A();
            a.method();
            
            // my_module_a 패키지에 포함된 B 클래스 이용
            // B b = new B();
            // b.method();
            
            // my_module_b 패키지에 포함된 C 클래스 이용
            C c = new C();
            c.method();
            
            C result = a.getC();
            result.method();
        }
    }
    ```

    **실행 결과**
    ```
    A-method 실행
    B-method 실행
    C-method 실행
    C-method 실행
    ```

집합 모듈인 `my_module`만 requires 하더라도 `my_module_a`와 `my_module_b` 소속의 클래스 A와 C를 사용하는 데에는 아무런 문제가 발생하지 않는다.

## 10.8 리플렉션 허용

은닉된 패키지는 기본적으로 다른 모듈에 의해 리플렉션을 허용하지 않는다. 리플렉션(Reflection)이란 실행 도중에 타입(클래스, 인터페이스 등)을 검사하고 구성 멤버를 조사하는 것을 말한다.

경우에 따라서는 은닉된 패키지도 리플렉션을 허용해야 할 때가 있다. 모듈은 모듈 기술자를 통해 모듈 전체 또는 지정된 패키지에 대해 리플렉션을 허용할 수 있고, 특정 외부 모듈에서만 리플렉션을 허용할 수도 있다.

*   **모듈 전체를 리플렉션 허용**
    ```java
    open module 모듈명 {
        ...
    }
    ```

*   **지정된 패키지에 대해 리플렉션 허용**
    ```java
    module 모듈명 {
        opens 패키지1;
        opens 패키지2;
    }
    ```

*   **지정된 패키지에 대해 특정 외부 모듈에서만 리플렉션 허용**
    ```java
    module 모듈명 {
        opens 패키지1 to 외부모듈명, 외부모듈명, ...;
        opens 패키지2 to 외부모듈명;
    }
    ```

export된 패키지는 언제든지 리플렉션이 가능하므로 opens로 지정할 필요가 없다. opens는 은닉된 패키지 중에서 특정 패키지에 대한 리플렉션을 허용한다.

리플렉션 프로그래밍 방법은 12.11절에서 자세히 학습하기로 하고, 여기서는 간단히 `open`, `opens` 키워드로 리플렉션을 허용할 수 있다는 것만 알고 넘어가자.

## 10.9 자바 표준 모듈

자바 프로그램이라면 반드시 활용해야 하는 라이브러리가 있다. 바로 JDK가 제공하는 표준 라이브러리이다. 표준 라이브러리는 Java 9부터 모듈화가 되어 Java 21 표준 모듈이 완성되었다.

`java.base`는 모든 모듈이 의존하는 기본 모듈이다. `java.base` 모듈은 requires 하지 않아도 사용할 수 있지만, 다른 모듈들은 모듈 기술자에 requires를 명시하고 사용해야 한다. `java.base` 모듈에는 `java.lang`, `java.util`, `java.io` 등의 핵심 패키지가 있으며, `java.lang`을 제외하고 import해서 사용할 수 있다.

`java.se`는 JDK가 제공하는 모든 모듈을 제공하는 집합 모듈이다. Java 8 이전 버전과 같이 자바 표준 라이브러리를 제한 없이 사용하고 싶을 경우에는 이 `java.se`를 requires 하면 된다.

```java
module my_application {
    requires java.se;
}
```

또 다른 방법은 `thisisjava` 프로젝트처럼 모듈 기술자가 없는 프로젝트를 만드는 것이다. 모듈 기술자가 없으면 모듈로 인식되지 않기 때문에 자바 표준 라이브러리를 제한 없이 사용할 수 있다.

Java 8 이전 버전까지는 응용프로그램이 표준 라이브러리의 5%만 사용하는데도 불구하고 응용프로그램을 실행하려면 전체 표준 라이브러리가 갖추어진 자바 실행 환경(JRE)이 필요했었다.

표준 라이브러리를 모듈화한 이유는 응용프로그램을 실행하는 데 필요한 모듈만으로 구성된 작은 사이즈의 자바 실행 환경(JRE)을 만들기 위해서이다. 작은 사이즈의 자바 실행 환경이 필요한 경우는 다음과 같다.

*   독립 실행형(응용프로그램 + 표준 라이브러리)으로 배포할 경우 표준 라이브러리의 크기가 작을수록 배포 사이즈가 줄어든다.
*   제한된 자원만 가지고 있는 소형(임베디드) 기기에서는 사이즈가 작은 자바 실행 환경이 필요하다.

자바 표준 모듈은 모듈 A에서 모듈 D까지 제공하지만, 프로젝트를 실행하는 데는 모듈 A와 모듈 B만 있으면 된다. 따라서 모듈 C와 모듈 D를 제외하고 프로젝트만 실행할 수 있는 작은 실행 환경을 `jlink` 명령어로 생성할 수 있다.

> **Java 8의 콤팩트 프로파일**
>
> Java 8의 콤팩트 프로파일(compact1, compact2, compact3)도 작은 사이즈의 자바 실행 환경을 위해 도입되었다. 그러나 compact2에 소속된 1개의 클래스만 필요한 경우라도 어쩔 수 없이 compact1보다 더 큰 compact2를 배포해야 하는 단점은 있다.

## 확인문제

1. 자바 라이브러리에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 일반적으로 JAR(*.jar) 파일 형태로 존재한다.
   - ② JAR 파일 안에는 클래스 및 인터페이스의 소스 파일이 있다.
   - ③ 라이브러리에 포함된 모든 패키지는 프로그램에서 접근이 가능하다.
   - ④ 이클립스 프로젝트에서 사용할 경우 Build Path에 JAR 파일을 추가한다.

   **정답:** ② (JAR 파일 안에는 바이트코드 파일(*.class)이 있다.)

2. 모듈에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 모듈은 패키지 관리 기능까지 포함된 라이브러리라고 볼 수 있다.
   - ② 모듈에 포함된 일부 패키지는 은닉해서 접근할 수 없도록 할 수 있다.
   - ③ 모듈은 모듈 기술자가 반드시 존재할 필요는 없다.
   - ④ 모듈도 라이브러리이므로 JAR 파일 형태로 배포될 수 있다.

   **정답:** ③ (모듈은 모듈 기술자(`module-info.java`)가 반드시 존재해야 한다.)

3. 모듈 기술자(`module-info.java`)에 기술되는 내용으로 틀린 것은 무엇입니까?
   - ① `exports`는 외부에서 접근할 수 있는 패키지를 기술한다.
   - ② `requires`는 의존 모듈을 기술한다.
   - ③ `requires`를 기술할 때에는 `exports`를 기술할 수 없다.
   - ④ `transitive`는 전이 의존 모듈을 기술한다.

   **정답:** ③ (함께 기술할 수 있다.)

4. 집합 모듈에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 한 번의 의존 설정으로 여러 모듈을 사용할 수 있도록 해준다.
   - ② 집합 모듈 기술자에는 `requires transitive`로 의존 모듈을 기술한다.
   - ③ 집합 모듈 기술자에는 `requires transitive`로 다른 집합 모듈을 기술할 수 있다.
   - ④ 집합 모듈을 의존 설정할 경우에는 다른 모듈을 의존 설정할 수 없다.

   **정답:** ④ (다른 모듈도 추가로 의존 설정할 수 있다.)

5. 자바 표준 모듈에 대한 설명으로 틀린 것은 무엇입니까?
   - ① `java.base` 모듈은 기본 모듈이므로 requires 하지 않아도 사용할 수 있다.
   - ② `java.base` 모듈에 속한 패키지는 import 없이도 사용할 수 있다.
   - ③ `java.se` 모듈은 JDK의 전체 모듈을 사용할 수 있도록 구성된 집합 모듈이다.
   - ④ 자바 표준 모듈은 작은 자바 실행 환경을 만들기 위해 설계되었다.

   **정답:** ② (java.base 모듈의 java.lang 패키지만 import 없이 사용할 수 있다. java.util, java.io 등은 import 해야 한다.)
