package com.floristeria.domain;

import java.util.ArrayList;

public class Floristeria {
	private String nom;
	private ArrayList<Arbre> arbres = new ArrayList<Arbre>();
	private ArrayList<Flor> flors = new ArrayList<Flor>();;
	private ArrayList<Decoracio> decoracions = new ArrayList<Decoracio>();;		
	
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
	
	public void afegirArbre(Arbre arbre) {
		this.arbres.add(arbre);
	}
	
	public void afegirFlor(Flor flor) {
		this.flors.add(flor);
	}
	
	public void afegirDecoracio(Decoracio decoracio) {
		this.decoracions.add(decoracio);
	}
	
	public void printArbres(){
		for (Arbre ar : this.arbres) {
			System.out.println(ar.getNom());
		}
	}
	
	public void printFlors(){
		for (Flor fl : this.flors) {
			System.out.println(fl.getNom());
		}
	}
	
	public void printDecoracions(){
		for (Decoracio dc : this.decoracions) {
			System.out.println(dc.getNom());
		}
	}


	@Override
	public String toString() {
		return "nom=" + nom + ", arbres=" + arbres + ", flors=" + flors + ", decoracions=" + decoracions;
	}
	
	


}
