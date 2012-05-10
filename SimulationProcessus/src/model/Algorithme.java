package model;

import model.ListAlgorithme.type;

public class Algorithme {
	
	private int num;
	private String nom;
	private type t;
	
	/**
	 * @param nom
	 */
	public Algorithme(String nom) {
		super();
		this.nom = nom;
	}
	
	
	
	/**
	 * @return the iD
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the t
	 */
	public type getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(type t) {
		this.t = t;
	}
	
}
