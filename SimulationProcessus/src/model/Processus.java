/**
 * 
 */
package model;



public class Processus {

	/**
	 * 
	 */
	private int IDProcessus;
	private String nom;
	private ListAction listAction;
	private int instantDemarage;
	private boolean repetition;
	private int priority;
	private int tempsVie;
	private int tempsAttente;
	
	public Processus() {
		IDProcessus = 0;
		nom = "";
		listAction = null;
		instantDemarage = 0;
		repetition = false;
		priority = 0;
		tempsVie = 0;
		tempsAttente = 0;
	}
	

	/**
	 * @param iD
	 * @param nom
	 * @param listAction
	 * @param instantDemarage
	 * @param repetition
	 * @param priority
	 * @param tempsVie
	 * @param tempsAttente
	 */
	public Processus(int iD, String nom, ListAction listAction,
			int instantDemarage, boolean repetition, int priority,
			int tempsVie, int tempsAttente) {
		super();
		IDProcessus = iD;
		this.nom = nom;
		this.listAction = listAction;
		this.instantDemarage = instantDemarage;
		this.repetition = repetition;
		this.priority = priority;
		this.tempsVie = tempsVie;
		this.tempsAttente = tempsAttente;
	}


	/**
	 * @return the iD
	 */
	public int getID() {
		return IDProcessus;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		IDProcessus = iD;
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
	 * @return the listAction
	 */
	public ListAction getListAction() {
		return listAction;
	}

	/**
	 * @param listAction the listAction to set
	 */
	public void setListAction(ListAction listAction) {
		this.listAction = listAction;
	}

	/**
	 * @return the instantDemarage
	 */
	public int getInstantDemarage() {
		return instantDemarage;
	}

	/**
	 * @param instantDemarage the instantDemarage to set
	 */
	public void setInstantDemarage(int instantDemarage) {
		this.instantDemarage = instantDemarage;
	}

	/**
	 * @return the repetition
	 */
	public boolean isRepetition() {
		return repetition;
	}

	/**
	 * @param repetition the repetition to set
	 */
	public void setRepetition(boolean repetition) {
		this.repetition = repetition;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the tempsVie
	 */
	public int getTempsVie() {
		return tempsVie;
	}

	/**
	 * @param tempsVie the tempsVie to set
	 */
	public void setTempsVie(int tempsVie) {
		this.tempsVie = tempsVie;
	}

	/**
	 * @return the tempsAttente
	 */
	public int getTempsAttente() {
		return tempsAttente;
	}

	/**
	 * @param tempsAttente the tempsAttente to set
	 */
	public void setTempsAttente(int tempsAttente) {
		this.tempsAttente = tempsAttente;
	}
	
	/*
	public String toString(){
		char[] p = prenom.toCharArray();
		p[0]=Character.toUpperCase(p[0]);
		String s = new String(p);
		return s + " " + nom.toUpperCase();
	}
*/
}
