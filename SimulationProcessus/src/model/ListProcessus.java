/**
 * 
 */
package model;


import java.util.ArrayList;
import java.util.Iterator;



public class ListProcessus extends ArrayList<Processus>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int ID;
	private ListProcessus listProcessus;
	
	
	
	/*********************************************************************/
	/********************GETTERS - SETTERS********************************/

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the listProcessus
	 */
	public ArrayList<Processus> getListProcessus() {
		return listProcessus;
	}


	/**
	 * @param listProcessus the listProcessus to set
	 */
	public void setListProcessus(ListProcessus listProcessus) {
		this.listProcessus = listProcessus;
	}
	
	/*********************************************************************/
	/*********************************************************************/
	


	/**
	 * Construit une nouvelle liste de serveurs.
	 */
	public ListProcessus(){
		listProcessus = new ListProcessus();
	}
	

	public void ajouterProcessus(int id, String n, ListAction l, int iDem, boolean rep, int prio, int tVie,int T_arr, int tAtt, boolean stat, int fin){
		ID++;
		Processus p = new Processus(ID, n, l, iDem, rep, prio,T_arr, tVie, tAtt,stat,fin);
		listProcessus.add(p);
	}
	
	/**
	 * retourne le processus correspondant au numéro entré en parametre
	 * @param numero
	 * @return
	 */
	public Processus getProcessus(int numero){
		Processus resultat = null;
		for (Processus p : listProcessus) {
			if( p.getID() == numero ){
				resultat = p;
			}
		}
		return resultat;
	}

	
	/**
	 * Retourne sous la forme d'un String la liste des processus.
	 * @return La liste des processus a afficher
	 */
	public String toString(){
		return"Liste Des Processus : " + listProcessus.toString();
	}
	
	
	/*********************************************************************/
	/*******************Methode de surcharge de la collection*************/
	@Override
	public Iterator<Processus> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return listProcessus.size();
	}
	/*********************************************************************/
	/*********************************************************************/
	
}
