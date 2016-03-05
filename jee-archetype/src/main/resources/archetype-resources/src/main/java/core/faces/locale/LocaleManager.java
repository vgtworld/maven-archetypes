package ${package}.core.faces.locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class LocaleManager implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocaleManager.class);

	private Locale activeLocale;

	public Locale getActiveLocale() {
		return activeLocale;
	}

	public String getActiveLanguage() {
		return activeLocale.getLanguage();
	}

	public void setActiveLanguage(String locale) {
		LOGGER.debug("Change session locale. locale:{}", locale);
		activeLocale = new Locale(locale);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(activeLocale);
	}

	@PostConstruct
	public void init() {
		Locale requestLocale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		LOGGER.debug("Setting session locale based on request. locale:{}", requestLocale);
		activeLocale = requestLocale;
	}

}
