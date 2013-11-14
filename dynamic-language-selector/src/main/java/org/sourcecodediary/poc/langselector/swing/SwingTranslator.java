package org.sourcecodediary.poc.langselector.swing;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.table.AbstractTableModel;

import org.sourcecodediary.poc.langselector.base.LanguageTranslator;
import org.sourcecodediary.poc.langselector.swing.listener.AbstractButtonLanguageListener;
import org.sourcecodediary.poc.langselector.swing.listener.AbstractTableModelLanguageListener;
import org.sourcecodediary.poc.langselector.swing.listener.JLabelLanguageListener;


public class SwingTranslator {

	/* Private constructor prevents instantiation from other classes */
	private SwingTranslator() {}

	// --- JLabel support ---------------------------------------------

	public static <T> JLabelLanguageListener translateLabel(Class<T> clazz, JLabel label, String messageKey) {
		String bundleName = LanguageTranslator.createBundleBaseName(clazz);
		return translateLabel(label, bundleName, messageKey);
	}

	public static JLabelLanguageListener translateLabel(JLabel label, String bundleBaseName, String messageKey) {
		setLabelText(label, bundleBaseName, messageKey);
		return JLabelLanguageListener.register(label, bundleBaseName, messageKey);
	}

	private static void setLabelText(JLabel label, String bundleBaseName, String messageKey) {
		String message = LanguageTranslator.getMessage(bundleBaseName, messageKey);
		label.setText(message);
	}

	// --- JRadioButton support ----------------------------------------

	public static <T> AbstractButtonLanguageListener translateRadioButton(Class<T> clazz, JRadioButton radioButton, String messageKey) {
		return translateAbstractButton(clazz, radioButton, messageKey);
	}

	public static AbstractButtonLanguageListener translateRadioButton(JRadioButton radioButton, String bundleBaseName, String messageKey) {
		return translateAbstractButton(radioButton, bundleBaseName, messageKey);
	}


	// --- JCheckBox support -------------------------------------------

	public static <T> AbstractButtonLanguageListener translateCheckBox(Class<T> clazz, JCheckBox checkBox, String messageKey) {
		return translateAbstractButton(clazz, checkBox, messageKey);
	}

	public static AbstractButtonLanguageListener translateCheckBox(JCheckBox checkBox, String bundleBaseName, String messageKey) {
		return translateAbstractButton(checkBox, bundleBaseName, messageKey);
	}


	// --- JMenu support ----------------------------------------------

	public static <T> AbstractButtonLanguageListener translateMenu(Class<T> clazz, JMenu menu, String messageKey) {
		return translateAbstractButton(clazz, menu, messageKey);
	}

	public static AbstractButtonLanguageListener translateMenu(JMenu menu, String bundleBaseName, String messageKey) {
		return translateAbstractButton(menu, bundleBaseName, messageKey);
	}


	// --- JMenuItem support ------------------------------------------

	public static <T> AbstractButtonLanguageListener translateMenuItem(Class<T> clazz, JMenuItem menuItem, String messageKey) {
		return translateAbstractButton(clazz, menuItem, messageKey);
	}

	public static AbstractButtonLanguageListener translateMenuItem(JMenuItem menuItem, String bundleBaseName, String messageKey) {
		return translateAbstractButton(menuItem, bundleBaseName, messageKey);
	}


	// --- AbstractButton support -------------------------------------

	private static <T> AbstractButtonLanguageListener translateAbstractButton(Class<T> clazz, AbstractButton button, String messageKey) {
		String bundleName = LanguageTranslator.createBundleBaseName(clazz);
		return translateAbstractButton(button, bundleName, messageKey);
	}

	private static AbstractButtonLanguageListener translateAbstractButton(AbstractButton button, String bundleBaseName, String messageKey) {
		setAbstractButtonText(button, bundleBaseName, messageKey);
		return AbstractButtonLanguageListener.register(button, bundleBaseName, messageKey);
	}

	private static void setAbstractButtonText(AbstractButton button, String bundleBaseName, String messageKey) {
		String message = LanguageTranslator.getMessage(bundleBaseName, messageKey);
		button.setText(message);
	}


	// --- JTable support ---------------------------------------------

	public static <T> AbstractTableModelLanguageListener translateTable(AbstractTableModel tableModel) {
		return AbstractTableModelLanguageListener.register(tableModel);
	}

}
