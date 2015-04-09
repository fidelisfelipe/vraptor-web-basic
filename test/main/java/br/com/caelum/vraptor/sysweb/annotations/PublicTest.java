package br.com.caelum.vraptor.sysweb.annotations;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
/**
 * Anotação que permite acesso sem login aos métodos
 * @author fidelis.guimaraes
 *
 */
public class PublicTest {

	class PublicMockClass{
		@Public
		public void test(){}
	}
	
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testPublicPresent(){
		boolean isMetodoAnotado = false;
		
		PublicMockClass classe = new PublicMockClass();
		for (Method method : classe.getClass().getMethods()) {
			if(method.isAnnotationPresent(Public.class)){
				isMetodoAnotado = true;
				break;
			}
		}
		assertTrue("metodo deve estar anotado", isMetodoAnotado);
	}
	
}
