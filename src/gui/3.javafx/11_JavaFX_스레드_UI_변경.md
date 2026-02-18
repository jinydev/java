# 11. JavaFX 스레드 UI 변경

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

