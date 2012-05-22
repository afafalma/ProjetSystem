package controller;

import view.GeneralConfiguration;


public class Controller {

	private GeneralConfiguration ConfVue;

	
	/**
	 * @param confVue
	 */
	public Controller() {
		super();
		ConfVue = new GeneralConfiguration();
	}


	/**
	 * @return the confVue
	 */
	public GeneralConfiguration getConfVue() {
		return ConfVue;
	}


	/**
	 * @param confVue the confVue to set
	 */
	public void setConfVue(GeneralConfiguration confVue) {
		ConfVue = confVue;
	}
	
	public void displayConfigGeneral() {
		ConfVue.display();
	}

	
}
