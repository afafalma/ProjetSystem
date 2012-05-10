package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ConfigGeneral extends JFrame {

	final Font policeDefaut = Font.getFont("Verdana"); 
	final Color couleurPoliceDefaut = new Color(18, 91, 152);
	final Color couleurBackgroundDefaut = new Color(251,252, 255);
	final Color couleurBackgroundServeur = new Color(50, 91, 152);
	
	final static int largeurFenetre = 530;
	final static int hauteurFenetre = 490;
	final static int hauteurPanelHaut = 40;
	private static final String nouveau = "Nouveau";
	private static final String charger = "Charger";
	private static final String enregistrer = "Enregistrer";
	private static final String quitter = "Quitter";
	
	//Fenetre globale
		private JFrame frame;
		private JMenuBar barreMenu;
		
		//Containers haut et bas
		private JPanel panelHaut;
		private JPanel panelBas;
		
		
		public ConfigGeneral(){
			
			super();
			
			//initialisation des modeles servant a construire les vues 'filtres' et 'intermediaires'
			
			
			initialierFenetre();
			initialiserBarreMenu();
			initialiserTheme();
			creationContainers();
		}


		private void creationContainers() {
			// TODO Auto-generated method stub
			
		}

		private void initialiserTheme() {
			try{ 
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
			}catch(Exception e){
				e.printStackTrace();	
			} 
			SwingUtilities.updateComponentTreeUI(frame);
		}


		private void initialiserBarreMenu() {
			barreMenu = new JMenuBar();
			
			//Menu 'Gestion'
			JMenu menu = new JMenu("Fichier");
			JMenuItem j = new JMenuItem(nouveau);
			JMenuItem j2 = new JMenuItem(charger);
			JMenuItem j3 = new JMenuItem(enregistrer);
			JMenuItem j4 = new JMenuItem(quitter);
			
			//action executee pour changer de menu
			class MenuActionListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					 String s = e.getActionCommand();
					 atteindrePage(s);
				}
			};
			
			j.addActionListener(new MenuActionListener());
			j2.addActionListener(new MenuActionListener());
			j3.addActionListener(new MenuActionListener());
			j4.addActionListener(new MenuActionListener());
			
			menu.add(j);
			menu.add(j2);
			menu.add(j3);
			menu.add(j4);
			

			//Menu 'Theme'
			JMenu menu2 = new JMenu("Theme");
			ButtonGroup bg = new ButtonGroup();
			Map<String,String> map = getLookAndFeels();
			
			//initialisation du choix des themes
			for(String clef : map.keySet()){
				final String classe = map.get(clef);
				boolean natif = classe.equals(UIManager.getSystemLookAndFeelClassName());
				
				JRadioButtonMenuItem item = new JRadioButtonMenuItem(clef,natif);
				item.addActionListener(new ActionListener(){ 
					public void actionPerformed(ActionEvent ae){ 
						try{ 
							UIManager.setLookAndFeel(classe); 
						}catch(Exception e){
							e.printStackTrace();	
						} 
						SwingUtilities.updateComponentTreeUI(frame); 
					} 
				}); 
				bg.add(item); 
				menu2.add(item);  	
			}
			
			barreMenu.add(menu);
			barreMenu.add(menu2);
			frame.setJMenuBar(barreMenu);
			
		}


		private void initialierFenetre() {
			frame = new JFrame("Assignement");
			frame.setTitle("Configuration générale");
			frame.setSize(largeurFenetre, hauteurFenetre);
			frame.setLayout(new BorderLayout());
			frame.setLocation(750, 100);
			
			//methode de fermeture de la fenetre
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					fermer();
				}
			});
			
		}
		
		private void fermer() {
			int reponse = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter l'application?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (reponse == JOptionPane.YES_OPTION){
				System.exit(0);
			}
			
		}
		
		/**
		 * Permet d'atteindre la page selon le String en parametre (pageCommande...).
		 * @param s
		 * 		La page a atteindre
		 */
		public void atteindrePage(String s){
			 CardLayout cl = (CardLayout)(panelBas.getLayout());
			 cl.show(panelBas, s);
		}
		
		/**
		 * Affiche la fenetre.
		 */
		public void afficher() {
			frame.setVisible(true);
			//atteindrePage(pageCommande);
		}
		
		private Map<String,String> getLookAndFeels(){
			UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
			Map<String,String> map = new TreeMap<String,String>();
			for(int i=0; i<info.length;i++){
				String nomLF = info[i].getName();
				String nomClasse = info[i].getClassName();
				map.put(nomLF,nomClasse); 	
			}
			return map;	
		}
	
		
		public void display() {
			setVisible(true);        
		}
	
}
