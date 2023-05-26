package others;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;

public class NewlineTableCellRenderer extends DefaultTableCellRenderer {
    private String text;
    public NewlineTableCellRenderer() {
        //this.text = text;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Use a JTextArea to display the cell value with newline
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(value != null ? value.toString() : ""); 
        
        // Adjust the row height based on the text content
        int desiredHeight = textArea.getPreferredSize().height;
        if (table.getRowHeight(row) != desiredHeight) {
            table.setRowHeight(row, desiredHeight);
        }
        
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        return textArea;
    }
}