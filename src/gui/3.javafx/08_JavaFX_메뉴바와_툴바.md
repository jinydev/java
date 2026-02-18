# 08. JavaFX 메뉴바와 툴바

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

