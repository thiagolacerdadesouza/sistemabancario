package controllers;

import models.Banco;
import models.Conta;
import models.Usuario;
import play.mvc.Controller;

public class UsuarioController extends Controller{
	
	public static void inserirUsuario(String nome, String cpf){
		
		
		try {
			Usuario usuario = new Usuario();
			
			usuario.inserirUsuario(nome, cpf);
			
			renderJSON("Cliente: "+ usuario +" cadastrado com sucesso!");	
			
		} catch (Exception e) {
			
			renderJSON("Existe uma inconformidade no Cadastro"+ e.getMessage());
		}
		
		
		
	
	}
	public static void excluirUsuario (Long idUsuario){
		
		try {
			Usuario usuario = Usuario.findById(idUsuario);
			usuario.excluirusuario (idUsuario);
			renderJSON("Cliente excluido com sucesso da Base de Dados");
		} catch (Exception e) {
			renderJSON("Erro ao remover o Cliente do sistema!");
		}
	}
}
