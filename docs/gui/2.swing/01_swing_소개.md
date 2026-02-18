# 01. Swing 소개

UIUser Interface 프로그램은 윈도우, 메뉴, 버튼, 라디오, 리스트 등 시각적인 컴포넌트를 제공해서 사

용자와 상호작용하도록 돕는다. 자바는 이러한 UI 프로그램을 개발할 수 있도록 JDK에서 JFC Java

Foundation Classes를 제공합니다.

JFC는 UI 프로그램을 만들기 위한 클래스들의 모음으로, AWTAbstract Window Toolkit와 Swing (스윙)

을 제공하고 있습니다. AWT는 java.awt 패키지로, Swing은 javax.swing 패키지로 사용 가능하다.

AWT는 운영체제가 가지고 있는 컴포넌트를 그대로 이용하고, Swing은 자바에서 직접 컴포넌트를

만든다는 점이 다르다. 따라서 AWT는 여러 운영체제들이 공통적으로 가지고 있는 컴포넌트만 사

용하므로 컴포넌트 수가 제한적이지만, Swing은 자바에서 직접 제공하는 컴포넌트이기 때문에 종

류가 매우 다양하다. Swing의 단점은 자바가 직접 컴포넌트를 생성하기 때문에 AWT에 비해 CPU

와 메모리를 상대적으로 많이 사용한다는 것입니다.

다음은 AWT로 작성한 간단한 윈도우 프로그램입니다. import되는 내용을 보면 모두 java.awt 패키

지를 사용하고 있는 것을 볼 수 있습니다.

>>> App.java


```java
package sec01.exam01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
```

//Frame 상속
```java
public class App extends Frame {
public App() {
//제목 설정
setTitle("AWT App");
//윈도우 크기 설정
setSize(300, 100);
//Button 추가
add(new Button("Ok"), BorderLayout.SOUTH);


```

//윈도우 종료 버튼을 클릭하면 프로세스 종료
addWindowListener(new WindowAdapter() {
```java
@Override
public void windowClosing(WindowEvent e) {
System.exit(0);

}

});

}

public static void main(String[] args) {
//윈도우 생성
App app  =  new App();
//윈도우를 보여줌
app.setVisible(true);

}

}

```

실행 결과

다음은 Swing으로 작성한 간단한 윈도우 프로그램입니다. Swing은 AWT가 제공하는 것을 공유하

기 때문에 import되는 내용을 보면 java.awt 패키지와 javax.swing 패키지를 사용하고 있는 것

을 볼 수 있습니다.

>>> App.java


```java
package sec01.exam02_swing;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;


```

//JFrame 상속
```java
public class App extends JFrame {
public App() {
//제목 설정
setTitle("Swing App");
//윈도우 크기 설정
setSize(300, 100);
//JButton 추가
getContentPane().add(new JButton("Ok"), BorderLayout.SOUTH);
//윈도우 종료 버튼을 클릭하면 프로세스 종료
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
System.exit(0);

}

});

}

public static void main(String[] args) {
//윈도우 생성
App app  =  new App();
//윈도우를 보여줌
app.setVisible(true);

}

}

```

실행 결과

윈도우를 만들기 위해 AWT는 Frame을 상속했고, Swing은 JFrame을 상속했다. 그리고 버튼은

AWT는 Button을, Swing은 JButton을 사용하고 있습니다. Swing의 UI 관련 클래스는 AWT의 클

래스에 J를 붙였기 때문에 쉽게 구분할 수 있습니다.



