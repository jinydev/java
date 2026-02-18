# 07. JavaFX 컨트롤

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

