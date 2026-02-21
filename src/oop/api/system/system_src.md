---
layout: oop
title: "12.4 System 클래스"
nav_order: 4
parent: "Chapter 12. java.base 모듈"
grand_parent: "객체지향 프로그래밍"
---

# 12.4 System 클래스

자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니라 `자바 가상 머신(JVM)` 위에서 실행된다. 따라서 운영체제의 모든 기능을 자바 코드로 직접 접근하기란 어렵다. 하지만 `java.lang` 패키지에 속하는 `System` 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.

`System` 클래스의 `정적(static)` 필드와 메소드를 이용하면 프로그램 종료, 키보드 입력, 콘솔(모니터) 출력, 현재 시간 읽기, 시스템 프로퍼티 읽기 등이 가능하다.

| 구분                 | 필드 및 메소드      | 용도                                       |
| :------------------- | :------------------ | :----------------------------------------- |
| 콘솔 출력            | out                 | 콘솔(모니터)에 문자 출력                   |
|                      | err                 | 콘솔(모니터)에 에러 내용 출력              |
| 키보드 입력          | in                  | 키보드 입력                                |
| 프로세스 종료        | exit(int status)    | 프로세스 종료                              |
| 진행 시간 읽기       | currentTimeMillis() | 현재 시간을 밀리초 단위의 long 값으로 리턴 |
|                      | nanoTime()          | 현재 시간을 나노초 단위의 long 값으로 리턴 |
| 시스템 프로퍼티 읽기 | getProperty()       | 운영체제와 사용자 정보 제공                |
|                      | getenv()            | 운영체제의 환경 변수 정보 제공             |

## 콘솔 출력

`out` 필드를 이용하면 콘솔에 원하는 문자열을 출력할 수 있다. `err` 필드도 `out` 필드와 동일한데, 차이점은 콘솔 종류에 따라 에러 내용이 빨간색으로 출력된다는 것이다. 다음은 `err` 필드의 `println()` 메소드로 에러 내용을 출력하는 예제이다.

```java
package ch12.sec04;

public class ErrExample {
	public static void main(String[] args) {
		try {
			int value = Integer.parseInt("1oo");
		} catch(NumberFormatException e) {
			System.err.println("[에러 내용]");
			System.err.println(e.getMessage());
		}
	}
}
```

**실행 결과**
```
[에러 내용]
For input string: "1oo"
```

## 키보드 입력

자바는 키보드로부터 입력된 키를 읽기 위해 `System` 클래스에서 `in` 필드를 제공한다. 다음과 같이 `in` 필드를 이용해서 `read()` 메소드를 호출하면 입력된 키의 코드값을 얻을 수 있다.

```java
int keyCode = System.in.read();
```

키 코드는 각 키에 부여되어 있는 번호이다.

`read()` 메소드는 호출과 동시에 키 코드를 읽는 것이 아니라, `Enter` 키를 누르기 전까지는 대기 상태이다가 `Enter` 키를 누르면 입력했던 키들을 하나씩 읽기 시작한다. 단, `read()` 메소드는 `IOException`을 발생할 수 있는 코드이므로 예외 처리가 필요하다.

다음은 숫자 키 1과 2를 입력함에 따라 `speed` 변수값을 증감하는 예제이다. 그리고 숫자 키 3을 입력하면 `while` 문을 종료하도록 했다.

```java
package ch12.sec04;

import java.io.IOException;

public class InExample {
	public static void main(String[] args) throws IOException {
		int speed = 0;
		int keyCode = 0;

		while (true) {
			// Enter 키를 읽지 않았을 경우에만 실행
			if (keyCode != 13 && keyCode != 10) {
				if (keyCode == 49) { // 숫자 1 키를 읽었을 경우
					speed++;
				} else if (keyCode == 50) { // 숫자 2 키를 읽었을 경우
					speed--;
				} else if (keyCode == 51) { // 숫자 3 키를 읽었을 경우
					break;
				}
				System.out.println("-------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("-------------------------");
				System.out.println("현재 속도= " + speed);
				System.out.print("선택: ");
			}

			// 키를 하나씩 읽음
			keyCode = System.in.read();
		}

		System.out.println("프로그램 종료");
	}
}
```

**실행 결과**
```
-------------------------
1. 증속 | 2. 감속 | 3. 중지
-------------------------
현재 속도= 0
선택: 1 <Enter>
-------------------------
1. 증속 | 2. 감속 | 3. 중지
-------------------------
현재 속도= 1
선택: 2 <Enter>
-------------------------
1. 증속 | 2. 감속 | 3. 중지
-------------------------
현재 속도= 0
선택: 3 <Enter>
프로그램 종료
```

## 프로세스 종료

운영체제는 실행 중인 프로그램을 `프로세스(process)`로 관리한다. 자바 프로그램을 시작하면 `JVM 프로세스`가 생성되고, 이 프로세스가 `main()` 메소드를 호출한다. 프로세스를 강제 종료하고 싶다면 `System.exit()` 메소드를 사용한다.

```java
System.exit(int status)
```

`exit()` 메소드는 `int` 매개값이 필요한데, 이 값을 `종료 상태값`이라고 한다. 종료 상태값으로 어떤 값을 주더라도 프로세스는 종료되는데 정상 종료일 경우 0, 비정상 종료는 1 또는 -1로 주는 것이 관례이다.

다음 예제는 i가 5가 되면 프로세스를 정상 종료한다.

```java
package ch12.sec04;

public class ExitExample {
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			// i값 출력
			System.out.println(i);
			if (i == 5) {
				System.out.println("프로세스 강제 종료");
				System.exit(0);
			}
		}
	}
}
```

**실행 결과**
```
0
1
2
3
4
5
프로세스 강제 종료
```

## 진행 시간 읽기

`System` 클래스의 `currentTimeMillis()` 메소드와 `nanoTime()` 메소드는 1970년 1월 1일 0시부터 시작해서 현재까지 진행된 시간을 리턴한다.

| 메소드                   | 용도                               |
| :----------------------- | :--------------------------------- |
| long currentTimeMillis() | 1/1000초 단위로 진행된 시간을 리턴 |
| long nanoTime()          | 1/10^9초 단위로 진행된 시간을 리턴 |

이 두 메소드는 프로그램 처리 시간을 측정하는 데 주로 사용된다. 프로그램 처리를 시작할 때 한 번, 끝날 때 한 번 읽어서 그 차이를 구하면 프로그램 처리 시간이 나온다. 다음 예제는 for문을 사용해서 1부터 1000000까지의 합을 구하는데 걸린 시간을 출력한다.

```java
package ch12.sec04;

public class MeasureRunTimeExample {
	public static void main(String[] args) {
		long time1 = System.nanoTime();
		int sum = 0;
		for (int i=1; i<=1000000; i++) {
			sum += i;
		}

		long time2 = System.nanoTime();

		System.out.println("1-1000000까지의 합: " + sum);
		System.out.println("계산에 " + (time2 - time1) + " 나노초가 소요되었습니다.");
	}
}
```

**실행 결과**
```
1-1000000까지의 합: 1784293664
계산에 1933400 나노초가 소요되었습니다.
```

## 시스템 프로퍼티 읽기

`시스템 프로퍼티(System Property)`란 자바 프로그램이 시작될 때 자동 설정되는 시스템의 속성을 말한다. 예를 들어 운영체제 종류 및 사용자 정보, 자바 버전 등의 기본 사양 정보가 해당한다. 다음은 시스템 프로퍼티의 주요 속성 이름(key)과 값(value)에 대해 설명한 것이다.

| 속성 이름(key)             | 설명                    | 값(value) 예시                     |
| :------------------------- | :---------------------- | :--------------------------------- |
| java.specification.version | 자바 스펙 버전          | 17                                 |
| java.home                  | JDK 디렉토리 경로       | C:\Program Files\Java\jdk-17.0.2   |
| os.name                    | 운영체제                | Windows 10                         |
| user.name                  | 사용자 이름             | xxx                                |
| user.home                  | 사용자 홈 디렉토리 경로 | C:\Users\xxx                       |
| user.dir                   | 현재 디렉토리 경로      | C:\ThisIsJava\workspace\thisisjava |

다음은 운영체제 이름, 사용자 이름, 사용자 홈 디렉토리를 따로 출력하고, 모든 시스템 프로퍼티의 속성 이름과 값을 출력하는 예제이다. (`Properties`와 `Set`은 15장에서 학습한다.)

```java
package ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
	public static void main(String[] args) {
		// 운영체제와 사용자 정보 출력
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);

		// 전체 키와 값을 출력
		System.out.println("---------------------------------");
		System.out.println(" key: value");
		System.out.println("---------------------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();

		for (Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s\n", key, value);
		}
	}
}
```
