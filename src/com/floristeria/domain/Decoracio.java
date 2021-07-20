package com.floristeria.domain;

public class Decoracio extends Producte {
	
	private boolean material;  //true=fusta, false=plàstic

	public Decoracio(String nom, double preu, boolean material) {
		super(nom, preu);
		this.material = material;
	}


	@Override
	public String toString() {
		String mater = this.material 
  				? "Fusta" 
  				: "Plastic";
		return "Decoracio: " + getNom() + ", ID: " + getId() + ", material:" + mater + ", preu: " + getPreu() + ", stock: " + getStock();
	}
}
