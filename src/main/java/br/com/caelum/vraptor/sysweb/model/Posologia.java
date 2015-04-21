package br.com.caelum.vraptor.sysweb.model;

/**
 * @author Fidelis
 *
 */
public class Posologia {
	private int intervaloHoras;
	private double dose;
	private int diasTratamento;
	private String observacao;
	
	public int getIntervaloHoras() {
		return intervaloHoras;
	}
	public void setIntervaloHoras(int intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}
	public double getDose() {
		return dose;
	}
	public void setDose(double dose) {
		this.dose = dose;
	}
	public int getDiasTratamento() {
		return diasTratamento;
	}
	public void setDiasTratamento(int diasTratamento) {
		this.diasTratamento = diasTratamento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
