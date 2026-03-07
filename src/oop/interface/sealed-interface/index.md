---
layout: oop
title: "11.13 봉인된 인터페이스"
nav_order: 13
parent: "Chapter 11. 인터페이스"
grand_parent: "객체지향 자바 프로그래밍"
description: "11.13 봉인된 인터페이스 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "11.13 봉인된 인터페이스, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 11.13 봉인된 인터페이스 (Sealed Interface)

Java 15에서 도입된 `sealed` 인터페이스는 **"허락된 자식만 상속받을 수 있는"** 폐쇄적인 인터페이스입니다.
아무나 구현(`implements`)하거나 상속(`extends`)하지 못하게 막고 싶을 때 사용합니다.

### 💡 핵심 비유: VIP 회원제 클럽
> **"이 클럽(Interface)은 아무나 가입할 수 없다. 오직 초대받은 멤버(Permits)만 들어올 수 있다."**

![VIP Permit](./img/interface_sealed_permit.svg)

---


<br>

## 1. 선언 방법

`sealed` 키워드를 붙이고, `permits` 뒤에 허용할 클래스/인터페이스 목록을 나열합니다.

```java
// "자식 중에 A랑 B만 인정하겠다!"
public sealed interface VipInterface permits ClassA, ClassB {
    void vipMethod();
}
```


<br>

## 2. 자식 클래스의 의무

부모가 `sealed`로 봉인을 걸었으므로, 허락받은 자식(`ClassA`, `ClassB`)은 자신의 상태를 명확히 밝혀야 합니다.
다음 3가지 중 하나를 반드시 선택해야 합니다.

1.  **`final`**: "나는 여기서 상속 끝내겠다." (더 이상 자식을 두지 않음)
2.  **`sealed`**: "나도 내 자식을 골라 받겠다." (봉인 유지)
3.  **`non-sealed`**: "나는 빗장을 풀겠다. 내 밑으로는 아무나 상속받아도 됨." (봉인 해제)

### 계층 구조 예시
![Sealed Tree](./img/interface_sealed_tree.svg)

```java
// 1. 여기서 끝!
public final class ClassA implements VipInterface { ... }

// 2. 봉인 해제! (이제 C의 자식은 자유)
public non-sealed class ClassB implements VipInterface { ... }
```

이 기능은 라이브러리 설계자가 **"내 의도된 상속 구조를 벗어나지 말아 달라"**고 강제할 때 매우 유용합니다.
