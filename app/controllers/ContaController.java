package controllers;

import models.Banco;
import models.Conta;
import models.Usuario;
import play.mvc.Controller;

public class ContaController extends Controller{
	
	public static void inserirConta ( double saque,Double extrato, Long idUsuario, Long idBanco){
		
		try {
			
			Conta conta = new Conta();
			
			conta.inserirConta(saque, extrato, idUsuario, idBanco);
						
			renderJSON("Conta: "+conta+" vinculada ao Cliente " +conta.usuario.nome + " com sucesso!");
			
			
		} catch (Exception e) {
			renderJSON("Existe uma inconformidade: "+ e.getMessage());	
		}
		
	}
	public static void excluirConta (Long idConta){
		
		try {
			Conta conta = Conta.findById(idConta);
			conta.excluirconta (idConta);
			renderJSON("Conta excluida com sucesso da Base de Dados");
		} catch (Exception e) {
			renderJSON("Erro ao remover a Conta do sistema!");
		}
	}
}

