---
layout: oop
title: "6.12 패키지"
nav_order: 12
parent: "Chapter 06. 클래스"
grand_parent: "객체지향 자바 프로그래밍"
---

# 6.12 패키지

우리는 지금까지 장별, 절별 예제 클래스를 패키지 안에 생성해서 관리했다. 자바의 패키지(package)는 단순히 디렉토리만을 의미하지는 않는다. 패키지는 클래스의 일부분이며, 클래스를 식별하는 용도로 사용된다.

패키지는 주로 개발 회사 도메인 이름의 역순으로 만든다. 예를 들어 mycompany.com 회사의 패키지는 com.mycompany로, yourcompany.com 회사의 패키지는 com.yourcompany로 만든다. 이렇게 하면 두 회사에서 개발한 Car 클래스가 있을 경우 다음과 같이 관리할 수 있다.

```
com
  mycompany
    Car.class
  yourcompany
    Car.class
```

패키지는 상위 패키지와 하위 패키지를 도트(.)로 구분한다. 도트는 물리적으로 하위 디렉토리임을 뜻한다. 예를 들어 com.mycompany 패키지의 com은 상위 디렉토리, mycompany는 하위 디렉토리이다.

패키지는 클래스를 식별하는 용도로 사용되기 때문에 클래스의 전체 이름에 포함된다. 예를 들어 Car 클래스가 com.mycompany 패키지에 속해 있다면 Car 클래스의 전체 이름은 com.mycompany.Car가 된다. 이것은 com.yourcompany.Car와 다른 클래스임을 뜻한다.

패키지에 속한 바이트코드 파일(*.class)은 따로 떼어 내어 다른 디렉토리로 이동할 수 없다. 예를 들어 Car 클래스가 com.mycompany 패키지에 소속되어 있다면 다른 디렉토리에 Car.class를 옮겨 저장할 경우 Car 클래스를 사용할 수 없게 된다.

```
com
  mycompany
    Car.class

com
  yourcompany
    Car.class
```

## 패키지 선언

패키지 디렉토리는 클래스를 컴파일하는 과정에서 자동으로 생성된다. 컴파일러는 클래스의 패키지 선언을 보고 디렉토리를 자동 생성시킨다. 패키지 선언은 package 키워드와 함께 패키지 이름을 기술한 것으로, 항상 소스 파일 최상단에 위치해야 한다.

```java
package 상위패키지.하위패키지;
public class 클래스명 { ... }
```

패키지 이름은 모두 소문자로 작성하는 것이 관례이다. 그리고 패키지 이름이 서로 중복되지 않도록 회사 도메인 이름의 역순으로 작성하고, 마지막에는 프로젝트 이름을 붙여 주는 것이 일반적이다.

```
com.samsung.projectname
com.lg.projectname
org.apache.projectname
```

이클립스에서는 패키지를 먼저 생성하고 클래스를 나중에 추가하는 방식을 사용한다. 지금까지 우리는 장별, 절별 패키지를 먼저 만들고, 클래스를 나중에 추가했다. 추가된 클래스를 보면 자동으로 패키지 선언이 포함되어 있는 것을 볼 수 있다.

소스 파일(*.java)이 저장되면 이클립스는 자동으로 컴파일해서 bin 디렉토리에 패키지 디렉토리와 함께 바이트코드 파일(*.class)을 생성한다.

만약 패키지 선언이 없다면 이클립스는 클래스를 (default package)에 포함시킨다. (default package)란 패키지가 없다는 뜻이다. 그러나 어떤 프로젝트든 패키지 없이 클래스를 만드는 경우는 드물다.

**Car.java**
```java
// (default package)
public class Car {
}
```

## import 문

같은 패키지에 있는 클래스는 아무런 조건 없이 사용할 수 있지만, 다른 패키지에 있는 클래스를 사용하려면 import 문을 이용해서 어떤 패키지의 클래스를 사용하는지 명시해야 한다.

다음은 com.mycompany 패키지의 Car 클래스에서 com.hankook 패키지의 Tire 클래스를 사용하기 위해 import 문을 사용한 것이다.

```java
package com.mycompany; // Car 클래스의 패키지
import com.hankook.Tire; // Tire 클래스의 전체 이름

public class Car {
    // 필드 선언 시 com.hankook.Tire 클래스를 사용
    Tire tire = new Tire();
}
```

import 문이 작성되는 위치는 패키지 선언과 클래스 선언 사이이다. import 키워드 뒤에는 사용하고자 하는 클래스의 전체 이름을 기술한다. 만약 동일한 패키지에 포함된 다수의 클래스를 사용해야 한다면 클래스 이름을 생략하고 *를 사용할 수 있다.

```java
import com.hankook.*;
```

import 문은 하위 패키지를 포함하지 않는다. 따라서 com.hankook 패키지에 있는 클래스도 사용해야 하고, com.hankook.project 패키지에 있는 클래스도 사용해야 한다면 다음과 같이 두 개의 import 문이 필요하다.

```java
import com.hankook.*;
import com.hankook.project.*;
```

만약 서로 다른 패키지에 동일한 클래스 이름이 존재한다고 가정해 보자.

```java
package com.hankook;
public class Tire { ... }

package com.kumho;
public class Tire { ... }
```

두 패키지를 모두 import하고 Tire 클래스를 사용할 경우, 컴파일러는 어떤 패키지의 클래스를 사용할지 결정할 수 없기 때문에 컴파일 에러를 발생시킨다.

```java
package com.hyundai;
import com.hankook.*;
import com.kumho.*;

public class Car {
    // 필드 선언
    Tire tire = new Tire(); // 컴파일 에러
}
```

이 경우에는 클래스의 전체 이름을 사용해서 정확히 어떤 패키지의 클래스를 사용하는지 알려야 한다. 클래스 전체 이름을 사용할 경우 import 문은 필요 없다.

```java
com.hankook.Tire tire = new com.hankook.Tire();
```

> **import 문 자동 추가 기능**
> 이클립스는 소스에서 사용한 클래스를 조사해서 필요하면 import 문을 자동으로 추가하는 기능을 제공한다.
> 1. 기본적으로 'import 전체클래스이름'으로 추가하려면 다음과 같이 선택한다.
>    상단 메뉴 [Source] - [Organize Imports] (단축키 [Ctrl]+[Shift]+[O])
> 2. 'import 패키지.*'로 추가하길 원한다면 다음과 같이 이클립스 설정을 변경한다.
>    상단 메뉴 [Window] - [Preferences] - [Java] - [Code Style] - [Organize Imports]
>    - Number of imports needed for .*의 99를 1로 변경

**SnowTire.java**
```java
package ch06.sec12.hankook;

public class SnowTire {
}
```

**Tire.java (hankook)**
```java
package ch06.sec12.hankook;

public class Tire {
}
```

**AllSeasonTire.java**
```java
package ch06.sec12.kumho;

public class AllSeasonTire {
}
```

**Tire.java (kumho)**
```java
package ch06.sec12.kumho;

public class Tire {
}
```

**Car.java**
```java
package ch06.sec12.hyundai;

// import 문으로 다른 패키지 클래스 사용을 명시
import ch06.sec12.hankook.SnowTire;
import ch06.sec12.kumho.AllSeasonTire;

public class Car {
	// 부품 필드 선언
	ch06.sec12.hankook.Tire tire1 = new ch06.sec12.hankook.Tire();
	ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
	SnowTire tire3 = new SnowTire();
	AllSeasonTire tire4 = new AllSeasonTire();
}
```
