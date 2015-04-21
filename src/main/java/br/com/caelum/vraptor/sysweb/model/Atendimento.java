package br.com.caelum.vraptor.sysweb.model;

import java.util.Set;

/**
 * @author Fidelis
 *
 */
public class Atendimento {
	
	private String nomeLocal;
	private Usuario usuario;
	private Set<Medico> medicos;
	
	public String getNomeLocal() {
		return nomeLocal;
	}
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Set<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}

}
