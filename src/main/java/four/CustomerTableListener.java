package four;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.sql.SQLException;

public class CustomerTableListener implements TableModelListener {

    @Override
    public void tableChanged(TableModelEvent e) {
        int rowIndex = e.getFirstRow();
        CustomerTableModel tableModel = (CustomerTableModel) e.getSource();
       tableModel.updateSqlRow(rowIndex);
    }
}
