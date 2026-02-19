---
layout: oop
title: "확인문제"
nav_order: 99
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 📝 Chapter 07 확인문제

학습한 내용을 확인해 봅시다.
(마우스를 드래그하면 정답을 확인할 수 있습니다.)

---

### Q1. 자바의 상속에 대한 설명 중 **틀린 것**은 무엇입니까?
1. 자바는 다중 상속을 허용한다.
2. 부모의 메소드를 자식 클래스에서 재정의(오버라이딩)할 수 있다.
3. 부모의 private 접근 제한을 갖는 필드와 메소드는 상속의 대상이 아니다.
4. final 클래스는 상속할 수 없고, final 메소드는 오버라이딩할 수 없다.

> <span style="color:white">정답: 1번 (자바는 다중 상속을 허용하지 않습니다.)</span>

---

### Q2. 클래스 타입 변환에 대한 설명 중 **틀린 것**은 무엇입니까?
1. 자식 객체는 부모 타입으로 자동 타입 변환된다.
2. 부모 객체는 어떤 자식 타입으로도 강제 타입 변환된다.
3. 자동 타입 변환을 이용해서 필드와 매개변수의 다형성을 구현한다.
4. 강제 타입 변환 전에 `instanceof` 연산자로 변환 가능한지 검사하는 것이 좋다.

> <span style="color:white">정답: 2번 (부모 객체가 본래 자식 객체에서 변환된 경우에만 강제 타입 변환이 가능합니다.)</span>

---

### Q3. final 키워드에 대한 설명으로 **틀린 것**은 무엇입니까?
1. final 클래스는 부모 클래스로 사용할 수 있다.
2. final 필드는 초기화된 후에는 변경할 수 없다.
3. final 메소드는 재정의(오버라이딩)할 수 없다.
4. static final 필드는 상수를 말한다.

> <span style="color:white">정답: 1번 (final 클래스는 상속할 수 없습니다.)</span>

---

### Q4. 오버라이딩(Overriding)에 대한 설명으로 **틀린 것**은 무엇입니까?
1. 부모 메소드의 시그너처(리턴 타입, 메소드명, 매개변수)와 동일해야 한다.
2. 부모 메소드보다 좁은 접근 제한자를 붙일 수 없다. (예: public -> private 불가).
3. `@Override` 어노테이션을 사용하면 재정의가 확실한지 컴파일러가 검증한다.
4. protected 접근 제한을 갖는 메소드는 다른 패키지의 자식 클래스에서 재정의할 수 없다.

> <span style="color:white">정답: 4번 (protected 메소드는 다른 패키지라도 자식 클래스라면 재정의 가능합니다.)</span>

---

### Q5. 추상 클래스에 대한 설명으로 **틀린 것**은 무엇입니까?
1. 직접 객체를 생성할 수 없고, 상속만 할 수 있다.
2. 추상 메소드를 반드시 가져야 한다.
3. 추상 메소드는 자식 클래스에서 재정의(오버라이딩)할 수 있다.
4. 추상 메소드를 재정의하지 않으면 자식 클래스도 추상 클래스가 되어야 한다.

> <span style="color:white">정답: 2번 (추상 클래스는 추상 메소드가 없어도 될 수 있습니다. 단, 추상 메소드가 있으면 반드시 추상 클래스여야 합니다.)</span>

---

### Q6. 컴파일 에러가 발생하는 이유와 해결 방법은?

```java
public class Parent {
    public String name;
    
    public Parent(String name) {
        this.name = name;
    }
}

public class Child extends Parent {
    public int studentNo;
    
    public Child(String name, int studentNo) {
        this.name = name;
        this.studentNo = studentNo;
    }
}
```

> **해설**:
> 부모 클래스(`Parent`)에 기본 생성자가 없고 매개변수가 있는 생성자만 있기 때문에, 자식 생성자에서 자동으로 `super()`를 호출할 수 없습니다.
> 따라서 명시적으로 **`super(name);`**을 호출하여 부모 생성자에게 매개값을 전달해야 합니다.

---

### Q7. 실행 결과 예측하기

```java
// (코드 생략 - Parent, Child 생성자 호출 순서 문제)
Child child = new Child();
```

> **실행 결과**:
> 1. Parent(String nation) call
> 2. Parent() call
> 3. Child(String name) call
> 4. Child() call
>
> (생성자는 부모 -> 자식 순서로 실행되는데, 코드 내부의 `this()` 호출로 인해 복잡한 순서를 가집니다. 부모 객체가 먼저 완전히 생성된 후 자식 객체의 남은 코드가 실행됩니다.)

---

### Q8. 다형성 실행 결과

```java
SnowTire snowTire = new SnowTire();
Tire tire = snowTire;

snowTire.run(); // "스노우 타이어가 굴러갑니다."
tire.run();     // "스노우 타이어가 굴러갑니다." (오버라이딩된 메소드 실행)
```

---

### Q9. 컴파일 에러가 나는 코드는?

```java
B b = (  );
```
1. `new B()`
2. `(B) new A()`
3. `new D()`
4. `new E()`

> <span style="color:white">정답: 2번 (부모 객체인 new A()를 자식 타입인 B로 강제 변환할 수 없습니다. ClassCastException 발생!)</span>

---

### Q10. 추상 클래스 상속 시 에러 이유

> **이유**: `Computer` 클래스가 `Machine` 추상 클래스를 상속받았지만, 추상 메소드인 `work()`를 구현(오버라이딩)하지 않았기 때문입니다.
> **해결**: `work()` 메소드를 오버라이딩하여 내용을 채우거나, `Computer` 클래스도 `abstract`로 선언해야 합니다.

---

### Q11. 부모 메소드 호출

```java
@Override
public void onCreate() {
    super.onCreate(); // 정답
    System.out.println("추가적인 실행 내용");
}
```

---

### Q12. instanceof 연산자

```java
if (a instanceof C c) { // 정답
    c.method2();
}
```
