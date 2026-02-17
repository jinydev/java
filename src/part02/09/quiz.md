---
layout: part02
title: "확인문제"
nav_order: 99
parent: "Chapter 09. 중첩 선언과 익명 객체"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제

1. 중첩 멤버 클래스에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 인스턴스 멤버 클래스는 바깥 클래스의 객체가 있어야 사용될 수 있다.
   - ② 정적 멤버 클래스는 바깥 클래스의 객체가 없어도 사용될 수 있다.
   - ③ 인스턴스 멤버 클래스 내부에는 바깥 클래스의 모든 필드와 메소드를 사용할 수 있다.
   - ④ 정적 멤버 클래스 내부에는 바깥 클래스의 인스턴스 필드를 사용할 수 있다.

   **정답:** ④ (정적 멤버 클래스에서는 바깥 클래스의 정적 필드와 정적 메소드만 사용할 수 있다.)

2. 로컬 클래스에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 로컬 클래스는 메소드 내부에 선언된 클래스를 말한다.
   - ② 로컬 클래스는 바깥 클래스의 필드와 메소드를 사용할 수 있다.
   - ③ 로컬 클래스는 `static` 키워드를 이용해서 정적 클래스로 만들 수 있다.
   - ④ `final` 특성을 가진 매개변수나 로컬 변수만 로컬 클래스 내부에서 사용할 수 있다.

   **정답:** ③ (로컬 클래스는 `static`을 붙일 수 없다.)

3. 익명 객체에 대한 설명으로 틀린 것은 무엇입니까?
   - ① 익명 객체는 클래스를 상속하거나 인터페이스를 구현해야만 생성될 수 있다.
   - ② 익명 객체는 필드, 매개변수, 로컬 변수의 초기값으로 주로 사용된다.
   - ③ 익명 객체에는 생성자를 선언할 수 있다.
   - ④ 익명 객체는 주로 재정의된 메소드를 멤버로 가진다.

   **정답:** ③ (익명 객체는 클래스 이름이 없으므로 생성자를 선언할 수 없다.)

4. 다음과 같이 `Car` 클래스 내부에 `Tire`와 `Engine` 클래스가 멤버로 선언되어 있습니다. `CarExample` 클래스에서 `Tire`와 `Engine` 객체를 생성하는 코드를 작성해 보세요.

```java
public class Car {
    class Tire {}
    static class Engine {}
}

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        
        Car.Tire tire = myCar.new Tire();
        Car.Engine engine = new Car.Engine();
    }
}
```

5. `Action` 인터페이스는 다음과 같이 `work()` 추상 메소드를 가지고 있습니다. `ActionExample` 클래스의 `main()` 메소드에서 `Action`의 익명 구현 객체를 만들어 실행 결과와 동일하게 나오도록 박스 안에 들어갈 코드를 작성해 보세요.

```java
public interface Action {
    public void work();
}

public class ActionExample {
    public static void main(String[] args) {
        Action action = new Action() {
            @Override
            public void work() {
                System.out.println("복사를 합니다.");
            }
        };
        action.work();
    }
}
```

**실행 결과**
```
복사를 합니다.
```

6. `AnonymousExample` 클래스의 실행 결과를 보고, `Vehicle` 인터페이스의 익명 구현 객체를 필드와 로컬 변수의 초기값 그리고 메소드의 매개값으로 대입해 보세요.

```java
public interface Vehicle {
	public void run();
}

public class Anonymous {
	Vehicle field = new Vehicle() {
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};
	
	void method1() {
		Vehicle localVar = new Vehicle() {
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}
}

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		anony.method2(new Vehicle() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}
}
```

**실행 결과**
```
자전거가 달립니다.
승용차가 달립니다.
트럭이 달립니다.
```

7. 다음 `Chatting` 클래스는 컴파일 에러가 발생합니다. 원인을 설명해 보세요.

```java
public class Chatting {
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
	
	void startChat(String chatId) {
		String nickName = null;
		nickName = chatId;
		
		Chat chat = new Chat() {
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "] " + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}
}
```

**정답:**
`startChat()` 메소드의 로컬 변수 `nickName`은 `chatId`로 초기화된 후 `Chat` 익명 자식 객체의 `start()` 메소드 내부에서 사용되고 있다. 로컬 클래스나 익명 객체 내부에서 사용되는 로컬 변수는 `final` 특성을 가져야 하므로 값을 수정할 수 없다. 하지만 13라인(`nickName = chatId;`)에서 값을 변경하고 있기 때문에 컴파일 에러가 발생한다. `nickName`을 `final`로 선언하거나, 초기화 이후 수정하지 말아야 한다. 또는 `chatId` 매개변수 자체를 직접 사용해도 된다(Java 8부터 `final` 생략 가능).

수정 예시:
```java
void startChat(String chatId) {
    // nickName을 사용하지 않고 chatId를 바로 사용하거나
    // nickName = chatId; 구문을 제거하고 선언 시 초기화
    String nickName = chatId; 
    
    Chat chat = new Chat() {
        @Override
        public void start() {
            while (true) {
                String inputData = "안녕하세요";
                String message = "[" + nickName + "] " + inputData;
                sendMessage(message);
            }
        }
    };
    chat.start();
}
```
