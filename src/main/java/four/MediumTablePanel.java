package four;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class MediumTablePanel extends JPanel {
    private final JTable table = new JTable(new MyTableDataModel());

    public MediumTablePanel() {
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
}

