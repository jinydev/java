---
layout: basic
title: "3.1 소스 작성부터 실행까지"
nav_order: 1
parent: "Chapter 03. 자바 시작하기"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 3.1 소스 작성부터 실행까지

## 1. 실습 목표 🎯

가장 기본적인 자바 프로그램인 **"Hello, Java"**를 출력하는 프로그램을 만들어 봅시다.

## 2. 폴더 만들기 (작업실 준비)

탐색기(Finder)에서 `C:\temp` (또는 원하는 곳) 폴더를 만들고, 그 안에 `Hello.java` 파일을 만듭니다.

```
C:\temp
 └─ Hello.java  <-- 우리가 작성할 소스 파일
```

## 3. 코드 작성 (레시피 적기)

`Hello.java` 파일을 메모장이나 텍스트 에디터로 열어서 아래 내용을 똑같이 적어보세요.
(대소문자를 정확히 지켜야 합니다!)

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java");
    }
}
```

## 4. 실행해보기 (요리하기)

터미널(명령 프롬프트)을 열고, 파일이 있는 곳으로 이동해서 실행합니다.

### 1) 컴파일 (번역)
```bash
javac Hello.java
```
*   아무 오류 없이 끝나면 `Hello.class` 파일(바이트코드)이 생깁니다.

### 2) 실행 (Run)
```bash
java Hello
```
*   **주의**: `Hello.class`가 아니라 그냥 `Hello`라고 입력하세요.

### 결과 확인
```
Hello, Java
```
화면에 문구가 출력되면 성공입니다! 🎉
