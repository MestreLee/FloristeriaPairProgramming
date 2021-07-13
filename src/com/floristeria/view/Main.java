package com.floristeria.view;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.domain.Arbre;
import com.floristeria.domain.Decoracio;
import com.floristeria.domain.Flor;
import com.floristeria.domain.Floristeria;

public class Main {
	
	private static List<Floristeria> floristeries=new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		//crearFloristeria 
		crearFloristeria(floristeries, "Floristeria 1");
		
		//afegirArbre 
		Arbre llimoner = new Arbre("llimoner", 20.5, 3.5);
		Arbre avet = new Arbre("avet", 20.5, 3.5);
		Arbre pi = new Arbre("pi", 20.5, 3.5);
		
		floristeries.get(0).afegirArbre(llimoner);
		floristeries.get(0).afegirArbre(avet);
		floristeries.get(0).afegirArbre(pi);
		
		//afegirFlor 
		Flor flor = new Flor("rosa", 5, "vermell");
		
		floristeries.get(0).afegirFlor(flor);
		
		//afegirDecoracio 
		Decoracio decoracio = new Decoracio("Decoracio de fusta", 6.5, true);
		
		floristeries.get(0).afegirDecoracio(decoracio);
		
		//stock: imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
		
		printejarFloristeria(floristeries.get(0));
		
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
