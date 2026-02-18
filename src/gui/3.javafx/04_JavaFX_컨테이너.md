# 04. JavaFX 컨테이너

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

