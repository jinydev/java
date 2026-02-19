---
layout: oop
title: "15.5 문자열 클래스 (String)"
nav_order: 5
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
---

# 15.5 문자열 클래스 (String)


<br>

## 1. 불변의 진주 목걸이 (`String`) 📿

자바의 `String` 객체는 **불변(Immutable)**입니다. 한 번 만들어진 문자열은 절대 변하지 않습니다.
마치 꽉 묶인 **진주 목걸이**와 같습니다.

```java
String data = "ABC";
data += "DEF"; // "ABCDEF"
```

위 코드는 "ABC" 목걸이에 "DEF" 구슬을 끼워 넣는 게 아닙니다.
"ABC" 목걸이는 그대로 두고, **"ABCDEF"라는 새 목걸이를 만들어서** `data`가 그것을 가리키게 하는 것입니다.
(수정이 빈번하면 쓰레기 객체가 많이 생겨서 성능에 안 좋습니다.)


<br>

## 2. 조립식 레고 (`StringBuilder`) 🧱

문자열을 자주 수정해야 한다면 **`StringBuilder`**를 쓰는 것이 좋습니다.
이것은 **레고 블록**과 같아서, 같은 판 위에서 블록을 더하고(`append`), 빼고(`delete`), 끼워 넣는(`insert`) 작업이 자유롭습니다.

```java
// 내부 버퍼(레고 판)에서 직접 수정함
StringBuilder sb = new StringBuilder();
sb.append("DEF");
sb.insert(0, "ABC"); // 맨 앞에 추가
sb.delete(3, 4); // D 삭제
String result = sb.toString(); // 완성된 문자열 리턴

System.out.println(result); // ABCEF
```


<br>

## 3. 식빵 커팅기 (`StringTokenizer`) 🍞

긴 문자열을 특정 문자(구분자) 기준으로 잘라낼 때 사용합니다.
`split()` 메소드와 비슷하지만, **한 종류의 구분자**로만 자를 때 더 간편합니다.

*   `countTokens()`: 남은 조각 개수
*   `hasMoreTokens()`: 남은 조각이 있니? (true/false)
*   `nextToken()`: 다음 조각을 줘!

```java
import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String data = "홍길동/이수홍/박연수";
        
        // /를 기준으로 자르겠다
        StringTokenizer st = new StringTokenizer(data, "/");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
```

> **핵심**:
> *   문자열 변화가 없다면? -> **`String`** (가장 많이 씀)
> *   문자열을 마구 뜯어 고쳐야 한다면? -> **`StringBuilder`**
> *   문자열을 단순하게 잘라야 한다면? -> **`StringTokenizer`**
