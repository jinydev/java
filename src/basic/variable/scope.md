---
layout: basic
title: "2.11 변수 사용 범위"
nav_order: 11
parent: "Chapter 02. 변수와 타입"
grand_parent: "객체지향 자바 프로그래밍"
---

# 2.11 변수 사용 범위

`main()` 메소드 블록에는 다른 중괄호 `{}` 블록들이 작성될 수 있다. 조건문에 해당하는 `if`, 반복문에 해당하는 `for`, `while` 등이 중괄호 `{}` 블록을 가질 수 있는데, 이러한 중괄호 `{}` 블록 내에서 선언된 변수는 해당 중괄호 `{}` 블록 내에서만 사용이 가능하고 밖에서는 사용할 수 없다.

```java
public static void main(String[] args) {
    int var1; //메소드 블록에서 선언
    
    if(...) {
        int var2; //if 블록에서 선언
        //var1과 var2 사용 가능
    }
    
    for(...) {
        int var3; //for 블록에서 선언
        //var1과 var3 사용 가능
        //var2는 사용 못함
    }
    
    //var1 사용 가능
    //var2와 var3는 사용 못함
}
```

메소드 블록 전체에서 사용하고 싶다면 메소드 블록 첫머리에 선언하는 것이 좋고, 특정 블록 내부에서만 사용된다면 해당 블록 내에서 선언하는 것이 좋다.

**[예제: VariableScopeExample.java]**
```java
package ch02.sec11;

public class VariableScopeExample {
    public static void main(String[] args) {
        int v1 = 15;
        if(v1>10) {
            int v2 = v1 - 10;
        }
        int v3 = v1 + v2 + 5; //v2 변수를 사용할 수 없기 때문에 컴파일 에러 발생
    }
}
```
