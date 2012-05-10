/**
 * 
 */
package model;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;


public class ListAction extends AbstractCollection<Action> {

	private static int ID=1;
	
	public enum typeAction {
		TRAITEMENT, ENTREESORTIE;
		public String toString(){
			switch (this){
				case TRAITEMENT : return "traitement";
				case ENTREESORTIE : return "entrée sortie";
			default: return "";
			}
		}
	}
	
	private ArrayList<Action> listActions;
	
	public ListAction(){
		listActions = new ArrayList<Action>();
	}
	
	
	/*********************************************************************/
	/****************************GET - SET********************************/
	
	
	/**
	 * @return the iD
	 */
	public static int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public static void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the listActions
	 */
	public ArrayList<Action> getListActions() {
		return listActions;
	}

	/**
	 * @param listActions the listActions to set
	 */
	public void setListActions(ArrayList<Action> listActions) {
		this.listActions = listActions;
	}

	/*********************************************************************/
	/*********************************************************************/
	
	
	public void ajoutAction(int duree, typeAction t){
		ID++;
		Action a = new Action(ID, duree,t);
		listActions.add(a);
	}
	
	
	public Action getAction(int id){
		Action resultat = null;
		for (Action a : listActions) {
			if( a.getIDAction() == id ){
				resultat = a;
			}
		}
		return resultat;
	}


	/*********************************************************************/
	/************SURCHARGE DES METHODES DE LA Collection******************/

	@Override
	public Iterator<Action> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/*********************************************************************/
	/*********************************************************************/
	
}
