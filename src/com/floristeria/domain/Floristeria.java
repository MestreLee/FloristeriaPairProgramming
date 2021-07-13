package com.floristeria.domain;

public class Floristeria {
	private String nom;
	
	
	
	//crea una floristeria i li assigna un nom.
	public Floristeria crearFloristeria(String nom) {
		
		Floristeria newFloristeria = new Floristeria();
		
		newFloristeria.setNom(nom);
		
		return newFloristeria;
	}
	
	
	
	
	//getters & setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
