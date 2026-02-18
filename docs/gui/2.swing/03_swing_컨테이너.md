# 03. Swing 컨테이너

윈도우 창과 같이 버튼, 라디오, 체크박스, 텍스트 필드 등의 컴포넌트를 배치할 수 있는 클래스를 컨

테이너라고 합니다. Swing은 기능에 따라 컨테이너 클래스를 다음과 같이 제공합니다.

컨테이너 클래스

용도

JDesktopPane

내부 윈도우를 여러 개 포함할 수 있는 MDI 프로그램을 만들 때 사용

JDialog

JFrame

다이얼로그 윈도우를 만들 때 사용

작업 표시줄, 메뉴가 제공되는 윈도우를 만들 때 사용

JInternalFrame

JDesktopPane에 포함되는 내부 윈도우를 만들 때 사용

JPanel

JScrollPane

JSplitPane

컴포넌트들을 배치할 때 사용

수직 또는 수평 스크롤이 필요할 때 사용

수직 또는 수평으로 보여주는 크기를 조절할 때 사용

JTabbedPane

여러 가지 탭을 제공할 때 사용

JWindow

작업 표시줄, 메뉴가 없는 윈도우를 만들 때 사용

JWindow, JFrame, JDialog는 완전한 윈도우 창 형태를 갖고 있는 최상위 레벨 컨테이너TopLevel

Containers입니다. 이들을 제외한 나머지는 최상위 레벨 컨테이너의 내부에서 사용되는 보조 컨테이너들

입니다.

JFrame

JTabbedPane

JDesktopPane

JInternalFrame

JScrollPane



Swing 컨테이너 구조

JWindow, JFrame, JDialog, JInternalFrame 컨테이너는 다른 컨테이너와 달리 기본 판Root Pane

위에 다음과 같이 여러 겹의 판Pane으로 구성되어 있습니다.

JWindow

JFrame

JDialog

JInternalFrame

Menu Bar

Layered Pane

Glass Pane

Root Pane

Content Pane

1) GlassPane

GlassPane은 다른 패널 위에 존재하면서 기본적으로 숨겨져 있는 투명한 판입니다. GlassPane에

대한 이해를 돕기 위해 책과 함께 제공되는 소스에서

GlassPaneDemo.java를 찾아 이클립스에서 실행

해 보자.

GlassPaneDemo 대화상자에서 Glass pane “visible”의 체크박스에 체크하지 않은 상태에서는

다른버튼을 클릭할 수 있지만 체크하면 GlassPane이 최상판이 되어 바로 밑에 있는 버튼과 메뉴들

을 사용할 수 없습니다. 대신 GlassPane에 그려지는 동그란 빨간 점만 볼 수 있습니다. 마치 유리로 덮여있

는 진열대에서 유리 속의 물건을 만질 수 없는 이치와 같다.

2) JMenuBar와 ContentPane

JMenuBar는 메뉴가 포함되는 판이고, 그 아래쪽에 있는 ContentPane은 버튼과 같은 UI 컴포

넌트가 배치되는 판입니다. ContentPane과 JMenuBar에 대한 이해를 돕기 위해 예제 소스에서

ContentPaneDemo.java를 찾아 이클립스에서 실행해 보자.



JMenuBar

ContentPane

JMenuBar는 JFrame의 setJMenuBar ( ) 메소드로 추가할 수 있습니다. 하지만 버튼과 같은 UI 컴포넌

트는 JWindow, JFrame, JDialog, JInternalFrame에 직접 배치할 수 없고 getContentPane ( )

메소드를 이용해서 ContentPane을 얻은 후에 배치해야 합니다.

다음 코드는 JFrame에서 JMenuBar를 추가하고, ContentPane 남쪽에 JButton을 배치합니다.

JFrame jFrame  =  new JFrame();

//MenuBar 추가
jFrame.setJMenuBar(new JMenuBar());

//컴포넌트 추가
jFrame.getContentPane().add(new JButton("확인"), BorderLayout.SOUTH);

3) LayeredPane

여러 컴포넌트들이 겹쳐질 때 각 컴포넌트의 상하 위치를 결

정합니다. LayeredPane에 대한 이해를 돕기 위해 예제 소스

에서 LayeredPaneDemo.java를 찾아 이클립스에서 실행

해 보자.

손 흔드는 듀크duke에 마우스를 올려 놓으면 듀크가 마우스

를 따라 움직인다. 듀크를 Yellow, Magenta, Cyan 영역

에 갖다 놓으면 잘 보이지만, Red, Green 영역에 갖다 놓

으면 가려진다. 듀크가 Cyan 레이어 위에 위치하기 때문이

다. 드롭다운 리스트에서 듀크의 위치를 변경해 보면 레이어

개념을 알 수 있을 것입니다.



JWindow

JWindow는 윈도우 경계선, 제목 표시줄, 메뉴바가 모두 없는 윈도우를 만드는 컨테이너로, 컴포

넌트만 배치할 수 있는 평면 공간만을 갖는다. 게임 애플리케이션처럼 제목 표시줄이 없는 윈도우를

만들 때 주로 이용됩니다.

새로운 개발자 정의 윈도우는 다음과 같이 JWindow를 상속해서 만들 수 있습니다.

```java
public class JWindowExample extends JWindow {
public JWindowExample() {
this.setSize(450, 300);
}

}
```

윈도우는 반드시 폭width과 높이height가 있어야 하기 때문에 생성자에서 setSize ( ) 메소드로 폭과 높

이를 주면 됩니다. 윈도우를 화면 중앙에 띄우기 위해서는 화면의 중앙 지점을 얻어서 윈도우의 좌측

상단 모서리의 좌표를 계산해야 합니다.

(centerPoint.x ­ width/2, centerPoint.y -height/2 )

width/2

height/2

JWindow

중앙  지점
(centerPoint.x, centerPoint.y )



다음은 JWindow를 화면 중앙에 띄우기 위해 필요한 코드들입니다.

GraphicsEnvironment ge  =  GraphicsEnvironment.getLocalGraphicsEnvironment();
Point centerPoint  =  ge.getCenterPoint();
int leftTopX  =  centerPoint.x - getWidth()/2;
int leftTopY  =  centerPoint.y - getHeight()/2;
this.setLocation(leftTopX, leftTopY);

java.awt.GraphicsEnvironment는 그래픽 환경에 대한 정보를 가지고 있는 객체입니다. 이 객체는

정적static 메소드인 getLocalGraphicsEnvironment ( )를 호출해서 얻을 수 있습니다.

GraphincsEnvironment의 getContentPoint ( ) 메소드는 화면 중앙 지점의 X좌표와 Y좌표를

가지고 있는 Point 객체를 리턴합니다. 이렇게 얻은 화면 중앙 좌표와 윈도우 폭, 높이로 JWindow

의 좌측 상단 모서리 좌표를 계산할 수 있습니다. 그런 다음 JWindow의 setLocation ( ) 메소드로 좌

측 상단 모서리 좌표를 설정해주면 됩니다.

JWindow를 화면에 띄우려면 setVisible (true ) 메소드를 호출하면 됩니다.

JWindowExample jWindow  =  new JWindowExample();
jWindow.setVisible(true);

반대로 setVisible (false )을 호출하면 JWindow가 화면에서 사라지는데, 이것은 JWindow가 화

면에서 완전히 제거되는 것이 아니라 단지 숨겨질 뿐입니다. 다시 setVisible (true )을 호출하면 언제

든지 나타난다. 만약 JWindow를 화면에서 완전히 제거하고 싶다면 dispose ( ) 메소드를 호출하

면 됩니다.

jWindow.dispose();

다음 예제는 JWindow를 이용해서 게임을 시작할 때 보여줄 로고 윈도우를 만든다.



>>> JWindowExample.java

```java
package sec03.exam02_jwindow;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class JWindowExample extends JWindow {
public JWindowExample() {
//JWindow의 크기
this.setSize(600, 350);
```

//JWindow를 화면 중앙으로 띄우기
GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
Point centerPoint  =  ge.getCenterPoint();
int leftTopX  =  centerPoint.x - this.getWidth()/2;
int leftTopY  =  centerPoint.y - this.getHeight()/2;
this.setLocation(leftTopX, leftTopY);

//JWindow에 이미지가 포함된 JLabel 추가
JLabel label  =  new JLabel();
label.setIcon(new ImageIcon(getClass().getResource("game.png")));
getContentPane().add(label, BorderLayout.CENTER);

//마우스 클릭 이벤트 처리
this.addMouseListener(new MouseAdapter() {
```java
@Override
public void mouseClicked(MouseEvent e) {
dispose();

}

});

}








public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
JWindowExample jWindow  =  new JWindowExample();
jWindow.setVisible(true);

}

});

}

}

```

실행 결과

JWindow에 이미지를 넣기 위해 26~27 라인에서 JLabel 컴포넌트를 활용하였다. JLabel은 글자

및 이미지를 포함할 수 있는 컴포넌트인데, setIcon ( ) 메소드로 ImageIcon 객체를 매개값으로

주면 이미지를 나타낼 수 있습니다.

ImageIcon 생성자는 이미지 파일의 URL 객체를 매개값으로 받는데, JWindowExample.class

와 동일한 폴더에 있는 ‘game.png’ 파일에 대한 URL 객체를 얻기 위해 다음 코드를 사용하였다.

getClass().getResource("game.png")

28라인은 JLable을 JWindow의 중앙에 배치시킨다. 컴포넌트 배치는 4절에서 설명합니다. 31~36

라인은 마우스로 JWindow를 클릭했을 때 JWindow를 제거하기 위해 이벤트를 처리한 것입니다.

이벤트 처리는 5절에서 설명합니다.



JFrame

JFrame은 JWindow와는 달리 윈도우 경계선, 제목 표시줄, 메뉴바가 있는 윈도우를 만드는 컨테

이너 클래스입니다. 새로운 개발자 정의 윈도우를 만들기 위해서는 다음과 같이 JFrame을 상속해서

만들 수 있습니다.

```java
public class JFrameExample extends JFrame {
public JFrameExample() {
//제목 표시줄
this.setIconImage(
new ImageIcon(getClass().getResource("icon.png")).getImage());
this.setTitle("창제목");
//JFrame 크기
this.setSize(600, 500);
//종료 버튼의 기본 기능
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

}
```

JFrame의 제목 표시줄은 아이콘, 제목, 크


기 조절용 버튼, 종료 버튼으로 구성됩니다.

아이콘은  setIconImage ( )  메소드로

설정하면  되는데,  ImageIcon  객체의

getImage ( ) 메소드로 Image 객체를 얻

어 매개값으로 설정하면 됩니다.

창 제목은 setTitle ( ) 메소드로 설정할 수


있습니다. 종료 버튼의 기본 기능은 JFrame을 단순히 숨기기만 하고 프로세스를 종료하지 않는다. 프로세

스를 완전히 종료하려면 setDefaultCloseOperation ( ) 메소드로 종료 버튼의 기본 기능을 변경해

야 합니다. setDefaultCloseOperation ( ) 메소드에 지정할 수 있는 종료 버튼의 기능별 매개값은

다음 네 가지 종류가 있습니다.



기능별 상수

설명

WindowConstants.DO_NOTHING_ON_CLOSE   아무 것도 하지 않음

WindowConstants.HIDE_ON_CLOSE

화면에서 JFrame 숨김 (기본)

WindowConstants.DISPOSE_ON_CLOSE

화면에서 JFrame 완전히 제거, 다른 JFrame이 없다면
윈도우 프로세스를 종료

JFrame.EXIT_ON_CLOSE

윈도우 프로세스를 종료

창 크기는 setSize ( )로 폭과 높이값을 주고, JFrame을 화면의 중앙 부분에 위치시키는 방법은

JWindow에서 설명한 것과 동일하다. 화면 중앙 좌표와 윈도우 폭, 높이로 JFrame의 좌측 상단

모서리 좌표를 구한 다음, setLocation ( ) 메소드로 설정해주면 됩니다.

JFrame를 화면에 띄우려면 setVisible (true ) 메소드를 다음과 같이 호출하면 됩니다.

JFrameExample jFrame  =  new JFrameExample ();
jFrame.setVisible(true);

반대로 setVisible (false )를 호출하면 JFrame이 화면에서 사라지는데, 이것은 JFrame이 화면에

서 완전히 제거되는 것이 아니라 숨겨질 뿐입니다. 다시 setVisible (true )를 호출하면 언제든지 나타

난다. 만약 JFrame를 화면에서 완전히 제거하고 싶다면 dispose ( ) 메소드를 호출하면 됩니다.

jFrame.dispose();

다음 예제는 JFrame으로 제목 표시줄이 있는 윈도우를 띄우고 종료하는 방법을 보여 준다.

>>> JFrameExample.java


```java
package sec03.exam03_jframe;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;





public class JFrameExample  extends JFrame {
public JFrameExample() {
//JWindow의 크기
this.setSize(600, 500);
```

//제목 표시줄 내용
this.setIconImage(new ImageIcon(getClass().getResource("icon.png")).
getImage());
this.setTitle("메인창");

//종료 버튼의 기본 기능
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//JWindow를 화면 중앙으로 띄우기
GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
Point centerPoint  =  ge.getCenterPoint();
int leftTopX  =  centerPoint.x - this.getWidth()/2;
int leftTopY  =  centerPoint.y - this.getHeight()/2;
this.setLocation(leftTopX, leftTopY);

}

```java
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
JFrameExample jFrame  =  new JFrameExample();
jFrame.setVisible(true);

}

});

}

}
```

실행 결과









JTabbedPane

JTabbedPane은 탭tab별로 다른 내용을 보여주

기 위해 사용되는 컨테이너입니다. JTabbedPane

은 독립적인 윈도우 모양을 갖고 있지 않기 때문

에 JWindow, JFrame, JDialog 등과 같은 최

상위 레벨 컨테이너에 배치됩니다.

오른쪽 화면은 JTabbedPane의 구현 모습입니다.

탭의 위치는 상단, 하단, 왼쪽, 오른쪽에 위치 시

킬 수 있습니다. JTabbedPane을 생성하려면 다음

과 같이 기본 생성자를 호출하면 됩니다.

JTabbedPane jTabbedPane  =  new JTabbedPane();

탭의 위치를 설정하려면 setTabPlacement ( ) 메소드로 탭의 위치 상수를 다음과 같이 지정합니다.

jTabbedPane.setTabPlacement(
JTabbedPane.TOP | JTabbedPane.BOTTOM | JTabbedPane.LEFT | JTabbedPane.RIGHT

);

JTabbedPane에 탭을 추가하려면 addTab ( ) 메소드를 이용합니다. addTab ( ) 메소드는 탭의 이

름과 탭안에 배치될 컴포넌트를 매개값으로 받는데, 컴포넌트는 주로 JPanel을 객체를 사용합니다.

jTabbedPane.addTab("TapName1", jPanel1);
jTabbedPane.addTab("TapName2", jPanel2);

그리고 각각의 JPanel 안에는 해당 탭에서 보여줄 컴포넌트를 배치하면 됩니다. 이렇게 생성된

JTabbedPane은 다른 컴포넌트와 마찬가지로 ContentPane에 배치됩니다. 다음은 JFrame의 중앙

에 JTabbedPane을 배치하는 코드입니다.

jFrame.getContentPane().add("Center", jTabbedPane);



다음 예제는 두 개의 탭을 추가한 다음 각 탭을 클릭하면 두 개의 JPanel이 이미지를 교체해 보여 준다.

>>> JTabbedPaneExample.java


```java
package sec03.exam04_jtabbedpane;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JTabbedPaneExample extends JFrame {
private JTabbedPane jTabbedPane;
private JPanel tab1Panel;
private JPanel tab2Panel;
```

//메인 윈도우 설정
public JTabbedPaneExample() {
this.setTitle("JTabbedPaneExample");
this.setSize(300, 200);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.getContentPane().add(getJTabbedPane(), BorderLayout.CENTER);

}

//JTabbedPane 생성 및 Tab 추가
private JTabbedPane getJTabbedPane() {
if (jTabbedPane  = =  null) {
jTabbedPane  =  new JTabbedPane();
jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
jTabbedPane.addTab("탭1", getTab1Panel());
jTabbedPane.addTab("탭2", getTab2Panel());

}
return jTabbedPane;

}

//Tab1에 추가된 JPanel 생성




private JPanel getTab1Panel() {
if(tab1Panel  = =  null) {
tab1Panel  =  new JPanel();
JLabel jLabel  =  new JLabel();
jLabel.setIcon(new ImageIcon(getClass().getResource("duke1.gif")));
tab1Panel.add(jLabel);

}
return tab1Panel;

}

//Tab2에 추가될 JPanel 생성
private JPanel getTab2Panel() {
if(tab2Panel  = =  null) {
tab2Panel  =  new JPanel();
JLabel jLabel  =  new JLabel();
jLabel.setIcon(new ImageIcon(getClass().getResource("duke2.gif")));
tab2Panel.add(jLabel);

}
return tab2Panel;

}

```java
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
JTabbedPaneExample jFrame  =  new JTabbedPaneExample();
jFrame.setVisible(true);

}

});

}

}

```

실행 결과



JScrollPane

JScrollPane은 포함된 컴포넌트의 크기가 JScrollPane 자신보다 큰 경우 수평 또는 수직 스크롤

바를 이용해서 볼 수 있게 해준다. JScrollPane은 다른 컨테이너와는 달리 단 하나의 컴포넌트만을

포함시킬 수 있습니다.

JScrollPane

수직 스크롤

수평 스크롤

JLabel의 크기
(그림의 크기)

위 그림을 보면 JScrollPane은 JFrame의 중앙에 위치하고 있습니다. JScrollPane안에는 그림을 포함

하고 있는 JLabel 배치되어 있는데, 그림의 크기가 JScrollPane보다 크기 때문에 수직 및 수평 스

크롤이 생긴다.

스크롤이 필요한 컴포넌트에는 큰 내용을 포함하고 있는 JLabel, JTextArea, JList, JTable, JTree

등이 있습니다. 이 컴포넌트에 스크롤을 적용시키려면 다음과 같이 JScrollPane 생성자에 컴포넌트를

매개값으로 주면 됩니다. 이렇게 생성된 JScrollPane은 컴포넌트가 배치될 수 있는 곳이라면 어디든

지 배치가 가능하다.

JScrollPane scrollJList  =  new JScrollPane(jLabel);
JScrollPane scrollJTextArea  =  new JScrollPane(jTextArea);
JScrollPane scrollJList  =  new JScrollPane(jList);
JScrollPane scrollJTable  =  new JScrollPane(jTable);

다음 예제에서는 JLabel에 큰 이미지를 넣고, JScrollPane에 JLabel을 추가시켰다. 그리고

JFrame 중앙에 JScrollPane을 배치시켰는데, JFrame의 사이즈가 이미지보다 작기 때문에 스크롤

이 자동 생성됩니다.



>>> JScrollPaneExample.java


```java
package sec03.exam05_jscrollpane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JScrollPaneExample extends JFrame {
private JScrollPane scrollImage;
private JLabel lblImage;
```

//메인 윈도우 설정
public JScrollPaneExample() {
this.setTitle("JScrollPaneExample");
this.setSize(350, 230);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//JFrame 중앙에 JScrollPane 추가
this.getContentPane().add(getScrollImage(), BorderLayout.CENTER);

}

//JScrollPane 생성
private JScrollPane getScrollImage() {
if (scrollImage  = =  null) {
scrollImage  =  new JScrollPane(getLblImage());

}
return scrollImage;

}

//JLabel 생성
public JLabel getLblImage() {
if(lblImage  = =  null) {
lblImage  =  new JLabel();
lblImage.setIcon(new ImageIcon(getClass().getResource("snow.jpg")));

}
return lblImage;

}






```java
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
JScrollPaneExample jFrame  =  new JScrollPaneExample();
jFrame.setVisible(true);

}

});

}

}

```

실행 결과

