---
layout: oop
title: "13.3 응용프로그램 모듈화"
nav_order: 3
parent: "Chapter 13. 라이브러리와 모듈"
grand_parent: "객체지향 자바 프로그래밍"
---

# 13.3 응용프로그램 모듈화 (Modularity)


<br>

## 1. 레고 블록 조립하기 🧱

거대한 프로그램을 만들 때, 모든 코드를 하나의 프로젝트에 몽땅 때려 넣으면 어떻게 될까요?
나중에 수정하기도 힘들고, 여러 사람이 나눠서 작업하기도 어렵습니다. 이것을 **모 놀리식(Monolithic)** 구조라고 합니다.

반면에, 기능을 잘게 쪼개서 **"전용 레고 블록(모듈)"**들로 만든 다음, 필요한 것끼리 조립하는 방식을 **모듈화(Modular)**라고 합니다.

![Monolith vs Modular](./img/monolith_vs_modular.svg)

*   **장점**:
    1.  **협업**: A팀은 '회원 모듈', B팀은 '결제 모듈'만 집중해서 만들면 됩니다.
    2.  **재사용**: 잘 만든 '결제 모듈'은 다른 쇼핑몰 프로젝트에도 그대로 가져다 쓸 수 있습니다.
    3.  **교체 용이**: 기능이 맘에 안 들면 해당 모듈(블록)만 쏙 빼서 새것으로 갈아끼우면 됩니다.

<br>


<br>

## 2. 모듈 연결하기 (requires)

레고 블록을 연결하려면 요철이 맞아야 하듯이, 모듈끼리도 **연결 고리(`requires`)**가 필요합니다.
우리가 만들 응용프로그램(`App`)이 `Module A`와 `Module B`를 사용한다고 해봅시다.

![Module Dependency](./img/module_dependency_graph.svg)

### 📌 실습 시나리오
1.  **`my_module_a`**: 기능 A 제공 (수출: `exports`)
2.  **`my_module_b`**: 기능 B 제공 (수출: `exports`)
3.  **`my_application`**: 위 두 모듈을 조립해서 실행 (수입: `requires`)

### 1단계: 모듈 A 만들기 (`module-info.java`)
```java
// my_module_a/src/module-info.java
module my_module_a {
    exports pack1; // pack1 패키지를 외부에서 쓸 수 있게 공개
}
```

### 2단계: 모듈 B 만들기 (`module-info.java`)
```java
// my_module_b/src/module-info.java
module my_module_b {
    exports pack2;
}
```

### 3단계: 애플리케이션에서 조립하기
```java
// my_application/src/module-info.java
module my_application {
    requires my_module_a; // 모듈 A가 필요해!
    requires my_module_b; // 모듈 B도 필요해!
}
```

이렇게 `requires`를 선언하면, 애플리케이션 안에서 `pack1`, `pack2` 패키지에 있는 클래스를 자유롭게 `import` 해서 쓸 수 있습니다.

> **핵심 요약**: 모듈화는 **"작게 만들어서 크게 조립하는 기술"**입니다. `module-info.java`는 이 조립 설명서 역할을 합니다.
