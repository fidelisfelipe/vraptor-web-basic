package br.com.caelum.vraptor.sysweb.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.jboss.weld.context.http.HttpRequestContext;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.sysweb.dao.impl.DefaultVacinaDao;
import br.com.caelum.vraptor.sysweb.model.Vacina;
import br.com.caelum.vraptor.validator.Validator;

@Path("/vacinas")
@Controller
public class VacinasController {

	private Result result;
	private Validator validator;
	// TODO: trocar por interface
	private final DefaultVacinaDao dao;
	private HttpServletRequest req;

	public VacinasController() {
		this(null, null, null, null);
	}

	@Inject
	public VacinasController(Result result, DefaultVacinaDao dao,
			Validator validator, HttpServletRequest req) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.req = req;
	}

	@Get({ "", "/" })
	public void index() {
	}

	@Get("/add")
	public void form() {
		result.include("path", req.getContextPath());
	}

	@Get("/list")
	public List<Vacina> list() {
		result.include("path", req.getContextPath());
		return dao.listAll();
	}

	@Post("/add")
	public void add(Vacina vacina) {
		dao.persist(vacina);
		result.redirectTo(this).list();
	}

	@Put("/update")
	public void update(Vacina vacina) {
	}

	@Delete("/remove")
	public void remove(Vacina vacina) {
	}

}
