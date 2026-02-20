---
layout: oop
title: "12.7 수학 클래스"
nav_order: 7
parent: "Chapter 12. java.base 모듈"
grand_parent: "객체지향 프로그래밍"
---

# 12.7 수학 클래스

`Math` 클래스는 수학 계산에 사용할 수 있는 메소드를 제공한다. `Math` 클래스가 제공하는 메소드는 모두 `정적(static)`이므로 `Math` 클래스로 바로 사용이 가능하다. 다음은 `Math` 클래스가 제공하는 주요 메소드이다.

| 구분     | 설명                                                       | 사용 예                                                           | 실행 결과                 |
| :------- | :--------------------------------------------------------- | :---------------------------------------------------------------- | :------------------------ |
| 절대값   | `Math.abs(int a)`<br>`Math.abs(double a)`                  | `int v1 = Math.abs(-5);`<br>`double v2 = Math.abs(-3.14);`        | `v1 = 5`<br>`v2 = 3.14`   |
| 올림값   | `Math.ceil(double a)`                                      | `double v3 = Math.ceil(5.3);`<br>`double v4 = Math.ceil(-5.3);`   | `v3 = 6.0`<br>`v4 = -5.0` |
| 버림값   | `Math.floor(double a)`                                     | `double v5 = Math.floor(5.3);`<br>`double v6 = Math.floor(-5.3);` | `v5 = 5.0`<br>`v6 = -6.0` |
| 최대값   | `Math.max(int a, int b)`<br>`Math.max(double a, double b)` | `int v7 = Math.max(5, 9);`<br>`double v8 = Math.max(5.3, 2.5);`   | `v7 = 9`<br>`v8 = 5.3`    |
| 최소값   | `Math.min(int a, int b)`<br>`Math.min(double a, double b)` | `int v9 = Math.min(5, 9);`<br>`double v10 = Math.min(5.3, 2.5);`  | `v9 = 5`<br>`v10 = 2.5`   |
| 랜덤값   | `Math.random()`                                            | `double v11 = Math.random();`                                     | `0.0 <= v11 < 1.0`        |
| 반올림값 | `Math.round(double a)`                                     | `long v14 = Math.round(5.3);`<br>`long v15 = Math.round(5.7);`    | `v14 = 5`<br>`v15 = 6`    |

```java
package ch12.sec07;

public class MathExample {
	public static void main(String[] args) {
		// 큰 정수 또는 작은 정수 얻기
		double v1 = Math.ceil(5.3);
		double v2 = Math.floor(5.3);
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);

		// 큰값 또는 작은값 얻기
		long v3 = Math.max(3, 7);
		long v4 = Math.min(3, 7);
		System.out.println("v3=" + v3);
		System.out.println("v4=" + v4);

		// 소수 이하 두 자리 얻기
		double value = 12.3456;
		double temp1 = value * 100;
		long temp2 = Math.round(temp1);
		double v5 = temp2 / 100.0;
		System.out.println("v5=" + v5);
	}
}
```

**실행 결과**
```
v1=5.3인 경우 ceil은 6.0
v1= 6.0
v2= 5.0
v3= 7
v4= 3
v5= 12.35
```

`random()` 메소드는 0.0과 1.0 사이의 `double` 타입 난수를 리턴한다. 이 값을 이용해서 start부터 시작하는 `n`개의 정수(start <= ... < start+n) 중 하나의 정수를 얻기 위한 공식을 만들면 다음과 같다.

```java
int num = (int) (Math.random() * n) + start;
```

난수를 얻는 또 다른 방법으로 `java.util.Random` 클래스를 이용할 수 있다. 이 클래스를 이용하면 `boolean`, `int`, `double` 난수를 얻을 수 있다.

```java
package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
		// 선택번호
		int[] selectNumber = new int[6];
		Random random = new Random(3); // 선택번호를 얻기 위한 Random 객체 생성(종자값 3)
		System.out.print("선택번호: ");
		for (int i=0; i<6; i++) {
			selectNumber[i] = random.nextInt(45) + 1; // 선택번호 6개를 얻어 배열에 저장
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		// 당첨번호
		int[] winningNumber = new int[6];
		random = new Random(5); // 당첨번호를 얻기 위한 Random 객체 생성(종자값 5)
		System.out.print("당첨번호: ");
		for (int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1; // 당첨번호 6개를 얻어 배열에 저장
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

		// 당첨여부
		Arrays.sort(selectNumber); // 비교하기 전에 배열 항목을 정렬시킴
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber); // 배열 항목 비교하기
		System.out.print("당첨여부: ");
		if (result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
	}
}
```

**실행 결과**
```
선택번호: 15 21 16 17 34 28
당첨번호: 18 38 45 15 22 36
당첨여부: 당첨되지 않았습니다.
```

선택번호 6개를 얻기 위해 `Random` 객체의 `종자값`으로 3을 주었고, 당첨번호 6개를 얻기 위해 `Random` 객체의 `종자값`으로 5를 주었다. 서로 다른 `종자값`을 주었기 때문에 선택번호와 당첨번호는 다르게 나온다. 만약 `종자값`을 동일하게 주면 동일한 난수를 얻기 때문에 선택번호와 당첨번호는 같게 나온다.
