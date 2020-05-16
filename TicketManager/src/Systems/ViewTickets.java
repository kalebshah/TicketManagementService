package Systems;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ViewTickets extends JFrame {
	private ViewTickets frame;
	private ReadUsers userDatabase;
	private Timestamp time = new Timestamp(10000);
	private JPanel contentPane;
	private User user;
	private ReadData data = new ReadData();
	private JTextPane viewer;
	private DefaultListModel<Ticket> list;
	private JList lstTickets;
	
	
	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTickets frame = new ViewTickets();
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
	public ViewTickets(User user, ReadUsers userDatabase) {
		//
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userDatabase = userDatabase;
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create New Ticket");
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewTicket newWindow = new CreateNewTicket(user, data, frame);
				newWindow.setVisible(true);
				newWindow.addFrame(newWindow, frame);
			}
		});
		btnNewButton.setBounds(10, 11, 143, 29);
		contentPane.add(btnNewButton);
		
		JTextPane userInfo = new JTextPane();
		userInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		userInfo.setText(user.getUserName());
		userInfo.setEditable(false);
		userInfo.setBounds(195, 11, 106, 20);
		contentPane.add(userInfo);
		
		JButton saveButton = new JButton("Sign Out");
		saveButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDatabase.saveUsers();
				data.saveTickets();
				JOptionPane.showMessageDialog(frame, "Successfully logged out!");
				System.exit(0); //shuts program
			}
		});
		saveButton.setBounds(305, 11, 113, 29);
		contentPane.add(saveButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 65, 436, 198);
		contentPane.add(scrollPane);
		
		lstTickets = new JList();
		lstTickets.setBorder(new TitledBorder(null, "Tickets", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = new DefaultListModel<Ticket>();
		addPreviousTickets();
		lstTickets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ticket selectedTicket = (Ticket) lstTickets.getSelectedValue();
				if(selectedTicket != null) {
					ShowTicket showTicket = new ShowTicket(user, data, selectedTicket, frame);
					showTicket.setVisible(true);
					showTicket.addFrame(showTicket, frame);
				}
			}
		});
		scrollPane.setViewportView(lstTickets);
 	}
	
	public void addFrame(ViewTickets frame) {
		this.frame = frame;
	}
	
	public void addTicket(Ticket tic) {
			list.addElement(tic);
			lstTickets.removeAll();
			lstTickets.setModel(list);
	}
	
	public void removeTicket(Ticket tic) {
		int index = list.indexOf(tic);
		list.remove(index);
		data.getTicketArray().remove(tic);
	}
	
	public void addPreviousTickets() {
		for(Ticket t: data.getTicketArray()) {
			list.addElement(t);
		}
		lstTickets.setModel(list);
	}
}
