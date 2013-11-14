package org.sourcecodediary.poc.langselector.demo;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.looks.windows.WindowsLookAndFeel;

import javax.swing.JLabel;
import javax.swing.JComboBox;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import org.sourcecodediary.poc.langselector.base.Language;
import org.sourcecodediary.poc.langselector.base.LanguageSelector;
import org.sourcecodediary.poc.langselector.swing.SwingTranslator;
import org.sourcecodediary.poc.langselector.swing.text.ColumnHeaderText;
import org.sourcecodediary.poc.langselector.swing.text.TranslationText;

public class TestFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel labelOne;
	private JLabel labelTwo;
	private JComboBox<Language> languageComboBox;
	private JLabel labelLanguage;
	private JMenuBar menuBar;
	private JMenu menuOne;
	private JCheckBox checkBox;
	private JRadioButton radioButton;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(WindowsLookAndFeel.class.getName());
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow(100)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15dlu"),}));
		contentPane.add(getLabelOne(), "2, 2");
		contentPane.add(getCheckBox(), "4, 2");
		contentPane.add(getScrollPane(), "6, 2, 1, 5, fill, fill");
		contentPane.add(getLabelTwo(), "2, 4");
		contentPane.add(getRadioButton(), "4, 4");
		contentPane.add(getLabelLanguage(), "2, 8, right, default");
		contentPane.add(getLanguageComboBox(), "4, 8, 3, 1, fill, default");
	}

	public JLabel getLabelOne() {
		if (labelOne == null) {
			labelOne = createLabelOne();
		}
		return labelOne;
	}

	private JLabel createLabelOne() {
		JLabel label = new JLabel("labelOne");
		SwingTranslator.translateLabel(TestFrame.class, label, "label.one");
		return label;
	}

	public JLabel getLabelTwo() {
		if (labelTwo == null) {
			labelTwo = createLabelTwo();
		}
		return labelTwo;
	}

	private JLabel createLabelTwo() {
		JLabel label = new JLabel("labelTwo");
		SwingTranslator.translateLabel(TestFrame.class, label, "label.two");
		return label;
	}

	public JComboBox<Language> getLanguageComboBox() {
		if (languageComboBox == null) {
			languageComboBox = createLanguageComboBox();
		}
		return languageComboBox;
	}

	private JComboBox<Language> createLanguageComboBox() {
		JComboBox<Language> comboBox = new JComboBox<Language>();
		comboBox.setModel(createLanguageComboBoxModel());
		comboBox.addItemListener(createLanguageComboItemListener());
		comboBox.setSelectedItem(getCurrentLanguage());
		return comboBox;
	}

	private Language getCurrentLanguage() {
		return LanguageSelector.getInstance().getLanguage();
	}

	private DefaultComboBoxModel<Language> createLanguageComboBoxModel() {
		 return new DefaultComboBoxModel<Language>(Language.values());
	}

	private ItemListener createLanguageComboItemListener() {
		return new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				switch (event.getStateChange()) {
					case ItemEvent.SELECTED: {
						Language selectedLanguage = (Language)event.getItem();
						LanguageSelector.getInstance().setLanguage(selectedLanguage);
						break;
					}
					default: { break; }
				}
			}
		};
	}

	public JLabel getLabelLanguage() {
		if (labelLanguage == null) {
			labelLanguage = createLabelLanguage();
		}
		return labelLanguage;
	}

	private JLabel createLabelLanguage() {
		JLabel label = new JLabel("labelLanguage");
		SwingTranslator.translateLabel(TestFrame.class, label, "label.language");
		return label;
	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = createMenuBar();
		}
		return menuBar;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(getMenuOne());
		return menuBar;
	}

	public JMenu getMenuOne() {
		if (menuOne == null) {
			menuOne = createMenuOne();
			menuOne.add(createMenuItemOne());
			menuOne.add(createMenuItemTwo());
		}
		return menuOne;
	}

	private JMenu createMenuOne() {
		JMenu menu = new JMenu("MenuOne");
		SwingTranslator.translateMenu(TestFrame.class, menu, "menu.one");
		return menu;
	}

	private JMenuItem createMenuItemOne() {
		JMenuItem menuItem = new JMenuItem("MenuItemOne");
		SwingTranslator.translateMenuItem(TestFrame.class, menuItem, "menu.item.one");
		return menuItem;
	}

	private JMenuItem createMenuItemTwo() {
		JMenuItem menuItem = new JMenuItem("MenuItemTwo");
		SwingTranslator.translateMenuItem(TestFrame.class, menuItem, "menu.item.two");
		return menuItem;
	}

	public JCheckBox getCheckBox() {
		if(checkBox == null) {
			checkBox = createCheckBox();
		}
		return checkBox;
	}

	private JCheckBox createCheckBox() {
		JCheckBox checkBox = new JCheckBox("checkBox");
		SwingTranslator.translateCheckBox(TestFrame.class, checkBox, "checkbox.text");
		return checkBox;
	}

	public JRadioButton getRadioButton() {
		if(radioButton == null) {
			radioButton = createRadioButton();
		}
		return radioButton;
	}

	private JRadioButton createRadioButton() {
		JRadioButton radioButton = new JRadioButton("radioButton");
		SwingTranslator.translateRadioButton(TestFrame.class, radioButton, "radiobutton.text");
		return radioButton;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = createScrollPane();
		}
		return scrollPane;
	}

	private JScrollPane createScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(getTable());
		return scrollPane;
	}

	public JTable getTable() {
		if (table == null) {
			table = createTable();
		}
		return table;
	}

	private JTable createTable() {
		AbstractTableModel tableModel =
    		new DefaultTableModel(
    			new Object[][] {
    				{ new TranslationText(TestFrame.class, "column.value.one"), 	"1" },
    				{ new TranslationText(TestFrame.class, "column.value.three"), 	"3" },
    				{ new TranslationText(TestFrame.class, "column.value.five"), 	"5" },
    				{ new TranslationText(TestFrame.class, "column.value.seven"), 	"7" }
    			},
    			new ColumnHeaderText[] {
    				new ColumnHeaderText(TestFrame.class, "column.one"),
    				new ColumnHeaderText(TestFrame.class, "column.two")
    			}
    		);
		JTable table = new JTable(tableModel);
		SwingTranslator.translateTable(tableModel);
		return table;
	}

}