---
layout: oop
title: "10.5 패키지 은닉"
nav_order: 5
parent: "Chapter 10. 라이브러리와 모듈"
grand_parent: "객체지향 자바 프로그래밍"
---

# 10.5 패키지 은닉

모듈은 모듈 기술자(`module-info.java`)에서 `exports` 키워드를 사용해 내부 패키지 중 외부에서 사용할 패키지를 지정한다. `exports` 되지 않은 패키지는 자동적으로 은닉된다.

모듈이 일부 패키지를 은닉하는 이유는 다음과 같다.
*   **모듈 사용 방법 통일**: 모듈 외부에서 패키지2와 3을 사용하지 못하도록 막고, 패키지1로 사용 방법을 통일한다.
*   **쉬운 수정**: 모듈 성능 향상을 위해 패키지2와 3을 수정하더라도 모듈 사용 방법(패키지1)이 달라지지 않기 때문에 외부에 영향을 주지 않는다.

`my_module_a`의 `module-info.java`를 수정해서 `pack2`를 은닉시켜 보자. 그리고 `pack1`의 `A` 클래스에서 `pack2`의 `B` 클래스를 사용하도록 수정하자.

**module-info.java**
```java
module my_module_a {
    exports pack1;
    // exports pack2;
}
```

**A.java**
```java
package pack1;

import pack2.B;

public class A {
    // 메소드
    public void method() {
        System.out.println("A-method 실행");
        
        // B 클래스 사용
        B b = new B();
        b.method();
    }
}
```

`pack2`가 은닉되어 외부에서 사용할 수 없으므로 `my_application_2`의 `Main.java`도 다음과 같이 수정한다.

**Main.java**
```java
package app;

import pack1.A;
// import pack2.B;
import pack3.C;

public class Main {
    public static void main(String[] args) {
        // my_module_a 패키지에 포함된 A 클래스 이용
        A a = new A();
        a.method();
        
        // my_module_a 패키지에 포함된 B 클래스 이용
        // B b = new B();
        // b.method();
