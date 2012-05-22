package view;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GeneralConfiguration {
	
	
	final static int LenghtWindow = 530;
	final static int HightWindow = 490;
	
	
	// about the window
	private JFrame frame;
	private JMenuBar barreMenu;
	//private JPanel container;
	private JPanel panelHigh;
	private JPanel panelLow;
	
	private JLabel time = new JLabel("Global time : ");
	private JComboBox combo = new JComboBox();
	
	private JLabel algo = new JLabel("Algorithm : ");
	private JComboBox combo1 = new JComboBox();
	
	private JLabel time2 = new JLabel("Global time of commutation : ");
	private JComboBox combo2 = new JComboBox();
	
	private JLabel number = new JLabel(" The number of processus : ");
	//private JComboBox combo2 = new JComboBox();
	private JCheckBox one = new JCheckBox("1");
	private JCheckBox two = new JCheckBox("2");
	private JCheckBox three = new JCheckBox("3");
	private JCheckBox four = new JCheckBox("4");
	private JCheckBox five = new JCheckBox("5");
	private JCheckBox six = new JCheckBox("6");
	private JCheckBox seven = new JCheckBox("7");
	private JCheckBox eight = new JCheckBox("8");
	private JCheckBox nine = new JCheckBox("9");
	private JCheckBox ten = new JCheckBox("10");

	
	private JButton button = new JButton("Valid");
	
public GeneralConfiguration(){

		CreateWindow();
		initializeTheme();
		initializeMenuBarre();
	    createContainers();
	}


/**
 * Initialise les deux principaux containers de la fenêtre : panels haut et bas.
 */

public void createContainers(){
	
	//initialisation du panel 'bas'
	panelLow = new JPanel(new CardLayout());
	panelLow.setBorder(new EmptyBorder(10, 0, 0, 0));
	//panelLow.add(button);
	
	
	//initialisation du panel 'haut'
	panelHigh = new JPanel();
	panelHigh.setPreferredSize(new Dimension(LenghtWindow, HightWindow) );
	
	panelHigh.add(time);
	combo.addItem("100 ms");
	combo.addItem("150 ms");
	combo.addItem("200 ms");
	combo.addItem("250 ms");
	combo.addItem("300 ms");
	panelHigh.add(combo);
	
	panelHigh.add(algo);
	combo1.addItem("FIFO");
	combo1.addItem("Short job first");
	combo1.addItem("Finish first");
	combo1.addItem("Tourniquet");
	combo1.addItem("Tourniquet with priority");
	panelHigh.add(combo1);
	
	panelHigh.add(time2);
	combo2.addItem("0 ms");
	combo2.addItem("10 ms");
	combo2.addItem("15 ms");
	combo2.addItem("20 ms");
	combo2.addItem("25 ms");
	combo2.addItem("30 ms");
	panelHigh.add(combo2);
	
	panelHigh.add(number);
	panelHigh.add(one);
	panelHigh.add(two);
	panelHigh.add(three);
	panelHigh.add(four);
	panelHigh.add(five);
	panelHigh.add(six);
	panelHigh.add(seven);
	panelHigh.add(eight);
	panelHigh.add(nine);
	panelHigh.add(ten);
	
    button.setForeground(Color.RED);
    panelHigh.add(button);
	
	frame.add(panelLow, BorderLayout.CENTER);
	frame.add(panelHigh, BorderLayout.NORTH);
}




	/**
	 * Create a window.
	 */
	
public void CreateWindow(){
	//container = new JPanel(new BorderLayout());
	//container.add(panelHigh, BorderLayout.NORTH);
	//container.add(panelLow, BorderLayout.CENTER);
	frame = new JFrame("General Configuration");
	frame.setSize(LenghtWindow, HightWindow);
	frame.setLayout(new BorderLayout());
	frame.setLocation(200, 100);
	//frame.add(time);
	//frame.add(button);
	//frame.add(container);
	/*frame.add(container);*/
	
	
	/*add(bouton);*/
	
	frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			close();
		}
	});
}

/**
 * get the LookAndFeels available in the system.
 * @return the LookAndFeels available.
 */
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


/**
 * initialize the theme of the windows.
 */
private void initializeTheme(){
	try{ 
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	}catch(Exception e){
		e.printStackTrace();	
	} 
	SwingUtilities.updateComponentTreeUI(frame);
}


/**
 * Initialize the menu
 */
public void initializeMenuBarre(){
	barreMenu = new JMenuBar();
	
	//'FILE' menu
	JMenu menu = new JMenu("File");
	JMenuItem j = new JMenuItem("New");
	JMenuItem j2 = new JMenuItem("Upload");
	JMenuItem j3 = new JMenuItem("Save");
	JMenuItem j4 = new JMenuItem("Exit");
	//JMenuItem j4 = new JMenuItem(pageTable);
	
	//'DISPLAY' menu
	JMenu menu1 = new JMenu("Display");
	JMenuItem j5 = new JMenuItem("Gantt");
	JMenuItem j6 = new JMenuItem("Statistic");
	JMenuItem j7 = new JMenuItem("Evenement");
	
	//'?' menu
	JMenu menu3 = new JMenu("?");
	JMenuItem j8 = new JMenuItem("Help");
	JMenuItem j9 = new JMenuItem("About");

	
	
	//executed action which allowed us to modify the menu
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			 String s = e.getActionCommand();
			// atteindrePage(s);
		}
	};
	
	j.addActionListener(new MenuActionListener());
	j2.addActionListener(new MenuActionListener());
	j3.addActionListener(new MenuActionListener());
	j4.addActionListener(new MenuActionListener());
	j5.addActionListener(new MenuActionListener());
	j6.addActionListener(new MenuActionListener());
	j7.addActionListener(new MenuActionListener());
	j8.addActionListener(new MenuActionListener());
	j9.addActionListener(new MenuActionListener());
	
	
	menu.add(j);
	menu.add(j2);
	menu.add(j3);
	menu.add(j4);
	menu1.add(j5);
	menu1.add(j6);
	menu1.add(j7);
	menu3.add(j8);
	menu3.add(j9);

	

	//'Theme' menu
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
	barreMenu.add(menu1);
	barreMenu.add(menu2);
	barreMenu.add(menu3);
	frame.setJMenuBar(barreMenu);
}



/*public void atteindrePage(String s){
	 CardLayout cl = (CardLayout)(panelLow.getLayout());
	 cl.show(panelLow, s);
}
*/
/**
 * Close the view.
 */
public void close() {
	int reponse = JOptionPane.showConfirmDialog(frame, "Do you want to exit ?", "Confirmation", JOptionPane.YES_NO_OPTION);
	if (reponse == JOptionPane.YES_OPTION){
		frame.dispose();
	}
}

public void display() {
	frame.setVisible(true);
}


	


}