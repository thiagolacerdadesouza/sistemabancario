package controllers;

import models.Banco;
import models.Conta;
import models.Usuario;
import play.mvc.Controller;

public class BancoController extends Controller{
	
	public static void inserirBanco (String nomeBanco, Long codAgencia){
	 	
		try {
			Banco banco = new Banco();
		 	banco.inserirBanco(nomeBanco, codAgencia);
			
			renderJSON("O Banco: "+ nomeBanco + " foi adicionado com sucesso à Base de dados");	
		} catch (Exception e) {
			renderJSON("Existe uma inconformidade na criação do Banco e Agência"+ e.getMessage());
		}
			
				
}
	public static void excluirBanco (Long id_banco){
		
		try {
			Banco banco = Banco.findById(id_banco);
			banco.excluirbanco (id_banco);
			renderJSON("Banco excluido com sucesso da Base de Dados");
		} catch (Exception e) {
			renderJSON("Erro ao remover o Banco do sistema!");
		}
		
	}
	
	
}
