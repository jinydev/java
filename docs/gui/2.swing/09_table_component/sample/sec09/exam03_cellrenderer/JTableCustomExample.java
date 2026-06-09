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
