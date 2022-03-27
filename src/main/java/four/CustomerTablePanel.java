package four;

import javax.swing.*;
import java.awt.*;

public class CustomerTablePanel extends JPanel {

    private JTable customerTable;


    public CustomerTablePanel() {
        CustomerTableModel customerTableModel = new CustomerTableModel();
        this.customerTable = new JTable(customerTableModel);
        setupTable();
        JScrollPane scrollPane = new JScrollPane(customerTable);
        add(scrollPane);
    }
    private void setupTable(){
        this.customerTable.setPreferredSize(new Dimension(800,200));
        this.customerTable.setFillsViewportHeight(true);

    }
}
