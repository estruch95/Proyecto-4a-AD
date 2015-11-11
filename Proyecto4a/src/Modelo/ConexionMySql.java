package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySql {
	//Atributos de la clase
	private Connection conexion;
	private String CONTROLADOR_MYSQL="com.mysql.jdbc.Driver";
	private String server="localhost";
	private String bbdd="actividades";
	private String user="rot";
	private String pass="";
	private static ConexionMySql instance=null;
	

	private ConexionMySql() throws SQLException{
		try {
			//Carga del controlador JDBC
			Class.forName(CONTROLADOR_MYSQL).newInstance();
			//Impreso informativo
			System.out.println("CARGA CORRECTA DEL CONTROLADOR JDBC");
		} 
		catch (Exception errorCargaControlador) {
			// TODO Auto-generated catch block
			errorCargaControlador.printStackTrace();
			System.err.println("ERROR EN LA CARGA DEL CONTROLADOR");
		}
		
		try {
			//Intento de conexión a la BBDD
			conexion = DriverManager.getConnection("jdbc:mysql://"+server+"/"+bbdd+"?"+"user="+user+"&password="+pass);
			//Impreso informativo
			System.out.println("CONEXION REALIZADA CON EXITO");
		} 
		catch (SQLException errorConexionBBDD) {
			// TODO Auto-generated catch block
			errorConexionBBDD.printStackTrace();
			System.err.println("ERROR DE CONEXION CON LA BBDD");
			
			if(errorConexionBBDD.getSQLState().equals("28000")){
				System.out.println("ERROR DE AUTENTIFICACIÓN");
			}
			else if(errorConexionBBDD.getSQLState().equals("08S01")){
				System.out.println("ERROR, SERVIDOR DESCONECTADO");
			}
			else{
				throw errorConexionBBDD;
			}
		}
	}
	
	//Método que nos devuelve la instancia de dicha clase
	public static ConexionMySql getInstance() {
		if(instance==null) {
			try {
				instance=new ConexionMySql();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
		

	//Método el cual nos permite realizar consultas (Selects) sobre cualquier tabla de la BBDD
	public ResultSet query(String query){
		
		Statement st;
		ResultSet rs = null;

		try {
			st = conexion.createStatement();
			try{
				rs = st.executeQuery(query);
			}
			catch (SQLException e){
				e.printStackTrace();
				System.err.println("ERROR AL REALIZAR LA CONSULTA");
			}
		
		}
		catch (SQLException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return rs;	
										
	}
	
	//Método el cual nos permite realizar INSERTS, UPDATES Y DELETE'S en cualquier tabla de la BBDD
	public int modifyQuery(String update){
		Statement stmt;
		int rs = 0;
		try{
		stmt = conexion.createStatement();		
			try{
				rs = stmt.executeUpdate(update);
			}
			catch (SQLException e){
				e.printStackTrace();
				System.err.println("ERROR AL REALIZAR EL INSERT/UPDATE/DELETE");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}
