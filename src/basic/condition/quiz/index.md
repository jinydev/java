---
layout: basic
title: "확인문제"
nav_order: 99
parent: "Chapter 04. 조건문"
grand_parent: "객체지향 자바 프로그래밍"
description: "확인문제 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "확인문제, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 확인문제

1. 조건문과 반복문에 대해 잘못 설명한 것은 무엇입니까?
   1. `if` 문은 조건식의 결과에 따라 실행 흐름을 달리할 수 있다.
   2. `switch` 문에서 사용할 수 있는 변수의 타입은 `int`, `double`이 될 수 있다.
   3. `for` 문은 카운터 변수로 지정한 횟수만큼 반복시킬 때 사용할 수 있다.
   4. `break` 문은 `switch` 문, `for` 문, `while` 문을 종료할 때 사용할 수 있다.

2. 왼쪽 `switch` 문을 Expression (표현식)으로 변경해서 오른쪽에 작성해 보세요.
   ```java
   String grade = "B";
   int score1 = 0;
   switch(grade) {
       case "A":
---

# 확인문제

1. 조건문과 반복문에 대해 잘못 설명한 것은 무엇입니까?
   1. `if` 문은 조건식의 결과에 따라 실행 흐름을 달리할 수 있다.
   2. `switch` 문에서 사용할 수 있는 변수의 타입은 `int`, `double`이 될 수 있다.
   3. `for` 문은 카운터 변수로 지정한 횟수만큼 반복시킬 때 사용할 수 있다.
   4. `break` 문은 `switch` 문, `for` 문, `while` 문을 종료할 때 사용할 수 있다.

2. 왼쪽 `switch` 문을 Expression (표현식)으로 변경해서 오른쪽에 작성해 보세요.
   ```java
   String grade = "B";
   int score1 = 0;
   switch(grade) {
       case "A":
           score1 = 100;
           break;
       case "B":
           int result = 100 - 20;
           score1 = result;
           break;
       default:
           score1 = 60;
   }
   ```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Quiz`**: 퀴즈, 간단한 시험. (지금까지 배운 조건문에 대한 중요한 기본 지식들을 스스로 점검해 보는 알찬 시간)
