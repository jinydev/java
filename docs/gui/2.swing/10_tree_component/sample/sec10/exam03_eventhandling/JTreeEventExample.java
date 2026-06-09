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
