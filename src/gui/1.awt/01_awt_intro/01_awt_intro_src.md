---
layout: gui
title: "01. AWT 개요"
---

# 01. AWT 개요

## 1. AWT(Abstract Window Toolkit)란?
AWT는 자바가 처음 1.0 버전을 발표하면서 함께 배포된 **자바의 기본 GUI 라이브러리**입니다.

### 특징
1.  **OS 네이티브 컴포넌트 사용 (Heavyweight)**:
    -   AWT 컴포넌트를 생성하면 운영체제(OS)의 해당 컴포넌트(Peer)가 실제로 생성됩니다.
    -   예를 들어, AWT `Button`을 만들면 윈도우에서는 윈도우 버튼이, 맥에서는 맥 버튼이 생성됩니다.
    -   따라서 **OS에 따라 모양과 동작이 다를 수 있습니다.**

2.  **빠른 속도**:
    -   OS의 컴포넌트를 직접 사용하기 때문에 처리 속도가 빠릅니다.

3.  **제한적인 디자인**:
    -   OS마다 공통으로 존재하는 컴포넌트만 지원해야 하므로, 복잡하고 다양한 디자인을 구현하기 어렵습니다.

---

## 2. AWT와 Swing 비교

| 구분              | AWT                         | Swing                          |
| :---------------- | :-------------------------- | :----------------------------- |
| **패키지**        | `java.awt`                  | `javax.swing`                  |
| **컴포넌트 타입** | Heavyweight (운영체제 의존) | Lightweight (Pure Java)        |
| **OS 의존성**     | 높음 (OS마다 모양 다름)     | 낮음 (모든 OS에서 동일한 모양) |
| **속도**          | 빠름                        | 상대적으로 느림 (JVM이 그림)   |
| **확장성**        | 낮음                        | 높음 (다양한 컴포넌트 제공)    |

---

## 3. AWT 애플리케이션 구조

AWT 프로그램은 기본적으로 `Frame`을 컨테이너로 사용하여 그 안에 `Button`, `Label` 등의 컴포넌트를 배치하는 방식으로 작성합니다.

### 예제 코드: Hello AWT

```java
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;

public class AwtExample {
    public static void main(String[] args) {
        // 1. 프레임(윈도우) 생성
        Frame f = new Frame("Hello AWT");

        // 2. 레이아웃 설정 (컴포넌트 배치 방식)
        f.setLayout(new FlowLayout());

        // 3. 버튼 생성 및 추가
        Button b = new Button("Click Me");
        f.add(b);

        // 4. 프레임 크기 설정 및 보이기
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
```

> **주의**: 위 코드는 윈도우 닫기 버튼을 눌러도 닫히지 않습니다. AWT는 이벤트 처리를 직접 구현해야 하기 때문입니다. (04. 이벤트 처리 챕터에서 학습합니다.)
