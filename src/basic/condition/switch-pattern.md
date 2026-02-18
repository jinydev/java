layout: basic
title: "4.5 switch 문의 패턴 매칭"
nav_order: 5
parent: "04. 조건문"
grand_parent: "Part 01. 자바 기초"
---

# 21.4 switch 문의 패턴 매칭

자바 21부터는 다음과 같이 switch 레이블에 패턴과 가드를 작성해서 표현값과 매칭시킬 수도 있다. 이 방식은 표현값이 객체를 참조하는 변수일 경우에만 사용할 수 있다.

## 레이블에 패턴 사용

소괄호 안의 표현값이 참조 타입 변수일 경우 패턴을 사용해서 타입 검사를 수행하고, 자동 타입 변환해서 패턴 변수를 초기화시킨다. 그리고 패턴 변수를 중괄호 블록에서 사용할 수 있다.

```java
switch (object) {
    case Integer i -> { ... } // object가 Integer 타입인 경우 매칭 (자동 타입 변환)
    case String s -> { ... } // object가 String 타입인 경우 매칭 (자동 타입 변환)
    case null, default -> { ... } // object가 null이거나 그 이외의 타입일 경우 매칭
}
```

표현값은 패턴 중 하나와 반드시 매칭되도록 해야 한다. 만약 매칭할 패턴이 없을 경우에는 나머지 매칭을 위해 `default`를 포함해야 한다. 이것을 표현값과 실행문의 완전성(exhaustiveness)이라고 하는데, 표현값이 반드시 실행문에서 처리되어야 함을 뜻한다.

## 가드 사용

패턴과 함께 좀 더 상세한 일치 조건을 만들기 위해 `when`으로 시작하는 가드(guard)를 사용할 수 있다. `when` 다음에는 패턴 변수를 사용해서 `boolean`을 리턴하는 조건식 또는 메소드 호출 코드가 올 수 있다. `true`를 리턴하면 레이블이 선택되고 중괄호가 실행된다.

```java
switch (object) {
    case Integer i when i > 0 -> { ... } // object가 Integer 타입이면서 양수일 경우 선택
    case String s when s.equals("a") -> { ... } // object가 String 타입이면서 "a"일 경우 선택
}
```

## 레이블 통과

레이블에 패턴이 사용되면 기본적으로 다음 레이블로 통과가 금지된다. 단, 다음이 `default`라면 통과할 수 있지만 화살표가 사용되면 무조건 통과가 금지된다.

```java
switch (object) {
    case String s:
        // break; // 생략하면 컴파일 에러 생김 (다음 레이블로 무조건 통과 금지)
    case Integer i:
        // break; // 명시적 통과 금지
    default:
}
```

## 레이블 작성 순서

레이블이 패턴일 경우에는 좁은 범위의 패턴을 먼저 작성하고, 넓은 범위의 패턴을 나중에 작성해야 한다. switch 문은 위에서부터 순차적으로 표현값과 패턴을 매칭하기 때문에 위쪽 패턴이 먼저 매칭되면 아래쪽 패턴은 검사하지 않는다.

```java
Integer data = 3;
switch (data) {
    case 0 -> System.out.println("0"); // ①
    case Integer i when i > 0 -> System.out.println("0 or positive number"); // ②
    case Integer i -> System.out.println("negative number"); // ③
}
```

정수의 범위를 비교하면 ①보다 ③이 넓고, ②보다 ③이 넓다. 따라서 레이블을 작성할 때 ①, ② 뒤에 ③이 오도록 작성해야 한다. 순서를 바꾸면 컴파일 에러가 발생한다.

## 인터페이스 타입의 표현값과 enum 레이블

자바 21에서는 패턴 매칭을 사용할 수 있기 때문에 표현값에 인터페이스 타입이 올 수 있다. 인터페이스는 여러 가지 `enum`을 그룹핑할 목적으로 사용할 수 있다.

```java
public sealed interface Drawable permits Shape, Image { }

public enum Shape implements Drawable { LINE, TRIANGLE, RECTANGLE }
public enum Image implements Drawable { JPEG, PNG }
```

자바 21에서는 switch 문의 표현값이 `Drawable` 타입이라면 `Drawable`로 그룹핑된 모든 `enum` 상수를 레이블로 작성할 수 있다.

```java
String result = switch (drawable) {
    case Shape.LINE -> "선을 그립니다.";
    case Shape.TRIANGLE -> "삼각형을 그립니다.";
    case Shape.RECTANGLE -> "사각형을 그립니다.";
    case Image.JPEG -> "JPEG 이미지를 그립니다.";
    case Image.PNG -> "PNG 이미지를 그립니다.";
    default -> "도형을 그리지 않습니다.";
};
```
