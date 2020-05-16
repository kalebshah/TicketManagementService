package Systems;
import java.sql.Timestamp;
import java.util.*;
import java.io.Serializable;

public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userID;
    private String userName;
    private String password;
    private Timestamp lastLogin = new Timestamp(1000);
    private Ticket[] userTickets;

    User(String userName, String password, Integer userID){
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.lastLogin.toLocalDateTime().toLocalDate();
        this.userTickets = null;
    }

    public Integer getUserID() {
        return userID;
    }
    
    public String getPassword() {
    	return password;
    }

    public String getUserName() {
        return userName;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public Ticket[] getUserTickets() {
        return userTickets;
    }
    
    @Override
    public String toString() {
    	return "ID: " + this.userID.toString() +" \t Username: " + this.userName + "";
    }
}