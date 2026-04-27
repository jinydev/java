layout: part03
title: "17.14 기본 문자셋 변경"
nav_order: 14
parent: "17. 데이터 입출력"
grand_parent: "Part 03. 라이브러리 활용"
---

# 21.8 기본 문자셋 변경

자바는 JVM이 실행될 때 운영체제의 환경에 따라 자바 기본 문자셋이 결정되었다. 맥OS는 UTF-8을 기본 문자셋으로 사용했고, 한글 윈도우는 x-windows-949(MS949)를 사용했다. 자바 21부터는 자바 기본 문자셋이 UTF-8로 통일되었으며, 이로써 운영체제의 환경에 의존하지 않고 어떤 실행 환경에서든 모두 UTF-8 문자셋을 사용한다.

## 바이트 수

기본 문자셋이 달라지면 숫자와 영어 문자는 문제가 되지 않지만, 한글 문자는 처리 바이트 수가 달라진다. MS949는 한글 문자를 2byte로 처리하지만, UTF-8은 한글 문자를 3byte로 처리하기 때문이다.

## 호환성 있는 코드

파일 입출력이나 네트워크 통신 시 문자셋 문제로 인한 호환성 문제를 해결하기 위해 명시적으로 문자셋을 지정하는 것이 좋다.

```java
byte[] bytes = "자바".getBytes(Charset.forName("UTF-8"));
FileWriter writer = new FileWriter(file, Charset.forName("UTF-8"));
```
