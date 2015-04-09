package br.com.caelum.vraptor.sysweb.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.sysweb.GenericTest;

/**
 * @author fidelis.guimaraes
 *
 */
public class PreconditionUtilTest extends GenericTest{

	@Before
	public void setUp(){
	}
	
	@Test
	public void testIsNotNullEhFalse(){
		assertFalse(PreconditionUtil.isNotNull(null));
	}
	@Test
	public void testIsNotNullEhTrue(){
		assertTrue(PreconditionUtil.isNotNull(this));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsNotEmptyEhFalse(){
		PreconditionUtil.isNotEmptyDoThrowsIllegalArgumentException(Collections.EMPTY_LIST);
	}
	
	@Test(expected = IllegalAccessException.class)
	public void testNotInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{
		PreconditionUtil.class.getDeclaredConstructors()[0].newInstance();
	}
}
