package ${package}.core.faces.locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class LocaleManager implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocaleManager.class);

	public static final String LANG_EN = "en";

	public static final String LANG_PL = "pl";

	private static final List<String> AVAILABLE_LANGUAGES = Arrays.asList(LANG_EN, LANG_PL);

	private static final String DEFAULT_LANGUAGE = LANG_EN;

	private Locale activeLocale;

	public Locale getActiveLocale() {
		return activeLocale;
	}

	public String getActiveLanguage() {
		return activeLocale.getLanguage();
	}

	public void setActiveLanguage(String language) {
		LOGGER.debug("Change session locale. language:{}", language);
		if (!AVAILABLE_LANGUAGES.contains(language)) {
			LOGGER.warn("Language not available. Unable to change locale. language:{}", language);
			return;
		}
		activeLocale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(activeLocale);
	}

	public Map<String, String> getAvailableLanguages() {
		Map<String, String> availableLanguages = new LinkedHashMap<>();
		for (String availableLanguage : AVAILABLE_LANGUAGES) {
			availableLanguages.put(availableLanguage.toUpperCase(), availableLanguage);
		}
		return availableLanguages;
	}

	@PostConstruct
	public void init() {
		Locale requestLocale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		LOGGER.debug("Setting session locale based on request. locale:{}", requestLocale);
		if (!AVAILABLE_LANGUAGES.contains(requestLocale.getLanguage())) {
			LOGGER.debug("Language not available. Switching to default locale.");
			activeLocale = new Locale(DEFAULT_LANGUAGE);
			return;
		}
		activeLocale = requestLocale;
	}

}
