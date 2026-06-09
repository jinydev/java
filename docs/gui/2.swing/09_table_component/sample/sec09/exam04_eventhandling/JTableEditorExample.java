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
