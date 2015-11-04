package Controladores;

import Modelo.ConexionMySql;
import Modelo.ModeloActividad;

public class ActividadController {
	
	private ModeloActividad modeloActividad;

	public ActividadController() {
		// TODO Auto-generated constructor stub
		modeloActividad = new ModeloActividad();
	}
	
	public void addActividad(String asignatura, String nombre, String inicio, String fin, String entregada){
		ConexionMySql conexion = ConexionMySql.getInstance();
		conexion.modifyQuery("INSERT INTO actividad VALUES("
		+ "'"+asignatura+"', "
		+ "'"+nombre+"',"
		+ "'"+inicio+"', "
		+ "'"+fin+"',"
		+ ""+entregada+");");
	}

}
