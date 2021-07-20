package com.floristeria.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.domain.Arbre;
import com.floristeria.domain.Decoracio;
import com.floristeria.domain.Flor;
import com.floristeria.domain.Floristeria;
import com.floristeria.domain.Producte;

public class ControladorFloristeria {
	public ControladorFloristeria() {
		
	}
	
	public void afegirArbre(Floristeria floristeria, Arbre arbre) {
		//assigna tipus
		arbre.setTipus("arbre");

		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1
		boolean trobat = false;  
		for (Producte pr:floristeria.getProductes()) {
			if((pr instanceof Arbre)) {	
				if(pr.getNom().equals(arbre.getNom())) {
					if(pr.getPreu() == arbre.getPreu()) {
						if(((Arbre) pr).getAlcada() == arbre.getAlcada()) {
							pr.incStock();
							floristeria.incrValorTotalStock(pr.getPreu());
							trobat = true;
							break;
						}
					}
				}
			}
		}
				
		//comprova si no trobat, afegeix stock = 1, suma el seu valor al valor total de l'stock i l'arbre a l'array
		if (!trobat) {
			arbre.setStock(1);
			floristeria.incrValorTotalStock(arbre.getPreu());
			//afegir a l'array
			floristeria.getProductes().add(arbre);
		}
	}
	
	public void afegirFlor(Floristeria floristeria, Flor flor) {
		//assigna tipus
		flor.setTipus("flor");

		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1
		boolean trobat = false;  
		for (Producte pr:floristeria.getProductes()) {
			if((pr instanceof Flor)) {	
				if(pr.getNom().equals(flor.getNom())) {
					if(pr.getPreu() == flor.getPreu()) {
						if(((Flor) pr).getColor().equals(flor.getColor())) {
							pr.incStock();
							floristeria.incrValorTotalStock(pr.getPreu());
							trobat = true;
							break;
						}
					}
				}
			}
		}
				
		//comprova si no trobat, afegeix stock = 1, suma el seu valor al valor total de l'stock i l'arbre a l'array
		if (!trobat) {
			flor.setStock(1);
			floristeria.incrValorTotalStock(flor.getPreu());
			//afegir a l'array
			floristeria.getProductes().add(flor);
		}
	}
	
	public void afegirDecoracio(Floristeria floristeria, Decoracio decoracio) {
		//assigna tipus
		decoracio.setTipus("decoracio");

		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1
		boolean trobat = false;  
		for (Producte pr:floristeria.getProductes()) {
			if((pr instanceof Decoracio)) {	
				if(pr.getNom().equals(decoracio.getNom())) {
					if(pr.getPreu() == decoracio.getPreu()) {
						if(((Decoracio) pr).getMaterial().equals(decoracio.getMaterial())) {
							pr.incStock();
							floristeria.incrValorTotalStock(pr.getPreu());
							trobat = true;
							break;
						}
					}
				}
			}
		}
				
		//comprova si no trobat, afegeix stock = 1, suma el seu valor al valor total de l'stock i l'arbre a l'array
		if (!trobat) {
			decoracio.setStock(1);
			floristeria.incrValorTotalStock(decoracio.getPreu());
			//afegir a l'array
			floristeria.getProductes().add(decoracio);
		}
	}
	
	public boolean comprovarStock(Floristeria floristeria, int id) {
		boolean teStock = false;
		for(Producte pr: floristeria.getProductes()) {
			if (pr.getId() == id) {
				if(pr.getStock() == 0) {
					break;
			}else {
				teStock = true;
			}
			}
		}
		
		return teStock;
				
	}
	
	public void retirarProductes (Floristeria floristeria, ArrayList<Integer> llistaIds) {
		for (int id:llistaIds) {
			for (Producte pr: floristeria.getProductes()) {
				if(pr.getId() == id) {
					if(pr.getStock() == 0) {
						break;
					}else {
						pr.decrStock();
						floristeria.decrValorTotalStock(pr.getPreu());
						break;
					}

				}
			}
		}
	}
	
	public static void printArbres(Floristeria floristeria){
		List<Producte>toPrint = floristeria.getProductes().stream()
				.filter( producte -> producte.getTipus().equals("arbre") )
				.filter( producte -> producte.getStock() >= 1 )
				.collect(Collectors.toList());
		for(Producte pr: toPrint) {
			System.out.println(pr.toString());
		}
	}
	
	public static void printFlors(Floristeria floristeria){
		List<Producte>toPrint = floristeria.getProductes().stream()
				.filter( producte -> producte.getTipus().equals("flor") )
				.filter( producte -> producte.getStock() >= 1 )
				.collect(Collectors.toList());
		for(Producte pr: toPrint) {
			System.out.println(pr.toString());
		}
	}
	
	public static void printDecoracions(Floristeria floristeria){
		List<Producte>toPrint = floristeria.getProductes().stream()
				.filter( producte -> producte.getTipus().equals("decoracio") )
				.filter( producte -> producte.getStock() >= 1 )
				.collect(Collectors.toList());
		for(Producte pr: toPrint) {
			System.out.println(pr.toString());
		}
	}
	
	public void printStock(Floristeria floristeria) {
		for (Producte pr:floristeria.getProductes()) {
			System.out.println("Producte: " + pr.getNom() + ", stock: " + pr.getStock());
		}
	}
	
	public void printValorTotal(Floristeria floristeria) {
		
		System.out.println("El valor total de l'stock de la floristeria és de: " + floristeria.getValorTotalStock() + " €.");
	}
	
	public static void printejarFloristeria(Floristeria floristeria) {
		System.out.println("Arbres: ");
		printArbres(floristeria);
		System.out.println("Flors: ");
		printFlors(floristeria);
		System.out.println("Decoracions: ");
		printDecoracions(floristeria);
		
	}

}
