---
layout: part01
title: "Chapter 04. 조건문과 반복문"
permalink: /part01/04/
---

# Chapter 04

## 조건문과 반복문

**목차**

* 4.1 코드 실행 흐름 제어
* 4.2 if 문
* 4.3 switch 문
* 4.4 for 문
* 4.5 while 문
* 4.6 do-while 문
* 4.7 break 문
* 4.8 continue 문

### 4.1 코드 실행 흐름 제어

자바 프로그램은 `main()` 메소드의 시작 중괄호 `{`에서 끝 중괄호 `}`까지 위에서부터 아래로 실행하는 흐름을 가지고 있다. 이러한 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있도록 해주는 것이 흐름 제어문(이하 제어문)이다.

제어문은 조건식과 중괄호 `{ }` 블록으로 구성되는데, 조건식의 연산 결과에 따라 블록 내부의 실행 여부가 결정된다. 제어문의 종류는 다음과 같다.

* **조건문**: `if` 문, `switch` 문
* **반복문**: `for` 문, `while` 문, `do-while` 문

제어문 블록이 실행 완료된 후 다시 제어문의 처음으로 돌아갈지, 아니면 제어문 블록을 빠져나와 정상 흐름으로 다시 돌아올지는 어떤 제어문을 사용하느냐에 달려 있다. 조건문일 경우는 정상 흐름으로 돌아오지만, 반복문일 경우는 제어문의 처음으로 다시 되돌아가 반복 실행한다. 이것을 루핑(looping)이라고 한다.

제어문 블록 내부에는 또 다른 제어문을 사용할 수 있다. `if` 문 내부에 `for` 문이나 `while` 문도 가질 수 있기 때문에 개발자가 원하는 매우 복잡한 흐름 제어도 가능하다.

### 4.2 if 문

`if` 문은 조건식의 결과에 따라 블록 실행 여부가 결정된다.

```java
if (조건식) {
    실행문;
    실행문;
}
```

조건식에는 `true` 또는 `false` 값을 산출할 수 있는 연산식이나 `boolean` 변수가 올 수 있다. 조건식이 `true`이면 블록을 실행하고 `false`이면 블록을 실행하지 않는다. 중괄호 `{ }` 블록 내에 실행문이 하나밖에 없다면 중괄호를 생략할 수 있다.

```java
if (조건식)
    실행문;
```

하지만 중괄호 `{ }` 블록을 생략하지 않고 작성하는 것을 추천한다. 중괄호 블록을 작성하지 않으면 코드의 가독성(코드 해석)이 좋지 않고, 버그 발생의 원인이 될 수 있다.

**[예제: IfExample.java]**
```java
package ch04.sec02;

public class IfExample {
    public static void main(String[] args) {
        int score = 93;
        
        if(score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        }
        
        if(score < 90) 
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다."); //if문과는 상관없는 실행문
    }
}
```

**실행 결과**
```
점수가 90보다 큽니다.
등급은 A입니다.
등급은 B입니다.
```

`score` 변수의 값이 93이므로 7라인의 `if` 조건식은 `true`가 되어 중괄호 블록 8~9라인이 실행된다. 그러나 12라인의 `if` 조건식은 `false`가 되어 13라인은 실행하지 않는 것이 의도였는데, 14라인은 무조건 실행된다. 12라인의 `if` 문에 중괄호 블록이 없기 때문에 13라인까지만 영향을 미치기 때문이다.

`if` 문은 `else` 블록과 함께 사용되어 조건식의 결과에 따라 실행 블록을 선택할 수 있다. `if` 문의 조건식이 `true`이면 `if` 문 블록이 실행되고, `false`이면 `else` 블록이 실행된다.

```java
if (조건식) {
    //조건식이 true
} else {
    //조건식이 false
}
```

이전 예제는 두 개의 `if` 문을 이용하였는데, 이것보다는 다음과 같이 `if-else` 문으로 간단히 처리하는 것이 더욱 간결한 코딩이 된다.

**[예제: IfElseExample.java]**
```java
package ch04.sec02;

public class IfElseExample {
    public static void main(String[] args) {
        int score = 85;
        
        if(score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        } else {
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다.");
        }
    }
}
```

**실행 결과**
```
점수가 90보다 작습니다.
등급은 B입니다.
```

조건문이 여러 개인 `if` 문도 있다. `else if`는 상위 조건식이 `false`일 경우 평가되고, `else if`가 `true`이면 해당 블록이 실행된다. `else if`의 수는 제한이 없으며, 여러 개의 조건식 중 `true`가 되는 `else if` 블록만 실행하고 전체 `if` 문을 벗어나게 된다.

```java
if (조건식1) {
    //조건식1이 true
} else if (조건식2) {
    //조건식2가 true
} else {
    //조건식1 및 조건식2가 false
}
```

마지막에는 `else` 블록을 추가할 수 있는데, 모든 조건식이 `false`일 경우 `else` 블록을 실행하고 `if` 문을 벗어나게 된다.

이전 예제는 점수가 90점 이상이거나 미만일 경우에만 실행 흐름을 제어했는데, 이번 예제는 조건식 3개를 이용해서 실행 흐름을 제어한다.

**[예제: IfElseIfElseExample.java]**
```java
package ch04.sec02;

public class IfElseIfElseExample {
    public static void main(String[] args) {
        int score = 75;
        
        if(score >= 90) {
            System.out.println("점수가 100-90입니다.");
            System.out.println("등급은 A입니다.");
        } else if(score >= 80) {
            System.out.println("점수가 80-89입니다.");
            System.out.println("등급은 B입니다.");
        } else if(score >= 70) {
            System.out.println("점수가 70-79입니다.");
            System.out.println("등급은 C입니다.");
        } else {
            System.out.println("점수가 70 미만입니다.");
            System.out.println("등급은 D입니다.");
        }
    }
}
```

**실행 결과**
```
점수가 70-79입니다.
등급은 C입니다.
```

주사위를 굴려서 나올 수 있는 1, 2, 3, 4, 5, 6 중에서 하나의 수를 뽑아서 출력하는 코드를 작성해 보자. 먼저 임의의 정수를 뽑기 위해 `Math.random()` 메소드를 활용할 수 있다. 이 메소드는 `0.0 <= ~ < 1.0` 사이의 `double` 타입 난수를 리턴한다.

```java
0.0 <= Math.random() < 1.0
```

여기에서 각 변에 6을 곱하면 `0.0 <= ~ < 6.0` 사이의 `double` 타입 난수를 얻게 된다.

```java
(0.0 * 6) <= (Math.random() * 6) < (1.0 * 6)
0.0 <= ... < 6.0
```

그리고 각 변을 `int` 타입으로 강제 타입 변환하면 0, 1, 2, 3, 4, 5 중에서 하나의 정수 난수를 얻게 된다.

```java
(int) 0.0 <= (int) (Math.random() * 6) < (int) 6.0
0 <= ... < 6
```

마지막으로 각 변에 1을 더하면 비로소 1, 2, 3, 4, 5, 6 중에서 하나의 정수 난수를 얻게 된다.

```java
(0 + 1) <= ((int) (Math.random() * 6) + 1) < (6 + 1)
1 <= ... < 7
```

그렇다면 start부터 시작하는 n개의 정수 중에서 하나의 정수를 얻기 위한 코드는 다음과 같이 작성할 수 있다.

```java
int num = (int) (Math.random() * n) + start;
```

로또 번호(1, ..., 45) 중 하나를 뽑기 위해서도 다음 코드를 사용할 수 있다.

```java
int num = (int) (Math.random() * 45) + 1;
```

**[예제: IfDiceExample.java]**
```java
package ch04.sec02;

public class IfDiceExample {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 6) + 1;
        
        if(num==1) {
            System.out.println("1번이 나왔습니다.");
        } else if(num==2) {
            System.out.println("2번이 나왔습니다.");
        } else if(num==3) {
            System.out.println("3번이 나왔습니다.");
        } else if(num==4) {
            System.out.println("4번이 나왔습니다.");
        } else if(num==5) {
            System.out.println("5번이 나왔습니다.");
        } else {
            System.out.println("6번이 나왔습니다.");
        }
    }
}
```

**실행 결과**
```
2번이 나왔습니다.
```

`if` 문의 블록 내부에는 또 다른 `if` 문을 사용할 수 있다. 이것을 중첩 `if` 문이라 부르는데, 중첩의 단계는 제한이 없다.

한 번 중첩되었을 뿐인데, 매우 복잡한 실행 흐름이 생긴다. 실제 프로그램에서는 여러 단계로 중첩되는 경우가 많기 때문에 코드의 실행 흐름을 이해하지 못한다면 프로그램 작성은 물론, 이미 작성된 프로그램도 분석이 어려워진다.

이번 예제는 81<= ... <=100 중에서 하나의 점수를 뽑아 바깥 `if` 문은 90점과 80점을 기준으로 조건식을 작성하고, 중첩 `if` 문은 좀 더 세부적으로 95점과 85점을 기준으로 조건식을 작성해서 A+, A, B+, B를 출력한다.

**[예제: IfNestedExample.java]**
```java
package ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int) (Math.random()*20) + 81;
        System.out.println("점수: " + score);
        
        String grade;
        
        if(score >= 90) {
            if(score >= 95) {
                grade = "A+";
            } else {
                grade = "A";
            }
        } else {
            if(score >= 85) {
                grade = "B+";
            } else {
                grade = "B";
            }
        }
        
        System.out.println("학점: " + grade);
    }
}
```

**실행 결과**
```
점수: 93
학점: A
```

### 4.3 switch 문

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

### 4.4 for 문

프로그램을 작성하다 보면 똑같은 실행문을 반복적으로 실행해야 할 경우가 많이 발생한다. 예를 들어 1부터 100까지의 합을 구하는 코드를 작성한다면 코드 양이 엄청 늘어날 것이다. 이런 경우 `for` 문을 사용하면 코드를 획기적으로 줄일 수 있다.

`for` 문은 실행문을 여러 번 반복 실행해주기 때문에 코드를 간결하게 만들어 준다.

```java
for( ①초기화식; ②조건식; ④증감식 ) {
    ③실행문;
}
```

`for` 문이 처음 실행될 때 ①초기화식이 제일 먼저 실행된다. 그런 다음 ②조건식을 평가해서 `true`이면 ③실행문을 실행시키고, `false`이면 `for` 문을 종료하고 블록을 건너뛴다. ②조건식이 `true`가 되어 ③실행문을 모두 실행하면 ④증감식이 실행된다. 그리고 다시 ②조건식을 평가하게 된다. 평가 결과가 다시 `true`이면 ③ -> ④ -> ②로 다시 진행하고, `false`이면 `for` 문이 끝나게 된다.

다음은 가장 기본적인 `for` 문의 형태로 1부터 10까지 출력하는 코드이다.

**[예제: PrintFrom1To10Example.java]**
```java
package ch04.sec04;

public class PrintFrom1To10Example {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++) {
            System.out.print(i + " ");
        }
    }
}
```

**실행 결과**
```
1 2 3 4 5 6 7 8 9 10 
```

초기화식은 조건식과 실행문, 증감식에서 사용할 변수를 초기화하는 역할을 한다. 어떤 경우에는 초기화식이 둘 이상 있을 수도 있고, 증감식도 둘 이상 있을 수 있다. 이런 경우에는 다음과 같이 쉼표(`,`)로 구분해서 작성한다.

```java
for (int i=0, j=100; i<=50 && j>=50; i++, j--) { ... }
```

초기화식에서 선언된 변수는 `for` 문 블록 안에서만 사용되는 로컬 변수다. `for` 문을 벗어나서도 사용하고 싶다면 초기화식에서 변수를 선언하지 말고 `for` 문 이전에 선언해야 한다.

다음 예제는 1부터 100까지의 합을 구하는 코드이다. 변수 `sum`과 `i`를 `for` 문이 시작하기 전에 선언한 이유는 `for` 문을 끝내고 `sum`과 `i`를 사용하기 때문이다.

**[예제: SumFrom1To100Example.java]**
```java
package ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;
        int i;
        
        for(i=1; i<=100; i++) {
            sum += i;
        }
        
        System.out.println("1~" + (i-1) + " 합 : " + sum);
    }
}
```

**실행 결과**
```
1~100 합 : 5050
```

`for` 문을 작성할 때 주의할 점은 초기화식에서 부동 소수점을 쓰는 `float` 타입을 사용하지 말아야 한다는 것이다. 다음 예를 보자. 이론적으로 `for` 문은 10번 반복해야 한다.

**[예제: FloatCounterExample.java]**
```java
package ch04.sec04;

public class FloatCounterExample {
    public static void main(String[] args) {
        for(float x=0.1f; x<=1.0f; x+=0.1f) {
            System.out.println(x);
        }
    }
}
```

**실행 결과**
```
0.1
0.2
0.3
0.4
0.5
0.6
0.70000005
0.8000001
0.9000001
```

부동 소수점 방식의 `float` 타입은 연산 과정에서 정확히 0.1을 표현하지 못하기 때문에 증감식에서 `x`에 더해지는 실제 값은 0.1보다 약간 클 수 있다. 따라서 최종 반복 횟수는 9번이 된다.

`for` 문은 또 다른 `for` 문을 내포할 수 있는데, 이것을 중첩된 `for` 문이라고 한다. 이 경우 바깥 `for` 문이 한 번 실행될 때마다 중첩된 `for` 문은 지정 횟수만큼 반복하고 다시 바깥 `for` 문으로 돌아간다. 중첩 `for` 문이 필요한 가장 간단한 예제는 구구단을 출력하는 코드이다.

**[예제: MultiplicationTableExample.java]**
```java
package ch04.sec04;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for (int m=2; m<=9; m++) {
            System.out.println("*** " + m + "단 ***");
            for (int n=1; n<=9; n++) {
                System.out.println(m + " x " + n + " = " + (m*n));
            }
        }
    }
}
```

**실행 결과**
```
*** 2단 ***
2 x 1 = 2
2 x 2 = 4
...
*** 9단 ***
9 x 8 = 72
9 x 9 = 81
```

### 4.5 while 문

`for` 문을 정해진 횟수만큼 반복한다면, `while` 문은 조건식이 `true`일 경우에 계속해서 반복하고, `false`가 되면 반복을 멈추고 `while` 문을 종료한다.

```java
while ( ①조건식 ) {
    ②실행문;
}
```

`while` 문이 처음 실행될 때 ①조건식을 평가한다. 평가 결과가 `true`이면 ②실행문을 실행한다. ②실행문이 모두 실행되면 조건식으로 되돌아가서 ①조건식을 다시 평가한다. 다시 조건식이 `true`라면 ② -> ①로 진행하고, `false`라면 `while` 문을 종료한다.

다음 예제는 `while` 문으로 1부터 10까지 출력한다.

**[예제: PrintFrom1To10Example.java]**
```java
package ch04.sec05;

public class PrintFrom1To10Example {
    public static void main(String[] args) {
        int i = 1;
        while (i<=10) {
            System.out.print(i + " ");
            i++;
        }
    }
}
```

**실행 결과**
```
1 2 3 4 5 6 7 8 9 10 
```

다음 예제는 1부터 100까지 합을 구하기 위해 `while` 문을 사용한다. `while` 문 내에서 계속 누적되는 값을 갖는 `sum` 변수는 `while` 문 시작 전에 미리 선언해 놓아야 한다.

**[예제: SumFrom1To100Example.java]**
```java
package ch04.sec05;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        
        while(i<=100) {
            sum += i;
            i++;
        }
        
        System.out.println("1~" + (i-1) + " 합 : " + sum);
    }
}
```

**실행 결과**
```
1~100 합 : 5050
```

만약 조건식에 `true`를 사용하면 `while(true) {...}` 되어서 무한 반복하게 된다. 이 경우, 언젠가는 `while` 문을 빠져나가기 위한 코드가 필요하다. 다음은 키보드에서 1, 2를 입력했을 때 속도를 증속, 감속시키고, 3을 입력하면 프로그램을 종료시키는 예제이다.

**[예제: KeyControlExample.java]**
```java
package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int speed = 0;
        
        while(run) {
            System.out.println("-----------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("-----------------------------");
            System.out.print("선택: ");
            
            String strNum = scanner.nextLine();
            
            if(strNum.equals("1")) {
                speed++;
                System.out.println("현재 속도 = " + speed);
            } else if(strNum.equals("2")) {
                speed--;
                System.out.println("현재 속도 = " + speed);
            } else if(strNum.equals("3")) {
                run = false;
            }
        }
        
        System.out.println("프로그램 종료");
    }
}
```

**실행 결과**
```
-----------------------------
1. 증속 | 2. 감속 | 3. 중지
-----------------------------
선택: 1
현재 속도 = 1
-----------------------------
1. 증속 | 2. 감속 | 3. 중지
-----------------------------
선택: 2
현재 속도 = 0
-----------------------------
1. 증속 | 2. 감속 | 3. 중지
-----------------------------
선택: 3
프로그램 종료
```

* 11라인의 `while` 조건식을 보면 `run` 변수의 값에 따라 `while` 문의 반복 여부가 결정된다.
* 처음 `run` 변수의 값은 `true`이므로 `while` 문은 무한 반복된다.
* 키보드로 `3`을 입력하면 `run` 변수의 값이 `false`가 되어 `while` 문의 조건식이 `false`가 된다. 이때 무한 반복을 종료하고 `while` 문을 빠져나간다.
* `while` 문을 빠져나가는 또 다른 방법으로 `break` 문을 이용할 수도 있다. `break` 문은 4.7절에서 다시 설명하도록 하겠다.

### 4.6 do-while 문

`do-while` 문은 조건식에 의해 반복 실행한다는 점에서는 `while` 문과 동일하다. `while` 문은 시작할 때부터 조건식을 평가하여 블록 내부를 실행할지 결정하지만, 경우에 따라서는 블록 내부를 먼저 실행시키고, 실행 결과에 따라서 반복 실행을 계속할지 결정하는 경우도 있다. 이때 `do-while` 문을 사용한다.

```java
do {
    ①실행문;
} while ( ②조건식 );
```

작성 시 주의할 점은 `while()` 뒤에 반드시 세미콜론(`;`)을 붙여야 한다. `do-while` 문이 처음 실행될 때 ①실행문을 우선 실행한다. ①실행문이 모두 실행되면 ②조건식을 평가하는데, 그 결과가 `true`이면 ① -> ②와 같이 반복 실행을 하고, 조건식의 결과가 `false`이면 `do-while` 문을 종료한다.

다음 예제는 키보드로 입력받은 내용을 조사하여 계속 반복할 것인지를 판단한다. 조건식은 키보드로 입력받은 이후에 평가되어야 하므로 우선 키보드로부터 입력된 내용을 받아야 한다.

**[예제: DoWhileExample.java]**
```java
package ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        System.out.println("메시지를 입력하세요.");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");
        
        Scanner scanner = new Scanner(System.in);
        String inputString;
        
        do {
            System.out.print(">");
            inputString = scanner.nextLine();
            System.out.println(inputString);
        } while( ! inputString.equals("q") );
        
        System.out.println();
        System.out.println("프로그램 종료");
    }
}
```

**실행 결과**
```
메시지를 입력하세요.
프로그램을 종료하려면 q를 입력하세요.
>안녕하세요.
안녕하세요.
>반갑습니다.
반갑습니다.
>q
q

프로그램 종료
```

### 4.7 break 문

`break` 문은 반복문인 `for` 문, `while` 문, `do-while` 문을 실행 중지하거나 조건문인 `switch` 문을 종료할 때 사용한다.

`break` 문은 대개 `if` 문과 같이 사용되어 조건식에 따라 `for` 문과 `while` 문을 종료한다. 다음 예제는 `while` 문을 이용해서 주사위 번호 중 하나를 반복적으로 뽑되, 6이 나오면 `while` 문을 종료시킨다.

**[예제: BreakExample.java]**
```java
package ch04.sec07;

public class BreakExample {
    public static void main(String[] args) {
        while(true) {
            int num = (int) (Math.random()*6) + 1;
            System.out.println(num);
            if(num == 6) {
                break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
```

**실행 결과**
```
4
2
6
프로그램 종료
```

만약 반복문이 중첩되어 있을 경우 `break` 문은 가장 가까운 반복문만 종료하고 바깥쪽 반복문은 종료시키지 않는다. 중첩된 반복문에서 바깥쪽 반복문까지 종료시키려면 바깥쪽 반복문에 이름(레이블)을 붙이고, `break 이름;`을 사용하면 된다.

```java
Label: for (...) {
    for (...) {
        break Label;
    }
}
```

다음 예제를 보면 바깥쪽 `for` 문은 'A'~'Z'까지 반복하고, 중첩된 `for` 문은 'a'~'z'까지 반복한다. 중첩된 `for` 문에서 `lower` 변수가 'g'를 갖게 되면 바깥쪽 `for` 문까지 빠져나오도록 바깥쪽 `for` 문에 `Outter`라는 라벨을 붙였다.

**[예제: BreakOutterExample.java]**
```java
package ch04.sec07;

public class BreakOutterExample {
    public static void main(String[] args) {
        Outter: for(char upper='A'; upper<='Z'; upper++) {
            for(char lower='a'; lower<='z'; lower++) {
                System.out.println(upper + "-" + lower);
                if(lower=='g') {
                    break Outter;
                }
            }
        }
        System.out.println("프로그램 실행 종료");
    }
}
```

**실행 결과**
```
A-a
A-b
A-c
A-d
A-e
A-f
A-g
프로그램 실행 종료
```

### 4.8 continue 문

`continue` 문은 반복문인 `for` 문, `while` 문, `do-while` 문에서만 사용되는데, 블록 내부에서 `continue` 문이 실행되면 `for` 문의 증감식 또는 `while` 문, `do-while` 문의 조건식으로 바로 이동한다.

`continue` 문은 반복문을 종료하지 않고 계속 반복을 수행한다는 점이 `break` 문과 다르다. `break` 문과 마찬가지로 `continue` 문도 대개 `if` 문과 같이 사용되는데, 특정 조건을 만족하는 경우에 `continue` 문을 실행해서 그 이후의 문장을 실행하지 않고 다음 반복으로 넘어간다.

다음 예제는 1에서 10 사이의 수 중에서 짝수만 출력하고 홀수인 경우에는 다음 반복으로 넘어간다.

**[예제: ContinueExample.java]**
```java
package ch04.sec08;

public class ContinueExample {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++) {
            if(i%2 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
```

**실행 결과**
```
2 4 6 8 10 
```

### 확인문제

1. 조건문과 반복문에 대해 잘못 설명한 것은 무엇입니까?
   1. `if` 문은 조건식의 결과에 따라 실행 흐름을 달리할 수 있다.
   2. `switch` 문에서 사용할 수 있는 변수의 타입은 `int`, `double`이 될 수 있다.
   3. `for` 문은 카운터 변수로 지정한 횟수만큼 반복시킬 때 사용할 수 있다.
   4. `break` 문은 `switch` 문, `for` 문, `while` 문을 종료할 때 사용할 수 있다.

2. 왼쪽 `switch` 문을 Expression (표현식)으로 변경해서 오른쪽에 작성해 보세요.
   ```java
   String grade = "B";
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
   ```

3. `for` 문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 출력하는 코드를 작성해 보세요.

4. `while` 문과 `Math.random()` 메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈을 `(눈1, 눈2)` 형태로 출력하고, 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성해 보세요. 눈의 합이 5가 되는 경우는 (1, 4), (4, 1), (2, 3), (3, 2)입니다.

5. 중첩 `for` 문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력하는 코드를 작성해 보세요. 단, x와 y는 10 이하의 자연수입니다.

6. `for` 문을 이용해서 다음과 같은 실행 결과가 나오는 코드를 작성해 보세요.
   ```
   *
   **
   ***
   ****
   *****
   ```

7. `while` 문과 `Scanner`의 `nextLine()` 메소드를 이용해서 다음 실행 결과와 같이 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성해 보세요.
   ```
   ---------------------------------
   1.예금 | 2.출금 | 3.잔고 | 4.종료
   ---------------------------------
   선택> 1
   예금액> 10000
   
   ---------------------------------
   1.예금 | 2.출금 | 3.잔고 | 4.종료
   ---------------------------------
   선택> 2
   출금액> 2000
   
   ---------------------------------
   1.예금 | 2.출금 | 3.잔고 | 4.종료
   ---------------------------------
   선택> 3
   잔고> 8000
   
   ---------------------------------
   1.예금 | 2.출금 | 3.잔고 | 4.종료
   ---------------------------------
   선택> 4
   
   프로그램 종료
   ```
