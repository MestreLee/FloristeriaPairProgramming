package com.floristeria.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Floristeria {
	private String nom;
	private double valorTotalStock = 0;
	
	static ArrayList<Producte> productes = new ArrayList<Producte>();
	
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

		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1 i suma el valor al valor total de l'stock
		boolean trobat = false;  
		for (Producte pr:productes) {
			if((pr instanceof Arbre)) {	
				if(pr.equals(arbre)) {
					pr.incStock();
					valorTotalStock = valorTotalStock + pr.getPreu();
					trobat = true;
					break;
				}

			}
		}
		
		//comprova si no trobat, afegeix stock = 1, suma el seu valor al valor total de l'stock i l'arbre a l'array
		if (!trobat) {
			arbre.setStock(1);
			valorTotalStock = valorTotalStock + arbre.getPreu();
			//afegir a l'array
			productes.add(arbre);
		}
	}
	
	public void afegirFlor(Flor flor) {
		flor.setTipus("flor");
		
		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1 i suma el valor al valor total de l'stock
		boolean trobat = false;
		for (Producte pr:productes) {
			if((pr instanceof Flor)) {	
				if(pr.equals(flor)) {
					pr.incStock();
					valorTotalStock = valorTotalStock + pr.getPreu();
					trobat = true;
					break;
				}

			}
		}
		
		//comprova si no trobat, afegeix stock = 1, suma el seu valor al valor total de l'stock i la flor a l'array
		if (!trobat) {
			flor.setStock(1);
			valorTotalStock = valorTotalStock + flor.getPreu();
			//afegir a l'array
			productes.add(flor);
		}
	}
	
	public void afegirDecoracio(Decoracio decoracio) {
		decoracio.setTipus("decoracio");
		
		//busca el producte a l'array de productes, si hi és n'incrementa el stock en 1 i suma el valor al valor total de l'stock
		boolean trobat = false;
		for (Producte pr:productes) {
			if((pr instanceof Decoracio)) {	
				if(pr.equals(decoracio)) {
					pr.incStock();
					valorTotalStock = valorTotalStock + pr.getPreu();
					trobat = true;
					break;
				}

			}
		}
		
		//comprova si no trobat, afegeix stock = 1, suma el seu valor al valor total de l'stock i la decoració a l'array
		if (!trobat) {
			decoracio.setStock(1);
			valorTotalStock = valorTotalStock + decoracio.getPreu();
			//afegir a l'array
			productes.add(decoracio);
		}
	}
	
	public void printArbres(){
		List<Producte>toPrint = productes.stream()
				.filter( producte -> producte.getTipus().equals("arbre") )
				.filter( producte -> producte.getStock() >= 1 )
				.collect(Collectors.toList());
		System.out.println(toPrint.toString());
	}
	
	public void printFlors(){
		List<Producte>toPrint = productes.stream()
				.filter( producte -> producte.getTipus().equals("flor") )
				.filter( producte -> producte.getStock() >= 1 )
				.collect(Collectors.toList());
		System.out.println(toPrint.toString());
	}
	
	public void printDecoracions(){
		List<Producte>toPrint = productes.stream()
				.filter( producte -> producte.getTipus().equals("decoracio") )
				.filter( producte -> producte.getStock() >= 1 )
				.collect(Collectors.toList());
		System.out.println(toPrint.toString());
	}
	
	public void retirarProducte(Producte producte) {
		for(Producte pr: productes) {
			if (pr.getId() == producte.getId()) {
				if(pr.getStock() == 0) {
					System.out.println("No queda stock d'aquest producte!");
					break;
				}else {
					pr.decrStock();
				}
					
			}
		}
	}
	
	public void printStock() {
		for (Producte pr:productes) {
			System.out.println("Producte: " + pr.getNom() + ", stock: " + pr.getStock());
		}
	}

	public void printValorTotal() {
		
		System.out.println("El valor total de l'stock de la floristeria és de: " + valorTotalStock + " €.");
	}

	
	//TO string
//	@Override
//	public String toString() {
//		return "nom=" + nom + ", arbres=" + productes.get("arbre") + ", flors=" + productes.get("flor") 
//		+ ", decoracions=" + productes.get("decoracio");
//	}
}
