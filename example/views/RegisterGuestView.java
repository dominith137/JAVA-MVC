package views;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controllers.RegisterGuestController;
import core.Model;
import core.View;

@SuppressWarnings("serial")
public class RegisterGuestView extends JPanel implements View
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	@SuppressWarnings("unused")
	private RegisterGuestController controller;
	private JTextField tf_nombre;
	private JTextField tf_celular;
	private JTextField tf_direccion;
	private JRadioButton rbtn_masculino;
	private JRadioButton rbtn_femenino;
	private JComboBox<Integer> cb_dia;
	private JComboBox<String> cb_mes;
	private JComboBox<Integer> cb_anio;
	private JCheckBox cb_terminos;

	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	public RegisterGuestView(RegisterGuestController controller)
	{
		this.controller = controller;
		make_frame();
		make_row_nombre();
		make_row_celular();
		make_row_genero();
		make_row_fechaNacimiento();
		make_row_direccion();
		make_row_terminos();
	}

	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void update(Model model, Object data) {}

	private void make_frame() { setLayout(null); }

	private void make_row_nombre()
	{
		JLabel lbl = new JLabel("Ingrese Nombre:");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl.setBounds(29, 29, 150, 14);
		add(lbl);

		tf_nombre = new JTextField();
		tf_nombre.setBounds(200, 26, 220, 20);
		add(tf_nombre);
		tf_nombre.setColumns(10);
	}

	private void make_row_celular()
	{
		JLabel lbl = new JLabel("Ingrese numero celular:");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl.setBounds(29, 71, 170, 14);
		add(lbl);

		tf_celular = new JTextField();
		tf_celular.setBounds(200, 68, 220, 20);
		add(tf_celular);
		tf_celular.setColumns(10);
	}

	private void make_row_genero()
	{
		JLabel lbl = new JLabel("Genero:");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl.setBounds(29, 119, 150, 14);
		add(lbl);

		ButtonGroup group = new ButtonGroup();
		rbtn_masculino = new JRadioButton("Masculino");
		rbtn_masculino.setBounds(200, 115, 100, 23);
		add(rbtn_masculino);
		group.add(rbtn_masculino);

		rbtn_femenino = new JRadioButton("Femenino");
		rbtn_femenino.setBounds(310, 115, 100, 23);
		add(rbtn_femenino);
		group.add(rbtn_femenino);

		rbtn_masculino.setSelected(true);
	}

	private void make_row_fechaNacimiento()
	{
		JLabel lbl = new JLabel("Fecha de nacimiento:");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl.setBounds(29, 164, 150, 14);
		add(lbl);

		cb_dia = new JComboBox<Integer>();
		for (int d = 1; d <= 31; d++) cb_dia.addItem(d);
		cb_dia.setBounds(200, 160, 60, 22);
		add(cb_dia);

		cb_mes = new JComboBox<String>(new String[]{
			"Enero","Febrero","Marzo","Abril","Mayo","Junio",
			"Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"
		});
		cb_mes.setBounds(270, 160, 110, 22);
		add(cb_mes);

		cb_anio = new JComboBox<Integer>();
		for (int y = 1950; y <= 2025; y++) cb_anio.addItem(y);
		cb_anio.setBounds(390, 160, 70, 22);
		add(cb_anio);
	}

	private void make_row_direccion()
	{
		JLabel lbl = new JLabel("Dirección:");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl.setBounds(29, 205, 150, 14);
		add(lbl);

		tf_direccion = new JTextField();
		tf_direccion.setBounds(200, 202, 220, 20);
		add(tf_direccion);
		tf_direccion.setColumns(10);
	}

	private void make_row_terminos()
	{
		cb_terminos = new JCheckBox("Acepta Terminos y Condiciones");
		cb_terminos.setBounds(29, 245, 250, 23);
		add(cb_terminos);
	}
}


