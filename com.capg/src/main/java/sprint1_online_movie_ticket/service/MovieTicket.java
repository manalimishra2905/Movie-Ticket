package sprint1_online_movie_ticket.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import sprint1_online_movie_ticket.Beans.user;
import sprint1_online_movie_ticket.dao.movieTicketRepository;

public class MovieTicket {
	File file = new File("C:\\Users\\DELL\\Desktop\\manali.txt");
	public InputStreamReader isr = new InputStreamReader(System.in);
	public BufferedReader buff = new BufferedReader(isr);

	String msg = "";
	public List<user> userList = new ArrayList<user>();
// for register
public void registerNewUser() {
	user userObj=new user();

	Integer userId;
	String userName;
	String password;
	
	char c;

	try {
		do {

			System.out.println("enter the userId:");
			 userId = Integer.parseInt(buff.readLine());
			//userObj.setUserId(userId);
			System.out.println("enter the username:");
			 userName = buff.readLine();
			//userObj.setUserName(userName);
			System.out.println("enter the password:");
			 password = buff.readLine();
		//	userObj.setPassword(password);
//			System.out.println("enter the userid:");
//			userId = Integer.parseInt(buff.readLine());
//			System.out.println("enter the username:");
//			userName = buff.readLine();
//			System.out.println("enter the password:");
//			password = buff.readLine();
			
			/*
			 while(choose!=2){
			 			System.out.println("enter the userId:");
			Integer userId = Integer.parseInt(buff.readLine());
			userObj.setUserId(userId);
			System.out.println("enter the username:");
			String userName = buff.readLine();
			userObj.setUserName(userName);
			System.out.println("enter the password:");
			String password = buff.readLine();
			
			userObj.setPassword(password);
			
			new user(userId,userName,password);
			
			 
			 
			 }
			  */
			
			
			System.out.println(isValidation(userId, userName, password));

			if (isValidation(userId, userName, password)) {
				
				userList.add(new user(userId, userName, password));
				System.out.println("Registration success........");
			} else {
				System.out.println(msg);
			}

			System.out.println("do u want to register another user plz press(y/n)");

			c = buff.readLine().charAt(0);
		} while (c == 'y');
		if (c == 'n')
			selectOperation();
	} catch (IOException e) {
		// TOOO Auto-generated catch block
		e.printStackTrace();
	}

	try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
		bw.write(userObj.getUserName() + "," + userObj.getPassword());
		System.out.println(userObj.getUserName() + "," + userObj.getPassword());
		bw.newLine();
		bw.flush();

	} catch (IOException e) {
		// TOOO Auto-generated catch block
		e.printStackTrace();
	}
	
}



//for sign in

public boolean signIn(String useName,String Password) {
	boolean flag = false;
	System.out.println("enter username");
	try {
		String UserName;
		UserName = buff.readLine();
		System.out.println("password");
		String pass = buff.readLine();
		for (user a : userList) {
			if ((a.getUserName().contentEquals(UserName)) && (a.getPassword().contentEquals(pass))) {
				flag = true;
				break;
			}
		}
	} catch (IOException e) {
		// TOOO Auto-generated catch block
		e.printStackTrace();
	}

	if (flag) {
		System.out.println("login succesful");
	} else {
		System.out.println("login denied");
	}
	return flag;

}
public boolean adminSignIn() {
	boolean flag = false;
	int size;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter your admin id");
	String AdminName=sc.nextLine();
	movieTicketRepository repObj=new movieTicketRepository();
	for( size=0;size<repObj.adminList.size();size++) {
		if(repObj.adminList.get(size).equals(AdminName)) {
			flag=true;
			break;
				
		}
	}
	if(flag==false) {
		System.out.println("wrong user name");
		
	}else {
		System.out.println("enter password");
		String password = sc.nextLine();
		if(repObj.passList.get(size).equals(password)) {
			System.out.println("you are log in");
			 
		}else {
			System.out.println("wrong password");
		}
	}
	
	
	return true;
}

//for sign out


public boolean signOut() {
	System.out.println("you are sign out");

	
	return false;
}



public void selectOperation() {
	int choice;
	System.out.println("enter 1 for registration/2 for signin/3 for signout/4 for adminlogin");
	try {
		choice = Integer.parseInt(buff.readLine());
		switch (choice) {
		case 1:
			registerNewUser();
			break;
		case 2:
			signIn(msg, msg);
			break;
		case 3:
			signOut();
			break;
		case 4:
			adminSignIn();
			break;
			
				
		}
	} catch (NumberFormatException e) {
		// TOOO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TOOO Auto-generated catch block
		e.printStackTrace();
	}}
	
	
	public boolean isValidation(Integer userId2, String userName2, String password2) {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		System.out.println("hi your user id: "+userId2+" your user name :  "+userName2+" your password   "+password2);
		if (userName2.isEmpty() && password2.isEmpty() && password2.length() < 8) {

			  // System.out.println("Hello Manali.......123");
			
			// Empty
			msg = "plz enter the details correctly";
			flag = false;

		}

		if (flag) {

			if (userList.isEmpty()) {
				flag = true;
			}

			else {
				msg = "userid already exist !";
				flag = !(userList.parallelStream().map(i -> i.getUserId()).collect(Collectors.toList()).contains(userId2));
			}
		}
		return flag;

	}


}
