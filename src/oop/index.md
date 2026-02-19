---
layout: oop
title: "Part 02. 객체지향 프로그래밍"
permalink: /oop/
---

# Part 02. 객체지향 프로그래밍

## 객체지향 프로그래밍

이 파트에서는 객체지향 프로그래밍(OOP)의 핵심 원리를 깊이 있게 이해하고, 자바 언어를 통해 이를 효과적으로 구현하는 방법을 학습합니다.

클래스(Class), 상속(Inheritance), 인터페이스(Interface), 다형성(Polymorphism) 등 객체지향의 4대 핵심 요소를 마스터하며, 나아가 효율적인 라이브러리 및 모듈 설계 방법까지 다룹니다. 또한, 안정적인 소프트웨어 운영을 위한 필수 역량인 예외 처리(Exception Handling) 기법도 상세히 배울 수 있습니다.

이 과정을 마치면 단순한 코딩을 넘어, 복잡한 자바 애플리케이션의 아키텍처를 이해하고 분석할 수 있는 전문적인 시각을 갖추게 될 것입니다. 

## 학습 목표

*   객체지향 프로그래밍의 특징과 절차지향 프로그래밍과의 차이점을 이해한다.
*   클래스, 객체, 인스턴스의 개념을 이해하고 클래스를 설계하는 방법을 학습한다.
*   상속과 다형성을 통해 코드의 재사용성과 확장성을 높이는 방법을 익힌다.
*   인터페이스를 활용하여 유연하고 결합도가 낮은 코드를 작성하는 방법을 배운다.
*   자바의 참조 타입과 메모리 관리 메커니즘을 이해한다.
*   예외 처리를 통해 안정적인 프로그램을 작성하는 방법을 학습한다.
*   자바 표준 라이브러리와 모듈 시스템을 활용하여 효율적인 개발 방법을 익힌다.

###  05. 참조 타입
- [5.1 데이터 타입 분류](/oop/reference/classification)
- [5.2 메모리 사용 영역](/oop/reference/memory-area)
- [5.3 참조 타입 변수의 ==, != 연산](/oop/reference/equality)
- [5.4 null과 NullPointerException](/oop/reference/null)
- [5.5 문자열(String) 타입](/oop/reference/string)
- [5.6 배열(Array) 타입](/oop/reference/array)
- [5.7 다차원 배열](/oop/reference/multidimensional-array)
- [5.8 객체를 참조하는 배열](/oop/reference/object-array)
- [5.9 배열 복사](/oop/reference/array-copy)
- [5.10 배열 항목 반복을 위한 향상된 for 문](/oop/reference/enhanced-for)
- [5.11 main() 메소드의 String[] 매개변수 용도](/oop/reference/main-arguments)
- [5.12 열거(Enum) 타입](/oop/reference/enum)

###  06. 클래스
- [6.1 객체지향 프로그래밍](/oop/oop/oop)
- [6.2 객체와 클래스](/oop/oop/object-class)
- [6.3 클래스 선언](/oop/oop/class-declaration)
- [6.4 객체 생성과 클래스 변수](/oop/oop/instance-creation)
- [6.5 클래스의 구성 멤버](/oop/oop/class-members)
- [6.6 필드 선언과 사용](/oop/oop/field)
- [6.7 생성자 선언과 호출](/oop/oop/constructor)
- [6.8 메소드 선언과 호출](/oop/oop/method)
- [6.9 인스턴스 멤버](/oop/oop/instance-member)
- [6.10 정적 멤버](/oop/oop/static-member)
- [6.11 final 필드와 상수](/oop/oop/final-constant)
- [6.12 패키지](/oop/oop/package)
- [6.13 접근 제한자](/oop/oop/access-modifier)
- [6.14 Getter와 Setter](/oop/oop/getter-setter)
- [6.15 싱글톤 패턴](/oop/oop/singleton)

###  07. 상속
- [7.1 상속 개념](/oop/extends/inheritance)
- [7.2 클래스 상속](/oop/extends/class-inheritance)
- [7.3 부모 생성자 호출](/oop/extends/super-constructor)
- [7.4 메소드 재정의](/oop/extends/method-overriding)
- [7.5 final 클래스와 final 메소드](/oop/extends/final)
- [7.6 protected 접근 제한자](/oop/extends/protected)
- [7.7 타입 변환](/oop/extends/casting)
- [7.8 다형성](/oop/extends/polymorphism)
- [7.9 객체 타입 확인](/oop/extends/instanceof)
- [7.10 추상 클래스](/oop/extends/abstract-class)
- [7.11 봉인된 클래스](/oop/extends/sealed-class)

###  08. 인터페이스
- [8.1 인터페이스의 역할](/oop/interface/role)
- [8.2 인터페이스와 구현 클래스 선언](/oop/interface/declaration)
- [8.3 상수 필드](/oop/interface/constant-field)
- [8.4 추상 메소드](/oop/interface/abstract-method)
- [8.5 디폴트 메소드](/oop/interface/default-method)
- [8.6 정적 메소드](/oop/interface/static-method)
- [8.7 private 메소드](/oop/interface/private-method)
- [8.8 다중 인터페이스 구현](/oop/interface/multiple-implementation)
- [8.9 인터페이스 상속](/oop/interface/inheritance)
- [8.10 타입 변환](/oop/interface/casting)
- [8.11 다형성](/oop/interface/polymorphism)
- [8.12 객체 타입 확인](/oop/interface/instanceof)
- [8.13 봉인된 인터페이스](/oop/interface/sealed-interface)

###  09. 중첩 선언과 익명 객체
- [9.1 중첩 클래스](/oop/nested/nested-class)
- [9.2 인스턴스 멤버 클래스](/oop/nested/instance-member-class)
- [9.3 정적 멤버 클래스](/oop/nested/static-member-class)
- [9.4 로컬 클래스](/oop/nested/local-class)
- [9.5 바깥 멤버 접근](/oop/nested/access-outer)
- [9.6 중첩 인터페이스](/oop/nested/nested-interface)
- [9.7 익명 객체](/oop/nested/anonymous-object)

###  10. 라이브러리와 모듈
- [10.1 라이브러리](/oop/module/library)
- [10.2 모듈](/oop/module/module)
- [10.3 응용프로그램 모듈화](/oop/module/application-modularity)
- [10.4 모듈 배포용 JAR 파일](/oop/module/modular-jar)
- [10.5 패키지 은닉](/oop/module/package-hiding)
- [10.6 전이 의존](/oop/module/transitive-dependency)
- [10.7 집합 모듈](/oop/module/aggregator-module)
- [10.8 리플렉션 허용](/oop/module/reflection)
- [10.9 자바 표준 모듈](/oop/module/standard-modules)

###  11. 예외 처리
- [11.1 예외와 예외 클래스](/oop/exception/exception-class)
- [11.2 예외 처리 코드](/oop/exception/handling-code)
- [11.3 예외 종류에 따른 처리](/oop/exception/handling-by-type)
- [11.4 리소스 자동 닫기](/oop/exception/try-with-resources)
- [11.5 예외 떠넘기기](/oop/exception/throws)
- [11.6 사용자 정의 예외](/oop/exception/custom-exception)



###  13. 제네릭
- [13.1 제네릭이란?](/oop/generic/intro)
- [13.2 제네릭 타입](/oop/generic/type)
- [13.3 제네릭 메소드](/oop/generic/method)
- [13.4 제한된 타입 파라미터](/oop/generic/bounded-type)
- [13.5 와일드카드 타입 파라미터](/oop/generic/wildcard)



###  16. 람다식
- [16.1 람다식이란?](/oop/lambda/intro)
- [16.2 매개변수가 없는 람다식](/oop/lambda/no-parameter)
- [16.3 매개변수가 있는 람다식](/oop/lambda/parameter)
- [16.4 리턴값이 있는 람다식](/oop/lambda/return)
- [16.5 메소드 참조](/oop/lambda/method-reference)
- [16.6 생성자 참조](/oop/lambda/constructor-reference)

###  15. 컬렉션 자료구조
- [15.1 컬렉션 프레임워크](/oop/collection/framework)
- [15.2 List 컬렉션](/oop/collection/list)
- [15.3 Set 컬렉션](/oop/collection/set)
- [15.4 Map 컬렉션](/oop/collection/map)
- [15.5 검색 기능을 강화시킨 컬렉션](/oop/collection/search)
- [15.6 LIFO와 FIFO 컬렉션](/oop/collection/stack-queue)
- [15.7 동기화된 컬렉션](/oop/collection/synchronized)
- [15.8 수정할 수 없는 컬렉션](/oop/collection/unmodifiable)

###  12. java.base 모듈
- [12.1 API 도큐먼트](/oop/api/documentation)
- [12.2 java.base 모듈](/oop/api/java-base)
- [12.3 Object 클래스](/oop/api/object)
- [12.4 System 클래스](/oop/api/system)
- [12.5 문자열 클래스](/oop/api/string)
- [12.6 포장 클래스](/oop/api/wrapper)
- [12.7 수학 클래스](/oop/api/math)
- [12.8 날짜와 시간 클래스](/oop/api/date-time)
- [12.9 형식 클래스](/oop/api/format)
- [12.10 정규 표현식 클래스](/oop/api/regex)
- [12.11 리플렉션](/oop/api/reflection)
- [12.12 어노테이션](/oop/api/annotation)
