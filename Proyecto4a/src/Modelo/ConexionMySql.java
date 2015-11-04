package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySql {
	
	private Connection conexion;
	private String CONTROLADOR_MYSQL="com.mysql.jdbc.Driver";
	private String server="localhost";
	private String bbdd="delincuentes";
	private String user="root";
	private String pass="";
	private static ConexionMySql instance=null;
	

	private ConexionMySql(){
		try {
			Class.forName(CONTROLADOR_MYSQL).newInstance();
			System.out.println("CARGA CORRECTA DEL CONTROLADOR JDBC");
		} 
		catch (Exception errorCargaControlador) {
			// TODO Auto-generated catch block
			errorCargaControlador.printStackTrace();
			System.out.println("ERROR EN LA CARGA DEL CONTROLADOR");
		}
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://"+server+"/"+bbdd+"?"+"user="+user+"&password="+pass);
			System.out.println("CONEXION REALIZADA CON EXITO");
		} 
		catch (SQLException errorConexionBBDD) {
			// TODO Auto-generated catch block
			errorConexionBBDD.printStackTrace();
			System.out.println("ERROR DE CONEXION CON LA BBDD");
		}
	}
	
	public static ConexionMySql getInstance() {
		if(instance==null) {
			instance=new ConexionMySql();
		}
		return instance;
	}
		

		//SELECTS
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
			}
		
		}
		catch (SQLException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return rs;	
										
	}
	
	//INSERTS, UPDATES Y DELETES
	public int modifyQuery(String update){
		Statement stmt;
		int rs = 0;
		try{
		stmt = conexion.createStatement();		
			try{
				rs = stmt.executeUpdate(update);
			}
			catch (SQLException e){
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}

}
