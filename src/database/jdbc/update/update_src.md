---
layout: part04
title: "20.7 데이터 수정"
nav_order: 7
parent: "Chapter 20. 데이터베이스 입출력"
grand_parent: "데이터 입출력"
description: "20.7 데이터 수정 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "20.7 데이터 수정, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 20.7 데이터 수정

데이터 수정은 `UPDATE` 문을 사용한다. `PreparedStatement`를 이용하여 매개변수 값을 설정하고 `executeUpdate()` 메소드를 호출한다.

```java
String sql = "UPDATE boards SET btitle=?, bcontent=?, bfilename=?, bfiledata=? WHERE bno=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
// ... 값 설정 ...
int rows = pstmt.executeUpdate();
```
