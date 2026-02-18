# 03. JavaFX 레이아웃

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

