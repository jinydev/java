---
layout: oop
title: "6.8 메소드 선언과 호출"
nav_order: 8
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.8 메소드 선언과 호출

메소드 선언은 객체의 동작을 실행 블록으로 정의하는 것을 말하고, 메소드 호출은 실행 블록을 실제로 실행하는 것을 말한다. 메소드는 객체 내부에서도 호출되지만 다른 객체에서도 호출될 수 있기 때문에 객체 간의 상호작용 방법을 정의하는 것이라고 볼 수 있다. 상호작용의 개념은 6.1절을 참고하길 바란다.

## 메소드 선언

다음은 메소드를 선언하는 방법을 보여 준다.

```java
리턴타입 메소드명 (매개변수, ...) {
    // 실행할 코드를 작성하는 곳
}
```

### 리턴 타입

리턴 타입은 메소드가 실행한 후 호출한 곳으로 전달하는 결과값의 타입을 말한다. 리턴값이 없는 메소드는 `void`로 작성해야 한다.

```java
void powerOn() { ... } // 리턴값이 없는 메소드 선언
double divide(int x, int y) { ... } // double 타입 값을 리턴하는 메소드 선언
```

리턴 타입이 있는 메소드는 실행 블록 안에서 `return` 문으로 리턴값을 반드시 지정해야 한다.

### 메소드명

메소드명은 첫 문자를 소문자로 시작하고, 캐멀 스타일로 작성한다. 다음은 잘 작성된 메소드명을 보여 준다.

```java
void run() { ... }
void setSpeed(int speed) { ... }
String getName() { ... }
```

### 매개변수

매개변수는 메소드를 호출할 때 전달한 매개값을 받기 위해 사용된다. 다음 예에서 `divide()` 메소드는 연산할 두 수를 전달받아야 하므로 매개변수가 2개 필요하다. 전달할 매개값이 없다면 매개변수는 생략할 수 있다.

```java
double divide(int x, int y) { ... }
```

### 실행 블록

메소드 호출 시 실행되는 부분이다.

다음 예제는 `Calculator` 클래스에서 `powerOn()`, `plus()`, `divide()`, `powerOff()` 메소드를 선언하는 방법을 보여 준다.

**Calculator.java**
```java
package ch06.sec08.exam01;

public class Calculator {
	// 리턴값이 없는 메소드 선언
	void powerOn() {
		System.out.println("전원을 니다.");
	}

	// 리턴값이 없는 메소드 선언
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	// 호출 시 두 정수 값을 전달받고,
	// 호출한 곳으로 결과값 int를 리턴하는 메소드 선언
	int plus(int x, int y) {
		int result = x + y;
		return result; // 리턴값 지정
	}

	// 호출 시 두 정수 값을 전달받고,
	// 호출한 곳으로 결과값 double을 리턴하는 메소드 선언
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result; // 리턴값 지정
	}
}
```

## 메소드 호출

메소드를 호출한다는 것은 메소드 블록을 실행하는 것을 말한다. 클래스에서 메소드를 선언했다고 해서 바로 호출할 수 있는 것은 아니다. 메소드는 객체의 동작이므로 객체가 존재하지 않으면 메소드를 호출할 수 없다.

클래스로부터 객체가 생성된 후에 메소드는 생성자와 다른 메소드 내부에서 호출될 수 있고, 객체 외부에서도 호출될 수 있다.

객체 내부에서는 단순히 메소드명으로 호출하면 되지만, 외부 객체에서는 참조 변수와 도트(.) 연산자를 이용해서 호출한다. 또한 메소드가 매개변수를 가지고 있을 때는 호출할 때 매개변수의 타입과 수에 맞게 매개값을 제공해야 한다.

메소드가 리턴값이 있을 경우에는 대입 연산자를 사용해서 다음과 같이 리턴값을 변수에 저장할 수 있다. 이때 변수 타입은 메소드의 리턴 타입과 동일하거나 자동 타입 변환될 수 있어야 한다.

```java
타입 변수 = 메소드();
```

**객체 내부**
```java
Calculator() {
    powerOff();
}

void method() {
    powerOn();
    int r1 = plus(3, 5);
    double r2 = divide(15, 3);
}
```

**외부 객체**
```java
void method() {
    Calculator calc = new Calculator();
    calc.powerOn();
    int r1 = calc.plus(10, 20);
    double r2 = calc.divide(10, 30);
}
```

다음 예제는 `Calculator` 클래스에서 선언된 `powerOn()`, `plus()`, `divide()`, `powerOff()` 메소드를 호출하는 방법을 보여 준다.

**CalculatorExample.java**
```java
package ch06.sec08.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		// Calculator 객체 생성
		Calculator myCalc = new Calculator();
		
		// 리턴값이 없는 powerOn() 메소드 호출
		myCalc.powerOn();
		
		// plus 메소드 호출 시 5와 6을 매개값으로 제공하고,
		// 덧셈 결과를 리턴받아 result1 변수에 대입
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1: " + result1);
		
		int x = 10;
		int y = 4;
		// divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고,
		// 나눗셈 결과를 리턴받아 result2 변수에 대입
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2);
		
		// 리턴값이 없는 powerOff() 메소드 호출
		myCalc.powerOff();
	}
}
```

**실행 결과**
```
전원을 니다.
result1: 11
result2: 2.5
전원을 끕니다.
```

## 가변길이 매개변수

메소드를 호출할 때에는 매개변수의 개수에 맞게 매개값을 제공해야 한다. 만약 메소드가 가변길이 매개변수를 가지고 있다면 매개변수의 개수와 상관없이 매개값을 줄 수 있다. 가변길이 매개변수는 다음과 같이 선언한다.

```java
int sum(int ... values) {
}
```

가변길이 매개변수는 메소드 호출 시 매개값을 쉼표로 구분해서 개수와 상관없이 제공할 수 있다.

```java
int result = sum(1, 2, 3);
int result = sum(1, 2, 3, 4, 5);
```

매개값들은 자동으로 배열 항목으로 변환되어 메소드에서 사용된다. 그렇기 때문에 메소드 호출 시 직접 배열을 매개값으로 제공해도 된다.

```java
int[] values = { 1, 2, 3 };
int result = sum(values);
int result = sum(new int[] { 1, 2, 3 });
```

**Computer.java**
```java
package ch06.sec08.exam02;

public class Computer {
	// 가변길이 매개변수를 갖는 메소드 선언
	int sum(int ... values) {
		// sum 변수 선언
		int sum = 0;
		
		// values는 배열 타입의 변수처럼 사용
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		
		// 합산 결과를 리턴
		return sum;
	}
}
```

**ComputerExample.java**
```java
package ch06.sec08.exam02;

public class ComputerExample {
	public static void main(String[] args) {
		// Computer 객체 생성
		Computer myCom = new Computer();
		
		// sum() 메소드 호출 시 매개값 1, 2, 3을 제공하고
		// 합산 결과를 리턴받아 result1 변수에 대입
		int result1 = myCom.sum(1, 2, 3);
		System.out.println("result1: " + result1);
		
		// sum() 메소드 호출 시 매개값 1, 2, 3, 4, 5를 제공하고
		// 합산 결과를 리턴받아 result2 변수에 대입
		int result2 = myCom.sum(1, 2, 3, 4, 5);
		System.out.println("result2: " + result2);
		
		// sum() 메소드 호출 시 배열을 제공하고
		// 합산 결과를 리턴받아 result3 변수에 대입
		int[] values = { 1, 2, 3, 4, 5 };
		int result3 = myCom.sum(values);
		System.out.println("result3: " + result3);
		
		// sum() 메소드 호출 시 배열을 제공하고
		// 합산 결과를 리턴받아 result4 변수에 대입
		int result4 = myCom.sum(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("result4: " + result4);
	}
}
```

**실행 결과**
```
result1: 6
result2: 15
result3: 15
result4: 15
```

## return 문

`return` 문은 메소드의 실행을 강제 종료하고 호출한 곳으로 돌아간다는 의미이다. 메소드 선언에 리턴 타입이 있을 경우에는 `return` 문 뒤에 리턴값을 추가로 지정해야 한다.

```java
return [리턴값];
```

`return` 문 이후에 실행문을 작성하면 'Unreachable code'라는 컴파일 에러가 발생한다. 왜냐하면 `return` 문 이후의 실행문은 결코 실행되지 않기 때문이다.

```java
int plus(int x, int y) {
    int result = x + y;
    return result;
    System.out.println(result); // Unreachable code
}
```

하지만 다음과 같은 경우에는 컴파일 에러가 발생하지 않는다.

```java
boolean isLeftGas() {
    if (gas == 0) {
        System.out.println("gas가 없습니다.");
        return false; // 1
    }
    System.out.println("gas가 있습니다."); // 2
    return true;
}
```

`if` 문의 조건식이 false가 되면 정상적으로 2가 실행되기 때문에 2는 'Unreachable code' 에러를 발생시키지 않는다. `if` 문의 조건식이 true가 되면 1이 실행되고 `return false;`가 실행되어 메소드는 즉시 종료되므로 당연히 2는 실행되지 않는다.

**Car.java**
```java
package ch06.sec08.exam03;

public class Car {
	// 필드 선언
	int gas;
	
	// 리턴값이 없는 메소드로 매개값을 받아서 gas 필드값을 변경
	void setGas(int gas) {
		this.gas = gas;
	}
	
	// 리턴값이 boolean인 메소드로 gas 필드값이 0이면 false를, 0이 아니면 true를 리턴
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false; // false를 리턴하고 메소드 종료
		}
		System.out.println("gas가 있습니다.");
		return true; // true를 리턴하고 메소드 종료
	}
	
	// 리턴값이 없는 메소드로 gas 필드값이 0이면 return 문으로 메소드를 종료
	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다.(gas잔량:" + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다.(gas잔량:" + gas + ")");
				return; // 메소드 종료
			}
		}
	}
}
```

**CarExample.java**
```java
package ch06.sec08.exam03;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();
		
		// 리턴값이 없는 setGas() 메소드 호출
		myCar.setGas(5);
		
		// isLeftGas() 메소드를 호출해서 받은 리턴값이 true일 경우 if 블록 실행
		if (myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			
			// 리턴값이 없는 run() 메소드 호출
			myCar.run();
		}
		
		System.out.println("gas를 주입하세요.");
	}
}
```

**실행 결과**
```
gas가 있습니다.
출발합니다.
달립니다.(gas잔량:5)
달립니다.(gas잔량:4)
달립니다.(gas잔량:3)
달립니다.(gas잔량:2)
달립니다.(gas잔량:1)
멈춥니다.(gas잔량:0)
gas를 주입하세요.
```

## 메소드 오버로딩

메소드 오버로딩(Overloading)은 메소드 이름은 같되 매개변수의 타입, 개수, 순서가 다른 메소드를 여러 개 선언하는 것을 말한다.

```java
class 클래스 {
    리턴타입 메소드이름 (타입 변수, ...) { ... }
    리턴타입 메소드이름 (타입 변수, ...) { ... } 
    // 리턴타입은 무관, 매개변수는 동일값, 개수, 순서가 달라야 함
}
```

메소드 오버로딩의 목적은 다양한 매개값을 처리하기 위해서이다. 다음 예에서 `plus()` 메소드는 두 개의 `int` 타입 매개값만 처리하고 `double` 타입 매개값은 처리할 수 없다.

```java
int plus(int x, int y) {
    int result = x + y;
    return result;
}
```

만약 `double` 타입 값도 처리하고 싶다면 다음과 같이 `plus()` 메소드를 오버로딩하면 된다.

```java
double plus(double x, double y) {
    double result = x + y;
    return result;
}
```

메소드 오버로딩의 대표적인 예는 콘솔에 출력하는 `System.out.println()` 메소드로, 호출할 때 주어진 매개값의 타입에 따라서 오버로딩된 `println()` 메소드 중 하나를 실행한다.

```java
void println() { ... }
void println(double x) { ... }
void println(int x) { ... }
void println(String x) { ... }
```

다음 예제는 `areaRectangle()` 메소드를 오버로딩해서 매개값이 한 개면 정사각형의 넓이를, 두 개면 직사각형의 넓이를 계산한다.

**Calculator.java**
```java
package ch06.sec08.exam04;

public class Calculator {
	// 정사각형의 넓이
	double areaRectangle(double width) {
		return width * width;
	}
	
	// 직사각형의 넓이
	double areaRectangle(double width, double height) {
		return width * height;
	}
}
```

**CalculatorExample.java**
```java
package ch06.sec08.exam04;

public class CalculatorExample {
	public static void main(String[] args) {
		// 객체 생성
		Calculator myCalcu = new Calculator();
		
		// 정사각형의 넓이 구하기
		double result1 = myCalcu.areaRectangle(10);
		
		// 직사각형의 넓이 구하기
		double result2 = myCalcu.areaRectangle(10, 20);
		
		System.out.println("정사각형 넓이=" + result1);
		System.out.println("직사각형 넓이=" + result2);
	}
}
```

**실행 결과**
```
정사각형 넓이=100.0
직사각형 넓이=200.0
```
