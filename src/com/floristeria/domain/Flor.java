package com.floristeria.domain;

public class Flor extends Producte {
	
	private String color;
	

	public Flor(String nom, double preu, String color) {
		
		this.setPreu(preu);
		this.setNom(nom);
		this.setColor(color);

	}
		

	//getters & setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Flor [color=" + color + ", Nom= " + getNom() + ", Preu= " + getPreu() + "]";
	}



	
	

}
