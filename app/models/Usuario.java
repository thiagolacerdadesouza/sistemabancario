package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@Entity
@Table (name = "Cliente")
public class Usuario extends GenericModel{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	public long id;
	@Column (name = "Nome", nullable = false, unique = true)
	public String nome;
	
	@Column (name = "CPF", nullable = false, unique = true)
	public String cpf;


	public void inserirUsuario(String nome, String cpf){
		
		
			if(nome == null || cpf == null)
				throw new IllegalArgumentException("Erro no preenchimento no cadastro do Cliente");
		
		this.nome = nome;
		this.cpf = cpf;
		this.save();
		}
	
	public void excluirusuario (Long idUsuario){
		
		if(idUsuario == null)
			throw new IllegalArgumentException("Erro na remoção do Cliente");
		
		Usuario usuario = Usuario.findById(idUsuario);//
		usuario.delete();
	}
}
