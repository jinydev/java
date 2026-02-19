---
layout: oop
title: "확인문제"
nav_order: 99
parent: "Chapter 15. 자바 기본 API (java.base)"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제


<br>

## 1. API 도큐먼트
API 도큐먼트에 대한 설명으로 **틀린 것**은 무엇입니까?
- ① 자바 표준 라이브러리를 프로그램에서 어떻게 사용할 수 있는지를 설명하고 있다.
- ② 클래스의 상속 관계 및 자식 클래스들이 무엇이 있는지 알 수 있다.
- ③ 생성자 선언부, 필드의 타입, 메소드의 선언부를 확인할 수 있다.
- ④ 모든 `private` 멤버들도 상세하게 확인할 수 있다.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ④
<br>
**해설:** API 도큐먼트는 주로 외부에서 사용할 수 있는 `public`이나 `protected` 멤버들을 설명합니다. `private` 멤버는 내부 구현이므로 보통 노출되지 않습니다.
</div>
</details>

<br>


<br>

## 2. Object 클래스
`Object` 클래스에 대한 설명 중 **틀린 것**은 무엇입니까?
- ① 모든 자바 클래스의 최상위 부모 클래스이다.
- ② `equals()` 메소드는 기본적으로 `==` 연산자와 동일하게 주소값을 비교한다.
- ③ `hashCode()` 메소드는 객체의 식별값(정수)을 리턴한다.
- ④ `toString()` 메소드는 항상 객체의 필드값을 예쁘게 출력해준다.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ④
<br>
**해설:** 기본적으로 `toString()`은 `클래스명@해시코드` 같은 알 수 없는 문자열을 리턴합니다. 필드값을 출력하려면 **반드시 재정의(Override)**해야 합니다.
</div>
</details>

<br>


<br>

## 3. System 클래스
`System` 클래스에 대한 설명 중 **틀린 것**은 무엇입니까?
- ① `System.out`은 모니터 출력, `System.in`은 키보드 입력을 담당한다.
- ② `currentTimeMillis()` 메소드는 현재 시간을 밀리초 단위로 리턴한다.
- ③ `exit(0)` 메소드는 프로그램을 강제 종료시킨다.
- ④ `System` 클래스는 객체를 생성(`new System()`)해서 사용해야 한다.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ④
<br>
**해설:** `System` 클래스의 모든 멤버는 **정적(static)**이므로 객체 생성 없이 `System.out` 처럼 바로 사용합니다.
</div>
</details>

<br>


<br>

## 4. String vs StringBuilder
다음 중 `StringBuilder`를 사용하기에 가장 적합한 경우는 언제입니까?
- ① 로그인 ID처럼 한 번 정하면 바뀔 일이 없는 문자열을 다룰 때
- ② 화면에 고정된 메뉴 이름을 출력할 때
- ③ 반복문 안에서 문자열을 계속 덧붙이거나 수정해야 할 때
- ④ 두 문자열이 같은지 비교만 할 때

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ③
<br>
**해설:** 문자열 변경이 잦은 경우 `String`을 쓰면 메모리 낭비가 심하므로, 수정 가능한 `StringBuilder`를 쓰는 것이 좋습니다.
</div>
</details>

<br>


<br>

## 5. Wrapper 클래스 (박싱/언박싱)
다음 코드의 실행 결과로 올바른 것은?

```java
Integer a = 128;
Integer b = 128;
System.out.println(a == b);
System.out.println(a.equals(b));
```

- ① true, true
- ② true, false
- ③ false, true
- ④ false, false

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ③
<br>
**해설:** `Integer`는 객체이므로 `==` 비교 시 주소값을 비교합니다. 128은 캐싱 범위(-128~127)를 벗어나므로 서로 다른 객체가 되어 `false`입니다. 값 비교는 `equals()`를 써야 하므로 두 번째는 `true`입니다.
</div>
</details>

<br>


<br>

## 6. Math 클래스
다음 중 `Math` 클래스의 메소드 결과가 **잘못된 것**은?
- ① `Math.ceil(5.3)` → `6.0` (올림)
- ② `Math.floor(5.3)` → `5.0` (버림)
- ③ `Math.max(5, 10)` → `5` (최대값)
- ④ `Math.round(5.5)` → `6` (반올림)

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ③
<br>
**해설:** `Math.max(5, 10)`은 두 수 중 큰 값을 리턴하므로 `10`이어야 합니다.
</div>
</details>

<br>


<br>

## 7. 날짜 조작
현재 시간(`now`)에서 **"3일 뒤"**를 구하는 올바른 코드는? (Java 8 이상 `LocalDateTime` 사용 기준)

- ① `now.addDays(3)`
- ② `now.plusDays(3)`
- ③ `now + 3`
- ④ `now.after(3)`

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ②
<br>
**해설:** `java.time` 패키지에서는 `plus...`, `minus...` 메소드를 사용합니다.
</div>
</details>
