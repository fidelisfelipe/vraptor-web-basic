package br.com.caelum.vraptor.sysweb.dao.impl;

import static org.junit.Assert.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.caelum.vraptor.sysweb.annotations.GenericTest;
import br.com.caelum.vraptor.sysweb.model.Usuario;

/**
 * @author fidelis.guimaraes
 *
 */
public class DefaultUsuarioDaoTest extends GenericTest {

	@Mock
	private Session session;
	@Mock
	private Criteria criteria;
	
	
	@Before
	public void setUp(){
		super.setUp();
	}

	@Test
	public void testExistTrue(){
		//given
		DefaultUsuarioDao daoTest = new DefaultUsuarioDao(session);
		Usuario usuario = new Usuario();
		usuario.setNome("nome");
		//deve ser passado para criteria.add
		SimpleExpression seEmail = Restrictions.eq("email", usuario.getEmail());
		SimpleExpression seSenha = Restrictions.eq("senha", usuario.getSenha());
		SimpleExpression seAtivo = Restrictions.eq("ativo", Boolean.TRUE);

		//when
		when(session.createCriteria(daoTest.getPersistentClass())).thenReturn(criteria);
		when(criteria.add(any(seEmail.getClass()))).thenReturn(criteria);
		when(criteria.add(any(seSenha.getClass()))).thenReturn(criteria);
		when(criteria.add(any(seAtivo.getClass()))).thenReturn(criteria);
		when(criteria.uniqueResult()).thenReturn(new Usuario());
		
		//then
		boolean isExists = daoTest.containsName(usuario.getNome());
		
		assertTrue("deve conter algo",isExists);
		
		verify(session).createCriteria(daoTest.getPersistentClass());
		verify(criteria).add(any(seEmail.getClass()));
		verify(criteria).add(any(seSenha.getClass()));
		verify(criteria).add(any(seAtivo.getClass()));
		verify(criteria).uniqueResult();
		
	}
	
}
