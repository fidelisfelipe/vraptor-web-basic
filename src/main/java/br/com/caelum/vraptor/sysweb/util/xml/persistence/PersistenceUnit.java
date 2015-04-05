package br.com.caelum.vraptor.sysweb.util.xml.persistence;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("persistence-unit")
public class PersistenceUnit {
	
	private String name;
	@XStreamAlias("class")
	@XStreamImplicit
	private List<Classe> classe;
	private Properties properties;
	
	public List<Classe> getClasse() {
		return classe;
	}
	public void setClasse(List<Classe> classe) {
		this.classe = classe;
	}
	public Properties getProperties() {
		return properties;
	}
	public String getName() {
		return name;
	}
}
