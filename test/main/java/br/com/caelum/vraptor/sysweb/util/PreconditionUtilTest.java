package br.com.caelum.vraptor.sysweb.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;

import org.jboss.weld.environment.servlet.util.Reflections;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import br.com.caelum.vraptor.sysweb.annotations.GenericTest;

/**
 * @author fidelis.guimaraes
 *
 */
public class PreconditionUtilTest extends GenericTest{

	@Before
	public void setUp(){
		super.setUp();
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
