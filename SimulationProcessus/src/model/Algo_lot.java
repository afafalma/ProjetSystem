/**
 * 
 */
package model;

/**
 * @author dienaba
 *
 */
public abstract class Algo_lot extends Algorithme  {

	/**
	 * 
	 */
	/**
	 * 
	 */
	
	public Algo_lot() {
		// TODO Auto-generated constructor stub
	}

	public Algo_lot(int num, String nom) {
		super(num, nom);
		// TODO Auto-generated constructor stub
	}


	public abstract ListEvent simulation (Assignement Ass);

}

