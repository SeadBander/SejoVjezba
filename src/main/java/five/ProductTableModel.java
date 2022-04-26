package five;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class ProductTableModel extends AbstractTableModel {

    private final ProductDao productDao = new ProductDao();
    private final Vector<String> columnNames = new Vector<>();
    private final Vector<Vector<Object>> rows = new Vector<>();

    public ProductTableModel() {
        columnNames.add("Product ID");
        columnNames.add("Name");
        columnNames.add("Quantity in stock");
        columnNames.add("Unit price");
        List<Product> productList = productDao.getAll();
        for(Product product: productList){
            Vector<Object> row = mapProductToVector(product);
            rows.add(row);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
    Class clas = getValueAt(0,columnIndex).getClass();
        return clas;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Vector<?> row =rows.get(rowIndex);
    Object valueAt = row.get(columnIndex);
        return valueAt;
    }

    public void updateSqlTableRow(int row){
        Vector<Object> rowVector = rows.get(row);
        Product product = mapRowToProduct(rowVector);
        productDao.update(product);
    }
    private Product mapRowToProduct(Vector<Object> row){
        return new Product();
    }

    private Vector<Object> mapProductToVector(Product product) {
        Vector<Object> row = new Vector<>();
        row.add(product.getProductId());
        row.add(product.getName());
        row.add(product.getQuantityInStock());
        row.add(product.getUnitPrice());
        return row;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Vector<Object>row =rows.get(rowIndex);
        row.set(rowIndex, aValue);
        fireTableCellUpdated(rowIndex,columnIndex);
    }
}
