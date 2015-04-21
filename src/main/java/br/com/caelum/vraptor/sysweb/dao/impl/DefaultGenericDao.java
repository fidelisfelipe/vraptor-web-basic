package br.com.caelum.vraptor.sysweb.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.sysweb.util.PreconditionUtil;

/**
 * @author fidelis.guimaraes
 *
 * @param <T>
 */
@PersistenceContext
public class DefaultGenericDao<T> {
	private Session session;
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public DefaultGenericDao(Session session) {
		this.session = session;
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Session getSession() {
		return this.session;
	}

	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	public boolean containsId(Long id) {
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(id);
		return this.session.createCriteria(this.persistentClass)
				.add(Restrictions.eq("id", id)).uniqueResult() != null;
	}
	
	public boolean containsId(Integer id) {
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(id);
		return containsId(id.longValue());
	}

	public boolean containsName(String nome) {
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(nome);
		return this.session.createCriteria(this.persistentClass)
				.add(Restrictions.eq("nome", nome)).uniqueResult() != null;
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String nome) {
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(nome);
		return this.session.createCriteria(this.persistentClass)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.addOrder(Order.asc("id")).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String criterio, String propriedade) {
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(criterio);
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(propriedade);
		return this.session
				.createCriteria(this.persistentClass)
				.add(Restrictions.ilike(propriedade, criterio,
						MatchMode.ANYWHERE)).addOrder(Order.asc("id")).list();
	}

	public void persist(T t) {
		this.session.persist(t);
	}

	public void saveOrUpdate(T t) {
		this.session.saveOrUpdate(t);
	}

	public void update(T t) {
		this.session.merge(t);
	}

	public void delete(T t) {
		this.session.delete(t);
	}

	public void refresh(T t) {
		this.session.refresh(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		return this.session.createCriteria(this.persistentClass)
				.addOrder(Order.desc("id")).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> listWithLimit(int qnt) {
		return this.session.createCriteria(this.persistentClass)
				.setMaxResults(qnt).addOrder(Order.asc("id")).list();
	}

	public T load(Long id) {
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(id);
		return (T) this.session.get(this.persistentClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public T load(Integer id) {
		PreconditionUtil.isNotNullDoThrowsIllegalArgumentException(id);
		return load(id.longValue());
	}

	public Integer rowCount() {
		return (Integer) this.session.createCriteria(this.persistentClass)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> loadPage(int limitPage, int pageCurrent) {
		int initial = pageCurrent * limitPage;
		return this.session.createCriteria(this.persistentClass)
				.setFirstResult(initial).setMaxResults(limitPage).list();
	}
}