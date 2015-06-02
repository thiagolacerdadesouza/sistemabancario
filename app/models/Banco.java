package models;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;


@Entity
@Table (name = "Banco")
public class Banco extends GenericModel{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	public long id;
	
	@Column (name = "Agência", nullable = false, unique = true)
	public Long codAgencia;
	
	@Column (name = "Banco", nullable = false, unique = true)
	public String nomebanco;

	public void inserirBanco (String nomeBanco, Long codAgencia){
	 	

		if(nomeBanco == null || codAgencia == null)
			throw new IllegalArgumentException("Erro de cadastro do Banco");
		
	 	
		this.nomebanco = nomeBanco;
		this.codAgencia = codAgencia; 
		this.save();
	}
	public void excluirbanco (Long idBanco){
		
		if(idBanco == null)
			throw new IllegalArgumentException("Erro na remoção do Banco");
		
		Banco banco = Banco.findById(idBanco);
		banco.delete();
	}
	
}
