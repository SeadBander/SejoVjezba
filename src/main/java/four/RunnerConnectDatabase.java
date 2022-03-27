package four;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class RunnerConnectDatabase {
    public static void main(String[] args) throws SQLException {

        /*CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();
        for (Customer customer : customers){
            System.out.println(customer);
        }*/


        Runnable runnable = RunnerConnectDatabase::createAndShowGui;
        SwingUtilities.invokeLater(runnable);
    }
    private static void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.setTitle("Table GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CustomerTablePanel panel = new CustomerTablePanel();
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
