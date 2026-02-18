# 06. JavaFX 속성 감시와 바인딩

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

