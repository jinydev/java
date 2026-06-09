---
layout: oop
title: "15.7 수학 클래스 (Math)"
nav_order: 7
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
description: "15.7 수학 클래스 (Math) 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "15.7 수학 클래스 (Math), 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 15.7 수학 클래스 (Math)


<br>

## 1. 공학용 계산기 🧮

`Math` 클래스는 수학 계산을 돕는 도구 모음입니다.
모두 **정적(static) 메소드**이므로 객체 생성 없이 바로 씁니다.

| 기능       | 메소드  | 예시              | 결과  |
| :--------- | :------ | :---------------- | :---- |
| **절대값** | `abs`   | `Math.abs(-5)`    | `5`   |
| **올림**   | `ceil`  | `Math.ceil(5.3)`  | `6.0` |
| **버림**   | `floor` | `Math.floor(5.7)` | `5.0` |
| **반올림** | `round` | `Math.round(5.3)` | `5`   |
| **최대값** | `max`   | `Math.max(5, 10)` | `10`  |
| **최소값** | `min`   | `Math.min(5, 10)` | `5`   |


<br>

## 2. 주사위 던지기 (`random`) 🎲

`Math.random()`은 `0.0` 이상 `1.0` 미만의 난수(Random Number)를 줍니다.
이걸 잘 조절하면 주사위나 로또 번호를 만들 수 있습니다.

**공식**: `(int) (Math.random() * 개수) + 시작숫자`

```java
// 1부터 시작하는 6개의 정수 (주사위)
int num = (int) (Math.random() * 6) + 1;
System.out.println("주사위 눈: " + num);
```


<br>

## 3. 전문 난수 생성기 (`Random` 클래스)

`Math.random()`보다 더 다양한 기능을 원하면 `java.util.Random` 클래스를 씁니다.

```java
import java.util.Random;

Random random = new Random();

boolean b = random.nextBoolean(); // true/false
int i = random.nextInt(10);       // 0 ~ 9 사이 정수
double d = random.nextDouble();   // 0.0 ~ 1.0 사이 실수
```

> **핵심**: 복잡한 수학 공식은 **`Math`** 클래스에게 맡기세요.

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Math`**: 매쓰, 수학. (골치 아픈 올림, 버림, 최대값, 로또 번호 뽑기 같은 계산들을 `Math.max()` 처럼 마법의 주문 한 줄로 대신해주는 자바의 든든한 공학용 계산기 클래스)
*   **`Random`**: 랜덤, 무작위의. (`Math.random()`을 호출할 때마다 `0.0`부터 `0.999...` 사이에서 컴퓨터가 주사위를 굴리듯 아무 숫자나 휙휙 뱉어내는 예측 불가한 고마운 기능)
