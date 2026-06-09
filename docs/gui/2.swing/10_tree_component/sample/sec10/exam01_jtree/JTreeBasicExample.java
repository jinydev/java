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
