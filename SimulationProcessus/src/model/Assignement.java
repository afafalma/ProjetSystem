package model;

import java.io.Serializable;


public class Assignement  implements Serializable{

	/**
	 * 
	 */
	public Assignement() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int IDAssignement;
	private int dureeTotale;
	private Algorithme algo;
	private int quantum;
	private int dureeCommut;
	private ListProcessus listProcess;
	private int nbcommut;



	/**
	 * @param dureeTotale
	 * @param algo
	 * @param quantum
	 * @param dureeCommut
	 * @param listProcess
	 * @param nbcommut
	 */
	public Assignement(int ID, int dureeTotale, Algorithme algo, int quantum,
			int dureeCommut, ListProcessus listProcess, int nbcommut) {
		super();
		IDAssignement = ID;
		this.dureeTotale = dureeTotale;
		this.algo = algo;
		this.quantum = quantum;
		this.dureeCommut = dureeCommut;
		this.listProcess = listProcess;
		this.nbcommut = nbcommut;
	}


	/**
	 * @return the iDAssignement
	 */
	public int getIDAssignement() {
		return IDAssignement;
	}


	/**
	 * @param iDAssignement the iDAssignement to set
	 */
	public void setIDAssignement(int iDAssignement) {
		IDAssignement = iDAssignement;
	}



	/**
	 * @return the dureeTotale
	 */
	public int getDureeTotale() {
		return dureeTotale;
	}


	/**
	 * @param dureeTotale the dureeTotale to set
	 */
	public void setDureeTotale(int dureeTotale) {
		this.dureeTotale = dureeTotale;
	}


	/**
	 * @return the algo
	 */
	public Algorithme getAlgo() {
		return algo;
	}


	/**
	 * @param algo the algo to set
	 */
	public void setAlgo(Algorithme algo) {
		this.algo = algo;
	}


	/**
	 * @return the quantum
	 */
	public int getQuantum() {
		return quantum;
	}


	/**
	 * @param quantum the quantum to set
	 */
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}


	/**
	 * @return the dureeCommut
	 */
	public int getDureeCommut() {
		return dureeCommut;
	}


	/**
	 * @param dureeCommut the dureeCommut to set
	 */
	public void setDureeCommut(int dureeCommut) {
		this.dureeCommut = dureeCommut;
	}


	/**
	 * @return the listProcess
	 */
	public ListProcessus getListProcess() {
		return listProcess;
	}


	/**
	 * @param listProcess the listProcess to set
	 */
	public void setListProcess(ListProcessus listProcess) {
		this.listProcess = listProcess;
	}


	/**
	 * @return the nbcommut
	 */
	public int getNbcommut() {
		return nbcommut;
	}


	/**
	 * @param nbcommut the nbcommut to set
	 */
	public void setNbcommut(int nbcommut) {
		this.nbcommut = nbcommut;
	}



	public void simulation (){
		//algo.simulation(this);
	}
}
