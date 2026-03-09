---
layout: oop
title: "18.6 생성자 참조"
nav_order: 6
parent: "Chapter 18. 람다식"
grand_parent: "객체지향 자바 프로그래밍"
description: "18.6 생성자 참조 에 대한 자바(Java) 기초 및 실전 프로그래밍 문서입니다."
keywords: "18.6 생성자 참조, 자바, Java, 프로그래밍, 백엔드, 개발, jinydev"
---

# 18.6 생성자 참조


<br>

## 1. 객체 생산 공장 🏭

람다식의 역할이 **"단순히 객체를 생성해서 리턴하는 것"**이라면, 생성자 참조를 쓸 수 있습니다.
마치 공장에 설계도(`new`)만 던져주는 것과 같습니다.

*   람다식: `(id, name) -> new Member(id, name)`
*   생성자 참조: `Member :: new`


<br>

## 2. 오버로딩된 생성자 선택

`Member` 클래스에 생성자가 여러 개(`Member(String id)`, `Member(String id, String name)`) 있어도 걱정 마세요.
자바 컴파일러가 **매개변수의 개수와 타입**을 보고 알아서 맞는 생성자를 찾아줍니다. (똑똑하죠?)

```java
// 매개변수 1개짜리 생성자 호출
Function<String, Member> f1 = Member :: new; 

// 매개변수 2개짜리 생성자 호출
BiFunction<String, String, Member> f2 = Member :: new;
```


<br>

## 3. 예제: 회원 생성

**생성자 인터페이스**
```java
@FunctionalInterface
public interface Creatable1 {
    public Member create(String id); // 매개변수 1개
}

@FunctionalInterface
public interface Creatable2 {
    public Member create(String id, String name); // 매개변수 2개
}
```

**실행 코드**
```java
package ch18.sec06;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 1. 매개변수 1개 -> Member(String id) 호출
        Member m1 = person.getMember1(Member :: new);
        System.out.println(m1);

        // 2. 매개변수 2개 -> Member(String id, String name) 호출
        Member m2 = person.getMember2(Member :: new);
        System.out.println(m2);
    }
}
```

**실행 결과**
```
Member(String id) 생성자 실행
{ id: winter, name: null }

Member(String id, String name) 생성자 실행
{ id: winter, name: 한겨울 }
```

> **핵심**: `클래스이름 :: new` 만 기억하세요. 어떤 생성자를 부를지는 파라미터가 결정합니다.

---

## 코딩 영단어 학습 📝

코딩에서 영어 단어의 의미만 정확히 이해해도 절반은 성공입니다! 오늘 배운 핵심 영단어들을 다시 한번 짚고 넘어가 볼까요?

*   **`Constructor`**: 컨스트럭터, 생성자. (`new` 키워드와 함께 객체를 뚝딱 만들어내는 공장 설계도. 람다식에서는 `::new` 형태로 아주 심플하게 호출됨)
*   **`Reference`**: 레퍼런스, 참조. (내가 직접 구구절절 코드를 쓰지 않고, "저기 있는 저 생성자 설계도 좀 대신 써줘" 하고 가리키고(참조) 토스하는 람다의 고급 기술)
