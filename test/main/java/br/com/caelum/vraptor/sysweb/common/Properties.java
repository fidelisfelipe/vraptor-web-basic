package br.com.caelum.vraptor.sysweb.common;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("properties")
public class Properties {
	@XStreamImplicit
	private List<Property> property;
	
	public List<Property> getProperty() {
		return property;
	}
}
