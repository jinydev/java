# 09. JavaFX 다이얼로그

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

