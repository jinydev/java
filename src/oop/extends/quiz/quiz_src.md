---
layout: oop
title: "확인문제"
nav_order: 99
parent: "Chapter 07. 상속"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제

1. 자바의 상속에 대한 설명 중 틀린 것은 무엇입니까?
   - ① 자바는 다중 상속을 허용한다.
   - ② 부모의 메소드를 자식 클래스에서 재정의(오버라이딩)할 수 있다.
   - ③ 부모의 `private` 접근 제한을 갖는 필드와 메소드는 상속의 대상이 아니다.
   - ④ `final` 클래스는 상속할 수 없고, `final` 메소드는 오버라이딩할 수 없다.

2. 클래스 타입 변환에 대한 설명 중 틀린 것은 무엇입니까?
   - ① 자식 객체는 부모 타입으로 자동 타입 변환된다.
   - ② 부모 객체는 어떤 자식 타입으로도 강제 타입 변환된다.
   - ③ 자동 타입 변환을 이용해서 필드와 매개변수의 다형성을 구현한다.
   - ④ 강제 타입 변환 전에 `instanceof` 연산자로 변환 가능한지 검사하는 것이 좋다.

3. `final` 키워드에 대한 설명으로 틀린 것은 무엇입니까?
   - ① `final` 클래스는 부모 클래스로 사용할 수 있다.
   - ② `final` 필드는 초기화된 후에는 변경할 수 없다.
   - ③ `final` 메소드는 재정의(오버라이딩)할 수 없다.
   - ④ `static final` 필드는 상수를 말한다.

4. 오버라이딩(Overriding)에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 부모 메소드의 시그너처(리턴 타입, 메소드명, 매개변수)와 동일해야 한다.
   - ② 부모 메소드보다 좁은 접근 제한자를 붙일 수 없다. (예: `public`(부모) -> `private`(자식)).
   - ③ `@Override` 어노테이션을 사용하면 재정의가 확실한지 컴파일러가 검증한다.
   - ④ `protected` 접근 제한을 갖는 메소드는 다른 패키지의 자식 클래스에서 재정의할 수 없다.

5. 추상 클래스에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 직접 객체를 생성할 수 없고, 상속만 할 수 있다.
   - ② 추상 메소드를 반드시 가져야 한다.
   - ③ 추상 메소드는 자식 클래스에서 재정의(오버라이딩)할 수 있다.
   - ④ 추상 메소드를 재정의하지 않으면 자식 클래스도 추상 클래스가 되어야 한다.

6. `Parent` 클래스를 상속해서 `Child` 클래스를 다음과 같이 작성했는데, `Child` 생성자에서 컴파일 에러가 발생했습니다. 그 이유와 해결 방법을 설명해 보세요.

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

**정답:**
부모 클래스에 기본 생성자가 없으므로, 자식 생성자에서 반드시 `super(name)`을 호출해야 한다.

```java
public Child(String name, int studentNo) {
    super(name);
    this.name = name;
    this.studentNo = studentNo;
}
```

7. `Parent` 클래스를 상속받아 `Child` 클래스를 다음과 같이 작성했습니다. `ChildExample` 클래스를 실행했을 때 호출되는 각 클래스의 생성자의 순서를 생각하면서 출력 결과를 작성해 보세요.

```java
public class Parent {
    public String nation;
    
    public Parent() {
        this("대한민국");
        System.out.println("Parent() call");
    }
    
    public Parent(String nation) {
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}

public class Child extends Parent {
    public String name;
    
    public Child() {
        this("홍길동");
        System.out.println("Child() call");
    }
    
    public Child(String name) {
        this.name = name;
        System.out.println("Child(String name) call");
    }
}

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
    }
}
```

**실행 결과**
```
Parent(String nation) call
Parent() call
Child(String name) call
Child() call
```

8. `Tire` 클래스를 상속받아 `SnowTire` 클래스를 다음과 같이 작성했습니다. `SnowTireExample` 클래스를 실행했을 때 출력 결과를 작성해 보세요.

```java
public class Tire {
    public void run() {
        System.out.println("일반 타이어가 굴러갑니다.");
    }
}

public class SnowTire extends Tire {
    @Override
    public void run() {
        System.out.println("스노우 타이어가 굴러갑니다.");
    }
}

public class SnowTireExample {
    public static void main(String[] args) {
        SnowTire snowTire = new SnowTire();
        Tire tire = snowTire;
        
        snowTire.run();
        tire.run();
    }
}
```

**실행 결과**
```
스노우 타이어가 굴러갑니다.
스노우 타이어가 굴러갑니다.
```

9. `A`, `B`, `C`, `D`, `E`, `F` 클래스가 다음과 같이 상속 관계에 있을 때 다음 빈칸에 들어올 수 없는 코드를 선택하세요.

```java
// 변수 대입
B b = (  );

// 메소드 선언
void method(B b) { ... }

// 메소드 호출
method(  )
```

- ① new B()
- ② (B) new A()
- ③ new D()
- ④ new E()

**정답:** ② (B) new A() (부모 객체를 자식 타입으로 강제 변환 불가 unless it was originally a child)

10. 다음과 같이 작성한 `Computer` 클래스에서 컴파일 에러가 발생했습니다. 그 이유를 설명해 보세요.

```java
public abstract class Machine {
    public void powerOn() { }
    public void powerOff() { }
    public abstract void work();
}

public class Computer extends Machine {
}
```

**정답:**
`Computer` 클래스는 추상 클래스 `Machine`을 상속받았지만, 추상 메소드인 `work()`를 재정의하지 않았기 때문이다. 해결하려면 `work()` 메소드를 오버라이딩하거나 `Computer` 클래스를 `abstract`로 선언해야 한다.

11. `MainActivity`의 `onCreate()`를 실행할 때 `Activity`의 `onCreate()`도 실행시키고 싶습니다. 밑줄에 들어갈 코드를 작성해 보세요.

```java
public class Activity {
    public void onCreate() {
        System.out.println("기본적인 실행 내용");
    }
}

public class MainActivity extends Activity {
    @Override
    public void onCreate() {
        __________________
        System.out.println("추가적인 실행 내용");
    }
}
```

**정답:** `super.onCreate();`

12. 다음과 같은 `Example` 클래스에서 `action()` 메소드를 호출할 때 매개값이 `C` 객체일 경우에만 `method2()`가 호출되도록 밑줄에 들어갈 코드를 작성해 보세요.

```java
public class A {
    public void method1() {
        System.out.println("A-method1()");
    }
}

public class B extends A {
    public void method1() {
        System.out.println("B-method1()");
    }
}

public class C extends A {
    public void method1() {
        System.out.println("C-method1()");
    }
    public void method2() {
        System.out.println("C-method2()");
    }
}

public class Example {
    public static void action(A a) {
        a.method1();
        if (__________________) {
            c.method2();
        }
    }
    
    public static void main(String[] args) {
        action(new A());
        action(new B());
        action(new C());
    }
}
```

**정답:** `a instanceof C c`

```java
        if (a instanceof C c) {
            c.method2();
        }
```

```
