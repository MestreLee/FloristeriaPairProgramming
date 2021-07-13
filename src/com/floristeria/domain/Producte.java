package com.floristeria.domain;

public abstract class Producte {
	
	
	private String nom;
	private double preu;
	
	
	
	
	
	//getters & setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPreu() {
		return preu;
	}
	public void setPreu(double preu) {
		this.preu = preu;
	}

}
