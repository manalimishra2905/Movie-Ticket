package sprint1_online_movie_ticket.Beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;



public class user {
	File file = new File("C:\\Users\\DELL\\Desktop\\manali.txt");
	public InputStreamReader isr = new InputStreamReader(System.in);
	public BufferedReader buff = new BufferedReader(isr);

	
	String msg = "";

	private Integer userId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	private String userName;
	private String Password;
	public user() {

	}

	public user(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.Password = password;
	}
}




