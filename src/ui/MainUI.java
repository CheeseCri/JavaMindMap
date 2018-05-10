package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class MainUI extends JFrame {
   
   public static void main(String[] args) {
      MainUI start = new MainUI();
   }
   
   private JMenuBar mainMenuBar;
   private JToolBar toolBar;
   private JPanel mindMapPane;
   private JPanel settingPane;
   private JTextArea textEditorPane;
   private JPanel menuPanel;
   private JPanel textAreaPanel;
   private JPanel settingPanel;
   
   public MainUI() {
      super("mindmap");
      super.setLayout(new BorderLayout());
      
      
      /* Init Member */
      mindMapPane = new JPanel();
      settingPane = new JPanel();
      textEditorPane = new JTextArea();
      menuPanel = new JPanel(new BorderLayout());
      mainMenuBar = new JMenuBar();
      toolBar = new JToolBar();
      textAreaPanel = new JPanel(new BorderLayout());
      settingPanel = new JPanel(new BorderLayout());
      
//      JMenu menu = new JMenu("HI");
//      mainMenuBar.add(menu);
      
      /* JFrame(MainFrame) init size, Location */
      Dimension frameDimension = new Dimension(1400, 700);
      super.setPreferredSize(frameDimension);
      super.setLocation(100, 100);
      
      /* Make ScorllPane, Split Pane */
      JScrollPane mindMapScrollPane = new JScrollPane(mindMapPane);
      JScrollPane settingScrollPane = new JScrollPane(settingPane);
      JScrollPane textEditorScrollPane = new JScrollPane(textEditorPane);
      
      JSplitPane textAndSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      JSplitPane mindAndSettingPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      
      textAreaPanel.add(textEditorScrollPane, BorderLayout.CENTER);
      settingPanel.add(settingScrollPane, BorderLayout.CENTER);
      //textAreaPanel.add(new JButton("HIHIHI"), BorderLayout.SOUTH);
      
      
      /* Add Component in SplitPane */
      textAndSplitPane.setLeftComponent(textAreaPanel);
      textAndSplitPane.setRightComponent(mindAndSettingPane);

      mindAndSettingPane.setLeftComponent(mindMapScrollPane);
      mindAndSettingPane.setRightComponent(settingPanel);
      
      /* Init SplitPane */
      textAndSplitPane.setDividerSize(15);
      textAndSplitPane.setDividerLocation(250);
      mindAndSettingPane.setDividerLocation(800);
      
      /* Add MenuPanel and SplitPane in MainFrame */
      menuPanel.add(mainMenuBar, BorderLayout.NORTH);
      menuPanel.add(toolBar, BorderLayout.SOUTH);
      
      super.add(textAndSplitPane, BorderLayout.CENTER);
      super.add(menuPanel, BorderLayout.NORTH);
      
      /* MainFrame Visible and Setting */
      super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      super.pack();
      super.setVisible(true);
      
   }

}