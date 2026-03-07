---
layout: part04
title: "23.10 프로시저와 함수 호출"
nav_order: 10
parent: "Chapter 23. 데이터베이스 입출력 (Oracle)"
grand_parent: "데이터 입출력"
description: "23.10 프로시저와 함수 호출 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "23.10 프로시저와 함수 호출, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 23.10 프로시저와 함수 호출

프로시저와 함수는 `CallableStatement`를 사용하여 호출한다. connection의 `prepareCall()` 메소드를 사용한다.

*   프로시저 호출: `{ call 프로시저명(?, ?, ...) }`
*   함수 호출: `{ ? = call 함수명(?, ?, ...) }`

리턴값(OUT 파라미터)은 `registerOutParameter()` 메소드로 타입을 지정하고, 실행 후 `get타입()` 메소드로 값을 얻는다.
