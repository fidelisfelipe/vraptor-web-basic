package br.com.caelum.vraptor.sysweb.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class UsuarioController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected UsuarioController() {
		this(null);
	}
	
	@Inject
	public UsuarioController(Result result) {
		this.result = result;
	}

	@Path("/usuarios")
	public void index() {
		result.include("variable", "Usuário!");
	}
}