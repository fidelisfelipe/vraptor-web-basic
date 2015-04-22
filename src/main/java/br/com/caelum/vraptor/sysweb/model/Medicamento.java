package br.com.caelum.vraptor.sysweb.model;

import br.com.caelum.vraptor.sysweb.enums.MedidaEnum;

/**
 * @author Fidelis
 *
 */
public class Medicamento implements Comparable<Medicamento>{
	
	private Integer order;
	private String nome;
	private MedidaEnum medida;
	private double dose;
	
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
	public MedidaEnum getMedida() {
		return medida;
	}
	public void setMedida(MedidaEnum medida) {
		this.medida = medida;
	}
	public double getDose() {
		return dose;
	}
	public void setDose(double dose) {
		this.dose = dose;
	}
	
	@Override
	public int compareTo(Medicamento o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(this.order == o.getOrder()) return EQUAL;
	    if(this.order < o.order) return BEFORE;
	    if(this.order > o.order) return AFTER;
	    
	    return EQUAL;
	}
	
}
