package five;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ProductTableListener implements TableModelListener {
    @Override
    public void tableChanged(TableModelEvent e) {
    int rowIndex = e.getFirstRow();
    ProductTableModel tableModel = (ProductTableModel) e.getSource();
    tableModel.updateSqlTableRow(rowIndex);
    }
}
