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
	/*Agora precismamos ver se há uma conexão ativa para ser gerenciada pela JVM.
	 * criamos um objeto da classe "connection" que é inicalizado com o método
	 * "createConnectionToMySql() 
	 * faremos isso dentro de um método "main".
	 * Depois testamos se o objeto é diferente de nulo, caso não seja imprimimos
	 * "conexão" obtida com sucesso*/
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso");
			con.close();
		}
	}

}
