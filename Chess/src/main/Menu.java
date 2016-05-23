package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import game.AIPlayer;
import game.UserPlayer;
import main.uis.CreateGame;
import main.uis.JoinGame;

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
				Main.startServer(52000);
				Main.user = new UserPlayer("localhost", 52000);
				Main.other = new AIPlayer("localhost", 52000);
				new GameWindow();
				dispose();
			}
		});
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(btnVersusAi);
		
		JButton btnLocalMultiplayer = new JButton("Local Multiplayer");
		btnLocalMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.startServer(52000);
				Main.user = new UserPlayer("localhost", 52000);
				Main.other = new UserPlayer("localhost", 52000);
				new GameWindow();
				dispose();
			}
		});
		contentPane.add(btnLocalMultiplayer);
		
		JButton btnCreateServer = new JButton("Create Online game");
		btnCreateServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateGame();
				dispose();
			}
		});
		contentPane.add(btnCreateServer);
		
		JButton btnJoinOnlineGame = new JButton("Join Online Game");
		btnJoinOnlineGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGame();
				dispose();
			}
		});
		contentPane.add(btnJoinOnlineGame);
		
		setTitle("Chess Menu");
		
		setVisible(true);
	}
}
