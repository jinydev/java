---
layout: gui
title: "03. AWT 레이아웃 매니저"
description: "03. AWT 레이아웃 매니저 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "03. AWT 레이아웃 매니저, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 03. AWT 레이아웃 매니저

## 1. 레이아웃 매니저(Layout Manager)란?
컨테이너(Frame, Panel 등) 내부에서 **컴포넌트들이 배치되는 방식을 결정하는** 클래스입니다.
`java.awt.LayoutManager` 인터페이스를 구현한 클래스들을 사용합니다.

-   **컨테이너는 일반적으로 기본 레이아웃 매니저를 가지고 있습니다.**
    -   `Frame`의 기본값: `BorderLayout`
    -   `Panel`의 기본값: `FlowLayout`

---

## 2. 주요 레이아웃 매니저

### 1) FlowLayout
-   컴포넌트를 **물 흐르듯 왼쪽에서 오른쪽으로** 배치합니다.
-   윈도우 너비가 너무 좁아지면 자동으로 다음 줄로 줄 바꿈됩니다.
-   `Panel`의 기본 레이아웃 매니저입니다.

```java
Frame f = new Frame();
f.setLayout(new FlowLayout()); // FlowLayout 설정

f.add(new Button("1"));
f.add(new Button("2"));
f.add(new Button("3"));
```

### 2) BorderLayout
-   컨테이너 영역을 5개 방향(**동, 서, 남, 북, 중앙**)으로 분할하여 배치합니다.
-   각 영역에는 하나의 컴포넌트만 추가할 수 있습니다.
-   `Frame`의 기본 레이아웃 매니저입니다.

```java
Frame f = new Frame();
f.setLayout(new BorderLayout());

f.add(new Button("North"), BorderLayout.NORTH);
f.add(new Button("South"), BorderLayout.SOUTH);
f.add(new Button("Center"), BorderLayout.CENTER);
// 동(East)과 서(West)는 생략 가능
```

### 3) GridLayout
-   컨테이너를 **격자(행, 열)** 모양으로 균등하게 분할하여 배치합니다.
-   모든 컴포넌트의 크기가 동일하게 설정됩니다.
-   계산기 버튼 패드 같은 UI를 만들 때 유용합니다.

```java
Frame f = new Frame();
f.setLayout(new GridLayout(2, 3)); // 2행 3열

f.add(new Button("1"));
f.add(new Button("2"));
f.add(new Button("3"));
f.add(new Button("4"));
f.add(new Button("5"));
f.add(new Button("6"));
```

### 4) Null Layout (절대 좌표 배치)
-   레이아웃 매니저를 사용하지 않고, 개발자가 직접 컴포넌트의 위치(x, y)와 크기(width, height)를 수동으로 지정합니다.
-   창의 크기가 변경되더라도 컴포넌트의 위치와 크기가 고정됩니다.

```java
Frame f = new Frame();
f.setLayout(null); // 레이아웃 매니저 제거

Button b = new Button("Click");
b.setBounds(50, 50, 100, 30); // x=50, y=50, w=100, h=30

f.add(b);
```

---

## 3. 레이아웃 매니저 종합 예제 (계산기 스타일)

```java
import java.awt.*;

public class LayoutExam {
    public static void main(String[] args) {
        Frame f = new Frame("Calculator Layout");
        f.setSize(300, 400);
        f.setLayout(new BorderLayout()); // 전체적으로 BorderLayout 사용

        // 상단: 결과 표시창 (TextField)
        TextField result = new TextField("0");
        f.add(result, BorderLayout.NORTH);

        // 중앙: 버튼 배치 (Panel + GridLayout)
        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 3)); // 4행 3열

        for (int i = 1; i <= 9; i++) {
            p.add(new Button(String.valueOf(i)));
        }
        p.add(new Button("*"));
        p.add(new Button("0"));
        p.add(new Button("#"));

        f.add(p, BorderLayout.CENTER);

        f.setVisible(true);
    }
}
```
