package ${package}.core.faces.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.net.MalformedURLException;
import java.net.URL;

@FacesValidator("vgt.urlValidator")
public class UrlValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			return;
		}
		String input = value.toString();
		if (input.trim().isEmpty()) {
			return;
		}
		try {
			new URL(input);
		} catch (MalformedURLException e) {
			throw new ValidatorException(new FacesMessage("Invalid URL format"), e);
		}
	}

}