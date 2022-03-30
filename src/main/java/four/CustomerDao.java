package four;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Customer>{
    @Override
    public void save(Customer entity) {

    }

    @Override
    public void update(Customer entity)  {
        String sql = "UPDATE customers SET first_name=?,last_name=? WHERE customer_id=?";
        Connection connection = ConnectionPool.getInstance().getConneciton();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println("Prije ažuriranja: " + entity);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastname());
            preparedStatement.setInt(3, entity.getCustomerId());
            int numberAffectedRows = preparedStatement.executeUpdate();
            System.out.println("Broj ažuriranih redova: " + numberAffectedRows);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        ConnectionPool.getInstance().releaseConnection(connection);
    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public Customer get(Integer primarykey) {
        String sql = "SELECT * FROM customers WHERE customer_id=?";
        Connection connection = ConnectionPool.getInstance().getConneciton();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primarykey);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();
            while (resultSet.next()) {
                customer.setCustomerId(resultSet.getInt(1));
                customer.setFirstName(resultSet.getString(2));
                customer.setLastname(resultSet.getString(3));
                customer.setBirthdate(resultSet.getDate(4).toLocalDate());
                customer.setPhone(resultSet.getString(5));
                customer.setAddress(resultSet.getString(6));
                customer.setCity(resultSet.getString(7));
                customer.setState(resultSet.getString(8));
                customer.setPoints(resultSet.getInt(9));
            }
            ConnectionPool.getInstance().releaseConnection(connection);
            return customer;
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getCause());
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        Connection connection = ConnectionPool.getInstance().getConneciton();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getInt(1));
            customer.setFirstName(resultSet.getString(2));
            customer.setLastname(resultSet.getString(3));
            customer.setBirthdate(resultSet.getDate(4).toLocalDate());
            customer.setPhone(resultSet.getString(5));
            customer.setAddress(resultSet.getString(6));
            customer.setCity(resultSet.getString(7));
            customer.setState(resultSet.getString(8));
            customer.setPoints(resultSet.getInt(9));
            customers.add(customer);

            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        ConnectionPool.getInstance().releaseConnection(connection);
        return customers;
    }

    public List<String> getColumnNames(){
        String sqlQuery = "SELECT * FROM customers";
        Connection connection = ConnectionPool.getInstance().getConneciton();
        try (PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery)){
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnNumber = resultSetMetaData.getColumnCount();
            List<String> columnNames = new ArrayList<>(columnNumber);
            for (int i = 1; i<=columnNumber; i++){
                String columnName = resultSetMetaData.getColumnName(i);
                columnNames.add(columnName);
            }
            return columnNames;

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

}
