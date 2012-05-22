package model;

import java.util.ArrayList;

import model.ListAction.typeAction;


public class ListEvent extends ArrayList<Event>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListEvent list_event;

	private static int ID=1;

	/**
	 * @param list
	 */
	public ListEvent(ListEvent list) {
		super();
		this.list_event = list;
	}

	public ListEvent getList() {
		return list_event;
	}

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

	public void setList(ListEvent list) {
		this.list_event = list;
	}
	
	
	public void addEvent (String etat, Processus p, int instant){
		ID++;
		Event e = new Event(ID, etat, p, instant);
		list_event.add(e);
	}
	
	
	public Event getEvent(int id){
		Event resultat = null;
		for (Event e : list_event) {
			if( e.getID_event() == id ){
				resultat = e;
			}
		}
		return resultat;
	}

	
}
