package testejdbc;

import br.com.usuarioempresa.business.UsuarioBusiness;
import br.com.usuarioempresa.dao.UsuarioDAO;
import br.com.usuarioempresa.model.Usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioTeste {

	public static void main(String[] args) {
		/*MetaCaracteres
		 * [] - Oque estiver dentro de colchetes ser� pesquisado, isso � �til para encontrar caracteres
		 * ESPECIFICOS
		 * [] tamb�m � poss�vel limitar um range de caracteres usando o h�fen "-" ex: a-z ou A-Z
		String regerx="[1.8]";
		String nome="123456789"; 

		Pattern pattern= Pattern.compile(regerx);
		Matcher matcher = pattern.matcher(nome);
		System.out.println("Texto:  "+nome);
		System.out.println("indice: 0123456789");
		System.out.println("express�o: "+matcher.pattern());
		System.out.println("posi�es encontradas");
		while(matcher.find()) {
			//posi��o inicial a qual encontramos a sequ�ncia
			System.out.print(matcher.start()+ " ");*/
		UsuarioBusiness usuarioBusiness= new UsuarioBusiness();
		
		System.out.println(usuarioBusiness.efetuarCadastro("alan", "novoLogin", "aaaaaaaaa"));
		UsuarioDAO usuarioDao= new UsuarioDAO();
		
		/*
		Usuario usuario1= new Usuario();
		usuario1.setNome("NamoradoDaFernanda");
		usuario1.setLogin("TopJuliano");
		usuario1.setSenha("Nene1500");
		
		usuarioDao.update(usuario1);*/
		
		
		
		System.out.println("Usuarios:");
		for(Usuario usuariosRetorno: usuarioDao.listUsuario()) {
			System.out.println("Nome: "+usuariosRetorno.getNome()+"| Login: "+usuariosRetorno.getLogin()+
					"| Senha: "+usuariosRetorno.getSenha());
		}
		String deletarUsuario="TopJuliano";
		usuarioDao.deleteByLogin(deletarUsuario);
		
		System.out.println("Usuarios:");
		for(Usuario usuariosRetorno: usuarioDao.listUsuario()) {
			System.out.println("Nome: "+usuariosRetorno.getNome()+"| Login: "+usuariosRetorno.getLogin()+
					"| Senha: "+usuariosRetorno.getSenha());
		}
	}

}
