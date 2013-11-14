package org.sourcecodediary.poc.langselector.swing.listener;

import javax.swing.AbstractButton;

import org.sourcecodediary.poc.langselector.api.ILanguageChangeListener;
import org.sourcecodediary.poc.langselector.base.Language;
import org.sourcecodediary.poc.langselector.base.LanguageSelector;
import org.sourcecodediary.poc.langselector.base.LanguageTranslator;


//TODO: introduce also a method for tooltip translation
public class AbstractButtonLanguageListener implements ILanguageChangeListener {

	private final AbstractButton button;
	private final String bundleBaseName;
	private final String messageKey;

	private AbstractButtonLanguageListener(AbstractButton button, String bundleBaseName, String messageKey) {
		this.button = button;
		this.bundleBaseName = bundleBaseName;
		this.messageKey = messageKey;
	}

	@Override
	public void languageChanged(Language language) {
		String message = LanguageTranslator.getMessage(language, bundleBaseName, messageKey);
		button.setText(message);
	}

	public static AbstractButtonLanguageListener register(AbstractButton button, String bundleBaseName, String messageKey) {
		AbstractButtonLanguageListener listener = new AbstractButtonLanguageListener(button, bundleBaseName, messageKey);
		LanguageSelector.getInstance().addListener(listener);
		return listener;
	}

	public static void deregister(AbstractButtonLanguageListener listener) {
		LanguageSelector.getInstance().removeListener(listener);
	}

}
