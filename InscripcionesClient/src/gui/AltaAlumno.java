package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.Client;
import dto.AlumnoView;

public class AltaAlumno extends JInternalFrame {

	private static final long serialVersionUID = -7885298908000683951L;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnAceptar, btnSalir;
	private JInternalFrame aux;

	public AltaAlumno(String titulo, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(titulo, resizable, closable, maximizable, iconifiable);
		configurar();
		this.setVisible(true);
		this.pack();
		aux = this;
	}

	private void configurar() {

		this.setLayout(new GridLayout(2, 2));
		lblNombre = new JLabel(" Nuevo Alumno ");
		txtNombre = new JTextField();
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtNombre.getText() == null || txtNombre.getText().length() == 0) {
					JOptionPane.showMessageDialog(aux, "Debe ingresar un nombre");
					return;
				}

				try {
					// TODO: move this to a controller
					// Controlador.getInstancia().agregarAlumno(txtNombre.getText());
					Client.getInstancia().getAlumnosRemoteObject()
							.agregarAlumno(new AlumnoView(0, txtNombre.getText()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(aux, ex.getMessage());
				}
			}
		});

		btnSalir = new JButton("Salir");
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(btnAceptar);
		this.add(btnSalir);

	}
}
