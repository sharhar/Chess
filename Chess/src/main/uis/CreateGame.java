package main.uis;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.UserPlayer;
import main.GameWindow;
import main.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateGame extends JFrame {
	private static final long serialVersionUID = -8891487659514055412L;
	private JPanel contentPane;
	private JTextField txtPort;
	
	public CreateGame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(213, 111);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPort = new JLabel("Port: ");
		lblPort.setBounds(10, 14, 34, 14);
		contentPane.add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setBounds(38, 11, 144, 20);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(txtPort.getText());
				Main.startServer(port);
				Main.user = new UserPlayer("localhost", port);
				new GameWindow();
				dispose();
			}
		});
		btnCreate.setBounds(48, 48, 89, 23);
		contentPane.add(btnCreate);
		
		setTitle("Menu");
		
		setVisible(true);
	}
}
