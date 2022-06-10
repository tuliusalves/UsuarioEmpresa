package br.com.usuarioempresa.business;

import br.com.usuarioempresa.dao.UsuarioDAO;
import br.com.usuarioempresa.model.Usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioBusiness {
	private UsuarioDAO usuariodao = new UsuarioDAO();
	public boolean efetuarLogin(String login, String senha) {
		/*Verifique se login e senha estão de acordo com a regra
		 * se não estiverem retorne falso.	 * 
		 */
		String regerx="([0-9])";
		
		Pattern pattern= Pattern.compile(regerx);
		Matcher matcher = pattern.matcher(login);
		while(matcher.find() || senha.length()<7) {
			
				//posição inicial a qual encontramos a sequência
				//System.out.print(matcher.start()+ " ");
			return false;
		}//else {
		usuariodao.podeEfetuarLogin(login, senha);
		return true;
		//}
	}
	
	public boolean efetuarCadastro(String nome, String login, String senha) {
		//regras do nome
		String regerx="([0-9\\W])";
		Pattern pattern = Pattern.compile(regerx);
		Matcher matcher = pattern.matcher(nome);// fim regra do nome
		//regras senha
		String regexSenha="\\w\\d";
		Pattern patternSenha= Pattern.compile(regexSenha);
		Matcher matcherSenha = patternSenha.matcher(regexSenha);// fim senha
		
		while(matcher.find()|| senha.length()<7) {
			return false;
		}
		while(matcherSenha.find()) {
			return false;
		}
		usuariodao.podeCadastrarUsuario(nome, login, senha);
		return true;
	}

}
