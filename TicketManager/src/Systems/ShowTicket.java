package Systems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class ShowTicket extends JFrame {
	private ShowTicket frame;
	private ViewTickets ticketFrame;
	private User user;
	private Timestamp time = new Timestamp(10000);
	private JPanel contentPane;
	private ReadData data;
	private Ticket ticket;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTicket frame = new ShowTicket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*

	/**
	 * Create the frame.
	 */
	public ShowTicket(User user, ReadData data, Ticket ticket, ViewTickets ticketFrame) {
		this.data = data;
		this.user= user;
		this.ticket = ticket;
		this.ticketFrame = ticketFrame;
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
		userInfo.setBounds(303, 0, 92, 29);
		userInfo.setEditable(false);
		contentPane.add(userInfo);
		
		JTextPane textSubject = new JTextPane();
		textSubject.setText("Subject:");
		textSubject.setBounds(10, 49, 61, 29);
		textSubject.setEditable(false);
		contentPane.add(textSubject);
		
		JTextPane textEmail = new JTextPane();
		textEmail.setText("Email ID:");
		textEmail.setBounds(10, 89, 61, 32);
		textEmail.setEditable(false);
		contentPane.add(textEmail);
		
		JTextPane txtpnDetails = new JTextPane();
		txtpnDetails.setText("Details:");
		txtpnDetails.setBounds(10, 132, 46, 29);
		txtpnDetails.setEditable(false);
		contentPane.add(txtpnDetails);
		
		JButton submitTicket = new JButton("Finished");
		submitTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketFrame.removeTicket(ticket);
				frame.setVisible(false);
			}
		});
		submitTicket.setBounds(256, 208, 117, 29);
		contentPane.add(submitTicket);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(81, 207, 117, 30);
		contentPane.add(btnNewButton);
		
		JTextPane paneSubject = new JTextPane();
		paneSubject.setBounds(81, 49, 292, 26);
		paneSubject.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		paneSubject.setText(ticket.getSubject());
		paneSubject.setEditable(false);
		contentPane.add(paneSubject);
		
		JTextPane paneEmail = new JTextPane();
		paneEmail.setBounds(81, 79, 292, 26);
		paneEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		paneEmail.setText(ticket.getEmail());
		paneEmail.setEditable(false);
		contentPane.add(paneEmail);
		
		JTextPane paneDetails = new JTextPane();
		paneDetails.setBounds(81, 117, 292, 80);
		paneDetails.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		paneDetails.setText(ticket.getDetails());
		paneEmail.setEditable(false);
		contentPane.add(paneDetails);
		
		JTextPane txtTime = new JTextPane();
		txtTime.setBounds(281, 25, 85, 26);
		txtTime.setText(ticket.getTime());
		txtTime.setEditable(false);
		contentPane.add(txtTime);
	}
	
	public void addFrame(ShowTicket frame, ViewTickets ticketFrame) {
		this.frame = frame;
		this.ticketFrame = ticketFrame;
	}
}
