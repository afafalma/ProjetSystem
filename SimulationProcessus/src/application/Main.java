package application;

import controller.Controller;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*initialisation du modele tampon
				ModeleSwing modele = new ModeleSwing();
			*/	
				//initialisation des controleurs
				Controller controlleur_ConfigGenerale = new Controller();		

				//affichage des fenetres
				controlleur_ConfigGenerale.displayConfigGeneral();

			}
			
	}


