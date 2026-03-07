---
layout: part04
title: "23.8 데이터 삭제"
nav_order: 8
parent: "Chapter 23. 데이터베이스 입출력 (Oracle)"
grand_parent: "데이터 입출력"
description: "23.8 데이터 삭제 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "23.8 데이터 삭제, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 23.8 데이터 삭제

데이터 삭제는 `DELETE` 문을 사용한다.

```java
String sql = "DELETE FROM boards WHERE bwriter=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "winter");
int rows = pstmt.executeUpdate();
```
