package com.floristeria.domain;

public class Flor extends Producte {
	

	
	private String color;
	


	public void afegirFlor(String nom, double preu, String color) {
		Flor newFlor = new Flor();
		
		newFlor.setPreu(preu);
		newFlor.setNom(nom);
		newFlor.setColor(color);
		
		//TODO s'ha de guardar al magatzem
	}
	
	

	//getters & setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
