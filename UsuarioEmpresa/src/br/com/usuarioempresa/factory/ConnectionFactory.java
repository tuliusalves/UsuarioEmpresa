package br.com.usuarioempresa.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME="root";
	private static final String PASSWORD="";
	
	private static final String DATABASE_URL="jdbc:mysql://localhost:3306/usuarios";
	
	public static Connection createConnectionToMySQL() throws Exception{
		//Fazer a classe ser carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
		
	}
	/*Agora precismamos ver se h� uma conex�o ativa para ser gerenciada pela JVM.
	 * criamos um objeto da classe "connection" que � inicalizado com o m�todo
	 * "createConnectionToMySql() 
	 * faremos isso dentro de um m�todo "main".
	 * Depois testamos se o objeto � diferente de nulo, caso n�o seja imprimimos
	 * "conex�o" obtida com sucesso*/
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		if(con!=null) {
			System.out.println("Conex�o obtida com sucesso");
			con.close();
		}
	}

}
