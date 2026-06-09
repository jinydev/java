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
