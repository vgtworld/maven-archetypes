package ${package}.app.hello;

import ${package}.app.hello.models.HelloModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class HelloController {

	private HelloModel model;

	public HelloModel getModel() {
		return model;
	}

	@PostConstruct
	public void init() {
		model = new HelloModel();
		model.setCurrentDate(new Date());
	}

}
