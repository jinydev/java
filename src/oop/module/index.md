---
layout: oop
title: "Chapter 13. 라이브러리와 모듈"
nav_order: 13
has_children: true
parent: "객체지향 자바 프로그래밍"
---

# Chapter 13. 라이브러리와 모듈 (Module System)

> **"프로그램의 부품을 체계적으로 관리하는 물류 시스템"**


<br>

## 학습목표

1.  라이브러리의 개념과 모듈(Module)이 등장한 배경을 이해합니다.
2.  **모듈 기술자(`module-info.java`)**의 역할과 `exports`, `requires` 키워드를 익힙니다.
3.  응용프로그램을 여러 모듈로 쪼개고 조립하는 방법을 배웁니다.
4.  패키지 은닉과 전이 의존 등 모듈 시스템의 고급 기능을 알아봅니다.

![Module Concept](./img/module_concept_container.svg)

---


<br>

## 목차

### [13.1 라이브러리](./library)
프로그램 개발에 필요한 부품(클래스, 인터페이스)을 모아놓은 JAR 파일의 개념을 배웁니다.

### [13.2 모듈이란?](./module)
패키지 관리 기능이 포함된 새로운 라이브러리 형식인 모듈의 개념을 "배송 컨테이너"에 비유하여 이해합니다.

### [13.3 응용프로그램 모듈화](./application-modularity)
거대한 하나의 프로젝트를 기능별로 여러 모듈로 나누어 개발하는 방법과 장점을 배웁니다.

### [13.4 모듈 배포용 JAR](./modular-jar)
개발한 모듈을 다른 사람이 사용할 수 있도록 JAR 파일로 압축하고 배포하는 방법을 알아봅니다.

### [13.5 패키지 은닉 (Exports)](./package-hiding)
모듈 내부의 중요한 패키지를 외부에 감추고, 허락된 패키지만 공개(`exports`)하는 보안 메커니즘을 배웁니다.

### [13.6 전이 의존 (Transitive)](./transitive-dependency)
"A가 B를 필요로 하고, B가 C를 필요로 할 때", A가 C를 자동으로 사용할 수 있게 해주는 `requires transitive` 키워드를 배웁니다.

### [13.7 집합 모듈 (Aggregator)](./aggregator-module)
여러 모듈을 묶어서 한 번에 `requires` 할 수 있게 해주는 편리한 집합 모듈 패턴을 알아봅니다.

### [13.8 리플렉션 허용 (Opens)](./reflection)
은닉된 패키지라도 실행 중에 내부를 들여다봐야 하는 경우(리플렉션)를 위해 `opens` 키워드를 사용하는 법을 배웁니다.

### [13.9 자바 표준 모듈 (Standard)](./standard-modules)
JDK에 이미 포함되어 있는 수많은 표준 모듈들(java.base 등)의 구조와 활용법을 배웁니다.

---


<br>

## 확인문제
- [확인문제](./quiz)
