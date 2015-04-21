package br.com.caelum.vraptor.sysweb.model;

import java.util.Set;

/**
 * @author Fidelis
 *
 */
public class Medico {
	private String nome;
	private Set<Receituario> receituarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Receituario> getReceituarios() {
		return receituarios;
	}

	public void setReceituarios(Set<Receituario> receituarios) {
		this.receituarios = receituarios;
	}

}
