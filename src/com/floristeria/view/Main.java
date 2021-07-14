package com.floristeria.view;

import com.floristeria.domain.Floristeria;
import com.floristeria.persistence.Magatzem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
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
				String nomFloristeria = sca.next();
				crearFloristeria(nomFloristeria);
				break;
				
			case 'b':
				boolean floristeriaExistent = false;
				String nomFLoristeria;
				while (floristeriaExistent == false) {
					System.out.println("+------------------------------------------+");
					System.out.println("|   Introduiu el nom de la floristeria     |");
					System.out.println("+------------------------------------------+");
					nomFLoristeria = sca.next();
					boolean floristeriaExistent = Arrays.stream(floristeries).anyMatch(nomFloristeria::equals); //TODO comprovar que funciona quan estigui tot el codi muntat
				}
				Floristeria floristeriaActual = floristeries.stream()
						.filter(floristeria -> nomFLoristeria.equals(floristeria.getNom()))
						.findAny();

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
				
				floristeriaActual.afegirArbre(nomArbre, preuArbre, alcadaArbre);
				
				break;
				
			case 'c':
				boolean floristeriaExistent = false;
				String nomFLoristeria;
				while (floristeriaExistent == false) {
					System.out.println("+------------------------------------------+");
					System.out.println("|   Introduiu el nom de la floristeria     |");
					System.out.println("+------------------------------------------+");
					nomFLoristeria = sca.next();
					boolean floristeriaExistent = Arrays.stream(floristeries).anyMatch(nomFloristeria::equals); //TODO comprovar que funciona quan estigui tot el codi muntat
				}
				Floristeria floristeriaActual = floristeries.stream()
						.filter(floristeria -> nomFLoristeria.equals(floristeria.getNom()))
						.findAny();
				
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
				
				floristeriaActual.afegirFlor(nomArbre, preuArbre, colorFlor);
				
				break;
				
			case 'd':
				boolean floristeriaExistent = false;
				String nomFLoristeria;
				while (floristeriaExistent == false) {
					System.out.println("+------------------------------------------+");
					System.out.println("|   Introduiu el nom de la floristeria     |");
					System.out.println("+------------------------------------------+");
					nomFLoristeria = sca.next();
					boolean floristeriaExistent = Arrays.stream(floristeries).anyMatch(nomFloristeria::equals); //TODO comprovar que funciona quan estigui tot el codi muntat
				}
				Floristeria floristeriaActual = floristeries.stream()
						.filter(floristeria -> nomFLoristeria.equals(floristeria.getNom()))
						.findAny();
				
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
				boolean materialDecoracioBool;
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
						materialDecoracio.toLowerCase();
					}
				}
				
				floristeriaActual.afegirDecoracio(nomArbre, preuArbre, materialDecoracioBool);
				
				break;
				
			case 'z':
				x = 1;
				sca.close();
				System.out.println("bye");
				break;
			}
		}
		
		

		
		
		
		
		//crearFloristeria 
		crearFloristeria("Floristeria 1");
		//afegirArbre 
		
		//afegirFlor 
		//afegirDecoracio 
		//stock: imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
		
	}
	
	private static void crearFloristeria (String nom) {
		Floristeria newFloristeria = new Floristeria(nom);
	}
	
	private static void afegirArbre (Floristeria floristeria, String nom) {
		
	}
	

}
