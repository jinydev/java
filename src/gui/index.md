---
layout: gui
title: "GUI 프로그래밍"
permalink: /gui/
---

# 자바 GUI 프로그래밍

GUI(Graphical User Interface)는 사용자가 그래픽 요소를 통해 컴퓨터와 상호작용하는 환경을 말합니다. 자바는 초기 버전부터 GUI 프로그래밍을 위한 다양한 라이브러리를 제공해 왔습니다.

## 학습목표

1.  **GUI 발전 과정 이해**: AWT, Swing, JavaFX로 이어지는 자바 GUI 라이브러리의 변천사와 각각의 특징(Heavyweight vs Lightweight)을 이해합니다.
2.  **레이아웃 및 컴포넌트 활용**: 다양한 배치 관리자(Layout Manager)와 컴포넌트(Component)를 사용하여 사용하기 편리한 UI를 구성합니다.
3.  **이벤트 처리 구현**: 위임형 이벤트 모델(Delegation Event Model)을 이해하고, 리스너와 어댑터를 활용하여 사용자 상호작용을 처리합니다.
4.  **현대적인 UI 개발**: JavaFX의 FXML, CSS, 속성 바인딩 등 최신 UI 개발 기법을 익혀 세련된 애플리케이션을 구현합니다.

---

## 1. AWT (Abstract Window Toolkit)
자바 초창기(JDK 1.0)에 발표된 최초의 GUI 라이브러리입니다. OS의 네이티브 컴포넌트를 사용하여 속도가 빠르지만 디자인에 한계가 있습니다.

### [AWT 상세 학습하기](/gui/1.awt/)

*   **[01. AWT 개요](1.awt/01_awt_intro/)**
*   **[02. AWT 컴포넌트](1.awt/02_awt_components/)**
*   **[03. AWT 배치관리자](1.awt/03_awt_layout/)**
*   **[04. AWT 이벤트처리](1.awt/04_awt_event/)**

---

## 2. Swing
AWT의 단점을 보완하기 위해 JDK 1.2에서 발표된 순수 자바(Lightweight) GUI 라이브러리입니다. OS 독립적이며 풍부한 컴포넌트를 제공합니다.

### [Swing 상세 학습하기](/gui/2.swing/)

*   **[01. Swing 소개](2.swing/01_Swing_소개/)**
*   **[02. 이벤트 디스패칭 스레드](2.swing/02_event_dispatching_thread/)**
*   **[03. Swing 컨테이너](2.swing/03_Swing_컨테이너/)**
*   **[04. 컴포넌트 배치](2.swing/04_component_layout/)**
*   **[05. 이벤트 처리](2.swing/05_event_handling/)**
*   **[06. 버튼 컴포넌트](2.swing/06_button_component/)**
*   **[07. 텍스트 컴포넌트](2.swing/07_text_component/)**
*   **[08. 리스트 컴포넌트](2.swing/08_list_component/)**
*   **[09. 테이블 컴포넌트](2.swing/09_table_component/)**
*   **[10. 트리 컴포넌트](2.swing/10_tree_component/)**
*   **[11. 메뉴 컴포넌트](2.swing/11_menu_component/)**
*   **[12. 툴바 컴포넌트](2.swing/12_toolbar_component/)**
*   **[13. 다이얼로그](2.swing/13_dialog/)**
*   **[14. 2D 그래픽스](2.swing/14_2d_graphics/)**
*   **[15. Swing 과제](2.swing/15_Swing_과제/)**

---

## 3. JavaFX
RIA 시장을 겨냥한 차세대 GUI 플랫폼입니다. 하드웨어 가속, FXML, CSS 스타일링을 지원하여 화려하고 현대적인 UI를 개발할 수 있습니다.

### [JavaFX 상세 학습하기](/gui/3.javafx/)

*   **[01. JavaFX 개요](3.javafx/01_javafx_intro/)**
*   **[02. JavaFX 프로젝트 생성 및 실행](3.javafx/02_javafx_project/)**
*   **[03. JavaFX 레이아웃](3.javafx/03_javafx_layout/)**
*   **[04. JavaFX 컨테이너](3.javafx/04_javafx_containers/)**
*   **[05. JavaFX 이벤트 처리](3.javafx/05_javafx_event_handling/)**
*   **[06. JavaFX 속성 감시와 바인딩](3.javafx/06_javafx_property_binding/)**
*   **[07. JavaFX 컨트롤](3.javafx/07_javafx_controls/)**
*   **[08. JavaFX 메뉴바와 툴바](3.javafx/08_javafx_menubar_toolbar/)**
*   **[09. JavaFX 다이얼로그](3.javafx/09_javafx_dialog/)**
*   **[10. JavaFX CSS 스타일](3.javafx/10_javafx_css/)**
*   **[11. JavaFX 스레드 UI 변경](3.javafx/11_javafx_thread_ui/)**
*   **[12. 장면 이동과 애니메이션](3.javafx/12_scene_transition_animation/)**
*   **[13. JavaFX 과제](3.javafx/13_javafx_assignment/)**

---

## 요약: 자바 GUI 변천사

| 구분            | AWT                       | Swing                   | JavaFX                     |
| :-------------- | :------------------------ | :---------------------- | :------------------------- |
| **등장 시기**   | JDK 1.0                   | JDK 1.2                 | JDK 8 (표준화)             |
| **구현 방식**   | OS 네이티브 (Heavyweight) | 순수 자바 (Lightweight) | 하드웨어 가속 (Prism 엔진) |
| **OS 의존성**   | 높음 (OS 종속적)          | 없음 (OS 독립적)        | 없음 (OS 독립적)           |
| **UI 정의**     | 자바 코드                 | 자바 코드               | 자바 코드 + **FXML**       |
| **스타일링**    | 제한적                    | Look and Feel           | **CSS**                    |
| **주요 패키지** | `java.awt`                | `javax.swing`           | `javafx.*`                 |
