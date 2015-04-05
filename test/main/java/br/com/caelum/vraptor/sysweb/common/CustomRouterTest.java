package br.com.caelum.vraptor.sysweb.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.asm.MethodAdapter;
import org.mockito.stubbing.Answer;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.controller.BeanClass;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.DefaultBeanClass;
import br.com.caelum.vraptor.controller.DefaultControllerMethod;
import br.com.caelum.vraptor.core.ReflectionProvider;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.sysweb.annotations.GenericTest;
import static org.junit.Assert.*;

/**
 * @author fidelis.guimaraes
 *
 */
public class CustomRouterTest extends GenericTest {

	private CustomRouterMock customRouter;

	@Controller
	class ControllerTest {
		@Get
		public void get() {
		}

		@Post
		public void post() {
		}

		@Delete
		public void delete() {
		}

		@Put
		public void put() {
		}
	}

	class CustomRouterMock extends CustomRouter {
		@Override
		protected String[] getURIsFor(Method javaMethod, Class<?> type) {
			return new String[] { "" };
		}
	}

	@Before
	public void setUp() {
		customRouter = spy(new CustomRouterMock());

	}

	@Test
	public void testMethodsAnnotations() throws NoSuchMethodException, SecurityException {
		BeanClass beanClass = new DefaultBeanClass(ControllerTest.class);

		Map<String, String> mapaRotas = new HashMap<String, String>();
		for (Method method : ControllerTest.class.getDeclaredMethods()) {

			DefaultControllerMethod controllerMethod = spy(new DefaultControllerMethod(beanClass, method));

			when(customRouter.getURIsFor(any(Method.class), any(Class.class)))
					.thenReturn(new String[] { "URI:/" + method.getName() });

			mapaRotas = customRouter.getURIsForMethod(controllerMethod);

		}
		assertTrue("o mapa de rotas deve ser preenchido", mapaRotas.size() > 0);
	}

}
