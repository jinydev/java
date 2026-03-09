layout: basic
title: "6.5 switch 문의 null 처리"
nav_order: 5
parent: "Chapter 06. 조건문"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 6.5 switch 문의 null 처리

자바 17까지는 표현값이 `null`일 경우 switch 문에서 `NullPointerException`이 발생했지만, 자바 21부터는 다음과 같이 레이블에 `null`을 지정해서 예외를 발생시키지 않고 `null`을 처리할 수 있게 되었다.

```mermaid
flowchart LR
    Input([입력 객체]) --> CheckNull{null 인가?}
    
    CheckNull -- "예 (기존)" --> NPE[💣 NullPointerException 발생!]
    CheckNull -- "예 (Java 21+)" --> CaseNull["case null 실행 (안전하게 처리)"]
    
    style Input fill:#f9f,stroke:#333,stroke-width:2px
    style CheckNull fill:#ff9,stroke:#333,stroke-width:2px
    style NPE fill:#f99,stroke:#333,stroke-width:2px,stroke-dasharray: 5 5
    style CaseNull fill:#bbf,stroke:#333,stroke-width:2px
```

```java
switch (object) {
    case null -> { ... } // object가 null일 경우 선택
    case null, default -> { ... } // object가 null이거나 위의 case가 선택되지 않은 경우 선택
}
```

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`NullPointerException (NPE)`**: 널 포인터 익셉션. (존재하지 않는 빈 주소(null)를 참조하려 할 때 발생하는 치명적인 에러)
