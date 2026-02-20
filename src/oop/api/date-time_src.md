---
layout: oop
title: "12.8 날짜와 시간 클래스"
nav_order: 8
parent: "Chapter 12. java.base 모듈"
grand_parent: "객체지향 프로그래밍"
---

# 12.8 날짜와 시간 클래스

자바는 컴퓨터의 날짜 및 시각을 읽을 수 있도록 java.util 패키지에서 Date와 Calendar 클래스를 제공하고 있다. 또한 날짜와 시간을 조작할 수 있도록 java.time 패키지에서 LocalDateTime 등의 클래스를 제공한다.

| 라이브러리    | 사용 패키지 | 설명                                         |
| :------------ | :---------- | :------------------------------------------- |
| Date          | java.util   | 날짜 정보를 전달하기 위해 사용               |
| Calendar      | java.util   | 다양한 시간대별로 날짜와 시간을 얻을 때 사용 |
| LocalDateTime | java.time   | 날짜와 시간을 조작할 때 사용                 |

## Date 클래스

Date는 날짜를 표현하는 클래스로 객체 간에 날짜 정보를 주고받을 때 사용된다. Date 클래스에는 여러 개의 생성자가 선언되어 있지만 대부분 Deprecated(더 이상 사용되지 않음)되어 Date() 생성자만 주로 사용된다. Date() 생성자는 컴퓨터의 현재 날짜를 읽어 Date 객체로 만든다.

```java
Date now = new Date();
```

현재 날짜를 문자열로 얻고 싶다면 toString() 메소드를 사용할 수 있지만 영문으로 출력되기 때문에 우리가 원하는 형식이 아니다. 원하는 문자열로 얻고 싶다면 SimpleDateFormat 클래스와 함께 사용해야 한다. 다음 예제는 '년.월.일 시:분:초' 형식으로 문자열을 얻는 방법을 보여 준다.

```java
package ch12.sec08;

import java.text.*;
import java.util.*;

public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}
}
```

**실행 결과**
```
Sun Nov 28 19:29:51 KST 2021
2021.11.28 19:29:51
```

## Calendar 클래스

Calendar 클래스는 달력을 표현하는 추상 클래스이다. 날짜와 시간을 계산하는 방법이 지역과 문화에 따라 다르기 때문에 특정 역법(날짜와 시간을 매기는 방법)에 따르는 달력은 자식 클래스에서 구현하도록 되어 있다.

특별한 역법을 사용하는 경우가 아니라면 직접 하위 클래스를 만들 필요는 없고 Calendar 클래스의 정적 메소드인 getInstance() 메소드를 이용하면 컴퓨터에 설정되어 있는 시간대(TimeZone)를 기준으로 Calendar 하위 객체를 얻을 수 있다.

```java
Calendar now = Calendar.getInstance();
```

Calendar가 제공하는 날짜와 시간에 대한 정보를 얻기 위해서는 get() 메소드를 이용한다. get() 메소드의 매개값으로 Calendar에 정의된 상수를 주면 상수가 의미하는 값을 리턴한다.

```java
int year = now.get(Calendar.YEAR);                 // 년도를 리턴
int month = now.get(Calendar.MONTH) + 1;           // 월을 리턴
int day = now.get(Calendar.DAY_OF_MONTH);          // 일을 리턴
int week = now.get(Calendar.DAY_OF_WEEK);          // 요일을 리턴
int amPm = now.get(Calendar.AM_PM);                // 오전/오후를 리턴
int hour = now.get(Calendar.HOUR);                 // 시를 리턴
int minute = now.get(Calendar.MINUTE);             // 분을 리턴
int second = now.get(Calendar.SECOND);             // 초를 리턴
```

```java
package ch12.sec08;

import java.util.*;

public class CalendarExample {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);

		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch(week) {
			case Calendar.MONDAY:   strWeek = "월"; break;
			case Calendar.TUESDAY:  strWeek = "화"; break;
			case Calendar.WEDNESDAY: strWeek = "수"; break;
			case Calendar.THURSDAY: strWeek = "목"; break;
			case Calendar.FRIDAY:   strWeek = "금"; break;
			case Calendar.SATURDAY: strWeek = "토"; break;
			default:                strWeek = "일";
		}

		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}

		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.println(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.println(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.println(second + "초 ");
	}
}
```

**실행 결과**
```
2021년 11월 28일
일요일 오후
7시 47분 54초
```

Calendar 클래스의 오버로딩된 다른 getInstance() 메소드를 이용하면 미국/로스앤젤레스와 같은 다른 시간대의 Calendar를 얻을 수 있다. 알고 싶은 시간대의 TimeZone 객체를 얻어, getInstance() 메소드의 매개값으로 넘겨주면 된다.

```java
TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
Calendar now = Calendar.getInstance(timeZone);
```

```java
package ch12.sec08;

import java.util.Calendar;
import java.util.TimeZone;

public class LosAngelesExample {
	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar now = Calendar.getInstance(timeZone);

		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}

		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		System.out.print(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.println(second + "초 ");
	}
}
```

**실행 결과**
```
오전 2시 58분 12초
```

America/Los_Angeles와 같은 시간대 ID는 TimeZone.getAvailableIDs() 메소드가 리턴하는 값 중 하나를 사용하면 된다. 다음 예제는 TimeZone.getAvailableIDs() 메소드가 리턴하는 시간대 ID를 모두 출력한다.

```java
package ch12.sec08;

import java.util.TimeZone;

public class PrintTimeZoneID {
	public static void main(String[] args) {
		String[] availableIDs = TimeZone.getAvailableIDs();
		for (String id : availableIDs) {
			System.out.println(id);
		}
	}
}
```

**실행 결과**
```
Africa/Abidjan
Africa/Accra
Africa/Addis_Ababa
...
```

## 날짜와 시간 조작

Date와 Calendar는 날짜와 시간 정보를 얻기에는 충분하지만, 날짜와 시간을 조작할 수는 없다. 이때는 java.time 패키지의 LocalDateTime 클래스가 제공하는 다음 메소드를 이용하면 매우 쉽게 날짜와 시간을 조작할 수 있다.

| 메소드             | 설명        |
| :----------------- | :---------- |
| minusYears(long)   | 년 빼기     |
| minusMonths(long)  | 월 빼기     |
| minusDays(long)    | 일 빼기     |
| minusWeeks(long)   | 주 빼기     |
| plusYears(long)    | 년 더하기   |
| plusMonths(long)   | 월 더하기   |
| plusDays(long)     | 일 더하기   |
| plusWeeks(long)    | 주 더하기   |
| minusHours(long)   | 시간 빼기   |
| minusMinutes(long) | 분 빼기     |
| minusSeconds(long) | 초 빼기     |
| minusNanos(long)   | 나노초 빼기 |
| plusHours(long)    | 시간 더하기 |
| plusMinutes(long)  | 분 더하기   |
| plusSeconds(long)  | 초 더하기   |

LocalDateTime 클래스를 이용해서 현재 컴퓨터의 날짜와 시간을 얻는 방법은 다음과 같다.

```java
LocalDateTime now = LocalDateTime.now();
```

다음 예제는 현재 시간에서 년, 월, 일을 연산하는 방법이다.

```java
package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("현재 시간: " + now.format(dtf));

		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 덧셈: " + result1.format(dtf));

		LocalDateTime result2 = now.minusMonths(2);
		System.out.println("2월 뺄셈: " + result2.format(dtf));

		LocalDateTime result3 = now.plusDays(7);
		System.out.println("7일 덧셈: " + result3.format(dtf));
	}
}
```

**실행 결과**
```
현재 시간: 2021.11.28 오후 21:13:37
1년 덧셈: 2022.11.28 오후 21:13:37
2월 뺄셈: 2021.09.28 오후 21:13:37
7일 덧셈: 2021.12.05 오후 21:13:37
```

9라인의 DateTimeFormatter는 날짜와 시간을 주어진 문자열 패턴으로 변환할 때 사용한다. LocalDateTime의 format() 메소드 호출 시 매개값으로 제공하면 문자열 패턴과 동일한 문자열을 얻을 수 있다.

## 날짜와 시간 비교

LocalDateTime 클래스는 날짜와 시간을 비교할 수 있는 다음 메소드도 제공한다.

| 리턴 타입 | 메소드             | 설명                          |
| :-------- | :----------------- | :---------------------------- |
| boolean   | isAfter(other)     | 이후 날짜인지?                |
| boolean   | isBefore(other)    | 이전 날짜인지?                |
| boolean   | isEqual(other)     | 동일 날짜인지?                |
| long      | until(other, unit) | 주어진 단위(unit) 차이를 리턴 |

비교를 위해 특정 날짜와 시간으로 LocalDateTime 객체를 얻는 방법은 다음과 같다. year부터 second까지 매개값을 모두 int 타입 값으로 제공하면 된다.

```java
LocalDateTime target = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
```

다음 예제는 2021년 1월 1일과 2021년 12월 31일을 비교한다.

```java
package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeCompareExample {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

		LocalDateTime startDateTime = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
		System.out.println("시작일: " + startDateTime.format(dtf));

		LocalDateTime endDateTime = LocalDateTime.of(2021, 12, 31, 0, 0, 0);
		System.out.println("종료일: " + endDateTime.format(dtf));

		if (startDateTime.isBefore(endDateTime)) {
			System.out.println("진행 중입니다.");
		} else if (startDateTime.isEqual(endDateTime)) {
			System.out.println("종료합니다.");
		} else if (startDateTime.isAfter(endDateTime)) {
			System.out.println("종료했습니다.");
		}

		long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);

		System.out.println("남은 해: " + remainYear);
		System.out.println("남은 월: " + remainMonth);
		System.out.println("남은 일: " + remainDay);
		System.out.println("남은 시간: " + remainHour);
		System.out.println("남은 분: " + remainMinute);
		System.out.println("남은 초: " + remainSecond);
	}
}
```

**실행 결과**
```
시작일: 2021.01.01 오전 00:00:00
종료일: 2021.12.31 오전 00:00:00
진행 중입니다.
남은 해: 0
남은 월: 11
남은 일: 364
남은 시간: 8736
남은 분: 524160
남은 초: 31449600
```
