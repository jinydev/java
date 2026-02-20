---
layout: gui
title: "Swing 강의 자료"
permalink: /gui/2.swing/
---

# Swing 강의 자료

## 학습목표

1. **Swing의 개요와 특징 이해**: AWT와 Swing의 차이점 및 Swing의 구조적 특징을 학습합니다.
2. **이벤트 처리 메커니즘**: 이벤트 디스패칭 스레드(EDT)와 이벤트 리스너 모델을 이해하고 올바른 이벤트 처리 방법을 익힙니다.
3. **컨테이너와 레이아웃 관리**: 다양한 컨테이너(JFrame, JPanel 등)와 배치 관리자(Layout Manager)를 활용하여 화면을 구성합니다.
4. **주요 컴포넌트 활용**: 버튼, 텍스트, 리스트, 테이블, 트리, 메뉴, 툴바 등 다양한 Swing 컴포넌트의 사용법과 속성을 학습합니다.
5. **고급 GUI 기능**: 다이얼로그와 2D 그래픽스 기능을 활용하여 풍부한 사용자 인터페이스를 구현합니다.

## 목차

### [01. Swing 소개](01_swing_intro/)
자바의 GUI 툴킷인 Swing의 역사와 구조적 특징을 알아보고, AWT와의 차이점을 이해합니다.
경량 컴포넌트(Lightweight Component)의 개념과 MVC 패턴 기반의 설계를 학습합니다.

### [02. 이벤트 디스패칭 스레드](02_event_dispatching_thread/)
Swing의 단일 스레드 모델 규칙과 이벤트 디스패칭 스레드(EDT)의 역할을 학습합니다.
`invokeLater`와 `invokeAndWait`를 사용하여 스레드 안전하게 UI를 업데이트하는 방법을 익힙니다.

### [03. Swing 컨테이너](03_swing_containers/)
JFrame, JDialog, JApplet 등 최상위 컨테이너와 JPanel과 같은 중간 컨테이너를 학습합니다.
컨테이너의 계층 구조(RootPane, ContentPane 등)와 컴포넌트 추가 방식을 이해합니다.

### [04. 컴포넌트 배치](04_component_layout/)
BorderLayout, FlowLayout, GridLayout 등 다양한 레이아웃 매니저의 특징과 사용법을 익힙니다.
복잡한 화면 구성을 위해 컨테이너를 중첩하고 배치를 제어하는 방법을 학습합니다.

### [05. 이벤트 처리](05_event_handling/)
이벤트 소스, 이벤트 리스너, 이벤트 객체로 구성된 위임형 이벤트 모델을 학습합니다.
다양한 리스너 인터페이스와 어댑터 클래스를 활용하여 사용자 입력을 처리하는 방법을 익힙니다.

### [06. 버튼 컴포넌트](06_button_component/)
JButton, JToggleButton, JCheckBox, JRadioButton 등 버튼 계열 컴포넌트를 학습합니다.
버튼의 상태 관리와 아이콘 설정, 이벤트 처리 방법을 실습합니다.

### [07. 텍스트 컴포넌트](07_text_component/)
JTextField, JTextArea, JPasswordField 등 텍스트 입력을 위한 컴포넌트를 다룹니다.
문서 모델(Document)의 개념과 텍스트 조작, 스크롤바 연동 방법을 학습합니다.

### [08. 리스트 컴포넌트](08_list_component/)
JList와 JComboBox를 사용하여 목록형 데이터를 표시하고 선택하는 방법을 학습합니다.
데이터 모델과 렌더러를 커스터마이징하여 다양한 형태의 목록을 구현합니다.

### [09. 테이블 컴포넌트](09_table_component/)
JTable을 사용하여 2차원 데이터를 표 형식으로 출력하고 편집하는 방법을 익힙니다.
TableModel을 구현하여 데이터와 뷰를 분리하고, 셀 렌더러와 에디터를 활용합니다.

### [10. 트리 컴포넌트](10_tree_component/)
JTree를 사용하여 계층적 데이터를 트리 구조로 시각화하는 방법을 학습합니다.
TreeNode, TreeModel을 이해하고 노드의 추가, 삭제, 편집 기능을 구현합니다.

### [11. 메뉴 컴포넌트](11_menu_component/)
JMenuBar, JMenu, JMenuItem을 사용하여 어플리케이션의 메뉴 시스템을 구성합니다.
단축키(Accelerator, Mnemonic) 설정과 팝업 메뉴(JPopupMenu) 구현 방법을 익힙니다.

### [12. 툴바 컴포넌트](12_toolbar_component/)
자주 사용하는 기능을 아이콘 버튼으로 모아놓은 툴바(JToolBar)를 구현합니다.
Action 인터페이스를 활용하여 메뉴와 툴바가 동일한 로직을 공유하도록 설계합니다.

### [13. 다이얼로그](13_dialog/)
JOptionPane을 이용한 표준 대화상자와 JDialog를 상속받은 커스텀 대화상자를 만듭니다.
모달(Modal)과 모달리스(Modeless) 다이얼로그의 차이점을 이해하고 활용합니다.

### [14. 2D 그래픽스](14_2d_graphics/)
Swing 컴포넌트의 `paintComponent` 메소드를 오버라이딩하여 커스텀 그래픽을 구현합니다.
Graphics2D 클래스를 사용하여 선, 도형, 이미지, 텍스트를 정교하게 그리는 방법을 학습합니다.

### [15. Swing 과제](15_swing_assignment/)
앞서 배운 Swing 컴포넌트와 기능을 종합적으로 활용할 수 있는 실습 과제들입니다.
계산기, 메모장, 그림판 등 실제 어플리케이션을 직접 구현해보며 실력을 다집니다.
