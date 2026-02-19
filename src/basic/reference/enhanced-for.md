---
layout: basic
title: "8.9 향상된 for 문"
nav_order: 9
parent: "Chapter 08. 참조 타입"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 8.9 향상된 for 문

## 1. 하나씩 다 꺼내줘! 🍬

배열이나 리스트에 있는 모든 항목을 처음부터 끝까지 하나씩 꺼내고 싶을 때 사용합니다.
`i` (인덱스)를 안 써도 돼서 코드가 아주 깔끔합니다.

```java
int[] scores = { 95, 71, 84, 93, 87 };

// 옛날 방식
for(int i=0; i<scores.length; i++) {
    System.out.println(scores[i]);
}

// 향상된 for 문
for(int s : scores) {
    System.out.println(s);
}
```

**"scores 안에 있는 거 하나씩 꺼내서 s에 담아줘."** 라는 뜻입니다.
