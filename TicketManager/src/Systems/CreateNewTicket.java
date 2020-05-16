package Systems;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class CreateNewTicket extends JFrame {
	private CreateNewTicket frame;
	private ViewTickets ticketFrame;
	private User user;
	private Timestamp time = new Timestamp(10000);
	private JPanel contentPane;
	private JTextField subject;
	private JTextField email;
	private ReadData data;
	private JTextPane details;

   // Launch the application.
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//CreateNew frame = new CreateNew();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateNewTicket(User user, ReadData data, ViewTickets ticketFrame) {
		this.data = data;
		this.user= user;
		this.ticketFrame = ticketFrame;
		Date date = new Date();
		this.time = new Timestamp(date.getTime());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JTextPane userInfo = new JTextPane();
		userInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		userInfo.setText(user.getUserName());
		userInfo.setBounds(294, 0, 100, 26);
		userInfo.setEditable(false);
		contentPane.add(userInfo);
		
		JTextPane timeInfo = new JTextPane();
		timeInfo.setBounds(256, 23, 138, 26);
		timeInfo.setEditable(false);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		timeInfo.setText(formatter.format(time));
		contentPane.add(timeInfo);
		
		subject = new JTextField();
		subject.setBounds(81, 49, 292, 26);
		contentPane.add(subject);
		subject.setColumns(10);
		
		email = new JTextField();
		email.setBounds(81, 79, 292, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		JTextPane textSubject = new JTextPane();
		textSubject.setForeground(Color.DARK_GRAY);
		textSubject.setText("Subject:");
		textSubject.setEditable(false);
		textSubject.setBounds(10, 49, 61, 26);
		contentPane.add(textSubject);
		
		JTextPane textEmail = new JTextPane();
		textEmail.setForeground(Color.DARK_GRAY);
		textEmail.setText("Email ID:");
		textEmail.setEditable(false);
		textEmail.setBounds(10, 89, 61, 26);
		contentPane.add(textEmail);
		
		JTextPane txtpnDetails = new JTextPane();
		txtpnDetails.setForeground(Color.DARK_GRAY);
		txtpnDetails.setText("Details:");
		txtpnDetails.setEditable(false);
		txtpnDetails.setBounds(10, 132, 61, 26);
		contentPane.add(txtpnDetails);
		
		JButton submitTicket = new JButton("Submit");
		submitTicket.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		submitTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sub = subject.getText();
				String ema = email.getText();
				String det = details.getText();
				if(sub.isEmpty() ||  ema.isEmpty() || det.isEmpty()){
					JOptionPane.showMessageDialog(frame, "Not all fields are filled, please try again or cancel.");
				}else {
					Ticket t1 = data.createTicket(data.getTicketArraySize(), user, sub, ema, det, formatter.format(time));
					ticketFrame.addTicket(t1);
					frame.setVisible(false);
				}
			}
		});
		submitTicket.setBounds(256, 208, 117, 29);
		contentPane.add(submitTicket);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(81, 207, 117, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 116, 292, 80);
		contentPane.add(scrollPane);
		
		details = new JTextPane();
		scrollPane.setViewportView(details);
	
	}
	
	public void addFrame(CreateNewTicket frame, ViewTickets ticketFrame) {
		this.frame = frame;
		this.ticketFrame = ticketFrame;
	}
}
