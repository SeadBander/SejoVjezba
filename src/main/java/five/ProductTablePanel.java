package five;

import javax.swing.*;
import java.awt.*;

public class ProductTablePanel extends JPanel {
    private JTable productJTable;

    public ProductTablePanel(){
        ProductTableModel productTableModel= new ProductTableModel();
        ProductTableListener productTableListener = new ProductTableListener();
        productTableModel.addTableModelListener(productTableListener);
        this.productJTable = new JTable(productTableModel);
        setupTable();
        JScrollPane scrollPane = new JScrollPane(productJTable);
        add(scrollPane);
    }
    private void setupTable() {
        this.productJTable.setPreferredSize(new Dimension(800, 800));
        this.productJTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.productJTable.setFillsViewportHeight(true);
    }
}
