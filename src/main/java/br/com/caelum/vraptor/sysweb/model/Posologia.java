package br.com.caelum.vraptor.sysweb.model;

import java.util.Set;

/**
 * @author Fidelis
 *
 */
public class Posologia implements Comparable<Posologia>{
	
	private Integer ordem;
	private String nome;
	
	private String descricao;
	private Set<Iteracao> iteracoes;
	
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<Iteracao> getIteracoes() {
		return iteracoes;
	}
	public void setIteracoes(Set<Iteracao> iteracoes) {
		this.iteracoes = iteracoes;
	}
	@Override
	public int compareTo(Posologia o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(this.ordem == o.getOrdem()) return EQUAL;
	    if(this.ordem < o.ordem) return BEFORE;
	    if(this.ordem > o.ordem) return AFTER;
	    
	    return EQUAL;
	}
	
}
