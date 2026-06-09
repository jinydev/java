---
layout: gui
title: "JavaFX 프로그래밍"
permalink: /gui/3.javafx/
description: "JavaFX 강의 자료 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "JavaFX 강의 자료, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# JavaFX 프로그래밍 개요

차세대 자바 GUI 플랫폼인 **JavaFX**의 세계로 초대합니다! 🎨✨

JavaFX는 고전적인 AWT나 Swing을 넘어 현대적이고 세련된 Rich Client 애플리케이션을 개발할 수 있도록 설계된 강력한 UI 툴킷입니다. FXML을 통한 화면 설계와 자바 코드 분리(MVC 패턴), 웹 기술처럼 스타일을 지정하는 CSS, 강력한 자동 바인딩(Binding) 시스템 등 현대적인 프런트엔드 개발의 편리함을 고스란히 담고 있습니다.

---

## 🗺️ JavaFX 학습 로드맵

JavaFX 탐험을 위한 여정의 전체 지도입니다. 하나씩 격파해 나갑시다!

![JavaFX 학습 로드맵](./img/javafx_roadmap.png)

---

## 🎯 이번 과정의 학습 목표
현대 자바 GUI의 절정인 JavaFX를 배움으로써 아래 핵심 역량을 기르게 됩니다.
1. 🎨 **선언적 UI 설계**: 화면 디자인(FXML), 옷 입히기(CSS), 연산 동작(Java Controller)을 완전히 분리하는 현대적인 MVC 아키텍처를 마스터합니다.
2. 🧳 **컨테이너 & 컨트롤 자유 활용**: 다양한 레이아웃 Pane(`AnchorPane`, `BorderPane`, `GridPane` 등)과 고급 컨트롤(`TableView`, `ListView` 등)을 다뤄 다채로운 앱 화면을 조립합니다.
3. 🔗 **속성 감시와 바인딩**: 데이터의 변경을 감지하고 UI와 모델 간의 값을 자동으로 싱크하는 반응형 코딩 기법을 연마합니다.
4. ⚙️ **스레드 안전성 확보**: 시간이 오래 걸리는 백그라운드 연산을 분리하고 `Platform.runLater()`를 사용해 안전하게 UI를 그리는 동시성 프로그래밍을 해결합니다.

---

## 📚 학습 목차

### 📌 [01. JavaFX 개요](01_javafx_intro/)
JavaFX의 등장 배경과 자바 GUI 발전 역사를 돌아보고, 왜 차세대 UI 플랫폼이라 불리는지 그 특징을 배웁니다.

### 📌 [02. JavaFX 프로젝트 생성 및 실행](02_javafx_project/)
이클립스나 IDE에 JavaFX 라이브러리를 빌드 패스에 등록하고 모듈 설정(`module-info.java`) 및 애플리케이션의 핵심 생명주기(`init`, `start`, `stop`)를 학습합니다.

### 📌 [03. JavaFX 레이아웃](03_javafx_layout/)
자바 코드로 UI를 손수 한 땀 한 땀 코딩하는 방식과, Scene Builder 도구를 써서 드래그 앤 드롭으로 FXML을 생성하는 방식의 장단점을 알아봅니다.

### 📌 [04. JavaFX 컨테이너](04_javafx_containers/)
HBox, VBox, AnchorPane, BorderPane, GridPane 등 UI 컨트롤들을 가두고 알맞게 자동 정렬해 주는 다양한 레이아웃 박스들의 꿀조합을 정복합니다.

### 📌 [05. JavaFX 이벤트 처리](05_javafx_event_handling/)
사용자가 마우스 클릭이나 키보드를 입력했을 때, 이벤트를 전용 컨트롤러(Controller) 메서드와 어노테이션(`@FXML`)으로 연결하여 반응하는 메커니즘을 학습합니다.

### 📌 [06. JavaFX 속성 감시와 바인딩](06_javafx_property_binding/)
자바 코드로 매번 Getter/Setter를 복잡하게 연동할 필요 없이, 속성과 속성을 벨트나 톱니바퀴처럼 엮어주는 반응형 바인딩 기법을 배웁니다.

### 📌 [07. JavaFX 컨트롤](07_javafx_controls/)
라벨, 텍스트 상자 같은 기본적인 입력 컨트롤부터 대규모 데이터를 표로 표시하는 `TableView`, 계층형으로 관리하는 `TreeView` 등의 응용 컴포넌트를 사용해 봅니다.

### 📌 [08. JavaFX 메뉴바와 툴바](08_javafx_menubar_toolbar/)
일반 데스크톱 소프트웨어에 반드시 들어가는 시스템 풀다운 메뉴바(`MenuBar`)와 단축 아이콘 툴바(`ToolBar`)를 FXML로 조립하는 방법을 학습합니다.

### 📌 [09. JavaFX 다이얼로그](09_javafx_dialog/)
안내 팝업창(`Alert`), 파일을 컴퓨터 폴더에서 찾아오게 돕는 파일 선택 창(`FileChooser`) 등의 실용 다이얼로그 창 구현법을 마스터합니다.

### 📌 [10. JavaFX CSS 스타일](10_javafx_css/)
웹 개발 CSS 문법을 활용해 복잡한 자바 코드를 손대지 않고도 배경색, 테두리, 폰트 스타일을 세련되게 바꿔주는 외부 스타일시트 적용 기법을 다룹니다.

### 📌 [11. JavaFX 스레드 UI 변경](11_javafx_thread_ui/)
오직 UI 스레드만 화면을 건드릴 수 있는 '단일 스레드 룰'을 이해하고, 백그라운드 스레드에서 `Platform.runLater()`나 `Task`를 써서 안전하게 UI를 바꾸는 원리를 정복합니다.

### 📌 [12. 장면 이동과 애니메이션](12_scene_transition_animation/)
여러 화면을 매끄럽게 교체하고, Timeline과 Transition 클래스들을 사용해 위젯이 날아다니고 페이드인/아웃되는 생동감 넘치는 화면 연출을 구현합니다.

### 📌 [13. JavaFX 종합 과제](13_javafx_assignment/)
앞서 배운 모든 퍼즐 조각을 맞춰 계산기, 메모장, 타이머 등의 실제 구동되는 미니 데스크톱 앱을 작성하는 실습 과제 명세서입니다.
