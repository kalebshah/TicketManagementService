package Systems;
import java.sql.*;
import java.util.*;
import java.io.Serializable;


public class Ticket implements Serializable{
	private static final long serialVersionUID = 1L;
    private String time;
    private Integer ticketNumber;
    private User user;
    private String subject;
    private String email;
    private String details;
    private boolean resolved;

    Ticket(Integer ticketNumber, User user, String subject, String email, String details, String time){
        this.time = time;
    	this.ticketNumber = ticketNumber;
        this.user = user;
        this.subject = subject;
        this.email = email;
        this.details = details;
        this.resolved = false;
    }

    public String getTime() {
        return time;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public User getUser() {
        return user;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    public String getDetails() {
        return details;
    }

	public boolean isResolved() {
		return resolved;
	}
	
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	
	@Override
	public String toString() {
		return String.format("%10s   %1s \t %10s", this.user.getUserName(), this.email, this.subject);
	} 
}
