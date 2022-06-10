package br.com.usuarioempresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.usuarioempresa.factory.ConnectionFactory;
import br.com.usuarioempresa.model.Usuario;

public class UsuarioDAO {
	public UsuarioDAO() {}
	
	Connection connection= null;
	PreparedStatement preparedStatement= null;
	String sql="";
	
	public boolean podeEfetuarLogin(String Login, String senha) {
		
		return true;
	}
	
	public boolean podeCadastrarUsuario(String nome,String login, String senha) {
		
		return true;
	}
	// o nome do usuário não pode conter caracteres especiais
	
	public void save (Usuario usuario) {
		sql="INSERT INTO usuarios(nome,login,senha) VALUES(?,?,?)";
		
		try {
			connection= ConnectionFactory.createConnectionToMySQL();
			preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1,usuario.getNome());
			preparedStatement.setString(2, usuario.getLogin());
			preparedStatement.setString(3, usuario.getSenha());
			
			preparedStatement.execute();
			System.out.println("Usuário: "+ usuario.getNome()+" cadastrado com sucesso");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection !=null) {
					connection.close();
				}
				if(preparedStatement !=null) {
					preparedStatement.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> listUsuario(){
		sql="SELECT * From usuarios";
		
		List<Usuario> usuariosBanco= new ArrayList<Usuario>();
		
		ResultSet resultSet= null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(resultSet.getString("nome"));
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
				
				usuariosBanco.add(usuario);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(connection !=null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return usuariosBanco;
	}
	
	public void update(Usuario usuario) {
		sql="UPDATE usuarios SET nome=?, login=?, senha=?"+ "WHERE login like ?";
		
		try {
			connection= ConnectionFactory.createConnectionToMySQL();
			
			preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
			
			preparedStatement.setString(1,usuario.getNome());
			preparedStatement.setString(2,usuario.getLogin());
			preparedStatement.setString(3, usuario.getSenha());
			
			preparedStatement.setString(4, usuario.getLogin());
			preparedStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(preparedStatement !=null) {
					preparedStatement.close();
				}
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByLogin(String login) {
		sql="DELETE FROM usuarios WHERE login like ?";
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			
			preparedStatement.setString(1,login);
			preparedStatement.execute();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement !=null) {
					preparedStatement.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

	



