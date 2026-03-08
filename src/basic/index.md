---
layout: basic
title: "Part 01. 자바 언어의 기초"
permalink: /basic/
description: "Part 01. 자바 언어의 기초 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "Part 01. 자바 언어의 기초, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# Part 01. 자바 언어의 기초

## 학습목표

1.  **자바 언어 소개**: 자바의 역사, 특징, 바이트코드 파일과 자바 가상 머신에 대해 이해합니다.
2.  **개발 환경 구축**: JDK 설치, 환경 변수 설정, 이클립스 설치, 이클립스 프로젝트 생성, 이클립스 소스 작성부터 실행, 인텔리제이 설치 및 소개, VS Code 설치, 안티그라비티 소개
3.  **자바 시작하기**: 소스 작성부터 실행까지, 코드 용어 이해, 코드 주석 달기, 실행문과 세미콜론
4.  **변수와 타입**: 변수 선언, 정수 타입, 문자 타입, 실수 타입, 논리 타입, 문자열 타입, 자동 타입 변환, 강제 타입 변환, 연산식에서 자동 타입 변환, 문자열을 기본 타입으로 변환, 변수 사용 범위, 콘솔로 변수값 출력, 키보드 입력 데이터를 변수에 저장
5.  **연산자**: 부호/증감 연산자, 산술 연산자, 오버플로우와 언더플로우, 정확한 계산은 정수 연산으로, 나눗셈 연산 후 NaN과 Infinity 처리, 비교 연산자, 논리 연산자, 비트 논리 연산자, 비트 이동 연산자, 대입 연산자, 삼항(조건) 연산자, 연산의 방향과 우선순위
6.  **조건문**: 코드 실행 흐름 제어, if 문, switch 문
7.  **반복문**: for 문, while 문, do-while 문, break 문, continue 문
8.  **참조 타입**: 데이터 타입 분류, 메모리 사용 영역, 참조 타입 변수의 ==, != 연산, null과 NullPointerException, 문자열(String) 타입, 배열(Array) 타입, 다차원 배열, 객체를 참조하는 배열, 배열 복사, 배열 항목 반복을 위한 향상된 for 문, main() 메소드의 String[] 매개변수 용도, 열거(Enum) 타입

## 목차

### [01. 자바 언어 소개](/basic/java)
- [1.1 프로그래밍 언어와 자바](/basic/java/programming-language)
- [1.2 자바의 역사와 제임스 고스링](/basic/java/history)
- [1.3 자바의 특징](/basic/java/features)
- [1.4 바이트코드 파일과 자바 가상 머신](/basic/java/jvm)

### [02. 개발 환경 구축](/basic/setup)
- [2.1 JDK 설치](/basic/setup/jdk-installation)
- [2.2 환경 변수 설정](/basic/setup/environment-variable)
- [2.3 이클립스 설치](/basic/setup/eclipse-installation)
- [2.4 이클립스 프로젝트 생성](/basic/setup/eclipse-project)
- [2.5 이클립스 소스 작성부터 실행](/basic/setup/eclipse-execution)
- [2.6 인텔리제이 설치 및 소개](/basic/setup/intellij-installation)
- [2.7 VS Code 설치](/basic/setup/vscode-installation)
- [2.8 안티그라비티 소개](/basic/setup/antigravity)

### [03. 자바 시작하기](/basic/start)
- [3.1 소스 작성부터 실행까지](/basic/start/execution-process)
- [3.2 코드 용어 이해](/basic/start/code-terminology)
- [3.3 코드 주석 달기](/basic/start/comments)
- [3.4 실행문과 세미콜론](/basic/start/statements)

### [04. 변수와 타입](/basic/variable)
- [4.1 변수 선언](/basic/variable/declaration)
- [4.2 정수 타입](/basic/variable/integer-type)
- [4.3 문자 타입](/basic/variable/char-type)
- [4.4 실수 타입](/basic/variable/float-type)
- [4.5 논리 타입](/basic/variable/boolean-type)
- [4.6 문자열 타입](/basic/variable/string-type)
- [4.7 자동 타입 변환](/basic/variable/promotion)
- [4.8 강제 타입 변환](/basic/variable/casting)
- [4.9 연산식에서 자동 타입 변환](/basic/variable/operation-promotion)
- [4.10 문자열을 기본 타입으로 변환](/basic/variable/string-conversion)
- [4.11 변수 사용 범위](/basic/variable/scope)
- [4.12 콘솔로 변수값 출력](/basic/variable/console-output)
- [4.13 키보드 입력 데이터를 변수에 저장](/basic/variable/keyboard-input)

### [05. 연산자](/basic/operator)
- [5.1 부호/증감 연산자](/basic/operator/sign-increment)
- [5.2 산술 연산자](/basic/operator/arithmetic)
- [5.3 오버플로우와 언더플로우](/basic/operator/overflow-underflow)
- [5.4 정확한 계산은 정수 연산으로](/basic/operator/accurate-calculation)
- [5.5 나눗셈 연산 후 NaN과 Infinity 처리](/basic/operator/nan-infinity)
- [5.6 비교 연산자](/basic/operator/comparison)
- [5.7 논리 연산자](/basic/operator/logical)
- [5.8 비트 논리 연산자](/basic/operator/bit-logical)
- [5.9 비트 이동 연산자](/basic/operator/bit-shift)
- [5.10 대입 연산자](/basic/operator/assignment)
- [5.11 삼항(조건) 연산자](/basic/operator/ternary)
- [5.12 연산의 방향과 우선순위](/basic/operator/precedence)

### [06. 조건문](/basic/condition)
- [6.1 코드 실행 흐름 제어](/basic/condition/flow-control)
- [6.2 if 문](/basic/condition/if)
- [6.3 switch 문](/basic/condition/switch)

### [07. 반복문](/basic/loop)
- [7.1 for 문](/basic/loop/for)
- [7.2 while 문](/basic/loop/while)
- [7.3 do-while 문](/basic/loop/do-while)
- [7.4 break 문](/basic/loop/break)
- [7.5 continue 문](/basic/loop/continue)

### [08. 참조 타입](/basic/reference)
- [8.1 데이터 타입 분류](/basic/reference/classification)
- [8.2 메모리 사용 영역](/basic/reference/memory-area)
- [8.3 참조 타입 변수의 ==, != 연산](/basic/reference/equality)
- [8.4 null과 NullPointerException](/basic/reference/null)
- [8.5 문자열(String) 타입](/basic/reference/string)
- [8.6 배열(Array) 타입](/basic/reference/array)
- [8.7 다차원 배열](/basic/reference/multidimensional-array)
- [8.8 객체를 참조하는 배열](/basic/reference/object-array)
- [8.9 배열 복사](/basic/reference/array-copy)
- [8.10 배열 항목 반복을 위한 향상된 for 문](/basic/reference/enhanced-for)
- [8.11 main() 메소드의 String[] 매개변수 용도](/basic/reference/main-arguments)
- [8.12 열거(Enum) 타입](/basic/reference/enum)

---
<br>

## 확인문제
- [확인문제](./quiz)


## 정리

이 과정(Part 01. 자바 언어의 기초)을 통해 자바 프로그래밍의 가장 뼈대가 되는 핵심 문법과 동작 원리를 학습했습니다.
다음은 각 장에서 배운 가장 중요한 핵심 내용 요약입니다.

*   **Chapter 01. 자바 언어 소개**: 자바는 '운영체제(OS)에 독립적'이라는 강력한 특징을 가집니다. 작성한 소스 코드는 컴파일러를 통해 바이트코드(`.class`)로 변환되며, 이 바이트코드는 각 운영체제의 자바 가상 머신(JVM) 위에서 실행됩니다.
*   **Chapter 02. 개발 환경 구축**: 자바 프로그램을 개발하기 위해서는 JDK(Java Development Kit) 설치가 필수적입니다. 이클립스(Eclipse), 인텔리제이(IntelliJ), VS Code 등 다양한 통합 개발 환경(IDE)을 활용하여 소스 코드 작성, 컴파일, 디버깅을 효율적으로 진행할 수 있습니다.
*   **Chapter 03. 자바 시작하기**: 가장 기본적인 자바 프로그램 구조는 클래스(Class) 블록과 메인(main) 메소드 블록으로 구성됩니다. 모든 실행문의 끝에는 반드시 세미콜론(`;`)을 붙여 명령의 끝을 알려야 하며, 슬래시(`//`, `/* */`)를 활용해 코드에 주석을 달 수 있습니다.
*   **Chapter 04. 변수와 타입**: 변수는 데이터를 저장하는 메모리 공간입니다. 저장할 데이터의 종류에 따라 정수(`int`, `long`), 실수(`double`), 문자(`char`), 논리(`boolean`) 등의 적절한 기본 타입을 선택해야 합니다. 데이터의 크기에 따라 허용 범위가 다르며, 필요에 따라 자동 타입 변환이나 강제 타입 변환(Casting)이 일어납니다.
*   **Chapter 05. 연산자**: 프로그램에서 데이터를 계산하고 비교하기 위해 다양한 연산자를 사용합니다. 산술(+, -, *, /), 증감(++, --), 비교(==, !=, >, <), 논리(&&, ||, !) 연산자 등이 있으며, 복잡한 수식에서는 연산자의 우선순위와 방향(왼쪽→오른쪽 등)이 중요하게 작용합니다.
*   **Chapter 06. 조건문**: 프로그램의 실행 흐름을 제어하는 핵심 문법입니다. `if` 구문(if, else if, else)을 통해 조건식(true/false)에 따라 실행할 블록을 결정하며, 변수의 값에 따라 여러 갈래로 나눌 때는 `switch` 구문을 활용합니다.
*   **Chapter 07. 반복문**: 특정 코드를 여러 번 반복해서 실행해야 할 때 사용합니다. 반복 횟수가 명확할 때는 `for`문을, 조건에 따라 반복할 때는 `while`문을 주로 사용합니다. 반복문 내부에서 `break`를 만나면 반복을 즉시 탈출하고, `continue`를 만나면 다음 반복 회차로 넘어갑니다.
*   **Chapter 08. 참조 타입**: 기본 타입과 달리, 변수에 직접 값이 아닌 '메모리 번지수(주소)'를 저장하는 타입입니다. 배열(Array), 문자열(String), 클래스가 여기에 속합니다. 참조 타입 변수끼리의 `==` 연산은 값이 아닌 주소가 같은지를 비교하며, 주소를 잃어버린 빈 상태는 `null` 키워드로 표현합니다. 이를 잘못 접근하면 `NullPointerException`이 발생합니다.
