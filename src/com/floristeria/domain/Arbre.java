package com.floristeria.domain;

public class Arbre extends Producte {
	
	private double alcada;  //al�ada

	public Arbre(String nom, double preu, double alcada) {
		super(nom, preu);
		this.setAlcada(alcada);
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
		return "Arbre: " + getNom() + ", al�ada " + alcada + ", ID: " + this.id + ", Preu= " + getPreu() +  ", Stock " + this.getStock();
	}

}
