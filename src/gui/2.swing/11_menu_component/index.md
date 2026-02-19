---
layout: gui
title: "11. 메뉴 컴포넌트"
---

# 11. 메뉴 컴포넌트

UI 프로그램에서 메뉴는 필수적인 구성 요소입니다. Swing은 `javax.swing` 패키지를 통해 다양한 메뉴 컴포넌트를 제공합니다.

| 컴포넌트                   | 설명                                                 |
| :------------------------- | :--------------------------------------------------- |
| **`JMenuBar`**             | 윈도우 상단에 위치하는 메뉴 바                       |
| **`JMenu`**                | 메뉴 바나 다른 메뉴에 포함되는 메뉴 (예: 파일, 편집) |
| **`JPopupMenu`**           | 마우스 우클릭 시 나타나는 팝업 메뉴                  |
| **`JMenuItem`**            | 실제 선택 가능한 메뉴 항목                           |
| **`JCheckBoxMenuItem`**    | 체크박스가 있는 메뉴 항목 (선택/해제 가능)           |
| **`JRadioButtonMenuItem`** | 라디오 버튼이 있는 메뉴 항목 (그룹 중 하나 선택)     |
| **`JSeparator`**           | 메뉴 항목 간의 구분선                                |

---

## 1. 메뉴 생성 및 배치
메뉴를 구성하는 단계는 다음과 같습니다.
1. `JMenuBar` 생성 및 `JFrame`에 설정 (`setJMenuBar()`).
2. `JMenu` 생성 및 `JMenuBar`에 추가.
3. `JMenuItem` 생성 및 `JMenu`에 추가.

```java
JMenuBar menuBar = new JMenuBar();
JMenu fileMenu = new JMenu("파일");
JMenuItem newItem = new JMenuItem("새로 만들기");

fileMenu.add(newItem);
menuBar.add(fileMenu);

frame.setJMenuBar(menuBar);
```

### 주의사항
- `JMenuBar`는 컨테이너 상단에 고정됩니다.
- 메뉴에 하위 메뉴(Sub Menu)를 넣으려면 `JMenu`에 또 다른 `JMenu`를 `add()`하면 됩니다.

---

## 2. 메뉴 예제 (`JMenuExample`)
다음은 파일 및 도움말 메뉴를 구성하고, 체크박스 메뉴 아이템과 아이콘을 사용하는 예제입니다.

```java
package sec11.exam01_jmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class JMenuExample extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu menuFile, menuNew, menuHelp;
    private JMenuItem menuItemNewFile, menuItemNewFolder;
    private JMenuItem menuItemOpen, menuItemSave, menuItemExit;
    
    public JMenuExample() {
        this.setTitle("JMenuExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.setJMenuBar(getJMenuBar());
    }

    // JMenuBar 생성
    public JMenuBar getJMenuBar() {
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
            jMenuBar.add(getMenuFile());
            jMenuBar.add(getMenuHelp());
        }
        return jMenuBar;
    }

    // [파일] 메뉴
    public JMenu getMenuFile() {
        if (menuFile == null) {
            menuFile = new JMenu("파일");
            menuFile.add(getMenuNew()); // 서브 메뉴
            menuFile.add(getMenuItemOpen());
            menuFile.add(getMenuItemSave());
            menuFile.add(new JSeparator()); // 구분선
            menuFile.add(getMenuItemExit());
        }
        return menuFile;
    }

    // [도움말] 메뉴
    public JMenu getMenuHelp() {
        if (menuHelp == null) {
            menuHelp = new JMenu("도움말");
        }
        return menuHelp;
    }

    // [파일] -> [새로 만들기] 서브 메뉴
    public JMenu getMenuNew() {
        if (menuNew == null) {
            menuNew = new JMenu("새로 만들기");
            menuNew.add(getMenuItemNewFile());
            menuNew.add(getMenuItemNewFolder());
        }
        return menuNew;
    }

    public JMenuItem getMenuItemNewFile() {
        if (menuItemNewFile == null) {
            menuItemNewFile = new JMenuItem("새 파일");
        }
        return menuItemNewFile;
    }

    public JMenuItem getMenuItemNewFolder() {
        if (menuItemNewFolder == null) {
            menuItemNewFolder = new JMenuItem("새 폴더");
        }
        return menuItemNewFolder;
    }

    public JMenuItem getMenuItemOpen() {
        if (menuItemOpen == null) {
            // 아이콘 포함 (이미지 파일 필요)
            menuItemOpen = new JMenuItem("파일 열기", new ImageIcon(getClass().getResource("open.gif")));
        }
        return menuItemOpen;
    }

    public JMenuItem getMenuItemSave() {
        if (menuItemSave == null) {
            // 체크박스 메뉴 아이템
            menuItemSave = new JCheckBoxMenuItem("파일 저장 (Check)");
            menuItemSave.addActionListener(actionListener);
        }
        return menuItemSave;
    }

    public JMenuItem getMenuItemExit() {
        if (menuItemExit == null) {
            menuItemExit = new JMenuItem("종료");
            menuItemExit.addActionListener(actionListener);
        }
        return menuItemExit;
    }

    // 이벤트 리스너
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menuItemSave) {
                if (menuItemSave.isSelected()) {
                    JOptionPane.showMessageDialog(JMenuExample.this, "저장 기능 활성화");
                } else {
                    JOptionPane.showMessageDialog(JMenuExample.this, "저장 기능 비활성화");
                }
            } else if (e.getSource() == menuItemExit) {
                System.exit(0);
            }
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JMenuExample jFrame = new JMenuExample();
            jFrame.setVisible(true);
        });
    }
}
```

---

## 3. 이벤트 처리
메뉴 선택 시 `ActionEvent`가 발생합니다.
- `e.getSource()`: 선택된 메뉴 컴포넌트 객체 반환
- `e.getActionCommand()`: 메뉴 텍스트 반환

체크박스 메뉴(`JCheckBoxMenuItem`)나 라디오 메뉴(`JRadioButtonMenuItem`)는 `isSelected()` 메서드로 현재 상태를 확인할 수 있습니다.


