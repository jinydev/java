---
layout: gui
title: "10. 트리 컴포넌트"
---

# 10. 트리 컴포넌트

`JTree`는 데이터를 계층적(Hierarchical)인 트리 구조로 표시하는 컴포넌트입니다.

## 1. 트리 구조
- **루트 노드(Root Node)**: 최상위 노드. 하나만 존재.
- **부모 노드(Parent Node)**: 자식 노드를 가지는 노드.
- **자식 노드(Child Node)**: 부모 노드 아래에 있는 노드.
- **리프 노드(Leaf Node)**: 자식 노드가 없는 말단 노드.

---

## 2. 기본 생성 방법
`JTree`는 `DefaultMutableTreeNode`를 사용하여 노드 구조를 만든 후 생성자에 전달합니다.

```java
DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
DefaultMutableTreeNode parent = new DefaultMutableTreeNode("Parent");
DefaultMutableTreeNode child = new DefaultMutableTreeNode("Child");

parent.add(child); // 부모에 자식 추가
root.add(parent);  // 루트에 부모 추가

JTree jTree = new JTree(root);
```

### 예제: 기본 JTree (`JTreeBasicExample`)

```java
package sec10.exam01_jtree;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeBasicExample extends JFrame {
    private JTree jTree;

    public JTreeBasicExample() {
        this.setTitle("JTreeBasicExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        
        this.getContentPane().add(new JScrollPane(getJTree()), BorderLayout.CENTER);
    }

    public JTree getJTree() {
        if (jTree == null) {
            // 1. 루트 노드 생성
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("그룹리스트");
            
            // 2. 자식 노드 생성 및 추가
            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("친구");
            node1.add(new DefaultMutableTreeNode("친구1"));
            node1.add(new DefaultMutableTreeNode("친구2"));
            root.add(node1);
            
            DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("회사동료");
            node2.add(new DefaultMutableTreeNode("동료1"));
            node2.add(new DefaultMutableTreeNode("동료2"));
            root.add(node2);
            
            // 3. JTree 생성
            jTree = new JTree(root);
        }
        return jTree;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTreeBasicExample jFrame = new JTreeBasicExample();
            jFrame.setVisible(true);
        });
    }
}
```

---

## 3. 노드 렌더러 (TreeCellRenderer)
노드의 아이콘이나 텍스트 스타일을 변경하려면 `TreeCellRenderer`를 구현해야 합니다. 기본적으로 `DefaultTreeCellRenderer`가 사용됩니다.

- `getTreeCellRendererComponent(...)`: 노드가 그려질 때 호출되어 해당 노드를 표현할 컴포넌트를 반환합니다.

### 렌더러 예제 Code (`JTreeCellRendererExample`)
이 예제는 리프 노드와 부모 노드의 아이콘을 다르게 설정하고, 선택 시 배경색을 변경합니다.

```java
package sec10.exam02_cellrenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class JTreeCustomRendererExample extends JFrame {
    private JTree jTree;

    public JTreeCustomRendererExample() {
        this.setTitle("JTreeCustomRendererExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.getContentPane().add(new JScrollPane(getJTree()), BorderLayout.CENTER);
    }

    public JTree getJTree() {
        if (jTree == null) {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("그룹리스트");
            
            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("친구");
            node1.add(new DefaultMutableTreeNode("친구1"));
            node1.add(new DefaultMutableTreeNode("친구2"));
            root.add(node1);
            
            DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("회사동료");
            node2.add(new DefaultMutableTreeNode("동료1"));
            node2.add(new DefaultMutableTreeNode("동료2"));
            root.add(node2);
            
            jTree = new JTree(root);
            // 커스텀 셀 렌더러 설정
            jTree.setCellRenderer(new MyTreeCellRenderer());
        }
        return jTree;
    }

    // 커스텀 렌더러 내부 클래스
    class MyTreeCellRenderer implements TreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(
                JTree tree, Object value, boolean sel, boolean expanded,
                boolean leaf, int row, boolean hasFocus) {
            
            if (!leaf) {
                // 부모 노드인 경우
                JLabel jLabel = new JLabel();
                jLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
                jLabel.setIcon(new ImageIcon(getClass().getResource("parentnode.gif")));
                jLabel.setText(value.toString());
                return jLabel;
            } else {
                // 리프 노드인 경우 (JPanel로 복합 구성)
                JPanel jPanel = new JPanel(new BorderLayout());
                jPanel.setBackground(sel ? Color.ORANGE : Color.WHITE);
                jPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
                
                JLabel lblWest = new JLabel(new ImageIcon(getClass().getResource("logon.gif")));
                JLabel lblCenter = new JLabel("  " + value.toString() + "  ");
                JLabel lblEast = new JLabel(new ImageIcon(getClass().getResource("time.gif")));
                
                jPanel.add(lblWest, BorderLayout.WEST);
                jPanel.add(lblCenter, BorderLayout.CENTER);
                jPanel.add(lblEast, BorderLayout.EAST);
                
                return jPanel;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTreeCustomRendererExample jFrame = new JTreeCustomRendererExample();
            jFrame.setVisible(true);
        });
    }
}
```

---

## 4. 이벤트 처리
- **`TreeSelectionListener`**: 노드 선택 변경 시 발생. (`getPath()`, `getLastPathComponent()` 사용)
- **`MouseListener`**: 더블 클릭 등 마우스 동작 감지. (`getPathForLocation()` 사용)

### 이벤트 처리 예제 (`JTreeEventExample`)

```java
package sec10.exam03_eventhandling;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class JTreeEventExample extends JFrame {
    private JTree jTree;

    public JTreeEventExample() {
        this.setTitle("JTreeEventExample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.getContentPane().add(new JScrollPane(getJTree()), BorderLayout.CENTER);
    }

    public JTree getJTree() {
        if (jTree == null) {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("그룹리스트");
            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("친구");
            node1.add(new DefaultMutableTreeNode("친구1"));
            node1.add(new DefaultMutableTreeNode("친구2"));
            root.add(node1);
            
            jTree = new JTree(root);
            
            // 1. 선택 이벤트 리스너
            jTree.addTreeSelectionListener(e -> {
                TreePath treePath = e.getPath();
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                String nodeText = (String) node.getUserObject();
                System.out.println("선택 변경됨: " + nodeText);
            });
            
            // 2. 마우스 리스너 (더블 클릭)
            jTree.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        TreePath treePath = jTree.getPathForLocation(e.getX(), e.getY());
                        if (treePath != null) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                            String nodeText = (String) node.getUserObject();
                            JOptionPane.showMessageDialog(JTreeEventExample.this, "더블 클릭: " + nodeText);
                        }
                    }
                }
            });
        }
        return jTree;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTreeEventExample jFrame = new JTreeEventExample();
            jFrame.setVisible(true);
        });
    }
}
```


