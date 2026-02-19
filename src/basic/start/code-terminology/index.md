---
layout: basic
title: "3.2 코드 용어 이해"
nav_order: 2
parent: "Chapter 03. 자바 시작하기"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 3.2 코드 용어 이해

방금 작성한 코드를 해부해 봅시다. 🕵️‍♂️

```java
package ch01; // ① 패키지

public class Hello { // ② 클래스
    
    public static void main(String[] args) { // ③ 메인 메소드
        System.out.println("Hello"); // ④ 실행문
    }

}
```

## 1. 패키지 (Package) 📂
*   **비유**: **폴더**
*   비슷한 소스 파일들을 모아놓는 그룹입니다.
*   `package ch01;`은 "이 파일은 `ch01` 폴더에 소속되어 있어"라고 선언하는 것입니다.

## 2. 클래스 (Class) 📄
*   **비유**: **파일 이름**
*   자바 프로그램의 기본 단위입니다.
*   **규칙**: 클래스 이름(`Hello`)은 소스 파일 이름(`Hello.java`)과 **똑같아야 합니다.** (대소문자까지!)

## 3. 메인 메소드 (main method) ▶️
*   **비유**: **시작 버튼 (Engine Start)**
*   `public static void main(String[] args)`
*   자바 프로그램은 무조건 **여기서부터 실행**됩니다. 이 부분이 없으면 실행할 수 없습니다.

## 4. 실행문 (Statement) ✍️
*   **비유**: **명령어**
*   `System.out.println(...)`: 콘솔(화면)에 글자를 출력하라는 명령입니다.
