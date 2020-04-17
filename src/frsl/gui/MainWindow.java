package frsl.gui;

import static frsl.gui.GuiUtil.addToToolBar;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import frsl.grammar.GrammarUtil;
import frsl.metamodel.UseCase;
import frsl.runtime.IPluginActionExtensionPoint;
import frsl.runtime.IRuntime;
import frsl.runtime.Log;
import frsl.runtime.PluginActionProxy;
import frsl.runtime.RuntimeUtil;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	// UI components
	public static MainWindow instance;

	private JPanel contentPane;

	private JToolBar toolBar;

	private JMenuBar menuBar;

	private JMenu fileMenu;

	private JMenu helpMenu;

	private JMenu pluginsMenu;

	private JMenuItem fileOpenMenuIteam;

	private JMenuItem aboutMenuIteam;

	// UI actions
	private ActionFRSLTextFileOpen actionFRSLTextFileOpen = new ActionFRSLTextFileOpen();

	private ActionHelpAbout actionHelpAbout = new ActionHelpAbout();

	private ActionCompileAndRun actionCompileAndRun = new ActionCompileAndRun();

	// data
	public String test = "hello from main window";

	private UseCase metaModel;

	private static IRuntime pluginRuntime;

	private Map<Map<String, String>, PluginActionProxy> pluginActions = new HashMap<Map<String, String>, PluginActionProxy>();

	public MainWindow() {
		super("FRSL");
		instance = this;
		pluginRuntime = RuntimeUtil.loadPlugin();

		ImageIcon img = new ImageIcon("resource/icon.png");
		setIconImage(img.getImage());
		setBounds(10, 20, 1100, 700);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) ((dimension.getWidth() - getWidth()) / 2), (int) ((dimension.getHeight() - getHeight()) / 2));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});

		contentPane = new FRSLSpecificationTextEditor();
		setContentPane(contentPane);

		toolBar = new JToolBar();
		addToToolBar(toolBar, actionFRSLTextFileOpen, "Open FRSL text file", null);
		addToToolBar(toolBar, actionCompileAndRun, "Compile and run", "Compile and run");
		add(toolBar, BorderLayout.PAGE_START);

		menuBar = new JMenuBar();
		getRootPane().setJMenuBar(menuBar);

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);
		fileOpenMenuIteam = fileMenu.add(actionFRSLTextFileOpen);
		fileOpenMenuIteam.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
		fileOpenMenuIteam.setMnemonic('O');

		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		aboutMenuIteam = helpMenu.add(actionHelpAbout);
		aboutMenuIteam.setMnemonic('A');

		pluginsMenu = new JMenu("Plugins");
		pluginsMenu.setMnemonic('P');
		menuBar.add(pluginsMenu);

		IPluginActionExtensionPoint actionExtensionPoint = (IPluginActionExtensionPoint) pluginRuntime
				.getExtensionPoint("action");

		pluginActions = actionExtensionPoint.createPluginActions(this);

		Set<Map.Entry<Map<String, String>, PluginActionProxy>> pluginActionSet = pluginActions.entrySet();

		for (Map.Entry<Map<String, String>, PluginActionProxy> currentActionMapEntry : pluginActionSet) {
			Map<String, String> currentActionDescMap = currentActionMapEntry.getKey();
			AbstractAction currentAction = currentActionMapEntry.getValue();
			addToToolBar(toolBar, currentAction, currentActionDescMap.get("tooltip"),
					currentActionDescMap.get("toolbaritem"));

			// Creating submenu and menu entries
			if (currentActionDescMap.get("menu").toString() == null) {
				Log.debug("Adding [" + currentActionDescMap.get("menuitem").toString() + "] to plugins menu");
				pluginsMenu.add(currentAction);
			} else {
				// Check if submenu already exists
				Component[] menuItems = pluginsMenu.getMenuComponents();
				boolean createNewMenu = true;
				Log.debug("Menu item length was [" + menuItems.length + "]");
				for (int iterateMenuItems = 0; iterateMenuItems < menuItems.length;) {
					Log.debug("Menu item is of type [" + menuItems[iterateMenuItems].getClass() + "]");
					if (menuItems[iterateMenuItems] instanceof JMenu) {
						JMenu currentMenu = (JMenu) menuItems[iterateMenuItems];
						Log.debug("Compairing menu [" + currentMenu.getText() + "] and ["
								+ currentActionDescMap.get("menu").toString() + "]");
						if (currentMenu.getText().equals(currentActionDescMap.get("menu").toString())) {
							Log.debug("Adding [" + currentActionDescMap.get("menuitem").toString() + "] to submenu ["
									+ currentMenu.getText() + "]");
							currentMenu.add(currentAction);
							createNewMenu = false;
							break;
						}
					}
					iterateMenuItems++;
				}
				if (createNewMenu) {
					Log.debug("Creating new Menu [" + currentActionDescMap.get("menuitem").toString() + "]");
					JMenu pluginSubmenu = new JMenu(currentActionDescMap.get("menu").toString());
					Log.debug("Adding [" + currentActionDescMap.get("menu").toString() + "] to new submenu ["
							+ pluginSubmenu.getText() + "]");
					pluginSubmenu.add(currentAction);
					pluginsMenu.add(pluginSubmenu);
				}
			}
		}
	}

	private class ActionFRSLTextFileOpen extends AbstractAction {
		ActionFRSLTextFileOpen() {
			super("Open FRSL text file");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser(".");
			c.setDialogTitle("Open FRSL text file");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			c.setFileFilter(filter);
			int rVal = c.showOpenDialog(instance);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				((FRSLSpecificationTextEditor) contentPane).loadFromFile(c.getSelectedFile().getPath());
			}
		}

	}

	private class ActionCompileAndRun extends AbstractAction {

		private static final long serialVersionUID = 1L;

		ActionCompileAndRun() {
			super("Compile and run");
		}

		public void actionPerformed(ActionEvent e) {
			metaModel = GrammarUtil.parseFromText(
					((FRSLSpecificationTextEditor) instance.getContentPane()).getFrslSpecificationText());
			if (metaModel == null) {
				JOptionPane.showMessageDialog(null, "Compilation failed", "Fail", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Compilation successfully", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	private class ActionHelpAbout extends AbstractAction {
		ActionHelpAbout() {
			super("About...");
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Call About...");
		}
	}

	// setter getter
	public UseCase getMetaModel() {
		return metaModel;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public JMenuBar getMenubar() {
		return menuBar;
	}

}