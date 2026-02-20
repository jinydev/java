---
layout: part04
title: "18.5 보조 스트림"
nav_order: 5
parent: "Chapter 22. 데이터 입출력"
grand_parent: "Chapter 22. 데이터 입출력"
---

# 18.5 보조 스트림

보조 스트림이란 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림을 말한다. 보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에 입출력 소스로부터 직접 생성된 입출력 스트림에 연결해서 사용해야 한다.

```java
보조스트림 변수 = new 보조스트림(입출력스트림);
```

### 보조 스트림 시각화 (정수기 필터 비유)

```mermaid
flowchart LR
    Origin[(출발지\n수도관)]
    MainStream[기본 스트림\n(물 흐름)]
    AuxStream[보조 스트림\n(정수기 필터 🧊)]
    Program((프로그램))
    
    Origin --> MainStream
    MainStream --> AuxStream
    AuxStream -->|필터링/성능강화 된 데이터| Program
    
    style Origin fill:#f9f9f9,stroke:#333
    style MainStream fill:#dae8fc,stroke:#6c8ebf
    style AuxStream fill:#d5e8d4,stroke:#82b366,stroke-width:2px
    style Program fill:#e1d5e7,stroke:#9673a6
```

자주 사용되는 보조 스트림은 다음과 같다.

| 보조 스트림                                                                         | 기능                                 |
| :---------------------------------------------------------------------------------- | :----------------------------------- |
| `InputStreamReader`                                                                 | 바이트 스트림을 문자 스트림으로 변환 |
| `BufferedInputStream`, `BufferedOutputStream`<br>`BufferedReader`, `BufferedWriter` | 입출력 성능 향상                     |
| `DataInputStream`, `DataOutputStream`                                               | 기본 타입 데이터 입출력              |
| `PrintStream`, `PrintWriter`                                                        | 줄바꿈 처리 및 형식화된 문자열 출력  |
| `ObjectInputStream`, `ObjectOutputStream`                                           | 객체 입출력                          |
