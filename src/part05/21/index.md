---
layout: part05
title: Chapter 21. 자바 21에서 강화된 언어 및 라이브러리
---

# Chapter 21. 자바 21에서 강화된 언어 및 라이브러리

## 21.1 자바 21 버전에서 강화된 내용

자바는 새로운 버전이 출시될 때마다 확정된 기능과 미리 보기(시험적) 기능을 포함하고 있다. 미리 보기 기능은 향후 변경될 여지가 있으므로 우리 책에서는 확정된 기능만을 다루도록 한다. 가능하면 본문의 Part 04 '데이터 입출력'까지 학습을 마친 뒤에 21장을 학습하길 권장한다. 최신 자바 버전에서 강화된 내용 중에는 자바 17까지의 내용을 알아야 이해되는 것이 있기 때문이다.

자바 21에서 강화된 언어 및 라이브러리 기능을 요약하면 다음과 같다.

*   **로컬(지역) 변수 타입 추론**: 생성자나 메소드에서 선언되는 로컬(지역) 변수는 명시적 타입 대신 `var`를 사용해서 컴파일 시에 타입 추론을 할 수 있다. 이 기능의 도입으로 복잡한 코드가 간결해졌다. 이 기능은 자바 11부터 사용할 수 있지만, 우리 책에서는 21장에서 처음 소개한다.
*   **switch 문의 null 처리 및 패턴 매칭**: 자바 17까지는 표현값이 `null`일 경우 switch 문에서 `NullPointerException`이 발생했지만, 자바 21부터는 레이블에 `null`을 지정해서 예외를 발생시키지 않고 `null` 처리를 할 수 있게 되었다. 또한 레이블에 패턴과 가드를 작성해서 표현값과 매칭시킬 수도 있다.
*   **레코드 패턴**: 자바 21에서 지원하는 레코드 패턴(Record Patterns)은 레코드의 필드값을 분해해서 변수에 대입하는 기능을 제공한다. 레코드의 필드값을 얻기 위해 Getter를 호출할 필요 없이 바로 매개변수로 받을 수 있어 매우 편리해졌다.
*   **가상 스레드**: 자바 21부터 사용할 수 있는 가장 주목해야 할 기능은 가상(Virtual) 스레드이다. 가상 스레드는 처리량이 높은 동시 애플리케이션을 개발할 때 사용할 수 있는 경량(Lightweight) 스레드이다.
*   **순차 컬렉션**: 자바 21은 순서가 있는 컬렉션을 묶고 공통 API를 제공할 목적으로 순차 컬렉션(SequencedCollection), 순차 셋(SequencedSet), 순차 맵(SequencedMap) 인터페이스를 추가하고, 기존 인터페이스의 상속 관계를 수정했다.
*   **기본 문자셋 변경**: 자바는 JVM이 실행될 때 운영체제 환경에 따라 자바 기본 문자셋이 결정되었다. macOS는 UTF-8을 기본 문자셋으로 사용했고, 한글 Windows는 x-windows-949(MS949)를 사용했다. 자바 21에서는 자바 기본 문자셋이 UTF-8로 통일되었다. 이로써 운영체제 환경에 의존하지 않고 어떤 실행 환경에서든 모두 UTF-8 문자셋을 사용한다.

## 21.2 로컬(지역) 변수 타입 추론

자바 11부터는 로컬(지역) 변수를 위한 타입 추론(type inference for local variable) 기능을 사용할 수 있다. 로컬 변수를 선언할 때 예약된 타입(reserved type)인 `var`를 사용하면 컴파일 시에 로컬 변수에 대입되는 값을 보고 컴파일러가 추론(inference)해서 타입을 결정한다.

전통적으로 자바는 로컬 변수를 선언할 때 대입되는 값에 따라서 다음과 같이 구체적인 타입을 사용해야 한다.

```java
void method() {
    String name = "홍길동";
    int age = 25;
}
```

위 코드를 예약된 타입인 `var`로 변경하면 대입되는 값에 상관없이 다음과 같이 작성할 수 있다.

```java
void method() {
    var name = "홍길동";
    var age = 25;
}
```

`name`에는 문자열이 대입되었고, `age`에는 정수가 대입되었기 때문에 컴파일 시에 각각 `String`과 `int` 타입으로 최종 결정된다.

로컬 변수 타입 추론 기능은 개발자들 사이에서 다소 논란이 있다. 코드의 간결성을 중요시하는 사람들은 환영하지만, 코드의 가독성을 중요시하는 사람들은 중요한 타입 정보가 없어짐에 따라 가독성이 떨어져서 나쁜 코드가 작성될 수 있다고 말한다. 필자도 가독성이 떨어진다는 생각에는 동의하지 않지만, 변수 이름만 잘 지어 준다면 `var`를 사용하더라도 가독성을 크게 해치지 않는다.

### 예약된 타입 var 제한

예약된 타입 `var`는 생성자(Constructor) 또는 메소드(Method) 안에서 로컬 변수를 선언할 때만 사용할 수 있다. 클래스나 인터페이스의 필드를 선언할 때는 사용할 수 없다.

```java
class 클래스명 {
    // var 필드명;  // 컴파일 에러
}
interface 인터페이스명 {
    // var 상수명 = 값; // 컴파일 에러
}
```

## 21.3 switch 문의 null 처리

자바 17까지는 표현값이 `null`일 경우 switch 문에서 `NullPointerException`이 발생했지만, 자바 21부터는 다음과 같이 레이블에 `null`을 지정해서 예외를 발생시키지 않고 `null`을 처리할 수 있게 되었다.

```java
switch (object) {
    case null -> { ... } // object가 null일 경우 선택
    case null, default -> { ... } // object가 null이거나 위의 case가 선택되지 않은 경우 선택
}
```

## 21.4 switch 문의 패턴 매칭

자바 21부터는 다음과 같이 switch 레이블에 패턴과 가드를 작성해서 표현값과 매칭시킬 수도 있다. 이 방식은 표현값이 객체를 참조하는 변수일 경우에만 사용할 수 있다.

### 레이블에 패턴 사용

소괄호 안의 표현값이 참조 타입 변수일 경우 패턴을 사용해서 타입 검사를 수행하고, 자동 타입 변환해서 패턴 변수를 초기화시킨다. 그리고 패턴 변수를 중괄호 블록에서 사용할 수 있다.

```java
switch (object) {
    case Integer i -> { ... } // object가 Integer 타입인 경우 매칭 (자동 타입 변환)
    case String s -> { ... } // object가 String 타입인 경우 매칭 (자동 타입 변환)
    case null, default -> { ... } // object가 null이거나 그 이외의 타입일 경우 매칭
}
```

표현값은 패턴 중 하나와 반드시 매칭되도록 해야 한다. 만약 매칭할 패턴이 없을 경우에는 나머지 매칭을 위해 `default`를 포함해야 한다. 이것을 표현값과 실행문의 완전성(exhaustiveness)이라고 하는데, 표현값이 반드시 실행문에서 처리되어야 함을 뜻한다.

### 가드 사용

패턴과 함께 좀 더 상세한 일치 조건을 만들기 위해 `when`으로 시작하는 가드(guard)를 사용할 수 있다. `when` 다음에는 패턴 변수를 사용해서 `boolean`을 리턴하는 조건식 또는 메소드 호출 코드가 올 수 있다. `true`를 리턴하면 레이블이 선택되고 중괄호가 실행된다.

```java
switch (object) {
    case Integer i when i > 0 -> { ... } // object가 Integer 타입이면서 양수일 경우 선택
    case String s when s.equals("a") -> { ... } // object가 String 타입이면서 "a"일 경우 선택
}
```

### 레이블 통과

레이블에 패턴이 사용되면 기본적으로 다음 레이블로 통과가 금지된다. 단, 다음이 `default`라면 통과할 수 있지만 화살표가 사용되면 무조건 통과가 금지된다.

```java
switch (object) {
    case String s:
        // break; // 생략하면 컴파일 에러 생김 (다음 레이블로 무조건 통과 금지)
    case Integer i:
        // break; // 명시적 통과 금지
    default:
}
```

### 레이블 작성 순서

레이블이 패턴일 경우에는 좁은 범위의 패턴을 먼저 작성하고, 넓은 범위의 패턴을 나중에 작성해야 한다. switch 문은 위에서부터 순차적으로 표현값과 패턴을 매칭하기 때문에 위쪽 패턴이 먼저 매칭되면 아래쪽 패턴은 검사하지 않는다.

```java
Integer data = 3;
switch (data) {
    case 0 -> System.out.println("0"); // ①
    case Integer i when i > 0 -> System.out.println("0 or positive number"); // ②
    case Integer i -> System.out.println("negative number"); // ③
}
```

정수의 범위를 비교하면 ①보다 ③이 넓고, ②보다 ③이 넓다. 따라서 레이블을 작성할 때 ①, ② 뒤에 ③이 오도록 작성해야 한다. 순서를 바꾸면 컴파일 에러가 발생한다.

### 인터페이스 타입의 표현값과 enum 레이블

자바 21에서는 패턴 매칭을 사용할 수 있기 때문에 표현값에 인터페이스 타입이 올 수 있다. 인터페이스는 여러 가지 `enum`을 그룹핑할 목적으로 사용할 수 있다.

```java
public sealed interface Drawable permits Shape, Image { }

public enum Shape implements Drawable { LINE, TRIANGLE, RECTANGLE }
public enum Image implements Drawable { JPEG, PNG }
```

자바 21에서는 switch 문의 표현값이 `Drawable` 타입이라면 `Drawable`로 그룹핑된 모든 `enum` 상수를 레이블로 작성할 수 있다.

```java
String result = switch (drawable) {
    case Shape.LINE -> "선을 그립니다.";
    case Shape.TRIANGLE -> "삼각형을 그립니다.";
    case Shape.RECTANGLE -> "사각형을 그립니다.";
    case Image.JPEG -> "JPEG 이미지를 그립니다.";
    case Image.PNG -> "PNG 이미지를 그립니다.";
    default -> "도형을 그리지 않습니다.";
};
```

## 21.5 레코드 패턴

자바 21에서 지원하는 레코드 패턴(Record Patterns)은 레코드의 필드값을 분해해서 변수에 대입하는 기능을 제공한다. 레코드의 필드값을 얻기 위해 Getter를 호출할 필요 없이 매개변수로 바로 받을 수 있어 매우 편리해졌다.

레코드 패턴은 `instanceof` 연산자와 switch 문의 레이블에서 다음과 같이 작성될 수 있다.

```java
if (obj instanceof 레코드(타입 변수, 타입 변수)) {
    // 레코드 패턴 변수 사용
}

switch (obj) {
    case 레코드(타입 변수, 타입 변수) -> {
        // 레코드 패턴 변수 사용
    }
}
```

예를 들어, `Rectangle` 레코드가 있다면:

```java
public record Rectangle(int width, int height) {}

// 자바 21 레코드 패턴
if (obj instanceof Rectangle(int width, int height)) {
    System.out.println("area: " + (width * height));
}
```

## 21.6 가상 스레드

자바 21부터 사용할 수 있는 기능 중 가장 주목해야 할 것은 가상(Virtual) 스레드이다. 가상 스레드는 처리량이 높은 동시 애플리케이션을 개발할 때 사용할 수 있는 경량(Lightweight) 스레드이다.

### 가상 스레드 개요

지금까지 자바 개발자들은 서버 애플리케이션에서 사용자 요청을 동시에 처리(요청별 스레드)하기 위해 스레드 풀링을 사용했다. 자바 17까지의 스레드는 운영체제가 제공하는 플랫폼(Platform) 스레드를 래핑했기 때문에 스레드와 플랫폼 스레드가 1:1로 매핑되었다. 플랫폼 스레드는 비용이 많이 들기 때문에 애플리케이션은 스레드의 수를 제한해서 사용해야 했었다.

이러한 단점을 해결하기 위해 자바 21에서는 CPU를 효율적으로 이용하면서 동시 처리량을 확장할 수 있도록 가상 스레드를 제공한다. 스레드가 플랫폼 스레드와 1:1로 매핑된다면 가상 스레드는 플랫폼 스레드와 n:1로 매핑된다. 다수의 가상 스레드가 한 개의 플랫폼 스레드와 매핑되기 때문에 플랫폼 스레드의 부족 문제를 해결할 수 있게 된다.

가상 스레드는 CPU에서 계산을 수행하는 동안만 플랫폼 스레드를 사용한다. 가상 스레드가 블로킹 I/O 작업(파일 입출력, 네트워킹)을 수행할 경우 가상 스레드는 일시 중지되지만, 플랫폼 스레드는 일시 중지되지 않고 다른 가상 스레드의 작업을 처리한다. 그렇기 때문에 CPU 활용도는 최적으로 끌어올리면서 높은 동시 처리량을 달성할 수 있다.

> **참고**: 자바 API 도큐먼트에서는 자바 21 이전까지의 일반적인 스레드(Thread)를 플랫폼 스레드라고 부른다.

### 가상 스레드풀 생성

가상 스레드는 메모리가 부족하지 않다면 개수를 무제한으로 사용할 수 있기 때문에 스레드풀에서 최대 개수를 제한할 필요가 없다. 실제로 가상 스레드풀을 생성하는 `Executors`의 메소드는 최대 개수를 입력받지 않는다.

*   **플랫폼 스레드풀**: `ExecutorService platformExecutor = Executors.newFixedThreadPool(최대 개수);`
*   **가상 스레드풀**: `ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor();`

가상 스레드는 스레드풀에서 풀링되어서는 안 되고, 작업 건수별로 새로운 가상 스레드를 생성해서 처리해야 한다.

### 가상 스레드 생성

자바 21부터는 가상 스레드를 생성하기 위해 새로운 정적 메소드 2개가 추가되었다.

*   `Thread.startVirtualThread(Runnable task)`
*   `Thread.ofVirtual().start(Runnable task)`

```java
// 방법 1
Thread.startVirtualThread(() -> {
    // 작업 내용
});

// 방법 2
Thread.ofVirtual().start(() -> {
    // 작업 내용
});
```

### 플랫폼 스레드 생성

자바 21부터는 플랫폼 스레드를 생성하는 또 다른 방법으로, `Thread` 클래스에 `ofPlatform()` 정적 메소드가 추가되었다.

```java
Thread.ofPlatform().start(() -> {
    // 작업 내용
});
```

## 21.7 순차 컬렉션

자바 21은 순서가 있는 컬렉션을 묶고, 공통 API를 제공할 목적으로 **순차 컬렉션(SequencedCollection)**, **순차 셋(SequencedSet)**, **순차 맵(SequencedMap)** 인터페이스를 추가하고 기존 인터페이스의 상속 관계를 수정했다.

### 순차 컬렉션 (SequencedCollection)

`SequencedCollection`은 순서가 있는 List와 Set 컬렉션의 최상위 인터페이스이다. 다음과 같은 메소드가 선언되어 있다.

*   `void addFirst(E e)`: 첫 번째 요소로 추가
*   `void addLast(E e)`: 마지막 요소로 추가
*   `E getFirst()`: 첫 번째 요소를 가져오기
*   `E getLast()`: 마지막 요소를 가져오기
*   `E removeFirst()`: 첫 번째 요소를 제거하기
*   `E removeLast()`: 마지막 요소를 제거하기
*   `SequencedCollection<E> reversed()`: 요소의 순서를 뒤바꾸기

### 순차 Set (SequencedSet)

순서가 있으면서 요소의 중복 저장을 허용하지 않는 순차 Set 컬렉션은 `SequencedCollection`의 자식인 `SequencedSet` 인터페이스를 별도로 상속받는다. `reversed()` 메소드만 리턴 타입을 `SequencedSet<E>`로 변경해서 재정의했다.

주의할 점은 `SortedSet`을 구현한 `TreeSet` 클래스는 요소들을 비교한 후 위치가 결정되기 때문에 `addFirst()`, `addLast()` 메소드를 사용해서 직접 해당 위치에 요소를 저장할 수 없다. (예외 발생)

### 순차 Map (SequencedMap)

`SequencedMap`은 순서가 있는 Map 컬렉션의 최상위 인터페이스이다.

*   `Map.Entry<K, V> firstEntry()`: 첫 번째 엔트리 가져오기
*   `Map.Entry<K, V> lastEntry()`: 마지막 엔트리 가져오기
*   `Map.Entry<K, V> pollFirstEntry()`: 첫 번째 엔트리를 가져오고 제거
*   `Map.Entry<K, V> pollLastEntry()`: 마지막 엔트리를 가져오고 제거
*   `V putFirst(K k, V v)`: 첫 번째 요소로 추가하기
*   `V putLast(K k, V v)`: 마지막 요소로 추가하기
*   `SequencedMap<K, V> reversed()`: 엔트리의 순서를 뒤바꾸기
*   `SequencedSet<Map.Entry<K, V>> sequencedEntrySet()`: 엔트리를 요소로 하는 SequencedSet 얻기
*   `SequencedSet<K> sequencedKeySet()`: 키를 요소로 하는 SequencedSet 얻기
*   `SequencedCollection<V> sequencedValues()`: 값을 요소로 하는 SequencedCollection 얻기

`SortedMap`을 구현한 `TreeMap`은 `putFirst()`, `putLast()` 메소드를 사용할 수 없다.

### 수정할 수 없는 순차 컬렉션

자바 21에서는 요소를 변경할 수 없도록 수정할 수 없는 순차 컬렉션을 만들기 위해 `Collections` 클래스에 다음 정적 메소드가 추가되었다.

*   `Collections.unmodifiableSequencedCollection(sequencedCollection)`
*   `Collections.unmodifiableSequencedSet(sequencedSet)`
*   `Collections.unmodifiableSequencedMap(sequencedMap)`

## 21.8 기본 문자셋 변경

자바는 JVM이 실행될 때 운영체제의 환경에 따라 자바 기본 문자셋이 결정되었다. 맥OS는 UTF-8을 기본 문자셋으로 사용했고, 한글 윈도우는 x-windows-949(MS949)를 사용했다. 자바 21부터는 자바 기본 문자셋이 UTF-8로 통일되었으며, 이로써 운영체제의 환경에 의존하지 않고 어떤 실행 환경에서든 모두 UTF-8 문자셋을 사용한다.

### 바이트 수

기본 문자셋이 달라지면 숫자와 영어 문자는 문제가 되지 않지만, 한글 문자는 처리 바이트 수가 달라진다. MS949는 한글 문자를 2byte로 처리하지만, UTF-8은 한글 문자를 3byte로 처리하기 때문이다.

### 호환성 있는 코드

파일 입출력이나 네트워크 통신 시 문자셋 문제로 인한 호환성 문제를 해결하기 위해 명시적으로 문자셋을 지정하는 것이 좋다.

```java
byte[] bytes = "자바".getBytes(Charset.forName("UTF-8"));
FileWriter writer = new FileWriter(file, Charset.forName("UTF-8"));
```
