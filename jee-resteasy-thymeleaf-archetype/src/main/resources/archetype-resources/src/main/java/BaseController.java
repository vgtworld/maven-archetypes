package ${package};

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

public abstract class BaseController {
	
	@Inject
	private TemplateEngine templateEngine;
	
	@Context
	protected HttpServletRequest request;
	
	@Context
	protected HttpServletResponse response;
	
	protected void setPageTitle(String title) {
		request.setAttribute("pageTitle", title);
	}
	
	protected String render(String view) {
		WebContext context = new WebContext(request, response, request.getServletContext(), request.getLocale());
		return templateEngine.process(view, context);
	}
	
}
