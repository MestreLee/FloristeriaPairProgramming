package com.floristeria.domain;

public class Decoracio extends Producte {
	
	private boolean material;  //true=fusta, false=plàstic

	public Decoracio(String nom, double preu, boolean material) {
		
		this.setPreu(preu);
		this.setNom(nom);
		this.setMaterial(material);
		
		//TODO s'ha de guardar al magatzem
	}
	

	//getters & setters
	public boolean getMaterial() {
		return material;
	}

	public void setMaterial(boolean material) {
		this.material = material;
	}


	@Override
	public String toString() {
		String mater = this.material 
  				? "Fusta" 
  				: "Plastic";
		return "Decoracio [material=" + mater + ", Nom= " + getNom() + ", Preu= " + getPreu() + "]";
	}
	
	

}
