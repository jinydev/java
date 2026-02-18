---
layout: part03
title: "확인문제"
nav_order: 99
parent: "Chapter 17. 데이터 입출력"
grand_parent: "라이브러리 활용"
---

# 확인문제

1.  스트림에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 스트림은 내부 반복자를 사용하기 때문에 코드가 간결해진다.
    *   ② 스트림은 요소를 분리해서 병렬 처리시킬 수 있다.
    *   ③ 스트림은 람다식을 사용해서 요소 처리 내용을 기술한다.
    *   ④ 스트림은 요소를 모두 처리하고 나서 처음부터 요소를 다시 반복시킬 수 있다.
    > **정답**: ④
    > **해설**: 스트림은 일회용이므로 한 번 사용하면 재사용할 수 없다.

2.  스트림을 얻을 수 있는 소스가 아닌 것은 무엇입니까?
    *   ① 컬렉션(List)
    *   ② int, long, double 범위
    *   ③ 디렉토리
    *   ④ 배열
    *   ⑤ Iterator
    > **정답**: ⑤
    > **해설**: Iterator로부터 바로 스트림을 얻는 메소드는 없다.

3.  스트림 파이프라인에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 스트림을 연결해서 중간 처리와 최종 처리를 할 수 있다.
    *   ② 중간 처리 단계에서는 필터링, 매핑, 정렬, 그룹핑을 한다.
    *   ③ 최종 처리 단계에서는 합계, 평균, 카운팅, 최대값, 최소값 등을 얻을 수 있다.
    *   ④ 최종 처리가 없더라도 중간 처리를 할 수 있다.
    > **정답**: ④
    > **해설**: 최종 처리가 호출되어야 비로소 중간 처리가 동작한다(Lazy Evaluation).

4.  스트림 병렬 처리에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 전체 요소를 분할해서 처리한다.
    *   ② 내부적으로 포크조인 프레임워크를 이용한다.
    *   ③ 병렬 처리는 순차적 처리보다 항상 빠른 처리를 한다.
    *   ④ 내부적으로 스레드풀을 이용해서 스레드를 관리한다.
    > **정답**: ③
    > **해설**: 요소 수가 적거나 처리 비용이 낮으면 오히려 느릴 수 있다.

5.  List에 저장되어 있는 String 요소에서 대소문자와 상관없이 "java"라는 단어가 포함된 문자열만 필터링해서 출력하려고 합니다. 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    List<String> list = Arrays.asList(
    	"This is a java book",
    	"Lambda Expressions",
    	"Java8 supports lambda expressions"
    );
    list.stream()
    	.filter(a -> a.toLowerCase().contains("java"))
    	.forEach(a -> System.out.println(a));
    ```

6.  List에 저장되어 있는 Member의 평균 나이를 출력하려고 합니다. 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    double avg = list.stream()
    	.mapToInt(Member::getAge)
    	.average()
    	.getAsDouble(); // 또는 orElse(0.0)
    ```

7.  List에 저장되어 있는 Member 중에서 직업이 "개발자"인 사람만 별도의 List에 수집하려고 합니다. 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    List<Member> developers = list.stream()
    	.filter(m -> m.getJob().equals("개발자"))
    	.collect(Collectors.toList());
    // 또는 .toList(); (Java 16+)
    ```

8.  List에 저장되어 있는 Member를 직업별로 그룹핑해서 Map<String, List<Member>> 객체로 생성하려고 합니다. 키는 Member의 직업이고, 값은 해당 직업을 갖는 Member들을 저장하고 있는 List입니다. 실행 결과를 보고 빈칸에 알맞은 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    Map<String, List<Member>> groupingMap = list.stream()
    	.collect(Collectors.groupingBy(Member::getJob));
    ```
