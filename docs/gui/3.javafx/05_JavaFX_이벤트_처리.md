# 05. JavaFX 이벤트 처리

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

