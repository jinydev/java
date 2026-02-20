---
layout: oop
title: "5.12 열거(Enum) 타입"
nav_order: 12
parent: "Chapter 05. 참조 타입"
grand_parent: "객체지향 자바 프로그래밍"
---

# 5.12 열거(Enum) 타입

데이터 중에는 몇 가지로 한정된 값을 갖는 경우가 있다. 예를 들어 요일은 월, 화, 수, 목, 금, 토, 일이라는 7개의 값을, 계절은 봄, 여름, 가을, 겨울이라는 4개의 값을 갖는다. 이와 같이 한정된 값을 갖는 타입을 열거 타입(enumeration type)이라고 한다.

열거 타입을 사용하기 위해서는 먼저 열거 타입 이름으로 소스 파일(.java)을 생성하고 한정된 값을 코드로 정의해야 한다. 열거 타입 이름은 첫 문자를 대문자로 하고 다음과 같이 캐멀(Camel) 스타일로 지어 주는 것이 관례이다.

```
Week.java
MemberGrade.java
ProductKind.java
```

요일을 저장할 수 있는 열거 타입인 `Week`를 이클립스에서 생성해 보자.

01 먼저 ch05.sec12 패키지를 생성 및 선택한 후 마우스 오른쪽 버튼으로 클릭하여 [New] - [Enum]을 선택한다.

02 [New Enum Type] 대화상자에서 Name 입력란에 'Week'라고 입력하고 [Finish] 버튼을 클릭한다.

03 요일 값은 7개이므로 다음과 같이 열거 상수 목록을 작성한다.

**[예제: Week.java]**

```java
package ch05.sec12;

public enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

**열거 상수 목록(한정된 값 목록)**

열거 상수는 열거 타입으로 사용할 수 있는 한정된 값을 말한다. 관례적으로 알파벳으로 정의하며, 모두 대문자로 작성한다. 만약 열거 상수가 여러 단어로 구성될 경우에는 다음과 같이 단어와 단어 사이를 언더바(`_`)로 연결하는 것이 관례이다.

```java
public enum LoginResult {
    LOGIN_SUCCESS,
    LOGIN_FAILED
}
```

열거 타입도 하나의 데이터 타입이므로 변수를 선언하고 사용해야 한다. 열거 타입 `Week`로 변수를 선언하면 다음과 같다.

```java
Week today;
Week reservationDay;
```

열거 타입 변수에는 열거 상수를 대입할 수 있는데, '열거타입.열거상수' 형태로 작성한다. `Week` 변수에 열거 상수인 `SUNDAY`를 대입하는 코드는 다음과 같다.

```java
Week today = Week.SUNDAY;
```

열거 타입은 참조 타입이므로 `Week` 변수에 다음과 같이 `null`도 대입할 수 있다.

```java
Week birthday = null;
```

열거 변수의 값이 특정 열거 상수인지 비교할 때는 `==`와 `!=` 연산자를 사용한다. `Week` 변수값이 `SUNDAY`인지 비교하는 코드는 다음과 같다.

```java
Week today = Week.SUNDAY;
boolean result = (today == Week.SUNDAY); // 결과: true
```

컴퓨터의 날짜 및 요일, 시간을 얻을 때는 `Calendar`를 이용한다. `Calendar`에 대해서는 10장에서 자세히 알아보기로 하고, 여기서는 오늘의 연, 월, 일, 요일, 시간, 분, 초를 다음과 같이 얻을 수 있다는 것만 알아두자.

```java
Calendar now = Calendar.getInstance(); // Calendar 객체 얻기
int year    = now.get(Calendar.YEAR);            // 연
int month   = now.get(Calendar.MONTH) + 1;       // 월(1~12)
int day     = now.get(Calendar.DAY_OF_MONTH);    // 일
int week    = now.get(Calendar.DAY_OF_WEEK);     // 요일(1~7)
int hour    = now.get(Calendar.HOUR);            // 시간
int minute  = now.get(Calendar.MINUTE);          // 분
int second  = now.get(Calendar.SECOND);          // 초
```

다음은 `Calendar`를 이용해서 오늘의 요일을 얻는 예제이다. 요일은 1~7 사이의 숫자이므로 코드 가독성을 위해 열거 상수로 변환해서 `Week` 변수에 대입하고 사용하는 방법을 보여 준다.

**[예제: WeekExample.java]**

```java
package ch05.sec12;

import java.util.Calendar;

public class WeekExample {
    public static void main(String[] args) {
        //Week 열거 타입 변수 선언
        Week today = null;
        
        //Calendar 얻기
        Calendar cal = Calendar.getInstance();
        
        //오늘의 요일 얻기(1~7)
        int week = cal.get(Calendar.DAY_OF_WEEK);
        
        //숫자를 열거 상수로 변환해서 변수에 대입
        switch(week) {
            case 1: today = Week.SUNDAY;    break;
            case 2: today = Week.MONDAY;    break;
            case 3: today = Week.TUESDAY;   break;
            case 4: today = Week.WEDNESDAY; break;
            case 5: today = Week.THURSDAY;  break;
            case 6: today = Week.FRIDAY;    break;
            case 7: today = Week.SATURDAY;  break;
        }
        
        //열거 타입 변수를 사용
        if(today == Week.SUNDAY) {
            System.out.println("일요일에는 축구를 합니다.");
        } else {
            System.out.println("열심히 자바를 공부합니다.");
        }
    }
}
```

**실행 결과**

```
열심히 자바를 공부합니다.
```
