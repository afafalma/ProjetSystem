package controller;

import view.ConfigGeneral;

public class Controller {

	private ConfigGeneral ConfVue;

	
	/**
	 * @param confVue
	 */
	public Controller() {
		super();
		ConfVue = new ConfigGeneral();
	}


	/**
	 * @return the confVue
	 */
	public ConfigGeneral getConfVue() {
		return ConfVue;
	}


	/**
	 * @param confVue the confVue to set
	 */
	public void setConfVue(ConfigGeneral confVue) {
		ConfVue = confVue;
	}
	
	public void displayConfigGeneral() {
		ConfVue.display();
	}

	
}
