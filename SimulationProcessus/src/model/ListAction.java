/**
 * 
 */
package model;
import java.util.ArrayList;


public class ListAction extends ArrayList<Action> {

	/**
	 *
	 */
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
	
	private ListAction list_action;
	
	public ListAction(){
		list_action = new ListAction();
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
	public ListAction getListActions() {
		return list_action;
	}

	/**
	 * @param listActions the listActions to set
	 */
	public void setListActions(ListAction list) {
		this.list_action = list;
	}

	/*********************************************************************/
	/*********************************************************************/
	
	
	public void ajoutAction(int duree, typeAction t){
		ID++;
		Action a = new Action(ID, duree,t,false);
		list_action.add(a);
	}
	
	
	public Action getAction(int id){
		Action resultat = null;
		for (Action a : list_action) {
			if( a.getIDAction() == id ){
				resultat = a;
			}
		}
		return resultat;
	}


	/*********************************************************************/
	/************SURCHARGE DES METHODES DE LA Collection******************

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

	
	*********************************************************************/
	/*********************************************************************/
	
}
