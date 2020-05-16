package Systems;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.*;
import java.sql.Timestamp;

//citation: https://stackoverflow.com/questions/42190602/reading-a-csv-file-using-another-class-then-login-java
public class ReadUsers{
    private ArrayList<User> userArray;

    @SuppressWarnings({"unchecked"})
	ReadUsers(){
	File newFile = new File("userDatabase.bin");
	if(newFile.length() != 0){
		try{
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("userDatabase.bin"));
			Object userArr = reader.readObject();
			this.userArray = (ArrayList<User>) userArr;
			reader.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	else {
		this.userArray = new ArrayList<>();
		}
	}
    
    /*
     if(newFile.length() != 0){
		try{
			System.out.println("File not empty");
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
	}*/
	
	public void createUser(String userName, String Password){
		int num = userArray.size();
		User u1 = new User(userName, Password, num);
		userArray.add(u1);
	}
	
	
	public void saveUsers() {
		String fileName = "userDatabase.bin";
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
			writer.writeObject(userArray);
			writer.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printAllUsers() {
		for(User u: userArray)
			System.out.println(u.toString());
		if(userArray.size() == 0)
			System.out.println("There are no users");
	}
	
	public int getUserArraySize(){
		return userArray.size();
	}
	
	public ArrayList<User> getUserArray(){
		return userArray;
	}
	
	public User verifyCredentials(String userName, char[] pass){
		String password = new String(pass);
		for(User u: userArray){
			if(u.getUserName().equals(userName) == true && u.getPassword().equals(password))
				return u;
		}
		return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ReadUsers temp = new ReadUsers();
		temp.printAllUsers();
	}
}