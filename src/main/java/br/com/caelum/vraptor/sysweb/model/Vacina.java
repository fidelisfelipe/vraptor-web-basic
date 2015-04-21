package br.com.caelum.vraptor.sysweb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Vacina implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String obs;
	private Date data = new Date();
	private Date atualizacao = new Date();
	
	@Id
	@SequenceGenerator(name="seq_vacina", sequenceName="seq_vacina", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_vacina")
	@Column(name="id_plano",nullable=false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 80, nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(length = 255, nullable=false)
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	@Column(name ="cadastro", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Column(name ="atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAtualizacao() {
		return atualizacao;
	}
	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}
	
}
