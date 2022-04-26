package five;

import javax.swing.*;

public class RunerProduct {
    public static void main(String[] args) {
        Runnable runnable = RunerProduct::createAndShowGui;
        SwingUtilities.invokeLater(runnable);
    }

    private static void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.setTitle("Table GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new ProductTablePanel();
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
