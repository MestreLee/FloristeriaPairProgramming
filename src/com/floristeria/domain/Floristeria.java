package com.floristeria.domain;

import java.util.ArrayList;

public class Floristeria {
	private String nom;
	private double valorTotalStock = 0;
	
	static ArrayList<Producte> productes = new ArrayList<Producte>();
	
	//crea una floristeria i li assigna un nom.
	public Floristeria(String nom) {		
		this.nom = nom;
	}
	
	
	//getters & setters
	public String getNom() {
		return nom;
	}

	public double getValorTotalStock() {
		return valorTotalStock;
	}
	
	public void incrValorTotalStock(double increment) {
		valorTotalStock = valorTotalStock + increment;
	}
	
	public void decrValorTotalStock(double decrement) {
		valorTotalStock = valorTotalStock - decrement;
	}
	
	public ArrayList<Producte> getProductes(){
		return productes;
	}
}
