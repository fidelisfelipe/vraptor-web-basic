package br.com.caelum.vraptor.sysweb.model;

import java.util.Set;

/**
 * @author Fidelis
 *
 */
public class Receituario {
	
	private Set<Tratamento> tratamentos;

	public Set<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(Set<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}

}
