---
layout: gui
title: "07. JavaFX 컨트롤"
---

# 07. JavaFX 컨트롤

JavaFX는 다양한 UI 컨트롤을 제공합니다. 이번 절에서는 사용 빈도가 높은 버튼, 입력, 뷰, 미디어, 차트 컨트롤에 대해 알아봅니다.

---

## 1. 버튼 컨트롤 (Button Controls)

버튼 컨트롤은 마우스로 클릭할 수 있는 컨트롤로, `ButtonBase`를 상속합니다.
- `Button`, `CheckBox`, `RadioButton`, `ToggleButton`, `Hyperlink` 등이 있습니다.

### Button
단순한 텍스트 또는 아이콘을 포함하는 버튼입니다. `setGraphic(ImageView)` 메소드로 아이콘을 넣을 수 있습니다.

```xml
<Button text="아이콘버튼">
    <graphic>
        <ImageView>
            <image>
                <Image url="@images/save.png"/>
            </image>
        </ImageView>
    </graphic>
</Button>
```

### CheckBox
다중 선택이 가능한 체크박스입니다. `selected` 속성으로 선택 상태를 제어합니다.

```xml
<CheckBox text="안경" userData="glasses" />
<CheckBox text="모자" userData="hat" selected="true" />
```

### RadioButton
여러 옵션 중 하나만 선택할 수 있는 라디오 버튼입니다. 같은 `ToggleGroup`으로 묶어야 그룹 내에서 하나만 선택됩니다.

```xml
<VBox>
    <fx:define>
        <ToggleGroup fx:id="group"/>
    </fx:define>
    <children>
        <RadioButton text="옵션1" toggleGroup="$group" />
        <RadioButton text="옵션2" toggleGroup="$group" />
        <RadioButton text="옵션3" toggleGroup="$group" />
    </children>
</VBox>
```

### 이벤트 처리
- **Click Event**: `onAction` 속성이나 `setOnAction()` 메소드 사용.
- **Selection Change Monitor**: `ToggleGroup`의 `selectedToggle` 속성 감시.

```java
group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
    @Override
    public void changed(ObservableValue<? extends Toggle> observable, 
                        Toggle oldValue, Toggle newValue) {
        if (newValue != null) {
            System.out.println("선택된 값: " + newValue.getUserData());
        }
    }
});
```

---

## 2. 입력 컨트롤 (Input Controls)

사용자로부터 데이터를 입력받기 위한 컨트롤입니다.

| 컨트롤              | 설명                                    |
| :------------------ | :-------------------------------------- |
| **`Label`**         | 텍스트 표시 (수정 불가, 주로 제목 용도) |
| **`TextField`**     | 한 줄 텍스트 입력                       |
| **`PasswordField`** | 비밀번호 입력 (입력값 마스킹)           |
| **`TextArea`**      | 여러 줄 텍스트 입력                     |
| **`ComboBox`**      | 드롭다운 목록 선택                      |
| **`DatePicker`**    | 날짜 선택                               |
| **`ColorPicker`**   | 색상 선택                               |
| **`HTMLEditor`**    | HTML 형식의 텍스트 편집                 |

### FXML 선언 예시

```xml
<!-- TextField -->
<TextField fx:id="txtName" promptText="이름을 입력하세요" />

<!-- ComboBox -->
<ComboBox fx:id="comboType" promptText="선택">
    <items>
        <FXCollections fx:factory="observableArrayList">
            <String fx:value="공개" />
            <String fx:value="비공개" />
        </FXCollections>
    </items>
</ComboBox>

<!-- DatePicker -->
<DatePicker fx:id="datePicker" />

<!-- TextArea -->
<TextArea fx:id="txtContent" prefHeight="100.0" />
```

---

## 3. 뷰 컨트롤 (View Controls)

데이터를 목록이나 테이블 형태로 보여주는 컨트롤입니다.

### 1) ImageView
이미지를 보여주는 컨트롤입니다.
- `fitWidth`, `fitHeight`: 이미지 뷰의 크기.
- `preserveRatio`: 이미지 종횡비 유지 여부.

```xml
<ImageView fitWidth="200" fitHeight="150" preserveRatio="true">
    <image>
        <Image url="@images/flower.png"/>
    </image>
</ImageView>
```

### 2) ListView
데이터를 리스트 형태로 보여줍니다.

```xml
<ListView fx:id="listView" prefWidth="100.0" prefHeight="100.0" />
```

**Java 초기화 코드:**
```java
ObservableList<String> items = FXCollections.observableArrayList("Item1", "Item2");
listView.setItems(items);

// 선택 감시
listView.getSelectionModel().selectedItemProperty().addListener(
    (obs, oldVal, newVal) -> System.out.println("선택됨: " + newVal)
);
```

### 3) TableView
데이터를 테이블(행/열) 형태로 보여줍니다. 가장 많이 사용되는 복잡한 컨트롤 중 하나입니다.
- **TableColumn**: 각 열을 정의합니다.
- **Model Class**: 각 행에 들어갈 데이터 클래스 (JavaBean 규약 준수 권장).
- **PropertyValueFactory**: 모델 클래스의 필드와 컬럼을 매핑합니다.

**FXML 구조:**
```xml
<TableView fx:id="tableView">
    <columns>
        <TableColumn text="스마트폰" prefWidth="100" />
        <TableColumn text="이미지" prefWidth="100" />
    </columns>
</TableView>
```

**Controller 초기화:**
```java
@FXML TableView<Phone> tableView;
@FXML TableColumn<Phone, String> colName;
@FXML TableColumn<Phone, String> colImage;

@Override
public void initialize(URL location, ResourceBundle resources) {
    // 컬럼 매핑 (Phone 클래스의 getSmartPhone(), getImage() 호출)
    colName.setCellValueFactory(new PropertyValueFactory<>("smartPhone"));
    colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
    
    // 데이터 추가
    ObservableList<Phone> list = FXCollections.observableArrayList(
        new Phone("Galaxy S24", "phone1.png"),
        new Phone("iPhone 15", "phone2.png")
    );
    tableView.setItems(list);
}
```

---

## 4. 미디어 컨트롤 (Media Controls)

영상이나 오디오를 재생하는 컨트롤입니다. `Media`, `MediaPlayer`, `MediaView` 3가지 클래스가 협력합니다.

```mermaid
graph LR
    File[Media File] --> Media[Media 객체]
    Media --> Player["MediaPlayer (재생 제어)"]
    Player["MediaPlayer (재생 제어)"] --> View["MediaView (화면 출력)"]
```

- **Media**: 미디어 소스 (파일 경로, URL 등).
- **MediaPlayer**: 재생, 일시정지, 정지 등 제어 담당.
- **MediaView**: 비디오 영상을 화면에 보여주는 뷰.

### 예제 코드
```java
// 미디어 소스 로드
Media media = new Media(getClass().getResource("media/video.mp4").toString());

// 플레이어 생성
MediaPlayer mediaPlayer = new MediaPlayer(media);

// 뷰에 플레이어 연결
bindingMediaView.setMediaPlayer(mediaPlayer);

// 재생
mediaPlayer.play();
```

---

## 5. 차트 컨트롤 (Chart Controls)

JavaFX는 다양한 차트를 제공합니다. (`javafx.scene.chart` 패키지)
- `PieChart`, `LineChart`, `BarChart`, `AreaChart`, `BubbleChart`, `ScatterChart`, `StackedBarChart`, `StackedAreaChart`

### PieChart 예제
```xml
<PieChart fx:id="pieChart" />
```

```java
ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
    new PieChart.Data("A", 10),
    new PieChart.Data("B", 30),
    new PieChart.Data("C", 60)
);
pieChart.setData(pieData);
```

### BarChart 예제
XY축이 있는 차트는 `XYChart.Series`와 `XYChart.Data`를 사용합니다.

```java
XYChart.Series series = new XYChart.Series();
series.setName("2024");
series.getData().add(new XYChart.Data("속성1", 100));
series.getData().add(new XYChart.Data("속성2", 200));

barChart.getData().add(series);
```
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

