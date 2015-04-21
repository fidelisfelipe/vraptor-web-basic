package br.com.caelum.vraptor.sysweb.model;

import br.com.caelum.vraptor.sysweb.enums.MedidaEnum;

/**
 * @author Fidelis
 *
 */
public class Medicamento {
	
	private String nome;
	private MedidaEnum medida;
	private double dose;
	
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
	
}
