---
layout: oop
title: "확인문제"
nav_order: 99
parent: "Chapter 16. 제네릭"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제


<br>

## 1. 제네릭 설명
제네릭에 대한 설명으로 틀린 것은 무엇입니까?
- ① 컴파일 시 강한 타입 체크를 할 수 있다.
- ② 타입 변환(casting)을 제거한다.
- ③ 제네릭 타입은 타입 파라미터를 가지는 제네릭 클래스와 인터페이스를 말한다.
- ④ 제네릭 메소드는 리턴 타입으로 타입 파라미터를 가질 수 없다.

<details>
<summary>정답 확인</summary>
<div markdown="1">
**정답:** ④
<br>
제네릭 메소드는 리턴 타입 앞에 타입 파라미터를 선언하고, 리턴 타입으로도 사용할 수 있습니다. (`<T> Box<T> boxing(T t)`)
</div>
</details>

<br>


<br>

## 2. 제네릭 클래스 선언 (컨테이너)
`ContainerExample` 클래스의 `main()` 메소드는 `Container` 제네릭 타입을 사용하고 있습니다. `main()` 메소드에서 사용하는 방식을 보고 `Container` 클래스를 선언해 보세요.

**ContainerExample.java**
```java
public class ContainerExample {
    public static void main(String[] args) {
        Container<String> container1 = new Container<String>();
        container1.set("홍길동");
        String str = container1.get();

        Container<Integer> container2 = new Container<Integer>();
        container2.set(6);
        int value = container2.get();
    }
}
```

<details>
<summary>정답 확인</summary>
<div markdown="1">
**Container.java**
```java
public class Container<T> {
    private T t;
    
    public T get() { 
        return t; 
    }
    
    public void set(T t) { 
        this.t = t; 
    }
}
```
</div>
</details>

<br>


<br>

## 3. 멀티 타입 파라미터 (키/값)
`Container` 클래스를 키(Key)와 값(Value)을 저장하도록 수정하고 싶습니다. `main()` 메소드를 참고하여 `Container` 클래스를 선언해 보세요.

**ContainerExample.java**
```java
public class ContainerExample {
    public static void main(String[] args) {
        Container<String, String> container1 = new Container<String, String>();
        container1.set("홍길동", "도적");
        String name1 = container1.getKey();
        String job = container1.getValue();

        Container<String, Integer> container2 = new Container<String, Integer>();
        container2.set("홍길동", 35);
        String name2 = container2.getKey();
        int age = container2.getValue();
    }
}
```

<details>
<summary>정답 확인</summary>
<div markdown="1">
**Container.java**
```java
public class Container<K, V> {
    private K key;
    private V value;

    public void set(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
```
</div>
</details>

<br>


<br>

## 4. 제네릭 메소드 활용
다음 `Util` 클래스의 정적 메소드 `getValue()`는 첫 번째 매개값으로 `Pair` 타입(또는 그 하위)을 받고, 두 번째 매개값으로 키값을 받습니다.
리턴값은 키값이 일치할 경우 `Pair`에 저장된 값을 리턴하고, 일치하지 않으면 `null`을 리턴해야 합니다.

**Util.java**의 `getValue()` 메소드를 작성해 보세요.

```java
public class Util {
    // 여기에 getValue 메소드를 작성하세요.
    // public static ... getValue( ... ) { ... }
}
```

<details>
<summary>정답 확인</summary>
<div markdown="1">
**Util.java**
```java
public class Util {
    // <K, V> : 타입 파라미터 정의
    // V : 리턴 타입
    // Pair<K, V> pair : 첫 번째 파라미터
    // K key : 두 번째 파라미터
    public static <K, V> V getValue(Pair<K, V> pair, K key) {
        if(pair.getKey().equals(key)) {
            return pair.getValue();
        } else {
            return null;
        }
    }
}
```
</div>
</details>
