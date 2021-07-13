package com.floristeria.domain;

public class Arbre extends Producte {
	
	private double alcada;  //alçada

	public Arbre(String nom, double preu, double alcada) {
		this.setPreu(preu);
		this.setNom(nom);
		this.setAlcada(alcada);
		
		//TODO s'ha de guardar al magatzem
	}
		

	//getters & setters
	public double getAlcada() {
		return alcada;
	}

	public void setAlcada(double alcada) {
		this.alcada = alcada;
	}


	@Override
	public String toString() {
		return "Arbre [alcada=" + alcada + ", Nom= " + getNom() + ", Preu= " + getPreu() + "]";
	}
	
	

}
