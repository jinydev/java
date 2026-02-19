---
layout: gui
title: "08. 리스트 컴포넌트"
---

# 08. 리스트 컴포넌트

리스트 컴포넌트는 여러 항목 중 하나 이상을 선택할 수 있는 UI 요소입니다. Swing에서는 `JList`와 `JComboBox`를 제공합니다.

- **JList**: 목록이 펼쳐져 있는 형태. 다중 선택 가능. 스크롤바 미포함(별도 추가 필요).
- **JComboBox**: 텍스트 필드와 화살표 버튼이 결합된 형태(콤보박스). 단일 선택만 가능.

---

## 1. JList
`JList`는 여러 항목을 보여주고 선택할 수 있게 합니다.

### 생성 방법
배열(`String[]`)이나 `Vector` 객체를 사용하여 생성할 수 있습니다.

```java
// 배열 사용
String[] items = { "One", "Two", "Three" };
JList jList = new JList(items);

// Vector 사용 (동적 추가/삭제 가능)
Vector<String> vectorItems = new Vector<>();
vectorItems.add("One");
vectorItems.add("Two");
JList jList = new JList(vectorItems);
```

### 주의사항
1. **스크롤바**: `JList`는 자체적으로 스크롤을 지원하지 않으므로, 항목이 많으면 `JScrollPane`에 넣어주어야 합니다.
   ```java
   JScrollPane scrollPane = new JScrollPane(jList);
   ```
2. **이미지 리스트**: 항목으로 `ImageIcon` 객체를 넣으면 이미지를 리스트로 보여줄 수 있습니다 (기본 셀 렌더러가 `JLabel` 기반).

### 이벤트 처리 (`ListSelectionListener`)
항목 선택 시 `ListSelectionEvent`가 발생합니다.
마우스 클릭 시 '누를 때'와 '뗐을 때' 두 번 이벤트가 발생할 수 있으므로, `getValueIsAdjusting()` 메서드로 구별해야 합니다.

```java
list.addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) { // 조정 중이 아닐 때(완전히 선택되었을 때)만 처리
        System.out.println("선택된 인덱스: " + list.getSelectedIndex());
        System.out.println("선택된 값: " + list.getSelectedValue());
    }
});
```

### JList 예제
좌측 리스트에서 과일 이름을 선택하면 우측에 해당 이미지를 보여주는 예제입니다.

```java
package sec08.exam01_jlist;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JListExample extends JFrame {
    private JPanel pWest;
    private JList<String> listString;
    private JList<ImageIcon> listImage;
    private JLabel jLabel;

    public JListExample() {
        this.setTitle("JListExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        
        this.getContentPane().add(getPWest(), BorderLayout.WEST);
        this.getContentPane().add(getJLabel(), BorderLayout.CENTER);
    }

    public JPanel getPWest() {
        if (pWest == null) {
            pWest = new JPanel(new GridLayout(2, 1));
            pWest.add(new JScrollPane(getListString()));
            pWest.add(new JScrollPane(getListImage()));
        }
        return pWest;
    }

    // 텍스트 리스트
    public JList<String> getListString() {
        if (listString == null) {
            String[] items = { 
                "Cantaloupe", "Grapefruit", "Grapes", "Kiwi", "Peach", 
                "pineapple", "strawberry", "tomato", "watermelon" 
            };
            listString = new JList<>(items);
            
            listString.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int index = listString.getSelectedIndex();
                    // fruit1.jpg ~ fruit9.jpg 로 가정
                    String imgName = "fruit" + (index + 1) + ".jpg";
                    ImageIcon image = new ImageIcon(getClass().getResource(imgName));
                    getJLabel().setIcon(image);
                }
            });
        }
        return listString;
    }

    // 이미지 리스트
    public JList<ImageIcon> getListImage() {
        if (listImage == null) {
            Vector<ImageIcon> items = new Vector<>();
            for (int i = 1; i < 10; i++) {
                items.add(new ImageIcon(getClass().getResource("fruit" + i + ".jpg")));
            }
            listImage = new JList<>(items);
            
            listImage.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    ImageIcon image = listImage.getSelectedValue();
                    getJLabel().setIcon(image);
                }
            });
        }
        return listImage;
    }

    public JLabel getJLabel() {
        if (jLabel == null) {
            jLabel = new JLabel();
            jLabel.setHorizontalAlignment(JLabel.CENTER);
        }
        return jLabel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JListExample jFrame = new JListExample();
            jFrame.setVisible(true);
        });
    }
}
```

---

## 2. JComboBox
`JComboBox`는 공간을 절약하면서 여러 항목 중 하나를 선택받을 때 사용합니다. 스크롤바는 항목이 많을 때 자동으로 생성됩니다.

### 이벤트 처리
- `ActionListener`: 항목 선택 시 발생.
- `ItemListener`: 항목 선택/해제 상태 변경 시 발생.

주로 `ActionListener`를 사용하여 처리합니다.

```java
comboBox.addActionListener(e -> {
    JComboBox cb = (JComboBox)e.getSource();
    System.out.println("선택된 인덱스: " + cb.getSelectedIndex());
    System.out.println("선택된 값: " + cb.getSelectedItem());
});
```

### JComboBox 예제
상단의 콤보박스에서 과일을 선택하면 하단에 이미지를 표시하는 예제입니다.

```java
package sec08.exam02_jcombobox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JComboBoxExample extends JFrame {
    private JPanel pNorth;
    private JComboBox<String> comboString;
    private JComboBox<ImageIcon> comboImage;
    private JLabel jLabel;

    public JComboBoxExample() {
        this.setTitle("JComboBoxExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.getContentPane().setBackground(Color.WHITE);
        
        this.getContentPane().add(getPNorth(), BorderLayout.NORTH);
        this.getContentPane().add(getJLabel(), BorderLayout.CENTER);
    }

    public JPanel getPNorth() {
        if (pNorth == null) {
            pNorth = new JPanel();
            pNorth.setBackground(Color.WHITE);
            pNorth.add(getComboString());
            pNorth.add(getComboImage());
        }
        return pNorth;
    }

    // 텍스트 콤보박스
    public JComboBox<String> getComboString() {
        if (comboString == null) {
            String[] items = { 
                "Cantaloupe", "Grapefruit", "Grapes", "Kiwi", "Peach", 
                "pineapple", "strawberry", "tomato", "watermelon" 
            };
            comboString = new JComboBox<>(items);
            comboString.setBackground(Color.WHITE);
            comboString.addActionListener(e -> {
                int index = comboString.getSelectedIndex();
                String imgName = "fruit" + (index + 1) + ".jpg";
                getJLabel().setIcon(new ImageIcon(getClass().getResource(imgName)));
            });
        }
        return comboString;
    }

    // 이미지 콤보박스
    public JComboBox<ImageIcon> getComboImage() {
        if (comboImage == null) {
            Vector<ImageIcon> vImage = new Vector<>();
            for (int i = 1; i < 10; i++) {
                vImage.add(new ImageIcon(getClass().getResource("fruit" + i + ".jpg")));
            }
            comboImage = new JComboBox<>(vImage);
            comboImage.setBackground(Color.WHITE);
            comboImage.addActionListener(e -> {
                ImageIcon image = (ImageIcon) comboImage.getSelectedItem();
                getJLabel().setIcon(image);
            });
        }
        return comboImage;
    }

    public JLabel getJLabel() {
        if (jLabel == null) {
            jLabel = new JLabel();
            jLabel.setHorizontalAlignment(JLabel.CENTER);
        }
        return jLabel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JComboBoxExample jFrame = new JComboBoxExample();
            jFrame.setVisible(true);
        });
    }
}
```
