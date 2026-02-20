---
layout: oop
title: "10.4 모듈 배포용 JAR 파일"
nav_order: 4
parent: "Chapter 10. 라이브러리와 모듈"
grand_parent: "객체지향 자바 프로그래밍"
---

# 10.4 모듈 배포용 JAR 파일

모듈 개발을 완료했다면 다른 모듈에서 쉽게 사용할 수 있도록 바이트코드 파일(`.class`)로 구성된 배포용 JAR 파일을 생성해 보자. 이전 예제에서 만든 `my_module_a`와 `my_module_b` 모듈의 배포용 JAR 파일을 각각 생성한다.

## 모듈 배포용 JAR 파일 생성

`my_module_a`와 `my_module_b` 모듈에 각각 JAR 파일을 저장할 `dist` 폴더를 생성하자. 모듈 프로젝트에서 마우스 오른쪽 버튼을 클릭하여 [New] - [Folder]를 선택하고 Folder name에 `dist`를 입력한 후 [Finish] 버튼을 클릭한다.

`my_module_a` 모듈의 배포용 JAR 파일을 생성하는 방법은 다음과 같다.

1.  `my_module_a` 모듈을 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Export]를 선택한다.
2.  Java 항목을 확장하고 JAR file을 선택한 후, [Next] 버튼을 클릭한다.
3.  `my_module_a`를 확장하여 `src` 폴더에만 체크박스에 체크하고 나머지는 모두 체크 해제한다.
4.  Select the export destination에서 [Browse] 버튼을 클릭하고, `my_module_a` 모듈의 `dist` 폴더로 이동한다. 파일 이름은 `my_module_a.jar`로 입력하고 [저장], [Finish] 버튼을 클릭한다.
5.  Package Explorer 뷰에서 `my_module_a` 모듈을 선택하고 마우스 오른쪽 버튼으로 클릭하여 [Refresh]를 선택한다. `dist` 폴더에 JAR 파일이 생성되었는지 확인한다.
6.  `my_module_b` 모듈의 배포용 JAR 파일도 위와 동일한 방법으로 생성한다.

## my_application_3 프로젝트 생성

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
