package br.com.caelum.vraptor.sysweb.model;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.sysweb.annotations.GenericTest;
import br.com.caelum.vraptor.sysweb.common.Classe;
import br.com.caelum.vraptor.sysweb.common.Persistence;
import br.com.caelum.vraptor.sysweb.common.PersistenceUnit;
import br.com.caelum.vraptor.sysweb.util.XmlUtil;
/**
 * @author fidelis.guimaraeso
 *
 */
public class RecursoTest extends GenericTest {

	@Before
	public void setUp(){
		super.setUp();
		
	}
	
	/**
	 * Deverá ler o persistence e conferir a existencia do mapeamento da entidade
	 * @throws FileNotFoundException
	 */
	@Test
	public void testDeveEstaMapeadoNoPersistence() throws FileNotFoundException{
		Persistence xml = XmlUtil.getPersistenceXml();
		
		assertTrue("xml de persistencia deve existir", xml != null);
		
		boolean isContains = false;
		for (PersistenceUnit pu : xml.getPersistence_unit()) {
			for (Classe classe: pu.getClasse()){
				if(classe.getValue().equals(Recurso.class.getName())){
					isContains = true;
					break;
				}
			}
		}
		assertTrue("deve conter a classe mapeada", isContains);
	}
	
}
