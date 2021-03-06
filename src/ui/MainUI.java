package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Listener.AttributeButtenListener;
import Listener.TextAreaButtonListener;
import NodeTree.TreeClass;

public class MainUI extends JFrame {

	public static void main(String[] args) {
		MainUI start = new MainUI();
	}

	private static TreeClass treeClass;

	private JMenuBar mainMenuBar;
	private JToolBar toolBar;
	private JPanel mindMapPane;
	private JPanel settingPane;
	private JTextArea textEditorPane;
	private JPanel menuPanel;
	private JPanel textAreaPanel;
	private JPanel settingPanel;
	private JButton textAreaButton;
	private JButton settingAreaButton;
	private JLabel settingItemNameLabel;
	private JTextField settingItemNameEdit;
	private JLabel settingItemXLabel;
	private JTextField settingItemXEdit;
	private JLabel settingItemYLabel;
	private JTextField settingItemYEdit;
	private JLabel settingItemWLabel;
	private JTextField settingItemWEdit;
	private JLabel settingItemHLabel;
	private JTextField settingItemHEdit;
	private JLabel settingItemColorLabel;
	private JTextField settingItemColorEdit;

	public MainUI() {
		super("mindmap");
		super.setLayout(new BorderLayout());

		/* Init Member */
		mindMapPane = new JPanel();
		settingPane = new JPanel();
		textEditorPane = new JTextArea();
		textEditorPane.setTabSize(textEditorPane.getTabSize()/2);
		menuPanel = new JPanel(new BorderLayout());
		mainMenuBar = new JMenuBar();
		toolBar = new JToolBar();
		textAreaPanel = new JPanel(new BorderLayout());
		settingPanel = new JPanel(new BorderLayout());
		textAreaButton = new JButton("적용");
		settingAreaButton = new JButton("적용");
		mindMapPane.setLayout(null);

		/* Init Setting Panel's Member */
		settingItemNameLabel = new JLabel("Text  :");
		settingItemXLabel = new JLabel("X     :");
		settingItemYLabel = new JLabel("Y     :");
		settingItemHLabel = new JLabel("H     :");
		settingItemWLabel = new JLabel("W     :");
		settingItemColorLabel = new JLabel("Color :");
		settingItemNameEdit = new JTextField();
		settingItemNameEdit.setEditable(false);
		settingItemXEdit = new JTextField();
		settingItemYEdit = new JTextField();
		settingItemWEdit = new JTextField();
		settingItemHEdit = new JTextField();
		settingItemColorEdit = new JTextField();


		/* JFrame(MainFrame) init size, Location */
		Dimension frameDimension = new Dimension(1400, 700);
		super.setPreferredSize(frameDimension);
		super.setLocation(100, 100);

		/* Make ScorllPane, Split Pane */
		JScrollPane mindMapScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	      mindMapScrollPane.getViewport().setView(mindMapPane);
		JScrollPane settingScrollPane = new JScrollPane(settingPane);
		JScrollPane textEditorScrollPane = new JScrollPane(textEditorPane);

		JSplitPane textAndSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JSplitPane mindAndSettingPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		textAreaPanel.add(textEditorScrollPane, BorderLayout.CENTER);
		settingPanel.add(settingScrollPane, BorderLayout.CENTER);
		textAreaPanel.add(textAreaButton, BorderLayout.SOUTH);
		settingPanel.add(settingAreaButton, BorderLayout.SOUTH);

		/* Add Component in SplitPane */
		textAndSplitPane.setLeftComponent(textAreaPanel);
		textAndSplitPane.setRightComponent(mindAndSettingPane);

		mindAndSettingPane.setLeftComponent(mindMapScrollPane);
		mindAndSettingPane.setRightComponent(settingPanel);

		/* Init SplitPane */
		Dimension mindMapPainDimension = new Dimension(2500, 2000);
	    textAndSplitPane.setDividerLocation(250);
	    mindAndSettingPane.setDividerLocation(800);
	    mindMapPane.setPreferredSize(mindMapPainDimension);
		

		/* Add MenuPanel and SplitPane in MainFrame */
		menuPanel.add(mainMenuBar, BorderLayout.NORTH);
		menuPanel.add(toolBar, BorderLayout.SOUTH);

		/* Add Attribute in settingPanel */
		settingPane.setLayout(new GridLayout(6, 1, 50, 100));
		settingPane.add(settingItemNameLabel);
		settingPane.add(settingItemNameEdit);
		settingPane.add(settingItemXLabel);
		settingPane.add(settingItemXEdit);
		settingPane.add(settingItemYLabel);
		settingPane.add(settingItemYEdit);
		settingPane.add(settingItemWLabel);
		settingPane.add(settingItemWEdit);
		settingPane.add(settingItemHLabel);
		settingPane.add(settingItemHEdit);
		settingPane.add(settingItemColorLabel);
		settingPane.add(settingItemColorEdit);

		super.add(textAndSplitPane, BorderLayout.CENTER);
		super.add(menuPanel, BorderLayout.NORTH);

		/* addListenr button */
		TextAreaButtonListener textAreaButtonListener = new TextAreaButtonListener(textEditorPane, this.mindMapPane);
		textAreaButtonListener.initEditorMemeber(settingItemNameEdit, settingItemXEdit, settingItemYEdit,
				settingItemWEdit, settingItemHEdit, settingItemColorEdit);
		textAreaButton.addActionListener(textAreaButtonListener);

		AttributeButtenListener attributeButtenListener = new AttributeButtenListener();
		attributeButtenListener.initEditorMemeber(settingItemNameEdit, settingItemXEdit, settingItemYEdit,
				settingItemWEdit, settingItemHEdit, settingItemColorEdit);
		settingAreaButton.addActionListener(attributeButtenListener);

		MenuUI menuUI = new MenuUI(mainMenuBar, mindMapPane, settingItemNameEdit, settingItemXEdit, settingItemYEdit,
				settingItemWEdit, settingItemHEdit, settingItemColorEdit, attributeButtenListener,
				textAreaButtonListener);
		menuUI.setTextEditorPane(textEditorPane);
		menuUI.setMindMapPane(mindMapPane);
		menuUI.initEditorMemeber(settingItemNameEdit, settingItemXEdit, settingItemYEdit, settingItemWEdit,
				settingItemHEdit, settingItemColorEdit);

		ToolBarUI toolBarUI = new ToolBarUI(toolBar, mindMapPane, settingItemNameEdit, settingItemXEdit,
				settingItemYEdit, settingItemWEdit, settingItemHEdit, settingItemColorEdit, attributeButtenListener,
				textAreaButtonListener);
		toolBarUI.setTextEditorPane(textEditorPane);
		toolBarUI.setMindMapPane(mindMapPane);
		toolBarUI.initEditorMemeber(settingItemNameEdit, settingItemXEdit, settingItemYEdit, settingItemWEdit,
				settingItemHEdit, settingItemColorEdit);

		/* MainFrame Visible and Setting */
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.pack();
		super.pack();
		super.setVisible(true);

	}

	public static TreeClass getTreeClass() {
		return treeClass;
	}

	public static void setTreeClass(TreeClass treeClass) {
		MainUI.treeClass = treeClass;
	}

}