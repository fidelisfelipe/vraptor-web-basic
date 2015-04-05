package br.com.caelum.vraptor.sysweb.util;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("property")
public class Property {
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
}
