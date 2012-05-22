/**
 * 
 */
package model;

/**
 * @author dienaba
 *
 */
public abstract class Algo_ite extends Algorithme {

	/**
	 * 
	 */
	
	private int quantum;
	
	public Algo_ite() {
		super();
	}

	public Algo_ite(int num, String nom) {
		super(num, nom);
		// TODO Auto-generated constructor stub
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}



	public abstract ListEvent simulation (Assignement Ass);

}
