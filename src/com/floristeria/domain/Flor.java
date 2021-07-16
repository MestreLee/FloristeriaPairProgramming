package com.floristeria.domain;

public class Flor extends Producte {
	
	private String color;
	
	public Flor(String nom, double preu, String color) {
		super(nom, preu);
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
		return "Flor:" + getNom() + ", color: " + color + ", ID: " + getId() + ", Preu= " + getPreu() + ", stock: " + getStock();
	}


}
