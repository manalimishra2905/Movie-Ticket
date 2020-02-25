package sprint1_online_movie_ticket.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import sprint1_online_movie_ticket.Beans.user;

import sprint1_online_movie_ticket.service.MovieTicket;

public class Source {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieTicket movieOj = new MovieTicket();
		movieOj.isr = new InputStreamReader(System.in);
		movieOj.buff = new BufferedReader(movieOj.isr);
		movieOj.userList = new ArrayList<user>();
		movieOj.registerNewUser();
		movieOj.selectOperation();

	}

}
