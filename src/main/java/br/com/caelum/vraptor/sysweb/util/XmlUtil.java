package br.com.caelum.vraptor.sysweb.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import br.com.caelum.vraptor.sysweb.common.Classe;
import br.com.caelum.vraptor.sysweb.common.Persistence;
import br.com.caelum.vraptor.sysweb.common.PersistenceUnit;
import br.com.caelum.vraptor.sysweb.common.Property;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * @author fidelis.guimaraes
 *
 */
public class XmlUtil {

	/**
	 * Recupera o XML
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Persistence getPersistenceXml () throws FileNotFoundException{
		//recupera o file xml
		FileReader file = new FileReader("src/main/resources/META-INF/persistence.xml");
		BufferedReader input = new BufferedReader(file);
		//configura modelo de xml
		
		//configura nome do persistence-unit
		XmlFriendlyNameCoder codeName = new XmlFriendlyNameCoder("_", "-");
		DomDriver conector = new DomDriver("UTF-8", codeName);
		
		//cria stream para recuperação
		XStream stream = new XStream(conector);
		
		//Classe principal
		stream.processAnnotations(Persistence.class);
		//PersistenceUnit.name
		stream.useAttributeFor(PersistenceUnit.class, "name");
		//Property.name
		stream.useAttributeFor(Property.class, "name");
		//Property.value
		stream.useAttributeFor(Property.class, "value");
		//converter para exibir o valor fora de atributo
		//<class>conteudo</class>
		stream.registerConverter(new ToAttributedValueConverter(Classe.class,
				stream.getMapper(), 
				stream.getReflectionProvider(), 
				stream.getConverterLookup(), "value"));
		
		return (Persistence)stream.fromXML(input);
	}
	
}
