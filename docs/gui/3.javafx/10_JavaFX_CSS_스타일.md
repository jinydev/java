# 10. JavaFX CSS 스타일

JavaFX UI를 담당하는 컨테이너 및 컨트롤은 CSSCascading Style Sheets를 적용해서 모양 및 색상 등을

변경할 수 있다. 이것은 HTML에 CSS를 적용하는 것과 유사하다. 다음은 JavaFX 애플리케이션에

CSS를 적용하면 UI 스킨이 어떻게 달라지는지 보여준다.





JavaFX CSS는 W3C CSS 버전 2.1 스펙(http://www.w3.org/TR/CSS21 )에 따르기 때문

에 CSS로 HTML 문서의 스타일을 작성해 본 개발자는 쉽게 JavaFX CSS를 정의할 수 있다. 단,

JavaFX CSS의 속성명은 W3C CSS 속성명 앞에 “-fx-”가 더 붙는 것이 차이점이다.

JavaFX 컨트롤의 기본 CSS는 modena.css 파일에 작성되어 있다. 이 파일은 javax.controls.jar

모듈에 포함되어 있다.

com/sun/javafx/scene/control/skin/modena/modena.css

커스텀 CSS는 기본 CSS의 속성값을 변경하거나 새로운 속성을 정의한 것을 말한다. 커스텀 CSS

를 적용하는 방법에는 컨테이너 또는 컨트롤을 정의할 때 직접 설정하는 인라인 스타일 방식과 외부

CSS 파일을 생성하고 Scene에 적용하는 방식이 있다.

인라인 스타일

인라인inline 스타일은 컨테이너 또는 컨트롤의 style 속성값으로 직접 CSS를 작성하는 방식을 말한

다. 작성이 쉬우며 빠르게 모양과 색상을 변경할 수 있다는 장점이 있다.

(cid:29)컨테이너 style = "속성:값; 속성:값; …">
(cid:29)컨트롤 style = "속성:값; 속성:값; …">



다음 예제는 세 개의 Label을 FXML로 선언하고, Label의 style 속성을 이용해서 첫 번째 Label은

배경을 검은색, 글자는 노란색으로 CSS를 적용하고, 두 번째, 세 번째 Label은 배경을 파란색, 글자

는 흰색으로 CSS를 적용했다.

>>> root.fxml





```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import java.lang.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"
prefHeight ="50" prefWidth ="400" alignment ="CENTER" spacing ="20">
<children>
<Label text ="(cid:1128)정바(cid:3092),노(cid:1734)글(cid:2431)"
style ="-fx-background-color: black; -fx-text-fill: yellow;
-fx-padding: 5;"/>
<Label text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"
style ="-fx-background-color: blue; -fx-text-fill: white;
-fx-padding: 5;"/>
<Label text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"
style ="-fx-background-color: blue; -fx-text-fill: white;
-fx-padding: 5;"/>
</children>
</HBox>

>>> AppMain.java

package sec10.exam01_inline;







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

외부 CSS 파일

인라인 스타일은 컨테이너와 컨트롤의 style 속성으로 CSS를 직접 적용하기 때문에 동일한 스타일

을 적용하는 컨테이너와 컨트롤이 많아질수록 중복 코드가 늘어나는 단점이 있다. 또한 레이아웃

FXML과 CSS가 뒤섞여 유지보수가 어렵다.

인라인 스타일보다는 외부 CSS 파일 방식을 사용하면 중복 CSS 작성을 줄이고 재사용성을 높이면

서 유지보수도 편리해진다. 외부 CSS 파일 방식은 컨테이너와 컨트롤에 사용되는 CSS를 별도 파일

에 작성하고, Scene을 생성할 때 추가하는 방식이다.

여러 가지 장점이 많기 때문에 보통 JavaFX 애플리케이션을 개발할 때는 외부 CSS 파일 방식을 사

용한다. 외부 CSS 파일을 작성하기 위해서는 몇 가지 선택자 문법을 알아야 한다.





1) 선택자

인라인 스타일은 해당 컨테이너 또는 컨트롤에 직접 스타일을 적용하기 때문에 선택자가 필요없지만,

외부 CSS 파일은 스타일을 적용할 컨테이너와 컨트롤을 선택해주는 선택자가 필요하다. 다음은 선

택자를 작성하는 방법을 보여준다.

선택자 {
속성:값; 속성:값; …

}

선택자는 중괄호 { }에 정의된 CSS 속성을 적용할 컨테이너 또는 컨트롤을 선택하는 역할을 하는데,

다음 세 가지가 있다.

선택자

Type 선택자

id 선택자

class 선택자

작성 방법

Type { 속성:값; 속성:값; .. }

#id { 속성:값; 속성:값; … }

.class { 속성:값; 속성:값; … }

Type 선택자는 같은 타입의 컨테이너 또는 컨트롤을 모두 선택한다. 예를 들어 모든 Label 컨트롤

의 안쪽 여백을 5만큼 주고 싶다면 다음과 같이 정의하면 된다.

Label {
-fx-padding: 5;

}

<Label …>
<Label …>

#id 선택자는 동일한 id 속성값을 가지고 있는 컨테이너 또는 컨트롤을 선택한다. 예를 들어 id 속성

값이 lblId인 Label의 배경을 검은색으로, 글자를 노란색으로 설정하고 싶다면 다음과 같이 정의하

면 된다.

#lblId {
-fx-background-color: black;
-fx-text-fill: yellow;

}


<Label id = "lblId">

.class 선택자는 동일한 styleClass 속성값을 가지고 있는 컨테이너 또는 컨트롤을 선택한다. 예를

들어 styleClass 속성값이 lblClass인 Label의 배경을 파란색으로, 글자를 흰색으로 설정하고 싶다

면 다음과 같이 정의하면 된다.

#lblId {
-fx-background-color: black;
-fx-text-fill: yellow;

}

<Label styleClass = "lblClass">
<Label styleClass = "lblClass">

FXML 파일에서 id 속성은 유일한 값을 가져야 하지만, styleClass 속성은 중복된 값을 가질 수 있

다. 이 말은 id 선택자는 하나의 컨트롤만 선택할 수 있는 반면, class 선택자는 동시에 여러 컨트롤

을 선택할 수 있다는 뜻이다.

Type 선택자와 class 선택자는 조합이 가능하다. 예를 들어 Label 컨트롤 중에서 styleClass=

"className"을 가진 것만 CSS를 적용하고 싶다면 다음과 같이 정의하면 된다. 만약 Button 컨트

롤이 styleClass="className"을 가지고 있다면 CSS는 적용되지 않는다.

Label.className {
-fx-background-color: blue;
-fx-text-fill: white;

}

컨트롤은 세 가지 상태를 가질 수 있다. 입력 가능한 상태(focused ), 마우스가 위에 있는 상태

(hover ), 마우스로 클릭한 상태(pressed )를 말하는데, 각 상태에 따라 스타일을 다르게 적용하

고 싶다면 선택자 다음에 :focused, :hover, :pressed를 붙이면 된다. 이러한 것들을 유사 클래스

(pseudo-class )라고 한다.

상태

입력 가능한 상태

상태별 선택자

선택자:focused { 속성:값; 속성:값; … }

마우스가 컨트롤 위에 있는 상태

선택자:hover { 속성:값; 속성:값; … }

마우스로 컨트롤을 누른 상태

선택자:pressed { 속성:값; 속성:값; … }



2) CSS 파일 적용

이렇게 작성된 외부 CSS 파일은 개별 컨테이너 또는 컨트롤에 적용하거나 Scene에 추가하여 Scene

내부의 모든 컨테이너와 컨트롤에 적용할 수 있다.

개별 컨테이너 또는 컨트롤에 CSS 파일을 적용하려면 다음과 같이 FXML 파일에서 해당 태그의

stylesheets 속성으로 CSS 파일 경로를 지정하면 된다.

(cid:29)컨테이너 stylesheets =  "@app.css">

Scene 내부의 모든 컨테이너와 컨트롤에 적용하려면 Scene의 getStylesheets ( ) 메소드로

ObservableList를 얻고, 여기에 CSS 파일 경로를 추가한다. CSS 파일은 메인 클래스와 동일한 경

로에서 흔히 작성되므로 다음과 같이 CSS 파일 경로를 얻어 추가하면 된다.

```java
public class AppMain extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
Parent root  =  FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene  =  new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());
primaryStage.setScene(scene);
primaryStage.show();

}

…

}
```

다음 예제는 외부 CSS 파일을 이용해서 Label들의 배경색과 글자색을 변경한다. root.xml에서 첫

번째 Label에는 id 속성이 있고, 두 번째와 세 번째 Label에는 styleClass 속성이 있다는 것을 주

목하자. 이들 속성을 이용해서 선택자를 작성한다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>



<?import javafx.scene.control.*?>
<?import java.lang.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"
prefHeight ="50" prefWidth ="400" alignment ="CENTER" spacing ="20">
<children>
<Label id ="lblId" text ="(cid:1128)정바(cid:3092),노(cid:1734)글(cid:2431)"/>
<Label styleClass ="lblClass" text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"/>
<Label styleClass ="lblClass" text ="파(cid:1734)바(cid:3092),흰글(cid:2431)"/>
</children>
</HBox>
```

CSS의 주석은 /*로 시작해서 */로 끝난다.
자바처럼 // 주석은 사용할 수 없다.

>>> app.css


/* 전체 Label 선택 */
Label {
-fx-padding: 5;

}

/* id = "lblId"을 가(cid:2771) 컨트롤 선택 */
#lblId {
-fx-background-color: black;
-fx-text-fill: yellow;

}

/* styleClass = "lblClass"을 가(cid:2771) 컨트롤 선택 */
.lblClass {
-fx-background-color: blue;
-fx-text-fill: white;

}



>>> AppMain.java


```java
package sec10.exam02_css_file;

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
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

다음 예제는 TextField와 Button 컨트롤의 상태에 따라서 스타일을 변경한다. TextField가 입력

가능한 상태가 되면 배경을 노란색으로, 마우스가 Button 위에 있으면 배경을 노란색 그리고 클릭

하면 빨간색으로 변경한다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>





<?import javafx.scene.control.*?>

<HBox xmlns:fx ="http://javafx.com/fxml" spacing ="10">
<padding>
<Insets topRightBottomLeft ="10"/>
</padding>

<children>
<TextField prefWidth ="200"/>
<Button prefWidth ="50" text ="확인"/>
</children>
</HBox>

>>> app.css


TextField:focused {
-fx-border-color: skyblue;
-fx-background-color: yellow;

}

Button:hover {
-fx-border-color: skyblue;
-fx-background-color: yellow;

}

Button:pressed {
-fx-border-color: skyblue;
-fx-background-color: red;

}



>>> AppMain.java


package sec10.exam03_state_selector;

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
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

border 속성

border 속성은 컨테이너 및 컨트롤의 경계선 스타일을 설정한다. 다음과 같이 경계선의 굵기, 색상,

스타일, 내부 경계선의 위치를 설정할 수 있는 세부 속성들이 있다.

속성

-fx-border-color

설명

경계선의 색상

-fx-border-insects

내부 경계선의 위치

-fx-border-radius

둥근 모서리를 위한 원의 반지름




-fx-border-style

-fx-border-width

경계선의 스타일(실선, 점선)

경계선의 굵기

-fx-border-color 속성은 경계선의 색상을 설정하는데, 다음과 같은 다양한 값들을 사용할 수

있다.

-fx-border-color: red;
-fx-border-color: #ff0000;
-fx-border-color: rgba(255,0,0,0);

//색이름

//(cid:4)색상번호
//rgba(red값, green값, blue값, 투명도)

rgba ( ) 함수의 red, green, blue는 0~255 값을 가질 수 있고, 투명도는 0.0 (투명)~1.0 (불투명)

값을 가진다. 다음은 경계선을 빨간색으로, 굵기를 1픽셀로 설정한 것이다.

-fx-border-color: red;
-fx-border-width: 1;

-fx-border-radius 속성은 원의 반지름을 설정해서 둥근 모서리를 만든다.

-fx-border-color: red;
-fx-border-width: 1;
-fx-border-radius: 20;

JavaFX 컨테이너 및 컨트롤은 바깥 경계선 외에 내부 경계선을 여러 개 정


의할 수 있다. -fxborder-insets 속성으로 경계선이 나타날 깊이를 쉼표

로 구분해서 나열하면 다른 속성들도 경계선의 개수에 맞게 굵기, 색상, 스

타일을 지정할 수 있다. 다음은 3개의 경계선을 정의하고 각각 색상 및 굵기



를 설정한 것이다.



-fx-border-insets: 0, 10, 20;
-fx-border-color: red, green, blue;
-fx-border-width: 1, 1, 1;

경계선은 top, right, bottom, left별로 굵기, 색상, 스타일을 지정할 수 있다. 값의 순서는 top부터

시작해 시계 방향으로 top, right, bottom, left로 나열해주면 된다. 다음은 두 번째 경계선 top,

bottom의 색상을 녹색으로 설정하고, 세 번째 경계선 right, bottom의 굵기를 3으로 설정한 것

이다.

-fx-border-insets: 0, 10, 20;
-fx-border-color: red, green white green white, blue;
-fx-border-width: 1, 1, 1 3 3 1;

-fx-border-style 속성은 실선과 점선을 설정하는데, solid (실선), dotted (점선), dashed (대

시선)와 선의 길이 및 공백을 설정할 수 있는 segments ( )를 값으로 줄 수 있다. segments ( )의

매개값은 홀수 번째 값은 선의 길이를, 짝수 번째 값은 공백의 길이를 주면 된다. 다음은 바깥 경계

선의 top, right, bottom, left를 다른 스타일로 설정한 것이다.

-fx-border-color: red;
-fx-border-width: 2;
-fx-border-style: solid dotted dashed segments(3, 2, 8, 2);

다음 예제는 FXML로 네 개의 VBox를 배치하고 border 속성을 다르게 적용하였다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import java.lang.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>



<HBox xmlns:fx ="http://javafx.com/fxml" spacing ="20">
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
<children>
<VBox id ="vbox1" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox2" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox3" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox4" prefHeight ="100" prefWidth ="100"/>
<VBox id ="vbox5" prefHeight ="100" prefWidth ="100"/>
</children>
</HBox>

>>> app.css


#vbox1 {
-fx-border-color: red;
-fx-border-width: 1;

}

#vbox2 {
-fx-border-color: red;
-fx-border-width: 1;
-fx-border-radius: 20;

}

#vbox3 {
-fx-border-insets: 0, 10, 20;




-fx-border-color: red, green, blue;
-fx-border-width: 1, 1, 1;

}

#vbox4 {
-fx-border-insets: 0, 10, 20;
-fx-border-color: red, green white green white, blue;
-fx-border-width: 1, 1, 1 3 3 1;

}

#vbox5 {
-fx-border-color: red;
-fx-border-width: 2;
-fx-border-style: solid dotted dashed segments(3, 2, 8, 2);

}

>>> AppMain.java

package sec10.exam04_border;

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
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}






public static void main(String[] args) {
launch(args);

}

}
```

background 속성

background 속성은 컨테이너 및 컨트롤의 배경 스타일을 설정한다. 다음과 같이 배경 색상, 배경

이미지를 설정할 수 있는 세부 속성들이 있다.

속성

-fx-background-color

-fx-background-image

설명

배경 색상

배경 이미지

-fx-background-position

배경 이미지 위치(top, right, bottom, left, center)

-fx-background-repeat

이미지 반복 여부(no-repeat: 반복하지 않음)

-fx-background-color 속성은 배경 색상을 설정하는데, 단일 색상을 지정하는 방법은 다음과

같다.

-fx-background-color: red;
-fx-background-color: #ff0000;
-fx-background-color: rgba(255,0,0,0);

//색 이름
//(cid:4)색상 번호
//rgba(red값, green값, blue값, 투명도)

-fx-background-color에는 단일 색상뿐만 아니라 선형 및 원형 그라디언트도 설정할 수 있다.

선형 그라디언트는 시작 색에서부터 끝 색까지 진행 방향으로 서서히 색상 변화를 준다. 선형 그라디

언트를 작성하는 방법은 다음과 같다.

linear-gradient(to (cid:2771)행방(cid:3313), 시작색 S%, 중간색 M%…, (cid:1368)색);



진행 방향은 to bottom, to right, to bottom right 등과 같이 밑으로, 오른쪽으

로, 대각선으로 지정할 수 있다. 각각의 색은 몇 % 정도가 나올지 S, M 값으로 지

정할 수 있다. 단, 끝 색은 % 값을 줄 수 없다. % 값이 생략되면 균등하게 색상이 나

온다. 오른쪽 그림은 다음과 같이 작성된 선형 그라디언트가 적용된 것이다.

-fx-background-color: linear-gradient(to right, black, white);

원형 그라디언트는 시작 색에서부터 끝 색까지 원형으로 서서히 색상 변화를 준다. 원형 그라디언트

를 작성하는 방법은 다음과 같다.

radial-gradient(center X% Y%, radius R%, 시작색 S%, 중간색 M%, (cid:1368)색);

X%와 Y%는 컨테이너 및 컨트롤의 좌상단을 0%, 0%로 보고, 원의 중심점이 위치하는 곳을 지정한

다. 예를 들어 center 50% 50%는 원의 정중앙을 중심점으로 설정한다. R%는 중심점에서부터 색상

변화가 종료되는 위치이다. 예를 들어 radius 50%는 컨테이너 및 컨트롤 전체 영

역에 원형 그라디언트를 적용한다. 각각의 색이 몇 % 정도로 나올지 S, M 값으로

지정할 수 있다. 단, 끝 색은 % 값을 줄 수 없다. % 값이 생략되면 균등하게 색상이

나온다. 오른쪽 그림은 다음과 같이 작성된 원형 그라디언트가 적용된 것이다.

-fx-background-color: radial-gradient(center 50% 50%, radius 50%, #ffffff 10%,
#000000);

-fx-background-image 속성은 배경 이미지를 설정한다. 배경 이미지보다 컨테이너 및 컨트롤의

사이즈가 더 크면 이미지는 반복적으로 드로잉된다. 한 번만 드로잉하려면 -fx-backgroundrepeat

속성값을 no-repeat로 설정하면 된다. 그리고 이

미지의 위치는 -fx-backgroundposition으로

설정한다. 다음은 배경 이미지를 설정하는 방법이다.


-fx-background-image: url("이미지 경로");
-fx-background-repeat: no-repeat;
-fx-background-position: center;

//이미지 파일 지정
//한 번만 드로잉하도록 지정
//정중앙에 위치하도록 지정

다음 예제는 6개의 VBox에 차례대로 단색, 선형 그라디언트, 원형 그라디언트, 반복 이미지, 단일

이미지, 정중앙 단일 이미지를 적용했다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>

<HBox xmlns:fx ="http://javafx.com/fxml" spacing ="10">
<padding>
<Insets bottom ="10.0" left ="10.0" right ="10.0" top ="10.0" />
</padding>
<children>
<VBox id ="vbox1" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox2" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox3" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox4" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox5" prefHeight ="100" prefWidth ="100" />
<VBox id ="vbox6" prefHeight ="100" prefWidth ="100" />
</children>
</HBox>



>>> app.css



#vbox1 {
-fx-background-color: rgba(0, 0, 0, 1);

}

#vbox2 {
-fx-background-color: linear-gradient(to right, #000000, #ffffff);

}

#vbox3 {
-fx-background-color: radial-gradient(center 50% 50%, radius 50%,
#ffffff, #000000);

}

#vbox4 {
-fx-border-color: skyblue;
-fx-background-image: url("images/icon.gif");

}

#vbox5 {
-fx-border-color: skyblue;
-fx-background-image: url("images/icon.gif");
-fx-background-repeat: no-repeat;

}

#vbox6 {
-fx-border-color: skyblue;
-fx-background-image: url("images/icon.gif");
-fx-background-repeat: no-repeat;
-fx-background-position: center;

}

>>> AppMain.java


package sec10.exam05_background;

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
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

font 속성

font 속성은 글자의 스타일을 설정한다. 여기에는 폰트의 크기, 종류, 굵기, 색상 등을 설정할 수 있

는 다음과 같은 세부 속성들이 있다.

속성

-fx-font-size

-fx-font-family

-fx-font-weight

-fx-text-fill

설명

폰트 크기

폰트 종류

폰트 굵기(bold)

폰트 색상(단색, 선형 그라디언트, 원형 그라디언트)

다음 예제는 Label 컨트롤의 폰트를 설정한다. 폰트 종류는 Arial Black, 크기는 35, 굵게, 색상은

선형 그라디언트를 적용했다.





>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>

<VBox id ="root" xmlns:fx ="http://javafx.com/fxml" >
<children>
<Label id ="welcome-text" text ="Welcome" />
</children>
</VBox>

>>> app.css


#root {
-fx-padding: 10;

}

#welcome-text {
-fx-font-size: 35;
-fx-font-family: "Arial Black";
-fx-font-weight: bold;
-fx-text-fill: linear-gradient(to bottom, blue, white);

}


>>> AppMain.java


package sec10.exam06_font;

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
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

shadow 효과

JavaFX  CSS는  그림자  효과를  주기  위한  -fx-effect  속성을  제공한다.  속성값으로는

dropshadow ( )와 innershadow ( )를 줄 수 있는데, dropshadow ( )는 바깥 그림자를 주어 튀

어 나오는 느낌을 주고, innershadow ( )는 안쪽 그림자를 주어 움푹 들어간 느낌을 준다.





-fx-effect 속성을 작성하는 방법은 다음과 같다.

-fx-effect: dropshadow(three-pass-box , 그림자색상 , radius, spread , offsetX , offsetY);
-fx-effect: innershadow(three-pass-box , 그림자색상 , radius, choke, offsetX, offsetY);

three-pass-box는 blur-type의 종류로 gaussian, one-pass-box, two-pass-box,

three-pass-box 등이 있다. JavaFX는 three-pass-box를 기본으로 사용한다. radius는

blurkernel의 반지름으로 0.0~127.0 사이의 값을 가지는데, 기본값은 10이다. spread와 choke

는 각각 그림자의 spread와 choke로 0.0~1.0 사이의 값을 가지는

offsetX

데, 기본값은 0.0이다. three-pass-box, radius, spread, choke

는 이해하기가 쉽지 않기 때문에 보통은 기본값을 그대로 이용한다.

offsetY

offsetX와 offsetY는 그림자의 편차인데, 오른쪽 그림을 보면 쉽게

이해가 될 것이다.

다음 예제는 두 개의 버튼에 shadow 효과를 주었다. 첫 번째 버튼은 dropshadow ( )를 적용했고

두 번째 버튼은 innershadow ( )를 적용했다.

>>> root.fxml


```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>

<HBox xmlns:fx ="http://javafx.com/fxml"  prefWidth ="300" prefHeight ="150"
spacing ="50" fillHeight ="false" alignment ="CENTER">
<padding>
<Insets topRightBottomLeft ="10"/>
</padding>
<children>
<Button id ="btn1" prefWidth ="100" prefHeight ="50" text ="DropShadow"/>
<Button id ="btn2" prefWidth ="100" prefHeight ="50" text ="InnerShadow"/>
</children>
</HBox>


>>> app.css


#btn1 {
-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.7) , 10, 0 , 5 , 5);

}

#btn2 {
-fx-effect: innershadow(three-pass-box , rgba(0,0,0,0.7) , 10, 0 , 3, 3);

}

>>> AppMain.java


package sec10.exam07_shadow;

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
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");





primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}
```

화면 스킨 입히기

다음 예제에서는 지금까지 학습한 내용을 활용해서 로그인 폼 화면을 만들고 CSS를 적용해서 스킨

을 입혀본다. 이 예제는 오라클의 JavaFX CSS 샘플 예제로 소개된 것이다. 마우스를 버튼 위로 올

리거나 클릭하면 색상 변화를 볼 수 있다

>>> root.fxml




```java
<?xml version ="1.0" encoding ="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<AnchorPane styleClass ="root"  xmlns:fx ="http://javafx.com/fxml"
prefHeight ="194.0" prefWidth ="300.0" >
<children>
<Label id ="welcome-text" layoutX ="40.0" layoutY ="14.0" text ="Welcome" />
<Label layoutX ="42.0" layoutY ="80.0" text ="아이디" />
<Label layoutX ="42.0" layoutY ="118.0" text ="패스워드" />
<TextField layoutX ="120.0" layoutY ="76.0" />
<PasswordField layoutX ="120.0" layoutY ="114.0" />
<Button layoutX ="97.0" layoutY ="158.0" styleClass ="button" text =
"로그인" />
<Button layoutX ="164.0" layoutY ="158.0" styleClass ="button" text =
"취소" />
</children>
</AnchorPane>





>>> app.css


.root {
-fx-background-image: url("images/background.jpg");

}

Label {
-fx-font-size: 12px;
-fx-font-weight: bold;
-fx-text-fill: #333333;

}

#welcome-text {
-fx-font-size: 35px;
-fx-font-family: "Arial Black";
-fx-text-fill: linear-gradient(darkgray, lightgray);
-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 3, 0 , 2 , 2.1 );

}

.button {
-fx-text-fill: white;
-fx-font-family: "Arial Narrow";
-fx-font-weight: bold;
-fx-background-color: linear-gradient(#61a2b1, #2A5058);
-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 10, 0 , 2 , 2 );

}

.button:hover {




-fx-background-color: linear-gradient(#2A5058, #61a2b1);

}

.button:pressed {
-fx-background-color: linear-gradient(yellow, #61a2b1);

}

>>> AppMain.java


package sec10.exam08_login_skin;

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
scene.getStylesheets().add(getClass().getResource("app.css").toString());

primaryStage.setTitle("AppMain");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);

}

}



```

