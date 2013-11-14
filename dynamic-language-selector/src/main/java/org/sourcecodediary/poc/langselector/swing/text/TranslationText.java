package org.sourcecodediary.poc.langselector.swing.text;

import org.sourcecodediary.poc.langselector.base.LanguageTranslator;

public class TranslationText {

	private final String bundleBaseName;
	private final String messageKey;

	public TranslationText(Class<?> clazz, String messageKey) {
		this(LanguageTranslator.createBundleBaseName(clazz), messageKey);
	}

	public TranslationText(String bundleBaseName, String messageKey) {
		this.bundleBaseName = bundleBaseName;
		this.messageKey = messageKey;
	}

	@Override
	public String toString() {
		return LanguageTranslator.getMessage(bundleBaseName, messageKey);
	}

}
