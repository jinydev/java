---
layout: gui
title: "08. JavaFX 메뉴바와 툴바"
---

# 08. JavaFX 메뉴바와 툴바

UI 애플리케이션에서 메뉴바와 툴바는 필수적인 요소입니다. JavaFX는 이를 위해 `MenuBar`와 `ToolBar` 컨트롤을 제공합니다.

---

## 1. MenuBar 컨트롤

MenuBar는 컨테이너 상단에 배치되어 사용자가 다양한 작업을 선택할 수 있게 합니다.

### 구조
- **MenuBar**: 전체 메뉴 바 컨테이너.
- **Menu**: "파일", "편집" 등의 상위 메뉴.
- **MenuItem**: 실제로 클릭하여 동작을 수행하는 메뉴 항목.

### 메뉴 아이템 종류
- **`MenuItem`**: 기본 메뉴 항목.
- **`CheckMenuItem`**: 선택/해제 상태를 가지는 메뉴 (V 체크 표시).
- **`RadioMenuItem`**: 그룹 내에서 하나만 선택 가능한 메뉴.
- **`CustomMenuItem`**: 임의의 노드를 메뉴로 포함.
- **`SeparatorMenuItem`**: 메뉴 항목 간의 구분선.

### FXML 선언

```xml
<MenuBar>
    <menus>
        <Menu text="파일">
            <items>
                <MenuItem text="새로만들기" onAction="#handleNew">
                    <accelerator>
                        <KeyCodeCombination alt="DOWN" code="N" control="UP" 
                                            meta="UP" shift="DOWN" shortcut="UP" />
                    </accelerator>
                    <graphic>
                        <ImageView>
                            <image><Image url="@icons/new.png" /></image>
                        </ImageView>
                    </graphic>
                </MenuItem>
                <SeparatorMenuItem />
                <MenuItem text="끝내기" onAction="#handleExit"/>
            </items>
        </Menu>
        <Menu text="편집">
            <items>
                <MenuItem text="복사"/>
                <MenuItem text="붙여넣기"/>
            </items>
        </Menu>
    </menus>
</MenuBar>
```

### 단축키 (Accelerator) 설정
`<accelerator>` 태그와 `KeyCodeCombination`을 사용하여 단축키를 설정할 수 있습니다.
- `alt`, `control`, `shift`, `meta`: `DOWN` (누름) 또는 `UP` (안 누름)으로 설정.
- `code`: 키 코드 (예: "N", "S").

---

## 2. ToolBar 컨트롤

자주 사용하는 기능을 버튼 아이콘으로 제공하여 빠르게 접근할 수 있게 합니다.

### FXML 선언

```xml
<ToolBar>
    <items>
        <Button onAction="#handleNew">
            <graphic>
                <ImageView>
                    <image><Image url="@icons/new.png" /></image>
                </ImageView>
            </graphic>
            <tooltip>
                <Tooltip text="새로 만들기" />
            </tooltip>
        </Button>
        <Button onAction="#handleSave">
            <graphic>
                <ImageView>
                    <image><Image url="@icons/save.png" /></image>
                </ImageView>
            </graphic>
        </Button>
        <!-- 다른 컨트롤도 포함 가능 -->
        <ComboBox promptText="선택">
            <items>
                <FXCollections fx:factory="observableArrayList">
                    <String fx:value="공개" />
                    <String fx:value="비공개" />
                </FXCollections>
            </items>
        </ComboBox>
    </items>
</ToolBar>
```

### 예제: 메모장 UI 구성

**root.fxml**
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.input.*?>
<?import javafx.scene.image.*?>
<?import javafx.collections.*?>
<?import java.lang.*?>

<BorderPane xmlns:fx="http://javafx.com/fxml"
            fx:controller="sec08.exam01_menubar_toolbar.RootController"
            prefHeight="200.0" prefWidth="400.0">
    <top>
        <VBox>
            <children>
                <MenuBar>
                    <menus>
                        <Menu text="파일">
                            <items>
                                <MenuItem text="새로만들기" onAction="#handleNew">
                                    <accelerator>
                                        <KeyCodeCombination alt="DOWN" code="N" 
                                            control="UP" meta="UP" shift="DOWN" shortcut="UP" />
                                    </accelerator>
                                    <graphic>
                                        <ImageView><image><Image url="@icons/new.png"/></image></ImageView>
                                    </graphic>
                                </MenuItem>
                                <MenuItem text="열기" onAction="#handleOpen">
                                    <accelerator>
                                        <KeyCodeCombination alt="UP" code="O" control="DOWN" 
                                            meta="UP" shift="UP" shortcut="UP" />
                                    </accelerator>
                                    <graphic>
                                        <ImageView><image><Image url="@icons/open.png"/></image></ImageView>
                                    </graphic>
                                </MenuItem>
                                <MenuItem text="저장" onAction="#handleSave">
                                    <accelerator>
                                        <KeyCodeCombination alt="UP" code="S" control="DOWN" 
                                            meta="UP" shift="UP" shortcut="UP" />
                                    </accelerator>
                                    <graphic>
                                        <ImageView><image><Image url="@icons/save.png"/></image></ImageView>
                                    </graphic>
                                </MenuItem>
                                <SeparatorMenuItem />
                                <MenuItem text="끝내기" onAction="#handleExit"/>
                            </items>
                        </Menu>
                    </menus>
                </MenuBar>
                
                <ToolBar>
                    <items>
                        <Button onAction="#handleNew">
                            <graphic>
                                <ImageView><image><Image url="@icons/new.png"/></image></ImageView>
                            </graphic>
                        </Button>
                        <Button onAction="#handleOpen">
                            <graphic>
                                <ImageView><image><Image url="@icons/open.png"/></image></ImageView>
                            </graphic>
                        </Button>
                        <Button onAction="#handleSave">
                            <graphic>
                                <ImageView><image><Image url="@icons/save.png"/></image></ImageView>
                            </graphic>
                        </Button>
                    </items>
                </ToolBar>
            </children>
        </VBox>
    </top>
    
    <center>
        <TextArea fx:id="textArea"/>
    </center>
</BorderPane>
```

**RootController.java**
```java
package sec08.exam01_menubar_toolbar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
    @FXML private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void handleNew(ActionEvent e) {
        textArea.appendText("New\n");
    }

    public void handleOpen(ActionEvent e) {
        textArea.appendText("Open\n");
    }

    public void handleSave(ActionEvent e) {
        textArea.appendText("Save\n");
    }

    public void handleExit(ActionEvent e) {
        Platform.exit();
    }
}
```


