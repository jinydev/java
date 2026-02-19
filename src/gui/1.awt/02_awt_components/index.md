---
layout: gui
title: "02. AWT 컴포넌트"
---

# 02. AWT 컴포넌트

## 1. 컴포넌트(Component)란?
AWT에서 화면을 구성하는 모든 요소를 **컴포넌트**라고 합니다.
`java.awt.Component` 클래스를 상속받아 구현되어 있으며, 버튼, 라벨, 텍스트 필드 등이 모두 컴포넌트입니다.

### 1-1. 컨테이너(Container)
컴포넌트를 담을 수 있는 특별한 컴포넌트를 **컨테이너**라고 합니다.
-   **Frame**: 독립적인 윈도우 창입니다. 프로그램의 메인 화면 역할을 합니다.
-   **Dialog**: 대화 상자입니다.
-   **Panel**: 여러 컴포넌트를 묶어서 관리하기 위한 사각형 영역입니다.

---

## 2. 주요 AWT 컴포넌트

### 1) Label (라벨)
단순한 문자열을 표시하는 컴포넌트입니다. 사용자가 편집할 수 없습니다.

```java
Label l1 = new Label("이름:");
Label l2 = new Label("비밀번호:", Label.RIGHT); // 정렬 지정
```

### 2) Button (버튼)
사용자가 클릭하여 이벤트를 발생시킬 수 있는 버튼입니다.

```java
Button b = new Button("가입하기");
```

### 3) TextField (텍스트 필드)
한 줄의 텍스트를 입력받을 수 있는 컴포넌트입니다.

```java
TextField tf = new TextField("기본값", 20); // 20은 글자 수(폭)
TextField pass = new TextField(10);
pass.setEchoChar('*'); // 비밀번호 입력 시 '*'로 표시
```

### 4) TextArea (텍스트 영역)
여러 줄의 텍스트를 입력받을 수 있는 컴포넌트입니다.

```java
TextArea ta = new TextArea("내용을 입력하세요", 5, 30); // 5행 30열
```

### 5) Checkbox (체크박스) / CheckboxGroup (라디오 버튼)
선택 옵션을 제공하는 컴포넌트입니다.

```java
// 다중 선택 가능 (체크박스)
Checkbox c1 = new Checkbox("사과");
Checkbox c2 = new Checkbox("바나나", true); // 선택된 상태

// 단일 선택 (라디오 버튼) - CheckboxGroup 사용
CheckboxGroup group = new CheckboxGroup();
Checkbox math = new Checkbox("수학", group, true);
Checkbox eng = new Checkbox("영어", group, false);
```

### 6) Choice (초이스/드롭다운)
클릭하면 목록이 펼쳐져 하나를 선택할 수 있는 컴포넌트입니다. (HTML의 `<select>`와 유사)

```java
Choice day = new Choice();
day.add("MON");
day.add("TUE");
day.add("WED");
```

### 7) List (리스트)
여러 항목을 보여주고 선택할 수 있는 컴포넌트입니다.

```java
List list = new List(3, true); // 3개 항목 보이기, 다중 선택 가능
list.add("Java");
list.add("Python");
list.add("C++");
```

---

## 3. 예제 코드

```java
import java.awt.*;

public class ComponentExam {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        f.setLayout(new FlowLayout()); // 컴포넌트를 순서대로 배치

        Label idLabel = new Label("ID :");
        TextField idText = new TextField(20);
        
        Label pwLabel = new Label("PW :");
        TextField pwText = new TextField(20);
        pwText.setEchoChar('*'); // 비밀번호 가리기

        Button loginBtn = new Button("Login");

        f.add(idLabel);
        f.add(idText);
        f.add(pwLabel);
        f.add(pwText);
        f.add(loginBtn);

        f.setVisible(true);
    }
}
```
