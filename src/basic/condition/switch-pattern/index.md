---
layout: basic
title: "6.4 (심화) 개선된 switch 문"
nav_order: 4
parent: "Chapter 06. 조건문"
grand_parent: "Part 01. 자바 언어의 기초"
---

# 6.4 (심화) 개선된 switch 문

## 1. 더 똑똑해진 자판기 (Java 12+) ✨

옛날 `switch` 문은 `break`를 꼬박꼬박 써야 해서 귀찮았습니다.
최신 자바에서는 **화살표(`->`)**를 써서 더 간결하게 만들 수 있습니다.

![그림](./img/smart_switch.png)

### 특징
1.  **`break`가 필요 없습니다!** (화살표 오른쪽만 실행하고 끝남)
2.  중괄호 `{}`로 여러 줄을 묶을 수 있습니다.
3.  콤마(`,`)로 여러 값을 한 번에 처리할 수 있습니다.

```mermaid
flowchart LR
    Input([입력값: 'A' 또는 'a']) --> CaseA{"case 'A', 'a'"}
    Input2([입력값: 'B' 또는 'b']) --> CaseB{"case 'B', 'b'"}
    
    CaseA --> ActionA["우수 회원입니다."]
    CaseB --> ActionB["일반 회원입니다."]
    
    ActionA --> End([switch 종료 (break 불필요)])
    ActionB --> End

    style Input fill:#f9f,stroke:#333,stroke-width:2px
    style Input2 fill:#f9f,stroke:#333,stroke-width:2px
    style CaseA fill:#ff9,stroke:#333,stroke-width:2px
    style CaseB fill:#ff9,stroke:#333,stroke-width:2px
    style ActionA fill:#bbf,stroke:#333,stroke-width:2px
    style ActionB fill:#bbf,stroke:#333,stroke-width:2px
    style End fill:#ccc,stroke:#333,stroke-width:2px
```

```java
char grade = 'B';

switch(grade) {
    case 'A', 'a' -> {
        System.out.println("우수 회원입니다.");
    }
    case 'B', 'b' -> System.out.println("일반 회원입니다.");
    default -> System.out.println("손님입니다.");
}
```

초보자라면 옛날 방식(`:`, `break`)을 먼저 이해하고, 나중에 이 방식을 쓰면 좋습니다.
