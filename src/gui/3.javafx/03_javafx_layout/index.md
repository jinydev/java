---
layout: gui
title: "03. JavaFX 레이아웃"
---

# 03. JavaFX 레이아웃

장면(Scene)에는 다양한 컨트롤이 포함되는데, 이들을 배치하는 것을 **레이아웃(Layout)**이라고 합니다. 레이아웃을 작성하는 방법은 두 가지가 있습니다.

1. **프로그램적 레이아웃**: 자바 코드로 직접 UI를 생성하고 배치.
2. **FXML 레이아웃**: XML 기반의 마크업 언어(FXML)로 UI를 선언.

---

## 1. 프로그램적 레이아웃

자바 코드로 UI 컨트롤을 배치하는 방법입니다.
- **장점**: 자바 코드에 익숙한 개발자가 빠르게 작성 가능.
- **단점**: 레이아웃이 복잡해지면 코드가 난잡해지고, 디자인 수정 시 재컴파일이 필요함. 디자이너(Scene Builder 등)와 협업이 어려움.

### 예제 (`AppMain.java`)
`HBox` 컨테이너를 사용하여 `TextField`와 `Button`을 수평으로 배치하는 예제입니다.

```java
package sec03.exam01_programmatical_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. HBox 컨테이너 생성 및 설정
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10)); // 안쪽 여백
        hbox.setSpacing(10); // 컨트롤 간의 수평 간격

        // 2. 컨트롤 생성
        TextField textField = new TextField();
        textField.setPrefWidth(200); // 폭 설정

        Button button = new Button();
        button.setText("확인"); // 텍스트 설정

        // 3. 컨테이너에 컨트롤 추가
        hbox.getChildren().add(textField);
        hbox.getChildren().add(button);

        // 4. 장면 및 윈도우 설정
        Scene scene = new Scene(hbox);
        primaryStage.setTitle("AppMain");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

---

## 2. FXML 레이아웃

XML 기반의 **FXML**을 사용하여 UI 레이아웃을 자바 코드와 분리하여 선언하는 방법입니다.
- **장점**: UI와 로직(Java)의 분리, 디자이너와 협업 용이, 수정 시 재컴파일 불필요, 재사용성 높음.
- **Scene Builder**를 사용하여 시각적으로 디자인 가능.

### 예제 (`root.fxml`)
위의 프로그램적 레이아웃과 동일한 화면을 FXML로 작성한 코드입니다.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.HBox?>
<?import javafx.geometry.Insets?>
<?import javafx.scene.control.*?>

<HBox xmlns:fx="http://javafx.com/fxml">
    <padding>
        <Insets top="10" right="10" bottom="10" left="10" />
    </padding>
    <spacing>10</spacing>
    
    <children>
        <TextField>
            <prefWidth>200</prefWidth>
        </TextField>
        
        <Button>
            <text>확인</text>
        </Button>
    </children>
</HBox>
```

- `xmlns:fx`: FXML 네임스페이스 선언 (`http://javafx.com/fxml`).
- `<?import ...?>`: 자바의 `import`와 동일.

### FXML 로딩 (`AppMain.java`)
`FXMLLoader`를 사용하여 FXML 파일을 로딩하여 객체화합니다.

```java
Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
Scene scene = new Scene(root);
```

---

## 3. 레이아웃 여백: 패딩(Padding)과 마진(Margin)

컨트롤 배치를 조정하기 위해 여백을 설정합니다.

| 구분               | 설명                   | 설정 메소드 (Java)                  | FXML 태그/속성                                       |
| :----------------- | :--------------------- | :---------------------------------- | :--------------------------------------------------- |
| **패딩 (Padding)** | 컨테이너 **안쪽** 여백 | `container.setPadding(Insets)`      | `<padding><Insets .../></padding>`                   |
| **마진 (Margin)**  | 컨트롤 **바깥쪽** 여백 | `Container.setMargin(node, Insets)` | `<Container.margin><Insets .../></Container.margin>` |

- **Insets 객체**: `new Insets(top, right, bottom, left)` 순서 (시계 방향).

### 비교 예제

**1) HBox의 Padding 설정**
```java
HBox hbox = new HBox();
hbox.setPadding(new Insets(50)); // 모든 면 50
```

**2) Button의 Margin 설정**
```java
Button button = new Button();
HBox.setMargin(button, new Insets(50));
// HBox 안에 있는 Button에 마진 적용
```

---

## 4. FXML 태그와 자바 코드 매핑

자바 코드와 FXML 태그는 1:1로 매핑됩니다. 이 규칙을 이해하면 API 문서를 보고 FXML을 작성할 수 있습니다.

| 자바 코드 (Java)                                                             | FXML 태그                                                                                                                                  |
| :--------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------- |
| **패키지 선언**<br>`import javafx.scene.layout.HBox;`                        | **import 태그**<br>`<?import javafx.scene.layout.HBox?>`                                                                                   |
| **객체 생성**<br>`new HBox()`                                                | **태그 선언**<br>`<HBox> ... </HBox>`                                                                                                      |
| **속성 설정 (Setter)**<br>`btn.setText("확인");`<br>`btn.setPrefWidth(200);` | **속성(Attribute)**<br>`<Button text="확인" prefWidth="200" />`<br>**자식 태그(Property Element)**<br>`<Button><text>확인</text></Button>` |
| **자식 추가**<br>`hbox.getChildren().add(btn);`                              | **자식 태그**<br>`<children><Button ... /></children>`                                                                                     |

### 객체 선언 규칙

1. **기본 생성자 호출**: `<클래스명 ... />`
2. **이름 있는 매개변수 생성자**: `@NamedArg`가 있는 경우 속성으로 전달.
3. **정적 메소드(Factory) 호출**: `fx:factory` 속성 사용.
   ```xml
   <FXCollections fx:factory="observableArrayList"> ... </FXCollections>
   ```
4. **값 객체(Value Object) 생성**: `fx:value` 사용 (String, Integer 등).
   ```xml
   <String fx:value="Hello World" />
   ```
5. **상수(Constant) 참조**: `fx:constant` 사용.
   ```xml
   <Double fx:constant="MAX_VALUE" />
   ```

---

## 5. Scene Builder 사용

[Scene Builder](https://gluonhq.com/products/scene-builder/)를 사용하면 드래그 앤 드롭으로 UI를 디자인하고 FXML을 자동 생성할 수 있습니다.

1. **프로젝트 생성**: JavaFX 프로젝트 생성.
2. **FXML 파일 생성**: `New > JavaFX > New FXML Document`.
3. **Scene Builder 열기**: FXML 파일 우클릭 > **Open with SceneBuilder**.
4. **디자인**:
   - **Containers/Controls**: 팔레트에서 드래그하여 배치.
   - **Properties/Layout**: 우측 패널에서 속성 설정.
5. **저장**: 저장 시 FXML 파일이 자동 업데이트됨.


