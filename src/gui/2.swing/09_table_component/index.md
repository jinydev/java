---
layout: gui
title: "09. 테이블 컴포넌트"
---

# 09. 테이블 컴포넌트

`JTable`은 데이터를 행(Row)과 열(Column)로 구성된 표 형식으로 보여주고 편집할 수 있는 강력한 컴포넌트입니다.

## 1. JTable 구조
테이블은 **컬럼 헤더(Column Header)**, **행(Row)**, **셀(Cell)**로 구성됩니다.
- **컬럼(Column)**: 열. 각 컬럼은 동일한 데이터 타입을 가집니다.
- **행(Row)**: 가로 줄.
- **셀(Cell)**: 행과 열이 만나는 데이터 표시 단위.

## 2. 기본 생성 방법
가장 간단한 생성 방법은 컬럼 이름 배열(`String[]`)과 데이터 배열(`Object[][]`)을 사용하는 것입니다.

```java
String[] columnNames = { "이름", "나이" };
Object[][] rowData = {
    { "춘삼월", 25 },
    { "하여름", 23 },
    { "하바다", 26 }
};
JTable table = new JTable(rowData, columnNames);
```

### 주의사항
- `JTable`은 스크롤을 자동으로 지원하지 않으므로 **`JScrollPane`**에 넣어서 사용해야 합니다.
- 컬럼 폭 조절: `table.getColumn("이름").setPreferredWidth(100);`

---

## 3. 예제: 기본 JTable

```java
package sec09.exam01_jtable;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class JTableBasicExample extends JFrame {
    private JTable jTable;

    public JTableBasicExample() {
        this.setTitle("JTableBasicExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        
        // JScrollPane에 JTable 추가
        this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
    }

    public JTable getJTable() {
        if(jTable == null) {
            String[] columnNames = { "이름", "나이" };
            Object[][] rowData = {
                { "춘삼월", 25 },
                { "하여름", 23 },
                { "하바다", 26 },
                { "추가을", 22 },
                { "동겨울", 27 },
                { "동장군", 15 }
            };
            jTable = new JTable(rowData, columnNames);
            
            // 컬럼 폭 설정
            jTable.getColumn("이름").setPreferredWidth(100);
            jTable.getColumn("나이").setPreferredWidth(50);
        }
        return jTable;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTableBasicExample jFrame = new JTableBasicExample();
            jFrame.setVisible(true);
        });
    }
}
```

---

## 4. TableModel
`JTable`은 데이터 관리를 위해 `TableModel`을 사용합니다. `getModel()` 메서드로 모델을 얻을 수 있습니다.

### 주요 메서드 (`TableModel`)
| 메서드                                          | 설명                         |
| :---------------------------------------------- | :--------------------------- |
| `int getColumnCount()`                          | 전체 컬럼 수 반환            |
| `String getColumnName(int col)`                 | 해당 인덱스의 컬럼 이름 반환 |
| `int getRowCount()`                             | 전체 행 수 반환              |
| `Object getValueAt(int row, int col)`           | 해당 셀의 데이터 반환        |
| `void setValueAt(Object val, int row, int col)` | 해당 셀의 데이터 변경        |

데이터의 동적 추가/삭제가 필요하다면 `DefaultTableModel`을 사용하는 것이 좋습니다.
- `addRow(Object[] data)`: 행 추가
- `removeRow(int row)`: 행 삭제

---

## 5. 예제: TableModel 사용 및 셀 렌더러

### 셀 렌더러 (Cell Renderer)
기본적으로 텍스트로 표시되지만, 이미지나 체크박스 등 다른 컴포넌트로 셀을 표시하고 싶을 때 사용합니다. `TableCellRenderer` 인터페이스를 구현해야 합니다.

```java
// 예: 조건에 따라 아이콘을 다르게 표시하는 렌더러
public class MyCellRenderer extends JLabel implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        // ... 컴포넌트 설정 (this 반환)
        return this;
    }
}
```

### 종합 예제 Code (`JTableCellRendererExample`)

```java
package sec09.exam03_cellrenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class JTableCustomExample extends JFrame {
    private JTable jTable;

    public JTableCustomExample() {
        this.setTitle("JTableCustomExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
    }

    public JTable getJTable() {
        if (jTable == null) {
            String[] columnNames = { "이름", "나이", "선택" };
            Object[][] rowData = {
                { "춘삼월", 25, false },
                { "하여름", 26, true },
                { "추가을", 22, false },
                { "동겨울", 27, true }
            };
            
            // 데이터 수정이 용이한 DefaultTableModel 사용
            DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
            jTable = new JTable(model);

            // 1. 이름 컬럼 렌더러 (중앙 정렬 + 노란 배경 선택)
            jTable.getColumn("이름").setCellRenderer(new DefaultRenderer());
            
            // 2. 나이 컬럼 렌더러 (조건부 아이콘 표시)
            jTable.getColumn("나이").setCellRenderer(new AgeRenderer());
            
            // 3. 선택 컬럼 렌더러 (체크박스)
            jTable.getColumn("선택").setCellRenderer(new CheckBoxRenderer());

            // 마우스 클릭 이벤트
            jTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = jTable.getSelectedRow();
                    int col = jTable.getSelectedColumn();
                    if (row != -1 && col != -1) {
                        Object value = jTable.getValueAt(row, col);
                        System.out.println("선택된 값(" + row + "," + col + "): " + value);
                    }
                }
            });
        }
        return jTable;
    }

    // 기본 렌더러 (중앙 정렬)
    class DefaultRenderer extends JLabel implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            setHorizontalAlignment(JLabel.CENTER);
            setOpaque(true);
            setBackground(isSelected ? Color.YELLOW : Color.WHITE);
            return this;
        }
    }

    // 나이 렌더러
    class AgeRenderer extends JLabel implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            int age = (Integer) value;
            if (age <= 25) {
                setIcon(new ImageIcon(getClass().getResource("key.gif")));
            } else {
                setIcon(new ImageIcon(getClass().getResource("start.gif")));
            }
            setText(value.toString());
            setHorizontalAlignment(JLabel.CENTER);
            setOpaque(true);
            setBackground(isSelected ? Color.YELLOW : Color.WHITE);
            return this;
        }
    }

    // 체크박스 렌더러
    class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setSelected((Boolean) value);
            setHorizontalAlignment(CENTER);
            setBackground(isSelected ? Color.YELLOW : Color.WHITE);
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTableCustomExample jFrame = new JTableCustomExample();
            jFrame.setVisible(true);
        });
    }
}
```


---

## 6. 행 추가, 수정, 삭제 (CRUD)
`DefaultTableModel`을 사용하면 행을 동적으로 제어할 수 있습니다.

- `addRow(Object[])` / `addRow(Vector)`: 행 추가
- `insertRow(int index, ...)`: 특정 위치에 삽입
- `removeRow(int index)`: 특정 행 삭제
- `fireTableDataChanged()`: 데이터 변경 통지 (일반적으로 `setDataVector` 등을 쓸 때 필요하지만, `DefaultTableModel` 메서드들은 자동 통지됨)

### CRUD 예제 Code (`JTableEditorExample`)
사용자 입력을 받아 테이블에 행을 추가, 수정, 삭제하는 예제입니다.

```java
package sec09.exam04_eventhandling;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class JTableEditorExample extends JFrame {
    private JTable jTable;
    private JTextField txtName, txtAge;
    
    public JTableEditorExample() {
        this.setTitle("JTableEditorExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        
        this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
        this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
    }

    public JTable getJTable() {
        if(jTable == null) {
            String[] columnNames = {"이름", "나이"};
            Object[][] rowData = {}; // 초기 데이터 없음
            
            // 데이터 조작을 위해 DefaultTableModel 사용
            DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
            jTable = new JTable(model);

            // 마우스 클릭 시 데이터 텍스트필드에 바인딩
            jTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = jTable.getSelectedRow();
                    if(row != -1) {
                        String name = (String) jTable.getValueAt(row, 0);
                        String age = (String) jTable.getValueAt(row, 1);
                        txtName.setText(name);
                        txtAge.setText(age);
                    }
                }
            });
        }
        return jTable;
    }

    public JPanel getPSouth() {
        JPanel pSouth = new JPanel(new GridLayout(3, 1));
        
        // 입력 패널
        JPanel pInput = new JPanel(new GridLayout(1, 4));
        pInput.add(new JLabel("이름", JLabel.CENTER));
        txtName = new JTextField();
        pInput.add(txtName);
        pInput.add(new JLabel("나이", JLabel.CENTER));
        txtAge = new JTextField();
        pInput.add(txtAge);
        pSouth.add(pInput);

        // 버튼 패널
        JPanel pBtn = new JPanel();
        
        // 추가 버튼
        JButton btnAdd = new JButton("추가");
        btnAdd.addActionListener(e -> {
            String[] data = { txtName.getText(), txtAge.getText() };
            ((DefaultTableModel) jTable.getModel()).addRow(data);
            clearFields();
        });
        pBtn.add(btnAdd);

        // 수정 버튼
        JButton btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(e -> {
            int row = jTable.getSelectedRow();
            if (row != -1) {
                jTable.setValueAt(txtName.getText(), row, 0);
                jTable.setValueAt(txtAge.getText(), row, 1);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "수정할 행을 선택하세요.");
            }
        });
        pBtn.add(btnUpdate);

        // 삭제 버튼
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(e -> {
            int row = jTable.getSelectedRow();
            if (row != -1) {
                ((DefaultTableModel) jTable.getModel()).removeRow(row);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요.");
            }
        });
        pBtn.add(btnDelete);

        pSouth.add(pBtn);
        return pSouth;
    }

    private void clearFields() {
        txtName.setText("");
        txtAge.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTableEditorExample jFrame = new JTableEditorExample();
            jFrame.setVisible(true);
        });
    }
}
```



Vector(전체 행 관리)
|-- Vector(0 인덱스 행 데이터)
|-- Vector(1 인덱스 행 데이터)
|-- ...

DefaultTableModel에서 전체 행을 관리하는 Vector는 getDataVector ( ) 메소드로 얻을 수

있습니다.

Vector<Vector> rows  =  tableModel.getDataVector();

그리고 각 행의 Vector는 행 인덱스를 주고 다음과 같이 얻을 수 있습니다.

Vector row  =  rows.elementAt(행인덱스);

행 Vector의 내부 요소를 변경하기 위해서는 Vector의 set ( ) 메소드를 이용하면 되는데, 첫 번째

매개값은 컬럼의 인덱스 번호이고, 두 번째 매개값은 컬럼의 값입니다.

row.set(0, changeValue);    //0번 컬럼의 값을 changeValue로 수정
row.set(1, changeValue);    //1번 컬럼의 값을 changeValue로 수정

행  Vector를  이용해서  행의  데이터를  수정하였다면  JTable을  다시  렌더링할  수  있도록

DefaultTableModel의 fireTableDataChanged ( ) 메소드를 호출해야 합니다.

tableModel.fireTableDataChanged();

다음 예제는 사용자가 입력한 내용을 JTable의 행으로 넣는다. 그리고 선택된 행의 데이터를 수정

하고 삭제할 수 있습니다.



>>> JTableExample.java



```java
package sec09.exam05_row_add_update_delete;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class JTableExample extends JFrame {
private JTable jTable;
private JPanel pSouth;
private JTextField txtName, txtAge;
private JButton btnInsert, btnUpdate, btnDelete;
```

//메인 윈도우 설정
public JTableExample() {
this.setTitle("JTableExample");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.getContentPane().add(new JScrollPane(getJTable()),
BorderLayout.CENTER);
this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
this.setSize(250, 250);

}

//JTable 생성
public JTable getJTable() {
if (jTable  = =  null) {




jTable  =  new JTable();
final DefaultTableModel tableModel  =  (DefaultTableModel)
jTable.getModel();
tableModel.addColumn("이름");
tableModel.addColumn("나이");
//행을 선택했을 때 이벤트 처리
jTable.addMouseListener(new MouseAdapter() {
```java
public void mouseClicked(MouseEvent e) {
int rowIndex  =  jTable.getSelectedRow();
if (rowIndex !=  -1) {
String name  =  (String) tableModel.getValueAt(rowIndex, 0);
String age  =  (String) tableModel.getValueAt(rowIndex, 1);
txtName.setText(name);
txtAge.setText(age.toString());

}

}

});

}
return jTable;

}
```

//사용자 입력 JPanel 생성
public JPanel getPSouth() {
if (pSouth  = =  null) {
pSouth  =  new JPanel();

pSouth.setLayout(new GridLayout(3, 1));

JPanel pNameInput  =  new JPanel();
pNameInput.setLayout(new GridLayout(1, 2));
pNameInput.add(new JLabel("이름", JLabel.CENTER));
pNameInput.add(getTxtName());
pSouth.add(pNameInput);

JPanel pAgeInput  =  new JPanel();
pAgeInput.setLayout(new GridLayout(1, 2));
pAgeInput.add(new JLabel("나이", JLabel.CENTER));
pAgeInput.add(getTxtAge());
pSouth.add(pAgeInput);








JPanel pButton  =  new JPanel();
pButton.add(getBtnInsert());
pButton.add(getBtnUpdate());
pButton.add(getBtnDelete());
pSouth.add(pButton);

}
return pSouth;

}

public JTextField getTxtName() {
if (txtName  = =  null) {
txtName  =  new JTextField();

}
return txtName;

}

public JTextField getTxtAge() {
if (txtAge  = =  null) {
txtAge  =  new JTextField();

}
return txtAge;

}

//행 삽입 버튼 생성
public JButton getBtnInsert() {
if (btnInsert  = =  null) {
btnInsert  =  new JButton();
btnInsert.setText("추가");
btnInsert.addActionListener(new ActionListener() {
```java
public void actionPerformed(ActionEvent e) {
Object[] rowData  =  { txtName.getText(), txtAge.getText() };
DefaultTableModel tableModel  =  (DefaultTableModel)
getJTable().getModel();
tableModel.addRow(rowData);
txtName.setText("");
txtAge.setText("");

}

});

}
return btnInsert;







}
```

//행 수정 버튼 생성
public JButton getBtnUpdate() {
if (btnUpdate  = =  null) {
btnUpdate  =  new JButton();
btnUpdate.setText("수정");
btnUpdate.addActionListener(new ActionListener() {
```java
public void actionPerformed(ActionEvent e) {
DefaultTableModel tableModel  =  (DefaultTableModel)
getJTable().getModel();
Vector<Vector> rows  =  tableModel.getDataVector();
Vector row  =  rows.elementAt(jTable.getSelectedRow());
row.set(0, txtName.getText());
row.set(1, txtAge.getText());
tableModel.fireTableDataChanged();
txtName.setText("");
txtAge.setText("");

}

});

}
return btnUpdate;

}
```

//행 삭제 버튼 생성
public JButton getBtnDelete() {
if (btnDelete  = =  null) {
btnDelete  =  new JButton();
btnDelete.setText("삭제");
btnDelete.addActionListener(new ActionListener() {
```java
public void actionPerformed(ActionEvent e) {
int rowIndex  =  getJTable().getSelectedRow();
if (rowIndex !=  -1) {
DefaultTableModel tableModel  =  (DefaultTableModel)
getJTable().getModel();
tableModel.removeRow(rowIndex);
txtName.setText("");
txtAge.setText("");

}

}





});

}
return btnDelete;

}

public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
JTableExample jFrame  =  new JTableExample();
jFrame.setVisible(true);

}

});

}

}

```

실행 결과

