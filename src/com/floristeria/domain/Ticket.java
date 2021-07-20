package com.floristeria.domain;

import java.util.ArrayList;

public class Ticket {
	
	public Ticket(){
		ticketID = nextId;
        nextId++;
	}


	private int ticketID;
	private static int nextId = 1;
	
	private ArrayList<Producte> productesTicket;
	
	
	//saves all the tickets
	private static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	
	//creates a new ticket after the purchase
	public void createTicket(ArrayList<Integer> productesComprats){
		
		Ticket newTicket = new Ticket();
		
		//saves all the ticket products
		newTicket.productesTicket = new ArrayList<Producte>();
		
		//adds the products to the product ArrayList
		for (int id: productesComprats) {
			Floristeria.productes.forEach( producte -> {
				if (producte.getId() == id) newTicket.productesTicket.add(producte);
			});
		}
		
		//save the products to the ticket array
		tickets.add(newTicket);
	}
	
	
	
	//prints the ticket with the ID indicated 
	public static void printTicket(int ticketID) {
		
		//Busca el tiquet amb la seva id
		int indexTicketToPrint = -1;
		for (int i=0; i<tickets.size(); i++) {
			if ( tickets.get(i).ticketID == ticketID ) indexTicketToPrint = i; 
		}
		if (indexTicketToPrint == -1) {
			System.out.println("ticketID no existent");
			return;
		}
		Ticket ticketToPrint = tickets.get(indexTicketToPrint);
		
		//capçalera
		System.out.println("------------------------------------------");
		System.out.println("     Ticket de la floristeria             ");
		System.out.println("         ID #"+ ticketToPrint.ticketID);
		System.out.println("==========================================");
		
		//productes
		for (Producte pr: ticketToPrint.productesTicket) {
			System.out.println("  " + pr.getNom());
			System.out.println("                         " + pr.getPreu());
			System.out.println("------------------------------------------");
		}
		System.out.println("==========================================");		
		
		//calcula el preu total
		double preuTotal = 0;
		for (Producte pr: ticketToPrint.productesTicket) {
			preuTotal += pr.getPreu();
		}
		
		//prints the last line
		System.out.println("         Preu total= " + preuTotal);
		System.out.println("------------------------------------------");
	}
	
	
	
	//prints the last ticket
	public void printLastTicket() {
		Ticket ticketToPrint = tickets.get(tickets.size() - 1);	
		
		//capçalera
		System.out.println("------------------------------------------");
		System.out.println("     Ticket de la floristeria             ");
		System.out.println("         ID #"+ ticketToPrint.ticketID);
		System.out.println("==========================================");
		
		//productes
		for (Producte pr: ticketToPrint.productesTicket) {
			System.out.println("  " + pr.getNom());
			System.out.println("                         " + pr.getPreu());
			System.out.println("------------------------------------------");
		}
		System.out.println("==========================================");		
		
		//calcula el preu total
		double preuTotal = 0;
		for (Producte pr: ticketToPrint.productesTicket) {
			preuTotal += pr.getPreu();
		}
		
		//prints the last line
		System.out.println("         Preu total= " + preuTotal);
		System.out.println("------------------------------------------");
	}
}
