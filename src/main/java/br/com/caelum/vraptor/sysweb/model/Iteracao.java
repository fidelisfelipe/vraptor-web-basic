package br.com.caelum.vraptor.sysweb.model;

import java.util.Set;

/**
 * @author Fidelis
 *
 */
public class Iteracao implements Comparable<Iteracao>{
	
	private Integer order;
	private int intervaloHoras;
	private int dias;
	private Set<Medicamento> medicamentos;
	private boolean isPrimeiraDoseEmJejum;
	
	public int getIntervaloHoras() {
		return intervaloHoras;
	}
	public void setIntervaloHoras(int intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public Set<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(Set<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public int compareTo(Iteracao o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(this.order == o.getOrder()) return EQUAL;
	    if(this.order < o.order) return BEFORE;
	    if(this.order > o.order) return AFTER;
	    
	    return EQUAL;
	}
	
	public boolean isPrimeiraDoseEmJejum() {
		return isPrimeiraDoseEmJejum;
	}
	public void setPrimeiraDoseEmJejum(boolean isPrimeiraDoseEmJejum) {
		this.isPrimeiraDoseEmJejum = isPrimeiraDoseEmJejum;		
	}

}
