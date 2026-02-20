---
layout: gui
title: "06. JavaFX 속성 감시와 바인딩"
---

# 06. JavaFX 속성 감시와 바인딩

JavaFX는 컨트롤의 **속성(Property)**을 감시하는 리스너를 설정할 수 있습니다. 예를 들어 `Slider`의 `value` 속성값을 감시하여, 값이 변경되면 `Label`의 폰트 크기나 이미지의 크기를 실시간으로 변경할 수 있습니다.

---

## 1. 속성 감시 (Property Monitoring)

JavaFX 컨트롤의 모든 속성은 `XXXProperty` 객체로 생성됩니다. 이는 Getter/Setter 외에도 속성 객체 자체를 리턴하는 `xxxProperty()` 메소드를 제공합니다.

### 예: TextField의 text 속성
`TextField`의 `text` 속성은 `StringProperty` 타입입니다.

```java
// StringProperty 타입의 text 속성 선언
private StringProperty text = new SimpleStringProperty();

// Getter와 Setter
public void setText(String newValue) { text.set(newValue); }
public String getText() { return text.get(); }

// StringProperty 객체를 리턴하는 메소드
public StringProperty textProperty() { return text; }
```

### 리스너 등록 (`ChangeListener`)
`addListener()` 메소드를 사용하여 속성 변경 시 실행될 코드를 등록할 수 있습니다.

```java
slider.valueProperty().addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> observable, 
                        Number oldValue, Number newValue) {
        // 속성값이 변경되었을 때 실행되는 코드
        System.out.println("변경전: " + oldValue + ", 변경후: " + newValue);
    }
});
```

- **oldValue**: 변경 전 값
- **newValue**: 변경 후 값 (새로운 값)

### 예제: Slider 값에 따른 폰트 크기 변경

**root.fxml**
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.text.Font?>
<?import javafx.scene.control.Slider?>

<BorderPane xmlns:fx="http://javafx.com/fxml"
            fx:controller="sec06.exam01_property_listener.RootController"
            prefHeight="250.0" prefWidth="350.0">
    <center>
        <Label fx:id="label" text="JavaFX">
            <font>
                <Font size="0"/>
            </font>
        </Label>
    </center>
    <bottom>
        <Slider fx:id="slider"/>
    </bottom>
</BorderPane>
```

**RootController.java**
```java
package sec06.exam01_property_listener;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {
    @FXML private Slider slider;
    @FXML private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Slider의 value 속성 감시 설정
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, 
                                Number oldValue, Number newValue) {
                // Label의 폰트 크기를 Slider의 값으로 변경
                label.setFont(new Font(newValue.doubleValue()));
            }
        });
    }
}
```

---

## 2. 속성 바인딩 (Property Binding)

속성 바인딩은 **한 속성의 값이 변경되면 다른 속성의 값도 자동으로 변경**되도록 연결하는 기능입니다.

### 1) 단방향 바인딩 (Unidirectional Binding)
한쪽 속성이 변경될 때 다른 쪽 속성도 따라서 변경되지만, 반대는 성립하지 않습니다.
- `target.bind(source)`: source가 변하면 target도 변함.

```java
TextArea textArea1 = new TextArea();
TextArea textArea2 = new TextArea();
// textArea1이 변경되면 textArea2도 변경됨 (textArea2는 직접 수정 불가)
textArea2.textProperty().bind(textArea1.textProperty());
```

### 2) 양방향 바인딩 (Bidirectional Binding)
어느 한쪽이 변경되면 다른 쪽도 함께 변경됩니다.
- `target.bindBidirectional(source)`

```java
// 방법 1
textArea2.textProperty().bindBidirectional(textArea1.textProperty());

// 방법 2 (Bindings 클래스 사용)
Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
```

> **바인딩 해제**: `unbind()` 또는 `unbindBidirectional()` 메소드 사용.

### 예제: 양방향 바인딩

**RootController.java**
```java
@Override
public void initialize(URL location, ResourceBundle resources) {
    // 두 TextArea의 text 속성을 양방향 바인딩
    Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
}
```

---

## 3. Bindings 클래스

`Bindings` 클래스는 속성값의 연산, 변환, 조건문 등을 처리하여 바인딩할 수 있는 다양한 정적 메소드를 제공합니다.

| 메소드                                  | 설명                                |
| :-------------------------------------- | :---------------------------------- |
| `add`, `subtract`, `multiply`, `divide` | 사칙연산 수행 후 바인딩             |
| `max`, `min`                            | 최대/최소값 바인딩                  |
| `greaterThan`, `greaterThanOrEqual`     | 크기 비교 (true/false) 바인딩       |
| `lessThan`, `lessThanOrEqual`           | 크기 비교 (true/false) 바인딩       |
| `equal`, `notEqual`                     | 동등 비교 (true/false) 바인딩       |
| `isEmpty`, `isNotEmpty`                 | 비어있는지 여부 확인                |
| `isNull`, `isNotNull`                   | Null 여부 확인                      |
| `length`                                | 문자열 길이 바인딩                  |
| `size`                                  | 컬렉션(List, Map 등) 요소 수 바인딩 |
| `and`, `or`, `not`                      | 논리 연산 바인딩                    |
| `convert`                               | 문자열로 변환하여 바인딩            |
| `select`                                | 중첩된 속성 탐색 및 바인딩          |

### 예제: 원을 항상 화면 중앙에 유지하기
`Cannot divide by zero` 등의 예외를 방지하고 반응형 UI를 만들기 위해 `Bindings.divide()`를 사용합니다.

```java
// Circle의 중심 좌표(centerX, centerY)를 Root 컨테이너의 너비/높이의 절반으로 바인딩
circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2));
circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));
```

**RootController.java**
```java
package sec06.exam03_bindings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class RootController implements Initializable {
    @FXML private AnchorPane root;
    @FXML private Circle circle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 화면 크기가 변해도 항상 중앙에 위치하도록 바인딩
        circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2));
        circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));
    }
}
```
