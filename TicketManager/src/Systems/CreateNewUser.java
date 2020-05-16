package Systems;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class CreateNewUser extends JFrame {
	private CreateNewUser frame;
	private ReadUsers data;
	private JPanel contentPane;
	private JTextField NewUsername;
	private JTextField NewPas;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewUser frame = new CreateNewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	public CreateNewUser(ReadUsers data) {
		this.data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Create New Account", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textUsername = new JTextPane();
		textUsername.setForeground(Color.DARK_GRAY);
		textUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		textUsername.setText("Username:");
		textUsername.setEditable(false);
		textUsername.setBounds(46, 70, 78, 27);
		contentPane.add(textUsername);
		
		JTextPane textPassword = new JTextPane();
		textPassword.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		textPassword.setForeground(Color.DARK_GRAY);
		textPassword.setText("Password:");
		textPassword.setEditable(false);
		textPassword.setBounds(46, 121, 78, 29);
		contentPane.add(textPassword);
		
		NewUsername = new JTextField();
		NewUsername.setText("");
		NewUsername.setBounds(134, 70, 207, 26);
		contentPane.add(NewUsername);
		NewUsername.setColumns(10);
		
		NewPas = new JTextField();
		NewPas.setText("");
		NewPas.setBounds(134, 124, 207, 26);
		contentPane.add(NewPas);
		NewPas.setColumns(10);
		
		JButton NewUser = new JButton("Create");
		NewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernam = NewUsername.getText();
				String pass = NewPas.getText();
				ArrayList<User> tempArray = data.getUserArray();
				boolean exists = false;
				for(User u: tempArray) {
						if(u.getUserName().equals(usernam))
							exists = true;
				}
				if(exists == true)
					JOptionPane.showMessageDialog(frame, "Username already exists!");
				else {
					data.createUser(usernam, pass);
					data.saveUsers();
					frame.setVisible(false);
				}
			}
		});
		NewUser.setBounds(224, 173, 117, 29);
		contentPane.add(NewUser);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnCancel.setBounds(46, 173, 123, 28);
		contentPane.add(btnCancel);
	}
	
	public void addFrame(CreateNewUser frame) {
		this.frame = frame;
	}
}
