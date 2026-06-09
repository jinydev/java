---
layout: gui
title: "04. AWT 이벤트 처리"
description: "04. AWT 이벤트 처리 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "04. AWT 이벤트 처리, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 04. AWT 이벤트 처리

## 1. 이벤트 위임 모델 (Event Delegation Model)
자바 AWT는 **이벤트 위임 모델(Delegation Event Model)**을 사용합니다.
-   **이벤트 소스(Event Source)**: 이벤트가 발생하는 컴포넌트입니다 (예: 버튼).
-   **이벤트 리스너(Event Listener)**: 이벤트가 발생했을 때 실행될 코드입니다 (인터페이스를 구현함).
-   **이벤트 객체(Event Object)**: 발생한 이벤트에 대한 정보입니다 (예: 클릭된 버튼, 마우스 좌표 등).

즉, **이벤트 소스에 리스너를 등록(add)**하고, 해당 이벤트가 발생하면 **리스너의 메서드가 자동으로 호출**되는 방식입니다.

---

## 2. 주요 이벤트와 리스너

| 컴포넌트          | 이벤트 클래스 | 리스너 인터페이스 | 주요 메서드                         |
| :---------------- | :------------ | :----------------- | :---------------------------------- |
| `Button`          | `ActionEvent` | `ActionListener`   | `actionPerformed(ActionEvent e)`    |
| `List`, `Choice`  | `ItemEvent`   | `ItemListener`     | `itemStateChanged(ItemEvent e)`     |
| `TextField`       | `TextEvent`   | `TextListener`     | `textValueChanged(TextEvent e)`     |
| `Frame` (Window)  | `WindowEvent` | `WindowListener`   | `windowClosing(WindowEvent e)`      |
| 마우스 (Mouse)    | `MouseEvent`  | `MouseListener`    | `mouseClicked`, `mousePressed`, ... |
| 키보드 (Keyboard) | `KeyEvent`    | `KeyListener`      | `keyPressed`, `keyReleased`, ...    |

---

## 3. 이벤트 처리 방법

### 방법 1: 리스너 인터페이스 직접 구현하기
클래스 자체가 리스너 역할을 하도록 인터페이스를 직접 구현하는 방식입니다.

```java
import java.awt.*;
import java.awt.event.*;

public class EventExam implements ActionListener {
    Frame f;
    Button b;

    public EventExam() {
        f = new Frame("Event Test");
        f.setLayout(new FlowLayout());

        b = new Button("Click Me");
        b.addActionListener(this); // 버튼에 리스너(자기 자신) 등록

        f.add(b);
        f.setSize(300, 200);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked!");
    }

    public static void main(String[] args) {
        new EventExam();
    }
}
```

### 방법 2: 익명 내부 클래스 (Anonymous Inner Class) 사용하기
따로 클래스 구현을 정의하지 않고, 즉석에서 리스너를 구현하는 방식입니다. 가장 널리 사용되는 방법입니다.

```java
import java.awt.*;
import java.awt.event.*;

public class AnonymousEventExam {
    public static void main(String[] args) {
        Frame f = new Frame("Anonymous Event");
        f.setSize(300, 200);
        f.setLayout(new FlowLayout());

        Button b = new Button("Close Window");

        // 1. 버튼 클릭 처리 (ActionListener)
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close button clicked");
                System.exit(0);
            }
        });

        // 2. 윈도우 'X' 버튼 처리 (WindowListener -> WindowAdapter)
        // WindowListener는 구현해야 할 메서드가 7개나 되므로, 필요한 메서드만 재정의할 수 있게 어댑터 클래스를 사용합니다.
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(b);
        f.setVisible(true);
    }
}
```

### * 어댑터(Adapter) 클래스란?
인터페이스의 모든 메서드를 구현하는 것이 번거로울 때(예: `WindowListener`는 7개의 메서드가 있음), 빈 껍데기 메서드들로 미리 구현되어 있는 **어댑터 클래스**(예: `WindowAdapter`)를 상속받아 **필요한 메서드만 재정의(Override)**하여 사용할 수 있도록 제공되는 클래스입니다.
-   `WindowListener` -> `WindowAdapter`
-   `MouseListener` -> `MouseAdapter`
-   `KeyListener` -> `KeyAdapter`
-   (단, `ActionListener`는 구현할 메서드가 하나뿐이므로 별도의 어댑터가 존재하지 않습니다.)
