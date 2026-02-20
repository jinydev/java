---
layout: oop
title: "9.6 중첩 인터페이스"
nav_order: 6
parent: "Chapter 09. 중첩 선언과 익명 객체"
grand_parent: "객체지향 자바 프로그래밍"
---

# 9.6 중첩 인터페이스

중첩 인터페이스는 클래스의 멤버로 선언된 인터페이스를 말한다. 인터페이스를 클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 객체를 만들기 위해서이다. 중첩 인터페이스는 다음과 같이 선언된다.

```java
class A {
    [public | private] [static] interface B {
        // 상수 필드
        // 추상 메소드
        // 디폴트 메소드
        // 정적 메소드
    }
}
```

외부의 접근을 막지 않으려면 `public`을 붙이고, `A` 클래스 내부에서만 사용하려면 `private`을 붙인다. 접근 제한자를 붙이지 않으면 같은 패키지 안에서만 접근이 가능하다. 그리고 중첩 인터페이스는 암시적으로 `static`이므로 `static`을 생략해도 항상 `A` 객체 없이 `B` 인터페이스를 사용할 수 있다.

중첩 인터페이스는 안드로이드와 같은 UI 프로그램에서 이벤트를 처리할 목적으로 많이 활용된다. 예를 들어 버튼을 클릭했을 때 이벤트를 처리할 객체는 중첩 인터페이스를 구현해서 만든다. 다음 예제를 따라 작성하면서 이해해 보자.

**Button.java**
```java
package ch09.sec06.exam01;

public class Button {
	// 정적 중첩 인터페이스
	public static interface ClickListener {
		// 추상 메소드
		void onClick();
	}
}
```

외부에서 접근이 가능하도록 `public`이면서 `Button` 객체 없이 사용할 수 있는 `static` 중첩 인터페이스로 `ClickListener`를 선언했다. 그리고 추상 메소드인 `onClick()`을 선언했다. `onClick()` 메소드는 버튼이 클릭되었을 때 호출될 메소드이다.

`Button` 클래스에 `ClickListener` 타입의 필드와 Setter를 추가해서 외부에서 Setter를 통해 `ClickListener` 구현 객체를 필드에 저장할 수 있도록 하자.

**Button.java**
```java
package ch09.sec06.exam02;

public class Button {
	// 정적 멤버 인터페이스
	public static interface ClickListener {
		// 추상 메소드
		void onClick();
	}
	
	// 필드
	private ClickListener clickListener;
	
	// 메소드
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
}
```

`Button`이 클릭되었을 때 실행할 메소드로 `click()`을 다음과 같이 추가한다. 실행 내용은 `ClickListener` 인터페이스 필드를 이용해서 `onClick()` 추상 메소드를 호출한다.

**Button.java**
```java
package ch09.sec06.exam03;

public class Button {
	// 정적 멤버 인터페이스
	public static interface ClickListener {
		// 추상 메소드
		void onClick();
	}
	
	// 필드
	private ClickListener clickListener;
	
	// 메소드
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		this.clickListener.onClick();
	}
}
```

`clickListener` 필드는 Setter를 통해 제공된 `ClickListener` 구현 객체의 참조를 갖고 있다. 따라서 `onClick()` 메소드를 호출하면 `ClickListener` 구현 객체의 `onClick()` 메소드가 실행된다. 이제 버튼을 이용하는 실행 클래스를 작성해 보자.

**ButtonExample.java**
```java
package ch09.sec06.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		// Ok 버튼 객체 생성
		Button btnOk = new Button();
		
		// Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class OkListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		}
		
		// Ok 버튼 객체에 ClickListener 구현 객체 주입
		btnOk.setClickListener(new OkListener());
		
		// Ok 버튼 클릭하기
		btnOk.click();
		
		// Cancel 버튼 객체 생성
		Button btnCancel = new Button();
		
		// Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class CancelListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		}
		
		// Cancel 버튼 객체에 ClickListener 구현 객체 주입
		btnCancel.setClickListener(new CancelListener());
		
		// Cancel 버튼 클릭하기
		btnCancel.click();
	}
}
```

**실행 결과**
```
Ok 버튼을 클릭했습니다.
Cancel 버튼을 클릭했습니다.
```
