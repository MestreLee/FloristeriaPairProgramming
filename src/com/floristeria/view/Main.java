package com.floristeria.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.floristeria.domain.Arbre;
import com.floristeria.domain.Decoracio;
import com.floristeria.domain.Flor;
import com.floristeria.domain.Floristeria;
import com.floristeria.domain.Ticket;
import com.floristeria.application.ControladorFloristeria;

public class Main {
	
	public static ControladorFloristeria controller = new ControladorFloristeria();
	
	public static void main(String[] args) throws Exception {
		
		//crida el scanner
		Scanner sca = new Scanner(System.in);
		
		//menú de navegació
		int x=-1;
		Floristeria floristeria = null;
		while (x<0) {			
			System.out.println("+------------------------------------------+");
			System.out.println("| Seleccioneu una de les següents opcions: |");
			System.out.println("+==========================================+");
			System.out.println("|   a: crear nova floristeria              |");
			System.out.println("+------------------------------------------+");
			System.out.println("|   b: afegir arbre                        |");
			System.out.println("|   c: afegir flor                         |");
			System.out.println("|   d: afegir decoració                    |");
			System.out.println("|   e: veure stock i valor stock           |");
			System.out.println("|   f: veure tots els productes            |");
			System.out.println("+------------------------------------------+");
			System.out.println("|   g: gestionar una compra                |");
			System.out.println("+------------------------------------------+");
			System.out.println("|   z: tancar programa                     |");
			System.out.println("+------------------------------------------+");
			
			char selector = sca.next().charAt(0);
			
			
			switch (selector) {
			case 'a':
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el nom de la floristeria:    |");
				System.out.println("+------------------------------------------+");
				floristeria = new Floristeria(sca.next());
				break;
				
			case 'b':

				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el nom de l'arbre:           |");
				System.out.println("+------------------------------------------+");
				String nomArbre = sca.next();
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el preu de l'arbre:          |");
				System.out.println("+------------------------------------------+");
				double preuArbre = sca.nextDouble();
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu l'alçada de l'arbre:         |");
				System.out.println("+------------------------------------------+");
				double alcadaArbre = sca.nextDouble();
				
				Arbre newArbre = new Arbre(nomArbre, preuArbre, alcadaArbre);
				try {
					controller.afegirArbre(floristeria, newArbre);
				}catch (NullPointerException e) {
					System.out.println("Primer has d'instanciar una floristeria!");
				}
				
				
				break;
				
			case 'c':
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el nom de la flor:           |");
				System.out.println("+------------------------------------------+");
				String nomFlor = sca.next();
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el preu de la flor:          |");
				System.out.println("+------------------------------------------+");
				double preuFlor = sca.nextDouble();
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el color de la flor:         |");
				System.out.println("+------------------------------------------+");
				String colorFlor = sca.next();
				
				Flor newFlor = new Flor(nomFlor, preuFlor, colorFlor);
				try {
					controller.afegirFlor(floristeria, newFlor);
				}catch (NullPointerException e) {
					System.out.println("Primer has d'instanciar una floristeria!");
				}
				
				
				break;
				
			case 'd':
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el nom de la decoració:      |");
				System.out.println("+------------------------------------------+");
				String nomDecoracio = sca.next();
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el preu de la decoració:     |");
				System.out.println("+------------------------------------------+");
				double preuDecoracio = sca.nextDouble();
				
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el material de la decoració: |");
				System.out.println("+------------------------------------------+");
				String materialDecoracio = sca.next();
				materialDecoracio = materialDecoracio.toLowerCase();
				
				int y=-1;
				boolean materialDecoracioBool = false;
				while (y<0) {
					if (materialDecoracio.equals("fusta")) {
						materialDecoracioBool = true;
						y=1;
						
					}
					else if (materialDecoracio.equals("plastic")) {
						materialDecoracioBool = false;
						y=1;
					}
					else {
						System.out.println("+------------------------------------------+");
						System.out.println("|el material de la decoració només pot ser |");
						System.out.println("|fusta o plastic.                          |");
						System.out.println("+------------------------------------------+");
						materialDecoracio = sca.next();
						materialDecoracio = materialDecoracio.toLowerCase();
					}
				}
				Decoracio newDecoracio = new Decoracio(nomDecoracio, preuDecoracio, materialDecoracioBool);
				try {
					controller.afegirDecoracio(floristeria, newDecoracio);
				}catch (NullPointerException e) {
					System.out.println("Primer has d'instanciar una floristeria!");
				}
						
				break;
			
			case 'e':
				try {
					controller.printStock(floristeria);
					controller.printValorTotal(floristeria);
				}catch (NullPointerException e) {
					System.out.println("No hi ha cap floristeria creada!");
				}
				
				break;
				
			case 'f':
				try {
					printejarFloristeria(floristeria);
				} catch (NullPointerException e) {
					System.out.println("No hi ha cap floristeria creada!");
				}
				
				break;
				
			case 'g': 
				
				//Pas 1: omplim un array d'ints amb les IDs dels productes que formaran part del ticket de compra
				
				ArrayList <Integer> llistaProductes = new ArrayList<Integer>();
				boolean segueixIterant = true;
				int idprod = 0;
				while (segueixIterant) {
					System.out.println("Afegeix una id de producte:");
					idprod = sca.nextInt();
					//Llegim la new-line que causa problemes amb l'scanner si no es fa:
					sca.next();
					if (controller.comprovarStock(floristeria, idprod)) llistaProductes.add(idprod);
					else System.out.println("No queda stock d'aquest producte!");
					System.out.println("Vols afegir més productes? si, no");
					if (sca.next() == "no") segueixIterant = false;  
				}
				
				//Pas 2: retirem els productes que coincideixin amb les IDs de l'array
				
				controller.retirarProductes(floristeria, llistaProductes);
				
				//Pas 3: creem el ticket de compra
				
				Ticket ticket = new Ticket();
				ticket.createTicket(llistaProductes);
				
				//Pas 4: printegem l'últim ticket creat
				
				ticket.printLastTicket();
				
				break;
				
			case 'z':
				x = 1;
				sca.close();
				System.out.println("bye");
				break;
			}
		}
		
		
		
		
		
		//DEBUG LINES
//		//crearFloristeria 
//		Floristeria floristeria = new Floristeria ("floristeria");
//		
//		//afegirArbre 
//		Arbre llimoner = new Arbre("llimoner", 20.5, 3.5);
//		Arbre avet = new Arbre("avet", 20.5, 3.5);
//		Arbre pi = new Arbre("pi", 20.5, 3.5);
//		
//		controller.afegirArbre(floristeria, llimoner);
//		controller.afegirArbre(floristeria, avet);
//		controller.afegirArbre(floristeria, pi);
//		
//		//afegirFlor 
//		Flor flor = new Flor("rosa", 5, "vermell");
//		
//		controller.afegirFlor(floristeria, flor);
//		
//		//afegirDecoracio 
//		Decoracio decoracio = new Decoracio("Decoracio de fusta", 6.5, true);
//		
//		controller.afegirDecoracio(floristeria, decoracio);
		
		
	}
	

	
	

	
	private static void printejarFloristeria(Floristeria floristeria) {
		System.out.println("Arbres: ");
		controller.printArbres(floristeria);
		System.out.println("Flors: ");
		controller.printFlors(floristeria);
		System.out.println("Decoracions: ");
		controller.printDecoracions(floristeria);
		
	}

}
