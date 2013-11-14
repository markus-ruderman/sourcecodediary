package org.sourcecodediary.poc.langselector.swing.listener;

import javax.swing.JLabel;

import org.sourcecodediary.poc.langselector.api.ILanguageChangeListener;
import org.sourcecodediary.poc.langselector.base.Language;
import org.sourcecodediary.poc.langselector.base.LanguageSelector;
import org.sourcecodediary.poc.langselector.base.LanguageTranslator;


//TODO: introduce also a method for tooltip translation
public class JLabelLanguageListener implements ILanguageChangeListener {

	private final JLabel label;
	private final String bundleBaseName;
	private final String messageKey;

	private JLabelLanguageListener(JLabel label, String bundleBaseName, String messageKey) {
		this.label = label;
		this.bundleBaseName = bundleBaseName;
		this.messageKey = messageKey;
	}

	@Override
	public void languageChanged(Language language) {
		String message = LanguageTranslator.getMessage(language, bundleBaseName, messageKey);
		label.setText(message);
	}

	public static JLabelLanguageListener register(JLabel label, String bundleBaseName, String messageKey) {
		JLabelLanguageListener listener = new JLabelLanguageListener(label, bundleBaseName, messageKey);
		LanguageSelector.getInstance().addListener(listener);
		return listener;
	}

	public static void deregister(JLabelLanguageListener listener) {
		LanguageSelector.getInstance().removeListener(listener);
	}

}
