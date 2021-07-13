package com.floristeria.domain;

public class Arbre extends Producte {
	

	
	private double alcada;  //alçada
	


	public void afegirArbre(String nom, double preu, double alcada) {
		Arbre newArbre = new Arbre();
		
		newArbre.setPreu(preu);
		newArbre.setNom(nom);
		newArbre.setAlcada(alcada);
		
		//TODO s'ha de guardar al magatzem
	}
	
	

	//getters & setters
	public double getAlcada() {
		return alcada;
	}

	public void setAlcada(double alcada) {
		this.alcada = alcada;
	}

}
