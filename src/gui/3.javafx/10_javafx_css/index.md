---
layout: gui
title: "10. JavaFX CSS 스타일"
---

# 10. JavaFX CSS 스타일

JavaFX UI를 담당하는 컨테이너 및 컨트롤은 **CSS (Cascading Style Sheets)**를 적용해서 모양 및 색상 등을 변경할 수 있습니다. HTML에 CSS를 적용하는 것과 유사하며, W3C CSS 버전 2.1 스펙을 따릅니다.
단, JavaFX CSS 속성명은 W3C CSS 속성명 앞에 `-fx-` 접두어가 붙습니다.

---

## 1. CSS 적용 방식

### 1) 인라인 스타일 (Inline Style)
컨테이너 또는 컨트롤의 `style` 속성값으로 직접 CSS를 작성하는 방식입니다.
```xml
<Label style="-fx-background-color: black; -fx-text-fill: yellow; -fx-padding: 5;" />
```

### 2) 외부 CSS 파일 (External CSS File)
CSS를 별도 파일(`app.css`)에 작성하고, `Scene` 또는 `Parent`에 적용하는 방식입니다. 유지보수와 재사용성에 유리합니다.

**선택자 종류**
| 선택자           | 작성 방법        | 설명                                                                 |
| :--------------- | :--------------- | :------------------------------------------------------------------- |
| **Type 선택자**  | `Type { ... }`   | 같은 타입의 모든 컨트롤 선택 (예: `Label { ... }`)                   |
| **id 선택자**    | `#id { ... }`    | `id` 속성값이 일치하는 컨트롤 선택 (예: `#lblId { ... }`)            |
| **class 선택자** | `.class { ... }` | `styleClass` 속성값이 일치하는 컨트롤 선택 (예: `.lblClass { ... }`) |

**상태별 선택자 (Pseudo-class)**
| 상태        | 선택자                 | 설명                           |
| :---------- | :--------------------- | :----------------------------- |
| **focus**   | `Type:focused { ... }` | 입력 포커스를 가진 상태        |
| **hover**   | `Type:hover { ... }`   | 마우스가 컨트롤 위에 있는 상태 |
| **pressed** | `Type:pressed { ... }` | 마우스로 클릭한 상태           |

#### 외부 CSS 적용 코드
```java
Scene scene = new Scene(root);
scene.getStylesheets().add(getClass().getResource("app.css").toString());
```

---

## 2. 주요 CSS 속성

### border 속성 (경계선)
| 속성                | 설명                                           |
| :------------------ | :--------------------------------------------- |
| `-fx-border-color`  | 경계선 색상                                    |
| `-fx-border-width`  | 경계선 두께 (top right bottom left 순서 가능)  |
| `-fx-border-style`  | 경계선 스타일 (`solid`, `dotted`, `dashed` 등) |
| `-fx-border-radius` | 모서리 둥글기 반지름                           |
| `-fx-border-insets` | 내부 경계선 위치 (여러 겹 테두리 가능)         |

### background 속성 (배경)
| 속성                      | 설명                                          |
| :------------------------ | :-------------------------------------------- |
| `-fx-background-color`    | 배경 색상 (단색, 그라디언트)                  |
| `-fx-background-image`    | 배경 이미지 URL                               |
| `-fx-background-repeat`   | 이미지 반복 여부 (`no-repeat`, `repeat-x` 등) |
| `-fx-background-position` | 이미지 위치 (`center`, `top left` 등)         |

**그라디언트 예시**
- **선형(Linear)**: `linear-gradient(to right, black, white)`
- **원형(Radial)**: `radial-gradient(center 50% 50%, radius 50%, white, black)`

### font 속성 (글꼴)
| 속성              | 설명                         |
| :---------------- | :--------------------------- |
| `-fx-font-family` | 폰트 종류 (예: "Arial")      |
| `-fx-font-size`   | 폰트 크기 (예: 12px)         |
| `-fx-font-weight` | 폰트 굵기 (`bold`, `normal`) |
| `-fx-text-fill`   | 글자 색상                    |

### effect 속성 (그림자 효과)
- **DropShadow**: 바깥 그림자 (튀어나오는 느낌)
  ```css
  -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);
  ```
- **InnerShadow**: 안쪽 그림자 (움푹 들어간 느낌)
  ```css
  -fx-effect: innershadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);
  ```

---

## 3. 예제: 로그인 폼 스킨 입히기

**root.fxml**
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.control.PasswordField?>
<?import javafx.scene.control.Button?>

<AnchorPane styleClass="root" xmlns:fx="http://javafx.com/fxml"
            prefHeight="194.0" prefWidth="300.0">
    <children>
        <Label id="welcome-text" layoutX="40.0" layoutY="14.0" text="Welcome" />
        <Label layoutX="42.0" layoutY="80.0" text="아이디" />
        <Label layoutX="42.0" layoutY="118.0" text="패스워드" />
        <TextField layoutX="120.0" layoutY="76.0" />
        <PasswordField layoutX="120.0" layoutY="114.0" />
        <Button layoutX="97.0" layoutY="158.0" styleClass="button" text="로그인" />
        <Button layoutX="164.0" layoutY="158.0" styleClass="button" text="취소" />
    </children>
</AnchorPane>
```

**app.css**
```css
.root {
    -fx-background-image: url("images/background.jpg");
}

Label {
    -fx-font-size: 12px;
    -fx-font-weight: bold;
    -fx-text-fill: #333333;
}

#welcome-text {
    -fx-font-size: 35px;
    -fx-font-family: "Arial Black";
    -fx-text-fill: linear-gradient(darkgray, lightgray);
    -fx-effect: innershadow(three-pass-box, rgba(0,0,0,0.7), 3, 0, 2, 2.1);
}

.button {
    -fx-text-fill: white;
    -fx-font-family: "Arial Narrow";
    -fx-font-weight: bold;
    -fx-background-color: linear-gradient(#61a2b1, #2A5058);
    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 2, 2);
}

.button:hover {
    -fx-background-color: linear-gradient(#2A5058, #61a2b1);
}

.button:pressed {
    -fx-background-color: linear-gradient(yellow, #61a2b1);
}
```


