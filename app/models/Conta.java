package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import play.db.jpa.GenericModel;



@Entity
@Table (name = "Conta")
public class Conta extends GenericModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	public long id;
	
	@Column (name = "Saldo", nullable = false, unique = true)
	public double saque;
	
	@Column (name = "SaldoInicial", nullable = false, unique = true)
	public Double extrato;

	@OneToOne
	@JoinColumn (name = "idCliente")
	public Usuario usuario;
	
	
	
	@OneToOne
	@JoinColumn (name = "idBanco")
	public Banco banco;
	
	
	
	public void inserirConta ( double saque,Double extrato, Long idUsuario, Long idBanco){
		
		
		Usuario usuario = Usuario.findById(idUsuario);
		Banco banco = Banco.findById(idBanco);
		
		List<Conta> contas = Conta.find("Select conta From Conta conta Where conta.usuario = :usuario").setParameter("usuario", usuario).fetch();

		Conta c = new Conta();

		for (int i = 0; i < contas.size(); i++) {
			c = contas.get(i);
			if ( c.banco.id == idBanco)
				throw new IllegalArgumentException("Conta ja cadastrada no Banco");	
		}
		
		this.saque = saque;//valor que possui na conta
		this.extrato = extrato;//valor solidificado a partir do primeiro deposito na conta
		
		
		this.banco = banco;
		this.usuario = usuario;
		this.save();
	}
	public void excluirconta (Long idConta){
		
		if(idConta == null)
			throw new IllegalArgumentException("Erro na remoção da Conta");
		
		Conta conta = Conta.findById(idConta);//
		conta.delete();
	}
	
}
