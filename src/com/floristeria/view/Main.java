package com.floristeria.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.floristeria.domain.Arbre;
import com.floristeria.domain.Decoracio;
import com.floristeria.domain.Flor;
import com.floristeria.domain.Floristeria;

public class Main {
	
	private static List<Floristeria> floristeries=new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		//crida el scanner
		Scanner sca = new Scanner(System.in);
		
		//menú de navegació
		int x=-1;
		while (x<0) {			
			System.out.println("+------------------------------------------+");
			System.out.println("| Seleccioneu una de les següents opcions: |");
			System.out.println("+==========================================+");
			System.out.println("|   a: crear nova floristeria              |");
			System.out.println("+------------------------------------------+");
			System.out.println("|   b: afegir arbre                        |");
			System.out.println("|   c: afegir flor                         |");
			System.out.println("|   d: afegir decoració                    |");
			System.out.println("+------------------------------------------+");
			System.out.println("|   z: tancar programa                     |");
			System.out.println("+------------------------------------------+");
			
			char selector = sca.next().charAt(0);
			
			
			switch (selector) {
			case 'a':
				System.out.println("+------------------------------------------+");
				System.out.println("|   introduiu el nom de la floristeria:    |");
				System.out.println("+------------------------------------------+");
				String nomFloristeriaA = sca.next();
				crearFloristeria(floristeries, nomFloristeriaA);
				break;
				
			case 'b':
				boolean floristeriaBExistent = false;
				int floristeriaBIndex = -1;
				while (floristeriaBExistent == false) {
					System.out.println("+------------------------------------------+");
					System.out.println("|   Introduiu el nom de la floristeria     |");
					System.out.println("+------------------------------------------+");
					String nomFLoristeriaB = sca.next();
					for (int i=0; i<floristeries.size(); i++) {
						if (nomFLoristeriaB.equals(floristeries.get(i).getNom())) {
							floristeriaBIndex = i;
							floristeriaBExistent = true;
						}
						else {
							System.out.println("+------------------------------------------+");
							System.out.println("|   floristeria no trobada                 |");
						}
					}
				}
				
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
				floristeries.get(floristeriaBIndex).afegirArbre(newArbre);
				
				break;
				
			case 'c':
				boolean floristeriaCExistent = false;
				int floristeriaCIndex = -1;
				while (floristeriaCExistent == false) {
					System.out.println("+------------------------------------------+");
					System.out.println("|   Introduiu el nom de la floristeria     |");
					System.out.println("+------------------------------------------+");
					String nomFLoristeriaC = sca.next();
					for (int i=0; i<floristeries.size(); i++) {
						if (nomFLoristeriaC.equals(floristeries.get(i).getNom())) {
							floristeriaCIndex = i;
							floristeriaCExistent = true;
						}
						else {
							System.out.println("+------------------------------------------+");
							System.out.println("|   floristeria no trobada                 |");
						}
					}
				}
				
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
				floristeries.get(floristeriaCIndex).afegirFlor(newFlor);
				
				break;
				
			case 'd':
				boolean floristeriaDExistent = false;
				int floristeriaDIndex = -1;
				while (floristeriaDExistent == false) {
					System.out.println("+------------------------------------------+");
					System.out.println("|   Introduiu el nom de la floristeria     |");
					System.out.println("+------------------------------------------+");
					String nomFLoristeriaD = sca.next();
					for (int i=0; i<floristeries.size(); i++) {
						if (nomFLoristeriaD.equals(floristeries.get(i).getNom())) {
							floristeriaDIndex = i;
							floristeriaDExistent = true;
						}
						else {
							System.out.println("+------------------------------------------+");
							System.out.println("|   floristeria no trobada                 |");
						}
					}
				}
				
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
				materialDecoracio.toLowerCase();
				
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
						materialDecoracio = materialDecoracio.toLowerCase(); //TODO 
					}
				}
				Decoracio newDecoracio = new Decoracio(nomDecoracio, preuDecoracio, materialDecoracioBool);
				floristeries.get(floristeriaDIndex).afegirDecoracio(newDecoracio);
				
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
//		crearFloristeria(floristeries, "Floristeria 1");
//		
//		//afegirArbre 
//		Arbre llimoner = new Arbre("llimoner", 20.5, 3.5);
//		Arbre avet = new Arbre("avet", 20.5, 3.5);
//		Arbre pi = new Arbre("pi", 20.5, 3.5);
//		
//		floristeries.get(0).afegirArbre(llimoner);
//		floristeries.get(0).afegirArbre(avet);
//		floristeries.get(0).afegirArbre(pi);
//		
//		//afegirFlor 
//		Flor flor = new Flor("rosa", 5, "vermell");
//		
//		floristeries.get(0).afegirFlor(flor);
//		
//		//afegirDecoracio 
//		Decoracio decoracio = new Decoracio("Decoracio de fusta", 6.5, true);
//		
//		floristeries.get(0).afegirDecoracio(decoracio);
//		
//		//stock: imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
//		
//		printejarFloristeria(floristeries.get(0));
		
		
	}
	
	private static void crearFloristeria (List<Floristeria> floristeries, String nom) {
		Floristeria newFloristeria = new Floristeria(nom);
		floristeries.add(newFloristeria);
	}
	
	private static void printejarFloristeria(Floristeria floristeria) {
		System.out.println("Arbres: ");
		floristeria.printArbres();
		System.out.println("Flors: ");
		floristeria.printFlors();
		System.out.println("Decoracions: ");
		floristeria.printDecoracions();
		
	}

}
