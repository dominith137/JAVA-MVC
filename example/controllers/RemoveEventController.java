package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import models.SchedulerIO;
import views.RemoveEventView;

/**
 * Controller responsible for Remove Event tab behavior.
 */
public class RemoveEventController extends Controller
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
    private RemoveEventView removeEventView;
    private JTable table;
    private EventListController eventListController;

    public RemoveEventController() {}

    public RemoveEventController(EventListController eventListController)
    {
        this.eventListController = eventListController;
    }

	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run()
	{
		table = new JTable(getDataColumnsWithCheckbox(), getNameColumnsWithCheckbox()) {
			private static final long serialVersionUID = 1L;
			@Override
			public Class<?> getColumnClass(int column) {
				if (column == 5) return Boolean.class;
				return Object.class;
			}
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5; // only checkbox editable
			}
		};
		removeEventView = new RemoveEventView(this, table);
	}

	/**
	 * Reloads the table data from disk.
	 */
	public void reload()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Vector<Vector<Object>> data = getDataColumnsWithCheckbox();
		for (Vector<Object> row : data) {
			model.addRow(row.toArray());
		}
	}

	/**
	 * Selects or deselects all checkboxes.
	 */
	public void setAllSelection(boolean selected)
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(selected, i, 5);
		}
	}

	/**
	 * Clears all checkbox selections.
	 */
	public void clearSelection()
	{
		setAllSelection(false);
	}

	/**
	 * Removes selected events from storage and refreshes table.
	 */
    public void removeSelected()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < model.getRowCount(); i++) {
			Object value = model.getValueAt(i, 5);
			if (value instanceof Boolean && (Boolean) value) {
				indexes.add(i);
			}
		}

		try {
			SchedulerIO io = new SchedulerIO();
			io.attach(removeEventView);
			io.removeEventsByIndexes(indexes);
		} catch (Exception ex) { }

		reload();
        if (eventListController != null) {
            eventListController.reload();
        }
	}

	//-----------------------------------------------------------------------
	//		Getters
	//-----------------------------------------------------------------------
	public RemoveEventView getView()
	{
		return removeEventView;
	}

	public Vector<String> getNameColumnsWithCheckbox()
	{
		Vector<String> nameColumns = new Vector<String>();
		nameColumns.add("Date");
		nameColumns.add("Description");
		nameColumns.add("Frequency");
		nameColumns.add("E-mail");
		nameColumns.add("Alarm");
		nameColumns.add("Boolean");
		return nameColumns;
	}

	public Vector<Vector<Object>> getDataColumnsWithCheckbox()
	{
		Vector<Vector<Object>> dataColumns = new Vector<Vector<Object>>();
		try {
			SchedulerIO schedulerIO = new SchedulerIO();
			dataColumns = schedulerIO.getEvents();
			// add unchecked boolean column
			for (Vector<Object> row : dataColumns) {
				row.add(Boolean.FALSE);
			}
		} catch (Exception ex) { }
		return dataColumns;
	}
}


