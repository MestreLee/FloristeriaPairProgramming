package com.floristeria.domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		
		
		//TODO veure el mètode per cridar el registre del ticket que faci falta
		
		
		//Busca el tiquet amb la seva id
		int indexTicketToPrint = tickets.indexOf( this.ticketID == ticketID );
		Ticket ticketToPrint = tickets.get(indexTicketToPrint);	
		
		//capçalera
		System.out.println("+------------------------------------------+");
		System.out.println("|     Ticket de la floristeria:            |");
//		System.out.println("|     "+ floristeria.getNom() +"          |"); //TODO no es pot accedir a la floristeria
		System.out.println("|   Ticket #"+ ticketToPrint.ticketID +"          |"); //TODO no es pot accedir a la floristeria
		System.out.println("+==========================================+");
		
		//productes
		for (int i=0; i<ticketToPrint.numProductes; i++) {
			System.out.println("|  " + ticketToPrint.productesTicket.get(i).getNom() 
					+ "  " + ticketToPrint.productesTicket.get(i).getPreu() + "  |");
		}
		System.out.println("+==========================================+");	
				
				

		
		//calcula el preu total
		double preuTotal = 0;
		productesTicket.forEach( producte -> preuTotal =+ producte.getPreu() );  //TODO 
		
		
		
		

		System.out.println("|   Preu total= " + preuTotal + "                 |");
		System.out.println("+------------------------------------------+");
		
		
	}
	
	
	
	
	
	
	//prints the last ticket  //TODO tickets.size()
	public void printLastTicket() {
		
	}
	
	
	

}
