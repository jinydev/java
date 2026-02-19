---
layout: gui
title: "24.md"
---




## 01. JavaFX 개요

## 02. JavaFX 프로젝트 생성 및 실행

## 03. JavaFX 레이아웃

## 04. JavaFX 컨테이너

## 05. JavaFX 이벤트 처리

## 06. JavaFX 속성 감시와 바인딩

## 07. JavaFx 컨트롤

## 08. JavaFX 메뉴바와 툴바

## 09. JavaFX 다이얼로그

## 10. JavaFX CSS 스타일

## 11. JavaFX 스레드 UI 변경

## 12. 장면 이동과 애니메이션

## 13. JavaFX 과제



## 01. JavaFX 개요

JavaFX는 자바 기반 UI 애플리케이션Rich Client Application을 개발할 때 사용할 수 있는 그래픽과 미디어

모듈을 말한다. 자바의 UI 라이브러리의 변천 과정은 다음과 같다.

AWT

자바 언어가 탄생한 1995년에는 인터넷이 활성화되지 않았기 때문에 대부분의 클라이언트 애플리

케이션은 운영체제가 제공하는 네이티브native UI 컴포넌트를 이용해서 개발되었다. 그래서 Java 1.0

에 포함된 AWTAbstract Window Toolkit는 운영 체제가 제공하는 네이티브 UI 컴포넌트를 이용하는 자바

라이브러리였다. 그렇다 보니 자바 애플리케이션이 실행되는 운영체제에 따라 UI의 모양이 서로 달

랐고, 종류도 제한적이었다.

Swing

AWT의 다음 주자로 Swing이 등장했다. Swing의 중심 아이디어는 운영체제가 제공하는 네이티

브 UI 컴포넌트를 사용하지 말자는 것이었다. 즉 모든 운영체제상에서 동일한 UI를 갖도록, Swing

자신만의 UI (look and feel )를 갖도록 했다. 그렇다 보니 실행 성능이 느려지고, 메모리를 더 많

이 사용하게 되었다. 시간이 흘러 네이티브 UI가 애니메이션과 다양한 시각적인 효과를 내면서 사

용자는 Swing의 UI보다는 운영체제의 네이티브 UI를 더 선호하게 되었다. 그래서 Swing은 점점

네이티브 UI에 밀려나기 시작했다.

JavaFX

JavaFX는 Java 기반의 데스크톱, 모바일 및 임베디드 시스템을 위한 오픈 소스 차세대 UI 클라이

언트 애플리케이션 플랫폼이다. JavaFX는 자바 코드와 분리해서 스타일 시트(CSS )를 작성할 수

있기 때문에 테마를 쉽게 변경할 수 있고, 안드로이드처럼 화면 레이아웃과 비즈니스 로직을 분리할

수 있기 때문에 Swing보다는 편리하게 디자인을 할 수 있다는 장점이 있다. 다음은 JavaFX 애플리

케이션을 구성하는 파일 단위 요소를 보여준다.

JavaFX 애플리케이션 구성 요소

[레이아웃]
자바 코드 파일
또는
FXML 파일

[외관 및 스타일]
CSS 파일

[비즈니스 로직]
자바 코드 파일

[리소스]
그림 파일
동영상 파일
…


JavaFX 설치

JavaFX는 Java 7과 Java 8에서는 JDK에 포함되어 있지만, Java 11부터 JDK에 포함되지 않고

오픈 소스 모듈로 진화하였다. 따라서 JavaFX를 사용하려면 별도의 설치 작업이 필요하다. JavaFX

모듈 설치 파일은 다음 URL에서 다운로드할 수 있다.

https ://gluonhq.com/products/javafx

장기 지원Long Term Support, LTS 버전을 받는 것이 좋기 때문에 21.0.1 [LTS] 버전을 선택한다. 운영체제

와 CPU 아키텍처는 사용하는 PC에 따라 선택하고, 타입은 SDK를 선택한다.

JavaFX 버전은 다운로드하는 시점에 따라 달라질 수 있다.

윈도우 운영체제용 설치 파일은 압축 파일(zip ) 형식으로 되어 있다. 압축을 해제하면 다음 폴더가

나온다.

javafx -sdk -21.0.1

이 폴더를 다음 경로로 이동시킨다.

C :\ThisisJava\javafx -sdk -21.0.1

javafx-sdk-21.0.1 폴더 내부를 보면 lib 폴더가 있다. 이 폴더에는 JavaFX에서 제공하는 모듈

파일(JAR )이 있다. 이들 모듈에 포함되어 있는 패키지와 패키지 내부의 클래스 및 인터페이스를 보

려면 API 도큐먼트가 필요하다. API 도큐먼트는 다음 URL에서 볼 수 있다. 학습할 때 언제든지 참

고할 수 있도록 웹 브라우저 북마크(즐겨찾기)에 추가해 두자.

https ://openjfx.io/javadoc/21



Scene Builder 설치

씬 빌더Scene Builder는 드래그 앤 드롭 사용자 인터페이스 디자인 방식으로 JavaFX의 화면 레이아웃

FXML 파일을 자동 생성해주는 오픈 소스 도구이다. Scene Builder 설치 파일은 다음 URL에서

다운로드할 수 있다.

https ://gluonhq.com/products/scene -builder

사용하는 PC의 운영체제에 따라 설치 파일을 다운로드한다.

설치 과정에서 윈도우 운영체제에서의 설치 경로를 다음과 같이 변경해 준다.

C :\ThisisJava\javafx -sdk -21.0.1\SceneBuilder


설치 완료 후 다음 파일을 더블 클릭하면 Scene Builder가 실행된다.

C :\ThisisJava\javafx -sdk -21.0.1\SceneBuilder\SceneBuilder.exe

Empty 템플릿을 선택하면 다음과 같은 FXML 편집기가 실행된다. 편집기 실행을 확인하고 우측

상단에 있는 종료 버튼(

)을 클릭해서 편집기를 닫는다.

e(fx)clipse 설치

e (fx )clipse는 JavaFX 개발도구를 제공해 주는 이클립스 플러그인이다. 프로젝트 생성 및 자동 완

성, FXML 파일을 Scene Builder로 열기 등의 기능을 제공하기 때문에 매우 편리하다.



이클립스 메뉴에서 [Help] - [Install New Software…]를 선택하고, [work with:]에 ‘https://

download.eclipse.org/efxclipse/updates-nightly/site/’를 입력하고 [Add…] 버튼을 클

릭하면 다음과 같은 [Add Repository] 대화상자를 확인할 수 있다. 대화상자의 [Name:]에

‘efxclipse’라고 입력하고 [Add] 버튼을 클릭해 설치한다.

e (fx )clipse는 3.10 버전 이상을 설치해야 하지만, 현재는 아직 nightly 버전에 해당하므로 정식 버전이 출시

되면 [Eclipse Marketplace…]에서 설치할 수 있을 것이다.

이클립스 메뉴에서 [Window] - [Preferences]를 선택한다. 왼쪽 항목에서 JavaFX를 선택하면

다음과 같이 SceneBuilder 실행 파일 경로와 JavaFX SDK 경로를 입력하는 내용이 나온다.

입력란에서 [Browse] 버튼을 클릭해 다음 경로의 파일을 선택해준다.

SceneBuilder executable

C :\ThisisJava\javafx -sdk -21.0.1\SceneBuilder\SceneBuilder.exe

JavaFX 11 + SDK

C :\ThisisJava\javafx -sdk -12.0.1\lib

[Apply and Close] 버튼을 클릭해 적용한다.


## 02. JavaFX 프로젝트 생성 및 실행

JavaFX 애플리케이션을 위한 프로젝트는 Java Project 또는 e (fx )clipse가 제공해주는 JavaFX

Project 위자드를 이용해서 생성할 수 있다. 처음 학습할 때에는 Java Project로 생성하는 것이 좋

고, JavaFX가 어느 정도 익숙해지면 JavaFX Project 위자드를 이용하는 것이 좋다.

프로젝트 생성 및 설정

이클립스 메뉴에서 [File] - [New] - [Java

Project]를 선택한다. [New Java Project]

대화상자의 [Project name]에 ‘thisisjava_

appendix_javafx’를 입력한다. JavaFX 프로

젝트는 JavaFX SDK가 제공하는 모듈을 참조

해야 하고, 이들 모듈에 대한 의존 설정을 해야

하므로 모듈 기술자가 포함된 프로젝트로 생

성해야 한다. 따라서 [Create module-info.

java file] 체크박스에 체크한다. [Module

name ]은  [Project   name ]과  동일하게

‘thisisjava_appendix_javafx’라고 입력하고

[Finish] 버튼을 클릭한다.

JavaFX 모듈 참조 및 의존성 설정

JavaFX 프로젝트는 JavaFX SDK가 제공하는 모듈을 참조해야 한다. thisisjava_appendix_

javafx 프로젝트를 선택하고 마우스 오른쪽 버튼을 클릭하여 [Build Path] - [Configure Build

Path] 메뉴를 선택한다. [Libraries] 탭에서 Modulepath를 선택하고, [Add External JARs] 버

튼을 클릭한다.



다음 폴더에 있는 모든 모듈 파일(JAR )을 선택하고, 화살표를 눌러 확장한다.

C :\ThisisJava\javafx -sdk -21.0.1\lib

우리 책에서는 javafx.control, javafx.fxml, javafx.media 모듈을 사용하므로 모듈 기술자에서

이들 모듈에 대한 의존 설정을 해야 한다.

>>> module-info.java


open module thisisjava_appendix_javafx {
requires java.se;
requires javafx.controls;
requires javafx.fxml;
requires javafx.media;

}

open 키워드가 추가된 이유는 JavaFX 애플리케이션이 실행될 때 클래스 리플렉션을 수행하기 때

문에 프로젝트 내부의 모든 클래스에 대해 리플렉션을 허용하기 위해서이다. java.se 집합 모듈은

JDK가 제공하는 모든 모듈을 사용하기 위해 추가하였다.


메인 클래스 작성

JavaFX 애플리케이션을 개발하려면 제일 먼저 메인 클래스를 작성해야 한다. 메인 클래스는 JavaFX

애플리케이션을 시작하는 관문이다. 메인 클래스는 추상 클래스인 Application을 상속받고, start ( )

메소드를 재정의해야 한다.

그리고 main ( ) 메소드에서는 Application의 launch ( ) 메소드를 호출해야 한다. launch ( ) 메

소드는 메인 클래스의 객체를 생성하고, 메인 윈도우를 생성한 다음 start ( ) 메소드를 호출하는 역할

을 한다.

>>> AppMain.java

```java
package sec02.exam01_application_start;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
primaryStage.show();   //윈도우 보여주기

}

public static void main(String[] args) {
launch(args);   //AppMain 객체 생성 및 메인 윈도우 생성

}

}

```

실행 결과

JavaFX는 윈도우를 무대(Stage )로 표현한다. launch ( )는 start ( ) 메소드를 호출할 때 메인 윈도

우를 primaryStage로 제공하는데, start ( )에서 primaryStage.show ( ) 메소드를 호출함으로써

메인 윈도우가 보여진다.




JavaFX 라이프사이클

JavaFx 애플리케이션은 Application.launch ( ) 메소드부터 시작해서 다음과 같은 순서로 진행된다.

Application.launch()

기본 생성자

init()

start()

사용

Platform.exit() 호출
또는
마지막 Stage 닫힘

stop()

종료

launch ( ) 메소드가 호출되면 메인 클래스의 기본 생성자를 호출해서 객체를 생성하고, 이어서 init ( )

메소드를 호출한다. init ( ) 메소드는 메인 클래스의 실행 매개값을 얻어 애플리케이션이 이용할 수

있도록 해준다. init ( )이 끝나고 나면, start ( ) 메소드를 호출해서 메인 윈도우를 실행시킨다.

JavaFX 애플리케이션이 종료되는 경우는 다음과 같이 세 가지가 있다.

① 마우스로 마지막 윈도우(Stage )의 우측 상단 닫기 버튼을 클릭했을 때

② 자바 코드로 마지막 윈도우(Stage )의 close ( ) 메소드를 호출했을 때

③ 자바 코드로 Platform.exit ( ) 또는 System.exit (0 )을 호출했을 때

JavaFX 애플리케이션은 종료되기 직전에 stop ( ) 메소드를 호출하는데, stop ( ) 메소드는 사용한

자원을 정리(파일 닫기, 네트워크 끊기)할 기회를 준다. init ( )과 stop ( ) 메소드는 옵션으로 필요

한 경우에 재정의해서 사용하면 된다.

주목할 점은 라이프사이클의 각 단계에서 호출되는 메소드는 서로 다른 스레드상에서 실행된다는

것이다. JVM이 생성한 main 스레드가 launch ( )를 실행하면 다음과 같은 이름을 가진 2개의 스레

드를 생성하고 시작시킨다.

① JavaFX -Launcher : init ( ) 실행

② JavaFX Application Thread : 메인 클래스 기본 생성자, start ( ) 및 stop ( ) 실행


JavaFX 애플리케이션에 윈도우(Stage )를 비롯한 UI 생성 및 수정 작업 그리고 이벤트 처리 등은

모두 JavaFX Application Thread가 관장한다. 그 이유는 JavaFX API는 스레드에 안전하지 않

아서 멀티 스레드가 동시에 UI를 생성하거나 수정하게 되면 문제가 발생하기 때문이다.

그래서 JavaFX Application Thread만 UI를 생성하거나 수정할 수 있도록 되어 있고, 다른 스레

드가 UI에 접근하게 되면 예외가 발생한다. init ( ) 메소드에서 UI를 생성하는 코드를 작성하면 안

되는데, 그 이유는 init ( ) 메소드가 JavaFX-Launcher 스레드에서 실행되기 때문이다.

다음 예제는 기본 생성자, init ( ), start ( ), stop ( ) 메소드가 어떤 스레드상에서 실행되는지 보여

준다.

>>> AppMain.java

```java
package sec02.exam02_application_lifecycle;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {
public AppMain() {
System.out.println(Thread.currentThread().getName()+": AppMain() 호출");

}

@Override
public void init() throws Exception {
System.out.println(Thread.currentThread().getName()+": init() 호출");

}

@Override
public void start(Stage primaryStage) throws Exception {
System.out.println(Thread.currentThread().getName()+": start() 호출");
primaryStage.show();

}

@Override
public void stop() throws Exception {
System.out.println(Thread.currentThread().getName()+": stop() 호출");

}








public static void main(String[] args) {
System.out.println(Thread.currentThread().getName()+": main() 호출");
launch(args);

}

}

```

실행 결과

main: main() 호출
JavaFX Application Thread: AppMain() 호출
JavaFX-Launcher: init() 호출
JavaFX Application Thread: start() 호출
JavaFX Application Thread: stop() 호출

메인 클래스 실행 매개값 얻기

init ( ) 메소드의 역할은 메인 클래스의 실행 매개값을 얻어 애플리케이션의 초기값으로 이용할 수

있도록 하는 것이다. 메인 클래스를 실행할 때 실행 매개값을 다음과 같이 주었다고 가정해 보자.

java AppMain --ip = 192.168.0.5 --port = 50001

Application.launch ( )는 main ( ) 메소드의 매개값을 그대로 넘겨 받는데, 이 매개값은 init ( ) 메

소드에서 다음과 같이 얻을 수 있다.

Parameters params  =  getParameters();
Map<String, String> map  =  params.getNamed();
String ip  =  map.get("ip");
String port  =  map.get("port");

Parameters의 getNamed ( ) 메소드는 “ip”를 키로 해서 “192.168.0.5”를 저장하고, “port”를 키

로 해서 “50001”을 저장하는 Map 컬렉션을 리턴한다.


무대와 장면

JavaFX는 윈도우를 무대Stage로 표현한다. 무대는 한 번에 하나의 장면을 가질 수 있는데, JavaFX는

장면을 Scene으로 표현한다. 메인 윈도우는 start ( ) 메소드의 primaryStage 매개값으로 전달되

지만, 장면Scene은 직접 생성해야 한다.

Scene을 생성하려면 UI의 루트 컨테이너인 javafx.scene.Parent가 필요하다.

Scene scene  =  new Scene(Parent root);

Parent는 추상 클래스이기 때문에 하위 컨테이너 클래스

로 객체를 생성해서 제공해야 한다. 주로 javafx.scene.

layout 패키지의 컨테이너들이 사용된다. 실제로 UI 컨

트롤들이 추가되는 곳은 컨테이너이며, 컨테이너의 폭과

높이가 장면의 폭과 높이가 된다.

Stage(윈도우)

Scene(장면)

Parent(루트 컨테이너)

Label(UI 컨트롤)

Button(UI 컨트롤)

장면Scene을 생성한 후에는 윈도우Stage에 올려야 하는데,

Stage의 setScene ( ) 메소드를 사용한다. setScene ( )

메소드는 매개값으로 받은 Scene을 윈도우 내용으로 설정한다.

primaryStage.setScene(scene);

다음 예제는 Parent의 하위 클래스인 VBox 컨테이너를 이용해서 Scene을 생성하고 메인 윈도우

(primaryStage )의 장면으로 설정했다. VBox에는 Label과 Button 컨트롤을 배치했다.

>>> AppMain.java


```java
package sec02.exam03_stage_scene;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;




import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
VBox root  =  new VBox();
root.setPrefWidth(350);
root.setPrefHeight(150);
root.setAlignment(Pos.CENTER);
root.setSpacing(20);
```

//Parent 하위 객체인 VBox 생성
//VBox의 폭 설정
//VBox의 높이 설정
//컨트롤을 중앙으로 정렬
//컨트롤의 수직 간격

Label label  =  new Label();
label.setText("Hello, JavaFX");
label.setFont(new Font(50));

//Label 컨트롤 생성
//text 속성 설정
//font 속성 설정

Button button  =  new Button();
button.setText("확인");
button.setOnAction(event -> Platform.exit());   //클릭 이벤트 처리

//Button 컨트롤 생성
//text 속성 설정

root.getChildren().add(label);
root.getChildren().add(button);

//VBox에 Label 컨트롤 추가
//VBox에 Button 컨트롤 추가

Scene scene  =  new Scene(root);

//VBox를 (cid:1814)트 컨테이너로 해서 Scene 생성

primaryStage.setTitle("AppMain");  //윈도우의 제목 설정
//윈도우에 장면 설정
primaryStage.setScene(scene);
//윈도우 보여주기
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}


실행 결과

VBox는 수직 방향으로 컨트롤을 배치하는 컨테이너로 먼저 Label을 배치하고 그 아래에 Button

을 배치했다. 28라인은 Button을 클릭했을 때 발생하는 ActionEvent를 처리한 것이다. Button

을 클릭하면 Platform.exit ( )를 호출해서 애플리케이션을 종료하도록 했다.

## 03. JavaFX 레이아웃

장면Scene에는 다양한 컨트롤이 포함되는데, 이들을 배치하는 것이 레이아웃Layout이다. 레이아웃을

작성하는 방법은 두 가지가 있다. 하나는 자바 코드로 작성하는 프로그램적 레이아웃이고, 다른 하

나는 FXML로 작성하는 선언적 레이아웃이다.

프로그램적 레이아웃

프로그램적 레이아웃이란 자바 코드로 UI 컨트롤을 배치하는 것을 말한다. 자바 코드에 익숙한 개발

자들이 선호하는 방식으로 컨트롤 배치, 스타일 지정, 이벤트 처리 등을 모두 자바 코드로 작성한다.

이 방법은 레이아웃이 복잡해지면 코드가 복잡해지고, 모든 것을 개발자가 직접 작성해야 하므로 디

자이너와 협력해서 개발하는 것도 어렵다. 개발을 완료한 후 간단한 레이아웃 변경을 하더라도 자바

소스를 수정하고 재컴파일해야 한다는 단점도 있다.

다음 예제는 옆의 화면과 같은 레이아웃을 프로그램적 방법으로 작성한 것이다. 텍스트를 입력할 수

있는 TextField 컨트롤과 클릭할 수 있는 Button 컨트롤

이 수평으로 나란히 배치되어 있기 때문에 루트 컨테이너로

HBox를 사용하였다.



>>> AppMain.java


```java
package sec03.exam01_programmatical_layout;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.collections.ObservableList;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
HBox hbox  =  new HBox();
//HBox 컨테이너 생성
hbox.setPadding(new Insets(10, 10, 10, 10));  //안쪽 여백 설정
hbox.setSpacing(10);
```

//컨트롤간의 수(cid:3235) 간격 설정

TextField textField  =  new TextField();  //TextField 컨트롤 생성
textField.setPrefWidth(200);

//TextField의 폭 설정

Button button  =  new Button();
button.setText("확인");

//Button 컨트롤 생성
//Button 글자 설정

ObservableList list  =  hbox.getChildren(); //HBox의 ObservableList 얻기
list.add(textField);
list.add(button);

//TextField 컨트롤 배치
//Button의 컨트롤 배치

Scene scene  =  new Scene(hbox);

//화면의 (cid:1814)트 컨테이너로 HBox 지정

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

//윈도우 창 제목 설정
//윈도우 창에 화면 설정
//윈도우 창 보여주기

}

public static void main(String[] args) {
launch(args);

}

}


FXML 레이아웃

FXML은 XML 기반의 마크업 언어로 JavaFX 애플리케이션의 UI 레이아웃을 자바 코드에서 분리

해서 태그로 선언하는 방법을 제공한다. 이 방법은 안드로이드Android 앱을 개발하는 방법과 유사한

데, XML로 레이아웃을 작성하고, 이벤트 처리 및 애플리케이션 로직은 자바로 작성한다.

태그로 레이아웃을 정의하기 때문에 태그에 익숙한 디자이너와 협업이 쉽고, 개발 완료 후 레이아웃

변경 시 자바 소스를 수정할 필요 없이 FXML 태그만 수정하면 되므로 편리하다. 그리고 레이아웃

이 비슷한 장면Scene들간에 재사용이 가능하기 때문에 개발 기간을 단축시킬 수도 있다.

다음 예제는 프로그램적 레이아웃을 사용하는 이전 예제를 FXML 레이아웃으로 변경한 것이다.

FXML 레이아웃은 root.fxml 파일로 다음과 같이 작성할 수 있다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.HBox?>
<?import javafx.geometry.Insets?>
<?import javafx.scene.control.*?>

<HBox xmlns:fx ="http://javafx.com/fxml">
<padding>
<Insets top ="10" right ="10" bottom ="10" left ="10" />
</padding>
<spacing>10</spacing>
```

<!-- HBox 컨테이너 선언 -->
<!-- 안쪽 여백 설정 -->

<!-- 컨트롤간의 수(cid:3235) 간격 설정 -->

<children>
<TextField>
<prefWidth>200</prefWidth>
</TextField>

```java
<Button>
<text>확인</text>
</Button>
</children>
</HBox>
```

<!-- 자(cid:2343) 컨트롤 추가 -->
<!-- TextField 선언 -->
<!-- TextField의 폭 설정 -->

<!-- Button 컨트롤 선언 -->
<!-- Button 글자 설정 -->



루트 컨테이너인 HBox는 <HBox> 태그로 작성되고, fx 접두사에 대한 네임스페이스 선언

(xmlns:fx="http://javafx.com/fxml")이 추가되어 있는 것을 볼 수 있다. 추후 이것은 FXML

파일에 <fx:XXX> 형태의 태그 및 fx:xxx="값" 형태의 속성을 작성할 수 있다는 뜻이다.

HBox 컨테이너에 들어갈 TextField와 Button은 <children> 태그의 내용으로 각각 <TextField>

와 <Button> 태그로 작성된 것을 볼 수 있다. <padding>은 여백을 말하는데, 곧 이어서 학습한다.

다음은 자바 로직 부분을 작성한 메인 클래스이다.

>>> AppMain.java


```java
package sec03.exam02_fxml_layout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

메인 클래스는 start ( ) 메소드에서 FXML 레이아웃 파일을 읽고 선언된 내용을 객체화해야 한다.

이것을 FXML 로딩이라고 한다. 이때 FXMLLoader의 load ( ) 메소드가 사용된다. load ( ) 메소

드는 정적과 인스턴스 모두 있다.




다음은 정적 load ( ) 메소드로 FXML 레이아웃 파일을 로딩하는 코드이다.

Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));

load ( )의 매개값은 FXML 파일의 위치 정보가 있는 URL 객체이다. FXML 파일이 메인 클래

스와 동일한 패키지에 있을 경우, getClass ( )로 메인 클래스 타입을 얻고 상대 경로를 이용해서

getResource ( )로 FXML 파일을 찾아 URL 객체를 얻을 수 있다.

다음은 인스턴스 load ( ) 메소드로 FXML 레이아웃 파일을 로딩하는 코드이다.

FXMLLoader loader  =  new FXMLLoader(getClass().getResource("root.fxml"));
Parent root  =  (Parent)loader.load();

정적 또는 인스턴스 load ( ) 메소드가 리턴하는 타입은 Parent 타입인데, 실제 객체는 FXML 파일

에서 루트 태그로 선언된 컨테이너이다. 위 예제에서 FXML 파일의 루트 태그는 <HBox>이므로 다

음과 같이 타입 변환이 가능하다.

HBox root  =  (HBox) FXMLLoader.load(getClass().getResource("root.fxml"));

FXML 파일을 로딩해서 Parent 객체를 얻었다면 이것을 가지고 다음과 같이 장면Scene 객체를 생성

하면 된다.

Scene scene  =  new Scene(root);

레이아웃 여백: 패딩과 마진

컨트롤을 보기 좋게 배치하기 위해서 여백이 거의 필수적으로 들어간다. 여백은 패딩padding과 마진

margin이 있는데, 패딩은 안쪽 여백을 말하고 마진은 바깥 여백을 말한다.

패딩은 컨테이너의 setPadding ( ) 메소드를 사용해서 설정하는 반면, 마진은 바깥 컨테이너의

setMargin ( ) 메소드를 사용해야 한다. 예를 들어 Button이 HBox에 포함되어 있을 때 HBox에



서 패딩을 50으로 주는 것과 Button에서 마진을 50으로 주는 것은 동일한 결과를 얻지만 코드는

다르다.

구분

HBox의 패딩

Button의 마진

HBox

HBox

개념

자바

코드

FXML
태그

Button

Button

HBox hbox  =  new HBox();
hbox.setPadding(new Insets(50));

Button button  =  new Button();
HBox.setMargin(button, new Insets(50));

```java
<HBox>
<padding>
<Insets topRightBottomLeft = "50"/>
</padding>
</HBox>

<Button>
<HBox.margin>
<Insets topRightBottomLeft = "50"/>
</HBox.margin>
</Button>
```

마진과 패딩은 적용하는 위치에 따라 top, right, bottom, left로 구분된다.

컨테이너A

컨테이너B

컨테이너A의
top padding

내용

컨테이너A의
right
margin

내용

컨테이너B의
right
padding

마진과 패딩값은 Insets 객체로 제공해야 하는데, 다음과 같이 생성한다. 생성자 매개값의 순서는

top을 시작으로 시계방향으로 나열되어 있어 쉽게 기억할 수 있을 것이다.

//top, right, bottom, left를 모두 동일한 값으로 설정할 때
new Insets(double topRightBottomLeft);

//top, right, bottom, left를 다(cid:1842) 값으로 설정할 때
new Insets(double top, double right, double bottom, double left)


다음 예제를 보면 14~17라인은 HBox의 안

쪽 여백 패딩으로 top과 left는 50, right와

bottom은 10으로 설정했다. 그리고 20~23라인

은 Button의 바깥 여백 마진으로 top과 right

는 10, bottom과 left는 50으로 설정했다. 한

쪽을 주석으로 처리해놓고 각각 실행해 보자.

>>> AppMain.java

HBox Padding

Button Margin


```java
package sec03.exam03_margin_padding;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
//패딩 설정-----------------------
/*HBox hbox  =  new HBox();
hbox.setPadding(new Insets(50, 10, 10, 50));
Button button  =  new Button();
button.setPrefSize(100, 100);*/
```

//마(cid:2771) 설정------------------------
HBox hbox  =  new HBox();
Button button  =  new Button();
button.setPrefSize(100, 100);
HBox.setMargin(button, new Insets(10, 10, 50, 50));

hbox.getChildren().add(button);

Scene scene  =  new Scene(hbox);

primaryStage.setTitle("AppMain");

















primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}

FXML 태그와 자바 코드 매핑

FXML로 선언된 태그는 자바 코드로 변환되어 실행되기 때문에 자바 코드와 매핑 관계가 존재한다.

이 매핑 관계만 잘 이해하면 JavaFX API 도큐먼트를 참조해서 FXML 태그를 쉽게 작성할 수 있다.

다음은 프로그램적 레이아웃 자바 코드와 FXML 레이아웃 태그를 매핑시킨 표이다.

프로그램적 레이아웃 자바 코드

FXML 레이아웃 태그

HBox hbox  =  new HBox();
hbox.setPadding(new Insets(10,10,10,10));
hbox.setSpacing(10);

```java
<HBox xmlns:fx = "http://javafx.com/fxml">
<padding>
<Insets top = "10" right = "10"
bottom = "10" left = "10"/>
</padding>
<spacing>10</spacing>
</HBox>

TextField textField  =  new TextField();
textField.setPrefWidth(200);

Button button  =  new Button();
button.setText("확인");

ObservableList list  =  hbox.getChildren();
list.add(textField);
list.add(button);

<TextField>
<prefWidth>200</prefWidth>
</TextField>

<Button >
<text(cid:31)확인(cid:29)/text>
</Button>

<children>
<TextField>...</TextField>
<Button >...</Button>
</children>
```

FXML은 XML 기반의 마크업 언어이기 때문에 XML 작성 규칙을 잘 지켜서 작성해야 한다. FXML

태그를 무조건 외우기보다는 자바 코드와 매핑되는 FXML 작성 규칙을 이해하면 FXML을 빨리 익





힐 수 있다. 그럼 FXML 작성 규칙을 자세히 살펴보기로 하자.

패키지 선언

자바 코드의 패키지 선언과 매핑되는 FXML 태그는 <?import?>이다. 클래스 하나를 import하는

방법과 같은 패키지의 모든 클래스를 import하는 방법은 다음과 같다.

자바 코드

FXML 태그

```java
import javafx.scene.layout.HBox;

<?import javafx.scene.layout.HBox?>

import javafx.scene.control.*;

<?import javafx.scene.control.*?>

<?import?> 태그를 작성하는 위치는 정해져 있다. XML 선언 태그인 <?xml version="1.0"
```

encoding="UTF-8"?>과 루트 컨테이너 태그 사이이다.

```java
<?xml version = "1.0" encoding = "UTF-8"?>

<?import javafx.scene.layout.HBox?>
<?import javafx.scene.control.*?>
```

(cid:29)(cid:1814)트컨테이너 xmlns:fx = "http://javafx.com/fxml" >
…

(cid:29)/(cid:1814)트컨테이너(cid:31)

FXML 태그의 이름은 하나의 JavaFX API 클래스 이름과 매핑되기 때문에 해당 클래스가 존재하

는 패키지를 반드시 <?import?> 태그로 선언해야 한다. 그렇지 않으면 FXML을 로딩할 때 not a

valid type이라는 메시지와 함께 javafx.fxml.LoadException이 발생한다.

태그 선언

FXML 태그는 < 와 > 사이에 태그 이름을 작성한 것인데, 반드시 시작 태그가 있으면 끝 태그도 있어

야 한다. 그렇지 않으면 javax.xml.stream.XMLStreamException 예외가 발생한다.

(cid:29)태그이름(cid:31) … (cid:29)/태그이름(cid:31)



시작 태그와 끝 태그 사이에는 태그 내용이 작성되는데, 태그 내용이 없을 경우에는 다음과 같이 시

작 태그 끝에 />를 붙이고 끝 태그를 생략할 수 있다.

(cid:29)태그이름/(cid:31)

태그 이름은 JavaFX의 클래스명이거나, Setter의 메소드명이 될 수 있다. 다음 표에서 Button 컨

트롤을 자바 코드로 작성한 것과 FXML 태그로 작성한 것을 비교해보면 쉽게 이해가 될 것이다.

자바 코드

Button button  =  new Button();
button.setText("확인");

FXML

```java
<Button>
<text(cid:31)확인(cid:29)/text>
</Button>
```

속성 선언

FXML 태그는 다음과 같은 속성을 가질 수 있다. 속성값은 큰따옴표(") 또는 작은따옴표(')로 반드

시 감싸야 한다. 그렇지 않으면 javax.xml.stream.XMLStreamException 예외가 발생한다.

(cid:29)태그이름 속성명=  "값" 속성명=  (cid:8612)값(cid:8613)(cid:31) … (cid:29)/태그이름(cid:31)

속성명은 Setter 메소드명이 오는데, 모든 Setter가 사용될 수 있는 것은 아니고 기본 타입(boolean,

byte, short, char, int, long, float, double )의 값을 세팅하거나, String (문자열)을 세팅하는

Setter만 올 수 있다. 예를 들어 Button의 글자를 설정할 때 setText ( ) 메소드를 사용하는데, 매개

값이 문자열이므로 다음과 같이 text 속성으로 작성할 수 있다.

자바 코드

FXML (Setter 태그)

FXML (Setter 속성)

Button button  =  new Button();
button.setText("확인");

```java
<Button >
<text(cid:31)확인(cid:29)/text>
</Button>

<Button text = "확인"/(cid:31)



```

객체 선언

Setter 메소드가 기본 타입과 String 타입이 아닌 다른 타입의 객체를 매개값으로 갖는다면 속성으

로 작성할 수 없고, 태그로 작성해야 한다. 이때 매개값인 객체를 태그로 선언하는 방법을 알아보자.

객체 선언

1) <클래스 속성="값"/>

일반적으로 다음과 같이 클래스명으로 태그를 작성하면 new 연산자로 기본 생성자를 호출해서 객

체가 생성된다.

(cid:29)클래스(cid:31)

만약 생성자에 매개변수가 있고, 매개변수에 @NamedArg (javafx.beans.NamedArg ) 어노테

이션이 적용되어 있다면 속성명이나 자식 태그로 작성할 수 있다.

(cid:29)클래스 속성= "값"(cid:31)

(cid:29)클래스(cid:31)

(cid:29)매개변수(cid:31)값(cid:29)/매개변수(cid:31)

(cid:29)/클래스(cid:31)

예를 들어 HBox의 패딩을 설정할 때 setPadding (Insets value ) 메소드를 사용하는데, Insets는

기본 생성자가 없고 Insets (double topRightBottomLeft ) 또는 Insets (double top, double

right, double bottom, double left )만 있다. 이 경우 Insets 객체를 FXML로 선언하면 다음과

같다.

자바 코드

HBox hbox  =  new HBox();
hbox.setPadding(new Insets(10,10,10,10));

FXML

```java
<HBox>
<padding>
<Insets top = "10" right = "10"
bottom = "10" left = "10"/>
</padding>
</HBox>


```

2) <클래스 fx:value="값"/>

클래스가 valueOf (String ) 메소드를 제공해서 객체를 생성하는 경우가 있다. 예를 들어 String,

Integer, Double, Boolean 클래스는 valueOf (String )을 호출해서 객체를 생성한다. 이 경우

다음과 같이 FXML 태그를 작성할 수 있다.

(cid:29)클래스 fx:value =  "값" />

예를 들어 String, Integer, Double, Boolean 객체를 FXML로 선언하면 다음과 같다.

자바 코드

FXML

String.valueOf("Hello, World");
Integer.valueOf("1");
Double.valueOf("1.0");
Boolean.valueOf("false");

<String fx:value = "Hello, World!"/>
<Integer fx:value = "1"/>
<Double fx:value = "1.0"/>
<Boolean fx:value = "false"/>

3) <클래스 fx:constant="상수"/>

클래스에 정의된 상수값을 얻고 싶을 경우에는 다음과 같이 FXML 태그를 작성할 수 있다.

(cid:29)클래스 fx:constant =  "상수" />

예를 들어 Double.MAX_VALUE 상수값을 Button 컨트롤의 maxWidth 속성값으로 설정할 경

우 다음과 같이 FXML로 선언할 수 있다.

자바 코드

FXML

Button button  =  new Button();
button.setMaxWidth(
Double.MAX_VALUE
);

```java
<Button>
<maxWidth>
<Double fx:constant = "MAX_VALUE"/>
</maxHeight>
</Button>

```

4) <클래스 fx:factory="정적메소드">

어떤 클래스는 new 연산자로 객체를 생성할 수 없고, 정적 메소드로 객체를 얻어야 하는 경우도 있

다. 이 경우 다음과 같이 FXML 태그를 작성할 수 있다.

(cid:29)클래스 fx:factory =  "정적메소드"(cid:31)

예를 들어 ComboBox의 setItems (ObservableList<T> value ) 메소드는 ObservableList 인

터페이스의 구현 객체를 매개값으로 가지는데, ObservableList 구현 객체는 FXCollections의 정

적 메소드인 observableArrayList (E... items ) 메소드로 얻을 수 있다. 그래서 다음과 같이 FXML

을 작성해야 한다.

자바 코드

FXML

ComboBox combo  =  new ComboBox();
combo.setItems(
FXCollections. observableArrayList(
"공개", "비공개"
)
);

<ComboBox>
<items>
<FXCollections fx:factory = "observ
ableArrayList">
<String fx:value = "공개"/(cid:31)
<String fx:value = "비공개"/(cid:31)
</FXCollections>
</items>
</ComboBox>

Scene Builder 사용

지금까지 FXML 태그를 작성하는 방법을 학습했지만, 레이아웃이 복잡해질수록 태그로 직접 작성

한다는 것은 힘든 작업이다. 01절에서 설치한 Scene Builder를 이용해서 드래그 앤 드롭 방식으로

화면을 디자인하면 자동으로 FXML 파일이 생성되므로 매우 편리하다.

실제로 JavaFX 애플리케이션 개발은 전체 레이아웃 작업은 Scene Builder로 빠르게 진행하고,

간단한 수정 작업은 FXML 태그로 직접 작성하는 것이 일반적이다. 다음은 Scene Builder에서

FXML 레이아웃을 작성하는 모습을 보여준다.



이클립스에서 JavaFX Scene Builder를 실행하려면 먼저 FXML 파일을 생성해야 한다. Package

Explorer 뷰에서 sec03.exam04_scene_builder 패키지를 생성하고, 마우스 오른쪽 버튼을 클

릭한 후 [New] - [Other] - [JavaFX]로 들어가 [New FXML Document]를 선택한다.

FXML File 대화상자에서 Name 입력란에 생성할 파일명을 입력하고 Root Element에 루트 컨테

이너가 될 클래스를 선택한 후 [Finish] 버튼을 클릭하면 FXML 파일이 생성된다.


다음은 Root Element를 HBox로 선택하고 생성한 FXML 파일 내용을 보여준다.

```java
<?xml version = "1.0" encoding = "UTF-8"?>

<?import javafx.scene.layout.HBox?>

<HBox xmlns:fx = "http://javafx.com/fxml">
<!-- TODO Add Nodes -->
</HBox>
```

xmlns :fx="http ://javafx.com/fxml/1"로
되어있어도 상관없음, 1은 FXML 버전을 뜻함

생성된 FXML 파일을 Scene Builder로 편집하려면 이클립스 Package Expolorer 뷰에서 FXML

파일을 선택하고 마우스 오른쪽 버튼을 클릭한 후 [Open with SceneBuilder]를 선택하면 된다.

Scene Builder 화면의 왼쪽에 있는 [Containers]와 [Controls] 메뉴에서 원하는 항목을 드래그

해 중앙의 디자인 영역에 드롭시키면 배치가 된다. 배치된 컨테이너와 컨트롤의 속성은 화면 오른쪽

에 있는 [Properties]와 [Layout] 메뉴에서 설정할 수 있다.



레이아웃 디자인이 완성했다면 상단 메뉴에서 [File] - [Save]를 선택해서 FXML 파일로 저장한다.

## 04. JavaFX 컨테이너

레이아웃을 작성할 때 컨트롤들을 쉽게 배치할 수 있도록 도와주는 클래스가 컨테이너이다. javafx.

scene.layout 패키지에는 다양한 컨테이너 클래스들이 존재한다. 접미사가 Pane으로 끝나는 클

래스는 모두 컨테이너이고, 그 이외에 Hbox, Vbox가 있다.

설명

컨트롤을 좌표를 이용해서 배치하는 레이아웃

위, 아래, 오른쪽, 왼쪽, 중앙에 컨트롤을 배치하는 레이아웃

행으로 배치하되 공간이 부족하면 새로운 행에 배치하는 레이아웃

그리드로 배치하되 셀의 크기가 고정적이지 않은 레이아웃

컨트롤을 겹쳐 배치하는 레이아웃

그리드로 배치하되 고정된 셀의 크기를 갖는 레이아웃

수평으로 배치하는 레이아웃

수직으로 배치하는 레이아웃

컨테이너

AnchorPane

BorderPane

FlowPane

GridPane

StackPane

TilePane

HBox

VBox


AnchorPane 컨테이너

AnchorPane 컨테이너는 좌표를 이용하여 AnchorPane의 좌상단(0, 0 )을 기준으로 컨트롤을 배

치한다. 컨트롤 좌표는 좌상단(layoutX, layoutY ) 값을 말하는데, (0, 0 )으로부터 떨어진 거리를

의미한다.

(0, 0)

## 30. (layoutY)


(layoutX)

(50, 30)

AnchorPane

컨트롤

AnchorPane에서 사용할 수 있는 주요 설정은 다음과 같다.

태그 및 속성

prefWidth

prefHeight

layoutX

layoutY

<children>

설명

폭을 설정

높이를 설정

컨트롤의 X 좌표

컨트롤의 Y 좌표

컨트롤을 포함

적용

AnchorPane

AnchorPane

컨트롤

컨트롤

AnchorPane

AnchorPane 컨테이너는 JavaFX Scene Builder를 사용해서 디자인하는 것이 좋다. 눈으로 거리

를 확인해서 컨트롤을 드롭시킬 수 있기 때문이다. 프로그램적 레이아웃 방법은 직접 코드상에 좌표

값을 입력해야 하기 때문에 매우 불편하다.

다음 예제는 AnchorPane루트 컨테이너를 사용해서 로그인 레이아웃을 디자인한 것이다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>





<?import javafx.scene.control.*?>

<AnchorPane xmlns:fx ="http://javafx.com/fxml" prefHeight ="150.0"
prefWidth ="300.0" >
<children>
<Label layoutX ="42.0" layoutY ="28.0" text ="아이디" />
<Label layoutX ="42.0" layoutY ="66.0" text ="패스워드" />
<TextField layoutX ="120.0" layoutY ="24.0" />
<PasswordField layoutX ="120.0" layoutY ="62.0" />
<Button layoutX ="97.0" layoutY ="106.0" text ="로그인" />
<Button layoutX ="164.0" layoutY ="106.0" text ="취소" />
</children>
</AnchorPane>
```

AnchorPane에 포함될 컨트롤은 <children> 태그의 내용으로 작성된다. AnchorPane을 사용해

서 컨트롤을 좌표로 배치하면 윈도우 창이 줄거나 늘어날 경우 컨트롤의 재배치가 일어나지 않는다.

따라서 AnchorPane으로 배치할 경우에는 윈도우 창의 크기를 변경할 수 없도록 primaryStage.

setResizable (false );를 추가하는 것이 좋다.

>>> AppMain.java


```java
package sec04.exam01_anchorpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;




import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();
primaryStage.setResizable(false);

}

public static void main(String[] args) {
launch(args);

}

}
```

HBox와 VBox 컨테이너

HBox와 VBox는 수평과 수직으로 컨트롤을 배치하는 컨테이너이다. HBox와 VBox는 자식 컨

트롤의 크기를 재조정하는데, HBox는 컨트롤의 높이를 확장하고, 컨트롤의 폭은 유지한다. VBox

는 컨트롤의 폭을 확장하고 컨트롤의 높이는 유지한다.

단, 크기 조정이 가능한 컨트롤만 자동 확장되는데, 기본 Button의 경우는 크기 조정이 되지 않는다.

그 이유는 maxWidth와 maxHeight가 -1.0을 가지기 때문이다. 크기 조정이 가능하도록 하려면

다음과 같이 maxWidth와 maxHeight을 변경하면 된다.

```java
<Button text = "button">
<maxWidth><Double fx:constant = "MAX_VALUE"/></maxWidth>
<maxHeight><Double fx:constant = "MAX_VALUE"/></maxHeight>
</Button>




```

HBox에서 컨트롤의 높이를 확장하고 싶지 않다면 fillHeight 속성을 false로 설정하면 되고,

VBox에서 컨트롤의 폭을 확장하고 싶지 않다면 fillWidth 속성을 false로 설정하면 된다. HBox

와 VBox에서 사용할 수 있는 주요 설정은 다음과 같다.

태그 및 속성

prefWidth

prefHeight

alignment

spacing

fillWidth

fillHeight

<children>

```java
<HBox.hgrow>
<Priority fx:constant="ALWAYS"/>
</HBox.hgrow>

<VBox.vgrow>
<Priority fx:constant="ALWAYS"/>
</VBox.vgrow>
```

설명

폭을 설정

높이를 설정

컨트롤의 정렬을 설정

컨트롤의 간격을 설정

적용

HBox, VBox

HBox, VBox

HBox, VBox

HBox, VBox

컨트롤의 폭 확장 여부 설정

컨트롤의 높이 확장 여부 설정

VBox

HBox

컨트롤을 포함

HBox, VBox

HBox의 남은 폭을 채움

컨트롤

VBox의 남은 높이를 채움

컨트롤

다음 예제는 VBox로 ImageView 컨트롤과 HBox 컨테이너를 수직으로 배치하고, HBox 안에는

두 개의 버튼을 수평으로 배치했다. [다음] 버튼은 HBox의 남은 폭을 채우도록 HBox의 hgrow

속성을 설정했다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.geometry.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import java.lang.*?>

<VBox xmlns:fx ="http://javafx.com/fxml">



<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>

<children>
<ImageView fitWidth ="200"  preserveRatio ="true" >
<image>
<Image url ="@images/javafx.jpg" />
</image>
</ImageView>
```

그림의 비율에 맞게

높이를 설정

현재 경로를 기준으로

상대 경로로 파일 지정

오른쪽 남은 공간을 버튼

이 모두 채우도록 설정

```java
<HBox alignment ="CENTER" spacing ="20.0">
<children>
<Button text ="이전" />
<Button text ="다음">
<HBox.hgrow><Priority fx:constant ="ALWAYS"/></HBox.hgrow>
<maxWidth><Double fx:constant ="MAX_VALUE"/></maxWidth>
</Button>
</children>
<VBox.margin>
<Insets top ="10.0" />
</VBox.margin>
</HBox>
</children>
</VBox>
```

버튼의 폭을 자동으로

확장하기 위해 설정





>>> AppMain.java


```java
package sec04.exam02_hbox_vbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
VBox root  =  (VBox)FXMLLoader.load(
getClass().getResource("root.fxml")

);
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

BorderPane 컨테이너

BorderPane은 top, bottom, left, right,

center 셀에 컨트롤을 배치하는 컨테이너이다.

컨트롤만 배치하는 것이 아니라 다른 컨테이너도

배치할 수 있기 때문에 다양한 레이아웃을 만들

어 낼 수 있다. 주의할 점은 각 셀에는 하나의 컨

트롤 또는 컨테이너만 배치할 수 있다.

top

left

center

right

bottom




다음은 BorderPane에서 사용할 수 있는 태그 및 속성들이다.

태그 및 속성

prefWidth

prefHeight

<top>

<bottom>

<right>

<left>

<center>

설명

폭을 설정

높이를 설정

top에 배치될 컨트롤을 포함

bottom에 배치될 컨트롤을 포함

right에 배치될 컨트롤을 포함

left에 배치될 컨트롤을 포함

center에 배치될 컨트롤을 포함

적용

BorderPane

BorderPane

BorderPane

BorderPane

BorderPane

BorderPane

BorderPane

BorderPane의 특징은 top, bottom, left, right에 컨트롤을 배치하지 않으면 center에 배치된

컨트롤이 top, bottom, left, right까지 확장된다.

다음은 BorderPane의 top에 ToolBar를 배치하고 center에는 TextArea를, bottom에는 다시

BorderPane을 배치한 것이다.

>>> root.fxml



```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<BorderPane xmlns:fx ="http://javafx.com/fxml" prefHeight ="200.0"
prefWidth ="300.0" >
<top>
<ToolBar>
<items>
<Button text ="Button" />
<Button text ="Button" />
</items>
</ToolBar>
</top>
<center>
<TextArea/>
</center>
```

left, right까지 확장





<bottom>
<BorderPane>
<center>
<TextField/>
</center>
<right>
```java
<Button text ="Button"/>
</right>
</BorderPane>
</bottom>
</BorderPane>
```

top, bottom, left까지 확장

>>> AppMain.java


```java
package sec04.exam03_borderpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));



Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

FlowPane 컨테이너

FlowPane은 행으로 컨트롤을 배치하되 공간이 부족하면 새로운 행에 배치하는 컨테이너이다.

FlowPane

다음은 FlowPane에서 사용할 수 있는 태그와 속성들이다.

태그 및 속성

prefWidth

prefHeight

hgap

vgap

설명

폭을 설정

높이를 설정

컨트롤의 수평 간격을 설정

컨트롤의 수직 간격을 설정

<children>

컨트롤을 포함

적용

FlowPane

FlowPane

FlowPane

FlowPane

FlowPane

다음 예제는 FlowPane 컨테이너에 여섯 개의 Button을 배치한 것인데, 버튼 간의 수평 간격과 수

직 간격을 주기 위해 hgap과 vgap을 10으로 설정하였다.





>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>

<FlowPane xmlns:fx ="http://javafx.com/fxml"
prefWidth ="300.0" prefHeight ="70.0"  hgap ="10.0"  vgap ="10.0"  >
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>

<children>
<Button text ="Button" />
<Button text ="Button" />
<Button text ="Button" />
<Button text ="Button" />
<Button text ="Button" />
<Button text ="Button" />
</children>
</FlowPane>

>>> AppMain.java


package sec04.exam04_flowpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

FlowPane을 잘 이해하려면 윈도우 창을 늘렸다가 줄여 보면 되는데, 오른쪽에 배치될 공간이 부족

할 경우에는 새로운 행에 컨트롤이 배치되는 것을 볼 수 있다.

TilePane 컨테이너

TilePane은 그리드로 컨트롤을 배치하되 고정된 셀(타일) 크기를 갖는 컨테이너이다. FlowPane

과 마찬가지로 오른쪽에 컨트롤을 배치할 공간이 부족하면 새로운 행에 컨트롤을 배치한다.

TilePane

다음은 TilePane에서 사용할 수 있는 태그와 속성들이다.





태그 및 속성

prefWidth

prefHeight

prefTileWidth

prefTileHeight

<children>

설명

폭을 설정

높이를 설정

타일의 폭을 설정

타일의 높이를 설정

컨트롤을 포함

적용

TilePane

TilePane

TilePane

TilePane

TilePane

다음은 여러 개의 ImageView를 TilePane에 배치한 예제이다. 셀의 크기를 100×100으로 지정

하기 위해 prefTileHeight="100" prefTileWidth="100"으로 지정했다.

>>> root.fxml



```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.image.*?>

<TilePane xmlns:fx ="http://javafx.com/fxml" prefTileHeight ="100"
prefTileWidth ="100"  >
<children>
<ImageView>
<image><Image url ="@images/fruit1.jpg" /></image>
</ImageView>
<ImageView>
<image><Image url ="@images/fruit2.jpg" /></image>
</ImageView>
<ImageView>
<image><Image url ="@images/fruit3.jpg" /></image>
</ImageView>
<ImageView>
<image><Image url ="@images/fruit4.jpg" /></image>
</ImageView>
<ImageView>
<image><Image url ="@images/fruit5.jpg" /></image>
</ImageView>
</children>
</TilePane>



>>> AppMain.java


package sec04.exam05_tilepane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}




```

GridPane 컨테이너

GridPane은 그리드로 컨트롤을 배치하되 셀의 크기가 고정적이지 않고 유동적인 컨테이너이다. 셀

병합이 가능하기 때문에 다양한 입력폼 화면을 만들 때 매우 유용하게 사용할 수 있다. 각 컨트롤은

자신이 배치될 행 인덱스와 컬럼 인덱스를 속성으로 가지며, 몇 개의 셀을 병합할 것인지도 지정할

수 있다.

다음은 GridPane에 적용 가능한 속성들이다.

태그 및 속성

prefWidth

prefHeight

hgap

vgap

설명

폭을 설정

높이를 설정

수평 컨트롤 간격을 설정

수직 컨트롤 간격을 설정

<children>

컨트롤을 포함

GridPane.rowIndex

컨트롤이 위치하는 행 인덱스를 설정

GridPane.columnIndex

컨트롤이 위치하는 컬럼 인덱스를 설정

GridPane.rowSpan

행 병합 수를 설정

GridPane.columnSpan

컬럼 병합 수를 설정

GridPane.hgrow

GridPane.vgrow

수평 빈 공간 채우기를 설정

수직 빈 공간 채우기를 설정

GridPane.halignment

컨트롤의 수평 정렬을 설정

GridPane.valignment

컨트롤의 수직 정렬을 설정

다음은 로그인 화면을 GridPane으로 배치한 것이다.


적용

GridPane

GridPane

GridPane

GridPane

GridPane

컨트롤

컨트롤

컨트롤

컨트롤

컨트롤

컨트롤

컨트롤

컨트롤

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>

<GridPane xmlns:fx ="http://javafx.com/fxml"
prefWidth ="300.0"  hgap ="10.0" vgap ="10.0" >
<padding>
<Insets topRightBottomLeft ="10.0"/>
</padding>
<children>
<Label text ="아이디"  GridPane.rowIndex ="0"  GridPane.columnIndex ="0" />
<TextField GridPane.rowIndex ="0"  GridPane.columnIndex ="1"
GridPane.hgrow ="ALWAYS"  />
```

<Label text ="패스워드"  GridPane.rowIndex="1"  GridPane.columnIndex="0" />
<TextField GridPane.columnIndex ="1" GridPane.rowIndex ="1"
GridPane.hgrow ="ALWAYS"  />

```java
<HBox  GridPane.rowIndex ="2" GridPane.columnIndex ="0"
GridPane.columnSpan ="2" GridPane.hgrow ="ALWAYS"
alignment ="CENTER" spacing ="20.0" >
<children>
<Button text ="로그인" />
<Button text ="취소" />
</children>
</HBox>
</children>
</GridPane>





>>> AppMain.java


package sec04.exam06_gridpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

StackPane 컨테이너

StackPane은 컨트롤을 겹쳐 배치하는 컨테이너이다. 흔히 카드 레이아웃이라고 하는데, 그림과 같

이 카드가 겹쳐 있는 것처럼 컨트롤도 겹쳐질 수 있다. 만약 위에 있는 컨트롤이 투명이라면 밑에 있

는 컨트롤이 겹쳐 보이게 된다.

StackPane

컨트롤 또는 컨테이너




다음은 두 개의 ImageView를 StackPane에 겹치도록 배치한 예제이다. 하단 이미지는 설경이고

상단 이미지는 투명한 배경을 가지고 있는 듀크이다. 실행해보면 듀크와 설경이 하나의 이미지처럼

보이지만, 상하로 겹쳐 있다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.image.*?>

<StackPane xmlns:fx ="http://javafx.com/fxml">
<children>
<ImageView  fitWidth ="500"  fitHeight ="300"  >
<image>
<Image url ="@images/snow.jpg" />
</image>
</ImageView>
<ImageView  preserveRatio ="true" >
<image>
<Image url ="@images/duke.gif" />
</image>
</ImageView>
</children>
</StackPane>
```

가로비와 세로비 상관없이

고정 길이로 설정

가로비와 세로비를 유지



>>> AppMain.java


```java
package sec04.exam07_stackpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

## 05. JavaFX 이벤트 처리

UI 애플리케이션은 사용자와 상호작용하면서 코드를 실행한다. 사용자가 UI 컨트롤을 사용하면 이

벤트event가 발생하고, 프로그램은 이벤트를 처리하기 위해 코드를 실행한다.

이벤트 핸들러

JavaFX는 이벤트 발생 컨트롤과 이벤트 처리를 분리하기 위해 위임형Delegation 방식을 사용한다. 위

임형 방식이란 컨트롤에서 이벤트가 발생하면 컨트롤이 직접 처리하지 않고 이벤트 핸들러에게 이벤

트 처리를 위임하는 방식이다.




예를 들어 사용자가 Button을 클릭하면 ActionEvent가 발생하고, Button에 등록된 EventHandler

가 ActionEvent를 처리한다.

이벤트 발생 컨트롤
(Button)

①

②

ActionEvent
이벤트 발생

④ 이벤트 처리 효과

1. 윈도우 닫기
2. 컨트롤 내용 변경
3. 다이얼로그 띄우기

이벤트 핸들러
(EventHandler)

이벤트 처리 메소드
실행

(cid:81)(cid:86)(cid:67)(cid:77)(cid:74)(cid:68)(cid:1)(cid:87)(cid:80)(cid:74)(cid:69)(cid:1)(cid:73)(cid:66)(cid:79)(cid:69)(cid:77)(cid:70)(cid:9)(cid:106)(cid:10)(cid:1)(cid:92)(cid:1)

③ 이벤트 처리

(cid:94)

EventHandler는 컨트롤에서 이벤트가 발생하면 자신의 handle ( ) 메소드를 실행시킨다. handle ( )

메소드에는 윈도우 닫기, 컨트롤 내용 변경, 다이얼로그 띄우기 등의 코드를 작성할 수 있다.

EventHandler는 제네릭 타입이기 때문에 타입 파라미터는 발생된 이벤트의 타입이 된다. 예를 들

어 ActionEvent를 처리하는 핸들러는 EventHandler<ActionEvent>가 되고, MouseEvent를

처리하는 핸들러는 EventHandler<MouseEvent>가 된다.

EventHandler가 컨트롤에서 발생된 이벤트를 처리하려면 먼저 컨트롤에 EventHandler를 등록

해야 한다. 컨트롤은 발생되는 이벤트에 따라서 EventHandler를 등록하는 다양한 메소드가 있는

데, 이 메소드들은 setOnXXX ( ) 이름을 가지고 있다. XXX는 보통 이벤트 이름과 동일하다.

몇 가지 예를 들어보자. Button을 클릭할 때 발생하는 ActionEvent를 처리하는 EventHandler

<ActionEvent>를 등록하려면 다음과 같이 setOnAction ( ) 메소드를 사용한다.

Button button  =  new Button();
button.setOnAction(new EventHandler<ActionEvent>() {
```java
@Override
public void handle(ActionEvent event) { … }

});
```

TableView의 행을 클릭할 때 발생하는 MouseEvent를 처리하는 EventHandler<MouseEvent>

를 등록하려면 다음과 같이 setOnMouseClicked ( ) 메소드를 사용한다.



TableView tableView  =  new TableView();
tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
```java
@Override
public void handle(MouseEvent event) { … }

});
```

윈도우Stage의 우측 상단 닫기(×) 버튼을 클릭했을 때 발생하는 WindowEvent를 처리하는

EventHandler<WindowEvent>를 등록하려면 다음과 같이 setOnCloseRequest ( ) 메소드를

사용한다.

stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
```java
@Override
public void handle(WindowEvent event) { … }

});
```

EventHandler는 하나의 메소드를 가진 함수적 인터페이스이므로 람다식을 이용하면 보다 적은 코

드로 EventHandler를 등록할 수 있다.

button.setOnAction( event->{ … } );
tableView.setOnMouseClicked( event->{ … } );
stage.setOnCloseRequest( event->{ … } );

다음은 프로그램적 레이아웃을 작성하고 버튼의 ActionEvent를 처리한 것이다. 첫 번째 버튼은 직

접 EventHandler 객체를 생성한 후 등록했고, 두 번째 버튼은 람다식을 이용해서 EventHandler

를 등록했다.

>>> AppMain.java


```java
package sec05.exam01_event_handler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
HBox root  =  new HBox();
root.setPrefSize(200, 50);
root.setAlignment(Pos.CENTER);
root.setSpacing(20);
```

Button btn1  =  new Button("버튼1");
btn1.setOnAction(new EventHandler<ActionEvent>() {
```java
@Override
public void handle(ActionEvent event) {
System.out.println("버튼1 클릭");

}

});
```

Button btn2  =  new Button("버튼2");
btn2.setOnAction(event -> System.out.println("버튼2 클릭"));

root.getChildren().addAll(btn1, btn2);
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.setOnCloseRequest(event -> System.out.println("종료 클릭"));
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}



FXML 컨트롤러

프로그램적 레이아웃은 레이아웃 코드와 이벤트 처리 코드를 모두 자바 코드로 작성해야 하므로 코

드가 복잡해지고 유지보수도 힘들어지며, 디자이너와 협력해서 개발하는 것도 쉽지 않다. FXML 레

이아웃은 FXML 파일당 별도의 컨트롤러Controller를 지정해서 이벤트를 처리할 수 있기 때문에 FXML

레이아웃과 이벤트 처리 코드를 완전히 분리할 수 있다.

1) fx:controller 속성과 컨트롤러 클래스

FXML 파일의 루트 태그에서 fx:controller 속성으로 컨트롤러를 지정하면 UI 컨트롤에서 발생하

는 이벤트를 컨트롤러가 처리한다.

(cid:29)(cid:1814)트컨테이너 xmlns:fx = "http://javafx.com/fxml"
fx:controller = "package...RootController" >

…

(cid:29)/(cid:1814)트컨테이너(cid:31)

컨트롤러는 다음과 같이 Initializable 인터페이스를 구현한 클래스로 작성하면 된다.

```java
public class RootController implements Initializable {
@Override
public void initialize(URL location, ResourceBundle resources) { }

}
```

initialize ( ) 메소드는 컨트롤러 객체가 생성되고 나서 호출되는데, 주로 UI 컨트롤의 초기화, 이벤

트 핸들러 등록, 속성 감시 등의 코드가 작성된다.

2) fx:id 속성과 @FXML 컨트롤 주입

컨트롤러는 이벤트 핸들러를 등록하기 위해, 그리고 이벤트 처리 시 FXML 파일에 포함된 컨테이너

및 컨트롤의 참조가 필요하다. 이를 위해서 FXML 파일에 포함된 컨트롤들은 fx:id 속성을 가질 필

요가 있다.


>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec05.exam02_fxml_controller.RootController"
prefHeight ="50.0" prefWidth ="200.0"
alignment ="CENTER" spacing ="20.0" >
<children>
<Button  fx:id ="btn1"  text ="버튼1" />
<Button  fx:id ="btn2"  text ="버튼2" />
<Button  fx:id ="btn3"  text ="버튼3" />
</children>
</HBox>
```

fx:id 속성을 가진 컨트롤들은 컨트롤러의 @FXML 어노테이션이 적용된 필드에 자동 주입된다. 주

의할 점은 fx:id 속성값과 필드명은 동일해야 한다.

```java
public class RootController implements Initializable {
@FXML private Button btn1;
@FXML private Button btn2;
@FXML private Button btn3;

@Override
public void initialize(URL location, ResourceBundle resources) { }

}


```

FXMLLoader가 FXML 파일을 로딩하면, 태그로 선언된 컨트롤들과 컨트롤러는 함께 객체로 생성

된다. 그리고 나서 컨트롤러의 @FXML 어노테이션이 적용된 필드에 컨트롤 객체가 자동 주입된다.

주입이 완료되면 비로소 initialize ( ) 메소드가 호출되기 때문에 initialize ( ) 내부에서 필드를 안전

하게 사용할 수 있다.

3) EventHandler 등록

컨트롤에서 발생하는 이벤트를 처리하려면 컨트롤러의 initialize ( ) 메소드에서 EventHandler를

생성하고 등록해야 한다. 다음은 세 개의 Button에서 발생하는 ActionEvent를 처리하는 방법을

보여준다.

>>> RootController.java


```java
package sec05.exam02_fxml_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable {
@FXML private Button btn1;
@FXML private Button btn2;
@FXML private Button btn3;

@Override
public void initialize(URL location, ResourceBundle resources) {
btn1.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent event) {
handleBtn1Action(event);
```

직접 EventHandler
생성 후 등록

}

});
btn2.setOnAction(event->handleBtn2Action(event));
btn3.setOnAction(event->handleBtn3Action(event));

람다식 이용



}

```java
public void handleBtn1Action(ActionEvent event) {
System.out.println("버튼1 클릭");

}
public void handleBtn2Action(ActionEvent event) {
System.out.println("버튼2 클릭");

}
public void handleBtn3Action(ActionEvent event) {
System.out.println("버튼3 클릭");

}

}
```

4) 이벤트 처리 메소드 매핑

컨트롤러에서 EventHandler를 생성하지 않고도 바로 이벤트 처리 메소드와 연결할 수 있는 방법

이 있다. Button 컨트롤을 작성할 때 다음과 같이 onAction 속성값으로 "#메소드명"을 주면 내부

적으로 EventHandler 객체가 생성되기 때문에 컨트롤러에서는 해당 메소드만 작성하면 된다.

FXML 파일

```java
<Button fx:id = "btn" text =  "버튼" onAction =  "#handleBtnAction"/>
```

Controller 클래스

```java
public void handleBtnAction(ActionEvent event) { … }
```

## 06. JavaFX 속성 감시와 바인딩

JavaFX는 컨트롤의 속성property을 감시하는 리스너를 설정할 수 있다. 예를 들어 Slider의 value 속

성값을 감시하는 리스너를 설정해서 value 속성값이 변경되면 리스너가 다른 컨트롤러의 폰트나 이

미지의 크기를 변경할 수 있다.




속성 감시

컨트롤의  모든  속성은  XXXProperty  객체로  생성된다.  그리고  Getter와  Setter  그리고

XXXProperty를 리턴하는 메소드로 구성된다. 예를 들어 TextField, TextArea 컨트롤의 text 속

성은 StringProperty 객체로 생성되고 다음과 같은 메소드로 구성된다.

//StringProperty 타입의 text 속성 선언
private StringProperty text  =  new SimpleStringProperty();

//Geter와 Setter 선언
```java
public void setText(String newValue) { text.set(newValue); }
public String getText() { return text.get(); }
```

//StringProperty 타입의 text 속성을 리턴하는 메소드
public StringProperty textProperty() { return text; }

StringProperty는 get ( )과 set ( ) 메소드 이외에 리스너를 관리하는 textProperty ( ) 메소드를 가

지고 있다. text 속성을 감시하는 리스너는 textProperty ( )가 리턴하는 StringProperty에서 설정

한다. javafx.beans.property 패키지에는 StringProperty 이외에도 다양한 XXXProperty 클래

스가 존재한다.

다음은 TextField 컨트롤의 text 속성값을 감시하는 ChangeListener를 설정하는 코드이다.

StringProperty stringProperty  =  textField.textProperty();
stringProperty.addListener( new ChangeListener<String>() {
```java
@Override
public void changed(ObservableValue<? extends String> observable,

String oldValue, String newValue) { … }

} );
```

addListener ( ) 메소드로 ChangeListener를 StringProperty 객체에 설정하면, text 속성이

변경되었을 때 ChangeListener의 changed ( ) 메소드가 자동으로 실행된다. 속성의 이전 값은

oldValue에, 새로운 값은 newValue로 전달된다.

ChangeListener는  제네릭  타입인데,  타입  파라미터는  속성의  타입이  된다.  예를  들어

textProperty ( )가 리턴하는 StringProperty는 Property<String>을 구현하고 있기 때문에 타입



파라미터는 String이 된다. 따라서 oldValue와 newValue의 타입은 String이다.

다른 예를 보자. Slider의 value 속성에 리스너를 설정하려면 다음과 같이 작성하면 된다.

Slider slider  =  new Slider();
DoubleProperty doubleProperty  =  slider.valueProperty();
doubleProperty.addListener( new ChangeListener<Number>() {
```java
@Override
public void changed(ObservableValue<? extends Number> observable,

Number oldValue, Number newValue) { … }

} );
```

valueProperty ( )가 리턴하는 DoubleProperty가 Property<Number>를 구현하고 있기 때문

에 ChangeListener의 타입 파라미터는 Number가 된다. 따라서 oldValue와 newValue의 타

입도 Number가 된다.

다음 예제는 Slider의 value 속성을 감시해서 value 속성값이 변경되면 Label의 폰트 크기를 변경

하도록 리스너를 설정했다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.text.*?>
<?import javafx.scene.control.*?>
<?import java.lang.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.layout.AnchorPane?>

<BorderPane xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec06.exam01_property_listener.RootController"
prefHeight ="250.0" prefWidth ="350.0" >
<center>
<Label fx:id ="label" text ="JavaFX" >
<font>
<Font size ="0" />
</font>
```

Label의 기본 폰트 크기는 0





</Label>
</center>
<bottom>
<Slider fx:id ="slider" />
</bottom>
</BorderPane>

>>> RootController.java


```java
package sec06.exam01_property_listener;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {
@FXML private Slider slider;
@FXML private Label label;

@Override
public void initialize(URL location, ResourceBundle resources) {



slider.valueProperty().addListener(new ChangeListener<Number>() {
@Override
public void changed(ObservableValue<? extends Number> observable,
Number oldValue, Number newValue) {
label.setFont( new Font( newValue.doubleValue() ) );

}
```

Label의 폰트 변경

Label의 폰트 변경

});

}

}

value 속성 감시 리스너 등록

>>> AppMain.java



```java
package sec06.exam01_property_listener;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource
("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}





```

속성 바인딩

컨트롤의 속성은 다른 컨트롤의 속성과 바인딩될 수 있다. 바인딩된 속성들은 하나가 변경되면 자동

적으로 다른 하나도 변경된다. 예를 들어 두 개의 TextArea 컨트롤의 text 속성들을 바인딩하여 한

쪽 text 속성이 변경되면 다른 쪽 text 속성도 자동 변경된다.

속성을 바인딩하기 위해서는 컨트롤의 xxxProperty ( ) 메소드가 리턴하는 XXXProperty 객체의

bind ( ) 메소드를 이용하면 된다. 예를 들어 textArea1에서 입력된 내용이 textArea2에 자동으로

입력되도록 하려면 다음과 같이 작성하면 된다.

TextArea textArea1  =  new TextArea();
TextArea textArea2  =  new TextArea();
textArea2.textProperty().bind(textArea1.textProperty());

bind ( ) 메소드는 단방향인데, textArea1에서 입력된 내용만 textArea2로 자동 입력되고 반대로

textArea2에서 입력된 내용은 textArea1로 자동 입력되지 않는다. 아예 textArea2는 입력조차

할 수 없다. 만약 양방향으로 바인딩하고 싶다면 bind ( ) 메소드 대신 bindBidirectional ( ) 메소

드를 이용하거나 Bindings.bindBidirectional ( ) 메소드를 이용하면 된다.

//양방(cid:3313) 바인딩 방법1
textArea2.textProperty().bindBidirectional(textArea1.textProperty());
//양방(cid:3313) 바인딩 방법2
Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());

바인딩된 속성을 언바인드하려면 다음 메소드를 이용한다.

//단방(cid:3313) 해제
textArea2.textProperty().unbind();
//양방(cid:3313) 해제 방법1
textArea2.textProperty().unbindBidirectional(textArea1.textProperty());
//양방(cid:3313) 해제 방법2
Bindings.unbindBidirectional(textArea1.textProperty(), textArea2.textProperty());


다음 예제는 text 속성으로 두 개의 TextArea 컨트롤을 양방향으로 바인딩하였다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>

<VBox xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec06.exam02_property_bind.RootController"
prefHeight ="200.0" prefWidth ="300.0" spacing ="10.0" >
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
<children>
<Label text ="textArea1" />
<TextArea fx:id ="textArea1"/>
<Label text ="textArea2" />
<TextArea fx:id ="textArea2"/>
</children>
</VBox>



>>> RootController.java



package sec06.exam02_property_bind;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
@FXML private TextArea textArea1;
@FXML private TextArea textArea2;

@Override
public void initialize(URL location, ResourceBundle resources) {
Bindings.bindBidirectional(textArea1.textProperty(),
textArea2.textProperty());

}

}

>>> AppMain.java


package sec06.exam02_property_bind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root = (Parent)FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");





primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

Bindings 클래스

두 속성이 항상 동일한 값과 타입을 가질 수는 없다. 한쪽 속성값이 다른 쪽 속성값과 바인딩하기 위

해서는 연산 작업이 필요할 수도 있다.

예를 들어 윈도우의 크기에 상관없이 항상 화면 정중앙에 원을 그린다고 가정해 보자. 루트 컨테이

너 폭의 1/2이 원의 X좌표가 되고, 루트 컨테이너 높이의 1/2이 원의 Y좌표가 될 것이다. 따라서

루트 컨테이너의 폭과 높이를 원의 중심과 바인딩하기 위해서는 1/2이라는 연산이 필요하다.

이때 사용할 수 있는 것이 Bindings 클래스가 제공하는 정적 메소드들이다. Bindings의 정적 메소

드는 속성을 연산하거나, 다른 타입으로 변환한 후 바인딩하는 기능을 제공한다. 다음은 Bindings

클래스가 제공하는 정적 메소드들을 설명한 표이다.

메소드

설명

add, substract, multiply, divide 속성값을 덧셈, 뺄셈, 곱셈, 나눗셈 연산을 수행하고 바인딩함

max, min

속성값과 어떤 수를 비교해서 최대, 최소값을 얻고 바인딩함

greaterThan,
greaterThanOrEqual

속성값이 어떤 값보다 크거나, 같거나 큰지를 조사해서 true/false로 변환하여
바인딩함

lessThan, lessThanOrEqual

속성값이 어떤 값보다 적거나, 같거나 적은지를 조사해서 true/false로 변환하
여 바인딩함

equal, notEquals

속성값이 어떤 값과 같은지, 다른지를 조사해서 true/false로 변환하여 바인딩함

equalIgnoreCase,
notEqualIgnoreCase

대소문자와 상관없이 속성값이 어떤 문자열과 같은지, 다른지를 조사해서 true/
false로 변환하여 바인딩함

isEmpty, isNotEmpty

속성값이 비어있는지, 아닌지를 조사해서 true/false로 변환하여 바인딩함

isNull, isNotNull

속성값이 null 또는 not null인지를 조사해서 true/false로 변환하여 바인딩함




length

size

and, or

not

convert

valueAt

속성값이 문자열일 경우 문자 수를 얻어 바인딩함

속성 타입이 배열, List, Map, Set일 경우 요소 수를 얻어 바인딩함

속성값이 boolean일 경우, 논리곱, 논리합을 얻어 바인딩함

속성값이 boolean일 경우, 반대값으로 바인딩함

속성값을 문자열로 변환해서 바인딩함

속성이 List, Map일 경우 해당 인덱스 또는 키의 값을 얻어 바인딩함

다음은 윈도우 창의 크기가 변경되더라도 항상 화면 정중앙에 원을 그리는 예제이다. 루트 컨테이너

의 폭과 높이를 원의 중심과 바인딩하기 위해 1/2 연산을 해야 하므로 Bindings.divide ( ) 메소드

를 이용하였다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.shape.*?>

<AnchorPane xmlns:fx ="http://javafx.com/fxml"
fx:id ="root"
fx:controller ="sec06.exam03_bindings.RootController"
prefHeight ="200.0" prefWidth ="300.0" >
<children>
<Circle fx:id ="circle" fill ="blue" radius ="50.0" stroke ="BLACK" />
</children>
</AnchorPane>



>>> RootController.java


package sec06.exam03_bindings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class RootController implements Initializable {
@FXML private AnchorPane root;
@FXML private Circle circle;

@Override
public void initialize(URL location, ResourceBundle resources) {
circle.centerXProperty().bind( Bindings.divide(root.widthProperty(), 2) );
circle.centerYProperty().bind( Bindings.divide(root.heightProperty(), 2) );

}

}
```

윈도우 창의 width, height 속성에 1/2 연산후 Circle의 centerX, centerY 속성과 바인딩

>>> AppMain.java

```java
package sec06.exam03_bindings;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root = (Parent)FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);






primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

## 07. JavaFX 컨트롤

JavaFX는 다양한 UI 컨트롤을 제공하고 있다. 이번 절에서는 사용 빈도가 높은 버튼 컨트롤, 입력

컨트롤, 뷰 컨트롤, 미디어 컨트롤, 차트 컨트롤에 대해 살펴보자.

버튼 컨트롤

버튼 컨트롤은 마우스로 클릭할 수 있는 컨트롤로 ButtonBase를 상속하는 하위 컨트롤을 말한다.

Button, CheckBox, RadioButton, ToggleButton, Hyperlink 등이 있다.

Button

CheckBox

RadioButton

ToggleButton

기본 Button은 단순한 글자로 구성되지만 setGraphic (ImageView ) 메소드로 아이콘을 넣을 수

도 있다. 다음은 아이콘 버튼을 FXML로 작성하는 방법을 보여준다.

```java
<Button text =  "아이콘버튼"(cid:31)
<graphic>
<ImageView>




<Image url =  "@images/history_view.gif"/>
</ImageView>
</graphic>
</Button>
```

CheckBox, RadioButton, ToggleButton 컨트롤은 선택과 미선택 두 가지 상태를 가질 수 있다.

selected 속성의 값이 true이면 선택이고, false이면 미선택이다. 다음은 CheckBox 컨트롤을

FXML로 선언한 것이다. text 속성은 사용자에게 보여주는 문자열이고, userData 속성은 프로그

램에서 처리하는 데이터이다.

<CheckBox text =  "라(cid:2032)1" userData =  "값1"/>
<CheckBox text =  "라(cid:2032)2" userData =  "값2" selected = "true"/>

RadioButton, ToggleButton에는 toggleGroup 속성이 있는데, 이 속성의 값은 $groupName

이다. $groupName은 <ToggleGroup fx:id="groupName"/>의 fx:id를 참조한다. 같은

groupName을 참조하는 버튼들은 하나의 그룹으로 묶이며, 같은 그룹 내에서는 하나의 버튼만 선

택된다.

<VBox>
<fx:define>
<ToggleGroup fx:id = "group" />
</fx:define>
<children>
<RadioButton … toggleGroup = "$group" />
<RadioButton … toggleGroup = "$group" />
<RadioButton … toggleGroup = "$group" />
</children>
</VBox>

CheckBox, RadioButton, ToggleButton 컨트롤은 사용자가 클릭하면 ActionEvent가 발생하

기 때문에 EventHandler로 처리가 가능하고, onAction 속성을 작성해서 컨트롤러의 이벤트 처리

메소드로 연결할 수도 있다.



<CheckBox … onAction =  "#handleChkAction"/>

만약 같은 그룹 내에서 RadioButton 또는 ToggleButton의 선택 변경을 감시하고 싶다면

ToggleGroup의 selectedToggle 속성에 다음과 같이 감시자를 등록하면 된다.

groupName.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
```java
@Override
public void changed(ObservableValue<? extends Toggle> observable,

Toggle oldValue, Toggle newValue) { … }

});
```

선택이 변경되면 changed ( ) 메소드가 실행되고 세 번째 매개값인 newValue에 마지막으로 선택

된 버튼이 대입된다. 다음 예제는 CheckBox와 RadioButton의 이벤트 처리를 어떻게 하는지 보

여준다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.image.*?>

<BorderPane xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec07.exam01_button.RootController" prefHeight ="150.0"
prefWidth ="420.0">
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>

<center>
<HBox alignment ="CENTER" prefHeight ="100.0" prefWidth ="200.0"
spacing ="10">
<children>
<VBox prefHeight ="200.0" prefWidth ="100.0" spacing ="20.0"





alignment ="CENTER_LEFT">
<children>
<CheckBox fx:id="chk1" text="안경" onAction="#handleChkAction" />
<CheckBox fx:id="chk2" text="모자" onAction="#handleChkAction" />
</children>
</VBox>

<ImageView fx:id ="checkImageView" fitWidth ="100.0"
preserveRatio ="true">
<image>
<Image url ="@images/geek.gif" />
</image>
</ImageView>

<Separator orientation ="VERTICAL" prefHeight ="200.0" />

<VBox prefHeight ="100" prefWidth ="150" spacing ="20.0"
alignment ="CENTER_LEFT">
<fx:define> <ToggleGroup fx:id ="group" /> </fx:define>
<children>
<RadioButton fx:id ="rad1" text ="BubbleChart"
userData ="BubbleChart" toggleGroup ="$group" />
<RadioButton fx:id ="rad2" text ="BarChart"
userData ="BarChart" toggleGroup ="$group" selected ="true" />
<RadioButton fx:id ="rad3" text ="AreaChart"
userData ="AreaChart" toggleGroup ="$group" />
</children>
</VBox>

<ImageView fx:id ="radioImageView" fitWidth ="100.0"
preserveRatio ="true">
<image>
<Image url ="@images/BarChart.png" />
</image>
</ImageView>
</children>
</HBox>
</center>

<bottom>




<Button fx:id ="btnExit" BorderPane.alignment ="CENTER"
onAction ="#handleBtnExitAction">
<graphic>
<ImageView> <Image url ="@images/exit.png" /> </ImageView>
</graphic>
<BorderPane.margin> <Insets top ="20.0" /> </BorderPane.margin>
</Button>
</bottom>
</BorderPane>

>>> RootController.java


package sec07.exam01_button;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;






import javafx.scene.image.ImageView;

public class RootController implements Initializable {
@FXML private CheckBox chk1;
@FXML private CheckBox chk2;
@FXML private ImageView checkImageView;
@FXML private ToggleGroup group;
@FXML private ImageView radioImageView;
@FXML private Button btnExit;

@Override
public void initialize(URL location, ResourceBundle resources) {
group.selectedToggleProperty().addListener(new
ChangeListener<Toggle>() {
@Override
public void changed(ObservableValue<? extends Toggle> observable,
Toggle oldValue, Toggle newValue) {
Image image  =  new Image(getClass().getResource(
"images/" + newValue.getUserData().toString() + ".png").
toString());
radioImageView.setImage(image);

}

});

}

public void handleChkAction(ActionEvent e) {
if(chk1.isSelected() && chk2.isSelected()) {
checkImageView.setImage(new Image(getClass().getResource(
"images/geek-glasses-hair.gif").toString()));
} else if(chk1.isSelected()) {
checkImageView.setImage(new Image(getClass().getResource(
"images/geek-glasses.gif").toString()));
} else if(chk2.isSelected()) {
checkImageView.setImage(new Image(getClass().getResource(
"images/geek-hair.gif").toString()));
} else {
checkImageView.setImage(new Image(getClass().getResource(
"images/geek.gif").toString()));

}

}







public void handleBtnExitAction(ActionEvent e) {
Platform.exit();

}

}

>>> AppMain.java



package sec07.exam01_button;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

입력 컨트롤

입력 컨트롤에는 한 줄 입력을 위한 TextField, 다중 행 입력을 위한 TextArea, 패스워드 입력을

위한 PasswordField, 제한된 항목에서 선택하는 ComboBox가 있다. 또한 날짜를 선택할 수 있






는 DatePicker, 색상을 선택할 수 있는 ColorPicker, HTML을 입력하기 위한 HTMLEditor도

입력 컨트롤이라고 볼 수 있다. Label은 입력 컨트롤은 아니지만 입력 컨트롤의 제목을 표시할 때

사용된다.

Label & TextField

PasswordField

TextArea

ComboBox

DatePicker

ColorPicker

HTMLEditor

다음은 입력 컨트롤을 FXML로 선언하는 방법을 보여준다.

<!-- Label 컨트롤 -->
<Label prefWidth = "폭" prefHeight = "높이" text = "제목" />

<!-- TextField 컨트롤 -->
<TextField prefWidth = "폭" prefHeight = "높이" promptText = "(cid:3430)트문자열"/(cid:31)

<!-- PasswordField 컨트롤 -->
<PasswordField prefWidth = "폭" prefHeight = "높이" promptText = "(cid:3430)트문자열"/(cid:31)



<!-- ComboBox 컨트롤 -->
<ComboBox prefWidth = "폭" prefHeight = "높이" promptText = "(cid:3430)트문자열" >
<items>
<FXCollections fx:factory = "observableArrayList">
<String fx:value = "공개"/(cid:31)
<String fx:value = "비공개"/(cid:31)
</FXCollections>
</items>
</ComboBox>

<!-- DatePicker 컨트롤 -->
<DatePicker prefWidth = "폭" prefHeight = "높이" promptText = "(cid:3430)트문자열" />

<!-- TextArea 컨트롤 -->
<TextArea prefWidth = "폭" prefHeight = "높이" promptText = "(cid:3430)트문자열"/(cid:31)

prefWidth와 prefHeight는 각각 폭과 높이를 설정하고, promptText는 힌트 문자열로 컨트롤이

포커스를 얻게 되면 사라진다.

다음 예제는 입력 컨트롤로 구성된 폼을 제공한다. 제목은 TextField, 비밀번호는 PasswordField,

공개는 ComboBox, 게시종료는 DatePicker, 내용은 TextArea로 구성했다. [등록] 버튼을 클릭

하면 모든 입력된 내용이 콘솔에 출력된다.

>>> root.fxml

```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.text.*?>
<?import javafx.scene.shape.*?>
<?import javafx.scene.web.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.image.*?>
<?import java.lang.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.collections.*?>




<AnchorPane xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec07.exam02_input.RootController"
prefHeight ="380" prefWidth ="485" >
<children>
<Label layoutX ="22.0" layoutY ="36.0" text ="제목" />
<TextField fx:id ="txtTitle" layoutX ="84.0" layoutY ="32.0"
prefHeight ="23.0" prefWidth ="375.0" />
<Label layoutX ="22.0" layoutY ="69.0" text ="비밀번호" />
<PasswordField fx:id ="txtPassword" layoutX ="86.0" layoutY ="65.0"
prefHeight ="23.0" prefWidth ="132.0" />
<Label layoutX ="22.0" layoutY ="104.0" text ="공개" />
<ComboBox fx:id ="comboPublic" layoutX ="86.0" layoutY ="100.0"
prefHeight ="23.0" prefWidth ="132.0" promptText ="선택하세요" >
<items>
<FXCollections fx:factory ="observableArrayList">
<String fx:value ="공개"/>
<String fx:value ="비공개"/>
</FXCollections>
</items>
</ComboBox>
<Label layoutX ="240.0" layoutY ="104.0" text ="게시종료" />
<DatePicker fx:id ="dateExit" layoutX ="296.0" layoutY ="100.0"
promptText ="날짜를 선택하세요"/>
<Label layoutX ="22.0" layoutY ="135.0" text ="내용" />
<TextArea fx:id ="txtContent" layoutX ="22.0" layoutY ="154.0"
prefHeight ="132.0" prefWidth ="440.0"/>
<Separator layoutX ="13.0" layoutY ="320"
prefHeight ="0.0" prefWidth ="457.0" />
<Button fx:id ="btnReg" layoutX ="189.0" layoutY ="340" text ="등록"
onAction ="#handleBtnRegAction"/>
<Button fx:id ="btnCancel" layoutX ="252.0" layoutY ="340" text ="취소"
onAction ="#handleBtnCancelAction"/>
</children>
</AnchorPane>



>>> RootController.java


package sec07.exam02_input;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
@FXML private TextField txtTitle;
@FXML private PasswordField txtPassword;
@FXML private ComboBox<String> comboPublic;
@FXML private DatePicker dateExit;



@FXML private TextArea txtContent;

@Override
public void initialize(URL location, ResourceBundle resources) {

}

public void handleBtnRegAction(ActionEvent e) {
String title  =  txtTitle.getText();
System.out.println("title: " + title);

String password  =  txtPassword.getText();
System.out.println("password: " + password);

String strPublic  =  comboPublic.getValue();
System.out.println("public: " + strPublic);

LocalDate localDate  =  dateExit.getValue();
if(localDate !=  null) {
System.out.println("dateExit: " + localDate.toString());

}

String content  =  txtContent.getText();
System.out.println("content: " + content);

}

public void handleBtnCancelAction(ActionEvent e) {
Platform.exit();

}

}

>>> AppMain.java


package sec07.exam02_input;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;












import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

뷰 컨트롤

뷰 컨트롤은 텍스트 또는 이미지 등을 보여주는데 목록 형태로 보여주는 ListView, 테이블 형태로

보여주는 TableView, 이미지를 보여주는 ImageView가 있다.

ListView

TableView

ImageView

1) ImageView 컨트롤

ImageView는 이미지를 보여주는 컨트롤이다. FXML로 선언하는 방법은 다음과 같다.





<ImageView fitWidth =  "폭" fitHeight =  "높이" preserveRatio = "true"/>

fitWidth와 fitHeight는 ImageView의 폭과 높이를 지정한다. preserveRatio 속성은 이미지의

종횡비를 유지할 것인지를 지정한다. false를 주면 종횡비와 상관없이 fitWidth와 fitHeight에 맞

게 ImageView 크기가 고정되고, true를 주면 이미지의 종횡비를 유지하기 위해 ImageView 크

기가 조정된다.

ImageView에 보여줄 이미지는 두 가지 방법으로 설정할 수 있는데, 첫 번째 방법은 ImageView

의 생성자 매개값으로 Image 객체를 설정하는 것이다.

<ImageView preserveRatio = "true">
<Image url =  "@images/flower.png"/>
</ImageView>

두 번째 방법은 ImageView의 setImage (  ) 메소드로 설정하는데, 역시 매개값은 Image 객체

이다.

<ImageView fitWidth = "200" fitHeight = "150" preserveRatio = "true">
<image>
<Image url =  "@images/flower.png"/>
</image>
</ImageView>

Image는 url 속성(생성자 매개변수)을 가지고 있는데, FXML 파일 위치에서 상대 경로로 "@이미

지 경로"를 값으로 주면 된다.

2) ListView 컨트롤

ListView는 항목들을 목록으로 보여주는 컨트롤이다. FXML로 선언하는 방법은 다음과 같다.

<ListView prefWidth =  "폭" prefHeight =  "높이"/(cid:31)



ListView에 항목을 추가하려면 setItems (ObservableList<T> value ) 메소드를 사용한다.

ObservableList 구현 객체는 FXCollections.observableArrayList (E… items ) 정적 메소드로

생성할 수 있다.

listView.setItems(FXCollections.observableArrayList("Swing", "JavaFX"));

외부 데이터로 항목을 추가하는 경우가 많기 때문에 컨트롤러에서 자바 코드로 추가하는 것이 일반

적이지만, 고정 항목일 경우에는 FXML 파일에서 다음과 같이 직접 선언해도 좋다.

<ListView fx:id = "listView" prefHeight = "100" prefWidth = "100">
<items>
<FXCollections fx:factory = "observableArrayList">
<String fx:value = "Swing"/>
<String fx:value = "JavaFX"/>
</FXCollections>
</items>
</ListView>

ListView에서 선택된 인덱스와 항목을 얻으려면 속성 감시를 이용할 수 있다. getSelectionModel ( )

메소드로  MultipleSelectionModel 을  얻고  나서  selectedIndexProperty   또는

selectedItemProperty에 리스너를 설정하면 된다. selectedIndexProperty는 선택된 인덱스이

고, selectedItemProperty는 선택된 항목이다. 다음은 selectedItemProperty에 리스너를 설정

하는 코드이다.

listView.getSelectionModel().selectedItemProperty().addListener(
new ChangeListener<String>() {
```java
@Override
public void changed(ObservableValue<? extends String> observable,

String oldValue, String newValue) { … }

}

);


```

3) TableView 컨트롤

TableView는 컬럼으로 구성된 행의 데이터를 보여주는 컨트롤이다. TableView를 FXML로 선언하

는 방법은 다음과 같다. <columns> 태그 안에 만들고자 하는 컬럼의 개수만큼 <TableColumn>

태그를 선언하면 된다.

<TableView prefHeight = "100" prefWidth = "300">
<columns>
<TableColumn prefWidth = "150" text =  "스마트폰"/(cid:31)
<TableColumn prefWidth = "150" text =  "이미지"/(cid:31)
</columns>
</TableView>

TableView에 행row을 추가하려면 행의 데이터를 가지고 있는 모델model 객체가 필요하다. 위 코드를

보면 스마트폰과 이미지 컬럼이 있는데, 이 두 값을 속성으로 갖는 모델 객체를 생성해서 행의 데이

터로 제공해야 한다. 다음은 Phone 모델 클래스를 생성하는 방법을 보여준다.

>>> Phone.java


```java
package sec07.exam03_view;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
private SimpleStringProperty smartPhone;
private SimpleStringProperty image;

public Phone() {
this.smartPhone  =  new SimpleStringProperty();
this.image  =  new SimpleStringProperty();

}
public Phone(String smartPhone, String image) {
this.smartPhone  =  new SimpleStringProperty(smartPhone);
this.image  =  new SimpleStringProperty(image);

}

public String getSmartPhone() {






return smartPhone.get();

}
public void setSmartPhone(String smartPhone) {
this.smartPhone.set(smartPhone);;

}
public String getImage() {
return image.get();

}
public void setImage(String image) {
this.image.set(image);;

}

}
```

모델의  속성  타입은  컬럼  값의  데이터  타입에  따라서  javafx.beans.property  패키지

의  SimpleXXXProperty를  사용하면  된다.  모델  클래스를  작성했다면  이제  모델  속성

과 TableColumn을 연결시키는 코드를 작성해야 한다. TableColumn은 TableView의

getColumns ( ).get (index )로 얻어내는데, 첫 번째 컬럼의 인덱스는 0이다.

TableColumn의 setCellValueFactory ( ) 메소드는 PropertyValueFactory 매개값을 이용해

서 모델 속성을 TableColumn으로 매핑한다. 다음은 첫 번째 TableColumn을 모델 클래스의

smartPhone 속성과 매핑시키는 코드이다.

TableColumn tcSmartPhone  =  tableView.getColumns().get(0);
tcSmartPhone.setCellValueFactory( new PropertyValueFactory("smartPhone") );

셀cell 내에서 정렬이 필요한 경우에는 다음과 같이 TableColumn의 setStyle ( ) 메소드로 CSS를

적용하면 된다. CSS는 10절 JavaFX CSS 스타일에서 학습한다.

tcSmartPhone.setStyle("-fx-alignment: CENTER;");

TableView에  행들을  추가하기  위해서는  ObservableList에  모델  객체들을  저장하고,

ObservableList를 매개값으로 해서 TableView의 setItems ( ) 메소드를 호출하면 된다.


ObservableList phoneList  =  FXCollections.observableArrayList(
new Phone("(cid:1107)(cid:1759)시S1", "phone01.png"),
new Phone("(cid:1107)(cid:1759)시S2", "phone02.png"),
new Phone("(cid:1107)(cid:1759)시S3", "phone03.png")

);

tableView.setItems( phoneList );

TableView에서  선택된  행의  인덱스와  모델  객체를  얻으려면  속성  감시를  이용할  수  있

다.  getSelectionModel ( )   메소드로  TableViewSelectionModel 을  얻고  나서,

selectedIndexProperty  또는  selectedItemProperty에  리스너를  설정하면  된다.

selectedIndexProperty는 선택된 행의 인덱스이고, selectedItemProperty는 선택된 행의 모

델 객체이다.

다음은 selectedItemProperty에 리스너를 설정하는 코드이다.

tableView.getSelectionModel().selectedItemProperty().addListener(
new ChangeListener<Phone>() {
```java
@Override
public void changed(ObservableValue<? extends Phone> observable,

Phone oldValue, Phone newValue) { … }

}

);
```

다음 예제는 ListView의 항목을 선택하면 같은 인덱스를 가지는 TableView의 행이 자동 선택되도

록 한다. 그리고 TableView에서 행이 선택되면 이미지 컬럼값을 읽고 ImageView에 이미지를 보

여준다. 하단의 [확인] 버튼을 클릭하면 ListView와 TableView에 선택된 정보를 콘솔에 출력한다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.text.*?>
<?import javafx.scene.shape.*?>
<?import javafx.scene.web.*?>
<?import javafx.geometry.*?>





<?import javafx.scene.image.*?>
<?import java.lang.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.collections.*?>

<AnchorPane xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec07.exam03_view.RootController"
prefHeight ="180.0" prefWidth ="500.0" >
<children>
<Label layoutX ="11.0" layoutY ="9.0" text ="ListView" />
<ListView fx:id ="listView" layoutX ="10.0" layoutY ="30.0"
prefHeight ="100.0" prefWidth ="100.0" />
<Label layoutX ="125.0" layoutY ="9.0" text ="TableView" />
<TableView fx:id ="tableView" layoutX ="120.0" layoutY ="30.0"
prefHeight ="100.0" prefWidth ="290.0">
<columns>
<TableColumn prefWidth ="100.0" text ="스마트폰" />
<TableColumn prefWidth ="100.0" text ="이미지" />
</columns>
</TableView>
<Label layoutX ="425.0" layoutY ="9.0" text ="ImageView" />
<ImageView fx:id ="imageView" fitHeight ="100.0" fitWidth ="60.0"
layoutX ="430.0" layoutY ="30.0" preserveRatio ="true" />
<Button layoutX ="190.0" layoutY ="145.0"
onAction ="#handleBtnOkAction" text ="확인" />
<Button layoutX ="260.0" layoutY ="145.0"
onAction ="#handleBtnCancelAction" text ="취소" />
</children>
</AnchorPane>


>>> RootController.java


package sec07.exam03_view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable {
@FXML private ListView<String> listView;
@FXML private TableView<Phone> tableView;
@FXML private ImageView imageView;

@Override
public void initialize(URL location, ResourceBundle resources) {
listView.setItems(FXCollections.observableArrayList(
"(cid:1107)(cid:1759)시S1", "(cid:1107)(cid:1759)시S2", "(cid:1107)(cid:1759)시S3", "(cid:1107)(cid:1759)시S4", "(cid:1107)(cid:1759)시S5", "(cid:1107)(cid:1759)시S6", "(cid:1107)(cid:1759)시S7"

));
listView.getSelectionModel().selectedIndexProperty().addListener(
new ChangeListener<Number>() {
@Override
public void changed(ObservableValue<? extends Number> observable,
Number oldValue, Number newValue) {
tableView.getSelectionModel().select(newValue.intValue());
tableView.scrollTo(newValue.intValue());
```

변경된 인덱스의 행 선택

}

});

변경된 인덱스 위치로 스크롤시킴

selectedIndex 속성 감시





ObservableList phoneList  =  FXCollections.observableArrayList(
new Phone("(cid:1107)(cid:1759)시S1", "phone01.png"),
new Phone("(cid:1107)(cid:1759)시S2", "phone02.png"),
new Phone("(cid:1107)(cid:1759)시S3", "phone03.png"),
new Phone("(cid:1107)(cid:1759)시S4", "phone04.png"),
new Phone("(cid:1107)(cid:1759)시S5", "phone05.png"),
new Phone("(cid:1107)(cid:1759)시S6", "phone06.png"),
new Phone("(cid:1107)(cid:1759)시S7", "phone07.png")

);

TableColumn tcSmartPhone  =  tableView.getColumns().get(0);
tcSmartPhone.setCellValueFactory(
new PropertyValueFactory("smartPhone")

);
tcSmartPhone.setStyle("-fx-alignment: CENTER;");

TableColumn tcImage  =  tableView.getColumns().get(1);
tcImage.setCellValueFactory(
new PropertyValueFactory("image")
);
tcImage.setStyle("-fx-alignment: CENTER;");

tableView.setItems(phoneList);

tableView.getSelectionModel().selectedItemProperty().addListener(
new ChangeListener<Phone>() {
```java
@Override
public void changed(ObservableValue<? extends Phone> observable,
Phone oldValue, Phone newValue) {
if(newValue!= null) {
imageView.setImage(new Image(getClass().getResource(
"images/" + newValue.getImage()).toString()));

}

}

});

}
```

selectedItem 속성 감시

```java
public void handleBtnOkAction(ActionEvent e) {









String item  =  listView.getSelectionModel().getSelectedItem();
System.out.println("ListView 스마트폰: " + item);
```

선택된 항목(행)의 데이터 얻기

Phone phone  =  tableView.getSelectionModel().getSelectedItem();
System.out.println("TableView 스마트폰: " + phone.getSmartPhone());
System.out.println("TableView 이미지: " + phone.getImage());

}

```java
public void handleBtnCancelAction(ActionEvent e) {
Platform.exit();

}

}

>>> AppMain.java



package sec07.exam03_view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}







```

미디어 컨트롤

미디어와 관련된 컨트롤에는 비디오를 재생할 수 있는 MediaView 컨트롤, 볼륨 및 재생 위치 조

절을 위한 Slider 컨트롤, 진행 상태를 보여주는 ProgressBar, ProgressIndicator 컨트롤 등이

있다.

MediaView

Slider

ProgressBar와 ProgressIndicator

Track

Thumb

Block increment

0.0

50.0


Tick marks

Tick label

progress: 0.0

progress: 0.6

progress: 1.0

0%

60%

Done

1) MediaPlayer와 MediaView 컨트롤

MediaView 컨트롤은 비디오를 보여주는 용도로만 사용되기 때문에 특별한 UI를 가지고 있지 않

다. FXML로 MediaView 컨트롤을 선언하는 방법은 다음과 같다.

<MediaView fitHeight = "200.0" fitWidth = "300.0" preserveRatio = "false" />

fitWidth와 fitHeight는 MediaView의 폭과 높이를 지정한다. preserveRatio는 비디오의 종횡

비를 유지할 것인지를 지정하는데, false는 비디오의 종횡비와 상관없이 fitWidth와 fitHeight에

맞게 MediaView의 크기가 고정되고, true는 비디오의 종횡비에 맞게 MediaView 크기가 조정

된다.



MediaView 컨트롤은 비디오를 재생하는 기능이 없기 때문에 미디어를 재생하는 MediaPlayer

가 필요하다. MediaPlayer는 비디오뿐만 아니라 오디오도 재생할 수 있는데, 미디어 파일 경로를

Media 객체 형태로 전달해서 다음과 같이 생성한다.

Media media  =  new Media("미디어 소스 경로");
MediaPlayer mediaPlayer  =  new MediaPlayer(media);

예를 들어 클래스 경로에 있는 비디오 파일을 재생하는 MediaPlayer는 다음과 같이 생성할 수 있다.

Media media  =  new Media(getClass().getResource("media/bigbuck.m4v").toString());
MediaPlayer mediaPlayer  =  new MediaPlayer(media);

미디어 소스가 비디오라면 MediaView의 setMediaPlayer ( ) 메소드로 MediaPlayer 객체를 등

록할 수 있다. 오디오 소스로부터 MediaPlayer가 생성되었다면 MediaView는 필요 없다.

mediaView.setMediaPlayer(mediaPlayer);

MediaPlayer를 생성했다고 해서 바로 재생할 수는 없고, 재생할 상태(READY )가 될 때까지 기다

려야 한다. 다음 표는 MediaPlayer가 가질 수 있는 상태와 상태를 변경하는 메소드가 무엇인지 보

여준다.

다음 상태

현재 상태

UNKNOWN

READY

PAUSED

PLAYING

STALLED

STOPPED

READY

PAUSED

PLAYING

STALLED

STOPPED

setAutoplay(true)
play( )

play( )

stop( )

pause( )

buffering data

stop( )

pause( )

data buffered

stop( )

pause( )

play( )



UNKNOWN은 Mediaplayer가 생성된 직후의

UNKNOWN

상태인데, 미디어를 재생할 준비가 되면 READY

상태로 자동 변경된다.

READY 상태에서 setAutoPlay (true ) 또는 play ( )

를 호출하면 PLAYING이 된다. PLAYING 상태

에서 pause ( )를 호출하면 PAUSED 상태가 되고,

stop ( )을 호출하면 STOPPED 상태가 된다.

READY

PLAYING

STALLED

PAUSED

STOPPED

만약 PLAYING 상태에서 재생 버퍼에 충분한 데이터가 없을 경우 STALLED 상태가 된다. 주로 네

트워크상에서 미디어 소스를 받아 재생할 때 네트워크 속도가 느리면 STALLED 상태가 된다.

위  표의  상태들은  MediaPlayer.Status  열거  타입으로  모두  정의되어  있는데,  코드에서

MediaPlayer의 상태를 알고 싶다면 getStatus ( )의 리턴값을 확인하면 된다.

위 표에는 나와 있지 않지만 EndOfMedia 상태도 있다. EndOfMedia는 MediaPlayer가 미

디어를 모두 재생했을 때의 상태를 말한다. EndOfMedia 상태에서 play ( )를 호출하면 다시

PLAYING 상태가 되는데, 처음 위치에서 자동 재생되지 않기 때문에 seek ( ) 메소드로 재생 위치

를 처음으로 되돌려놓고 play ( )를 호출해야 한다.

상태가 변경되면 자동 실행해야 할 코드들이 있을 수 있다. 이런 코드들은 Runnable의 run ( ) 메소

드에 작성하고, setOnXXX ( ) 메소드로 등록하면 된다. 그러면 해당 상태가 되었을 때 Runnable

의 run ( ) 메소드가 자동 실행된다. 다음은 각 상태로 변경될 때 실행하는 Runnable을 설정하는

메소드이다.

상태

자동 실행 Runnable 설정 메소드

Runnable에 포함될 수 있는 코드

READY

setOnReady(Runnable r)

- 재생 시간을 표시하는 리스너 등록

- 재생 버튼 활성화

PLAYING

PAUSED

setOnPlaying(Runnable r)

- 멈춤 및 정지 버튼 활성화

setOnPaused(Runnable r)

- 재생 및 정지 버튼 활성화

STOPPED

setOnStopped(Runnable r)

- 재생 버튼 활성화

EndOfMedia

setOnEndOfMedia(Runnable r)

- 재생 버튼 활성화

다음은 setOnReady ( ) 메소드를 작성하는 방법을 보여준다.


mediaPlayer.setOnReady(new Runnable() {
```java
@Override
public void run() {
//(cid:733)재생 버튼을 (cid:3357)성화 코드 또는 setAutoPlay(true);
```

//(cid:734)재생 시간을 알 수 있도록 currentTime 속성 (cid:1093)시
mediaPlayer.currentTimeProperty().addListener(new  ChangeListener<Duration>()

{

```java
@Override
public void changed(ObservableValue<? extends Duration> observable,

Duration oldValue, Duration newValue) { … }

});

}

});
```

보통 READY 상태로 변경될 경우에는 PLAYING 상태로 변경할 수 있도록 [재생 버튼]을 활성

화하거나 자동 실행을 위해 setAutoPlay (true )를 호출한다. 그리고 재생 시간을 표시하기 위해

currentTime 속성을 감시하는 ChangeListener를 등록할 수 있다.

다음 예제는 비디오 파일과 오디오 파일을 재생하는 방법을 보여준다. RootController의 26라인과

27라인 중 하나를 주석처리하고 실행시켜 보자.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.media.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.control.*?>

<AnchorPane xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec07.exam04_mediaview.RootController"
prefHeight ="220.0" prefWidth ="530.0" >
<children>
<StackPane layoutX ="10.0" layoutY ="10.0">
<children>
<ImageView fx:id ="imageView"

MediaView

ImageView





fitHeight ="200.0" fitWidth ="360.0"  preserveRatio ="false">
<image><Image url ="@media/audio.png" /></image>
</ImageView>
<MediaView fx:id ="mediaView"
fitHeight ="200.0" fitWidth ="360.0" preserveRatio ="false" />
</children>
</StackPane>
<Button fx:id ="btnPlay" layoutX ="385.0" layoutY ="15.0"
prefHeight ="23.0" prefWidth ="131.0" text ="재생" />
<Button fx:id ="btnPause" layoutX ="385.0" layoutY ="39.0"
prefHeight ="23.0" prefWidth ="131.0" text ="(cid:1893)(cid:2938)"/>
<Button fx:id ="btnStop" layoutX ="385.0" layoutY ="63.0"
prefHeight ="23.0" prefWidth ="131.0" text ="중지"/>
</children>
</AnchorPane>

>>> RootController.java


package sec07.exam04_mediaview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;







public class RootController implements Initializable {
@FXML private MediaView mediaView;
@FXML private ImageView imageView;
@FXML private Button btnPlay;
@FXML private Button btnPause;
@FXML private Button btnStop;
```

//재생 (cid:2542)료를 확인하는 (cid:3282)래그 필드
private boolean endOfMedia;

```java
@Override
public void initialize(URL location, ResourceBundle resources) {
//미디어 객체 생성
//Media media  =  new Media(getClass().getResource("media/video.m4v").
toString());
Media media  =  new Media(getClass().getResource("media/audio.wav").
toString());
```

//미디어 (cid:3282)레이어 생성 및 미디어 (cid:2093)에 설정
MediaPlayer mediaPlayer  =  new MediaPlayer(media);
mediaView.setMediaPlayer(mediaPlayer);

//READY 상태가 될 때 실행할 Runnable 설정
mediaPlayer.setOnReady(new Runnable() {
```java
@Override
public void run() {
btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(true);
if(mediaPlayer.isAutoPlay()) {mediaView.setVisible(false);}

}

});
```

//PLAYING 상태가 될 때 실행할 Runnable 설정
mediaPlayer.setOnPlaying(()->{
btnPlay.setDisable(true); btnPause.setDisable(false);
btnStop.setDisable(false);

});

//PAUSED 상태가 될 때 실행할 Runnable 설정

















mediaPlayer.setOnPaused(()->{
btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(false);

});

//EndOfMedia 상태가 될 때 실행할 Runnable 설정
mediaPlayer.setOnEndOfMedia(()->{
endOfMedia  =  true;
btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(true);

});

//STOPPED 상태가 될 때 실행할 Runnable 설정
mediaPlayer.setOnStopped(()->{
mediaPlayer.seek(mediaPlayer.getStartTime());
btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(true);

});

//버튼 ActionEvent 처리
btnPlay.setOnAction(event->{
if(endOfMedia) {
mediaPlayer.stop();
mediaPlayer.seek(mediaPlayer.getStartTime()); //재생 시간을 처음으로 돌림

//재생 중지

}
mediaPlayer.play();
endOfMedia  =  false;

//재생하기

});
btnPause.setOnAction(event->mediaPlayer.pause());
btnStop.setOnAction(event->mediaPlayer.stop());

//일시 정지

//중지

}

}

>>> AppMain.java


```java
package sec07.exam04_mediaview;

import javafx.application.Application;










import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

2) Slider 컨트롤

Slider 컨트롤은 Track과 Thumb로 구성되어 있다.

Track

Thumb

Block increment

Slider의 value 속성에는 현재 Thumb의 위치값이 저

장되는데, 최소값은 0, 최대값은 100이다.

0.0

50.0


기본적으로 Tick marks와 Tick label이 숨겨져 있는

Tick marks

Tick label

데, setShowTickMarks (true )와 setShowTickLabels (true )를 호출하면 볼 수 있다. Block

increment 간격은 setBlockIncrement ( )로 설정할 수 있다. 다음은 FXML로 Slider 컨트롤을

선언하는 방법을 보여준다.

<Slider prefHeight =  "폭" prefWidth =  "높이" showTickLabels = "true" showTickMarks =
"true"/>






다음 코드는 MediaPlayer의 볼륨을 조정하기 위해 Slider 컨트롤를 사용하는 방법을 보여준다.

slider.valueProperty().addListener(new ChangeListener<Number>() {
```java
@Override
public void changed(ObservableValue<? extends Number> observable,

Number oldValue, Number newValue) {
mediaPlayer.setVolume(sliderVolume.getValue() / 100.0);

}

});
```

Slider의 value 속성을 감시하기 위해 ChangeListener를 등록하고 changed ( ) 메소드에서

MediaPlayer의 setVolume ( ) 메소드를 호출한다. MediaPlayer의 volume 속성은 0.0~1.0

값을 가지는데, Slider value 속성은 0.0~100.0 값을 가지므로 Slider의 value 속성값을 100.0

으로 나누어서 MediaPlayer의 value 속성값으로 설정한다.

3) ProgressBar와 ProgressIndicator 컨트롤

오른쪽 그림과 같이 ProgressBar는 수평 막대 모양의 컨트롤

이고, ProgressIndicator는 원형 모양의 컨트롤이다. 둘 다 작

업의 진행 정도를 표시하는데, 미디어 재생 시간을 표시하거나

저장소의 사용량 및 네트워크 통신량을 표시할 때도 사용할 수

progress: 0.0

progress: 0.6

progress: 1.0

0%

60%

Done

있다.

다음은 FXML로 선언하는 방법을 보여준다.

<ProgressBar prefHeight = "15" prefWidth = "100" progress = "0.0" />
<ProgressIndicator prefHeight = "47.0" prefWidth = "31.0" progress = "0.0" />

ProgressBar는 ProgressIndicator를 상속한 하위 컨트롤이기 때문에 사용하는 속성들이 동일하

다. 이들 컨트롤의 progress 속성은 진행 정도를 설정하는데, 최소값은 0.0이고 최대값은 1.0이다.

다음은 진행 정도를 변경하는 코드이다.

progressBar.setProgress(0.0~1.0);
progressIndicator.setProgress(0.0~1.0);



ProgressBar는 ProgressIndicator로 MediaPlayer의 재생 시간을 나타내기 위해서는 현재 재생

시간을 전체 재생 시간으로 나눈값을 progress 속성값으로 설정하면 된다.

double currentSeconds  =  mediaPlayer.getCurrentTime().toSeconds();
double totalSeconds  =  mediaPlayer.getTotalDuration().toSeconds();
double progress  =  currentSeconds / totalSeconds;
progressBar.setProgress(progress);
progressIndicator.setProgress(progress);

주의할 점은 마지막 재생 시간과 전체 재생 시간이 정확히 일치하지 않기 때문에 마지막 값이 1.0이

되지 않을 수도 있다. 그래서 MediaPlayer가 EndOfMedia 상태가 되었을 때 progress 속성을

강제로 1.0으로 설정하는 것이 좋다.

mediaPlayer.setOnEndOfMedia(()->{
progressBar.setProgress(1.0);
progressIndicator.setProgress(1.0);

});

다음은 이전 예제에서 재생 시간을 표시하도록 ProgressBar와 ProgressIndicator 컨트롤을 추가

하고, 볼륨을 조정하기 위해 Slider 컨트롤을 추가한 것이다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.media.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.control.*?>

<AnchorPane xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec07.exam05_slider_progressbar.RootController"
prefHeight ="220.0" prefWidth ="530.0" >
<children>
<StackPane layoutX ="10.0" layoutY ="10.0">






<children>
<ImageView fx:id ="imageView"
fitHeight ="200.0" fitWidth ="360.0"  preserveRatio ="false">
<image><Image url ="@media/audio.png" /></image>
</ImageView>
<MediaView fx:id ="mediaView"
fitHeight ="200.0" fitWidth ="360.0" preserveRatio ="false" />
</children>
</StackPane>
<Button fx:id ="btnPlay" layoutX ="385.0" layoutY ="15.0"
prefHeight ="23.0" prefWidth ="131.0" text ="재생" />
<Button fx:id ="btnPause" layoutX ="385.0" layoutY ="39.0"
prefHeight ="23.0" prefWidth ="131.0" text ="(cid:1893)(cid:2938)"/>
<Button fx:id ="btnStop" layoutX ="385.0" layoutY ="63.0"
prefHeight ="23.0" prefWidth ="131.0" text ="중지"/>
```

<Label layoutX ="387.0" layoutY ="101.0" text ="시간" />
<ProgressBar fx:id ="progressBar" layoutX ="385.0" layoutY ="121.0"
prefHeight ="18.0" prefWidth ="98.0" progress ="0.0" />
<ProgressIndicator fx:id ="progressIndicator" layoutX ="489.0"
layoutY ="112.0"
prefHeight ="47.0" prefWidth ="31.0" progress ="0.0" />
<Label fx:id ="labelTime" alignment ="CENTER" layoutX ="386.0"
layoutY ="142.0"
prefHeight ="18.0" prefWidth ="98.0" text ="0/0 sec" />

<Label layoutX ="385.0" layoutY ="169.0" text ="소리" />
<Slider fx:id ="sliderVolume" layoutX ="385.0" layoutY ="187.0"
prefHeight ="14.0" prefWidth ="131.0"  showTickMarks ="true"/>
</children>
</AnchorPane>






>>> RootController.java


```java
package sec07.exam05_slider_progressbar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class RootController implements Initializable {
@FXML private MediaView mediaView;
@FXML private ImageView imageView;
@FXML private Button btnPlay;
@FXML private Button btnPause;
@FXML private Button btnStop;

@FXML private Label labelTime;
@FXML private Slider sliderVolume;
@FXML private ProgressBar progressBar;
@FXML private ProgressIndicator progressIndicator;

private boolean endOfMedia;

@Override
public void initialize(URL location, ResourceBundle resources) {
//미디어 객체 생성
Media media  =  new Media(getClass().getResource("media/video.mp4").
toString());













//Media media  =  new Media(getClass().getResource("media/audio.wav").
toString());
```

//미디어 (cid:3282)레이어 생성 및 미디어 (cid:2093)에 설정
MediaPlayer mediaPlayer  =  new MediaPlayer(media);
mediaView.setMediaPlayer(mediaPlayer);

//해당 상태가 되면 실행할 Runnable 설정
mediaPlayer.setOnReady(new Runnable() {
```java
@Override
public void run() {
mediaPlayer.currentTimeProperty().addListener(new
ChangeListener<Duration>() {
@Override
public void changed(ObservableValue<? extends Duration>
observable,
Duration oldValue, Duration newValue) {
double progress  =  mediaPlayer.getCurrentTime().toSeconds() /
mediaPlayer.getTotalDuration().toSeconds();
progressBar.setProgress(progress);
progressIndicator.setProgress(progress);
labelTime.setText(
(int)mediaPlayer.getCurrentTime().toSeconds()+"/"+
(int)mediaPlayer.getTotalDuration().toSeconds()+" sec");

}

});

btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(true);
if(mediaPlayer.isAutoPlay()) {mediaView.setVisible(false);}

}

});

mediaPlayer.setOnPlaying(()->{
btnPlay.setDisable(true); btnPause.setDisable(false);
btnStop.setDisable(false);

});
mediaPlayer.setOnPaused(()->{
btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(false);














});
mediaPlayer.setOnEndOfMedia(()->{
progressBar.setProgress(1.0);
progressIndicator.setProgress(1.0);
endOfMedia  =  true;
btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(true);
```

미디어 재생이 완료되었을 때

progress 속성값을 1.0으로 설정

});
mediaPlayer.setOnStopped(()->{
btnPlay.setDisable(false); btnPause.setDisable(true);
btnStop.setDisable(true);

});

//(cid:2053)(cid:1836) 설정
sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
```java
@Override
public void changed(ObservableValue<? extends Number> observable,
Number oldValue, Number newValue) {
mediaPlayer.setVolume(sliderVolume.getValue() / 100.0);
```

Slider의 value 속성 감시

}

});

//Slider의 value 초기값 설정
sliderVolume.setValue(50.0);

//버튼 이벤트 처리
btnPlay.setOnAction(event->{
if(endOfMedia) {
mediaPlayer.stop();
mediaPlayer.seek(mediaPlayer.getStartTime());

}
mediaPlayer.play();
endOfMedia  =  false;

});
btnPause.setOnAction(event->mediaPlayer.pause());
btnStop.setOnAction(event->mediaPlayer.stop());

}

}









>>> AppMain.java



```java
package sec07.exam05_slider_progressbar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

차트 컨트롤

JavaFX에는 다음과 같이 다양한 차트를 생성하는 컨트롤이 제공된다. 이 차트의 컨트롤들은

javafx.scene.chart 패키지에 포함되어 있다.





PieChart

LineChart

AreaChart

BarChart

BubbleChart

ScatterChart

FXML로 차트 컨트롤을 배치하는 방법은 매우 쉬운데, PieChart일 경우 다음과 같이 작성하면 된

다. PieChart는 X축과 Y축이 없으므로 축으로 정의할 필요가 없다.

<PieChart/>

LineChart, AreaChart, BarChart일 경우 X축과 Y축이 필요하므로 축 정의가 필요하다. 다음은

BarChart를 선언하는 방법을 보여준다.

<BarChart>
<xAxis>
<CategoryAxis side = "BOTTOM" />
</xAxis>
<yAxis>
<NumberAxis side = "LEFT" />
</yAxis>
</BarChart>



<xAxis>와 <yAxis>는 각각 X축, Y축을 말한다. X축은 위쪽 또는 아래쪽이 있고, Y축은 왼쪽 또는

오른쪽이 있기 때문에 눈금이 나타날 위치를 지정해야 한다. <CategoryAxis side=" BOTTOM"/>

은 분류 눈금을 아래쪽 축에 나타낸다. <NumberAxis side="LEFT"/>는 숫자 눈금을 왼쪽 축에 나

타낸다.

차트의 데이터는 데이터베이스나 네트워크에서 전달받아 사용하는 것이 일반적이므로 컨트롤러에

서 Java 코드로 이들 데이터를 얻고 나서 차트 컨트롤에 추가한다.

1) 축이 필요 없는 차트 데이터

X축과 Y축이 필요 없는 PieChart에 데이터를 제공하는 방법은 다음과 같다. 데이터를 PieChart.

Date 객체로 생성하고, 이것을 ObservableList에 저장한 다음 PieChart의 setData ( ) 메소드로

전달하면 된다.

pieChart.setData(FXCollections.observableArrayList(
new PieChart.Data("AWT", 10),
new PieChart.Data("Swing", 30),
new PieChart.Data("SWT", 25),
new PieChart.Data("JavaFX", 35)

));

2) 축이 필요한 차트 데이터

X축과 Y축이 필요한 LineChart, AreaChart, BarChart에 데이터를 추가하는 방법은 모두 동일하

다. 다음은 BarChart에 데이터를 추가하는 방법을 보여준다.

//시리(cid:2761) 생성
XYChart.Series series  =  new XYChart.Series();
//시리(cid:2761) 이름 설정
series.setName("남자");
//시리(cid:2761) 데이터 세(cid:3188)
series.setData(FXCollections.observableArrayList(
new XYChart.Data("2015", 70),
new XYChart.Data("2016", 40),
new XYChart.Data("2017", 50),


new XYChart.Data("2018", 30)

));

//(cid:2864)트에 시리(cid:2761) 추가
barChart.getData().add( series );

XYChart.Series는 하나의 그래프에 대한 데이터이다. 여러 개의 그래프를 겹쳐 보이게 하려면

XYChart.Series를 그래프의 수에 맞게 생성해야 한다. 데이터는 XYChart.Data 객체로 생성하

고, 이것을 ObservableList에 저장한 다음 XYChart.Series의 setData ( )으로 저장한다.

XYChart.Series가 완성되면 차트의 getData ( ) 메소드로 ObservableList를 얻고 여기에

XYChart.Series를 추가하면 그래프가 생성된다. 다음 예제는 PieChart, BarChart, AreaChart

를 생성하는 방법을 보여준다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.chart.*?>
<?import java.lang.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec07.exam06_chart.RootController"
prefHeight ="250" prefWidth ="850" >
<children>
<PieChart fx:id ="pieChart" />
<BarChart fx:id ="barChart">
<xAxis>
<CategoryAxis side ="BOTTOM" />
</xAxis>
<yAxis>
<NumberAxis side ="LEFT" />
</yAxis>
</BarChart>




<AreaChart fx:id ="areaChart">
<xAxis>
<CategoryAxis side ="BOTTOM" />
</xAxis>
<yAxis>
<NumberAxis side ="LEFT" />
</yAxis>
</AreaChart>
</children>
</HBox>

>>> RootController.java


package sec07.exam06_chart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class RootController implements Initializable {



@FXML private PieChart pieChart;
@FXML private BarChart barChart;
@FXML private AreaChart areaChart;

@Override
public void initialize(URL location, ResourceBundle resources) {
//PieChart 데이터 세(cid:3188)
pieChart.setData(FXCollections.observableArrayList(
new PieChart.Data("AWT", 10),
new PieChart.Data("Swing", 30),
new PieChart.Data("SWT", 25),
new PieChart.Data("JavaFX", 35)

));
```

//BarChart 데이터 세(cid:3188)
XYChart.Series series1  =  new XYChart.Series();
series1.setName("남자");
series1.setData(FXCollections.observableArrayList(
new XYChart.Data("2015", 70),
new XYChart.Data("2016", 40),
new XYChart.Data("2017", 50),
new XYChart.Data("2018", 30)
));
XYChart.Series series2  =  new XYChart.Series();
series2.setName("여자");
series2.setData(FXCollections.observableArrayList(
new XYChart.Data("2015", 30),
new XYChart.Data("2016", 60),
new XYChart.Data("2017", 50),
new XYChart.Data("2018", 60)
));
barChart.getData().add(series1);
barChart.getData().add(series2);

두 개의 XYChart.Series 추가

//AreaChart 데이터 세(cid:3188)
XYChart.Series series3  =  new XYChart.Series();
series3.setName("(cid:3235)(cid:1232)(cid:2529)도");
series3.setData(FXCollections.observableArrayList(
new XYChart.Data("2015", 13),
new XYChart.Data("2016", 6),








new XYChart.Data("2017", 22),
new XYChart.Data("2018", 19)

));
areaChart.getData().add(series3);

}

}

>>> AppMain.java



```java
package sec07.exam06_chart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}




```

## 08. JavaFX 메뉴바와 툴바

UI 애플리케이션에서 메뉴바와 툴바는 빠질 수 없는 요소이다. JavaFX도 메뉴바와 툴바를 생성할

수 있도록 MenuBar 컨트롤과 Toolbar 컨트롤을 제공한다.

MenuBar 컨트롤

MenuBar 컨트롤은 컨테이너 상단에 배치되어 다양한 작업을 쉽게 선택하도록 해준다. MenuBar

에는 Menu들이 배치되는데, 다음 화면에서 “파일”, “편집”이 Menu에 해당된다.

Menu

MenuItem

MenuBar

Accelerator
(단축키)

M e n u 에는  메뉴  아이템으로  M e n u I t e m ,  C h e c k M e n u I t e m ,  R a d i o M e n u I t e m ,

CustomMenuItem, SeparatorMenuItem을 추가할 수 있고, 서브 메뉴를 갖는 Menu도 추가할

수 있다. 위 화면에서 “새로만들기”, “열기”, “저장”, “끝내기”가 MenuItem에 해당되고, 가로 구분

선은 SeparatorMenuItem이다.

C h e c k M e n u I t e m ,  R a d i o M e n u I t e m 은  두  가지  상태를  가지는  메뉴  아이템으로

CheckMenuItem을 클릭하면 선택, 다시 클릭하면 미선택이 된다. 동일한 ToggleGroup을 참조

하는 RadioMenuItem들은 하나를 클릭하면 다른 것들이 선택 해제된다.

다음은 FXML로 MenuBar를 선언하는 방법을 보여준다.

<MenuBar>
<menus>
<Menu text = "파일"(cid:31) … </Menu>
<Menu text = "(cid:3230)(cid:2776)"(cid:31) … </Menu>
</menus>
</MenuBar>

다음은 “파일” Menu의 “새로만들기” MenuItem을 추가하는 방법을 보여준다.



<Menu text = "파일"(cid:31)
<items>
<MenuItem text = "새로만들기" onAction = "#handleNew" >
<accelerator>
<KeyCodeCombination alt = "DOWN" code = "N" control = "UP" meta = "UP"

shift = "DOWN" shortcut = "UP" />

</accelerator>
<graphic>
<ImageView><image><Image url = "@icons/new.png" /></image></ImageView>
</graphic>
</MenuItem>
</items>
</Menu>

MenuItem도 Button과 마찬가지로 클릭하면 onAction 속성에 지정된 컨트롤러의 메소드를 호

출해서 ActionEvent를 처리한다. MenuItem은 추가적으로 단축키와 아이콘을 설정할 수 있는데

<accelerator>는 단축키를, <graphic>은 아이콘을 설정한다.

단축키는 KeyCodeCombination 객체로 생성하는데,  Alt  키,  Control  키,  Shift  키, Code 키의

조합으로 구성할 수 있다. DOWN으로 설정된 키와 code 키를 동시에 누르면 MenuItem이 선택

되어 onAction 속성에 지정된 메소드가 호출된다. “새로만들기” 메뉴 아이템일 경우  Alt  +  Shift  +

N 을 동시에 누르면 handleNew ( ) 메소드가 실행된다.

Toolbar 컨트롤

계층적인 작업 선택 기능은 MenuBar 컨트롤이 편리하나, 빠르게

작업을 선택하고 싶다면 Toolbar 컨트롤이 편리하다. Toolbar 컨

트롤은 Button, ComboBox와 같은 다른 컨트롤도 배치할 수는

컨테이너이다.

다음은 FXML로 Toolbar를 선언하는 방법을 보여준다.

<ToolBar>
<items>
```java
<Button onAction = "#handleNew">



<graphic>
<ImageView><image><Image url = "@icons/new.png" /></image></ImageView>
</graphic>
</Button>
</items>
</ToolBar>
```

다음 예제는 상단에 MenuBar와 ToolBar를 추가하고 중앙에는 TextArea를 추가해서 간단한 메

모장을 만든 것이다. MenuBar의 MenuItem과 ToolBar의 Button을 클릭하면 TextArea에 선

택된 작업 내용이 출력된다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.input.*?>
<?import javafx.scene.image.*?>
<?import javafx.collections.*?>
<?import java.lang.*?>

<BorderPane xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec08.exam01_menubar_toolbar.RootController"
prefHeight ="200.0" prefWidth ="400.0" >
<top>
<VBox>
<children>
<MenuBar>
<menus>
<Menu text ="파일">
<items>
<MenuItem text ="새로만들기" onAction ="#handleNew" >
<accelerator>
<KeyCodeCombination alt ="DOWN" code ="N"
control ="UP" meta ="UP" shift ="DOWN" shortcut ="UP" />
</accelerator>
<graphic>




<ImageView>
<image><Image url ="@icons/new.png" /></image>
</ImageView>
</graphic>
</MenuItem>
<MenuItem text ="열기"  onAction ="#handleOpen" >
<accelerator>
<KeyCodeCombination alt ="UP" code ="O" control ="DOWN"
meta ="UP" shift ="UP" shortcut ="UP" />
</accelerator>
<graphic>
<ImageView>
<image><Image url ="@icons/open.png" /></image>
</ImageView>
</graphic>
</MenuItem>
<MenuItem text ="저장" onAction ="#handleSave" >
<accelerator>
<KeyCodeCombination alt ="UP" code ="S" control ="DOWN"
meta ="UP" shift ="UP" shortcut ="UP" />
</accelerator>
<graphic>
<ImageView>
<image> <Image url ="@icons/save.png" /></image>
</ImageView>
</graphic>
</MenuItem>
<SeparatorMenuItem />
<MenuItem text ="(cid:1368)내기" onAction ="#handleExit"/>
</items>
</Menu>
</menus>
</MenuBar>

<ToolBar>
<items>
<Button onAction ="#handleNew">
<graphic>
<ImageView>
<image><Image url ="@icons/new.png" /></image>




</ImageView>
</graphic>
</Button>
<Button onAction ="#handleOpen">
<graphic>
<ImageView>
<image><Image url ="@icons/open.png" /></image>
</ImageView>
</graphic>
</Button>
<Button onAction ="#handleSave">
<graphic>
<ImageView>
<image><Image url ="@icons/save.png" /></image>
</ImageView>
</graphic>
</Button>
<ComboBox prefWidth ="100" promptText ="선택" >
<items>
<FXCollections fx:factory ="observableArrayList">
<String fx:value ="공개"/>
<String fx:value ="비공개"/>
</FXCollections>
</items>
</ComboBox>
</items>
</ToolBar>
</children>
</VBox>
</top>

<center>
<TextArea fx:id ="textArea"/>
</center>
</BorderPane>







>>> RootController.java


package sec08.exam01_menubar_toolbar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
@FXML private TextArea textArea;

@Override
public void initialize(URL location, ResourceBundle resources) {

}

public void handleNew(ActionEvent e) {
textArea.appendText("New\n");

}

public void handleOpen(ActionEvent e) {
textArea.appendText("Open\n");

}

public void handleSave(ActionEvent e) {
textArea.appendText("Save\n");

}







public void handleExit(ActionEvent e) {
Platform.exit();

}

}

>>> AppMain.java



package sec08.exam01_menubar_toolbar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}






```

## 09. JavaFX 다이얼로그

다이얼로그Dialog는 주 윈도우에서 알림 또는 사용자의 입력을 위해서 실행되는 서브 윈도우라고 볼

수 있다. 다이얼로그는 자체적으로 실행될 수 없고 주 윈도우에 의해 실행되는데, 다이얼로그를 띄

우는 주 윈도우를 다이얼로그의 소유자owner 윈도우라고 한다.

다이얼로그에는 모달modal과 모달리스modeless 두 가지 종류가 있다. 모달 다이얼로그는 다이얼로그를

닫기 전까지 소유자 윈도우를 사용할 수 없고, 모달리스 다이얼로그는 소유자 윈도우를 계속 사용할

수 있다.

JavaFX에서 제공하는 다이얼로그 종류에는 파일을 선택하는 FileChooser, 디렉토리를 선택하는

DirectoryChooser, 팝업창을 띄우는 Popup 등이 있다. 이 다이얼로그들은 javafx.stage 패키

지에 모두 포함되어 있다. 다이얼로그도 윈도우이므로 Stage로 생성되기 때문이다.

FileChooser, DirectoryChooser

FileChooser는 PC의 파일을 선택할 수 있는 다이얼로그이다. 열기 또는 저장 옵션으로 실행할 수

있고, 파일 확장명을 필터링해서 원하는 파일만 볼 수 있다. FileChooser는 컨트롤이 아니기 때문

에 FXML에서 선언할 수 없고, Java 코드로 FileChooser를 생성하고 showOpenDialog ( ) 또

는 showSaveDialog ( )를 호출해야 띄울 수 있다. 다음은 열기 옵션으로 FileChooser를 띄우는

코드이다.

FileChooser fileChooser  =  new FileChooser();
File selectedFile  =  fileChooser.showOpenDialog(primaryStage);


showOpenDialog ( ) 또는 showSaveDialog ( )를 호출할 때에는 소유자 윈도우를 제공해야 한

다. 위 코드에서는 primaryStage를 제공했다. FileChooser는 모달 다이얼로그이므로 [열기] 또는

[저장] 버튼을 클릭하거나 [취소] 버튼을 클릭하기 전까지는 소유자 윈도우를 사용할 수 없다.

기본적으로 All Files (*.*)가 선택되어 있기 때문에 모든 파일을 볼 수 있다. 만약 파일 확장명으

로 필터링해서 파일을 보려면 다음과 같이 ExtensionFilter를 생성해서 FileChooser에 추가하면

된다.

FileChooser fileChooser  =  new FileChooser();

//파일 확장명으로 필터(cid:1858) 정보 추가
fileChooser.getExtensionFilters().addAll(
new ExtensionFilter("Text Files", "*.txt"),
new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
new ExtensionFilter("All Files", "*.*")

);

File selectedFile  =  fileChooser.showOpenDialog(primaryStage);

파일을  선택하고  [열기]  또는  [저장]  버튼을  클릭하면,  s h o w O p e n D i a l o g ( )   또는

showSaveDialog ( ) 메소드는 선택된 파일의 File 객체를 리턴한다. 선택된 파일의 전체 경로를

문자열로 얻고 싶다면 File의 getPath ( )를 호출하면 된다.

File selectedFile  =  fileChooser.showOpenDialog(primaryStage);
String selectedFilePath  =  selectedFile.getPath()

파일이 아니라 디렉토리(폴더)를 선택하고 싶다면 FileChooser 대신 DirectoryChooser를 사용

하면 된다. 사용 방법은 FileChooser와 비슷하다.

DirectoryChooser directoryChooser  =  new DirectoryChooser();
File selectedDir  =  directoryChooser.showDialog(primaryStage);
String selectedDirPath  =  selectedDir.getPath();



Popup

Popup은 투명한 컨테이너를 제공하는 모달리스 다이얼로그이다. 따라서 소유자 윈도우는 계속 사

용될 수 있다. Popup은 컨트롤의 툴팁tooltip, 메시지 통지notification, 드롭다운 박스drop down boxes, 마우

스 오른쪽 버튼을 클릭했을 때 나타나는 메뉴 등을 만들 때 사용될 수 있다.

예를 들어 오른쪽 그림과 같이 메시지 통지를 알려주는 Popup을 만들 수 있다.

Popup은 윈도우의 기본 장식(아이콘, 제목, 최소화 및 복원 버튼, 닫기 버튼)을 가지고 있지 않다.

Popup의 내용은 Java 코드로 작성하거나 FXML 파일로 작성할 수 있다. 다음은 FXML 파일을 로

딩해서 Popup의 내용으로 추가하는 코드이다.

Popup popup  =  new Popup();
popup.getContent().add(FXMLLoader.load(getClass().getResource("popup.fxml")));

Popup을 실행하려면 다음과 같이 show ( ) 메소드를 호출하면 된다.

popup.show(primaryStage);
popup.show(primaryStage, anchorX, anchorY);

//PC 화면 정중앙에서 실행
//지정된 좌표에서 실행

anchorX와 anchorY를 지정하지 않으면 PC 화면의 중앙에 Popup이 실행된다. 다른 위치에서

실행하고 싶다면 PC 화면의 좌상단(0,0 )을 기준으로 anchorX, anchorY를 지정하면 된다.

Popup은 다른 윈도우보다 최상위 위치에 놓이게 되므로 화면에서 항상 제일 위에 나타난다.

Popup을 숨기려면 Popup 안에 있는 컨트롤의 이벤트를 처리해서 hide ( ) 메소드를 호출해야 한

다. 또 다른 방법은 setAutoHide (true )를 설정해서 다른 윈도우로 포커스가 이동할 때 자동으로

Popup을 숨기도록 해야 한다.

popup.hide();
popup.setAutoHide(true);

//수동으로 닫을 때 호출
//다(cid:1842) 윈도우로 포커스가 이동할 때 자동으로 닫(cid:3428)도록 설정

다음은 Popup에 들어갈 내용으로 HBox를 FXML 파일로 정의한 것이다. HBox에 CSS를 적용

해서 배경을 검은색으로, 모서리는 둥글게 변경하고 Label의 글자색을 흰색으로 변경했다. 주목할

점은 컨트롤에 id 속성이 있다는 점이다.



```java
<HBox xmlns:fx = "http://javafx.com/fxml"
alignment = "CENTER_LEFT"
style = "-fx-background-color: black; -fx-background-radius: 20;" >
<children>
<ImageView id = "imgMessage"
fitHeight = "30" fitWidth = "30" preserveRatio = "true"/>
<Label id = "lblMessage" style = "-fx-text-fill: white;">
<HBox.margin>
<Insets left = "5.0" right = "5.0" />
</HBox.margin>
</Label>
</children>
</HBox>
```

Popup의 정적인 내용은 FXML 파일에 정의하면 되지만, 상황에 따라 변경되는 동적 내용은

FXML 파일을 로딩한 후에 변경해야 한다. 변경이 필요한 컨트롤은 컨테이너의 lookup (“#id”) 메

소드를 이용해서 찾을 수 있는데, 이 메소드는 컨트롤의 id 속성값을 이용해서 컨트롤을 찾는다.

다음 코드는 HBox가 로딩된 후에 내부의 ImageView와 Label의 참조를 얻어 동적으로 설정을

바꾸는 방법을 보여준다.

//FXML 파일 로딩
HBox hbox  =  (HBox) FXMLLoader.load(getClass().getResource("xxx.fxml"));

//HBox 내부에 있는 ImageView와 Label 컨트롤 (cid:2869)조 얻기
ImageView imageView  =  (ImageView) hbox.lookup("#imgMessage");
Label lblMessage  =  (Label)parent.lookup("#lblMessage");

//ImageView에 이미지를 설정하고 마우스로 클릭했을 때 Popup을 닫도록 이벤트 처리
imageView.setImage(new Image(getClass().getResource("images/dialog-info.png").
toString()));
imageView.setOnMouseClicked(event->popup.hide());

//Label의 글자를 설정
lblMessage.setText("메시지가 왔습니다.");



Popup 내용이 완성되었다면 다음 코드로 Popup을 띄우면 된다.

//Popup 생성
Popup popup  =  new Popup();

//Popup의 내용으로 hbox를 설정
popup.getContent().add(hbox);

//다(cid:1842) 윈도우로 포커스가 이동될 때 Popup을 자동으로 (cid:2304)기도록 설정
popup.setAutoHide(true);

//Popup 띄우기(소유자 윈도우는 primaryStage로 설정)
popup.show(primaryStage);

커스텀 다이얼로그

다양한 내용의 다이얼로그를 만들고 싶다면 Stage로 직접 생성하면 된다. 그리고 기본적인 다이얼

로그 설정을 다음과 같이 하면 된다.

//Stage 객체 생성
Stage dialog  =  new Stage(StageStyle.UTILITY);
//모달리스로 설정
dialog.initModality(Modality.WINDOW_MODAL);
//소유자 윈도우 설정
dialog.initOwner(primaryStage);
//다이얼로그 제목 설정
dialog.setTitle("확인");

Stage 생성자 매개값에는 윈도우 스타일을 결정짓는 StageStyle 열거 상수가 온다. 다음은 StageStyle

열거 상수와 윈도우 스타일을 설명한 표이다.

StageStyle 열거 상수

설명

DECORATED

일반적인 윈도우 스타일. 배경이 흰색, 제목줄에 장식(아이콘, 타이틀, 축소, 복원,

닫기 버튼 장식)이 있음

UNDECORATED

배경이 흰색, 제목줄 없음


TRANSPARENT

배경이 투명, 제목줄 없음

UNIFIED

UTILITY

DECORATED와 동일하나 내용물의 경계선이 없음

배경이 흰색이고, 제목줄에 타이틀, 종료 버튼만 있음

만약 매개값이 없는 기본 생성자로 Stage를 생성했다면 DECORATED 윈도우가 생성된다.

initModality (Modality.WINDOW_MODAL )은 모달 다이얼로그로 설정한다. 이 설정을 하지

않으면 기본적으로 모달리스가 된다. initOwner (primaryStage )는 소유자 윈도우Stage를 설정

한다.

다음은 커스텀 다이얼로그에 들어갈 내용을 AnchorPane으로 정의한 FXML 파일이다.

<AnchorPane xmlns:fx = "http://javafx.com/fxml"
prefHeight = "150.0" prefWidth = "400.0" >
<children>
<ImageView fitHeight = "50" fitWidth = "50"
layoutX = "15" layoutY = "15" preserveRatio = "true">
<image><Image url = "@images/dialog-info.png" /></image>
</ImageView>
<Label id = "txtTitle" prefHeight = "15.0" prefWidth = "290.0"
layoutX = "87.0" layoutY = "33.0" />
```java
<Button id = "btnOk" layoutX = "336.0" layoutY = "104.0" text = "확인" />
</children>
</AnchorPane>
```

다음 코드는 AnchorPane가 로딩된 후에 내부의 ImageView와 Label의 참조를 얻어 동적으로

설정을 바꾸는 방법을 보여준다.



//FXML 파일 로딩
AnchorPane anchorPane  =  (AnchorPane) FXMLLoader.load(getClass().getResource("xxx.
fxml"));

//Label의 글자를 변경
Label txtTitle  =  (Label) parent.lookup("#txtTitle");
txtTitle.setText("확인하(cid:2257)습니까?");

//버튼의 이벤트 처리
Button btnOk  =  (Button) parent.lookup("#btnOk");
btnOk.setOnAction(event->dialog.close());

커스텀 다이얼로그의 내용이 완성되었다면 다음과 같이 커스텀 다이얼로그의 내용을 설정하고 띄우

면 된다.

//다이얼로그 내용을 Scene 객체로 만들고 다이얼로그에 설정
Scene scene  =  new Scene(parent);
dialog.setScene(scene);

//다이얼로그 창 크기를 변경하지 (cid:1925)하도록 설정(내용이 AnchorPane일 경우 필요)
dialog.setResizable(false);

//다이얼로그 띄우기
dialog.show();

primaryStage 참조 얻기

컨트롤러에서 다이얼로그를 실행할 때는 소유자 윈도우가 될 primaryStage가 필요하다. 컨트롤러

에서 primaryStage를 얻는 방법은 두 가지가 있다.

1) 메인 클래스에서 전달하는 방법

primaryStage는 메인 클래스의 start ( ) 매개값으로 전달되기 때문에 start ( ) 메소드에서 컨트롤러

로 primaryStage를 전달하면 된다.

FXML 루트 태그의 fx:controller 속성에 지정된 컨트롤러 클래스는 FXMLLoader가 FXML을 로


딩할 때 객체로 생성된다. 그리고 FXMLLoader의 getController ( ) 메소드로 참조를 얻을 수 있다.

그러나 getController ( ) 메소드는 인스턴스 메소드이기 때문에 FXMLLoader 객체가 필요하다.

FXML을 FXMLLoader의 정적 메소드인 load ( )로 로딩하면 FXMLLoader 객체를 얻을 수 없기

때문에 FXMLLoader 객체를 직접 생성하고 다음과 같이 인스턴스 메소드인 load ( )를 이용해서

FXML을 로딩해야 한다.

```java
public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
//FXML 로딩
FXMLLoader loader  =  new FXMLLoader(getClass().getResource("root.fxml"));
Parent root  =  loader.load();
```

//생성된 Controller 객체를 얻어 primaryStage 전달
RootController controller  =  loader.getController();
controller.setPrimaryStage(primaryStage);

Scene scene  =  new Scene(root);
primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

…

}

위 코드는 컨트롤러의 setPrimaryStage ( ) 메소드를 이용해서 primaryStage를 전달하고 있기 때

문에 컨트롤러는 다음과 같이 필드와 Setter 메소드를 추가해야 한다.

```java
public class RootController implements Initializable {
private Stage primaryStage;
public void setPrimaryStage(Stage primaryStage) {
this.primaryStage  =  primaryStage;

}

…

}


```

2) 컨테이너 또는 컨트롤로부터 얻는 방법

컨테이너나 컨트롤의 getScene ( ) 메소드는 자신이 포함된 Scene 객체를 리턴한다. 그리고 Scene

의 getWindow ( ) 메소드는 자신을 보여주는 Stage 객체를 리턴한다. 따라서 다음과 같은 코드를

이용하면 컨트롤러에서 primaryStage를 얻을 수 있다.

Stage primaryStage  =  (Stage) 컨트롤.getScene().getWindow();

주의할 점은 위 코드는 initialize ( ) 메소드 안에서는 사용할 수 없다. 그 이유는 아직 primaryStage

가 준비되지 않았기 때문이다. 메인 클래스의 start ( ) 메소드에서 Scene 객체를 생성하고,

primaryStage에 Scene을 설정해야만 위 코드가 정상적으로 동작한다. 따라서 이벤트 처리 메소드

내에서만 위 코드를 사용해야 한다.

예를 들어 Button을 클릭했을 때 실행하는 메소드가 handleButton ( )이라면 handleButton ( )

메소드 내부에서 다음과 같이 primaryStage를 얻어야 한다.

```java
public class RootController implements Initializable {
@FXML private Button button;

@Override
public void initialize(URL location, ResourceBundle resources) {

…

}

public void handleButton(ActionEvent e) {
Stage primaryStage  =  (Stage) button.getScene().getWindow();

…

}

}
```

다음 예제는 지금까지 설명한 다이얼로그들을 차례대로 버튼을 클릭해서 띄운다. 첫 번째 버튼은 파

일 오픈 다이얼로그를, 두 번째 버튼은 파일 저장 다이얼로그를, 세 번째 버튼은 디렉토리 선택 다이

얼로그를, 네 번째 버튼은 팝업을, 다섯 번째 버튼은 커스텀 다이어로그를 띄운다.



>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import javafx.geometry.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"
fx:controller ="sec09.exam01_dialog.RootController"
alignment ="TOP_LEFT" spacing ="10.0" >
<children>
<Button text ="Open FileChooser" onAction ="#handleOpenFileChooser"/>
<Button text ="Save FileChooser" onAction ="#handleSaveFileChooser"/>
<Button text ="DirectoryChooser" onAction ="#handleDirectoryChooser"/>
<Button text ="Popup" onAction ="#handlePopup"/>
<Button text ="Custom" onAction ="#handleCustom"/>
</children>
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
</HBox>

>>> popup.xml


<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.geometry.*?>
<?import java.lang.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>



```

HBox에 CSS를 적용해서 배경을 검은색으로, 모서리는 둥글게 변경

```java
<HBox xmlns:fx ="http://javafx.com/fxml"
alignment ="CENTER_LEFT"
style ="-fx-background-color: black; -fx-background-radius: 20;" >
<children>
<ImageView id ="imgMessage"
fitHeight ="30" fitWidth ="30" preserveRatio ="true"/>
<Label id ="lblMessage" style ="-fx-text-fill: white;">
<HBox.margin>
<Insets left ="5.0" right ="5.0" />
</HBox.margin>
</Label>
</children>
</HBox>
```

Label의 글자색을 흰색으로 변경

>>> custom_dialog.xml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.image.*?>

<AnchorPane xmlns:fx ="http://javafx.com/fxml"
prefHeight ="150.0" prefWidth ="400.0" >
<children>
<ImageView fitHeight ="50" fitWidth ="50"
layoutX ="15" layoutY ="15" preserveRatio ="true">
<image><Image url ="@images/dialog-info.png" /></image>
</ImageView>
<Label id ="txtTitle" prefHeight ="15.0" prefWidth ="290.0"
layoutX ="87.0" layoutY ="33.0" />
<Button id ="btnOk" layoutX ="336.0" layoutY ="104.0" text ="확인" />
</children>
</AnchorPane>


>>> RootController.java


package sec09.exam01_dialog;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
@Override
public void initialize(URL location, ResourceBundle resources) {

}

private Stage primaryStage;






public void setPrimaryStage(Stage primaryStage) {
this.primaryStage  =  primaryStage;

}
```

//파일 열기 다이얼로그 실행
```java
public void handleOpenFileChooser(ActionEvent e) {
FileChooser fileChooser  =  new FileChooser();
fileChooser.getExtensionFilters().addAll(
new ExtensionFilter("Text Files", "*.txt"),
new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
new ExtensionFilter("All Files", "*.*"));
File selectedFile  =  fileChooser.showOpenDialog(primaryStage);
if (selectedFile !=  null) {
System.out.println(selectedFile.getPath());

}

}
```

//파일 저장 다이얼로그 실행
```java
public void handleSaveFileChooser(ActionEvent e) {
FileChooser fileChooser  =  new FileChooser();
fileChooser.getExtensionFilters().add(new ExtensionFilter("All
Files", "*.*"));
File selectedFile  =  fileChooser.showSaveDialog(primaryStage);
if (selectedFile !=  null) {
System.out.println(selectedFile.getPath());
}

}
```

//디렉토리 선택 다이얼로그 실행
```java
public void handleDirectoryChooser(ActionEvent e) {
DirectoryChooser directoryChooser  =  new DirectoryChooser();
File selectedDir  =  directoryChooser.showDialog(primaryStage);
if (selectedDir !=  null) {
System.out.println(selectedDir.getPath());
}

}
```

//Popup 다이얼로그 실행
```java
public void handlePopup(ActionEvent e) throws Exception {









Popup popup  =  new Popup();

Parent parent  =  FXMLLoader.load(getClass().getResource("popup.fxml"));
ImageView imageView  =  (ImageView) parent.lookup("#imgMessage");
imageView.setImage(new Image(
getClass().getResource("images/dialog-info.png").toString()));
imageView.setOnMouseClicked(event->popup.hide());
Label lblMessage  =  (Label)parent.lookup("#lblMessage");
lblMessage.setText("메시지가 왔습니다.");

popup.getContent().add(parent);
popup.setAutoHide(true);
popup.show(primaryStage);

}
```

//커스(cid:3109) 다이얼로그 실행
```java
public void handleCustom(ActionEvent e) throws Exception {
Stage dialog  =  new Stage(StageStyle.UTILITY);
dialog.initModality(Modality.WINDOW_MODAL);
dialog.initOwner(primaryStage);
dialog.setTitle("확인");

Parent parent  =  FXMLLoader.load(getClass().getResource("custom_dialog.
fxml"));
Label txtTitle  =  (Label) parent.lookup("#txtTitle");
txtTitle.setText("확인하(cid:2257)습니까?");
Button btnOk  =  (Button) parent.lookup("#btnOk");
btnOk.setOnAction(event->dialog.close());
Scene scene  =  new Scene(parent);

dialog.setScene(scene);
dialog.setResizable(false);
dialog.show();

}

}









>>> AppMain.java


package sec09.exam01_dialog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
FXMLLoader loader  = new FXMLLoader(getClass().getResource("root.fxml"));
Parent root  =  loader.load();
RootController controller  =  loader.getController();
controller.setPrimaryStage(primaryStage);

Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

## 10. JavaFX CSS 스타일

JavaFX UI를 담당하는 컨테이너 및 컨트롤은 CSSCascading Style Sheets를 적용해서 모양 및 색상 등을

변경할 수 있다. 이것은 HTML에 CSS를 적용하는 것과 유사하다. 다음은 JavaFX 애플리케이션에

CSS를 적용하면 UI 스킨이 어떻게 달라지는지 보여준다.





JavaFX CSS는 W3C CSS 버전 2.1 스펙(http://www.w3.org/TR/CSS21 )에 따르기 때문

에 CSS로 HTML 문서의 스타일을 작성해 본 개발자는 쉽게 JavaFX CSS를 정의할 수 있다. 단,

JavaFX CSS의 속성명은 W3C CSS 속성명 앞에 “-fx-”가 더 붙는 것이 차이점이다.

JavaFX 컨트롤의 기본 CSS는 modena.css 파일에 작성되어 있다. 이 파일은 javax.controls.jar

모듈에 포함되어 있다.

com/sun/javafx/scene/control/skin/modena/modena.css

커스텀 CSS는 기본 CSS의 속성값을 변경하거나 새로운 속성을 정의한 것을 말한다. 커스텀 CSS

를 적용하는 방법에는 컨테이너 또는 컨트롤을 정의할 때 직접 설정하는 인라인 스타일 방식과 외부

CSS 파일을 생성하고 Scene에 적용하는 방식이 있다.

인라인 스타일

인라인inline 스타일은 컨테이너 또는 컨트롤의 style 속성값으로 직접 CSS를 작성하는 방식을 말한

다. 작성이 쉬우며 빠르게 모양과 색상을 변경할 수 있다는 장점이 있다.

(cid:29)컨테이너 style = "속성:값; 속성:값; …">
(cid:29)컨트롤 style = "속성:값; 속성:값; …">



다음 예제는 세 개의 Label을 FXML로 선언하고, Label의 style 속성을 이용해서 첫 번째 Label은

배경을 검은색, 글자는 노란색으로 CSS를 적용하고, 두 번째, 세 번째 Label은 배경을 파란색, 글자

는 흰색으로 CSS를 적용했다.

>>> root.fxml





```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import java.lang.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"
prefHeight ="50" prefWidth ="400" alignment ="CENTER" spacing ="20">
<children>
<Label text ="(cid:1128)정바(cid:3092),노(cid:1734)글(cid:2431)"
style ="-fx-background-color: black; -fx-text-fill: yellow;
-fx-padding: 5;"/>
<Label text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"
style ="-fx-background-color: blue; -fx-text-fill: white;
-fx-padding: 5;"/>
<Label text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"
style ="-fx-background-color: blue; -fx-text-fill: white;
-fx-padding: 5;"/>
</children>
</HBox>

>>> AppMain.java

package sec10.exam01_inline;







import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

외부 CSS 파일

인라인 스타일은 컨테이너와 컨트롤의 style 속성으로 CSS를 직접 적용하기 때문에 동일한 스타일

을 적용하는 컨테이너와 컨트롤이 많아질수록 중복 코드가 늘어나는 단점이 있다. 또한 레이아웃

FXML과 CSS가 뒤섞여 유지보수가 어렵다.

인라인 스타일보다는 외부 CSS 파일 방식을 사용하면 중복 CSS 작성을 줄이고 재사용성을 높이면

서 유지보수도 편리해진다. 외부 CSS 파일 방식은 컨테이너와 컨트롤에 사용되는 CSS를 별도 파일

에 작성하고, Scene을 생성할 때 추가하는 방식이다.

여러 가지 장점이 많기 때문에 보통 JavaFX 애플리케이션을 개발할 때는 외부 CSS 파일 방식을 사

용한다. 외부 CSS 파일을 작성하기 위해서는 몇 가지 선택자 문법을 알아야 한다.





1) 선택자

인라인 스타일은 해당 컨테이너 또는 컨트롤에 직접 스타일을 적용하기 때문에 선택자가 필요없지만,

외부 CSS 파일은 스타일을 적용할 컨테이너와 컨트롤을 선택해주는 선택자가 필요하다. 다음은 선

택자를 작성하는 방법을 보여준다.

선택자 {
속성:값; 속성:값; …

}

선택자는 중괄호 { }에 정의된 CSS 속성을 적용할 컨테이너 또는 컨트롤을 선택하는 역할을 하는데,

다음 세 가지가 있다.

선택자

Type 선택자

id 선택자

class 선택자

작성 방법

Type { 속성:값; 속성:값; .. }

#id { 속성:값; 속성:값; … }

.class { 속성:값; 속성:값; … }

Type 선택자는 같은 타입의 컨테이너 또는 컨트롤을 모두 선택한다. 예를 들어 모든 Label 컨트롤

의 안쪽 여백을 5만큼 주고 싶다면 다음과 같이 정의하면 된다.

Label {
-fx-padding: 5;

}

<Label …>
<Label …>

#id 선택자는 동일한 id 속성값을 가지고 있는 컨테이너 또는 컨트롤을 선택한다. 예를 들어 id 속성

값이 lblId인 Label의 배경을 검은색으로, 글자를 노란색으로 설정하고 싶다면 다음과 같이 정의하

면 된다.

#lblId {
-fx-background-color: black;
-fx-text-fill: yellow;

}


<Label id = "lblId">

.class 선택자는 동일한 styleClass 속성값을 가지고 있는 컨테이너 또는 컨트롤을 선택한다. 예를

들어 styleClass 속성값이 lblClass인 Label의 배경을 파란색으로, 글자를 흰색으로 설정하고 싶다

면 다음과 같이 정의하면 된다.

#lblId {
-fx-background-color: black;
-fx-text-fill: yellow;

}

<Label styleClass = "lblClass">
<Label styleClass = "lblClass">

FXML 파일에서 id 속성은 유일한 값을 가져야 하지만, styleClass 속성은 중복된 값을 가질 수 있

다. 이 말은 id 선택자는 하나의 컨트롤만 선택할 수 있는 반면, class 선택자는 동시에 여러 컨트롤

을 선택할 수 있다는 뜻이다.

Type 선택자와 class 선택자는 조합이 가능하다. 예를 들어 Label 컨트롤 중에서 styleClass=

"className"을 가진 것만 CSS를 적용하고 싶다면 다음과 같이 정의하면 된다. 만약 Button 컨트

롤이 styleClass="className"을 가지고 있다면 CSS는 적용되지 않는다.

Label.className {
-fx-background-color: blue;
-fx-text-fill: white;

}

컨트롤은 세 가지 상태를 가질 수 있다. 입력 가능한 상태(focused ), 마우스가 위에 있는 상태

(hover ), 마우스로 클릭한 상태(pressed )를 말하는데, 각 상태에 따라 스타일을 다르게 적용하

고 싶다면 선택자 다음에 :focused, :hover, :pressed를 붙이면 된다. 이러한 것들을 유사 클래스

(pseudo-class )라고 한다.

상태

입력 가능한 상태

상태별 선택자

선택자:focused { 속성:값; 속성:값; … }

마우스가 컨트롤 위에 있는 상태

선택자:hover { 속성:값; 속성:값; … }

마우스로 컨트롤을 누른 상태

선택자:pressed { 속성:값; 속성:값; … }



2) CSS 파일 적용

이렇게 작성된 외부 CSS 파일은 개별 컨테이너 또는 컨트롤에 적용하거나 Scene에 추가하여 Scene

내부의 모든 컨테이너와 컨트롤에 적용할 수 있다.

개별 컨테이너 또는 컨트롤에 CSS 파일을 적용하려면 다음과 같이 FXML 파일에서 해당 태그의

stylesheets 속성으로 CSS 파일 경로를 지정하면 된다.

(cid:29)컨테이너 stylesheets =  "@app.css">

Scene 내부의 모든 컨테이너와 컨트롤에 적용하려면 Scene의 getStylesheets ( ) 메소드로

ObservableList를 얻고, 여기에 CSS 파일 경로를 추가한다. CSS 파일은 메인 클래스와 동일한 경

로에서 흔히 작성되므로 다음과 같이 CSS 파일 경로를 얻어 추가하면 된다.

```java
public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());
primaryStage.setScene(scene);
primaryStage.show();

}

…

}
```

다음 예제는 외부 CSS 파일을 이용해서 Label들의 배경색과 글자색을 변경한다. root.xml에서 첫

번째 Label에는 id 속성이 있고, 두 번째와 세 번째 Label에는 styleClass 속성이 있다는 것을 주

목하자. 이들 속성을 이용해서 선택자를 작성한다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>



<?import javafx.scene.control.*?>
<?import java.lang.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"
prefHeight ="50" prefWidth ="400" alignment ="CENTER" spacing ="20">
<children>
<Label id ="lblId" text ="(cid:1128)정바(cid:3092),노(cid:1734)글(cid:2431)"/>
<Label styleClass ="lblClass" text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"/>
<Label styleClass ="lblClass" text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"/>
</children>
</HBox>
```

CSS의 주석은 /*로 시작해서 */로 끝난다.
자바처럼 // 주석은 사용할 수 없다.

>>> app.css


/* 전체 Label 선택 */
Label {
-fx-padding: 5;

}

/* id = "lblId"을 가(cid:2771) 컨트롤 선택 */
#lblId {
-fx-background-color: black;
-fx-text-fill: yellow;

}

/* styleClass = "lblClass"을 가(cid:2771) 컨트롤 선택 */
.lblClass {
-fx-background-color: blue;
-fx-text-fill: white;

}



>>> AppMain.java


```java
package sec10.exam02_css_file;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

다음 예제는 TextField와 Button 컨트롤의 상태에 따라서 스타일을 변경한다. TextField가 입력

가능한 상태가 되면 배경을 노란색으로, 마우스가 Button 위에 있으면 배경을 노란색 그리고 클릭

하면 빨간색으로 변경한다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>





<?import javafx.scene.control.*?>

<HBox xmlns:fx ="http://javafx.com/fxml" spacing ="10">
<padding>
<Insets topRightBottomLeft ="10"/>
</padding>

<children>
<TextField prefWidth ="200"/>
<Button prefWidth ="50" text ="확인"/>
</children>
</HBox>

>>> app.css


TextField:focused {
-fx-border-color: skyblue;
-fx-background-color: yellow;

}

Button:hover {
-fx-border-color: skyblue;
-fx-background-color: yellow;

}

Button:pressed {
-fx-border-color: skyblue;
-fx-background-color: red;

}



>>> AppMain.java


package sec10.exam03_state_selector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

border 속성

border 속성은 컨테이너 및 컨트롤의 경계선 스타일을 설정한다. 다음과 같이 경계선의 굵기, 색상,

스타일, 내부 경계선의 위치를 설정할 수 있는 세부 속성들이 있다.

속성

-fx-border-color

설명

경계선의 색상

-fx-border-insects

내부 경계선의 위치

-fx-border-radius

둥근 모서리를 위한 원의 반지름




-fx-border-style

-fx-border-width

경계선의 스타일(실선, 점선)

경계선의 굵기

-fx-border-color 속성은 경계선의 색상을 설정하는데, 다음과 같은 다양한 값들을 사용할 수

있다.

-fx-border-color: red;
-fx-border-color: #ff0000;
-fx-border-color: rgba(255,0,0,0);

//색이름

//(cid:4)색상번호
//rgba(red값, green값, blue값, 투명도)

rgba ( ) 함수의 red, green, blue는 0~255 값을 가질 수 있고, 투명도는 0.0 (투명)~1.0 (불투명)

값을 가진다. 다음은 경계선을 빨간색으로, 굵기를 1픽셀로 설정한 것이다.

-fx-border-color: red;
-fx-border-width: 1;

-fx-border-radius 속성은 원의 반지름을 설정해서 둥근 모서리를 만든다.

-fx-border-color: red;
-fx-border-width: 1;
-fx-border-radius: 20;

JavaFX 컨테이너 및 컨트롤은 바깥 경계선 외에 내부 경계선을 여러 개 정


의할 수 있다. -fxborder-insets 속성으로 경계선이 나타날 깊이를 쉼표

로 구분해서 나열하면 다른 속성들도 경계선의 개수에 맞게 굵기, 색상, 스

타일을 지정할 수 있다. 다음은 3개의 경계선을 정의하고 각각 색상 및 굵기



를 설정한 것이다.



-fx-border-insets: 0, 10, 20;
-fx-border-color: red, green, blue;
-fx-border-width: 1, 1, 1;

경계선은 top, right, bottom, left별로 굵기, 색상, 스타일을 지정할 수 있다. 값의 순서는 top부터

시작해 시계 방향으로 top, right, bottom, left로 나열해주면 된다. 다음은 두 번째 경계선 top,

bottom의 색상을 녹색으로 설정하고, 세 번째 경계선 right, bottom의 굵기를 3으로 설정한 것

이다.

-fx-border-insets: 0, 10, 20;
-fx-border-color: red, green white green white, blue;
-fx-border-width: 1, 1, 1 3 3 1;

-fx-border-style 속성은 실선과 점선을 설정하는데, solid (실선), dotted (점선), dashed (대

시선)와 선의 길이 및 공백을 설정할 수 있는 segments ( )를 값으로 줄 수 있다. segments ( )의

매개값은 홀수 번째 값은 선의 길이를, 짝수 번째 값은 공백의 길이를 주면 된다. 다음은 바깥 경계

선의 top, right, bottom, left를 다른 스타일로 설정한 것이다.

-fx-border-color: red;
-fx-border-width: 2;
-fx-border-style: solid dotted dashed segments(3, 2, 8, 2);

다음 예제는 FXML로 네 개의 VBox를 배치하고 border 속성을 다르게 적용하였다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import java.lang.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>



<HBox xmlns:fx ="http://javafx.com/fxml" spacing ="20">
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
<children>
<VBox id ="vbox1" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox2" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox3" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox4" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox5" prefHeight ="100" prefWidth ="100"/>
</children>
</HBox>

>>> app.css


#vbox1 {
-fx-border-color: red;
-fx-border-width: 1;

}

#vbox2 {
-fx-border-color: red;
-fx-border-width: 1;
-fx-border-radius: 20;

}

#vbox3 {
-fx-border-insets: 0, 10, 20;




-fx-border-color: red, green, blue;
-fx-border-width: 1, 1, 1;

}

#vbox4 {
-fx-border-insets: 0, 10, 20;
-fx-border-color: red, green white green white, blue;
-fx-border-width: 1, 1, 1 3 3 1;

}

#vbox5 {
-fx-border-color: red;
-fx-border-width: 2;
-fx-border-style: solid dotted dashed segments(3, 2, 8, 2);

}

>>> AppMain.java

package sec10.exam04_border;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}






public static void main(String[] args) {
launch(args);

}

}
```

background 속성

background 속성은 컨테이너 및 컨트롤의 배경 스타일을 설정한다. 다음과 같이 배경 색상, 배경

이미지를 설정할 수 있는 세부 속성들이 있다.

속성

-fx-background-color

-fx-background-image

설명

배경 색상

배경 이미지

-fx-background-position

배경 이미지 위치(top, right, bottom, left, center)

-fx-background-repeat

이미지 반복 여부(no-repeat: 반복하지 않음)

-fx-background-color 속성은 배경 색상을 설정하는데, 단일 색상을 지정하는 방법은 다음과

같다.

-fx-background-color: red;
-fx-background-color: #ff0000;
-fx-background-color: rgba(255,0,0,0);

//색 이름
//(cid:4)색상 번호
//rgba(red값, green값, blue값, 투명도)

-fx-background-color에는 단일 색상뿐만 아니라 선형 및 원형 그라디언트도 설정할 수 있다.

선형 그라디언트는 시작 색에서부터 끝 색까지 진행 방향으로 서서히 색상 변화를 준다. 선형 그라디

언트를 작성하는 방법은 다음과 같다.

linear-gradient(to (cid:2771)행방(cid:3313), 시작색 S%, 중간색 M%…, (cid:1368)색);



진행 방향은 to bottom, to right, to bottom right 등과 같이 밑으로, 오른쪽으

로, 대각선으로 지정할 수 있다. 각각의 색은 몇 % 정도가 나올지 S, M 값으로 지

정할 수 있다. 단, 끝 색은 % 값을 줄 수 없다. % 값이 생략되면 균등하게 색상이 나

온다. 오른쪽 그림은 다음과 같이 작성된 선형 그라디언트가 적용된 것이다.

-fx-background-color: linear-gradient(to right, black, white);

원형 그라디언트는 시작 색에서부터 끝 색까지 원형으로 서서히 색상 변화를 준다. 원형 그라디언트

를 작성하는 방법은 다음과 같다.

radial-gradient(center X% Y%, radius R%, 시작색 S%, 중간색 M%, (cid:1368)색);

X%와 Y%는 컨테이너 및 컨트롤의 좌상단을 0%, 0%로 보고, 원의 중심점이 위치하는 곳을 지정한

다. 예를 들어 center 50% 50%는 원의 정중앙을 중심점으로 설정한다. R%는 중심점에서부터 색상

변화가 종료되는 위치이다. 예를 들어 radius 50%는 컨테이너 및 컨트롤 전체 영

역에 원형 그라디언트를 적용한다. 각각의 색이 몇 % 정도로 나올지 S, M 값으로

지정할 수 있다. 단, 끝 색은 % 값을 줄 수 없다. % 값이 생략되면 균등하게 색상이

나온다. 오른쪽 그림은 다음과 같이 작성된 원형 그라디언트가 적용된 것이다.

-fx-background-color: radial-gradient(center 50% 50%, radius 50%, #ffffff 10%,
#000000);

-fx-background-image 속성은 배경 이미지를 설정한다. 배경 이미지보다 컨테이너 및 컨트롤의

사이즈가 더 크면 이미지는 반복적으로 드로잉된다. 한 번만 드로잉하려면 -fx-backgroundrepeat

속성값을 no-repeat로 설정하면 된다. 그리고 이

미지의 위치는 -fx-backgroundposition으로

설정한다. 다음은 배경 이미지를 설정하는 방법이다.


-fx-background-image: url("이미지 경로");
-fx-background-repeat: no-repeat;
-fx-background-position: center;

//이미지 파일 지정
//한 번만 드로잉하도록 지정
//정중앙에 위치하도록 지정

다음 예제는 6개의 VBox에 차례대로 단색, 선형 그라디언트, 원형 그라디언트, 반복 이미지, 단일

이미지, 정중앙 단일 이미지를 적용했다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>

<HBox xmlns:fx ="http://javafx.com/fxml" spacing ="10">
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
<children>
<VBox id ="vbox1" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox2" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox3" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox4" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox5" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox6" prefHeight ="100" prefWidth ="100" />
</children>
</HBox>



>>> app.css



#vbox1 {
-fx-background-color: rgba(0, 0, 0, 1);

}

#vbox2 {
-fx-background-color: linear-gradient(to right, #000000, #ffffff);

}

#vbox3 {
-fx-background-color: radial-gradient(center 50% 50%, radius 50%,
#ffffff, #000000);

}

#vbox4 {
-fx-border-color: skyblue;
-fx-background-image: url("images/icon.gif");

}

#vbox5 {
-fx-border-color: skyblue;
-fx-background-image: url("images/icon.gif");
-fx-background-repeat: no-repeat;

}

#vbox6 {
-fx-border-color: skyblue;
-fx-background-image: url("images/icon.gif");
-fx-background-repeat: no-repeat;
-fx-background-position: center;

}

>>> AppMain.java


package sec10.exam05_background;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;




import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

font 속성

font 속성은 글자의 스타일을 설정한다. 여기에는 폰트의 크기, 종류, 굵기, 색상 등을 설정할 수 있

는 다음과 같은 세부 속성들이 있다.

속성

-fx-font-size

-fx-font-family

-fx-font-weight

-fx-text-fill

설명

폰트 크기

폰트 종류

폰트 굵기(bold)

폰트 색상(단색, 선형 그라디언트, 원형 그라디언트)

다음 예제는 Label 컨트롤의 폰트를 설정한다. 폰트 종류는 Arial Black, 크기는 35, 굵게, 색상은

선형 그라디언트를 적용했다.





>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>

<VBox id ="root" xmlns:fx ="http://javafx.com/fxml" >
<children>
<Label id ="welcome-text" text ="Welcome" />
</children>
</VBox>

>>> app.css


#root {
-fx-padding: 10;

}

#welcome-text {
-fx-font-size: 35;
-fx-font-family: "Arial Black";
-fx-font-weight: bold;
-fx-text-fill: linear-gradient(to bottom, blue, white);

}


>>> AppMain.java


package sec10.exam06_font;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

shadow 효과

JavaFX  CSS는  그림자  효과를  주기  위한  -fx-effect  속성을  제공한다.  속성값으로는

dropshadow ( )와 innershadow ( )를 줄 수 있는데, dropshadow ( )는 바깥 그림자를 주어 튀

어 나오는 느낌을 주고, innershadow ( )는 안쪽 그림자를 주어 움푹 들어간 느낌을 준다.





-fx-effect 속성을 작성하는 방법은 다음과 같다.

-fx-effect: dropshadow(three-pass-box , 그림자색상 , radius, spread , offsetX , offsetY);
-fx-effect: innershadow(three-pass-box , 그림자색상 , radius, choke, offsetX, offsetY);

three-pass-box는 blur-type의 종류로 gaussian, one-pass-box, two-pass-box,

three-pass-box 등이 있다. JavaFX는 three-pass-box를 기본으로 사용한다. radius는

blurkernel의 반지름으로 0.0~127.0 사이의 값을 가지는데, 기본값은 10이다. spread와 choke

는 각각 그림자의 spread와 choke로 0.0~1.0 사이의 값을 가지는

offsetX

데, 기본값은 0.0이다. three-pass-box, radius, spread, choke

는 이해하기가 쉽지 않기 때문에 보통은 기본값을 그대로 이용한다.

offsetY

offsetX와 offsetY는 그림자의 편차인데, 오른쪽 그림을 보면 쉽게

이해가 될 것이다.

다음 예제는 두 개의 버튼에 shadow 효과를 주었다. 첫 번째 버튼은 dropshadow ( )를 적용했고

두 번째 버튼은 innershadow ( )를 적용했다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"  prefWidth ="300" prefHeight ="150"
spacing ="50" fillHeight ="false" alignment ="CENTER">
<padding>
<Insets topRightBottomLeft ="10"/>
</padding>
<children>
<Button id ="btn1" prefWidth ="100" prefHeight ="50" text ="DropShadow"/>
<Button id ="btn2" prefWidth ="100" prefHeight ="50" text ="InnerShadow"/>
</children>
</HBox>


>>> app.css


#btn1 {
-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.7) , 10, 0 , 5 , 5);

}

#btn2 {
-fx-effect: innershadow(three-pass-box , rgba(0,0,0,0.7) , 10, 0 , 3, 3);

}

>>> AppMain.java


package sec10.exam07_shadow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");





primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

화면 스킨 입히기

다음 예제에서는 지금까지 학습한 내용을 활용해서 로그인 폼 화면을 만들고 CSS를 적용해서 스킨

을 입혀본다. 이 예제는 오라클의 JavaFX CSS 샘플 예제로 소개된 것이다. 마우스를 버튼 위로 올

리거나 클릭하면 색상 변화를 볼 수 있다

>>> root.fxml




```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<AnchorPane styleClass ="root"  xmlns:fx ="http://javafx.com/fxml"
prefHeight ="194.0" prefWidth ="300.0" >
<children>
<Label id ="welcome-text" layoutX ="40.0" layoutY ="14.0" text ="Welcome" />
<Label layoutX ="42.0" layoutY ="80.0" text ="아이디" />
<Label layoutX ="42.0" layoutY ="118.0" text ="패스워드" />
<TextField layoutX ="120.0" layoutY ="76.0" />
<PasswordField layoutX ="120.0" layoutY ="114.0" />
<Button layoutX ="97.0" layoutY ="158.0" styleClass ="button" text =
"로그인" />
<Button layoutX ="164.0" layoutY ="158.0" styleClass ="button" text =
"취소" />
</children>
</AnchorPane>





>>> app.css


.root {
-fx-background-image: url("images/background.jpg");

}

Label {
-fx-font-size: 12px;
-fx-font-weight: bold;
-fx-text-fill: #333333;

}

#welcome-text {
-fx-font-size: 35px;
-fx-font-family: "Arial Black";
-fx-text-fill: linear-gradient(darkgray, lightgray);
-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 3, 0 , 2 , 2.1 );

}

.button {
-fx-text-fill: white;
-fx-font-family: "Arial Narrow";
-fx-font-weight: bold;
-fx-background-color: linear-gradient(#61a2b1, #2A5058);
-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 10, 0 , 2 , 2 );

}

.button:hover {




-fx-background-color: linear-gradient(#2A5058, #61a2b1);

}

.button:pressed {
-fx-background-color: linear-gradient(yellow, #61a2b1);

}

>>> AppMain.java


package sec10.exam08_login_skin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}



```

## 11. JavaFX 스레드 UI 변경

JavaFX UI는 스레드에 안전하지 않기 때문에 UI를 생성하고 변경하는 작업은 JavaFX Application

Thread가 담당하고, 다른 작업 스레드들은 UI를 생성하거나 변경할 수 없다.

main 스레드가 Application의 launch ( ) 메소드를 호출하면서 생성된 JavaFX Application

Thread는 start ( ) 메소드를 실행시키면서 모든 UI를 생성한다. 컨트롤에서 이벤트가 발생할 경우

컨트롤러의 이벤트 처리 메소드를 실행하는 것도 JavaFX Application Thread이다.

main Thread

launch()

JavaFX Application Thread

start()

UI 생성/변경

컨트롤로 생성 및 이벤트 처리

Worker Thread

JavaFX 애플리케이션을 개발할 때 주의할 점은 JavaFX Application Thread가 시간을 요하는

작업을 하지 않도록 하는 것이다. 시간을 요하는 작업을 하게 되면 이 시간 동안에 UI는 반응하지

않고 멈춰있는 상태가 되기 때문에 다른 작업 스레드를 생성해서 처리하는 것이 좋다.

예를 들어 파일을 읽고 쓰거나 네트워크상에서 데이터를 주고받을 때 얼마만큼의 시간이 필요한지

모르기 때문에 반드시 작업 스레드를 생성해서 처리해야 한다.

만약 작업 스레드에서 UI 변경 작업이 필요하다면 작업 스레드가 직접 UI를 변경할 수 없기 때문

에 UI 변경 코드를 Runnable로 생성하고, 이것을 매개값으로 해서 Platform의 정적 메소드인

runLater ( )를 호출해야 한다.



Runnable 익명 구현 객체 이용

람다식 이용

Platform.runLater(new Runnable() {
```java
@Override
public void run() {
//UI 생성 및 변경 코드
}
});

Platform.runLater(()->{
//UI 생성 및 변경 코드
);
```

Platform.runLater ( ) 메소드는 매개값으로 받은 Runnable을 이벤트 큐event queue에 저장하고 즉

시 리턴된다.

스레드 A

스레드 B

스레드 C

Platform.runLater ( );

이벤트 큐(EventQueue )

Runnable 객체

JavaFX
Application
Thread

UI 생성
및 변경

이벤트 큐에 저장된 Runnable은 JavaFX Application Thread에 의해 순차적으로 하나씩 실행

처리되어 UI를 변경한다. runLater는 지금 당장 실행하는 것이 아니고 순서에 따라 조금 후에 실행

한다는 뜻에서 지어진 이름이다.

다음 예제는 작업 스레드가 0.1초 주기로 얻어낸 시간을 Label 컨트롤의 text 속성값으로 사용한다.

Label은 UI 요소이므로 작업 스레드에서 setText ( ) 메소드로 text 속성값을 변경할 수 없다. 대신

Runnable을 생성해서 Platform.runLater ( ) 메소드를 호출한다.

>>> root.fxml

```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>






<AnchorPane xmlns:fx ="http://javafx.com/fxml" prefHeight ="100.0"
prefWidth ="200.0"
fx:controller ="sec11.exam01_runlater.RootController">
<children>
<Label fx:id ="lblTime" alignment ="CENTER" layoutX ="25.0"
layoutY ="15.0"
prefHeight ="35.0" prefWidth ="150.0"
style ="-fx-background-color: black; -fx-text-fill: yellow;
-fx-font-size: 20; -fx-background-radius: 10;" text ="00:00:00" />
<Button fx:id ="btnStart" layoutX ="46.0" layoutY ="63.0" text ="시작" />
<Button fx:id ="btnStop" layoutX ="110.0" layoutY ="63.0" text ="(cid:1893)(cid:2938)" />
</children>
</AnchorPane>

>>> RootController.java


package sec11.exam01_runlater;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {






@FXML private Label lblTime;
@FXML private Button btnStart;
@FXML private Button btnStop;

private boolean stop;

@Override
public void initialize(URL location, ResourceBundle resources) {
btnStart.setOnAction(event->handleBtnStart(event));
btnStop.setOnAction(event->handleBtnStop(event));

}

public void handleBtnStart(ActionEvent e) {
stop  =  false;
Thread thread  =  new Thread() {
@Override
public void run() {
SimpleDateFormat sdf  =  new SimpleDateFormat("HH:mm:ss");
while(!stop) {
String strTime  =  sdf.format(new Date());
Platform.runLater(()->{
lblTime.setText(strTime);
```

UI 변경 작업

});
try { Thread.sleep(100); } catch (InterruptedException e) {}

}

};

};
thread.setDaemon(true);
thread.start();

}

```java
public void handleBtnStop(ActionEvent e) {
stop  =  true;

}

}






>>> AppMain.java



package sec11.exam01_runlater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

다음 예제는 작업 스레드에서 0부터 100까지 합을 구할 동안 ProgressBar와 Label 컨트롤에 진행

정도를 표시한다. 그리고 작업이 완료되면 결과를 Label 컨트롤에 나타낸다. ProgressBar의 진행

정도와 Label의 글자를 변경하는 작업은 Platform.runlater ( ) 메소드로 처리하는 것을 볼 수 있다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import java.lang.*?>
<?import javafx.scene.layout.*?>








<?import javafx.scene.control.*?>

<AnchorPane xmlns:fx ="http://javafx.com/fxml" prefHeight ="129.0"
prefWidth ="233.0"
fx:controller ="sec11.exam02_runlater.RootController">
<children>
<ProgressBar fx:id ="progressBar" layoutX ="17.0" layoutY ="23.0"
prefWidth ="200.0" progress ="0.0" />
<Label layoutX ="18.0" layoutY ="57.0" text ="(cid:2771)행정도:" />
<Label fx:id ="lblWorkDone" layoutX ="77.0" layoutY ="57.0" />
<Label layoutX ="118.0" layoutY ="57.0" text ="작업결과:" />
<Label fx:id ="lblResult" layoutX ="175.0" layoutY ="57.0" />
<Button fx:id ="btnStart" layoutX ="66.0" layoutY ="91.0" text ="시작" />
<Button fx:id ="btnStop" layoutX ="130.0" layoutY ="91.0" text ="(cid:1893)(cid:2938)" />
</children>
</AnchorPane>

>>> RootController.java


package sec11.exam02_runlater;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;




import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {
@FXML private ProgressBar progressBar;
@FXML private Label lblWorkDone;
@FXML private Label lblResult;
@FXML private Button btnStart;
@FXML private Button btnStop;

private Thread thread;

@Override
public void initialize(URL location, ResourceBundle resources) {
btnStart.setOnAction(event->handleBtnStart(event));
btnStop.setOnAction(event->handleBtnStop(event));

}

public void handleBtnStart(ActionEvent e) {
thread  =  new Thread() {
@Override
public void run() {
int result  =  0;
for(int i = 0; i<= 100; i++) {
result + =  i;

double progress  =  i/100.0;
String workDone  =  String.valueOf(i);

Platform.runLater(() -> {
progressBar.setProgress(progress);
lblWorkDone.setText(workDone);

});
```

UI 변경 작업

try {Thread.sleep(100); } catch(InterruptedException e) {
break;

}

}

String strResult  =  String.valueOf(result);










Platform.runLater(() -> {
lblResult.setText(String.valueOf(strResult));

UI 변경 작업

});

}

};
thread.setDaemon(true);
thread.start();

}

```java
public void handleBtnStop(ActionEvent e) {
thread.interrupt();

}

}

>>> AppMain.java



package sec11.exam02_runlater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  (Parent)FXMLLoader.load(getClass().getResource("root.
fxml"));
Scene scene  =  new Scene(root);

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);








}

}
```

## 12. 장면 이동과 애니메이션

애플리케이션은 다양한 화면을 가지고 있다. 메인 화면에서 시작해 사용자의 선택에 따라 가입 화

면, 로그인 화면, 목록 화면 등으로 이동된다. 화면이 이동될 때 애니메이션을 적용하면 눈을 즐겁게

만들어준다. 같은 화면에서도 마우스의 위치에 따라 컨트롤의 속성을 변화시켜 다이나믹한 애니메

이션을 만들 수도 있다.

이번 절에서는 화면을 이동시키는 방법과 슬라이드slide와 페이드fade 애니메이션을 적용하는 방법을

알아보기로 하자.

화면 이동

JavaFX에서 화면은 장면이므로 화면을 이동한다는 것은 즉 장면을 변경하는 것이다. 장면을 변경

하는 가장 쉬운 방법은 Stage에 새로운 Scene을 세팅하는 것이다.

메인 화면에서 로그인 화면으로 이동하기 위해 버튼을 클릭했다고 가정해보자. 컨트롤러의 이벤트

처리 메소드는 로그인 Scene을 생성하고, primaryStage의 setScene ( ) 메소드로 현재 Scene을

로그인 Scene으로 변경할 수 있다.

```java
public void handlebtnLogin(ActionEvent event) {
try {
Parent login  =  FXMLLoader.load(getClass().getResource("login.fxml"));
Scene scene  =  new Scene(login);
Stage primaryStage  =  (Stage) btnLogin.getScene().getWindow();
primaryStage.setScene(scene);    //화면 변경
} catch(Exception e) {
e.printStackTrace();

}

}


```

setScene ( ) 메소드로 화면을 이동하면 이전 Scene은 Stage에서 제거되므로 애니메이션을 적용할

수 없다. 화면 이동 애니메이션을 적용하려면 이전 화면과 다음 화면이 일시적으로 공존해야 한다.

따라서 화면 이동을 위한 다른 방법이 필요한데, StackPane을 이용하면 화면 이동 효과와 함께 애

니메이션을 적용할 수 있다. 다음과 같이 Scene은 하나만 생성하고 StackPane을 루트 컨테이너로

해서 메인 화면과 로그인 화면을 추가하는 것이다.

StackPane

로그인 장면

메인 장면

인덱스 1

인덱스 0

메인 화면만 StackPane에 추가되어 있는 상태에서 로그인 화면이 생성되고 StackPane에 추가되

면 StackPane은 나중에 추가된 로그인 화면만 사용자에게 보여주고 메인 화면은 뒤로 숨긴다. 반

대로 StackPane에서 로그인 화면을 제거하면 밑에 있는 메인 화면이 보여진다.

이와 같은 방법으로 화면을 이동하게 되면 이전 화면과 다음 화면이 일시적으로 공존하게 되고 애니

메이션을 적용할 수 있게 된다. 다음 예제는 StackPane을 이용해서 로그인 화면과 메인 화면을 번

갈아가면서 보여준다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import javafx.geometry.*?>

<StackPane xmlns:fx ="http://javafx.com/fxml"
prefHeight ="500" prefWidth ="350"
fx:controller ="sec12.exam01_stackpane.RootController">
<children>
<BorderPane>
<top>
<BorderPane style ="-fx-background-color: #eaeaea;">




<center>
<Label alignment ="CENTER" prefWidth ="215" text ="메인 화면" />
</center>

<right>
<Button fx:id ="btnLogin" text ="로그인"/>
</right>
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
</BorderPane>
</top>

<center>
<VBox style ="-fx-background-color: #0000ff;">
</VBox>
</center>
</BorderPane>
</children>
</StackPane>





>>> RootController.java


package sec12.exam01_stackpane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {
@FXML private Button btnLogin;

@Override
public void initialize(URL location, ResourceBundle resources) {
btnLogin.setOnAction(e->handleBtnLogin(e));

}

public void  handleBtnLogin(ActionEvent event) {
try {
Parent login =  FXMLLoader.load(getClass().getResource("login.fxml"));
StackPane root  =  (StackPane) btnLogin.getScene().getRoot();
root.getChildren().add(login);
} catch(Exception e) {
e.printStackTrace();
```

로그인 화면으로 이동

}

}

}

>>> login.xml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>






<?import javafx.geometry.*?>

<BorderPane  xmlns:fx ="http://javafx.com/fxml"
fx:id ="login" prefHeight ="500" prefWidth ="350"
fx:controller ="sec12.exam01_stackpane.LoginController">
<top>
<BorderPane style ="-fx-background-color: #eaeaea;">
<left>
<Button fx:id ="btnMain" text ="메인"/>
</left>
<center>
<Label alignment ="CENTER" prefWidth ="215" text ="로그인 화면" />
</center>
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
</BorderPane>
</top>

<center>
<VBox style ="-fx-background-color: #ffff00;">
</VBox>
</center>
</BorderPane>




>>> LoginController.java


package sec12.exam01_stackpane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable {
@FXML private BorderPane login;
@FXML private Button btnMain;

@Override
public void initialize(URL location, ResourceBundle resources) {
btnMain.setOnAction(e -> handleBtnMain(e));

}

public void handleBtnMain(ActionEvent event) {
try {
StackPane root  =  (StackPane) btnMain.getScene().getRoot();
root.getChildren().remove(login);
} catch (Exception e) {
e.printStackTrace();
```

StackPane에서 로그인 화면
제거, 메인 화면으로 이동

}

}

}

>>> AppMain.java


```java
package sec12.exam01_stackpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;




import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
primaryStage.setTitle("AppMain");
Parent root =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
primaryStage.setScene(scene);
primaryStage.setWidth(350);
primaryStage.setHeight(500);
primaryStage.setResizable(false);
primaryStage.show();
```

//윈도우의 고정 폭 설정
//윈도우의 고정 높이 설정
//윈도우 크기를 조정할 수 없도록 함

}

public static void main(String[] args) {
launch(args);

}

}

애니메이션

JavaFX에서 애니메이션은 컨트롤 또는 컨테이너의 속성Property 변화를 주어진 시간 동안 진행함으

로써 구현한다. 다음은 애니메이션과 관련된 클래스를 설명한 표이다.

클래스

KeyValue

KeyFrame

Timeline

설명

값이 변경될 타겟 Property와 종료값을 설정하는 객체

애니메이션의 지속 시간과 KeyValue를 설정하는 객체
(지속시간 동안 타겟 Property의 값을 종료값까지 변화시킴)

KeyFrame에 설정된 내용대로 애니메이션을 플레이하는 객체

다음은 컨테이너의 translateX 속성을 주어진 종료값까지 변화시켜 수평 방향으로 슬라이드하는 애

니메이션을 구현한 코드이다. 종료값은 x 좌표값으로 음수, 0, 양수 값을 모두 가질 수 있다.




(cid:733) Timeline timeline  =  new Timeline();
(cid:734) KeyValue keyValue  =  new KeyValue(컨테이너.translateXProperty(), 종료값);
(cid:735) KeyFrame keyFrame  =  new KeyFrame(Duration.millis(지속시간), keyValue);
(cid:736) timeline.getKeyFrames().add(keyFrame);
(cid:737) timeline.play();    //(cid:2455)니메이션 시작

다음 코드는 이전 예제의 [로그인] 버튼 이벤트 처리 메소드를 수정한 것으로, 로그인 화면이 나올 때

우측에서 좌측으로 수평 애니메이션이 진행되도록 했다.

>>> RootController.java


```java
package sec12.exam02_move_animation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController implements Initializable {
@FXML private Button btnLogin;

@Override
public void initialize(URL location, ResourceBundle resources) {
btnLogin.setOnAction(e->handleBtnLogin(e));

}

public void  handleBtnLogin(ActionEvent event) {
try {
Parent login =  FXMLLoader.load(getClass().getResource("login.fxml"));





StackPane root  =  (StackPane) btnLogin.getScene().getRoot();
root.getChildren().add(login);
```

//로그인 화면의 x 좌표를 350(윈도우 폭) 만(cid:3072) 이동(안보이게 하기 위해서)
login.setTranslateX(350);

//Timeline 객체 생성
Timeline timeline  =  new Timeline();
//로그인 화면의 x 좌표 종료값으로 0을 설정
KeyValue keyValue  =  new KeyValue(login.translateXProperty(), 0);
//0.1초간 종료값까지 x 좌표를 변화시키도록(0 <-- 350) KeyFrame 생성
KeyFrame keyFrame  =  new KeyFrame(Duration.millis(100), keyValue);
//Timeline에 KeyFrame 추가
timeline.getKeyFrames().add(keyFrame);
//(cid:2455)니메이션 시작
timeline.play();
} catch(Exception e) {
e.printStackTrace();

}

}

}




KeyFrame은 지속시간 동안 속성을 종료값까지 변화시키고 나서 콜백 메소드를 자동 호출하는 기

능이 있다. KeyFrame을 생성할 때 두 번째 매개값으로 EventHandler<ActionEvent> 객체를

제공해주면 애니메이션이 종료될 때 handle ( ) 메소드가 자동 실행된다.

KeyFrame keyFrame  =  new KeyFrame(
Duration.millis(지속시간),
new EventHandler<ActionEvent>() {
```java
@Override
public void handle(ActionEvent event) {
//(cid:2455)니메이션이 종료된 후 실행할 코드

}

},
keyValue

);
```

애니메이션이 종료되면 발생되는

이벤트를 처리하는 핸들러 지정

다음 코드는 이전 예제에서 로그인 화면의 [메인] 버튼 이벤트 처리 메소드를 수정한 것으로, 로그인

화면이 사라질 때 좌측에서 우측으로 수평 애니메이션이 진행되도록 했다. 그리고 애니메이션을 종

료한 후에는 StackPane에서 로그인 화면을 완전히 제거한다.

>>> LoginController.java

```java
package sec12.exam02_move_animation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;




public class LoginController implements Initializable {
@FXML private BorderPane login;
@FXML private Button btnMain;

@Override
public void initialize(URL location, ResourceBundle resources) {
btnMain.setOnAction(e -> handleBtnMain(e));

}

public void handleBtnMain(ActionEvent event) {
try {
StackPane root  =  (StackPane) btnMain.getScene().getRoot();
```

//로그인 화면의 x 좌표를 0으로 이동시켜놓음(원래 0(cid:2640))
login.setTranslateX(0);

//Timeline 객체 생성
Timeline timeline  =  new Timeline();
//로그인 화면의 x 좌표 종료값으로 350을 설정
KeyValue keyValue  =  new KeyValue(login.translateXProperty(), 350);
//0.1초간 종료값까지 x 좌표를 변화시키도록(0 --> 350) KeyFrame 생성
KeyFrame keyFrame  =  new KeyFrame(
Duration.millis(100),
new EventHandler<ActionEvent>() {
```java
@Override
public void handle(ActionEvent event) {
//(cid:2455)니메이션이 종료된 후, StackPane에서 로그인 화면 제거
root.getChildren().remove(login);

}
},
keyValue

);
//Timeline에 KeyFrame 추가
timeline.getKeyFrames().add(keyFrame);
//(cid:2455)니메이션 시작
timeline.play();
} catch (Exception e) {
e.printStackTrace();

}

}

}


```

## 13. JavaFX 과제

지금까지 학습한 내용을 기반으로 5가지 과제를 수행해 보자.

과제 1

학생들의 점수를 보여주는 애플리케이션의

메인 윈도우를 다음과 같이 만든다.

생성해야 할 파일과 역할은 다음 표와 같다.

파일명

AppMain.java

root.fxml

RootController.java

역할

메인 클래스

메인 윈도우 레이아웃

컨트롤러 클래스

root.fxml의 루트 태그는 BorderPane 컨테이너로 작성한다. 중앙에는 TableView를 배치하고

하단에는 HBox를 배치한다. 그리고 HBox에는 [추가] 버튼을 배치한다. TableView에는 이름,

국어, 수학, 영어 컬럼을 추가한다.


과제 2

과제 1에 이어서 메인 윈도우에서 [추가] 버

튼을 클릭하면 학생 정보 추가 다이얼로그

가 다음과 같이 실행되도록 만든다.

생성해야 할 파일과 역할은 다음 표와 같다.

파일명

form.fxml

역할

학생 정보 추가 다이얼로그 레이아웃

form.fxml의 루트 태그는 BorderPane 컨테이너로 작성한다. 중앙에는 GridPane 컨테이너를

배치하고 네 개의 Label과 네 개의 TextField를 배치한다. 하단에는 HBox를 배치하고 [저장], [취

소] 버튼을 배치한다. 그리고 학생 정보 추가 다이얼로그에서 [취소] 버튼을 클릭하면 다이얼로그가

닫히도록 이벤트 처리한다.

과제 3

과제 2에 이어서 학생 정보 추가 다이얼로그에서 정보를 입력하고 [저장] 버튼을 클릭하면 메인 윈도

우의 TableView에 행이 추가되도록 한다.



생성해야 할 파일과 역할은 다음 표와 같다.

파일명

Student.java

과제 4

역할

테이블 행의 데이터를 가지고 있는 모델 클래스

과제 3에 이어서 메인 윈도우 하단에 [학생별 막대 그래프] 버튼을 추가하고, 이 버튼을 클릭하면 다

음 그림과 같이 막대 그래프 다이얼로그가 실행되도록 한다.

생성해야 할 파일과 역할은 다음 표와 같다.

파일명

barchart.fxml

역할

막대 그래프 다이얼로그의 레이아웃

barchart.fxml의 루트 태그는 BorderPane 컨테이너로 작성한다. 중앙에는 BarChart를 배치하

고 하단에는 HBox를 배치한다. 그리고 HBox에는 [닫기] 버튼을 배치한다. [닫기] 버튼을 클릭하

면 막대 그래프 다이얼로그가 닫히도록 이벤트 처리를 한다.

과제 5

과제 4에 이어서 메인 윈도우의 TableView에서 한 행을 더블 클릭하면 오른쪽 그림과 같이 해당

학생의 과목 점수를 보여주는 파이 그래프 다이얼로그가 실행되도록 한다.


생성해야 할 파일과 역할은 다음 표와 같다.

파일명

piechart.fxml

역할

파이 그래프 다이얼로그의 레이아웃

piechart.fxml의 루트 태그는 BorderPane 컨테이너로 작성한다. 중앙에는 PieChart를 배치하

고 하단에는 HBox를 배치한다. 그리고 HBox에는 [닫기] 버튼을 배치한다. [닫기] 버튼을 클릭하

면 파이 그래프 다이얼로그가 닫히도록 이벤트 처리한다.

TableView의 setOnMouseClicked ( ) 메소드로 마우스 이벤트 핸들러를 등록하고, 이벤트 핸들

러에서 MouseEvent의 getClickCount ( ) 메소드가 2를 리턴할 경우(더블 클릭)에만 파이 그래

프 다이얼로그가 실행되도록 한다.




