package Vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.ActividadController;
import Modelo.ConexionMySql;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAsignatura;
	private JTextField textFieldNombre;
	private JTextField textFieldInicio;
	private JTextField textFieldFin;
	private JTextField textFieldEntregada;
	
	private ActividadController controladorActividad;

	public FramePrincipal() {
		setTitle("Gestor de actividades DAM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controladorActividad = new ActividadController();
		
		
		labels();
		textFields();
		buttons();
		
	}
	
	public void labels(){
		JLabel lblNuevaActividad = new JLabel("Nueva actividad");
		lblNuevaActividad.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNuevaActividad.setBounds(20, 6, 117, 16);
		contentPane.add(lblNuevaActividad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 83, 81, 16);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Asignatura:");
		lblNewLabel.setBounds(20, 50, 81, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(20, 120, 81, 16);
		contentPane.add(lblInicio);
		
		JLabel lblFin = new JLabel("Fin:");
		lblFin.setBounds(20, 161, 81, 16);
		contentPane.add(lblFin);
		
		JLabel lblEntregada = new JLabel("Entregada:");
		lblEntregada.setBounds(20, 201, 81, 16);
		contentPane.add(lblEntregada);
	}
	
	public void textFields(){
		textFieldAsignatura = new JTextField();
		textFieldAsignatura.setBounds(129, 45, 280, 26);
		contentPane.add(textFieldAsignatura);
		textFieldAsignatura.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(129, 78, 280, 26);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldInicio = new JTextField();
		textFieldInicio.setColumns(10);
		textFieldInicio.setBounds(129, 115, 280, 26);
		contentPane.add(textFieldInicio);
		
		textFieldFin = new JTextField();
		textFieldFin.setColumns(10);
		textFieldFin.setBounds(129, 156, 280, 26);
		contentPane.add(textFieldFin);
		
		textFieldEntregada = new JTextField();
		textFieldEntregada.setColumns(10);
		textFieldEntregada.setBounds(129, 196, 280, 26);
		contentPane.add(textFieldEntregada);
	}
	
	public void buttons(){
		JButton btnIntroducirAct = new JButton("Introducir actividad");
		btnIntroducirAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controladorActividad.addActividad(
						textFieldAsignatura.getText(),
						textFieldNombre.getText(), 
						textFieldInicio.getText(),
						textFieldFin.getText(),
						textFieldEntregada.getText());
			}
		});
		btnIntroducirAct.setBounds(6, 229, 203, 29);
		contentPane.add(btnIntroducirAct);
		
		JButton btnConsultarAct = new JButton("Consultar actividades");
		btnConsultarAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConsultarAct.setBounds(221, 229, 188, 29);
		contentPane.add(btnConsultarAct);
	}
}
