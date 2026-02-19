---
layout: oop
title: "확인문제"
nav_order: 99
parent: "Chapter 18. 람다식"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제


<br>

## 1. 람다식 특징
람다식에 대한 설명으로 **틀린 것**은 무엇입니까?
- ① 람다식은 함수형 인터페이스의 익명 구현 객체를 생성한다.
- ② 매개변수가 없을 경우 `( ) -> { ... }` 형태로 작성한다.
- ③ `(x, y) -> { return x+y; }`는 `(x, y) -> x+y`로 바꿀 수 있다.
- ④ `@FunctionalInterface`가 기술된 인터페이스만 람다식으로 표현이 가능하다.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ④
<br>
**해설:** `@FunctionalInterface` 어노테이션이 없더라도, **추상 메소드가 단 하나**라면 람다식으로 표현할 수 있습니다. 어노테이션은 실수로 두 개 이상의 메소드를 선언하는 것을 방지하는 안전장치일 뿐입니다.
</div>
</details>

<br>


<br>

## 2. 알맞은 람다식
다음 중 **잘못 작성된 람다식**은 무엇입니까?
- ① `a -> a + 3`
- ② `a, b -> a * b`
- ③ `x -> System.out.println(x/5)`
- ④ `(x, y) -> Math.max(x, y)`

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ②
<br>
**해설:** 매개변수가 **두 개 이상**일 때는 반드시 괄호 `()`로 감싸야 합니다.
`a, b -> a * b` (X) -> `(a, b) -> a * b` (O)
</div>
</details>

<br>


<br>

## 3. 람다식 변환
다음 코드의 빈 곳에 들어갈 적절한 람다식을 작성해보세요.

```java
Thread thread = new Thread(
    ______________________________
);
thread.start();
```

**(요구사항)**
*   작업 스레드가 실행될 때 "작업 스레드가 실행됩니다."를 3번 출력할 것.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답 예시:**
```java
() -> {
    for(int i=0; i<3; i++) {
        System.out.println("작업 스레드가 실행됩니다.");
    }
}
```
</div>
</details>

<br>


<br>

## 4. 버튼 클릭 이벤트
버튼을 클릭했을 때 메시지를 출력하도록 빈 곳에 람다식을 작성해보세요.

```java
Button btnOk = new Button();
btnOk.setClickListener( ______________________________ );
btnOk.click();
```

**(요구사항)**
*   출력: "Ok 버튼을 클릭했습니다."

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답 예시:**
```java
() -> System.out.println("Ok 버튼을 클릭했습니다.")
```
</div>
</details>

<br>


<br>

## 5. 메소드 참조 변환
다음 람다식을 메소드 참조로 변경해보세요.

**(1) 정적 메소드 참조**
```java
(left, right) -> Math.max(left, right)
```
**변경:** ______________________________

**(2) 인스턴스 메소드 참조**
```java
(a, b) -> a.compareToIgnoreCase(b)
```
**변경:** ______________________________

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:**
1. `Math :: max`
2. `String :: compareToIgnoreCase`
</div>
</details>
