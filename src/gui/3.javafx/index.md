---
layout: gui
title: "JavaFX 강의 자료"
permalink: /gui/3.javafx/
---

# JavaFX 강의 자료

## 학습목표

1. **JavaFX의 이해와 환경 설정**: JavaFX의 특징과 아키텍처를 이해하고, 개발 환경을 구축하여 프로젝트를 생성합니다.
2. **레이아웃과 FXML 활용**: 다양한 레이아웃 컨테이너(Pane)의 종류와 역할을 학습하고, FXML을 사용하여 UI를 선언적으로 구성하는 방법을 익힙니다.
3. **이벤트 처리와 바인딩**: 사용자 인터랙션을 처리하는 이벤트 핸들러와 데이터의 변경을 감지하고 동기화하는 속성 바인딩 메커니즘을 이해합니다.
4. **UI 컨트롤과 스타일링**: 버튼, 테이블, 리스트 등 다양한 UI 컨트롤을 활용하고, CSS를 적용하여 애플리케이션의 디자인을 스타일링합니다.
5. **고급 기능 구현**: 스레드 안전성을 고려한 UI 업데이트, 화면 전환(Scene Navigation), 애니메이션 효과 등을 통해 완성도 높은 애플리케이션을 구현합니다.

## 목차

### [01. JavaFX 개요](01_javafx_intro/)
JavaFX의 등장 배경과 AWT/Swing과의 차이점을 이해하고, 차세대 UI 플랫폼으로서의 특징을 학습합니다.
Rich Client Application 개발을 위한 구조와 주요 구성 요소를 살펴봅니다.

### [02. JavaFX 프로젝트 생성 및 실행](02_javafx_project/)
JavaFX 애플리케이션의 생명주기(Life Cycle)를 이해하고, `launch()`, `start()`, `stop()` 메소드의 역할을 학습합니다.
IDE를 사용하여 프로젝트를 설정하고 실행하는 과정을 실습합니다.

### [03. JavaFX 레이아웃](03_javafx_layout/)
화면 구성을 위한 레이아웃 관리자의 개념을 익히고, 프로그래밍 방식(Java Code)과 선언적 방식(FXML)의 차이를 이해합니다.
Scene Builder 도구를 활용한 레이아웃 작성법을 소개합니다.

### [04. JavaFX 컨테이너](04_javafx_containers/)
`AnchorPane`, `BorderPane`, `FlowPane`, `GridPane`, `HBox`, `VBox` 등 주요 컨테이너의 특징과 사용법을 학습합니다.
복합적인 화면 구성을 위해 컨테이너를 중첩하여 사용하는 방법을 익힙니다.

### [05. JavaFX 이벤트 처리](05_javafx_event_handling/)
이벤트 핸들러(EventHandler) 등록과 이벤트 위임 모델을 학습합니다.
키보드, 마우스 등 다양한 사용자 입력 이벤트에 반응하는 로직을 구현합니다.

### [06. JavaFX 속성 감시와 바인딩](06_javafx_property_binding/)
JavaFX의 강력한 기능인 속성(Property) 감시와 바인딩(Binding) 메커니즘을 학습합니다.
데이터 모델과 UI 뷰 간의 동기화를 자동화하는 방법을 익힙니다.

### [07. JavaFX 컨트롤](07_javafx_controls/)
사용자와 상호작용하는 기본 컨트롤(Button, Label, TextField)부터 복합 컨트롤(ListView, TableView, TreeView)까지 다양한 컴포넌트를 학습합니다.
각 컨트롤의 주요 속성과 이벤트를 다룹니다.

### [08. JavaFX 메뉴바와 툴바](08_javafx_menubar_toolbar/)
데스크톱 애플리케이션의 필수 요소인 메뉴 시스템(`MenuBar`, `Menu`, `MenuItem`)과 툴바(`ToolBar`)를 구현합니다.
공통 기능을 묶어서 관리하고 사용자 편의성을 높이는 UI를 구성합니다.

### [09. JavaFX 다이얼로그](09_javafx_dialog/)
사용자에게 메시지를 전달하거나 입력을 받기 위한 다이얼로그(Alert, FileChooser, Popup) 사용법을 학습합니다.
커스텀 다이얼로그를 제작하여 애플리케이션에 맞는 대화창을 구현합니다.

### [10. JavaFX CSS 스타일](10_javafx_css/)
웹 표준 CSS와 유사한 JavaFX CSS 구문을 익히고, 애플리케이션의 외관을 스타일링합니다.
선택자(Selector), 속성(Property), 외부 스타일시트 적용 방법을 학습합니다.

### [11. JavaFX 스레드 UI 변경](11_javafx_thread_ui/)
JavaFX 애플리케이션 스레드(Application Thread) 모델과 동시성(Concurrency) 문제를 이해합니다.
`Platform.runLater()`와 `Task` 클래스를 사용하여 백그라운드 작업 후 안전하게 UI를 업데이트하는 방법을 익힙니다.

### [12. 장면 이동과 애니메이션](12_scene_transition_animation/)
`Stage`와 `Scene`을 제어하여 화면을 전환하는 방법을 학습합니다.
Transition 및 Timeline API를 사용하여 생동감 있는 애니메이션 효과를 구현합니다.

### [13. JavaFX 과제](13_javafx_assignment/)
계산기, 메모장, 애니메이션 효과 등 앞서 배운 내용을 종합적으로 활용하는 실습 과제입니다.
실제 동작하는 애플리케이션을 직접 구현하며 문제 해결 능력을 키웁니다.
