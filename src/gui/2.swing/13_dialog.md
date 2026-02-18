---
layout: gui
title: "13. 다이얼로그"
---

# 13. 다이얼로그

다이얼로그(Dialog)는 주 윈도우에서 사용자의 입력을 받거나 메시지를 전달하기 위해 띄우는 서브 윈도우입니다. 다이얼로그를 띄우는 주 윈도우를 **소유자(Owner)**라고 합니다.

## 1. 다이얼로그 종류
- **모달(Modal)**: 다이얼로그를 닫기 전까지 소유자 윈도우를 사용할 수 없음. (입력 강제)
- **모달리스(Modeless)**: 다이얼로그가 떠 있어도 소유자 윈도우를 계속 사용할 수 있음.

---

## 2. JDialog
사용자 정의 다이얼로그를 만들 때 `JDialog`를 상속받아 구현합니다.

### 주요 설정
```java
public class MyDialog extends JDialog {
    public MyDialog(JFrame owner) {
        super(owner); // 소유자 설정
        setTitle("Title");
        setSize(300, 200);
        setModal(true); // 모달 설정
        setResizable(false);
        
        // 위치 설정 (소유자 중앙)
        setLocationRelativeTo(owner);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // 닫을 때 리소스 해제
    }
}
```

### 소멸 상수 (`setDefaultCloseOperation`)
| 상수                  | 설명                |
| :-------------------- | :------------------ |
| `DO_NOTHING_ON_CLOSE` | 아무것도 하지 않음  |
| `HIDE_ON_CLOSE`       | 숨김 (기본값)       |
| `DISPOSE_ON_CLOSE`    | 리소스 해제 및 제거 |

---

## 3. 표준 다이얼로그 (JOptionPane)
Swing은 자주 사용되는 다이얼로그를 `JOptionPane` 클래스로 제공합니다.

| 메서드              | 설명        | 버튼 구성      |
| :------------------ | :---------- | :------------- |
| `showMessageDialog` | 메시지 출력 | [확인]         |
| `showConfirmDialog` | 사용자 확인 | [예/아니오] 등 |
| `showInputDialog`   | 문자열 입력 | [확인/취소]    |
| `showOptionDialog`  | 사용자 정의 | [커스텀 버튼]  |

### 매개변수
- `parentComponent`: 다이얼로그가 뜰 위치의 기준 (null이면 화면 중앙)
- `message`: 표시할 내용
- `title`: 제목 표시줄 텍스트
- `messageType`: 아이콘 (`INFORMATION`, `WARNING`, `ERROR`, `QUESTION`, `PLAIN`)

### 리턴값 (ConfirmDialog)
- `YES_OPTION`: 예
- `NO_OPTION`: 아니오
- `CANCEL_OPTION`: 취소
- `CLOSED_OPTION`: X 버튼

### 예제 (`JOptionPaneExample`)
```java
package sec13.exam02_joptionpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JOptionPaneExample extends JFrame {
    private JButton btnMessage, btnConfirm, btnInput, btnOption;

    public JOptionPaneExample() {
        this.setTitle("JOptionPaneExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(4, 1));
        
        this.getContentPane().add(getBtnMessage());
        this.getContentPane().add(getBtnConfirm());
        this.getContentPane().add(getBtnInput());
        this.getContentPane().add(getBtnOption());
        
        this.setSize(400, 300);
    }

    public JButton getBtnMessage() {
        if (btnMessage == null) {
            btnMessage = new JButton("MessageDialog");
            btnMessage.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    JOptionPaneExample.this,
                    "알림 메시지입니다.",
                    "알림",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });
        }
        return btnMessage;
    }

    public JButton getBtnConfirm() {
        if (btnConfirm == null) {
            btnConfirm = new JButton("ConfirmDialog");
            btnConfirm.addActionListener(e -> {
                int option = JOptionPane.showConfirmDialog(
                    JOptionPaneExample.this,
                    "진행하시겠습니까?",
                    "확인",
                    JOptionPane.OK_CANCEL_OPTION
                );
                
                if (option == JOptionPane.OK_OPTION) {
                    System.out.println("확인 선택");
                } else {
                    System.out.println("취소 선택");
                }
            });
        }
        return btnConfirm;
    }

    public JButton getBtnInput() {
        if (btnInput == null) {
            btnInput = new JButton("InputDialog");
            btnInput.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(
                    JOptionPaneExample.this,
                    "이름을 입력하세요:",
                    "입력",
                    JOptionPane.QUESTION_MESSAGE
                );
                System.out.println("입력값: " + input);
            });
        }
        return btnInput;
    }

    public JButton getBtnOption() {
        if (btnOption == null) {
            btnOption = new JButton("OptionDialog");
            btnOption.addActionListener(e -> {
                String[] options = {"시작", "중지"};
                int choice = JOptionPane.showOptionDialog(
                    JOptionPaneExample.this,
                    "작업을 선택하세요",
                    "옵션",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
                );
                
                if (choice == 0) System.out.println("시작 선택");
                else if (choice == 1) System.out.println("중지 선택");
            });
        }
        return btnOption;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JOptionPaneExample().setVisible(true);
        });
    }
}
```

---

## 4. 파일 다이얼로그 (JFileChooser)
파일을 열거나 저장할 때 사용합니다.

- `showOpenDialog(Component)`: [열기] 다이얼로그, `APPROVE_OPTION` 반환 시 선택 완료.
- `showSaveDialog(Component)`: [저장] 다이얼로그.
- `getSelectedFile()`: 선택된 `File` 객체 반환.
- `FileNameExtensionFilter`: 확장자 필터링.

### 예제 (`JFileChooserExample`)
```java
package sec13.exam03_jfilechooser;

import java.awt.GridLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserExample extends JFrame {
    private JButton btnOpen, btnSave;

    public JFileChooserExample() {
        setTitle("JFileChooserExample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        
        add(getBtnOpen());
        add(getBtnSave());
        setSize(300, 200);
    }

    public JButton getBtnOpen() {
        if (btnOpen == null) {
            btnOpen = new JButton("Open File");
            btnOpen.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("텍스트 파일 (*.txt)", "txt"));
                
                int option = fileChooser.showOpenDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    System.out.println("여는 파일: " + file.getAbsolutePath());
                }
            });
        }
        return btnOpen;
    }

    public JButton getBtnSave() {
        if (btnSave == null) {
            btnSave = new JButton("Save File");
            btnSave.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    System.out.println("저장할 파일: " + file.getAbsolutePath());
                }
            });
        }
        return btnSave;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JFileChooserExample().setVisible(true));
    }
}
```

---

## 5. 색상 다이얼로그 (JColorChooser)
색상을 선택할 수 있는 다이얼로그입니다. `JColorChooser.showDialog()` 정적 메서드를 사용합니다.

```java
Color selectedColor = JColorChooser.showDialog(
    parentComponent,
    "색상 선택",
    Color.BLUE // 초기값
);

if (selectedColor != null) {
    // 색상 선택됨
    component.setBackground(selectedColor);
}
```


