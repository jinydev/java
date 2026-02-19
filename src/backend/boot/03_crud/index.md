---
layout: backend
title: "3.3 JPA를 이용한 CRUD"
nav_order: 8
parent: "3주차. Spring Boot 시작하기"
grand_parent: "백엔드 웹서버 개발"
---

# 3.3 JPA를 이용한 CRUD

## 1. Entity (데이터 모델)
DB 테이블과 매핑되는 클래스입니다.

```java
@Entity
@Getter @Setter
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String content;
    private String writer;
}
```

## 2. Repository (데이터 접근)
인터페이스만 만들면 Spring Data JPA가 자동으로 구현체를 만들어줍니다. 기본적인 CRUD 메소드(`save`, `findById`, `findAll`, `delete`)가 이미 들어있습니다.

```java
public interface BoardRepository extends JpaRepository<Board, Long> {
}
```

## 3. Service (비즈니스 로직)
```java
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> list() {
        return boardRepository.findAll();
    }

    public void write(Board board) {
        boardRepository.save(board);
    }
}
```

## 4. Controller (요청 처리)
```java
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/list")
    public String list(Model model) {
        model.addAttribute("list", boardService.list());
        return "board/list"; // templates/board/list.html 로 이동
    }

    @PostMapping("/board/write")
    public String write(Board board) {
        boardService.write(board);
        return "redirect:/board/list";
    }
}
```

## 5. View (Thymeleaf) - list.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <table>
        <tr th:each="board : ${list}">
            <td th:text="${board.id}">1</td>
            <td th:text="${board.title}">제목</td>
            <td th:text="${board.writer}">홍길동</td>
        </tr>
    </table>
</body>
</html>
```
