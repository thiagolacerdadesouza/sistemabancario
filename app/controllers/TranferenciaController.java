package controllers;

import models.Banco;
import models.Conta;
import models.Usuario;
import play.mvc.Controller;

public class TranferenciaController extends Controller{
	
	public static void transfere (Long idConta1, Long idConta2, Double valor){
		Conta conta1 = Conta.findById(idConta1);
		Conta conta2 = Conta.findById(idConta2);
		if (valor <= 56.00)
			ted(conta1, conta2, valor);
		if	(valor > 56.00 )
			doc (conta1, conta2,valor);
		else{
			
		}
				
		
	}
	private static void ted (Conta conta1, Conta conta2, Double valor){
		if(conta1.saque > (valor+14.56)){
			conta1.saque -= (valor+14.56);
			conta2.saque += valor;
		}
		conta1.save();
		conta2.save();
		renderJSON(conta2);
		
	}
	private static void doc (Conta conta1, Conta conta2, Double valor){
		if(conta1.saque > (valor+18.98)){
			conta1.saque -= (valor+18.98);
			conta2.saque += valor;
		}
		conta1.save();
		conta2.save();
		renderJSON(conta2);
	}
}
