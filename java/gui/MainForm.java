/* Copyright (C) 2014 CompleteDB LLC.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with PubSubSQL.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainForm extends JFrame {

	private JMenuItem connectLocalMenu;
	private JButton connectLocalButton;
	private JMenuItem connectMenu;
	private JButton connectButton;
	private JMenuItem disconnectMenu;
	private JButton disconnectButton;
	private JMenuItem executeMenu;
	private JButton executeButton;
	private JMenuItem cancelMenu;
	private JButton cancelButton;
	private JMenuItem simulateMenu;
		

	private JTextArea queryText;
	private JTabbedPane resultsTabContainer;
	private JTextArea statusText;
	private JTextArea jsonText;
	private String DEFAULT_ADDRESS = "localhost:7777";
	private pubsubsql.Client client = pubsubsql.Factory.NewClient();
	private String connectedAddress = "";

	public MainForm() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
		setupMenuAndToolBar();		
		// query text
		queryText = new JTextArea();
		queryText.setPreferredSize(new Dimension(screen.width / 2, 100));
		// tabs
		resultsTabContainer = new JTabbedPane();
		statusText = new JTextArea();		
		resultsTabContainer.addTab("Status", statusText);
		jsonText = new JTextArea();
		resultsTabContainer.addTab("JSON Response", jsonText);
		// splitter
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, queryText, resultsTabContainer); 
		this.add(splitPane, BorderLayout.CENTER);	
		// position
        setSize(screen.width / 2, screen.height / 2);
        setLocation(screen.width / 4, screen.height / 4);
		//
        updateConnectedAddress("");
		enableDisableControls();
	}

	void setupMenuAndToolBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);	
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		// File
		JMenu fileMenu = new JMenu("File");
			// New
			JMenuItem newMenu = new JMenuItem(new_);	
			new_.putValue(Action.SHORT_DESCRIPTION, "New PubSubSQL Interactive Query");
			fileMenu.add(newMenu);
			fileMenu.addSeparator();
			toolBar.add(new_);
			toolBar.addSeparator();
			// Exit	
			JMenuItem exitMenu = new JMenuItem(exit);
			defaultTooltips(exit);
			fileMenu.add(exitMenu);
		menuBar.add(fileMenu);
		// Connection
		JMenu connectionMenu = new JMenu("Connection");
			// Connect local
			connectLocalMenu = new JMenuItem(connectLocal);
			defaultTooltips(connectLocal);
			connectionMenu.add(connectLocalMenu);
			connectLocalButton = toolBar.add(connectLocal);
			// Connect
			connectMenu = new JMenuItem(connect);
			connect.putValue(Action.SHORT_DESCRIPTION, "Connect to remote server");
			connectionMenu.add(connectMenu);
			connectButton = toolBar.add(connect);
			// Disconnect
			disconnectMenu = new JMenuItem(disconnect);
			defaultTooltips(disconnect);
			connectionMenu.add(disconnectMenu);
			disconnectButton = toolBar.add(disconnect);
			toolBar.addSeparator();
		menuBar.add(connectionMenu);	
		// Query
		JMenu queryMenu = new JMenu("Query");
			// Execute 
			executeMenu = new JMenuItem(execute);
			defaultTooltips(execute);
			queryMenu.add(executeMenu);
			executeButton = toolBar.add(execute);
			// Cancel Executing Query 
			cancelMenu = new JMenuItem(cancelExecute);
			defaultTooltips(cancelExecute);
			queryMenu.add(cancelMenu);
			cancelButton = toolBar.add(cancelExecute);
			// Simulate 
			simulateMenu = new JMenuItem(simulate);
			defaultTooltips(simulate);
			queryMenu.add(simulateMenu);
		menuBar.add(queryMenu);	
		// Help
		JMenu helpMenu = new JMenu("Help");
			// About 
			JMenuItem aboutMenu = new JMenuItem(about);
			defaultTooltips(about);
			helpMenu.add(aboutMenu);
		menuBar.add(helpMenu);	
	}

	// events
	Action new_ = new AbstractAction("New", createImageIcon("images/New.png")) {
		public void actionPerformed(ActionEvent event) {
			
		}
	};
	
	Action exit = new AbstractAction("Exit") {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	};

	Action connectLocal = new AbstractAction("Connect to " + DEFAULT_ADDRESS, createImageIcon("images/ConnectLocal.png")) {
		public void actionPerformed(ActionEvent event) {
			connect(DEFAULT_ADDRESS);
		}
	};

	Action connect = new AbstractAction("Connect...", createImageIcon("images/Connect.png")) {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	};

	private void connect(String address) {
		clear();
		if (client.Connect(address)) {
			updateConnectedAddress(address);	
		}
		setStatus();
		enableDisableControls();
	}

	Action disconnect = new AbstractAction("Disconnect", createImageIcon("images/Disconnect.png")) {
		public void actionPerformed(ActionEvent event) {
			updateConnectedAddress("");
			clear();
			client.Disconnect();
			enableDisableControls();
		}
	};

	Action execute = new AbstractAction("Execute", createImageIcon("images/Execute2.png")) {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	};

	Action cancelExecute = new AbstractAction("Cancel Executing Query", createImageIcon("images/Stop.png")) {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	};

	Action simulate = new AbstractAction("Simulate") {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	};

	Action about = new AbstractAction("About") {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	};
	
	// helpers 
	private void defaultTooltips(Action action) {
		action.putValue(Action.SHORT_DESCRIPTION, action.getValue(Action.NAME)); 
	}

	private ImageIcon createImageIcon(String path) {
		java.net.URL url = getClass().getResource(path);
		if (url == null) return null;
		return new ImageIcon(url);
	}

	private void clear() {
		updateConnectedAddress("");
	}

	private void updateConnectedAddress(String address) {
        setTitle("PubSubSQL Interactive Query " + address);
		connectedAddress = address;
	}

	private void setStatus() {

	}

	private void enableDisableControls() {
		boolean connected = client.Connected();
		connectLocalButton.setEnabled(!connected);
		connectLocalMenu.setEnabled(!connected);
		connectButton.setEnabled(!connected);
		connectMenu.setEnabled(!connected);
		disconnectButton.setEnabled(connected);
		disconnectMenu.setEnabled(connected);
		executeButton.setEnabled(connected);
		executeMenu.setEnabled(connected);
		cancelButton.setEnabled(false);
		cancelMenu.setEnabled(false);
		simulateMenu.setEnabled(executeMenu.isEnabled());
	}
}
