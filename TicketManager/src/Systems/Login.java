package Systems;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Login {
	private ReadUsers temp = new ReadUsers();
	private JFrame frame;
	private JTextField enterUsername;
	private JPasswordField enterPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setForeground(new Color(25, 25, 112));
		txtpnWelcomeToThe.setFont(new Font("Cooper Black", Font.PLAIN, 17));
		txtpnWelcomeToThe.setText("Welcome to the Ticket Management Service");
		txtpnWelcomeToThe.setEditable(false);
		txtpnWelcomeToThe.setBounds(104, 39, 253, 56);
		frame.getContentPane().add(txtpnWelcomeToThe);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setForeground(Color.DARK_GRAY);
		txtpnUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txtpnUsername.setText("Username");
		txtpnUsername.setEditable(false);
		txtpnUsername.setBounds(84, 106, 81, 36);
		frame.getContentPane().add(txtpnUsername);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setForeground(Color.DARK_GRAY);
		txtpnPassword.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(84, 153, 81, 23);
		txtpnPassword.setEditable(false);
		frame.getContentPane().add(txtpnPassword);
		
		enterUsername = new JTextField();
		enterUsername.setText("");
		enterUsername.setBounds(177, 106, 130, 26);
		frame.getContentPane().add(enterUsername);
		enterUsername.setColumns(10);
		
		enterPassword = new JPasswordField();
		enterPassword.setBounds(177, 155, 130, 27);
		enterPassword.setEchoChar('*');
		frame.getContentPane().add(enterPassword);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(UIManager.getColor("ToolBar.floatingBackground"));
		loginButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = enterUsername.getText();
				char[] password = enterPassword.getPassword();
				User tempUser = temp.verifyCredentials(name, password);
				if(tempUser != null){
					frame.dispose();
					ViewTickets newWindow = new ViewTickets(tempUser, temp);
					newWindow.setVisible(true);
					newWindow.addFrame(newWindow);
				}else {
					JOptionPane.showMessageDialog(frame, "Incorrect Password or Username");
				}
				}
		});
		loginButton.setBounds(226, 207, 81, 29);
		frame.getContentPane().add(loginButton);
		
		JButton newAccount = new JButton("New Account");
		newAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewUser newWindow = new CreateNewUser(temp);
				newWindow.setVisible(true);
				newWindow.addFrame(newWindow);
			}
		});
		newAccount.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		newAccount.setBounds(84, 207, 110, 29);
		frame.getContentPane().add(newAccount);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}