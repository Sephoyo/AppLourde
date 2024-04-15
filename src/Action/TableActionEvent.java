package Action;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onEdit(int row, Object id);

    public void onDelete(int row,Object id);

    public void onView(int row,Object id);
}