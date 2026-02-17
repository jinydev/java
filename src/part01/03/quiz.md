---
layout: part01
title: "확인문제"
nav_order: 99
parent: "Chapter 03. 연산자"
grand_parent: "객체지향 자바 프로그래밍"
---

# 확인문제

1. 다음 코드를 실행했을 때 출력 결과를 작성해 보세요.
   ```java
   int x = 10;
   int y = 20;
   int z = (++x) + (y--);
   System.out.println(z);
   ```

2. 다음 코드를 실행했을 때 출력 결과를 작성해 보세요.
   ```java
   int score = 85;
   String result = (!(score>90)) ? "가" : "나";
   System.out.println(result);
   ```

3. 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고, 마지막에 몇 개가 남는지를 구하는 코드입니다. ( )에 들어갈 알맞은 코드를 차례대로 작성해 보세요.
   ```java
   int pencils = 534;
   int students = 30;
   
   //학생 한 명이 가지는 연필 수
   int pencilsPerStudent = (   );
   System.out.println(pencilsPerStudent);
   
   //남은 연필 수
   int pencilsLeft = (   );
   System.out.println(pencilsLeft);
   ```

4. 다음은 십의 자리 이하를 버리는 코드입니다. 변수 value의 값이 356이라면 300이 나올 수 있도록 ( )에 알맞은 코드를 작성하세요(산술 연산자만 사용).
   ```java
   int value = 356;
   System.out.println(   );
   ```

5. 다음 코드는 사다리꼴의 넓이를 구하는 코드입니다. 정확히 소수 자릿수가 나올 수 있도록 ( )에 들어갈 수 있는 코드를 모두 선택하세요.
   ```java
   int lengthTop = 5;
   int lengthBottom = 10;
   int height = 7;
   double area = (   );
   System.out.println(area);
   ```
   1. `(lengthTop + lengthBottom) * height / 2.0`
   2. `(lengthTop + lengthBottom) * height * 1.0 / 2`
   3. `(double)(lengthTop + lengthBottom) * height / 2`
   4. `(double)((lengthTop + lengthBottom) * height / 2)`

6. 다음 코드는 비교 연산자와 논리 연산자의 복합 연산식입니다. 연산식의 출력 결과를 작성해 보세요.
   ```java
   int x = 10;
   int y = 5;
   System.out.println( (x>7) && (y<=5) );
   System.out.println( (x%3 == 2) || (y%2 != 1) );
   ```

7. 다음은 % 연산을 수행한 결과값에 10을 더하는 코드입니다. NaN 값을 검사해서 올바른 결과가 출력될 수 있도록 ( )에 들어갈 코드를 작성해 보세요.
   ```java
   double x = 5.0;
   double y = 0.0;
   double z = x % y;
   
   if(   ) {
       System.out.println("0.0으로 나눌 수 없습니다.");
   } else {
       double result = z + 10;
       System.out.println("결과: " + result);
   }
   ```
