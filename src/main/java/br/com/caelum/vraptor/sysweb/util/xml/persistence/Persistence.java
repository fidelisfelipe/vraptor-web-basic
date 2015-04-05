package br.com.caelum.vraptor.sysweb.util.xml.persistence;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("persistence")
public class Persistence {
	@XStreamImplicit
	private List<PersistenceUnit> persistence_unit;
	
	public List<PersistenceUnit> getPersistence_unit() {
		return persistence_unit;
	}
}
