package Systems;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ReadData implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Ticket> ticketArray;
	
	@SuppressWarnings({ "unchecked", "resource" })
	ReadData(){
	File newFile = new File("ticketsDatabase.bin");
	if(newFile.length() != 0){
		try{
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("ticketsDatabase.bin"));
			Object ticketArr = reader.readObject();
			this.ticketArray = (ArrayList<Ticket>) ticketArr;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	else {
		this.ticketArray = new ArrayList<>();
		}
	}
	
	public Ticket createTicket(Integer ticketNumber, User user, String subject, String email, String details, String time){
		Ticket t1 = new Ticket(ticketNumber,user,subject,email,details, time);
		ticketArray.add(t1);
		return t1;
	}
	
	public void saveTickets() {
		String fileName = "ticketsDatabase.bin";
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
			writer.writeObject(ticketArray);
			writer.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printAllTickets() {
		for(Ticket t: this.ticketArray)
			System.out.println(t);
	}
	
	public String allTickets() {
		StringBuffer text = new StringBuffer();
		for(Ticket t: ticketArray)
			text.append(t.toString() + "\n");
		return text.toString();
	}
	
	public int getTicketArraySize(){
		return ticketArray.size();
	}
	
	public ArrayList<Ticket> getTicketArray() {
		return this.ticketArray;
	}

	public static void main(String[] args) throws FileNotFoundException {
	/*	ReadData test = new ReadData();
		User Kaleb = new User("kalebshah", "123", 1);
		User Luis = new User("luisCarlua", "456", 2);
		test.createTicket(1, Kaleb, "Wifi Connection","1kingkaleb@gmail.com", "Cannot connect to wifi");
		test.createTicket(2, Luis, "Matlan Access","luaLuis@gmail.com", "Cannot connect to karp or matlan");
		test.printAllTickets();
		test.saveTickets();
		*/
		ReadData test = new ReadData();
		test.printAllTickets();
	}
}