package org.sourcecodediary.poc.langselector.base;

import java.util.Locale;

public enum Language {

	GERMAN	(Locale.GERMAN, "language.german"),
	ENGLISH	(Locale.ENGLISH, "language.english"),
	ITALIAN	(Locale.ITALIAN, "language.italian");

	private static final String BUNDLE_BASE_NAME =
			LanguageTranslator.createBundleBaseName(Language.class);

	private Locale locale;

	private String messageKey;

	private Language(Locale locale, String messageKey) {
		this.locale = locale;
		this.messageKey = messageKey;
	}

	public Locale getLocale() {
		return locale;
	}

	@Override
	public String toString() {
		return LanguageTranslator.getMessage(BUNDLE_BASE_NAME, messageKey);
	}

}
