package four;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablePanel extends JPanel {

    final String [] imeKolona = {"Ime", "Prezime", "Sport", "Godine u sportu", "Vegetarijanac"};
    Object [][] data = {
            {"Sejo", "Bander", "Fudbal", Integer.valueOf(5), Boolean.valueOf(false)},
            {"Sejo2", "Bander2", "Kosarka", Integer.valueOf(4), Boolean.valueOf(true)},
            {"Sejo3", "Bander3", "Fudbal", Integer.valueOf(5), Boolean.valueOf(false)},
            {"Sejo4", "Bander4", "Kosarka", Integer.valueOf(4), Boolean.valueOf(true)}
    };

    private final JTable table = new JTable(data, imeKolona);

    public TablePanel() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                printTabeleData(e);
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
    private void printTabeleData (MouseEvent mouseEvent){
        int rowNumber = table.getRowCount();
        int columnNumber = table.getColumnCount();
        TableModel tableModel = table.getModel();
        for (int i=0; i<rowNumber; i++){
            for (int j=0; j<columnNumber; j++){
                System.out.print(""+tableModel.getValueAt(i,j));
            }
            System.out.println();
        }

    }
}
