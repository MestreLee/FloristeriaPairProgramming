package com.floristeria.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Floristeria {
	private String nom;
	
	ArrayList<Producte> productes = new ArrayList<Producte>();
	
	//crea una floristeria i li assigna un nom.
	public Floristeria(String nom) {		
		this.nom = nom;
	}
	
	
	//getters & setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	//methods add/print products
	public void afegirArbre(Arbre arbre) {
		
		//assigna tipus
		arbre.setTipus("arbre");

		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1
		boolean trobat = false;  //TODO s'ha de canviar de manera que es puugi accedir a l'alçada
		for (Producte pr:productes) {
			if (pr.getNom().equals(arbre.getNom())) {
				if (pr.getPreu() == arbre.getPreu()) {
//					if (pr.getAlcada)
				}
				pr.incStock();
				trobat = true;
				break;
			}
		}
		
//		ArrayList<Arbre> arbres = productes.stream()
//				.filter(objecte -> {
//					objecte.getTipus().equals("arbre");
//					objecte = (Arbre) objecte;
//					})
//				.collect(Collectors.toList());
//		
//		arbres.get(i).getAlcada();
//		
//		for (int i=0; i<productes.size(); i++) {

			
			
//			if (pr.getNom().equals(arbre.getNom())) {
//				if (pr.getPreu() == arbre.getPreu()) {
//					if (pr.getAlcada)
//				}
//				pr.incStock();
//				trobat = true;
//				break;
//			}
//		}
		
		//comprova si no trobat, afegeix stock = 1 i la decoració a l'array
		if (!trobat) {
			arbre.setStock(1);
			
			//afegir a l'array
			productes.add(arbre);
		}
	}
	
	public void afegirFlor(Flor flor) {
		flor.setTipus("flor");
		
		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1
		boolean trobat = false;
		for (Producte pr:productes) {
			if (pr.getNom().equals(flor.getNom())) {
				pr.incStock();
				trobat = true;
				break;
			}
		}
		
		//comprova si no trobat, afegeix stock = 1 i la decoració a l'array
		if (!trobat) {
			flor.setStock(1);
			
			//afegir a l'array
			productes.add(flor);
		}
	}
	
	public void afegirDecoracio(Decoracio decoracio) {
		decoracio.setTipus("decoracio");
		
		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1
		boolean trobat = false;
		for (Producte pr:productes) {
			if (pr.getNom().equals(decoracio.getNom())) {
				pr.incStock();
				trobat = true;
				break;
			}
		}
		
		//comprova si no trobat, afegeix stock = 1 i la decoració a l'array
		if (!trobat) {
			decoracio.setStock(1);
			
			//afegir a l'array
			productes.add(decoracio);
		}
	}
	
	public void printArbres(){
		List<Producte>toPrint = productes.stream()
				.filter( producte -> producte.getTipus().equals("arbre") )
				.collect(Collectors.toList());
		System.out.println(toPrint.toString());
	}
	
	public void printFlors(){
		List<Producte>toPrint = productes.stream()
				.filter( producte -> producte.getTipus().equals("flor") )
				.collect(Collectors.toList());
		System.out.println(toPrint.toString());
	}
	
	public void printDecoracions(){
		List<Producte>toPrint = productes.stream()
				.filter( producte -> producte.getTipus().equals("decoracio") )
				.collect(Collectors.toList());
		System.out.println(toPrint.toString());
	}


	
	//TO string
//	@Override
//	public String toString() {
//		return "nom=" + nom + ", arbres=" + productes.get("arbre") + ", flors=" + productes.get("flor") 
//		+ ", decoracions=" + productes.get("decoracio");
//	}
}
