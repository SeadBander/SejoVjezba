package four;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class CustomerTableModel extends AbstractTableModel {
    private final Vector<String> columnNames;
    private final Vector<Vector<Object>> data = new Vector<>();

    private final CustomerDao customerDao = new CustomerDao();


    public CustomerTableModel(){
        columnNames = customerDao.getColumnNames()
                .stream()
                .collect(Collectors.toCollection(Vector::new));

        System.out.println();
            for (Customer customer : customerDao.getAll()){
                Vector<Object> row = mapCustomerToVector(customer);
                data.add(row);
            }
        }


    private Vector<Object> mapCustomerToVector (Customer customer){
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
        return row;
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Vector<Object> row = data.get(rowIndex);
        row.set(rowIndex, aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clas =getValueAt(0, columnIndex).getClass();
        return clas;

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }

    private Vector<Object> getRawData(int rowIndex) {
        return data.get(rowIndex);
    }

    public void updateSqlRow(int rowIndex) {
        Vector<Object> rowVector = getRawData(rowIndex);
        Customer customer = toCustomer(rowVector);
        customerDao.update(customer);
    }

        private Customer toCustomer(Vector<Object> row) {
        Customer customer = new Customer();
        Integer customerId = (Integer) row.get(0);
        String firstName = (String) row.get(1);
        String lastName = (String) row.get(2);
        LocalDate birthdate = (LocalDate) row.get(3);
        String phone = (String) row.get(4);
        String address = (String) row.get(5);
        String city = (String) row.get(6);
        String state = (String) row.get(7);
        Integer points = (Integer) row.get(8);
        customer.setCustomerId(customerId);
        customer.setFirstName(firstName);
        customer.setLastname(lastName);
        customer.setBirthdate(birthdate);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setState(state);
        customer.setPoints(points);
        return customer;
    }


}
