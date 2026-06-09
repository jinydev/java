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
