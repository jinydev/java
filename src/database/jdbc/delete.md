---
layout: part04
title: "20.8 데이터 삭제"
nav_order: 8
parent: "Chapter 20. 데이터베이스 입출력"
grand_parent: "데이터 입출력"
---

# 20.8 데이터 삭제

데이터 삭제는 `DELETE` 문을 사용한다.

```java
String sql = "DELETE FROM boards WHERE bwriter=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "winter");
int rows = pstmt.executeUpdate();
```
