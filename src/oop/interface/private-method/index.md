---
layout: oop
title: "11.12 프라이빗 메소드"
nav_order: 12
parent: "Chapter 11. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
description: "11.12 프라이빗 메소드 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "11.12 프라이빗 메소드, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 11.12 프라이빗 메소드 (비밀 레시피)

Java 9부터는 인터페이스 내부에 **`private` 메소드**를 만들 수 있게 되었습니다.
인터페이스는 원래 "공개(public)"가 원칙이었는데, 왜 굳이 숨겨진 메소드를 허용했을까요?

### 💡 핵심 비유: 식당의 메뉴판과 주방
> **"손님에게 보여주는 메뉴판(public)은 깔끔해야 한다. 복잡한 요리 과정(private)은 주방 안에서만 공유하고, 밖으로 드러내지 않는다."**

![Secret Recipe](./img/interface_private_secret.svg)

---


<br>

## 1. 사용 목적 (코드 중복 제거)

여러 `default` 메소드나 `static` 메소드에서 **공통적으로 반복되는 코드**가 있을 때, 이를 외부로 노출하지 않으면서 재사용하기 위해 사용합니다.

### 🛑 Before (중복 발생)
```java
public interface Service {
    default void methodA() {
        System.out.println("보안 검사 시작"); // 중복!
        System.out.println("로그 기록");      // 중복!
        System.out.println("A 작업 수행");
    }

    default void methodB() {
        System.out.println("보안 검사 시작"); // 중복!
        System.out.println("로그 기록");      // 중복!
        System.out.println("B 작업 수행");
    }
}
```

### ✅ After (Private 메소드로 분리)
![Code Deduplication](./img/interface_private_code_dedup.svg)

```java
public interface Service {
    default void methodA() {
        commonLogic(); // 공통 코드 호출
        System.out.println("A 작업 수행");
    }

    default void methodB() {
        commonLogic(); // 공통 코드 호출
        System.out.println("B 작업 수행");
    }

    // 외부에는 안 보이고, 내부에서만 쓰는 비밀 도우미
    private void commonLogic() {
        System.out.println("보안 검사 시작");
        System.out.println("로그 기록");
    }
}
```


<br>

## 2. 종류

1.  **`private` 메소드**: `default` 메소드에서 호출 가능.
2.  **`private static` 메소드**: `static` 메소드에서 호출 가능. (물론 `default`에서도 호출 가능)

이제 인터페이스 내부 코드도 **"보여줄 것(Signature)"**과 **"감출 것(Implementation Details)"**을 명확히 나눌 수 있게 되었습니다.

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Private Method`**: 프라이빗 메소드. (식당 주방에서 셰프들끼리만 몰래 돌려보는 비밀 레시피처럼, 인터페이스 외부에는 꼭꼭 숨긴 채 자기들(`default`나 `static` 메소드)끼리만 공통으로 가져다 쓰는 내부 전용 숨김 메소드)
*   **`Code Deduplication`**: 코드 중복 제거. (여러 곳에 똑같이 흩어져 있는 지저분한 복사-붙여넣기 코드를 하나의 프라이빗 메소드로 깔끔하게 묶어내어 청소하는 행위)
