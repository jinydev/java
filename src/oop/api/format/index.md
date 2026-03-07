---
layout: oop
title: "15.9 형식 클래스 (Format)"
nav_order: 9
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
description: "15.9 형식 클래스 (Format) 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "15.9 형식 클래스 (Format), 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 15.9 형식 클래스 (Format)


<br>

## 1. 데이터 디자이너 (Decorator) 🎨

숫자나 날짜를 **"보기 좋게 꾸며주는 역할"**을 합니다.
천 단위마다 콤마(`,`)를 찍거나, 날짜를 "2024년 2월 20일"처럼 바꾸고 싶을 때 사용합니다.

| 클래스                 | 용도                                 |
| :--------------------- | :----------------------------------- |
| **`DecimalFormat`**    | 숫자 꾸미기 (`12345` -> `12,345`)    |
| **`SimpleDateFormat`** | 날짜 꾸미기 (`Date` -> `2024-02-20`) |


<br>

## 2. 숫자 꾸미기 (`DecimalFormat`)

`#`과 `0`을 사용해 패턴을 만듭니다.
*   `#`: 숫자가 있으면 출력, 없으면 생략.
*   `0`: 숫자가 없으면 0으로 채움.
*   `,`: 단위 구분 기호.

```java
double num = 1234567.89;

// 천 단위 콤마 + 소수점 한 자리
DecimalFormat df = new DecimalFormat("#,###.0");
System.out.println(df.format(num)); // 1,234,567.9
```


<br>

## 3. 날짜 꾸미기 (`SimpleDateFormat`)

`Date` 객체를 원하는 문자열 형식으로 바꿔줍니다.

*   `yyyy`: 년도 (4자리)
*   `MM`: 월 (2자리)
*   `dd`: 일 (2자리)
*   `HH`: 시 (24시간)
*   `mm`: 분
*   `ss`: 초

```java
Date now = new Date();

SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
System.out.println(sdf.format(now)); 
// 출력: 2024년 02월 20일 10시 30분
```

> **핵심**: 데이터의 **"화장(Make-up)"**이 필요할 때 `Format` 클래스를 부르세요.
