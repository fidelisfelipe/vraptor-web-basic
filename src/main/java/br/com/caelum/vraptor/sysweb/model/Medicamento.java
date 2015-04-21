package br.com.caelum.vraptor.sysweb.model;

/**
 * @author Fidelis
 *
 */
public class Medicamento {
	
	private String nome;
	private long intervado;
	private MedidaEnum medida;
	private double dose;
	
	private Posologia posologia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getIntervado() {
		return intervado;
	}

	public void setIntervado(long intervado) {
		this.intervado = intervado;
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

	public Posologia getPosologia() {
		return posologia;
	}

	public void setPosologia(Posologia posologia) {
		this.posologia = posologia;
	}
	
	
	
}
