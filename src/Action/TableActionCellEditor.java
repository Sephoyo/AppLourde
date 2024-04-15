package Action;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction action = new PanelAction();
        Object id = jtable.getModel().getValueAt(row, 0);
        action.initEvent(event, row,id);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}