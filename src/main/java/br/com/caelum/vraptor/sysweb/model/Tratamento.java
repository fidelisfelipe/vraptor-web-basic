package br.com.caelum.vraptor.sysweb.model;

import java.util.Set;

/**
 * @author Fidelis
 *
 */
public class Tratamento {

	private String nome;
	private Set<Posologia> posologias;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Posologia> getPosologias() {
		return posologias;
	}

	public void setPosologias(Set<Posologia> posologias) {
		this.posologias = posologias;
	}

}
