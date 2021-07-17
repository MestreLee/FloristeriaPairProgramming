package com.floristeria.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Ticket {
	
	Ticket(int numProductes){
		this.numProductes = numProductes;
		ticketID = nextId;
        nextId++;
	}


	private int numProductes;
//	private String nomFloristeria;
	private int ticketID;
	private static int nextId = 1;
	
	private ArrayList<Producte> productesTicket;
	
	
	//saves all the tickets
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	
	Scanner sca = new Scanner(System.in);

	
	
	//creates a new ticket after the purchase
	public void createTicket(int numProductes){
		Ticket newTicket = new Ticket(numProductes);
		
		
		//saves all the ticket products
		newTicket.productesTicket = new ArrayList<Producte>();
		
		
		//adds the products to the product ArrayList
		for (int i=0; i<numProductes; i++) {
			//TODO això haurà d'anar al menú, però temporalment queda dins del mètode. també s'ha d'esborrar el scanner
			System.out.println("Introduiu la ID del producte #" + (i+1) + " que voleu adquirir");
			int producteNouID = sca.nextInt();
			
			Floristeria.productes.forEach( producte -> {
				if (producte.getId() == producteNouID) newTicket.productesTicket.add(producte);
			});
		}
		
		
		//save the products to the ticket array
		tickets.add(newTicket);
	}
	
	
	
	
	
	//prints the ticket with the ID indicated 
	public void printTicket(int ticketID) {
		
		//TODO mètode per calcular el número d'espais al ticket
		
		
		
		//Busca el tiquet amb la seva id
		int indexTicketToPrint = -1;
		for (int i=0; i<tickets.size(); i++) {
			if ( tickets.get(i).ticketID == ticketID ) indexTicketToPrint = i; 
		}
		if (indexTicketToPrint == -1) {
			System.out.println("ticketID no existent");
			return;  //TODO comprovar que pari l'execució del mètode
		}
		Ticket ticketToPrint = tickets.get(indexTicketToPrint);	

		
		//capçalera
		System.out.println("+------------------------------------------+");
		System.out.println("|     Ticket de la floristeria:            |");
//		System.out.println("|     "+ floristeria.getNom() +"          |"); //TODO no es pot accedir a la floristeria
		System.out.println("|   Ticket #"+ ticketToPrint.ticketID +"          |");
		System.out.println("+==========================================+");
		
		//productes
		for (int i=0; i<ticketToPrint.numProductes; i++) {
			System.out.println("|  " + ticketToPrint.productesTicket.get(i).getNom() 
					+ "  " + ticketToPrint.productesTicket.get(i).getPreu() + "  |");
		}
		System.out.println("+==========================================+");	
				
				

		
		//calcula el preu total
		double preuTotal = 0;
		for (Producte pr: productesTicket) {
			preuTotal += pr.getPreu();
		}
		
		//prints the last line
		System.out.println("|   Preu total= " + preuTotal + "                 |");
		System.out.println("+------------------------------------------+");
		
		
	}
	
	
	
	
	
	
	//prints the last ticket
	public void printLastTicket() {
		//TODO s'ha de fer a partir del codi anterior, fent que l'index sígui tickets.size()
	}






	
	
	
	
	//getters & setters
	public int getNumProductes() {
		return numProductes;
	}

	public void setNumProductes(int numProductes) {
		this.numProductes = numProductes;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public ArrayList<Producte> getProductesTicket() {
		return productesTicket;
	}

	public void setProductesTicket(ArrayList<Producte> productesTicket) {
		this.productesTicket = productesTicket;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Scanner getSca() {
		return sca;
	}

	public void setSca(Scanner sca) {
		this.sca = sca;
	}
}
