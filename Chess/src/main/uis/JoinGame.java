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

public class JoinGame extends JFrame {

	private static final long serialVersionUID = -3938483148086318585L;
	private JPanel contentPane;
	private JTextField txtAdress;
	private JTextField txtPort;

	public JoinGame() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(253, 140);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdress = new JLabel("Adress: ");
		lblAdress.setBounds(10, 11, 46, 14);
		contentPane.add(lblAdress);

		txtAdress = new JTextField();
		txtAdress.setBounds(50, 8, 151, 20);
		contentPane.add(txtAdress);
		txtAdress.setColumns(10);

		JLabel lblPort = new JLabel("Port: ");
		lblPort.setBounds(10, 34, 46, 14);
		contentPane.add(lblPort);

		txtPort = new JTextField();
		txtPort.setBounds(50, 31, 151, 20);
		contentPane.add(txtPort);
		txtPort.setColumns(10);

		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adress = txtAdress.getText();
				int port = Integer.parseInt(txtPort.getText());
				Main.user = new UserPlayer(adress, port);
				new GameWindow();
				dispose();
			}
		});
		btnJoin.setBounds(83, 62, 89, 23);
		contentPane.add(btnJoin);
		setVisible(true);
	}

}
