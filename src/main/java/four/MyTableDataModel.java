package four;

import javax.swing.table.AbstractTableModel;

    class MyTableDataModel extends AbstractTableModel {

        private final String [] columnName = {"Ime", "Prezime", "Sport", "Godine u sportu", "Vegetarijanac"};
        private final Object [][] data = {
                {"Sejo", "Bander", "Fudbal", Integer.valueOf(5), Boolean.valueOf(false)},
                {"Sejo2", "Bander2", "Kosarka", Integer.valueOf(4), Boolean.valueOf(true)},
                {"Sejo3", "Bander3", "Fudbal", Integer.valueOf(5), Boolean.valueOf(false)},
                {"Sejo4", "Bander4", "Kosarka", Integer.valueOf(4), Boolean.valueOf(true)}
        };

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnName.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex]=aValue;
            fireTableCellUpdated(rowIndex,columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex <=2){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0,columnIndex).getClass();
        }

        @Override
        public String getColumnName(int column) {
            return columnName [column];
        }
    }

