package org.sourcecodediary.poc.langselector.swing.text;

import org.sourcecodediary.poc.langselector.base.LanguageTranslator;

public class ColumnHeaderText {

	private final TranslationText translationText;

	public ColumnHeaderText(Class<?> clazz, String messageKey) {
		this(LanguageTranslator.createBundleBaseName(clazz), messageKey);
	}

	public ColumnHeaderText(String bundleBaseName, String messageKey) {
		this.translationText = new TranslationText(bundleBaseName, messageKey);
	}

	@Override
	public String toString() {
		return translationText.toString();
	}

}
