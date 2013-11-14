package org.sourcecodediary.poc.langselector.swing.listener;

import javax.swing.table.AbstractTableModel;

import org.sourcecodediary.poc.langselector.api.ILanguageChangeListener;
import org.sourcecodediary.poc.langselector.base.Language;
import org.sourcecodediary.poc.langselector.base.LanguageSelector;


public class AbstractTableModelLanguageListener implements ILanguageChangeListener {

	private final AbstractTableModel tableModel;

	private AbstractTableModelLanguageListener(AbstractTableModel tableModel) {
		this.tableModel = tableModel;
	}

	@Override
	public void languageChanged(Language language) {
		tableModel.fireTableStructureChanged();
	}

	public static AbstractTableModelLanguageListener register(AbstractTableModel tableModel) {
		AbstractTableModelLanguageListener listener = new AbstractTableModelLanguageListener(tableModel);
		LanguageSelector.getInstance().addListener(listener);
		return listener;
	}

	public static void deregister(AbstractTableModelLanguageListener listener) {
		LanguageSelector.getInstance().removeListener(listener);
	}

}