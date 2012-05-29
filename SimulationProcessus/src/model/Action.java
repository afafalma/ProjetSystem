/**
 * 
 */
package model;

import model.ListAction.typeAction;



public class Action {

	private int IDAction;
	private int duree;
	private typeAction t;
	boolean exec = false;
	


	/**
	 * @param iDAction
	 * @param duree
	 * @param exec
	 */
	public Action(int iDAction, int duree, typeAction t, boolean exec) {
		super();
		IDAction = iDAction;
		this.duree = duree;
		this.t = t;
		this.exec = exec;
	}
	
	/**
	 * @return the iDAction
	 */
	public int getIDAction() {
		return IDAction;
	}

	/**
	 * @param iDAction the iDAction to set
	 */
	public void setIDAction(int iDAction) {
		IDAction = iDAction;
	}

	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * @return the t
	 */
	public typeAction getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(typeAction t) {
		this.t = t;
	}

	/**
	 * @return the exec
	 */
	public boolean isExec() {
		return exec;
	}

	/**
	 * @param exec the exec to set
	 */
	public void setExec(boolean exec) {
		this.exec = exec;
	}

	
	
	
}
