package com.floristeria.domain;

public class Decoracio extends Producte {
	

	
	private boolean material;  //true=fusta, false=plàstic
	


	public void afegirArbre(String nom, double preu, boolean material) {
		Decoracio newArbre = new Decoracio();
		
		newArbre.setPreu(preu);
		newArbre.setNom(nom);
		newArbre.setMaterial(material);
		
		//TODO s'ha de guardar al magatzem
	}
	
	

	//getters & setters
	public boolean getMaterial() {
		return material;
	}

	public void setMaterial(boolean material) {
		this.material = material;
	}

}
