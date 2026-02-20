---
layout: oop
title: "6.14 Getter와 Setter"
nav_order: 14
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.14 Getter와 Setter

객체의 필드(데이터)를 외부에서 마음대로 읽고 변경할 경우 객체의 무결성(결점이 없는 성질)이 깨질 수 있다. 예를 들어 자동차의 속도는 음수가 될 수 없는데, 외부에서 음수 값을 설정하면 객체의 무결성이 깨진다.

```java
myCar.speed = -100;
```

이러한 문제점을 해결하기 위해 객체지향 프로그래밍에서는 객체의 필드를 외부에서 직접적으로 접근하는 것을 막고, 대신 메소드를 통해 필드에 접근하는 것을 선호한다. 그 이유는 메소드는 데이터를 검증해서 유효한 값만 필드에 저장할 수 있기 때문이다.

이 역할을 하는 메소드가 Setter이다. 예를 들어 자동차의 속도를 `setSpeed()` 메소드로 변경할 경우에 다음과 같이 검증 코드를 작성할 수 있다.

```java
void setSpeed(double speed) {
    if (speed < 0) {
        this.speed = 0;
        return;
    } else {
        this.speed = speed;
    }
}
```

외부에서 객체의 데이터를 읽을 때도 메소드를 사용하는 것이 좋다. 필드값이 객체 외부에서 사용하기에 부적절한 경우, 메소드로 적절한 값으로 변환해서 리턴할 수 있기 때문이다.

이 역할을 하는 메소드가 Getter이다. 예를 들어 자동차의 속도 단위가 마일(mile)인 경우, 외부에서 킬로미터(km) 단위로 읽고 싶다면 Getter 메소드에서 변환해서 리턴해 줄 수 있다.

```java
double getSpeed() {
    double km = speed * 1.6;
    return km;
}
```

클래스를 선언할 때 가능하다면 필드를 `private`로 선언해서 외부로부터 보호하고, 필드에 대한 Setter와 Getter 메소드를 작성해서 필드값을 안전하게 변경/사용하는 것이 좋다.

Setter와 Getter 메소드는 다음과 같은 명명 규칙을 권장한다.

| 리턴타입 | 메소드 이름                           | 작성 예                |
| -------- | ------------------------------------- | ---------------------- |
| boolean  | is`FieldName`()                       | isStop()               |
| 그 외    | get`FieldName`()                      | getSpeed()             |
| void     | set`FieldName`(`Type` `fieldName`)    | setSpeed(double speed) |
| boolean  | set`FieldName`(`boolean` `fieldName`) | setStop(boolean stop)  |

**Car.java**
```java
package ch06.sec14;

public class Car {
	// 필드 선언
	private int speed;
	private boolean stop;
	
	// speed 필드의 Getter/Setter 선언
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}
	
	// stop 필드의 Getter/Setter 선언
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		if (stop == true) this.speed = 0;
	}
}
```

**CarExample.java**
```java
package ch06.sec14;

public class CarExample {
	public static void main(String[] args) {
		// 객체 생성
		Car myCar = new Car();
		
		// 잘못된 속도 변경
		myCar.setSpeed(-50);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		// 올바른 속도 변경
		myCar.setSpeed(60);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		// 멈춤
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("현재 속도: " + myCar.getSpeed());
	}
}
```

**실행 결과**
```
현재 속도: 0
현재 속도: 60
현재 속도: 0
```
