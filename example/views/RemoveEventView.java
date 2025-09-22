package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.RemoveEventController;
import core.Model;
import core.View;

@SuppressWarnings("serial")
public class RemoveEventView extends JPanel implements View
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	@SuppressWarnings("unused")
	private RemoveEventController controller;
	private JTable table;

	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	public RemoveEventView(RemoveEventController controller, JTable table)
	{
		this.controller = controller;
		this.table = table;
		make_frame();
	}

	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void update(Model model, Object data) {}

    private void make_frame()
    {
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSelectAll = new JButton("Select everything");
        JButton btnCancel = new JButton("Cancel");
        JButton btnRemover = new JButton("Remover");
        controls.add(btnSelectAll);
        controls.add(btnCancel);
        controls.add(btnRemover);

        add(controls, BorderLayout.SOUTH);

        btnSelectAll.addActionListener(e -> controller.setAllSelection(true));
        btnCancel.addActionListener(e -> controller.clearSelection());
        btnRemover.addActionListener(e -> controller.removeSelected());
    }
}


