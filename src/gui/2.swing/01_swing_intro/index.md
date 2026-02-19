---
layout: gui
title: "01. Swing 소개"
---

# 01. Swing 소개

UI(User Interface) 프로그램은 윈도우, 메뉴, 버튼, 라디오, 리스트 등 시각적인 컴포넌트를 제공해서 사용자와 상호작용하도록 돕습니다. 자바는 이러한 UI 프로그램을 개발할 수 있도록 JDK에서 **JFC(Java Foundation Classes)**를 제공합니다.

JFC는 UI 프로그램을 만들기 위한 클래스들의 모음으로, **AWT(Abstract Window Toolkit)**와 **Swing(스윙)**을 포함하고 있습니다.
- **AWT**: `java.awt` 패키지 사용. 운영체제(OS)의 네이티브 컴포넌트를 그대로 이용 (Heavyweight).
- **Swing**: `javax.swing` 패키지 사용. 자바에서 직접 컴포넌트를 그려서 구현 (Lightweight).

AWT는 OS의 컴포넌트를 사용하므로 속도가 빠르지만 디자인이 OS에 종속적입니다. 반면 Swing은 자바가 직접 그리므로 모든 OS에서 동일한 디자인을 유지할 수 있고 다양한 컴포넌트를 제공하지만, AWT보다 리소스를 더 많이 사용할 수 있습니다.

---

## 1. AWT 예제
다음은 AWT로 작성한 간단한 윈도우 프로그램입니다. `Frame`을 상속받아 윈도우를 만듭니다.

```java
package sec01.exam01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame {
    public App() {
        // 제목 설정
        setTitle("AWT App");
        // 윈도우 크기 설정
        setSize(300, 100);
        // Button 추가
        add(new Button("Ok"), BorderLayout.SOUTH);

        // 윈도우 종료 버튼을 클릭하면 프로세스 종료
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // 윈도우 생성
        App app = new App();
        // 윈도우를 보여줌
        app.setVisible(true);
    }
}
```

---

## 2. Swing 예제
다음은 Swing으로 작성한 윈도우 프로그램입니다. AWT의 `Frame` 대신 `JFrame`을 상속받고, `Button` 대신 `JButton`을 사용합니다. Swing 컴포넌트는 클래스 이름 앞에 `J`가 붙는 것이 특징입니다.

```java
package sec01.exam02_swing;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class App extends JFrame {
    public App() {
        // 제목 설정
        setTitle("Swing App");
        // 윈도우 크기 설정
        setSize(300, 100);
        // JButton 추가
        // Swing에서는 ContentPane에 컴포넌트를 추가하는 것이 정석이나, 
        // Java 5부터는 JFrame에 직접 add() 해도 ContentPane에 추가됨.
        getContentPane().add(new JButton("Ok"), BorderLayout.SOUTH);
        
        // 윈도우 종료 버튼을 클릭하면 프로세스 종료
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // 윈도우 생성
        App app = new App();
        // 윈도우를 보여줌
        app.setVisible(true);
    }
}
```

### 요약
- **AWT**: `Frame`, `Button` 등 OS 종속 컴포넌트.
- **Swing**: `JFrame`, `JButton` 등 순수 자바 컴포넌트 (`J` 접두사).
