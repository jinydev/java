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
*자바의 역사, 특징, JVM의 역할 등 자바 언어의 탄생 배경과 기본적인 동작 원리를 알아봅니다.*
- [1.1 프로그래밍 언어와 자바](/basic/java/programming-language)
- [1.2 자바의 역사와 제임스 고스링](/basic/java/history)
- [1.3 자바의 특징](/basic/java/features)
- [1.4 바이트코드 파일과 자바 가상 머신](/basic/java/jvm)

### [02. 개발 환경 구축](/basic/setup)
*자바 프로그래밍에 필요한 JDK 설치부터 이클립스, 인텔리제이, VS Code 등 다양한 IDE 세팅 방법을 배웁니다.*
- [2.1 JDK 설치](/basic/setup/jdk-installation)
- [2.2 환경 변수 설정](/basic/setup/environment-variable)
- [2.3 이클립스 설치](/basic/setup/eclipse-installation)
- [2.4 이클립스 프로젝트 생성](/basic/setup/eclipse-project)
- [2.5 이클립스 소스 작성부터 실행](/basic/setup/eclipse-execution)
- [2.6 인텔리제이 설치 및 소개](/basic/setup/intellij-installation)
- [2.7 VS Code 설치](/basic/setup/vscode-installation)
- [2.8 안티그라비티 소개](/basic/setup/antigravity)

### [03. 자바 시작하기](/basic/start)
*첫 자바 소스 코드를 작성하고 컴파일하여 실행하는 흐름을 체득하며, 주석 작성법과 세미콜론의 역할을 익힙니다.*
- [3.1 소스 작성부터 실행까지](/basic/start/execution-process)
- [3.2 코드 용어 이해](/basic/start/code-terminology)
- [3.3 코드 주석 달기](/basic/start/comments)
- [3.4 실행문과 세미콜론](/basic/start/statements)

### [04. 변수와 타입](/basic/variable)
*데이터를 그릇에 담는 변수의 개념과, 정수·실수·문자·논리 등 메모리 효율을 위한 다양한 기본 자료형 및 형변환(Casting)을 다룹니다.*
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
*데이터를 가공하기 위한 산술, 비교, 논리, 대입 연산자와 연산 방향 및 우선순위에 대해 상세히 학습합니다.*
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
*특정 조건에 따라 코드의 실행 경로를 나누는 흐름 제어의 핵심인 if 문과 switch 문의 문법과 활용처를 배웁니다.*
- [6.1 코드 실행 흐름 제어](/basic/condition/flow-control)
- [6.2 if 문](/basic/condition/if)
- [6.3 switch 문](/basic/condition/switch)

### [07. 반복문](/basic/loop)
*중복되는 코드를 효율적으로 처리하기 위해 주어진 조건만큼 반복 실행을 지시하는 for, while, do-while 문을 실습합니다.*
- [7.1 for 문](/basic/loop/for)
- [7.2 while 문](/basic/loop/while)
- [7.3 do-while 문](/basic/loop/do-while)
- [7.4 break 문](/basic/loop/break)
- [7.5 continue 문](/basic/loop/continue)

### [08. 참조 타입](/basic/reference)
*배열, 문자열 등 데이터 자체가 아닌 메모리의 번지수를 참조하는 고급 자료형의 개념과 Null 관리에 대해 학습합니다.*
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
자바의 기본적인 문법을 학습하였습니다. 

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 자바의 기초를 시작하며 자주 보게 될 영단어들을 가볍게 눈에 익혀 볼까요?

*   **`Basic`**: 베이직, 기초. (프로그래밍 언어를 배울 때 가장 근본이 되는 뼈대 문법과 원리)
*   **`Part`**: 파트, 부분, 편. (전체 학습 과정을 크게 나눈 넓은 범위의 단위)
*   **`Chapter`**: 챕터, 장. (각 파트 안에서 세부 주제별로 나눈 구체적인 학습 단위)

