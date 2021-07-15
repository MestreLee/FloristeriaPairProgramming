package com.floristeria.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ticket {
	
	Ticket(int numProductes, String nomFloristeria){
		this.numProductes = numProductes;
		this.nomFloristeria = nomFloristeria;
		ticketID = nextId;
        nextId++;
	}
	
	
//	private int idProducte;
//	private String nomProducte;
//	private int quantitatProducte;
//	private String nomFloristeria;
//	private int ticketID;
//	private static int nextId = 1;

	private int numProductes;
	private String nomFloristeria;
	private int ticketID;
	private static int nextId = 1;
	private ArrayList<Producte> productesTicket;
	
	
	//saves all the tickets
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	

	
	
	//creates a new ticket after the purchase
	public void createTicket(int numProductes, String nomFloristeria){
		Ticket newTicket = new Ticket(numProductes, nomFloristeria);
		
		//saves all the ticket products
		newTicket.productesTicket = new ArrayList<Producte>();
		
		//adds the products
		for (int i=0; i<numProductes; i++) {
			newTicket.productesTicket = Floristeria.productes.stream() //TODO veure com queda definida la id dels productes i crear accés
					.filter(producte -> producte.getProducteID == i) //TODO canviar el filtre en funció de l'estructura de la id
					.collect(Collectors.toList());
		}
		
		//save the products to the ticket array
		tickets.add(newTicket);
	}
	
	
	//prints the ticket with the ID indicated 
	public void printTicket(int ticketID) {
		
		//TODO mètode per calcular el número d'espais al ticket
		
		//TODO veure el mètode per cridar el registre del ticket que faci falta
		System.out.println("+------------------------------------------+");
		System.out.println("|  Ticket de la floristeria:               |");
		System.out.println("|     "+ nomFloristeria +"              |");
		System.out.println("+==========================================+");
		System.out.println("|  " + nomProducte + "    x" + quantitatProducte + "  " + preuProducte + "   |  " + (preuProducte*quantitatProducte) + "  |");
		System.out.println("|   b: afegir arbre                        |");
		System.out.println("|   c: afegir flor                         |");
		System.out.println("|   d: afegir decoració                    |");
		System.out.println("+------------------------------------------+");
		System.out.println("|   z: tancar programa                     |");
		System.out.println("+------------------------------------------+");
	}
	
	
	//prints the last ticket  //TODO tickets.size()
	public void printLastTicket() {
		
	}
	
	
	

}
