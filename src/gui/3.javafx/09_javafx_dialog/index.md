---
layout: gui
title: "09. JavaFX 다이얼로그"
---

# 09. JavaFX 다이얼로그

다이얼로그(Dialog)는 주 윈도우에서 알림을 표시하거나 사용자의 입력을 받기 위해 실행되는 서브 윈도우입니다. 다이얼로그를 띄우는 주 윈도우를 **소유자(Owner) 윈도우**라고 합니다.

### 다이얼로그 종류
- **모달(Modal)**: 다이얼로그를 닫기 전까지 소유자 윈도우를 사용할 수 없음.
- **모달리스(Modeless)**: 다이얼로그가 떠 있어도 소유자 윈도우를 계속 사용할 수 있음.

JavaFX는 `FileChooser`, `DirectoryChooser`, `Popup`, `stage`를 이용한 커스텀 다이얼로그 등을 제공합니다.

---

## 1. FileChooser, DirectoryChooser

### FileChooser
파일 열기/저장을 위한 다이얼로그입니다.

```java
FileChooser fileChooser = new FileChooser();
// 확장자 필터 설정
fileChooser.getExtensionFilters().addAll(
    new ExtensionFilter("Text Files", "*.txt"),
    new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
    new ExtensionFilter("All Files", "*.*")
);

// 파일 열기 다이얼로그 실행
File selectedFile = fileChooser.showOpenDialog(primaryStage);
if (selectedFile != null) {
    System.out.println("선택된 파일: " + selectedFile.getPath());
}

// 파일 저장 다이얼로그 실행
File savedFile = fileChooser.showSaveDialog(primaryStage);
```

### DirectoryChooser
디렉토리를 선택하기 위한 다이얼로그입니다.

```java
DirectoryChooser directoryChooser = new DirectoryChooser();
File selectedDir = directoryChooser.showDialog(primaryStage);
if (selectedDir != null) {
    System.out.println("선택된 폴더: " + selectedDir.getPath());
}
```

---

## 2. Popup

`Popup`은 투명한 컨테이너를 제공하는 모달리스 다이얼로그입니다. 툴팁, 알림 메시지, 드롭다운 메뉴 등에 사용됩니다.
- 장식(제목 표시줄, 닫기 버튼 등)이 없습니다.
- `autoHide` 속성을 `true`로 설정하면 포커스를 잃을 때 자동으로 닫힙니다.

### 예제: 알림 팝업

**popup.fxml**
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.HBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.image.Image?>
<?import javafx.geometry.Insets?>

<HBox xmlns:fx="http://javafx.com/fxml"
      alignment="CENTER_LEFT"
      style="-fx-background-color: black; -fx-background-radius: 20;">
    <children>
        <ImageView id="imgMessage" fitHeight="30" fitWidth="30" preserveRatio="true"/>
        <Label id="lblMessage" style="-fx-text-fill: white;">
            <HBox.margin>
                <Insets left="5.0" right="5.0" />
            </HBox.margin>
        </Label>
    </children>
</HBox>
```

**Java 코드**
```java
// Popup 생성
Popup popup = new Popup();

// FXML 로드
HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("popup.fxml"));
ImageView imageView = (ImageView) hbox.lookup("#imgMessage");
imageView.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
imageView.setOnMouseClicked(event -> popup.hide()); // 클릭 시 닫기

Label lblMessage = (Label) hbox.lookup("#lblMessage");
lblMessage.setText("메시지가 왔습니다.");

// Popup 설정
popup.getContent().add(hbox);
popup.setAutoHide(true); // 포커스 이동 시 자동 닫힘
popup.show(primaryStage); // 실행
```

---

## 3. 커스텀 다이얼로그 (Custom Dialog)

`Stage`를 직접 생성하여 원하는 형태의 다이얼로그를 만들 수 있습니다.

```java
// Stage 생성 및 스타일 설정
Stage dialog = new Stage(StageStyle.UTILITY);
dialog.initModality(Modality.WINDOW_MODAL); // 모달 설정
dialog.initOwner(primaryStage); // 소유자 윈도우 설정
dialog.setTitle("확인");

// 내용 설정 (FXML 로드)
Parent parent = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
Scene scene = new Scene(parent);
dialog.setScene(scene);
dialog.setResizable(false); // 크기 조절 불가

// 다이얼로그 실행
dialog.show();
```

### StageStyle 열거 상수
| 상수            | 설명                                         |
| :-------------- | :------------------------------------------- |
| **DECORATED**   | 일반적인 윈도우 (흰 배경, 제목줄, 장식 있음) |
| **UNDECORATED** | 흰 배경, 제목줄 없음                         |
| **TRANSPARENT** | 투명 배경, 제목줄 없음                       |
| **UNIFIED**     | DECORATED와 동일하나 내용물 경계선 없음      |
| **UTILITY**     | 흰 배경, 제목줄에 타이틀과 종료 버튼만 있음  |

---

## 4. PrimaryStage 얻기

컨트롤러에서 다이얼로그를 띄우려면 `primaryStage` 참조가 필요합니다.

### 방법 1: 메인 클래스에서 Setter 주입
```java
// Main
FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
Parent root = loader.load();
RootController controller = loader.getController();
controller.setPrimaryStage(primaryStage); // Setter 호출

// Controller
private Stage primaryStage;
public void setPrimaryStage(Stage primaryStage) {
    this.primaryStage = primaryStage;
}
```

### 방법 2: Node로부터 얻기 (이벤트 핸들러 내에서)
```java
// 버튼 클릭 이벤트 핸들러 등에서 사용 가능
public void handleButton(ActionEvent e) {
    // 이벤트가 발생한 컨트롤(button)이 속한 Scene의 Window를 얻음
    Stage primaryStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
    // 또는
    // Stage primaryStage = (Stage) button.getScene().getWindow();
}
```
**주의**: `initialize()` 메소드 시점에는 무대가 준비되지 않았으므로 이 방법을 사용할 수 없습니다.


