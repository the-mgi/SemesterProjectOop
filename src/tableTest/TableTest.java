package tableTest;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TableTest extends JFrame {

    public TableTest() throws IOException {
        super.setTitle("JTable Model");
        super.setSize(600, 500);
        super.setLayout(new BorderLayout());


        JTable table = new JTable(1, 1);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        File file = new File("E:\\Songs\\Mobile Songs");
        File[] getFiles = file.listFiles();
        assert getFiles != null;
        Object[] rowData = new Object[1];
        for (int i = 0; i < getFiles.length; i++) {
            rowData[0] = getFiles[i].getName();
            tableModel.addRow(rowData);
        }

        JScrollPane pane = new JScrollPane(table);

        super.add(pane, BorderLayout.CENTER);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new TableTest();
    }
}
