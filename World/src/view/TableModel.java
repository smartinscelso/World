
package view;

import com.mysql.jdbc.RowData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author junio
 */
public class TableModel extends DefaultTableModel {
    public static final String[] COLUMN_NAMES = {"Code", "Name", "Continent", "Surface Area", "Head of State"};

    public TableModel() {
        super(COLUMN_NAMES, 0);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getRowCount() > 0 && getValueAt(0, columnIndex) != null) {
            return getValueAt(0, columnIndex).getClass();
        }
        return super.getColumnClass(columnIndex);
    }


    public void addRow(RowData rowData) {
        if (rowData == null) {
            throw new IllegalArgumentException("rowData cannot be null");
        }
        Vector<Object> rowVector;
        rowVector = new Vector<>();
        rowVector.add(rowData.getCode());
        rowVector.add(rowData.getCc());
        rowVector.add(rowData.getAge());
        rowVector.add(rowData.getPhone());
        rowVector.add(rowData.getDate());
        rowVector.add(rowData.getAmount());
        rowVector.add(rowData.getCc());

        super.addRow(rowVector);
    }

    // TODO: methods to return a row as a RowData object
}
