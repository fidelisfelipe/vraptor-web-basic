package br.com.caelum.vraptor.sysweb.dao.impl;

import javax.inject.Inject;

import org.hibernate.Session;

import br.com.caelum.vraptor.sysweb.dao.VacinaDao;
import br.com.caelum.vraptor.sysweb.model.Vacina;

/**
 * @author fidelis.guimaraes
 *
 */
public class DefaultVacinaDao extends DefaultGenericDao<Vacina>{

	public DefaultVacinaDao() {
		this(null);
	}
	
	@Inject
	public DefaultVacinaDao(Session session) {
		super(session);
	}

}
