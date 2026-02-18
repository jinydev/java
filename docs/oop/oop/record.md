layout: oop
title: "6.16 레코드 패턴"
nav_order: 16
parent: "06. 클래스"
grand_parent: "Part 02. 객체지향"
---

# 21.5 레코드 패턴

자바 21에서 지원하는 레코드 패턴(Record Patterns)은 레코드의 필드값을 분해해서 변수에 대입하는 기능을 제공한다. 레코드의 필드값을 얻기 위해 Getter를 호출할 필요 없이 매개변수로 바로 받을 수 있어 매우 편리해졌다.

레코드 패턴은 `instanceof` 연산자와 switch 문의 레이블에서 다음과 같이 작성될 수 있다.

```java
if (obj instanceof 레코드(타입 변수, 타입 변수)) {
    // 레코드 패턴 변수 사용
}

switch (obj) {
    case 레코드(타입 변수, 타입 변수) -> {
        // 레코드 패턴 변수 사용
    }
}
```

예를 들어, `Rectangle` 레코드가 있다면:

```java
public record Rectangle(int width, int height) {}

// 자바 21 레코드 패턴
if (obj instanceof Rectangle(int width, int height)) {
    System.out.println("area: " + (width * height));
}
```
