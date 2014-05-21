package ${package};

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Singleton
public class AppTemplateEngine {

	private TemplateEngine templateEngine;
	
	@Produces
	public TemplateEngine getTemplateEngine() {
		return templateEngine;
	}
	
	@PostConstruct
	public void init() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setTemplateMode("XHTML");
		templateResolver.setPrefix("/WEB-INF/pages/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheTTLMs(3600000L);
		
		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
	}
}
