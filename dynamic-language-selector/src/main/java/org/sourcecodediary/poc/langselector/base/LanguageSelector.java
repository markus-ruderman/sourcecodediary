package org.sourcecodediary.poc.langselector.base;

import java.util.ArrayList;
import java.util.List;

import org.sourcecodediary.poc.langselector.api.ILanguageChangeListener;


public class LanguageSelector {

	private Language currentLanguage = Language.ENGLISH;

	private final List<ILanguageChangeListener> listenerList = new ArrayList<>();

    /* Private constructor prevents instantiation from other classes */
    private LanguageSelector() {}

    private static class SingletonHolder {
    	public static final LanguageSelector INSTANCE = new LanguageSelector();
    }

    public static LanguageSelector getInstance() {
    	return SingletonHolder.INSTANCE;
    }

	public void addListener(ILanguageChangeListener listener) {
		listenerList.add(listener);
	}

	public void removeListener(ILanguageChangeListener listener) {
		listenerList.remove(listener);
	}

	public void releaseAllListeners() {
		listenerList.clear();
	}

	public void setLanguage(Language language) {
		Language oldLanguage = currentLanguage;
		currentLanguage = language;
		fireLanguageChanged(oldLanguage, language);
	}

	public Language getLanguage() {
		return currentLanguage;
	}

	private void fireLanguageChanged(Language oldLanguage, Language newLanguage) {
		if (!oldLanguage.equals(newLanguage)) {

			System.out.println("Language was changed " +
									"from " + oldLanguage.toString() + " " +
									"to " + newLanguage.toString());

			for (ILanguageChangeListener listener : listenerList) {
				listener.languageChanged(newLanguage);
			}

		}
	}

}
