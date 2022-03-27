package four;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class CustomerTableModel extends AbstractTableModel {
    private final Vector<String> columnNames = new Vector<>();
    private final Vector<Vector<Object>> data = new Vector<>();

    private final CustomerDao customerDao = new CustomerDao();

    public CustomerTableModel(){
        columnNames.add("ID");
        columnNames.add("First name");
        columnNames.add("Last name");
        columnNames.add("Birthdate");
        columnNames.add("Phone");
        columnNames.add("Address");
        columnNames.add("City");
        columnNames.add("State");
        columnNames.add("Points");

        try {
            List<Customer> customerList = customerDao.getAll();
            for (Customer customer : customerList){
                Vector<Object> row = new Vector<>();
                row.add(customer.getCustomerId());
                row.add(customer.getFirstName());
                row.add(customer.getLastname());
                row.add(customer.getBirthdate());
                row.add(customer.getPhone());
                row.add(customer.getAddress());
                row.add(customer.getCity());
                row.add(customer.getState());
                row.add(customer.getPoints());
                data.add(row);
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vector<Object> rowVector = data.get(rowIndex);
        Object cellValue = rowVector.get(columnIndex);
        return cellValue;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
}
