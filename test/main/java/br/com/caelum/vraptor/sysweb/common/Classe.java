package br.com.caelum.vraptor.sysweb.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("class")
public class Classe {
	private String value;

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
