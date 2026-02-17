---
layout: part03
title: "확인문제"
nav_order: 99
parent: "Chapter 15. 컬렉션 자료구조"
grand_parent: "라이브러리 활용"
---

# 확인문제

1.  자바의 컬렉션 프레임워크에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① List 컬렉션은 인덱스로 객체를 관리하며 중복 저장을 허용한다.
    *   ② Set 컬렉션은 순서를 유지하지 않으며 중복 저장을 허용하지 않는다.
    *   ③ Map 컬렉션은 키와 값으로 구성된 Map.Entry를 저장한다.
    *   ④ Stack은 FIFO (선입선출) 자료구조를 구현한 클래스이다.
    > **정답**: ④
    > **해설**: Stack은 LIFO(후입선출) 자료구조이다.

2.  List 컬렉션에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 대표적인 구현 클래스로는 ArrayList, Vector, LinkedList가 있다.
    *   ② 멀티 스레드 환경에서는 ArrayList보다는 Vector가 스레드에 안전하다.
    *   ③ ArrayList에서 객체를 삭제하면 삭제된 위치는 비어 있게 된다.
    *   ④ 중간 위치에 객체를 빈번히 삽입하거나 제거할 경우 LinkedList를 사용하는 것이 좋다.
    > **정답**: ③
    > **해설**: ArrayList에서 객체를 삭제하면 뒤의 객체들이 한 칸씩 앞으로 당겨져 위치를 채운다.

3.  Set 컬렉션에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 대표적인 구현 클래스로는 HashSet, LinkedHashSet, TreeSet이 있다.
    *   ② Set 컬렉션에서 객체를 하나씩 꺼내오고 싶다면 Iterator를 이용한다.
    *   ③ HashSet은 hashCode()와 equals() 메소드를 이용해서 중복된 객체를 판별한다.
    *   ④ Set 컬렉션에는 null을 저장할 수 없다.
    > **정답**: ④
    > **해설**: Set 컬렉션에는 null을 저장할 수 있다 (단, 하나만).

4.  Map 컬렉션에 대한 설명 중 틀린 것은 무엇입니까?
    *   ① 대표적인 구현 클래스로는 HashMap, Hashtable, TreeMap, Properties가 있다.
    *   ② HashMap과 Hashtable은 hashCode()와 equals() 메소드를 이용해서 중복 키를 판별한다.
    *   ③ 멀티 스레드 환경에서는 Hashtable보다는 HashMap이 스레드에 안전하다.
    *   ④ Properties는 키와 값이 모두 String 타입이다.
    > **정답**: ③
    > **해설**: Hashtable이 동기화되어 있어 스레드에 안전하다. HashMap은 안전하지 않다.

5.  단일(싱글) 스레드 환경에서 Board 객체를 저장 순서에 맞게 읽고 싶습니다. 가장 적합한 컬렉션을 생성하도록 밑줄 친 부분에 코드를 작성해 보세요.
    ```java
    List<Board> list = new ArrayList<Board>();
    // 또는 new ArrayList<>();
    ```

6.  단일(싱글) 스레드 환경에서 학번(String)를 키로, 점수(Integer)를 값으로 저장하는 가장 적합한 컬렉션을 생성하도록 밑줄 친 부분에 코드를 작성해 보세요.
    ```java
    Map<String, Integer> map = new HashMap<String, Integer>();
    // 또는 new HashMap<>();
    ```

7.  BoardDao 객체의 getBoardList() 메소드를 호출하면 List\<Board\> 타입의 컬렉션을 리턴합니다. ListExample 클래스의 실행 결과를 보고, BoardDao 클래스와 getBoardList() 메소드를 작성해 보세요.
    ```java
    import java.util.ArrayList;
    import java.util.List;

    public class BoardDao {
    	public List<Board> getBoardList() {
    		List<Board> list = new ArrayList<>();
    		list.add(new Board("제목1", "내용1"));
    		list.add(new Board("제목2", "내용2"));
    		list.add(new Board("제목3", "내용3"));
    		return list;
    	}
    }
    ```

8.  HashSet에 Student 객체를 저장하려고 합니다. 학번이 같으면 동일한 Student라고 가정하고 중복 저장이 되지 않도록 하고 싶습니다. Student 객체의 해시코드는 학번이라고 가정하고 Student 클래스를 작성해 보세요.
    ```java
    public class Student {
    	public int studentNum;
    	public String name;

    	public Student(int studentNum, String name) {
    		this.studentNum = studentNum;
    		this.name = name;
    	}

    	@Override
    	public int hashCode() {
    		return studentNum;
    	}

    	@Override
    	public boolean equals(Object obj) {
    		if (obj instanceof Student target) {
    			return target.studentNum == studentNum;
    		} else {
    			return false;
    		}
    	}
    }
    ```

9.  HashMap에 아이디(String)와 점수(Integer)가 저장되어 있습니다. 실행 결과와 같이 평균 점수, 최고 점수, 최고 점수를 받은 아이디를 출력하도록 코드를 작성해 보세요.
    ```java
    // ... main 내부 ...
    String name = null;
    int maxScore = 0;
    int totalScore = 0;

    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
    for (Map.Entry<String, Integer> entry : entrySet) {
    	if (entry.getValue() > maxScore) {
    		name = entry.getKey();
    		maxScore = entry.getValue();
    	}
    	totalScore += entry.getValue();
    }
    int avgScore = totalScore / map.size();

    System.out.println("평균 점수: " + avgScore);
    System.out.println("최고 점수: " + maxScore);
    System.out.println("최고 점수를 받은 아이디: " + name);
    ```

10. TreeSet에 Student 객체를 저장할 때, Student의 score 필드값을 기준으로 자동 정렬되도록 구현하고 싶습니다. TreeSet의 last() 메소드를 호출했을 때 가장 높은 score의 Student 객체가 리턴되도록 Student 클래스에서 밑줄 친 곳과 비어있는 곳에 코드를 작성해 보세요.
    ```java
    public class Student implements Comparable<Student> {
    	public String id;
    	public int score;

    	public Student(String id, int score) {
    		this.id = id;
    		this.score = score;
    	}

    	@Override
    	public int compareTo(Student o) {
    		if (score < o.score) return -1;
    		else if (score == o.score) return 0;
    		else return 1;
    	}
    }
    ```

11. LIFO와 FIFO 컬렉션에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① Stack은 LIFO이고 Queue는 FIFO 구조를 가지고 있다.
    *   ② Stack에 넣는 행위는 push이고, 빼는 행위는 pop이다.
    *   ③ Queue에 넣는 행위는 offer이고, 빼는 행위는 poll이다.
    *   ④ Stack과 Queue는 자바에서 클래스 타입이다.
    > **정답**: ④
    > **해설**: Stack은 클래스이지만, Queue는 인터페이스이다.

12. 동기화된 컬렉션에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 멀티 스레드 환경에서 안전하게 사용할 수 있는 컬렉션이다.
    *   ② 동기화된 컬렉션의 메소드는 synchronized 처리가 되어 있다.
    *   ③ Vector와 HashMap은 동기화된 컬렉션이다.
    *   ④ Collections의 synchronizedMap() 메소드는 동기화된 Map을 리턴한다.
    > **정답**: ③
    > **해설**: Vector는 동기화된 컬렉션이지만, HashMap은 동기화되어 있지 않다. Hashtable이 동기화된 컬렉션이다.

13. 수정할 수 없는 List 컬렉션에 대한 설명으로 틀린 것은 무엇입니까?
    *   ① 요소를 추가, 삭제할 수 없는 List 컬렉션을 말한다.
    *   ② List의 of() 메소드는 수정할 수 없는 컬렉션을 생성한다.
    *   ③ List의 copyOf() 메소드는 기존 컬렉션을 복사한 수정할 수 없는 컬렉션을 생성한다.
    *   ④ Arrays.asList() 메소드는 배열로부터 수정할 수 있는 List 컬렉션을 생성한다.
    > **정답**: ④
    > **해설**: Arrays.asList()로 생성된 리스트는 고정 크기라서 추가/삭제 불가능하지만 set()으로 변경은 가능하다. 하지만 문제의 문맥상 일반적으로 '수정할 수 없는' 기능에 포함되거나, 혹은 완전한 '수정할 수 있는' ArrayList와 구별된다. 하지만 여기서 명확히 틀린 것을 찾자면, Arrays.asList()는 `add`/`remove`를 지원하지 않아 "수정할 수 있는"이라고 단정하기 어렵고, `List.of`나 `copyOf`와 달리 `set`은 되므로 완전 불변도 아니다. 그러나 문제 의도는 1,2,3이 명확히 맞는 설명이고 4번이 "수정할 수 있는"이라고 했으므로 틀린 것으로 볼 수 있다. (Arrays.asList는 구조적 수정 불가). 혹은 Arrays.asList는 불변 리스트가 아니라 고정 크기 리스트이다.
