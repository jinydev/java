---
layout: oop
title: "6.3 클래스 선언"
nav_order: 3
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
description: "6.3 클래스 선언 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "6.3 클래스 선언, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 6.3 클래스 선언 (설계도 작성하기)

## 클래스 선언이란?

자, 이제 직접 **설계도(클래스)**를 만들어 볼 차례입니다.
설계도에는 다음과 같은 내용이 들어가야 합니다.

1.  **이름**: 설계도 이름 (클래스명)
2.  **구성 요소**: 어떤 부품(필드)과 어떤 기능(메소드)이 필요한지

![Class Structure](./img/class_structure.png)

자바에서는 다음과 같이 작성합니다.

```java
// 공개된(public) 클래스(class)를 선언합니다. 이름은 '클래스명'입니다.
public class 클래스명 {
    // 여기에 필드와 메소드를 적습니다.
}
```

## 클래스 이름 짓기 (작명 규칙)

클래스 이름을 지을 때는 **'캐멀 스타일(CamelCase)'**을 따르는 것이 약속입니다. 낙타 등처럼 울퉁불퉁하다는 뜻이죠.

1.  **첫 글자는 대문자**: `Car`, `Person`
2.  **단어가 합쳐질 때마다 첫 글자를 대문자로**: `SportsCar`, `ChatServer`

*   `sportscar` (X) -> 단어 구분이 어려워요.
*   `sports_car` (X) -> 자바 클래스 이름으로는 잘 안 써요.
*   `SportsCar` (O) -> **캐멀 스타일!**

![Camel Case SportsCar](./img/camel_case_sportscar.png)

## 소스 파일 만들기

이클립스 같은 도구를 쓰면 아주 쉽게 클래스를 만들 수 있습니다.
우리가 `SportsCar`라는 클래스를 만들면, 자바는 똑같은 이름의 `SportsCar.java` 파일을 만듭니다.

**SportsCar.java**
```java
package ch06.sec03; // 패키지는 '폴더'라고 생각하면 됩니다.

public class SportsCar { // 클래스 선언 시작
}
```

## 하나의 파일에 여러 클래스? (TMI)

하나의 `.java` 파일 안에 여러 개의 `class`를 선언할 수도 있습니다.
하지만 **주인공은 단 한 명**입니다. 파일 이름과 똑같은 클래스만 `public` (공개) 키워드를 가질 수 있습니다.

**SportsCar.java**
```java
public class SportsCar { // 주인공! (파일명과 같음)
---

# 6.3 클래스 선언 (설계도 작성하기)

## 클래스 선언이란?

자, 이제 직접 **설계도(클래스)**를 만들어 볼 차례입니다.
설계도에는 다음과 같은 내용이 들어가야 합니다.

1.  **이름**: 설계도 이름 (클래스명)
2.  **구성 요소**: 어떤 부품(필드)과 어떤 기능(메소드)이 필요한지

![Class Structure](./img/class_structure.png)

자바에서는 다음과 같이 작성합니다.

```java
// 공개된(public) 클래스(class)를 선언합니다. 이름은 '클래스명'입니다.
public class 클래스명 {
    // 여기에 필드와 메소드를 적습니다.
}
```

## 클래스 이름 짓기 (작명 규칙)

클래스 이름을 지을 때는 **'캐멀 스타일(CamelCase)'**을 따르는 것이 약속입니다. 낙타 등처럼 울퉁불퉁하다는 뜻이죠.

1.  **첫 글자는 대문자**: `Car`, `Person`
2.  **단어가 합쳐질 때마다 첫 글자를 대문자로**: `SportsCar`, `ChatServer`

*   `sportscar` (X) -> 단어 구분이 어려워요.
*   `sports_car` (X) -> 자바 클래스 이름으로는 잘 안 써요.
*   `SportsCar` (O) -> **캐멀 스타일!**

![Camel Case SportsCar](./img/camel_case_sportscar.png)

## 소스 파일 만들기

이클립스 같은 도구를 쓰면 아주 쉽게 클래스를 만들 수 있습니다.
우리가 `SportsCar`라는 클래스를 만들면, 자바는 똑같은 이름의 `SportsCar.java` 파일을 만듭니다.

**SportsCar.java**
```java
package ch06.sec03; // 패키지는 '폴더'라고 생각하면 됩니다.

public class SportsCar { // 클래스 선언 시작
}
```

## 하나의 파일에 여러 클래스? (TMI)

하나의 `.java` 파일 안에 여러 개의 `class`를 선언할 수도 있습니다.
하지만 **주인공은 단 한 명**입니다. 파일 이름과 똑같은 클래스만 `public` (공개) 키워드를 가질 수 있습니다.

**SportsCar.java**
```java
public class SportsCar { // 주인공! (파일명과 같음)
}

class Tire { // 조연 (파일명과 다름, public 못 붙임)
}
```

*   컴파일하면 `SportsCar.class`와 `Tire.class` 두 개의 파일이 생깁니다.
*   하지만 보통은 헷갈리지 않게 **파일 하나당 클래스 하나**를 만드는 것이 가장 좋습니다.

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Class`**: 클래스. (현실 세계의 사물이나 개념을 컴퓨터 메모리에 똑같이 본떠 만들기 위해 짜여진 청사진, 설계도)
*   **`Declaration`**: 선언. (이러한 이름과 뼈대로 클래스라는 설계도를 만들겠다고 자바 컴파일러에게 정식으로 알리는 행위)
*   **`CamelCase`**: 캐멀 케이스. (둘 이상의 단어가 이어질 때 각 단어의 첫 글자를 대문자로 써서 띄어쓰기를 대신하는 작명 방식. 낙타(Camel)의 울퉁불퉁한 등처럼 보인다고 해서 붙은 이름)
