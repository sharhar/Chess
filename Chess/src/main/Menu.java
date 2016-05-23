package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Menu extends JFrame {
	private static final long serialVersionUID = -994830966508608497L;
	private JPanel contentPane;
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JButton btnVersusAi = new JButton("Versus AI");
		btnVersusAi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("AI");
			}
		});
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(btnVersusAi);
		
		JButton btnLocalMultiplayer = new JButton("Local Multiplayer");
		btnLocalMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Local Multiplayer");
			}
		});
		contentPane.add(btnLocalMultiplayer);
		
		JButton btnCreateServer = new JButton("Create Server");
		btnCreateServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Server");
			}
		});
		contentPane.add(btnCreateServer);
		
		JButton btnJoinOnlineGame = new JButton("Join Online Game");
		btnJoinOnlineGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connect");
			}
		});
		contentPane.add(btnJoinOnlineGame);
		
		setTitle("Chess Menu");
		
		setVisible(true);
	}
}
