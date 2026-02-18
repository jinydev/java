# 02. JavaFX 프로젝트 생성 및 실행

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

