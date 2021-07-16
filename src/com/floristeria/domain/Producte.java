package com.floristeria.domain;

public abstract class Producte {
	
	protected Producte(String nom, double preu) {
		id = Producte.nextId;
		nextId++;
		this.nom = nom;
		this.preu = preu;
		
	}
	
	
	//abstract attributes
	private String nom;
	private double preu;
	private String tipus; //arbre, flor, decoracio
	private static int nextId = 1;
    protected int id;
	private int stock;
	
	
	
	//getters & setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPreu() {
		return preu;
	}
	public void setPreu(double preu) {
		this.preu = preu;
	}
	
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	public int getId() {
		return id;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void incStock() {
		stock++;
	}
	
	public void decrStock() {
		stock--;
	}
	
	
	@Override
	public String toString() {
		return "Producte [nom=" + nom + ", preu=" + preu + "]";
	}
	

	
	
}
