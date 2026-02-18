---
layout: oop
title: "12.9 형식 클래스"
nav_order: 9
parent: "Chapter 12. java.base 모듈"
grand_parent: "객체지향 프로그래밍"
---

# 12.9 형식 클래스

Format(형식) 클래스는 숫자 또는 날짜를 원하는 형태의 문자열로 변환해주는 기능을 제공한다. Format 클래스는 java.text 패키지에 포함되어 있는데, 주요 Format 클래스는 다음과 같다.

| Format 클래스    | 설명                          |
| :--------------- | :---------------------------- |
| DecimalFormat    | 숫자를 형식화된 문자열로 변환 |
| SimpleDateFormat | 날짜를 형식화된 문자열로 변환 |

## DecimalFormat

DecimalFormat은 숫자를 형식화된 문자열로 변환하는 기능을 제공한다. 원하는 형식으로 표현하기 위해 다음과 같은 패턴을 사용한다.

| 기호   | 의미                                               | 패턴 예                      | 1234567.89 -> 변환 결과                          |
| :----- | :------------------------------------------------- | :--------------------------- | :----------------------------------------------- |
| 0      | 10진수(빈자리는 0으로 채움)                        | 0<br>0.0<br>0000000000.00000 | 1234568<br>1234567.9<br>0001234567.89000         |
| #      | 10진수(빈자리는 채우지 않음)                       | #<br>#.#<br>##########.##### | 1234568<br>1234567.9<br>1234567.89               |
| .      | 소수점                                             | #.0                          | 1234567.9                                        |
| -      | 음수 기호                                          | +#.0                         | +1234567.9<br>-1234567.9                         |
| ,      | 단위 구분                                          | #,###.0                      | 1,234,567.9                                      |
| E      | 지수문자                                           | 0.0E0                        | 1.2E6                                            |
| ;      | 양수와 음수의 패턴을 모두 기술할 경우, 패턴 구분자 | +#,###;-#.###                | +1,234.568 (양수일 때)<br>-1,234.568 (음수일 때) |
| %      | % 문자                                             | #.# %                        | 123456789%                                       |
| \u00A4 | 통화 기호                                          | \u00A4 #,###                 | ￦1,234,568                                       |

패턴 정보와 함께 DecimalFormat 객체를 생성하고 format() 메소드로 숫자를 제공하면 패턴에 따른 형식화된 문자열을 얻을 수 있다.

```java
DecimalFormat df = new DecimalFormat("#,###.0");
String result = df.format(1234567.89); // 1,234,567.9
```

```java
package ch12.sec09;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.89;

		DecimalFormat df;

		// 정수 자리까지 표기
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));

		// 무조건 소수 첫째 자리까지 표기
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(num));
	}
}
```

**실행 결과**
```
1,234,568
1,234,567.9
```

## SimpleDateFormat

SimpleDateFormat은 날짜를 형식화된 문자열로 변환하는 기능을 제공한다. 원하는 형식으로 표현하기 위해 다음과 같은 패턴을 사용한다.

| 패턴 문자 | 의미                     | 패턴 문자 | 의미                 |
| :-------- | :----------------------- | :-------- | :------------------- |
| y         | 년                       | H         | 시(0~23)             |
| M         | 월                       | h         | 시(1~12)             |
| d         | 일                       | K         | 시(0~11)             |
| D         | 월 구분이 없는 일(1~365) | k         | 시(1~24)             |
| E         | 요일                     | m         | 분                   |
| a         | 오전/오후                | s         | 초                   |
| w         | 년의 몇 번째 주          | S         | 밀리세컨드(1/1000초) |
| W         | 월의 몇 번째 주          |           |                      |

패턴에는 자릿수에 맞게 기호를 반복해서 작성할 수 있다. 예를 들어 yyyy는 년도를 4자리로, MM과 dd는 각각 월과 일을 2자리로 표시하라는 의미이다. 패턴 정보와 함께 SimpleDateFormat 객체를 생성하고 format() 메소드로 날짜를 제공하면 패턴과 동일한 문자열을 얻을 수 있다.

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
String strDate = sdf.format(new Date()); // 2021년 11월 28일
```

```java
package ch12.sec09;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
	public static void main(String[] args) {
		Date now = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("이달의 d번째 날");
		System.out.println(sdf.format(now));
	}
}
```

**실행 결과**
```
2021-11-28
2021년 11월 28일
2021.11.28 오후 20:33:28
오늘은 일요일
올해의 332번째 날
이달의 28번째 날
```
