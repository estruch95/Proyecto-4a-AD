package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ModeloActividad {

	public ModeloActividad() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Actividad> load(){
		ConexionMySql conexion = ConexionMySql.getInstance();
		ResultSet rs = conexion.query("SELECT * FROM actividades;");
		
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try{
			while(rs.next()){
				Actividad actividad = new Actividad();
				actividad.setId((int) rs.getObject("id"));
				actividad.setAsignatura((String) rs.getObject("asignatura"));
				actividad.setNombre((String) rs.getObject("nombre"));
				actividad.setInicio((String) rs.getObject("inicio"));
				actividad.setFin((String) rs.getObject("fin"));
				actividad.setEntregada((boolean) rs.getObject("entregada"));
				
				actividades.add(actividad);
			}
		}
		catch(SQLException errorLoadActividad){
			errorLoadActividad.printStackTrace();
			System.out.println("ERROR EN LOAD ACTIVIDAD");
		}
		return actividades;
	} 

	public void save(Actividad act){
		
	}
}
