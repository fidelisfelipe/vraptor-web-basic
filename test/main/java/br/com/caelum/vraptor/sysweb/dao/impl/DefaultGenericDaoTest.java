package br.com.caelum.vraptor.sysweb.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import br.com.caelum.vraptor.sysweb.annotations.GenericTest;

/**
 * @author fidelis.guimaraes
 *
 */
public class DefaultGenericDaoTest extends GenericTest {

	@Mock
	private Session session;
	@Mock
	private Criteria criteria;

	/**
	 * @author fidelis.guimaraes
	 *
	 */
	class EntidadeTest {
		private Long id;
		private String name;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	/**
	 * @author fidelis.guimaraes
	 *
	 */
	class TestDefaultDao extends DefaultGenericDao<EntidadeTest> {

		public TestDefaultDao(Session session) {
			super(session);
		}

	}

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testConstructor() {
		TestDefaultDao daoTest = new TestDefaultDao(session);
		assertEquals(EntidadeTest.class, daoTest.getPersistentClass());
		assertNotNull("deve ter uma sessao criada", daoTest.getSession());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContainsIdFailIdIntegerIsNullDoThrowsIllegalArgumentException(){
		TestDefaultDao daoTest = new TestDefaultDao(session);
		Integer id = null;
		daoTest.containsId(id);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testContainsIdFailIdLongIsNullDoThrowsIllegalArgumentException(){
		TestDefaultDao daoTest = new TestDefaultDao(session);
		Long id = null;
		daoTest.containsId(id);
	}
	@Test
	public void testContainsId(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		test.setId(1l);
		//deve ser passado para criteria.add
		SimpleExpression se = Restrictions.eq("id", test.getId());
		
		//when
		when(session.createCriteria(daoTest.getPersistentClass())).thenReturn(criteria);
		when(criteria.add(any(se.getClass()))).thenReturn(criteria);
		when(criteria.uniqueResult()).thenReturn(new Object());
		//then
		daoTest.containsId(test.getId());
		
		verify(session).createCriteria(daoTest.getPersistentClass());
		verify(criteria).add(any(se.getClass()));
		verify(criteria).uniqueResult();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testContainsNameFailNameIsNullDoThrowsIllegalArgumentException(){
		TestDefaultDao daoTest = new TestDefaultDao(session);
		String nome = null;
		daoTest.containsName(nome);
	}
	@Test
	public void testContainsName(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		test.setName("name");
		//deve ser passado para criteria.add
		SimpleExpression se = Restrictions.eq("name", test.getName());
		
		//when
		when(session.createCriteria(daoTest.getPersistentClass())).thenReturn(criteria);
		when(criteria.add(any(se.getClass()))).thenReturn(criteria);
		when(criteria.uniqueResult()).thenReturn(new Object());
		
		//then
		daoTest.containsName(test.getName());
		
		verify(session).createCriteria(daoTest.getPersistentClass());
		verify(criteria).add(any(se.getClass()));
		verify(criteria).uniqueResult();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindNameFailNameIsNullDoThrowsIllegalArgumentException(){
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		daoTest.find(test.getName());
	}
	
	@Test
	public void testFindName(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		test.setName("name");
		//deve ser passado para criteria.add
		Criterion criterion  = Restrictions.ilike("nome", test.getName(), MatchMode.ANYWHERE);
		//deve ser passado para crietria.addOrder
		Order order = Order.asc("id");
		
		//when
		when(session.createCriteria(daoTest.getPersistentClass())).thenReturn(criteria);
		when(criteria.add(any(criterion.getClass()))).thenReturn(criteria);
		when(criteria.addOrder(any(order.getClass()))).thenReturn(criteria);
		when(criteria.list()).thenReturn(anyList());
		
		//then
		List list = daoTest.find(test.getName());
		
		assertNotNull("deve retornar algo", list);
		
		verify(session).createCriteria(daoTest.getPersistentClass());
		verify(criteria).add(any(criterion.getClass()));
		verify(criteria).addOrder(any(order.getClass()));
		verify(criteria).list();
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFindCriterioFailCriterioIsNullDoThrowsIllegalArgumentException(){
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		daoTest.find(test.getName() , "nome");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFindCriterioFailPropriedadeIsNullDoThrowsIllegalArgumentException(){
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		test.setName("nome");
		daoTest.find(test.getName() , null);
	}
	
	@Test
	public void testFindCriterio(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		test.setName("name");
		String propriedade = "name";
		//deve ser passado para criteria.add
		Criterion criterion  = Restrictions.ilike(propriedade, test.getName(), MatchMode.ANYWHERE);
		//deve ser passado para crietria.addOrder
		Order order = Order.asc("id");
		
		//when
		when(session.createCriteria(daoTest.getPersistentClass())).thenReturn(criteria);
		when(criteria.add(any(criterion.getClass()))).thenReturn(criteria);
		when(criteria.addOrder(any(order.getClass()))).thenReturn(criteria);
		when(criteria.list()).thenReturn(anyList());
		
		//then
		List list = daoTest.find(test.getName(), propriedade);
		
		assertNotNull("deve retornar algo", list);
		
		verify(session).createCriteria(daoTest.getPersistentClass());
		verify(criteria).add(any(criterion.getClass()));
		verify(criteria).addOrder(any(order.getClass()));
		verify(criteria).list();
		
	}
	
	@Test
	public void persist(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		
		//when
		doNothing().when(session).persist(test);
		
		//then
		daoTest.persist(test);
		
		verify(session).persist(test);
	}
	
	@Test
	public void update(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		
		//when
		doNothing().when(session).update(test);
		
		//then
		daoTest.update(test);
		
		verify(session).merge(test);
	}
	
	@Test
	public void delete(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		
		//when
		doNothing().when(session).delete(test);
		
		//then
		daoTest.delete(test);
		
		verify(session).delete(test);
	}
	
	@Test
	public void refresh(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		
		//when
		doNothing().when(session).refresh(test);
		
		//then
		daoTest.refresh(test);
		
		verify(session).refresh(test);
	}
	
	@Test
	public void listAll(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		//deve ser passado para crietria.addOrder
		Order order = Order.asc("id");
		
		//when
		when(session.createCriteria(daoTest.getPersistentClass())).thenReturn(criteria);
		when(criteria.addOrder(any(order.getClass()))).thenReturn(criteria);
		when(criteria.list()).thenReturn(anyList());
		
		//then
		List list = daoTest.listAll();
		
		assertNotNull("deve retornar algo", list);
		
		verify(session).createCriteria(daoTest.getPersistentClass());
		verify(criteria).addOrder(any(order.getClass()));
		verify(criteria).list();
	}
	@Test
	public void listWithLimit(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		int qntRegistros = 10;
		//deve ser passado para crietria.addOrder
		Order order = Order.asc("id");
		
		//when
		when(session.createCriteria(daoTest.getPersistentClass())).thenReturn(criteria);
		when(criteria.setMaxResults(qntRegistros)).thenReturn(criteria);
		when(criteria.addOrder(any(order.getClass()))).thenReturn(criteria);
		when(criteria.list()).thenReturn(anyList());
		
		//then
		List list = daoTest.listWithLimit(qntRegistros);
		
		assertNotNull("deve retornar algo", list);
		
		verify(session).createCriteria(daoTest.getPersistentClass());
		verify(criteria).setMaxResults(qntRegistros);
		verify(criteria).addOrder(any(order.getClass()));
		verify(criteria).list();
	}
	
	@Test
	public void loadLong(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		test.setId(1l);
		
		//when
		when(session.get(test.getClass(), test.getId())).thenReturn(new EntidadeTest());
		
		//then
		EntidadeTest retorno = daoTest.load(test.getId());
		
		assertNotNull("deve retornar algo", retorno);
		
		verify(session).get(daoTest.getPersistentClass(), test.getId());
	}
	@Test
	public void loadInteger(){
		//given
		TestDefaultDao daoTest = new TestDefaultDao(session);
		EntidadeTest test = new EntidadeTest();
		test.setId(1l);
		
		//when
		when(session.get(test.getClass(), test.getId().longValue())).thenReturn(new EntidadeTest());
		
		//then
		EntidadeTest retorno = daoTest.load(test.getId().intValue());
		
		assertNotNull("deve retornar algo", retorno);
		
		verify(session).get(daoTest.getPersistentClass(), test.getId().longValue());
	}
	
	//Falta rowCount e LoadPage test
	
	
}
