---
layout: basic
title: "8.8 배열 복사"
nav_order: 8
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.8 배열 복사

## 1. 이사 가기 🚚

배열은 한 번 만들면 **크기를 바꿀 수 없습니다.** (건물을 늘릴 수 없는 것처럼요.)
더 많은 공간이 필요하면 **더 큰 배열을 새로 짓고 이사(복사)**를 가야 합니다.

## 2. System.arraycopy()

`for` 문으로 하나씩 옮겨도 되지만, 이삿짐센터(`System.arraycopy`)를 부르면 훨씬 빠릅니다.

```java
String[] oldStr = { "java", "array", "copy" };
String[] newStr = new String[5]; // 더 큰 집

// (원본, 시작위치, 새배열, 시작위치, 개수)
System.arraycopy(oldStr, 0, newStr, 0, oldStr.length);
```

이제 `newStr`에는 3개의 데이터가 복사되어 있고, 나머지 2칸은 비어있습니다(`null`).
