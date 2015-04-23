package br.com.caelum.vraptor.sysweb.model;

import java.util.Set;

/**
 * @author Fidelis
 *
 */
public class Tratamento implements Comparable<Tratamento>{

	private Integer order;
	private String nome;
	private Set<Posologia> posologias;
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

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

	@Override
	public int compareTo(Tratamento o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(this.order == o.getOrder()) return EQUAL;
	    if(this.order < o.order) return BEFORE;
	    if(this.order > o.order) return AFTER;
	    
	    return EQUAL;
	}

}
