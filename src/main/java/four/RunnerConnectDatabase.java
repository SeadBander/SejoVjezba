package four;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class RunnerConnectDatabase {
    public static void main(String[] args) {

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
        //CustomerTablePanel panel = new CustomerTablePanel();
        MediumTablePanel panel = new MediumTablePanel();
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
