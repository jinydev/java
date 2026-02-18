---
layout: basic
title: "4.3 switch 문"
nav_order: 3
parent: "Chapter 04. 조건문과 반복문"
grand_parent: "객체지향 자바 프로그래밍"
---

# 4.3 switch 문

`if` 문은 조건식의 결과가 `true`, `false` 두 가지밖에 없기 때문에 경우의 수가 많아질수록 `else if`를 반복적으로 추가해야 하므로 코드가 복잡해진다. 그러나 `switch` 문은 변수의 값에 따라서 실행문이 결정되기 때문에 같은 기능의 `if` 문보다 코드가 간결해진다.

`switch` 문은 괄호 안의 변수값에 따라 해당 `case`로 가서 실행문을 실행시킨다. 만약 변수값과 동일한 값을 갖는 `case`가 없으면 `default`로 가서 실행문을 실행시킨다. `default`가 필요 없다면 생략 가능하다.

```java
switch(변수) {
    case 값1:
        실행문;
        break;
    case 값2:
        실행문;
        break;
    default:
        실행문;
}
```

**[예제: SwitchExample.java]**
```java
package ch04.sec03;

public class SwitchExample {
    public static void main(String[] args) {
        int num = (int) (Math.random()*6) + 1;
        
        switch(num) {
            case 1:
                System.out.println("1번이 나왔습니다.");
                break;
            case 2:
                System.out.println("2번이 나왔습니다.");
                break;
            case 3:
                System.out.println("3번이 나왔습니다.");
                break;
            case 4:
                System.out.println("4번이 나왔습니다.");
                break;
            case 5:
                System.out.println("5번이 나왔습니다.");
                break;
            default:
                System.out.println("6번이 나왔습니다.");
        }
    }
}
```

**실행 결과**
```
2번이 나왔습니다.
```

`case` 끝에 있는 `break`는 다음 `case`를 실행하지 않고 `switch` 문을 빠져나가기 위해 필요하다. 만약 `break`가 없다면 다음 `case`가 연달아 실행되는데, 이때는 `case` 값과는 상관없이 실행된다.

**[예제: SwitchNoBreakCaseExample.java]**
```java
package ch04.sec03;

public class SwitchNoBreakCaseExample {
    public static void main(String[] args) {
        int time = (int) (Math.random()*4) + 8;
        System.out.println("[현재 시간: " + time + "시]");
        
        switch(time) {
            case 8:
                System.out.println("출근합니다.");
            case 9:
                System.out.println("회의를 합니다.");
            case 10:
                System.out.println("업무를 봅니다.");
            default:
                System.out.println("외근을 나갑니다.");
        }
    }
}
```

**실행 결과**
```
[현재 시간: 9시]
회의를 합니다.
업무를 봅니다.
외근을 나갑니다.
```

`switch` 문의 괄호에는 정수 타입(byte, char, short, int, long)과 문자열 타입(String) 변수를 사용할 수 있다. 다음은 `char` 타입 변수를 이용해서 영어 대소문자에 관계없이 똑같이 처리하는 예제이다.

**[예제: SwitchCharExample.java]**
```java
package ch04.sec03;

public class SwitchCharExample {
    public static void main(String[] args) {
        char grade = 'B';
        
        switch(grade) {
            case 'A':
            case 'a':
                System.out.println("우수 회원입니다.");
                break;
            case 'B':
            case 'b':
                System.out.println("일반 회원입니다.");
                break;
            default:
                System.out.println("손님입니다.");
        }
    }
}
```

**실행 결과**
```
일반 회원입니다.
```

Java 12 이후부터는 `switch` 문에서 Expressions(표현식)를 사용할 수 있다. `break` 문을 없애는 대신에 화살표와 중괄호를 사용해 가독성이 좋아졌다. 다음은 앞의 예제를 Switch Expressions로 다시 작성한 것이다.

**[예제: SwitchExpressionsExample.java]**
```java
package ch04.sec03;

public class SwitchExpressionsExample {
    public static void main(String[] args) {
        char grade = 'B';
        
        switch(grade) {
            case 'A', 'a' -> {
                System.out.println("우수 회원입니다.");
            }
            case 'B', 'b' -> {
                System.out.println("일반 회원입니다.");
            }
            default -> {
                System.out.println("손님입니다.");
            }
        }
        
        switch(grade) {
            case 'A', 'a' -> System.out.println("우수 회원입니다.");
            case 'B', 'b' -> System.out.println("일반 회원입니다.");
            default -> System.out.println("손님입니다.");
        }
    }
}
```

**실행 결과**
```
일반 회원입니다.
일반 회원입니다.
```

Switch Expressions을 사용하면 스위치된 값을 변수에 바로 대입할 수도 있다. 단일 값일 경우에는 화살표 오른쪽에 값을 기술하면 되고, 중괄호를 사용할 경우에는 `yield` (Java 13부터 사용 가능) 키워드로 값을 지정하면 된다. 단, 이 경우에는 `default`가 반드시 존재해야 한다.

```java
타입 변수 = switch(grade) {
    case "값1" -> 변수값;
    case "값2" -> {
        ...
        yield 변수값;
    }
    default -> 변수값;
};
```

다음은 `grade`에 따라 스위치된 점수를 `score` 변수에 대입하는 예제이다.

**[예제: SwitchValueExample.java]**
```java
package ch04.sec03;

public class SwitchValueExample {
    public static void main(String[] args) {
        String grade = "B";
        
        //Java 11 이전 문법
        int score1 = 0;
        switch(grade) {
            case "A":
                score1 = 100;
                break;
            case "B":
                int result = 100 - 20;
                score1 = result;
                break;
            default:
                score1 = 60;
        }
        System.out.println("score1: " + score1);
        
        //Java 13부터 가능
        int score2 = switch(grade) {
            case "A" -> 100;
            case "B" -> {
                int result = 100 - 20;
                yield result;
            }
            default -> 60;
        };
        System.out.println("score2: " + score2);
    }
}
```

**실행 결과**
```
score1: 80
score2: 80
```

> **NOTE:** 자바 21에서 switch 문의 표현식을 작성하는 방법이 강화되었다. 자세한 내용은 21장에서 설명하므로 20장까지 모두 학습한 후에 학습하길 권한다.
