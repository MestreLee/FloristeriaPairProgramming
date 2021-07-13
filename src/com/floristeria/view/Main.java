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
		Arbre arbre = new Arbre("llimoner", 20.5, 3.5);
		
		floristeries.get(0).afegirArbre(arbre);
		
		//afegirFlor 
		Flor flor = new Flor("rosa", 5, "vermell");
		
		floristeries.get(0).afegirFlor(flor);
		
		//afegirDecoracio 
		Decoracio decoracio = new Decoracio("Decoracio de fusta", 6.5, true);
		
		floristeries.get(0).afegirDecoracio(decoracio);
		
		System.out.println(floristeries.get(0).toString());
		
		//stock: imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
		
	}
	
	private static void crearFloristeria (List<Floristeria> floristeries, String nom) {
		Floristeria newFloristeria = new Floristeria(nom);
		floristeries.add(newFloristeria);
		System.out.println("Floristeria " + newFloristeria.getNom() + " creada correctament!");
	}
	


}
