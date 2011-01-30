package graphics;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import network.ssh.SSH2Client;
import util.JFrameUtil;


public class JSimpleTerminal extends JFrame {
	
	private static final long serialVersionUID = -78836768236278425L;
	
	public static final String DEFAULT_TITLE = "Terminal";
	
	
	public JSimpleTerminal(SSH2Client sshClient) {
		this(DEFAULT_TITLE, sshClient);
	}
	public JSimpleTerminal(String title, final SSH2Client sshClient) {
		super(title);
		setLayout(new BorderLayout());
		
		JSimpleTerminalPanel terminalPanel = new JSimpleTerminalPanel(sshClient);
		terminalPanel.addCloseListener(new JSimpleTerminalPanel.CloseListener() {
			public void closed() {
				JSimpleTerminal.this.dispose();
			}
		});
		add(new JScrollPane(terminalPanel));
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		pack();
		JFrameUtil.centerFrame(this);
	}
	
}