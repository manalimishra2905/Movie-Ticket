package com.capg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sprint1_online_movie_ticket.service.MovieTicket;

class MovieTicketTest {

	@Test
	void test() {
		MovieTicket moivie = new MovieTicket();
		boolean b = moivie.isValidation(123, "Manali", "Manali123");
		
		assertEquals(true, b);
		
	}

}
