package org.sourcecodediary.poc.langselector.base;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguageTranslator {

	/* Private constructor prevents instantiation from other classes */
	private LanguageTranslator() {}

	public static String getMessage(String bundleBaseName, String messageKey) {
		Language currentLanguage = LanguageSelector.getInstance().getLanguage();
		return getMessage(currentLanguage, bundleBaseName, messageKey);
	}

	public static String getMessage(Language language, String bundleBaseName, String messageKey) {
	    try {
	      ResourceBundle bundle = ResourceBundle.getBundle(bundleBaseName, language.getLocale());
	      String message = bundle.getString(messageKey);
	      return message;
	    } catch (MissingResourceException exception) {
	      System.err.println(exception);
	      return messageKey;
	    }
	}

	public static <T> String createBundleBaseName(Class<T> clazz) {
		return clazz.getPackage().getName() + "." + clazz.getSimpleName().toLowerCase();
	}

}
