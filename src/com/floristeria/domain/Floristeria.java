package com.floristeria.domain;

//import java.util.ArrayList;
import java.util.HashMap;

public class Floristeria {
	private String nom;
//	private ArrayList<Arbre> arbres = new ArrayList<Arbre>();
//	private ArrayList<Flor> flors = new ArrayList<Flor>();
//	private ArrayList<Decoracio> decoracions = new ArrayList<Decoracio>();
	
//	private ArrayList<Producte> productes = new ArrayList<Producte>();
	
	HashMap<String, Producte> productes = new HashMap<String, Producte>();
	
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

	//TODO getter i setter de la hashmap
	
	
	
	
	//methods add/print products
	public void afegirArbre(Arbre arbre) {
		this.productes.put("arbre", arbre);
	}
	
	public void afegirFlor(Flor flor) {
		this.productes.put("flor", flor);
	}
	
	public void afegirDecoracio(Decoracio decoracio) {
		this.productes.put("decoracio", decoracio);
	}
	
	public void printArbres(){
		System.out.println(productes.get("arbre")); //TODO comprovar que imprimeix algo entendible
//		for (Arbre ar : this.arbres) {
//			System.out.println(ar.getNom());
//		}
	}
	
	public void printFlors(){
		System.out.println(productes.get("flor")); //TODO comprovar que imprimeix algo entendible
//		for (Flor fl : this.flors) {
//			System.out.println(fl.getNom());
//		}
	}
	
	public void printDecoracions(){
		System.out.println(productes.get("decoracio")); //TODO comprovar que imprimeix algo entendible
//		for (Decoracio dc : this.decoracions) {
//			System.out.println(dc.getNom());
//		}
	}


	
	//TO string
	@Override
	public String toString() {
		return "nom=" + nom + ", arbres=" + productes.get("arbre") + ", flors=" + productes.get("flor") 
		+ ", decoracions=" + productes.get("decoracio");
	}
	
	


}
