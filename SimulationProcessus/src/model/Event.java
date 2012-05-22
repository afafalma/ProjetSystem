package model;

public class Event {

	private int ID_event;
	private String etat=null;
	private Processus p;
	private int instant;


	/**
	 * @param etat
	 * @param p
	 * @param instant
	 */
	public Event(int ID_event, String etat, Processus p, int instant) {
		super();
		this.ID_event = ID_event;
		this.etat = etat;
		this.p = p;
		this.instant = instant;
	}



	/**
	 * @return the iD_event
	 */
	public int getID_event() {
		return ID_event;
	}

	/**
	 * @param iD_event the iD_event to set
	 */
	public void setID_event(int iD_event) {
		ID_event = iD_event;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}



	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}



	/**
	 * @return the p
	 */
	public Processus getP() {
		return p;
	}



	/**
	 * @param p the p to set
	 */
	public void setP(Processus p) {
		this.p = p;
	}



	/**
	 * @return the instant
	 */
	public int getInstant() {
		return instant;
	}



	/**
	 * @param instant the instant to set
	 */
	public void setInstant(int instant) {
		this.instant = instant;
	}
	
	
	
	
}
