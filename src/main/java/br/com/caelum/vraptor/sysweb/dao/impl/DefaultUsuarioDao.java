package br.com.caelum.vraptor.sysweb.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.sysweb.dao.UsuarioDao;
import br.com.caelum.vraptor.sysweb.model.Usuario;

/**
 * @author fidelis.guimaraes
 *
 */
public class DefaultUsuarioDao extends DefaultGenericDao<Usuario> implements
		UsuarioDao {
	protected DefaultUsuarioDao() {
		this(null);
	}

	@Inject
	public DefaultUsuarioDao(Session session) {
		super(session);
	}

	public Usuario findForName(String name) {
		return (Usuario) find(name);
	}

	public List<Usuario> listAll() {
		return super.listAll();
	}

	public boolean containsUsuarioWithLogin(String nome) {
		Long count = (Long) getSession()
				.createQuery(
						"select count(u) from Usuario u where u.nome = :nome")
				.setParameter("nome", nome).uniqueResult();
		return count.longValue() > 0L;
	}

	public void add(Usuario usuario) {
		persist(usuario);
	}

	public void refresh(Usuario usuario) {
		super.refresh(usuario);
	}

	public Usuario load(Usuario usuario) {
		return (Usuario) load(usuario.getId());
	}

	public void remove(Usuario usuario) {
		Usuario object = load(usuario);
		if (object != null)
			delete(object);
	}

	/**
	 * Verifica se existe o usuário informado e ativo
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario existe(Usuario usuario) {
		if (usuario != null)
			return (Usuario) getSession().createCriteria(Usuario.class)
					.add(Restrictions.eq("email", usuario.getEmail()))
					.add(Restrictions.eq("senha", usuario.getSenha()))
					.add(Restrictions.eq("ativo", true)).uniqueResult();

		return usuario;
	}
}