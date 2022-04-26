package four;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class MediumTablePanel extends JPanel {

    private final JTextField nameTextField;
    private final TableRowSorter<MyTableDataModel> tableRowSorter;

    private final JTable table;

    public MediumTablePanel() {
        JPanel formPanel = new JPanel(new GridLayout(1,1));
        formPanel.setSize(200,300);
        JLabel searchLable = new JLabel("Filter by name", SwingConstants.TRAILING);
        formPanel.add(searchLable);
        this.nameTextField = new JTextField();
        this.nameTextField.getDocument().addDocumentListener(new MyDocumentListener());
        searchLable.setLabelFor(nameTextField);
        formPanel.add(nameTextField);
        add(formPanel);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        MyTableDataModel tableDataModel = new MyTableDataModel();
        this.tableRowSorter = new TableRowSorter<>(tableDataModel);
        this.table = new JTable(tableDataModel);
        this.table.setRowSorter(tableRowSorter);
        setupTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
    private void setupTable(){
    this.table.setPreferredSize(new Dimension(500,200));
    this.table.setFillsViewportHeight(true);
    this.table.getSelectionModel().addListSelectionListener(new RowListner());
    this.table.getColumnModel().getSelectionModel().addListSelectionListener(new ColumnListner());

    }



    private class RowListner implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Selektovan red");
        }
    }

    private class ColumnListner implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Selektovana kolona");
        }
    }

    private class MyDocumentListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            filter();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filter();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filter();
        }
        private void filter(){
            String nameText = nameTextField.getText();
            RowFilter<MyTableDataModel, Object> rowFilter = RowFilter.regexFilter(nameText, 2);
            tableRowSorter.setRowFilter(rowFilter);
        }
    }
}

